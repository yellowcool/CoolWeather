package test.collyellow.coolweather.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;


import com.android.databinding.library.baseAdapters.BR;

import java.util.List;

/**
 * Created by collyellow on 2016/12/16.
 */

public class WeatherBean extends BaseObservable {
    /**
     * daily : [{"code_day":"0","code_night":"4","date":"2016-12-16","high":"6","low":"-6","precip":"","text_day":"晴","text_night":"多云","wind_direction":"南","wind_direction_degree":"180","wind_scale":"2","wind_speed":"10"},{"code_day":"31","code_night":"31","date":"2016-12-17","high":"7","low":"-6","precip":"","text_day":"霾","text_night":"霾","wind_direction":"南","wind_direction_degree":"180","wind_scale":"2","wind_speed":"10"},{"code_day":"31","code_night":"31","date":"2016-12-18","high":"6","low":"-4","precip":"","text_day":"霾","text_night":"霾","wind_direction":"南","wind_direction_degree":"180","wind_scale":"2","wind_speed":"10"}]
     * last_update : 2016-12-16T08:00:00+08:00
     * location : {"country":"CN","id":"WX4FBXXFKE4F","name":"北京","path":"北京,北京,中国","timezone":"Asia/Shanghai","timezone_offset":"+08:00"}
     */

    private List<ResultsBean> results;

    @Bindable
    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
        notifyChange();
    }

    public static class ResultsBean extends BaseObservable {
        private String last_update = "66";
        /**
         * country : CN
         * id : WX4FBXXFKE4F
         * name : 北京
         * path : 北京,北京,中国
         * timezone : Asia/Shanghai
         * timezone_offset : +08:00
         */

        private LocationBean location;
        /**
         * code_day : 0
         * code_night : 4
         * date : 2016-12-16
         * high : 6
         * low : -6
         * precip :
         * text_day : 晴
         * text_night : 多云
         * wind_direction : 南
         * wind_direction_degree : 180
         * wind_scale : 2
         * wind_speed : 10
         */

        private List<DailyBean> daily;

        @Bindable
        public String getLast_update() {
            return last_update;
        }

        public void setLast_update(String last_update) {
            this.last_update = last_update;
            notifyChange();
        }

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        @Bindable
        public List<DailyBean> getDaily() {
            return daily;
        }

        public void setDaily(List<DailyBean> daily) {
            this.daily = daily;
            notifyChange();
        }

        public static class LocationBean {
            private String country;
            private String id;
            private String name;
            private String path;
            private String timezone;
            private String timezone_offset;

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public String getTimezone() {
                return timezone;
            }

            public void setTimezone(String timezone) {
                this.timezone = timezone;
            }

            public String getTimezone_offset() {
                return timezone_offset;
            }

            public void setTimezone_offset(String timezone_offset) {
                this.timezone_offset = timezone_offset;
            }
        }

        public static class DailyBean extends BaseObservable {
            private String code_day = "11";
            private String code_night;
            private String date;
            private String high;
            private String low;
            private String precip;
            private String text_day;
            private String text_night;
            private String wind_direction;
            private String wind_direction_degree;
            private String wind_scale;
            private String wind_speed;
            private String name = "aaa";

            public void setName(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            @Bindable
            public String getCode_day() {
                return code_day;
            }

            public void setCode_day(String code_day) {
                this.code_day = code_day;
               notifyPropertyChanged(BR.code_day);
            }

            @Bindable
            public String getCode_night() {
                return code_night;
            }

            public void setCode_night(String code_night) {
                this.code_night = code_night;
                notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.code_night);
            }

            @Bindable
            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
                notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.date);
            }

            @Bindable
            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
                notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.high);
            }

            @Bindable
            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
                notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.low);
            }

            @Bindable
            public String getPrecip() {
                return precip;
            }

            public void setPrecip(String precip) {
                this.precip = precip;
            }

            @Bindable
            public String getText_day() {
                return text_day;
            }

            public void setText_day(String text_day) {
                this.text_day = text_day;
                notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.text_day);
            }

            @Bindable
            public String getText_night() {
                return text_night;
            }

            public void setText_night(String text_night) {
                this.text_night = text_night;
                notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.text_night);
            }

            @Bindable
            public String getWind_direction() {
                return wind_direction;
            }

            public void setWind_direction(String wind_direction) {
                this.wind_direction = wind_direction;
                notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.wind_direction);
            }

            @Bindable
            public String getWind_direction_degree() {
                return wind_direction_degree;
            }

            public void setWind_direction_degree(String wind_direction_degree) {
                this.wind_direction_degree = wind_direction_degree;
                notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.wind_direction_degree);
            }

            @Bindable
            public String getWind_scale() {
                return wind_scale;
            }

            public void setWind_scale(String wind_scale) {
                this.wind_scale = wind_scale;
            }

            @Bindable
            public String getWind_speed() {
                return wind_speed;
            }

            public void setWind_speed(String wind_speed) {
                this.wind_speed = wind_speed;
                notifyPropertyChanged(com.android.databinding.library.baseAdapters.BR.wind_speed);
            }
        }
    }
}
