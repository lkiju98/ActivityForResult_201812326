package kr.ac.konkuk.activityforresult_201812326;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    static final int GET_STRING = 1; // GET_STRING 초기화
    TextView text,text2; // TextView 생성

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //activity_main.xml 파일과 연결

        //코드상의 변수와 xml의 요소들을 연결해주기
        Button button = (Button) findViewById(R.id.button);
        text = (TextView) findViewById(R.id.text);
        text2 = (TextView) findViewById(R.id.text2);


        button.setOnClickListener(new View.OnClickListener() { //sub화면으로 이동을 돕는 버튼
            // @Override
            public void onClick(View arg0) { //버튼 클릭했을때
                Intent in = new Intent(MainActivity.this, SubActivity.class); //SubActivity로 이동
                startActivityForResult(in, GET_STRING); } //in을 반환받아 startActivityForResult실행
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { //SubActivity에서 반환받은 in에 대한 처리
        if (requestCode == GET_STRING) { //GET_STRING 코드
            if (resultCode == RESULT_OK) { //RESULT_OK 라면,
                text.setText(data.getStringExtra("INPUT_TEXT")); //text에 "INPUT_TEXT"키값의 내용 출력
                text2.setText(data.getStringExtra("INPUT_TEXT2")); //text2에 "INPUT_TEXT2"키값의 내용 출력
            }
        }
    }


}