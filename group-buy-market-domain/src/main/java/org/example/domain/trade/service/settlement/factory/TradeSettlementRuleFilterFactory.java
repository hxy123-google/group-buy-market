package org.example.domain.trade.service.settlement.factory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.trade.model.entity.*;
import org.example.domain.trade.service.lock.factory.TradeRuleFilterFactory;
import org.example.domain.trade.service.lock.filter.ActivityUsabilityRuleFilter;
import org.example.domain.trade.service.lock.filter.UserTakeLimitRuleFilter;
import org.example.domain.trade.service.settlement.filter.EndRuleFilter;
import org.example.domain.trade.service.settlement.filter.OutTradeNoRuleFilter;
import org.example.domain.trade.service.settlement.filter.SCRuleFilter;
import org.example.domain.trade.service.settlement.filter.SettableRuleFilter;
import org.example.types.design.framework.link.model2.LinkArmory;
import org.example.types.design.framework.link.model2.chain.BusinessLinkedList;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * ClassName: TradeSettlementRuleFilterFactory
 * Package: org.example.domain.trade.service.settlement.factory
 * Description:
 *
 * @Author Hxy
 * @Create 2025/3/24 9:22
 * @Version 1.0
 */
@Slf4j
@Service
public class TradeSettlementRuleFilterFactory {
    @Bean("tradeSettlementRuleFilter")
    public BusinessLinkedList<TradeSettlementRuleCommandEntity,
            TradeSettlementRuleFilterFactory.DynamicContext, TradeSettlementRuleFilterBackEntity> tradeSettlementRuleFilter(
            SCRuleFilter scRuleFilter,
            OutTradeNoRuleFilter outTradeNoRuleFilter,
            SettableRuleFilter settableRuleFilter,
            EndRuleFilter endRuleFilter) {

        // 组装链
        LinkArmory<TradeSettlementRuleCommandEntity, TradeSettlementRuleFilterFactory.DynamicContext, TradeSettlementRuleFilterBackEntity> linkArmory =
                new LinkArmory<>("交易结算规则过滤链", scRuleFilter, outTradeNoRuleFilter, settableRuleFilter, endRuleFilter);

        // 链对象
        return linkArmory.getLogicLink();
    }
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DynamicContext {

        // 订单营销实体对象
        private MarketPayOrderEntity marketPayOrderEntity;
        // 拼团组队实体对象
        private GroupBuyTeamEntity groupBuyTeamEntity;

    }
}
