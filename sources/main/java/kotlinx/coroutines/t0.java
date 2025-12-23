package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.PublishedApi;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class t0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final String f49650a = "kotlinx.coroutines.debug";

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final String f49651b = "kotlinx.coroutines.stacktrace.recovery";

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final String f49652c = "auto";

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final String f49653d = "on";

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final String f49654e = "off";

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f49655f = false;

    /* renamed from: g, reason: collision with root package name */
    private static final boolean f49656g;

    /* renamed from: h, reason: collision with root package name */
    private static final boolean f49657h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final AtomicLong f49658i;

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        if (r0.equals(kotlinx.coroutines.t0.f49653d) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0040, code lost:
    
        if (r0.equals("") != false) goto L23;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.debug"
            java.lang.String r0 = kotlinx.coroutines.internal.v0.d(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L2f
            int r3 = r0.hashCode()
            if (r3 == 0) goto L3a
            r4 = 3551(0xddf, float:4.976E-42)
            if (r3 == r4) goto L31
            r4 = 109935(0x1ad6f, float:1.54052E-40)
            if (r3 == r4) goto L27
            r4 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r3 != r4) goto L44
            java.lang.String r3 = "auto"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L44
            goto L2f
        L27:
            java.lang.String r3 = "off"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L44
        L2f:
            r0 = 0
            goto L64
        L31:
            java.lang.String r3 = "on"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L44
            goto L42
        L3a:
            java.lang.String r3 = ""
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L44
        L42:
            r0 = 1
            goto L64
        L44:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
            r2.append(r3)
            r2.append(r0)
            r0 = 39
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L64:
            kotlinx.coroutines.t0.f49656g = r0
            if (r0 == 0) goto L71
            java.lang.String r0 = "kotlinx.coroutines.stacktrace.recovery"
            boolean r0 = kotlinx.coroutines.internal.v0.f(r0, r1)
            if (r0 == 0) goto L71
            goto L72
        L71:
            r1 = 0
        L72:
            kotlinx.coroutines.t0.f49657h = r1
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r1 = 0
            r0.<init>(r1)
            kotlinx.coroutines.t0.f49658i = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.t0.<clinit>():void");
    }

    public static final boolean b() {
        return f49655f;
    }

    @NotNull
    public static final AtomicLong c() {
        return f49658i;
    }

    public static final boolean d() {
        return f49656g;
    }

    public static final boolean e() {
        return f49657h;
    }

    public static final void g() {
        f49658i.set(0L);
    }

    @PublishedApi
    public static /* synthetic */ void f() {
    }

    @InlineOnly
    private static final void a(Function0<Boolean> function0) {
    }
}
