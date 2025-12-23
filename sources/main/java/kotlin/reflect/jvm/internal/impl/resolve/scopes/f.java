package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.n;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nGivenFunctionsMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GivenFunctionsMemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/GivenFunctionsMemberScope\n+ 2 CollectionUtil.kt\norg/jetbrains/kotlin/utils/CollectionUtilKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,91:1\n32#2,2:92\n9#2,6:94\n32#2,2:100\n9#2,6:102\n1374#3:108\n1460#3,5:109\n808#3,11:114\n1491#3:125\n1516#3,3:126\n1519#3,3:136\n1491#3:139\n1516#3,3:140\n1519#3,3:150\n774#3:153\n865#3,2:154\n382#4,7:129\n382#4,7:143\n*S KotlinDebug\n*F\n+ 1 GivenFunctionsMemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/GivenFunctionsMemberScope\n*L\n51#1:92,2\n51#1:94,6\n55#1:100,2\n55#1:102,6\n61#1:108\n61#1:109,5\n62#1:114,11\n63#1:125\n63#1:126,3\n63#1:136,3\n64#1:139\n64#1:140,3\n64#1:150,3\n68#1:153\n68#1:154,2\n63#1:129,7\n64#1:143,7\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class f extends l {

    /* renamed from: d, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f46768d = {o0.u(new PropertyReference1Impl(f.class, "allDescriptors", "getAllDescriptors()Ljava/util/List;", 0))};

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.d f46769b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f46770c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends kotlin.reflect.jvm.internal.impl.resolve.l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.k> f46771a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f46772b;

        a(ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.k> arrayList, f fVar) {
            this.f46771a = arrayList;
            this.f46772b = fVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.m
        public void a(CallableMemberDescriptor fakeOverride) {
            g0.p(fakeOverride, "fakeOverride");
            OverridingUtil.K(fakeOverride, null);
            this.f46771a.add(fakeOverride);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.l
        protected void e(CallableMemberDescriptor fromSuper, CallableMemberDescriptor fromCurrent) {
            g0.p(fromSuper, "fromSuper");
            g0.p(fromCurrent, "fromCurrent");
            throw new IllegalStateException(("Conflict in scope of " + this.f46772b.n() + ": " + fromSuper + " vs " + fromCurrent).toString());
        }
    }

    @NotNull
    protected abstract List<y> k();

    public f(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d containingClass) {
        g0.p(storageManager, "storageManager");
        g0.p(containingClass, "containingClass");
        this.f46769b = containingClass;
        this.f46770c = storageManager.e(new e(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<kotlin.reflect.jvm.internal.impl.descriptors.k> l(List<? extends y> list) {
        Collection<? extends CallableMemberDescriptor> J;
        ArrayList arrayList = new ArrayList(3);
        Collection<t0> i6 = this.f46769b.o().i();
        g0.o(i6, "getSupertypes(...)");
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = i6.iterator();
        while (it.hasNext()) {
            f0.s0(arrayList2, n.a.a(((t0) it.next()).r(), null, null, 3, null));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (obj instanceof CallableMemberDescriptor) {
                arrayList3.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList3) {
            kotlin.reflect.jvm.internal.impl.name.f name = ((CallableMemberDescriptor) obj2).getName();
            Object obj3 = linkedHashMap.get(name);
            if (obj3 == null) {
                obj3 = new ArrayList();
                linkedHashMap.put(name, obj3);
            }
            ((List) obj3).add(obj2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            g0.o(key, "component1(...)");
            kotlin.reflect.jvm.internal.impl.name.f fVar = (kotlin.reflect.jvm.internal.impl.name.f) key;
            List list2 = (List) entry.getValue();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj4 : list2) {
                Boolean valueOf = Boolean.valueOf(((CallableMemberDescriptor) obj4) instanceof y);
                Object obj5 = linkedHashMap2.get(valueOf);
                if (obj5 == null) {
                    obj5 = new ArrayList();
                    linkedHashMap2.put(valueOf, obj5);
                }
                ((List) obj5).add(obj4);
            }
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                boolean booleanValue = ((Boolean) entry2.getKey()).booleanValue();
                List list3 = (List) entry2.getValue();
                OverridingUtil overridingUtil = OverridingUtil.f46633f;
                List list4 = list3;
                if (booleanValue) {
                    J = new ArrayList<>();
                    for (Object obj6 : list) {
                        if (g0.g(((y) obj6).getName(), fVar)) {
                            J.add(obj6);
                        }
                    }
                } else {
                    J = f0.J();
                }
                overridingUtil.v(fVar, list4, J, this.f46769b, new a(arrayList, this));
            }
        }
        return kotlin.reflect.jvm.internal.impl.utils.a.c(arrayList);
    }

    private final List<kotlin.reflect.jvm.internal.impl.descriptors.k> m() {
        return (List) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f46770c, this, f46768d[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    public Collection<d1> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        List list;
        g0.p(name, "name");
        g0.p(location, "location");
        List<kotlin.reflect.jvm.internal.impl.descriptors.k> m6 = m();
        if (m6.isEmpty()) {
            list = f0.J();
        } else {
            kotlin.reflect.jvm.internal.impl.utils.j jVar = new kotlin.reflect.jvm.internal.impl.utils.j();
            for (Object obj : m6) {
                if ((obj instanceof d1) && g0.g(((d1) obj).getName(), name)) {
                    jVar.add(obj);
                }
            }
            list = jVar;
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<w0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull u3.b location) {
        List list;
        g0.p(name, "name");
        g0.p(location, "location");
        List<kotlin.reflect.jvm.internal.impl.descriptors.k> m6 = m();
        if (m6.isEmpty()) {
            list = f0.J();
        } else {
            kotlin.reflect.jvm.internal.impl.utils.j jVar = new kotlin.reflect.jvm.internal.impl.utils.j();
            for (Object obj : m6) {
                if ((obj instanceof w0) && g0.g(((w0) obj).getName(), name)) {
                    jVar.add(obj);
                }
            }
            list = jVar;
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.l, kotlin.reflect.jvm.internal.impl.resolve.scopes.n
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> h(@NotNull d kindFilter, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        g0.p(kindFilter, "kindFilter");
        g0.p(nameFilter, "nameFilter");
        return !kindFilter.a(d.f46752p.m()) ? f0.J() : m();
    }

    @NotNull
    protected final kotlin.reflect.jvm.internal.impl.descriptors.d n() {
        return this.f46769b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List j(f fVar) {
        List<y> k6 = fVar.k();
        return f0.I4(k6, fVar.l(k6));
    }
}
