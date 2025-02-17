package org.example.domain.activity.service.discount.impl;


import lombok.extern.slf4j.Slf4j;
import org.example.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import org.example.domain.activity.service.discount.AbstractDiscountCalculateService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 折扣优惠计算
 * @create 2024-12-22 12:12
 */
@Slf4j
@Service("ZK")
public class ZKCalculateService extends AbstractDiscountCalculateService {

    @Override
    public BigDecimal doCalculate(BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount) {
        log.info("优惠策略折扣计算:{}", groupBuyDiscount.getDiscountType().getCode());

        // 折扣表达式 - 折扣百分比
        String marketExpr = groupBuyDiscount.getMarketExpr();

        // 折扣价格
        BigDecimal deductionPrice = originalPrice.multiply(new BigDecimal(marketExpr));

        // 判断折扣后金额，最低支付1分钱
        if (deductionPrice.compareTo(BigDecimal.ZERO) <= 0) {
            return new BigDecimal("0.01");
        }

        return deductionPrice;
    }

}
