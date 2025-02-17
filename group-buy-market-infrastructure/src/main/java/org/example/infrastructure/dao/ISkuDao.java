package org.example.infrastructure.dao;


import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.dao.po.Sku;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 商品查询
 * @create 2024-12-21 10:48
 */
@Mapper
public interface ISkuDao {

    Sku querySkuByGoodsId(String goodsId);

}
