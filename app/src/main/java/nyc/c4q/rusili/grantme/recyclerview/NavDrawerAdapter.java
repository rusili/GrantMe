package nyc.c4q.rusili.grantme.recyclerview;

import android.app.ProgressDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.rusili.grantme.R;

public class NavDrawerAdapter extends RecyclerView.Adapter {
    private View mView;
    private ProgressDialog progressDialog;

    public NavDrawerAdapter (ProgressDialog progressDialogParam) {
        this.progressDialog = progressDialogParam;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        mView = inflater.inflate(R.layout.navigationdrawer_viewholder, parent, false);
        NavDrawerViewholder viewHolder = new NavDrawerViewholder(mView, progressDialog);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder (RecyclerView.ViewHolder holder, int position) {
        NavDrawerViewholder navDrawerViewholder = (NavDrawerViewholder) holder;
        String text = null;
        switch (position) {
            case 0:
                text = "Grant Information";
                break;
            case 1:
                text = "FAQ";
                break;
            case 2:
                text = "Email";
                break;
        }
        navDrawerViewholder.bind(text);
    }

    @Override
    public int getItemCount () {
        return 3;
    }
}
