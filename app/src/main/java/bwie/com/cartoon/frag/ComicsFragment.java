package bwie.com.cartoon.frag;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.support.v4.view.ViewPager;
import android.widget.RelativeLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import bwie.com.cartoon.R;
import bwie.com.cartoon.util.MyEventBus;

public class ComicsFragment extends Fragment implements View.OnClickListener {

    private RadioGroup group;
    private RadioButton attention;
    private RadioButton hot;
    private ViewPager comicVp;
    private RelativeLayout layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.comics, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layout = (RelativeLayout) view.findViewById(R.id.comic_relativelayout);
        group = (RadioGroup) view.findViewById(R.id.group);
        attention = (RadioButton) view.findViewById(R.id.attention);
        hot = (RadioButton) view.findViewById(R.id.hot);

        view.findViewById(R.id.seek).setOnClickListener(this);
        comicVp = (ViewPager) view.findViewById(R.id.comic_vp);
        setPageadaptr();

    }

    private void setPageadaptr() {

        comicVp.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            Fragment fragment = null;

            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        fragment = new LoginFragment();
                        break;
                    case 1:
                        fragment = new Animation();

                        break;
                }

                return fragment;
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return super.getPageTitle(position);
            }
        });
        comicVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position) {
                    case 0:
                      attention.setChecked(true);
                        attention.setTextColor(Color.BLACK);
                        hot.setTextColor(Color.YELLOW);
                        break;

                    case 1:
                        hot.setChecked(true);
                        attention.setTextColor(Color.YELLOW);
                        hot.setTextColor(Color.BLACK);
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        attention.setOnClickListener(this);
        hot.setOnClickListener(this);
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN , sticky = false)
public void onMyEventBus(MyEventBus bus){
    if (bus.isResult()){
        Log.e("----------------",bus.isResult()+"");
    }else {
        Log.e("---------------",bus.isResult()+"");

    }

}
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.seek:
                break;
            case R.id.attention:
                attention.setTextColor(Color.BLACK);
                hot.setTextColor(Color.YELLOW);
                comicVp.setCurrentItem(0);

                break;
            case R.id.hot:
                Log.e("",hot.isChecked()+"");
                attention.setTextColor(Color.YELLOW);
                hot.setTextColor(Color.BLACK);
                comicVp.setCurrentItem(1);
                break;
        }
    }
}
