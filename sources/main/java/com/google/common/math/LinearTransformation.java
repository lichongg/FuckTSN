package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Beta
@GwtIncompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class LinearTransformation {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.common.math.LinearTransformation$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class LinearTransformationBuilder {

        /* renamed from: x1, reason: collision with root package name */
        private final double f32776x1;

        /* renamed from: y1, reason: collision with root package name */
        private final double f32777y1;

        /* synthetic */ LinearTransformationBuilder(double d6, double d7, AnonymousClass1 anonymousClass1) {
            this(d6, d7);
        }

        private LinearTransformationBuilder(double d6, double d7) {
            this.f32776x1 = d6;
            this.f32777y1 = d7;
        }

        public LinearTransformation and(double d6, double d7) {
            boolean z5;
            boolean z6 = false;
            if (DoubleUtils.isFinite(d6) && DoubleUtils.isFinite(d7)) {
                z5 = true;
            } else {
                z5 = false;
            }
            Preconditions.checkArgument(z5);
            double d8 = this.f32776x1;
            if (d6 == d8) {
                if (d7 != this.f32777y1) {
                    z6 = true;
                }
                Preconditions.checkArgument(z6);
                return new VerticalLinearTransformation(this.f32776x1);
            }
            return withSlope((d7 - this.f32777y1) / (d6 - d8));
        }

        public LinearTransformation withSlope(double d6) {
            Preconditions.checkArgument(!Double.isNaN(d6));
            if (DoubleUtils.isFinite(d6)) {
                return new RegularLinearTransformation(d6, this.f32777y1 - (this.f32776x1 * d6));
            }
            return new VerticalLinearTransformation(this.f32776x1);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class NaNLinearTransformation extends LinearTransformation {
        static final NaNLinearTransformation INSTANCE = new NaNLinearTransformation();

        @Override // com.google.common.math.LinearTransformation
        public boolean isHorizontal() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isVertical() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public double slope() {
            return Double.NaN;
        }

        public String toString() {
            return "NaN";
        }

        @Override // com.google.common.math.LinearTransformation
        public double transform(double d6) {
            return Double.NaN;
        }

        private NaNLinearTransformation() {
        }

        @Override // com.google.common.math.LinearTransformation
        public LinearTransformation inverse() {
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class RegularLinearTransformation extends LinearTransformation {

        @LazyInit
        LinearTransformation inverse;
        final double slope;
        final double yIntercept;

        RegularLinearTransformation(double d6, double d7) {
            this.slope = d6;
            this.yIntercept = d7;
            this.inverse = null;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isVertical() {
            return false;
        }

        private LinearTransformation createInverse() {
            double d6 = this.slope;
            return d6 != 0.0d ? new RegularLinearTransformation(1.0d / d6, (this.yIntercept * (-1.0d)) / d6, this) : new VerticalLinearTransformation(this.yIntercept, this);
        }

        @Override // com.google.common.math.LinearTransformation
        public LinearTransformation inverse() {
            LinearTransformation linearTransformation = this.inverse;
            if (linearTransformation != null) {
                return linearTransformation;
            }
            LinearTransformation createInverse = createInverse();
            this.inverse = createInverse;
            return createInverse;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isHorizontal() {
            return this.slope == 0.0d;
        }

        @Override // com.google.common.math.LinearTransformation
        public double slope() {
            return this.slope;
        }

        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.slope), Double.valueOf(this.yIntercept));
        }

        @Override // com.google.common.math.LinearTransformation
        public double transform(double d6) {
            return (d6 * this.slope) + this.yIntercept;
        }

        RegularLinearTransformation(double d6, double d7, LinearTransformation linearTransformation) {
            this.slope = d6;
            this.yIntercept = d7;
            this.inverse = linearTransformation;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class VerticalLinearTransformation extends LinearTransformation {

        @LazyInit
        LinearTransformation inverse;

        /* renamed from: x, reason: collision with root package name */
        final double f32778x;

        VerticalLinearTransformation(double d6) {
            this.f32778x = d6;
            this.inverse = null;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isHorizontal() {
            return false;
        }

        @Override // com.google.common.math.LinearTransformation
        public boolean isVertical() {
            return true;
        }

        private LinearTransformation createInverse() {
            return new RegularLinearTransformation(0.0d, this.f32778x, this);
        }

        @Override // com.google.common.math.LinearTransformation
        public LinearTransformation inverse() {
            LinearTransformation linearTransformation = this.inverse;
            if (linearTransformation != null) {
                return linearTransformation;
            }
            LinearTransformation createInverse = createInverse();
            this.inverse = createInverse;
            return createInverse;
        }

        @Override // com.google.common.math.LinearTransformation
        public double slope() {
            throw new IllegalStateException();
        }

        public String toString() {
            return String.format("x = %g", Double.valueOf(this.f32778x));
        }

        @Override // com.google.common.math.LinearTransformation
        public double transform(double d6) {
            throw new IllegalStateException();
        }

        VerticalLinearTransformation(double d6, LinearTransformation linearTransformation) {
            this.f32778x = d6;
            this.inverse = linearTransformation;
        }
    }

    public abstract LinearTransformation inverse();

    public abstract boolean isHorizontal();

    public abstract boolean isVertical();

    public abstract double slope();

    public abstract double transform(double d6);

    public static LinearTransformation forNaN() {
        return NaNLinearTransformation.INSTANCE;
    }

    public static LinearTransformation horizontal(double d6) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d6));
        return new RegularLinearTransformation(0.0d, d6);
    }

    public static LinearTransformationBuilder mapping(double d6, double d7) {
        boolean z5;
        if (DoubleUtils.isFinite(d6) && DoubleUtils.isFinite(d7)) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5);
        return new LinearTransformationBuilder(d6, d7, null);
    }

    public static LinearTransformation vertical(double d6) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d6));
        return new VerticalLinearTransformation(d6);
    }
}
