package com.example.xyzreader.remote;

import android.util.Log;

import com.example.xyzreader.data.JsonData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RemoteEndpointUtil {
    private static final String TAG = "RemoteEndpointUtil";

    private RemoteEndpointUtil() {
    }

    public static JSONArray fetchJsonArray() {
        String itemsJson = null;
        itemsJson = JsonData.JSON_DATA;

        // Parse JSON
        try {
            JSONObject tokener = new JSONObject(itemsJson);
            JSONArray jsonArray = tokener.getJSONArray("reader_data");
            if (!(jsonArray instanceof JSONArray)) {
                throw new JSONException("Expected JSONArray");
            }
            return jsonArray;
        } catch (JSONException e) {
            Log.e(TAG, "Error parsing items JSON", e);
        }

        return null;
    }
}
