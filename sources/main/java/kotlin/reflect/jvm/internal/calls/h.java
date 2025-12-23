package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.s0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCallerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,281:1\n1#2:282\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class h<M extends Member> implements kotlin.reflect.jvm.internal.calls.g<M> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final d f44288e = new d(null);

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final M f44289a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Type f44290b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final Class<?> f44291c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final List<Type> f44292d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nCallerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenBoundConstructor\n+ 2 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Companion\n*L\n1#1,281:1\n278#2:282\n*S KotlinDebug\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenBoundConstructor\n*L\n76#1:282\n*E\n"})
    public static final class a extends h<Constructor<?>> implements kotlin.reflect.jvm.internal.calls.f {

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        private final Object f44293f;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(@org.jetbrains.annotations.NotNull java.lang.reflect.Constructor<?> r8, @org.jetbrains.annotations.Nullable java.lang.Object r9) {
            /*
                r7 = this;
                java.lang.String r0 = "constructor"
                kotlin.jvm.internal.g0.p(r8, r0)
                java.lang.Class r3 = r8.getDeclaringClass()
                java.lang.String r0 = "getDeclaringClass(...)"
                kotlin.jvm.internal.g0.o(r3, r0)
                java.lang.reflect.Type[] r0 = r8.getGenericParameterTypes()
                java.lang.String r1 = "getGenericParameterTypes(...)"
                kotlin.jvm.internal.g0.o(r0, r1)
                int r1 = r0.length
                r2 = 2
                if (r1 > r2) goto L1f
                r0 = 0
                java.lang.reflect.Type[] r0 = new java.lang.reflect.Type[r0]
                goto L26
            L1f:
                int r1 = r0.length
                r2 = 1
                int r1 = r1 - r2
                java.lang.Object[] r0 = kotlin.collections.n.l1(r0, r2, r1)
            L26:
                r5 = r0
                java.lang.reflect.Type[] r5 = (java.lang.reflect.Type[]) r5
                r6 = 0
                r4 = 0
                r1 = r7
                r2 = r8
                r1.<init>(r2, r3, r4, r5, r6)
                r1.f44293f = r9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.h.a.<init>(java.lang.reflect.Constructor, java.lang.Object):void");
        }

        @Override // kotlin.reflect.jvm.internal.calls.g
        @Nullable
        public Object call(@NotNull Object[] args) {
            g0.p(args, "args");
            d(args);
            Constructor<?> c6 = c();
            s0 s0Var = new s0(3);
            s0Var.a(this.f44293f);
            s0Var.b(args);
            s0Var.a(null);
            return c6.newInstance(s0Var.d(new Object[s0Var.c()]));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nCallerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenConstructor\n+ 2 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Companion\n*L\n1#1,281:1\n274#2:282\n*S KotlinDebug\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenConstructor\n*L\n62#1:282\n*E\n"})
    public static final class b extends h<Constructor<?>> {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public b(@org.jetbrains.annotations.NotNull java.lang.reflect.Constructor<?> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "constructor"
                kotlin.jvm.internal.g0.p(r8, r0)
                java.lang.Class r3 = r8.getDeclaringClass()
                java.lang.String r0 = "getDeclaringClass(...)"
                kotlin.jvm.internal.g0.o(r3, r0)
                java.lang.reflect.Type[] r0 = r8.getGenericParameterTypes()
                java.lang.String r1 = "getGenericParameterTypes(...)"
                kotlin.jvm.internal.g0.o(r0, r1)
                int r1 = r0.length
                r2 = 0
                r4 = 1
                if (r1 > r4) goto L1f
                java.lang.reflect.Type[] r0 = new java.lang.reflect.Type[r2]
                goto L25
            L1f:
                int r1 = r0.length
                int r1 = r1 - r4
                java.lang.Object[] r0 = kotlin.collections.n.l1(r0, r2, r1)
            L25:
                r5 = r0
                java.lang.reflect.Type[] r5 = (java.lang.reflect.Type[]) r5
                r6 = 0
                r4 = 0
                r1 = r7
                r2 = r8
                r1.<init>(r2, r3, r4, r5, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.h.b.<init>(java.lang.reflect.Constructor):void");
        }

        @Override // kotlin.reflect.jvm.internal.calls.g
        @Nullable
        public Object call(@NotNull Object[] args) {
            g0.p(args, "args");
            d(args);
            Constructor<?> c6 = c();
            s0 s0Var = new s0(2);
            s0Var.b(args);
            s0Var.a(null);
            return c6.newInstance(s0Var.d(new Object[s0Var.c()]));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c extends h<Constructor<?>> implements kotlin.reflect.jvm.internal.calls.f {

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        private final Object f44294f;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public c(@org.jetbrains.annotations.NotNull java.lang.reflect.Constructor<?> r8, @org.jetbrains.annotations.Nullable java.lang.Object r9) {
            /*
                r7 = this;
                java.lang.String r0 = "constructor"
                kotlin.jvm.internal.g0.p(r8, r0)
                java.lang.Class r3 = r8.getDeclaringClass()
                java.lang.String r0 = "getDeclaringClass(...)"
                kotlin.jvm.internal.g0.o(r3, r0)
                java.lang.reflect.Type[] r5 = r8.getGenericParameterTypes()
                java.lang.String r0 = "getGenericParameterTypes(...)"
                kotlin.jvm.internal.g0.o(r5, r0)
                r6 = 0
                r4 = 0
                r1 = r7
                r2 = r8
                r1.<init>(r2, r3, r4, r5, r6)
                r1.f44294f = r9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.h.c.<init>(java.lang.reflect.Constructor, java.lang.Object):void");
        }

        @Override // kotlin.reflect.jvm.internal.calls.g
        @Nullable
        public Object call(@NotNull Object[] args) {
            g0.p(args, "args");
            d(args);
            Constructor<?> c6 = c();
            s0 s0Var = new s0(2);
            s0Var.a(this.f44294f);
            s0Var.b(args);
            return c6.newInstance(s0Var.d(new Object[s0Var.c()]));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d {
        public /* synthetic */ d(v vVar) {
            this();
        }

        private d() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class e extends h<Constructor<?>> {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public e(@org.jetbrains.annotations.NotNull java.lang.reflect.Constructor<?> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "constructor"
                kotlin.jvm.internal.g0.p(r8, r0)
                java.lang.Class r3 = r8.getDeclaringClass()
                java.lang.String r0 = "getDeclaringClass(...)"
                kotlin.jvm.internal.g0.o(r3, r0)
                java.lang.Class r0 = r8.getDeclaringClass()
                java.lang.Class r1 = r0.getDeclaringClass()
                if (r1 == 0) goto L24
                int r0 = r0.getModifiers()
                boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
                if (r0 != 0) goto L24
            L22:
                r4 = r1
                goto L26
            L24:
                r1 = 0
                goto L22
            L26:
                java.lang.reflect.Type[] r5 = r8.getGenericParameterTypes()
                java.lang.String r0 = "getGenericParameterTypes(...)"
                kotlin.jvm.internal.g0.o(r5, r0)
                r6 = 0
                r1 = r7
                r2 = r8
                r1.<init>(r2, r3, r4, r5, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.h.e.<init>(java.lang.reflect.Constructor):void");
        }

        @Override // kotlin.reflect.jvm.internal.calls.g
        @Nullable
        public Object call(@NotNull Object[] args) {
            g0.p(args, "args");
            d(args);
            return c().newInstance(Arrays.copyOf(args, args.length));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class f extends h<Field> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class a extends f implements kotlin.reflect.jvm.internal.calls.f {

            /* renamed from: f, reason: collision with root package name */
            @Nullable
            private final Object f44295f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull Field field, @Nullable Object obj) {
                super(field, false, null);
                g0.p(field, "field");
                this.f44295f = obj;
            }

            @Override // kotlin.reflect.jvm.internal.calls.h.f, kotlin.reflect.jvm.internal.calls.g
            @Nullable
            public Object call(@NotNull Object[] args) {
                g0.p(args, "args");
                d(args);
                return c().get(this.f44295f);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends f implements kotlin.reflect.jvm.internal.calls.f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(@NotNull Field field) {
                super(field, false, null);
                g0.p(field, "field");
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class c extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(@NotNull Field field) {
                super(field, true, null);
                g0.p(field, "field");
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class d extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(@NotNull Field field) {
                super(field, true, null);
                g0.p(field, "field");
            }

            @Override // kotlin.reflect.jvm.internal.calls.h
            public void d(@NotNull Object[] args) {
                g0.p(args, "args");
                super.d(args);
                e(kotlin.collections.n.Fc(args));
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class e extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(@NotNull Field field) {
                super(field, false, null);
                g0.p(field, "field");
            }
        }

        public /* synthetic */ f(Field field, boolean z5, v vVar) {
            this(field, z5);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private f(java.lang.reflect.Field r7, boolean r8) {
            /*
                r6 = this;
                java.lang.reflect.Type r2 = r7.getGenericType()
                java.lang.String r0 = "getGenericType(...)"
                kotlin.jvm.internal.g0.o(r2, r0)
                if (r8 == 0) goto L11
                java.lang.Class r8 = r7.getDeclaringClass()
            Lf:
                r3 = r8
                goto L13
            L11:
                r8 = 0
                goto Lf
            L13:
                r8 = 0
                java.lang.reflect.Type[] r4 = new java.lang.reflect.Type[r8]
                r5 = 0
                r0 = r6
                r1 = r7
                r0.<init>(r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.h.f.<init>(java.lang.reflect.Field, boolean):void");
        }

        @Override // kotlin.reflect.jvm.internal.calls.g
        @Nullable
        public Object call(@NotNull Object[] args) {
            g0.p(args, "args");
            d(args);
            return c().get(h() != null ? kotlin.collections.n.jc(args) : null);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class g extends h<Field> {

        /* renamed from: f, reason: collision with root package name */
        private final boolean f44296f;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class a extends g implements kotlin.reflect.jvm.internal.calls.f {

            /* renamed from: g, reason: collision with root package name */
            @Nullable
            private final Object f44297g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull Field field, boolean z5, @Nullable Object obj) {
                super(field, z5, false, null);
                g0.p(field, "field");
                this.f44297g = obj;
            }

            @Override // kotlin.reflect.jvm.internal.calls.h.g, kotlin.reflect.jvm.internal.calls.g
            @NotNull
            public Object call(@NotNull Object[] args) {
                g0.p(args, "args");
                d(args);
                c().set(this.f44297g, kotlin.collections.n.jc(args));
                return n1.f44123a;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b extends g implements kotlin.reflect.jvm.internal.calls.f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(@NotNull Field field, boolean z5) {
                super(field, z5, false, null);
                g0.p(field, "field");
            }

            @Override // kotlin.reflect.jvm.internal.calls.h.g, kotlin.reflect.jvm.internal.calls.g
            @NotNull
            public Object call(@NotNull Object[] args) {
                g0.p(args, "args");
                d(args);
                c().set(null, kotlin.collections.n.Th(args));
                return n1.f44123a;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class c extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(@NotNull Field field, boolean z5) {
                super(field, z5, true, null);
                g0.p(field, "field");
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class d extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(@NotNull Field field, boolean z5) {
                super(field, z5, true, null);
                g0.p(field, "field");
            }

            @Override // kotlin.reflect.jvm.internal.calls.h.g, kotlin.reflect.jvm.internal.calls.h
            public void d(@NotNull Object[] args) {
                g0.p(args, "args");
                super.d(args);
                e(kotlin.collections.n.Fc(args));
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class e extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(@NotNull Field field, boolean z5) {
                super(field, z5, false, null);
                g0.p(field, "field");
            }
        }

        public /* synthetic */ g(Field field, boolean z5, boolean z6, v vVar) {
            this(field, z5, z6);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private g(java.lang.reflect.Field r8, boolean r9, boolean r10) {
            /*
                r7 = this;
                java.lang.String r0 = "TYPE"
                java.lang.Class r3 = java.lang.Void.TYPE
                kotlin.jvm.internal.g0.o(r3, r0)
                if (r10 == 0) goto Lf
                java.lang.Class r10 = r8.getDeclaringClass()
            Ld:
                r4 = r10
                goto L11
            Lf:
                r10 = 0
                goto Ld
            L11:
                java.lang.reflect.Type r10 = r8.getGenericType()
                r0 = 1
                java.lang.reflect.Type[] r5 = new java.lang.reflect.Type[r0]
                r0 = 0
                r5[r0] = r10
                r6 = 0
                r1 = r7
                r2 = r8
                r1.<init>(r2, r3, r4, r5, r6)
                r1.f44296f = r9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.h.g.<init>(java.lang.reflect.Field, boolean, boolean):void");
        }

        @Override // kotlin.reflect.jvm.internal.calls.g
        @Nullable
        public Object call(@NotNull Object[] args) {
            g0.p(args, "args");
            d(args);
            c().set(h() != null ? kotlin.collections.n.jc(args) : null, kotlin.collections.n.Th(args));
            return n1.f44123a;
        }

        @Override // kotlin.reflect.jvm.internal.calls.h
        public void d(@NotNull Object[] args) {
            g0.p(args, "args");
            super.d(args);
            if (this.f44296f && kotlin.collections.n.Th(args) == null) {
                throw new IllegalArgumentException("null is not allowed as a value for this property.");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlin.reflect.jvm.internal.calls.h$h, reason: collision with other inner class name */
    public static abstract class AbstractC0872h extends h<Method> {

        /* renamed from: f, reason: collision with root package name */
        private final boolean f44298f;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.calls.h$h$a */
        public static final class a extends AbstractC0872h implements kotlin.reflect.jvm.internal.calls.f {

            /* renamed from: g, reason: collision with root package name */
            @Nullable
            private final Object f44299g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull Method method, @Nullable Object obj) {
                super(method, false, null, 4, null);
                g0.p(method, "method");
                this.f44299g = obj;
            }

            @Override // kotlin.reflect.jvm.internal.calls.g
            @Nullable
            public Object call(@NotNull Object[] args) {
                g0.p(args, "args");
                d(args);
                return i(this.f44299g, args);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.calls.h$h$b */
        public static final class b extends AbstractC0872h implements kotlin.reflect.jvm.internal.calls.f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(@NotNull Method method) {
                super(method, false, null, 4, null);
                g0.p(method, "method");
            }

            @Override // kotlin.reflect.jvm.internal.calls.g
            @Nullable
            public Object call(@NotNull Object[] args) {
                g0.p(args, "args");
                d(args);
                return i(null, args);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @SourceDebugExtension({"SMAP\nCallerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStatic\n+ 2 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Companion\n*L\n1#1,281:1\n270#2:282\n*S KotlinDebug\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStatic\n*L\n142#1:282\n*E\n"})
        /* renamed from: kotlin.reflect.jvm.internal.calls.h$h$c */
        public static final class c extends AbstractC0872h implements kotlin.reflect.jvm.internal.calls.f {

            /* renamed from: g, reason: collision with root package name */
            private final boolean f44300g;

            /* renamed from: h, reason: collision with root package name */
            @Nullable
            private final Object f44301h;

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public c(@org.jetbrains.annotations.NotNull java.lang.reflect.Method r5, boolean r6, @org.jetbrains.annotations.Nullable java.lang.Object r7) {
                /*
                    r4 = this;
                    java.lang.String r0 = "method"
                    kotlin.jvm.internal.g0.p(r5, r0)
                    java.lang.reflect.Type[] r0 = r5.getGenericParameterTypes()
                    java.lang.String r1 = "getGenericParameterTypes(...)"
                    kotlin.jvm.internal.g0.o(r0, r1)
                    int r1 = r0.length
                    r2 = 0
                    r3 = 1
                    if (r1 > r3) goto L16
                    java.lang.reflect.Type[] r0 = new java.lang.reflect.Type[r2]
                    goto L1b
                L16:
                    int r1 = r0.length
                    java.lang.Object[] r0 = kotlin.collections.n.l1(r0, r3, r1)
                L1b:
                    java.lang.reflect.Type[] r0 = (java.lang.reflect.Type[]) r0
                    r1 = 0
                    r4.<init>(r5, r2, r0, r1)
                    r4.f44300g = r6
                    r4.f44301h = r7
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.h.AbstractC0872h.c.<init>(java.lang.reflect.Method, boolean, java.lang.Object):void");
            }

            @Override // kotlin.reflect.jvm.internal.calls.g
            @Nullable
            public Object call(@NotNull Object[] args) {
                g0.p(args, "args");
                d(args);
                s0 s0Var = new s0(2);
                s0Var.a(this.f44301h);
                s0Var.b(args);
                return i(null, s0Var.d(new Object[s0Var.c()]));
            }

            @Nullable
            public final Object j() {
                return this.f44301h;
            }

            public final boolean k() {
                return this.f44300g;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @SourceDebugExtension({"SMAP\nCallerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStaticMultiFieldValueClass\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,281:1\n37#2:282\n36#2,3:283\n*S KotlinDebug\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStaticMultiFieldValueClass\n*L\n155#1:282\n155#1:283,3\n*E\n"})
        /* renamed from: kotlin.reflect.jvm.internal.calls.h$h$d */
        public static final class d extends AbstractC0872h implements kotlin.reflect.jvm.internal.calls.f {

            /* renamed from: g, reason: collision with root package name */
            @NotNull
            private final Object[] f44302g;

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public d(@org.jetbrains.annotations.NotNull java.lang.reflect.Method r4, @org.jetbrains.annotations.NotNull java.lang.Object[] r5) {
                /*
                    r3 = this;
                    java.lang.String r0 = "method"
                    kotlin.jvm.internal.g0.p(r4, r0)
                    java.lang.String r0 = "boundReceiverComponents"
                    kotlin.jvm.internal.g0.p(r5, r0)
                    java.lang.reflect.Type[] r0 = r4.getGenericParameterTypes()
                    java.lang.String r1 = "getGenericParameterTypes(...)"
                    kotlin.jvm.internal.g0.o(r0, r1)
                    int r1 = r5.length
                    java.util.List r0 = kotlin.collections.n.D9(r0, r1)
                    java.util.Collection r0 = (java.util.Collection) r0
                    r1 = 0
                    java.lang.reflect.Type[] r2 = new java.lang.reflect.Type[r1]
                    java.lang.Object[] r0 = r0.toArray(r2)
                    java.lang.reflect.Type[] r0 = (java.lang.reflect.Type[]) r0
                    r2 = 0
                    r3.<init>(r4, r1, r0, r2)
                    r3.f44302g = r5
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.h.AbstractC0872h.d.<init>(java.lang.reflect.Method, java.lang.Object[]):void");
            }

            @Override // kotlin.reflect.jvm.internal.calls.g
            @Nullable
            public Object call(@NotNull Object[] args) {
                g0.p(args, "args");
                d(args);
                s0 s0Var = new s0(2);
                s0Var.b(this.f44302g);
                s0Var.b(args);
                return i(null, s0Var.d(new Object[s0Var.c()]));
            }

            @NotNull
            public final Object[] j() {
                return this.f44302g;
            }

            public final int k() {
                return this.f44302g.length;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @SourceDebugExtension({"SMAP\nCallerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Instance\n+ 2 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Companion\n*L\n1#1,281:1\n270#2:282\n*S KotlinDebug\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Instance\n*L\n113#1:282\n*E\n"})
        /* renamed from: kotlin.reflect.jvm.internal.calls.h$h$e */
        public static final class e extends AbstractC0872h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(@NotNull Method method) {
                super(method, false, null, 6, null);
                g0.p(method, "method");
            }

            @Override // kotlin.reflect.jvm.internal.calls.g
            @Nullable
            public Object call(@NotNull Object[] args) {
                g0.p(args, "args");
                d(args);
                return i(args[0], args.length <= 1 ? new Object[0] : kotlin.collections.n.l1(args, 1, args.length));
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @SourceDebugExtension({"SMAP\nCallerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Method$JvmStaticInObject\n+ 2 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Companion\n*L\n1#1,281:1\n270#2:282\n*S KotlinDebug\n*F\n+ 1 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Method$JvmStaticInObject\n*L\n121#1:282\n*E\n"})
        /* renamed from: kotlin.reflect.jvm.internal.calls.h$h$f */
        public static final class f extends AbstractC0872h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(@NotNull Method method) {
                super(method, true, null, 4, null);
                g0.p(method, "method");
            }

            @Override // kotlin.reflect.jvm.internal.calls.g
            @Nullable
            public Object call(@NotNull Object[] args) {
                g0.p(args, "args");
                d(args);
                e(kotlin.collections.n.Fc(args));
                return i(null, args.length <= 1 ? new Object[0] : kotlin.collections.n.l1(args, 1, args.length));
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.calls.h$h$g */
        public static final class g extends AbstractC0872h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public g(@NotNull Method method) {
                super(method, false, null, 6, null);
                g0.p(method, "method");
            }

            @Override // kotlin.reflect.jvm.internal.calls.g
            @Nullable
            public Object call(@NotNull Object[] args) {
                g0.p(args, "args");
                d(args);
                return i(null, args);
            }
        }

        public /* synthetic */ AbstractC0872h(Method method, boolean z5, Type[] typeArr, v vVar) {
            this(method, z5, typeArr);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public /* synthetic */ AbstractC0872h(java.lang.reflect.Method r1, boolean r2, java.lang.reflect.Type[] r3, int r4, kotlin.jvm.internal.v r5) {
            /*
                r0 = this;
                r5 = r4 & 2
                if (r5 == 0) goto Le
                int r2 = r1.getModifiers()
                boolean r2 = java.lang.reflect.Modifier.isStatic(r2)
                r2 = r2 ^ 1
            Le:
                r4 = r4 & 4
                if (r4 == 0) goto L1b
                java.lang.reflect.Type[] r3 = r1.getGenericParameterTypes()
                java.lang.String r4 = "getGenericParameterTypes(...)"
                kotlin.jvm.internal.g0.o(r3, r4)
            L1b:
                r4 = 0
                r0.<init>(r1, r2, r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.h.AbstractC0872h.<init>(java.lang.reflect.Method, boolean, java.lang.reflect.Type[], int, kotlin.jvm.internal.v):void");
        }

        @Nullable
        protected final Object i(@Nullable Object obj, @NotNull Object[] args) {
            g0.p(args, "args");
            return this.f44298f ? n1.f44123a : c().invoke(obj, Arrays.copyOf(args, args.length));
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private AbstractC0872h(java.lang.reflect.Method r7, boolean r8, java.lang.reflect.Type[] r9) {
            /*
                r6 = this;
                java.lang.reflect.Type r2 = r7.getGenericReturnType()
                java.lang.String r0 = "getGenericReturnType(...)"
                kotlin.jvm.internal.g0.o(r2, r0)
                if (r8 == 0) goto L11
                java.lang.Class r8 = r7.getDeclaringClass()
            Lf:
                r3 = r8
                goto L13
            L11:
                r8 = 0
                goto Lf
            L13:
                r5 = 0
                r0 = r6
                r1 = r7
                r4 = r9
                r0.<init>(r1, r2, r3, r4, r5)
                java.lang.reflect.Type r7 = r6.getReturnType()
                java.lang.Class r8 = java.lang.Void.TYPE
                boolean r7 = kotlin.jvm.internal.g0.g(r7, r8)
                r0.f44298f = r7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.h.AbstractC0872h.<init>(java.lang.reflect.Method, boolean, java.lang.reflect.Type[]):void");
        }
    }

    public /* synthetic */ h(Member member, Type type, Class cls, Type[] typeArr, v vVar) {
        this(member, type, cls, typeArr);
    }

    public boolean g() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0025, code lost:
    
        if (r1 == null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private h(M r1, java.lang.reflect.Type r2, java.lang.Class<?> r3, java.lang.reflect.Type[] r4) {
        /*
            r0 = this;
            r0.<init>()
            r0.f44289a = r1
            r0.f44290b = r2
            r0.f44291c = r3
            if (r3 == 0) goto L27
            kotlin.jvm.internal.s0 r1 = new kotlin.jvm.internal.s0
            r2 = 2
            r1.<init>(r2)
            r1.a(r3)
            r1.b(r4)
            int r2 = r1.c()
            java.lang.reflect.Type[] r2 = new java.lang.reflect.Type[r2]
            java.lang.Object[] r1 = r1.d(r2)
            java.util.List r1 = kotlin.collections.f0.Q(r1)
            if (r1 != 0) goto L2b
        L27:
            java.util.List r1 = kotlin.collections.n.dz(r4)
        L2b:
            r0.f44292d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.h.<init>(java.lang.reflect.Member, java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type[]):void");
    }

    @Override // kotlin.reflect.jvm.internal.calls.g
    @NotNull
    public List<Type> b() {
        return this.f44292d;
    }

    @Override // kotlin.reflect.jvm.internal.calls.g
    @NotNull
    public final M c() {
        return this.f44289a;
    }

    protected final void e(@Nullable Object obj) {
        if (obj == null || !this.f44289a.getDeclaringClass().isInstance(obj)) {
            throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        }
    }

    public void f(Object[] args) {
        g0.p(args, "args");
        if (i.a(this) == args.length) {
            return;
        }
        throw new IllegalArgumentException("Callable expects " + i.a(this) + " arguments, but " + args.length + " were provided.");
    }

    @Override // kotlin.reflect.jvm.internal.calls.g
    @NotNull
    public final Type getReturnType() {
        return this.f44290b;
    }

    @Nullable
    public final Class<?> h() {
        return this.f44291c;
    }

    @Override // kotlin.reflect.jvm.internal.calls.g
    public boolean a() {
        return g();
    }

    public void d(@NotNull Object[] objArr) {
        f(objArr);
    }
}
