package kotlin.jvm.internal;

import com.daimajia.numberprogressbar.BuildConfig;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.SinceKotlin;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KParameter;
import kotlin.reflect.KVisibility;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class CallableReference implements kotlin.reflect.c, Serializable {

    @SinceKotlin(version = "1.1")
    public static final Object NO_RECEIVER = a.f43991a;

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    private final boolean isTopLevel;

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    private final String name;

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    private final Class owner;

    @SinceKotlin(version = "1.1")
    protected final Object receiver;
    private transient kotlin.reflect.c reflected;

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    private final String signature;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SinceKotlin(version = "1.2")
    private static class a implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        private static final a f43991a = new a();

        private Object readResolve() throws ObjectStreamException {
            return f43991a;
        }

        private a() {
        }
    }

    public CallableReference() {
        this(NO_RECEIVER);
    }

    protected abstract kotlin.reflect.c computeReflected();

    @SinceKotlin(version = "1.1")
    protected CallableReference(Object obj) {
        this(obj, null, null, null, false);
    }

    @SinceKotlin(version = "1.1")
    public kotlin.reflect.c compute() {
        kotlin.reflect.c cVar = this.reflected;
        if (cVar != null) {
            return cVar;
        }
        kotlin.reflect.c computeReflected = computeReflected();
        this.reflected = computeReflected;
        return computeReflected;
    }

    @SinceKotlin(version = "1.1")
    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // kotlin.reflect.c
    public String getName() {
        return this.name;
    }

    public kotlin.reflect.h getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? o0.g(cls) : o0.d(cls);
    }

    public String getSignature() {
        return this.signature;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    protected CallableReference(Object obj, Class cls, String str, String str2, boolean z5) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z5;
    }

    @Override // kotlin.reflect.c
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // kotlin.reflect.c
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    @Override // kotlin.reflect.b
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    @Override // kotlin.reflect.c
    public List<KParameter> getParameters() {
        return getReflected().getParameters();
    }

    @SinceKotlin(version = "1.1")
    protected kotlin.reflect.c getReflected() {
        kotlin.reflect.c compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.c
    public kotlin.reflect.r getReturnType() {
        return getReflected().getReturnType();
    }

    @Override // kotlin.reflect.c
    @SinceKotlin(version = "1.1")
    public List<kotlin.reflect.s> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // kotlin.reflect.c
    @SinceKotlin(version = "1.1")
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // kotlin.reflect.c
    @SinceKotlin(version = "1.1")
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // kotlin.reflect.c
    @SinceKotlin(version = "1.1")
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // kotlin.reflect.c
    @SinceKotlin(version = "1.1")
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // kotlin.reflect.c
    @SinceKotlin(version = "1.3")
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
