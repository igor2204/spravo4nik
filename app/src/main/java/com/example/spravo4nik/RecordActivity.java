package com.example.spravo4nik;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RecordActivity extends AppCompatActivity {
    private TextView topicTextView;
    private EditText noteEditText;
    private Button editButton;


    private String topic = "";
    private String note = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        // Находим элементы интерфейса по идентификаторам
        topicTextView = findViewById(R.id.topicTextView);
        noteEditText = findViewById(R.id.noteEditText);
        editButton = findViewById(R.id.editButton);


        // Получаем переданные данные о теме и заметке из интента
        Intent intent = getIntent();
        if (intent != null) {
            topic = intent.getStringExtra("topic");
            note = "C:\\Users\\igorc\\OneDrive\\Рабочий стол\\file.txt"; // Здесь нужно получить текст заметки из соответствующего места (например, базы данных)

            topicTextView.setText(topic);
            noteEditText.setText(note);

        }

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получаем измененный текст заметки
                String updatedNote = noteEditText.getText().toString();

                // Здесь нужно сохранить измененный текст заметки в соответствующем месте (например, базе данных)

                // Создаем намерение для возврата к главной активити (MainActivity)
                Intent returnIntent = new Intent();
                returnIntent.putExtra("updatedNote", updatedNote);
                setResult(RESULT_OK, returnIntent);

                // Закрываем текущую активити
                finish();
            }
        });
    }
}