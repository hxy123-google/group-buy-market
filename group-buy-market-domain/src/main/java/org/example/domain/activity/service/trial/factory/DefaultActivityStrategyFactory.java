package org.example.domain.activity.service.trial.factory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.domain.activity.model.entity.MarketProductEntity;
import org.example.domain.activity.model.entity.TrialBalanceEntity;
import org.example.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import org.example.domain.activity.model.valobj.SkuVO;
import org.example.domain.activity.service.trial.node.RootNode;
import org.example.types.design.framework.tree.StrategyHandler;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * ClassName: DefaultActivityStrategyFactory
 * Package: org.example.domain.activity.service.trial.factory
 * Description:
 *
 * @Author Hxy
 * @Create 2025/2/8 18:51
 * @Version 1.0
 */
@Service
public class DefaultActivityStrategyFactory {
    private final RootNode rootNode;

    public DefaultActivityStrategyFactory(RootNode rootNode) {
        this.rootNode = rootNode;
    }

    public StrategyHandler<MarketProductEntity, DynamicContext, TrialBalanceEntity> strategyHandler() {
        return rootNode;
    }
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DynamicContext {
        // 拼团活动营销配置值对象
        private GroupBuyActivityDiscountVO groupBuyActivityDiscountVO;
        // 商品信息
        private SkuVO skuVO;
        // 折扣价格
        private BigDecimal deductionPrice;
        //支付金额
        private BigDecimal payPrice;
        // 活动可见性限制
        private boolean visible;
        // 活动
        private boolean enable;
    }
}
