package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.p2;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\Downloads\app\classes.dex */
final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {
    final /* synthetic */ Function2<r0, kotlin.coroutines.e<? super n1>, Object> $block;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", i = {0, 0}, l = {166}, m = "invokeSuspend", n = {"launchedJob", "observer"}, s = {"L$0", "L$1"})
    @SourceDebugExtension({"SMAP\nRepeatOnLifecycle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RepeatOnLifecycle.kt\nandroidx/lifecycle/RepeatOnLifecycleKt$repeatOnLifecycle$3$1\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,165:1\n314#2,11:166\n*S KotlinDebug\n*F\n+ 1 RepeatOnLifecycle.kt\nandroidx/lifecycle/RepeatOnLifecycleKt$repeatOnLifecycle$3$1\n*L\n97#1:166,11\n*E\n"})
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {
        final /* synthetic */ r0 $$this$coroutineScope;
        final /* synthetic */ Function2<r0, kotlin.coroutines.e<? super n1>, Object> $block;
        final /* synthetic */ Lifecycle.State $state;
        final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, r0 r0Var, Function2<? super r0, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2, kotlin.coroutines.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.$this_repeatOnLifecycle = lifecycle;
            this.$state = state;
            this.$$this$coroutineScope = r0Var;
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            return new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull r0 r0Var, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((AnonymousClass1) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00cf  */
        /* JADX WARN: Removed duplicated region for block: B:26:? A[SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r4v3, types: [T, androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r13.label
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L37
                if (r1 != r3) goto L2f
                java.lang.Object r0 = r13.L$5
                kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
                java.lang.Object r0 = r13.L$4
                kotlinx.coroutines.r0 r0 = (kotlinx.coroutines.r0) r0
                java.lang.Object r0 = r13.L$3
                androidx.lifecycle.Lifecycle r0 = (androidx.lifecycle.Lifecycle) r0
                java.lang.Object r0 = r13.L$2
                androidx.lifecycle.Lifecycle$State r0 = (androidx.lifecycle.Lifecycle.State) r0
                java.lang.Object r0 = r13.L$1
                r1 = r0
                kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
                java.lang.Object r0 = r13.L$0
                r4 = r0
                kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
                kotlin.g0.n(r14)     // Catch: java.lang.Throwable -> L2b
                goto La9
            L2b:
                r0 = move-exception
                r14 = r0
                goto Lc0
            L2f:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L37:
                kotlin.g0.n(r14)
                androidx.lifecycle.Lifecycle r14 = r13.$this_repeatOnLifecycle
                androidx.lifecycle.Lifecycle$State r14 = r14.getCurrentState()
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.DESTROYED
                if (r14 != r1) goto L47
                kotlin.n1 r14 = kotlin.n1.f44123a
                return r14
            L47:
                kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
                r6.<init>()
                kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
                r1.<init>()
                androidx.lifecycle.Lifecycle$State r14 = r13.$state     // Catch: java.lang.Throwable -> La1
                androidx.lifecycle.Lifecycle r12 = r13.$this_repeatOnLifecycle     // Catch: java.lang.Throwable -> La1
                kotlinx.coroutines.r0 r7 = r13.$$this$coroutineScope     // Catch: java.lang.Throwable -> La1
                kotlin.jvm.functions.Function2<kotlinx.coroutines.r0, kotlin.coroutines.e<? super kotlin.n1>, java.lang.Object> r11 = r13.$block     // Catch: java.lang.Throwable -> La1
                r13.L$0 = r6     // Catch: java.lang.Throwable -> La1
                r13.L$1 = r1     // Catch: java.lang.Throwable -> La1
                r13.L$2 = r14     // Catch: java.lang.Throwable -> La1
                r13.L$3 = r12     // Catch: java.lang.Throwable -> La1
                r13.L$4 = r7     // Catch: java.lang.Throwable -> La1
                r13.L$5 = r11     // Catch: java.lang.Throwable -> La1
                r13.label = r3     // Catch: java.lang.Throwable -> La1
                kotlinx.coroutines.q r9 = new kotlinx.coroutines.q     // Catch: java.lang.Throwable -> La1
                kotlin.coroutines.e r4 = kotlin.coroutines.intrinsics.a.e(r13)     // Catch: java.lang.Throwable -> La1
                r9.<init>(r4, r3)     // Catch: java.lang.Throwable -> La1
                r9.Q()     // Catch: java.lang.Throwable -> La1
                androidx.lifecycle.Lifecycle$Event$Companion r4 = androidx.lifecycle.Lifecycle.Event.Companion     // Catch: java.lang.Throwable -> La1
                androidx.lifecycle.Lifecycle$Event r5 = r4.upTo(r14)     // Catch: java.lang.Throwable -> La1
                androidx.lifecycle.Lifecycle$Event r8 = r4.downFrom(r14)     // Catch: java.lang.Throwable -> La1
                r14 = 0
                kotlinx.coroutines.sync.a r10 = kotlinx.coroutines.sync.c.b(r14, r3, r2)     // Catch: java.lang.Throwable -> La1
                androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 r4 = new androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1     // Catch: java.lang.Throwable -> La1
                r4.<init>()     // Catch: java.lang.Throwable -> La1
                r1.element = r4     // Catch: java.lang.Throwable -> La1
                java.lang.String r14 = "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver"
                kotlin.jvm.internal.g0.n(r4, r14)     // Catch: java.lang.Throwable -> La1
                androidx.lifecycle.LifecycleEventObserver r4 = (androidx.lifecycle.LifecycleEventObserver) r4     // Catch: java.lang.Throwable -> La1
                r12.addObserver(r4)     // Catch: java.lang.Throwable -> La1
                java.lang.Object r14 = r9.x()     // Catch: java.lang.Throwable -> La1
                java.lang.Object r4 = kotlin.coroutines.intrinsics.a.l()     // Catch: java.lang.Throwable -> La1
                if (r14 != r4) goto La5
                kotlin.coroutines.jvm.internal.e.c(r13)     // Catch: java.lang.Throwable -> La1
                goto La5
            La1:
                r0 = move-exception
                r14 = r0
                r4 = r6
                goto Lc0
            La5:
                if (r14 != r0) goto La8
                return r0
            La8:
                r4 = r6
            La9:
                T r14 = r4.element
                kotlinx.coroutines.e2 r14 = (kotlinx.coroutines.e2) r14
                if (r14 == 0) goto Lb2
                kotlinx.coroutines.e2.a.b(r14, r2, r3, r2)
            Lb2:
                T r14 = r1.element
                androidx.lifecycle.LifecycleEventObserver r14 = (androidx.lifecycle.LifecycleEventObserver) r14
                if (r14 == 0) goto Lbd
                androidx.lifecycle.Lifecycle r0 = r13.$this_repeatOnLifecycle
                r0.removeObserver(r14)
            Lbd:
                kotlin.n1 r14 = kotlin.n1.f44123a
                return r14
            Lc0:
                T r0 = r4.element
                kotlinx.coroutines.e2 r0 = (kotlinx.coroutines.e2) r0
                if (r0 == 0) goto Lc9
                kotlinx.coroutines.e2.a.b(r0, r2, r3, r2)
            Lc9:
                T r0 = r1.element
                androidx.lifecycle.LifecycleEventObserver r0 = (androidx.lifecycle.LifecycleEventObserver) r0
                if (r0 == 0) goto Ld4
                androidx.lifecycle.Lifecycle r1 = r13.$this_repeatOnLifecycle
                r1.removeObserver(r0)
            Ld4:
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle lifecycle, Lifecycle.State state, Function2<? super r0, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2, kotlin.coroutines.e<? super RepeatOnLifecycleKt$repeatOnLifecycle$3> eVar) {
        super(2, eVar);
        this.$this_repeatOnLifecycle = lifecycle;
        this.$state = state;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3 repeatOnLifecycleKt$repeatOnLifecycle$3 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.$this_repeatOnLifecycle, this.$state, this.$block, eVar);
        repeatOnLifecycleKt$repeatOnLifecycle$3.L$0 = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull r0 r0Var, @Nullable kotlin.coroutines.e<? super n1> eVar) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object l6 = kotlin.coroutines.intrinsics.a.l();
        int i6 = this.label;
        if (i6 != 0) {
            if (i6 == 1) {
                g0.n(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            g0.n(obj);
            r0 r0Var = (r0) this.L$0;
            p2 v5 = g1.e().v();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, r0Var, this.$block, null);
            this.label = 1;
            if (kotlinx.coroutines.i.h(v5, anonymousClass1, this) == l6) {
                return l6;
            }
        }
        return n1.f44123a;
    }
}
