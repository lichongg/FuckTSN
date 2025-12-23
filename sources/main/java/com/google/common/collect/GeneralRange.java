package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.netty.util.internal.StringUtil;
import java.io.Serializable;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible(serializable = true)
/* loaded from: D:\Downloads\app\classes5.dex */
final class GeneralRange<T> implements Serializable {
    private final Comparator<? super T> comparator;
    private final boolean hasLowerBound;
    private final boolean hasUpperBound;
    private final BoundType lowerBoundType;

    @NullableDecl
    private final T lowerEndpoint;

    @MonotonicNonNullDecl
    private transient GeneralRange<T> reverse;
    private final BoundType upperBoundType;

    @NullableDecl
    private final T upperEndpoint;

    static <T> GeneralRange<T> all(Comparator<? super T> comparator) {
        BoundType boundType = BoundType.OPEN;
        return new GeneralRange<>(comparator, false, null, boundType, false, null, boundType);
    }

    static <T> GeneralRange<T> downTo(Comparator<? super T> comparator, @NullableDecl T t5, BoundType boundType) {
        return new GeneralRange<>(comparator, true, t5, boundType, false, null, BoundType.OPEN);
    }

    static <T> GeneralRange<T> range(Comparator<? super T> comparator, @NullableDecl T t5, BoundType boundType, @NullableDecl T t6, BoundType boundType2) {
        return new GeneralRange<>(comparator, true, t5, boundType, true, t6, boundType2);
    }

    static <T> GeneralRange<T> upTo(Comparator<? super T> comparator, @NullableDecl T t5, BoundType boundType) {
        return new GeneralRange<>(comparator, false, null, BoundType.OPEN, true, t5, boundType);
    }

    Comparator<? super T> comparator() {
        return this.comparator;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof GeneralRange) {
            GeneralRange generalRange = (GeneralRange) obj;
            if (this.comparator.equals(generalRange.comparator) && this.hasLowerBound == generalRange.hasLowerBound && this.hasUpperBound == generalRange.hasUpperBound && getLowerBoundType().equals(generalRange.getLowerBoundType()) && getUpperBoundType().equals(generalRange.getUpperBoundType()) && Objects.equal(getLowerEndpoint(), generalRange.getLowerEndpoint()) && Objects.equal(getUpperEndpoint(), generalRange.getUpperEndpoint())) {
                return true;
            }
        }
        return false;
    }

    BoundType getLowerBoundType() {
        return this.lowerBoundType;
    }

    T getLowerEndpoint() {
        return this.lowerEndpoint;
    }

    BoundType getUpperBoundType() {
        return this.upperBoundType;
    }

    T getUpperEndpoint() {
        return this.upperEndpoint;
    }

    boolean hasLowerBound() {
        return this.hasLowerBound;
    }

    boolean hasUpperBound() {
        return this.hasUpperBound;
    }

    public int hashCode() {
        return Objects.hashCode(this.comparator, getLowerEndpoint(), getLowerBoundType(), getUpperEndpoint(), getUpperBoundType());
    }

    GeneralRange<T> reverse() {
        GeneralRange<T> generalRange = this.reverse;
        if (generalRange != null) {
            return generalRange;
        }
        GeneralRange<T> generalRange2 = new GeneralRange<>(Ordering.from(this.comparator).reverse(), this.hasUpperBound, getUpperEndpoint(), getUpperBoundType(), this.hasLowerBound, getLowerEndpoint(), getLowerBoundType());
        generalRange2.reverse = this;
        this.reverse = generalRange2;
        return generalRange2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.comparator);
        sb.append(":");
        BoundType boundType = this.lowerBoundType;
        BoundType boundType2 = BoundType.CLOSED;
        sb.append(boundType == boundType2 ? '[' : '(');
        sb.append(this.hasLowerBound ? this.lowerEndpoint : "-∞");
        sb.append(StringUtil.COMMA);
        sb.append(this.hasUpperBound ? this.upperEndpoint : "∞");
        sb.append(this.upperBoundType == boundType2 ? ']' : ')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private GeneralRange(Comparator<? super T> comparator, boolean z5, @NullableDecl T t5, BoundType boundType, boolean z6, @NullableDecl T t6, BoundType boundType2) {
        boolean z7;
        boolean z8;
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
        this.hasLowerBound = z5;
        this.hasUpperBound = z6;
        this.lowerEndpoint = t5;
        this.lowerBoundType = (BoundType) Preconditions.checkNotNull(boundType);
        this.upperEndpoint = t6;
        this.upperBoundType = (BoundType) Preconditions.checkNotNull(boundType2);
        if (z5) {
            comparator.compare(t5, t5);
        }
        if (z6) {
            comparator.compare(t6, t6);
        }
        if (z5 && z6) {
            int compare = comparator.compare(t5, t6);
            if (compare <= 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.checkArgument(z7, "lowerEndpoint (%s) > upperEndpoint (%s)", t5, t6);
            if (compare == 0) {
                BoundType boundType3 = BoundType.OPEN;
                if (boundType != boundType3) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                Preconditions.checkArgument(z8 | (boundType2 != boundType3));
            }
        }
    }

    static <T extends Comparable> GeneralRange<T> from(Range<T> range) {
        T t5;
        BoundType boundType;
        BoundType boundType2;
        T t6 = null;
        if (range.hasLowerBound()) {
            t5 = range.lowerEndpoint();
        } else {
            t5 = null;
        }
        if (range.hasLowerBound()) {
            boundType = range.lowerBoundType();
        } else {
            boundType = BoundType.OPEN;
        }
        BoundType boundType3 = boundType;
        if (range.hasUpperBound()) {
            t6 = range.upperEndpoint();
        }
        T t7 = t6;
        if (range.hasUpperBound()) {
            boundType2 = range.upperBoundType();
        } else {
            boundType2 = BoundType.OPEN;
        }
        return new GeneralRange<>(Ordering.natural(), range.hasLowerBound(), t5, boundType3, range.hasUpperBound(), t7, boundType2);
    }

    boolean contains(@NullableDecl T t5) {
        if (!tooLow(t5) && !tooHigh(t5)) {
            return true;
        }
        return false;
    }

    GeneralRange<T> intersect(GeneralRange<T> generalRange) {
        int compare;
        int compare2;
        T t5;
        int compare3;
        BoundType boundType;
        Preconditions.checkNotNull(generalRange);
        Preconditions.checkArgument(this.comparator.equals(generalRange.comparator));
        boolean z5 = this.hasLowerBound;
        T lowerEndpoint = getLowerEndpoint();
        BoundType lowerBoundType = getLowerBoundType();
        if (!hasLowerBound()) {
            z5 = generalRange.hasLowerBound;
            lowerEndpoint = generalRange.getLowerEndpoint();
            lowerBoundType = generalRange.getLowerBoundType();
        } else if (generalRange.hasLowerBound() && ((compare = this.comparator.compare(getLowerEndpoint(), generalRange.getLowerEndpoint())) < 0 || (compare == 0 && generalRange.getLowerBoundType() == BoundType.OPEN))) {
            lowerEndpoint = generalRange.getLowerEndpoint();
            lowerBoundType = generalRange.getLowerBoundType();
        }
        boolean z6 = z5;
        boolean z7 = this.hasUpperBound;
        T upperEndpoint = getUpperEndpoint();
        BoundType upperBoundType = getUpperBoundType();
        if (!hasUpperBound()) {
            z7 = generalRange.hasUpperBound;
            upperEndpoint = generalRange.getUpperEndpoint();
            upperBoundType = generalRange.getUpperBoundType();
        } else if (generalRange.hasUpperBound() && ((compare2 = this.comparator.compare(getUpperEndpoint(), generalRange.getUpperEndpoint())) > 0 || (compare2 == 0 && generalRange.getUpperBoundType() == BoundType.OPEN))) {
            upperEndpoint = generalRange.getUpperEndpoint();
            upperBoundType = generalRange.getUpperBoundType();
        }
        boolean z8 = z7;
        T t6 = upperEndpoint;
        if (z6 && z8 && ((compare3 = this.comparator.compare(lowerEndpoint, t6)) > 0 || (compare3 == 0 && lowerBoundType == (boundType = BoundType.OPEN) && upperBoundType == boundType))) {
            lowerBoundType = BoundType.OPEN;
            upperBoundType = BoundType.CLOSED;
            t5 = t6;
        } else {
            t5 = lowerEndpoint;
        }
        return new GeneralRange<>(this.comparator, z6, t5, lowerBoundType, z8, t6, upperBoundType);
    }

    boolean isEmpty() {
        if (!hasUpperBound() || !tooLow(getUpperEndpoint())) {
            if (hasLowerBound() && tooHigh(getLowerEndpoint())) {
                return true;
            }
            return false;
        }
        return true;
    }

    boolean tooHigh(@NullableDecl T t5) {
        boolean z5;
        boolean z6;
        boolean z7 = false;
        if (!hasUpperBound()) {
            return false;
        }
        int compare = this.comparator.compare(t5, getUpperEndpoint());
        if (compare > 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (compare == 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (getUpperBoundType() == BoundType.OPEN) {
            z7 = true;
        }
        return (z6 & z7) | z5;
    }

    boolean tooLow(@NullableDecl T t5) {
        boolean z5;
        boolean z6;
        boolean z7 = false;
        if (!hasLowerBound()) {
            return false;
        }
        int compare = this.comparator.compare(t5, getLowerEndpoint());
        if (compare < 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (compare == 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (getLowerBoundType() == BoundType.OPEN) {
            z7 = true;
        }
        return (z6 & z7) | z5;
    }
}
