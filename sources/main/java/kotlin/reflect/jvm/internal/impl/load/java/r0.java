package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.types.e1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JvmName(name = "SpecialBuiltinMembers")
@SourceDebugExtension({"SMAP\nspecialBuiltinMembers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 specialBuiltinMembers.kt\norg/jetbrains/kotlin/load/java/SpecialBuiltinMembers\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,177:1\n1#2:178\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class r0 {
    public static final boolean d(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.jvm.internal.g0.p(callableMemberDescriptor, "<this>");
        return g(callableMemberDescriptor) != null;
    }

    @Nullable
    public static final String e(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        CallableMemberDescriptor w5;
        kotlin.reflect.jvm.internal.impl.name.f j6;
        kotlin.jvm.internal.g0.p(callableMemberDescriptor, "callableMemberDescriptor");
        CallableMemberDescriptor f6 = f(callableMemberDescriptor);
        if (f6 != null && (w5 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.w(f6)) != null) {
            if (w5 instanceof w0) {
                return l.f45498a.b(w5);
            }
            if ((w5 instanceof d1) && (j6 = e.f45424o.j((d1) w5)) != null) {
                return j6.b();
            }
        }
        return null;
    }

    @Nullable
    public static final <T extends CallableMemberDescriptor> T g(@NotNull T t5) {
        kotlin.jvm.internal.g0.p(t5, "<this>");
        if (!SpecialGenericSignatures.f45335a.g().contains(t5.getName()) && !i.f45440a.d().contains(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.w(t5).getName())) {
            return null;
        }
        if ((t5 instanceof w0) || (t5 instanceof v0)) {
            return (T) kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.i(t5, false, o0.f45729a, 1, null);
        }
        if (t5 instanceof d1) {
            return (T) kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.i(t5, false, p0.f45731a, 1, null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(CallableMemberDescriptor it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return l.f45498a.d(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.w(it));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(CallableMemberDescriptor it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return e.f45424o.k((d1) it);
    }

    @Nullable
    public static final <T extends CallableMemberDescriptor> T j(@NotNull T t5) {
        kotlin.jvm.internal.g0.p(t5, "<this>");
        T t6 = (T) g(t5);
        if (t6 != null) {
            return t6;
        }
        h hVar = h.f45434o;
        kotlin.reflect.jvm.internal.impl.name.f name = t5.getName();
        kotlin.jvm.internal.g0.o(name, "getName(...)");
        if (hVar.n(name)) {
            return (T) kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.i(t5, false, q0.f45735a, 1, null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k(CallableMemberDescriptor it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return kotlin.reflect.jvm.internal.impl.builtins.j.h0(it) && h.o(it) != null;
    }

    public static final boolean l(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a specialCallableDescriptor) {
        kotlin.jvm.internal.g0.p(dVar, "<this>");
        kotlin.jvm.internal.g0.p(specialCallableDescriptor, "specialCallableDescriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.k b6 = specialCallableDescriptor.b();
        kotlin.jvm.internal.g0.n(b6, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        e1 s5 = ((kotlin.reflect.jvm.internal.impl.descriptors.d) b6).s();
        kotlin.jvm.internal.g0.o(s5, "getDefaultType(...)");
        for (kotlin.reflect.jvm.internal.impl.descriptors.d s6 = kotlin.reflect.jvm.internal.impl.resolve.i.s(dVar); s6 != null; s6 = kotlin.reflect.jvm.internal.impl.resolve.i.s(s6)) {
            if (!(s6 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.c) && kotlin.reflect.jvm.internal.impl.types.checker.y.b(s6.s(), s5) != null) {
                return !kotlin.reflect.jvm.internal.impl.builtins.j.h0(s6);
            }
        }
        return false;
    }

    public static final boolean m(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.jvm.internal.g0.p(callableMemberDescriptor, "<this>");
        return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.w(callableMemberDescriptor).b() instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.c;
    }

    public static final boolean n(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.jvm.internal.g0.p(callableMemberDescriptor, "<this>");
        return m(callableMemberDescriptor) || kotlin.reflect.jvm.internal.impl.builtins.j.h0(callableMemberDescriptor);
    }

    private static final CallableMemberDescriptor f(CallableMemberDescriptor callableMemberDescriptor) {
        if (kotlin.reflect.jvm.internal.impl.builtins.j.h0(callableMemberDescriptor)) {
            return g(callableMemberDescriptor);
        }
        return null;
    }
}
