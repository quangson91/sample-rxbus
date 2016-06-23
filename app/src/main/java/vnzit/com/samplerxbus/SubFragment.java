package vnzit.com.samplerxbus;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sh on 6/23/16.
 */
public class SubFragment extends BaseFragment {
    TextView tvContent;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.frg_sub, container, false);
        tvContent = (TextView) v.findViewById(R.id.tvContent);
        return v;
    }

    @Override
    protected void handlerBus(@NonNull Object o) {
        super.handlerBus(o);
        if (o instanceof Events.Message) {
            tvContent.setText(((Events.Message) o).message);
        }
    }
}
