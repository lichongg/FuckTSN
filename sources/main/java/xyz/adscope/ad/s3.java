package xyz.adscope.ad;

import android.content.Context;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.BidModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface s3 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        public static s3 a(Context context, BidModel bidModel, a2 a2Var, b1 b1Var) {
            return new v4(context, bidModel, a2Var, b1Var);
        }
    }

    BidModel a();

    a2 b();

    b1 c();

    Context getContext();
}
