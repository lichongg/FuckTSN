package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class j extends a {

    /* renamed from: g, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.k f44755g;

    /* renamed from: h, reason: collision with root package name */
    private final e1 f44756h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f44757i;

    private static /* synthetic */ void p0(int i6) {
        String str = (i6 == 4 || i6 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i6 == 4 || i6 == 5) ? 2 : 3];
        if (i6 == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i6 == 2) {
            objArr[0] = CommonNetImpl.NAME;
        } else if (i6 == 3) {
            objArr[0] = SocialConstants.PARAM_SOURCE;
        } else if (i6 == 4 || i6 == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[0] = "storageManager";
        }
        if (i6 == 4) {
            objArr[1] = "getContainingDeclaration";
        } else if (i6 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[1] = "getSource";
        }
        if (i6 != 4 && i6 != 5) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i6 != 4 && i6 != 5) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected j(@NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull e1 e1Var, boolean z5) {
        super(nVar, fVar);
        if (nVar == null) {
            p0(0);
        }
        if (kVar == null) {
            p0(1);
        }
        if (fVar == null) {
            p0(2);
        }
        if (e1Var == null) {
            p0(3);
        }
        this.f44755g = kVar;
        this.f44756h = e1Var;
        this.f44757i = z5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.l, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.k b() {
        kotlin.reflect.jvm.internal.impl.descriptors.k kVar = this.f44755g;
        if (kVar == null) {
            p0(4);
        }
        return kVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n
    @NotNull
    public e1 getSource() {
        e1 e1Var = this.f44756h;
        if (e1Var == null) {
            p0(5);
        }
        return e1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean isExternal() {
        return this.f44757i;
    }
}
