package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.internal.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class x<T> implements kotlinx.coroutines.flow.j<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final kotlin.coroutines.i f49037a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Object f49038b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Function2<T, kotlin.coroutines.e<? super n1>, Object> f49039c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.UndispatchedContextCollector$emitRef$1", f = "ChannelFlow.kt", i = {}, l = {212}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<T, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f49040a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f49041b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.j<T> f49042c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(kotlinx.coroutines.flow.j<? super T> jVar, kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
            this.f49042c = jVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            a aVar = new a(this.f49042c, eVar);
            aVar.f49041b = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object invoke(T t5, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(t5, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f49040a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                Object obj2 = this.f49041b;
                kotlinx.coroutines.flow.j<T> jVar = this.f49042c;
                this.f49040a = 1;
                if (jVar.emit(obj2, this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    @Override // kotlinx.coroutines.flow.j
    @Nullable
    public Object emit(T t5, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object c6 = e.c(this.f49037a, t5, this.f49038b, this.f49039c, eVar);
        return c6 == kotlin.coroutines.intrinsics.a.l() ? c6 : n1.f44123a;
    }

    public x(@NotNull kotlinx.coroutines.flow.j<? super T> jVar, @NotNull kotlin.coroutines.i iVar) {
        this.f49037a = iVar;
        this.f49038b = y0.b(iVar);
        this.f49039c = new a(jVar, null);
    }
}
