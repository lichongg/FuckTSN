package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.calls.h;
import kotlin.reflect.jvm.internal.p2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nKPropertyImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KPropertyImpl.kt\nkotlin/reflect/jvm/internal/KPropertyImplKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,334:1\n1#2:335\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class u2 {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.reflect.jvm.internal.calls.g<?> b(kotlin.reflect.jvm.internal.p2.a<?, ?> r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 587
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.u2.b(kotlin.reflect.jvm.internal.p2$a, boolean):kotlin.reflect.jvm.internal.calls.g");
    }

    @Nullable
    public static final Object f(@NotNull p2.a<?, ?> aVar) {
        kotlin.jvm.internal.g0.p(aVar, "<this>");
        return aVar.f0().k0();
    }

    private static final kotlin.reflect.jvm.internal.calls.h<Field> c(p2.a<?, ?> aVar, boolean z5, Field field) {
        if (!g(aVar.f0().e0()) && Modifier.isStatic(field.getModifiers())) {
            if (d(aVar)) {
                if (z5) {
                    if (aVar.c0()) {
                        return new h.f.b(field);
                    }
                    return new h.f.d(field);
                }
                if (aVar.c0()) {
                    return new h.g.b(field, e(aVar));
                }
                return new h.g.d(field, e(aVar));
            }
            if (z5) {
                return new h.f.e(field);
            }
            return new h.g.e(field, e(aVar));
        }
        if (z5) {
            if (aVar.c0()) {
                return new h.f.a(field, f(aVar));
            }
            return new h.f.c(field);
        }
        if (aVar.c0()) {
            return new h.g.a(field, e(aVar), f(aVar));
        }
        return new h.g.c(field, e(aVar));
    }

    private static final boolean d(p2.a<?, ?> aVar) {
        return aVar.f0().e0().getAnnotations().l(p3.l());
    }

    private static final boolean e(p2.a<?, ?> aVar) {
        return !kotlin.reflect.jvm.internal.impl.types.j2.l(aVar.f0().e0().getType());
    }

    private static final boolean g(kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var) {
        kotlin.reflect.jvm.internal.impl.descriptors.k b6 = w0Var.b();
        kotlin.jvm.internal.g0.o(b6, "getContainingDeclaration(...)");
        if (!kotlin.reflect.jvm.internal.impl.resolve.i.x(b6)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.k b7 = b6.b();
        if (!kotlin.reflect.jvm.internal.impl.resolve.i.C(b7) && !kotlin.reflect.jvm.internal.impl.resolve.i.t(b7)) {
            return true;
        }
        if (!(w0Var instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n0) || !kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h.f(((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.n0) w0Var).K())) {
            return false;
        }
        return true;
    }
}
