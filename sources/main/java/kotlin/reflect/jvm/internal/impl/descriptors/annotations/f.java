package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Pair;
import kotlin.collections.f0;
import kotlin.collections.i1;
import kotlin.jvm.internal.g0;
import kotlin.o0;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.resolve.constants.y;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.f f44650a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.f f44651b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.f f44652c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.f f44653d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.f f44654e;

    static {
        kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(CrashHianalyticsData.MESSAGE);
        g0.o(h6, "identifier(...)");
        f44650a = h6;
        kotlin.reflect.jvm.internal.impl.name.f h7 = kotlin.reflect.jvm.internal.impl.name.f.h("replaceWith");
        g0.o(h7, "identifier(...)");
        f44651b = h7;
        kotlin.reflect.jvm.internal.impl.name.f h8 = kotlin.reflect.jvm.internal.impl.name.f.h("level");
        g0.o(h8, "identifier(...)");
        f44652c = h8;
        kotlin.reflect.jvm.internal.impl.name.f h9 = kotlin.reflect.jvm.internal.impl.name.f.h("expression");
        g0.o(h9, "identifier(...)");
        f44653d = h9;
        kotlin.reflect.jvm.internal.impl.name.f h10 = kotlin.reflect.jvm.internal.impl.name.f.h("imports");
        g0.o(h10, "identifier(...)");
        f44654e = h10;
    }

    @NotNull
    public static final c b(@NotNull kotlin.reflect.jvm.internal.impl.builtins.j jVar, @NotNull String message, @NotNull String replaceWith, @NotNull String level, boolean z5) {
        g0.p(jVar, "<this>");
        g0.p(message, "message");
        g0.p(replaceWith, "replaceWith");
        g0.p(level, "level");
        k kVar = new k(jVar, o.a.B, i1.W(o0.a(f44653d, new y(replaceWith)), o0.a(f44654e, new kotlin.reflect.jvm.internal.impl.resolve.constants.b(f0.J(), new e(jVar)))), false, 8, null);
        kotlin.reflect.jvm.internal.impl.name.c cVar = o.a.f44631y;
        Pair a6 = o0.a(f44650a, new y(message));
        Pair a7 = o0.a(f44651b, new kotlin.reflect.jvm.internal.impl.resolve.constants.a(kVar));
        kotlin.reflect.jvm.internal.impl.name.f fVar = f44652c;
        kotlin.reflect.jvm.internal.impl.name.b c6 = kotlin.reflect.jvm.internal.impl.name.b.f46334d.c(o.a.A);
        kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(level);
        g0.o(h6, "identifier(...)");
        return new k(jVar, cVar, i1.W(a6, a7, o0.a(fVar, new kotlin.reflect.jvm.internal.impl.resolve.constants.k(c6, h6))), z5);
    }

    public static /* synthetic */ c c(kotlin.reflect.jvm.internal.impl.builtins.j jVar, String str, String str2, String str3, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            str2 = "";
        }
        if ((i6 & 4) != 0) {
            str3 = "WARNING";
        }
        if ((i6 & 8) != 0) {
            z5 = false;
        }
        return b(jVar, str, str2, str3, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t0 d(kotlin.reflect.jvm.internal.impl.builtins.j jVar, kotlin.reflect.jvm.internal.impl.descriptors.f0 module) {
        g0.p(module, "module");
        e1 m6 = module.p().m(Variance.INVARIANT, jVar.X());
        g0.o(m6, "getArrayType(...)");
        return m6;
    }
}
