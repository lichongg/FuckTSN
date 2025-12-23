package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class n0 extends c {

    /* renamed from: e, reason: collision with root package name */
    static final /* synthetic */ boolean f44813e = false;

    /* renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.k f44814c;

    /* renamed from: d, reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h f44815d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h hVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        this(kVar, hVar, gVar, kotlin.reflect.jvm.internal.impl.name.h.f46363i);
        if (kVar == null) {
            T(0);
        }
        if (hVar == null) {
            T(1);
        }
        if (gVar == null) {
            T(2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h hVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar) {
        super(gVar, fVar);
        if (kVar == null) {
            T(3);
        }
        if (hVar == null) {
            T(4);
        }
        if (gVar == null) {
            T(5);
        }
        if (fVar == null) {
            T(6);
        }
        this.f44814c = kVar;
        this.f44815d = hVar;
    }

    private static /* synthetic */ void T(int i6) {
        String str = (i6 == 7 || i6 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i6 == 7 || i6 == 8) ? 2 : 3];
        switch (i6) {
            case 1:
            case 4:
                objArr[0] = "value";
                break;
            case 2:
            case 5:
                objArr[0] = "annotations";
                break;
            case 3:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 6:
                objArr[0] = CommonNetImpl.NAME;
                break;
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
                break;
            case 9:
                objArr[0] = "newOwner";
                break;
            case 10:
                objArr[0] = "outType";
                break;
        }
        if (i6 == 7) {
            objArr[1] = "getValue";
        } else if (i6 != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        switch (i6) {
            case 7:
            case 8:
                break;
            case 9:
                objArr[2] = "copy";
                break;
            case 10:
                objArr[2] = "setOutType";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i6 != 7 && i6 != 8) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.k b() {
        kotlin.reflect.jvm.internal.impl.descriptors.k kVar = this.f44814c;
        if (kVar == null) {
            T(8);
        }
        return kVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.z0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h getValue() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h hVar = this.f44815d;
        if (hVar == null) {
            T(7);
        }
        return hVar;
    }
}
