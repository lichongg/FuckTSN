package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.coroutines.i;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface e2 extends i.b {

    /* renamed from: s0, reason: collision with root package name */
    @NotNull
    public static final b f48569s0 = b.f48570a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public static /* synthetic */ void b(e2 e2Var, CancellationException cancellationException, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i6 & 1) != 0) {
                cancellationException = null;
            }
            e2Var.b(cancellationException);
        }

        public static /* synthetic */ boolean c(e2 e2Var, Throwable th, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i6 & 1) != 0) {
                th = null;
            }
            return e2Var.a(th);
        }

        public static /* synthetic */ j1 g(e2 e2Var, boolean z5, boolean z6, Function1 function1, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i6 & 1) != 0) {
                z5 = false;
            }
            if ((i6 & 2) != 0) {
                z6 = true;
            }
            return e2Var.G(z5, z6, function1);
        }

        public static <R> R d(@NotNull e2 e2Var, R r5, @NotNull Function2<? super R, ? super i.b, ? extends R> function2) {
            return (R) i.b.a.a(e2Var, r5, function2);
        }

        @Nullable
        public static <E extends i.b> E e(@NotNull e2 e2Var, @NotNull i.c<E> cVar) {
            return (E) i.b.a.b(e2Var, cVar);
        }

        @NotNull
        public static kotlin.coroutines.i h(@NotNull e2 e2Var, @NotNull i.c<?> cVar) {
            return i.b.a.c(e2Var, cVar);
        }

        @NotNull
        public static kotlin.coroutines.i i(@NotNull e2 e2Var, @NotNull kotlin.coroutines.i iVar) {
            return i.b.a.d(e2Var, iVar);
        }

        @ExperimentalCoroutinesApi
        public static /* synthetic */ void f() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @NotNull
        public static e2 j(@NotNull e2 e2Var, @NotNull e2 e2Var2) {
            return e2Var2;
        }
    }

    @InternalCoroutinesApi
    @NotNull
    v A(@NotNull x xVar);

    @NotNull
    kotlin.sequences.m<e2> E();

    @InternalCoroutinesApi
    @NotNull
    j1 G(boolean z5, boolean z6, @NotNull Function1<? super Throwable, kotlin.n1> function1);

    @InternalCoroutinesApi
    @NotNull
    CancellationException H();

    @Nullable
    Object M(@NotNull kotlin.coroutines.e<? super kotlin.n1> eVar);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean a(Throwable th);

    void b(@Nullable CancellationException cancellationException);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    @Nullable
    e2 getParent();

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @NotNull
    e2 j(@NotNull e2 e2Var);

    @NotNull
    j1 k(@NotNull Function1<? super Throwable, kotlin.n1> function1);

    boolean start();

    @NotNull
    kotlinx.coroutines.selects.e y();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements i.c<e2> {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f48570a = new b();

        private b() {
        }
    }
}
