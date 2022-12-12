package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class apitest extends AppCompatActivity {

    Call<data_model> call;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apitest);


        textView =findViewById(R.id.testTextView);



        // 레트로핏 인스턴스 생성을 해줍니다.
        // enqueue로 비동기 통신을 싱행합니다.
        Retrofit_interface service = retrofit_client.getRetrofitInstance().create(Retrofit_interface.class);
        Call<List<data_model>> call = service.getAllPhotos();
        //통신완료후 이벤트 처리를 위한 콜백 리스너 등록
        call.enqueue(new Callback<List<data_model>>() {
            // 정상으로 통신 성공시
            @Override
            public void onResponse(Call<List<data_model>> call, Response<List<data_model>> response) {
//                progressDoalog.dismiss();
//                generateDataList(response.body());  //리싸이클러뷰 실행
                  System.out.println("aaaaaaaaaaaaaaaaa"+response.body());

            }
            // 통신 실패시(예외발생, 인터넷끊김 등의 이유)
            @Override
            public void onFailure(Call<List<data_model>> call, Throwable t) {
//                progressDoalog.dismiss();
                Toast.makeText(apitest.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });






//        call = retrofit_client.getApiService().test_api_get("5");
//        call = retrofit_client.getApiService().test_api_get("3");
//        call.enqueue(new Callback<data_model>(){
//            //콜백 받는 부분
//            @Override
//            public void onResponse(Call<data_model> call, Response<data_model> response) {
//                data_model result = response.body();
//                String str;
//                System.out.println("aaaaaaaaaaaaaaaaa"+response.body());
//                System.out.println("ssss"+result);
//                str= result.getUserId() +"\n"+
//                        result.getID()+"\n"+
//                        result.getTitle()+"\n"+
//                        result.getBody();
//                textView.setText(str);
//            }
//
//            @Override
//            public void onFailure(Call<data_model> call, Throwable t) {
//
//            }
//        });


    }

}
