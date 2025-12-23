package androidx.collection;

import androidx.annotation.IntRange;
import java.util.Arrays;
import kotlin.collections.n;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLongList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LongList.kt\nandroidx/collection/MutableLongList\n+ 2 LongList.kt\nandroidx/collection/LongList\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,969:1\n549#1:970\n70#2:971\n253#2,6:974\n70#2:980\n70#2:981\n70#2:982\n70#2:989\n70#2:990\n13607#3,2:972\n1675#3,6:983\n*S KotlinDebug\n*F\n+ 1 LongList.kt\nandroidx/collection/MutableLongList\n*L\n692#1:970\n753#1:971\n772#1:974,6\n783#1:980\n787#1:981\n834#1:982\n850#1:989\n869#1:990\n763#1:972,2\n836#1:983,6\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class MutableLongList extends LongList {
    public MutableLongList() {
        this(0, 1, null);
    }

    public final boolean add(long j6) {
        ensureCapacity(this._size + 1);
        long[] jArr = this.content;
        int i6 = this._size;
        jArr[i6] = j6;
        this._size = i6 + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = 0) int i6, @NotNull long[] elements) {
        int i7;
        g0.p(elements, "elements");
        if (i6 < 0 || i6 > (i7 = this._size)) {
            throw new IndexOutOfBoundsException("Index " + i6 + " must be in 0.." + this._size);
        }
        if (elements.length == 0) {
            return false;
        }
        ensureCapacity(i7 + elements.length);
        long[] jArr = this.content;
        int i8 = this._size;
        if (i6 != i8) {
            n.A0(jArr, jArr, elements.length + i6, i6, i8);
        }
        n.J0(elements, jArr, i6, 0, 0, 12, null);
        this._size += elements.length;
        return true;
    }

    public final void clear() {
        this._size = 0;
    }

    public final void minusAssign(long j6) {
        remove(j6);
    }

    public final void plusAssign(@NotNull LongList elements) {
        g0.p(elements, "elements");
        addAll(this._size, elements);
    }

    public final boolean removeAll(@NotNull long[] elements) {
        g0.p(elements, "elements");
        int i6 = this._size;
        for (long j6 : elements) {
            remove(j6);
        }
        return i6 != this._size;
    }

    public final boolean retainAll(@NotNull long[] elements) {
        g0.p(elements, "elements");
        int i6 = this._size;
        long[] jArr = this.content;
        int i7 = i6 - 1;
        while (true) {
            int i8 = 0;
            int i9 = -1;
            if (-1 >= i7) {
                break;
            }
            long j6 = jArr[i7];
            int length = elements.length;
            while (true) {
                if (i8 >= length) {
                    break;
                }
                if (elements[i8] == j6) {
                    i9 = i8;
                    break;
                }
                i8++;
            }
            if (i9 < 0) {
                removeAt(i7);
            }
            i7--;
        }
        return i6 != this._size;
    }

    public /* synthetic */ MutableLongList(int i6, int i7, v vVar) {
        this((i7 & 1) != 0 ? 16 : i6);
    }

    public static /* synthetic */ void trim$default(MutableLongList mutableLongList, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i6 = mutableLongList._size;
        }
        mutableLongList.trim(i6);
    }

    public final void ensureCapacity(int i6) {
        long[] jArr = this.content;
        if (jArr.length < i6) {
            long[] copyOf = Arrays.copyOf(jArr, Math.max(i6, (jArr.length * 3) / 2));
            g0.o(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(@NotNull long[] elements) {
        g0.p(elements, "elements");
        for (long j6 : elements) {
            remove(j6);
        }
    }

    public final void plusAssign(@NotNull long[] elements) {
        g0.p(elements, "elements");
        addAll(this._size, elements);
    }

    public final long removeAt(@IntRange(from = 0) int i6) {
        int i7;
        if (i6 < 0 || i6 >= (i7 = this._size)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Index ");
            sb.append(i6);
            sb.append(" must be in 0..");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        long[] jArr = this.content;
        long j6 = jArr[i6];
        if (i6 != i7 - 1) {
            n.A0(jArr, jArr, i6, i6 + 1, i7);
        }
        this._size--;
        return j6;
    }

    public final void removeRange(@IntRange(from = 0) int i6, @IntRange(from = 0) int i7) {
        int i8;
        if (i6 < 0 || i6 > (i8 = this._size) || i7 < 0 || i7 > i8) {
            throw new IndexOutOfBoundsException("Start (" + i6 + ") and end (" + i7 + ") must be in 0.." + this._size);
        }
        if (i7 >= i6) {
            if (i7 != i6) {
                if (i7 < i8) {
                    long[] jArr = this.content;
                    n.A0(jArr, jArr, i6, i7, i8);
                }
                this._size -= i7 - i6;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Start (" + i6 + ") is more than end (" + i7 + ')');
    }

    public final long set(@IntRange(from = 0) int i6, long j6) {
        if (i6 >= 0 && i6 < this._size) {
            long[] jArr = this.content;
            long j7 = jArr[i6];
            jArr[i6] = j6;
            return j7;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("set index ");
        sb.append(i6);
        sb.append(" must be between 0 .. ");
        sb.append(this._size - 1);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final void sort() {
        n.R3(this.content, 0, this._size);
    }

    public final void sortDescending() {
        n.Vu(this.content, 0, this._size);
    }

    public final void trim(int i6) {
        int max = Math.max(i6, this._size);
        long[] jArr = this.content;
        if (jArr.length > max) {
            long[] copyOf = Arrays.copyOf(jArr, max);
            g0.o(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public MutableLongList(int i6) {
        super(i6, null);
    }

    public final void plusAssign(long j6) {
        add(j6);
    }

    public final boolean remove(long j6) {
        int indexOf = indexOf(j6);
        if (indexOf >= 0) {
            removeAt(indexOf);
            return true;
        }
        return false;
    }

    public final void add(@IntRange(from = 0) int i6, long j6) {
        int i7;
        if (i6 >= 0 && i6 <= (i7 = this._size)) {
            ensureCapacity(i7 + 1);
            long[] jArr = this.content;
            int i8 = this._size;
            if (i6 != i8) {
                n.A0(jArr, jArr, i6 + 1, i6, i8);
            }
            jArr[i6] = j6;
            this._size++;
            return;
        }
        throw new IndexOutOfBoundsException("Index " + i6 + " must be in 0.." + this._size);
    }

    public final void minusAssign(@NotNull LongList elements) {
        g0.p(elements, "elements");
        long[] jArr = elements.content;
        int i6 = elements._size;
        for (int i7 = 0; i7 < i6; i7++) {
            remove(jArr[i7]);
        }
    }

    public final boolean removeAll(@NotNull LongList elements) {
        g0.p(elements, "elements");
        int i6 = this._size;
        int i7 = elements._size - 1;
        if (i7 >= 0) {
            int i8 = 0;
            while (true) {
                remove(elements.get(i8));
                if (i8 == i7) {
                    break;
                }
                i8++;
            }
        }
        return i6 != this._size;
    }

    public final boolean retainAll(@NotNull LongList elements) {
        g0.p(elements, "elements");
        int i6 = this._size;
        long[] jArr = this.content;
        for (int i7 = i6 - 1; -1 < i7; i7--) {
            if (!elements.contains(jArr[i7])) {
                removeAt(i7);
            }
        }
        return i6 != this._size;
    }

    public final boolean addAll(@IntRange(from = 0) int i6, @NotNull LongList elements) {
        g0.p(elements, "elements");
        if (i6 >= 0 && i6 <= this._size) {
            if (elements.isEmpty()) {
                return false;
            }
            ensureCapacity(this._size + elements._size);
            long[] jArr = this.content;
            int i7 = this._size;
            if (i6 != i7) {
                n.A0(jArr, jArr, elements._size + i6, i6, i7);
            }
            n.A0(elements.content, jArr, i6, 0, elements._size);
            this._size += elements._size;
            return true;
        }
        throw new IndexOutOfBoundsException("Index " + i6 + " must be in 0.." + this._size);
    }

    public final boolean addAll(@NotNull LongList elements) {
        g0.p(elements, "elements");
        return addAll(this._size, elements);
    }

    public final boolean addAll(@NotNull long[] elements) {
        g0.p(elements, "elements");
        return addAll(this._size, elements);
    }
}
