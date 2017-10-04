package demo.tdd.com.mytddapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.HashMap;

import demo.tdd.com.mytddapp.constant.ApiKeyConstant;
import demo.tdd.com.mytddapp.modellogin.ResponseLogin;
import demo.tdd.com.mytddapp.retrofit.APIError;
import demo.tdd.com.mytddapp.retrofit.CommonResponce;
import demo.tdd.com.mytddapp.retrofit.ResponseResolver;
import demo.tdd.com.mytddapp.retrofit.RestClient;

import static demo.tdd.com.mytddapp.constant.ApiKeyConstant.APP_TYPE;
import static demo.tdd.com.mytddapp.constant.ApiKeyConstant.DEFAULT_LANGUAGE;


/**
 * Created by Samandeep Kaur Sidhu on 22/09/17.
 */

public class LoginService extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public boolean login(String username, String password) {
        return true;
    }

    /**
     *
     * @param userId String id
     * @param password password
     * @param callback CallBack for network response
     */
    public void loginUser(final String userId, final String password, final CommonResponce<ResponseLogin> callback) {
        System.out.println("login user called");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(ApiKeyConstant.LANGUAGE_CONTENT, DEFAULT_LANGUAGE);
        hashMap.put(ApiKeyConstant.OFFSET, "300");
        HashMap<String,String> param = new HashMap<>();
        param.put(ApiKeyConstant.PRIMARY_MOBILE,userId);
        param.put(ApiKeyConstant.PASSWORD,password);
        param.put(ApiKeyConstant.ROLE,ApiKeyConstant.ROLE_TYPE);
        param.put(ApiKeyConstant.DEVICE_TOKEN,"android");
        param.put(ApiKeyConstant.DEVICE_TYPE,APP_TYPE);
        RestClient.getApiInterface().login(hashMap, param)
                .enqueue(new ResponseResolver<ResponseLogin>(MyApplication.getAppContext()) {
                    @Override
                    public void success(ResponseLogin responseLogin) {
                        Log.e("abcd","retrofit success");
                        callback.onSuccess(responseLogin);
                    }

                    @Override
                    public void failure(APIError error) {
                      callback.onFailure(error.getMessage());
                        Log.e("abcd","retrofit fail" + error.getMessage());
                    }
                });

    }


}
