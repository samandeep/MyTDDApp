package demo.tdd.com.mytddapp.retrofit;

import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

import static demo.tdd.com.mytddapp.retrofit.ResponseResolver.UNEXPECTED_ERROR_OCCURRED;


/**
 *  +++++++++++++++++++++++++++++++
 *  +++++++++Click labs +++++++++++
 *  +++++++++++++++++++++++++++++++
 */

final class ErrorUtils {
    static final int DEFAULT_STATUS_CODE = 900;

    /**
     * Empty Constructor
     * not called
     */
    private ErrorUtils() {
    }

    /**
     * @param response response of api call
     * @return object of APIError
     */
    static APIError parseError(final Response<?> response) {
        Converter<ResponseBody, APIError> converter = RestClient.getRetrofitBuilder().responseBodyConverter(APIError.class, new Annotation[0]);
        APIError error;
        try {
            if (response.errorBody() != null) {
                error = converter.convert(response.errorBody());
            } else {
                error = new APIError(response.code(), response.message());
            }

        } catch (Exception e) {
            int statusCode = DEFAULT_STATUS_CODE;
            String message = UNEXPECTED_ERROR_OCCURRED;
            if (response.code() != 0) {
                statusCode = response.code();
            }
            if (response.message() != null && !response.message().isEmpty()) {
                message = response.message();
            }
            return new APIError(statusCode, message);
        }
        return error;
    }
}
