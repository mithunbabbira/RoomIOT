package babbira.mithun.roomiot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button lightOn, lightOff, fanOn, fanOff;
    private jsonPlaceHolder jsonPlaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lightOn = findViewById(R.id.lightOnbtn);
        lightOff = findViewById(R.id.lightOffBtn);
        fanOn = findViewById(R.id.fanOnBtn);
        fanOff = findViewById(R.id.fanOffBtn);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://188.166.206.43/fa045324698e48bb9be8e4887a89973c/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        jsonPlaceHolder = retrofit.create(jsonPlaceHolder.class);

        fanOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action(1, "fan");

            }
        });

        fanOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action(0, "fan");

            }
        });

        lightOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action(0, "light");
            }
        });


        lightOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action(1, "light");
            }
        });

    }

    private void action(int trigger, String appliance) {
        Call<Integer> call = null;

        Log.d("TAG", "in");

        if (appliance.equals("light")) {
            call = jsonPlaceHolder.lights(trigger);

        } else if (appliance.equals("fan")) {
            call = jsonPlaceHolder.fan(trigger);
        }


        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {

            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {

            }
        });


    }
}