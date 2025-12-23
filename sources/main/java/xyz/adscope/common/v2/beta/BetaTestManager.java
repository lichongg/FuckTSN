package xyz.adscope.common.v2.beta;

import android.content.Context;
import xyz.adscope.common.v2.singleton.IAbstractManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class BetaTestManager extends IAbstractManager<IBetaTest> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.v2.beta.BetaTestManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class InstanceHolder {
        private static BetaTestManager instance = new BetaTestManager(null);

        private InstanceHolder() {
        }
    }

    /* synthetic */ BetaTestManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    private BetaTestManager() {
        if (InstanceHolder.instance != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // xyz.adscope.common.v2.singleton.IAbstractManager
    public IBetaTest createNewImpl(Context context) {
        return new BetaTestImpl();
    }

    public static BetaTestManager getInstance() {
        return InstanceHolder.instance;
    }
}
