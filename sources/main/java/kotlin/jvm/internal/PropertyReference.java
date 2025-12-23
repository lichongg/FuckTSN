package kotlin.jvm.internal;

import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.SinceKotlin;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class PropertyReference extends CallableReference implements kotlin.reflect.n {
    private final boolean syntheticJavaProperty;

    public PropertyReference() {
        this.syntheticJavaProperty = false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            return getOwner().equals(propertyReference.getOwner()) && getName().equals(propertyReference.getName()) && getSignature().equals(propertyReference.getSignature()) && g0.g(getBoundReceiver(), propertyReference.getBoundReceiver());
        }
        if (obj instanceof kotlin.reflect.n) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.c compute() {
        return this.syntheticJavaProperty ? this : super.compute();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.CallableReference
    @SinceKotlin(version = "1.1")
    public kotlin.reflect.n getReflected() {
        if (this.syntheticJavaProperty) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
        }
        return (kotlin.reflect.n) super.getReflected();
    }

    @SinceKotlin(version = "1.1")
    public PropertyReference(Object obj) {
        super(obj);
        this.syntheticJavaProperty = false;
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // kotlin.reflect.n
    @SinceKotlin(version = "1.1")
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // kotlin.reflect.n
    @SinceKotlin(version = "1.1")
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        kotlin.reflect.c compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    public PropertyReference(Object obj, Class cls, String str, String str2, int i6) {
        super(obj, cls, str, str2, (i6 & 1) == 1);
        this.syntheticJavaProperty = (i6 & 2) == 2;
    }
}
