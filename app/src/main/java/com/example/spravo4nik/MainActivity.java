package com.example.spravo4nik;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    private String[] Topics = {"Тема 1", "Тема 2", "Тема 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Topics);// адаптер для списка тем
        list.setAdapter(adapter);// адаптер для ListView


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() { //Установка обработчика событий для нажатия на элемент списка
            @Override//создание интента для запуска дочерней активити
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String topic = Topics[position];
                Intent intent = new Intent(MainActivity.this, RecordActivity.class);
                intent.putExtra("topic", topic);
                startActivity(intent);// запуск дочерней активити
            }
        });
    }
}