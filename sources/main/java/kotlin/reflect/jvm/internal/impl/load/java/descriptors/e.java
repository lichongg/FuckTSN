package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import com.acse.ottn.l3;
import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.descriptors.s;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class e extends o0 implements kotlin.reflect.jvm.internal.impl.load.java.descriptors.a {
    public static final a.InterfaceC0876a<q1> G = new a();
    public static final a.InterfaceC0876a<Boolean> H = new b();
    static final /* synthetic */ boolean I = false;
    private c E;
    private final boolean F;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum c {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);


        /* renamed from: a, reason: collision with root package name */
        public final boolean f45422a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f45423b;

        private static /* synthetic */ void a(int i6) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", l3.f4736f));
        }

        @NotNull
        public static c b(boolean z5, boolean z6) {
            c cVar = z5 ? z6 ? STABLE_SYNTHESIZED : STABLE_DECLARED : z6 ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED;
            if (cVar == null) {
                a(0);
            }
            return cVar;
        }

        c(boolean z5, boolean z6) {
            this.f45422a = z5;
            this.f45423b = z6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements a.InterfaceC0876a<q1> {
        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b implements a.InterfaceC0876a<Boolean> {
        b() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected e(@NotNull k kVar, @Nullable d1 d1Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull CallableMemberDescriptor.Kind kind, @NotNull e1 e1Var, boolean z5) {
        super(kVar, d1Var, gVar, fVar, kind, e1Var);
        if (kVar == null) {
            T(0);
        }
        if (gVar == null) {
            T(1);
        }
        if (fVar == null) {
            T(2);
        }
        if (kind == null) {
            T(3);
        }
        if (e1Var == null) {
            T(4);
        }
        this.E = null;
        this.F = z5;
    }

    private static /* synthetic */ void T(int i6) {
        String str = (i6 == 13 || i6 == 18 || i6 == 21) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i6 == 13 || i6 == 18 || i6 == 21) ? 2 : 3];
        switch (i6) {
            case 1:
            case 6:
            case 16:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = CommonNetImpl.NAME;
                break;
            case 3:
            case 15:
                objArr[0] = "kind";
                break;
            case 4:
            case 8:
            case 17:
                objArr[0] = SocialConstants.PARAM_SOURCE;
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 9:
                objArr[0] = "contextReceiverParameters";
                break;
            case 10:
                objArr[0] = "typeParameters";
                break;
            case 11:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
                objArr[0] = "visibility";
                break;
            case 13:
            case 18:
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            case 14:
                objArr[0] = "newOwner";
                break;
            case 19:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i6 == 13) {
            objArr[1] = "initialize";
        } else if (i6 == 18) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i6 != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i6) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "createJavaMethod";
                break;
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "initialize";
                break;
            case 13:
            case 18:
            case 21:
                break;
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i6 != 13 && i6 != 18 && i6 != 21) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @NotNull
    public static e k1(@NotNull k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull e1 e1Var, boolean z5) {
        if (kVar == null) {
            T(5);
        }
        if (gVar == null) {
            T(6);
        }
        if (fVar == null) {
            T(7);
        }
        if (e1Var == null) {
            T(8);
        }
        return new e(kVar, null, gVar, fVar, CallableMemberDescriptor.Kind.DECLARATION, e1Var, z5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s
    public boolean L0() {
        return this.E.f45422a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.o0
    @NotNull
    public o0 j1(@Nullable z0 z0Var, @Nullable z0 z0Var2, @NotNull List<z0> list, @NotNull List<? extends j1> list2, @NotNull List<q1> list3, @Nullable t0 t0Var, @Nullable Modality modality, @NotNull s sVar, @Nullable Map<? extends a.InterfaceC0876a<?>, ?> map) {
        if (list == null) {
            T(9);
        }
        if (list2 == null) {
            T(10);
        }
        if (list3 == null) {
            T(11);
        }
        if (sVar == null) {
            T(12);
        }
        o0 j12 = super.j1(z0Var, z0Var2, list, list2, list3, t0Var, modality, sVar, map);
        a1(kotlin.reflect.jvm.internal.impl.util.s.f47421a.a(j12).a());
        if (j12 == null) {
            T(13);
        }
        return j12;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.o0, kotlin.reflect.jvm.internal.impl.descriptors.impl.s
    @NotNull
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public e G0(@NotNull k kVar, @Nullable y yVar, @NotNull CallableMemberDescriptor.Kind kind, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull e1 e1Var) {
        if (kVar == null) {
            T(14);
        }
        if (kind == null) {
            T(15);
        }
        if (gVar == null) {
            T(16);
        }
        if (e1Var == null) {
            T(17);
        }
        d1 d1Var = (d1) yVar;
        if (fVar == null) {
            fVar = getName();
        }
        e eVar = new e(kVar, d1Var, gVar, fVar, kind, e1Var, this.F);
        eVar.n1(L0(), n0());
        return eVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.a
    @NotNull
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public e k0(@Nullable t0 t0Var, @NotNull List<t0> list, @NotNull t0 t0Var2, @Nullable Pair<a.InterfaceC0876a<?>, ?> pair) {
        if (list == null) {
            T(19);
        }
        if (t0Var2 == null) {
            T(20);
        }
        e eVar = (e) n().n(h.a(list, g(), this)).h(t0Var2).b(t0Var == null ? null : kotlin.reflect.jvm.internal.impl.resolve.h.i(this, t0Var, kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b())).m().g().build();
        if (pair != null) {
            eVar.P0(pair.getFirst(), pair.getSecond());
        }
        if (eVar == null) {
            T(21);
        }
        return eVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.s, kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean n0() {
        return this.E.f45423b;
    }

    public void n1(boolean z5, boolean z6) {
        this.E = c.b(z5, z6);
    }
}
