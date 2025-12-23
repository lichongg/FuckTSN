package xyz.adscope.common.v2.encrypt;

import android.content.Context;
import xyz.adscope.common.v2.encrypt.impl.LinkedEncryptImpl;
import xyz.adscope.common.v2.singleton.IAbstractManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class LinkedEncryptManager extends IAbstractManager<ILinkedEncrypt> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.v2.encrypt.LinkedEncryptManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class InstanceHolder {
        private static LinkedEncryptManager instance = new LinkedEncryptManager(null);

        private InstanceHolder() {
        }
    }

    /* synthetic */ LinkedEncryptManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    private LinkedEncryptManager() {
        if (InstanceHolder.instance != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // xyz.adscope.common.v2.singleton.IAbstractManager
    public ILinkedEncrypt createNewImpl(Context context) {
        return new LinkedEncryptImpl();
    }

    public static LinkedEncryptManager getInstance() {
        return InstanceHolder.instance;
    }
}
