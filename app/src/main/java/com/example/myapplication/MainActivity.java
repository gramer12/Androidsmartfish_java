package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{


    //차트 프래그먼트
    private FragmentManager fragmentManager;
    private test test;
    private FragmentTransaction transaction;



    // 어답터
    private UserListAdapter1 adapter;
    // 리사이클러뷰
    private RecyclerView recyclerView;
    // 진행바
    ProgressDialog progressDoalog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new test();
        fragmentManager = getSupportFragmentManager();
        test = new test();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.bar_chart_frameLayout, test).commitAllowingStateLoss();



        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();



        // 레트로핏 인스턴스 생성을 해줍니다.
        // enqueue로 비동기 통신을 싱행합니다.
        Retrofit_interface service = retrofit_client.getRetrofitInstance().create(Retrofit_interface.class);
        Call<List<UserInfo1>> call = service.getAllPhotos();
        //통신완료후 이벤트 처리를 위한 콜백 리스너 등록
        call.enqueue(new Callback<List<UserInfo1>>() {
            // 정상으로 통신 성공시
            @Override
            public void onResponse(Call<List<UserInfo1>> call, Response<List<UserInfo1>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
            }
            // 통신 실패시(예외발생, 인터넷끊김 등의 이유)
            @Override
            public void onFailure(Call<List<UserInfo1>> call, Throwable t) {
                progressDoalog.dismiss();
                System.out.println(t);
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

            }
        });





        //버튼 리스너
        {
        //사진 버튼
        findViewById(R.id.temper).setOnClickListener(this);
        findViewById(R.id.fishbowl).setOnClickListener(this);
        findViewById(R.id.light).setOnClickListener(this);
        findViewById(R.id.ph).setOnClickListener(this);

        //상태 버튼
        findViewById(R.id.temperstatus).setOnClickListener(this);
        findViewById(R.id.fishbowlStatus).setOnClickListener(this);
        findViewById(R.id.lightStatus).setOnClickListener(this);
        findViewById(R.id.PHStatus).setOnClickListener(this);
        }

    }


    // 리사이클러뷰
    private void generateDataList(List<UserInfo1> photoList) {
        recyclerView = findViewById(R.id.recyclerviewList);
        adapter = new UserListAdapter1(this, photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.temper:
                mOnPopupClick(view,PopupActivity.class,"temper");
                break;

            case R.id.fishbowl:
                mOnPopupClick(view,PopupActivity.class,"fishbowl");
                break;
            case R.id.light:
                mOnPopupClick(view,PopupActivity.class,"light");
                break;
            case R.id.ph:
                mOnPopupClick(view,PopupActivity.class,"ph");
                break;

            case R.id.temperstatus:
                mOnPopupClick(view,LogPopupActivity.class,"temperstatus");
                break;
            case R.id.fishbowlStatus:
                mOnPopupClick(view,LogPopupActivity.class,"fishbowlStatus");
                break;
            case R.id.lightStatus:
                mOnPopupClick(view,LogPopupActivity.class,"lightStatus");
                break;
            case R.id.PHStatus:
                mOnPopupClick(view,LogPopupActivity.class,"PHStatus");
                break;

        }
    }



    //버튼
    public void mOnPopupClick(View v, Class<? extends Activity> context,String name){
        //데이터 담아서 팝업(액티비티) 호출

        Intent intent = new Intent(this, context);
//        intent.putExtra("data", "Test Popup");
        intent.putExtra("name", name);
        startActivity(intent);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                String result = data.getStringExtra("result");
//                txtResult.setText(result);
            }
        }
    }



}