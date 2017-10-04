package demo.tdd.com.mytddapp;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import demo.tdd.com.mytddapp.modellogin.ResponseLogin;
import demo.tdd.com.mytddapp.retrofit.CommonResponce;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Samandeep Kaur Sidhu on 22/09/17.
 */

public class LoginPresenterTest {
    private LoginPresenter loginPresenter;
    @Mock
    private LoginView loginView;
    @Mock
    private LoginService loginService;
    @Captor
    ArgumentCaptor<CommonResponce<ResponseLogin>> callbackArgumentCaptor;
    @Captor
    ArgumentCaptor<String> stringArgumentCaptorEmail;
    @Captor
    ArgumentCaptor<String> stringArgumentCaptorPassword;
    @Mock
    Context context;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        loginPresenter = spy(new LoginPresenter(loginView, loginService));
        when(loginPresenter.getDataService()).thenReturn(loginService);
    }

    /**
     * Test case to check empty EditText field for id and show error if empty
     *
     * @throws Exception exception
     */
    @Test
    public void testEmptyIdView() throws Exception {
        // mock the return function getUserId() to return empty string
        when(loginView.getUsername()).thenReturn("");
        loginPresenter.onLoginClicked();
        /**
         * verify that after button clicked weather
         * showEmptyIdError(int id) method called on loginView on not
         */
        verify(loginView).showEmailError(R.string.err_enter_email);
    }

    @Test
    public void testEmptyPasswordField() throws Exception {
        /**
         *    similar to above except we need to pass id as non empty such
         *    that previous case not exploit
         */
        when(loginView.getUsername()).thenReturn("Saman");
        when(loginView.getPassword()).thenReturn("");
        loginPresenter.onLoginClicked();
        verify(loginView).showPasswordError(R.string.err_enter_password);
    }

    @Test
    public void testSuccessFullLogin() throws Exception {
        when(loginView.getUsername()).thenReturn("Saman");
        when(loginView.getPassword()).thenReturn("123456");
        loginPresenter.login(loginView.getUsername(), loginView.getPassword());
        verify(loginService).loginUser(stringArgumentCaptorEmail.capture(), stringArgumentCaptorPassword.capture(), callbackArgumentCaptor.capture());
        callbackArgumentCaptor.getValue().onSuccess(new ResponseLogin());
        verify(loginView).showProgressBar(false);
        verify(loginView).onSuccessfullLogin();
    }

    @Test
    public void testLoginFailed() throws Exception {
        when(loginView.getUsername()).thenReturn("Saman");
        when(loginView.getPassword()).thenReturn("123456");
        loginPresenter.login(loginView.getUsername(), loginView.getPassword());
        verify(loginService).loginUser(stringArgumentCaptorEmail.capture(), stringArgumentCaptorPassword.capture(), callbackArgumentCaptor.capture());
        callbackArgumentCaptor.getValue().onFailure("");
        verify(loginView).showProgressBar(false);
        verify(loginView).onLoginError("error");
    }


}