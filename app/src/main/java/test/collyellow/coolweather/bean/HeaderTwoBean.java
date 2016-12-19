package test.collyellow.coolweather.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.Color;

import com.android.databinding.library.baseAdapters.BR;

import java.util.ArrayList;

import im.dacer.androidcharts.LineView;


/**
 * Created by collyellow on 2016/12/19.
 */

public class HeaderTwoBean extends BaseObservable {

    private ArrayList<ArrayList<Integer>> dataLists = new ArrayList<ArrayList<Integer>>();

    @Bindable
    public boolean getShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
        notifyPropertyChanged(BR.show);
    }

    private boolean show = true;

    @Bindable
    public ArrayList<ArrayList<Integer>> getDataLists() {
        return dataLists;
    }

    public void setDataLists(ArrayList<ArrayList<Integer>> dataLists) {
        this.dataLists = dataLists;
        notifyPropertyChanged(BR.dataLists);
    }

    private ArrayList<String> test = new ArrayList<String>();
    private int[] colorArray = new int[]{
            Color.parseColor("#ff0000"), Color.parseColor("#00ff00"), Color.parseColor("#0000ff"), Color.parseColor("#ffff00")};
    private boolean drawDotLine = true;
    private int showPopup = LineView.SHOW_POPUPS_NONE;

    public HeaderTwoBean() {
        for (int i = 0; i < 9; i++) {
            test.add(String.valueOf(i + 1));
        }
        ArrayList<Integer> dataList = new ArrayList<Integer>();
        int random = (int) (Math.random() * 9 + 1);
        for (int i = 0; i < 9; i++) {
            dataList.add((int) (Math.random() * random));
        }

        ArrayList<Integer> dataList2 = new ArrayList<Integer>();
        random = (int) (Math.random() * 9 + 1);
        for (int i = 0; i < 9; i++) {
            dataList2.add((int) (Math.random() * random));
        }

        ArrayList<Integer> dataList3 = new ArrayList<Integer>();
        random = (int) (Math.random() * 9 + 1);
        for (int i = 0; i < 9; i++) {
            dataList3.add((int) (Math.random() * random));
        }

        dataLists.add(dataList);
        dataLists.add(dataList2);
        dataLists.add(dataList3);
    }

    @Bindable
    public ArrayList<String> getTest() {
        return test;
    }

    public void setTest(ArrayList<String> test) {
        this.test = test;
        notifyPropertyChanged(BR.test);
    }

    @Bindable
    public int[] getColorArray() {
        return colorArray;
    }

    public void setColorArray(int[] colorArray) {
        this.colorArray = colorArray;
        notifyPropertyChanged(BR.colorArray);
    }

    @Bindable
    public boolean getDrawDotLine() {
        return drawDotLine;
    }

    public void setDrawDotLine(boolean drawDotLine) {
        this.drawDotLine = drawDotLine;
        notifyPropertyChanged(BR.drawDotLine);
    }

    @Bindable
    public int getShowPopup() {
        return showPopup;
    }

    public void setShowPopup(int showPopup) {
        this.showPopup = showPopup;
        notifyPropertyChanged(BR.showPopup);
    }

}
