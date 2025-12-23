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
@SourceDebugExtension({"SMAP\nNodes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmFunction\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,830:1\n1563#2:831\n1634#2,3:832\n*S KotlinDebug\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmFunction\n*L\n263#1:831\n263#1:832,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private int f45264a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private String f45265b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<w> f45266c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private u f45267d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final List<d> f45268e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final List<u> f45269f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final List<y> f45270g;

    /* renamed from: h, reason: collision with root package name */
    public u f45271h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private final List<a0> f45272i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private k f45273j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private final List<d> f45274k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private final List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.g> f45275l;

    public q(int i6, @NotNull String name) {
        g0.p(name, "name");
        this.f45264a = i6;
        this.f45265b = name;
        this.f45266c = new ArrayList(0);
        this.f45268e = new ArrayList(0);
        this.f45269f = new ArrayList(0);
        this.f45270g = new ArrayList();
        this.f45272i = new ArrayList(0);
        this.f45274k = new ArrayList(0);
        List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.p> c6 = kotlin.reflect.jvm.internal.impl.km.internal.extensions.p.f45189a.c();
        ArrayList arrayList = new ArrayList(f0.d0(c6, 10));
        Iterator<T> it = c6.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.km.internal.extensions.p) it.next()).u());
        }
        this.f45275l = arrayList;
    }

    @NotNull
    public final List<d> a() {
        return this.f45274k;
    }

    @NotNull
    public final List<u> b() {
        return this.f45269f;
    }

    @NotNull
    public final List<d> c() {
        return this.f45268e;
    }

    @NotNull
    public final List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.g> d() {
        return this.f45275l;
    }

    public final int e() {
        return this.f45264a;
    }

    @NotNull
    public final List<w> f() {
        return this.f45266c;
    }

    @NotNull
    public final List<y> g() {
        return this.f45270g;
    }

    @NotNull
    public final List<a0> h() {
        return this.f45272i;
    }

    public final void i(@Nullable k kVar) {
        this.f45273j = kVar;
    }

    public final void j(int i6) {
        this.f45264a = i6;
    }

    public final void k(@Nullable u uVar) {
        this.f45267d = uVar;
    }

    public final void l(@NotNull u uVar) {
        g0.p(uVar, "<set-?>");
        this.f45271h = uVar;
    }
}
