package vnzit.com.samplerxbus;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by sh on 6/23/16.
 */
public class BaseActivity extends AppCompatActivity {
    private Subscription busSubscription;

    @Override
    protected void onResume() {
        super.onResume();
        autoUnsubBus();
        busSubscription = App.get().bus().toObserverable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Action1<Object>() {
                            @Override
                            public void call(Object o) {
                                if (o == null) return;
                                handlerBus(o);
                            }
                        }
                );
    }

    protected void handlerBus(@NonNull  Object o) {
    }

    private void autoUnsubBus() {
        if (busSubscription != null && !busSubscription.isUnsubscribed()) {
            busSubscription.unsubscribe();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        autoUnsubBus();
    }
}
