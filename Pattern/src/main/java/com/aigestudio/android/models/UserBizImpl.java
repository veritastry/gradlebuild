package com.aigestudio.android.models;

/**
 * Model
 * 登录界面模型层用户实体业务实现类
 *
 * @author AigeStudio
 * @since 2016-03-27
 */
public class UserBizImpl implements IUserBiz {
    @Override
    public void queryUser(final OnDataHandleListener<User> listener) {
        if (null == listener) return;

        // 模拟耗时操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                User user = new User();
                user.username = "admin";
                user.password = "admin";
                user.timeUpdate = System.currentTimeMillis();
                listener.onDataHandled(user);
            }
        }).start();
    }

    @Override
    public void updateUser(final User user, final OnDataHandleListener<User> listener) {
        // 模拟耗时操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (null != listener) listener.onDataHandled(user);
            }
        }).start();
    }
}