package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class e2 extends d2 {

    /* renamed from: a, reason: collision with root package name */
    private final Variance f47209a;

    /* renamed from: b, reason: collision with root package name */
    private final t0 f47210b;

    public e2(@NotNull Variance variance, @NotNull t0 t0Var) {
        if (variance == null) {
            d(0);
        }
        if (t0Var == null) {
            d(1);
        }
        this.f47209a = variance;
        this.f47210b = t0Var;
    }

    private static /* synthetic */ void d(int i6) {
        String str = (i6 == 4 || i6 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i6 == 4 || i6 == 5) ? 2 : 3];
        switch (i6) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "type";
                break;
            case 4:
            case 5:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
                break;
            case 6:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "projection";
                break;
        }
        if (i6 == 4) {
            objArr[1] = "getProjectionKind";
        } else if (i6 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        } else {
            objArr[1] = "getType";
        }
        if (i6 == 3) {
            objArr[2] = "replaceType";
        } else if (i6 != 4 && i6 != 5) {
            if (i6 != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "refine";
            }
        }
        String format = String.format(str, objArr);
        if (i6 != 4 && i6 != 5) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.c2
    public boolean b() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.c2
    @NotNull
    public c2 a(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (gVar == null) {
            d(6);
        }
        return new e2(this.f47209a, gVar.a(this.f47210b));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.c2
    @NotNull
    public Variance c() {
        Variance variance = this.f47209a;
        if (variance == null) {
            d(4);
        }
        return variance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.c2
    @NotNull
    public t0 getType() {
        t0 t0Var = this.f47210b;
        if (t0Var == null) {
            d(5);
        }
        return t0Var;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e2(@NotNull t0 t0Var) {
        this(Variance.INVARIANT, t0Var);
        if (t0Var == null) {
            d(2);
        }
    }
}
