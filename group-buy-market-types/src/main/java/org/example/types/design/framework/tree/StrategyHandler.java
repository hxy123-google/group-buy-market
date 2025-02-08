package org.example.types.design.framework.tree;

/**
 * ClassName: StrategyHandler
 * Package: org.example.types.design.framework.tree
 * Description:
 *
 * @Author Hxy
 * @Create 2025/2/8 17:03
 * @Version 1.0
 */
public interface StrategyHandler<T, D, R> {
    StrategyHandler DEFAULT = (T, D) -> null;
    R apply(T requestParameter,D dynamicContext) throws Exception;
}
