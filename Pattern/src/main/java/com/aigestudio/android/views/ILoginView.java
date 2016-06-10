package com.aigestudio.android.views;

/**
 * View
 * 登录界面视图层接口
 *
 * @author AigeStudio
 * @since 2016-03-27
 */
public interface ILoginView {
    /**
     * 切换进度对话框显示隐藏
     *
     * @param isDialogShow ...
     */
    void switchProgressDialog(boolean isDialogShow);

    /**
     * 弹出文本信息提示
     *
     * @param isSuccess ...
     */
    void toastMessage(boolean isSuccess);
}