package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.o1;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class k extends j {

    /* renamed from: p, reason: collision with root package name */
    static final /* synthetic */ boolean f44767p = false;

    /* renamed from: j, reason: collision with root package name */
    private final Modality f44768j;

    /* renamed from: k, reason: collision with root package name */
    private final ClassKind f44769k;

    /* renamed from: l, reason: collision with root package name */
    private final w1 f44770l;

    /* renamed from: m, reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.resolve.scopes.k f44771m;

    /* renamed from: n, reason: collision with root package name */
    private Set<kotlin.reflect.jvm.internal.impl.descriptors.c> f44772n;

    /* renamed from: o, reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.descriptors.c f44773o;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public o1<e1> g0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean i0() {
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
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.d s0() {
        return null;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Modality modality, @NotNull ClassKind classKind, @NotNull Collection<kotlin.reflect.jvm.internal.impl.types.t0> collection, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.e1 e1Var, boolean z5, @NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar) {
        super(nVar, kVar, fVar, e1Var, z5);
        if (kVar == null) {
            p0(0);
        }
        if (fVar == null) {
            p0(1);
        }
        if (modality == null) {
            p0(2);
        }
        if (classKind == null) {
            p0(3);
        }
        if (collection == null) {
            p0(4);
        }
        if (e1Var == null) {
            p0(5);
        }
        if (nVar == null) {
            p0(6);
        }
        this.f44768j = modality;
        this.f44769k = classKind;
        this.f44770l = new kotlin.reflect.jvm.internal.impl.types.v(this, Collections.EMPTY_LIST, collection, nVar);
    }

    public final void F0(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.k kVar, @NotNull Set<kotlin.reflect.jvm.internal.impl.descriptors.c> set, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.c cVar) {
        if (kVar == null) {
            p0(7);
        }
        if (set == null) {
            p0(8);
        }
        this.f44771m = kVar;
        this.f44772n = set;
        this.f44773o = cVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> f() {
        Set<kotlin.reflect.jvm.internal.impl.descriptors.c> set = this.f44772n;
        if (set == null) {
            p0(11);
        }
        return set;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g getAnnotations() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.g b6 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b();
        if (b6 == null) {
            p0(9);
        }
        return b6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.c0, kotlin.reflect.jvm.internal.impl.descriptors.o
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.s getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.s sVar = kotlin.reflect.jvm.internal.impl.descriptors.r.f44948e;
        if (sVar == null) {
            p0(17);
        }
        return sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public ClassKind h() {
        ClassKind classKind = this.f44769k;
        if (classKind == null) {
            p0(15);
        }
        return classKind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.c0
    @NotNull
    public Modality i() {
        Modality modality = this.f44768j;
        if (modality == null) {
            p0(16);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public w1 o() {
        w1 w1Var = this.f44770l;
        if (w1Var == null) {
            p0(10);
        }
        return w1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.z
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k o0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (gVar == null) {
            p0(12);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.k kVar = this.f44771m;
        if (kVar == null) {
            p0(13);
        }
        return kVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k r0() {
        k.c cVar = k.c.f46780b;
        if (cVar == null) {
            p0(14);
        }
        return cVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.g
    @NotNull
    public List<j1> t() {
        List<j1> list = Collections.EMPTY_LIST;
        if (list == null) {
            p0(18);
        }
        return list;
    }

    public String toString() {
        return "class " + getName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public kotlin.reflect.jvm.internal.impl.descriptors.c z() {
        return this.f44773o;
    }

    private static /* synthetic */ void p0(int i6) {
        String str;
        int i7;
        switch (i6) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i6) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
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
                objArr[0] = CommonNetImpl.NAME;
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "supertypes";
                break;
            case 5:
                objArr[0] = SocialConstants.PARAM_SOURCE;
                break;
            case 6:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 8:
                objArr[0] = "constructors";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 12:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i6) {
            case 9:
                objArr[1] = "getAnnotations";
                break;
            case 10:
                objArr[1] = "getTypeConstructor";
                break;
            case 11:
                objArr[1] = "getConstructors";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 14:
                objArr[1] = "getStaticScope";
                break;
            case 15:
                objArr[1] = "getKind";
                break;
            case 16:
                objArr[1] = "getModality";
                break;
            case 17:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i6) {
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                break;
            case 12:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i6) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(format);
            case 12:
            default:
                throw new IllegalArgumentException(format);
        }
    }
}
