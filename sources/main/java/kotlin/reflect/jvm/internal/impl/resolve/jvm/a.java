package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.k0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.k;
import kotlin.reflect.jvm.internal.impl.name.f;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSyntheticJavaPartsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SyntheticJavaPartsProvider.kt\norg/jetbrains/kotlin/resolve/jvm/CompositeSyntheticJavaPartsProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,108:1\n1374#2:109\n1460#2,5:110\n1869#2,2:115\n1374#2:117\n1460#2,5:118\n1869#2,2:123\n1869#2,2:125\n1374#2:127\n1460#2,5:128\n1869#2,2:133\n1803#2,3:135\n*S KotlinDebug\n*F\n+ 1 SyntheticJavaPartsProvider.kt\norg/jetbrains/kotlin/resolve/jvm/CompositeSyntheticJavaPartsProvider\n*L\n55#1:109\n55#1:110,5\n64#1:115,2\n68#1:117\n68#1:118,5\n76#1:123,2\n84#1:125,2\n88#1:127\n88#1:128,5\n97#1:133,2\n105#1:135,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a implements e {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<e> f46713b;

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull List<? extends e> inner) {
        g0.p(inner, "inner");
        this.f46713b = inner;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.e
    public void a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d thisDescriptor, @NotNull List<kotlin.reflect.jvm.internal.impl.descriptors.c> result, @NotNull k c6) {
        g0.p(thisDescriptor, "thisDescriptor");
        g0.p(result, "result");
        g0.p(c6, "c");
        Iterator<T> it = this.f46713b.iterator();
        while (it.hasNext()) {
            ((e) it.next()).a(thisDescriptor, result, c6);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.e
    @NotNull
    public k0 b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d thisDescriptor, @NotNull k0 propertyDescriptor, @NotNull k c6) {
        g0.p(thisDescriptor, "thisDescriptor");
        g0.p(propertyDescriptor, "propertyDescriptor");
        g0.p(c6, "c");
        Iterator<T> it = this.f46713b.iterator();
        while (it.hasNext()) {
            propertyDescriptor = ((e) it.next()).b(thisDescriptor, propertyDescriptor, c6);
        }
        return propertyDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.e
    @NotNull
    public List<f> c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d thisDescriptor, @NotNull k c6) {
        g0.p(thisDescriptor, "thisDescriptor");
        g0.p(c6, "c");
        List<e> list = this.f46713b;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            f0.s0(arrayList, ((e) it.next()).c(thisDescriptor, c6));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.e
    @NotNull
    public List<f> d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d thisDescriptor, @NotNull k c6) {
        g0.p(thisDescriptor, "thisDescriptor");
        g0.p(c6, "c");
        List<e> list = this.f46713b;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            f0.s0(arrayList, ((e) it.next()).d(thisDescriptor, c6));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.e
    public void e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d thisDescriptor, @NotNull f name, @NotNull Collection<d1> result, @NotNull k c6) {
        g0.p(thisDescriptor, "thisDescriptor");
        g0.p(name, "name");
        g0.p(result, "result");
        g0.p(c6, "c");
        Iterator<T> it = this.f46713b.iterator();
        while (it.hasNext()) {
            ((e) it.next()).e(thisDescriptor, name, result, c6);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.e
    public void f(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d thisDescriptor, @NotNull f name, @NotNull Collection<d1> result, @NotNull k c6) {
        g0.p(thisDescriptor, "thisDescriptor");
        g0.p(name, "name");
        g0.p(result, "result");
        g0.p(c6, "c");
        Iterator<T> it = this.f46713b.iterator();
        while (it.hasNext()) {
            ((e) it.next()).f(thisDescriptor, name, result, c6);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.e
    @NotNull
    public List<f> g(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d thisDescriptor, @NotNull k c6) {
        g0.p(thisDescriptor, "thisDescriptor");
        g0.p(c6, "c");
        List<e> list = this.f46713b;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            f0.s0(arrayList, ((e) it.next()).g(thisDescriptor, c6));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.jvm.e
    public void h(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d thisDescriptor, @NotNull f name, @NotNull List<kotlin.reflect.jvm.internal.impl.descriptors.d> result, @NotNull k c6) {
        g0.p(thisDescriptor, "thisDescriptor");
        g0.p(name, "name");
        g0.p(result, "result");
        g0.p(c6, "c");
        Iterator<T> it = this.f46713b.iterator();
        while (it.hasNext()) {
            ((e) it.next()).h(thisDescriptor, name, result, c6);
        }
    }
}
