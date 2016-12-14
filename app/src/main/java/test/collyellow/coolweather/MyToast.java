package test.collyellow.coolweather;

import android.widget.Toast;

/**
 * Created by collyellow on 2016/12/14.
 */

public class MyToast {
    private static Toast  mToast;
   public static void show(String msg){
       if (mToast==null){
           mToast = Toast.makeText(App.context,msg,Toast.LENGTH_SHORT);
       }
       mToast.setText(msg);
       mToast.show();
   }
}
