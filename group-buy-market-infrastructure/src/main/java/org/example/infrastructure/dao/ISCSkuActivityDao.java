package org.example.infrastructure.dao;


import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.dao.po.SCSkuActivity;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 渠道商品活动配置关联表Dao
 * @create 2025-01-01 09:30
 */
@Mapper
public interface ISCSkuActivityDao {

    SCSkuActivity querySCSkuActivityBySCGoodsId(SCSkuActivity scSkuActivity);

}
