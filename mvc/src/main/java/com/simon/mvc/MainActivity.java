package com.simon.mvc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.simon.mvc.custom.ProcessDialog;
import com.simon.mvc.http.RequestCenter;
import com.simon.mvc.modul.Contributor;
import com.simon.mvp.R;
import com.simon.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;
import okhttp3.Request;

/**
 *  MVC 架构模式中，activity或者fragment充当了control的角色,xml作为view, 其他的网络处理或者数据方法作为modul层
 * 但是因为xml的能力有限，所以在activity会进行view的操作。
 * 这样导致两个缺点：
 *  1.activity过重，并且和view耦合
 *  2.view和model耦合
 *
 */


public class MainActivity extends AppCompatActivity {
    private ProcessDialog dialog;
    private Contributor contributor = new Contributor();
    private TextView topContributor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topContributor = (TextView)findViewById(R.id.top_contributor);
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
                topContributor.setText(contributor.login);
            }

            @Override
            public void onError(Call call, Exception e, int id) {
                dismissProgress();
            }
        });
    }

    public void change(View view){
        contributor.login = "zjutkz";
        topContributor.setText(contributor.login);
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
