package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class PairedStats implements Serializable {
    private static final int BYTES = 88;
    private static final long serialVersionUID = 0;
    private final double sumOfProductsOfDeltas;
    private final Stats xStats;
    private final Stats yStats;

    public boolean equals(@NullableDecl Object obj) {
        if (obj == null || PairedStats.class != obj.getClass()) {
            return false;
        }
        PairedStats pairedStats = (PairedStats) obj;
        return this.xStats.equals(pairedStats.xStats) && this.yStats.equals(pairedStats.yStats) && Double.doubleToLongBits(this.sumOfProductsOfDeltas) == Double.doubleToLongBits(pairedStats.sumOfProductsOfDeltas);
    }

    private static double ensureInUnitRange(double d6) {
        if (d6 >= 1.0d) {
            return 1.0d;
        }
        if (d6 <= -1.0d) {
            return -1.0d;
        }
        return d6;
    }

    private static double ensurePositive(double d6) {
        if (d6 > 0.0d) {
            return d6;
        }
        return Double.MIN_VALUE;
    }

    public long count() {
        return this.xStats.count();
    }

    public int hashCode() {
        return Objects.hashCode(this.xStats, this.yStats, Double.valueOf(this.sumOfProductsOfDeltas));
    }

    double sumOfProductsOfDeltas() {
        return this.sumOfProductsOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer order = ByteBuffer.allocate(88).order(ByteOrder.LITTLE_ENDIAN);
        this.xStats.writeTo(order);
        this.yStats.writeTo(order);
        order.putDouble(this.sumOfProductsOfDeltas);
        return order.array();
    }

    public Stats xStats() {
        return this.xStats;
    }

    public Stats yStats() {
        return this.yStats;
    }

    PairedStats(Stats stats, Stats stats2, double d6) {
        this.xStats = stats;
        this.yStats = stats2;
        this.sumOfProductsOfDeltas = d6;
    }

    public static PairedStats fromByteArray(byte[] bArr) {
        boolean z5;
        Preconditions.checkNotNull(bArr);
        if (bArr.length == 88) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "Expected PairedStats.BYTES = %s, got %s", 88, bArr.length);
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        return new PairedStats(Stats.readFrom(order), Stats.readFrom(order), order.getDouble());
    }

    public LinearTransformation leastSquaresFit() {
        boolean z5;
        boolean z6 = false;
        if (count() > 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState(z5);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return LinearTransformation.forNaN();
        }
        double sumOfSquaresOfDeltas = this.xStats.sumOfSquaresOfDeltas();
        if (sumOfSquaresOfDeltas > 0.0d) {
            if (this.yStats.sumOfSquaresOfDeltas() > 0.0d) {
                return LinearTransformation.mapping(this.xStats.mean(), this.yStats.mean()).withSlope(this.sumOfProductsOfDeltas / sumOfSquaresOfDeltas);
            }
            return LinearTransformation.horizontal(this.yStats.mean());
        }
        if (this.yStats.sumOfSquaresOfDeltas() > 0.0d) {
            z6 = true;
        }
        Preconditions.checkState(z6);
        return LinearTransformation.vertical(this.xStats.mean());
    }

    public double pearsonsCorrelationCoefficient() {
        boolean z5;
        boolean z6;
        boolean z7 = false;
        if (count() > 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState(z5);
        if (Double.isNaN(this.sumOfProductsOfDeltas)) {
            return Double.NaN;
        }
        double sumOfSquaresOfDeltas = xStats().sumOfSquaresOfDeltas();
        double sumOfSquaresOfDeltas2 = yStats().sumOfSquaresOfDeltas();
        if (sumOfSquaresOfDeltas > 0.0d) {
            z6 = true;
        } else {
            z6 = false;
        }
        Preconditions.checkState(z6);
        if (sumOfSquaresOfDeltas2 > 0.0d) {
            z7 = true;
        }
        Preconditions.checkState(z7);
        return ensureInUnitRange(this.sumOfProductsOfDeltas / Math.sqrt(ensurePositive(sumOfSquaresOfDeltas * sumOfSquaresOfDeltas2)));
    }

    public double populationCovariance() {
        boolean z5;
        if (count() != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState(z5);
        return this.sumOfProductsOfDeltas / count();
    }

    public double sampleCovariance() {
        boolean z5;
        if (count() > 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState(z5);
        return this.sumOfProductsOfDeltas / (count() - 1);
    }

    public String toString() {
        if (count() > 0) {
            return MoreObjects.toStringHelper(this).add("xStats", this.xStats).add("yStats", this.yStats).add("populationCovariance", populationCovariance()).toString();
        }
        return MoreObjects.toStringHelper(this).add("xStats", this.xStats).add("yStats", this.yStats).toString();
    }
}
