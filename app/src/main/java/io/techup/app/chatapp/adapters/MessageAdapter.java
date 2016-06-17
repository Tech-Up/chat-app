package io.techup.app.chatapp.adapters;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import io.techup.app.chatapp.R;
import io.techup.app.chatapp.pojo.Message;

/**
 * Created by ceosilvajr on 13/06/16.
 */
public class MessageAdapter extends ArrayAdapter<Message> {

  private Context mContext;
  private List<Message> mMessageList;

  public MessageAdapter(Context context, List<Message> objects) {
    super(context, 0, objects);
    this.mContext = context;
    this.mMessageList = objects;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

    LayoutInflater inflater = (LayoutInflater) mContext
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View view = inflater.inflate(R.layout.message_item, parent, false);

    ImageView userImage = (ImageView) view.findViewById(R.id.iv_img_user);
    TextView userName = (TextView) view.findViewById(R.id.tv_user_name);
    TextView userMessage = (TextView) view.findViewById(R.id.tv_message);
    TextView time = (TextView) view.findViewById(R.id.tv_time);

    Message message = mMessageList.get(position);

    Glide.with(mContext).load(message.getSenderPhotoUrl()).asBitmap().into(userImage);
    userName.setText(message.getSenderName());
    userMessage.setText(message.getMessage());
    // Convert date to human readable time
    String convertedTime = DateUtils.getRelativeTimeSpanString(message.getTime().getTime(), System.currentTimeMillis(),
            DateUtils.SECOND_IN_MILLIS).toString();
    time.setText(convertedTime);

    return view;
  }

  @Override
  public Message getItem(int position) {
    return mMessageList.get(position);
  }

}