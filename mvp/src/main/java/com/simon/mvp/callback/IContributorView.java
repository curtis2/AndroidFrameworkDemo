package com.simon.mvp.callback;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */

public interface IContributorView {

    void showProgress();

    void dismissProgress();

    void setResponseString(String content);
}
