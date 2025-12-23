package kotlinx.coroutines.flow.internal;

import com.umeng.analytics.pro.bi;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.b0;
import kotlinx.coroutines.channels.z;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f<T> extends d<T> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlinx.coroutines.flow.i<kotlinx.coroutines.flow.i<T>> f48918d;

    /* renamed from: e, reason: collision with root package name */
    private final int f48919e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> implements kotlinx.coroutines.flow.j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e2 f48920a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.sync.d f48921b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ z<T> f48922c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ u<T> f48923d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1", f = "Merge.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: kotlinx.coroutines.flow.internal.f$a$a, reason: collision with other inner class name */
        static final class C0940a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            int f48924a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.i<T> f48925b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ u<T> f48926c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.sync.d f48927d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0940a(kotlinx.coroutines.flow.i<? extends T> iVar, u<T> uVar, kotlinx.coroutines.sync.d dVar, kotlin.coroutines.e<? super C0940a> eVar) {
                super(2, eVar);
                this.f48925b = iVar;
                this.f48926c = uVar;
                this.f48927d = dVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
                return new C0940a(this.f48925b, this.f48926c, this.f48927d, eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull r0 r0Var, @Nullable kotlin.coroutines.e<? super n1> eVar) {
                return ((C0940a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object l6 = kotlin.coroutines.intrinsics.a.l();
                int i6 = this.f48924a;
                try {
                    if (i6 != 0) {
                        if (i6 == 1) {
                            g0.n(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        g0.n(obj);
                        kotlinx.coroutines.flow.i<T> iVar = this.f48925b;
                        u<T> uVar = this.f48926c;
                        this.f48924a = 1;
                        if (iVar.collect(uVar, this) == l6) {
                            return l6;
                        }
                    }
                    this.f48927d.release();
                    return n1.f44123a;
                } catch (Throwable th) {
                    this.f48927d.release();
                    throw th;
                }
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2", f = "Merge.kt", i = {0, 0}, l = {66}, m = "emit", n = {"this", bi.ax}, s = {"L$0", "L$1"})
        static final class b extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            Object f48928a;

            /* renamed from: b, reason: collision with root package name */
            Object f48929b;

            /* renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f48930c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ a<T> f48931d;

            /* renamed from: e, reason: collision with root package name */
            int f48932e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            b(a<? super T> aVar, kotlin.coroutines.e<? super b> eVar) {
                super(eVar);
                this.f48931d = aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f48930c = obj;
                this.f48932e |= Integer.MIN_VALUE;
                return this.f48931d.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(e2 e2Var, kotlinx.coroutines.sync.d dVar, z<? super T> zVar, u<T> uVar) {
            this.f48920a = e2Var;
            this.f48921b = dVar;
            this.f48922c = zVar;
            this.f48923d = uVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // kotlinx.coroutines.flow.j
        @org.jetbrains.annotations.Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i<? extends T> r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof kotlinx.coroutines.flow.internal.f.a.b
                if (r0 == 0) goto L13
                r0 = r9
                kotlinx.coroutines.flow.internal.f$a$b r0 = (kotlinx.coroutines.flow.internal.f.a.b) r0
                int r1 = r0.f48932e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f48932e = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.internal.f$a$b r0 = new kotlinx.coroutines.flow.internal.f$a$b
                r0.<init>(r7, r9)
            L18:
                java.lang.Object r9 = r0.f48930c
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r0.f48932e
                r3 = 1
                if (r2 == 0) goto L39
                if (r2 != r3) goto L31
                java.lang.Object r8 = r0.f48929b
                kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) r8
                java.lang.Object r0 = r0.f48928a
                kotlinx.coroutines.flow.internal.f$a r0 = (kotlinx.coroutines.flow.internal.f.a) r0
                kotlin.g0.n(r9)
                goto L53
            L31:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L39:
                kotlin.g0.n(r9)
                kotlinx.coroutines.e2 r9 = r7.f48920a
                if (r9 == 0) goto L43
                kotlinx.coroutines.h2.A(r9)
            L43:
                kotlinx.coroutines.sync.d r9 = r7.f48921b
                r0.f48928a = r7
                r0.f48929b = r8
                r0.f48932e = r3
                java.lang.Object r9 = r9.c(r0)
                if (r9 != r1) goto L52
                return r1
            L52:
                r0 = r7
            L53:
                kotlinx.coroutines.channels.z<T> r1 = r0.f48922c
                kotlinx.coroutines.flow.internal.f$a$a r4 = new kotlinx.coroutines.flow.internal.f$a$a
                kotlinx.coroutines.flow.internal.u<T> r9 = r0.f48923d
                kotlinx.coroutines.sync.d r0 = r0.f48921b
                r2 = 0
                r4.<init>(r8, r9, r0, r2)
                r5 = 3
                r6 = 0
                r3 = 0
                kotlinx.coroutines.i.e(r1, r2, r3, r4, r5, r6)
                kotlin.n1 r8 = kotlin.n1.f44123a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.f.a.emit(kotlinx.coroutines.flow.i, kotlin.coroutines.e):java.lang.Object");
        }
    }

    public /* synthetic */ f(kotlinx.coroutines.flow.i iVar, int i6, kotlin.coroutines.i iVar2, int i7, BufferOverflow bufferOverflow, int i8, kotlin.jvm.internal.v vVar) {
        this(iVar, i6, (i8 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : iVar2, (i8 & 8) != 0 ? -2 : i7, (i8 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.d
    @NotNull
    protected String f() {
        return "concurrency=" + this.f48919e;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    @Nullable
    protected Object h(@NotNull z<? super T> zVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object collect = this.f48918d.collect(new a((e2) eVar.getContext().get(e2.f48569s0), kotlinx.coroutines.sync.f.b(this.f48919e, 0, 2, null), zVar, new u(zVar)), eVar);
        return collect == kotlin.coroutines.intrinsics.a.l() ? collect : n1.f44123a;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    @NotNull
    protected d<T> i(@NotNull kotlin.coroutines.i iVar, int i6, @NotNull BufferOverflow bufferOverflow) {
        return new f(this.f48918d, this.f48919e, iVar, i6, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.d
    @NotNull
    public b0<T> m(@NotNull r0 r0Var) {
        return kotlinx.coroutines.channels.x.c(r0Var, this.f48908a, this.f48909b, k());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@NotNull kotlinx.coroutines.flow.i<? extends kotlinx.coroutines.flow.i<? extends T>> iVar, int i6, @NotNull kotlin.coroutines.i iVar2, int i7, @NotNull BufferOverflow bufferOverflow) {
        super(iVar2, i7, bufferOverflow);
        this.f48918d = iVar;
        this.f48919e = i6;
    }
}
