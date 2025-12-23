package kotlinx.coroutines.flow;

import kotlin.KotlinNothingValueException;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class f0 implements c0 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.StartedLazily$command$1", f = "SharingStarted.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<j<? super SharingCommand>, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f48864a;

        /* renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f48865b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ h0<Integer> f48866c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlinx.coroutines.flow.f0$a$a, reason: collision with other inner class name */
        static final class C0937a<T> implements j {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Ref.BooleanRef f48867a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ j<SharingCommand> f48868b;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            @DebugMetadata(c = "kotlinx.coroutines.flow.StartedLazily$command$1$1", f = "SharingStarted.kt", i = {}, l = {158}, m = "emit", n = {}, s = {})
            /* renamed from: kotlinx.coroutines.flow.f0$a$a$a, reason: collision with other inner class name */
            static final class C0938a extends ContinuationImpl {

                /* renamed from: a, reason: collision with root package name */
                /* synthetic */ Object f48869a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ C0937a<T> f48870b;

                /* renamed from: c, reason: collision with root package name */
                int f48871c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C0938a(C0937a<? super T> c0937a, kotlin.coroutines.e<? super C0938a> eVar) {
                    super(eVar);
                    this.f48870b = c0937a;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    this.f48869a = obj;
                    this.f48871c |= Integer.MIN_VALUE;
                    return this.f48870b.a(0, this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            C0937a(Ref.BooleanRef booleanRef, j<? super SharingCommand> jVar) {
                this.f48867a = booleanRef;
                this.f48868b = jVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object a(int r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof kotlinx.coroutines.flow.f0.a.C0937a.C0938a
                    if (r0 == 0) goto L13
                    r0 = r6
                    kotlinx.coroutines.flow.f0$a$a$a r0 = (kotlinx.coroutines.flow.f0.a.C0937a.C0938a) r0
                    int r1 = r0.f48871c
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f48871c = r1
                    goto L18
                L13:
                    kotlinx.coroutines.flow.f0$a$a$a r0 = new kotlinx.coroutines.flow.f0$a$a$a
                    r0.<init>(r4, r6)
                L18:
                    java.lang.Object r6 = r0.f48869a
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                    int r2 = r0.f48871c
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.g0.n(r6)
                    goto L4b
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    kotlin.g0.n(r6)
                    if (r5 <= 0) goto L4e
                    kotlin.jvm.internal.Ref$BooleanRef r5 = r4.f48867a
                    boolean r6 = r5.element
                    if (r6 != 0) goto L4e
                    r5.element = r3
                    kotlinx.coroutines.flow.j<kotlinx.coroutines.flow.SharingCommand> r5 = r4.f48868b
                    kotlinx.coroutines.flow.SharingCommand r6 = kotlinx.coroutines.flow.SharingCommand.START
                    r0.f48871c = r3
                    java.lang.Object r5 = r5.emit(r6, r0)
                    if (r5 != r1) goto L4b
                    return r1
                L4b:
                    kotlin.n1 r5 = kotlin.n1.f44123a
                    return r5
                L4e:
                    kotlin.n1 r5 = kotlin.n1.f44123a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.f0.a.C0937a.a(int, kotlin.coroutines.e):java.lang.Object");
            }

            @Override // kotlinx.coroutines.flow.j
            public /* bridge */ /* synthetic */ Object emit(Object obj, kotlin.coroutines.e eVar) {
                return a(((Number) obj).intValue(), eVar);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(h0<Integer> h0Var, kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
            this.f48866c = h0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.e<n1> create(@Nullable Object obj, @NotNull kotlin.coroutines.e<?> eVar) {
            a aVar = new a(this.f48866c, eVar);
            aVar.f48865b = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull j<? super SharingCommand> jVar, @Nullable kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(jVar, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f48864a;
            if (i6 != 0) {
                if (i6 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.g0.n(obj);
            } else {
                kotlin.g0.n(obj);
                j jVar = (j) this.f48865b;
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                h0<Integer> h0Var = this.f48866c;
                C0937a c0937a = new C0937a(booleanRef, jVar);
                this.f48864a = 1;
                if (h0Var.collect(c0937a, this) == l6) {
                    return l6;
                }
            }
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlinx.coroutines.flow.c0
    @NotNull
    public i<SharingCommand> a(@NotNull h0<Integer> h0Var) {
        return k.J0(new a(h0Var, null));
    }

    @NotNull
    public String toString() {
        return "SharingStarted.Lazily";
    }
}
