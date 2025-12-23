package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.load.java.e0;
import kotlin.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y3.z;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c {
    @NotNull
    public static final k d(@NotNull k kVar, @NotNull p typeParameterResolver) {
        g0.p(kVar, "<this>");
        g0.p(typeParameterResolver, "typeParameterResolver");
        return new k(kVar.a(), typeParameterResolver, kVar.c());
    }

    @NotNull
    public static final k e(@NotNull k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.e containingDeclaration, @Nullable z zVar, int i6) {
        g0.p(kVar, "<this>");
        g0.p(containingDeclaration, "containingDeclaration");
        return c(kVar, containingDeclaration, zVar, i6, t.b(LazyThreadSafetyMode.NONE, new a(kVar, containingDeclaration)));
    }

    public static /* synthetic */ k f(k kVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, z zVar, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            zVar = null;
        }
        if ((i7 & 4) != 0) {
            i6 = 0;
        }
        return e(kVar, eVar, zVar, i6);
    }

    @NotNull
    public static final k h(@NotNull k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k containingDeclaration, @NotNull z typeParameterOwner, int i6) {
        g0.p(kVar, "<this>");
        g0.p(containingDeclaration, "containingDeclaration");
        g0.p(typeParameterOwner, "typeParameterOwner");
        return c(kVar, containingDeclaration, typeParameterOwner, i6, kVar.c());
    }

    public static /* synthetic */ k i(k kVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar2, z zVar, int i6, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            i6 = 0;
        }
        return h(kVar, kVar2, zVar, i6);
    }

    @Nullable
    public static final e0 j(@NotNull k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g additionalAnnotations) {
        g0.p(kVar, "<this>");
        g0.p(additionalAnnotations, "additionalAnnotations");
        return kVar.a().a().d(kVar.b(), additionalAnnotations);
    }

    @NotNull
    public static final k k(@NotNull k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g additionalAnnotations) {
        g0.p(kVar, "<this>");
        g0.p(additionalAnnotations, "additionalAnnotations");
        return additionalAnnotations.isEmpty() ? kVar : new k(kVar.a(), kVar.f(), t.b(LazyThreadSafetyMode.NONE, new b(kVar, additionalAnnotations)));
    }

    @NotNull
    public static final k m(@NotNull k kVar, @NotNull d components) {
        g0.p(kVar, "<this>");
        g0.p(components, "components");
        return new k(components, kVar.f(), kVar.c());
    }

    private static final k c(k kVar, kotlin.reflect.jvm.internal.impl.descriptors.k kVar2, z zVar, int i6, s<e0> sVar) {
        p f6;
        d a6 = kVar.a();
        if (zVar != null) {
            f6 = new m(kVar, kVar2, zVar, i6);
        } else {
            f6 = kVar.f();
        }
        return new k(a6, f6, sVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e0 g(k kVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        return j(kVar, eVar.getAnnotations());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final e0 l(k kVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        return j(kVar, gVar);
    }
}
