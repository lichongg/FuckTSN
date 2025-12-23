package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@PublishedApi
@SourceDebugExtension({"SMAP\nDispatchedTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTask\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 6 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,222:1\n1#2:223\n107#3,10:224\n118#3,2:238\n220#4:234\n221#4:237\n61#5,2:235\n75#6:240\n*S KotlinDebug\n*F\n+ 1 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTask\n*L\n90#1:224,10\n90#1:238,2\n103#1:234\n103#1:237\n103#1:235,2\n142#1:240\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class d1<T> extends kotlinx.coroutines.scheduling.j {

    /* renamed from: c, reason: collision with root package name */
    @JvmField
    public int f48477c;

    @NotNull
    public abstract kotlin.coroutines.e<T> e();

    @Nullable
    public abstract Object j();

    @Nullable
    public Throwable f(@Nullable Object obj) {
        d0 d0Var = obj instanceof d0 ? (d0) obj : null;
        if (d0Var != null) {
            return d0Var.f48476a;
        }
        return null;
    }

    public final void i(@Nullable Throwable th, @Nullable Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            kotlin.l.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        kotlin.jvm.internal.g0.m(th);
        o0.b(e().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object m130constructorimpl;
        Object m130constructorimpl2;
        kotlinx.coroutines.scheduling.k kVar = this.f49504b;
        try {
            kotlin.coroutines.e<T> e6 = e();
            kotlin.jvm.internal.g0.n(e6, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            kotlinx.coroutines.internal.l lVar = (kotlinx.coroutines.internal.l) e6;
            kotlin.coroutines.e<T> eVar = lVar.f49278e;
            Object obj = lVar.f49280g;
            kotlin.coroutines.i context = eVar.getContext();
            Object c6 = kotlinx.coroutines.internal.y0.c(context, obj);
            p3<?> g6 = c6 != kotlinx.coroutines.internal.y0.f49325a ? l0.g(eVar, context, c6) : null;
            try {
                kotlin.coroutines.i context2 = eVar.getContext();
                Object j6 = j();
                Throwable f6 = f(j6);
                e2 e2Var = (f6 == null && e1.c(this.f48477c)) ? (e2) context2.get(e2.f48569s0) : null;
                if (e2Var != null && !e2Var.isActive()) {
                    CancellationException H = e2Var.H();
                    d(j6, H);
                    Result.a aVar = Result.Companion;
                    eVar.resumeWith(Result.m130constructorimpl(kotlin.g0.a(H)));
                } else if (f6 != null) {
                    Result.a aVar2 = Result.Companion;
                    eVar.resumeWith(Result.m130constructorimpl(kotlin.g0.a(f6)));
                } else {
                    Result.a aVar3 = Result.Companion;
                    eVar.resumeWith(Result.m130constructorimpl(g(j6)));
                }
                kotlin.n1 n1Var = kotlin.n1.f44123a;
                if (g6 == null || g6.A1()) {
                    kotlinx.coroutines.internal.y0.a(context, c6);
                }
                try {
                    Result.a aVar4 = Result.Companion;
                    kVar.o();
                    m130constructorimpl2 = Result.m130constructorimpl(n1Var);
                } catch (Throwable th) {
                    Result.a aVar5 = Result.Companion;
                    m130constructorimpl2 = Result.m130constructorimpl(kotlin.g0.a(th));
                }
                i(null, Result.m133exceptionOrNullimpl(m130constructorimpl2));
            } catch (Throwable th2) {
                if (g6 == null || g6.A1()) {
                    kotlinx.coroutines.internal.y0.a(context, c6);
                }
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                Result.a aVar6 = Result.Companion;
                kVar.o();
                m130constructorimpl = Result.m130constructorimpl(kotlin.n1.f44123a);
            } catch (Throwable th4) {
                Result.a aVar7 = Result.Companion;
                m130constructorimpl = Result.m130constructorimpl(kotlin.g0.a(th4));
            }
            i(th3, Result.m133exceptionOrNullimpl(m130constructorimpl));
        }
    }

    public d1(int i6) {
        this.f48477c = i6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T g(@Nullable Object obj) {
        return obj;
    }

    public void d(@Nullable Object obj, @NotNull Throwable th) {
    }
}
