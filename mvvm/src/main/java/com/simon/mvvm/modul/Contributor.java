package com.simon.mvvm.modul;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.simon.rameworkdemo.mvvm.BR;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */
public class Contributor extends BaseObservable{
    public String login;
    public int contributions;

    @Bindable
    public String getLogin(){
        return login;
    }
    @Bindable
    public int getContributions(){
        return contributions;
    }

    public void setLogin(String login){
        this.login = login;
        notifyPropertyChanged(BR.login);
    }

    public void setContributions(int contributions){
        this.contributions = contributions;
        notifyPropertyChanged(BR.contributions);
    }

    @Override
    public String toString() {
        return login + ", " + contributions;
    }
}