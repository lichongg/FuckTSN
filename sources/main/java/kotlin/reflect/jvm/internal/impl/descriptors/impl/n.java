package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class n extends m implements kotlin.reflect.jvm.internal.impl.descriptors.l {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.descriptors.k f44811c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final e1 f44812d;

    private static /* synthetic */ void T(int i6) {
        String str = (i6 == 4 || i6 == 5 || i6 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i6 == 4 || i6 == 5 || i6 == 6) ? 2 : 3];
        switch (i6) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = CommonNetImpl.NAME;
                break;
            case 3:
                objArr[0] = SocialConstants.PARAM_SOURCE;
                break;
            case 4:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i6 == 4) {
            objArr[1] = "getOriginal";
        } else if (i6 == 5) {
            objArr[1] = "getContainingDeclaration";
        } else if (i6 != 6) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i6 != 4 && i6 != 5 && i6 != 6) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i6 != 4 && i6 != 5 && i6 != 6) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected n(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull e1 e1Var) {
        super(gVar, fVar);
        if (kVar == null) {
            T(0);
        }
        if (gVar == null) {
            T(1);
        }
        if (fVar == null) {
            T(2);
        }
        if (e1Var == null) {
            T(3);
        }
        this.f44811c = kVar;
        this.f44812d = e1Var;
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.k b() {
        kotlin.reflect.jvm.internal.impl.descriptors.k kVar = this.f44811c;
        if (kVar == null) {
            T(5);
        }
        return kVar;
    }

    @NotNull
    public e1 getSource() {
        e1 e1Var = this.f44812d;
        if (e1Var == null) {
            T(6);
        }
        return e1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.m, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.n a() {
        kotlin.reflect.jvm.internal.impl.descriptors.n nVar = (kotlin.reflect.jvm.internal.impl.descriptors.n) super.a();
        if (nVar == null) {
            T(4);
        }
        return nVar;
    }
}
