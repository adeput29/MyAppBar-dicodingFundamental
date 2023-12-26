package com.example.myappbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.myappbar.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String title = "Latihan MyAppBar";
    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.topAppBar);
        setActionBarTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        //return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu1) {
            Toast.makeText(this,"TESSS",Toast.LENGTH_LONG).show();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new MenuFragment())
                    .addToBackStack(null)
                    .commit();
            //return super.onOptionsItemSelected(item);
            return true;
        } else if (item.getItemId() == R.id.menu2) {
            Intent i = new Intent(this, MenuActivity.class);
            startActivity(i);
            //return super.onOptionsItemSelected(item);
            return true;
        } else {
            Toast.makeText(this,"TESSS",Toast.LENGTH_LONG);
            //return super.onOptionsItemSelected(item);
            return true;
        }
        //return true;

    }
}