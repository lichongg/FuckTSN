package okhttp3.internal.connection;

import kotlin.jvm.internal.g0;
import okhttp3.internal.connection.RoutePlanner;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class FailedPlan implements RoutePlanner.Plan {
    private final boolean isReady;

    @NotNull
    private final RoutePlanner.ConnectResult result;

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* renamed from: handleSuccess, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ RealConnection mo290handleSuccess() {
        return (RealConnection) handleSuccess();
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    /* renamed from: retry, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ RoutePlanner.Plan mo291retry() {
        return (RoutePlanner.Plan) retry();
    }

    public FailedPlan(@NotNull Throwable e6) {
        g0.p(e6, "e");
        this.result = new RoutePlanner.ConnectResult(this, null, e6, 2, null);
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan, okhttp3.internal.http.ExchangeCodec.Carrier
    @NotNull
    /* renamed from: cancel, reason: merged with bridge method [inline-methods] */
    public Void mo289cancel() {
        throw new IllegalStateException("unexpected cancel");
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    @NotNull
    /* renamed from: connectTcp */
    public RoutePlanner.ConnectResult mo293connectTcp() {
        return this.result;
    }

    @Override // okhttp3.internal.connection.RoutePlanner.Plan
    @NotNull
    /* renamed from: connectTlsEtc */
    public RoutePlanner.ConnectResult mo294connectTlsEtc() {
        return this.result;
    }

    @NotNull
    public final RoutePlanner.ConnectResult getResult() {
        return this.result;
    }

    @NotNull
    public Void handleSuccess() {
        throw new IllegalStateException("unexpected call");
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
