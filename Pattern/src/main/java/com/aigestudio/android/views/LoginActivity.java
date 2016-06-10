package com.aigestudio.android.views;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aigestudio.android.R;
import com.aigestudio.android.presenters.LoginPresenter;

/**
 * View
 * 登录界面视图层实现类
 *
 * @author AigeStudio
 * @since 2016-03-27
 */
public class LoginActivity extends Activity implements ILoginView {
    private ProgressDialog mProgressDialog;// 进度对话框

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_login);

        // 构造一个LoginPresenter对象来处理我们的业务逻辑
        // 这里在Android中一般情况下都是需要将View作为入参进行构造 原因嘛很简单我们new不来Activity
        final LoginPresenter loginPresenter = new LoginPresenter(this);

        // 获取文本框控件
        final EditText etUsername = (EditText) findViewById(R.id.login_username_et);
        final EditText etPassword = (EditText) findViewById(R.id.login_password_et);

        // 获取按钮控件并设置点击事件监听
        Button btnLogin = (Button) findViewById(R.id.login_btn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击事件中View的主要职责就是拿到文本框的数据传递给Presenter处理
                loginPresenter.doLogin(
                        etUsername.getText().toString(),
                        etPassword.getText().toString()
                );
            }
        });
        mProgressDialog = new ProgressDialog(this);
    }

    @Override
    public void switchProgressDialog(boolean isDialogShow) {
        if (isDialogShow)
            mProgressDialog.show();
        else
            mProgressDialog.dismiss();
    }

    @Override
    public void toastMessage(final boolean isSuccess) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this,
                        isSuccess ? "Login success!" : "Login failed!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}