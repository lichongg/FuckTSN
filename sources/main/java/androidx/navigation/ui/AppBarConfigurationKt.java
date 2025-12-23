package androidx.navigation.ui;

import android.view.Menu;
import androidx.customview.widget.Openable;
import androidx.navigation.NavGraph;
import androidx.navigation.ui.AppBarConfiguration;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class AppBarConfigurationKt {
    @NotNull
    public static final AppBarConfiguration AppBarConfiguration(@NotNull NavGraph navGraph, @Nullable Openable openable, @NotNull Function0<Boolean> fallbackOnNavigateUpListener) {
        g0.q(navGraph, "navGraph");
        g0.q(fallbackOnNavigateUpListener, "fallbackOnNavigateUpListener");
        AppBarConfiguration build = new AppBarConfiguration.Builder(navGraph).setOpenableLayout(openable).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(fallbackOnNavigateUpListener)).build();
        g0.h(build, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        return build;
    }

    public static /* synthetic */ AppBarConfiguration AppBarConfiguration$default(NavGraph navGraph, Openable openable, Function0 fallbackOnNavigateUpListener, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            openable = null;
        }
        if ((i6 & 4) != 0) {
            fallbackOnNavigateUpListener = AppBarConfigurationKt$AppBarConfiguration$1.INSTANCE;
        }
        g0.q(navGraph, "navGraph");
        g0.q(fallbackOnNavigateUpListener, "fallbackOnNavigateUpListener");
        AppBarConfiguration build = new AppBarConfiguration.Builder(navGraph).setOpenableLayout(openable).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(fallbackOnNavigateUpListener)).build();
        g0.h(build, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        return build;
    }

    @NotNull
    public static final AppBarConfiguration AppBarConfiguration(@NotNull Menu topLevelMenu, @Nullable Openable openable, @NotNull Function0<Boolean> fallbackOnNavigateUpListener) {
        g0.q(topLevelMenu, "topLevelMenu");
        g0.q(fallbackOnNavigateUpListener, "fallbackOnNavigateUpListener");
        AppBarConfiguration build = new AppBarConfiguration.Builder(topLevelMenu).setOpenableLayout(openable).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(fallbackOnNavigateUpListener)).build();
        g0.h(build, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        return build;
    }

    public static /* synthetic */ AppBarConfiguration AppBarConfiguration$default(Menu topLevelMenu, Openable openable, Function0 fallbackOnNavigateUpListener, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            openable = null;
        }
        if ((i6 & 4) != 0) {
            fallbackOnNavigateUpListener = new Function0<Boolean>() { // from class: androidx.navigation.ui.AppBarConfigurationKt$AppBarConfiguration$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Boolean invoke() {
                    return Boolean.valueOf(invoke2());
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2() {
                    return false;
                }
            };
        }
        g0.q(topLevelMenu, "topLevelMenu");
        g0.q(fallbackOnNavigateUpListener, "fallbackOnNavigateUpListener");
        AppBarConfiguration build = new AppBarConfiguration.Builder(topLevelMenu).setOpenableLayout(openable).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(fallbackOnNavigateUpListener)).build();
        g0.h(build, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        return build;
    }

    @NotNull
    public static final AppBarConfiguration AppBarConfiguration(@NotNull Set<Integer> topLevelDestinationIds, @Nullable Openable openable, @NotNull Function0<Boolean> fallbackOnNavigateUpListener) {
        g0.q(topLevelDestinationIds, "topLevelDestinationIds");
        g0.q(fallbackOnNavigateUpListener, "fallbackOnNavigateUpListener");
        AppBarConfiguration build = new AppBarConfiguration.Builder(topLevelDestinationIds).setOpenableLayout(openable).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(fallbackOnNavigateUpListener)).build();
        g0.h(build, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        return build;
    }

    public static /* synthetic */ AppBarConfiguration AppBarConfiguration$default(Set topLevelDestinationIds, Openable openable, Function0 fallbackOnNavigateUpListener, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            openable = null;
        }
        if ((i6 & 4) != 0) {
            fallbackOnNavigateUpListener = new Function0<Boolean>() { // from class: androidx.navigation.ui.AppBarConfigurationKt$AppBarConfiguration$3
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Boolean invoke() {
                    return Boolean.valueOf(invoke2());
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2() {
                    return false;
                }
            };
        }
        g0.q(topLevelDestinationIds, "topLevelDestinationIds");
        g0.q(fallbackOnNavigateUpListener, "fallbackOnNavigateUpListener");
        AppBarConfiguration build = new AppBarConfiguration.Builder((Set<Integer>) topLevelDestinationIds).setOpenableLayout(openable).setFallbackOnNavigateUpListener(new AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(fallbackOnNavigateUpListener)).build();
        g0.h(build, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        return build;
    }
}
