package xyz.adscope.ad;

import android.content.Context;
import xyz.adscope.ad.h2;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.DisplayModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class r1 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final r1 f55926a = new r1(null);
    }

    /* synthetic */ r1(a aVar) {
        this();
    }

    public static r1 a() {
        return b.f55926a;
    }

    private r1() {
    }

    private h2 a(Context context, DisplayModel displayModel, h2.a aVar) {
        return new a5(context, displayModel, aVar);
    }

    public h2 b(Context context, DisplayModel displayModel, h2.a aVar) {
        if (displayModel != null) {
            return a(context, displayModel, aVar);
        }
        return null;
    }
}
