package xyz.adscope.ad;

import android.content.Context;
import java.util.List;
import xyz.adscope.common.v2.dev.DeviceObtainManager;
import xyz.adscope.common.v2.dev.IDeviceInterface;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private final IDeviceInterface f55257a;

    /* renamed from: b, reason: collision with root package name */
    private List<c1> f55258b;

    public void a(List<c1> list) {
        this.f55258b = list;
    }

    public List<c1> a() {
        return this.f55258b;
    }

    public IDeviceInterface b() {
        return this.f55257a;
    }

    j(Context context) {
        this.f55257a = DeviceObtainManager.getInstance().getOrCreateImplement(context);
    }
}
