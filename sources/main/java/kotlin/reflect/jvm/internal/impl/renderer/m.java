package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.u1;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.renderer.a;
import kotlin.reflect.jvm.internal.impl.types.c2;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f46574a;

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final m f46575b;

    /* renamed from: c, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final m f46576c;

    /* renamed from: d, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final m f46577d;

    /* renamed from: e, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final m f46578e;

    /* renamed from: f, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final m f46579f;

    /* renamed from: g, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final m f46580g;

    /* renamed from: h, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final m f46581h;

    /* renamed from: i, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final m f46582i;

    /* renamed from: j, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final m f46583j;

    /* renamed from: k, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final m f46584k;

    /* renamed from: l, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final m f46585l;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.m$a$a, reason: collision with other inner class name */
        public static final /* synthetic */ class C0909a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f46586a;

            static {
                int[] iArr = new int[ClassKind.values().length];
                try {
                    iArr[ClassKind.CLASS.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ClassKind.INTERFACE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ClassKind.ENUM_CLASS.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ClassKind.OBJECT.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[ClassKind.ENUM_ENTRY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                f46586a = iArr;
            }
        }

        private a() {
        }

        @NotNull
        public final String a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.g classifier) {
            g0.p(classifier, "classifier");
            if (classifier instanceof i1) {
                return "typealias";
            }
            if (!(classifier instanceof kotlin.reflect.jvm.internal.impl.descriptors.d)) {
                throw new AssertionError("Unexpected classifier: " + classifier);
            }
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) classifier;
            if (dVar.l0()) {
                return "companion object";
            }
            switch (C0909a.f46586a[dVar.h().ordinal()]) {
                case 1:
                    return "class";
                case 2:
                    return "interface";
                case 3:
                    return "enum class";
                case 4:
                    return "object";
                case 5:
                    return "annotation class";
                case 6:
                    return "enum entry";
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        @NotNull
        public final m b(@NotNull Function1<? super u, n1> changeOptions) {
            g0.p(changeOptions, "changeOptions");
            x xVar = new x();
            changeOptions.invoke(xVar);
            xVar.r0();
            return new t(xVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class a implements b {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final a f46587a = new a();

            @Override // kotlin.reflect.jvm.internal.impl.renderer.m.b
            public void a(int i6, @NotNull StringBuilder builder) {
                g0.p(builder, "builder");
                builder.append("(");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.m.b
            public void b(int i6, @NotNull StringBuilder builder) {
                g0.p(builder, "builder");
                builder.append(")");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.m.b
            public void c(@NotNull q1 parameter, int i6, int i7, @NotNull StringBuilder builder) {
                g0.p(parameter, "parameter");
                g0.p(builder, "builder");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.m.b
            public void d(@NotNull q1 parameter, int i6, int i7, @NotNull StringBuilder builder) {
                g0.p(parameter, "parameter");
                g0.p(builder, "builder");
                if (i6 != i7 - 1) {
                    builder.append(", ");
                }
            }

            private a() {
            }
        }

        void a(int i6, @NotNull StringBuilder sb);

        void b(int i6, @NotNull StringBuilder sb);

        void c(@NotNull q1 q1Var, int i6, int i7, @NotNull StringBuilder sb);

        void d(@NotNull q1 q1Var, int i6, int i7, @NotNull StringBuilder sb);
    }

    @NotNull
    public abstract String N(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar);

    @NotNull
    public abstract String O(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar, @Nullable AnnotationUseSiteTarget annotationUseSiteTarget);

    @NotNull
    public abstract String Q(@NotNull String str, @NotNull String str2, @NotNull kotlin.reflect.jvm.internal.impl.builtins.j jVar);

    @NotNull
    public abstract String R(@NotNull kotlin.reflect.jvm.internal.impl.name.d dVar);

    @NotNull
    public abstract String S(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, boolean z5);

    @NotNull
    public abstract String T(@NotNull t0 t0Var);

    @NotNull
    public abstract String U(@NotNull c2 c2Var);

    static {
        a aVar = new a(null);
        f46574a = aVar;
        f46575b = aVar.b(kotlin.reflect.jvm.internal.impl.renderer.b.f46563a);
        f46576c = aVar.b(d.f46565a);
        f46577d = aVar.b(e.f46566a);
        f46578e = aVar.b(f.f46567a);
        f46579f = aVar.b(g.f46568a);
        f46580g = aVar.b(h.f46569a);
        f46581h = aVar.b(i.f46570a);
        f46582i = aVar.b(j.f46571a);
        f46583j = aVar.b(k.f46572a);
        f46584k = aVar.b(l.f46573a);
        f46585l = aVar.b(c.f46564a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 A(u withOptions) {
        g0.p(withOptions, "$this$withOptions");
        withOptions.p(a.b.f46561a);
        withOptions.a(ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 B(u withOptions) {
        g0.p(withOptions, "$this$withOptions");
        withOptions.g(u1.k());
        return n1.f44123a;
    }

    public static /* synthetic */ String P(m mVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar, AnnotationUseSiteTarget annotationUseSiteTarget, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
        }
        if ((i6 & 2) != 0) {
            annotationUseSiteTarget = null;
        }
        return mVar.O(cVar, annotationUseSiteTarget);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 r(u withOptions) {
        g0.p(withOptions, "$this$withOptions");
        withOptions.k(false);
        withOptions.g(u1.k());
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 s(u withOptions) {
        g0.p(withOptions, "$this$withOptions");
        withOptions.k(false);
        withOptions.g(u1.k());
        withOptions.l(true);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 t(u withOptions) {
        g0.p(withOptions, "$this$withOptions");
        withOptions.k(false);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 u(u withOptions) {
        g0.p(withOptions, "$this$withOptions");
        withOptions.g(u1.k());
        withOptions.p(a.b.f46561a);
        withOptions.a(ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 v(u withOptions) {
        g0.p(withOptions, "$this$withOptions");
        withOptions.h(true);
        withOptions.p(a.C0908a.f46560a);
        withOptions.g(DescriptorRendererModifier.ALL);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 w(u withOptions) {
        g0.p(withOptions, "$this$withOptions");
        withOptions.g(DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 x(u withOptions) {
        g0.p(withOptions, "$this$withOptions");
        withOptions.g(DescriptorRendererModifier.ALL);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 y(u withOptions) {
        g0.p(withOptions, "$this$withOptions");
        withOptions.n(RenderingFormat.HTML);
        withOptions.g(DescriptorRendererModifier.ALL);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 z(u withOptions) {
        g0.p(withOptions, "$this$withOptions");
        withOptions.k(false);
        withOptions.g(u1.k());
        withOptions.p(a.b.f46561a);
        withOptions.i(true);
        withOptions.a(ParameterNameRenderingPolicy.NONE);
        withOptions.m(true);
        withOptions.q(true);
        withOptions.l(true);
        withOptions.j(true);
        return n1.f44123a;
    }

    @NotNull
    public final m V(@NotNull Function1<? super u, n1> changeOptions) {
        g0.p(changeOptions, "changeOptions");
        g0.n(this, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        x t5 = ((t) this).L0().t();
        changeOptions.invoke(t5);
        t5.r0();
        return new t(t5);
    }
}
