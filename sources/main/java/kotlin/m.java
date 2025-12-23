package kotlin;

import com.daimajia.numberprogressbar.BuildConfig;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import kotlin.internal.HidesMembers;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class m {
    @SinceKotlin(version = "1.1")
    @HidesMembers
    public static void a(@NotNull Throwable th, @NotNull Throwable exception) {
        kotlin.jvm.internal.g0.p(th, "<this>");
        kotlin.jvm.internal.g0.p(exception, "exception");
        if (th != exception) {
            kotlin.internal.b.f43804a.a(th, exception);
        }
    }

    @NotNull
    public static final StackTraceElement[] b(@NotNull Throwable th) {
        kotlin.jvm.internal.g0.p(th, "<this>");
        StackTraceElement[] stackTrace = th.getStackTrace();
        kotlin.jvm.internal.g0.m(stackTrace);
        return stackTrace;
    }

    @NotNull
    public static final List<Throwable> d(@NotNull Throwable th) {
        kotlin.jvm.internal.g0.p(th, "<this>");
        return kotlin.internal.b.f43804a.d(th);
    }

    @InlineOnly
    private static final void f(Throwable th) {
        kotlin.jvm.internal.g0.p(th, "<this>");
        th.printStackTrace();
    }

    @InlineOnly
    private static final void g(Throwable th, PrintStream stream) {
        kotlin.jvm.internal.g0.p(th, "<this>");
        kotlin.jvm.internal.g0.p(stream, "stream");
        th.printStackTrace(stream);
    }

    @InlineOnly
    private static final void h(Throwable th, PrintWriter writer) {
        kotlin.jvm.internal.g0.p(th, "<this>");
        kotlin.jvm.internal.g0.p(writer, "writer");
        th.printStackTrace(writer);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    public static String i(@NotNull Throwable th) {
        kotlin.jvm.internal.g0.p(th, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        kotlin.jvm.internal.g0.o(stringWriter2, "toString(...)");
        return stringWriter2;
    }

    public static /* synthetic */ void c(Throwable th) {
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public static /* synthetic */ void e(Throwable th) {
    }
}
