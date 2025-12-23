package cn.easyar.engine;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.umeng.analytics.pro.bi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class MotionSensor {
    private Sensor attitudeSensor_;
    private Sensor gravitySensor_;
    private Sensor gyroscopeSensor_;
    private Sensor linearAccelerationSensor_;
    private SensorManager manager_;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface IClosable {
        void close();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface IOnUpdated {
        void updateAttitudeData(float v02, float v12, float v22, float v32, long timestamp);

        void updateGravityData(float x5, float y5, float z5, long timestamp);

        void updateGyroscopeData(float x5, float y5, float z5, long timestamp);

        void updateLinearAccelerationData(float x5, float y5, float z5, long timestamp);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class NativeOnUpdated implements IOnUpdated {
        public long ptr;

        @Override // cn.easyar.engine.MotionSensor.IOnUpdated
        public native void updateAttitudeData(float v02, float v12, float v22, float v32, long timestamp);

        @Override // cn.easyar.engine.MotionSensor.IOnUpdated
        public native void updateGravityData(float x5, float y5, float z5, long timestamp);

        @Override // cn.easyar.engine.MotionSensor.IOnUpdated
        public native void updateGyroscopeData(float x5, float y5, float z5, long timestamp);

        @Override // cn.easyar.engine.MotionSensor.IOnUpdated
        public native void updateLinearAccelerationData(float x5, float y5, float z5, long timestamp);
    }

    public boolean isAvailable() {
        return (this.gravitySensor_ == null || this.linearAccelerationSensor_ == null || this.gyroscopeSensor_ == null || this.attitudeSensor_ == null) ? false : true;
    }

    public MotionSensor(Context appContext) {
        SensorManager sensorManager = (SensorManager) appContext.getSystemService(bi.ac);
        this.manager_ = sensorManager;
        this.gravitySensor_ = sensorManager.getDefaultSensor(9);
        this.linearAccelerationSensor_ = this.manager_.getDefaultSensor(10);
        this.gyroscopeSensor_ = this.manager_.getDefaultSensor(4);
        Sensor defaultSensor = this.manager_.getDefaultSensor(15);
        this.attitudeSensor_ = defaultSensor;
        if (defaultSensor == null) {
            this.attitudeSensor_ = this.manager_.getDefaultSensor(11);
        }
    }

    public IClosable open(int samplingPeriodUs, final IOnUpdated onUpdated) {
        if (!isAvailable()) {
            return null;
        }
        final SensorEventListener sensorEventListener = new SensorEventListener() { // from class: cn.easyar.engine.MotionSensor.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                IOnUpdated iOnUpdated = onUpdated;
                float[] fArr = sensorEvent.values;
                iOnUpdated.updateGravityData(fArr[0], fArr[1], fArr[2], sensorEvent.timestamp);
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i6) {
            }
        };
        final SensorEventListener sensorEventListener2 = new SensorEventListener() { // from class: cn.easyar.engine.MotionSensor.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                IOnUpdated iOnUpdated = onUpdated;
                float[] fArr = sensorEvent.values;
                iOnUpdated.updateLinearAccelerationData(fArr[0], fArr[1], fArr[2], sensorEvent.timestamp);
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i6) {
            }
        };
        final SensorEventListener sensorEventListener3 = new SensorEventListener() { // from class: cn.easyar.engine.MotionSensor.3
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                IOnUpdated iOnUpdated = onUpdated;
                float[] fArr = sensorEvent.values;
                iOnUpdated.updateGyroscopeData(fArr[0], fArr[1], fArr[2], sensorEvent.timestamp);
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i6) {
            }
        };
        final SensorEventListener sensorEventListener4 = new SensorEventListener() { // from class: cn.easyar.engine.MotionSensor.4
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
                iOnUpdated.updateAttitudeData(sqrt, fArr2[0], fArr2[1], fArr2[2], sensorEvent.timestamp);
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i6) {
            }
        };
        if (!this.manager_.registerListener(sensorEventListener, this.gravitySensor_, samplingPeriodUs)) {
            return null;
        }
        if (!this.manager_.registerListener(sensorEventListener2, this.linearAccelerationSensor_, samplingPeriodUs)) {
            this.manager_.unregisterListener(sensorEventListener);
            return null;
        }
        if (!this.manager_.registerListener(sensorEventListener3, this.gyroscopeSensor_, samplingPeriodUs)) {
            this.manager_.unregisterListener(sensorEventListener);
            this.manager_.unregisterListener(sensorEventListener2);
            return null;
        }
        if (!this.manager_.registerListener(sensorEventListener4, this.attitudeSensor_, samplingPeriodUs)) {
            this.manager_.unregisterListener(sensorEventListener);
            this.manager_.unregisterListener(sensorEventListener2);
            this.manager_.unregisterListener(sensorEventListener3);
            return null;
        }
        return new IClosable() { // from class: cn.easyar.engine.MotionSensor.5
            @Override // cn.easyar.engine.MotionSensor.IClosable
            public void close() {
                MotionSensor.this.manager_.unregisterListener(sensorEventListener);
                MotionSensor.this.manager_.unregisterListener(sensorEventListener2);
                MotionSensor.this.manager_.unregisterListener(sensorEventListener3);
                MotionSensor.this.manager_.unregisterListener(sensorEventListener4);
            }
        };
    }
}
