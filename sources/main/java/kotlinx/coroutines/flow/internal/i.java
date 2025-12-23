package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/internal/ChannelFlowTransformLatest\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,100:1\n1#2:101\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i<T, R> extends g<T, R> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final Function3<kotlinx.coroutines.flow.j<? super R>, T, kotlin.coroutines.e<? super n1>, Object> f48937e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48938a;

        /* renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f48939b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ i<T, R> f48940c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.j<R> f48941d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlinx.coroutines.flow.internal.i$a$a, reason: collision with other inner class name */
        static final class C0941a<T> implements kotlinx.coroutines.flow.j {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Ref.ObjectRef<e2> f48942a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ r0 f48943b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ i<T, R> f48944c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j<R> f48945d;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2", f = "Merge.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: kotlinx.coroutines.flow.internal.i$a$a$a, reason: collision with other inner class name */
            static final class C0942a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

                /* renamed from: a, reason: collision with root package name */
                int f48946a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ i<T, R> f48947b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.flow.j<R> f48948c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ T f48949d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C0942a(i<T, R> iVar, kotlinx.coroutines.flow.j<? super R> jVar, T t5, kotlin.coroutines.e<? super C0942a> eVar) {
                    super(2, eVar);
                    this.f48947b = iVar;
                    this.f48948c = jVar;
                    this.f48949d = t5;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
                    return new C0942a(this.f48947b, this.f48948c, this.f48949d, eVar);
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull r0 r0Var, @Nullable kotlin.coroutines.e<? super n1> eVar) {
                    return ((C0942a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object l6 = kotlin.coroutines.intrinsics.a.l();
                    int i6 = this.f48946a;
                    if (i6 != 0) {
                        if (i6 == 1) {
                            g0.n(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        g0.n(obj);
                        Function3 function3 = ((i) this.f48947b).f48937e;
                        kotlinx.coroutines.flow.j<R> jVar = this.f48948c;
                        T t5 = this.f48949d;
                        this.f48946a = 1;
                        if (function3.invoke(jVar, t5, this) == l6) {
                            return l6;
                        }
                    }
                    return n1.f44123a;
                }
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1", f = "Merge.kt", i = {0, 0}, l = {30}, m = "emit", n = {"this", "value"}, s = {"L$0", "L$1"})
            /* renamed from: kotlinx.coroutines.flow.internal.i$a$a$b */
            static final class b extends ContinuationImpl {

                /* renamed from: a, reason: collision with root package name */
                Object f48950a;

                /* renamed from: b, reason: collision with root package name */
                Object f48951b;

                /* renamed from: c, reason: collision with root package name */
                Object f48952c;

                /* renamed from: d, reason: collision with root package name */
                /* synthetic */ Object f48953d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ C0941a<T> f48954e;

                /* renamed from: f, reason: collision with root package name */
                int f48955f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                b(C0941a<? super T> c0941a, kotlin.coroutines.e<? super b> eVar) {
                    super(eVar);
                    this.f48954e = c0941a;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    this.f48953d = obj;
                    this.f48955f |= Integer.MIN_VALUE;
                    return this.f48954e.emit(null, this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            C0941a(Ref.ObjectRef<e2> objectRef, r0 r0Var, i<T, R> iVar, kotlinx.coroutines.flow.j<? super R> jVar) {
                this.f48942a = objectRef;
                this.f48943b = r0Var;
                this.f48944c = iVar;
                this.f48945d = jVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
            @Override // kotlinx.coroutines.flow.j
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(T r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof kotlinx.coroutines.flow.internal.i.a.C0941a.b
                    if (r0 == 0) goto L13
                    r0 = r9
                    kotlinx.coroutines.flow.internal.i$a$a$b r0 = (kotlinx.coroutines.flow.internal.i.a.C0941a.b) r0
                    int r1 = r0.f48955f
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f48955f = r1
                    goto L18
                L13:
                    kotlinx.coroutines.flow.internal.i$a$a$b r0 = new kotlinx.coroutines.flow.internal.i$a$a$b
                    r0.<init>(r7, r9)
                L18:
                    java.lang.Object r9 = r0.f48953d
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                    int r2 = r0.f48955f
                    r3 = 1
                    if (r2 == 0) goto L3b
                    if (r2 != r3) goto L33
                    java.lang.Object r8 = r0.f48952c
                    kotlinx.coroutines.e2 r8 = (kotlinx.coroutines.e2) r8
                    java.lang.Object r8 = r0.f48951b
                    java.lang.Object r0 = r0.f48950a
                    kotlinx.coroutines.flow.internal.i$a$a r0 = (kotlinx.coroutines.flow.internal.i.a.C0941a) r0
                    kotlin.g0.n(r9)
                    goto L5e
                L33:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L3b:
                    kotlin.g0.n(r9)
                    kotlin.jvm.internal.Ref$ObjectRef<kotlinx.coroutines.e2> r9 = r7.f48942a
                    T r9 = r9.element
                    kotlinx.coroutines.e2 r9 = (kotlinx.coroutines.e2) r9
                    if (r9 == 0) goto L5d
                    kotlinx.coroutines.flow.internal.ChildCancelledException r2 = new kotlinx.coroutines.flow.internal.ChildCancelledException
                    r2.<init>()
                    r9.b(r2)
                    r0.f48950a = r7
                    r0.f48951b = r8
                    r0.f48952c = r9
                    r0.f48955f = r3
                    java.lang.Object r9 = r9.M(r0)
                    if (r9 != r1) goto L5d
                    return r1
                L5d:
                    r0 = r7
                L5e:
                    kotlin.jvm.internal.Ref$ObjectRef<kotlinx.coroutines.e2> r9 = r0.f48942a
                    kotlinx.coroutines.r0 r1 = r0.f48943b
                    kotlinx.coroutines.CoroutineStart r3 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
                    kotlinx.coroutines.flow.internal.i$a$a$a r4 = new kotlinx.coroutines.flow.internal.i$a$a$a
                    kotlinx.coroutines.flow.internal.i<T, R> r2 = r0.f48944c
                    kotlinx.coroutines.flow.j<R> r0 = r0.f48945d
                    r5 = 0
                    r4.<init>(r2, r0, r8, r5)
                    r5 = 1
                    r6 = 0
                    r2 = 0
                    kotlinx.coroutines.e2 r8 = kotlinx.coroutines.i.e(r1, r2, r3, r4, r5, r6)
                    r9.element = r8
                    kotlin.n1 r8 = kotlin.n1.f44123a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.i.a.C0941a.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(i<T, R> iVar, kotlinx.coroutines.flow.j<? super R> jVar, kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
            this.f48940c = iVar;
            this.f48941d = jVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            a aVar = new a(this.f48940c, this.f48941d, eVar);
            aVar.f48939b = obj;
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
            int i6 = this.f48938a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                r0 r0Var = (r0) this.f48939b;
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                i<T, R> iVar = this.f48940c;
                kotlinx.coroutines.flow.i<S> iVar2 = iVar.f48933d;
                C0941a c0941a = new C0941a(objectRef, r0Var, iVar, this.f48941d);
                this.f48938a = 1;
                if (iVar2.collect(c0941a, this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    public /* synthetic */ i(Function3 function3, kotlinx.coroutines.flow.i iVar, kotlin.coroutines.i iVar2, int i6, BufferOverflow bufferOverflow, int i7, kotlin.jvm.internal.v vVar) {
        this(function3, iVar, (i7 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : iVar2, (i7 & 8) != 0 ? -2 : i6, (i7 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.d
    @NotNull
    protected d<R> i(@NotNull kotlin.coroutines.i iVar, int i6, @NotNull BufferOverflow bufferOverflow) {
        return new i(this.f48937e, this.f48933d, iVar, i6, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.g
    @Nullable
    protected Object r(@NotNull kotlinx.coroutines.flow.j<? super R> jVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Object g6 = s0.g(new a(this, jVar, null), eVar);
        return g6 == kotlin.coroutines.intrinsics.a.l() ? g6 : n1.f44123a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(@NotNull Function3<? super kotlinx.coroutines.flow.j<? super R>, ? super T, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function3, @NotNull kotlinx.coroutines.flow.i<? extends T> iVar, @NotNull kotlin.coroutines.i iVar2, int i6, @NotNull BufferOverflow bufferOverflow) {
        super(iVar, iVar2, i6, bufferOverflow);
        this.f48937e = function3;
    }
}
