package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/DescriptorKindFilter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 MemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/DescriptorKindFilter$Companion\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,261:1\n1869#2,2:262\n1740#2,3:264\n295#2,2:267\n1617#2,9:269\n1869#2:278\n1870#2:280\n1626#2:281\n1617#2,9:286\n1869#2:295\n1870#2:297\n1626#2:298\n774#2:303\n865#2,2:304\n1617#2,9:306\n1869#2:315\n1870#2:317\n1626#2:318\n1#3:279\n1#3:296\n1#3:316\n210#4:282\n210#4:299\n3829#5:283\n4344#5,2:284\n3829#5:300\n4344#5,2:301\n*S KotlinDebug\n*F\n+ 1 MemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/DescriptorKindFilter\n*L\n98#1:262,2\n103#1:264,3\n129#1:267,2\n131#1:269,9\n131#1:278\n131#1:280\n131#1:281\n197#1:286,9\n197#1:295\n197#1:297\n197#1:298\n203#1:303\n203#1:304,2\n204#1:306,9\n204#1:315\n204#1:317\n204#1:318\n131#1:279\n197#1:296\n204#1:316\n196#1:282\n202#1:299\n196#1:283\n196#1:284,2\n202#1:300\n202#1:301,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f46739c;

    /* renamed from: d, reason: collision with root package name */
    private static int f46740d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f46741e;

    /* renamed from: f, reason: collision with root package name */
    private static final int f46742f;

    /* renamed from: g, reason: collision with root package name */
    private static final int f46743g;

    /* renamed from: h, reason: collision with root package name */
    private static final int f46744h;

    /* renamed from: i, reason: collision with root package name */
    private static final int f46745i;

    /* renamed from: j, reason: collision with root package name */
    private static final int f46746j;

    /* renamed from: k, reason: collision with root package name */
    private static final int f46747k;

    /* renamed from: l, reason: collision with root package name */
    private static final int f46748l;

    /* renamed from: m, reason: collision with root package name */
    private static final int f46749m;

    /* renamed from: n, reason: collision with root package name */
    private static final int f46750n;

    /* renamed from: o, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final d f46751o;

    /* renamed from: p, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final d f46752p;

    /* renamed from: q, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final d f46753q;

    /* renamed from: r, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final d f46754r;

    /* renamed from: s, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final d f46755s;

    /* renamed from: t, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final d f46756t;

    /* renamed from: u, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final d f46757u;

    /* renamed from: v, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final d f46758v;

    /* renamed from: w, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final d f46759w;

    /* renamed from: x, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final d f46760x;

    /* renamed from: y, reason: collision with root package name */
    @NotNull
    private static final List<a.C0914a> f46761y;

    /* renamed from: z, reason: collision with root package name */
    @NotNull
    private static final List<a.C0914a> f46762z;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<c> f46763a;

    /* renamed from: b, reason: collision with root package name */
    private final int f46764b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nMemberScope.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/DescriptorKindFilter$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,261:1\n1#2:262\n3829#3:263\n4344#3,2:264\n*S KotlinDebug\n*F\n+ 1 MemberScope.kt\norg/jetbrains/kotlin/resolve/scopes/DescriptorKindFilter$Companion\n*L\n210#1:263\n210#1:264,2\n*E\n"})
    public static final class a {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.scopes.d$a$a, reason: collision with other inner class name */
        private static final class C0914a {

            /* renamed from: a, reason: collision with root package name */
            private final int f46765a;

            /* renamed from: b, reason: collision with root package name */
            @NotNull
            private final String f46766b;

            public C0914a(int i6, @NotNull String name) {
                g0.p(name, "name");
                this.f46765a = i6;
                this.f46766b = name;
            }

            public final int a() {
                return this.f46765a;
            }

            @NotNull
            public final String b() {
                return this.f46766b;
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int j() {
            int i6 = d.f46740d;
            a aVar = d.f46739c;
            d.f46740d <<= 1;
            return i6;
        }

        public final int b() {
            return d.f46747k;
        }

        public final int c() {
            return d.f46748l;
        }

        public final int d() {
            return d.f46745i;
        }

        public final int e() {
            return d.f46741e;
        }

        public final int f() {
            return d.f46744h;
        }

        public final int g() {
            return d.f46742f;
        }

        public final int h() {
            return d.f46743g;
        }

        public final int i() {
            return d.f46746j;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(int i6, @NotNull List<? extends c> excludes) {
        g0.p(excludes, "excludes");
        this.f46763a = excludes;
        Iterator it = excludes.iterator();
        while (it.hasNext()) {
            i6 &= ~((c) it.next()).a();
        }
        this.f46764b = i6;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!g0.g(d.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        g0.n(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
        d dVar = (d) obj;
        return g0.g(this.f46763a, dVar.f46763a) && this.f46764b == dVar.f46764b;
    }

    static {
        a.C0914a c0914a;
        a.C0914a c0914a2;
        a aVar = new a(null);
        f46739c = aVar;
        f46740d = 1;
        int j6 = aVar.j();
        f46741e = j6;
        int j7 = aVar.j();
        f46742f = j7;
        int j8 = aVar.j();
        f46743g = j8;
        int j9 = aVar.j();
        f46744h = j9;
        int j10 = aVar.j();
        f46745i = j10;
        int j11 = aVar.j();
        f46746j = j11;
        int j12 = aVar.j() - 1;
        f46747k = j12;
        int i6 = j6 | j7 | j8;
        f46748l = i6;
        int i7 = j7 | j10 | j11;
        f46749m = i7;
        int i8 = j10 | j11;
        f46750n = i8;
        int i9 = 2;
        f46751o = new d(j12, 0 == true ? 1 : 0, i9, 0 == true ? 1 : 0);
        f46752p = new d(i8, 0 == true ? 1 : 0, i9, 0 == true ? 1 : 0);
        f46753q = new d(j6, 0 == true ? 1 : 0, i9, 0 == true ? 1 : 0);
        f46754r = new d(j7, 0 == true ? 1 : 0, i9, 0 == true ? 1 : 0);
        f46755s = new d(j8, 0 == true ? 1 : 0, i9, 0 == true ? 1 : 0);
        f46756t = new d(i6, 0 == true ? 1 : 0, i9, 0 == true ? 1 : 0);
        f46757u = new d(j9, 0 == true ? 1 : 0, i9, 0 == true ? 1 : 0);
        f46758v = new d(j10, 0 == true ? 1 : 0, i9, 0 == true ? 1 : 0);
        f46759w = new d(j11, 0 == true ? 1 : 0, i9, 0 == true ? 1 : 0);
        f46760x = new d(i7, 0 == true ? 1 : 0, i9, 0 == true ? 1 : 0);
        Field[] fields = d.class.getFields();
        g0.o(fields, "getFields(...)");
        ArrayList<Field> arrayList = new ArrayList();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Field field2 : arrayList) {
            Object obj = field2.get(null);
            d dVar = obj instanceof d ? (d) obj : null;
            if (dVar != null) {
                int i10 = dVar.f46764b;
                String name = field2.getName();
                g0.o(name, "getName(...)");
                c0914a2 = new a.C0914a(i10, name);
            } else {
                c0914a2 = null;
            }
            if (c0914a2 != null) {
                arrayList2.add(c0914a2);
            }
        }
        f46761y = arrayList2;
        Field[] fields2 = d.class.getFields();
        g0.o(fields2, "getFields(...)");
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (g0.g(((Field) obj2).getType(), Integer.TYPE)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field4 : arrayList4) {
            Object obj3 = field4.get(null);
            g0.n(obj3, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj3).intValue();
            if (intValue == ((-intValue) & intValue)) {
                String name2 = field4.getName();
                g0.o(name2, "getName(...)");
                c0914a = new a.C0914a(intValue, name2);
            } else {
                c0914a = null;
            }
            if (c0914a != null) {
                arrayList5.add(c0914a);
            }
        }
        f46762z = arrayList5;
    }

    public final boolean a(int i6) {
        return (i6 & this.f46764b) != 0;
    }

    public int hashCode() {
        return (this.f46763a.hashCode() * 31) + this.f46764b;
    }

    @NotNull
    public final List<c> l() {
        return this.f46763a;
    }

    public final int m() {
        return this.f46764b;
    }

    @Nullable
    public final d n(int i6) {
        int i7 = i6 & this.f46764b;
        if (i7 == 0) {
            return null;
        }
        return new d(i7, this.f46763a);
    }

    @NotNull
    public String toString() {
        Object obj;
        Iterator<T> it = f46761y.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((a.C0914a) obj).a() == this.f46764b) {
                break;
            }
        }
        a.C0914a c0914a = (a.C0914a) obj;
        String b6 = c0914a != null ? c0914a.b() : null;
        if (b6 == null) {
            List<a.C0914a> list = f46762z;
            ArrayList arrayList = new ArrayList();
            for (a.C0914a c0914a2 : list) {
                String b7 = a(c0914a2.a()) ? c0914a2.b() : null;
                if (b7 != null) {
                    arrayList.add(b7);
                }
            }
            b6 = f0.r3(arrayList, " | ", null, null, 0, null, null, 62, null);
        }
        return "DescriptorKindFilter(" + b6 + ", " + this.f46763a + ')';
    }

    public /* synthetic */ d(int i6, List list, int i7, kotlin.jvm.internal.v vVar) {
        this(i6, (i7 & 2) != 0 ? f0.J() : list);
    }
}
