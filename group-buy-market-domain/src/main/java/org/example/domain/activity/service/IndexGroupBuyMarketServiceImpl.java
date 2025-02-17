package org.example.domain.activity.service;

import org.example.domain.activity.model.entity.MarketProductEntity;
import org.example.domain.activity.model.entity.TrialBalanceEntity;
import org.example.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import org.example.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import org.example.types.design.framework.tree.StrategyHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ClassName: IndexGroupBuyMarketServiceImpl
 * Package: org.example.domain.activity.service
 * Description:
 *
 * @Author Hxy
 * @Create 2025/2/8 19:33
 * @Version 1.0
 */
@Service
public class IndexGroupBuyMarketServiceImpl implements IIndexGroupBuyMarketService{
    @Resource
    private DefaultActivityStrategyFactory defaultActivityStrategyFactory;
    @Override
    public TrialBalanceEntity indexMarketTrial(MarketProductEntity marketProductEntity) throws Exception{
        StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> strategyHandler = defaultActivityStrategyFactory.strategyHandler();
        TrialBalanceEntity trialBalanceEntity=strategyHandler.apply(marketProductEntity,new DefaultActivityStrategyFactory.DynamicContext());
        return  trialBalanceEntity;
    };
}
