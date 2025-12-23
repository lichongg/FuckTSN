package kotlin.text;

import java.nio.charset.Charset;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f47850a = new e();

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final Charset f47851b;

    /* renamed from: c, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final Charset f47852c;

    /* renamed from: d, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final Charset f47853d;

    /* renamed from: e, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final Charset f47854e;

    /* renamed from: f, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final Charset f47855f;

    /* renamed from: g, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final Charset f47856g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private static volatile Charset f47857h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private static volatile Charset f47858i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private static volatile Charset f47859j;

    static {
        Charset forName = Charset.forName("UTF-8");
        kotlin.jvm.internal.g0.o(forName, "forName(...)");
        f47851b = forName;
        Charset forName2 = Charset.forName("UTF-16");
        kotlin.jvm.internal.g0.o(forName2, "forName(...)");
        f47852c = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        kotlin.jvm.internal.g0.o(forName3, "forName(...)");
        f47853d = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        kotlin.jvm.internal.g0.o(forName4, "forName(...)");
        f47854e = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        kotlin.jvm.internal.g0.o(forName5, "forName(...)");
        f47855f = forName5;
        Charset forName6 = Charset.forName(org.apache.commons.net.ftp.b.T);
        kotlin.jvm.internal.g0.o(forName6, "forName(...)");
        f47856g = forName6;
    }

    @JvmName(name = "UTF32")
    @NotNull
    public final Charset a() {
        Charset charset = f47857h;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32");
        kotlin.jvm.internal.g0.o(forName, "forName(...)");
        f47857h = forName;
        return forName;
    }

    @JvmName(name = "UTF32_BE")
    @NotNull
    public final Charset b() {
        Charset charset = f47859j;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32BE");
        kotlin.jvm.internal.g0.o(forName, "forName(...)");
        f47859j = forName;
        return forName;
    }

    @JvmName(name = "UTF32_LE")
    @NotNull
    public final Charset c() {
        Charset charset = f47858i;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32LE");
        kotlin.jvm.internal.g0.o(forName, "forName(...)");
        f47858i = forName;
        return forName;
    }

    private e() {
    }
}
