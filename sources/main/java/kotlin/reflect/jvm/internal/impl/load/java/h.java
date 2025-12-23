package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nspecialBuiltinMembers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 specialBuiltinMembers.kt\norg/jetbrains/kotlin/load/java/BuiltinMethodsWithSpecialGenericSignature\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,177:1\n1#2:178\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class h extends SpecialGenericSignatures {

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public static final h f45434o = new h();

    private final boolean k(CallableMemberDescriptor callableMemberDescriptor) {
        return kotlin.collections.f0.a2(SpecialGenericSignatures.f45335a.e(), kotlin.reflect.jvm.internal.impl.load.kotlin.c0.d(callableMemberDescriptor));
    }

    @JvmStatic
    @Nullable
    public static final kotlin.reflect.jvm.internal.impl.descriptors.y l(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y functionDescriptor) {
        kotlin.jvm.internal.g0.p(functionDescriptor, "functionDescriptor");
        h hVar = f45434o;
        kotlin.reflect.jvm.internal.impl.name.f name = functionDescriptor.getName();
        kotlin.jvm.internal.g0.o(name, "getName(...)");
        if (hVar.n(name)) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.y) kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.i(functionDescriptor, false, f.f45426a, 1, null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(CallableMemberDescriptor it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return f45434o.k(it);
    }

    @JvmStatic
    @Nullable
    public static final SpecialGenericSignatures.SpecialSignatureInfo o(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        CallableMemberDescriptor i6;
        String d6;
        kotlin.jvm.internal.g0.p(callableMemberDescriptor, "<this>");
        SpecialGenericSignatures.a aVar = SpecialGenericSignatures.f45335a;
        if (!aVar.d().contains(callableMemberDescriptor.getName()) || (i6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.i(callableMemberDescriptor, false, g.f45428a, 1, null)) == null || (d6 = kotlin.reflect.jvm.internal.impl.load.kotlin.c0.d(i6)) == null) {
            return null;
        }
        return aVar.l(d6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(CallableMemberDescriptor it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return (it instanceof kotlin.reflect.jvm.internal.impl.descriptors.y) && f45434o.k(it);
    }

    public final boolean n(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar) {
        kotlin.jvm.internal.g0.p(fVar, "<this>");
        return SpecialGenericSignatures.f45335a.d().contains(fVar);
    }

    private h() {
    }
}
