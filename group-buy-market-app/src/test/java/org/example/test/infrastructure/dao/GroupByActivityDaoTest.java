package org.example.test.infrastructure.dao;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.example.infrastructure.dao.IGroupBuyActivityDao;
import org.example.infrastructure.dao.po.GroupBuyActivity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: GroupByActivityDaoTest
 * Package: org.example.test.infrastructure.dao
 * Description:
 *
 * @Author Hxy
 * @Create 2025/2/8 14:27
 * @Version 1.0
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupByActivityDaoTest {
    @Resource
    private IGroupBuyActivityDao groupBuyActivityDao;
    @Test
    public void test_queryGroupBuyActivityList() {
        List<GroupBuyActivity> groupBuyActivities = groupBuyActivityDao.queryGroupBuyActivityList();
        log.info("测试结果:{}", JSON.toJSONString(groupBuyActivities));
    }

}
