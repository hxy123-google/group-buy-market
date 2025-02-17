package org.example.domain.activity.service.trial;


import org.example.domain.activity.adapter.repository.IActivityRepository;
import org.example.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import org.example.types.design.framework.tree.AbstractMultiThreadStrategyRouter;
import org.example.types.design.framework.tree.AbstractStrategyRouter;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 抽象的拼团营销支撑类
 * @create 2024-12-14 13:42
 */
public abstract class AbstractGroupBuyMarketSupport<MarketProductEntity,DynamicContext, TrialBalanceEntity> extends AbstractMultiThreadStrategyRouter<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {
    protected long timeout = 500;
    @Resource
    protected IActivityRepository repository;
    @Override
    public void multiThread(MarketProductEntity requestParameter,DefaultActivityStrategyFactory.DynamicContext dynamicContext)  throws ExecutionException, InterruptedException, TimeoutException{

    };




}
