package nyc.c4q.rusili.grantme.fragments.startscreen;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import nyc.c4q.rusili.grantme.R;
import nyc.c4q.rusili.grantme.activities.HomePage;
import nyc.c4q.rusili.grantme.toasts.CustomToast;

public class FragmentLogin extends Fragment {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseAuth.AuthStateListener mAuthListener;
    private CustomToast customToast;

    private View mView;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    private TextView buttonCreateAccount;

    private String TAG = "FragmentLogin: ";
    private String email;
    private String password;

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_start_login, container, false);
        initializeViews();
        return mView;
    }

    private void initializeViews () {
        ShimmerFrameLayout container =
                (ShimmerFrameLayout) mView.findViewById(R.id.fragment_login_image_logo_shimmer);
        container.setBaseAlpha(0.8f);
        container.setDuration(1500);
        container.setRepeatDelay(3000);
        container.startShimmerAnimation();
        buttonLogin = (Button) mView.findViewById(R.id.fragment_login_button);
        buttonCreateAccount = (TextView) mView.findViewById(R.id.fragment_login_createaccount);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                onClickLogin();
            }
        });
    }

    private void onClickLogin () {
        editTextEmail = (EditText) mView.findViewById(R.id.fragment_login_edittext_username);
        //email = editTextEmail.getText().toString().trim();
        email = "Rusili56@gmail.com";
        editTextPassword = (EditText) mView.findViewById(R.id.fragment_login_edittext_password);
        //password = editTextPassword.getText().toString().trim();
        password = "123456";

        mAuth = FirebaseAuth.getInstance();
        checkLogin();
    }

    private void checkLogin () {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener <AuthResult>() {
                    @Override
                    public void onComplete (@NonNull Task <AuthResult> task) {
                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());
                        if (task.isSuccessful()) {
                            customToast.show(mView, "Signed In");
                            ProgressDialog progressDialog = new ProgressDialog(mView.getContext());
                            progressDialog.setMessage("Loading..");
                            progressDialog.setIndeterminate(false);
                            progressDialog.setCancelable(true);
                            progressDialog.show();
                            fromStarttoMain();
                        } else {
                            customToast.show(mView, "Invalid credentials");
                        }
                    }
                });
    }

    private void fromStarttoMain () {
        Intent intentStarttoMain = new Intent(mView.getContext(), HomePage.class);
        startActivity(intentStarttoMain);
        getActivity().overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
        getActivity().finish();
    }
}
