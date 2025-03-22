package org.example.domain.trade.model.aggregate;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.domain.trade.model.entity.PayActivityEntity;
import org.example.domain.trade.model.entity.PayDiscountEntity;
import org.example.domain.trade.model.entity.UserEntity;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 拼团订单聚合对象；聚合可以理解用各个四肢、身体、头等组装出来一个人
 * @create 2025-01-11 10:07
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroupBuyOrderAggregate {

    /** 用户实体对象 */
    private UserEntity userEntity;
    /** 支付活动实体对象 */
    private PayActivityEntity payActivityEntity;
    /** 支付优惠实体对象 */
    private PayDiscountEntity payDiscountEntity;
    /** 已参与拼团量 */
    private Integer userTakeOrderCount;


}
