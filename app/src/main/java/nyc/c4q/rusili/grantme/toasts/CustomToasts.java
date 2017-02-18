package nyc.c4q.rusili.grantme.toasts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import nyc.c4q.rusili.utilitytemplates.R;

// Creates custom Toast
//Parameters: 1) View of the Activity
//            2) String of the message
//Needs:      1) Custom layout:   toast_layout
//            2) Textview:        toast_textview

public class CustomToasts {
    private static Toast toastInflater;

    public static void show (View viewParam, String messageParam) {
        if (toastInflater != null) {
            toastInflater.cancel();
        }
        toastInflater = new Toast(viewParam.getContext());
        toastInflater.setDuration(Toast.LENGTH_SHORT);
        LayoutInflater inflater = (LayoutInflater) viewParam.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // R.layout.toast_layout in layout folder
        View view = inflater.inflate(R.layout.toast_layout, null);
        TextView textView = (TextView) view.findViewById(R.id.toast_textview);
        textView.setText(messageParam);
        toastInflater.setView(view);
        toastInflater.show();
    }
}