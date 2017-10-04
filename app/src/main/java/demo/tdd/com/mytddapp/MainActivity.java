package demo.tdd.com.mytddapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Samandeep Kaur Sidhu on 22/09/17.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    private EditText etEmail;
    private EditText etPassword;
    private Button btSignIn;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    /**
     * to intialize view
     */
    private void init() {
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btSignIn = (Button) findViewById(R.id.btSignIn);

        btSignIn.setOnClickListener(this);

        loginPresenter = new LoginPresenter(this, new LoginService());
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btSignIn:
                onSignInClick();
                break;
            default:
                break;
        }
    }

    /**
     * To perform Login Operation
     */
    private void onSignInClick() {
        loginPresenter.onLoginClicked();
    }

    /**
     * To get Username
     *
     * @return
     */
    @Override
    public String getUsername() {
        return etEmail.getText().toString();
    }

    /**
     * To get password
     *
     * @return
     */
    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    /**
     * To show the email error
     *
     * @param resId
     */
    @Override
    public void showEmailError(int resId) {
        etEmail.setError(getString(resId));
    }

    /**
     * To show password error
     *
     * @param resId
     */
    @Override
    public void showPasswordError(int resId) {
        etPassword.setError(getString(resId));
    }

    /**
     * Perform action here after successfull login
     */
    @Override
    public void onSuccessfullLogin() {
        System.out.println("intent called");
        startActivity(new Intent(this, HomeActivity.class));
    }

    /**
     * Perform action here after login failed
     */
    @Override
    public void onLoginError(final String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar(final boolean show) {
        //progressBar.setVisibility(show?View.VISIBLE:View.GONE);
    }
}
