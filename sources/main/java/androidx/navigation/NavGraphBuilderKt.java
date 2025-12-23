package androidx.navigation;

import androidx.annotation.IdRes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class NavGraphBuilderKt {
    @NotNull
    public static final NavGraph navigation(@NotNull NavigatorProvider navigation, @IdRes int i6, @IdRes int i7, @NotNull Function1<? super NavGraphBuilder, n1> builder) {
        g0.q(navigation, "$this$navigation");
        g0.q(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigation, i6, i7);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static final void navigation(@NotNull NavGraphBuilder navigation, @IdRes int i6, @IdRes int i7, @NotNull Function1<? super NavGraphBuilder, n1> builder) {
        g0.q(navigation, "$this$navigation");
        g0.q(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigation.getProvider(), i6, i7);
        builder.invoke(navGraphBuilder);
        navigation.destination(navGraphBuilder);
    }

    public static /* synthetic */ NavGraph navigation$default(NavigatorProvider navigation, int i6, int i7, Function1 builder, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        g0.q(navigation, "$this$navigation");
        g0.q(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigation, i6, i7);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }
}
