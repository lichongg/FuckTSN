package kotlin.reflect.jvm.internal;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.KParameter;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j3 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j3 f47506a = new j3();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.renderer.m f47507b = kotlin.reflect.jvm.internal.impl.renderer.m.f46581h;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f47508a;

        static {
            int[] iArr = new int[KParameter.Kind.values().length];
            try {
                iArr[KParameter.Kind.EXTENSION_RECEIVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KParameter.Kind.INSTANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KParameter.Kind.VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f47508a = iArr;
        }
    }

    private final void c(StringBuilder sb, kotlin.reflect.jvm.internal.impl.descriptors.z0 z0Var) {
        if (z0Var != null) {
            kotlin.reflect.jvm.internal.impl.types.t0 type = z0Var.getType();
            kotlin.jvm.internal.g0.o(type, "getType(...)");
            sb.append(l(type));
            sb.append(".");
        }
    }

    private final String e(kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        if (aVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.w0) {
            return k((kotlin.reflect.jvm.internal.impl.descriptors.w0) aVar);
        }
        if (aVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.y) {
            return f((kotlin.reflect.jvm.internal.impl.descriptors.y) aVar);
        }
        throw new IllegalStateException(("Illegal callable: " + aVar).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence g(kotlin.reflect.jvm.internal.impl.descriptors.q1 q1Var) {
        j3 j3Var = f47506a;
        kotlin.reflect.jvm.internal.impl.types.t0 type = q1Var.getType();
        kotlin.jvm.internal.g0.o(type, "getType(...)");
        return j3Var.l(type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence i(kotlin.reflect.jvm.internal.impl.descriptors.q1 q1Var) {
        j3 j3Var = f47506a;
        kotlin.reflect.jvm.internal.impl.types.t0 type = q1Var.getType();
        kotlin.jvm.internal.g0.o(type, "getType(...)");
        return j3Var.l(type);
    }

    @NotNull
    public final String f(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y descriptor) {
        kotlin.jvm.internal.g0.p(descriptor, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append("fun ");
        j3 j3Var = f47506a;
        j3Var.d(sb, descriptor);
        kotlin.reflect.jvm.internal.impl.renderer.m mVar = f47507b;
        kotlin.reflect.jvm.internal.impl.name.f name = descriptor.getName();
        kotlin.jvm.internal.g0.o(name, "getName(...)");
        sb.append(mVar.S(name, true));
        List<kotlin.reflect.jvm.internal.impl.descriptors.q1> g6 = descriptor.g();
        kotlin.jvm.internal.g0.o(g6, "getValueParameters(...)");
        kotlin.collections.r0.o3(g6, sb, (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? "" : "(", (r14 & 8) == 0 ? ")" : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : h3.f44389a);
        sb.append(": ");
        kotlin.reflect.jvm.internal.impl.types.t0 returnType = descriptor.getReturnType();
        kotlin.jvm.internal.g0.m(returnType);
        sb.append(j3Var.l(returnType));
        return sb.toString();
    }

    @NotNull
    public final String h(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y invoke) {
        kotlin.jvm.internal.g0.p(invoke, "invoke");
        StringBuilder sb = new StringBuilder();
        j3 j3Var = f47506a;
        j3Var.d(sb, invoke);
        List<kotlin.reflect.jvm.internal.impl.descriptors.q1> g6 = invoke.g();
        kotlin.jvm.internal.g0.o(g6, "getValueParameters(...)");
        kotlin.collections.r0.o3(g6, sb, (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? "" : "(", (r14 & 8) == 0 ? ")" : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : i3.f44393a);
        sb.append(" -> ");
        kotlin.reflect.jvm.internal.impl.types.t0 returnType = invoke.getReturnType();
        kotlin.jvm.internal.g0.m(returnType);
        sb.append(j3Var.l(returnType));
        return sb.toString();
    }

    @NotNull
    public final String j(@NotNull d2 parameter) {
        kotlin.jvm.internal.g0.p(parameter, "parameter");
        StringBuilder sb = new StringBuilder();
        int i6 = a.f47508a[parameter.h().ordinal()];
        if (i6 == 1) {
            sb.append("extension receiver parameter");
        } else if (i6 == 2) {
            sb.append("instance parameter");
        } else {
            if (i6 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            sb.append("parameter #" + parameter.getIndex() + ' ' + parameter.getName());
        }
        sb.append(" of ");
        sb.append(f47506a.e(parameter.l().e0()));
        return sb.toString();
    }

    @NotNull
    public final String k(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.w0 descriptor) {
        kotlin.jvm.internal.g0.p(descriptor, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append(descriptor.C() ? "var " : "val ");
        j3 j3Var = f47506a;
        j3Var.d(sb, descriptor);
        kotlin.reflect.jvm.internal.impl.renderer.m mVar = f47507b;
        kotlin.reflect.jvm.internal.impl.name.f name = descriptor.getName();
        kotlin.jvm.internal.g0.o(name, "getName(...)");
        sb.append(mVar.S(name, true));
        sb.append(": ");
        kotlin.reflect.jvm.internal.impl.types.t0 type = descriptor.getType();
        kotlin.jvm.internal.g0.o(type, "getType(...)");
        sb.append(j3Var.l(type));
        return sb.toString();
    }

    @NotNull
    public final String l(@NotNull kotlin.reflect.jvm.internal.impl.types.t0 type) {
        kotlin.jvm.internal.g0.p(type, "type");
        return f47507b.T(type);
    }

    private j3() {
    }

    private final void d(StringBuilder sb, kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        boolean z5;
        kotlin.reflect.jvm.internal.impl.descriptors.z0 k6 = p3.k(aVar);
        kotlin.reflect.jvm.internal.impl.descriptors.z0 f02 = aVar.f0();
        c(sb, k6);
        if (k6 != null && f02 != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            sb.append("(");
        }
        c(sb, f02);
        if (z5) {
            sb.append(")");
        }
    }
}
