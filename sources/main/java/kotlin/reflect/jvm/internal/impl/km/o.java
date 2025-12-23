package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nNodes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmEnumEntry\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,830:1\n1617#2,9:831\n1869#2:840\n1870#2:842\n1626#2:843\n1#3:841\n*S KotlinDebug\n*F\n+ 1 Nodes.kt\nkotlin/metadata/KmEnumEntry\n*L\n521#1:831,9\n521#1:840\n521#1:842\n521#1:843\n521#1:841\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private String f45258a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<d> f45259b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.d> f45260c;

    public o(@NotNull String name) {
        g0.p(name, "name");
        this.f45258a = name;
        this.f45259b = new ArrayList(0);
        List<kotlin.reflect.jvm.internal.impl.km.internal.extensions.p> c6 = kotlin.reflect.jvm.internal.impl.km.internal.extensions.p.f45189a.c();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = c6.iterator();
        while (it.hasNext()) {
            kotlin.reflect.jvm.internal.impl.km.internal.extensions.d b6 = ((kotlin.reflect.jvm.internal.impl.km.internal.extensions.p) it.next()).b();
            if (b6 != null) {
                arrayList.add(b6);
            }
        }
        this.f45260c = arrayList;
    }

    @NotNull
    public final List<d> a() {
        return this.f45259b;
    }

    @NotNull
    public String toString() {
        return this.f45258a;
    }
}
