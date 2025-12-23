package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.collections.i1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJavaAnnotationMapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JavaAnnotationMapper.kt\norg/jetbrains/kotlin/load/java/components/JavaRetentionAnnotationDescriptor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,182:1\n1#2:183\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class l extends c {

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f45400h = {o0.u(new PropertyReference1Impl(l.class, "allValueArguments", "getAllValueArguments()Ljava/util/Map;", 0))};

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f45401g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@NotNull y3.a annotation, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.k c6) {
        super(c6, annotation, o.a.L);
        g0.p(annotation, "annotation");
        g0.p(c6, "c");
        this.f45401g = c6.e().e(new k(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map h(l lVar) {
        kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> b6 = f.f45391a.b(lVar.c());
        Map k6 = b6 != null ? i1.k(kotlin.o0.a(d.f45385a.c(), b6)) : null;
        return k6 == null ? i1.z() : k6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.c, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    @NotNull
    public Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a() {
        return (Map) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f45401g, this, f45400h[0]);
    }
}
