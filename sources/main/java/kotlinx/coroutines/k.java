package kotlinx.coroutines;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.f;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nBuilders.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.common.kt\nkotlinx/coroutines/BuildersKt__Builders_commonKt\n+ 2 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,273:1\n95#2,5:274\n*S KotlinDebug\n*F\n+ 1 Builders.common.kt\nkotlinx/coroutines/BuildersKt__Builders_commonKt\n*L\n166#1:274,5\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final /* synthetic */ class k {

    /* renamed from: a, reason: collision with root package name */
    private static final int f49339a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static final int f49340b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static final int f49341c = 2;

    private static final <T> Object d(m0 m0Var, Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2, kotlin.coroutines.e<? super T> eVar) {
        kotlin.jvm.internal.d0.e(0);
        Object h6 = i.h(m0Var, function2, eVar);
        kotlin.jvm.internal.d0.e(1);
        return h6;
    }

    public static /* synthetic */ x0 b(r0 r0Var, kotlin.coroutines.i iVar, CoroutineStart coroutineStart, Function2 function2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            iVar = EmptyCoroutineContext.INSTANCE;
        }
        if ((i6 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return i.a(r0Var, iVar, coroutineStart, function2);
    }

    public static /* synthetic */ e2 f(r0 r0Var, kotlin.coroutines.i iVar, CoroutineStart coroutineStart, Function2 function2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            iVar = EmptyCoroutineContext.INSTANCE;
        }
        if ((i6 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return i.d(r0Var, iVar, coroutineStart, function2);
    }

    @NotNull
    public static final <T> x0<T> a(@NotNull r0 r0Var, @NotNull kotlin.coroutines.i iVar, @NotNull CoroutineStart coroutineStart, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2) {
        y0 y0Var;
        kotlin.coroutines.i e6 = l0.e(r0Var, iVar);
        if (coroutineStart.isLazy()) {
            y0Var = new n2(e6, function2);
        } else {
            y0Var = new y0(e6, true);
        }
        ((a) y0Var).z1(coroutineStart, y0Var, function2);
        return (x0<T>) y0Var;
    }

    @Nullable
    public static final <T> Object c(@NotNull m0 m0Var, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super T> eVar) {
        return i.h(m0Var, function2, eVar);
    }

    @NotNull
    public static final e2 e(@NotNull r0 r0Var, @NotNull kotlin.coroutines.i iVar, @NotNull CoroutineStart coroutineStart, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super kotlin.n1>, ? extends Object> function2) {
        a a3Var;
        kotlin.coroutines.i e6 = l0.e(r0Var, iVar);
        if (coroutineStart.isLazy()) {
            a3Var = new o2(e6, function2);
        } else {
            a3Var = new a3(e6, true);
        }
        a3Var.z1(coroutineStart, a3Var, function2);
        return a3Var;
    }

    @Nullable
    public static final <T> Object g(@NotNull kotlin.coroutines.i iVar, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2, @NotNull kotlin.coroutines.e<? super T> eVar) {
        Object A1;
        kotlin.coroutines.i context = eVar.getContext();
        kotlin.coroutines.i d6 = l0.d(context, iVar);
        h2.z(d6);
        if (d6 == context) {
            kotlinx.coroutines.internal.o0 o0Var = new kotlinx.coroutines.internal.o0(d6, eVar);
            A1 = o4.b.e(o0Var, o0Var, function2);
        } else {
            f.b bVar = kotlin.coroutines.f.f43765o0;
            if (kotlin.jvm.internal.g0.g(d6.get(bVar), context.get(bVar))) {
                p3 p3Var = new p3(d6, eVar);
                kotlin.coroutines.i context2 = p3Var.getContext();
                Object c6 = kotlinx.coroutines.internal.y0.c(context2, null);
                try {
                    Object e6 = o4.b.e(p3Var, p3Var, function2);
                    kotlinx.coroutines.internal.y0.a(context2, c6);
                    A1 = e6;
                } catch (Throwable th) {
                    kotlinx.coroutines.internal.y0.a(context2, c6);
                    throw th;
                }
            } else {
                c1 c1Var = new c1(d6, eVar);
                o4.a.f(function2, c1Var, c1Var, null, 4, null);
                A1 = c1Var.A1();
            }
        }
        if (A1 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return A1;
    }
}
