package nyc.c4q.rusili.grantme.fragments.startscreen;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import nyc.c4q.rusili.grantme.R;
import nyc.c4q.rusili.grantme.toasts.CustomToast;
import nyc.c4q.rusili.grantme.utilities.FragmentBuilder;

public class FragmentCreateAccount extends Fragment {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseAuth.AuthStateListener mAuthListener;

    private CustomToast customToast;
    private View mView;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonCreateAccount;
    private String username;
    private String password;

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_start_createaccount, container, false);
        initializeViews();
        customToast = new CustomToast();
        return mView;
    }

    private void initializeViews () {
        editTextEmail = (EditText) mView.findViewById(R.id.fragment_createaccount_email);
        username = editTextEmail.getText().toString();
        editTextPassword = (EditText) mView.findViewById(R.id.fragment_createaccount_password);
        password = editTextPassword.getText().toString();
        buttonCreateAccount = (Button) mView.findViewById(R.id.fragment_createaccount_button);
        buttonCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                createAccountFirebase();
            }
        });
    }

    private void createAccountFirebase(){
        String createAccountEmail = editTextEmail.getText().toString().trim();
        String createAccountPassword = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(createAccountEmail) || TextUtils.isEmpty(createAccountPassword)) {
            customToast.show(mView, "Please enter an email and password");
        } else {
            mAuth.createUserWithEmailAndPassword(createAccountEmail, createAccountPassword)
                    .addOnCompleteListener(new OnCompleteListener <AuthResult>() {
                        @Override
                        public void onComplete (@NonNull Task <AuthResult> task) {
                            if (task.isSuccessful()) {
                                customToast.show(mView, "Account Created!");
                                backToLoginScreen();
                            } else {
                                customToast.show(mView, "Failed to make account");
                            }
                        }
                    });
        }
    }

    private void backToLoginScreen(){
        FragmentLogin fragmentLogin = new FragmentLogin();
        FragmentBuilder fragmentBuilder = new FragmentBuilder.Builder()
                .activity((Activity) mView.getContext())
                .fragment(fragmentLogin)
                .containerID(R.id.activity_start_layout_parent)
                .animations(R.animator.animator_slide_in_right, R.animator.animator_slide_out_right)
                .backstack(false)
                .build();
        fragmentBuilder.inflateFragment();
    }
}
