package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.navigation.Navigator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Navigator.Name("NoOp")
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public class NoOpNavigator extends Navigator<NavDestination> {
    @Override // androidx.navigation.Navigator
    public boolean popBackStack() {
        return true;
    }

    @Override // androidx.navigation.Navigator
    @NonNull
    public NavDestination createDestination() {
        return new NavDestination(this);
    }

    @Override // androidx.navigation.Navigator
    @Nullable
    public NavDestination navigate(@NonNull NavDestination navDestination, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        return navDestination;
    }
}
