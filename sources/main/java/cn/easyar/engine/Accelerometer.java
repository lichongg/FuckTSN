package cn.easyar.engine;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.umeng.analytics.pro.bi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class Accelerometer {
    private SensorManager manager_;
    private Sensor sensor_;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface IClosable {
        void close();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface IOnUpdated {
        void invoke(float x5, float y5, float z5, long timestamp);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class NativeOnUpdated implements IOnUpdated {
        public long ptr;

        @Override // cn.easyar.engine.Accelerometer.IOnUpdated
        public native void invoke(float x5, float y5, float z5, long timestamp);
    }

    public boolean isAvailable() {
        return this.sensor_ != null;
    }

    public IClosable open(int samplingPeriodUs, final IOnUpdated onUpdated) {
        if (this.sensor_ == null) {
            return null;
        }
        final SensorEventListener sensorEventListener = new SensorEventListener() { // from class: cn.easyar.engine.Accelerometer.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                IOnUpdated iOnUpdated = onUpdated;
                float[] fArr = sensorEvent.values;
                iOnUpdated.invoke(fArr[0], fArr[1], fArr[2], sensorEvent.timestamp);
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i6) {
            }
        };
        if (this.manager_.registerListener(sensorEventListener, this.sensor_, samplingPeriodUs)) {
            return new IClosable() { // from class: cn.easyar.engine.Accelerometer.2
                @Override // cn.easyar.engine.Accelerometer.IClosable
                public void close() {
                    Accelerometer.this.manager_.unregisterListener(sensorEventListener);
                }
            };
        }
        return null;
    }

    public Accelerometer(Context appContext) {
        SensorManager sensorManager = (SensorManager) appContext.getSystemService(bi.ac);
        this.manager_ = sensorManager;
        this.sensor_ = sensorManager.getDefaultSensor(1);
    }
}
