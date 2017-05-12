package com.example.ryan.riglettemp.models;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ryan.riglettemp.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ryan on 5/7/2017.
 */

public class FriendAdapter extends ArrayAdapter<Friend> {

    private EditUserCallback callback;
    List<Friend> list;
    private Context context;

    public FriendAdapter(Context context, List<Friend> items) {
        super(context, R.layout.listview_friendlist_item, items);
        this.list = items;
        this.context=context;
    }

    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
        TextView txtTitle;
        Button editBtn;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Friend friend = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.listview_friendlist_item, null);
            holder = new ViewHolder();
            holder.txtTitle = (TextView) convertView.findViewById(R.id.friendNameTextView);
            holder.imageView = (ImageView) convertView.findViewById(R.id.profileImageView);
            convertView.setTag(holder);
            holder.editBtn = (Button)convertView.findViewById(R.id.editBtn);
        } else
            holder = (ViewHolder) convertView.getTag();
        holder.txtTitle.setText(friend.getDisplayName());
        if (friend.getGender()) {
            holder.imageView.setImageResource(R.drawable.person_male);
        } else {
            holder.imageView.setImageResource(R.drawable.person_female);
        }


        holder.editBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "Edit button Clicked",
                        Toast.LENGTH_LONG).show();
                callback.gotoEdit(position);
            }
        });

        return convertView;
    }

    public void setCallback(EditUserCallback callback){
        this.callback = callback;
    }


    public interface EditUserCallback {
        public void gotoEdit(int position);
    }

}