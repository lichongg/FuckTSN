package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.h1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.t1;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class h extends n implements j1 {

    /* renamed from: e, reason: collision with root package name */
    private final Variance f44735e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f44736f;

    /* renamed from: g, reason: collision with root package name */
    private final int f44737g;

    /* renamed from: h, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<w1> f44738h;

    /* renamed from: i, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<e1> f44739i;

    /* renamed from: j, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.n f44740j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Function0<w1> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.storage.n f44741a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h1 f44742b;

        a(kotlin.reflect.jvm.internal.impl.storage.n nVar, h1 h1Var) {
            this.f44741a = nVar;
            this.f44742b = h1Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public w1 invoke() {
            return new c(h.this, this.f44741a, this.f44742b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Function0<e1> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.name.f f44744a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements Function0<kotlin.reflect.jvm.internal.impl.resolve.scopes.k> {
            a() {
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public kotlin.reflect.jvm.internal.impl.resolve.scopes.k invoke() {
                return kotlin.reflect.jvm.internal.impl.resolve.scopes.x.n("Scope for type parameter " + b.this.f44744a.b(), h.this.getUpperBounds());
            }
        }

        b(kotlin.reflect.jvm.internal.impl.name.f fVar) {
            this.f44744a = fVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e1 invoke() {
            return kotlin.reflect.jvm.internal.impl.types.w0.o(t1.f47332b.k(), h.this.o(), Collections.EMPTY_LIST, false, new kotlin.reflect.jvm.internal.impl.resolve.scopes.i(new a()));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c extends kotlin.reflect.jvm.internal.impl.types.q {

        /* renamed from: d, reason: collision with root package name */
        private final h1 f44747d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ h f44748e;

        @Override // kotlin.reflect.jvm.internal.impl.types.w1
        public boolean d() {
            return true;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull h hVar, kotlin.reflect.jvm.internal.impl.storage.n nVar, h1 h1Var) {
            super(nVar);
            if (nVar == null) {
                H(0);
            }
            this.f44748e = hVar;
            this.f44747d = h1Var;
        }

        private static /* synthetic */ void H(int i6) {
            String str = (i6 == 1 || i6 == 2 || i6 == 3 || i6 == 4 || i6 == 5 || i6 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i6 == 1 || i6 == 2 || i6 == 3 || i6 == 4 || i6 == 5 || i6 == 8) ? 2 : 3];
            switch (i6) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                    break;
                case 6:
                    objArr[0] = "type";
                    break;
                case 7:
                    objArr[0] = "supertypes";
                    break;
                case 9:
                    objArr[0] = "classifier";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i6 == 1) {
                objArr[1] = "computeSupertypes";
            } else if (i6 == 2) {
                objArr[1] = "getParameters";
            } else if (i6 == 3) {
                objArr[1] = "getDeclarationDescriptor";
            } else if (i6 == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i6 == 5) {
                objArr[1] = "getSupertypeLoopChecker";
            } else if (i6 != 8) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
            } else {
                objArr[1] = "processSupertypesWithoutCycles";
            }
            switch (i6) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    break;
                case 6:
                    objArr[2] = "reportSupertypeLoopError";
                    break;
                case 7:
                    objArr[2] = "processSupertypesWithoutCycles";
                    break;
                case 9:
                    objArr[2] = "isSameClassifier";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            if (i6 != 1 && i6 != 2 && i6 != 3 && i6 != 4 && i6 != 5 && i6 != 8) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.w, kotlin.reflect.jvm.internal.impl.types.w1
        @NotNull
        public kotlin.reflect.jvm.internal.impl.descriptors.f c() {
            h hVar = this.f44748e;
            if (hVar == null) {
                H(3);
            }
            return hVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.w
        protected boolean g(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f fVar) {
            if (fVar == null) {
                H(9);
            }
            return (fVar instanceof j1) && kotlin.reflect.jvm.internal.impl.resolve.g.f46707a.m(this.f44748e, (j1) fVar, true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.w1
        @NotNull
        public List<j1> getParameters() {
            List<j1> list = Collections.EMPTY_LIST;
            if (list == null) {
                H(2);
            }
            return list;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.w1
        @NotNull
        public kotlin.reflect.jvm.internal.impl.builtins.j p() {
            kotlin.reflect.jvm.internal.impl.builtins.j m6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.m(this.f44748e);
            if (m6 == null) {
                H(4);
            }
            return m6;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.q
        @NotNull
        protected Collection<kotlin.reflect.jvm.internal.impl.types.t0> r() {
            List<kotlin.reflect.jvm.internal.impl.types.t0> G0 = this.f44748e.G0();
            if (G0 == null) {
                H(1);
            }
            return G0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.q
        @Nullable
        protected kotlin.reflect.jvm.internal.impl.types.t0 s() {
            return kotlin.reflect.jvm.internal.impl.types.error.i.d(ErrorTypeKind.CYCLIC_UPPER_BOUNDS, new String[0]);
        }

        public String toString() {
            return this.f44748e.getName().toString();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.q
        @NotNull
        protected h1 v() {
            h1 h1Var = this.f44747d;
            if (h1Var == null) {
                H(5);
            }
            return h1Var;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.q
        @NotNull
        protected List<kotlin.reflect.jvm.internal.impl.types.t0> x(@NotNull List<kotlin.reflect.jvm.internal.impl.types.t0> list) {
            if (list == null) {
                H(7);
            }
            List<kotlin.reflect.jvm.internal.impl.types.t0> E0 = this.f44748e.E0(list);
            if (E0 == null) {
                H(8);
            }
            return E0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.q
        protected void z(@NotNull kotlin.reflect.jvm.internal.impl.types.t0 t0Var) {
            if (t0Var == null) {
                H(6);
            }
            this.f44748e.F0(t0Var);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    public boolean E() {
        return false;
    }

    protected abstract void F0(@NotNull kotlin.reflect.jvm.internal.impl.types.t0 t0Var);

    @NotNull
    protected abstract List<kotlin.reflect.jvm.internal.impl.types.t0> G0();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected h(@NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Variance variance, boolean z5, int i6, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.e1 e1Var, @NotNull h1 h1Var) {
        super(kVar, gVar, fVar, e1Var);
        if (nVar == null) {
            T(0);
        }
        if (kVar == null) {
            T(1);
        }
        if (gVar == null) {
            T(2);
        }
        if (fVar == null) {
            T(3);
        }
        if (variance == null) {
            T(4);
        }
        if (e1Var == null) {
            T(5);
        }
        if (h1Var == null) {
            T(6);
        }
        this.f44735e = variance;
        this.f44736f = z5;
        this.f44737g = i6;
        this.f44738h = nVar.e(new a(nVar, h1Var));
        this.f44739i = nVar.e(new b(fVar));
        this.f44740j = nVar;
    }

    @NotNull
    protected List<kotlin.reflect.jvm.internal.impl.types.t0> E0(@NotNull List<kotlin.reflect.jvm.internal.impl.types.t0> list) {
        if (list == null) {
            T(12);
        }
        if (list == null) {
            T(13);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    @NotNull
    public kotlin.reflect.jvm.internal.impl.storage.n d0() {
        kotlin.reflect.jvm.internal.impl.storage.n nVar = this.f44740j;
        if (nVar == null) {
            T(14);
        }
        return nVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    public int getIndex() {
        return this.f44737g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    public boolean j() {
        return this.f44736f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    @NotNull
    public Variance l() {
        Variance variance = this.f44735e;
        if (variance == null) {
            T(7);
        }
        return variance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1, kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public final w1 o() {
        w1 invoke = this.f44738h.invoke();
        if (invoke == null) {
            T(9);
        }
        return invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public e1 s() {
        e1 invoke = this.f44739i.invoke();
        if (invoke == null) {
            T(10);
        }
        return invoke;
    }

    private static /* synthetic */ void T(int i6) {
        String str;
        int i7;
        switch (i6) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i6) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                i7 = 2;
                break;
            case 12:
            default:
                i7 = 3;
                break;
        }
        Object[] objArr = new Object[i7];
        switch (i6) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = CommonNetImpl.NAME;
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = SocialConstants.PARAM_SOURCE;
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 12:
                objArr[0] = "bounds";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i6) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case 11:
                objArr[1] = "getOriginal";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 13:
                objArr[1] = "processBoundsWithoutCycles";
                break;
            case 14:
                objArr[1] = "getStorageManager";
                break;
        }
        switch (i6) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                break;
            case 12:
                objArr[2] = "processBoundsWithoutCycles";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i6) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                throw new IllegalStateException(format);
            case 12:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R W(kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> mVar, D d6) {
        return mVar.h(this, d6);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.n
    @NotNull
    public j1 a() {
        j1 j1Var = (j1) super.a();
        if (j1Var == null) {
            T(11);
        }
        return j1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.j1
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.types.t0> getUpperBounds() {
        List<kotlin.reflect.jvm.internal.impl.types.t0> i6 = ((c) o()).i();
        if (i6 == null) {
            T(8);
        }
        return i6;
    }
}
