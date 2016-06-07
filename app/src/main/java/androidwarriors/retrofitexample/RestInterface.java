package androidwarriors.retrofitexample;

import androidwarriors.retrofitexample.POJO.Model;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by kundan on 8/8/2015.
 */
public interface RestInterface {

    @GET("/weather?id=1580578&APPID=f3f8edc7a83cd938deace3c2bbfcbb0c")
    //@GET("/24.json?limit=10&api-key=ffd170d7fe4246c69413fb97a1b0ce05")

    void getWheatherReport(Callback<Model>cb);

}
