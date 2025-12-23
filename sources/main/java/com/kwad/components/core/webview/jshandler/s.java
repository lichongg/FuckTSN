package com.kwad.components.core.webview.jshandler;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.bi;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class s implements SensorEventListener, com.kwad.sdk.core.webview.c.a {
    private Map<Integer, com.kwad.sdk.core.webview.c.c> acz = new ConcurrentHashMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int acC;
        public ArrayList<Float> acD;
        public int accuracy;
        public long timestamp;
        public int type;

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.type = jSONObject.optInt("type");
            this.acC = jSONObject.optInt(com.umeng.analytics.pro.bi.aX);
            this.timestamp = jSONObject.optLong("timestamp");
            this.accuracy = jSONObject.optInt("accuracy");
            JSONArray optJSONArray = jSONObject.optJSONArray("values");
            ArrayList<Float> arrayList = new ArrayList<>();
            if (optJSONArray == null) {
                this.acD = arrayList;
                return;
            }
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                try {
                    Object obj = optJSONArray.get(i6);
                    if (obj != null) {
                        arrayList.add((Float) obj);
                    }
                } catch (Throwable unused) {
                }
            }
            this.acD = arrayList;
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            int i6 = this.type;
            if (i6 != 0) {
                com.kwad.sdk.utils.aa.putValue(jSONObject, "type", i6);
            }
            int i7 = this.acC;
            if (i7 != 0) {
                com.kwad.sdk.utils.aa.putValue(jSONObject, com.umeng.analytics.pro.bi.aX, i7);
            }
            long j6 = this.timestamp;
            if (j6 != 0) {
                com.kwad.sdk.utils.aa.putValue(jSONObject, "timestamp", j6);
            }
            int i8 = this.accuracy;
            if (i8 != 0) {
                com.kwad.sdk.utils.aa.putValue(jSONObject, "accuracy", i8);
            }
            if (!this.acD.isEmpty()) {
                com.kwad.sdk.utils.aa.putValue(jSONObject, "values", this.acD);
            }
            return jSONObject;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (TextUtils.isEmpty(str)) {
            cVar.onError(-1, "data is empty");
            return;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
        this.acz.put(Integer.valueOf(aVar.type), cVar);
        a(aVar.type, aVar.acC, cVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerSensorListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.sdk.utils.bi.Rx().a(this);
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        a(sensorEvent);
    }

    private void a(int i6, int i7, final com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.utils.bi.Rx().a(i6, i7, this, new bi.b() { // from class: com.kwad.components.core.webview.jshandler.s.1
            @Override // com.kwad.sdk.utils.bi.b
            public final void onFailed() {
                cVar.onError(-1, "sensor is not support");
            }
        });
    }

    private void a(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == 4) {
            type = 2;
        } else if (type == 10) {
            type = 1;
        }
        com.kwad.sdk.core.webview.c.c cVar = this.acz.get(Integer.valueOf(type));
        if (cVar == null) {
            return;
        }
        ArrayList<Float> arrayList = new ArrayList<>();
        int i6 = 0;
        while (true) {
            float[] fArr = sensorEvent.values;
            if (i6 < fArr.length) {
                arrayList.add(Float.valueOf(fArr[i6]));
                i6++;
            } else {
                a aVar = new a();
                aVar.acD = arrayList;
                aVar.timestamp = sensorEvent.timestamp;
                aVar.accuracy = sensorEvent.accuracy;
                cVar.a(aVar);
                return;
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i6) {
    }
}
