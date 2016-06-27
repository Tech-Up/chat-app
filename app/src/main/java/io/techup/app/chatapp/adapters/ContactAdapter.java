package io.techup.app.chatapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import io.techup.app.chatapp.R;
import io.techup.app.chatapp.pojo.User;

/**
 * Created by ceosilvajr on 13/06/16.
 */
public class ContactAdapter extends ArrayAdapter<User> {

  private Context mContext;
  private List<User> mUserList;

  public ContactAdapter(Context context, List<User> objects) {
    super(context, 0, objects);
    this.mContext = context;
    this.mUserList = objects;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

    LayoutInflater inflater = (LayoutInflater) mContext
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View view = inflater.inflate(R.layout.contact_item, parent, false);

    ImageView userImage = (ImageView) view.findViewById(R.id.iv_img_user);
    TextView userName = (TextView) view.findViewById(R.id.tv_user_name);

    User user = mUserList.get(position);
    Glide.with(mContext).load(user.getImageUrl()).asBitmap().into(userImage);

    String name = user.getFirstName() + " " + user.getLastName();
    userName.setText(name);

    return view;
  }

  @Override
  public User getItem(int position) {
    return mUserList.get(position);
  }

}