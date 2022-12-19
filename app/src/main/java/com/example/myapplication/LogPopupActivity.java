package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONObject;

import java.text.BreakIterator;
import java.util.ArrayList;

public class LogPopupActivity extends Activity {
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
        setContentView(R.layout.log_popup_activity);

        //UI 객체생성
//        txtText = (TextView)findViewById(R.id.txtText);

        //데이터 가져오기
        Intent intent = getIntent();
        String data = intent.getStringExtra("name");
        TextView txtText =(TextView)findViewById(R.id.Textview_LOG);
        txtText.setText(data+" LOG DATA");


//리사이클러뷰
        userList = findViewById(R.id.logRecyclerview);
        linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        adapter = new UserListAdapter3(items);
        userList.setLayoutManager(linearLayoutManager);
        userList.setAdapter(adapter);

        {
            items.add(new UserInfo3(
                    "12.09",
                    "dsadsadasdasdasdasdasdaddadssad"
            ));
            items.add(new UserInfo3(
                    "12.09",
                    "dsadsadasdasdasdasdasdaddadssad"
            ));items.add(new UserInfo3(
                "12.09",
                "dsadsadasdasdasdasdasdaddadssad"
        ));items.add(new UserInfo3(
                "12.09",
                "dsadsadasdasdasdasdasdaddadssad"
        ));items.add(new UserInfo3(
                "12.09",
                "dsadsadasdasdasdasdasdaddadssad"
        ));items.add(new UserInfo3(
                "12.09",
                "dsadsadasdasdasdasdasdaddadssad"
        ));items.add(new UserInfo3(
                "12.09",
                "dsadsadasdasdasdasdasdaddadssad"
        ));

        }

    }

    //확인 버튼 클릭
    public void mOnClose(View v){
        //데이터 전달하기
        Intent intent = new Intent();
//        intent.putExtra("result", "Close Popup");
//        setResult(RESULT_OK, intent);

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

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }
}
