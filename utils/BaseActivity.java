package com.zengyu.androidwidgets;

import android.app.Activity;

/**
 * Created on 2019-08-29
 *
 * @author Zengyu.Zhan
 */
public abstract class BaseActivity extends Activity {
    /**
     * 从 Intent 获取传递过来的一些参数，设置到属性中
     */
    protected abstract void getIntents();

    /**
     * 通过 findViewById 来初始化各个组件
     */
    protected abstract void findViewById();

    /**
     * 给组件设置监听或者初始状态
     */
    protected abstract void setViews();

    /**
     * 模板方法
     */
    final public void init() {
        if (isGetIntents()) {
            getIntents();
        }
        findViewById();
        setViews();
    }

    /**
     * 钩子方法，是否需要设置数据，默认为 true
     * @return
     */
    protected boolean isGetIntents() {
        return true;
    }
}
