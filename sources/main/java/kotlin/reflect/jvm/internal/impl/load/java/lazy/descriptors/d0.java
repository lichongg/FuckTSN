package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.i1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLazyJavaPackageFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LazyJavaPackageFragment.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaPackageFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,96:1\n1617#2,9:97\n1869#2:106\n1870#2:109\n1626#2:110\n1563#2:111\n1634#2,3:112\n1#3:107\n1#3:108\n*S KotlinDebug\n*F\n+ 1 LazyJavaPackageFragment.kt\norg/jetbrains/kotlin/load/java/lazy/descriptors/LazyJavaPackageFragment\n*L\n46#1:97,9\n46#1:106\n46#1:109\n46#1:110\n55#1:111\n55#1:112,3\n46#1:108\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d0 extends kotlin.reflect.jvm.internal.impl.descriptors.impl.h0 {

    /* renamed from: o, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f45541o = {kotlin.jvm.internal.o0.u(new PropertyReference1Impl(d0.class, "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;", 0)), kotlin.jvm.internal.o0.u(new PropertyReference1Impl(d0.class, "partToFacade", "getPartToFacade()Ljava/util/HashMap;", 0))};

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final y3.u f45542g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.k f45543h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.c f45544i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f45545j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private final f f45546k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i<List<kotlin.reflect.jvm.internal.impl.name.c>> f45547l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.g f45548m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f45549n;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45550a;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            try {
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f45550a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.k outerContext, @NotNull y3.u jPackage) {
        super(outerContext.d(), jPackage.d());
        kotlin.jvm.internal.g0.p(outerContext, "outerContext");
        kotlin.jvm.internal.g0.p(jPackage, "jPackage");
        this.f45542g = jPackage;
        kotlin.reflect.jvm.internal.impl.load.java.lazy.k f6 = kotlin.reflect.jvm.internal.impl.load.java.lazy.c.f(outerContext, this, null, 0, 6, null);
        this.f45543h = f6;
        this.f45544i = outerContext.a().b().f().g().f();
        this.f45545j = f6.e().e(new a0(this));
        this.f45546k = new f(f6, jPackage, this);
        this.f45547l = f6.e().a(new b0(this), kotlin.collections.f0.J());
        this.f45548m = f6.a().i().a() ? kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b() : kotlin.reflect.jvm.internal.impl.load.java.lazy.h.a(f6, jPackage);
        this.f45549n = f6.e().e(new c0(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map H0(d0 d0Var) {
        List<String> a6 = d0Var.f45543h.a().o().a(d0Var.d().a());
        ArrayList arrayList = new ArrayList();
        for (String str : a6) {
            b.a aVar = kotlin.reflect.jvm.internal.impl.name.b.f46334d;
            kotlin.reflect.jvm.internal.impl.name.c e6 = kotlin.reflect.jvm.internal.impl.resolve.jvm.d.d(str).e();
            kotlin.jvm.internal.g0.o(e6, "getFqNameForTopLevelClassMaybeWithDollars(...)");
            kotlin.reflect.jvm.internal.impl.load.kotlin.x a7 = kotlin.reflect.jvm.internal.impl.load.kotlin.w.a(d0Var.f45543h.a().j(), aVar.c(e6), d0Var.f45544i);
            Pair a8 = a7 != null ? kotlin.o0.a(str, a7) : null;
            if (a8 != null) {
                arrayList.add(a8);
            }
        }
        return i1.B0(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashMap M0(d0 d0Var) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, kotlin.reflect.jvm.internal.impl.load.kotlin.x> entry : d0Var.J0().entrySet()) {
            String key = entry.getKey();
            kotlin.reflect.jvm.internal.impl.load.kotlin.x value = entry.getValue();
            kotlin.reflect.jvm.internal.impl.resolve.jvm.d d6 = kotlin.reflect.jvm.internal.impl.resolve.jvm.d.d(key);
            kotlin.jvm.internal.g0.o(d6, "byInternalName(...)");
            KotlinClassHeader e6 = value.e();
            int i6 = a.f45550a[e6.c().ordinal()];
            if (i6 == 1) {
                String e7 = e6.e();
                if (e7 != null) {
                    hashMap.put(d6, kotlin.reflect.jvm.internal.impl.resolve.jvm.d.d(e7));
                }
            } else if (i6 == 2) {
                hashMap.put(d6, d6);
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List N0(d0 d0Var) {
        Collection<y3.u> o5 = d0Var.f45542g.o();
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(o5, 10));
        Iterator<T> it = o5.iterator();
        while (it.hasNext()) {
            arrayList.add(((y3.u) it.next()).d());
        }
        return arrayList;
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.descriptors.d I0(@NotNull y3.g jClass) {
        kotlin.jvm.internal.g0.p(jClass, "jClass");
        return this.f45546k.j().l0(jClass);
    }

    @NotNull
    public final Map<String, kotlin.reflect.jvm.internal.impl.load.kotlin.x> J0() {
        return (Map) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f45545j, this, f45541o[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.l0
    @NotNull
    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public f r() {
        return this.f45546k;
    }

    @NotNull
    public final List<kotlin.reflect.jvm.internal.impl.name.c> L0() {
        return this.f45547l.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.b, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g getAnnotations() {
        return this.f45548m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.h0, kotlin.reflect.jvm.internal.impl.descriptors.impl.n, kotlin.reflect.jvm.internal.impl.descriptors.n
    @NotNull
    public e1 getSource() {
        return new kotlin.reflect.jvm.internal.impl.load.kotlin.y(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.h0, kotlin.reflect.jvm.internal.impl.descriptors.impl.m
    @NotNull
    public String toString() {
        return "Lazy Java package fragment: " + d() + " of module " + this.f45543h.a().m();
    }
}
