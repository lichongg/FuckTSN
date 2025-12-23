package xyz.adscope.common.v2.crash;

import android.content.Context;
import xyz.adscope.common.v2.singleton.IAbstractManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ScopeCrashHandlerManager extends IAbstractManager<IScopeCrashHandler> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.v2.crash.ScopeCrashHandlerManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class InstanceHolder {
        private static ScopeCrashHandlerManager instance = new ScopeCrashHandlerManager(null);

        private InstanceHolder() {
        }
    }

    /* synthetic */ ScopeCrashHandlerManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    private ScopeCrashHandlerManager() {
        if (InstanceHolder.instance != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // xyz.adscope.common.v2.singleton.IAbstractManager
    public IScopeCrashHandler createNewImpl(Context context) {
        return new ScopeCrashHandler(context);
    }

    public static ScopeCrashHandlerManager getInstance() {
        return InstanceHolder.instance;
    }
}
