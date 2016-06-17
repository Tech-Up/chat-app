package io.techup.app.chatapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.techup.app.chatapp.adapters.MessageAdapter;
import io.techup.app.chatapp.pojo.Message;

public class HomeActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
      }
    });

    initView();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_home, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.menu_settings:

        break;
    }
    return super.onOptionsItemSelected(item);
  }

  private void initView() {

    Date date = new Date();

    ListView messageListView = (ListView) findViewById(R.id.lv_messages);


    List<Message> messages = new ArrayList<>();

    Message message1 = new Message("Sample Message 1", "Ariel Silva Jr", date, "https://scontent.fmnl4-3.fna.fbcdn.net/v/t1.0-9/228244_224256857586940_3418428_n.jpg?oh=91af892d503f6cd366369f3efdc9d4cc&oe=580D51EA");
    Message message2 = new Message("Hi Ariel", "Ian", date, "https://scontent.fmnl4-3.fna.fbcdn.net/t31.0-8/12186257_10206715399982230_8629849205288280003_o.jpg");
    Message message3 = new Message("Hello bro!", "Edward", date, "https://scontent.fmnl4-3.fna.fbcdn.net/v/t1.0-9/13010593_10208018571436635_3485367098360723908_n.jpg?oh=d3692d62dd5a07f369899aa6f205f2ca&oe=580086FC");
    Message message4 = new Message("Hey Hey hey", "Pao", date, "https://scontent.fmnl4-3.fna.fbcdn.net/t31.0-8/11046392_10153470799883519_3745362851528649751_o.jpg");

    messages.add(message1);
    messages.add(message2);
    messages.add(message3);
    messages.add(message4);

    MessageAdapter messageAdapter = new MessageAdapter(this, messages);

    if (messageListView != null) {
      messageListView.setAdapter(messageAdapter);
    }
  }

}
