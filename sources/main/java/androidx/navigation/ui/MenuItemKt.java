package androidx.navigation.ui;

import android.view.MenuItem;
import androidx.navigation.NavController;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class MenuItemKt {
    public static final boolean onNavDestinationSelected(@NotNull MenuItem onNavDestinationSelected, @NotNull NavController navController) {
        g0.q(onNavDestinationSelected, "$this$onNavDestinationSelected");
        g0.q(navController, "navController");
        return NavigationUI.onNavDestinationSelected(onNavDestinationSelected, navController);
    }
}
