package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class o {
    @NotNull
    public static final <T> T[] a(@NotNull T[] reference, int i6) {
        kotlin.jvm.internal.g0.p(reference, "reference");
        Object newInstance = Array.newInstance(reference.getClass().getComponentType(), i6);
        kotlin.jvm.internal.g0.n(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (T[]) ((Object[]) newInstance);
    }

    @SinceKotlin(version = "1.3")
    public static final void c(int i6, int i7) {
        if (i6 <= i7) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i6 + ") is greater than size (" + i7 + ").");
    }

    public static final /* synthetic */ <T> T[] d(T[] tArr) {
        if (tArr != null) {
            return tArr;
        }
        kotlin.jvm.internal.g0.y(0, ExifInterface.GPS_DIRECTION_TRUE);
        return (T[]) new Object[0];
    }

    @InlineOnly
    private static final String e(byte[] bArr, Charset charset) {
        kotlin.jvm.internal.g0.p(bArr, "<this>");
        kotlin.jvm.internal.g0.p(charset, "charset");
        return new String(bArr, charset);
    }

    public static final /* synthetic */ <T> T[] f(Collection<? extends T> collection) {
        kotlin.jvm.internal.g0.p(collection, "<this>");
        kotlin.jvm.internal.g0.y(0, "T?");
        return (T[]) collection.toArray(new Object[0]);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "contentDeepHashCode")
    public static final <T> int b(@Nullable T[] tArr) {
        return Arrays.deepHashCode(tArr);
    }
}
