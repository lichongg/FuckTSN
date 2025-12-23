package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.c;
import retrofit2.g;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class z {

    /* renamed from: c, reason: collision with root package name */
    private static final z f52227c = f();

    /* renamed from: a, reason: collision with root package name */
    private final boolean f52228a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final Constructor<MethodHandles.Lookup> f52229b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends z {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: retrofit2.z$a$a, reason: collision with other inner class name */
        static final class ExecutorC1010a implements Executor {

            /* renamed from: a, reason: collision with root package name */
            private final Handler f52230a = new Handler(Looper.getMainLooper());

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.f52230a.post(runnable);
            }

            ExecutorC1010a() {
            }
        }

        a() {
            super(Build.VERSION.SDK_INT >= 24);
        }

        @Override // retrofit2.z
        public Executor c() {
            return new ExecutorC1010a();
        }

        @Override // retrofit2.z
        @Nullable
        Object h(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            if (Build.VERSION.SDK_INT >= 26) {
                return super.h(method, cls, obj, objArr);
            }
            throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
        }
    }

    @Nullable
    Executor c() {
        return null;
    }

    private static z f() {
        return "Dalvik".equals(System.getProperty("java.vm.name")) ? new a() : new z(true);
    }

    static z g() {
        return f52227c;
    }

    List<? extends c.a> a(@Nullable Executor executor) {
        h hVar = new h(executor);
        return this.f52228a ? Arrays.asList(f.f52115a, hVar) : Collections.singletonList(hVar);
    }

    int b() {
        return this.f52228a ? 2 : 1;
    }

    List<? extends g.a> d() {
        return this.f52228a ? Collections.singletonList(q.f52180a) : Collections.EMPTY_LIST;
    }

    int e() {
        return this.f52228a ? 1 : 0;
    }

    @Nullable
    @IgnoreJRERequirement
    Object h(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        MethodHandle unreflectSpecial;
        MethodHandle bindTo;
        Object invokeWithArguments;
        Constructor<MethodHandles.Lookup> constructor = this.f52229b;
        unreflectSpecial = (constructor != null ? t.a(constructor.newInstance(cls, -1)) : MethodHandles.lookup()).unreflectSpecial(method, cls);
        bindTo = unreflectSpecial.bindTo(obj);
        invokeWithArguments = bindTo.invokeWithArguments(objArr);
        return invokeWithArguments;
    }

    @IgnoreJRERequirement
    boolean i(Method method) {
        boolean isDefault;
        if (!this.f52228a) {
            return false;
        }
        isDefault = method.isDefault();
        return isDefault;
    }

    z(boolean z5) {
        this.f52228a = z5;
        Constructor<MethodHandles.Lookup> constructor = null;
        if (z5) {
            try {
                constructor = s.a().getDeclaredConstructor(Class.class, Integer.TYPE);
                constructor.setAccessible(true);
            } catch (NoClassDefFoundError | NoSuchMethodException unused) {
            }
        }
        this.f52229b = constructor;
    }
}
