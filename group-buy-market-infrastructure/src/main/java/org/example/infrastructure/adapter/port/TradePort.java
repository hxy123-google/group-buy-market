package org.example.infrastructure.adapter.port;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.example.domain.trade.adapter.port.ITradePort;
import org.example.domain.trade.model.entity.NotifyTaskEntity;
import org.example.infrastructure.gateway.GroupBuyNotifyService;
import org.example.infrastructure.redis.IRedisService;
import org.example.types.enums.NotifyTaskHTTPEnumVO;
import org.redisson.api.RLock;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description
 * @create 2025-01-31 13:34
 */
@Service
@Slf4j
public class TradePort implements ITradePort {

    @Resource
    private GroupBuyNotifyService groupBuyNotifyService;
    @Resource
    private IRedisService redisService;

    @Override
    public String groupBuyNotify(NotifyTaskEntity notifyTask) throws Exception {
        RLock lock = redisService.getLock(notifyTask.lockKey());
        try {
            // group-buy-market 拼团服务端会被部署到多台应用服务器上，那么就会有很多任务一起执行。这个时候要进行抢占，避免被多次执行
            if (lock.tryLock(3, 0, TimeUnit.SECONDS)) {
                try {
                    log.info("url :{}",notifyTask.getNotifyUrl());
                    // 无效的 notifyUrl 则直接返回成功
                    if (StringUtils.isBlank(notifyTask.getNotifyUrl()) || "暂无".equals(notifyTask.getNotifyUrl())) {
                        log.info("url无效");
                        return NotifyTaskHTTPEnumVO.SUCCESS.getCode();
                    }
                    log.info("进入正常groupBuyNotifyService");
                    return groupBuyNotifyService.groupBuyNotify(notifyTask.getNotifyUrl(), notifyTask.getParameterJson());
                } finally {
                    if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                        lock.unlock();
                    }
                }
            }
            log.info("不正常");
            return NotifyTaskHTTPEnumVO.NULL.getCode();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            return NotifyTaskHTTPEnumVO.NULL.getCode();
        }
    }

}
