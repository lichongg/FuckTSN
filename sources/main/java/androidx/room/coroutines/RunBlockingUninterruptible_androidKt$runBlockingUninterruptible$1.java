package androidx.room.coroutines;

import kotlin.Result;
import kotlin.coroutines.f;
import kotlin.coroutines.i;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.w1;
import kotlinx.coroutines.y;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1", f = "RunBlockingUninterruptible.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\Downloads\app\classes.dex */
final class RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1<T> extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super T>, Object> {
    final /* synthetic */ Function2<r0, kotlin.coroutines.e<? super T>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$1", f = "RunBlockingUninterruptible.android.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nRunBlockingUninterruptible.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunBlockingUninterruptible.android.kt\nandroidx/room/coroutines/RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,67:1\n1#2:68\n*E\n"})
    /* renamed from: androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {
        final /* synthetic */ Function2<r0, kotlin.coroutines.e<? super T>, Object> $block;
        final /* synthetic */ y<T> $deferred;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(y<T> yVar, Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2, kotlin.coroutines.e<? super AnonymousClass1> eVar) {
            super(2, eVar);
            this.$deferred = yVar;
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$deferred, this.$block, eVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((AnonymousClass1) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            y<T> yVar;
            Object m130constructorimpl;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.label;
            if (i6 != 0) {
                if (i6 == 1) {
                    yVar = (y) this.L$0;
                    try {
                        g0.n(obj);
                    } catch (Throwable th) {
                        th = th;
                        Result.a aVar = Result.Companion;
                        m130constructorimpl = Result.m130constructorimpl(g0.a(th));
                        a0.d(yVar, m130constructorimpl);
                        return n1.f44123a;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                r0 r0Var = (r0) this.L$0;
                y<T> yVar2 = this.$deferred;
                Function2<r0, kotlin.coroutines.e<? super T>, Object> function2 = this.$block;
                try {
                    Result.a aVar2 = Result.Companion;
                    this.L$0 = yVar2;
                    this.label = 1;
                    obj = function2.invoke(r0Var, this);
                    if (obj == l6) {
                        return l6;
                    }
                    yVar = yVar2;
                } catch (Throwable th2) {
                    th = th2;
                    yVar = yVar2;
                    Result.a aVar3 = Result.Companion;
                    m130constructorimpl = Result.m130constructorimpl(g0.a(th));
                    a0.d(yVar, m130constructorimpl);
                    return n1.f44123a;
                }
            }
            m130constructorimpl = Result.m130constructorimpl(obj);
            a0.d(yVar, m130constructorimpl);
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$2", f = "RunBlockingUninterruptible.android.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.room.coroutines.RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super T>, Object> {
        final /* synthetic */ y<T> $deferred;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(y<T> yVar, kotlin.coroutines.e<? super AnonymousClass2> eVar) {
            super(2, eVar);
            this.$deferred = yVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new AnonymousClass2(this.$deferred, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super T> eVar) {
            return ((AnonymousClass2) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.label;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                    return obj;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            g0.n(obj);
            y<T> yVar = this.$deferred;
            this.label = 1;
            Object f6 = yVar.f(this);
            if (f6 == l6) {
                return l6;
            }
            return f6;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1(Function2<? super r0, ? super kotlin.coroutines.e<? super T>, ? extends Object> function2, kotlin.coroutines.e<? super RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1> eVar) {
        super(2, eVar);
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
        RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1 runBlockingUninterruptible_androidKt$runBlockingUninterruptible$1 = new RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1(this.$block, eVar);
        runBlockingUninterruptible_androidKt$runBlockingUninterruptible$1.L$0 = obj;
        return runBlockingUninterruptible_androidKt$runBlockingUninterruptible$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super T> eVar) {
        return ((RunBlockingUninterruptible_androidKt$runBlockingUninterruptible$1) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a.l();
        if (this.label == 0) {
            g0.n(obj);
            i.b bVar = ((r0) this.L$0).getCoroutineContext().get(f.f43765o0);
            kotlin.jvm.internal.g0.m(bVar);
            f fVar = (f) bVar;
            y c6 = a0.c(null, 1, null);
            kotlinx.coroutines.i.d(w1.f49676a, fVar, CoroutineStart.UNDISPATCHED, new AnonymousClass1(c6, this.$block, null));
            while (!c6.isCompleted()) {
                try {
                    return kotlinx.coroutines.i.f(fVar, new AnonymousClass2(c6, null));
                } catch (InterruptedException unused) {
                }
            }
            return c6.d();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
