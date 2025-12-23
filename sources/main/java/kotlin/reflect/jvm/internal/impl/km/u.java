package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nNodes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmType\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,830:1\n1563#2:831\n1634#2,3:832\n*S KotlinDebug\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmType\n*L\n579#1:831\n579#1:832,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    private int f45300a;

    /* renamed from: b, reason: collision with root package name */
    public h f45301b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<x> f45302c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private u f45303d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private u f45304e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private p f45305f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.l> f45306g;

    public u(int i6) {
        this.f45300a = i6;
        this.f45302c = new ArrayList(0);
        List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.p> c6 = kotlin.reflect.jvm.internal.impl.km.internal.extensions.p.f45189a.c();
        ArrayList arrayList = new ArrayList(f0.d0(c6, 10));
        Iterator<T> it = c6.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.km.internal.extensions.p) it.next()).h());
        }
        this.f45306g = arrayList;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!g0.g(u.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        g0.n(obj, "null cannot be cast to non-null type kotlin.metadata.KmType");
        u uVar = (u) obj;
        return this.f45300a == uVar.f45300a && g0.g(c(), uVar.c()) && g0.g(this.f45302c, uVar.f45302c) && g0.g(this.f45304e, uVar.f45304e) && g0.g(this.f45303d, uVar.f45303d) && g0.g(this.f45305f, uVar.f45305f) && g0.g(this.f45306g, uVar.f45306g);
    }

    @Nullable
    public final u a() {
        return this.f45303d;
    }

    @NotNull
    public final List<x> b() {
        return this.f45302c;
    }

    @NotNull
    public final h c() {
        h hVar = this.f45301b;
        if (hVar != null) {
            return hVar;
        }
        g0.S("classifier");
        return null;
    }

    @NotNull
    public final List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.l> d() {
        return this.f45306g;
    }

    public final int e() {
        return this.f45300a;
    }

    @Nullable
    public final p f() {
        return this.f45305f;
    }

    @Nullable
    public final u g() {
        return this.f45304e;
    }

    public final void h(@Nullable u uVar) {
        this.f45303d = uVar;
    }

    public int hashCode() {
        return (((this.f45300a * 31) + c().hashCode()) * 31) + this.f45302c.hashCode();
    }

    public final void i(@NotNull h hVar) {
        g0.p(hVar, "<set-?>");
        this.f45301b = hVar;
    }

    public final void j(int i6) {
        this.f45300a = i6;
    }

    public final void k(@Nullable p pVar) {
        this.f45305f = pVar;
    }

    public final void l(@Nullable u uVar) {
        this.f45304e = uVar;
    }

    public u() {
        this(0);
    }
}
