package androidwarriors.retrofitexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidwarriors.retrofitexample.POJO.Model;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    TextView city, status, humidity, pressure;
    Button material,temp;
    String url = "http://api.openweathermap.org/data/2.5";
    //String url = "api.openweathermap.org/data/2.5/forecast/city?id=1580578&APPID=f3f8edc7a83cd938deace3c2bbfcbb0c";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = (TextView) findViewById(R.id.txt_city);
        status = (TextView) findViewById(R.id.txt_status);
        humidity = (TextView) findViewById(R.id.txt_humidity);
        pressure = (TextView) findViewById(R.id.txt_press);
        material = (Button) findViewById(R.id.material);
        temp = (Button) findViewById(R.id.button);
        material.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
            }
        });

        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "temp", Toast.LENGTH_LONG).show();
            }
        });

        //making object of RestAdapter
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(url).build();

        //Log.d("ket qua",adapter.);
        //Creating Rest Services
        RestInterface restInterface = adapter.create(RestInterface.class);

        //Calling method to get whether report
        restInterface.getWheatherReport(new Callback<Model>() {
            @Override
            public void success(Model model, Response response) {
                Log.d("data",model.getName());
                city.setText("city :"+model.getName());
                status.setText("Status :"+model.getWeather().get(0).getDescription());
                humidity.setText("humidity :"+model.getMain().getHumidity().toString());
                pressure.setText("pressure :"+model.getMain().getPressure().toString());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("fail","fail");
                String merror = error.getMessage();
            }
        });

    }


}
