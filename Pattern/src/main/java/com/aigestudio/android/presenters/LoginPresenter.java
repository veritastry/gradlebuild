package com.aigestudio.android.presenters;

import com.aigestudio.android.models.User;
import com.aigestudio.android.models.UserBizImpl;
import com.aigestudio.android.views.ILoginView;
import com.aigestudio.android.models.IUserBiz;
import com.aigestudio.android.models.OnDataHandleListener;

/**
 * Presenter
 * 登录界面业务中间处理者
 *
 * @author AigeStudio
 * @since 2016-03-27
 */
public class LoginPresenter {
    private ILoginView mLoginView;
    private IUserBiz mUserBiz;

    public LoginPresenter(ILoginView loginView) {
        mLoginView = loginView;
        mUserBiz = new UserBizImpl();
    }

    /**
     * 执行登录操作
     *
     * @param username ...
     * @param password ...
     */
    public void doLogin(final String username, final String password) {
        // 先把进度对话框显示出来
        mLoginView.switchProgressDialog(true);

        // 数据校验
        mUserBiz.queryUser(new OnDataHandleListener<User>() {
            @Override
            public void onDataHandled(User user) {
                // 拿到数据不管成功与否都把进度对话框隐藏掉
                mLoginView.switchProgressDialog(false);

                // 如果成功则更新数据否则提示失败
                if (user.username.equals(username) && user.password.equals(password)) {
                    mLoginView.toastMessage(true);
                    user.timeUpdate = System.currentTimeMillis();
                    mUserBiz.updateUser(user, null);
                } else {
                    mLoginView.toastMessage(false);
                }
            }
        });
    }
}