package com.example.a65apps.daggerlesson.presentation;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a65apps.daggerlesson.R;
import com.example.a65apps.daggerlesson.di.core.AppComponent;
import com.example.a65apps.daggerlesson.di.core.AppModule;
import com.example.a65apps.daggerlesson.di.core.DaggerAppComponent;
import com.example.a65apps.daggerlesson.di.main.DaggerMainComponent;
import com.example.a65apps.daggerlesson.di.main.MainComponent;
import com.example.a65apps.daggerlesson.presentation.contacts.ContactListFragment;

import javax.inject.Inject;

/**
 * Инъекция с использованием ComponentDependency
 */
public class MainActivity extends AppCompatActivity {

    @Inject
    public SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new ContactListFragment())
                .commit();
    }
}