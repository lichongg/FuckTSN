package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nNodes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmTypeAlias\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,830:1\n1617#2,9:831\n1869#2:840\n1870#2:842\n1626#2:843\n1#3:841\n*S KotlinDebug\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmTypeAlias\n*L\n435#1:831,9\n435#1:840\n435#1:842\n435#1:843\n435#1:841\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    private int f45307a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private String f45308b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<w> f45309c;

    /* renamed from: d, reason: collision with root package name */
    public u f45310d;

    /* renamed from: e, reason: collision with root package name */
    public u f45311e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final List<d> f45312f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final List<a0> f45313g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.k> f45314h;

    public v(int i6, @NotNull String name) {
        g0.p(name, "name");
        this.f45307a = i6;
        this.f45308b = name;
        this.f45309c = new ArrayList(0);
        this.f45312f = new ArrayList(0);
        this.f45313g = new ArrayList(0);
        List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.p> c6 = kotlin.reflect.jvm.internal.impl.km.internal.extensions.p.f45189a.c();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = c6.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.km.internal.extensions.k a6 = ((kotlin.reflect.jvm.internal.impl.km.internal.extensions.p) it.next()).a();
            if (a6 != null) {
                arrayList.add(a6);
            }
        }
        this.f45314h = arrayList;
    }

    @NotNull
    public final List<d> a() {
        return this.f45312f;
    }

    public final int b() {
        return this.f45307a;
    }

    @NotNull
    public final List<w> c() {
        return this.f45309c;
    }

    @NotNull
    public final List<a0> d() {
        return this.f45313g;
    }

    public final void e(@NotNull u uVar) {
        g0.p(uVar, "<set-?>");
        this.f45311e = uVar;
    }

    public final void f(int i6) {
        this.f45307a = i6;
    }

    public final void g(@NotNull u uVar) {
        g0.p(uVar, "<set-?>");
        this.f45310d = uVar;
    }
}
