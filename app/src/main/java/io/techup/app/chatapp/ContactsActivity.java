package io.techup.app.chatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.techup.app.chatapp.adapters.ContactAdapter;
import io.techup.app.chatapp.pojo.User;

public class ContactsActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_contacts);
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
    ListView contactsListView = (ListView) findViewById(R.id.lv_contacts);

    List<User> users = new ArrayList<>();

    User user1 = new User("Ariel", "Silva", "ceosilvajr@gmail.com", "09399080674",
            "https://scontent.fmnl2-1.fna.fbcdn.net/v/t1.0-1/c50.0.320.320/p320x320/228244_224256857586940_3418428_n.jpg?oh=1d99d5de6535055f064920c99d6f1709&oe=57D5CD3E");
    User user2 = new User("Ian", "De Jesus", "ian@gmail.com", "09771234536",
            "https://scontent.fmnl4-3.fna.fbcdn.net/t31.0-8/12186257_10206715399982230_8629849205288280003_o.jpg");
    User user3 = new User("Edward", "Pedron", "edward@gmail.com", "09771234526",
            "https://scontent.fmnl4-3.fna.fbcdn.net/v/t1.0-9/13010593_10208018571436635_3485367098360723908_n.jpg?oh=d3692d62dd5a07f369899aa6f205f2ca&oe=580086FC");
    User user4 = new User("Pao", "Rendor", "pao@gmail.com", "09771234516",
            "https://scontent.fmnl4-3.fna.fbcdn.net/t31.0-8/11046392_10153470799883519_3745362851528649751_o.jpg");

    users.add(user1);
    users.add(user2);
    users.add(user3);
    users.add(user4);

    ContactAdapter contactAdapter = new ContactAdapter(this, users);

    if (contactsListView != null) {
      contactsListView.setAdapter(contactAdapter);
      contactsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
          Intent intent = new Intent(ContactsActivity.this, ContactDetailsActivity.class);
          startActivity(intent);
        }
      });
    }
  }

}
