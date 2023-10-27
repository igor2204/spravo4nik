package com.example.spravo4nik;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences;

public class RecordActivity extends AppCompatActivity {
    private EditText topicEditText;
    private EditText contentEditText;
    private Button saveButton;
    private String selectedTopic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        topicEditText = findViewById(R.id.topicEditText);
        contentEditText = findViewById(R.id.contentEditText);
        saveButton = findViewById(R.id.saveButton);

        // Получение данных из предыдущей активити
        Intent intent = getIntent();
        selectedTopic = intent.getStringExtra("topic");

        // Загрузка сохраненной темы и текста заметки (если она была)
        SharedPreferences sharedPreferences = getSharedPreferences("NoteBook", MODE_PRIVATE);
        String savedTopic = sharedPreferences.getString(selectedTopic + "_topic", "");
        String savedContent = sharedPreferences.getString(selectedTopic + "_content", "");

        // Установка загруженной темы и текста заметки в поля редактирования
        topicEditText.setText(savedTopic);
        contentEditText.setText(savedContent);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получение новой темы и текста заметки из полей редактирования
                String newTopic = topicEditText.getText().toString();
                String newContent = contentEditText.getText().toString();

                // Сохранение новой темы и текста заметки в SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(selectedTopic + "_topic", newTopic);
                editor.putString(selectedTopic + "_content", newContent);
                editor.apply();




                // Возвращение результата в предыдущую активити
                Intent resultIntent = new Intent();
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
