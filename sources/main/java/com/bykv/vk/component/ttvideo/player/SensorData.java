package com.bykv.vk.component.ttvideo.player;

import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.bytedance.sdk.component.utils.vl;

@Keep
/* loaded from: D:\Downloads\app\classes3.dex */
public class SensorData {
    protected static final int Sensor_ACC_Data = 1;
    protected static final int Sensor_MAG_Data = 2;
    protected static final int Sensor_ROT_Data = 3;
    private long mHandle = 0;
    private SensorManager mSensorManager = null;
    private SensorEventListener mListener = null;
    private float[] magnet = new float[3];
    private float[] accel = new float[3];

    private static final native void _writeData(long j6, int i6, float f6, float f7, float f8);

    public Boolean initListeners() {
        return Boolean.FALSE;
    }

    @CalledByNative
    public void setHandle(long j6, TTPlayer tTPlayer) {
        this.mHandle = j6;
        tTPlayer.getContext();
    }

    @CalledByNative
    public void stop() {
        vl.r("ttmn", "stop sensor");
        this.mHandle = 0L;
    }

    protected void finalize() {
        stop();
    }

    @CalledByNative
    public int start() {
        if (initListeners().booleanValue()) {
            return 0;
        }
        return -1;
    }
}
