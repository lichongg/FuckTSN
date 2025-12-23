package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public final class StatsAccumulator {
    private long count = 0;
    private double mean = 0.0d;
    private double sumOfSquaresOfDeltas = 0.0d;
    private double min = Double.NaN;
    private double max = Double.NaN;

    public void addAll(Iterable<? extends Number> iterable) {
        Iterator<? extends Number> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next().doubleValue());
        }
    }

    public void add(double d6) {
        long j6 = this.count;
        if (j6 == 0) {
            this.count = 1L;
            this.mean = d6;
            this.min = d6;
            this.max = d6;
            if (Doubles.isFinite(d6)) {
                return;
            }
            this.sumOfSquaresOfDeltas = Double.NaN;
            return;
        }
        this.count = j6 + 1;
        if (Doubles.isFinite(d6) && Doubles.isFinite(this.mean)) {
            double d7 = this.mean;
            double d8 = d6 - d7;
            double d9 = d7 + (d8 / this.count);
            this.mean = d9;
            this.sumOfSquaresOfDeltas += d8 * (d6 - d9);
        } else {
            this.mean = calculateNewMeanNonFinite(this.mean, d6);
            this.sumOfSquaresOfDeltas = Double.NaN;
        }
        this.min = Math.min(this.min, d6);
        this.max = Math.max(this.max, d6);
    }

    public long count() {
        return this.count;
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

    public final double populationVariance() {
        Preconditions.checkState(this.count != 0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        if (this.count == 1) {
            return 0.0d;
        }
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / this.count;
    }

    public final double sampleVariance() {
        Preconditions.checkState(this.count > 1);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / (this.count - 1);
    }

    public Stats snapshot() {
        return new Stats(this.count, this.mean, this.sumOfSquaresOfDeltas, this.min, this.max);
    }

    public final double sum() {
        return this.mean * this.count;
    }

    double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    static double calculateNewMeanNonFinite(double d6, double d7) {
        if (Doubles.isFinite(d6)) {
            return d7;
        }
        if (!Doubles.isFinite(d7) && d6 != d7) {
            return Double.NaN;
        }
        return d6;
    }

    public void addAll(Iterator<? extends Number> it) {
        while (it.hasNext()) {
            add(it.next().doubleValue());
        }
    }

    public final double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public final double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public void addAll(double... dArr) {
        for (double d6 : dArr) {
            add(d6);
        }
    }

    public void addAll(int... iArr) {
        for (int i6 : iArr) {
            add(i6);
        }
    }

    public void addAll(long... jArr) {
        for (long j6 : jArr) {
            add(j6);
        }
    }

    public void addAll(Stats stats) {
        if (stats.count() == 0) {
            return;
        }
        long j6 = this.count;
        if (j6 == 0) {
            this.count = stats.count();
            this.mean = stats.mean();
            this.sumOfSquaresOfDeltas = stats.sumOfSquaresOfDeltas();
            this.min = stats.min();
            this.max = stats.max();
            return;
        }
        this.count = j6 + stats.count();
        if (Doubles.isFinite(this.mean) && Doubles.isFinite(stats.mean())) {
            double mean = stats.mean();
            double d6 = this.mean;
            double d7 = mean - d6;
            this.mean = d6 + ((stats.count() * d7) / this.count);
            this.sumOfSquaresOfDeltas += stats.sumOfSquaresOfDeltas() + (d7 * (stats.mean() - this.mean) * stats.count());
        } else {
            this.mean = calculateNewMeanNonFinite(this.mean, stats.mean());
            this.sumOfSquaresOfDeltas = Double.NaN;
        }
        this.min = Math.min(this.min, stats.min());
        this.max = Math.max(this.max, stats.max());
    }
}
