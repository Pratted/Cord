package com.cord.cord;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button buttonNewIncident;

    private ArrayList<IncidentListItem> incidentListItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        initializer();
        buttonNewIncidentListener();

        incidentListItems = new ArrayList<>();
        final LinearLayout ll_incidents = findViewById(R.id.ll_incidents);
        final LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Button btnCreateNewIncident = findViewById(R.id.btn_create_new_incident);

        // clicking the new incident button causes a select dialog to appear
        btnCreateNewIncident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MaterialDialog.Builder builder  = new MaterialDialog.Builder(MainActivity.this);

                builder.title("Select an Incident Type")
                        .items("Telephone Pole", "Flooding", "Road Kill")
                        .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, View itemView, int which, CharSequence text) {
                                return true; // this just makes it so the radio button appears filled in when selected..
                            }
                        })
                        .positiveText("Ok")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                String type = dialog.getItems().get(dialog.getSelectedIndex()).toString();

                                Toast.makeText(MainActivity.this, "You selected " + type, Toast.LENGTH_LONG).show();

                                LinearLayout ll_incident = (LinearLayout) inflater.inflate(R.layout.item_incident, null);
                                ll_incidents.addView(ll_incident);

                                String description = "You selected " + type + ". There could be other information here but this is an example so this is it.";

                                IncidentListItem item = new IncidentListItem(ll_incident, type, "Mechanicsburg, PA", "12/8/18 10:58pm", "Verizon", "Under Review", description);
                                incidentListItems.add(item);

                                Intent AddIncidentIntent = new Intent(MainActivity.this, AddIncident.class);
                                startActivity(AddIncidentIntent);
                                overridePendingTransition(R.anim.enter_in_up, R.anim.exit_out_up);
                            }
                        })
                        .negativeText("Cancel")
                        .show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        for(IncidentListItem item: incidentListItems)
            item.refresh();

    }

    private void initializer() {
        buttonNewIncident = findViewById(R.id.btn_create_new_incident);
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
