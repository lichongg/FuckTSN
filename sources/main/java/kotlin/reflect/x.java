package kotlin.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.NotImplementedError;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ExperimentalStdlibApi
@SourceDebugExtension({"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypeVariableImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,230:1\n1563#2:231\n1634#2,3:232\n37#3,2:235\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypeVariableImpl\n*L\n116#1:231\n116#1:232,3\n116#1:235,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class x implements TypeVariable<GenericDeclaration>, v {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final s f47644a;

    @NotNull
    public final Annotation[] b() {
        return new Annotation[0];
    }

    @NotNull
    public final Annotation[] c() {
        return new Annotation[0];
    }

    public x(@NotNull s typeParameter) {
        g0.p(typeParameter, "typeParameter");
        this.f47644a = typeParameter;
    }

    @Nullable
    public final <T extends Annotation> T a(@NotNull Class<T> annotationClass) {
        g0.p(annotationClass, "annotationClass");
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) obj;
        return g0.g(getName(), typeVariable.getName()) && g0.g(getGenericDeclaration(), typeVariable.getGenericDeclaration());
    }

    @Override // java.lang.reflect.TypeVariable
    @NotNull
    public Type[] getBounds() {
        Type c6;
        List<r> upperBounds = this.f47644a.getUpperBounds();
        ArrayList arrayList = new ArrayList(f0.d0(upperBounds, 10));
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            c6 = y.c((r) it.next(), true);
            arrayList.add(c6);
        }
        return (Type[]) arrayList.toArray(new Type[0]);
    }

    @Override // java.lang.reflect.TypeVariable
    @NotNull
    public GenericDeclaration getGenericDeclaration() {
        throw new NotImplementedError("An operation is not implemented: " + ("getGenericDeclaration() is not yet supported for type variables created from KType: " + this.f47644a));
    }

    @Override // java.lang.reflect.TypeVariable
    @NotNull
    public String getName() {
        return this.f47644a.getName();
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.v
    @NotNull
    public String getTypeName() {
        return getName();
    }

    public int hashCode() {
        return getName().hashCode() ^ getGenericDeclaration().hashCode();
    }

    @NotNull
    public String toString() {
        return getTypeName();
    }
}
