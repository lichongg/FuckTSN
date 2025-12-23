package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class ComparisonChain {
    private static final ComparisonChain ACTIVE = new ComparisonChain() { // from class: com.google.common.collect.ComparisonChain.1
        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(Comparable comparable, Comparable comparable2) {
            return classify(comparable.compareTo(comparable2));
        }

        @Override // com.google.common.collect.ComparisonChain
        public int result() {
            return 0;
        }

        ComparisonChain classify(int i6) {
            return i6 < 0 ? ComparisonChain.LESS : i6 > 0 ? ComparisonChain.GREATER : ComparisonChain.ACTIVE;
        }

        @Override // com.google.common.collect.ComparisonChain
        public <T> ComparisonChain compare(@NullableDecl T t5, @NullableDecl T t6, Comparator<T> comparator) {
            return classify(comparator.compare(t5, t6));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(int i6, int i7) {
            return classify(Ints.compare(i6, i7));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareFalseFirst(boolean z5, boolean z6) {
            return classify(Booleans.compare(z5, z6));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareTrueFirst(boolean z5, boolean z6) {
            return classify(Booleans.compare(z6, z5));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(long j6, long j7) {
            return classify(Longs.compare(j6, j7));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(float f6, float f7) {
            return classify(Float.compare(f6, f7));
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(double d6, double d7) {
            return classify(Double.compare(d6, d7));
        }
    };
    private static final ComparisonChain LESS = new InactiveComparisonChain(-1);
    private static final ComparisonChain GREATER = new InactiveComparisonChain(1);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class InactiveComparisonChain extends ComparisonChain {
        final int result;

        InactiveComparisonChain(int i6) {
            super();
            this.result = i6;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(double d6, double d7) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(float f6, float f7) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public int result() {
            return this.result;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(int i6, int i7) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(long j6, long j7) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(@NullableDecl Comparable comparable, @NullableDecl Comparable comparable2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public <T> ComparisonChain compare(@NullableDecl T t5, @NullableDecl T t6, @NullableDecl Comparator<T> comparator) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareFalseFirst(boolean z5, boolean z6) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareTrueFirst(boolean z5, boolean z6) {
            return this;
        }
    }

    public abstract ComparisonChain compare(double d6, double d7);

    public abstract ComparisonChain compare(float f6, float f7);

    public abstract ComparisonChain compare(int i6, int i7);

    public abstract ComparisonChain compare(long j6, long j7);

    @Deprecated
    public final ComparisonChain compare(Boolean bool, Boolean bool2) {
        return compareFalseFirst(bool.booleanValue(), bool2.booleanValue());
    }

    public abstract ComparisonChain compare(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract <T> ComparisonChain compare(@NullableDecl T t5, @NullableDecl T t6, Comparator<T> comparator);

    public abstract ComparisonChain compareFalseFirst(boolean z5, boolean z6);

    public abstract ComparisonChain compareTrueFirst(boolean z5, boolean z6);

    public abstract int result();

    private ComparisonChain() {
    }

    public static ComparisonChain start() {
        return ACTIVE;
    }
}
