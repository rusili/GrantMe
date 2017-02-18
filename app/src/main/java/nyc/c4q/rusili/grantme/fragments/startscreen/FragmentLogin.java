package nyc.c4q.rusili.grantme.fragments.startscreen;

import android.app.Fragment;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import nyc.c4q.rusili.grantme.R;
import nyc.c4q.rusili.grantme.activities.HomePage;
import nyc.c4q.rusili.grantme.toasts.CustomToast;

public class FragmentLogin extends Fragment{
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
        buttonLogin = (Button) mView.findViewById(R.id.fragment_login_button);
        buttonCreateAccount = (TextView) mView.findViewById(R.id.fragment_login_createaccount);
    }

    private void onClickLogin(){
        editTextEmail = (EditText) mView.findViewById(R.id.fragment_login_edittext_username);
        email = editTextEmail.getText().toString();
        editTextPassword = (EditText) mView.findViewById(R.id.fragment_login_edittext_password);
        password = editTextPassword.getText().toString();
    }

    private void checkLogin(){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                        if (task.isSuccessful()) {
                            System.out.println("Sign in successful!");
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
    }
}
