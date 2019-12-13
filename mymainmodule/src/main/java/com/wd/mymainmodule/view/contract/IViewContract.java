package com.wd.mymainmodule.view.contract;

import com.bwie.mvplibrary.base.BasePresenter;
import com.wd.mymainmodule.view.IBasesView;

import java.util.Map;

/**
 * date:2019/12/13
 * author:贺少伟(盗)
 * function: 契约类
 */
public interface IViewContract {
    interface doView extends IBasesView{}

    abstract class doData extends BasePresenter{
//   登录
        public abstract void doRegister(Map<String,String> map);
    }
}
