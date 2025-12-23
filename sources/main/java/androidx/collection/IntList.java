package androidx.collection;

import androidx.annotation.IntRange;
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
@SourceDebugExtension({"SMAP\nIntList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntList.kt\nandroidx/collection/IntList\n*L\n1#1,969:1\n253#1,6:970\n279#1,6:976\n253#1,6:982\n75#1:988\n253#1,6:989\n253#1,6:995\n253#1,6:1001\n266#1,6:1007\n279#1,6:1013\n293#1,6:1019\n70#1:1025\n70#1:1026\n266#1,6:1027\n266#1,6:1033\n293#1,6:1039\n70#1:1045\n279#1,6:1046\n293#1,6:1052\n266#1,6:1058\n266#1,6:1064\n253#1,6:1070\n75#1:1076\n467#1,10:1077\n266#1,4:1087\n477#1,9:1091\n271#1:1100\n486#1,2:1101\n467#1,10:1103\n266#1,4:1113\n477#1,9:1117\n271#1:1126\n486#1,2:1127\n467#1,10:1129\n266#1,4:1139\n477#1,9:1143\n271#1:1152\n486#1,2:1153\n467#1,10:1155\n266#1,4:1165\n477#1,9:1169\n271#1:1178\n486#1,2:1179\n467#1,10:1181\n266#1,4:1191\n477#1,9:1195\n271#1:1204\n486#1,2:1205\n*S KotlinDebug\n*F\n+ 1 IntList.kt\nandroidx/collection/IntList\n*L\n96#1:970,6\n110#1:976,6\n122#1:982,6\n135#1:988\n153#1:989,6\n175#1:995,6\n192#1:1001,6\n208#1:1007,6\n225#1:1013,6\n241#1:1019,6\n306#1:1025\n317#1:1026\n343#1:1027,6\n357#1:1033,6\n371#1:1039,6\n397#1:1045\n407#1:1046,6\n420#1:1052,6\n445#1:1058,6\n476#1:1064,6\n494#1:1070,6\n510#1:1076\n-1#1:1077,10\n-1#1:1087,4\n-1#1:1091,9\n-1#1:1100\n-1#1:1101,2\n-1#1:1103,10\n-1#1:1113,4\n-1#1:1117,9\n-1#1:1126\n-1#1:1127,2\n-1#1:1129,10\n-1#1:1139,4\n-1#1:1143,9\n-1#1:1152\n-1#1:1153,2\n-1#1:1155,10\n-1#1:1165,4\n-1#1:1169,9\n-1#1:1178\n-1#1:1179,2\n-1#1:1181,10\n-1#1:1191,4\n-1#1:1195,9\n-1#1:1204\n-1#1:1205,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class IntList {

    @JvmField
    public int _size;

    @JvmField
    @NotNull
    public int[] content;

    public /* synthetic */ IntList(int i6, v vVar) {
        this(i6);
    }

    public static /* synthetic */ String joinToString$default(IntList intList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i6, CharSequence charSequence4, int i7, Object obj) {
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
        CharSequence charSequence5 = charSequence4;
        CharSequence charSequence6 = charSequence3;
        return intList.joinToString(charSequence, charSequence2, charSequence6, i6, charSequence5);
    }

    public final boolean any() {
        return isNotEmpty();
    }

    public final int count() {
        return this._size;
    }

    public final int first() {
        if (isEmpty()) {
            throw new NoSuchElementException("IntList is empty.");
        }
        return this.content[0];
    }

    @NotNull
    public final m getIndices() {
        return t.W1(0, this._size);
    }

    @JvmOverloads
    @NotNull
    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final int last() {
        if (isEmpty()) {
            throw new NoSuchElementException("IntList is empty.");
        }
        return this.content[this._size - 1];
    }

    private IntList(int i6) {
        this.content = i6 == 0 ? IntSetKt.getEmptyIntArray() : new int[i6];
    }

    public final boolean any(@NotNull Function1<? super Integer, Boolean> predicate) {
        g0.p(predicate, "predicate");
        int[] iArr = this.content;
        int i6 = this._size;
        for (int i7 = 0; i7 < i6; i7++) {
            if (predicate.invoke(Integer.valueOf(iArr[i7])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final boolean contains(int i6) {
        int[] iArr = this.content;
        int i7 = this._size;
        for (int i8 = 0; i8 < i7; i8++) {
            if (iArr[i8] == i6) {
                return true;
            }
        }
        return false;
    }

    public final boolean containsAll(@NotNull IntList elements) {
        g0.p(elements, "elements");
        m W1 = t.W1(0, elements._size);
        int e6 = W1.e();
        int f6 = W1.f();
        if (e6 > f6) {
            return true;
        }
        while (contains(elements.get(e6))) {
            if (e6 == f6) {
                return true;
            }
            e6++;
        }
        return false;
    }

    public final int count(@NotNull Function1<? super Integer, Boolean> predicate) {
        g0.p(predicate, "predicate");
        int[] iArr = this.content;
        int i6 = this._size;
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            if (predicate.invoke(Integer.valueOf(iArr[i8])).booleanValue()) {
                i7++;
            }
        }
        return i7;
    }

    public final int elementAt(@IntRange(from = 0) int i6) {
        if (i6 >= 0 && i6 < this._size) {
            return this.content[i6];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Index ");
        sb.append(i6);
        sb.append(" must be in 0..");
        sb.append(this._size - 1);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final int elementAtOrElse(@IntRange(from = 0) int i6, @NotNull Function1<? super Integer, Integer> defaultValue) {
        g0.p(defaultValue, "defaultValue");
        return (i6 < 0 || i6 >= this._size) ? defaultValue.invoke(Integer.valueOf(i6)).intValue() : this.content[i6];
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof IntList) {
            IntList intList = (IntList) obj;
            int i6 = intList._size;
            int i7 = this._size;
            if (i6 == i7) {
                int[] iArr = this.content;
                int[] iArr2 = intList.content;
                m W1 = t.W1(0, i7);
                int e6 = W1.e();
                int f6 = W1.f();
                if (e6 > f6) {
                    return true;
                }
                while (iArr[e6] == iArr2[e6]) {
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

    public final <R> R fold(R r5, @NotNull Function2<? super R, ? super Integer, ? extends R> operation) {
        g0.p(operation, "operation");
        int[] iArr = this.content;
        int i6 = this._size;
        for (int i7 = 0; i7 < i6; i7++) {
            r5 = operation.invoke(r5, Integer.valueOf(iArr[i7]));
        }
        return r5;
    }

    public final <R> R foldIndexed(R r5, @NotNull Function3<? super Integer, ? super R, ? super Integer, ? extends R> operation) {
        g0.p(operation, "operation");
        int[] iArr = this.content;
        int i6 = this._size;
        for (int i7 = 0; i7 < i6; i7++) {
            R r6 = r5;
            r5 = operation.invoke(Integer.valueOf(i7), r6, Integer.valueOf(iArr[i7]));
        }
        return r5;
    }

    public final <R> R foldRight(R r5, @NotNull Function2<? super Integer, ? super R, ? extends R> operation) {
        g0.p(operation, "operation");
        int[] iArr = this.content;
        int i6 = this._size;
        while (true) {
            i6--;
            if (-1 >= i6) {
                return r5;
            }
            r5 = operation.invoke(Integer.valueOf(iArr[i6]), r5);
        }
    }

    public final <R> R foldRightIndexed(R r5, @NotNull Function3<? super Integer, ? super Integer, ? super R, ? extends R> operation) {
        g0.p(operation, "operation");
        int[] iArr = this.content;
        int i6 = this._size;
        while (true) {
            i6--;
            if (-1 >= i6) {
                return r5;
            }
            r5 = operation.invoke(Integer.valueOf(i6), Integer.valueOf(iArr[i6]), r5);
        }
    }

    public final void forEach(@NotNull Function1<? super Integer, n1> block) {
        g0.p(block, "block");
        int[] iArr = this.content;
        int i6 = this._size;
        for (int i7 = 0; i7 < i6; i7++) {
            block.invoke(Integer.valueOf(iArr[i7]));
        }
    }

    public final void forEachIndexed(@NotNull Function2<? super Integer, ? super Integer, n1> block) {
        g0.p(block, "block");
        int[] iArr = this.content;
        int i6 = this._size;
        for (int i7 = 0; i7 < i6; i7++) {
            block.invoke(Integer.valueOf(i7), Integer.valueOf(iArr[i7]));
        }
    }

    public final void forEachReversed(@NotNull Function1<? super Integer, n1> block) {
        g0.p(block, "block");
        int[] iArr = this.content;
        int i6 = this._size;
        while (true) {
            i6--;
            if (-1 >= i6) {
                return;
            } else {
                block.invoke(Integer.valueOf(iArr[i6]));
            }
        }
    }

    public final void forEachReversedIndexed(@NotNull Function2<? super Integer, ? super Integer, n1> block) {
        g0.p(block, "block");
        int[] iArr = this.content;
        int i6 = this._size;
        while (true) {
            i6--;
            if (-1 >= i6) {
                return;
            } else {
                block.invoke(Integer.valueOf(i6), Integer.valueOf(iArr[i6]));
            }
        }
    }

    public final int get(@IntRange(from = 0) int i6) {
        if (i6 >= 0 && i6 < this._size) {
            return this.content[i6];
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
        int[] iArr = this.content;
        int i6 = this._size;
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            i7 += iArr[i8] * 31;
        }
        return i7;
    }

    public final int indexOf(int i6) {
        int[] iArr = this.content;
        int i7 = this._size;
        for (int i8 = 0; i8 < i7; i8++) {
            if (i6 == iArr[i8]) {
                return i8;
            }
        }
        return -1;
    }

    public final int indexOfFirst(@NotNull Function1<? super Integer, Boolean> predicate) {
        g0.p(predicate, "predicate");
        int[] iArr = this.content;
        int i6 = this._size;
        for (int i7 = 0; i7 < i6; i7++) {
            if (predicate.invoke(Integer.valueOf(iArr[i7])).booleanValue()) {
                return i7;
            }
        }
        return -1;
    }

    public final int indexOfLast(@NotNull Function1<? super Integer, Boolean> predicate) {
        g0.p(predicate, "predicate");
        int[] iArr = this.content;
        int i6 = this._size;
        do {
            i6--;
            if (-1 >= i6) {
                return -1;
            }
        } while (!predicate.invoke(Integer.valueOf(iArr[i6])).booleanValue());
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
        return joinToString$default(this, separator, null, null, 0, null, 30, null);
    }

    public final int lastIndexOf(int i6) {
        int[] iArr = this.content;
        int i7 = this._size;
        do {
            i7--;
            if (-1 >= i7) {
                return -1;
            }
        } while (iArr[i7] != i6);
        return i7;
    }

    public final boolean reversedAny(@NotNull Function1<? super Integer, Boolean> predicate) {
        g0.p(predicate, "predicate");
        int[] iArr = this.content;
        for (int i6 = this._size - 1; -1 < i6; i6--) {
            if (predicate.invoke(Integer.valueOf(iArr[i6])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, 25, null);
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix) {
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, 28, null);
    }

    public final boolean none() {
        return isEmpty();
    }

    public final int first(@NotNull Function1<? super Integer, Boolean> predicate) {
        g0.p(predicate, "predicate");
        int[] iArr = this.content;
        int i6 = this._size;
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = iArr[i7];
            if (predicate.invoke(Integer.valueOf(i8)).booleanValue()) {
                return i8;
            }
        }
        throw new NoSuchElementException("IntList contains no element matching the predicate.");
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix) {
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        g0.p(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, 24, null);
    }

    public static /* synthetic */ String joinToString$default(IntList intList, CharSequence separator, CharSequence prefix, CharSequence postfix, int i6, CharSequence truncated, Function1 transform, int i7, Object obj) {
        if (obj == null) {
            if ((i7 & 1) != 0) {
                separator = ", ";
            }
            if ((i7 & 2) != 0) {
                prefix = "";
            }
            if ((i7 & 4) != 0) {
                postfix = "";
            }
            if ((i7 & 8) != 0) {
                i6 = -1;
            }
            if ((i7 & 16) != 0) {
                truncated = "...";
            }
            g0.p(separator, "separator");
            g0.p(prefix, "prefix");
            g0.p(postfix, "postfix");
            g0.p(truncated, "truncated");
            g0.p(transform, "transform");
            StringBuilder sb = new StringBuilder();
            sb.append(prefix);
            int[] iArr = intList.content;
            int i8 = intList._size;
            int i9 = 0;
            while (true) {
                if (i9 < i8) {
                    int i10 = iArr[i9];
                    if (i9 == i6) {
                        sb.append(truncated);
                        break;
                    }
                    if (i9 != 0) {
                        sb.append(separator);
                    }
                    sb.append((CharSequence) transform.invoke(Integer.valueOf(i10)));
                    i9++;
                } else {
                    sb.append(postfix);
                    break;
                }
            }
            String sb2 = sb.toString();
            g0.o(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6) {
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        g0.p(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i6, null, 16, null);
    }

    public final int last(@NotNull Function1<? super Integer, Boolean> predicate) {
        int i6;
        g0.p(predicate, "predicate");
        int[] iArr = this.content;
        int i7 = this._size;
        do {
            i7--;
            if (-1 < i7) {
                i6 = iArr[i7];
            } else {
                throw new NoSuchElementException("IntList contains no element matching the predicate.");
            }
        } while (!predicate.invoke(Integer.valueOf(i6)).booleanValue());
        return i6;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated) {
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        g0.p(postfix, "postfix");
        g0.p(truncated, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        int[] iArr = this.content;
        int i7 = this._size;
        int i8 = 0;
        while (true) {
            if (i8 < i7) {
                int i9 = iArr[i8];
                if (i8 == i6) {
                    sb.append(truncated);
                    break;
                }
                if (i8 != 0) {
                    sb.append(separator);
                }
                sb.append(i9);
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

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull CharSequence truncated, @NotNull Function1<? super Integer, ? extends CharSequence> transform) {
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        g0.p(postfix, "postfix");
        g0.p(truncated, "truncated");
        g0.p(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        int[] iArr = this.content;
        int i7 = this._size;
        int i8 = 0;
        while (true) {
            if (i8 < i7) {
                int i9 = iArr[i8];
                if (i8 == i6) {
                    sb.append(truncated);
                    break;
                }
                if (i8 != 0) {
                    sb.append(separator);
                }
                sb.append(transform.invoke(Integer.valueOf(i9)));
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

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, int i6, @NotNull Function1<? super Integer, ? extends CharSequence> transform) {
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        g0.p(postfix, "postfix");
        g0.p(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        int[] iArr = this.content;
        int i7 = this._size;
        int i8 = 0;
        while (true) {
            if (i8 < i7) {
                int i9 = iArr[i8];
                if (i8 == i6) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i8 != 0) {
                    sb.append(separator);
                }
                sb.append(transform.invoke(Integer.valueOf(i9)));
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

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull CharSequence postfix, @NotNull Function1<? super Integer, ? extends CharSequence> transform) {
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        g0.p(postfix, "postfix");
        g0.p(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        int[] iArr = this.content;
        int i6 = this._size;
        int i7 = 0;
        while (true) {
            if (i7 < i6) {
                int i8 = iArr[i7];
                if (i7 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i7 != 0) {
                    sb.append(separator);
                }
                sb.append(transform.invoke(Integer.valueOf(i8)));
                i7++;
            } else {
                sb.append(postfix);
                break;
            }
        }
        String sb2 = sb.toString();
        g0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull CharSequence prefix, @NotNull Function1<? super Integer, ? extends CharSequence> transform) {
        g0.p(separator, "separator");
        g0.p(prefix, "prefix");
        g0.p(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        int[] iArr = this.content;
        int i6 = this._size;
        int i7 = 0;
        while (true) {
            if (i7 < i6) {
                int i8 = iArr[i7];
                if (i7 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i7 != 0) {
                    sb.append(separator);
                }
                sb.append(transform.invoke(Integer.valueOf(i8)));
                i7++;
            } else {
                sb.append((CharSequence) "");
                break;
            }
        }
        String sb2 = sb.toString();
        g0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull CharSequence separator, @NotNull Function1<? super Integer, ? extends CharSequence> transform) {
        g0.p(separator, "separator");
        g0.p(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int[] iArr = this.content;
        int i6 = this._size;
        int i7 = 0;
        while (true) {
            if (i7 < i6) {
                int i8 = iArr[i7];
                if (i7 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i7 != 0) {
                    sb.append(separator);
                }
                sb.append(transform.invoke(Integer.valueOf(i8)));
                i7++;
            } else {
                sb.append((CharSequence) "");
                break;
            }
        }
        String sb2 = sb.toString();
        g0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @JvmOverloads
    @NotNull
    public final String joinToString(@NotNull Function1<? super Integer, ? extends CharSequence> transform) {
        g0.p(transform, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int[] iArr = this.content;
        int i6 = this._size;
        int i7 = 0;
        while (true) {
            if (i7 < i6) {
                int i8 = iArr[i7];
                if (i7 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i7 != 0) {
                    sb.append((CharSequence) ", ");
                }
                sb.append(transform.invoke(Integer.valueOf(i8)));
                i7++;
            } else {
                sb.append((CharSequence) "");
                break;
            }
        }
        String sb2 = sb.toString();
        g0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
