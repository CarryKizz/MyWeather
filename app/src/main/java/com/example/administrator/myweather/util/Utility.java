package com.example.administrator.myweather.util;

import android.text.TextUtils;

import com.example.administrator.myweather.db.City;
import com.example.administrator.myweather.db.County;
import com.example.administrator.myweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/3/18.
 */
public class Utility {
    //获取省级数据
    public static  Boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province pr = new Province();
                    pr.setProvinceCode(provinceObject.getInt("id"));
                    pr.setProvinceName(provinceObject.getString("name"));
                    pr.save();
                }
                return  true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return  false;
    }
    //获取市级数据
    public  static  boolean handleCityResponse(String response,int provinceId){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray  allCities = new JSONArray(response);
                for (int i=0;i<allCities.length();i++){
                    JSONObject cityOb  = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityCode(cityOb.getInt("id"));
                    city.setCityName(cityOb.getString("name"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return  true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    //获取县级数据
    public static  boolean  handleCountyResponse(String response,int cityId){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounties = new JSONArray(response);
                for (int i=0;i<allCounties.length();i++){
                    JSONObject countyJo=allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyJo.getString("name"));
                    county.setWeatherId(countyJo.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return  true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
