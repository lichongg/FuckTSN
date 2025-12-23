package androidx.fragment.app;

import android.view.View;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ViewKt {
    @NotNull
    public static final <F extends Fragment> F findFragment(@NotNull View findFragment) {
        g0.q(findFragment, "$this$findFragment");
        F f6 = (F) FragmentManager.findFragment(findFragment);
        g0.h(f6, "FragmentManager.findFragment(this)");
        return f6;
    }
}
