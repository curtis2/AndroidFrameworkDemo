package com.simon.mvp.callback;

import com.simon.mvp.base.MvpView;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */

public interface IContributorView  extends MvpView{

    void showProgress();

    void dismissProgress();

    void setResponseString(String content);
}
