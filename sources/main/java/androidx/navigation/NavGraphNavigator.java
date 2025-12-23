package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.navigation.Navigator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Navigator.Name(NotificationCompat.CATEGORY_NAVIGATION)
/* loaded from: D:\Downloads\app\classes.dex */
public class NavGraphNavigator extends Navigator<NavGraph> {
    private final NavigatorProvider mNavigatorProvider;

    @Override // androidx.navigation.Navigator
    public boolean popBackStack() {
        return true;
    }

    @Override // androidx.navigation.Navigator
    @NonNull
    public NavGraph createDestination() {
        return new NavGraph(this);
    }

    @Override // androidx.navigation.Navigator
    @Nullable
    public NavDestination navigate(@NonNull NavGraph navGraph, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        int startDestination = navGraph.getStartDestination();
        if (startDestination == 0) {
            throw new IllegalStateException("no start destination defined via app:startDestination for " + navGraph.getDisplayName());
        }
        NavDestination findNode = navGraph.findNode(startDestination, false);
        if (findNode != null) {
            return this.mNavigatorProvider.getNavigator(findNode.getNavigatorName()).navigate(findNode, findNode.addInDefaultArgs(bundle), navOptions, extras);
        }
        throw new IllegalArgumentException("navigation destination " + navGraph.getStartDestDisplayName() + " is not a direct child of this NavGraph");
    }

    public NavGraphNavigator(@NonNull NavigatorProvider navigatorProvider) {
        this.mNavigatorProvider = navigatorProvider;
    }
}
