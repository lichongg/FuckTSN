package androidx.navigation;

import java.util.List;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@NavDestinationDsl
/* loaded from: D:\Downloads\app\classes.dex */
public class NavGraphBuilder extends NavDestinationBuilder<NavGraph> {
    private final List<NavDestination> destinations;

    @NotNull
    private final NavigatorProvider provider;
    private int startDestination;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public NavGraphBuilder(@org.jetbrains.annotations.NotNull androidx.navigation.NavigatorProvider r3, @androidx.annotation.IdRes int r4, @androidx.annotation.IdRes int r5) {
        /*
            r2 = this;
            java.lang.String r0 = "provider"
            kotlin.jvm.internal.g0.q(r3, r0)
            java.lang.Class<androidx.navigation.NavGraphNavigator> r0 = androidx.navigation.NavGraphNavigator.class
            androidx.navigation.Navigator r0 = r3.getNavigator(r0)
            java.lang.String r1 = "getNavigator(clazz.java)"
            kotlin.jvm.internal.g0.h(r0, r1)
            r2.<init>(r0, r4)
            r2.provider = r3
            r2.startDestination = r5
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r2.destinations = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavGraphBuilder.<init>(androidx.navigation.NavigatorProvider, int, int):void");
    }

    public final void addDestination(@NotNull NavDestination destination) {
        g0.q(destination, "destination");
        this.destinations.add(destination);
    }

    @Override // androidx.navigation.NavDestinationBuilder
    @NotNull
    public NavGraph build() {
        NavGraph navGraph = (NavGraph) super.build();
        navGraph.addDestinations(this.destinations);
        int i6 = this.startDestination;
        if (i6 == 0) {
            throw new IllegalStateException("You must set a startDestination");
        }
        navGraph.setStartDestination(i6);
        return navGraph;
    }

    public final <D extends NavDestination> void destination(@NotNull NavDestinationBuilder<? extends D> navDestination) {
        g0.q(navDestination, "navDestination");
        this.destinations.add(navDestination.build());
    }

    @NotNull
    public final NavigatorProvider getProvider() {
        return this.provider;
    }

    public final void unaryPlus(@NotNull NavDestination unaryPlus) {
        g0.q(unaryPlus, "$this$unaryPlus");
        addDestination(unaryPlus);
    }
}
