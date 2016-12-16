package test.collyellow.coolweather.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import test.collyellow.coolweather.bean.WeatherBean;

/**
 * Created by collyellow on 2016/12/16.
 */

public interface RetrofitService {
    @GET("daily.json")
    Call<WeatherBean> getSearchBooks(@Query("key") String key,
                                     @Query("location") String location,
                                     @Query("language") String language,
                                     @Query("unit") String unit,
                                     @Query("start") int start,
                                     @Query("days") int days);
}
