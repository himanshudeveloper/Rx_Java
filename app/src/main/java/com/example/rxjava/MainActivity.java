package com.example.rxjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtHi)
    TextView txtHi;

    @BindView(R.id.myRecycleView)
    RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewCustomAdapter recyclerViewCustomAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        linearLayoutManager =new LinearLayoutManager(this);
        recyclerViewCustomAdapter = new RecyclerViewCustomAdapter();

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewCustomAdapter);


        Observable.just("How are you").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Throwable {
                txtHi.setText(s);

            }
        });

        Observable.just("jak","himanshu","samsung","java","LAva").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Throwable {
                recyclerViewCustomAdapter.addStringToList(s);

            }
        });
    }
}