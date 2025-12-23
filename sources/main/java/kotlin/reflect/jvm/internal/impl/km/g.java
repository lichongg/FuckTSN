package kotlin.reflect.jvm.internal.impl.km;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nNodes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmClass\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,830:1\n1563#2:831\n1634#2,3:832\n*S KotlinDebug\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmClass\n*L\n135#1:831\n135#1:832,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g implements l {

    /* renamed from: a, reason: collision with root package name */
    private int f45138a;

    /* renamed from: b, reason: collision with root package name */
    public String f45139b;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private String f45146i;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    private String f45151n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    private u f45152o;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    private final List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.b> f45156s;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<w> f45140c = new ArrayList(0);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final List<u> f45141d = new ArrayList(1);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final List<q> f45142e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final List<s> f45143f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final List<v> f45144g = new ArrayList(0);

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final List<j> f45145h = new ArrayList(1);

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private final List<String> f45147j = new ArrayList(0);

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private final List<String> f45148k = new ArrayList(0);

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private final List<o> f45149l = new ArrayList(0);

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private final List<String> f45150m = new ArrayList(0);

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private final List<d> f45153p = new ArrayList(0);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private final List<u> f45154q = new ArrayList(0);

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    private final List<a0> f45155r = new ArrayList(0);

    @Override // kotlin.reflect.jvm.internal.impl.km.l
    @NotNull
    public List<s> a() {
        return this.f45143f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.l
    @NotNull
    public List<v> b() {
        return this.f45144g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.l
    @NotNull
    public List<q> c() {
        return this.f45142e;
    }

    @NotNull
    public final List<d> d() {
        return this.f45153p;
    }

    @NotNull
    public final List<j> e() {
        return this.f45145h;
    }

    @NotNull
    public final List<u> f() {
        return this.f45154q;
    }

    @NotNull
    public final List<String> g() {
        return this.f45148k;
    }

    @NotNull
    public final List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.b> h() {
        return this.f45156s;
    }

    public final int i() {
        return this.f45138a;
    }

    @NotNull
    public final List<o> j() {
        return this.f45149l;
    }

    @NotNull
    public final String k() {
        String str = this.f45139b;
        if (str != null) {
            return str;
        }
        g0.S(CommonNetImpl.NAME);
        return null;
    }

    @NotNull
    public final List<String> l() {
        return this.f45147j;
    }

    @NotNull
    public final List<String> m() {
        return this.f45150m;
    }

    @NotNull
    public final List<u> n() {
        return this.f45141d;
    }

    @NotNull
    public final List<w> o() {
        return this.f45140c;
    }

    @NotNull
    public final List<a0> p() {
        return this.f45155r;
    }

    public final void q(@Nullable String str) {
        this.f45146i = str;
    }

    public final void r(int i6) {
        this.f45138a = i6;
    }

    public final void s(@Nullable String str) {
        this.f45151n = str;
    }

    public final void t(@Nullable u uVar) {
        this.f45152o = uVar;
    }

    public final void u(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f45139b = str;
    }

    public g() {
        List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.p> c6 = kotlin.reflect.jvm.internal.impl.km.internal.extensions.p.f45189a.c();
        ArrayList arrayList = new ArrayList(f0.d0(c6, 10));
        Iterator<T> it = c6.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.km.internal.extensions.p) it.next()).e());
        }
        this.f45156s = arrayList;
    }
}
