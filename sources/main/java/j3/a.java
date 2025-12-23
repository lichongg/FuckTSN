package j3;

import com.daimajia.numberprogressbar.BuildConfig;
import java.util.concurrent.CancellationException;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.SourceDebugExtension;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCancellationException.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellationException.kt\nkotlin/coroutines/cancellation/CancellationExceptionKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,22:1\n1#2:23\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a {
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final CancellationException a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    private static final CancellationException b(Throwable th) {
        CancellationException cancellationException = new CancellationException(th != null ? String.valueOf(th) : null);
        cancellationException.initCause(th);
        return cancellationException;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static /* synthetic */ void c() {
    }
}
