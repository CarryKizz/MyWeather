package com.example.administrator.myweather;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.myweather.db.City;
import com.example.administrator.myweather.db.County;
import com.example.administrator.myweather.db.Province;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/18.
 */
public class choseAreaFragment extends Fragment{
    public static  final  int LEVEL_PROVINCE = 0 ;
    public static final  int LEVEL_CITY = 1;
    public static final int LEVEL_COUNTY = 2;
    private ProgressDialog  progressDialog ;
    private TextView textView;
    private ListView listView ;
    private Button backButton ;
    private ArrayAdapter<String> adapter;
    private List<String> dataList = new ArrayList<>();
    //省列表
    private  List<Province>  provinceList ;
    private  List<City>  cityList;
    private  List<County> countyList;
    private Province selectProvince ;
    private City selectCity;
    //当前选中类别
    private int currentLevel;

}
