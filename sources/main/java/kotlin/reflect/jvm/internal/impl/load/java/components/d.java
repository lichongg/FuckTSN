package kotlin.reflect.jvm.internal.impl.load.java.components;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.Map;
import kotlin.collections.i1;
import kotlin.jvm.internal.g0;
import kotlin.o0;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.load.java.i0;
import kotlin.reflect.jvm.internal.impl.name.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f45385a = new d();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.f f45386b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.f f45387c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.f f45388d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Map<kotlin.reflect.jvm.internal.impl.name.c, kotlin.reflect.jvm.internal.impl.name.c> f45389e;

    static {
        kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(CrashHianalyticsData.MESSAGE);
        g0.o(h6, "identifier(...)");
        f45386b = h6;
        kotlin.reflect.jvm.internal.impl.name.f h7 = kotlin.reflect.jvm.internal.impl.name.f.h("allowedTargets");
        g0.o(h7, "identifier(...)");
        f45387c = h7;
        kotlin.reflect.jvm.internal.impl.name.f h8 = kotlin.reflect.jvm.internal.impl.name.f.h("value");
        g0.o(h8, "identifier(...)");
        f45388d = h8;
        f45389e = i1.W(o0.a(o.a.H, i0.f45449d), o0.a(o.a.L, i0.f45451f), o0.a(o.a.P, i0.f45454i));
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.annotations.c f(d dVar, y3.a aVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.k kVar, boolean z5, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        return dVar.e(aVar, kVar, z5);
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c a(@NotNull kotlin.reflect.jvm.internal.impl.name.c kotlinName, @NotNull y3.d annotationOwner, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.k c6) {
        y3.a b6;
        g0.p(kotlinName, "kotlinName");
        g0.p(annotationOwner, "annotationOwner");
        g0.p(c6, "c");
        if (g0.g(kotlinName, o.a.f44631y)) {
            kotlin.reflect.jvm.internal.impl.name.c DEPRECATED_ANNOTATION = i0.f45453h;
            g0.o(DEPRECATED_ANNOTATION, "DEPRECATED_ANNOTATION");
            y3.a b7 = annotationOwner.b(DEPRECATED_ANNOTATION);
            if (b7 != null || annotationOwner.s()) {
                return new h(b7, c6);
            }
        }
        kotlin.reflect.jvm.internal.impl.name.c cVar = f45389e.get(kotlinName);
        if (cVar == null || (b6 = annotationOwner.b(cVar)) == null) {
            return null;
        }
        return f(f45385a, b6, c6, false, 4, null);
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.f b() {
        return f45386b;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.f c() {
        return f45388d;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.f d() {
        return f45387c;
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c e(@NotNull y3.a annotation, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.k c6, boolean z5) {
        g0.p(annotation, "annotation");
        g0.p(c6, "c");
        kotlin.reflect.jvm.internal.impl.name.b c7 = annotation.c();
        b.a aVar = kotlin.reflect.jvm.internal.impl.name.b.f46334d;
        kotlin.reflect.jvm.internal.impl.name.c TARGET_ANNOTATION = i0.f45449d;
        g0.o(TARGET_ANNOTATION, "TARGET_ANNOTATION");
        if (g0.g(c7, aVar.c(TARGET_ANNOTATION))) {
            return new n(annotation, c6);
        }
        kotlin.reflect.jvm.internal.impl.name.c RETENTION_ANNOTATION = i0.f45451f;
        g0.o(RETENTION_ANNOTATION, "RETENTION_ANNOTATION");
        if (g0.g(c7, aVar.c(RETENTION_ANNOTATION))) {
            return new l(annotation, c6);
        }
        kotlin.reflect.jvm.internal.impl.name.c DOCUMENTED_ANNOTATION = i0.f45454i;
        g0.o(DOCUMENTED_ANNOTATION, "DOCUMENTED_ANNOTATION");
        if (g0.g(c7, aVar.c(DOCUMENTED_ANNOTATION))) {
            return new c(c6, annotation, o.a.P);
        }
        kotlin.reflect.jvm.internal.impl.name.c DEPRECATED_ANNOTATION = i0.f45453h;
        g0.o(DEPRECATED_ANNOTATION, "DEPRECATED_ANNOTATION");
        if (g0.g(c7, aVar.c(DEPRECATED_ANNOTATION))) {
            return null;
        }
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.j(c6, annotation, z5);
    }

    private d() {
    }
}
