package jungdain.kr.hs.emirim.dbex;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    class MyDBHelper extends SQLiteOpenHelper {
        //idolDB라는 이름의 데이터베이스가 생성된다
        public MyDBHelper(Context context) {
            super(context, "ido1DB", null, 1); //새롭게 다시 만들어주고 싶다면 버전을 업시켜준다 ex.1을 2로 바꾼다
        }
        //idolTable라는 이름의 테이블 생성
        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql="create table idolTable(idolName text not null primary key,idolCount integer)";
            db.execSQL(sql);
        }
        //이미 idolTable이 존재한다면 기존의 테이블을 삭제하고 새로 테이블을 만들 때 호출한다
        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            String sql="drop table if exist idolTable"; //만약에 idolTable이 존재한다면 table을 삭제해줘라
            db.execSQL(sql);
            onCreate(db);
        }
    }
}
