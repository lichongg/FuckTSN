package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nReflectJavaTypeParameter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaTypeParameter.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaTypeParameter\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,50:1\n11228#2:51\n11563#2,3:52\n*S KotlinDebug\n*F\n+ 1 ReflectJavaTypeParameter.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaTypeParameter\n*L\n29#1:51\n29#1:52,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class f0 extends u implements j, y3.y {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final TypeVariable<?> f45006a;

    @Override // y3.d
    public /* bridge */ /* synthetic */ y3.a b(kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return b(cVar);
    }

    @Override // y3.d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // y3.d
    public boolean s() {
        return false;
    }

    public f0(@NotNull TypeVariable<?> typeVariable) {
        kotlin.jvm.internal.g0.p(typeVariable, "typeVariable");
        this.f45006a = typeVariable;
    }

    @Override // y3.y
    @NotNull
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public List<s> getUpperBounds() {
        Type[] bounds = this.f45006a.getBounds();
        kotlin.jvm.internal.g0.o(bounds, "getBounds(...)");
        ArrayList arrayList = new ArrayList(bounds.length);
        for (Type type : bounds) {
            arrayList.add(new s(type));
        }
        s sVar = (s) kotlin.collections.f0.p5(arrayList);
        return kotlin.jvm.internal.g0.g(sVar != null ? sVar.M() : null, Object.class) ? kotlin.collections.f0.J() : arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.j, y3.d
    @Nullable
    public g b(kotlin.reflect.jvm.internal.impl.name.c fqName) {
        Annotation[] declaredAnnotations;
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        AnnotatedElement element = getElement();
        if (element == null || (declaredAnnotations = element.getDeclaredAnnotations()) == null) {
            return null;
        }
        return k.a(declaredAnnotations, fqName);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof f0) && kotlin.jvm.internal.g0.g(this.f45006a, ((f0) obj).f45006a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.j, y3.d
    @NotNull
    public List<g> getAnnotations() {
        Annotation[] declaredAnnotations;
        List<g> b6;
        AnnotatedElement element = getElement();
        return (element == null || (declaredAnnotations = element.getDeclaredAnnotations()) == null || (b6 = k.b(declaredAnnotations)) == null) ? kotlin.collections.f0.J() : b6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.j
    @Nullable
    public AnnotatedElement getElement() {
        TypeVariable<?> typeVariable = this.f45006a;
        if (typeVariable instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable;
        }
        return null;
    }

    @Override // y3.t
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.f getName() {
        kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(this.f45006a.getName());
        kotlin.jvm.internal.g0.o(h6, "identifier(...)");
        return h6;
    }

    public int hashCode() {
        return this.f45006a.hashCode();
    }

    @NotNull
    public String toString() {
        return f0.class.getName() + ": " + this.f45006a;
    }
}
