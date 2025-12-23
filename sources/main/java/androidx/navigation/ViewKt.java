package androidx.navigation;

import android.view.View;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ViewKt {
    @NotNull
    public static final NavController findNavController(@NotNull View findNavController) {
        g0.q(findNavController, "$this$findNavController");
        NavController findNavController2 = Navigation.findNavController(findNavController);
        g0.h(findNavController2, "Navigation.findNavController(this)");
        return findNavController2;
    }
}
