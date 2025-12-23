package xyz.adscope.common.v2.dev;

import android.content.Context;
import xyz.adscope.common.v2.singleton.IAbstractManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class DeviceObtainManager extends IAbstractManager<IDeviceInterface> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.v2.dev.DeviceObtainManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class InstanceHolder {
        private static DeviceObtainManager instance = new DeviceObtainManager(null);

        private InstanceHolder() {
        }
    }

    /* synthetic */ DeviceObtainManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    private DeviceObtainManager() {
        if (InstanceHolder.instance != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // xyz.adscope.common.v2.singleton.IAbstractManager
    public IDeviceInterface createNewImpl(Context context) {
        return new DeviceObtain(context);
    }

    public static DeviceObtainManager getInstance() {
        return InstanceHolder.instance;
    }
}
