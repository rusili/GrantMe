package nyc.c4q.rusili.grantme.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.rusili.grantme.R;

public class NavDrawerViewholder extends RecyclerView.ViewHolder {
    private TextView mTextView;

    public NavDrawerViewholder (View itemView) {
        super(itemView);
        mTextView = (TextView) itemView.findViewById(R.id.navigationdrawer_viewholder);
    }

    public void bind (String text) {
        mTextView.setText(text);
    }
}
