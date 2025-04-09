package org.example.domain.trade.service;


import org.example.domain.trade.model.entity.TradePaySettlementEntity;
import org.example.domain.trade.model.entity.TradePaySuccessEntity;

import java.util.Map;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 拼团交易结算服务接口
 * @create 2025-01-26 14:34
 */
public interface ITradeSettlementOrderService {

    /**
     * 营销结算
     * @param tradePaySuccessEntity 交易支付订单实体对象
     * @return 交易结算订单实体
     */
    TradePaySettlementEntity settlementMarketPayOrder(TradePaySuccessEntity tradePaySuccessEntity)throws Exception;
    Map<String, Integer> execSettlementNotifyJob() throws Exception;

    /**
     * 执行结算通知任务
     *
     * @param teamId 指定结算组ID
     * @return 结算数量
     * @throws Exception 异常
     */
    Map<String, Integer> execSettlementNotifyJob(String teamId) throws Exception;

}
