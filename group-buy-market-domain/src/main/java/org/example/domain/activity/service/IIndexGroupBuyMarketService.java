package org.example.domain.activity.service;


import org.example.domain.activity.model.entity.MarketProductEntity;
import org.example.domain.activity.model.entity.TrialBalanceEntity;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 首页营销服务接口
 * @create 2024-12-14 13:39
 */
public interface IIndexGroupBuyMarketService {

    TrialBalanceEntity indexMarketTrial(MarketProductEntity marketProductEntity) throws Exception;

}
