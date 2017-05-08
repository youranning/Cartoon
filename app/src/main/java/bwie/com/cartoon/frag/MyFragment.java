package bwie.com.cartoon.frag;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import bwie.com.cartoon.IApplication;
import bwie.com.cartoon.R;


public class MyFragment extends Fragment  {


    private ImageView iv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iv = (ImageView) view.findViewById(R.id.my_iv);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageLoader.getInstance().displayImage("http://www.93.gov.cn/11002/upload/webcms/content/image/2017/04/28/14_48_55_934_38206_cl1fb.jpg",iv, IApplication.MyDisplayImageOptions());
    }
}
