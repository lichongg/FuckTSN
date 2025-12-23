package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import okhttp3.Route;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class RouteDatabase {

    @NotNull
    private final Set<Route> _failedRoutes = new LinkedHashSet();

    public final synchronized void connected(@NotNull Route route) {
        g0.p(route, "route");
        this._failedRoutes.remove(route);
    }

    public final synchronized void failed(@NotNull Route failedRoute) {
        g0.p(failedRoute, "failedRoute");
        this._failedRoutes.add(failedRoute);
    }

    @NotNull
    public final synchronized Set<Route> getFailedRoutes() {
        return f0.f6(this._failedRoutes);
    }

    public final synchronized boolean shouldPostpone(@NotNull Route route) {
        g0.p(route, "route");
        return this._failedRoutes.contains(route);
    }
}
