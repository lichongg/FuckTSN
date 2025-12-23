package androidx.collection;

import androidx.annotation.IntRange;
import java.util.Arrays;
import kotlin.collections.n;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFloatList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatList.kt\nandroidx/collection/MutableFloatList\n+ 2 FloatList.kt\nandroidx/collection/FloatList\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,969:1\n549#1:970\n70#2:971\n253#2,6:974\n70#2:980\n70#2:981\n70#2:982\n70#2:989\n70#2:990\n13614#3,2:972\n1687#3,6:983\n*S KotlinDebug\n*F\n+ 1 FloatList.kt\nandroidx/collection/MutableFloatList\n*L\n692#1:970\n753#1:971\n772#1:974,6\n783#1:980\n787#1:981\n834#1:982\n850#1:989\n869#1:990\n763#1:972,2\n836#1:983,6\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class MutableFloatList extends FloatList {
    public MutableFloatList() {
        this(0, 1, null);
    }

    public final boolean add(float f6) {
        ensureCapacity(this._size + 1);
        float[] fArr = this.content;
        int i6 = this._size;
        fArr[i6] = f6;
        this._size = i6 + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = 0) int i6, @NotNull float[] elements) {
        int i7;
        g0.p(elements, "elements");
        if (i6 < 0 || i6 > (i7 = this._size)) {
            throw new IndexOutOfBoundsException("Index " + i6 + " must be in 0.." + this._size);
        }
        if (elements.length == 0) {
            return false;
        }
        ensureCapacity(i7 + elements.length);
        float[] fArr = this.content;
        int i8 = this._size;
        if (i6 != i8) {
            n.y0(fArr, fArr, elements.length + i6, i6, i8);
        }
        n.H0(elements, fArr, i6, 0, 0, 12, null);
        this._size += elements.length;
        return true;
    }

    public final void clear() {
        this._size = 0;
    }

    public final void minusAssign(float f6) {
        remove(f6);
    }

    public final void plusAssign(@NotNull FloatList elements) {
        g0.p(elements, "elements");
        addAll(this._size, elements);
    }

    public final boolean removeAll(@NotNull float[] elements) {
        g0.p(elements, "elements");
        int i6 = this._size;
        for (float f6 : elements) {
            remove(f6);
        }
        return i6 != this._size;
    }

    public final boolean retainAll(@NotNull float[] elements) {
        g0.p(elements, "elements");
        int i6 = this._size;
        float[] fArr = this.content;
        int i7 = i6 - 1;
        while (true) {
            int i8 = 0;
            int i9 = -1;
            if (-1 >= i7) {
                break;
            }
            float f6 = fArr[i7];
            int length = elements.length;
            while (true) {
                if (i8 >= length) {
                    break;
                }
                if (elements[i8] == f6) {
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

    public /* synthetic */ MutableFloatList(int i6, int i7, v vVar) {
        this((i7 & 1) != 0 ? 16 : i6);
    }

    public static /* synthetic */ void trim$default(MutableFloatList mutableFloatList, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i6 = mutableFloatList._size;
        }
        mutableFloatList.trim(i6);
    }

    public final void ensureCapacity(int i6) {
        float[] fArr = this.content;
        if (fArr.length < i6) {
            float[] copyOf = Arrays.copyOf(fArr, Math.max(i6, (fArr.length * 3) / 2));
            g0.o(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(@NotNull float[] elements) {
        g0.p(elements, "elements");
        for (float f6 : elements) {
            remove(f6);
        }
    }

    public final void plusAssign(@NotNull float[] elements) {
        g0.p(elements, "elements");
        addAll(this._size, elements);
    }

    public final float removeAt(@IntRange(from = 0) int i6) {
        int i7;
        if (i6 < 0 || i6 >= (i7 = this._size)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Index ");
            sb.append(i6);
            sb.append(" must be in 0..");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        float[] fArr = this.content;
        float f6 = fArr[i6];
        if (i6 != i7 - 1) {
            n.y0(fArr, fArr, i6, i6 + 1, i7);
        }
        this._size--;
        return f6;
    }

    public final void removeRange(@IntRange(from = 0) int i6, @IntRange(from = 0) int i7) {
        int i8;
        if (i6 < 0 || i6 > (i8 = this._size) || i7 < 0 || i7 > i8) {
            throw new IndexOutOfBoundsException("Start (" + i6 + ") and end (" + i7 + ") must be in 0.." + this._size);
        }
        if (i7 >= i6) {
            if (i7 != i6) {
                if (i7 < i8) {
                    float[] fArr = this.content;
                    n.y0(fArr, fArr, i6, i7, i8);
                }
                this._size -= i7 - i6;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Start (" + i6 + ") is more than end (" + i7 + ')');
    }

    public final float set(@IntRange(from = 0) int i6, float f6) {
        if (i6 >= 0 && i6 < this._size) {
            float[] fArr = this.content;
            float f7 = fArr[i6];
            fArr[i6] = f6;
            return f7;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("set index ");
        sb.append(i6);
        sb.append(" must be between 0 .. ");
        sb.append(this._size - 1);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final void sort() {
        n.N3(this.content, 0, this._size);
    }

    public final void sortDescending() {
        n.Ru(this.content, 0, this._size);
    }

    public final void trim(int i6) {
        int max = Math.max(i6, this._size);
        float[] fArr = this.content;
        if (fArr.length > max) {
            float[] copyOf = Arrays.copyOf(fArr, max);
            g0.o(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public MutableFloatList(int i6) {
        super(i6, null);
    }

    public final void plusAssign(float f6) {
        add(f6);
    }

    public final boolean remove(float f6) {
        int indexOf = indexOf(f6);
        if (indexOf >= 0) {
            removeAt(indexOf);
            return true;
        }
        return false;
    }

    public final void add(@IntRange(from = 0) int i6, float f6) {
        int i7;
        if (i6 >= 0 && i6 <= (i7 = this._size)) {
            ensureCapacity(i7 + 1);
            float[] fArr = this.content;
            int i8 = this._size;
            if (i6 != i8) {
                n.y0(fArr, fArr, i6 + 1, i6, i8);
            }
            fArr[i6] = f6;
            this._size++;
            return;
        }
        throw new IndexOutOfBoundsException("Index " + i6 + " must be in 0.." + this._size);
    }

    public final void minusAssign(@NotNull FloatList elements) {
        g0.p(elements, "elements");
        float[] fArr = elements.content;
        int i6 = elements._size;
        for (int i7 = 0; i7 < i6; i7++) {
            remove(fArr[i7]);
        }
    }

    public final boolean removeAll(@NotNull FloatList elements) {
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

    public final boolean retainAll(@NotNull FloatList elements) {
        g0.p(elements, "elements");
        int i6 = this._size;
        float[] fArr = this.content;
        for (int i7 = i6 - 1; -1 < i7; i7--) {
            if (!elements.contains(fArr[i7])) {
                removeAt(i7);
            }
        }
        return i6 != this._size;
    }

    public final boolean addAll(@IntRange(from = 0) int i6, @NotNull FloatList elements) {
        g0.p(elements, "elements");
        if (i6 >= 0 && i6 <= this._size) {
            if (elements.isEmpty()) {
                return false;
            }
            ensureCapacity(this._size + elements._size);
            float[] fArr = this.content;
            int i7 = this._size;
            if (i6 != i7) {
                n.y0(fArr, fArr, elements._size + i6, i6, i7);
            }
            n.y0(elements.content, fArr, i6, 0, elements._size);
            this._size += elements._size;
            return true;
        }
        throw new IndexOutOfBoundsException("Index " + i6 + " must be in 0.." + this._size);
    }

    public final boolean addAll(@NotNull FloatList elements) {
        g0.p(elements, "elements");
        return addAll(this._size, elements);
    }

    public final boolean addAll(@NotNull float[] elements) {
        g0.p(elements, "elements");
        return addAll(this._size, elements);
    }
}
