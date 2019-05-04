package com.cosw.myapplication.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.cosw.myapplication.R;
import com.cosw.myapplication.android.network.data.LoginWrapper;
import com.cosw.myapplication.android.utils.StringUtils;

public class LoginActivity extends AppCompatActivity {

    private EditText email;

    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLoginClicked( final View view ) {
        final LoginWrapper loginWrapper = validInputFields();
    }

    private LoginWrapper validInputFields() {
        String email = this.email.getText().toString();
        String password = this.password.getText().toString();
        if ( !StringUtils.isValidEmail( email ) )
        {
            this.email.setError( getString( R.string.error_invalid_email ) );
            return null;
        }
        else
        {
            this.email.setError( null );
            if ( password.isEmpty() )
            {
                this.password.setError( getString( R.string.please_enter_a_password ) );
                return null;
            }
            else
            {
                this.password.setError( null );
            }
        }

        return new LoginWrapper( email, password );
    }
}
