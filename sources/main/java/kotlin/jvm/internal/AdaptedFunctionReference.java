package kotlin.jvm.internal;

import com.daimajia.numberprogressbar.BuildConfig;
import java.io.Serializable;
import kotlin.SinceKotlin;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SinceKotlin(version = BuildConfig.VERSION_NAME)
/* loaded from: D:\Downloads\app\classes8.dex */
public class AdaptedFunctionReference implements c0, Serializable {
    private final int arity;
    private final int flags;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private final String signature;

    public AdaptedFunctionReference(int i6, Class cls, String str, String str2, int i7) {
        this(i6, CallableReference.NO_RECEIVER, cls, str, str2, i7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdaptedFunctionReference)) {
            return false;
        }
        AdaptedFunctionReference adaptedFunctionReference = (AdaptedFunctionReference) obj;
        return this.isTopLevel == adaptedFunctionReference.isTopLevel && this.arity == adaptedFunctionReference.arity && this.flags == adaptedFunctionReference.flags && g0.g(this.receiver, adaptedFunctionReference.receiver) && g0.g(this.owner, adaptedFunctionReference.owner) && this.name.equals(adaptedFunctionReference.name) && this.signature.equals(adaptedFunctionReference.signature);
    }

    public AdaptedFunctionReference(int i6, Object obj, Class cls, String str, String str2, int i7) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = (i7 & 1) == 1;
        this.arity = i6;
        this.flags = i7 >> 1;
    }

    @Override // kotlin.jvm.internal.c0
    public int getArity() {
        return this.arity;
    }

    public kotlin.reflect.h getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? o0.g(cls) : o0.d(cls);
    }

    public int hashCode() {
        Object obj = this.receiver;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Class cls = this.owner;
        return ((((((((((hashCode + (cls != null ? cls.hashCode() : 0)) * 31) + this.name.hashCode()) * 31) + this.signature.hashCode()) * 31) + (this.isTopLevel ? 1231 : 1237)) * 31) + this.arity) * 31) + this.flags;
    }

    public String toString() {
        return o0.w(this);
    }
}
