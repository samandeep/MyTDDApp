package demo.tdd.com.mytddapp.constant;


/**
 * +++++++++++++++++++++++++++++++
 * +++++++++Click labs +++++++++++
 * +++++++++++++++++++++++++++++++
 */
public interface AppConstant {
    String DEVICE_TYPE = "ANDROID";

    //Intent Filter
    String NOTIFICATION_RECEIVED = "notification_received";

    //Error
    String ERROR_VALUE_MISSING = "Either start or Destination Missing";

    String CHAT_SERVER_URL = "https://socketio-chat.now.sh/";


    String HOUR = "hr";
    String MINUTES = "min";

    //
    int SESSION_EXPIRED = 401;

    int REQUEST_CODE_PLAY_STORE = 500;
    int SDK_MIN = 23;

    //Request code
    int REQ_CODE_DEFAULT_SETTINGS = 16061;
    int REQ_CODE_PLAY_SERVICES_RESOLUTION = 16061;
    int REQ_CODE_SCREEN_OVERLAY = 10101;


    float DEFAULT_POLYLINE_WIDTH = 15;
    int CONVERT_TIME_MIN = 60;
    int CONVERT_KM = 1000;
    /*
   PolyLine decoding
    */
    int POLYDECODING_1 = 63;
    int POLYDECODING_2 = 0x1f;
    int POLYDECODING_3 = 0x20;
    double POLYDECODING_4 = 1E5;


    //Geo Model Data
    String STREET_NAME = "street_number";
    String ROUTE = "route";
    String LOCALITY = "locality";
    String COUNTRY = "country";
    String POSTAL_CODE = "postal_code";
    String POLITICAL = "political";
    String FORMATTED_ADDRESS = "formatted_address";


    float DIM_AMOUNT = 0.6f;

    String LIVE = "LIVE";
    String DEV = "DEV";
    String QA = "QA";


    //Save logs Address
    String ADD_LOGS = "/logcat-base.txt";
    /**
     * GetLocationconstants
     */
    int REQUEST_PERMISSIONS_REQUEST_CODE = 34;
    int SET_TIME_INTERVAL = 101;


    String CLICK_LABS_EMAIL = "contact@click-labs.com";
    String CLICK_LABS_PHONE_NUMBER = "tel:01722659902";
    String CLICK_LABS_SUPPORT = "CLICKLABS SUPPORT";


    int YEAR = 1995;
    int DAY = 28;
    int MONTH = 7;

    //Date
    String DATE_PICKER = "mDatePicker";
    String DIALOG_FORGOT_PASSWORD = "Reset password link is sent on your email";
    String REFER_CODE_SEND = "Send Refral:";
    String REFERAL_CODE = "ClickLabs100";


    String TUTORIAL_BUNDLE_FIRST = "first";
    String TUTORIAL_BUNDLE_SECOND = "second";
    String TUTORIAL_BUNDLE_THIRD = "third";


}
