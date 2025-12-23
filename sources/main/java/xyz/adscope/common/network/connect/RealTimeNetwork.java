package xyz.adscope.common.network.connect;

import android.content.Context;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class RealTimeNetwork implements Network {

    /* renamed from: a, reason: collision with root package name */
    private final Context f56565a;

    /* renamed from: b, reason: collision with root package name */
    private final NetworkChecker f56566b;

    @Override // xyz.adscope.common.network.connect.Network
    public boolean isAvailable() {
        return this.f56566b.isAvailable();
    }

    public RealTimeNetwork(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f56565a = origApplicationContext;
        this.f56566b = new NetworkChecker(origApplicationContext);
    }
}
