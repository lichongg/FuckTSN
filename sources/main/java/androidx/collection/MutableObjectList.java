package androidx.collection;

import androidx.annotation.IntRange;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.f0;
import kotlin.collections.n;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.v;
import kotlin.ranges.m;
import kotlin.ranges.t;
import kotlin.sequences.p;
import m3.e;
import m3.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nObjectList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObjectList.kt\nandroidx/collection/MutableObjectList\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ScatterSet.kt\nandroidx/collection/ScatterSet\n+ 4 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 5 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 6 ObjectList.kt\nandroidx/collection/ObjectList\n+ 7 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,1618:1\n948#1,2:1641\n948#1,2:1652\n948#1,2:1656\n652#1:1659\n955#1,2:1662\n955#1,2:1669\n955#1,2:1691\n955#1,2:1701\n955#1,2:1704\n955#1,2:1708\n1864#2,3:1619\n1855#2:1651\n1856#2:1654\n1855#2:1703\n1856#2:1706\n267#3,4:1622\n237#3,7:1626\n248#3,3:1634\n251#3,2:1638\n272#3:1640\n273#3:1643\n254#3,6:1644\n274#3:1650\n267#3,4:1672\n237#3,7:1676\n248#3,3:1684\n251#3,2:1688\n272#3:1690\n273#3:1693\n254#3,6:1694\n274#3:1700\n1826#4:1633\n1688#4:1637\n1826#4:1683\n1688#4:1687\n1295#5:1655\n1296#5:1658\n1295#5:1707\n1296#5:1710\n80#6:1660\n305#6,4:1665\n310#6:1671\n75#6:1711\n75#6:1712\n75#6:1713\n75#6:1714\n75#6:1715\n75#6:1716\n75#6:1717\n75#6:1718\n13579#7:1661\n13580#7:1664\n*S KotlinDebug\n*F\n+ 1 ObjectList.kt\nandroidx/collection/MutableObjectList\n*L\n864#1:1641,2\n898#1:1652,2\n907#1:1656,2\n927#1:1659\n1050#1:1662,2\n1059#1:1669,2\n1068#1:1691,2\n1077#1:1701,2\n1086#1:1704,2\n1095#1:1708,2\n740#1:1619,3\n897#1:1651\n897#1:1654\n1085#1:1703\n1085#1:1706\n863#1:1622,4\n863#1:1626,7\n863#1:1634,3\n863#1:1638,2\n863#1:1640\n863#1:1643\n863#1:1644,6\n863#1:1650\n1067#1:1672,4\n1067#1:1676,7\n1067#1:1684,3\n1067#1:1688,2\n1067#1:1690\n1067#1:1693\n1067#1:1694,6\n1067#1:1700\n863#1:1633\n863#1:1637\n1067#1:1683\n1067#1:1687\n906#1:1655\n906#1:1658\n1094#1:1707\n1094#1:1710\n979#1:1660\n1058#1:1665,4\n1058#1:1671\n1105#1:1711\n1109#1:1712\n1159#1:1713\n1175#1:1714\n1191#1:1715\n1207#1:1716\n1223#1:1717\n1242#1:1718\n1049#1:1661\n1049#1:1664\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class MutableObjectList<E> extends ObjectList<E> {

    @Nullable
    private ObjectListMutableList<E> list;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class MutableObjectListIterator<T> implements ListIterator<T>, f {

        @NotNull
        private final List<T> list;
        private int prevIndex;

        public MutableObjectListIterator(@NotNull List<T> list, int i6) {
            g0.p(list, "list");
            this.list = list;
            this.prevIndex = i6 - 1;
        }

        @Override // java.util.ListIterator
        public void add(T t5) {
            List<T> list = this.list;
            int i6 = this.prevIndex + 1;
            this.prevIndex = i6;
            list.add(i6, t5);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.prevIndex < this.list.size() - 1;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.prevIndex >= 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            List<T> list = this.list;
            int i6 = this.prevIndex + 1;
            this.prevIndex = i6;
            return list.get(i6);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.prevIndex + 1;
        }

        @Override // java.util.ListIterator
        public T previous() {
            List<T> list = this.list;
            int i6 = this.prevIndex;
            this.prevIndex = i6 - 1;
            return list.get(i6);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.prevIndex;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.list.remove(this.prevIndex);
            this.prevIndex--;
        }

        @Override // java.util.ListIterator
        public void set(T t5) {
            this.list.set(this.prevIndex, t5);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ObjectListMutableList<T> implements List<T>, e {

        @NotNull
        private final MutableObjectList<T> objectList;

        @Override // java.util.List, java.util.Collection
        public boolean add(T t5) {
            return this.objectList.add(t5);
        }

        @Override // java.util.List
        public boolean addAll(int i6, @NotNull Collection<? extends T> elements) {
            g0.p(elements, "elements");
            return this.objectList.addAll(i6, elements);
        }

        @Override // java.util.List
        @NotNull
        public ListIterator<T> listIterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int i6) {
            return removeAt(i6);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return u.a(this);
        }

        public ObjectListMutableList(@NotNull MutableObjectList<T> objectList) {
            g0.p(objectList, "objectList");
            this.objectList = objectList;
        }

        @Override // java.util.List
        public void add(int i6, T t5) {
            this.objectList.add(i6, t5);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(@NotNull Collection<? extends T> elements) {
            g0.p(elements, "elements");
            return this.objectList.addAll(elements);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            this.objectList.clear();
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            return this.objectList.contains(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(@NotNull Collection<? extends Object> elements) {
            g0.p(elements, "elements");
            return this.objectList.containsAll(elements);
        }

        public int getSize() {
            return this.objectList.getSize();
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            return this.objectList.indexOf(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.objectList.isEmpty();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        @NotNull
        public Iterator<T> iterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            return this.objectList.lastIndexOf(obj);
        }

        @Override // java.util.List
        @NotNull
        public ListIterator<T> listIterator(int i6) {
            return new MutableObjectListIterator(this, i6);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            return this.objectList.remove(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(@NotNull Collection<? extends Object> elements) {
            g0.p(elements, "elements");
            return this.objectList.removeAll(elements);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(@NotNull Collection<? extends Object> elements) {
            g0.p(elements, "elements");
            return this.objectList.retainAll((Collection<? extends T>) elements);
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] array) {
            g0.p(array, "array");
            return (T[]) u.b(this, array);
        }

        @Override // java.util.List
        public T get(int i6) {
            ObjectListKt.checkIndex(this, i6);
            return this.objectList.get(i6);
        }

        public T removeAt(int i6) {
            ObjectListKt.checkIndex(this, i6);
            return this.objectList.removeAt(i6);
        }

        @Override // java.util.List
        public T set(int i6, T t5) {
            ObjectListKt.checkIndex(this, i6);
            return this.objectList.set(i6, t5);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        @NotNull
        public List<T> subList(int i6, int i7) {
            ObjectListKt.checkSubIndex(this, i6, i7);
            return new SubList(this, i6, i7);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nObjectList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObjectList.kt\nandroidx/collection/MutableObjectList$SubList\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1618:1\n1855#2,2:1619\n1855#2,2:1621\n*S KotlinDebug\n*F\n+ 1 ObjectList.kt\nandroidx/collection/MutableObjectList$SubList\n*L\n1395#1:1619,2\n1477#1:1621,2\n*E\n"})
    private static final class SubList<T> implements List<T>, e {
        private int end;

        @NotNull
        private final List<T> list;
        private final int start;

        @Override // java.util.List, java.util.Collection
        public boolean add(T t5) {
            List<T> list = this.list;
            int i6 = this.end;
            this.end = i6 + 1;
            list.add(i6, t5);
            return true;
        }

        @Override // java.util.List
        public boolean addAll(int i6, @NotNull Collection<? extends T> elements) {
            g0.p(elements, "elements");
            this.list.addAll(i6 + this.start, elements);
            this.end += elements.size();
            return elements.size() > 0;
        }

        @Override // java.util.List
        @NotNull
        public ListIterator<T> listIterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int i6) {
            return removeAt(i6);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return u.a(this);
        }

        public SubList(@NotNull List<T> list, int i6, int i7) {
            g0.p(list, "list");
            this.list = list;
            this.start = i6;
            this.end = i7;
        }

        @Override // java.util.List
        public void add(int i6, T t5) {
            this.list.add(i6 + this.start, t5);
            this.end++;
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            int i6 = this.end - 1;
            int i7 = this.start;
            if (i7 <= i6) {
                while (true) {
                    this.list.remove(i6);
                    if (i6 == i7) {
                        break;
                    } else {
                        i6--;
                    }
                }
            }
            this.end = this.start;
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            int i6 = this.end;
            for (int i7 = this.start; i7 < i6; i7++) {
                if (g0.g(this.list.get(i7), obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(@NotNull Collection<? extends Object> elements) {
            g0.p(elements, "elements");
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        public int getSize() {
            return this.end - this.start;
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int i6 = this.end;
            for (int i7 = this.start; i7 < i6; i7++) {
                if (g0.g(this.list.get(i7), obj)) {
                    return i7 - this.start;
                }
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.end == this.start;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        @NotNull
        public Iterator<T> iterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int i6 = this.end - 1;
            int i7 = this.start;
            if (i7 > i6) {
                return -1;
            }
            while (!g0.g(this.list.get(i6), obj)) {
                if (i6 == i7) {
                    return -1;
                }
                i6--;
            }
            return i6 - this.start;
        }

        @Override // java.util.List
        @NotNull
        public ListIterator<T> listIterator(int i6) {
            return new MutableObjectListIterator(this, i6);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            int i6 = this.end;
            for (int i7 = this.start; i7 < i6; i7++) {
                if (g0.g(this.list.get(i7), obj)) {
                    this.list.remove(i7);
                    this.end--;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(@NotNull Collection<? extends Object> elements) {
            g0.p(elements, "elements");
            int i6 = this.end;
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            return i6 != this.end;
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(@NotNull Collection<? extends Object> elements) {
            g0.p(elements, "elements");
            int i6 = this.end;
            int i7 = i6 - 1;
            int i8 = this.start;
            if (i8 <= i7) {
                while (true) {
                    if (!elements.contains(this.list.get(i7))) {
                        this.list.remove(i7);
                        this.end--;
                    }
                    if (i7 == i8) {
                        break;
                    }
                    i7--;
                }
            }
            return i6 != this.end;
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] array) {
            g0.p(array, "array");
            return (T[]) u.b(this, array);
        }

        @Override // java.util.List
        public T get(int i6) {
            ObjectListKt.checkIndex(this, i6);
            return this.list.get(i6 + this.start);
        }

        public T removeAt(int i6) {
            ObjectListKt.checkIndex(this, i6);
            this.end--;
            return this.list.remove(i6 + this.start);
        }

        @Override // java.util.List
        public T set(int i6, T t5) {
            ObjectListKt.checkIndex(this, i6);
            return this.list.set(i6 + this.start, t5);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        @NotNull
        public List<T> subList(int i6, int i7) {
            ObjectListKt.checkSubIndex(this, i6, i7);
            return new SubList(this, i6, i7);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(@NotNull Collection<? extends T> elements) {
            g0.p(elements, "elements");
            this.list.addAll(this.end, elements);
            this.end += elements.size();
            return elements.size() > 0;
        }
    }

    public MutableObjectList() {
        this(0, 1, null);
    }

    public final boolean add(E e6) {
        ensureCapacity(this._size + 1);
        Object[] objArr = this.content;
        int i6 = this._size;
        objArr[i6] = e6;
        this._size = i6 + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = 0) int i6, @NotNull E[] elements) {
        int i7;
        g0.p(elements, "elements");
        if (i6 < 0 || i6 > (i7 = this._size)) {
            throw new IndexOutOfBoundsException("Index " + i6 + " must be in 0.." + this._size);
        }
        if (elements.length == 0) {
            return false;
        }
        ensureCapacity(i7 + elements.length);
        Object[] objArr = this.content;
        int i8 = this._size;
        if (i6 != i8) {
            n.B0(objArr, objArr, elements.length + i6, i6, i8);
        }
        n.K0(elements, objArr, i6, 0, 0, 12, null);
        this._size += elements.length;
        return true;
    }

    public final void minusAssign(E e6) {
        remove(e6);
    }

    public final void plusAssign(@NotNull ObjectList<E> elements) {
        g0.p(elements, "elements");
        if (elements.isEmpty()) {
            return;
        }
        ensureCapacity(this._size + elements._size);
        n.B0(elements.content, this.content, this._size, 0, elements._size);
        this._size += elements._size;
    }

    public final boolean removeAll(@NotNull E[] elements) {
        g0.p(elements, "elements");
        int i6 = this._size;
        for (E e6 : elements) {
            remove(e6);
        }
        return i6 != this._size;
    }

    public final boolean retainAll(@NotNull E[] elements) {
        g0.p(elements, "elements");
        int i6 = this._size;
        Object[] objArr = this.content;
        for (int i7 = i6 - 1; -1 < i7; i7--) {
            if (n.bg(elements, objArr[i7]) < 0) {
                removeAt(i7);
            }
        }
        return i6 != this._size;
    }

    public /* synthetic */ MutableObjectList(int i6, int i7, v vVar) {
        this((i7 & 1) != 0 ? 16 : i6);
    }

    public static /* synthetic */ void trim$default(MutableObjectList mutableObjectList, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i6 = mutableObjectList._size;
        }
        mutableObjectList.trim(i6);
    }

    @NotNull
    public final List<E> asMutableList() {
        ObjectListMutableList<E> objectListMutableList = this.list;
        if (objectListMutableList != null) {
            return objectListMutableList;
        }
        ObjectListMutableList<E> objectListMutableList2 = new ObjectListMutableList<>(this);
        this.list = objectListMutableList2;
        return objectListMutableList2;
    }

    public final void clear() {
        n.M1(this.content, null, 0, this._size);
        this._size = 0;
    }

    public final void ensureCapacity(int i6) {
        Object[] objArr = this.content;
        if (objArr.length < i6) {
            Object[] copyOf = Arrays.copyOf(objArr, Math.max(i6, (objArr.length * 3) / 2));
            g0.o(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(@NotNull List<? extends E> elements) {
        g0.p(elements, "elements");
        int size = elements.size();
        for (int i6 = 0; i6 < size; i6++) {
            remove(elements.get(i6));
        }
    }

    public final E removeAt(@IntRange(from = 0) int i6) {
        int i7;
        if (i6 < 0 || i6 >= (i7 = this._size)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Index ");
            sb.append(i6);
            sb.append(" must be in 0..");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        Object[] objArr = this.content;
        E e6 = (E) objArr[i6];
        if (i6 != i7 - 1) {
            n.B0(objArr, objArr, i6, i6 + 1, i7);
        }
        int i8 = this._size - 1;
        this._size = i8;
        objArr[i8] = null;
        return e6;
    }

    public final void removeIf(@NotNull Function1<? super E, Boolean> predicate) {
        g0.p(predicate, "predicate");
        int i6 = this._size;
        Object[] objArr = this.content;
        int i7 = 0;
        m W1 = t.W1(0, i6);
        int e6 = W1.e();
        int f6 = W1.f();
        if (e6 <= f6) {
            while (true) {
                objArr[e6 - i7] = objArr[e6];
                if (predicate.invoke(objArr[e6]).booleanValue()) {
                    i7++;
                }
                if (e6 == f6) {
                    break;
                } else {
                    e6++;
                }
            }
        }
        n.M1(objArr, null, i6 - i7, i6);
        this._size -= i7;
    }

    public final void removeRange(@IntRange(from = 0) int i6, @IntRange(from = 0) int i7) {
        int i8;
        if (i6 < 0 || i6 > (i8 = this._size) || i7 < 0 || i7 > i8) {
            throw new IndexOutOfBoundsException("Start (" + i6 + ") and end (" + i7 + ") must be in 0.." + this._size);
        }
        if (i7 < i6) {
            throw new IllegalArgumentException("Start (" + i6 + ") is more than end (" + i7 + ')');
        }
        if (i7 != i6) {
            if (i7 < i8) {
                Object[] objArr = this.content;
                n.B0(objArr, objArr, i6, i7, i8);
            }
            int i9 = this._size;
            int i10 = i9 - (i7 - i6);
            n.M1(this.content, null, i10, i9);
            this._size = i10;
        }
    }

    public final E set(@IntRange(from = 0) int i6, E e6) {
        if (i6 >= 0 && i6 < this._size) {
            Object[] objArr = this.content;
            E e7 = (E) objArr[i6];
            objArr[i6] = e6;
            return e7;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("set index ");
        sb.append(i6);
        sb.append(" must be between 0 .. ");
        sb.append(this._size - 1);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final void trim(int i6) {
        int max = Math.max(i6, this._size);
        Object[] objArr = this.content;
        if (objArr.length > max) {
            Object[] copyOf = Arrays.copyOf(objArr, max);
            g0.o(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public MutableObjectList(int i6) {
        super(i6, null);
    }

    @Override // androidx.collection.ObjectList
    @NotNull
    public List<E> asList() {
        return asMutableList();
    }

    public final boolean remove(E e6) {
        int indexOf = indexOf(e6);
        if (indexOf >= 0) {
            removeAt(indexOf);
            return true;
        }
        return false;
    }

    public final void add(@IntRange(from = 0) int i6, E e6) {
        int i7;
        if (i6 >= 0 && i6 <= (i7 = this._size)) {
            ensureCapacity(i7 + 1);
            Object[] objArr = this.content;
            int i8 = this._size;
            if (i6 != i8) {
                n.B0(objArr, objArr, i6 + 1, i6, i8);
            }
            objArr[i6] = e6;
            this._size++;
            return;
        }
        throw new IndexOutOfBoundsException("Index " + i6 + " must be in 0.." + this._size);
    }

    public final void minusAssign(@NotNull E[] elements) {
        g0.p(elements, "elements");
        for (E e6 : elements) {
            remove(e6);
        }
    }

    public final boolean removeAll(@NotNull ObjectList<E> elements) {
        g0.p(elements, "elements");
        int i6 = this._size;
        minusAssign((ObjectList) elements);
        return i6 != this._size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(@NotNull ObjectList<E> elements) {
        g0.p(elements, "elements");
        Object[] objArr = elements.content;
        int i6 = elements._size;
        for (int i7 = 0; i7 < i6; i7++) {
            remove(objArr[i7]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean retainAll(@NotNull ObjectList<E> elements) {
        g0.p(elements, "elements");
        int i6 = this._size;
        Object[] objArr = this.content;
        for (int i7 = i6 - 1; -1 < i7; i7--) {
            if (!elements.contains(objArr[i7])) {
                removeAt(i7);
            }
        }
        return i6 != this._size;
    }

    public final boolean removeAll(@NotNull ScatterSet<E> elements) {
        g0.p(elements, "elements");
        int i6 = this._size;
        minusAssign((ScatterSet) elements);
        return i6 != this._size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(@NotNull ScatterSet<E> elements) {
        g0.p(elements, "elements");
        if (elements.isEmpty()) {
            return;
        }
        ensureCapacity(this._size + elements.getSize());
        Object[] objArr = elements.elements;
        long[] jArr = elements.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            long j6 = jArr[i6];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i7 = 8 - ((~(i6 - length)) >>> 31);
                for (int i8 = 0; i8 < i7; i8++) {
                    if ((255 & j6) < 128) {
                        add(objArr[(i6 << 3) + i8]);
                    }
                    j6 >>= 8;
                }
                if (i7 != 8) {
                    return;
                }
            }
            if (i6 == length) {
                return;
            } else {
                i6++;
            }
        }
    }

    public final boolean addAll(@IntRange(from = 0) int i6, @NotNull Collection<? extends E> elements) {
        g0.p(elements, "elements");
        if (i6 >= 0 && i6 <= this._size) {
            int i7 = 0;
            if (elements.isEmpty()) {
                return false;
            }
            ensureCapacity(this._size + elements.size());
            Object[] objArr = this.content;
            if (i6 != this._size) {
                n.B0(objArr, objArr, elements.size() + i6, i6, this._size);
            }
            for (Object obj : elements) {
                int i8 = i7 + 1;
                if (i7 < 0) {
                    f0.b0();
                }
                objArr[i7 + i6] = obj;
                i7 = i8;
            }
            this._size += elements.size();
            return true;
        }
        throw new IndexOutOfBoundsException("Index " + i6 + " must be in 0.." + this._size);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(@NotNull ScatterSet<E> elements) {
        g0.p(elements, "elements");
        Object[] objArr = elements.elements;
        long[] jArr = elements.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            long j6 = jArr[i6];
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i7 = 8 - ((~(i6 - length)) >>> 31);
                for (int i8 = 0; i8 < i7; i8++) {
                    if ((255 & j6) < 128) {
                        remove(objArr[(i6 << 3) + i8]);
                    }
                    j6 >>= 8;
                }
                if (i7 != 8) {
                    return;
                }
            }
            if (i6 == length) {
                return;
            } else {
                i6++;
            }
        }
    }

    public final boolean removeAll(@NotNull List<? extends E> elements) {
        g0.p(elements, "elements");
        int i6 = this._size;
        minusAssign((List) elements);
        return i6 != this._size;
    }

    public final boolean retainAll(@NotNull Collection<? extends E> elements) {
        g0.p(elements, "elements");
        int i6 = this._size;
        Object[] objArr = this.content;
        for (int i7 = i6 - 1; -1 < i7; i7--) {
            if (!elements.contains(objArr[i7])) {
                removeAt(i7);
            }
        }
        return i6 != this._size;
    }

    public final boolean removeAll(@NotNull Iterable<? extends E> elements) {
        g0.p(elements, "elements");
        int i6 = this._size;
        minusAssign((Iterable) elements);
        return i6 != this._size;
    }

    public final void minusAssign(@NotNull Iterable<? extends E> elements) {
        g0.p(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final void plusAssign(@NotNull E[] elements) {
        g0.p(elements, "elements");
        if (elements.length == 0) {
            return;
        }
        ensureCapacity(this._size + elements.length);
        n.K0(elements, this.content, this._size, 0, 0, 12, null);
        this._size += elements.length;
    }

    public final boolean removeAll(@NotNull kotlin.sequences.m<? extends E> elements) {
        g0.p(elements, "elements");
        int i6 = this._size;
        minusAssign((kotlin.sequences.m) elements);
        return i6 != this._size;
    }

    public final void minusAssign(@NotNull kotlin.sequences.m<? extends E> elements) {
        g0.p(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final boolean retainAll(@NotNull Iterable<? extends E> elements) {
        g0.p(elements, "elements");
        int i6 = this._size;
        Object[] objArr = this.content;
        for (int i7 = i6 - 1; -1 < i7; i7--) {
            if (!f0.a2(elements, objArr[i7])) {
                removeAt(i7);
            }
        }
        return i6 != this._size;
    }

    public final void plusAssign(@NotNull List<? extends E> elements) {
        g0.p(elements, "elements");
        if (elements.isEmpty()) {
            return;
        }
        int i6 = this._size;
        ensureCapacity(elements.size() + i6);
        Object[] objArr = this.content;
        int size = elements.size();
        for (int i7 = 0; i7 < size; i7++) {
            objArr[i7 + i6] = elements.get(i7);
        }
        this._size += elements.size();
    }

    public final boolean addAll(@IntRange(from = 0) int i6, @NotNull ObjectList<E> elements) {
        g0.p(elements, "elements");
        if (i6 >= 0 && i6 <= this._size) {
            if (elements.isEmpty()) {
                return false;
            }
            ensureCapacity(this._size + elements._size);
            Object[] objArr = this.content;
            int i7 = this._size;
            if (i6 != i7) {
                n.B0(objArr, objArr, elements._size + i6, i6, i7);
            }
            n.B0(elements.content, objArr, i6, 0, elements._size);
            this._size += elements._size;
            return true;
        }
        throw new IndexOutOfBoundsException("Index " + i6 + " must be in 0.." + this._size);
    }

    public final boolean retainAll(@NotNull kotlin.sequences.m<? extends E> elements) {
        g0.p(elements, "elements");
        int i6 = this._size;
        Object[] objArr = this.content;
        for (int i7 = i6 - 1; -1 < i7; i7--) {
            if (!p.D0(elements, objArr[i7])) {
                removeAt(i7);
            }
        }
        return i6 != this._size;
    }

    public final void plusAssign(E e6) {
        add(e6);
    }

    public final void plusAssign(@NotNull Iterable<? extends E> elements) {
        g0.p(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public final void plusAssign(@NotNull kotlin.sequences.m<? extends E> elements) {
        g0.p(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public final boolean addAll(@NotNull ObjectList<E> elements) {
        g0.p(elements, "elements");
        int i6 = this._size;
        plusAssign((ObjectList) elements);
        return i6 != this._size;
    }

    public final boolean addAll(@NotNull ScatterSet<E> elements) {
        g0.p(elements, "elements");
        int i6 = this._size;
        plusAssign((ScatterSet) elements);
        return i6 != this._size;
    }

    public final boolean addAll(@NotNull E[] elements) {
        g0.p(elements, "elements");
        int i6 = this._size;
        plusAssign((Object[]) elements);
        return i6 != this._size;
    }

    public final boolean addAll(@NotNull List<? extends E> elements) {
        g0.p(elements, "elements");
        int i6 = this._size;
        plusAssign((List) elements);
        return i6 != this._size;
    }

    public final boolean addAll(@NotNull Iterable<? extends E> elements) {
        g0.p(elements, "elements");
        int i6 = this._size;
        plusAssign((Iterable) elements);
        return i6 != this._size;
    }

    public final boolean addAll(@NotNull kotlin.sequences.m<? extends E> elements) {
        g0.p(elements, "elements");
        int i6 = this._size;
        plusAssign((kotlin.sequences.m) elements);
        return i6 != this._size;
    }
}
