package androidx.navigation.fragment;

import androidx.annotation.IdRes;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavDestinationBuilder;
import androidx.navigation.NavDestinationDsl;
import androidx.navigation.fragment.DialogFragmentNavigator;
import kotlin.jvm.internal.g0;
import kotlin.reflect.d;
import l3.a;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@NavDestinationDsl
/* loaded from: D:\Downloads\app\classes.dex */
public final class DialogFragmentNavigatorDestinationBuilder extends NavDestinationBuilder<DialogFragmentNavigator.Destination> {
    private final d<? extends DialogFragment> fragmentClass;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogFragmentNavigatorDestinationBuilder(@NotNull DialogFragmentNavigator navigator, @IdRes int i6, @NotNull d<? extends DialogFragment> fragmentClass) {
        super(navigator, i6);
        g0.q(navigator, "navigator");
        g0.q(fragmentClass, "fragmentClass");
        this.fragmentClass = fragmentClass;
    }

    @Override // androidx.navigation.NavDestinationBuilder
    @NotNull
    public DialogFragmentNavigator.Destination build() {
        DialogFragmentNavigator.Destination destination = (DialogFragmentNavigator.Destination) super.build();
        destination.setClassName(a.e(this.fragmentClass).getName());
        return destination;
    }
}
