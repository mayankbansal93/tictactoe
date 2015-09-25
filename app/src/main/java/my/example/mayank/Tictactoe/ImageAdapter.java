package my.example.mayank.Tictactoe;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.mayank.Tictactoe.R;

/**
 * Created by mayank on 1/9/15.
 */
public class ImageAdapter extends BaseAdapter {


    @Override
    public int getCount() {
        return 9;
    }
    Context c;
    public ImageAdapter(Context c){
        this.c=c;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView iv;
        if(view==null){
            iv = new ImageView(c);
        } else {
            iv = (ImageView) view;
        }
        GridView.LayoutParams lp=new GridView.LayoutParams(320,320);
        iv.setLayoutParams(lp);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        iv.setImageResource(R.drawable.white);
        return iv;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }
}




