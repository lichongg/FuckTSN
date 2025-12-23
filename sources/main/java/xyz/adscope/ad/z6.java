package xyz.adscope.ad;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.optimize.OptimizeModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class z6 extends f1 {

    /* renamed from: d, reason: collision with root package name */
    private final boolean f56216d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f56217e;

    public boolean e() {
        return this.f56217e;
    }

    public boolean f() {
        return this.f56216d;
    }

    public z6(@NonNull Context context, OptimizeModel optimizeModel, boolean z5, boolean z6) {
        super(context, optimizeModel);
        this.f56216d = z5;
        this.f56217e = z6;
    }

    @Override // xyz.adscope.ad.f1
    public void a() {
        c();
        if (this.f55132c instanceof ViewGroup) {
            ((ViewGroup) this.f55132c).addView(this, new ViewGroup.LayoutParams(-1, -1));
        }
    }
}
