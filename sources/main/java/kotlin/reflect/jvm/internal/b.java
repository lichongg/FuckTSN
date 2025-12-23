package kotlin.reflect.jvm.internal;

import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCacheByClass.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CacheByClass.kt\nkotlin/reflect/jvm/internal/CacheByClassKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,98:1\n1#2:99\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f44256a = false;

    static {
        Object m130constructorimpl;
        try {
            Result.a aVar = Result.Companion;
            m130constructorimpl = Result.m130constructorimpl(Class.forName("java.lang.ClassValue"));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m130constructorimpl = Result.m130constructorimpl(kotlin.g0.a(th));
        }
        if (Result.m137isSuccessimpl(m130constructorimpl)) {
            Result.a aVar3 = Result.Companion;
            m130constructorimpl = Boolean.TRUE;
        }
        Object m130constructorimpl2 = Result.m130constructorimpl(m130constructorimpl);
        Boolean bool = Boolean.FALSE;
        if (Result.m136isFailureimpl(m130constructorimpl2)) {
            m130constructorimpl2 = bool;
        }
        ((Boolean) m130constructorimpl2).getClass();
    }

    @NotNull
    public static final <V> a<V> a(@NotNull Function1<? super Class<?>, ? extends V> compute) {
        kotlin.jvm.internal.g0.p(compute, "compute");
        return new m(compute);
    }
}
