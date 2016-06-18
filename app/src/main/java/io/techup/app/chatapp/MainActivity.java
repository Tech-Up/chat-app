package io.techup.app.chatapp;

import android.content.Intent;

import io.techup.app.chatapp.extras.SplashActivity;

public class MainActivity extends SplashActivity {

  @Override
  public int setLayout() {
    return R.layout.activity_main;
  }

  @Override
  public int setTimeInSeconds() {
    return 2;
  }

  @Override
  public void init() {

  }

  @Override
  public void done() {
    Intent intent = new Intent(this, LoginActivity.class);
    startActivity(intent);
    finish();
  }

}