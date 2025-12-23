package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class Stats implements Serializable {
    static final int BYTES = 40;
    private static final long serialVersionUID = 0;
    private final long count;
    private final double max;
    private final double mean;
    private final double min;
    private final double sumOfSquaresOfDeltas;

    public static double meanOf(Iterable<? extends Number> iterable) {
        return meanOf(iterable.iterator());
    }

    public static Stats of(Iterable<? extends Number> iterable) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(iterable);
        return statsAccumulator.snapshot();
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == null || Stats.class != obj.getClass()) {
            return false;
        }
        Stats stats = (Stats) obj;
        return this.count == stats.count && Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(stats.mean) && Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(stats.sumOfSquaresOfDeltas) && Double.doubleToLongBits(this.min) == Double.doubleToLongBits(stats.min) && Double.doubleToLongBits(this.max) == Double.doubleToLongBits(stats.max);
    }

    public static double meanOf(Iterator<? extends Number> it) {
        Preconditions.checkArgument(it.hasNext());
        double doubleValue = it.next().doubleValue();
        long j6 = 1;
        while (it.hasNext()) {
            double doubleValue2 = it.next().doubleValue();
            j6++;
            doubleValue = (Doubles.isFinite(doubleValue2) && Doubles.isFinite(doubleValue)) ? doubleValue + ((doubleValue2 - doubleValue) / j6) : StatsAccumulator.calculateNewMeanNonFinite(doubleValue, doubleValue2);
        }
        return doubleValue;
    }

    public long count() {
        return this.count;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max));
    }

    public double max() {
        Preconditions.checkState(this.count != 0);
        return this.max;
    }

    public double mean() {
        Preconditions.checkState(this.count != 0);
        return this.mean;
    }

    public double min() {
        Preconditions.checkState(this.count != 0);
        return this.min;
    }

    public double populationVariance() {
        Preconditions.checkState(this.count > 0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        if (this.count == 1) {
            return 0.0d;
        }
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / count();
    }

    public double sampleVariance() {
        Preconditions.checkState(this.count > 1);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / (this.count - 1);
    }

    public double sum() {
        return this.mean * this.count;
    }

    double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer order = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
        writeTo(order);
        return order.array();
    }

    Stats(long j6, double d6, double d7, double d8, double d9) {
        this.count = j6;
        this.mean = d6;
        this.sumOfSquaresOfDeltas = d7;
        this.min = d8;
        this.max = d9;
    }

    public static Stats fromByteArray(byte[] bArr) {
        boolean z5;
        Preconditions.checkNotNull(bArr);
        if (bArr.length == 40) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "Expected Stats.BYTES = %s remaining , got %s", 40, bArr.length);
        return readFrom(ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN));
    }

    static Stats readFrom(ByteBuffer byteBuffer) {
        boolean z5;
        Preconditions.checkNotNull(byteBuffer);
        if (byteBuffer.remaining() >= 40) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        return new Stats(byteBuffer.getLong(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble());
    }

    public double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public String toString() {
        if (count() > 0) {
            return MoreObjects.toStringHelper(this).add("count", this.count).add("mean", this.mean).add("populationStandardDeviation", populationStandardDeviation()).add("min", this.min).add("max", this.max).toString();
        }
        return MoreObjects.toStringHelper(this).add("count", this.count).toString();
    }

    void writeTo(ByteBuffer byteBuffer) {
        boolean z5;
        Preconditions.checkNotNull(byteBuffer);
        if (byteBuffer.remaining() >= 40) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        byteBuffer.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
    }

    public static Stats of(Iterator<? extends Number> it) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(it);
        return statsAccumulator.snapshot();
    }

    public static Stats of(double... dArr) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(dArr);
        return statsAccumulator.snapshot();
    }

    public static double meanOf(double... dArr) {
        Preconditions.checkArgument(dArr.length > 0);
        double d6 = dArr[0];
        for (int i6 = 1; i6 < dArr.length; i6++) {
            double d7 = dArr[i6];
            d6 = (Doubles.isFinite(d7) && Doubles.isFinite(d6)) ? d6 + ((d7 - d6) / (i6 + 1)) : StatsAccumulator.calculateNewMeanNonFinite(d6, d7);
        }
        return d6;
    }

    public static Stats of(int... iArr) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(iArr);
        return statsAccumulator.snapshot();
    }

    public static Stats of(long... jArr) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(jArr);
        return statsAccumulator.snapshot();
    }

    public static double meanOf(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        double d6 = iArr[0];
        for (int i6 = 1; i6 < iArr.length; i6++) {
            double d7 = iArr[i6];
            d6 = (Doubles.isFinite(d7) && Doubles.isFinite(d6)) ? d6 + ((d7 - d6) / (i6 + 1)) : StatsAccumulator.calculateNewMeanNonFinite(d6, d7);
        }
        return d6;
    }

    public static double meanOf(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        double d6 = jArr[0];
        for (int i6 = 1; i6 < jArr.length; i6++) {
            double d7 = jArr[i6];
            d6 = (Doubles.isFinite(d7) && Doubles.isFinite(d6)) ? d6 + ((d7 - d6) / (i6 + 1)) : StatsAccumulator.calculateNewMeanNonFinite(d6, d7);
        }
        return d6;
    }
}
