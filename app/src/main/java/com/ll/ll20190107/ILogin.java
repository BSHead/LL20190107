package com.ll.ll20190107;

import com.ll.ll20190107.bean.Result;
import com.ll.ll20190107.bean.User;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ILogin {
    /**
     * 登陆
     * @param mobile
     * @param password
     * @return
     */
    @POST("user/v1/login")
    @FormUrlEncoded
    Observable<Result<User>> loginRx(@Field("phone") String mobile,
                                     @Field("pwd") String password);

}
