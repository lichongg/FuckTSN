package kotlin.jvm.internal;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.SinceKotlin;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class FunctionReference extends CallableReference implements c0, kotlin.reflect.i {
    private final int arity;

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    private final int flags;

    public FunctionReference(int i6) {
        this(i6, CallableReference.NO_RECEIVER, null, null, null, 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            return getName().equals(functionReference.getName()) && getSignature().equals(functionReference.getSignature()) && this.flags == functionReference.flags && this.arity == functionReference.arity && g0.g(getBoundReceiver(), functionReference.getBoundReceiver()) && g0.g(getOwner(), functionReference.getOwner());
        }
        if (obj instanceof kotlin.reflect.i) {
            return obj.equals(compute());
        }
        return false;
    }

    @SinceKotlin(version = "1.1")
    public FunctionReference(int i6, Object obj) {
        this(i6, obj, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.c0
    public int getArity() {
        return this.arity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.CallableReference
    @SinceKotlin(version = "1.1")
    public kotlin.reflect.i getReflected() {
        return (kotlin.reflect.i) super.getReflected();
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public FunctionReference(int i6, Object obj, Class cls, String str, String str2, int i7) {
        super(obj, cls, str, str2, (i7 & 1) == 1);
        this.arity = i6;
        this.flags = i7 >> 1;
    }

    @Override // kotlin.jvm.internal.CallableReference
    @SinceKotlin(version = "1.1")
    protected kotlin.reflect.c computeReflected() {
        return o0.c(this);
    }

    public int hashCode() {
        int hashCode;
        if (getOwner() == null) {
            hashCode = 0;
        } else {
            hashCode = getOwner().hashCode() * 31;
        }
        return ((hashCode + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // kotlin.reflect.i
    @SinceKotlin(version = "1.1")
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // kotlin.reflect.i
    @SinceKotlin(version = "1.1")
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // kotlin.reflect.i
    @SinceKotlin(version = "1.1")
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // kotlin.reflect.i
    @SinceKotlin(version = "1.1")
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
    @SinceKotlin(version = "1.1")
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        kotlin.reflect.c compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }
}
