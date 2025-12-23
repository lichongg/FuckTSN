package xyz.adscope.ad.publish.ad.unified.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import xyz.adscope.ad.a3;
import xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a;
import xyz.adscope.ad.h4;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.report.ReportModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class ASNPUnifiedExpressContainer extends a {
    public ASNPUnifiedExpressContainer(@NonNull Context context, String str) {
        super(context, str);
    }

    public ASNPUnifiedExpressContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ASNPUnifiedExpressContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }

    @Override // xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a
    protected void a(ReportModel reportModel, a3 a3Var, h4 h4Var) {
        super.a(reportModel, a3Var, h4Var);
        getMonitor().a();
    }

    public ASNPUnifiedExpressContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
    }
}
