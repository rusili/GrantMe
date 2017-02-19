package nyc.c4q.rusili.grantme.activities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.rusili.grantme.R;
import nyc.c4q.rusili.grantme.network.pojo.Listener;

/**
 * Created by huilin on 2/18/17.
 */
public class LocationAdapter extends RecyclerView.Adapter<LocationViewHolder> {


    private Listener mListener;
    private String mFragId;

    public LocationAdapter(Listener listener, String fragId){
        this.mListener=listener;
        this.mFragId=fragId;

    }

    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_items, parent, false);
        return new LocationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LocationViewHolder holder, final int position) {
        holder.bind(position);
        holder.getmCardView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.showTrainings(position,mFragId);

            }
        });

    }

    @Override
    public int getItemCount() {
        return 5;
    }

}
