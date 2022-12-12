package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{



    private FragmentManager fragmentManager;
    private test test;

    private FragmentTransaction transaction;


    TextView txtText;
    //리싸이클러뷰
    RecyclerView userList;
    LinearLayoutManager linearLayoutManager;
    UserListAdapter1 adapter;
    ArrayList<UserInfo1> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new test();

        fragmentManager = getSupportFragmentManager();

        test = new test();

        transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.bar_chart_frameLayout, test).commitAllowingStateLoss();




        userList = findViewById(R.id.recyclerviewList);
        linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        adapter = new UserListAdapter1(items);
        userList.setLayoutManager(linearLayoutManager);
        userList.setAdapter(adapter);
        //리싸이클러뷰 데이터
        {
            items.add(new UserInfo1(
                    "22.12.08",
                    "20:44",
                    "30",
                    "6.8",
                    "300",
                    "700"
            ));
            items.add(new UserInfo1(
                    "22.12.08",
                    "20:44",
                    "30",
                    "6.8",
                    "300",
                    "700"
            ));items.add(new UserInfo1(
                "22.12.08",
                "20:44",
                "30",
                "6.8",
                "300",
                "700"
        ));items.add(new UserInfo1(
                "22.12.08",
                "20:44",
                "30",
                "6.8",
                "300",
                "700"
        ));
            items.add(new UserInfo1(
                    "22.12.08",
                    "20:44",
                    "30",
                    "6.8",
                    "300",
                    "700"
            ));items.add(new UserInfo1(
                "22.12.08",
                "20:44",
                "30",
                "6.8",
                "300",
                "700"
        ));items.add(new UserInfo1(
                "22.12.08",
                "20:44",
                "30",
                "6.8",
                "300",
                "700"
        ));
            items.add(new UserInfo1(
                    "22.12.08",
                    "20:44",
                    "30",
                    "6.8",
                    "300",
                    "700"
            ));items.add(new UserInfo1(
                "22.12.08",
                "20:44",
                "30",
                "6.8",
                "300",
                "700"
        ));items.add(new UserInfo1(
                "22.12.08",
                "20:44",
                "30",
                "6.8",
                "300",
                "700"
        ));items.add(new UserInfo1(
                "22.12.08",
                "20:44",
                "30",
                "6.8",
                "300",
                "700"
        ));items.add(new UserInfo1(
                "22.12.08",
                "20:44",
                "30",
                "6.8",
                "300",
                "700"
        ));

        }




        findViewById(R.id.temper).setOnClickListener(this);
        findViewById(R.id.fishbowl).setOnClickListener(this);
        findViewById(R.id.light).setOnClickListener(this);
        findViewById(R.id.ph).setOnClickListener(this);

        findViewById(R.id.temperstatus).setOnClickListener(this);
        findViewById(R.id.fishbowlStatus).setOnClickListener(this);
        findViewById(R.id.lightStatus).setOnClickListener(this);
        findViewById(R.id.PHStatus).setOnClickListener(this);


    }




    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.temper:
                mOnPopupClick(view);
                break;

            case R.id.fishbowl:
                mOnPopupClick(view);
                break;
            case R.id.light:
                mOnPopupClick(view);
                break;
            case R.id.ph:
                mOnPopupClick(view);
                break;

            case R.id.temperstatus:
                mOnLogPopupClick(view);
                break;
            case R.id.fishbowlStatus:
                mOnLogPopupClick(view);
                break;
            case R.id.lightStatus:
                mOnLogPopupClick(view);
                break;
            case R.id.PHStatus:
                mOnLogPopupClick(view);
                break;

        }
    }



    //버튼
    public void mOnPopupClick(View v){
        //데이터 담아서 팝업(액티비티) 호출
        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("data", "Test Popup");
        startActivityForResult(intent, 1);
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

    //버튼
    public void mOnLogPopupClick(View v){
        //데이터 담아서 팝업(액티비티) 호출
        Intent intent = new Intent(this, LogPopupActivity.class);
        intent.putExtra("data", "Test Popup");
        startActivityForResult(intent, 1);
    }


}