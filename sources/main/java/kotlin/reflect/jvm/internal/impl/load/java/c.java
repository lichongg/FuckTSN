package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nAnnotationTypeQualifierResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnotationTypeQualifierResolver.kt\norg/jetbrains/kotlin/load/java/AnnotationTypeQualifierResolver\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,57:1\n77#2:58\n97#2,5:59\n1374#3:64\n1460#3,5:65\n*S KotlinDebug\n*F\n+ 1 AnnotationTypeQualifierResolver.kt\norg/jetbrains/kotlin/load/java/AnnotationTypeQualifierResolver\n*L\n43#1:58\n43#1:59,5\n52#1:64\n52#1:65,5\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c extends b<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> {
    @Override // kotlin.reflect.jvm.internal.impl.load.java.b
    public boolean o() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull d0 javaTypeEnhancementState) {
        super(javaTypeEnhancementState);
        kotlin.jvm.internal.g0.p(javaTypeEnhancementState, "javaTypeEnhancementState");
    }

    private final List<String> B(kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar) {
        if (!(gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.b)) {
            return gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.k ? kotlin.collections.f0.l(((kotlin.reflect.jvm.internal.impl.resolve.constants.k) gVar).b().getIdentifier()) : kotlin.collections.f0.J();
        }
        List<? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a6 = ((kotlin.reflect.jvm.internal.impl.resolve.constants.b) gVar).a();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = a6.iterator();
        while (it.hasNext()) {
            kotlin.collections.f0.s0(arrayList, B((kotlin.reflect.jvm.internal.impl.resolve.constants.g) it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.b
    @NotNull
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public Iterable<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> m(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g annotations;
        kotlin.jvm.internal.g0.p(cVar, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.d l6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.l(cVar);
        return (l6 == null || (annotations = l6.getAnnotations()) == null) ? kotlin.collections.f0.J() : annotations;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.b
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public Iterable<String> c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar, boolean z5) {
        kotlin.jvm.internal.g0.p(cVar, "<this>");
        Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a6 = cVar.a();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> entry : a6.entrySet()) {
            kotlin.collections.f0.s0(arrayList, (!z5 || kotlin.jvm.internal.g0.g(entry.getKey(), i0.f45448c)) ? B(entry.getValue()) : kotlin.collections.f0.J());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.b
    @Nullable
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.name.c k(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        kotlin.jvm.internal.g0.p(cVar, "<this>");
        return cVar.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.b
    @NotNull
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object l(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        kotlin.jvm.internal.g0.p(cVar, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.d l6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.l(cVar);
        kotlin.jvm.internal.g0.m(l6);
        return l6;
    }
}
