package com.kwad.sdk.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class bk {
    private static bk baG;
    private SensorManager baH;

    public static bk RC() {
        if (baG == null) {
            synchronized (bk.class) {
                try {
                    if (baG == null) {
                        baG = new bk();
                    }
                } finally {
                }
            }
        }
        return baG;
    }

    private SensorManager dM(Context context) {
        if (this.baH == null) {
            this.baH = (SensorManager) context.getSystemService(com.umeng.analytics.pro.bi.ac);
        }
        return this.baH;
    }

    public final Sensor getDefaultSensor(Context context, int i6) {
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "getDefaultSensor type:" + i6);
        if (RE()) {
            return dM(context).getDefaultSensor(i6);
        }
        return null;
    }

    public final boolean registerListener(Context context, SensorEventListener sensorEventListener, Sensor sensor, int i6) {
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "registerListener sensor:" + sensor + ", listener: " + sensorEventListener);
        if (!RE()) {
            return false;
        }
        try {
            return dM(context).registerListener(sensorEventListener, sensor, i6);
        } catch (Exception unused) {
            return false;
        }
    }

    public final void unregisterListener(SensorEventListener sensorEventListener) {
        SensorManager sensorManager;
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "unregisterListener listener:" + sensorEventListener);
        if (RE() && (sensorManager = this.baH) != null) {
            try {
                sensorManager.unregisterListener(sensorEventListener);
            } catch (Throwable unused) {
            }
        }
    }

    private static boolean RD() {
        return !bc.useSensorManagerDisable();
    }

    private boolean RE() {
        boolean RD = RD();
        com.kwad.sdk.core.d.c.d("SensorManagerWrapper", "checkEnableSensor enable:" + RD);
        if (RD) {
            return true;
        }
        this.baH = null;
        return false;
    }

    public final SensorManager checkAndObtainSensorManager(Context context) {
        if (!RE()) {
            return null;
        }
        return dM(context);
    }
}
