package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class PairedStatsAccumulator {
    private final StatsAccumulator xStats = new StatsAccumulator();
    private final StatsAccumulator yStats = new StatsAccumulator();
    private double sumOfProductsOfDeltas = 0.0d;

    private static double ensureInUnitRange(double d6) {
        if (d6 >= 1.0d) {
            return 1.0d;
        }
        if (d6 <= -1.0d) {
            return -1.0d;
        }
        return d6;
    }

    private double ensurePositive(double d6) {
        if (d6 > 0.0d) {
            return d6;
        }
        return Double.MIN_VALUE;
    }

    public void add(double d6, double d7) {
        this.xStats.add(d6);
        if (!Doubles.isFinite(d6) || !Doubles.isFinite(d7)) {
            this.sumOfProductsOfDeltas = Double.NaN;
        } else if (this.xStats.count() > 1) {
            this.sumOfProductsOfDeltas += (d6 - this.xStats.mean()) * (d7 - this.yStats.mean());
        }
        this.yStats.add(d7);
    }

    public long count() {
        return this.xStats.count();
    }

    public PairedStats snapshot() {
        return new PairedStats(this.xStats.snapshot(), this.yStats.snapshot(), this.sumOfProductsOfDeltas);
    }

    public Stats xStats() {
        return this.xStats.snapshot();
    }

    public Stats yStats() {
        return this.yStats.snapshot();
    }

    public void addAll(PairedStats pairedStats) {
        if (pairedStats.count() == 0) {
            return;
        }
        this.xStats.addAll(pairedStats.xStats());
        if (this.yStats.count() == 0) {
            this.sumOfProductsOfDeltas = pairedStats.sumOfProductsOfDeltas();
        } else {
            this.sumOfProductsOfDeltas += pairedStats.sumOfProductsOfDeltas() + ((pairedStats.xStats().mean() - this.xStats.mean()) * (pairedStats.yStats().mean() - this.yStats.mean()) * pairedStats.count());
        }
        this.yStats.addAll(pairedStats.yStats());
    }

    public final LinearTransformation leastSquaresFit() {
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

    public final double pearsonsCorrelationCoefficient() {
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
        double sumOfSquaresOfDeltas = this.xStats.sumOfSquaresOfDeltas();
        double sumOfSquaresOfDeltas2 = this.yStats.sumOfSquaresOfDeltas();
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

    public final double sampleCovariance() {
        boolean z5;
        if (count() > 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkState(z5);
        return this.sumOfProductsOfDeltas / (count() - 1);
    }
}
