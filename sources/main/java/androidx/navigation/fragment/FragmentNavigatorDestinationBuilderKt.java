package androidx.navigation.fragment;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.Navigator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class FragmentNavigatorDestinationBuilderKt {
    public static final /* synthetic */ <F extends Fragment> void fragment(@NotNull NavGraphBuilder fragment, @IdRes int i6, @NotNull Function1<? super FragmentNavigatorDestinationBuilder, n1> builder) {
        g0.q(fragment, "$this$fragment");
        g0.q(builder, "builder");
        Navigator navigator = fragment.getProvider().getNavigator((Class<Navigator>) FragmentNavigator.class);
        g0.h(navigator, "getNavigator(clazz.java)");
        g0.y(4, "F");
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navigator, i6, o0.d(Fragment.class));
        builder.invoke(fragmentNavigatorDestinationBuilder);
        fragment.destination(fragmentNavigatorDestinationBuilder);
    }

    public static final /* synthetic */ <F extends Fragment> void fragment(@NotNull NavGraphBuilder fragment, @IdRes int i6) {
        g0.q(fragment, "$this$fragment");
        Navigator navigator = fragment.getProvider().getNavigator((Class<Navigator>) FragmentNavigator.class);
        g0.h(navigator, "getNavigator(clazz.java)");
        g0.y(4, "F");
        fragment.destination(new FragmentNavigatorDestinationBuilder((FragmentNavigator) navigator, i6, o0.d(Fragment.class)));
    }
}
