package androidx.navigation;

import androidx.annotation.IdRes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class NavHostKt {
    @NotNull
    public static final NavGraph createGraph(@NotNull NavHost createGraph, @IdRes int i6, @IdRes int i7, @NotNull Function1<? super NavGraphBuilder, n1> builder) {
        g0.q(createGraph, "$this$createGraph");
        g0.q(builder, "builder");
        NavController navController = createGraph.getNavController();
        g0.h(navController, "navController");
        NavigatorProvider navigatorProvider = navController.getNavigatorProvider();
        g0.h(navigatorProvider, "navigatorProvider");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, i6, i7);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph createGraph$default(NavHost createGraph, int i6, int i7, Function1 builder, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i6 = 0;
        }
        g0.q(createGraph, "$this$createGraph");
        g0.q(builder, "builder");
        NavController navController = createGraph.getNavController();
        g0.h(navController, "navController");
        NavigatorProvider navigatorProvider = navController.getNavigatorProvider();
        g0.h(navigatorProvider, "navigatorProvider");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navigatorProvider, i6, i7);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }
}
