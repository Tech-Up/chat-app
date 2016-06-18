package io.techup.app.chatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.commons.validator.routines.EmailValidator;

public class LoginActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    initView();
  }

  private void initView() {

    final Button btnLogin = (Button) findViewById(R.id.btn_login);
    final EditText edtEmail = (EditText) findViewById(R.id.edt_email);
    final EditText edtPassword = (EditText) findViewById(R.id.edt_password);

    if (btnLogin != null) {
      btnLogin.setOnClickListener(new View.OnClickListener() {
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

          Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
          startActivity(intent);
          finish();

        }
      });
    }

    Button btnRegister = (Button) findViewById(R.id.btn_register);
    if (btnRegister != null) {
      btnRegister.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
          startActivity(intent);
        }
      });
    }

    TextView textView = (TextView) findViewById(R.id.tv_forgot_password);
    if (textView != null) {
      textView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
          startActivity(intent);
        }
      });
    }
  }

  private boolean isValidEmail(String email) {
    return !email.isEmpty() && EmailValidator.getInstance().isValid(email);
  }
}