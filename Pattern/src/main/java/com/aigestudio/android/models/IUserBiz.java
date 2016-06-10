package com.aigestudio.android.models;

/**
 * Model
 * 登录界面模型层用户实体业务接口
 *
 * @author AigeStudio
 * @since 2016-03-27
 */
public interface IUserBiz {
    /**
     * 查询用户数据
     *
     * @param listener ...
     */
    void queryUser(OnDataHandleListener<User> listener);

    /**
     * 更新用户数据
     *
     * @param user     ...
     * @param listener ...
     */
    void updateUser(User user, OnDataHandleListener<User> listener);
}