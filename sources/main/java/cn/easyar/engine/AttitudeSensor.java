package cn.easyar.engine;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.umeng.analytics.pro.bi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class AttitudeSensor {
    private SensorManager manager_;
    private Sensor sensor_;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface IClosable {
        void close();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface IOnUpdated {
        void invoke(float v02, float v12, float v22, float v32, long timestamp);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class NativeOnUpdated implements IOnUpdated {
        public long ptr;

        @Override // cn.easyar.engine.AttitudeSensor.IOnUpdated
        public native void invoke(float v02, float v12, float v22, float v32, long timestamp);
    }

    public boolean isAvailable() {
        return this.sensor_ != null;
    }

    public IClosable open(int samplingPeriodUs, final IOnUpdated onUpdated) {
        if (this.sensor_ == null) {
            return null;
        }
        final SensorEventListener sensorEventListener = new SensorEventListener() { // from class: cn.easyar.engine.AttitudeSensor.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] fArr = sensorEvent.values;
                float f6 = fArr[0];
                float f7 = fArr[1];
                float f8 = fArr[2];
                float max = Math.max(0.0f, 1.0f - (((f6 * f6) + (f7 * f7)) + (f8 * f8)));
                IOnUpdated iOnUpdated = onUpdated;
                float sqrt = (float) Math.sqrt(max);
                float[] fArr2 = sensorEvent.values;
                iOnUpdated.invoke(sqrt, fArr2[0], fArr2[1], fArr2[2], sensorEvent.timestamp);
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i6) {
            }
        };
        if (this.manager_.registerListener(sensorEventListener, this.sensor_, samplingPeriodUs)) {
            return new IClosable() { // from class: cn.easyar.engine.AttitudeSensor.2
                @Override // cn.easyar.engine.AttitudeSensor.IClosable
                public void close() {
                    AttitudeSensor.this.manager_.unregisterListener(sensorEventListener);
                }
            };
        }
        return null;
    }

    public AttitudeSensor(Context appContext) {
        SensorManager sensorManager = (SensorManager) appContext.getSystemService(bi.ac);
        this.manager_ = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(15);
        this.sensor_ = defaultSensor;
        if (defaultSensor == null) {
            this.sensor_ = this.manager_.getDefaultSensor(11);
        }
    }
}
