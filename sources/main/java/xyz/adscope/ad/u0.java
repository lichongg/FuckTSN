package xyz.adscope.ad;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.NativeModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.down.DownloadInfoModel;
import xyz.adscope.ad.widget.activity.ASNPDlInfoDetailActivity;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class u0 extends z1 {
    @Override // xyz.adscope.ad.w2
    public void a(View view, int i6) {
        String str;
        if (view instanceof u5) {
            u5 u5Var = (u5) view;
            str = u5Var.getWhereDetailActivityTab();
            u5Var.e();
        } else {
            str = null;
        }
        DownloadInfoModel b6 = b();
        if (b6 != null) {
            a(view.getContext(), b6, str);
        }
    }

    private DownloadInfoModel b() {
        NativeModel nativeModel = this.f56207d;
        if (nativeModel == null || nativeModel.b() == null) {
            return null;
        }
        return this.f56207d.b();
    }

    private void a(Context context, DownloadInfoModel downloadInfoModel, String str) {
        Intent intent = new Intent(context, (Class<?>) ASNPDlInfoDetailActivity.class);
        intent.putExtra("dlm", downloadInfoModel.toJsonString());
        intent.putExtra("whichTab", str);
        n4.c(context, intent);
    }
}
