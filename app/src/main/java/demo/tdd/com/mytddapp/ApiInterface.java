package demo.tdd.com.mytddapp;

import java.util.HashMap;

import demo.tdd.com.mytddapp.modellogin.ResponseLogin;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by Samandeep Kaur Sidhu on 25/09/17.
 */

public interface ApiInterface {
    //Api Key Constants
    String API_USER = "user";
    String LOGIN_API = API_USER + "/login";
    /**
     * @param headerMap Headers on API
     * @param map       Data to be send
     * @return return the response
     */
    @FormUrlEncoded
    @POST(LOGIN_API)
    Call<ResponseLogin> login(@HeaderMap HashMap<String, String> headerMap, @FieldMap HashMap<String, String> map);
}
