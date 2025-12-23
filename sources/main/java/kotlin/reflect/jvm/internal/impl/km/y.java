package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nNodes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmValueParameter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,830:1\n1617#2,9:831\n1869#2:840\n1870#2:842\n1626#2:843\n1#3:841\n*S KotlinDebug\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmValueParameter\n*L\n476#1:831,9\n476#1:840\n476#1:842\n476#1:843\n476#1:841\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    private int f45325a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private String f45326b;

    /* renamed from: c, reason: collision with root package name */
    public u f45327c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private u f45328d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private e f45329e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final List<d> f45330f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.n> f45331g;

    public y(int i6, @NotNull String name) {
        g0.p(name, "name");
        this.f45325a = i6;
        this.f45326b = name;
        this.f45330f = new ArrayList(0);
        List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.p> c6 = kotlin.reflect.jvm.internal.impl.km.internal.extensions.p.f45189a.c();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = c6.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.km.internal.extensions.n k6 = ((kotlin.reflect.jvm.internal.impl.km.internal.extensions.p) it.next()).k();
            if (k6 != null) {
                arrayList.add(k6);
            }
        }
        this.f45331g = arrayList;
    }

    @Nullable
    public final e a() {
        return this.f45329e;
    }

    @NotNull
    public final List<d> b() {
        return this.f45330f;
    }

    public final int c() {
        return this.f45325a;
    }

    @NotNull
    public final String d() {
        return this.f45326b;
    }

    @Nullable
    public final u e() {
        return this.f45328d;
    }

    public final void f(@Nullable e eVar) {
        this.f45329e = eVar;
    }

    public final void g(int i6) {
        this.f45325a = i6;
    }

    @NotNull
    public final u getType() {
        u uVar = this.f45327c;
        if (uVar != null) {
            return uVar;
        }
        g0.S("type");
        return null;
    }

    public final void h(@NotNull u uVar) {
        g0.p(uVar, "<set-?>");
        this.f45327c = uVar;
    }

    public final void i(@Nullable u uVar) {
        this.f45328d = uVar;
    }
}
