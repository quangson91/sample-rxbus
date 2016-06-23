package vnzit.com.samplerxbus;

import android.app.Application;

/**
 * Created by sh on 6/23/16.
 */
public class App extends Application {
    private static App instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static App get() {
        return instance;
    }
}
