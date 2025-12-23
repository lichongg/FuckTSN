package com.bytedance.sdk.openadsdk.az;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.umeng.analytics.pro.bi;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {

    /* renamed from: j, reason: collision with root package name */
    private Context f27628j;
    private WeakReference<tl> xt;
    private Map<String, j> cw = new HashMap();

    /* renamed from: r, reason: collision with root package name */
    private SensorEventListener f27630r = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.az.m.1
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            tl r5;
            if (sensorEvent.sensor.getType() != 1 || (r5 = m.this.r()) == null) {
                return;
            }
            float[] fArr = sensorEvent.values;
            float f6 = fArr[0];
            float f7 = fArr[1];
            float f8 = fArr[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", f6);
                jSONObject.put("y", f7);
                jSONObject.put(bi.aG, f8);
                r5.j("accelerometer_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i6) {
        }
    };
    private SensorEventListener up = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.az.m.12
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            tl r5;
            if (sensorEvent.sensor.getType() != 4 || (r5 = m.this.r()) == null) {
                return;
            }
            float degrees = (float) Math.toDegrees(sensorEvent.values[0]);
            float degrees2 = (float) Math.toDegrees(sensorEvent.values[1]);
            float degrees3 = (float) Math.toDegrees(sensorEvent.values[2]);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", degrees);
                jSONObject.put("y", degrees2);
                jSONObject.put(bi.aG, degrees3);
                r5.j("gyro_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i6) {
        }
    };

    /* renamed from: m, reason: collision with root package name */
    private SensorEventListener f27629m = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.az.m.23
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            tl r5;
            if (sensorEvent.sensor.getType() != 10 || (r5 = m.this.r()) == null) {
                return;
            }
            float[] fArr = sensorEvent.values;
            float f6 = fArr[0];
            float f7 = fArr[1];
            float f8 = fArr[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", f6);
                jSONObject.put("y", f7);
                jSONObject.put(bi.aG, f8);
                r5.j("accelerometer_grativityless_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i6) {
        }
    };
    private SensorEventListener ae = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.az.m.34
        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                float[] fArr = sensorEvent.values;
                float[] fArr2 = oq.xt;
                System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            } else if (sensorEvent.sensor.getType() == 2) {
                float[] fArr3 = sensorEvent.values;
                float[] fArr4 = oq.cw;
                System.arraycopy(fArr3, 0, fArr4, 0, fArr4.length);
            }
            float[] fArr5 = oq.f27696r;
            SensorManager.getRotationMatrix(fArr5, null, oq.xt, oq.cw);
            float[] fArr6 = oq.up;
            SensorManager.getOrientation(fArr5, fArr6);
            tl r5 = m.this.r();
            if (r5 == null) {
                return;
            }
            float f6 = fArr6[0];
            float f7 = fArr6[1];
            float f8 = fArr6[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("alpha", f6);
                jSONObject.put("beta", f7);
                jSONObject.put("gamma", f8);
                r5.j("rotation_vector_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i6) {
        }
    };

    interface j {
        JSONObject j(JSONObject jSONObject) throws Throwable;
    }

    private void cw() {
        this.cw.put("adInfo", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.45
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                if (r5 == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject mi = r5.mi();
                if (mi != null) {
                    mi.put("code", 1);
                    return mi;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", -1);
                return jSONObject3;
            }
        });
        this.cw.put("appInfo", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.56
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 1);
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.5.1");
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = m.this.j().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject2.put("supportList", jSONArray);
                tl r5 = m.this.r();
                if (r5 != null) {
                    jSONObject2.put("deviceId", r5.m());
                    jSONObject2.put("netType", r5.av());
                    jSONObject2.put("innerAppName", r5.cw());
                    jSONObject2.put("appName", r5.r());
                    jSONObject2.put("appVersion", r5.up());
                    Map<String, String> j6 = r5.j();
                    for (String str : j6.keySet()) {
                        jSONObject2.put(str, j6.get(str));
                    }
                }
                return jSONObject2;
            }
        });
        this.cw.put("playableSDKInfo", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.61
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 1);
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "6.5.1");
                jSONObject2.put("os", FaceEnvironment.OS);
                return jSONObject2;
            }
        });
        this.cw.put("subscribe_app_ad", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.62
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.az.j up = m.this.up();
                JSONObject jSONObject2 = new JSONObject();
                if (up == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("download_app_ad", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.63
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.az.j up = m.this.up();
                JSONObject jSONObject2 = new JSONObject();
                if (up == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("isViewable", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.2
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                if (r5 == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 1);
                jSONObject3.put("viewStatus", r5.tl());
                return jSONObject3;
            }
        });
        this.cw.put("getVolume", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.3
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                if (r5 == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", 1);
                jSONObject3.put("endcard_mute", r5.ae());
                return jSONObject3;
            }
        });
        this.cw.put("getScreenSize", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.4
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                if (r5 == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject w5 = r5.w();
                w5.put("code", 1);
                return w5;
            }
        });
        this.cw.put("start_accelerometer_observer", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.5
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int i6 = 2;
                if (jSONObject != null) {
                    try {
                        i6 = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        ae.j("PlayableJsBridge", "invoke start_accelerometer_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                oq.j(m.this.f27628j, m.this.f27630r, i6);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("close_accelerometer_observer", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.6
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    oq.j(m.this.f27628j, m.this.f27630r);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    ae.j("PlayableJsBridge", "invoke close_accelerometer_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.cw.put("start_gyro_observer", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.7
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int i6 = 2;
                if (jSONObject != null) {
                    try {
                        i6 = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        ae.j("PlayableJsBridge", "invoke start_gyro_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                oq.xt(m.this.f27628j, m.this.up, i6);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("close_gyro_observer", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.8
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    oq.j(m.this.f27628j, m.this.up);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    ae.j("PlayableJsBridge", "invoke close_gyro_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.cw.put("start_accelerometer_grativityless_observer", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.9
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int i6 = 2;
                if (jSONObject != null) {
                    try {
                        i6 = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        ae.j("PlayableJsBridge", "invoke start_accelerometer_grativityless_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                oq.cw(m.this.f27628j, m.this.f27629m, i6);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("close_accelerometer_grativityless_observer", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.10
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    oq.j(m.this.f27628j, m.this.f27629m);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    ae.j("PlayableJsBridge", "invoke close_accelerometer_grativityless_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.cw.put("start_rotation_vector_observer", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.11
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int i6 = 2;
                if (jSONObject != null) {
                    try {
                        i6 = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        ae.j("PlayableJsBridge", "invoke start_rotation_vector_observer error", th);
                        jSONObject2.put("code", -1);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                oq.r(m.this.f27628j, m.this.ae, i6);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("close_rotation_vector_observer", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.13
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    oq.j(m.this.f27628j, m.this.ae);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    ae.j("PlayableJsBridge", "invoke close_rotation_vector_observer error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.cw.put("device_shake", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.14
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    oq.j(m.this.f27628j, 300L);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    ae.j("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.cw.put("device_shake_short", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.15
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    oq.j(m.this.f27628j, 150L);
                    jSONObject2.put("code", 1);
                    return jSONObject2;
                } catch (Throwable th) {
                    ae.j("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put("code", -1);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.cw.put("playable_style", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.16
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject xt = r5.xt();
                xt.put("code", 1);
                return xt;
            }
        });
        this.cw.put("sendReward", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.17
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                r5.tj();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("webview_time_track", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.18
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                return new JSONObject();
            }
        });
        this.cw.put("playable_event", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.19
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null || jSONObject == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                r5.xt(jSONObject.optString("event", null), jSONObject.optJSONObject("params"));
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("reportAd", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.20
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("close", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.21
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("openAdLandPageLinks", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.22
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("get_viewport", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.24
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject kt = r5.kt();
                kt.put("code", 1);
                return kt;
            }
        });
        this.cw.put("jssdk_load_finish", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.25
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                r5.p();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_material_render_result", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.26
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                r5.qv(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("detect_change_playable_click", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.27
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject g6 = r5.g();
                g6.put("code", 1);
                return g6;
            }
        });
        this.cw.put("check_camera_permission", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.28
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject vl = r5.vl();
                vl.put("code", 1);
                return vl;
            }
        });
        this.cw.put("check_external_storage", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.29
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject jy = r5.jy();
                if (jy.isNull("result")) {
                    jy.put("code", -1);
                    return jy;
                }
                jy.put("code", 1);
                return jy;
            }
        });
        this.cw.put("playable_open_camera", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.30
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                r5.j(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_pick_photo", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.31
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                r5.xt(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_download_media_in_photos", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.32
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                r5.cw(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_preventTouchEvent", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.33
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                r5.r(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_settings_info", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.35
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject ws = r5.ws();
                ws.put("code", 1);
                return ws;
            }
        });
        this.cw.put("playable_load_main_scene", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.36
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                r5.f();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_enter_section", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.37
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                r5.m(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_end", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.38
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                r5.v();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_finish_play_playable", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.39
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                r5.x();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_transfrom_module_show", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.40
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                r5.ch();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_transfrom_module_change_color", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.41
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                r5.s();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_set_scroll_rect", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.42
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_click_area", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.43
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                r5.ae(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_real_play_start", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.44
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_material_first_frame_show", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.46
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                r5.a();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_stuck_check_pong", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.47
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                r5.l();
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_material_adnormal_mask", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.48
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                r5.tl(jSONObject);
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_long_press_panel", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.49
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_alpha_player_play", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.50
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_transfrom_module_highlight", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.51
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_send_click_event", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.52
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_query_media_permission_declare", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.53
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject g6 = r5.g(jSONObject);
                g6.put("code", 1);
                return g6;
            }
        });
        this.cw.put("playable_query_media_permission_enable", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.54
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                tl r5 = m.this.r();
                JSONObject jSONObject2 = new JSONObject();
                if (r5 == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                JSONObject oq = r5.oq(jSONObject);
                oq.put("code", 1);
                return oq;
            }
        });
        this.cw.put("playable_apply_media_permission", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.55
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.az.j up = m.this.up();
                JSONObject jSONObject2 = new JSONObject();
                if (up == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_start_kws", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.57
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.az.j up = m.this.up();
                JSONObject jSONObject2 = new JSONObject();
                if (up == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_close_kws", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.58
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.az.j up = m.this.up();
                JSONObject jSONObject2 = new JSONObject();
                if (up == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_video_preload_task_add", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.59
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.az.j up = m.this.up();
                JSONObject jSONObject2 = new JSONObject();
                if (up == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
        this.cw.put("playable_video_preload_task_cancel", new j() { // from class: com.bytedance.sdk.openadsdk.az.m.60
            @Override // com.bytedance.sdk.openadsdk.az.m.j
            public JSONObject j(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.az.j up = m.this.up();
                JSONObject jSONObject2 = new JSONObject();
                if (up == null) {
                    jSONObject2.put("code", -1);
                    return jSONObject2;
                }
                jSONObject2.put("code", 1);
                return jSONObject2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public tl r() {
        WeakReference<tl> weakReference = this.xt;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.az.j up() {
        tl r5 = r();
        if (r5 == null) {
            return null;
        }
        return r5.i();
    }

    public Set<String> j() {
        return this.cw.keySet();
    }

    public void xt() {
        oq.j(this.f27628j, this.f27630r);
        oq.j(this.f27628j, this.up);
        oq.j(this.f27628j, this.f27629m);
        oq.j(this.f27628j, this.ae);
    }

    public m(tl tlVar) {
        this.f27628j = tlVar.getContext();
        this.xt = new WeakReference<>(tlVar);
        cw();
    }

    public JSONObject j(String str, JSONObject jSONObject) {
        try {
            j jVar = this.cw.get(str);
            if (jVar == null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", -1);
                return jSONObject2;
            }
            return jVar.j(jSONObject);
        } catch (Throwable th) {
            ae.j("PlayableJsBridge", "invoke error", th);
            return null;
        }
    }
}
