package org.example.domain.trade.service;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.trade.model.aggregate.GroupBuyOrderAggregate;
import org.example.domain.trade.model.entity.MarketPayOrderEntity;
import org.example.domain.trade.model.entity.PayActivityEntity;
import org.example.domain.trade.model.entity.PayDiscountEntity;
import org.example.domain.trade.model.entity.UserEntity;
import org.example.domain.trade.model.valobj.GroupBuyProgressVO;
import org.example.domain.trade.repository.ITradeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ClassName: TradeOrderService
 * Package: org.example.domain.trade.service
 * Description:
 *
 * @Author Hxy
 * @Create 2025/3/16 19:51
 * @Version 1.0
 */
@Slf4j
@Service
public class TradeOrderService implements ITradeOrderService{
    @Resource
    private ITradeRepository repository;
    @Override
    public MarketPayOrderEntity queryNoPayMarketPayOrderByOutTradeNo(String userId, String outTradeNo){
        log.info("拼团交易-查询未支付营销订单:{} outTradeNo:{}", userId, outTradeNo);
        return repository.queryMarketPayOrderEntityByOutTradeNo(userId, outTradeNo);
    }
    @Override
    public GroupBuyProgressVO queryGroupBuyProgress(String teamId) {
        log.info("拼团交易-查询拼单进度:{}", teamId);
        return repository.queryGroupBuyProgress(teamId);
    }

    @Override
    public MarketPayOrderEntity lockMarketPayOrder(UserEntity userEntity, PayActivityEntity payActivityEntity, PayDiscountEntity payDiscountEntity) {
        log.info("拼团交易-锁定营销优惠支付订单:{} activityId:{} goodsId:{}", userEntity.getUserId(), payActivityEntity.getActivityId(), payDiscountEntity.getGoodsId());

        // 构建聚合对象
        GroupBuyOrderAggregate groupBuyOrderAggregate = GroupBuyOrderAggregate.builder()
                .userEntity(userEntity)
                .payActivityEntity(payActivityEntity)
                .payDiscountEntity(payDiscountEntity)
                .build();

        // 锁定聚合订单 - 这会用户只是下单还没有支付。后续会有2个流程；支付成功、超时未支付（回退）
        return repository.lockMarketPayOrder(groupBuyOrderAggregate);
    }

}
