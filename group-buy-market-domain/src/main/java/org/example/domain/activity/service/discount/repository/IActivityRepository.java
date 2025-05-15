package org.example.domain.activity.service.discount.repository;

import org.example.domain.activity.model.entity.UserGroupBuyOrderDetailEntity;
import org.example.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import org.example.domain.activity.model.valobj.SCSkuActivityVO;
import org.example.domain.activity.model.valobj.SkuVO;
import org.example.domain.activity.model.valobj.TeamStatisticVO;

import java.util.List;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 活动仓储
 * @create 2024-12-21 10:06
 */
public interface IActivityRepository {

    GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(Long activityId);

    SkuVO querySkuByGoodsId(String goodsId);

    SCSkuActivityVO querySCSkuActivityBySCGoodsId(String source, String channel, String goodsId);
    boolean isTagCrowdRange(String tagId, String userId);

    boolean downgradeSwitch();

    boolean cutRange(String userId);
    List<UserGroupBuyOrderDetailEntity> queryInProgressUserGroupBuyOrderDetailListByOwner(Long activityId, String userId, Integer ownerCount);

    List<UserGroupBuyOrderDetailEntity> queryInProgressUserGroupBuyOrderDetailListByRandom(Long activityId, String userId, Integer randomCount);
    TeamStatisticVO queryTeamStatisticByActivityId(Long activityId);

}
