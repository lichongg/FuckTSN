package xyz.adscope.ad;

import android.content.Context;
import xyz.adscope.common.v2.singleton.IAbstractManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class b extends IAbstractManager<xyz.adscope.ad.a> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.ad.b$b, reason: collision with other inner class name */
    private static class C1086b {

        /* renamed from: a, reason: collision with root package name */
        private static b f54835a = new b(null);
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    public static b a() {
        return C1086b.f54835a;
    }

    private b() {
        if (C1086b.f54835a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // xyz.adscope.common.v2.singleton.IAbstractManager
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public xyz.adscope.ad.a createNewImpl(Context context) {
        return new xyz.adscope.ad.a(context);
    }
}
