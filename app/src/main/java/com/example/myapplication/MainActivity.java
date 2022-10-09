package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private EditText nameEdt, jobEdt;
    private Button postDataBtn;
    private ProgressBar loadingPB;
    private TextView responseTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
    }
    private void initViews(){
        nameEdt = findViewById(R.id.idEdtName);
        jobEdt = findViewById(R.id.idEdtJob);
        postDataBtn = findViewById(R.id.idBtnPost);
        loadingPB = findViewById(R.id.idLoadingPB);
        responseTV = findViewById(R.id.idTVResponse);
    }

    private void initListeners(){
        postDataBtn.setOnClickListener(view -> {
            if(nameEdt.getText().toString().isEmpty() || jobEdt.getText().toString().isEmpty()){
                Toast.makeText(this, "Invalid Form", Toast.LENGTH_SHORT).show();
            }else{
                postData(nameEdt.getText().toString(), jobEdt.getText().toString());
            }
        });
    }

    private void postData(String name, String job) {
        loadingPB.setVisibility(View.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitApiInterface retrofitApiInterface = retrofit.create(RetrofitApiInterface.class);
        FormRequest formRequest = new FormRequest(name, job);
        Call<FormRequest> call = retrofitApiInterface.registerUser(formRequest);
        call.enqueue(new Callback<FormRequest>() {
            @Override
            public void onResponse(Call<FormRequest> call, Response<FormRequest> response) {
                Toast.makeText(MainActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();
                loadingPB.setVisibility(View.GONE);
                jobEdt.setText("");
                nameEdt.setText("");
                FormRequest responseFromAPI = response.body();
                String responseString = "Response Code : " + response.code() + "\nName : " + responseFromAPI.getName() + "\n" + "Job : " + responseFromAPI.getJob();
                responseTV.setText(responseString);
            }

            @Override
            public void onFailure(Call<FormRequest> call, Throwable t) {
                loadingPB.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Network Error occurred", Toast.LENGTH_SHORT).show();
            }
        });
    }
}