package com.kwai.adclient.kscommerciallogger.snapshot;

import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class d {
    private final String bfi;
    private final LinkedHashMap<String, String> bfj = new LinkedHashMap<>();
    private final long time = System.nanoTime();

    synchronized JSONObject Tq() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : this.bfj.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("time", this.time);
                jSONObject.put("span_name", this.bfi);
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
        } catch (Throwable th) {
            throw th;
        }
        return jSONObject;
    }

    d(String str) {
        this.bfi = str;
    }
}
