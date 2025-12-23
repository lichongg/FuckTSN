package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nNodes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmTypeParameter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,830:1\n1563#2:831\n1634#2,3:832\n*S KotlinDebug\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmTypeParameter\n*L\n505#1:831\n505#1:832,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private int f45315a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private String f45316b;

    /* renamed from: c, reason: collision with root package name */
    private int f45317c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private KmVariance f45318d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final List<u> f45319e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.m> f45320f;

    public w(int i6, @NotNull String name, int i7, @NotNull KmVariance variance) {
        g0.p(name, "name");
        g0.p(variance, "variance");
        this.f45315a = i6;
        this.f45316b = name;
        this.f45317c = i7;
        this.f45318d = variance;
        this.f45319e = new ArrayList(1);
        List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.p> c6 = kotlin.reflect.jvm.internal.impl.km.internal.extensions.p.f45189a.c();
        ArrayList arrayList = new ArrayList(f0.d0(c6, 10));
        Iterator<T> it = c6.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.km.internal.extensions.p) it.next()).j());
        }
        this.f45320f = arrayList;
    }

    @NotNull
    public final List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.m> a() {
        return this.f45320f;
    }

    public final int b() {
        return this.f45315a;
    }

    public final int c() {
        return this.f45317c;
    }

    @NotNull
    public final String d() {
        return this.f45316b;
    }

    @NotNull
    public final List<u> e() {
        return this.f45319e;
    }

    @NotNull
    public final KmVariance f() {
        return this.f45318d;
    }

    public final void g(int i6) {
        this.f45315a = i6;
    }
}
