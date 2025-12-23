package androidx.navigation;

import android.app.Activity;
import androidx.annotation.IdRes;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ActivityKt {
    @NotNull
    public static final NavController findNavController(@NotNull Activity findNavController, @IdRes int i6) {
        g0.q(findNavController, "$this$findNavController");
        NavController findNavController2 = Navigation.findNavController(findNavController, i6);
        g0.h(findNavController2, "Navigation.findNavController(this, viewId)");
        return findNavController2;
    }
}
