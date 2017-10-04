package demo.tdd.com.mytddapp.retrofit;

import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;

import java.io.File;
import java.util.HashMap;

import demo.tdd.com.mytddapp.util.CommonData;
import demo.tdd.com.mytddapp.util.DateTimeUtil;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static demo.tdd.com.mytddapp.constant.ApiKeyConstant.AUTHORIZATION;
import static demo.tdd.com.mytddapp.constant.ApiKeyConstant.DEFAULT_LANGUAGE;
import static demo.tdd.com.mytddapp.constant.ApiKeyConstant.LANGUAGE_CONTENT;
import static demo.tdd.com.mytddapp.constant.ApiKeyConstant.OFFSET;


/**
 * +++++++++++++++++++++++++++++++
 * +++++++++Click labs +++++++++++
 * +++++++++++++++++++++++++++++++
 */

public final class RetrofitUtils {

    /**
     * Empty Constructor
     * not called
     */
    private RetrofitUtils() {
    }


    /**
     * @param value content which need to convert into request body
     * @return object of request body
     */
    public static RequestBody getRequestBodyFromString(final String value) {
        RequestBody body = RequestBody.create(MediaType.parse("text/plain"), value);
        return body;
    }


    /**
     * @param key  parameter name
     * @param file that need to convert in request body
     * @return object of MultipartBody.Part
     */
    public static MultipartBody.Part getPartBodyFromFile(final String key, final File file) {

        // create RequestBody instance from file
        RequestBody requestFile =
                RequestBody.create(MediaType.parse(getMimeType(file)), file);
        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body =
                MultipartBody.Part.createFormData(key, file.getName(), requestFile);

        return body;
    }


    /**
     * @param file of which mime type is required
     * @return mimeType of file
     */
    public static String getMimeType(final File file) {
        String mimeType = "image/png";
        try {
            Uri selectedUri = Uri.fromFile(file);
            String fileExtension
                    = MimeTypeMap.getFileExtensionFromUrl(selectedUri.toString());
            mimeType
                    = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtension);
        } catch (Exception e) {
            Log.e("Mime type exception ", e.toString());
        }
        return mimeType;
    }

    /**
     * Gets header map.
     *
     * @param isWithAccessToken the is with access token
     * @return the header map
     */
    public static HashMap<String, String> getHeaderMap(final boolean isWithAccessToken) {
        Log.e("getCurrentZoneOffset", DateTimeUtil.getCurrentZoneOffset());
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(LANGUAGE_CONTENT, DEFAULT_LANGUAGE);
        hashMap.put(OFFSET, DateTimeUtil.getCurrentZoneOffset());
        if (isWithAccessToken) {
            hashMap.put(AUTHORIZATION, CommonData.getAccessToken());
        }
        return hashMap;
    }

}
