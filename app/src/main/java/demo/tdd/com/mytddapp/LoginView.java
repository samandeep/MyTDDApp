package demo.tdd.com.mytddapp;

/**
 * Created by Samandeep Kaur Sidhu on 22/09/17.
 */

interface LoginView {
    String getUsername();
    String getPassword();

    void showEmailError(int resId);

    void showPasswordError(int resId);

    void onSuccessfullLogin();

    void onLoginError(String error);

    void showProgressBar(boolean show);

}
