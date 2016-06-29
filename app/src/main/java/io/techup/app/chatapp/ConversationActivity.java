package io.techup.app.chatapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.techup.app.chatapp.adapters.ConversationAdapter;
import io.techup.app.chatapp.pojo.Message;

public class ConversationActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_conversation);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    initView();
  }

  private void initView() {

    Date date = new Date();

    ListView messageListView = (ListView) findViewById(R.id.lv_conversations);
    List<Message> messages = new ArrayList<>();

    Message message1 = new Message("Sample Message 1", "Ariel Silva Jr", date, "https://scontent.fmnl2-1.fna.fbcdn.net/v/t1.0-1/c50.0.320.320/p320x320/228244_224256857586940_3418428_n.jpg?oh=1d99d5de6535055f064920c99d6f1709&oe=57D5CD3E");
    Message message2 = new Message("Hi Ariel", "Ian", date, "https://scontent.fmnl4-3.fna.fbcdn.net/t31.0-8/12186257_10206715399982230_8629849205288280003_o.jpg");
    message2.setSender(true);
    Message message3 = new Message("Hello bro!", "Edward", date, "https://scontent.fmnl4-3.fna.fbcdn.net/v/t1.0-9/13010593_10208018571436635_3485367098360723908_n.jpg?oh=d3692d62dd5a07f369899aa6f205f2ca&oe=580086FC");
    message3.setSender(true);
    Message message4 = new Message("Hey Hey hey", "Pao", date, "https://scontent.fmnl4-3.fna.fbcdn.net/t31.0-8/11046392_10153470799883519_3745362851528649751_o.jpg");
    message4.setSender(true);

    messages.add(message1);
    messages.add(message2);
    messages.add(message3);
    messages.add(message4);

    ConversationAdapter conversationAdapter = new ConversationAdapter(this, messages);

    if (messageListView != null) {
      messageListView.setAdapter(conversationAdapter);
    }
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

}
