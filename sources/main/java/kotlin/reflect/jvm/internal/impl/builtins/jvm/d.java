package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.Collection;
import kotlin.collections.f0;
import kotlin.collections.u1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJavaToKotlinClassMapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaToKotlinClassMapper.kt\norg/jetbrains/kotlin/builtins/jvm/JavaToKotlinClassMapper\n*L\n1#1,80:1\n75#1,3:81\n75#1,3:84\n*S KotlinDebug\n*F\n+ 1 JavaToKotlinClassMapper.kt\norg/jetbrains/kotlin/builtins/jvm/JavaToKotlinClassMapper\n*L\n59#1:81,3\n65#1:84,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f44483a = new d();

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.d f(d dVar, kotlin.reflect.jvm.internal.impl.name.c cVar, kotlin.reflect.jvm.internal.impl.builtins.j jVar, Integer num, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            num = null;
        }
        return dVar.e(cVar, jVar, num);
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.d a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d mutable) {
        g0.p(mutable, "mutable");
        kotlin.reflect.jvm.internal.impl.name.c o5 = c.f44463a.o(kotlin.reflect.jvm.internal.impl.resolve.i.m(mutable));
        if (o5 != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.d p5 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.m(mutable).p(o5);
            g0.o(p5, "getBuiltInClassByFqName(...)");
            return p5;
        }
        throw new IllegalArgumentException("Given class " + mutable + " is not a mutable collection");
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.d b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d readOnly) {
        g0.p(readOnly, "readOnly");
        kotlin.reflect.jvm.internal.impl.name.c p5 = c.f44463a.p(kotlin.reflect.jvm.internal.impl.resolve.i.m(readOnly));
        if (p5 != null) {
            kotlin.reflect.jvm.internal.impl.descriptors.d p6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.m(readOnly).p(p5);
            g0.o(p6, "getBuiltInClassByFqName(...)");
            return p6;
        }
        throw new IllegalArgumentException("Given class " + readOnly + " is not a read-only collection");
    }

    public final boolean c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d mutable) {
        g0.p(mutable, "mutable");
        return c.f44463a.k(kotlin.reflect.jvm.internal.impl.resolve.i.m(mutable));
    }

    public final boolean d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d readOnly) {
        g0.p(readOnly, "readOnly");
        return c.f44463a.l(kotlin.reflect.jvm.internal.impl.resolve.i.m(readOnly));
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.descriptors.d e(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull kotlin.reflect.jvm.internal.impl.builtins.j builtIns, @Nullable Integer num) {
        g0.p(fqName, "fqName");
        g0.p(builtIns, "builtIns");
        kotlin.reflect.jvm.internal.impl.name.b m6 = (num == null || !g0.g(fqName, c.f44463a.h())) ? c.f44463a.m(fqName) : kotlin.reflect.jvm.internal.impl.builtins.o.a(num.intValue());
        if (m6 != null) {
            return builtIns.p(m6.a());
        }
        return null;
    }

    @NotNull
    public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> g(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull kotlin.reflect.jvm.internal.impl.builtins.j builtIns) {
        g0.p(fqName, "fqName");
        g0.p(builtIns, "builtIns");
        kotlin.reflect.jvm.internal.impl.descriptors.d f6 = f(this, fqName, builtIns, null, 4, null);
        if (f6 == null) {
            return u1.k();
        }
        kotlin.reflect.jvm.internal.impl.name.c p5 = c.f44463a.p(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.p(f6));
        return p5 == null ? u1.f(f6) : f0.Q(f6, builtIns.p(p5));
    }

    private d() {
    }
}
