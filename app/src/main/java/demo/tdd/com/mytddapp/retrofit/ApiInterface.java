package demo.tdd.com.mytddapp.retrofit;


import java.util.HashMap;

import demo.tdd.com.mytddapp.modellogin.ResponseLogin;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * +++++++++++++++++++++++++++++++
 * +++++++++Click labs +++++++++++
 * +++++++++++++++++++++++++++++++
 */
public interface ApiInterface {

    /*SERVER_DOMAIN PORT*/
    /*Development server*/
    String DEV_SERVER = "DEV_SERVER";
    /*Test server*/
    String TEST_SERVER = "TEST_SERVER";
    /*Live server*/
    String LIVE_SERVER = "LIVE_SERVER";
    /*Live Pre server*/
    String LIVE_PRE_SERVER = "LIVE_PRE_SERVER";

    //   String UNIVERSAL_BASE_URL = null;
    String UPDATE_LOCATION = "api/v1/user/updateLocation";
    String GOOGLE_DIRECTION = "maps/api/directions/json";
    String GEO_CODING = "maps/api/geocode/json";
//    String GOOGLE_AUTO_COMPLETE_ADDRESS = "maps/api/place/autocomplete/json";


    //Api Key Constants
    String API_USER = "user";
    String API_CUSTOMER = "customer";
    String API_SOCIAL = "social";


    String LOGIN_API = API_USER + "/login";
    String VERIFY_OTP = API_USER + "/verifyMobileOTP";
    String RESEND_OTP = API_USER + "/resendOTP";
    String FORGOT_PASSWORD = API_USER + "/getResetPasswordToken";
    String SIGN_UP = API_CUSTOMER + "/registerFromEmail";
    String RESET_PASSWORD = API_USER + "/resetPassword";
    String LOG_OUT = API_USER + "/logout";
    String SOCIAL_LOGIN = API_SOCIAL + "/login";

    /**
     * @param headerMap Headers on API
     * @param map       Data to be send
     * @return return the response
     */
    @FormUrlEncoded
    @POST(LOGIN_API)
    Call<ResponseLogin> login(@HeaderMap HashMap<String, String> headerMap, @FieldMap HashMap<String, String> map);


}

