package com.example.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopupActivity extends Activity {
android.widget.ImageView ImageView;


    // 어답터
    private UserListAdapter adapter;
    // 리사이클러뷰
    private RecyclerView recyclerView;
    String sensorName;
    // 진행바
    ProgressDialog progressDoalog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_activity);

        //UI 객체생성
        TextView txtText = (TextView)findViewById(R.id.notice);


        //데이터 가져오기
        Intent intent = getIntent();
        sensorName = intent.getStringExtra("name");
        txtText.setText(sensorName +" DATA");


//리사이클러뷰
//        userList = findViewById(R.id.popupRecyclerview);
//        linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
//        adapter = new UserListAdapter(items);
//        userList.setLayoutManager(linearLayoutManager);
//        userList.setAdapter(adapter);



        generateDataList(MainActivity.getAlldataList());



    }

    //확인 버튼 클릭
    public void mOnClose(View v){
        //데이터 전달하기
        Intent intent = new Intent();
        intent.putExtra("result", "Close Popup");
        setResult(RESULT_OK, intent);

        //액티비티(팝업) 닫기
        finish();
    }
    // 리사이클러뷰
    private void generateDataList(List<UserInfo1> photoList) {
        try {
            recyclerView = findViewById(R.id.popupRecyclerview);
            adapter = new UserListAdapter(this, photoList,sensorName);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PopupActivity.this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }catch (Exception e){
            Log.i("gello", " "+e);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }
}
