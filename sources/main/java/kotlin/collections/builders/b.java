package kotlin.collections.builders;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/ListBuilderKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,722:1\n1#2:723\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> int i(T[] tArr, int i6, int i7) {
        int i8 = 1;
        for (int i9 = 0; i9 < i7; i9++) {
            T t5 = tArr[i6 + i9];
            i8 = (i8 * 31) + (t5 != null ? t5.hashCode() : 0);
        }
        return i8;
    }

    @NotNull
    public static final <E> E[] d(int i6) {
        if (i6 >= 0) {
            return (E[]) new Object[i6];
        }
        throw new IllegalArgumentException("capacity must be non-negative.");
    }

    @NotNull
    public static final <T> T[] e(@NotNull T[] tArr, int i6) {
        g0.p(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i6);
        g0.o(tArr2, "copyOf(...)");
        return tArr2;
    }

    public static final <E> void f(@NotNull E[] eArr, int i6) {
        g0.p(eArr, "<this>");
        eArr[i6] = null;
    }

    public static final <E> void g(@NotNull E[] eArr, int i6, int i7) {
        g0.p(eArr, "<this>");
        while (i6 < i7) {
            f(eArr, i6);
            i6++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> String j(T[] tArr, int i6, int i7, Collection<? extends T> collection) {
        StringBuilder sb = new StringBuilder((i7 * 3) + 2);
        sb.append("[");
        for (int i8 = 0; i8 < i7; i8++) {
            if (i8 > 0) {
                sb.append(", ");
            }
            T t5 = tArr[i6 + i8];
            if (t5 == collection) {
                sb.append("(this Collection)");
            } else {
                sb.append(t5);
            }
        }
        sb.append("]");
        String sb2 = sb.toString();
        g0.o(sb2, "toString(...)");
        return sb2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> boolean h(T[] tArr, int i6, int i7, List<?> list) {
        if (i7 != list.size()) {
            return false;
        }
        for (int i8 = 0; i8 < i7; i8++) {
            if (!g0.g(tArr[i6 + i8], list.get(i8))) {
                return false;
            }
        }
        return true;
    }
}
