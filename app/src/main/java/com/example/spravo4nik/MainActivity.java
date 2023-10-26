package com.example.spravo4nik;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private String[] topics = {"Тема 1", "Тема 2", "Тема 3"};
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Находим ListView по идентификатору
        ListView listView= findViewById(R.id.list);

        // Создаем адаптер для списка тем
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, topics);

        // Устанавливаем адаптер для ListView
        listView.setAdapter(adapter);

        // Устанавливаем обработчик событий для нажатия на элемент списка
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String topic = topics[position];

                // Создаем намерение для запуска дочерней активити (RecordActivity)
                Intent intent = new Intent(MainActivity.this, RecordActivity.class);
                intent.putExtra("topic", topic);

                // Запускаем дочернюю активити
                startActivity(intent);
            }
        });
    }
}