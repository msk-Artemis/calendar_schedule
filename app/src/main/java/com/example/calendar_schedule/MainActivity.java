package com.example.calendar_schedule;


//xmlファイルの各レイアウトと結び付け
import com.example.calendar_schedule.R;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import android.widget.EditText; // 追加
import android.widget.TextView; // 追加


public class MainActivity extends AppCompatActivity {

    //各変数を宣言
    private DatePicker datePicker;
    private Button addButton;
    private ListView eventListView;

    private List<String> eventList;
    private ArrayAdapter<String> eventAdapter;

    private EditText eventNameEditText;
    private TextView outputTextView;

    //Overrideでメソッド初期化
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //xmlファイルの各ウィジェットの操作するための処理
        datePicker = findViewById(R.id.datePicker);
        addButton = findViewById(R.id.addButton);
        eventListView = findViewById(R.id.eventListView);
        eventNameEditText = findViewById(R.id.eventNameEditText); // 7/30追加
        outputTextView = findViewById(R.id.outputTextView); // 7/30追加


        eventList = new ArrayList<>();
        eventAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, eventList);
        eventListView.setAdapter(eventAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEvent();
            }
        });
    }

    private void addEvent() {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();

        //予定と日付をプリントアウト
        String event = year + "/" + month + "/" + day + "\n"
                + "予定名: " + eventNameEditText.getText().toString();

        eventList.add(event);
        eventAdapter.notifyDataSetChanged();

        Toast.makeText(this, "Event added", Toast.LENGTH_SHORT).show();
    }
}
