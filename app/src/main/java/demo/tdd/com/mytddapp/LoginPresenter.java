package demo.tdd.com.mytddapp;

import demo.tdd.com.mytddapp.modellogin.ResponseLogin;
import demo.tdd.com.mytddapp.retrofit.CommonResponce;

/**
 * Created by Samandeep Kaur Sidhu on 22/09/17.
 */

public class LoginPresenter {
    private LoginService loginService;
    private LoginView loginView;

    public LoginService getDataService() {
        return this.loginService;
    }

    public LoginPresenter(LoginView loginView, LoginService loginService) {
             this.loginService = loginService;
        this.loginView = loginView;
    }

    public void onLoginClicked() {
        String email = loginView.getUsername();
        if (email.isEmpty()) {
            loginView.showEmailError(R.string.err_enter_email);
            return;
        }
        String password = loginView.getPassword();
        if (password.isEmpty()) {
            loginView.showPasswordError(R.string.err_enter_password);
            return;
        }

        if (loginService.login(email, password)) {
            login(email, password);
            return;
        }
    }

    /**
     * login With Email and Password
     */
    public void login(String email, String pasword) {
        getDataService().loginUser(email, pasword, new CommonResponce<ResponseLogin>() {
            @Override
            public void onSuccess(ResponseLogin responseLogin) {
                loginView.showProgressBar(false);
                loginView.onSuccessfullLogin();
            }
            @Override
            public void onFailure(String error) {
                loginView.showProgressBar(false);
                loginView.onLoginError("error");
            }
        });
    }


}
