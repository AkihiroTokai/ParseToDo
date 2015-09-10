package com.example.owner.todo;

import android.app.Application;
import android.content.Context;
import android.support.v4.widget.CompoundButtonCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Created by OWNER on 2015/09/09.
 */
public class TaskAdapter extends ArrayAdapter<Task>
        implements CompoundButton.OnCheckedChangeListener {

    private int mResourceId;
    private LayoutInflater mInflator;

    public TaskAdapter(Context context, int resource, List<Task> objects) {
        super(context, resource, objects);
        mInflator = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mResourceId = resource;
    }

    @Override
    public View getView(int position ,View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = mInflator.inflate(mResourceId, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        } else {
           viewHolder = (ViewHolder)  convertView.getTag();
        }
        Task task = getItem(position);

        viewHolder.checkBox.setText(task.getTitle());
        viewHolder.checkBox.setOnCheckedChangeListener(null);
        viewHolder.checkBox.setChecked(task.isCheck());
        viewHolder.checkBox.setOnCheckedChangeListener(this);
        viewHolder.checkBox.setTag(task);

        return convertView;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
        Task task = (Task) buttonView.getTag();
        task.setCheck(isChecked);
        task.saveInBackground();
    }

    public class ViewHolder{
        CheckBox checkBox;
        public ViewHolder (View view){
            checkBox = (CheckBox)view.findViewById(R.id.checkBox);
        }
    }
}
