package kr.ac.konkuk.activityforresult_201812326;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static kr.ac.konkuk.activityforresult_201812326.MainActivity.GET_STRING;

public class SubActivity extends Activity {
    EditText edit; // EditText 생성
    TextView text2; // TextView 생성
    static final int GET_STRING = 1; // GET_STRING 초기화

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub); //sub.xml 파일과 연결

        //코드상의 변수와 xml의 요소들을 연결해주기
        edit = (EditText) findViewById(R.id.edit);
        text2 = (TextView) findViewById(R.id.text2);

        Button button_second = (Button) findViewById(R.id.button_second); //두번째 text를 입력받기위해 sub2화면으로의 이동을 돕는 버튼
        button_second.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View arg0) { //버튼 클릭했을때
                Intent in2 = new Intent(SubActivity.this, SubActivity2.class); //SubActivity2로 이동
                startActivityForResult(in2, GET_STRING); //in2을 반환받아 startActivityForResult실행
                 }
        });

        Button button_ok = (Button) findViewById(R.id.button_ok); //"입력완료"버튼.text1입력 후 누르면 main으로 이동
        button_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  //버튼 클릭했을때
                Intent intent = new Intent(); //intent생성
                intent.putExtra("INPUT_TEXT", edit.getText().toString()); //intent의 "INPUT_TEXT"키값에 edit의 값을 입력
                intent.putExtra("INPUT_TEXT2", text2.getText().toString()); //intent의 "INPUT_TEXT2"키값에 text2의 값을 입력
                setResult(RESULT_OK, intent); //결과값을 RESULT_OK 로 설정후, intent반환
                finish();
            }
        });

        Button button_cancel = (Button) findViewById(R.id.button_cancel); //"취소"버튼.
        button_cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  //버튼 클릭했을때
                setResult(RESULT_CANCELED); //결과값을 RESULT_CANCELED 로 설정
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GET_STRING) { //GET_STRING 코드
            if (resultCode == RESULT_OK) { //RESULT_OK 라면,
                text2.setText(data.getStringExtra("INPUT_TEXT2")); //text2에 "INPUT_TEXT2"키값의 내용 출력
            }
        }
    }
}
