package demo.tdd.com.mytddapp.retrofit;

/**
 * +++++++++++++++++++++++++++++++++
 * ++++++++++Click labs ++++++++++++
 * +++++++++++++++++++++++++++++++++
 */

public interface CommonResponce<T> {

    void onSuccess(T t);
    void onFailure(String error);
}
