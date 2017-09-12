package com.simon.mvpdatabinding.callback;

import com.simon.mvpdatabinding.modul.Contributor;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */

public interface IContributorView {

    void showProgress();

    void dismissProgress();

    void setResponseString(Contributor contributor);
}
