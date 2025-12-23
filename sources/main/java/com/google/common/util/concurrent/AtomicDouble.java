package com.google.common.util.concurrent;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class AtomicDouble extends Number implements Serializable {
    private static final long serialVersionUID = 0;
    private transient AtomicLong value;

    public AtomicDouble(double d6) {
        this.value = new AtomicLong(Double.doubleToRawLongBits(d6));
    }

    @CanIgnoreReturnValue
    public final double addAndGet(double d6) {
        long j6;
        double longBitsToDouble;
        do {
            j6 = this.value.get();
            longBitsToDouble = Double.longBitsToDouble(j6) + d6;
        } while (!this.value.compareAndSet(j6, Double.doubleToRawLongBits(longBitsToDouble)));
        return longBitsToDouble;
    }

    public final boolean compareAndSet(double d6, double d7) {
        return this.value.compareAndSet(Double.doubleToRawLongBits(d6), Double.doubleToRawLongBits(d7));
    }

    public final double get() {
        return Double.longBitsToDouble(this.value.get());
    }

    @CanIgnoreReturnValue
    public final double getAndAdd(double d6) {
        long j6;
        double longBitsToDouble;
        do {
            j6 = this.value.get();
            longBitsToDouble = Double.longBitsToDouble(j6);
        } while (!this.value.compareAndSet(j6, Double.doubleToRawLongBits(longBitsToDouble + d6)));
        return longBitsToDouble;
    }

    public final boolean weakCompareAndSet(double d6, double d7) {
        return this.value.weakCompareAndSet(Double.doubleToRawLongBits(d6), Double.doubleToRawLongBits(d7));
    }

    public AtomicDouble() {
        this(0.0d);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.value = new AtomicLong();
        set(objectInputStream.readDouble());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeDouble(get());
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return get();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) get();
    }

    public final double getAndSet(double d6) {
        return Double.longBitsToDouble(this.value.getAndSet(Double.doubleToRawLongBits(d6)));
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) get();
    }

    public final void lazySet(double d6) {
        this.value.lazySet(Double.doubleToRawLongBits(d6));
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) get();
    }

    public final void set(double d6) {
        this.value.set(Double.doubleToRawLongBits(d6));
    }

    public String toString() {
        return Double.toString(get());
    }
}
