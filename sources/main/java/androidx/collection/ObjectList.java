package androidx.collection;

import androidx.annotation.IntRange;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import kotlin.ranges.m;
import kotlin.ranges.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nObjectList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObjectList.kt\nandroidx/collection/ObjectList\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1618:1\n305#1,6:1619\n331#1,6:1625\n305#1,6:1633\n305#1,6:1639\n305#1,6:1645\n305#1,6:1651\n305#1,6:1657\n318#1,6:1663\n331#1,6:1669\n345#1,6:1675\n75#1:1681\n75#1:1682\n318#1,6:1683\n318#1,6:1689\n318#1,6:1695\n345#1,6:1701\n75#1:1707\n331#1,6:1708\n75#1:1714\n331#1,6:1715\n345#1,6:1721\n345#1,6:1727\n318#1,6:1733\n305#1,6:1739\n80#1:1745\n1855#2,2:1631\n*S KotlinDebug\n*F\n+ 1 ObjectList.kt\nandroidx/collection/ObjectList\n*L\n101#1:1619,6\n115#1:1625,6\n168#1:1633,6\n186#1:1639,6\n209#1:1645,6\n227#1:1651,6\n244#1:1657,6\n260#1:1663,6\n277#1:1669,6\n293#1:1675,6\n358#1:1681\n369#1:1682\n399#1:1683,6\n405#1:1689,6\n421#1:1695,6\n435#1:1701,6\n461#1:1707\n472#1:1708,6\n483#1:1714\n492#1:1715,6\n509#1:1721,6\n515#1:1727,6\n545#1:1733,6\n576#1:1739,6\n592#1:1745\n157#1:1631,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class ObjectList<E> {

    @JvmField
    public int _size;

    @JvmField
    @NotNull
    public Object[] content;

    public /* synthetic */ ObjectList(int i6, v vVar) {
        this(i6);
    }

    public final boolean any() {
        return isNotEmpty();
    }

    @NotNull
    public abstract List<E> asList();

    public final boolean containsAll(@NotNull E[] elements) {
        g0.p(elements, "elements");
        for (E e6 : elements) {
            if (!contains(e6)) {
                return false;
            }
        }
        return true;
    }

    public final int count() {
        return this._size;
    }

    public final E first() {
        if (isEmpty()) {
            throw new NoSuchElementException("ObjectList is empty.");
        }
        return (E) this.content[0];
    }

    @Nullable
    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return get(0);
    }

    @NotNull
    public final m getIndices() {
        return t.W1(0, this._size);
    }

    public final int indexOf(E e6) {
        int i6 = 0;
        if (e6 == null) {
            Object[] objArr = this.content;
            int i7 = this._size;
            while (i6 < i7) {
                if (objArr[i6] == null) {
                    return i6;
                }
                i6++;
            }
            return -1;
        }
        Object[] objArr2 = this.content;
        int i8 = this._size;
        while (i6 < i8) {
            if (e6.equals(objArr2[i6])) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, null, 63, null);
    }

    public final E last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ObjectList is empty.");
        }
        return (E) this.content[this._size - 1];
    }

    public final int lastIndexOf(E e6) {
        if (e6 == null) {
            Object[] objArr = this.content;
            for (int i6 = this._size - 1; -1 < i6; i6--) {
                if (objArr[i6] == null) {
                    return i6;
                }
            }
        } else {
            Object[] objArr2 = this.content;
            for (int i7 = this._size - 1; -1 < i7; i7--) {
                if (e6.equals(objArr2[i7])) {
                    return i7;
                }
            }
        }
        return -1;
    }

    @Nullable
    public final E lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.content[this._size - 1];
    }

    private ObjectList(int i6) {
        this.content = i6 == 0 ? ObjectListKt.EmptyArray : new Object[i6];
    }

    public static /* synthetic */ String joinToString$default(ObjectList objectList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, Function1 function1, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i7 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i7 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i7 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i7 & 8) != 0) {
            i6 = -1;
        }
        if ((i7 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i7 & 32) != 0) {
            function1 = null;
        }
        CharSequence charSequence5 = charSequence4;
        Function1 function12 = function1;
        return objectList.joinToString(charSequence, charSequence2, charSequence3, i6, charSequence5, function12);
    }

    public final boolean any(@NotNull Function1<? super E, Boolean> predicate) {
        g0.p(predicate, "predicate");
        Object[] objArr = this.content;
        int i6 = this._size;
        for (int i7 = 0; i7 < i6; i7++) {
            if (predicate.invoke(objArr[i7]).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final int count(@NotNull Function1<? super E, Boolean> predicate) {
        g0.p(predicate, "predicate");
        Object[] objArr = this.content;
        int i6 = this._size;
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            if (predicate.invoke(objArr[i8]).booleanValue()) {
                i7++;
            }
        }
        return i7;
    }

    public final E elementAt(@IntRange(from = 0) int i6) {
        if (i6 >= 0 && i6 < this._size) {
            return (E) this.content[i6];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Index ");
        sb.append(i6);
        sb.append(" must be in 0..");
        sb.append(this._size - 1);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final E elementAtOrElse(@IntRange(from = 0) int i6, @NotNull Function1<? super Integer, ? extends E> defaultValue) {
        g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= this._size) ? defaultValue.invoke(Integer.valueOf(i6)) : (E) this.content[i6];
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ObjectList) {
            ObjectList objectList = (ObjectList) obj;
            int i6 = objectList._size;
            int i7 = this._size;
            if (i6 == i7) {
                Object[] objArr = this.content;
                Object[] objArr2 = objectList.content;
                m W1 = t.W1(0, i7);
                int e6 = W1.e();
                int f6 = W1.f();
                if (e6 > f6) {
                    return true;
                }
                while (g0.g(objArr[e6], objArr2[e6])) {
                    if (e6 == f6) {
                        return true;
                    }
                    e6++;
                }
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [E, java.lang.Object] */
    @Nullable
    public final E firstOrNull(@NotNull Function1<? super E, Boolean> predicate) {
        g0.p(predicate, "predicate");
        Object[] objArr = this.content;
        int i6 = this._size;
        for (int i7 = 0; i7 < i6; i7++) {
            ?? r32 = (Object) objArr[i7];
            if (predicate.invoke(r32).booleanValue()) {
                return r32;
            }
        }
        return null;
    }

    public final <R> R fold(R r5, @NotNull Function2<? super R, ? super E, ? extends R> operation) {
        g0.p(operation, "operation");
        Object[] objArr = this.content;
        int i6 = this._size;
        for (int i7 = 0; i7 < i6; i7++) {
            r5 = operation.invoke(r5, objArr[i7]);
        }
        return r5;
    }

    public final <R> R foldIndexed(R r5, @NotNull Function3<? super Integer, ? super R, ? super E, ? extends R> operation) {
        g0.p(operation, "operation");
        Object[] objArr = this.content;
        int i6 = this._size;
        for (int i7 = 0; i7 < i6; i7++) {
            r5 = operation.invoke(Integer.valueOf(i7), r5, objArr[i7]);
        }
        return r5;
    }

    public final <R> R foldRight(R r5, @NotNull Function2<? super E, ? super R, ? extends R> operation) {
        g0.p(operation, "operation");
        Object[] objArr = this.content;
        int i6 = this._size;
        while (true) {
            i6--;
            if (-1 >= i6) {
                return r5;
            }
            r5 = operation.invoke(objArr[i6], r5);
        }
    }

    public final <R> R foldRightIndexed(R r5, @NotNull Function3<? super Integer, ? super E, ? super R, ? extends R> operation) {
        g0.p(operation, "operation");
        Object[] objArr = this.content;
        int i6 = this._size;
        while (true) {
            i6--;
            if (-1 >= i6) {
                return r5;
            }
            r5 = operation.invoke(Integer.valueOf(i6), objArr[i6], r5);
        }
    }

    public final void forEach(@NotNull Function1<? super E, n1> block) {
        g0.p(block, "block");
        Object[] objArr = this.content;
        int i6 = this._size;
        for (int i7 = 0; i7 < i6; i7++) {
            block.invoke(objArr[i7]);
        }
    }

    public final void forEachIndexed(@NotNull Function2<? super Integer, ? super E, n1> block) {
        g0.p(block, "block");
        Object[] objArr = this.content;
        int i6 = this._size;
        for (int i7 = 0; i7 < i6; i7++) {
            block.invoke(Integer.valueOf(i7), objArr[i7]);
        }
    }

    public final void forEachReversed(@NotNull Function1<? super E, n1> block) {
        g0.p(block, "block");
        Object[] objArr = this.content;
        int i6 = this._size;
        while (true) {
            i6--;
            if (-1 >= i6) {
                return;
            } else {
                block.invoke(objArr[i6]);
            }
        }
    }

    public final void forEachReversedIndexed(@NotNull Function2<? super Integer, ? super E, n1> block) {
        g0.p(block, "block");
        Object[] objArr = this.content;
        int i6 = this._size;
        while (true) {
            i6--;
            if (-1 >= i6) {
                return;
            } else {
                block.invoke(Integer.valueOf(i6), objArr[i6]);
            }
        }
    }

    public final E get(@IntRange(from = 0) int i6) {
        if (i6 >= 0 && i6 < this._size) {
            return (E) this.content[i6];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Index ");
        sb.append(i6);
        sb.append(" must be in 0..");
        sb.append(this._size - 1);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    @IntRange(from = -1)
    public final int getLastIndex() {
        return this._size - 1;
    }

    @IntRange(from = 0)
    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        Object[] objArr = this.content;
        int i6 = this._size;
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            Object obj = objArr[i8];
            i7 += (obj != null ? obj.hashCode() : 0) * 31;
        }
        return i7;
    }

    public final int indexOfFirst(@NotNull Function1<? super E, Boolean> predicate) {
        g0.p(predicate, "predicate");
        Object[] objArr = this.content;
        int i6 = this._size;
        for (int i7 = 0; i7 < i6; i7++) {
            if (predicate.invoke(objArr[i7]).booleanValue()) {
                return i7;
            }
        }
        return -1;
    }

    public final int indexOfLast(@NotNull Function1<? super E, Boolean> predicate) {
        g0.p(predicate, "predicate");
        Object[] objArr = this.content;
        int i6 = this._size;
        do {
            i6--;
            if (-1 >= i6) {
                return -1;
            }
        } while (!predicate.invoke(objArr[i6]).booleanValue());
        return i6;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator) {
        g0.p(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, null, 62, null);
    }

    public final boolean reversedAny(@NotNull Function1<? super E, Boolean> predicate) {
        g0.p(predicate, "predicate");
        Object[] objArr = this.content;
        for (int i6 = this._size - 1; -1 < i6; i6--) {
            if (predicate.invoke(objArr[i6]).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, new Function1<E, CharSequence>(this) { // from class: androidx.collection.ObjectList$toString$1
            final /* synthetic */ ObjectList<E> this$0;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Object obj) {
                return invoke((ObjectList$toString$1<E>) obj);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(E e6) {
                return e6 == this.this$0 ? "(this)" : String.valueOf(e6);
            }
        }, 25, null);
    }

    public final boolean contains(E e6) {
        if (indexOf(e6) >= 0) {
            return true;
        }
        return false;
    }

    public final boolean containsAll(@NotNull List<? extends E> elements) {
        g0.p(elements, "elements");
        int size = elements.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (!contains(elements.get(i6))) {
                return false;
            }
        }
        return true;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix) {
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, null, 60, null);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [E, java.lang.Object] */
    @Nullable
    public final E lastOrNull(@NotNull Function1<? super E, Boolean> predicate) {
        ?? r22;
        g0.p(predicate, "predicate");
        Object[] objArr = this.content;
        int i6 = this._size;
        do {
            i6--;
            if (-1 >= i6) {
                return null;
            }
            r22 = (Object) objArr[i6];
        } while (!predicate.invoke(r22).booleanValue());
        return r22;
    }

    public final boolean none() {
        return isEmpty();
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [E, java.lang.Object] */
    public final E first(@NotNull Function1<? super E, Boolean> predicate) {
        g0.p(predicate, "predicate");
        Object[] objArr = this.content;
        int i6 = this._size;
        for (int i7 = 0; i7 < i6; i7++) {
            ?? r32 = (Object) objArr[i7];
            if (predicate.invoke(r32).booleanValue()) {
                return r32;
            }
        }
        throw new NoSuchElementException("ObjectList contains no element matching the predicate.");
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix) {
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        g0.p(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, null, 56, null);
    }

    public final boolean containsAll(@NotNull Iterable<? extends E> elements) {
        g0.p(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6) {
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        g0.p(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i6, null, null, 48, null);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [E, java.lang.Object] */
    public final E last(@NotNull Function1<? super E, Boolean> predicate) {
        ?? r22;
        g0.p(predicate, "predicate");
        Object[] objArr = this.content;
        int i6 = this._size;
        do {
            i6--;
            if (-1 < i6) {
                r22 = (Object) objArr[i6];
            } else {
                throw new NoSuchElementException("ObjectList contains no element matching the predicate.");
            }
        } while (!predicate.invoke(r22).booleanValue());
        return r22;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated) {
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        g0.p(postfix, "postfix");
        g0.p(truncated, "truncated");
        return joinToString$default(this, separator, prefix, postfix, i6, truncated, null, 32, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean containsAll(@NotNull ObjectList<E> elements) {
        g0.p(elements, "elements");
        Object[] objArr = elements.content;
        int i6 = elements._size;
        for (int i7 = 0; i7 < i6; i7++) {
            if (!contains(objArr[i7])) {
                return false;
            }
        }
        return true;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @Nullable Function1<? super E, ? extends CharSequence> function1) {
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        g0.p(postfix, "postfix");
        g0.p(truncated, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        Object[] objArr = this.content;
        int i7 = this._size;
        int i8 = 0;
        while (true) {
            if (i8 < i7) {
                Object obj = objArr[i8];
                if (i8 == i6) {
                    sb.append(truncated);
                    break;
                }
                if (i8 != 0) {
                    sb.append(separator);
                }
                if (function1 == null) {
                    sb.append(obj);
                } else {
                    sb.append(function1.invoke(obj));
                }
                i8++;
            } else {
                sb.append(postfix);
                break;
            }
        }
        String sb2 = sb.toString();
        g0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @PublishedApi
    public static /* synthetic */ void getContent$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void get_size$annotations() {
    }
}
