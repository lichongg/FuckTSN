package androidx.camera.core.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
final class LongRational {
    private final long mDenominator;
    private final long mNumerator;

    LongRational(long j6, long j7) {
        this.mNumerator = j6;
        this.mDenominator = j7;
    }

    long getDenominator() {
        return this.mDenominator;
    }

    long getNumerator() {
        return this.mNumerator;
    }

    double toDouble() {
        return this.mNumerator / this.mDenominator;
    }

    @NonNull
    public String toString() {
        return this.mNumerator + "/" + this.mDenominator;
    }

    LongRational(double d6) {
        this((long) (d6 * 10000.0d), 10000L);
    }
}
