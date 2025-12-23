package xyz.adscope.ad;

import android.content.Context;
import android.view.View;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.MediaModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface w3 {
    void a();

    boolean a(MediaModel mediaModel);

    void b();

    View getExpressView();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        public static w3 a(Context context, a2 a2Var) {
            if (a2Var.getAdType() == c.UNIFIED) {
                return new j6(context, a2Var);
            }
            return new h6(context, a2Var);
        }
    }
}
