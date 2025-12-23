package kotlin.reflect.jvm.internal;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\ncaches.kt\nKotlin\n*S Kotlin\n*F\n+ 1 caches.kt\nkotlin/reflect/jvm/internal/CachesKt\n+ 2 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,74:1\n72#2,2:75\n1#3:77\n*S KotlinDebug\n*F\n+ 1 caches.kt\nkotlin/reflect/jvm/internal/CachesKt\n*L\n68#1:75,2\n68#1:77\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final a<h0<? extends Object>> f44356a = b.a(c.f44266a);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final a<a2> f44357b = b.a(d.f44323a);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final a<kotlin.reflect.r> f44358c = b.a(e.f44333a);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final a<kotlin.reflect.r> f44359d = b.a(f.f44343a);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final a<ConcurrentHashMap<Pair<List<kotlin.reflect.t>, Boolean>, kotlin.reflect.r>> f44360e = b.a(g.f44350a);

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.r a(Class it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return kotlin.reflect.full.i.b(n(it), kotlin.collections.f0.J(), false, kotlin.collections.f0.J());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConcurrentHashMap b(Class it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.r c(Class it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return kotlin.reflect.full.i.b(n(it), kotlin.collections.f0.J(), true, kotlin.collections.f0.J());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h0 d(Class it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return new h0(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a2 e(Class it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return new a2(it);
    }

    public static final void k() {
        f44356a.a();
        f44357b.a();
        f44358c.a();
        f44359d.a();
        f44360e.a();
    }

    @NotNull
    public static final <T> kotlin.reflect.r l(@NotNull Class<T> jClass, @NotNull List<kotlin.reflect.t> arguments, boolean z5) {
        kotlin.jvm.internal.g0.p(jClass, "jClass");
        kotlin.jvm.internal.g0.p(arguments, "arguments");
        return arguments.isEmpty() ? z5 ? f44359d.b(jClass) : f44358c.b(jClass) : m(jClass, arguments, z5);
    }

    private static final <T> kotlin.reflect.r m(Class<T> cls, List<kotlin.reflect.t> list, boolean z5) {
        ConcurrentHashMap<Pair<List<kotlin.reflect.t>, Boolean>, kotlin.reflect.r> b6 = f44360e.b(cls);
        Pair<List<kotlin.reflect.t>, Boolean> a6 = kotlin.o0.a(list, Boolean.valueOf(z5));
        kotlin.reflect.r rVar = b6.get(a6);
        if (rVar == null) {
            kotlin.reflect.r b7 = kotlin.reflect.full.i.b(n(cls), list, z5, kotlin.collections.f0.J());
            kotlin.reflect.r putIfAbsent = b6.putIfAbsent(a6, b7);
            rVar = putIfAbsent == null ? b7 : putIfAbsent;
        }
        kotlin.jvm.internal.g0.o(rVar, "getOrPut(...)");
        return rVar;
    }

    @NotNull
    public static final <T> h0<T> n(@NotNull Class<T> jClass) {
        kotlin.jvm.internal.g0.p(jClass, "jClass");
        kotlin.reflect.h b6 = f44356a.b(jClass);
        kotlin.jvm.internal.g0.n(b6, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<T of kotlin.reflect.jvm.internal.CachesKt.getOrCreateKotlinClass>");
        return (h0) b6;
    }

    @NotNull
    public static final <T> kotlin.reflect.h o(@NotNull Class<T> jClass) {
        kotlin.jvm.internal.g0.p(jClass, "jClass");
        return f44357b.b(jClass);
    }
}
