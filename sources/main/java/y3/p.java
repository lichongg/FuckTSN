package y3;

import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class p {
    public static final boolean c(@NotNull q qVar) {
        g0.p(qVar, "<this>");
        return qVar.y().I() && (qVar instanceof r) && b((r) qVar);
    }

    private static final boolean a(r rVar) {
        x xVar;
        kotlin.reflect.jvm.internal.impl.name.c d6;
        b0 b0Var = (b0) f0.p5(rVar.g());
        j jVar = null;
        if (b0Var != null) {
            xVar = b0Var.getType();
        } else {
            xVar = null;
        }
        if (xVar instanceof j) {
            jVar = (j) xVar;
        }
        if (jVar == null) {
            return false;
        }
        i n6 = jVar.n();
        if (!(n6 instanceof g) || (d6 = ((g) n6).d()) == null || !g0.g(d6.a(), "java.lang.Object")) {
            return false;
        }
        return true;
    }

    private static final boolean b(r rVar) {
        String b6 = rVar.getName().b();
        int hashCode = b6.hashCode();
        if (hashCode != -1776922004) {
            if (hashCode != -1295482945) {
                if (hashCode != 147696667 || !b6.equals("hashCode")) {
                    return false;
                }
            } else {
                if (b6.equals("equals")) {
                    return a(rVar);
                }
                return false;
            }
        } else if (!b6.equals("toString")) {
            return false;
        }
        return rVar.g().isEmpty();
    }
}
