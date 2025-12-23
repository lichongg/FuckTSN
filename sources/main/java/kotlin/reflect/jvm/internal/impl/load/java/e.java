package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e extends SpecialGenericSignatures {

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public static final e f45424o = new e();

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l(d1 d1Var, CallableMemberDescriptor it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return SpecialGenericSignatures.f45335a.j().containsKey(kotlin.reflect.jvm.internal.impl.load.kotlin.c0.d(d1Var));
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.name.f j(@NotNull d1 functionDescriptor) {
        kotlin.jvm.internal.g0.p(functionDescriptor, "functionDescriptor");
        Map<String, kotlin.reflect.jvm.internal.impl.name.f> j6 = SpecialGenericSignatures.f45335a.j();
        String d6 = kotlin.reflect.jvm.internal.impl.load.kotlin.c0.d(functionDescriptor);
        if (d6 == null) {
            return null;
        }
        return j6.get(d6);
    }

    public final boolean k(@NotNull d1 functionDescriptor) {
        kotlin.jvm.internal.g0.p(functionDescriptor, "functionDescriptor");
        return kotlin.reflect.jvm.internal.impl.builtins.j.h0(functionDescriptor) && kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.i(functionDescriptor, false, new d(functionDescriptor), 1, null) != null;
    }

    public final boolean m(@NotNull d1 d1Var) {
        kotlin.jvm.internal.g0.p(d1Var, "<this>");
        return kotlin.jvm.internal.g0.g(d1Var.getName().b(), "removeAt") && kotlin.jvm.internal.g0.g(kotlin.reflect.jvm.internal.impl.load.kotlin.c0.d(d1Var), SpecialGenericSignatures.f45335a.h().d());
    }

    private e() {
    }
}
