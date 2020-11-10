package kr.ac.konkuk.activityforresult_201812326;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity2 extends Activity {
    EditText edit; // EditText 생성

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub2); //sub2.xml 파일과 연결

        //코드상의 변수와 xml의 요소들을 연결해주기
        edit = (EditText) findViewById(R.id.edit);

        Button button_ok = (Button) findViewById(R.id.button_ok); //"입력완료"버튼.text2입력 후 누르면 sub2로 이동
        button_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { //버튼 클릭했을때
                Intent intent = new Intent(); //intent생성
                intent.putExtra("INPUT_TEXT2", edit.getText().toString()); //intent의 "INPUT_TEXT2"키값에 text2의 값을 입력
                setResult(RESULT_OK, intent); //결과값을 RESULT_OK 로 설정후, intent반환
                finish();
            }
        });

        Button button_cancel = (Button) findViewById(R.id.button_cancel); //"취소"버튼.
        button_cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { //버튼 클릭했을때
                setResult(RESULT_CANCELED); //결과값을 RESULT_CANCELED 로 설정
                finish();
            }
        });

    }
}
