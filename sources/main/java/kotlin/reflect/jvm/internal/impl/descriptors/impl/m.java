package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class m extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.b implements kotlin.reflect.jvm.internal.impl.descriptors.k {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.f f44807b;

    private static /* synthetic */ void T(int i6) {
        String str = (i6 == 2 || i6 == 3 || i6 == 5 || i6 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i6 == 2 || i6 == 3 || i6 == 5 || i6 == 6) ? 2 : 3];
        switch (i6) {
            case 1:
                objArr[0] = CommonNetImpl.NAME;
                break;
            case 2:
            case 3:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
                break;
            case 4:
                objArr[0] = "descriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        if (i6 == 2) {
            objArr[1] = "getName";
        } else if (i6 == 3) {
            objArr[1] = "getOriginal";
        } else if (i6 == 5 || i6 == 6) {
            objArr[1] = "toString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        }
        if (i6 != 2 && i6 != 3) {
            if (i6 == 4) {
                objArr[2] = "toString";
            } else if (i6 != 5 && i6 != 6) {
                objArr[2] = "<init>";
            }
        }
        String format = String.format(str, objArr);
        if (i6 != 2 && i6 != 3 && i6 != 5 && i6 != 6) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar) {
        super(gVar);
        if (gVar == null) {
            T(0);
        }
        if (fVar == null) {
            T(1);
        }
        this.f44807b = fVar;
    }

    @NotNull
    public static String o0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            T(4);
        }
        try {
            String str = kotlin.reflect.jvm.internal.impl.renderer.m.f46584k.N(kVar) + "[" + kVar.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(kVar)) + "]";
            if (str == null) {
                T(5);
            }
            return str;
        } catch (Throwable unused) {
            String str2 = kVar.getClass().getSimpleName() + " " + kVar.getName();
            if (str2 == null) {
                T(6);
            }
            return str2;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.f getName() {
        kotlin.reflect.jvm.internal.impl.name.f fVar = this.f44807b;
        if (fVar == null) {
            T(2);
        }
        return fVar;
    }

    public String toString() {
        return o0(this);
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.k a() {
        return this;
    }
}
