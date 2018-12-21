package com.cord.cord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private Button buttonNewIncident;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        initializer();
        buttonNewIncidentListener();

    }

    private void initializer() {
        buttonNewIncident = findViewById(R.id.button_new_incident_MA);
    }

    private void buttonNewIncidentListener() {
        buttonNewIncident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AddIncidentIntent = new Intent(MainActivity.this, AddIncident.class);
                startActivity(AddIncidentIntent);
                overridePendingTransition(R.anim.enter_in_up, R.anim.exit_out_up);
            }
        });
    }


}
