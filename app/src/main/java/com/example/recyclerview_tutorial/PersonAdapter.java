package com.example.recyclerview_tutorial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    private final List<Person> personList;

    public PersonAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_list_item, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = personList.get(position);
        holder.bindData(person);
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }
}

class PersonViewHolder extends RecyclerView.ViewHolder {

    private final TextView nameTextView;
    private final TextView ageTextView;

    public PersonViewHolder(@NonNull View itemView) {
        super(itemView);

        nameTextView = itemView.findViewById(R.id.nameTextView);
        ageTextView = itemView.findViewById(R.id.ageTextView);
    }

    public void bindData(Person person) {
        nameTextView.setText(person.getName());
        ageTextView.setText("Age: " + person.getAge());
    }
}