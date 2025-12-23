package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@GwtCompatible
/* loaded from: D:\Downloads\app\classes5.dex */
final class TopKSelector<T> {
    private final T[] buffer;
    private int bufferSize;
    private final Comparator<? super T> comparator;

    /* renamed from: k, reason: collision with root package name */
    private final int f32751k;

    @NullableDecl
    private T threshold;

    public static <T extends Comparable<? super T>> TopKSelector<T> greatest(int i6) {
        return greatest(i6, Ordering.natural());
    }

    public static <T extends Comparable<? super T>> TopKSelector<T> least(int i6) {
        return least(i6, Ordering.natural());
    }

    public void offerAll(Iterable<? extends T> iterable) {
        offerAll(iterable.iterator());
    }

    public static <T> TopKSelector<T> greatest(int i6, Comparator<? super T> comparator) {
        return new TopKSelector<>(Ordering.from(comparator).reverse(), i6);
    }

    public static <T> TopKSelector<T> least(int i6, Comparator<? super T> comparator) {
        return new TopKSelector<>(comparator, i6);
    }

    private int partition(int i6, int i7, int i8) {
        T[] tArr = this.buffer;
        T t5 = tArr[i8];
        tArr[i8] = tArr[i7];
        int i9 = i6;
        while (i6 < i7) {
            if (this.comparator.compare(this.buffer[i6], t5) < 0) {
                swap(i9, i6);
                i9++;
            }
            i6++;
        }
        T[] tArr2 = this.buffer;
        tArr2[i7] = tArr2[i9];
        tArr2[i9] = t5;
        return i9;
    }

    private void swap(int i6, int i7) {
        T[] tArr = this.buffer;
        T t5 = tArr[i6];
        tArr[i6] = tArr[i7];
        tArr[i7] = t5;
    }

    private void trim() {
        int i6 = (this.f32751k * 2) - 1;
        int log2 = IntMath.log2(i6, RoundingMode.CEILING) * 3;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i7 >= i6) {
                break;
            }
            int partition = partition(i7, i6, ((i7 + i6) + 1) >>> 1);
            int i10 = this.f32751k;
            if (partition <= i10) {
                if (partition >= i10) {
                    break;
                }
                i7 = Math.max(partition, i7 + 1);
                i9 = partition;
            } else {
                i6 = partition - 1;
            }
            i8++;
            if (i8 >= log2) {
                Arrays.sort(this.buffer, i7, i6, this.comparator);
                break;
            }
        }
        this.bufferSize = this.f32751k;
        this.threshold = this.buffer[i9];
        while (true) {
            i9++;
            if (i9 >= this.f32751k) {
                return;
            }
            if (this.comparator.compare(this.buffer[i9], this.threshold) > 0) {
                this.threshold = this.buffer[i9];
            }
        }
    }

    public void offer(@NullableDecl T t5) {
        int i6 = this.f32751k;
        if (i6 == 0) {
            return;
        }
        int i7 = this.bufferSize;
        if (i7 == 0) {
            this.buffer[0] = t5;
            this.threshold = t5;
            this.bufferSize = 1;
            return;
        }
        if (i7 < i6) {
            T[] tArr = this.buffer;
            this.bufferSize = i7 + 1;
            tArr[i7] = t5;
            if (this.comparator.compare(t5, this.threshold) > 0) {
                this.threshold = t5;
                return;
            }
            return;
        }
        if (this.comparator.compare(t5, this.threshold) < 0) {
            T[] tArr2 = this.buffer;
            int i8 = this.bufferSize;
            int i9 = i8 + 1;
            this.bufferSize = i9;
            tArr2[i8] = t5;
            if (i9 == this.f32751k * 2) {
                trim();
            }
        }
    }

    public void offerAll(Iterator<? extends T> it) {
        while (it.hasNext()) {
            offer(it.next());
        }
    }

    public List<T> topK() {
        Arrays.sort(this.buffer, 0, this.bufferSize, this.comparator);
        int i6 = this.bufferSize;
        int i7 = this.f32751k;
        if (i6 > i7) {
            T[] tArr = this.buffer;
            Arrays.fill(tArr, i7, tArr.length, (Object) null);
            int i8 = this.f32751k;
            this.bufferSize = i8;
            this.threshold = this.buffer[i8 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.buffer, this.bufferSize)));
    }

    private TopKSelector(Comparator<? super T> comparator, int i6) {
        boolean z5;
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator, "comparator");
        this.f32751k = i6;
        if (i6 >= 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "k must be nonnegative, was %s", i6);
        this.buffer = (T[]) new Object[i6 * 2];
        this.bufferSize = 0;
        this.threshold = null;
    }
}
