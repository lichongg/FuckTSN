package kotlin.reflect.jvm.internal.impl.load.java;

import com.acse.ottn.l3;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.reflect.jvm.internal.impl.name.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h0 f45435a = new h0();

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c f45436b;

    /* renamed from: c, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.b f45437c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.b f45438d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.b f45439e;

    static {
        kotlin.reflect.jvm.internal.impl.name.c cVar = new kotlin.reflect.jvm.internal.impl.name.c("kotlin.jvm.JvmField");
        f45436b = cVar;
        b.a aVar = kotlin.reflect.jvm.internal.impl.name.b.f46334d;
        f45437c = aVar.c(cVar);
        f45438d = aVar.c(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
        f45439e = b.a.b(aVar, "kotlin/jvm/internal/RepeatableContainer", false, 2, null);
    }

    @JvmStatic
    @NotNull
    public static final String b(@NotNull String propertyName) {
        kotlin.jvm.internal.g0.p(propertyName, "propertyName");
        if (f(propertyName)) {
            return propertyName;
        }
        return l3.f4736f + f4.a.a(propertyName);
    }

    @JvmStatic
    public static final boolean c(@NotNull String name) {
        kotlin.jvm.internal.g0.p(name, "name");
        return kotlin.text.u.H2(name, l3.f4736f, false, 2, null) || kotlin.text.u.H2(name, "is", false, 2, null);
    }

    @JvmStatic
    public static final boolean d(@NotNull String name) {
        kotlin.jvm.internal.g0.p(name, "name");
        return kotlin.text.u.H2(name, l3.f4738h, false, 2, null);
    }

    @JvmStatic
    @NotNull
    public static final String e(@NotNull String propertyName) {
        String a6;
        kotlin.jvm.internal.g0.p(propertyName, "propertyName");
        StringBuilder sb = new StringBuilder();
        sb.append(l3.f4738h);
        if (f(propertyName)) {
            a6 = propertyName.substring(2);
            kotlin.jvm.internal.g0.o(a6, "substring(...)");
        } else {
            a6 = f4.a.a(propertyName);
        }
        sb.append(a6);
        return sb.toString();
    }

    @JvmStatic
    public static final boolean f(@NotNull String name) {
        kotlin.jvm.internal.g0.p(name, "name");
        if (!kotlin.text.u.H2(name, "is", false, 2, null) || name.length() == 2) {
            return false;
        }
        char charAt = name.charAt(2);
        return kotlin.jvm.internal.g0.t(97, charAt) > 0 || kotlin.jvm.internal.g0.t(charAt, 122) > 0;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.b a() {
        return f45439e;
    }

    private h0() {
    }
}
