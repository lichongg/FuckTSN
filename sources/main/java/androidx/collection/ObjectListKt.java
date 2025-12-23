package androidx.collection;

import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nObjectList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObjectList.kt\nandroidx/collection/ObjectListKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ObjectList.kt\nandroidx/collection/MutableObjectList\n*L\n1#1,1618:1\n1#2:1619\n948#3,2:1620\n948#3,2:1622\n948#3,2:1624\n948#3,2:1626\n948#3,2:1628\n948#3,2:1630\n*S KotlinDebug\n*F\n+ 1 ObjectList.kt\nandroidx/collection/ObjectListKt\n*L\n1587#1:1620,2\n1596#1:1622,2\n1597#1:1624,2\n1607#1:1626,2\n1608#1:1628,2\n1609#1:1630,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class ObjectListKt {

    @NotNull
    private static final Object[] EmptyArray = new Object[0];

    @NotNull
    private static final ObjectList<Object> EmptyObjectList = new MutableObjectList(0);

    @NotNull
    public static final <E> MutableObjectList<E> mutableObjectListOf() {
        return new MutableObjectList<>(0, 1, null);
    }

    @NotNull
    public static final <E> ObjectList<E> objectListOf() {
        ObjectList<E> objectList = (ObjectList<E>) EmptyObjectList;
        g0.n(objectList, "null cannot be cast to non-null type androidx.collection.ObjectList<E of androidx.collection.ObjectListKt.objectListOf>");
        return objectList;
    }

    @NotNull
    public static final <E> ObjectList<E> emptyObjectList() {
        ObjectList<E> objectList = (ObjectList<E>) EmptyObjectList;
        g0.n(objectList, "null cannot be cast to non-null type androidx.collection.ObjectList<E of androidx.collection.ObjectListKt.emptyObjectList>");
        return objectList;
    }

    @NotNull
    public static final <E> MutableObjectList<E> mutableObjectListOf(E e6) {
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(1);
        mutableObjectList.add(e6);
        return mutableObjectList;
    }

    @NotNull
    public static final <E> ObjectList<E> objectListOf(E e6) {
        return mutableObjectListOf(e6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkIndex(List<?> list, int i6) {
        int size = list.size();
        if (i6 >= 0 && i6 < size) {
            return;
        }
        throw new IndexOutOfBoundsException("Index " + i6 + " is out of bounds. The list has " + size + " elements.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkSubIndex(List<?> list, int i6, int i7) {
        int size = list.size();
        if (i6 <= i7) {
            if (i6 >= 0) {
                if (i7 <= size) {
                    return;
                }
                throw new IndexOutOfBoundsException("toIndex (" + i7 + ") is more than than the list size (" + size + ')');
            }
            throw new IndexOutOfBoundsException("fromIndex (" + i6 + ") is less than 0.");
        }
        throw new IllegalArgumentException("Indices are out of order. fromIndex (" + i6 + ") is greater than toIndex (" + i7 + ").");
    }

    @NotNull
    public static final <E> ObjectList<E> objectListOf(E e6, E e7) {
        return mutableObjectListOf(e6, e7);
    }

    @NotNull
    public static final <E> MutableObjectList<E> mutableObjectListOf(E e6, E e7) {
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(2);
        mutableObjectList.add(e6);
        mutableObjectList.add(e7);
        return mutableObjectList;
    }

    @NotNull
    public static final <E> ObjectList<E> objectListOf(E e6, E e7, E e8) {
        return mutableObjectListOf(e6, e7, e8);
    }

    @NotNull
    public static final <E> ObjectList<E> objectListOf(@NotNull E... elements) {
        g0.p(elements, "elements");
        MutableObjectList mutableObjectList = new MutableObjectList(elements.length);
        mutableObjectList.plusAssign((Object[]) elements);
        return mutableObjectList;
    }

    @NotNull
    public static final <E> MutableObjectList<E> mutableObjectListOf(E e6, E e7, E e8) {
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(3);
        mutableObjectList.add(e6);
        mutableObjectList.add(e7);
        mutableObjectList.add(e8);
        return mutableObjectList;
    }

    @NotNull
    public static final <E> MutableObjectList<E> mutableObjectListOf(@NotNull E... elements) {
        g0.p(elements, "elements");
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(elements.length);
        mutableObjectList.plusAssign((Object[]) elements);
        return mutableObjectList;
    }
}
