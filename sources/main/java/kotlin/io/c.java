package kotlin.io;

import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "ConsoleKt")
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c {
    @InlineOnly
    private static final void a(byte b6) {
        System.out.getClass();
    }

    @InlineOnly
    private static final void b(char c6) {
        System.out.getClass();
    }

    @InlineOnly
    private static final void c(double d6) {
        System.out.getClass();
    }

    @InlineOnly
    private static final void d(float f6) {
        System.out.getClass();
    }

    @InlineOnly
    private static final void e(int i6) {
        System.out.getClass();
    }

    @InlineOnly
    private static final void f(long j6) {
        System.out.getClass();
    }

    @InlineOnly
    private static final void g(Object obj) {
        System.out.getClass();
    }

    @InlineOnly
    private static final void h(short s5) {
        System.out.getClass();
    }

    @InlineOnly
    private static final void i(boolean z5) {
        System.out.getClass();
    }

    @InlineOnly
    private static final void j(char[] message) {
        g0.p(message, "message");
        System.out.getClass();
    }

    @InlineOnly
    private static final void k() {
        System.out.getClass();
    }

    @InlineOnly
    private static final void l(byte b6) {
        System.out.getClass();
    }

    @InlineOnly
    private static final void m(char c6) {
        System.out.getClass();
    }

    @InlineOnly
    private static final void n(double d6) {
        System.out.getClass();
    }

    @InlineOnly
    private static final void o(float f6) {
        System.out.getClass();
    }

    @InlineOnly
    private static final void p(int i6) {
        System.out.getClass();
    }

    @InlineOnly
    private static final void q(long j6) {
        System.out.getClass();
    }

    @InlineOnly
    private static final void r(Object obj) {
        System.out.getClass();
    }

    @InlineOnly
    private static final void s(short s5) {
        System.out.getClass();
    }

    @InlineOnly
    private static final void t(boolean z5) {
        System.out.getClass();
    }

    @InlineOnly
    private static final void u(char[] message) {
        g0.p(message, "message");
        System.out.getClass();
    }

    @Nullable
    public static final String v() {
        p pVar = p.f43879a;
        InputStream in = System.in;
        g0.o(in, "in");
        Charset defaultCharset = Charset.defaultCharset();
        g0.o(defaultCharset, "defaultCharset(...)");
        return pVar.d(in, defaultCharset);
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @NotNull
    public static final String w() {
        String x5 = x();
        if (x5 != null) {
            return x5;
        }
        throw new ReadAfterEOFException("EOF has already been reached");
    }

    @SinceKotlin(version = cn.bluemobi.dylan.photoview.a.f1297f)
    @Nullable
    public static final String x() {
        return v();
    }
}
