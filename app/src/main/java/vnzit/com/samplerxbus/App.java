package vnzit.com.samplerxbus;

import android.app.Application;

/**
 * Created by sh on 6/23/16.
 */
public class App extends Application {
    private static App instance;

    private RxBus bus;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        bus = new RxBus();
    }

    public static App get() {
        return instance;
    }

    public RxBus bus() {
        return bus;
    }
}
