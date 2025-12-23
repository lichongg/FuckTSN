package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.jvm.internal.g0;
import kotlin.l;
import okhttp3.internal.connection.RoutePlanner;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SequentialExchangeFinder implements ExchangeFinder {

    @NotNull
    private final RoutePlanner routePlanner;

    @Override // okhttp3.internal.connection.ExchangeFinder
    @NotNull
    public RealConnection find() {
        RoutePlanner.Plan plan;
        IOException iOException = null;
        while (!getRoutePlanner().isCanceled()) {
            try {
                plan = getRoutePlanner().plan();
            } catch (IOException e6) {
                if (iOException == null) {
                    iOException = e6;
                } else {
                    l.a(iOException, e6);
                }
                if (!c.a(getRoutePlanner(), null, 1, null)) {
                    throw iOException;
                }
            }
            if (!plan.isReady()) {
                RoutePlanner.ConnectResult mo293connectTcp = plan.mo293connectTcp();
                if (mo293connectTcp.isSuccess()) {
                    mo293connectTcp = plan.mo294connectTlsEtc();
                }
                RoutePlanner.Plan component2 = mo293connectTcp.component2();
                Throwable component3 = mo293connectTcp.component3();
                if (component3 != null) {
                    throw component3;
                }
                if (component2 != null) {
                    getRoutePlanner().getDeferredPlans().addFirst(component2);
                }
            }
            return plan.mo290handleSuccess();
        }
        throw new IOException("Canceled");
    }

    public SequentialExchangeFinder(@NotNull RoutePlanner routePlanner) {
        g0.p(routePlanner, "routePlanner");
        this.routePlanner = routePlanner;
    }

    @Override // okhttp3.internal.connection.ExchangeFinder
    @NotNull
    public RoutePlanner getRoutePlanner() {
        return this.routePlanner;
    }
}
