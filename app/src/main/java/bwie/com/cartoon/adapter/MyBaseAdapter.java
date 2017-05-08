package bwie.com.cartoon.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import bwie.com.cartoon.R;
import bwie.com.cartoon.bean.Week;

/**
 * Created by $USER_NAME on 2017/4/24.
 */

public class MyBaseAdapter extends BaseAdapter {
    Context context;
    List<Week.DataBean.ComicsBean> list;

    public MyBaseAdapter(Context context, List<Week.DataBean.ComicsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list != null ? list.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.bu, null);
            viewHolder.bu_tv1 = (TextView) convertView.findViewById(R.id.bu_tv1);
            viewHolder.bu_tv2 = (TextView) convertView.findViewById(R.id.bu_tv2);
            viewHolder.bu_tv3 = (TextView) convertView.findViewById(R.id.bu_tv3);
            viewHolder.bu_tv4 = (TextView) convertView.findViewById(R.id.bu_tv4);
            viewHolder.bu_tv5 = (TextView) convertView.findViewById(R.id.bu_tv5);
            viewHolder.bu_b = (TextView) convertView.findViewById(R.id.bu_b);
            viewHolder.iv = (ImageView) convertView.findViewById(R.id.bu_iv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.bu_tv1.setText(list.get(position).getLabel_text());
        viewHolder.bu_tv2.setText(list.get(position).getTopic().getTitle());
        viewHolder.bu_tv3.setText(list.get(position).getTitle());
//        viewHolder.bu_tv4.setText(list.get(position).getLabel_text());
//        viewHolder.bu_tv5.setText(list.get(position).getLabel_text());
        ImageLoader.getInstance().displayImage(list.get(position).getCover_image_url(),viewHolder.iv);
        return convertView;
    }


    class ViewHolder {
        TextView bu_tv1;
        TextView bu_tv2;
        TextView bu_b;
        ImageView iv;
        TextView bu_tv3;
        TextView bu_tv4;
        TextView bu_tv5;

    }
}
