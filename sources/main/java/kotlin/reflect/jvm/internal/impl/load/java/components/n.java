package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.collections.f0;
import kotlin.collections.i1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJavaAnnotationMapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaAnnotationMapper.kt\norg/jetbrains/kotlin/load/java/components/JavaTargetAnnotationDescriptor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,182:1\n1#2:183\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n extends c {

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f45403h = {o0.u(new PropertyReference1Impl(n.class, "allValueArguments", "getAllValueArguments()Ljava/util/Map;", 0))};

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f45404g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@NotNull y3.a annotation, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.k c6) {
        super(c6, annotation, o.a.H);
        g0.p(annotation, "annotation");
        g0.p(c6, "c");
        this.f45404g = c6.e().e(new m(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.c, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<Object>> a() {
        return (Map) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f45404g, this, f45403h[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map h(n nVar) {
        kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar;
        y3.b c6 = nVar.c();
        Map map = null;
        if (c6 instanceof y3.e) {
            gVar = f.f45391a.d(((y3.e) nVar.c()).getElements());
        } else if (c6 instanceof y3.m) {
            gVar = f.f45391a.d(f0.l(nVar.c()));
        } else {
            gVar = null;
        }
        if (gVar != null) {
            map = i1.k(kotlin.o0.a(d.f45385a.d(), gVar));
        }
        if (map == null) {
            return i1.z();
        }
        return map;
    }
}
