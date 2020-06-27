package com.example.internetshopping;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {
    private ListView mListView;
    private  String[] titles = {"苹果","香蕉","梨子","火龙果","猕猴桃","桃子"};
    private  String[] prices = {"10元/kg","8元/kg","7元/kg","15元/kg","10元/kg","11元/kg"};

    private int[] icons = {R.drawable.apple,R.drawable.banana,R.drawable.pear,R.drawable.pitaya,R.drawable.kiwifruit,R.drawable.peach};

    protected  void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        mListView=(ListView)findViewById(R.id.lv);

        MyBaseAdaPter mAdapter = new MyBaseAdaPter();

        mListView.setAdapter(mAdapter);
    }
    class MyBaseAdaPter extends  BaseAdapter{
        @Override
        public int getCount( ){
            return  titles.length;
        }
        @Override
        public Object getItem(int position){
            return titles[position];
        }
        @Override
        public long getItemId(int position){
            return  position;
        }
        @Override
        public View getView(int position,View convertView,ViewGroup parent){
            ViewHolder holder =null;
            if(convertView == null){
                convertView = View.inflate( MainActivity.this,R.layout.list_item,null);
                holder= new ViewHolder();
                holder.title=(TextView) convertView.findViewById(R.id.title);
                holder.price=(TextView) convertView.findViewById(R.id.price);
                holder.iv=(ImageView) convertView.findViewById(R.id.iv);
                convertView.setTag(holder);
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.title.setText(titles[position]);
            holder.price.setText(prices[position]);
            holder.iv.setBackgroundResource(icons[position]);
            return  convertView;
        }
    }
    static class ViewHolder{
        TextView title;
        TextView price;
        ImageView iv;
    }
}
