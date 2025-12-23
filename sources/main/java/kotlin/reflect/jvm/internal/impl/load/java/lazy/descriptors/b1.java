package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLazyJavaTypeParameterDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaTypeParameterDescriptor.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaTypeParameterDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,75:1\n1563#2:76\n1634#2,3:77\n*S KotlinDebug\n*F\n+ 1 LazyJavaTypeParameterDescriptor.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaTypeParameterDescriptor\n*L\n62#1:76\n62#1:77,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b1 extends kotlin.reflect.jvm.internal.impl.descriptors.impl.b {

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.k f45537k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private final y3.y f45538l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b1(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.k c6, @NotNull y3.y javaTypeParameter, int i6, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k containingDeclaration) {
        super(c6.e(), containingDeclaration, new kotlin.reflect.jvm.internal.impl.load.java.lazy.g(c6, javaTypeParameter, false, 4, null), javaTypeParameter.getName(), Variance.INVARIANT, false, i6, e1.f44683a, c6.a().v());
        kotlin.jvm.internal.g0.p(c6, "c");
        kotlin.jvm.internal.g0.p(javaTypeParameter, "javaTypeParameter");
        kotlin.jvm.internal.g0.p(containingDeclaration, "containingDeclaration");
        this.f45537k = c6;
        this.f45538l = javaTypeParameter;
    }

    private final List<kotlin.reflect.jvm.internal.impl.types.t0> H0() {
        Collection<y3.j> upperBounds = this.f45538l.getUpperBounds();
        if (upperBounds.isEmpty()) {
            kotlin.reflect.jvm.internal.impl.types.e1 i6 = this.f45537k.d().p().i();
            kotlin.jvm.internal.g0.o(i6, "getAnyType(...)");
            kotlin.reflect.jvm.internal.impl.types.e1 J = this.f45537k.d().p().J();
            kotlin.jvm.internal.g0.o(J, "getNullableAnyType(...)");
            return kotlin.collections.f0.l(kotlin.reflect.jvm.internal.impl.types.w0.e(i6, J));
        }
        Collection<y3.j> collection = upperBounds;
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f45537k.g().p((y3.j) it.next(), kotlin.reflect.jvm.internal.impl.load.java.lazy.types.b.b(TypeUsage.COMMON, false, false, this, 3, null)));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.h
    @NotNull
    protected List<kotlin.reflect.jvm.internal.impl.types.t0> E0(@NotNull List<? extends kotlin.reflect.jvm.internal.impl.types.t0> bounds) {
        kotlin.jvm.internal.g0.p(bounds, "bounds");
        return this.f45537k.a().r().r(this, bounds, this.f45537k);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.h
    protected void F0(@NotNull kotlin.reflect.jvm.internal.impl.types.t0 type) {
        kotlin.jvm.internal.g0.p(type, "type");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.h
    @NotNull
    protected List<kotlin.reflect.jvm.internal.impl.types.t0> G0() {
        return H0();
    }
}
