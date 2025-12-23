package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nReflectJavaAnnotationOwner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaAnnotationOwner.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaAnnotationOwnerKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,43:1\n11228#2:44\n11563#2,3:45\n1310#2,2:48\n1#3:50\n*S KotlinDebug\n*F\n+ 1 ReflectJavaAnnotationOwner.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaAnnotationOwnerKt\n*L\n37#1:44\n37#1:45,3\n41#1:48,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class k {
    @Nullable
    public static final g a(@NotNull Annotation[] annotationArr, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        Annotation annotation;
        kotlin.jvm.internal.g0.p(annotationArr, "<this>");
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        int length = annotationArr.length;
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                annotation = null;
                break;
            }
            annotation = annotationArr[i6];
            if (kotlin.jvm.internal.g0.g(f.e(l3.a.e(l3.a.a(annotation))).a(), fqName)) {
                break;
            }
            i6++;
        }
        if (annotation != null) {
            return new g(annotation);
        }
        return null;
    }

    @NotNull
    public static final List<g> b(@NotNull Annotation[] annotationArr) {
        kotlin.jvm.internal.g0.p(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(new g(annotation));
        }
        return arrayList;
    }
}
