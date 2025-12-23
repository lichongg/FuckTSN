package kotlinx.coroutines.flow.internal;

import java.util.ArrayList;
import kotlin.collections.f0;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.b0;
import kotlinx.coroutines.channels.z;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.s0;
import kotlinx.coroutines.u0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@InternalCoroutinesApi
@SourceDebugExtension({"SMAP\nChannelFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelFlow.kt\nkotlinx/coroutines/flow/internal/ChannelFlow\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,245:1\n1#2:246\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class d<T> implements p<T> {

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    @NotNull
    public final kotlin.coroutines.i f48908a;

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    public final int f48909b;

    /* renamed from: c, reason: collision with root package name */
    @JvmField
    @NotNull
    public final BufferOverflow f48910c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48911a;

        /* renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f48912b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.j<T> f48913c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d<T> f48914d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(kotlinx.coroutines.flow.j<? super T> jVar, d<T> dVar, kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
            this.f48913c = jVar;
            this.f48914d = dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            a aVar = new a(this.f48913c, this.f48914d, eVar);
            aVar.f48912b = obj;
            return aVar;
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
            int i6 = this.f48911a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                r0 r0Var = (r0) this.f48912b;
                kotlinx.coroutines.flow.j<T> jVar = this.f48913c;
                b0<T> m6 = this.f48914d.m(r0Var);
                this.f48911a = 1;
                if (kotlinx.coroutines.flow.k.l0(jVar, m6, this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", f = "ChannelFlow.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<z<? super T>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48915a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f48916b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d<T> f48917c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(d<T> dVar, kotlin.coroutines.e<? super b> eVar) {
            super(2, eVar);
            this.f48917c = dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            b bVar = new b(this.f48917c, eVar);
            bVar.f48916b = obj;
            return bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull z<? super T> zVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((b) create(zVar, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f48915a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                z<? super T> zVar = (z) this.f48916b;
                d<T> dVar = this.f48917c;
                this.f48915a = 1;
                if (dVar.h(zVar, this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    @Nullable
    protected String f() {
        return null;
    }

    @Nullable
    protected abstract Object h(@NotNull z<? super T> zVar, @NotNull kotlin.coroutines.e<? super n1> eVar);

    @NotNull
    protected abstract d<T> i(@NotNull kotlin.coroutines.i iVar, int i6, @NotNull BufferOverflow bufferOverflow);

    @Nullable
    public kotlinx.coroutines.flow.i<T> j() {
        return null;
    }

    static /* synthetic */ <T> Object g(d<T> dVar, kotlinx.coroutines.flow.j<? super T> jVar, kotlin.coroutines.e<? super n1> eVar) {
        Object g6 = s0.g(new a(jVar, dVar, null), eVar);
        return g6 == kotlin.coroutines.intrinsics.a.l() ? g6 : n1.f44123a;
    }

    @Override // kotlinx.coroutines.flow.internal.p
    @NotNull
    public kotlinx.coroutines.flow.i<T> e(@NotNull kotlin.coroutines.i iVar, int i6, @NotNull BufferOverflow bufferOverflow) {
        kotlin.coroutines.i plus = iVar.plus(this.f48908a);
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            int i7 = this.f48909b;
            if (i7 != -3) {
                if (i6 != -3) {
                    if (i7 != -2) {
                        if (i6 != -2) {
                            i6 += i7;
                            if (i6 < 0) {
                                i6 = Integer.MAX_VALUE;
                            }
                        }
                    }
                }
                i6 = i7;
            }
            bufferOverflow = this.f48910c;
        }
        return (kotlin.jvm.internal.g0.g(plus, this.f48908a) && i6 == this.f48909b && bufferOverflow == this.f48910c) ? this : i(plus, i6, bufferOverflow);
    }

    @NotNull
    public final Function2<z<? super T>, kotlin.coroutines.e<? super n1>, Object> k() {
        return new b(this, null);
    }

    public final int l() {
        int i6 = this.f48909b;
        if (i6 == -3) {
            return -2;
        }
        return i6;
    }

    @NotNull
    public b0<T> m(@NotNull r0 r0Var) {
        return kotlinx.coroutines.channels.x.h(r0Var, this.f48908a, l(), this.f48910c, CoroutineStart.ATOMIC, null, k(), 16, null);
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String f6 = f();
        if (f6 != null) {
            arrayList.add(f6);
        }
        if (this.f48908a != EmptyCoroutineContext.INSTANCE) {
            arrayList.add("context=" + this.f48908a);
        }
        if (this.f48909b != -3) {
            arrayList.add("capacity=" + this.f48909b);
        }
        if (this.f48910c != BufferOverflow.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.f48910c);
        }
        return u0.a(this) + '[' + f0.r3(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }

    public d(@NotNull kotlin.coroutines.i iVar, int i6, @NotNull BufferOverflow bufferOverflow) {
        this.f48908a = iVar;
        this.f48909b = i6;
        this.f48910c = bufferOverflow;
    }

    @Override // kotlinx.coroutines.flow.i
    @Nullable
    public Object collect(@NotNull kotlinx.coroutines.flow.j<? super T> jVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        return g(this, jVar, eVar);
    }
}
