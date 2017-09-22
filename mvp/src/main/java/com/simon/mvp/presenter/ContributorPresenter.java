package com.simon.mvp.presenter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.simon.mvp.base.MvpBasePresenter;
import com.simon.mvp.callback.IContributorView;
import com.simon.mvp.http.RequestCenter;
import com.simon.mvp.modul.Contributor;
import com.simon.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Request;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */
public class ContributorPresenter extends MvpBasePresenter<IContributorView> {

    public ContributorPresenter(){
    }

    public void getContributorData(){
        RequestCenter.requestCountributor(new StringCallback() {
            @Override
            public void onBefore(Request request, int id) {
                if(isViewAttached()){
                    getView().showProgress();
                }
            }

            @Override
            public void onResponse(String response, int id) {
                getView().dismissProgress();
                //显示数据
                List<Contributor> contributors = new Gson().fromJson(response, new TypeToken<List<Contributor>>() {}.getType());
                Contributor contributor = contributors.get(0);
                if(isViewAttached()){
                  getView().setResponseString(contributor.login);
                }
            }

            @Override
            public void onError(okhttp3.Call call, Exception e, int id) {
                if(isViewAttached()){
                  getView().dismissProgress();
                }
            }

        });
    }
}
