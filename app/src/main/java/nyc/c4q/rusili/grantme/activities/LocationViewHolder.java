package nyc.c4q.rusili.grantme.activities;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Map;

import nyc.c4q.rusili.grantme.R;
import nyc.c4q.rusili.grantme.utilities.DataSets;

/**
 * Created by huilin on 2/18/17.
 */
public class LocationViewHolder extends RecyclerView.ViewHolder {
    private final TextView tileTV;
    private final View tileView;
    private final ImageView tileBg;

    public LocationViewHolder (View itemView) {
        super(itemView);
        tileView = itemView;
        tileTV = (TextView) itemView.findViewById(R.id.tile_tv);
        tileBg = (ImageView) itemView.findViewById(R.id.tile_background);
    }

    public void bind (String cardIdentifier) {
        tileTV.setText(cardIdentifier);
        DataSets pictures = new DataSets();
        pictures.initPictureMap();
        Map <String, Integer> pictureMap = pictures.getPictureMap();
        if (pictureMap.containsKey(cardIdentifier)) {
            Picasso.with(itemView.getContext()).load(pictureMap.get(cardIdentifier)).into(tileBg);
        }
    }
}
