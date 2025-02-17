package org.example.types.design.framework.tree;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * ClassName: AbstractMultiThreadStrategyRouter
 * Package: org.example.types.design.framework.tree
 * Description:
 *
 * @Author Hxy
 * @Create 2025/2/9 9:34
 * @Version 1.0
 */
public abstract class AbstractMultiThreadStrategyRouter<T,D,R>implements StrategyHandler<T,D,R>,StrategyMapper<T,D,R>{
    @Getter
    @Setter
    protected StrategyHandler<T, D, R> defaultStrategyHandler = StrategyHandler.DEFAULT;

    public R router(T requestParameter, D dynamicContext) throws Exception {
        StrategyHandler<T, D, R> strategyHandler = get(requestParameter, dynamicContext);
        if(null != strategyHandler) return strategyHandler.apply(requestParameter, dynamicContext);
        return defaultStrategyHandler.apply(requestParameter, dynamicContext);
    }
    @Override
    public R apply(T requestParameter, D dynamicContext) throws Exception {
        // 异步加载数据
        multiThread(requestParameter, dynamicContext);
        // 业务流程受理
        return doApply(requestParameter, dynamicContext);
    }
    public abstract void multiThread(T requestParameter, D dynamicContext)  throws ExecutionException, InterruptedException, TimeoutException;;
    public abstract R doApply(T requestParameter, D dynamicContext)  throws Exception;
}
