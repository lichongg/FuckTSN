package androidx.collection;

import kotlin.collections.n;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCircularIntArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CircularIntArray.kt\nandroidx/collection/CircularIntArray\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CollectionPlatformUtils.jvm.kt\nandroidx/collection/CollectionPlatformUtils\n*L\n1#1,213:1\n1#2:214\n26#3:215\n26#3:216\n26#3:217\n26#3:218\n26#3:219\n26#3:220\n26#3:221\n*S KotlinDebug\n*F\n+ 1 CircularIntArray.kt\nandroidx/collection/CircularIntArray\n*L\n100#1:215\n113#1:216\n139#1:217\n156#1:218\n169#1:219\n181#1:220\n193#1:221\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class CircularIntArray {
    private int capacityBitmask;

    @NotNull
    private int[] elements;
    private int head;
    private int tail;

    @JvmOverloads
    public CircularIntArray() {
        this(0, 1, null);
    }

    @JvmOverloads
    public CircularIntArray(int i6) {
        if (i6 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i6 > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        i6 = Integer.bitCount(i6) != 1 ? Integer.highestOneBit(i6 - 1) << 1 : i6;
        this.capacityBitmask = i6 - 1;
        this.elements = new int[i6];
    }

    private final void doubleCapacity() {
        int[] iArr = this.elements;
        int length = iArr.length;
        int i6 = this.head;
        int i7 = length - i6;
        int i8 = length << 1;
        if (i8 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        int[] iArr2 = new int[i8];
        n.z0(iArr, iArr2, 0, i6, length);
        n.z0(this.elements, iArr2, i7, 0, this.head);
        this.elements = iArr2;
        this.head = 0;
        this.tail = length;
        this.capacityBitmask = i8 - 1;
    }

    public final void addFirst(int i6) {
        int i7 = (this.head - 1) & this.capacityBitmask;
        this.head = i7;
        this.elements[i7] = i6;
        if (i7 == this.tail) {
            doubleCapacity();
        }
    }

    public final void addLast(int i6) {
        int[] iArr = this.elements;
        int i7 = this.tail;
        iArr[i7] = i6;
        int i8 = this.capacityBitmask & (i7 + 1);
        this.tail = i8;
        if (i8 == this.head) {
            doubleCapacity();
        }
    }

    public final void clear() {
        this.tail = this.head;
    }

    public final int get(int i6) {
        if (i6 < 0 || i6 >= size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.elements[this.capacityBitmask & (this.head + i6)];
    }

    public final int getFirst() {
        int i6 = this.head;
        if (i6 != this.tail) {
            return this.elements[i6];
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int getLast() {
        int i6 = this.head;
        int i7 = this.tail;
        if (i6 != i7) {
            return this.elements[(i7 - 1) & this.capacityBitmask];
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final boolean isEmpty() {
        return this.head == this.tail;
    }

    public final int popFirst() {
        int i6 = this.head;
        if (i6 == this.tail) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i7 = this.elements[i6];
        this.head = (i6 + 1) & this.capacityBitmask;
        return i7;
    }

    public final int popLast() {
        int i6 = this.head;
        int i7 = this.tail;
        if (i6 == i7) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i8 = this.capacityBitmask & (i7 - 1);
        int i9 = this.elements[i8];
        this.tail = i8;
        return i9;
    }

    public final void removeFromEnd(int i6) {
        if (i6 <= 0) {
            return;
        }
        if (i6 > size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        this.tail = this.capacityBitmask & (this.tail - i6);
    }

    public final void removeFromStart(int i6) {
        if (i6 <= 0) {
            return;
        }
        if (i6 > size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        this.head = this.capacityBitmask & (this.head + i6);
    }

    public final int size() {
        return (this.tail - this.head) & this.capacityBitmask;
    }

    public /* synthetic */ CircularIntArray(int i6, int i7, v vVar) {
        this((i7 & 1) != 0 ? 8 : i6);
    }
}
