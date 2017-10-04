package demo.tdd.com.mytddapp;

import android.app.Application;
import android.content.Context;

import io.paperdb.Paper;



/**
 * Created by Samandeep Kaur Sidhu on 22/09/17.
 */

public class MyApplication extends Application {
    private static MyApplication myApplication;

    /**
     * @return instance of MyApplication
     */
    public static MyApplication getApplication() {
        return myApplication;
    }

    /**
     * Getter to access Singleton instance
     *
     * @return instance of MyApplication
     */
    public static Context getAppContext() {
        return getApplication().getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Paper.init(this);
        // Setup singleton instance
        myApplication = this;

        //leak canary
        /*if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...
        */
    }
}
