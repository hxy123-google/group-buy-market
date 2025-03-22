package org.example.domain.trade.service.factory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.trade.model.entity.GroupBuyActivityEntity;
import org.example.domain.trade.model.entity.TradeRuleCommandEntity;
import org.example.domain.trade.model.entity.TradeRuleFilterBackEntity;
import org.example.domain.trade.service.filter.ActivityUsabilityRuleFilter;
import org.example.domain.trade.service.filter.UserTakeLimitRuleFilter;
import org.example.types.design.framework.link.model2.LinkArmory;
import org.example.types.design.framework.link.model2.chain.BusinessLinkedList;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ClassName: TradeRuleFilterFactory
 * Package: org.example.domain.trade.service.factory
 * Description:
 *
 * @Author Hxy
 * @Create 2025/3/22 15:40
 * @Version 1.0
 */
@Slf4j
@Service
public class TradeRuleFilterFactory {
    @Bean("tradeRuleFilter")
    public BusinessLinkedList<TradeRuleCommandEntity,TradeRuleFilterFactory.DynamicContext, TradeRuleFilterBackEntity> tradeRuleFilter(ActivityUsabilityRuleFilter activityUsabilityRuleFilter, UserTakeLimitRuleFilter userTakeLimitRuleFilter) {
        LinkArmory<TradeRuleCommandEntity, DynamicContext, TradeRuleFilterBackEntity> linkArmory =
                new LinkArmory<>("交易规则过滤链", activityUsabilityRuleFilter, userTakeLimitRuleFilter);

        // 链对象
        return linkArmory.getLogicLink();

    }
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DynamicContext {

        private GroupBuyActivityEntity groupBuyActivity;

    }
}
