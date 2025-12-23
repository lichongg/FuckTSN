package okhttp3.internal.connection;

import kotlin.jvm.internal.g0;
import okhttp3.internal.connection.RoutePlanner;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class ReusePlan implements RoutePlanner.Plan {

    @NotNull
    private final RealConnection connection;
    private final boolean isReady;

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* renamed from: connectTcp, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ RoutePlanner.ConnectResult mo293connectTcp() {
        return (RoutePlanner.ConnectResult) connectTcp();
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* renamed from: connectTlsEtc, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ RoutePlanner.ConnectResult mo294connectTlsEtc() {
        return (RoutePlanner.ConnectResult) connectTlsEtc();
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* renamed from: retry */
    public /* bridge */ /* synthetic */ RoutePlanner.Plan mo291retry() {
        return (RoutePlanner.Plan) retry();
    }

    public ReusePlan(@NotNull RealConnection connection) {
        g0.p(connection, "connection");
        this.connection = connection;
        this.isReady = true;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan, okhttp3.internal.http.ExchangeCodec.Carrier
    @NotNull
    /* renamed from: cancel, reason: merged with bridge method [inline-methods] */
    public Void mo289cancel() {
        throw new IllegalStateException("unexpected cancel");
    }

    @NotNull
    public Void connectTcp() {
        throw new IllegalStateException("already connected");
    }

    @NotNull
    public Void connectTlsEtc() {
        throw new IllegalStateException("already connected");
    }

    @NotNull
    public final RealConnection getConnection() {
        return this.connection;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    @NotNull
    /* renamed from: handleSuccess */
    public RealConnection mo290handleSuccess() {
        return this.connection;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    public boolean isReady() {
        return this.isReady;
    }

    @NotNull
    public Void retry() {
        throw new IllegalStateException("unexpected retry");
    }
}
