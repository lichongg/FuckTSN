package okio;

import java.io.Closeable;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
final /* synthetic */ class Okio__OkioKt {
    @NotNull
    public static final BufferedSource buffer(@NotNull Source source) {
        g0.p(source, "<this>");
        return new RealBufferedSource(source);
    }

    @JvmName(name = "blackhole")
    @NotNull
    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    @NotNull
    public static final BufferedSink buffer(@NotNull Sink sink) {
        g0.p(sink, "<this>");
        return new RealBufferedSink(sink);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    public static final <T extends Closeable, R> R use(T t5, @NotNull Function1<? super T, ? extends R> block) {
        ?? r42;
        g0.p(block, "block");
        R th = null;
        try {
            R invoke = block.invoke(t5);
            d0.d(1);
            if (t5 != null) {
                try {
                    t5.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            d0.c(1);
            R r5 = th;
            th = invoke;
            r42 = r5;
        } catch (Throwable th3) {
            d0.d(1);
            if (t5 != null) {
                try {
                    t5.close();
                } catch (Throwable th4) {
                    kotlin.l.a(th3, th4);
                }
            }
            d0.c(1);
            r42 = th3;
        }
        if (r42 == 0) {
            return th;
        }
        throw r42;
    }
}
