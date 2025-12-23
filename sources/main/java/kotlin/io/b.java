package kotlin.io;

import java.io.Closeable;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "CloseableKt")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b {
    @SinceKotlin(version = "1.1")
    @PublishedApi
    public static final void a(@Nullable Closeable closeable, @Nullable Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                kotlin.l.a(th, th2);
            }
        }
    }

    @InlineOnly
    private static final <T extends Closeable, R> R b(T t5, Function1<? super T, ? extends R> block) {
        g0.p(block, "block");
        try {
            R invoke = block.invoke(t5);
            d0.d(1);
            a(t5, null);
            d0.c(1);
            return invoke;
        } finally {
        }
    }
}
