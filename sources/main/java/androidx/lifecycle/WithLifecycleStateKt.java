package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.p2;
import kotlinx.coroutines.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nWithLifecycleState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WithLifecycleState.kt\nandroidx/lifecycle/WithLifecycleStateKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,206:1\n154#1,8:207\n154#1,8:215\n154#1,8:223\n154#1,8:231\n43#1,5:239\n154#1,8:244\n43#1,5:252\n154#1,8:257\n154#1,8:265\n154#1,8:273\n154#1,8:281\n314#2,11:289\n*S KotlinDebug\n*F\n+ 1 WithLifecycleState.kt\nandroidx/lifecycle/WithLifecycleStateKt\n*L\n47#1:207,8\n58#1:215,8\n71#1:223,8\n84#1:231,8\n98#1:239,5\n98#1:244,8\n98#1:252,5\n98#1:257,8\n111#1:265,8\n124#1:273,8\n137#1:281,8\n177#1:289,11\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class WithLifecycleStateKt {
    @Nullable
    public static final <R> Object withCreated(@NotNull Lifecycle lifecycle, @NotNull Function0<? extends R> function0, @NotNull kotlin.coroutines.e<? super R> eVar) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        p2 v5 = g1.e().v();
        boolean isDispatchNeeded = v5.isDispatchNeeded(eVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, v5, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), eVar);
    }

    private static final <R> Object withCreated$$forInline(Lifecycle lifecycle, Function0<? extends R> function0, kotlin.coroutines.e<? super R> eVar) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        g1.e().v();
        d0.e(3);
        throw null;
    }

    @Nullable
    public static final <R> Object withResumed(@NotNull Lifecycle lifecycle, @NotNull Function0<? extends R> function0, @NotNull kotlin.coroutines.e<? super R> eVar) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        p2 v5 = g1.e().v();
        boolean isDispatchNeeded = v5.isDispatchNeeded(eVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, v5, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), eVar);
    }

    private static final <R> Object withResumed$$forInline(Lifecycle lifecycle, Function0<? extends R> function0, kotlin.coroutines.e<? super R> eVar) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        g1.e().v();
        d0.e(3);
        throw null;
    }

    @Nullable
    public static final <R> Object withStarted(@NotNull Lifecycle lifecycle, @NotNull Function0<? extends R> function0, @NotNull kotlin.coroutines.e<? super R> eVar) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        p2 v5 = g1.e().v();
        boolean isDispatchNeeded = v5.isDispatchNeeded(eVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, v5, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), eVar);
    }

    private static final <R> Object withStarted$$forInline(Lifecycle lifecycle, Function0<? extends R> function0, kotlin.coroutines.e<? super R> eVar) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        g1.e().v();
        d0.e(3);
        throw null;
    }

    @Nullable
    public static final <R> Object withStateAtLeast(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, @NotNull Function0<? extends R> function0, @NotNull kotlin.coroutines.e<? super R> eVar) {
        if (state.compareTo(Lifecycle.State.CREATED) < 0) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        p2 v5 = g1.e().v();
        boolean isDispatchNeeded = v5.isDispatchNeeded(eVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, v5, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), eVar);
    }

    private static final <R> Object withStateAtLeast$$forInline(Lifecycle lifecycle, Lifecycle.State state, Function0<? extends R> function0, kotlin.coroutines.e<? super R> eVar) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            g1.e().v();
            d0.e(3);
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.lifecycle.LifecycleObserver, androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1] */
    @PublishedApi
    @Nullable
    public static final <R> Object suspendWithStateAtLeastUnchecked(@NotNull final Lifecycle lifecycle, @NotNull final Lifecycle.State state, boolean z5, @NotNull final m0 m0Var, @NotNull final Function0<? extends R> function0, @NotNull kotlin.coroutines.e<? super R> eVar) {
        final q qVar = new q(kotlin.coroutines.intrinsics.a.e(eVar), 1);
        qVar.Q();
        final ?? r12 = new LifecycleEventObserver() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                Object m130constructorimpl;
                g0.p(source, "source");
                g0.p(event, "event");
                if (event != Lifecycle.Event.Companion.upTo(Lifecycle.State.this)) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        lifecycle.removeObserver(this);
                        kotlin.coroutines.e eVar2 = qVar;
                        Result.a aVar = Result.Companion;
                        eVar2.resumeWith(Result.m130constructorimpl(kotlin.g0.a(new LifecycleDestroyedException())));
                        return;
                    }
                    return;
                }
                lifecycle.removeObserver(this);
                kotlin.coroutines.e eVar3 = qVar;
                Function0<R> function02 = function0;
                try {
                    Result.a aVar2 = Result.Companion;
                    m130constructorimpl = Result.m130constructorimpl(function02.invoke());
                } catch (Throwable th) {
                    Result.a aVar3 = Result.Companion;
                    m130constructorimpl = Result.m130constructorimpl(kotlin.g0.a(th));
                }
                eVar3.resumeWith(m130constructorimpl);
            }
        };
        if (z5) {
            m0Var.dispatch(EmptyCoroutineContext.INSTANCE, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1
                @Override // java.lang.Runnable
                public final void run() {
                    Lifecycle.this.addObserver(r12);
                }
            });
        } else {
            lifecycle.addObserver(r12);
        }
        qVar.I(new Function1<Throwable, n1>() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ n1 invoke(Throwable th) {
                invoke2(th);
                return n1.f44123a;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th) {
                m0 m0Var2 = m0.this;
                EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
                if (!m0Var2.isDispatchNeeded(emptyCoroutineContext)) {
                    lifecycle.removeObserver(r12);
                    return;
                }
                m0 m0Var3 = m0.this;
                final Lifecycle lifecycle2 = lifecycle;
                final WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 = r12;
                m0Var3.dispatch(emptyCoroutineContext, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Lifecycle.this.removeObserver(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1);
                    }
                });
            }
        });
        Object x5 = qVar.x();
        if (x5 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        return x5;
    }

    @PublishedApi
    @Nullable
    public static final <R> Object withStateAtLeastUnchecked(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, @NotNull Function0<? extends R> function0, @NotNull kotlin.coroutines.e<? super R> eVar) {
        p2 v5 = g1.e().v();
        boolean isDispatchNeeded = v5.isDispatchNeeded(eVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return function0.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, v5, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), eVar);
    }

    @PublishedApi
    private static final <R> Object withStateAtLeastUnchecked$$forInline(Lifecycle lifecycle, Lifecycle.State state, Function0<? extends R> function0, kotlin.coroutines.e<? super R> eVar) {
        g1.e().v();
        d0.e(3);
        throw null;
    }

    private static final <R> Object withCreated$$forInline(LifecycleOwner lifecycleOwner, Function0<? extends R> function0, kotlin.coroutines.e<? super R> eVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.CREATED;
        g1.e().v();
        d0.e(3);
        throw null;
    }

    private static final <R> Object withResumed$$forInline(LifecycleOwner lifecycleOwner, Function0<? extends R> function0, kotlin.coroutines.e<? super R> eVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.RESUMED;
        g1.e().v();
        d0.e(3);
        throw null;
    }

    private static final <R> Object withStarted$$forInline(LifecycleOwner lifecycleOwner, Function0<? extends R> function0, kotlin.coroutines.e<? super R> eVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.STARTED;
        g1.e().v();
        d0.e(3);
        throw null;
    }

    private static final <R> Object withStateAtLeast$$forInline(LifecycleOwner lifecycleOwner, Lifecycle.State state, Function0<? extends R> function0, kotlin.coroutines.e<? super R> eVar) {
        lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            g1.e().v();
            d0.e(3);
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    @Nullable
    public static final <R> Object withCreated(@NotNull LifecycleOwner lifecycleOwner, @NotNull Function0<? extends R> function0, @NotNull kotlin.coroutines.e<? super R> eVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.CREATED;
        p2 v5 = g1.e().v();
        boolean isDispatchNeeded = v5.isDispatchNeeded(eVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return function0.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, v5, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), eVar);
    }

    @Nullable
    public static final <R> Object withResumed(@NotNull LifecycleOwner lifecycleOwner, @NotNull Function0<? extends R> function0, @NotNull kotlin.coroutines.e<? super R> eVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.RESUMED;
        p2 v5 = g1.e().v();
        boolean isDispatchNeeded = v5.isDispatchNeeded(eVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return function0.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, v5, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), eVar);
    }

    @Nullable
    public static final <R> Object withStarted(@NotNull LifecycleOwner lifecycleOwner, @NotNull Function0<? extends R> function0, @NotNull kotlin.coroutines.e<? super R> eVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.STARTED;
        p2 v5 = g1.e().v();
        boolean isDispatchNeeded = v5.isDispatchNeeded(eVar.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return function0.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, v5, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), eVar);
    }

    @Nullable
    public static final <R> Object withStateAtLeast(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.State state, @NotNull Function0<? extends R> function0, @NotNull kotlin.coroutines.e<? super R> eVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            p2 v5 = g1.e().v();
            boolean isDispatchNeeded = v5.isDispatchNeeded(eVar.getContext());
            if (!isDispatchNeeded) {
                if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                    if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                        return function0.invoke();
                    }
                } else {
                    throw new LifecycleDestroyedException();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, v5, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), eVar);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }
}
