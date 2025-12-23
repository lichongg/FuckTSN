package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.f2;
import kotlin.reflect.jvm.internal.impl.types.h2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class k0 extends x0 implements kotlin.reflect.jvm.internal.impl.descriptors.w0 {
    private y0 A;
    private boolean B;
    private kotlin.reflect.jvm.internal.impl.descriptors.v C;
    private kotlin.reflect.jvm.internal.impl.descriptors.v D;

    /* renamed from: k, reason: collision with root package name */
    private final Modality f44774k;

    /* renamed from: l, reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.descriptors.s f44775l;

    /* renamed from: m, reason: collision with root package name */
    private Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.w0> f44776m;

    /* renamed from: n, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.w0 f44777n;

    /* renamed from: o, reason: collision with root package name */
    private final CallableMemberDescriptor.Kind f44778o;

    /* renamed from: p, reason: collision with root package name */
    private final boolean f44779p;

    /* renamed from: q, reason: collision with root package name */
    private final boolean f44780q;

    /* renamed from: r, reason: collision with root package name */
    private final boolean f44781r;

    /* renamed from: s, reason: collision with root package name */
    private final boolean f44782s;

    /* renamed from: t, reason: collision with root package name */
    private final boolean f44783t;

    /* renamed from: u, reason: collision with root package name */
    private final boolean f44784u;

    /* renamed from: v, reason: collision with root package name */
    private List<z0> f44785v;

    /* renamed from: w, reason: collision with root package name */
    private z0 f44786w;

    /* renamed from: x, reason: collision with root package name */
    private z0 f44787x;

    /* renamed from: y, reason: collision with root package name */
    private List<j1> f44788y;

    /* renamed from: z, reason: collision with root package name */
    private l0 f44789z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.descriptors.k f44790a;

        /* renamed from: b, reason: collision with root package name */
        private Modality f44791b;

        /* renamed from: c, reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.descriptors.s f44792c;

        /* renamed from: f, reason: collision with root package name */
        private CallableMemberDescriptor.Kind f44795f;

        /* renamed from: i, reason: collision with root package name */
        private z0 f44798i;

        /* renamed from: k, reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.name.f f44800k;

        /* renamed from: l, reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.types.t0 f44801l;

        /* renamed from: d, reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.descriptors.w0 f44793d = null;

        /* renamed from: e, reason: collision with root package name */
        private boolean f44794e = false;

        /* renamed from: g, reason: collision with root package name */
        private f2 f44796g = f2.f47250b;

        /* renamed from: h, reason: collision with root package name */
        private boolean f44797h = true;

        /* renamed from: j, reason: collision with root package name */
        private List<j1> f44799j = null;

        public a() {
            this.f44790a = k0.this.b();
            this.f44791b = k0.this.i();
            this.f44792c = k0.this.getVisibility();
            this.f44795f = k0.this.h();
            this.f44798i = k0.this.f44786w;
            this.f44800k = k0.this.getName();
            this.f44801l = k0.this.getType();
        }

        private static /* synthetic */ void a(int i6) {
            String str = (i6 == 1 || i6 == 2 || i6 == 3 || i6 == 5 || i6 == 7 || i6 == 9 || i6 == 11 || i6 == 19 || i6 == 13 || i6 == 14 || i6 == 16 || i6 == 17) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i6 == 1 || i6 == 2 || i6 == 3 || i6 == 5 || i6 == 7 || i6 == 9 || i6 == 11 || i6 == 19 || i6 == 13 || i6 == 14 || i6 == 16 || i6 == 17) ? 2 : 3];
            switch (i6) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 4:
                    objArr[0] = "type";
                    break;
                case 6:
                    objArr[0] = "modality";
                    break;
                case 8:
                    objArr[0] = "visibility";
                    break;
                case 10:
                    objArr[0] = "kind";
                    break;
                case 12:
                    objArr[0] = "typeParameters";
                    break;
                case 15:
                    objArr[0] = "substitution";
                    break;
                case 18:
                    objArr[0] = CommonNetImpl.NAME;
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            if (i6 == 1) {
                objArr[1] = "setOwner";
            } else if (i6 == 2) {
                objArr[1] = "setOriginal";
            } else if (i6 == 3) {
                objArr[1] = "setPreserveSourceElement";
            } else if (i6 == 5) {
                objArr[1] = "setReturnType";
            } else if (i6 == 7) {
                objArr[1] = "setModality";
            } else if (i6 == 9) {
                objArr[1] = "setVisibility";
            } else if (i6 == 11) {
                objArr[1] = "setKind";
            } else if (i6 == 19) {
                objArr[1] = "setName";
            } else if (i6 == 13) {
                objArr[1] = "setTypeParameters";
            } else if (i6 == 14) {
                objArr[1] = "setDispatchReceiverParameter";
            } else if (i6 == 16) {
                objArr[1] = "setSubstitution";
            } else if (i6 != 17) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
            } else {
                objArr[1] = "setCopyOverrides";
            }
            switch (i6) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    break;
                case 4:
                    objArr[2] = "setReturnType";
                    break;
                case 6:
                    objArr[2] = "setModality";
                    break;
                case 8:
                    objArr[2] = "setVisibility";
                    break;
                case 10:
                    objArr[2] = "setKind";
                    break;
                case 12:
                    objArr[2] = "setTypeParameters";
                    break;
                case 15:
                    objArr[2] = "setSubstitution";
                    break;
                case 18:
                    objArr[2] = "setName";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String format = String.format(str, objArr);
            if (i6 != 1 && i6 != 2 && i6 != 3 && i6 != 5 && i6 != 7 && i6 != 9 && i6 != 11 && i6 != 19 && i6 != 13 && i6 != 14 && i6 != 16 && i6 != 17) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @Nullable
        public kotlin.reflect.jvm.internal.impl.descriptors.w0 n() {
            return k0.this.M0(this);
        }

        kotlin.reflect.jvm.internal.impl.descriptors.x0 o() {
            kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var = this.f44793d;
            if (w0Var == null) {
                return null;
            }
            return w0Var.getGetter();
        }

        y0 p() {
            kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var = this.f44793d;
            if (w0Var == null) {
                return null;
            }
            return w0Var.getSetter();
        }

        @NotNull
        public a q(boolean z5) {
            this.f44797h = z5;
            return this;
        }

        @NotNull
        public a r(@NotNull CallableMemberDescriptor.Kind kind) {
            if (kind == null) {
                a(10);
            }
            this.f44795f = kind;
            return this;
        }

        @NotNull
        public a s(@NotNull Modality modality) {
            if (modality == null) {
                a(6);
            }
            this.f44791b = modality;
            return this;
        }

        @NotNull
        public a t(@Nullable CallableMemberDescriptor callableMemberDescriptor) {
            this.f44793d = (kotlin.reflect.jvm.internal.impl.descriptors.w0) callableMemberDescriptor;
            return this;
        }

        @NotNull
        public a u(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            if (kVar == null) {
                a(0);
            }
            this.f44790a = kVar;
            return this;
        }

        @NotNull
        public a v(@NotNull f2 f2Var) {
            if (f2Var == null) {
                a(15);
            }
            this.f44796g = f2Var;
            return this;
        }

        @NotNull
        public a w(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar) {
            if (sVar == null) {
                a(8);
            }
            this.f44792c = sVar;
            return this;
        }
    }

    @NotNull
    public static k0 K0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull Modality modality, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar, boolean z5, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull CallableMemberDescriptor.Kind kind, @NotNull e1 e1Var, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11) {
        if (kVar == null) {
            T(7);
        }
        if (gVar == null) {
            T(8);
        }
        if (modality == null) {
            T(9);
        }
        if (sVar == null) {
            T(10);
        }
        if (fVar == null) {
            T(11);
        }
        if (kind == null) {
            T(12);
        }
        if (e1Var == null) {
            T(13);
        }
        return new k0(kVar, null, gVar, modality, sVar, z5, fVar, kind, e1Var, z6, z7, z8, z9, z10, z11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.w0, kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public <V> V N(a.InterfaceC0876a<V> interfaceC0876a) {
        return null;
    }

    public void Q0(@Nullable l0 l0Var, @Nullable y0 y0Var) {
        R0(l0Var, y0Var, null, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected k0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull Modality modality, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar, boolean z5, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull CallableMemberDescriptor.Kind kind, @NotNull e1 e1Var, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11) {
        super(kVar, gVar, fVar, null, z5, e1Var);
        if (kVar == null) {
            T(0);
        }
        if (gVar == null) {
            T(1);
        }
        if (modality == null) {
            T(2);
        }
        if (sVar == null) {
            T(3);
        }
        if (fVar == null) {
            T(4);
        }
        if (kind == null) {
            T(5);
        }
        if (e1Var == null) {
            T(6);
        }
        this.f44776m = null;
        this.f44785v = Collections.EMPTY_LIST;
        this.f44774k = modality;
        this.f44775l = sVar;
        this.f44777n = w0Var == null ? this : w0Var;
        this.f44778o = kind;
        this.f44779p = z6;
        this.f44780q = z7;
        this.f44781r = z8;
        this.f44782s = z9;
        this.f44783t = z10;
        this.f44784u = z11;
    }

    @NotNull
    private e1 O0(boolean z5, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var) {
        e1 e1Var;
        if (z5) {
            if (w0Var == null) {
                w0Var = a();
            }
            e1Var = w0Var.getSource();
        } else {
            e1Var = e1.f44683a;
        }
        if (e1Var == null) {
            T(28);
        }
        return e1Var;
    }

    private static kotlin.reflect.jvm.internal.impl.descriptors.y P0(@NotNull h2 h2Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.v0 v0Var) {
        if (h2Var == null) {
            T(30);
        }
        if (v0Var == null) {
            T(31);
        }
        if (v0Var.x0() != null) {
            return v0Var.x0().c(h2Var);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void T(int r11) {
        /*
            Method dump skipped, instructions count: 538
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.k0.T(int):void");
    }

    private static kotlin.reflect.jvm.internal.impl.descriptors.s U0(kotlin.reflect.jvm.internal.impl.descriptors.s sVar, CallableMemberDescriptor.Kind kind) {
        return (kind == CallableMemberDescriptor.Kind.FAKE_OVERRIDE && kotlin.reflect.jvm.internal.impl.descriptors.r.g(sVar.f())) ? kotlin.reflect.jvm.internal.impl.descriptors.r.f44951h : sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.w0, kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public List<z0> A0() {
        List<z0> list = this.f44785v;
        if (list == null) {
            T(22);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.s1
    public boolean B0() {
        return this.f44779p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w0
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.v D() {
        return this.D;
    }

    @NotNull
    protected k0 L0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull Modality modality, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var, @NotNull CallableMemberDescriptor.Kind kind, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull e1 e1Var) {
        if (kVar == null) {
            T(32);
        }
        if (modality == null) {
            T(33);
        }
        if (sVar == null) {
            T(34);
        }
        if (kind == null) {
            T(35);
        }
        if (fVar == null) {
            T(36);
        }
        if (e1Var == null) {
            T(37);
        }
        return new k0(kVar, w0Var, getAnnotations(), modality, sVar, C(), fVar, kind, e1Var, B0(), isConst(), q0(), i0(), isExternal(), X());
    }

    @Nullable
    protected kotlin.reflect.jvm.internal.impl.descriptors.w0 M0(@NotNull a aVar) {
        z0 z0Var;
        Function0<kotlin.reflect.jvm.internal.impl.storage.j<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>>> function0;
        if (aVar == null) {
            T(29);
        }
        k0 L0 = L0(aVar.f44790a, aVar.f44791b, aVar.f44792c, aVar.f44793d, aVar.f44795f, aVar.f44800k, O0(aVar.f44794e, aVar.f44793d));
        List<j1> typeParameters = aVar.f44799j == null ? getTypeParameters() : aVar.f44799j;
        ArrayList arrayList = new ArrayList(typeParameters.size());
        h2 b6 = kotlin.reflect.jvm.internal.impl.types.d0.b(typeParameters, aVar.f44796g, L0, arrayList);
        kotlin.reflect.jvm.internal.impl.types.t0 t0Var = aVar.f44801l;
        kotlin.reflect.jvm.internal.impl.types.t0 p5 = b6.p(t0Var, Variance.OUT_VARIANCE);
        if (p5 == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.types.t0 p6 = b6.p(t0Var, Variance.IN_VARIANCE);
        if (p6 != null) {
            L0.V0(p6);
        }
        z0 z0Var2 = aVar.f44798i;
        if (z0Var2 != null) {
            z0 c6 = z0Var2.c(b6);
            if (c6 == null) {
                return null;
            }
            z0Var = c6;
        } else {
            z0Var = null;
        }
        z0 z0Var3 = this.f44787x;
        z0 a12 = z0Var3 != null ? a1(b6, L0, z0Var3) : null;
        ArrayList arrayList2 = new ArrayList();
        Iterator<z0> it = this.f44785v.iterator();
        while (it.hasNext()) {
            z0 Z0 = Z0(b6, L0, it.next());
            if (Z0 != null) {
                arrayList2.add(Z0);
            }
        }
        L0.X0(p5, arrayList, z0Var, a12, arrayList2);
        l0 l0Var = this.f44789z == null ? null : new l0(L0, this.f44789z.getAnnotations(), aVar.f44791b, U0(this.f44789z.getVisibility(), aVar.f44795f), this.f44789z.Y(), this.f44789z.isExternal(), this.f44789z.isInline(), aVar.f44795f, aVar.o(), e1.f44683a);
        if (l0Var != null) {
            kotlin.reflect.jvm.internal.impl.types.t0 returnType = this.f44789z.getReturnType();
            l0Var.I0(P0(b6, this.f44789z));
            l0Var.L0(returnType != null ? b6.p(returnType, Variance.OUT_VARIANCE) : null);
        }
        m0 m0Var = this.A == null ? null : new m0(L0, this.A.getAnnotations(), aVar.f44791b, U0(this.A.getVisibility(), aVar.f44795f), this.A.Y(), this.A.isExternal(), this.A.isInline(), aVar.f44795f, aVar.p(), e1.f44683a);
        if (m0Var != null) {
            List<q1> K0 = s.K0(m0Var, this.A.g(), b6, false, false, null);
            if (K0 == null) {
                L0.W0(true);
                K0 = Collections.singletonList(m0.K0(m0Var, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.m(aVar.f44790a).I(), this.A.g().get(0).getAnnotations()));
            }
            if (K0.size() != 1) {
                throw new IllegalStateException();
            }
            m0Var.I0(P0(b6, this.A));
            m0Var.M0(K0.get(0));
        }
        kotlin.reflect.jvm.internal.impl.descriptors.v vVar = this.C;
        r rVar = vVar == null ? null : new r(vVar.getAnnotations(), L0);
        kotlin.reflect.jvm.internal.impl.descriptors.v vVar2 = this.D;
        L0.R0(l0Var, m0Var, rVar, vVar2 == null ? null : new r(vVar2.getAnnotations(), L0));
        if (aVar.f44797h) {
            kotlin.reflect.jvm.internal.impl.utils.k a6 = kotlin.reflect.jvm.internal.impl.utils.k.a();
            Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.w0> it2 = e().iterator();
            while (it2.hasNext()) {
                a6.add(it2.next().c(b6));
            }
            L0.R(a6);
        }
        if (isConst() && (function0 = this.f44916i) != null) {
            L0.G0(this.f44915h, function0);
        }
        return L0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w0
    @Nullable
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public l0 getGetter() {
        return this.f44789z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w0
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.v O() {
        return this.C;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void R(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == 0) {
            T(40);
        }
        this.f44776m = collection;
    }

    public void R0(@Nullable l0 l0Var, @Nullable y0 y0Var, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.v vVar, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.v vVar2) {
        this.f44789z = l0Var;
        this.A = y0Var;
        this.C = vVar;
        this.D = vVar2;
    }

    public boolean S0() {
        return this.B;
    }

    @NotNull
    public a T0() {
        return new a();
    }

    public void V0(@NotNull kotlin.reflect.jvm.internal.impl.types.t0 t0Var) {
        if (t0Var == null) {
            T(14);
        }
    }

    public void W0(boolean z5) {
        this.B = z5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.t1
    public boolean X() {
        return this.f44784u;
    }

    public void X0(@NotNull kotlin.reflect.jvm.internal.impl.types.t0 t0Var, @NotNull List<? extends j1> list, @Nullable z0 z0Var, @Nullable z0 z0Var2, @NotNull List<z0> list2) {
        if (t0Var == null) {
            T(17);
        }
        if (list == null) {
            T(18);
        }
        if (list2 == null) {
            T(19);
        }
        F0(t0Var);
        this.f44788y = new ArrayList(list);
        this.f44787x = z0Var2;
        this.f44786w = z0Var;
        this.f44785v = list2;
    }

    public void Y0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar) {
        if (sVar == null) {
            T(20);
        }
        this.f44775l = sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.w0, kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public z0 c0() {
        return this.f44786w;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.w0, kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.w0> e() {
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.w0> collection = this.f44776m;
        if (collection == null) {
            collection = Collections.EMPTY_LIST;
        }
        if (collection == null) {
            T(41);
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.w0, kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public z0 f0() {
        return this.f44787x;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w0
    @Nullable
    public y0 getSetter() {
        return this.A;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.w0, kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public List<j1> getTypeParameters() {
        List<j1> list = this.f44788y;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.s getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.s sVar = this.f44775l;
        if (sVar == null) {
            T(25);
        }
        return sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    public CallableMemberDescriptor.Kind h() {
        CallableMemberDescriptor.Kind kind = this.f44778o;
        if (kind == null) {
            T(39);
        }
        return kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    @NotNull
    public Modality i() {
        Modality modality = this.f44774k;
        if (modality == null) {
            T(24);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean i0() {
        return this.f44782s;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.w0, kotlin.reflect.jvm.internal.impl.descriptors.s1
    public boolean isConst() {
        return this.f44780q;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean isExternal() {
        return this.f44783t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean q0() {
        return this.f44781r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w0
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.descriptors.v0> x() {
        ArrayList arrayList = new ArrayList(2);
        l0 l0Var = this.f44789z;
        if (l0Var != null) {
            arrayList.add(l0Var);
        }
        y0 y0Var = this.A;
        if (y0Var != null) {
            arrayList.add(y0Var);
        }
        return arrayList;
    }

    private static z0 Z0(h2 h2Var, kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var, z0 z0Var) {
        kotlin.reflect.jvm.internal.impl.types.t0 p5 = h2Var.p(z0Var.getType(), Variance.IN_VARIANCE);
        if (p5 == null) {
            return null;
        }
        return new n0(w0Var, new kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.c(w0Var, p5, ((kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.f) z0Var.getValue()).a(), z0Var.getValue()), z0Var.getAnnotations());
    }

    private static z0 a1(h2 h2Var, kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var, z0 z0Var) {
        kotlin.reflect.jvm.internal.impl.types.t0 p5 = h2Var.p(z0Var.getType(), Variance.IN_VARIANCE);
        if (p5 == null) {
            return null;
        }
        return new n0(w0Var, new kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.d(w0Var, p5, z0Var.getValue()), z0Var.getAnnotations());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.w0 e0(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.s sVar, CallableMemberDescriptor.Kind kind, boolean z5) {
        kotlin.reflect.jvm.internal.impl.descriptors.w0 n6 = T0().u(kVar).t(null).s(modality).w(sVar).r(kind).q(z5).n();
        if (n6 == null) {
            T(42);
        }
        return n6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R W(kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> mVar, D d6) {
        return mVar.c(this, d6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.w0, kotlin.reflect.jvm.internal.impl.descriptors.g1
    public kotlin.reflect.jvm.internal.impl.descriptors.w0 c(@NotNull h2 h2Var) {
        if (h2Var == null) {
            T(27);
        }
        return h2Var.k() ? this : T0().v(h2Var.j()).t(a()).n();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.w0, kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.types.t0 getReturnType() {
        kotlin.reflect.jvm.internal.impl.types.t0 type = getType();
        if (type == null) {
            T(23);
        }
        return type;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.w0, kotlin.reflect.jvm.internal.impl.descriptors.impl.n
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.w0 a() {
        kotlin.reflect.jvm.internal.impl.descriptors.w0 w0Var = this.f44777n;
        kotlin.reflect.jvm.internal.impl.descriptors.w0 a6 = w0Var == this ? this : w0Var.a();
        if (a6 == null) {
            T(38);
        }
        return a6;
    }
}
