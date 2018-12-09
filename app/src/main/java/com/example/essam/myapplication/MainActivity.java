package com.example.essam.myapplication;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    RelativeLayout body;

    TextInputLayout userNameLayout;
    TextInputLayout passwordLayout;
    AppCompatEditText userName;
    AppCompatEditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        userNameLayout = (TextInputLayout) findViewById(R.id.user_name_textInputLayout);
        passwordLayout = (TextInputLayout) findViewById(R.id.password_textInputLayout);

        userName = (AppCompatEditText) findViewById(R.id.user_name);
        password = (AppCompatEditText) findViewById(R.id.password);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.nav_drawer);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        body = (RelativeLayout) findViewById(R.id.body);
        body.setOnClickListener(null);

        navigationView.setNavigationItemSelectedListener(this);
        setSupportActionBar(toolbar);
        setTitle("Material Design");

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (userName.getText().toString().length() == 0) {
                    userNameLayout.setErrorEnabled(true);
                    userNameLayout.setError("Please Enter username");
                } else {
                    userNameLayout.setErrorEnabled(false);

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        userName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (userName.getText().toString().length() == 0) {
                    userNameLayout.setErrorEnabled(true);
                    userNameLayout.setError("Please Enter username");
                } else {
                    userNameLayout.setErrorEnabled(false);

                }
            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (password.getText().toString().length() == 0) {
                    passwordLayout.setErrorEnabled(true);
                    passwordLayout.setError("Please Enter Password");
                } else {
                    passwordLayout.setErrorEnabled(false);

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (password.getText().toString().length() == 0) {
                    passwordLayout.setErrorEnabled(true);
                    passwordLayout.setError("Please Enter Password");
                } else {
                    passwordLayout.setErrorEnabled(false);

                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setting:
                Toast.makeText(this, getString(R.string.setting), Toast.LENGTH_SHORT).show();
                break;
            case R.id.aboutUS:
                Toast.makeText(this, getString(R.string.about_us), Toast.LENGTH_SHORT).show();
                break;
            case R.id.user:
                Toast.makeText(this, getString(R.string.users), Toast.LENGTH_SHORT).show();
                break;

            case R.id.search:
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
                break;

            case R.id.card:
                Toast.makeText(this, "Card Clicked", Toast.LENGTH_SHORT).show();
                break;

            case android.R.id.home:
                finish();
                break;

            default:
                break;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.sent_email:
                Toast.makeText(this, "Sent Email", Toast.LENGTH_SHORT).show();
                break;
            case R.id.inbox:
                Toast.makeText(this, "inbox", Toast.LENGTH_SHORT).show();
                break;
            case R.id.starred:
                Toast.makeText(this, "starred", Toast.LENGTH_SHORT).show();
                break;
            case R.id.draft:
                Toast.makeText(this, "draft", Toast.LENGTH_SHORT).show();
                break;
            case R.id.all_email:
                Toast.makeText(this, "all email", Toast.LENGTH_SHORT).show();
                break;
            case R.id.trash:
                Toast.makeText(this, "trash", Toast.LENGTH_SHORT).show();
                break;
            case R.id.spam:
                Toast.makeText(this, "spam", Toast.LENGTH_SHORT).show();
                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }
}
