package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavArgs;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;
import kotlin.reflect.d;
import kotlin.s;
import l3.a;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class NavArgsLazy<Args extends NavArgs> implements s<Args> {
    private final Function0<Bundle> argumentProducer;
    private Args cached;
    private final d<Args> navArgsClass;

    public NavArgsLazy(@NotNull d<Args> navArgsClass, @NotNull Function0<Bundle> argumentProducer) {
        g0.q(navArgsClass, "navArgsClass");
        g0.q(argumentProducer, "argumentProducer");
        this.navArgsClass = navArgsClass;
        this.argumentProducer = argumentProducer;
    }

    @Override // kotlin.s
    @NotNull
    public Args getValue() {
        Args args = this.cached;
        if (args != null) {
            return args;
        }
        Bundle invoke = this.argumentProducer.invoke();
        Method method = NavArgsLazyKt.getMethodMap().get(this.navArgsClass);
        if (method == null) {
            Class e6 = a.e(this.navArgsClass);
            Class<Bundle>[] methodSignature = NavArgsLazyKt.getMethodSignature();
            method = e6.getMethod("fromBundle", (Class[]) Arrays.copyOf(methodSignature, methodSignature.length));
            NavArgsLazyKt.getMethodMap().put(this.navArgsClass, method);
            g0.h(method, "navArgsClass.java.getMet…hod\n                    }");
        }
        Object invoke2 = method.invoke(null, invoke);
        if (invoke2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type Args");
        }
        Args args2 = (Args) invoke2;
        this.cached = args2;
        return args2;
    }

    @Override // kotlin.s
    public boolean isInitialized() {
        return this.cached != null;
    }
}
