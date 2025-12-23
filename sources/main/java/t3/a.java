package t3;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.incremental.components.Position;
import kotlin.reflect.jvm.internal.impl.incremental.components.ScopeKind;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.i;
import org.jetbrains.annotations.NotNull;
import u3.b;
import u3.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a {
    public static final void a(@NotNull c cVar, @NotNull b from, @NotNull d scopeOwner, @NotNull f name) {
        u3.a location;
        g0.p(cVar, "<this>");
        g0.p(from, "from");
        g0.p(scopeOwner, "scopeOwner");
        g0.p(name, "name");
        if (cVar == c.a.f54673a || (location = from.getLocation()) == null) {
            return;
        }
        Position position = cVar.a() ? location.getPosition() : Position.Companion.a();
        String a6 = location.a();
        String a7 = i.m(scopeOwner).a();
        ScopeKind scopeKind = ScopeKind.CLASSIFIER;
        String b6 = name.b();
        g0.o(b6, "asString(...)");
        cVar.b(a6, position, a7, scopeKind, b6);
    }

    public static final void b(@NotNull c cVar, @NotNull b from, @NotNull l0 scopeOwner, @NotNull f name) {
        g0.p(cVar, "<this>");
        g0.p(from, "from");
        g0.p(scopeOwner, "scopeOwner");
        g0.p(name, "name");
        String a6 = scopeOwner.d().a();
        String b6 = name.b();
        g0.o(b6, "asString(...)");
        c(cVar, from, a6, b6);
    }

    public static final void c(@NotNull c cVar, @NotNull b from, @NotNull String packageFqName, @NotNull String name) {
        u3.a location;
        g0.p(cVar, "<this>");
        g0.p(from, "from");
        g0.p(packageFqName, "packageFqName");
        g0.p(name, "name");
        if (cVar == c.a.f54673a || (location = from.getLocation()) == null) {
            return;
        }
        cVar.b(location.a(), cVar.a() ? location.getPosition() : Position.Companion.a(), packageFqName, ScopeKind.PACKAGE, name);
    }
}
