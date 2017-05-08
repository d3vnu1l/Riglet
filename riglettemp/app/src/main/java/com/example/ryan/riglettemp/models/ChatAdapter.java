package com.example.ryan.riglettemp.models;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ryan.riglettemp.R;
import com.example.ryan.riglettemp.models.Message;

import java.util.ArrayList;
import java.util.List;

public class ChatAdapter extends ArrayAdapter<Message> {
    ArrayList<Message> list;
    private Context context;

    public ChatAdapter(Context context, ArrayList<Message> messages) {
        super(context, R.layout.chatbubble_left, messages);
        this.list=messages;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message tempmes = getItem(position);            // Get the data item for this position

        ViewHolder viewHolder; // view lookup cache stored in tag
        viewHolder = new ViewHolder();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        if(list.get(position).getIsme()) {
            convertView = inflater.inflate(R.layout.chatbubble_right, parent, false);
        }
        else{
            convertView = inflater.inflate(R.layout.chatbubble_left, parent, false);
        }
        viewHolder.txt_msg = (TextView) convertView.findViewById(R.id.txt_msg);
        // Cache the viewHolder object inside the fresh view
        convertView.setTag(viewHolder);
        // Populate the data from the data object via the viewHolder object
        // into the template view.
        viewHolder.txt_msg.setText(tempmes.getMessage());
        // Return the completed view to render on screen
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        // return the total number of view types. this value should never change
        // at runtime. Value 2 is returned because of left and right views.
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        // return a value between 0 and (getViewTypeCount - 1)
        return position % 2;
    }

    private static class ViewHolder {
        TextView txt_msg;
    }
}