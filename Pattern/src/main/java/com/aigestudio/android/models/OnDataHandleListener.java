package com.aigestudio.android.models;

/**
 * 数据处理监听器
 *
 * @author AigeStudio
 * @since 2016-03-27
 */
public interface OnDataHandleListener<T> {
    /**
     * 数据处理完毕后调用
     *
     * @param t ...
     */
    void onDataHandled(T t);
}