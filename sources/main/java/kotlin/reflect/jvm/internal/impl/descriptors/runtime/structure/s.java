package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nReflectJavaClassifierType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaClassifierType.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaClassifierType\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,64:1\n1#2:65\n1563#3:66\n1634#3,3:67\n*S KotlinDebug\n*F\n+ 1 ReflectJavaClassifierType.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaClassifierType\n*L\n50#1:66\n50#1:67,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class s extends e0 implements y3.j {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Type f45033b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final y3.i f45034c;

    @Override // y3.d
    public boolean s() {
        return false;
    }

    public s(@NotNull Type reflectType) {
        y3.i qVar;
        kotlin.jvm.internal.g0.p(reflectType, "reflectType");
        this.f45033b = reflectType;
        Type M = M();
        if (M instanceof Class) {
            qVar = new q((Class) M);
        } else if (M instanceof TypeVariable) {
            qVar = new f0((TypeVariable) M);
        } else {
            if (!(M instanceof ParameterizedType)) {
                throw new IllegalStateException("Not a classifier type (" + M.getClass() + "): " + M);
            }
            Type rawType = ((ParameterizedType) M).getRawType();
            kotlin.jvm.internal.g0.n(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            qVar = new q((Class) rawType);
        }
        this.f45034c = qVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.e0
    @NotNull
    public Type M() {
        return this.f45033b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.e0, y3.d
    @Nullable
    public y3.a b(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        return null;
    }

    @Override // y3.j
    @NotNull
    public y3.i n() {
        return this.f45034c;
    }

    @Override // y3.j
    @NotNull
    public String v() {
        throw new UnsupportedOperationException("Type not found: " + M());
    }

    @Override // y3.j
    public boolean C() {
        boolean z5;
        Type M = M();
        if (M instanceof Class) {
            TypeVariable[] typeParameters = ((Class) M).getTypeParameters();
            kotlin.jvm.internal.g0.o(typeParameters, "getTypeParameters(...)");
            if (typeParameters.length == 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (!z5) {
                return true;
            }
        }
        return false;
    }

    @Override // y3.d
    @NotNull
    public Collection<y3.a> getAnnotations() {
        return kotlin.collections.f0.J();
    }

    @Override // y3.j
    @NotNull
    public List<y3.x> p() {
        List<Type> h6 = f.h(M());
        e0.a aVar = e0.f45001a;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(h6, 10));
        Iterator<T> it = h6.iterator();
        while (it.hasNext()) {
            arrayList.add(aVar.a((Type) it.next()));
        }
        return arrayList;
    }

    @Override // y3.j
    @NotNull
    public String t() {
        return M().toString();
    }
}
