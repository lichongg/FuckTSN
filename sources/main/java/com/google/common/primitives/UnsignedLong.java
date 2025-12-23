package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.math.BigInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(serializable = true)
/* loaded from: D:\Downloads\app\classes5.dex */
public final class UnsignedLong extends Number implements Comparable<UnsignedLong>, Serializable {
    private static final long UNSIGNED_MASK = Long.MAX_VALUE;
    private final long value;
    public static final UnsignedLong ZERO = new UnsignedLong(0);
    public static final UnsignedLong ONE = new UnsignedLong(1);
    public static final UnsignedLong MAX_VALUE = new UnsignedLong(-1);

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(long j6) {
        Preconditions.checkArgument(j6 >= 0, "value (%s) is outside the range for an unsigned long value", j6);
        return fromLongBits(j6);
    }

    public String toString() {
        return UnsignedLongs.toString(this.value);
    }

    public static UnsignedLong fromLongBits(long j6) {
        return new UnsignedLong(j6);
    }

    public BigInteger bigIntegerValue() {
        BigInteger valueOf = BigInteger.valueOf(this.value & Long.MAX_VALUE);
        return this.value < 0 ? valueOf.setBit(63) : valueOf;
    }

    @Override // java.lang.Comparable
    public int compareTo(UnsignedLong unsignedLong) {
        Preconditions.checkNotNull(unsignedLong);
        return UnsignedLongs.compare(this.value, unsignedLong.value);
    }

    public UnsignedLong dividedBy(UnsignedLong unsignedLong) {
        return fromLongBits(UnsignedLongs.divide(this.value, ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        long j6 = this.value;
        double d6 = Long.MAX_VALUE & j6;
        return j6 < 0 ? d6 + 9.223372036854776E18d : d6;
    }

    public boolean equals(@NullableDecl Object obj) {
        return (obj instanceof UnsignedLong) && this.value == ((UnsignedLong) obj).value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        long j6 = this.value;
        float f6 = Long.MAX_VALUE & j6;
        return j6 < 0 ? f6 + 9.223372E18f : f6;
    }

    public int hashCode() {
        return Longs.hashCode(this.value);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public UnsignedLong minus(UnsignedLong unsignedLong) {
        return fromLongBits(this.value - ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value);
    }

    public UnsignedLong mod(UnsignedLong unsignedLong) {
        return fromLongBits(UnsignedLongs.remainder(this.value, ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value));
    }

    public UnsignedLong plus(UnsignedLong unsignedLong) {
        return fromLongBits(this.value + ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value);
    }

    public UnsignedLong times(UnsignedLong unsignedLong) {
        return fromLongBits(this.value * ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value);
    }

    public String toString(int i6) {
        return UnsignedLongs.toString(this.value, i6);
    }

    private UnsignedLong(long j6) {
        this.value = j6;
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger);
        Preconditions.checkArgument(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 64, "value (%s) is outside the range for an unsigned long value", bigInteger);
        return fromLongBits(bigInteger.longValue());
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(String str) {
        return valueOf(str, 10);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(String str, int i6) {
        return fromLongBits(UnsignedLongs.parseUnsignedLong(str, i6));
    }
}
