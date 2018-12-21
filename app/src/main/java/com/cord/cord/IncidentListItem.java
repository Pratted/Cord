package com.cord.cord;

import android.widget.LinearLayout;
import android.widget.TextView;

import com.ms.square.android.expandabletextview.ExpandableTextView;

public class IncidentListItem extends Incident {
    private LinearLayout layout;

    private TextView tvIncidentType;
    private TextView tvLocation;
    private TextView tvActiveSince;
    private TextView tvOwners;
    private TextView tvStatus;
    //private TextView tvDescription;
    private ExpandableTextView etvDescription;

    public IncidentListItem(LinearLayout parent, String incidentType, String location, String activeSince){
        super(incidentType, location, activeSince);
        this.layout = parent;

        refresh();
    }

    public IncidentListItem(LinearLayout parent, String incidentType, String location, String activeSince, String owners, String status, String description){
        super(incidentType, location, activeSince, owners, status, description);
        this.layout = parent;

        refresh();
    }

    // reset all references to views and update their text values
    public void refresh(){
        tvIncidentType = layout.findViewById(R.id.tv_incident_type);
        tvLocation = layout.findViewById(R.id.tv_location);
        tvActiveSince = layout.findViewById(R.id.tv_active_since);
        tvOwners = layout.findViewById(R.id.tv_owners);
        tvStatus = layout.findViewById(R.id.tv_status);
        etvDescription = layout.findViewById(R.id.etv_description);

        tvIncidentType.setText(incidentType);
        tvLocation.setText(location);
        tvActiveSince.setText(activeSince);
        tvOwners.setText(owners);
        tvStatus.setText(status);
        etvDescription.setText(description);
    }

}
