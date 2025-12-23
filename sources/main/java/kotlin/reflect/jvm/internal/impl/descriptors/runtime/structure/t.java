package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nReflectJavaConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaConstructor.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaConstructor\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,51:1\n11228#2:52\n11563#2,3:53\n*S KotlinDebug\n*F\n+ 1 ReflectJavaConstructor.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaConstructor\n*L\n49#1:52\n49#1:53,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class t extends y implements y3.k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Constructor<?> f45035a;

    public t(@NotNull Constructor<?> member) {
        kotlin.jvm.internal.g0.p(member, "member");
        this.f45035a = member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.y
    @NotNull
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public Constructor<?> N() {
        return this.f45035a;
    }

    @Override // y3.k
    @NotNull
    public List<y3.b0> g() {
        Type[] genericParameterTypes = N().getGenericParameterTypes();
        kotlin.jvm.internal.g0.m(genericParameterTypes);
        if (genericParameterTypes.length == 0) {
            return kotlin.collections.f0.J();
        }
        Class<?> declaringClass = N().getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            genericParameterTypes = (Type[]) kotlin.collections.n.l1(genericParameterTypes, 1, genericParameterTypes.length);
        }
        Annotation[][] parameterAnnotations = N().getParameterAnnotations();
        if (parameterAnnotations.length >= genericParameterTypes.length) {
            if (parameterAnnotations.length > genericParameterTypes.length) {
                kotlin.jvm.internal.g0.m(parameterAnnotations);
                parameterAnnotations = (Annotation[][]) kotlin.collections.n.l1(parameterAnnotations, parameterAnnotations.length - genericParameterTypes.length, parameterAnnotations.length);
            }
            kotlin.jvm.internal.g0.m(genericParameterTypes);
            kotlin.jvm.internal.g0.m(parameterAnnotations);
            return O(genericParameterTypes, parameterAnnotations, N().isVarArgs());
        }
        throw new IllegalStateException("Illegal generic signature: " + N());
    }

    @Override // y3.z
    @NotNull
    public List<f0> getTypeParameters() {
        TypeVariable<Constructor<?>>[] typeParameters = N().getTypeParameters();
        kotlin.jvm.internal.g0.o(typeParameters, "getTypeParameters(...)");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Constructor<?>> typeVariable : typeParameters) {
            arrayList.add(new f0(typeVariable));
        }
        return arrayList;
    }
}
