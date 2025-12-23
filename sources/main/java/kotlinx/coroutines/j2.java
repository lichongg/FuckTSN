package kotlinx.coroutines;

import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.coroutines.i;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJob.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Job.kt\nkotlinx/coroutines/JobKt__JobKt\n+ 2 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,685:1\n13#2:686\n1295#3,2:687\n1295#3,2:689\n1295#3,2:691\n1295#3,2:693\n*S KotlinDebug\n*F\n+ 1 Job.kt\nkotlinx/coroutines/JobKt__JobKt\n*L\n494#1:686\n521#1:687,2\n535#1:689,2\n629#1:691,2\n653#1:693,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final /* synthetic */ class j2 {
    @Nullable
    public static final Object l(@NotNull e2 e2Var, @NotNull kotlin.coroutines.e<? super kotlin.n1> eVar) {
        e2.a.b(e2Var, null, 1, null);
        Object M = e2Var.M(eVar);
        return M == kotlin.coroutines.intrinsics.a.l() ? M : kotlin.n1.f44123a;
    }

    public static final boolean A(@NotNull kotlin.coroutines.i iVar) {
        e2 e2Var = (e2) iVar.get(e2.f48569s0);
        if (e2Var != null) {
            return e2Var.isActive();
        }
        return true;
    }

    private static final Throwable B(Throwable th, e2 e2Var) {
        return th == null ? new JobCancellationException("Job was cancelled", null, e2Var) : th;
    }

    @NotNull
    public static final b0 a(@Nullable e2 e2Var) {
        return new g2(e2Var);
    }

    public static /* synthetic */ b0 c(e2 e2Var, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            e2Var = null;
        }
        return h2.a(e2Var);
    }

    public static /* synthetic */ e2 d(e2 e2Var, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            e2Var = null;
        }
        return b(e2Var);
    }

    public static final void f(@NotNull kotlin.coroutines.i iVar, @Nullable CancellationException cancellationException) {
        e2 e2Var = (e2) iVar.get(e2.f48569s0);
        if (e2Var != null) {
            e2Var.b(cancellationException);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ boolean h(kotlin.coroutines.i iVar, Throwable th) {
        i.b bVar = iVar.get(e2.f48569s0);
        l2 l2Var = bVar instanceof l2 ? (l2) bVar : null;
        if (l2Var == null) {
            return false;
        }
        l2Var.j0(B(th, l2Var));
        return true;
    }

    public static /* synthetic */ void i(kotlin.coroutines.i iVar, CancellationException cancellationException, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            cancellationException = null;
        }
        h2.f(iVar, cancellationException);
    }

    public static /* synthetic */ void j(e2 e2Var, String str, Throwable th, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            th = null;
        }
        h2.g(e2Var, str, th);
    }

    public static /* synthetic */ boolean k(kotlin.coroutines.i iVar, Throwable th, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            th = null;
        }
        return h(iVar, th);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void n(kotlin.coroutines.i iVar, Throwable th) {
        e2 e2Var = (e2) iVar.get(e2.f48569s0);
        if (e2Var == null) {
            return;
        }
        for (e2 e2Var2 : e2Var.E()) {
            l2 l2Var = e2Var2 instanceof l2 ? (l2) e2Var2 : null;
            if (l2Var != null) {
                l2Var.j0(B(th, e2Var));
            }
        }
    }

    public static final void o(@NotNull kotlin.coroutines.i iVar, @Nullable CancellationException cancellationException) {
        kotlin.sequences.m<e2> E;
        e2 e2Var = (e2) iVar.get(e2.f48569s0);
        if (e2Var == null || (E = e2Var.E()) == null) {
            return;
        }
        Iterator<e2> it = E.iterator();
        while (it.hasNext()) {
            it.next().b(cancellationException);
        }
    }

    public static /* synthetic */ void s(kotlin.coroutines.i iVar, Throwable th, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            th = null;
        }
        n(iVar, th);
    }

    public static /* synthetic */ void t(kotlin.coroutines.i iVar, CancellationException cancellationException, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            cancellationException = null;
        }
        h2.o(iVar, cancellationException);
    }

    public static /* synthetic */ void u(e2 e2Var, Throwable th, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            th = null;
        }
        q(e2Var, th);
    }

    public static /* synthetic */ void v(e2 e2Var, CancellationException cancellationException, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            cancellationException = null;
        }
        h2.r(e2Var, cancellationException);
    }

    @NotNull
    public static final j1 w(@NotNull e2 e2Var, @NotNull j1 j1Var) {
        return e2Var.k(new l1(j1Var));
    }

    public static final void x(@NotNull kotlin.coroutines.i iVar) {
        e2 e2Var = (e2) iVar.get(e2.f48569s0);
        if (e2Var != null) {
            h2.A(e2Var);
        }
    }

    @NotNull
    public static final e2 z(@NotNull kotlin.coroutines.i iVar) {
        e2 e2Var = (e2) iVar.get(e2.f48569s0);
        if (e2Var != null) {
            return e2Var;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + iVar).toString());
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    @JvmName(name = "Job")
    public static final /* synthetic */ e2 b(e2 e2Var) {
        return h2.a(e2Var);
    }

    public static final void g(@NotNull e2 e2Var, @NotNull String str, @Nullable Throwable th) {
        e2Var.b(s1.a(str, th));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void q(e2 e2Var, Throwable th) {
        l2 l2Var;
        for (e2 e2Var2 : e2Var.E()) {
            if (e2Var2 instanceof l2) {
                l2Var = (l2) e2Var2;
            } else {
                l2Var = null;
            }
            if (l2Var != null) {
                l2Var.j0(B(th, e2Var));
            }
        }
    }

    public static final void r(@NotNull e2 e2Var, @Nullable CancellationException cancellationException) {
        Iterator<e2> it = e2Var.E().iterator();
        while (it.hasNext()) {
            it.next().b(cancellationException);
        }
    }

    public static final void y(@NotNull e2 e2Var) {
        if (e2Var.isActive()) {
        } else {
            throw e2Var.H();
        }
    }
}
