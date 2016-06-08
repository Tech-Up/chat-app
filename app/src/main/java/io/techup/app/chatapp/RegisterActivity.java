package io.techup.app.chatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.apache.commons.validator.routines.EmailValidator;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {

        Button btnSubmit = (Button) findViewById(R.id.btn_submit);

        final EditText edtEmail = (EditText) findViewById(R.id.edt_email);
        final EditText edtPassword = (EditText) findViewById(R.id.edt_password);

        if (btnSubmit != null) {
            btnSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (edtEmail != null) {
                        String email = edtEmail.getText().toString();
                        if (!isValidEmail(email)) {
                            edtEmail.setError("Invalid email");
                        }
                    }

                    if (edtPassword != null) {
                        String password = edtPassword.getText().toString();
                        if (password.length() == 0) {
                            edtPassword.setError("Please enter your password.");
                            return;
                        }
                        if (password.length() < 6) {
                            edtPassword.setError("Please enter at least 6 character.");
                            return;
                        }
                    }

                    Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }

    private boolean isValidEmail(String email) {
        return !email.isEmpty() && EmailValidator.getInstance().isValid(email);
    }

}
