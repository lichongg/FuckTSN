package androidx.navigation;

import androidx.annotation.IdRes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ActivityNavigatorDestinationBuilderKt {
    public static final void activity(@NotNull NavGraphBuilder activity, @IdRes int i6, @NotNull Function1<? super ActivityNavigatorDestinationBuilder, n1> builder) {
        g0.q(activity, "$this$activity");
        g0.q(builder, "builder");
        Navigator navigator = activity.getProvider().getNavigator((Class<Navigator>) ActivityNavigator.class);
        g0.h(navigator, "getNavigator(clazz.java)");
        ActivityNavigatorDestinationBuilder activityNavigatorDestinationBuilder = new ActivityNavigatorDestinationBuilder((ActivityNavigator) navigator, i6);
        builder.invoke(activityNavigatorDestinationBuilder);
        activity.destination(activityNavigatorDestinationBuilder);
    }
}
