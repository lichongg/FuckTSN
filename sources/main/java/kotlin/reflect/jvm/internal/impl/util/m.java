package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.util.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nmodifierChecks.kt\nKotlin\n*S Kotlin\n*F\n+ 1 modifierChecks.kt\norg/jetbrains/kotlin/util/NoDefaultAndVarargsCheck\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,264:1\n1740#2,3:265\n*S KotlinDebug\n*F\n+ 1 modifierChecks.kt\norg/jetbrains/kotlin/util/NoDefaultAndVarargsCheck\n*L\n105#1:265,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class m implements f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f47412a = new m();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final String f47413b = "should not have varargs or parameters with default values";

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    public boolean b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y functionDescriptor) {
        g0.p(functionDescriptor, "functionDescriptor");
        List<q1> g6 = functionDescriptor.g();
        g0.o(g6, "getValueParameters(...)");
        List<q1> list = g6;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        for (q1 q1Var : list) {
            g0.m(q1Var);
            if (kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.f(q1Var) || q1Var.z0() != null) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    @NotNull
    public String getDescription() {
        return f47413b;
    }

    private m() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    @Nullable
    public String a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y yVar) {
        return f.a.a(this, yVar);
    }
}
