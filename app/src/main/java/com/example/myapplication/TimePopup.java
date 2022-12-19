package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TimePopup extends Activity {
    android.widget.ImageView ImageView;

    //리싸이클러뷰
    RecyclerView userList;
    LinearLayoutManager linearLayoutManager;
    UserListAdapter3 adapter;
    ArrayList<UserInfo3> items = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.time_popup);



        findViewById(R.id.dateButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnClose(view,"ok");

            }
        });

        findViewById(R.id.alldatautton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnClose(view,"no");
            }
        });




    }

    public void mOnClose(View v,String okdata){
        //데이터 전달하기
        Intent intent = new Intent();
        intent.putExtra("okdata", okdata);
        setResult(RESULT_OK, intent);

        //액티비티(팝업) 닫기
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }


}
