package kotlin.coroutines.intrinsics;

import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.e;
import kotlin.coroutines.i;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.u0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nIntrinsicsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntrinsicsJvm.kt\nkotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt\n*L\n1#1,269:1\n204#1,4:270\n225#1:274\n204#1,4:275\n225#1:279\n*S KotlinDebug\n*F\n+ 1 IntrinsicsJvm.kt\nkotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt\n*L\n130#1:270,4\n130#1:274\n165#1:275,4\n165#1:279\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class IntrinsicsKt__IntrinsicsJvmKt {
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @NotNull
    public static <T> e<n1> b(@NotNull final Function1<? super e<? super T>, ? extends Object> function1, @NotNull e<? super T> completion) {
        g0.p(function1, "<this>");
        g0.p(completion, "completion");
        final e<?> a6 = kotlin.coroutines.jvm.internal.e.a(completion);
        if (function1 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function1).create(a6);
        }
        final i context = a6.getContext();
        return context == EmptyCoroutineContext.INSTANCE ? new RestrictedContinuationImpl(a6, function1) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1
            final /* synthetic */ Function1 $this_createCoroutineUnintercepted$inlined;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(a6);
                this.$this_createCoroutineUnintercepted$inlined = function1;
                g0.n(a6, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object obj) {
                int i6 = this.label;
                if (i6 == 0) {
                    this.label = 1;
                    kotlin.g0.n(obj);
                    g0.n(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                    return ((Function1) u0.q(this.$this_createCoroutineUnintercepted$inlined, 1)).invoke(this);
                }
                if (i6 != 1) {
                    throw new IllegalStateException("This coroutine had already completed");
                }
                this.label = 2;
                kotlin.g0.n(obj);
                return obj;
            }
        } : new ContinuationImpl(a6, context, function1) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2
            final /* synthetic */ Function1 $this_createCoroutineUnintercepted$inlined;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(a6, context);
                this.$this_createCoroutineUnintercepted$inlined = function1;
                g0.n(a6, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object obj) {
                int i6 = this.label;
                if (i6 == 0) {
                    this.label = 1;
                    kotlin.g0.n(obj);
                    g0.n(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                    return ((Function1) u0.q(this.$this_createCoroutineUnintercepted$inlined, 1)).invoke(this);
                }
                if (i6 != 1) {
                    throw new IllegalStateException("This coroutine had already completed");
                }
                this.label = 2;
                kotlin.g0.n(obj);
                return obj;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @NotNull
    public static <R, T> e<n1> c(@NotNull final Function2<? super R, ? super e<? super T>, ? extends Object> function2, final R r5, @NotNull e<? super T> completion) {
        g0.p(function2, "<this>");
        g0.p(completion, "completion");
        final e<?> a6 = kotlin.coroutines.jvm.internal.e.a(completion);
        if (function2 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function2).create(r5, a6);
        }
        final i context = a6.getContext();
        return context == EmptyCoroutineContext.INSTANCE ? new RestrictedContinuationImpl(a6, function2, r5) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
            final /* synthetic */ Object $receiver$inlined;
            final /* synthetic */ Function2 $this_createCoroutineUnintercepted$inlined;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(a6);
                this.$this_createCoroutineUnintercepted$inlined = function2;
                this.$receiver$inlined = r5;
                g0.n(a6, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object obj) {
                int i6 = this.label;
                if (i6 == 0) {
                    this.label = 1;
                    kotlin.g0.n(obj);
                    g0.n(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                    return ((Function2) u0.q(this.$this_createCoroutineUnintercepted$inlined, 2)).invoke(this.$receiver$inlined, this);
                }
                if (i6 != 1) {
                    throw new IllegalStateException("This coroutine had already completed");
                }
                this.label = 2;
                kotlin.g0.n(obj);
                return obj;
            }
        } : new ContinuationImpl(a6, context, function2, r5) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
            final /* synthetic */ Object $receiver$inlined;
            final /* synthetic */ Function2 $this_createCoroutineUnintercepted$inlined;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(a6, context);
                this.$this_createCoroutineUnintercepted$inlined = function2;
                this.$receiver$inlined = r5;
                g0.n(a6, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object obj) {
                int i6 = this.label;
                if (i6 == 0) {
                    this.label = 1;
                    kotlin.g0.n(obj);
                    g0.n(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                    return ((Function2) u0.q(this.$this_createCoroutineUnintercepted$inlined, 2)).invoke(this.$receiver$inlined, this);
                }
                if (i6 != 1) {
                    throw new IllegalStateException("This coroutine had already completed");
                }
                this.label = 2;
                kotlin.g0.n(obj);
                return obj;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @NotNull
    public static <T> e<T> e(@NotNull e<? super T> eVar) {
        e<T> eVar2;
        g0.p(eVar, "<this>");
        ContinuationImpl continuationImpl = eVar instanceof ContinuationImpl ? (ContinuationImpl) eVar : null;
        return (continuationImpl == null || (eVar2 = (e<T>) continuationImpl.intercepted()) == null) ? eVar : eVar2;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object f(Function1<? super e<? super T>, ? extends Object> function1, e<? super T> completion) {
        g0.p(function1, "<this>");
        g0.p(completion, "completion");
        return !(function1 instanceof BaseContinuationImpl) ? i(function1, completion) : ((Function1) u0.q(function1, 1)).invoke(completion);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <R, T> Object g(Function2<? super R, ? super e<? super T>, ? extends Object> function2, R r5, e<? super T> completion) {
        g0.p(function2, "<this>");
        g0.p(completion, "completion");
        return !(function2 instanceof BaseContinuationImpl) ? j(function2, r5, completion) : ((Function2) u0.q(function2, 2)).invoke(r5, completion);
    }

    @InlineOnly
    private static final <R, P, T> Object h(Function3<? super R, ? super P, ? super e<? super T>, ? extends Object> function3, R r5, P p5, e<? super T> completion) {
        g0.p(function3, "<this>");
        g0.p(completion, "completion");
        return !(function3 instanceof BaseContinuationImpl) ? k(function3, r5, p5, completion) : ((Function3) u0.q(function3, 3)).invoke(r5, p5, completion);
    }

    @PublishedApi
    @Nullable
    public static final <T> Object i(@NotNull Function1<? super e<? super T>, ? extends Object> function1, @NotNull e<? super T> completion) {
        g0.p(function1, "<this>");
        g0.p(completion, "completion");
        return ((Function1) u0.q(function1, 1)).invoke(d(kotlin.coroutines.jvm.internal.e.a(completion)));
    }

    @PublishedApi
    @Nullable
    public static final <R, T> Object j(@NotNull Function2<? super R, ? super e<? super T>, ? extends Object> function2, R r5, @NotNull e<? super T> completion) {
        g0.p(function2, "<this>");
        g0.p(completion, "completion");
        return ((Function2) u0.q(function2, 2)).invoke(r5, d(kotlin.coroutines.jvm.internal.e.a(completion)));
    }

    @PublishedApi
    @Nullable
    public static <R, P, T> Object k(@NotNull Function3<? super R, ? super P, ? super e<? super T>, ? extends Object> function3, R r5, P p5, @NotNull e<? super T> completion) {
        g0.p(function3, "<this>");
        g0.p(completion, "completion");
        return ((Function3) u0.q(function3, 3)).invoke(r5, p5, d(kotlin.coroutines.jvm.internal.e.a(completion)));
    }

    @SinceKotlin(version = "1.3")
    private static final <T> e<n1> a(final e<? super T> eVar, final Function1<? super e<? super T>, ? extends Object> function1) {
        final i context = eVar.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new RestrictedContinuationImpl(eVar, function1) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1
                final /* synthetic */ Function1<e<? super T>, Object> $block;
                private int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(eVar);
                    this.$block = function1;
                    g0.n(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                protected Object invokeSuspend(Object obj) {
                    int i6 = this.label;
                    if (i6 == 0) {
                        this.label = 1;
                        kotlin.g0.n(obj);
                        return this.$block.invoke(this);
                    }
                    if (i6 != 1) {
                        throw new IllegalStateException("This coroutine had already completed");
                    }
                    this.label = 2;
                    kotlin.g0.n(obj);
                    return obj;
                }
            };
        }
        return new ContinuationImpl(eVar, context, function1) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2
            final /* synthetic */ Function1<e<? super T>, Object> $block;
            private int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(eVar, context);
                this.$block = function1;
                g0.n(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object obj) {
                int i6 = this.label;
                if (i6 == 0) {
                    this.label = 1;
                    kotlin.g0.n(obj);
                    return this.$block.invoke(this);
                }
                if (i6 != 1) {
                    throw new IllegalStateException("This coroutine had already completed");
                }
                this.label = 2;
                kotlin.g0.n(obj);
                return obj;
            }
        };
    }

    private static final <T> e<T> d(final e<? super T> eVar) {
        final i context = eVar.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new RestrictedContinuationImpl(eVar) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(eVar);
                    g0.n(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                protected Object invokeSuspend(Object obj) {
                    kotlin.g0.n(obj);
                    return obj;
                }
            };
        }
        return new ContinuationImpl(eVar, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createSimpleCoroutineForSuspendFunction$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(eVar, context);
                g0.n(eVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            protected Object invokeSuspend(Object obj) {
                kotlin.g0.n(obj);
                return obj;
            }
        };
    }
}
