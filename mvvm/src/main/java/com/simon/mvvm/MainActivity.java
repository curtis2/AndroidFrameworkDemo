package com.simon.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.simon.mvvm.custom.ProcessDialog;
import com.simon.mvvm.http.RequestCenter;
import com.simon.mvvm.modul.Contributor;
import com.simon.okhttp.callback.StringCallback;
import com.simon.rameworkdemo.mvvm.R;
import com.simon.rameworkdemo.mvvm.databinding.ActivityMainBinding;

import java.util.List;

import okhttp3.Request;


/**
 * mvvm模式：暂时没看出他的优势在哪里
 * 缺点： 目前的databing能做的有限，所以会导致activity处理很多逻辑和view操作，所以activity会变的很厚
 *
 */
public class MainActivity extends AppCompatActivity  {
    private ProcessDialog dialog;
    private Contributor contributor = new Contributor();
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
    }

    public void get(View view){
        RequestCenter.requestCountributor(new StringCallback() {
            @Override
            public void onBefore(Request request, int id) {
                showProgress();
            }

            @Override
            public void onResponse(String response, int id) {
                dismissProgress();
                //显示数据
                List<Contributor> contributors = new Gson().fromJson(response, new TypeToken<List<Contributor>>() {}.getType());
                Contributor contributor = contributors.get(0);
                binding.setContributor(contributor);
            }

            @Override
            public void onError(okhttp3.Call call, Exception e, int id) {
                dismissProgress();
            }
        });
    }

    public void change(View view){
        if(binding.getContributor()!=null){
            contributor.login = "zjutkz";
            binding.setContributor(contributor);
        }

    }

    public void showProgress(){
        if(dialog == null){
            dialog = new ProcessDialog(this);
        }
        dialog.showMessage("正在加载...");
    }

    public void dismissProgress(){
        if(dialog == null){
            dialog = new ProcessDialog(this);
        }
        dialog.dismiss();
    }

}
