package com.simon.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */

public abstract class MvpBaseActivity<V extends MvpView,P extends MvpBasePresenter<V>>  extends AppCompatActivity implements MvpView{

    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter(createPresenter());
        getPresenter().attachView(getMvpView());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().detachView();
    }

    public abstract P createPresenter();

    public  P getPresenter(){
        return presenter;
    }

    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    public  V getMvpView(){
        return (V)this;
    }

}
