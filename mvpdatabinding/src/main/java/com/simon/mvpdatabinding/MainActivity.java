package com.simon.mvpdatabinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.simon.mvpdatabinding.callback.IContributorView;
import com.simon.mvpdatabinding.custom.ProcessDialog;
import com.simon.mvpdatabinding.modul.Contributor;
import com.simon.mvpdatabinding.presenter.ContributorPresenter;
import com.simon.rameworkdemo.mvpdatabinding.R;
import com.simon.rameworkdemo.mvpdatabinding.databinding.ActivityMainBinding;


/**
 *最佳实践：通过databing+mvp模式，通过databing简化activity中的view操作，通过presenter分担原来activity的逻辑处理
 */
public class MainActivity extends AppCompatActivity implements IContributorView {
    private ProcessDialog dialog;
    private Contributor contributor = new Contributor();
     ActivityMainBinding binding;
     ContributorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=new ContributorPresenter(this);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    public void get(View view){
       presenter.getContributorData();
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

    @Override
    public void setResponseString(Contributor contributor) {
        binding.setContributor(contributor);
    }

}
