package com.classy.class_2021a_andb_7;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(6);
        nums.add(7);
        nums.add(8);
        nums.add(9);
        nums.add(10);



        // downloadUserData();
        // updateUserUI();
        // getUserFavoriteList();
        // updateFavoriteList();
        // getDataForEverySong();
        // updateSongInList(); // x10


        // which thread - main thread (UI thread) ,other
        // timeout
        // ReCall count

        Log.d("pttt", "Start");

        Observable<List<String>> listObservable2 = Observable.just(getSongList());

        Observable<List<String>> listObservable = Observable
                .just(getSongList())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                ;

        listObservable.subscribe(new Observer<List<String>>() {

            @Override
            public void onComplete() {
                Log.d("ptttRX", "onComplete");
            }

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d("ptttRX", "onSubscribe");

            }

            @Override
            public void onNext(List<String> colors) {
                Log.d("ptttRX", "onNext");


            }

            @Override
            public void onError(Throwable e) {
                Log.d("ptttRX", "onError");

            }
        });

        Log.d("pttt", "End");
    }

    private List<String> getSongList() {

        int x = 0;
        int y = 0;
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 10000; j++) {
                x = (i % 2 == 0) ? i+1 : j+1;
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

    private void downloadUserData() {
        Log.d("pttt", "downloadUserData");
    }

    private void updateUserUI() {
        Log.d("pttt", "updateUserUI");
    }

    private void getUserFavoriteList() {
        Log.d("pttt", "getUserFavoriteList");
    }

    private void updateFavoriteList() {
        Log.d("pttt", "updateFavoriteList");
    }

    private void getDataForEverySong() {
        Log.d("pttt", "getDataForEverySong");
    }

    private void updateSongInList() {
        Log.d("pttt", "updateSongInList");
    }

}