package xyz.adscope.ad;

import android.content.Context;
import xyz.adscope.common.v2.singleton.IAbstractManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class k0 extends IAbstractManager<j0> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static k0 f55287a = new k0(null);
    }

    /* synthetic */ k0(a aVar) {
        this();
    }

    public static k0 a() {
        return b.f55287a;
    }

    private k0() {
        if (b.f55287a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // xyz.adscope.common.v2.singleton.IAbstractManager
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public j0 createNewImpl(Context context) {
        return new j0(context);
    }
}
