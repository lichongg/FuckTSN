package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.primitives.ImmutableLongArray;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public class AtomicDoubleArray implements Serializable {
    private static final long serialVersionUID = 0;
    private transient AtomicLongArray longs;

    public AtomicDoubleArray(int i6) {
        this.longs = new AtomicLongArray(i6);
    }

    @CanIgnoreReturnValue
    public double addAndGet(int i6, double d6) {
        while (true) {
            long j6 = this.longs.get(i6);
            double longBitsToDouble = Double.longBitsToDouble(j6) + d6;
            int i7 = i6;
            if (this.longs.compareAndSet(i7, j6, Double.doubleToRawLongBits(longBitsToDouble))) {
                return longBitsToDouble;
            }
            i6 = i7;
        }
    }

    public final boolean compareAndSet(int i6, double d6, double d7) {
        return this.longs.compareAndSet(i6, Double.doubleToRawLongBits(d6), Double.doubleToRawLongBits(d7));
    }

    public final double get(int i6) {
        return Double.longBitsToDouble(this.longs.get(i6));
    }

    @CanIgnoreReturnValue
    public final double getAndAdd(int i6, double d6) {
        while (true) {
            long j6 = this.longs.get(i6);
            double longBitsToDouble = Double.longBitsToDouble(j6);
            int i7 = i6;
            if (this.longs.compareAndSet(i7, j6, Double.doubleToRawLongBits(longBitsToDouble + d6))) {
                return longBitsToDouble;
            }
            i6 = i7;
        }
    }

    public final int length() {
        return this.longs.length();
    }

    public final boolean weakCompareAndSet(int i6, double d6, double d7) {
        return this.longs.weakCompareAndSet(i6, Double.doubleToRawLongBits(d6), Double.doubleToRawLongBits(d7));
    }

    public AtomicDoubleArray(double[] dArr) {
        int length = dArr.length;
        long[] jArr = new long[length];
        for (int i6 = 0; i6 < length; i6++) {
            jArr[i6] = Double.doubleToRawLongBits(dArr[i6]);
        }
        this.longs = new AtomicLongArray(jArr);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        ImmutableLongArray.Builder builder = ImmutableLongArray.builder();
        for (int i6 = 0; i6 < readInt; i6++) {
            builder.add(Double.doubleToRawLongBits(objectInputStream.readDouble()));
        }
        this.longs = new AtomicLongArray(builder.build().toArray());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int length = length();
        objectOutputStream.writeInt(length);
        for (int i6 = 0; i6 < length; i6++) {
            objectOutputStream.writeDouble(get(i6));
        }
    }

    public final double getAndSet(int i6, double d6) {
        return Double.longBitsToDouble(this.longs.getAndSet(i6, Double.doubleToRawLongBits(d6)));
    }

    public final void lazySet(int i6, double d6) {
        this.longs.lazySet(i6, Double.doubleToRawLongBits(d6));
    }

    public final void set(int i6, double d6) {
        this.longs.set(i6, Double.doubleToRawLongBits(d6));
    }

    public String toString() {
        int length = length();
        int i6 = length - 1;
        if (i6 == -1) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(length * 19);
        sb.append('[');
        int i7 = 0;
        while (true) {
            sb.append(Double.longBitsToDouble(this.longs.get(i7)));
            if (i7 == i6) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(StringUtil.COMMA);
            sb.append(' ');
            i7++;
        }
    }
}
