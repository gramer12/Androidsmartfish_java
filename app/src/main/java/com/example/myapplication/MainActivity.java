package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Adapter_Folder.AllDataListAdapter;
import com.example.myapplication.Data_Folder.AlldataList;
import com.example.myapplication.Fragment.BarChart;
import com.example.myapplication.Fragment.DatePickerFragment;
import com.example.myapplication.Retrofit_Folder.Retrofit_interface;
import com.example.myapplication.Retrofit_Folder.retrofit_client;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    //차트 프래그먼트
    private FragmentManager fragmentManager;
    private com.example.myapplication.Fragment.BarChart BarChart;
    private FragmentTransaction transaction;
    static List<AlldataList> alldataList;

    static List<AlldataList> selectDataList=new ArrayList<>();

    public static List<AlldataList> getSelectDataList() {
        return selectDataList;
    }

    //타이머 코드
    private Timer timerCall;
    private int nCnt;

    static public List<AlldataList> getAlldataList() {
        return alldataList;
    }

    public void setAlldataList(List<AlldataList> alldataList) {
        this.alldataList = alldataList;
    }


    //선택 날자
    private String dateMessage;

    // 어답터
    private AllDataListAdapter adapter;
    // 리사이클러뷰
    private RecyclerView recyclerView;
    // 진행바
    ProgressDialog progressDoalog;

    TimerTask timerTask;


    private TextView timeTextView;
    private Boolean isBlack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new BarChart();
        fragmentManager = getSupportFragmentManager();
        BarChart = new BarChart();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.bar_chart_frameLayout, BarChart).commitAllowingStateLoss();


        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();


        // 레트로핏 인스턴스 생성을 해줍니다.
        // enqueue로 비동기 통신을 싱행합니다.
        Retrofit_interface service = retrofit_client.getRetrofitInstance().create(Retrofit_interface.class);
        Call<List<AlldataList>> call = service.getAllPhotos();
        //통신완료후 이벤트 처리를 위한 콜백 리스너 등록


        nCnt = 0;

        timerTask = new TimerTask() {
            @Override
            public void run() {
//                someWork();//타이머 켄슬

                call.clone().enqueue(new Callback<List<AlldataList>>() {
                    // 정상으로 통신 성공시
                    @Override
                    public void onResponse(Call<List<AlldataList>> call, Response<List<AlldataList>> response) {
                        progressDoalog.dismiss();
                        setAlldataList(response.body());

                        if(nCnt==0)
                            selectDataList=alldataList;
                        nCnt++;
                        generateDataList(selectDataList);

                    }

                    // 통신 실패시(예외발생, 인터넷끊김 등의 이유)
                    @Override
                    public void onFailure(Call<List<AlldataList>> call, Throwable t) {
                        progressDoalog.dismiss();
                        System.out.println(t);
                        Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                    }
                });
                Log.e("new","newenwewn");

            }
        };

        timerCall = new Timer();
        //몇초 후 실행 delay
        //period 주기마다
        timerCall.schedule(timerTask, 0, 10 * 1000);


        isBlack = true;



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

            //달력버튼?

            findViewById(R.id.btn_TimeText).setOnClickListener(this);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();


    }



    //달력
    public void showDatePicker() {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");

    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        this.dateMessage = (year_string + "-" + month_string + "-" + day_string);
        Log.e("a",""+dateMessage);
        Toast.makeText(this, "Date: " + dateMessage, Toast.LENGTH_SHORT).show();

        selectDataList=new ArrayList<>();
        try {
            for (int i = 0; i < alldataList.size()-1; i++) {
                if (alldataList.get(i).getDate().equals(dateMessage)) {

                    selectDataList.add(alldataList.get(i));

                }


            }

                    generateDataList(selectDataList);
        } catch (Exception e) {
            Log.e("dd", e + "");
        }
    }

    // 리사이클러뷰
    private void generateDataList(List<AlldataList> photoList) {
        recyclerView = findViewById(R.id.recyclerviewList);
        adapter = new AllDataListAdapter(this, photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.temper:
                mOnPopupClick(view, PopupActivity.class, "temper");
                break;
            case R.id.fishbowl:
                mOnPopupClick(view, PopupActivity.class, "fishbowl");
                break;
            case R.id.light:
                mOnPopupClick(view, PopupActivity.class, "light");
                break;
            case R.id.ph:
                mOnPopupClick(view, PopupActivity.class, "ph");
                break;

            case R.id.temperstatus:
                mOnPopupClick(view, LogPopupActivity.class, "temperstatus");
                break;
            case R.id.fishbowlStatus:
                mOnPopupClick(view, LogPopupActivity.class, "fishbowlStatus");
                break;
            case R.id.lightStatus:
                mOnPopupClick(view, LogPopupActivity.class, "lightStatus");
                break;
            case R.id.PHStatus:
                mOnPopupClick(view, LogPopupActivity.class, "PHStatus");
                break;

            case R.id.btn_TimeText:
                mOnPopupClick(view, TimePopup.class, "");




                break;
        }
    }


    //버튼
    public void mOnPopupClick(View v, Class<? extends Activity> context, String name) {
        //데이터 담아서 팝업(액티비티) 호출

        Intent intent = new Intent(this, context);
//        intent.putExtra("data", "Test Popup");
        intent.putExtra("name", name);

        startActivityForResult(intent, 1);

//        startActivity(intent);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                String result = data.getStringExtra("okdata");
                if(result.equals("ok")){
                    Log.e("ss","데이터 true");
                    showDatePicker();
                }else{
                    Log.e("ss","데이터 false");
                    selectDataList=alldataList;
                    generateDataList(alldataList);

                }
            }
        }
    }


}