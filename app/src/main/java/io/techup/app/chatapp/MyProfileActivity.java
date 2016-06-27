package io.techup.app.chatapp;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MyProfileActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my_profile);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
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
    ImageButton btnEditFirstName = (ImageButton) findViewById(R.id.btn_edit_first_name);
    if (btnEditFirstName != null) {
      btnEditFirstName.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          popupEditFirstName();
        }
      });
    }
    ImageButton btnEditLastName = (ImageButton) findViewById(R.id.btn_edit_last_name);
    if (btnEditLastName != null) {
      btnEditLastName.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          popUpEditLastName();
        }
      });
    }
  }

  private void popupEditFirstName() {
    final Dialog dialog = new Dialog(this);
    dialog.setContentView(R.layout.dialog_edit_first_name);
    dialog.setTitle("Edit first name");
    dialog.show();
  }

  private void popUpEditLastName() {
    final Dialog dialog = new Dialog(this);
    dialog.setContentView(R.layout.dialog_edit_last_name);
    dialog.setTitle("Edit first name");
    dialog.show();
  }

}
