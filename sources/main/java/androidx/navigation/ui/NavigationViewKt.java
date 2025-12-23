package androidx.navigation.ui;

import androidx.navigation.NavController;
import com.google.android.material.navigation.NavigationView;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class NavigationViewKt {
    public static final void setupWithNavController(@NotNull NavigationView setupWithNavController, @NotNull NavController navController) {
        g0.q(setupWithNavController, "$this$setupWithNavController");
        g0.q(navController, "navController");
        NavigationUI.setupWithNavController(setupWithNavController, navController);
    }
}
