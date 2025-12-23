package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class g<T> implements i<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final i<T> f48872a;

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public final Function1<T, Object> f48873b;

    /* renamed from: c, reason: collision with root package name */
    @JvmField
    @NotNull
    public final Function2<Object, Object, Boolean> f48874c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a<T> implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g<T> f48875a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Object> f48876b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ j<T> f48877c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.DistinctFlowImpl$collect$2", f = "Distinct.kt", i = {}, l = {77}, m = "emit", n = {}, s = {})
        /* renamed from: kotlinx.coroutines.flow.g$a$a, reason: collision with other inner class name */
        static final class C0939a extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f48878a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ a<T> f48879b;

            /* renamed from: c, reason: collision with root package name */
            int f48880c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0939a(a<? super T> aVar, kotlin.coroutines.e<? super C0939a> eVar) {
                super(eVar);
                this.f48879b = aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f48878a = obj;
                this.f48880c |= Integer.MIN_VALUE;
                return this.f48879b.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(g<T> gVar, Ref.ObjectRef<Object> objectRef, j<? super T> jVar) {
            this.f48875a = gVar;
            this.f48876b = objectRef;
            this.f48877c = jVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // kotlinx.coroutines.flow.j
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(T r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof kotlinx.coroutines.flow.g.a.C0939a
                if (r0 == 0) goto L13
                r0 = r7
                kotlinx.coroutines.flow.g$a$a r0 = (kotlinx.coroutines.flow.g.a.C0939a) r0
                int r1 = r0.f48880c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f48880c = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.g$a$a r0 = new kotlinx.coroutines.flow.g$a$a
                r0.<init>(r5, r7)
            L18:
                java.lang.Object r7 = r0.f48878a
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r0.f48880c
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.g0.n(r7)
                goto L67
            L29:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L31:
                kotlin.g0.n(r7)
                kotlinx.coroutines.flow.g<T> r7 = r5.f48875a
                kotlin.jvm.functions.Function1<T, java.lang.Object> r7 = r7.f48873b
                java.lang.Object r7 = r7.invoke(r6)
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r2 = r5.f48876b
                T r2 = r2.element
                kotlinx.coroutines.internal.s0 r4 = kotlinx.coroutines.flow.internal.s.f49029a
                if (r2 == r4) goto L58
                kotlinx.coroutines.flow.g<T> r4 = r5.f48875a
                kotlin.jvm.functions.Function2<java.lang.Object, java.lang.Object, java.lang.Boolean> r4 = r4.f48874c
                java.lang.Object r2 = r4.invoke(r2, r7)
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                if (r2 != 0) goto L55
                goto L58
            L55:
                kotlin.n1 r6 = kotlin.n1.f44123a
                return r6
            L58:
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r2 = r5.f48876b
                r2.element = r7
                kotlinx.coroutines.flow.j<T> r7 = r5.f48877c
                r0.f48880c = r3
                java.lang.Object r6 = r7.emit(r6, r0)
                if (r6 != r1) goto L67
                return r1
            L67:
                kotlin.n1 r6 = kotlin.n1.f44123a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.g.a.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
        }
    }

    @Override // kotlinx.coroutines.flow.i
    @Nullable
    public Object collect(@NotNull j<? super T> jVar, @NotNull kotlin.coroutines.e<? super n1> eVar) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (T) kotlinx.coroutines.flow.internal.s.f49029a;
        Object collect = this.f48872a.collect(new a(this, objectRef, jVar), eVar);
        return collect == kotlin.coroutines.intrinsics.a.l() ? collect : n1.f44123a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull i<? extends T> iVar, @NotNull Function1<? super T, ? extends Object> function1, @NotNull Function2<Object, Object, Boolean> function2) {
        this.f48872a = iVar;
        this.f48873b = function1;
        this.f48874c = function2;
    }
}
