package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nNodes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmConstructor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,830:1\n1563#2:831\n1634#2,3:832\n*S KotlinDebug\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmConstructor\n*L\n199#1:831\n199#1:832,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private int f45209a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<y> f45210b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<a0> f45211c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final List<d> f45212d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.c> f45213e;

    public j(int i6) {
        this.f45209a = i6;
        this.f45210b = new ArrayList();
        this.f45211c = new ArrayList(0);
        this.f45212d = new ArrayList(0);
        List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.p> c6 = kotlin.reflect.jvm.internal.impl.km.internal.extensions.p.f45189a.c();
        ArrayList arrayList = new ArrayList(f0.d0(c6, 10));
        Iterator<T> it = c6.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.km.internal.extensions.p) it.next()).f());
        }
        this.f45213e = arrayList;
    }

    @NotNull
    public final List<d> a() {
        return this.f45212d;
    }

    @NotNull
    public final List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.c> b() {
        return this.f45213e;
    }

    public final int c() {
        return this.f45209a;
    }

    @NotNull
    public final List<y> d() {
        return this.f45210b;
    }

    @NotNull
    public final List<a0> e() {
        return this.f45211c;
    }

    public final void f(int i6) {
        this.f45209a = i6;
    }

    public j() {
        this(0);
    }
}
