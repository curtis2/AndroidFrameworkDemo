package com.simon.mvc.modul;

/**
 * auther: Simon zhang
 * Emaill:18292967668@163.com
 */

public class Contributor {
    public String login;
    public int contributions;

    @Override
    public String toString() {
        return login + ", " + contributions;
    }
}