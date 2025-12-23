package kotlinx.coroutines.selects;

import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@PublishedApi
/* loaded from: D:\Downloads\app\classes8.dex */
public final class r<R> extends s<R> {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final kotlinx.coroutines.q<R> f49583h;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl$initSelectResult$1", f = "SelectOld.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f49584a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ r<R> f49585b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(r<R> rVar, kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
            this.f49585b = rVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            return new a(this.f49585b, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull r0 r0Var, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f49584a;
            try {
                if (i6 != 0) {
                    if (i6 == 1) {
                        g0.n(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    g0.n(obj);
                    r<R> rVar = this.f49585b;
                    this.f49584a = 1;
                    obj = rVar.y(this);
                    if (obj == l6) {
                        return l6;
                    }
                }
                p.c(((r) this.f49585b).f49583h, obj);
                return n1.f44123a;
            } catch (Throwable th) {
                p.d(((r) this.f49585b).f49583h, th);
                return n1.f44123a;
            }
        }
    }

    @PublishedApi
    public final void R(@NotNull Throwable th) {
        kotlinx.coroutines.q<R> qVar = this.f49583h;
        Result.a aVar = Result.Companion;
        qVar.resumeWith(Result.m130constructorimpl(g0.a(th)));
    }

    @PublishedApi
    @Nullable
    public final Object S() {
        if (this.f49583h.isCompleted()) {
            return this.f49583h.x();
        }
        kotlinx.coroutines.k.f(s0.a(getContext()), null, CoroutineStart.UNDISPATCHED, new a(this, null), 1, null);
        return this.f49583h.x();
    }

    public r(@NotNull kotlin.coroutines.e<? super R> eVar) {
        super(eVar.getContext());
        this.f49583h = new kotlinx.coroutines.q<>(kotlin.coroutines.intrinsics.a.e(eVar), 1);
    }
}
