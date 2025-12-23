package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.h1;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class b extends h {
    private static /* synthetic */ void T(int i6) {
        Object[] objArr = new Object[3];
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
            default:
                objArr[0] = "storageManager";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        objArr[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Variance variance, boolean z5, int i6, @NotNull e1 e1Var, @NotNull h1 h1Var) {
        super(nVar, kVar, gVar, fVar, variance, z5, i6, e1Var, h1Var);
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
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.m
    public String toString() {
        String str;
        String str2 = "";
        if (!j()) {
            str = "";
        } else {
            str = "reified ";
        }
        if (l() != Variance.INVARIANT) {
            str2 = l() + " ";
        }
        return String.format("%s%s%s", str, str2, getName());
    }
}
