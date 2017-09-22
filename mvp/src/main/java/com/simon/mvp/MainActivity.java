package com.simon.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.simon.mvp.base.MvpBaseActivity;
import com.simon.mvp.callback.IContributorView;
import com.simon.mvp.custom.ProcessDialog;
import com.simon.mvp.modul.Contributor;
import com.simon.mvp.presenter.ContributorPresenter;
import com.simon.rameworkdemo.mvp.R;


/**
 * mvp模式，通过presenter将module和view层隔离开，activity和xml一起充当view层。
 * mvp模式也有一些问题：
 * 1.presenter过于厚，而且当页面过于负逻辑很多的时候，接口太多不好维护
 * 2.presenter会持有activity的引用导致内存泄漏
 *
 * 优化：
 * 1.可以通过弱引用来避免内存泄漏
 * 2.通过设计一些公共的接口来避免接口过多
 * 参考：https://github.com/sockeqwe/mosby
 *
 */

public class MainActivity extends MvpBaseActivity<IContributorView,ContributorPresenter> implements IContributorView{
    private ProcessDialog dialog;
    private TextView topContributor;
    private Contributor contributor = new Contributor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topContributor = (TextView)findViewById(R.id.top_contributor);
    }

    @Override
    public ContributorPresenter createPresenter() {
        return new ContributorPresenter();
    }

    public void get(View view){
        getPresenter().getContributorData();
    }

    public void change(View view){
        contributor.login = "zjutkz";
        topContributor.setText(contributor.login);
    }

    @Override
    public void showProgress(){
        if(dialog == null){
            dialog = new ProcessDialog(this);
        }
        dialog.showMessage("正在加载...");
    }

    @Override
    public void dismissProgress(){
        if(dialog == null){
            dialog = new ProcessDialog(this);
        }
        dialog.dismiss();
    }

    @Override
    public void setResponseString(String content) {
        topContributor.setText(content);
    }

}
