package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nArrays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Arrays.kt\nkotlin/collections/ArraysKt__ArraysKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,165:1\n1#2:166\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
class p extends o {
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "contentDeepEquals")
    public static final <T> boolean g(@Nullable T[] tArr, @Nullable T[] tArr2) {
        if (tArr == tArr2) {
            return true;
        }
        if (tArr == 0 || tArr2 == 0 || tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            Object[] objArr = tArr[i6];
            Object[] objArr2 = tArr2[i6];
            if (objArr != objArr2) {
                if (objArr == 0 || objArr2 == 0) {
                    return false;
                }
                if ((objArr instanceof Object[]) && (objArr2 instanceof Object[])) {
                    if (!g(objArr, objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof byte[]) && (objArr2 instanceof byte[])) {
                    if (!Arrays.equals((byte[]) objArr, (byte[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof short[]) && (objArr2 instanceof short[])) {
                    if (!Arrays.equals((short[]) objArr, (short[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof int[]) && (objArr2 instanceof int[])) {
                    if (!Arrays.equals((int[]) objArr, (int[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof long[]) && (objArr2 instanceof long[])) {
                    if (!Arrays.equals((long[]) objArr, (long[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof float[]) && (objArr2 instanceof float[])) {
                    if (!Arrays.equals((float[]) objArr, (float[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof double[]) && (objArr2 instanceof double[])) {
                    if (!Arrays.equals((double[]) objArr, (double[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof char[]) && (objArr2 instanceof char[])) {
                    if (!Arrays.equals((char[]) objArr, (char[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof boolean[]) && (objArr2 instanceof boolean[])) {
                    if (!Arrays.equals((boolean[]) objArr, (boolean[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof kotlin.w0) && (objArr2 instanceof kotlin.w0)) {
                    if (!kotlin.collections.unsigned.a.Y0(((kotlin.w0) objArr).z(), ((kotlin.w0) objArr2).z())) {
                        return false;
                    }
                } else if ((objArr instanceof kotlin.k1) && (objArr2 instanceof kotlin.k1)) {
                    if (!kotlin.collections.unsigned.a.W0(((kotlin.k1) objArr).z(), ((kotlin.k1) objArr2).z())) {
                        return false;
                    }
                } else if ((objArr instanceof kotlin.a1) && (objArr2 instanceof kotlin.a1)) {
                    if (!kotlin.collections.unsigned.a.X0(((kotlin.a1) objArr).z(), ((kotlin.a1) objArr2).z())) {
                        return false;
                    }
                } else if ((objArr instanceof kotlin.e1) && (objArr2 instanceof kotlin.e1)) {
                    if (!kotlin.collections.unsigned.a.Z0(((kotlin.e1) objArr).z(), ((kotlin.e1) objArr2).z())) {
                        return false;
                    }
                } else if (!kotlin.jvm.internal.g0.g(objArr, objArr2)) {
                    return false;
                }
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "contentDeepToString")
    @NotNull
    @PublishedApi
    public static final <T> String h(@Nullable T[] tArr) {
        if (tArr == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder((kotlin.ranges.t.B(tArr.length, 429496729) * 5) + 2);
        i(tArr, sb, new ArrayList());
        return sb.toString();
    }

    @NotNull
    public static final <T> List<T> j(@NotNull T[][] tArr) {
        kotlin.jvm.internal.g0.p(tArr, "<this>");
        int i6 = 0;
        for (T[] tArr2 : tArr) {
            i6 += tArr2.length;
        }
        ArrayList arrayList = new ArrayList(i6);
        for (T[] tArr3 : tArr) {
            m0.u0(arrayList, tArr3);
        }
        return arrayList;
    }

    /* JADX WARN: Incorrect types in method signature: <C:[Ljava/lang/Object;:TR;R:Ljava/lang/Object;>(TC;Lkotlin/jvm/functions/Function0<+TR;>;)TR; */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final Object k(Object[] objArr, Function0 defaultValue) {
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        return objArr.length == 0 ? defaultValue.invoke() : objArr;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final boolean l(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    @NotNull
    public static final <T, R> Pair<List<T>, List<R>> m(@NotNull Pair<? extends T, ? extends R>[] pairArr) {
        kotlin.jvm.internal.g0.p(pairArr, "<this>");
        ArrayList arrayList = new ArrayList(pairArr.length);
        ArrayList arrayList2 = new ArrayList(pairArr.length);
        for (Pair<? extends T, ? extends R> pair : pairArr) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return kotlin.o0.a(arrayList, arrayList2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> void i(T[] tArr, StringBuilder sb, List<Object[]> list) {
        if (list.contains(tArr)) {
            sb.append("[...]");
            return;
        }
        list.add(tArr);
        sb.append('[');
        int length = tArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (i6 != 0) {
                sb.append(", ");
            }
            Object[] objArr = tArr[i6];
            if (objArr == 0) {
                sb.append("null");
            } else if (objArr instanceof Object[]) {
                i(objArr, sb, list);
                kotlin.n1 n1Var = kotlin.n1.f44123a;
            } else if (objArr instanceof byte[]) {
                String arrays = Arrays.toString((byte[]) objArr);
                kotlin.jvm.internal.g0.o(arrays, "toString(...)");
                sb.append(arrays);
            } else if (objArr instanceof short[]) {
                String arrays2 = Arrays.toString((short[]) objArr);
                kotlin.jvm.internal.g0.o(arrays2, "toString(...)");
                sb.append(arrays2);
            } else if (objArr instanceof int[]) {
                String arrays3 = Arrays.toString((int[]) objArr);
                kotlin.jvm.internal.g0.o(arrays3, "toString(...)");
                sb.append(arrays3);
            } else if (objArr instanceof long[]) {
                String arrays4 = Arrays.toString((long[]) objArr);
                kotlin.jvm.internal.g0.o(arrays4, "toString(...)");
                sb.append(arrays4);
            } else if (objArr instanceof float[]) {
                String arrays5 = Arrays.toString((float[]) objArr);
                kotlin.jvm.internal.g0.o(arrays5, "toString(...)");
                sb.append(arrays5);
            } else if (objArr instanceof double[]) {
                String arrays6 = Arrays.toString((double[]) objArr);
                kotlin.jvm.internal.g0.o(arrays6, "toString(...)");
                sb.append(arrays6);
            } else if (objArr instanceof char[]) {
                String arrays7 = Arrays.toString((char[]) objArr);
                kotlin.jvm.internal.g0.o(arrays7, "toString(...)");
                sb.append(arrays7);
            } else if (objArr instanceof boolean[]) {
                String arrays8 = Arrays.toString((boolean[]) objArr);
                kotlin.jvm.internal.g0.o(arrays8, "toString(...)");
                sb.append(arrays8);
            } else if (objArr instanceof kotlin.w0) {
                sb.append(kotlin.collections.unsigned.a.e1(((kotlin.w0) objArr).z()));
            } else if (objArr instanceof kotlin.k1) {
                sb.append(kotlin.collections.unsigned.a.g1(((kotlin.k1) objArr).z()));
            } else if (objArr instanceof kotlin.a1) {
                sb.append(kotlin.collections.unsigned.a.f1(((kotlin.a1) objArr).z()));
            } else if (objArr instanceof kotlin.e1) {
                sb.append(kotlin.collections.unsigned.a.h1(((kotlin.e1) objArr).z()));
            } else {
                sb.append(objArr.toString());
            }
        }
        sb.append(']');
        list.remove(h0.L(list));
    }
}
