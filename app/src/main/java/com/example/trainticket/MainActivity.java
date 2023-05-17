package com.example.trainticket;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // определение полей
    private EditText nameIn; // поле имени
    private EditText price; // поле адреса
    private EditText place_of_departure;// поле электронного адреса
    private EditText time_of_departure;
    private EditText place_of_arrival;
    private EditText time_of_arrival;
    private Button button; // поле кнопки

    private String name; // поле хранения имени
    private String price_Ticket; // поле хранения адреса
    private String Place_of_departure; // поле хранения электронного адреса
    private String Time_of_departure;
    private String Place_of_arrival;
    private String Time_of_arrival;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // привязка id к полям
        nameIn = findViewById(R.id.nameIn);
        price = findViewById(R.id.price);
        place_of_departure = findViewById(R.id.place_of_departure);
        time_of_departure = findViewById(R.id.time_of_departure);
        place_of_arrival = findViewById(R.id.place_of_arrival);
        time_of_arrival = findViewById(R.id.time_of_arrival);
        button = findViewById(R.id.button);



        // обработка нажатия кнопки
        button.setOnClickListener(listener);
    }

    // создание слушателя
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // переключение на другой экран и передача данных

            // считывание данных с экрана
            name = nameIn.getText().toString();
            price_Ticket = price.getText().toString();
            Place_of_departure = place_of_departure.getText().toString();
            Time_of_departure = time_of_departure.getText().toString();
            Place_of_arrival = place_of_arrival.getText().toString();
            Time_of_arrival = time_of_arrival.getText().toString();




            // создадим объект нашей сущности и через конструктор инициализируем его
            User user = new User(name, price_Ticket, Place_of_departure, Time_of_departure, Place_of_arrival, Time_of_arrival);

            // создание намерения
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

            // запаковка данных в контейнер намерения
            intent.putExtra(User.class.getSimpleName(), user); // User.class.getSimpleName() является ключом для запаковки в контейнер

            // старт переключения активити и передачи данных
            startActivity(intent);
        }
    };
}