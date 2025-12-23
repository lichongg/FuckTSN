package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nReflectJavaAnnotation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaAnnotation.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaAnnotation\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,43:1\n11228#2:44\n11563#2,3:45\n*S KotlinDebug\n*F\n+ 1 ReflectJavaAnnotation.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaAnnotation\n*L\n26#1:44\n26#1:45,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g extends u implements y3.a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Annotation f45007a;

    @Override // y3.a
    public boolean e() {
        return false;
    }

    @Override // y3.a
    public boolean u() {
        return false;
    }

    public g(@NotNull Annotation annotation) {
        kotlin.jvm.internal.g0.p(annotation, "annotation");
        this.f45007a = annotation;
    }

    @NotNull
    public final Annotation M() {
        return this.f45007a;
    }

    @Override // y3.a
    @NotNull
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public q D() {
        return new q(l3.a.e(l3.a.a(this.f45007a)));
    }

    @Override // y3.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.b c() {
        return f.e(l3.a.e(l3.a.a(this.f45007a)));
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof g) && this.f45007a == ((g) obj).f45007a;
    }

    @Override // y3.a
    @NotNull
    public Collection<y3.b> getArguments() {
        Method[] declaredMethods = l3.a.e(l3.a.a(this.f45007a)).getDeclaredMethods();
        kotlin.jvm.internal.g0.o(declaredMethods, "getDeclaredMethods(...)");
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            h.a aVar = h.f45012b;
            Object invoke = method.invoke(this.f45007a, null);
            kotlin.jvm.internal.g0.o(invoke, "invoke(...)");
            arrayList.add(aVar.a(invoke, kotlin.reflect.jvm.internal.impl.name.f.h(method.getName())));
        }
        return arrayList;
    }

    public int hashCode() {
        return System.identityHashCode(this.f45007a);
    }

    @NotNull
    public String toString() {
        return g.class.getName() + ": " + this.f45007a;
    }
}
