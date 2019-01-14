package com.ll.ll20190107;


import io.reactivex.Observable;

public class LoginPrecenter extends BasePrecenter {

    public LoginPrecenter(DataCall consumer) {
        super(consumer);
    }
    @Override
    protected Observable observable(Object... args) {
        ILogin iLogin = NetWorkManager.getmInstance().create(ILogin.class);
        return iLogin.loginRx((String) args[0],(String)args[1]);
    }
}
