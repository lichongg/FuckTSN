package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.i1;
import kotlin.collections.u1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.o0;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinRetention;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJavaAnnotationMapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaAnnotationMapper.kt\norg/jetbrains/kotlin/load/java/components/JavaAnnotationTargetMapper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,182:1\n808#2,11:183\n1374#2:194\n1460#2,5:195\n1563#2:200\n1634#2,3:201\n*S KotlinDebug\n*F\n+ 1 JavaAnnotationMapper.kt\norg/jetbrains/kotlin/load/java/components/JavaAnnotationTargetMapper\n*L\n153#1:183,11\n154#1:194\n154#1:195,5\n155#1:200\n155#1:201,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f45391a = new f();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Map<String, EnumSet<KotlinTarget>> f45392b = i1.W(o0.a("PACKAGE", EnumSet.noneOf(KotlinTarget.class)), o0.a("TYPE", EnumSet.of(KotlinTarget.CLASS, KotlinTarget.FILE)), o0.a("ANNOTATION_TYPE", EnumSet.of(KotlinTarget.ANNOTATION_CLASS)), o0.a("TYPE_PARAMETER", EnumSet.of(KotlinTarget.TYPE_PARAMETER)), o0.a("FIELD", EnumSet.of(KotlinTarget.FIELD)), o0.a("LOCAL_VARIABLE", EnumSet.of(KotlinTarget.LOCAL_VARIABLE)), o0.a("PARAMETER", EnumSet.of(KotlinTarget.VALUE_PARAMETER)), o0.a("CONSTRUCTOR", EnumSet.of(KotlinTarget.CONSTRUCTOR)), o0.a("METHOD", EnumSet.of(KotlinTarget.FUNCTION, KotlinTarget.PROPERTY_GETTER, KotlinTarget.PROPERTY_SETTER)), o0.a("TYPE_USE", EnumSet.of(KotlinTarget.TYPE)));

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Map<String, KotlinRetention> f45393c = i1.W(o0.a("RUNTIME", KotlinRetention.RUNTIME), o0.a("CLASS", KotlinRetention.BINARY), o0.a("SOURCE", KotlinRetention.SOURCE));

    /* JADX INFO: Access modifiers changed from: private */
    public static final t0 e(f0 module) {
        t0 type;
        g0.p(module, "module");
        q1 b6 = a.b(d.f45385a.d(), module.p().p(o.a.H));
        return (b6 == null || (type = b6.getType()) == null) ? kotlin.reflect.jvm.internal.impl.types.error.i.d(ErrorTypeKind.UNMAPPED_ANNOTATION_TARGET_TYPE, new String[0]) : type;
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> b(@Nullable y3.b bVar) {
        y3.m mVar = bVar instanceof y3.m ? (y3.m) bVar : null;
        if (mVar != null) {
            Map<String, KotlinRetention> map = f45393c;
            kotlin.reflect.jvm.internal.impl.name.f d6 = mVar.d();
            KotlinRetention kotlinRetention = map.get(d6 != null ? d6.b() : null);
            if (kotlinRetention != null) {
                kotlin.reflect.jvm.internal.impl.name.b c6 = kotlin.reflect.jvm.internal.impl.name.b.f46334d.c(o.a.K);
                kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(kotlinRetention.name());
                g0.o(h6, "identifier(...)");
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.k(c6, h6);
            }
        }
        return null;
    }

    @NotNull
    public final Set<KotlinTarget> c(@Nullable String str) {
        EnumSet<KotlinTarget> enumSet = f45392b.get(str);
        return enumSet != null ? enumSet : u1.k();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> d(@NotNull List<? extends y3.b> arguments) {
        g0.p(arguments, "arguments");
        ArrayList<y3.m> arrayList = new ArrayList();
        for (Object obj : arguments) {
            if (obj instanceof y3.m) {
                arrayList.add(obj);
            }
        }
        ArrayList<KotlinTarget> arrayList2 = new ArrayList();
        for (y3.m mVar : arrayList) {
            f fVar = f45391a;
            kotlin.reflect.jvm.internal.impl.name.f d6 = mVar.d();
            kotlin.collections.f0.s0(arrayList2, fVar.c(d6 != null ? d6.b() : null));
        }
        ArrayList arrayList3 = new ArrayList(kotlin.collections.f0.d0(arrayList2, 10));
        for (KotlinTarget kotlinTarget : arrayList2) {
            kotlin.reflect.jvm.internal.impl.name.b c6 = kotlin.reflect.jvm.internal.impl.name.b.f46334d.c(o.a.J);
            kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(kotlinTarget.name());
            g0.o(h6, "identifier(...)");
            arrayList3.add(new kotlin.reflect.jvm.internal.impl.resolve.constants.k(c6, h6));
        }
        return new kotlin.reflect.jvm.internal.impl.resolve.constants.b(arrayList3, e.f45390a);
    }

    private f() {
    }
}
