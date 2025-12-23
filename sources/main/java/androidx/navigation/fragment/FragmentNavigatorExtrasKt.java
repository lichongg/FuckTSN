package androidx.navigation.fragment;

import android.view.View;
import androidx.navigation.fragment.FragmentNavigator;
import kotlin.Pair;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class FragmentNavigatorExtrasKt {
    @NotNull
    public static final FragmentNavigator.Extras FragmentNavigatorExtras(@NotNull Pair<? extends View, String>... sharedElements) {
        g0.q(sharedElements, "sharedElements");
        FragmentNavigator.Extras.Builder builder = new FragmentNavigator.Extras.Builder();
        for (Pair<? extends View, String> pair : sharedElements) {
            builder.addSharedElement(pair.component1(), pair.component2());
        }
        FragmentNavigator.Extras build = builder.build();
        g0.h(build, "FragmentNavigator.Extras…      }\n        }.build()");
        return build;
    }
}
