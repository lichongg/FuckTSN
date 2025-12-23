package com.umeng.commonsdk.utils;

import java.util.Comparator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class JSONArraySortUtil implements Comparator<JSONObject> {
    private String mCompareKey;

    @Override // java.util.Comparator
    public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            return (int) (jSONObject.getLong(this.mCompareKey) - jSONObject2.getLong(this.mCompareKey));
        } catch (JSONException e6) {
            e6.printStackTrace();
            return 0;
        }
    }

    public void setCompareKey(String str) {
        this.mCompareKey = str;
    }
}
