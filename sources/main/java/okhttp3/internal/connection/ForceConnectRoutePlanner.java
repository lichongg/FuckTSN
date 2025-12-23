package okhttp3.internal.connection;

import kotlin.collections.m;
import kotlin.jvm.internal.g0;
import okhttp3.Address;
import okhttp3.HttpUrl;
import okhttp3.internal.connection.RoutePlanner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ForceConnectRoutePlanner implements RoutePlanner {

    @NotNull
    private final RealRoutePlanner delegate;

    public ForceConnectRoutePlanner(@NotNull RealRoutePlanner delegate) {
        g0.p(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    @NotNull
    public Address getAddress() {
        return this.delegate.getAddress();
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    @NotNull
    public m<RoutePlanner.Plan> getDeferredPlans() {
        return this.delegate.getDeferredPlans();
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public boolean hasNext(@Nullable RealConnection realConnection) {
        return this.delegate.hasNext(realConnection);
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public boolean isCanceled() {
        return this.delegate.isCanceled();
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    @NotNull
    public RoutePlanner.Plan plan() {
        return this.delegate.planConnect$okhttp();
    }

    @Override // okhttp3.internal.connection.RoutePlanner
    public boolean sameHostAndPort(@NotNull HttpUrl url) {
        g0.p(url, "url");
        return this.delegate.sameHostAndPort(url);
    }
}
