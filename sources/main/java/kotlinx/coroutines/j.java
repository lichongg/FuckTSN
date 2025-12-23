package kotlinx.coroutines;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/BuildersKt__BuildersKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,102:1\n1#2:103\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final /* synthetic */ class j {
    public static /* synthetic */ Object b(kotlin.coroutines.i iVar, Function2 function2, int i6, Object obj) throws InterruptedException {
        if ((i6 & 1) != 0) {
            iVar = EmptyCoroutineContext.INSTANCE;
        }
        return i.f(iVar, function2);
    }

    public static final <T> T a(@NotNull kotlin.coroutines.i iVar, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2) throws InterruptedException {
        n1 n1Var;
        n1 a6;
        kotlin.coroutines.i e6;
        Thread currentThread = Thread.currentThread();
        kotlin.coroutines.f fVar = (kotlin.coroutines.f) iVar.get(kotlin.coroutines.f.f43765o0);
        if (fVar == null) {
            a6 = g3.f49210a.b();
            e6 = l0.e(w1.f49676a, iVar.plus(a6));
        } else {
            n1 n1Var2 = null;
            if (fVar instanceof n1) {
                n1Var = (n1) fVar;
            } else {
                n1Var = null;
            }
            if (n1Var != null) {
                if (n1Var.O()) {
                    n1Var2 = n1Var;
                }
                if (n1Var2 != null) {
                    a6 = n1Var2;
                    e6 = l0.e(w1.f49676a, iVar);
                }
            }
            a6 = g3.f49210a.a();
            e6 = l0.e(w1.f49676a, iVar);
        }
        g gVar = new g(e6, currentThread, a6);
        gVar.z1(CoroutineStart.DEFAULT, gVar, function2);
        return (T) gVar.A1();
    }
}
