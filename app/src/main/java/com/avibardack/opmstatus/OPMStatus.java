package com.avibardack.opmstatus;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Avi on 1/24/2015.
 */
public class OPMStatus {
    public MainActivity.Status status;
    public String txt;

    public OPMStatus(JSONObject obj) {
        try {
            this.txt = obj.getString("ShortStatusMessage");
            String iconText = obj.getString("Icon");
            switch (iconText) {
                case "Open":
                    this.status = MainActivity.Status.Open;
                    break;
                case "Alert":
                    this.status = MainActivity.Status.Alert;
                    break;
                default:
                    this.status = MainActivity.Status.Closed;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            txt = "";
            this.status = MainActivity.Status.Open;
        }
    }
}
