package androidx.navigation;

import kotlin.jvm.internal.g0;
import kotlin.reflect.d;
import l3.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class NavigatorProviderKt {
    @NotNull
    public static final <T extends Navigator<? extends NavDestination>> T get(@NotNull NavigatorProvider get, @NotNull String name) {
        g0.q(get, "$this$get");
        g0.q(name, "name");
        T t5 = (T) get.getNavigator(name);
        g0.h(t5, "getNavigator(name)");
        return t5;
    }

    @NotNull
    public static final <T extends Navigator<? extends NavDestination>> T get(@NotNull NavigatorProvider get, @NotNull d<T> clazz) {
        g0.q(get, "$this$get");
        g0.q(clazz, "clazz");
        T t5 = (T) get.getNavigator(a.e(clazz));
        g0.h(t5, "getNavigator(clazz.java)");
        return t5;
    }

    public static final void plusAssign(@NotNull NavigatorProvider plusAssign, @NotNull Navigator<? extends NavDestination> navigator) {
        g0.q(plusAssign, "$this$plusAssign");
        g0.q(navigator, "navigator");
        plusAssign.addNavigator(navigator);
    }

    @Nullable
    public static final Navigator<? extends NavDestination> set(@NotNull NavigatorProvider set, @NotNull String name, @NotNull Navigator<? extends NavDestination> navigator) {
        g0.q(set, "$this$set");
        g0.q(name, "name");
        g0.q(navigator, "navigator");
        return set.addNavigator(name, navigator);
    }
}
