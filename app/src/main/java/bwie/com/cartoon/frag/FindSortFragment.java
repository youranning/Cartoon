package bwie.com.cartoon.frag;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.support.v4.view.ViewPager;

import bwie.com.cartoon.R;

public class FindSortFragment extends Fragment  {

    private RadioGroup findGroup;
    private RadioButton findAll;
    private RadioButton findTwo;
    private RadioButton findThree;
    private RadioButton findFour;
    private RadioButton findFive;
    private RadioButton findSix;
    private RadioButton findSeven;
    private RadioButton findEight;
    private RadioButton findNine;
    private RadioButton findTen;
    private RadioButton findEleven;
    private RadioButton findTwelve;
    private ViewPager first;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.findsort, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findGroup = (RadioGroup) view.findViewById(R.id.find_group);
        findAll = (RadioButton) view.findViewById(R.id.find_all);
        findTwo = (RadioButton) view.findViewById(R.id.find_two);
        findThree = (RadioButton) view.findViewById(R.id.find_three);
        findFour = (RadioButton) view.findViewById(R.id.find_four);
        findFive = (RadioButton) view.findViewById(R.id.find_five);
        findSix = (RadioButton) view.findViewById(R.id.find_six);
        findSeven = (RadioButton) view.findViewById(R.id.find_seven);
        findEight = (RadioButton) view.findViewById(R.id.find_eight);
        findNine = (RadioButton) view.findViewById(R.id.find_nine);
        findTen = (RadioButton) view.findViewById(R.id.find_ten);
        findEleven = (RadioButton) view.findViewById(R.id.find_eleven);
        findTwelve = (RadioButton) view.findViewById(R.id.find_twelve);
        first = (ViewPager) view.findViewById(R.id.find_first);
    }

}
