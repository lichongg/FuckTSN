package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.c;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.p1;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.i2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\ntypeSignatureMapping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 typeSignatureMapping.kt\norg/jetbrains/kotlin/load/kotlin/TypeSignatureMappingKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,103:1\n1#2:104\n1761#3,3:105\n*S KotlinDebug\n*F\n+ 1 typeSignatureMapping.kt\norg/jetbrains/kotlin/load/kotlin/TypeSignatureMappingKt\n*L\n55#1:105,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j0 {
    @NotNull
    public static final <T> T a(@NotNull t<T> tVar, @NotNull T possiblyPrimitiveType, boolean z5) {
        kotlin.jvm.internal.g0.p(tVar, "<this>");
        kotlin.jvm.internal.g0.p(possiblyPrimitiveType, "possiblyPrimitiveType");
        return z5 ? tVar.c(possiblyPrimitiveType) : possiblyPrimitiveType;
    }

    @Nullable
    public static final <T> T b(@NotNull i2 i2Var, @NotNull e4.g type, @NotNull t<T> typeFactory, @NotNull i0 mode) {
        kotlin.jvm.internal.g0.p(i2Var, "<this>");
        kotlin.jvm.internal.g0.p(type, "type");
        kotlin.jvm.internal.g0.p(typeFactory, "typeFactory");
        kotlin.jvm.internal.g0.p(mode, "mode");
        e4.o X = i2Var.X(type);
        if (!i2Var.c0(X)) {
            return null;
        }
        PrimitiveType o02 = i2Var.o0(X);
        if (o02 != null) {
            return (T) a(typeFactory, typeFactory.d(o02), i2Var.j0(type) || p1.c(i2Var, type));
        }
        PrimitiveType Z = i2Var.Z(X);
        if (Z != null) {
            return typeFactory.a('[' + JvmPrimitiveType.get(Z).getDesc());
        }
        if (i2Var.z(X)) {
            kotlin.reflect.jvm.internal.impl.name.d t02 = i2Var.t0(X);
            kotlin.reflect.jvm.internal.impl.name.b n6 = t02 != null ? kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f44463a.n(t02) : null;
            if (n6 != null) {
                if (!mode.a()) {
                    List<c.a> i6 = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f44463a.i();
                    if (!(i6 instanceof Collection) || !i6.isEmpty()) {
                        Iterator<T> it = i6.iterator();
                        while (it.hasNext()) {
                            if (kotlin.jvm.internal.g0.g(((c.a) it.next()).d(), n6)) {
                                return null;
                            }
                        }
                    }
                }
                String h6 = kotlin.reflect.jvm.internal.impl.resolve.jvm.d.h(n6);
                kotlin.jvm.internal.g0.o(h6, "internalNameByClassId(...)");
                return typeFactory.f(h6);
            }
        }
        return null;
    }
}
