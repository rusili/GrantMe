package nyc.c4q.rusili.grantme.activities;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nyc.c4q.rusili.grantme.R;

/**
 * Created by huilin on 2/18/17.
 */
public class LocationViewHolder extends RecyclerView.ViewHolder {

    private final TextView cardTV;
    private final View cardView;
    private final ImageView cardImgV;

//    private CardView mCardView;

    public LocationViewHolder(View itemView) {
        super(itemView);
        cardView = itemView;
        cardTV = (TextView) itemView.findViewById(R.id.card_tv);
//        mCardView = (CardView) itemView.findViewById(R.id.location_card);
        cardImgV = (ImageView) itemView.findViewById(R.id.card_background);
    }

    public void bind(String cardIdentifier ) {
        cardTV.setText(cardIdentifier);
        switch (cardIdentifier) {
            case "Brooklyn":
                Picasso.with(itemView.getContext()).load(R.drawable.brooklyn).into(cardImgV);
                break;
            case "Bronx":
                Picasso.with(itemView.getContext()).load(R.drawable.bronx).into(cardImgV);
                break;
            case "Manhattan":
                Picasso.with(itemView.getContext()).load(R.drawable.manhattan).into(cardImgV);
                break;
            case "Queens":
                Picasso.with(itemView.getContext()).load(R.drawable.queens).into(cardImgV);
                break;
            case "Staten Island":
                Picasso.with(itemView.getContext()).load(R.drawable.statenisland).into(cardImgV);
                break;
            case "All":
                Picasso.with(itemView.getContext()).load(R.drawable.nyc).into(cardImgV);
                break;
        }

    }

//    public CardView getmCardView() {
//        return mCardView;
//}
}
