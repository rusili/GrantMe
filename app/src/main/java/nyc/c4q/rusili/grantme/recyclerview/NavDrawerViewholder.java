package nyc.c4q.rusili.grantme.recyclerview;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import nyc.c4q.rusili.grantme.R;

public class NavDrawerViewholder extends RecyclerView.ViewHolder {
    private TextView mTextView;
    private ProgressDialog progressDialog;

    public NavDrawerViewholder (View itemView, ProgressDialog progressDialogParam) {
        super(itemView);
        mTextView = (TextView) itemView.findViewById(R.id.navigationdrawer_viewholder);
        this.progressDialog = progressDialogParam;
    }

    public void bind (final String text) {
        mTextView.setText(text);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                switch (text){
                    case "Grant Information":
                        grantInfo();
                        break;
                    case "FAQ":
                        faqInfo();
                        break;
                    case "E-mail":
                        emailInfo();
                        break;
                }
            }
        });

    }

    private void emailInfo() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"recipient@example.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
        i.putExtra(Intent.EXTRA_TEXT, "body of email");
        try {
            itemView.getContext().startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(itemView.getContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }

    }

    private void grantInfo() {
        createLoadingSpinner();

        String url = "http://mtprawvwsbswtp.nyc.gov/popups/ITG.aspx";
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        builder.setStartAnimations(itemView.getContext(), R.anim.slide_in_right, R.anim.slide_out_left);
        builder.setExitAnimations(itemView.getContext(), R.anim.slide_in_left, R.anim.slide_out_right);
        builder.setToolbarColor(itemView.getContext().getResources().getColor(R.color.colorPrimaryDark));
        customTabsIntent.launchUrl(itemView.getContext(), Uri.parse(url));
    }


    private void faqInfo() {
        createLoadingSpinner();

        String url = "http://www.nyc.gov/html/sbs/wf1/downloads/pdf/WhatIsAnITG_FAQ2.pdf";
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        builder.setStartAnimations(itemView.getContext(), R.anim.slide_in_right, R.anim.slide_out_left);
        builder.setExitAnimations(itemView.getContext(), R.anim.slide_in_left, R.anim.slide_out_right);
        builder.setToolbarColor(itemView.getContext().getResources().getColor(R.color.colorPrimaryDark));
        customTabsIntent.launchUrl(itemView.getContext(), Uri.parse(url));
    }

    private void createLoadingSpinner(){
        progressDialog.setMessage("Loading..");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(true);
        progressDialog.show();
    }
}
