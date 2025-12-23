package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nReflectJavaAnnotationArguments.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaAnnotationArguments.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaArrayAnnotationArgument\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,79:1\n11228#2:80\n11563#2,3:81\n*S KotlinDebug\n*F\n+ 1 ReflectJavaAnnotationArguments.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaArrayAnnotationArgument\n*L\n48#1:80\n48#1:81,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class l extends h implements y3.e {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Object[] f45018c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Object[] values) {
        super(fVar, null);
        kotlin.jvm.internal.g0.p(values, "values");
        this.f45018c = values;
    }

    @Override // y3.e
    @NotNull
    public List<h> getElements() {
        Object[] objArr = this.f45018c;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            h.a aVar = h.f45012b;
            kotlin.jvm.internal.g0.m(obj);
            arrayList.add(aVar.a(obj, null));
        }
        return arrayList;
    }
}
