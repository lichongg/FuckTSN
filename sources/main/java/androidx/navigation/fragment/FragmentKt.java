package androidx.navigation.fragment;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class FragmentKt {
    @NotNull
    public static final NavController findNavController(@NotNull Fragment findNavController) {
        g0.q(findNavController, "$this$findNavController");
        NavController findNavController2 = NavHostFragment.findNavController(findNavController);
        g0.h(findNavController2, "NavHostFragment.findNavController(this)");
        return findNavController2;
    }
}
