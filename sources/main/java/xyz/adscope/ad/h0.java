package xyz.adscope.ad;

import android.content.Context;
import xyz.adscope.common.v2.singleton.IAbstractManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class h0 extends IAbstractManager<w1> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static h0 f55186a = new h0(null);
    }

    /* synthetic */ h0(a aVar) {
        this();
    }

    public static h0 a() {
        return b.f55186a;
    }

    private h0() {
        if (b.f55186a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // xyz.adscope.common.v2.singleton.IAbstractManager
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public w1 createNewImpl(Context context) {
        return new g0(context);
    }
}
