package xyz.adscope.common.analyse2.publish;

import android.content.Context;
import xyz.adscope.common.j;
import xyz.adscope.common.v2.singleton.IAbstractManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ScopeEventAnalyserManager extends IAbstractManager<IScopeEventAnalyser> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.analyse2.publish.ScopeEventAnalyserManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class InstanceHolder {
        private static ScopeEventAnalyserManager instance = new ScopeEventAnalyserManager(null);

        private InstanceHolder() {
        }
    }

    /* synthetic */ ScopeEventAnalyserManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    private ScopeEventAnalyserManager() {
        if (InstanceHolder.instance != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // xyz.adscope.common.v2.singleton.IAbstractManager
    public IScopeEventAnalyser createNewImpl(Context context) {
        return new j().a(context);
    }

    public static ScopeEventAnalyserManager getInstance() {
        return InstanceHolder.instance;
    }
}
