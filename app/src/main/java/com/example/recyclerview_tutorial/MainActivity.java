package com.example.recyclerview_tutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Person person1 = new Person("Patrick Feltes", 21);
        Person person2 = new Person("Jane Doe", 43);
        Person person3 = new Person("John Smith", 44);
        Person person4 = new Person("Johnny Appleseed", 16);

        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        PersonAdapter adapter = new PersonAdapter(personList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
    }
}
