package vnzit.com.samplerxbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    private Subscription busSubscription;
    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContent = (TextView) findViewById(R.id.tvContent);
        findViewById(R.id.btnClickMe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.get().bus().send(new Events.Message("Click at(ms): " + System.currentTimeMillis()));
            }
        });

    }

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
                                handlerBus(o);
                            }
                        }
                );
    }

    private void handlerBus(Object o) {
        if (o instanceof Events.Message) {
            tvContent.setText(((Events.Message) o).message);
        }
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
