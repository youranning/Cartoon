package bwie.com.cartoon;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

import bwie.com.cartoon.frag.Animation;
import bwie.com.cartoon.frag.ComicsFragment;
import bwie.com.cartoon.frag.FindFragment;
import bwie.com.cartoon.frag.MyFragment;
import bwie.com.cartoon.frag.VFragment;

public class Main extends FragmentActivity implements  View.OnClickListener {

    private FragmentManager manager;
    private MyFragment my;
    private VFragment v;
    private FindFragment find;
    private ComicsFragment animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initView();
        manager = getSupportFragmentManager();
        animation = (ComicsFragment) manager.findFragmentById(R.id.one);
        find = (FindFragment) manager.findFragmentById(R.id.two);
        v = (VFragment) manager.findFragmentById(R.id.three);
        my = (MyFragment) manager.findFragmentById(R.id.four);
        manager.beginTransaction().hide(find).hide(v).hide(my).show(animation).commit();

    }

    private void initView() {

        findViewById(R.id.rg1).setOnClickListener(this);
        findViewById(R.id.rg2).setOnClickListener(this);
        findViewById(R.id.rg3).setOnClickListener(this);
        findViewById(R.id.rg4).setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rg1:
                Log.e("","-----------------------");
                manager.beginTransaction().hide(find).hide(v).hide(my).show(animation).commit();
                break;
            case R.id.rg2:
                manager.beginTransaction().hide(animation).hide(v).hide(my).show(find).commit();

                break;
            case R.id.rg3:
                manager.beginTransaction().hide(find).hide(animation).hide(my).show(v).commit();

                break;
            case R.id.rg4:
                manager.beginTransaction().hide(find).hide(v).hide(animation).show(my).commit();

                break;

        }
    }
}
