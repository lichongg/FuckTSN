package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nClassicBuiltinSpecialProperties.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassicBuiltinSpecialProperties.kt\norg/jetbrains/kotlin/load/java/ClassicBuiltinSpecialProperties\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,36:1\n1#2:37\n1761#3,3:38\n*S KotlinDebug\n*F\n+ 1 ClassicBuiltinSpecialProperties.kt\norg/jetbrains/kotlin/load/java/ClassicBuiltinSpecialProperties\n*L\n33#1:38,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f45498a = new l();

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(CallableMemberDescriptor it) {
        kotlin.jvm.internal.g0.p(it, "it");
        return f45498a.d(it);
    }

    private final boolean e(CallableMemberDescriptor callableMemberDescriptor) {
        if (kotlin.collections.f0.a2(i.f45440a.c(), kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.k(callableMemberDescriptor)) && callableMemberDescriptor.g().isEmpty()) {
            return true;
        }
        if (!kotlin.reflect.jvm.internal.impl.builtins.j.h0(callableMemberDescriptor)) {
            return false;
        }
        Collection<? extends CallableMemberDescriptor> e6 = callableMemberDescriptor.e();
        kotlin.jvm.internal.g0.o(e6, "getOverriddenDescriptors(...)");
        Collection<? extends CallableMemberDescriptor> collection = e6;
        if (collection.isEmpty()) {
            return false;
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            l lVar = f45498a;
            kotlin.jvm.internal.g0.m(callableMemberDescriptor2);
            if (lVar.d(callableMemberDescriptor2)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final String b(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.reflect.jvm.internal.impl.name.f fVar;
        kotlin.jvm.internal.g0.p(callableMemberDescriptor, "<this>");
        kotlin.reflect.jvm.internal.impl.builtins.j.h0(callableMemberDescriptor);
        CallableMemberDescriptor i6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.i(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.w(callableMemberDescriptor), false, k.f45494a, 1, null);
        if (i6 == null || (fVar = i.f45440a.a().get(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.o(i6))) == null) {
            return null;
        }
        return fVar.b();
    }

    public final boolean d(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.jvm.internal.g0.p(callableMemberDescriptor, "callableMemberDescriptor");
        if (i.f45440a.d().contains(callableMemberDescriptor.getName())) {
            return e(callableMemberDescriptor);
        }
        return false;
    }

    private l() {
    }
}
