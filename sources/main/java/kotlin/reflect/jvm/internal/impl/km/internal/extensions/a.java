package kotlin.reflect.jvm.internal.impl.km.internal.extensions;

import java.util.Collection;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.km.q;
import kotlin.reflect.jvm.internal.impl.km.r;
import kotlin.reflect.jvm.internal.impl.km.s;
import kotlin.reflect.jvm.internal.impl.km.u;
import kotlin.reflect.jvm.internal.impl.km.w;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a {
    @NotNull
    public static final b a(@NotNull kotlin.reflect.jvm.internal.impl.km.g gVar, @NotNull f type) {
        g0.p(gVar, "<this>");
        g0.p(type, "type");
        return (b) h(gVar.h(), type);
    }

    @NotNull
    public static final c b(@NotNull kotlin.reflect.jvm.internal.impl.km.j jVar, @NotNull f type) {
        g0.p(jVar, "<this>");
        g0.p(type, "type");
        return (c) h(jVar.b(), type);
    }

    @NotNull
    public static final g c(@NotNull q qVar, @NotNull f type) {
        g0.p(qVar, "<this>");
        g0.p(type, "type");
        return (g) h(qVar.d(), type);
    }

    @NotNull
    public static final i d(@NotNull r rVar, @NotNull f type) {
        g0.p(rVar, "<this>");
        g0.p(type, "type");
        return (i) h(rVar.d(), type);
    }

    @NotNull
    public static final j e(@NotNull s sVar, @NotNull f type) {
        g0.p(sVar, "<this>");
        g0.p(type, "type");
        return (j) h(sVar.f(), type);
    }

    @NotNull
    public static final l f(@NotNull u uVar, @NotNull f type) {
        g0.p(uVar, "<this>");
        g0.p(type, "type");
        return (l) h(uVar.d(), type);
    }

    @NotNull
    public static final m g(@NotNull w wVar, @NotNull f type) {
        g0.p(wVar, "<this>");
        g0.p(type, "type");
        return (m) h(wVar.a(), type);
    }

    private static final <N extends e> N h(Collection<? extends N> collection, f fVar) {
        N n6 = null;
        for (N n7 : collection) {
            if (g0.g(n7.getType(), fVar)) {
                if (n6 == null) {
                    n6 = n7;
                } else {
                    throw new IllegalStateException("Multiple extensions handle the same extension type: " + fVar);
                }
            }
        }
        if (n6 != null) {
            return n6;
        }
        throw new IllegalStateException("No extensions handle the extension type: " + fVar);
    }
}
