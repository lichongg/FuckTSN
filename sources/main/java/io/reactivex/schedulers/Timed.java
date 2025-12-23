package io.reactivex.schedulers;

import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Timed<T> {
    final long time;
    final TimeUnit unit;
    final T value;

    public long time() {
        return this.time;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Timed) {
            Timed timed = (Timed) obj;
            if (ObjectHelper.equals(this.value, timed.value) && this.time == timed.time && ObjectHelper.equals(this.unit, timed.unit)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        T t5 = this.value;
        int hashCode = t5 != null ? t5.hashCode() : 0;
        long j6 = this.time;
        return (((hashCode * 31) + ((int) (j6 ^ (j6 >>> 31)))) * 31) + this.unit.hashCode();
    }

    public long time(TimeUnit timeUnit) {
        return timeUnit.convert(this.time, this.unit);
    }

    public String toString() {
        return "Timed[time=" + this.time + ", unit=" + this.unit + ", value=" + this.value + "]";
    }

    public TimeUnit unit() {
        return this.unit;
    }

    public T value() {
        return this.value;
    }

    public Timed(T t5, long j6, TimeUnit timeUnit) {
        this.value = t5;
        this.time = j6;
        this.unit = (TimeUnit) ObjectHelper.requireNonNull(timeUnit, "unit is null");
    }
}
