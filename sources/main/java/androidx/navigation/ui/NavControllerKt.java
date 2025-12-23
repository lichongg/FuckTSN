package androidx.navigation.ui;

import androidx.customview.widget.Openable;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.ui.AppBarConfiguration;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class NavControllerKt {
    public static final boolean navigateUp(@NotNull NavController navigateUp, @Nullable Openable openable) {
        g0.q(navigateUp, "$this$navigateUp");
        NavGraph graph = navigateUp.getGraph();
        g0.h(graph, "graph");
        AppBarConfigurationKt$AppBarConfiguration$1 appBarConfigurationKt$AppBarConfiguration$1 = AppBarConfigurationKt$AppBarConfiguration$1.INSTANCE;
        AppBarConfiguration.Builder openableLayout = new AppBarConfiguration.Builder(graph).setOpenableLayout(openable);
        Object obj = appBarConfigurationKt$AppBarConfiguration$1;
        if (appBarConfigurationKt$AppBarConfiguration$1 != null) {
            obj = new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(appBarConfigurationKt$AppBarConfiguration$1);
        }
        AppBarConfiguration build = openableLayout.setFallbackOnNavigateUpListener((AppBarConfiguration.OnNavigateUpListener) obj).build();
        g0.h(build, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        return NavigationUI.navigateUp(navigateUp, build);
    }

    public static final boolean navigateUp(@NotNull NavController navigateUp, @NotNull AppBarConfiguration appBarConfiguration) {
        g0.q(navigateUp, "$this$navigateUp");
        g0.q(appBarConfiguration, "appBarConfiguration");
        return NavigationUI.navigateUp(navigateUp, appBarConfiguration);
    }
}
