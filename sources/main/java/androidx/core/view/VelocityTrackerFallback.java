package androidx.core.view;

import android.view.MotionEvent;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
class VelocityTrackerFallback {
    private static final long ASSUME_POINTER_STOPPED_MS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final long RANGE_MS = 100;
    private final float[] mMovements = new float[20];
    private final long[] mEventTimes = new long[20];
    private float mLastComputedVelocity = 0.0f;
    private int mDataPointsBufferSize = 0;
    private int mDataPointsBufferLastUsedIndex = 0;

    private void clear() {
        this.mDataPointsBufferSize = 0;
        this.mLastComputedVelocity = 0.0f;
    }

    private static float kineticEnergyToVelocity(float f6) {
        return (f6 < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f6) * 2.0f));
    }

    void computeCurrentVelocity(int i6) {
        computeCurrentVelocity(i6, Float.MAX_VALUE);
    }

    private float getCurrentVelocity() {
        long[] jArr;
        long j6;
        int i6 = this.mDataPointsBufferSize;
        if (i6 < 2) {
            return 0.0f;
        }
        int i7 = this.mDataPointsBufferLastUsedIndex;
        int i8 = ((i7 + 20) - (i6 - 1)) % 20;
        long j7 = this.mEventTimes[i7];
        while (true) {
            jArr = this.mEventTimes;
            j6 = jArr[i8];
            if (j7 - j6 <= 100) {
                break;
            }
            this.mDataPointsBufferSize--;
            i8 = (i8 + 1) % 20;
        }
        int i9 = this.mDataPointsBufferSize;
        if (i9 < 2) {
            return 0.0f;
        }
        if (i9 == 2) {
            int i10 = (i8 + 1) % 20;
            if (j6 == jArr[i10]) {
                return 0.0f;
            }
            return this.mMovements[i10] / (r2 - j6);
        }
        int i11 = 0;
        float f6 = 0.0f;
        for (int i12 = 0; i12 < this.mDataPointsBufferSize - 1; i12++) {
            int i13 = i12 + i8;
            long[] jArr2 = this.mEventTimes;
            long j8 = jArr2[i13 % 20];
            int i14 = (i13 + 1) % 20;
            if (jArr2[i14] != j8) {
                i11++;
                float kineticEnergyToVelocity = kineticEnergyToVelocity(f6);
                float f7 = this.mMovements[i14] / (this.mEventTimes[i14] - j8);
                f6 += (f7 - kineticEnergyToVelocity) * Math.abs(f7);
                if (i11 == 1) {
                    f6 *= 0.5f;
                }
            }
        }
        return kineticEnergyToVelocity(f6);
    }

    void computeCurrentVelocity(int i6, float f6) {
        float currentVelocity = getCurrentVelocity() * i6;
        this.mLastComputedVelocity = currentVelocity;
        if (currentVelocity < (-Math.abs(f6))) {
            this.mLastComputedVelocity = -Math.abs(f6);
        } else if (this.mLastComputedVelocity > Math.abs(f6)) {
            this.mLastComputedVelocity = Math.abs(f6);
        }
    }

    float getAxisVelocity(int i6) {
        if (i6 != 26) {
            return 0.0f;
        }
        return this.mLastComputedVelocity;
    }

    VelocityTrackerFallback() {
    }

    void addMovement(@NonNull MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.mDataPointsBufferSize != 0 && eventTime - this.mEventTimes[this.mDataPointsBufferLastUsedIndex] > ASSUME_POINTER_STOPPED_MS) {
            clear();
        }
        int i6 = (this.mDataPointsBufferLastUsedIndex + 1) % 20;
        this.mDataPointsBufferLastUsedIndex = i6;
        int i7 = this.mDataPointsBufferSize;
        if (i7 != 20) {
            this.mDataPointsBufferSize = i7 + 1;
        }
        this.mMovements[i6] = motionEvent.getAxisValue(26);
        this.mEventTimes[this.mDataPointsBufferLastUsedIndex] = eventTime;
    }
}
