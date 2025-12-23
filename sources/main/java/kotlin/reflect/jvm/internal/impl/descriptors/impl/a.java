package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.f2;
import kotlin.reflect.jvm.internal.impl.types.h2;
import kotlin.reflect.jvm.internal.impl.types.j2;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class a extends z {

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ boolean f44690f = false;

    /* renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.name.f f44691b;

    /* renamed from: c, reason: collision with root package name */
    protected final kotlin.reflect.jvm.internal.impl.storage.i<e1> f44692c;

    /* renamed from: d, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<kotlin.reflect.jvm.internal.impl.resolve.scopes.k> f44693d;

    /* renamed from: e, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<z0> f44694e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.impl.a$a, reason: collision with other inner class name */
    class C0878a implements Function0<e1> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.impl.a$a$a, reason: collision with other inner class name */
        class C0879a implements Function1<kotlin.reflect.jvm.internal.impl.types.checker.g, e1> {
            C0879a() {
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e1 invoke(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
                kotlin.reflect.jvm.internal.impl.descriptors.f f6 = gVar.f(a.this);
                return f6 == null ? a.this.f44692c.invoke() : f6 instanceof i1 ? kotlin.reflect.jvm.internal.impl.types.w0.c((i1) f6, j2.g(f6.o().getParameters())) : f6 instanceof z ? j2.v(f6.o().a(gVar), ((z) f6).o0(gVar), this) : f6.s();
            }
        }

        C0878a() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e1 invoke() {
            a aVar = a.this;
            return j2.u(aVar, aVar.H(), new C0879a());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Function0<kotlin.reflect.jvm.internal.impl.resolve.scopes.k> {
        b() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.jvm.internal.impl.resolve.scopes.k invoke() {
            return new kotlin.reflect.jvm.internal.impl.resolve.scopes.g(a.this.H());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements Function0<z0> {
        c() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public z0 invoke() {
            return new t(a.this);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.z, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d a() {
        return this;
    }

    public a(@NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar) {
        if (nVar == null) {
            p0(0);
        }
        if (fVar == null) {
            p0(1);
        }
        this.f44691b = fVar;
        this.f44692c = nVar.e(new C0878a());
        this.f44693d = nVar.e(new b());
        this.f44694e = nVar.e(new c());
    }

    private static /* synthetic */ void p0(int i6) {
        String str = (i6 == 2 || i6 == 3 || i6 == 4 || i6 == 5 || i6 == 6 || i6 == 9 || i6 == 12 || i6 == 14 || i6 == 16 || i6 == 17 || i6 == 19 || i6 == 20) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i6 == 2 || i6 == 3 || i6 == 4 || i6 == 5 || i6 == 6 || i6 == 9 || i6 == 12 || i6 == 14 || i6 == 16 || i6 == 17 || i6 == 19 || i6 == 20) ? 2 : 3];
        switch (i6) {
            case 1:
                objArr[0] = CommonNetImpl.NAME;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            case 17:
            case 19:
            case 20:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 7:
            case 13:
                objArr[0] = "typeArguments";
                break;
            case 8:
            case 11:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 10:
            case 15:
                objArr[0] = "typeSubstitution";
                break;
            case 18:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i6 == 2) {
            objArr[1] = "getName";
        } else if (i6 == 3) {
            objArr[1] = "getOriginal";
        } else if (i6 == 4) {
            objArr[1] = "getUnsubstitutedInnerClassesScope";
        } else if (i6 == 5) {
            objArr[1] = "getThisAsReceiverParameter";
        } else if (i6 == 6) {
            objArr[1] = "getContextReceivers";
        } else if (i6 == 9 || i6 == 12 || i6 == 14 || i6 == 16) {
            objArr[1] = "getMemberScope";
        } else if (i6 == 17) {
            objArr[1] = "getUnsubstitutedMemberScope";
        } else if (i6 == 19) {
            objArr[1] = "substitute";
        } else if (i6 != 20) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        } else {
            objArr[1] = "getDefaultType";
        }
        switch (i6) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            case 17:
            case 19:
            case 20:
                break;
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
                objArr[2] = "getMemberScope";
                break;
            case 18:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i6 != 2 && i6 != 3 && i6 != 4 && i6 != 5 && i6 != 6 && i6 != 9 && i6 != 12 && i6 != 14 && i6 != 16 && i6 != 17 && i6 != 19 && i6 != 20) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g1
    @NotNull
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.d c(@NotNull h2 h2Var) {
        if (h2Var == null) {
            p0(18);
        }
        return h2Var.k() ? this : new y(this, h2Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k G() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k invoke = this.f44693d.invoke();
        if (invoke == null) {
            p0(4);
        }
        return invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.z
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k T(@NotNull f2 f2Var, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (f2Var == null) {
            p0(10);
        }
        if (gVar == null) {
            p0(11);
        }
        if (!f2Var.f()) {
            return new kotlin.reflect.jvm.internal.impl.resolve.scopes.t(o0(gVar), h2.g(f2Var));
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k o02 = o0(gVar);
        if (o02 == null) {
            p0(12);
        }
        return o02;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public z0 V() {
        z0 invoke = this.f44694e.invoke();
        if (invoke == null) {
            p0(5);
        }
        return invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.f getName() {
        kotlin.reflect.jvm.internal.impl.name.f fVar = this.f44691b;
        if (fVar == null) {
            p0(2);
        }
        return fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public List<z0> j0() {
        List<z0> list = Collections.EMPTY_LIST;
        if (list == null) {
            p0(6);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public e1 s() {
        e1 invoke = this.f44692c.invoke();
        if (invoke == null) {
            p0(20);
        }
        return invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k v0(@NotNull f2 f2Var) {
        if (f2Var == null) {
            p0(15);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k T = T(f2Var, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.r(kotlin.reflect.jvm.internal.impl.resolve.i.g(this)));
        if (T == null) {
            p0(16);
        }
        return T;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k H() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k o02 = o0(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.r(kotlin.reflect.jvm.internal.impl.resolve.i.g(this)));
        if (o02 == null) {
            p0(17);
        }
        return o02;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R W(kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> mVar, D d6) {
        return mVar.a(this, d6);
    }
}
