package androidx.navigation.fragment;

import androidx.annotation.IdRes;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.Navigator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class DialogFragmentNavigatorDestinationBuilderKt {
    public static final /* synthetic */ <F extends DialogFragment> void dialog(@NotNull NavGraphBuilder dialog, @IdRes int i6, @NotNull Function1<? super DialogFragmentNavigatorDestinationBuilder, n1> builder) {
        g0.q(dialog, "$this$dialog");
        g0.q(builder, "builder");
        Navigator navigator = dialog.getProvider().getNavigator((Class<Navigator>) DialogFragmentNavigator.class);
        g0.h(navigator, "getNavigator(clazz.java)");
        g0.y(4, "F");
        DialogFragmentNavigatorDestinationBuilder dialogFragmentNavigatorDestinationBuilder = new DialogFragmentNavigatorDestinationBuilder((DialogFragmentNavigator) navigator, i6, o0.d(DialogFragment.class));
        builder.invoke(dialogFragmentNavigatorDestinationBuilder);
        dialog.destination(dialogFragmentNavigatorDestinationBuilder);
    }

    public static final /* synthetic */ <F extends DialogFragment> void dialog(@NotNull NavGraphBuilder dialog, @IdRes int i6) {
        g0.q(dialog, "$this$dialog");
        Navigator navigator = dialog.getProvider().getNavigator((Class<Navigator>) DialogFragmentNavigator.class);
        g0.h(navigator, "getNavigator(clazz.java)");
        g0.y(4, "F");
        dialog.destination(new DialogFragmentNavigatorDestinationBuilder((DialogFragmentNavigator) navigator, i6, o0.d(DialogFragment.class)));
    }
}
