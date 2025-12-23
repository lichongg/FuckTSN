package com.bxkj.student.v2.ai.fitness.camera;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.umeng.analytics.pro.bi;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class l implements SensorEventListener {

    /* renamed from: c, reason: collision with root package name */
    private static final String f20561c = "TemperatureMonitor";

    /* renamed from: a, reason: collision with root package name */
    public Map<String, Float> f20562a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final SensorManager f20563b;

    public void a() {
        for (Map.Entry<String, Float> entry : this.f20562a.entrySet()) {
            Float value = entry.getValue();
            float floatValue = value.floatValue();
            if (floatValue >= 0.0f) {
                String.format(Locale.US, "%s:\t%.1fC\t%.1fF", entry.getKey(), value, Float.valueOf((floatValue * 1.8f) + 32.0f));
            }
        }
    }

    public void b() {
        this.f20563b.unregisterListener(this);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        this.f20562a.put(sensorEvent.sensor.getName(), Float.valueOf(sensorEvent.values[0]));
    }

    public l(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService(bi.ac);
        this.f20563b = sensorManager;
        for (Sensor sensor : sensorManager.getSensorList(-1)) {
            if (sensor.getName().toLowerCase().contains("temperature")) {
                this.f20563b.registerListener(this, sensor, 3);
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
