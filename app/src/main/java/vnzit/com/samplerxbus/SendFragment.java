package vnzit.com.samplerxbus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sh on 6/23/16.
 */
public class SendFragment extends BaseFragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.frg_send, container, false);
        v.findViewById(R.id.btnSend).setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        App.get().bus().send(new Events.Message("Message from `SendFragment` at " + System.currentTimeMillis()));
    }
}
