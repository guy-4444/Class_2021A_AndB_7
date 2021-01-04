package com.classy.class_2021a_andb_7;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_LBL_title) TextView main_LBL_title;
    @BindView(R.id.main_LBL_info) TextView main_LBL_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        Log.d("pttt", "Start");

        Observable<List<String>> songsObservable = Observable.fromCallable(new Callable<List<String>>() {
            @Override
            public List<String> call() {
                return getSongList();
            }
        });

        songsObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<String>>() {

                            @Override
                            public void onSubscribe(@NonNull Disposable d) {
                                Log.d("pttt", "onSubscribe " + Thread.currentThread().getName());
                            }

                            @Override
                            public void onNext(@NonNull List<String> strings) {
                                Log.d("pttt", "onNext " + Thread.currentThread().getName());
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                Log.d("pttt", "onError " + Thread.currentThread().getName());
                            }

                            @Override
                            public void onComplete() {
                                Log.d("pttt", "onComplete " + Thread.currentThread().getName());
                                updateList();
                            }
                        });

        Log.d("pttt", "End");
        //
    }

    private void updateList() {
        Log.d("pttt", "updateList " + Thread.currentThread().getName());
        main_LBL_title.setText("AAAA");
        main_LBL_info.setText("BBBB");
    }

    private List<String> getSongList() {
        Log.d("pttt", "getSongList " + Thread.currentThread().getName());

        int x = 0;
        int y = 0;
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 10000; j++) {
                x = (i % 2 == 0) ? i + 1 : j + 1;
                y = x * 2;
            }
        }
        ArrayList<String> songs = new ArrayList<>();
        songs.add("Trailer");
        songs.add("Hello");
        songs.add("Tel-Aviv");
        songs.add("Alien");
        return songs;
    }
}