package androidx.navigation.ui;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.ui.AppBarConfiguration;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class CollapsingToolbarLayoutKt {
    public static final void setupWithNavController(@NotNull CollapsingToolbarLayout setupWithNavController, @NotNull Toolbar toolbar, @NotNull NavController navController, @Nullable DrawerLayout drawerLayout) {
        g0.q(setupWithNavController, "$this$setupWithNavController");
        g0.q(toolbar, "toolbar");
        g0.q(navController, "navController");
        NavGraph graph = navController.getGraph();
        g0.h(graph, "navController.graph");
        AppBarConfigurationKt$AppBarConfiguration$1 appBarConfigurationKt$AppBarConfiguration$1 = AppBarConfigurationKt$AppBarConfiguration$1.INSTANCE;
        AppBarConfiguration.Builder openableLayout = new AppBarConfiguration.Builder(graph).setOpenableLayout(drawerLayout);
        Object obj = appBarConfigurationKt$AppBarConfiguration$1;
        if (appBarConfigurationKt$AppBarConfiguration$1 != null) {
            obj = new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(appBarConfigurationKt$AppBarConfiguration$1);
        }
        AppBarConfiguration build = openableLayout.setFallbackOnNavigateUpListener((AppBarConfiguration.OnNavigateUpListener) obj).build();
        g0.h(build, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        NavigationUI.setupWithNavController(setupWithNavController, toolbar, navController, build);
    }

    public static /* synthetic */ void setupWithNavController$default(CollapsingToolbarLayout collapsingToolbarLayout, Toolbar toolbar, NavController navController, AppBarConfiguration appBarConfiguration, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            NavGraph graph = navController.getGraph();
            g0.h(graph, "navController.graph");
            AppBarConfigurationKt$AppBarConfiguration$1 appBarConfigurationKt$AppBarConfiguration$1 = AppBarConfigurationKt$AppBarConfiguration$1.INSTANCE;
            AppBarConfiguration.Builder openableLayout = new AppBarConfiguration.Builder(graph).setOpenableLayout(null);
            Object obj2 = appBarConfigurationKt$AppBarConfiguration$1;
            if (appBarConfigurationKt$AppBarConfiguration$1 != null) {
                obj2 = new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(appBarConfigurationKt$AppBarConfiguration$1);
            }
            appBarConfiguration = openableLayout.setFallbackOnNavigateUpListener((AppBarConfiguration.OnNavigateUpListener) obj2).build();
            g0.h(appBarConfiguration, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        }
        setupWithNavController(collapsingToolbarLayout, toolbar, navController, appBarConfiguration);
    }

    public static final void setupWithNavController(@NotNull CollapsingToolbarLayout setupWithNavController, @NotNull Toolbar toolbar, @NotNull NavController navController, @NotNull AppBarConfiguration configuration) {
        g0.q(setupWithNavController, "$this$setupWithNavController");
        g0.q(toolbar, "toolbar");
        g0.q(navController, "navController");
        g0.q(configuration, "configuration");
        NavigationUI.setupWithNavController(setupWithNavController, toolbar, navController, configuration);
    }
}
