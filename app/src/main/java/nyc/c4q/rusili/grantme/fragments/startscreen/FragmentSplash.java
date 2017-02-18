package nyc.c4q.rusili.grantme.fragments.startscreen;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.rusili.grantme.R;

public class FragmentSplash extends Fragment{
    private View mView;

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragmentstart_splash, container, false);
        InitializeViews();
        return mView;
    }

    private void InitializeViews (){

    }
}