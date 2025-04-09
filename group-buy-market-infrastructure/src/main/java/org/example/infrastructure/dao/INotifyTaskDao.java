package org.example.infrastructure.dao;


import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.dao.po.NotifyTask;

import java.util.List;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 回调任务
 * @create 2025-01-26 18:23
 */
@Mapper
public interface INotifyTaskDao {

    void insert(NotifyTask notifyTask);

    NotifyTask queryUnExecutedNotifyTaskByTeamId(String teamId);

    int updateNotifyTaskStatusSuccess(String teamId);

    int updateNotifyTaskStatusError(String teamId);

    int updateNotifyTaskStatusRetry(String teamId);

    List<NotifyTask> queryUnExecutedNotifyTaskList();
}
