package xyz.adscope.common.analyse.publish;

import android.content.Context;
import xyz.adscope.common.k;
import xyz.adscope.common.v2.singleton.IAbstractManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class CommonAnalyserManager extends IAbstractManager<IEventAnalyser> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.analyse.publish.CommonAnalyserManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class InstanceHolder {
        private static CommonAnalyserManager instance = new CommonAnalyserManager(null);

        private InstanceHolder() {
        }
    }

    /* synthetic */ CommonAnalyserManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    private CommonAnalyserManager() {
        if (InstanceHolder.instance != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // xyz.adscope.common.v2.singleton.IAbstractManager
    public IEventAnalyser createNewImpl(Context context) {
        return new k().a(context);
    }

    public static CommonAnalyserManager getInstance() {
        return InstanceHolder.instance;
    }
}
