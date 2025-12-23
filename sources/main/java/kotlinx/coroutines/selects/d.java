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
public final class d<R> extends l<R> {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final kotlinx.coroutines.q<R> f49535g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.selects.SelectBuilderImpl$getResult$1", f = "SelectOld.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f49536a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d<R> f49537b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(d<R> dVar, kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
            this.f49537b = dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            return new a(this.f49537b, eVar);
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
            int i6 = this.f49536a;
            try {
                if (i6 != 0) {
                    if (i6 == 1) {
                        g0.n(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    g0.n(obj);
                    d<R> dVar = this.f49537b;
                    this.f49536a = 1;
                    obj = dVar.y(this);
                    if (obj == l6) {
                        return l6;
                    }
                }
                p.c(((d) this.f49537b).f49535g, obj);
                return n1.f44123a;
            } catch (Throwable th) {
                p.d(((d) this.f49537b).f49535g, th);
                return n1.f44123a;
            }
        }
    }

    @PublishedApi
    @Nullable
    public final Object P() {
        if (this.f49535g.isCompleted()) {
            return this.f49535g.x();
        }
        kotlinx.coroutines.k.f(s0.a(getContext()), null, CoroutineStart.UNDISPATCHED, new a(this, null), 1, null);
        return this.f49535g.x();
    }

    @PublishedApi
    public final void Q(@NotNull Throwable th) {
        kotlinx.coroutines.q<R> qVar = this.f49535g;
        Result.a aVar = Result.Companion;
        qVar.resumeWith(Result.m130constructorimpl(g0.a(th)));
    }

    public d(@NotNull kotlin.coroutines.e<? super R> eVar) {
        super(eVar.getContext());
        this.f49535g = new kotlinx.coroutines.q<>(kotlin.coroutines.intrinsics.a.e(eVar), 1);
    }
}
