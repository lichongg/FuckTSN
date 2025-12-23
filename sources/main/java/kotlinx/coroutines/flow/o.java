package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final /* synthetic */ class o {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__CountKt", f = "Count.kt", i = {0}, l = {17}, m = "count", n = {"i"}, s = {"L$0"})
    static final class a<T> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f49071a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f49072b;

        /* renamed from: c, reason: collision with root package name */
        int f49073c;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f49072b = obj;
            this.f49073c |= Integer.MIN_VALUE;
            return k.Y(null, this);
        }

        a(kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b<T> implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f49074a;

        b(Ref.IntRef intRef) {
            this.f49074a = intRef;
        }

        @Override // kotlinx.coroutines.flow.j
        @Nullable
        public final Object emit(T t5, @NotNull kotlin.coroutines.e<? super n1> eVar) {
            this.f49074a.element++;
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__CountKt", f = "Count.kt", i = {0}, l = {29}, m = "count", n = {"i"}, s = {"L$0"})
    static final class c<T> extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f49075a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f49076b;

        /* renamed from: c, reason: collision with root package name */
        int f49077c;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f49076b = obj;
            this.f49077c |= Integer.MIN_VALUE;
            return k.Z(null, null, this);
        }

        c(kotlin.coroutines.e<? super c> eVar) {
            super(eVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class d<T> implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<T, kotlin.coroutines.e<? super Boolean>, Object> f49078a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f49079b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__CountKt$count$4", f = "Count.kt", i = {0}, l = {30}, m = "emit", n = {"this"}, s = {"L$0"})
        static final class a extends ContinuationImpl {

            /* renamed from: a, reason: collision with root package name */
            Object f49080a;

            /* renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f49081b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ d<T> f49082c;

            /* renamed from: d, reason: collision with root package name */
            int f49083d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(d<? super T> dVar, kotlin.coroutines.e<? super a> eVar) {
                super(eVar);
                this.f49082c = dVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f49081b = obj;
                this.f49083d |= Integer.MIN_VALUE;
                return this.f49082c.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        d(Function2<? super T, ? super kotlin.coroutines.e<? super Boolean>, ? extends Object> function2, Ref.IntRef intRef) {
            this.f49078a = function2;
            this.f49079b = intRef;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // kotlinx.coroutines.flow.j
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(T r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof kotlinx.coroutines.flow.o.d.a
                if (r0 == 0) goto L13
                r0 = r6
                kotlinx.coroutines.flow.o$d$a r0 = (kotlinx.coroutines.flow.o.d.a) r0
                int r1 = r0.f49083d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f49083d = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.o$d$a r0 = new kotlinx.coroutines.flow.o$d$a
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.f49081b
                java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
                int r2 = r0.f49083d
                r3 = 1
                if (r2 == 0) goto L35
                if (r2 != r3) goto L2d
                java.lang.Object r5 = r0.f49080a
                kotlinx.coroutines.flow.o$d r5 = (kotlinx.coroutines.flow.o.d) r5
                kotlin.g0.n(r6)
                goto L46
            L2d:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L35:
                kotlin.g0.n(r6)
                kotlin.jvm.functions.Function2<T, kotlin.coroutines.e<? super java.lang.Boolean>, java.lang.Object> r6 = r4.f49078a
                r0.f49080a = r4
                r0.f49083d = r3
                java.lang.Object r6 = r6.invoke(r5, r0)
                if (r6 != r1) goto L45
                return r1
            L45:
                r5 = r4
            L46:
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                if (r6 == 0) goto L55
                kotlin.jvm.internal.Ref$IntRef r5 = r5.f49079b
                int r6 = r5.element
                int r6 = r6 + r3
                r5.element = r6
            L55:
                kotlin.n1 r5 = kotlin.n1.f44123a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.o.d.emit(java.lang.Object, kotlin.coroutines.e):java.lang.Object");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super java.lang.Integer> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.o.a
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.o$a r0 = (kotlinx.coroutines.flow.o.a) r0
            int r1 = r0.f49073c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49073c = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.o$a r0 = new kotlinx.coroutines.flow.o$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f49072b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f49073c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f49071a
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            kotlin.g0.n(r5)
            goto L4e
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.g0.n(r5)
            kotlin.jvm.internal.Ref$IntRef r5 = new kotlin.jvm.internal.Ref$IntRef
            r5.<init>()
            kotlinx.coroutines.flow.o$b r2 = new kotlinx.coroutines.flow.o$b
            r2.<init>(r5)
            r0.f49071a = r5
            r0.f49073c = r3
            java.lang.Object r4 = r4.collect(r2, r0)
            if (r4 != r1) goto L4d
            return r1
        L4d:
            r4 = r5
        L4e:
            int r4 = r4.element
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.a.f(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.o.a(kotlinx.coroutines.flow.i, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object b(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.e<? super java.lang.Boolean>, ? extends java.lang.Object> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super java.lang.Integer> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.o.c
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.o$c r0 = (kotlinx.coroutines.flow.o.c) r0
            int r1 = r0.f49077c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49077c = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.o$c r0 = new kotlinx.coroutines.flow.o$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f49076b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f49077c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f49075a
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            kotlin.g0.n(r6)
            goto L4e
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.g0.n(r6)
            kotlin.jvm.internal.Ref$IntRef r6 = new kotlin.jvm.internal.Ref$IntRef
            r6.<init>()
            kotlinx.coroutines.flow.o$d r2 = new kotlinx.coroutines.flow.o$d
            r2.<init>(r5, r6)
            r0.f49075a = r6
            r0.f49077c = r3
            java.lang.Object r4 = r4.collect(r2, r0)
            if (r4 != r1) goto L4d
            return r1
        L4d:
            r4 = r6
        L4e:
            int r4 = r4.element
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.a.f(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.o.b(kotlinx.coroutines.flow.i, kotlin.jvm.functions.Function2, kotlin.coroutines.e):java.lang.Object");
    }
}
