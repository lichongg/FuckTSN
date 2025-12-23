package androidx.collection;

import kotlin.collections.n;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCircularArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CircularArray.kt\nandroidx/collection/CircularArray\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CollectionPlatformUtils.jvm.kt\nandroidx/collection/CollectionPlatformUtils\n*L\n1#1,270:1\n1#2:271\n26#3:272\n26#3:273\n26#3:274\n26#3:275\n26#3:276\n26#3:277\n26#3:278\n*S KotlinDebug\n*F\n+ 1 CircularArray.kt\nandroidx/collection/CircularArray\n*L\n104#1:272\n122#1:273\n152#1:274\n187#1:275\n221#1:276\n235#1:277\n249#1:278\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class CircularArray<E> {
    private int capacityBitmask;

    @NotNull
    private E[] elements;
    private int head;
    private int tail;

    @JvmOverloads
    public CircularArray() {
        this(0, 1, null);
    }

    @JvmOverloads
    public CircularArray(int i6) {
        if (i6 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i6 > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        i6 = Integer.bitCount(i6) != 1 ? Integer.highestOneBit(i6 - 1) << 1 : i6;
        this.capacityBitmask = i6 - 1;
        this.elements = (E[]) new Object[i6];
    }

    private final void doubleCapacity() {
        E[] eArr = this.elements;
        int length = eArr.length;
        int i6 = this.head;
        int i7 = length - i6;
        int i8 = length << 1;
        if (i8 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        E[] eArr2 = (E[]) new Object[i8];
        n.B0(eArr, eArr2, 0, i6, length);
        n.B0(this.elements, eArr2, i7, 0, this.head);
        this.elements = eArr2;
        this.head = 0;
        this.tail = length;
        this.capacityBitmask = i8 - 1;
    }

    public final void addFirst(E e6) {
        int i6 = (this.head - 1) & this.capacityBitmask;
        this.head = i6;
        this.elements[i6] = e6;
        if (i6 == this.tail) {
            doubleCapacity();
        }
    }

    public final void addLast(E e6) {
        E[] eArr = this.elements;
        int i6 = this.tail;
        eArr[i6] = e6;
        int i7 = this.capacityBitmask & (i6 + 1);
        this.tail = i7;
        if (i7 == this.head) {
            doubleCapacity();
        }
    }

    public final E get(int i6) {
        if (i6 < 0 || i6 >= size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        E e6 = this.elements[this.capacityBitmask & (this.head + i6)];
        g0.m(e6);
        return e6;
    }

    public final E getFirst() {
        int i6 = this.head;
        if (i6 == this.tail) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        E e6 = this.elements[i6];
        g0.m(e6);
        return e6;
    }

    public final E getLast() {
        int i6 = this.head;
        int i7 = this.tail;
        if (i6 == i7) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        E e6 = this.elements[(i7 - 1) & this.capacityBitmask];
        g0.m(e6);
        return e6;
    }

    public final boolean isEmpty() {
        return this.head == this.tail;
    }

    public final E popFirst() {
        int i6 = this.head;
        if (i6 == this.tail) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        E[] eArr = this.elements;
        E e6 = eArr[i6];
        eArr[i6] = null;
        this.head = (i6 + 1) & this.capacityBitmask;
        return e6;
    }

    public final E popLast() {
        int i6 = this.head;
        int i7 = this.tail;
        if (i6 == i7) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i8 = this.capacityBitmask & (i7 - 1);
        E[] eArr = this.elements;
        E e6 = eArr[i8];
        eArr[i8] = null;
        this.tail = i8;
        return e6;
    }

    public final void removeFromEnd(int i6) {
        if (i6 <= 0) {
            return;
        }
        if (i6 > size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i7 = this.tail;
        int i8 = i6 < i7 ? i7 - i6 : 0;
        for (int i9 = i8; i9 < i7; i9++) {
            this.elements[i9] = null;
        }
        int i10 = this.tail;
        int i11 = i10 - i8;
        int i12 = i6 - i11;
        this.tail = i10 - i11;
        if (i12 > 0) {
            int length = this.elements.length;
            this.tail = length;
            int i13 = length - i12;
            for (int i14 = i13; i14 < length; i14++) {
                this.elements[i14] = null;
            }
            this.tail = i13;
        }
    }

    public final void removeFromStart(int i6) {
        if (i6 <= 0) {
            return;
        }
        if (i6 > size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int length = this.elements.length;
        int i7 = this.head;
        if (i6 < length - i7) {
            length = i7 + i6;
        }
        while (i7 < length) {
            this.elements[i7] = null;
            i7++;
        }
        int i8 = this.head;
        int i9 = length - i8;
        int i10 = i6 - i9;
        this.head = this.capacityBitmask & (i8 + i9);
        if (i10 > 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                this.elements[i11] = null;
            }
            this.head = i10;
        }
    }

    public final int size() {
        return (this.tail - this.head) & this.capacityBitmask;
    }

    public final void clear() {
        removeFromStart(size());
    }

    public /* synthetic */ CircularArray(int i6, int i7, v vVar) {
        this((i7 & 1) != 0 ? 8 : i6);
    }
}
