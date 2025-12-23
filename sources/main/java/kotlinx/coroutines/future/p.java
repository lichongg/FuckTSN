package kotlinx.coroutines.future;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.h2;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.x0;
import kotlinx.coroutines.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFuture.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Future.kt\nkotlinx/coroutines/future/FutureKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,197:1\n1#2:198\n314#3,11:199\n*S KotlinDebug\n*F\n+ 1 Future.kt\nkotlinx/coroutines/future/FutureKt\n*L\n172#1:199,11\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends Lambda implements Function1<Throwable, n1> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CompletableFuture<T> f49197a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ x0<T> f49198b;

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ n1 invoke(Throwable th) {
            invoke2(th);
            return n1.f44123a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(CompletableFuture<T> completableFuture, x0<? extends T> x0Var) {
            super(1);
            this.f49197a = completableFuture;
            this.f49198b = x0Var;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            try {
                this.f49197a.complete(this.f49198b.d());
            } catch (Throwable th2) {
                this.f49197a.completeExceptionally(th2);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b extends Lambda implements Function1<Throwable, n1> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CompletableFuture<n1> f49199a;

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ n1 invoke(Throwable th) {
            invoke2(th);
            return n1.f44123a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(CompletableFuture<n1> completableFuture) {
            super(1);
            this.f49199a = completableFuture;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            if (th == null) {
                this.f49199a.complete(n1.f44123a);
            } else {
                this.f49199a.completeExceptionally(th);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c<T> extends Lambda implements Function2<T, Throwable, Object> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ y<T> f49200a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(y<T> yVar) {
            super(2);
            this.f49200a = yVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
        
            r0 = r0.getCause();
         */
        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invoke(T r2, java.lang.Throwable r3) {
            /*
                r1 = this;
                if (r3 != 0) goto Lb
                kotlinx.coroutines.y<T> r3 = r1.f49200a     // Catch: java.lang.Throwable -> L9
                boolean r2 = r3.p(r2)     // Catch: java.lang.Throwable -> L9
                goto L27
            L9:
                r2 = move-exception
                goto L2c
            Lb:
                kotlinx.coroutines.y<T> r2 = r1.f49200a     // Catch: java.lang.Throwable -> L9
                boolean r0 = kotlinx.coroutines.future.d.a(r3)     // Catch: java.lang.Throwable -> L9
                if (r0 == 0) goto L18
                java.util.concurrent.CompletionException r0 = kotlinx.coroutines.future.e.a(r3)     // Catch: java.lang.Throwable -> L9
                goto L19
            L18:
                r0 = 0
            L19:
                if (r0 == 0) goto L23
                java.lang.Throwable r0 = kotlinx.coroutines.future.f.a(r0)     // Catch: java.lang.Throwable -> L9
                if (r0 != 0) goto L22
                goto L23
            L22:
                r3 = r0
            L23:
                boolean r2 = r2.c(r3)     // Catch: java.lang.Throwable -> L9
            L27:
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> L9
                return r2
            L2c:
                kotlin.coroutines.EmptyCoroutineContext r3 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
                kotlinx.coroutines.o0.b(r3, r2)
                kotlin.n1 r2 = kotlin.n1.f44123a
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.future.p.c.invoke(java.lang.Object, java.lang.Throwable):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class d extends Lambda implements Function1<Throwable, n1> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CompletableFuture<T> f49201a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g<T> f49202b;

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ n1 invoke(Throwable th) {
            invoke2(th);
            return n1.f44123a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(CompletableFuture<T> completableFuture, g<T> gVar) {
            super(1);
            this.f49201a = completableFuture;
            this.f49202b = gVar;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            this.f49201a.cancel(false);
            this.f49202b.cont = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 k(e2 e2Var, Object obj, Throwable th) {
        if (th != null) {
            r2 = th instanceof CancellationException ? (CancellationException) th : null;
            if (r2 == null) {
                r2 = s1.a("CompletableFuture was completed exceptionally", th);
            }
        }
        e2Var.b(r2);
        return n1.f44123a;
    }

    public static /* synthetic */ CompletableFuture i(r0 r0Var, kotlin.coroutines.i iVar, CoroutineStart coroutineStart, Function2 function2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            iVar = EmptyCoroutineContext.INSTANCE;
        }
        if ((i6 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return h(r0Var, iVar, coroutineStart, function2);
    }

    private static final void j(final e2 e2Var, CompletableFuture<?> completableFuture) {
        completableFuture.handle((BiFunction<? super Object, Throwable, ? extends U>) new BiFunction() { // from class: kotlinx.coroutines.future.o
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                n1 k6;
                k6 = p.k(e2.this, obj, (Throwable) obj2);
                return k6;
            }
        });
    }

    @NotNull
    public static final <T> CompletableFuture<T> c(@NotNull x0<? extends T> x0Var) {
        CompletableFuture<T> a6 = m.a();
        j(x0Var, a6);
        x0Var.k(new a(a6, x0Var));
        return a6;
    }

    @NotNull
    public static final CompletableFuture<n1> d(@NotNull e2 e2Var) {
        CompletableFuture<n1> a6 = m.a();
        j(e2Var, a6);
        e2Var.k(new b(a6));
        return a6;
    }

    @NotNull
    public static final <T> x0<T> e(@NotNull CompletionStage<T> completionStage) {
        CompletableFuture completableFuture;
        boolean isDone;
        ExecutionException executionException;
        Throwable cause;
        Object obj;
        completableFuture = completionStage.toCompletableFuture();
        isDone = completableFuture.isDone();
        if (isDone) {
            try {
                obj = completableFuture.get();
                return a0.a(obj);
            } catch (Throwable th) {
                th = th;
                if (th instanceof ExecutionException) {
                    executionException = (ExecutionException) th;
                } else {
                    executionException = null;
                }
                if (executionException != null && (cause = executionException.getCause()) != null) {
                    th = cause;
                }
                y c6 = a0.c(null, 1, null);
                c6.c(th);
                return c6;
            }
        }
        y c7 = a0.c(null, 1, null);
        final c cVar = new c(c7);
        completionStage.handle(new BiFunction() { // from class: kotlinx.coroutines.future.n
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj2, Object obj3) {
                Object f6;
                f6 = p.f(Function2.this, obj2, (Throwable) obj3);
                return f6;
            }
        });
        h2.x(c7, completableFuture);
        return c7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object f(Function2 function2, Object obj, Throwable th) {
        return function2.invoke(obj, th);
    }

    @Nullable
    public static final <T> Object g(@NotNull CompletionStage<T> completionStage, @NotNull kotlin.coroutines.e<? super T> eVar) {
        CompletableFuture completableFuture;
        boolean isDone;
        Object obj;
        completableFuture = completionStage.toCompletableFuture();
        isDone = completableFuture.isDone();
        if (isDone) {
            try {
                obj = completableFuture.get();
                return obj;
            } catch (ExecutionException e6) {
                Throwable cause = e6.getCause();
                if (cause == null) {
                    throw e6;
                }
                throw cause;
            }
        }
        kotlinx.coroutines.q qVar = new kotlinx.coroutines.q(kotlin.coroutines.intrinsics.a.e(eVar), 1);
        qVar.Q();
        g gVar = new g(qVar);
        completionStage.handle(io.netty.handler.ssl.p.a(gVar));
        qVar.I(new d(completableFuture, gVar));
        Object x5 = qVar.x();
        if (x5 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return x5;
    }

    @NotNull
    public static final <T> CompletableFuture<T> h(@NotNull r0 r0Var, @NotNull kotlin.coroutines.i iVar, @NotNull CoroutineStart coroutineStart, @NotNull Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2) {
        if (!coroutineStart.isLazy()) {
            kotlin.coroutines.i e6 = l0.e(r0Var, iVar);
            CompletableFuture<T> a6 = m.a();
            kotlinx.coroutines.future.c cVar = new kotlinx.coroutines.future.c(e6, a6);
            a6.handle(io.netty.handler.ssl.p.a(cVar));
            cVar.z1(coroutineStart, cVar, function2);
            return a6;
        }
        throw new IllegalArgumentException((coroutineStart + " start is not supported").toString());
    }
}
