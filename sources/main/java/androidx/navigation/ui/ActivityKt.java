package androidx.navigation.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.ui.AppBarConfiguration;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ActivityKt {
    public static final void setupActionBarWithNavController(@NotNull AppCompatActivity setupActionBarWithNavController, @NotNull NavController navController, @Nullable DrawerLayout drawerLayout) {
        g0.q(setupActionBarWithNavController, "$this$setupActionBarWithNavController");
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
        NavigationUI.setupActionBarWithNavController(setupActionBarWithNavController, navController, build);
    }

    public static /* synthetic */ void setupActionBarWithNavController$default(AppCompatActivity appCompatActivity, NavController navController, AppBarConfiguration appBarConfiguration, int i6, Object obj) {
        if ((i6 & 2) != 0) {
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
        setupActionBarWithNavController(appCompatActivity, navController, appBarConfiguration);
    }

    public static final void setupActionBarWithNavController(@NotNull AppCompatActivity setupActionBarWithNavController, @NotNull NavController navController, @NotNull AppBarConfiguration configuration) {
        g0.q(setupActionBarWithNavController, "$this$setupActionBarWithNavController");
        g0.q(navController, "navController");
        g0.q(configuration, "configuration");
        NavigationUI.setupActionBarWithNavController(setupActionBarWithNavController, navController, configuration);
    }
}
