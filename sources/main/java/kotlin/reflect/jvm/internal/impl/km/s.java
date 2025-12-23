package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nNodes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmProperty\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,830:1\n1#2:831\n1563#3:832\n1634#3,3:833\n*S KotlinDebug\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmProperty\n*L\n390#1:832\n390#1:833,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class s {

    /* renamed from: r, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f45280r = {o0.k(new MutablePropertyReference1Impl(s.class, "_hasSetter", "get_hasSetter()Z", 0)), o0.k(new MutablePropertyReference1Impl(s.class, "_hasGetter", "get_hasGetter()Z", 0))};

    /* renamed from: a, reason: collision with root package name */
    private int f45281a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private String f45282b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.km.internal.a f45283c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.km.internal.a f45284d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final t f45285e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private t f45286f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final List<w> f45287g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private u f45288h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private final List<d> f45289i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private final List<u> f45290j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private y f45291k;

    /* renamed from: l, reason: collision with root package name */
    public u f45292l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private final List<a0> f45293m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private final List<d> f45294n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private final List<d> f45295o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private final List<d> f45296p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private final List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.j> f45297q;

    public s(int i6, @NotNull String name, int i7, int i8) {
        g0.p(name, "name");
        this.f45281a = i6;
        this.f45282b = name;
        b.C0902b HAS_SETTER = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.A;
        g0.o(HAS_SETTER, "HAS_SETTER");
        this.f45283c = kotlin.reflect.jvm.internal.impl.km.internal.c.g(new kotlin.reflect.jvm.internal.impl.km.internal.d(HAS_SETTER));
        b.C0902b HAS_GETTER = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f46231z;
        g0.o(HAS_GETTER, "HAS_GETTER");
        this.f45284d = kotlin.reflect.jvm.internal.impl.km.internal.c.g(new kotlin.reflect.jvm.internal.impl.km.internal.d(HAS_GETTER));
        t tVar = new t(i7);
        u(true);
        this.f45285e = tVar;
        this.f45286f = p() ? new t(i8) : null;
        this.f45287g = new ArrayList(0);
        this.f45289i = new ArrayList(0);
        this.f45290j = new ArrayList(0);
        this.f45293m = new ArrayList(0);
        this.f45294n = new ArrayList(0);
        this.f45295o = new ArrayList(0);
        this.f45296p = new ArrayList(0);
        List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.p> c6 = kotlin.reflect.jvm.internal.impl.km.internal.extensions.p.f45189a.c();
        ArrayList arrayList = new ArrayList(f0.d0(c6, 10));
        Iterator<T> it = c6.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.km.internal.extensions.p) it.next()).p());
        }
        this.f45297q = arrayList;
    }

    private final boolean p() {
        return this.f45283c.a(this, f45280r[0]);
    }

    private final void u(boolean z5) {
        this.f45284d.b(this, f45280r[1], z5);
    }

    @NotNull
    public final List<d> a() {
        return this.f45294n;
    }

    @NotNull
    public final List<d> b() {
        return this.f45295o;
    }

    @NotNull
    public final List<u> c() {
        return this.f45290j;
    }

    @NotNull
    public final List<d> d() {
        return this.f45296p;
    }

    @NotNull
    public final List<d> e() {
        return this.f45289i;
    }

    @NotNull
    public final List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.j> f() {
        return this.f45297q;
    }

    public final int g() {
        return this.f45281a;
    }

    @NotNull
    public final t h() {
        return this.f45285e;
    }

    @NotNull
    public final String i() {
        return this.f45282b;
    }

    @Nullable
    public final u j() {
        return this.f45288h;
    }

    @NotNull
    public final u k() {
        u uVar = this.f45292l;
        if (uVar != null) {
            return uVar;
        }
        g0.S("returnType");
        return null;
    }

    @Nullable
    public final t l() {
        return this.f45286f;
    }

    @Nullable
    public final y m() {
        return this.f45291k;
    }

    @NotNull
    public final List<w> n() {
        return this.f45287g;
    }

    @NotNull
    public final List<a0> o() {
        return this.f45293m;
    }

    public final void q(int i6) {
        this.f45281a = i6;
    }

    public final void r(@Nullable u uVar) {
        this.f45288h = uVar;
    }

    public final void s(@NotNull u uVar) {
        g0.p(uVar, "<set-?>");
        this.f45292l = uVar;
    }

    public final void t(@Nullable y yVar) {
        this.f45291k = yVar;
    }
}
