package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class x0 extends w0 {

    /* renamed from: j, reason: collision with root package name */
    static final /* synthetic */ boolean f44913j = false;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f44914g;

    /* renamed from: h, reason: collision with root package name */
    protected kotlin.reflect.jvm.internal.impl.storage.j<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> f44915h;

    /* renamed from: i, reason: collision with root package name */
    protected Function0<kotlin.reflect.jvm.internal.impl.storage.j<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>>> f44916i;

    private static /* synthetic */ void T(int i6) {
        Object[] objArr = new Object[3];
        if (i6 == 1) {
            objArr[0] = "annotations";
        } else if (i6 == 2) {
            objArr[0] = CommonNetImpl.NAME;
        } else if (i6 == 3) {
            objArr[0] = SocialConstants.PARAM_SOURCE;
        } else if (i6 == 4 || i6 == 5) {
            objArr[0] = "compileTimeInitializerFactory";
        } else {
            objArr[0] = "containingDeclaration";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (i6 == 4) {
            objArr[2] = "setCompileTimeInitializerFactory";
        } else if (i6 != 5) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "setCompileTimeInitializer";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @Nullable kotlin.reflect.jvm.internal.impl.types.t0 t0Var, boolean z5, @NotNull e1 e1Var) {
        super(kVar, gVar, fVar, t0Var, e1Var);
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
        this.f44914g = z5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.s1
    public boolean C() {
        return this.f44914g;
    }

    public void G0(@Nullable kotlin.reflect.jvm.internal.impl.storage.j<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> jVar, @NotNull Function0<kotlin.reflect.jvm.internal.impl.storage.j<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>>> function0) {
        if (function0 == null) {
            T(5);
        }
        this.f44916i = function0;
        if (jVar == null) {
            jVar = function0.invoke();
        }
        this.f44915h = jVar;
    }

    public void H0(@NotNull Function0<kotlin.reflect.jvm.internal.impl.storage.j<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>>> function0) {
        if (function0 == null) {
            T(4);
        }
        G0(null, function0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.s1
    @Nullable
    public kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> t0() {
        kotlin.reflect.jvm.internal.impl.storage.j<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> jVar = this.f44915h;
        if (jVar != null) {
            return jVar.invoke();
        }
        return null;
    }
}
