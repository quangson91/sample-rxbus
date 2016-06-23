package vnzit.com.samplerxbus;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends BaseActivity {


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

    protected void handlerBus(@NonNull  Object o) {
        if (o instanceof Events.Message) {
            tvContent.setText(((Events.Message) o).message);
        }
    }
}
