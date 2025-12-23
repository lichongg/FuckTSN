package xyz.adscope.ad;

import android.content.Context;
import xyz.adscope.common.v2.singleton.IAbstractManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class c0 extends IAbstractManager<v1> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static c0 f54903a = new c0(null);
    }

    /* synthetic */ c0(a aVar) {
        this();
    }

    public static c0 a() {
        return b.f54903a;
    }

    private c0() {
        if (b.f54903a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // xyz.adscope.common.v2.singleton.IAbstractManager
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public v1 createNewImpl(Context context) {
        return new b0(context);
    }
}
