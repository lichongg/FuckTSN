package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nReflectJavaMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaMethod.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaMethod\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,37:1\n1#2:38\n11228#3:39\n11563#3,3:40\n*S KotlinDebug\n*F\n+ 1 ReflectJavaMethod.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaMethod\n*L\n35#1:39\n35#1:40,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class z extends y implements y3.r {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Method f45039a;

    public z(@NotNull Method member) {
        kotlin.jvm.internal.g0.p(member, "member");
        this.f45039a = member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.y
    @NotNull
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public Method N() {
        return this.f45039a;
    }

    @Override // y3.r
    @NotNull
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public e0 getReturnType() {
        e0.a aVar = e0.f45001a;
        Type genericReturnType = N().getGenericReturnType();
        kotlin.jvm.internal.g0.o(genericReturnType, "getGenericReturnType(...)");
        return aVar.a(genericReturnType);
    }

    @Override // y3.r
    public boolean K() {
        if (l() != null) {
            return true;
        }
        return false;
    }

    @Override // y3.r
    @NotNull
    public List<y3.b0> g() {
        Type[] genericParameterTypes = N().getGenericParameterTypes();
        kotlin.jvm.internal.g0.o(genericParameterTypes, "getGenericParameterTypes(...)");
        Annotation[][] parameterAnnotations = N().getParameterAnnotations();
        kotlin.jvm.internal.g0.o(parameterAnnotations, "getParameterAnnotations(...)");
        return O(genericParameterTypes, parameterAnnotations, N().isVarArgs());
    }

    @Override // y3.z
    @NotNull
    public List<f0> getTypeParameters() {
        TypeVariable<Method>[] typeParameters = N().getTypeParameters();
        kotlin.jvm.internal.g0.o(typeParameters, "getTypeParameters(...)");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Method> typeVariable : typeParameters) {
            arrayList.add(new f0(typeVariable));
        }
        return arrayList;
    }

    @Override // y3.r
    @Nullable
    public y3.b l() {
        Object defaultValue = N().getDefaultValue();
        if (defaultValue == null) {
            return null;
        }
        return h.f45012b.a(defaultValue, null);
    }
}
