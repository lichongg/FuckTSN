package com.kwad.components.offline.api.core.api;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface ISensorManagerProxy {
    SensorManager checkAndObtainSensorManager(Context context);

    Sensor getDefaultSensor(Context context, int i6);

    boolean registerListener(Context context, SensorEventListener sensorEventListener, Sensor sensor, int i6);

    void unregisterListener(SensorEventListener sensorEventListener);
}
