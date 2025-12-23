package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.collections.d1;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import kotlin.ranges.m;
import kotlin.reflect.jvm.internal.impl.builtins.functions.e;
import kotlin.reflect.jvm.internal.impl.builtins.o;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.o1;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.descriptors.s;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import kotlin.reflect.jvm.internal.impl.storage.n;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.e2;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.t1;
import kotlin.reflect.jvm.internal.impl.types.w0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFunctionClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FunctionClassDescriptor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionClassDescriptor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,146:1\n1563#2:147\n1634#2,3:148\n*S KotlinDebug\n*F\n+ 1 FunctionClassDescriptor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionClassDescriptor\n*L\n54#1:147\n54#1:148,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b extends kotlin.reflect.jvm.internal.impl.descriptors.impl.a {

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public static final a f44407o = new a(null);

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.b f44408p;

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private static final kotlin.reflect.jvm.internal.impl.name.b f44409q;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private final n f44410g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private final l0 f44411h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private final e f44412i;

    /* renamed from: j, reason: collision with root package name */
    private final int f44413j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private final C0874b f44414k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private final c f44415l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private final List<j1> f44416m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private final FunctionClassKind f44417n;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nFunctionClassDescriptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FunctionClassDescriptor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionClassDescriptor$FunctionTypeConstructor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,146:1\n1563#2:147\n1634#2,2:148\n1563#2:150\n1634#2,3:151\n1636#2:154\n*S KotlinDebug\n*F\n+ 1 FunctionClassDescriptor.kt\norg/jetbrains/kotlin/builtins/functions/FunctionClassDescriptor$FunctionTypeConstructor\n*L\n113#1:147\n113#1:148,2\n117#1:150\n117#1:151,3\n113#1:154\n*E\n"})
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.functions.b$b, reason: collision with other inner class name */
    private final class C0874b extends kotlin.reflect.jvm.internal.impl.types.b {
        @Override // kotlin.reflect.jvm.internal.impl.types.w1
        public boolean d() {
            return true;
        }

        public C0874b() {
            super(b.this.f44410g);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.b, kotlin.reflect.jvm.internal.impl.types.w, kotlin.reflect.jvm.internal.impl.types.w1
        @NotNull
        /* renamed from: J, reason: merged with bridge method [inline-methods] */
        public b c() {
            return b.this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.w1
        @NotNull
        public List<j1> getParameters() {
            return b.this.f44416m;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.q
        @NotNull
        protected Collection<t0> r() {
            List Q;
            e P0 = b.this.P0();
            e.a aVar = e.a.f44424f;
            if (g0.g(P0, aVar)) {
                Q = f0.l(b.f44408p);
            } else if (g0.g(P0, e.b.f44425f)) {
                Q = f0.Q(b.f44409q, new kotlin.reflect.jvm.internal.impl.name.b(o.B, aVar.c(b.this.L0())));
            } else {
                e.d dVar = e.d.f44427f;
                if (g0.g(P0, dVar)) {
                    Q = f0.l(b.f44408p);
                } else {
                    if (!g0.g(P0, e.c.f44426f)) {
                        h4.a.b(null, 1, null);
                        throw new KotlinNothingValueException();
                    }
                    Q = f0.Q(b.f44409q, new kotlin.reflect.jvm.internal.impl.name.b(o.f44575s, dVar.c(b.this.L0())));
                }
            }
            kotlin.reflect.jvm.internal.impl.descriptors.f0 b6 = b.this.f44411h.b();
            List<kotlin.reflect.jvm.internal.impl.name.b> list = Q;
            ArrayList arrayList = new ArrayList(f0.d0(list, 10));
            for (kotlin.reflect.jvm.internal.impl.name.b bVar : list) {
                kotlin.reflect.jvm.internal.impl.descriptors.d b7 = x.b(b6, bVar);
                if (b7 == null) {
                    throw new IllegalStateException(("Built-in class " + bVar + " not found").toString());
                }
                List P5 = f0.P5(getParameters(), b7.o().getParameters().size());
                ArrayList arrayList2 = new ArrayList(f0.d0(P5, 10));
                Iterator it = P5.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new e2(((j1) it.next()).s()));
                }
                arrayList.add(w0.h(t1.f47332b.k(), b7, arrayList2));
            }
            return f0.a6(arrayList);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.q
        @NotNull
        protected h1 v() {
            return h1.a.f44688a;
        }

        @NotNull
        public String toString() {
            return c().toString();
        }
    }

    @Nullable
    public Void M0() {
        return null;
    }

    @Nullable
    public Void S0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public o1<e1> g0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean i0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g
    public boolean k() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean l0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean q0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean u() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean v() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean w() {
        return false;
    }

    static {
        kotlin.reflect.jvm.internal.impl.name.c cVar = o.B;
        kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h("Function");
        g0.o(h6, "identifier(...)");
        f44408p = new kotlin.reflect.jvm.internal.impl.name.b(cVar, h6);
        kotlin.reflect.jvm.internal.impl.name.c cVar2 = o.f44581y;
        kotlin.reflect.jvm.internal.impl.name.f h7 = kotlin.reflect.jvm.internal.impl.name.f.h("KFunction");
        g0.o(h7, "identifier(...)");
        f44409q = new kotlin.reflect.jvm.internal.impl.name.b(cVar2, h7);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull n storageManager, @NotNull l0 containingDeclaration, @NotNull e functionTypeKind, int i6) {
        super(storageManager, functionTypeKind.c(i6));
        g0.p(storageManager, "storageManager");
        g0.p(containingDeclaration, "containingDeclaration");
        g0.p(functionTypeKind, "functionTypeKind");
        this.f44410g = storageManager;
        this.f44411h = containingDeclaration;
        this.f44412i = functionTypeKind;
        this.f44413j = i6;
        this.f44414k = new C0874b();
        this.f44415l = new c(storageManager, this);
        ArrayList arrayList = new ArrayList();
        m mVar = new m(1, i6);
        ArrayList arrayList2 = new ArrayList(f0.d0(mVar, 10));
        Iterator<Integer> it = mVar.iterator();
        while (it.hasNext()) {
            int nextInt = ((d1) it).nextInt();
            Variance variance = Variance.IN_VARIANCE;
            StringBuilder sb = new StringBuilder();
            sb.append('P');
            sb.append(nextInt);
            F0(arrayList, this, variance, sb.toString());
            arrayList2.add(n1.f44123a);
        }
        F0(arrayList, this, Variance.OUT_VARIANCE, "R");
        this.f44416m = f0.a6(arrayList);
        this.f44417n = FunctionClassKind.Companion.a(this.f44412i);
    }

    private static final void F0(ArrayList<j1> arrayList, b bVar, Variance variance, String str) {
        arrayList.add(kotlin.reflect.jvm.internal.impl.descriptors.impl.t0.M0(bVar, g.f44655q0.b(), false, variance, kotlin.reflect.jvm.internal.impl.name.f.h(str), arrayList.size(), bVar.f44410g));
    }

    public final int L0() {
        return this.f44413j;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.l, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public l0 b() {
        return this.f44411h;
    }

    @NotNull
    public final e P0() {
        return this.f44412i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public k.c r0() {
        return k.c.f46780b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.z
    @NotNull
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public c o0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.f44415l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public g getAnnotations() {
        return g.f44655q0.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.e1 getSource() {
        kotlin.reflect.jvm.internal.impl.descriptors.e1 NO_SOURCE = kotlin.reflect.jvm.internal.impl.descriptors.e1.f44683a;
        g0.o(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.c0, kotlin.reflect.jvm.internal.impl.descriptors.o
    @NotNull
    public s getVisibility() {
        s PUBLIC = r.f44948e;
        g0.o(PUBLIC, "PUBLIC");
        return PUBLIC;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public ClassKind h() {
        return ClassKind.INTERFACE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.c0
    @NotNull
    public Modality i() {
        return Modality.ABSTRACT;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public w1 o() {
        return this.f44414k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.g
    @NotNull
    public List<j1> t() {
        return this.f44416m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public List<kotlin.reflect.jvm.internal.impl.descriptors.c> f() {
        return f0.J();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.d s0() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.d) M0();
    }

    @NotNull
    public String toString() {
        String b6 = getName().b();
        g0.o(b6, "asString(...)");
        return b6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.c z() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.c) S0();
    }
}
