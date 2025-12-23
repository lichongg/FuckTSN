package xyz.adscope.ad;

import android.content.Context;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.DisplayModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.NativeModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class z1 implements w2, k2 {

    /* renamed from: a, reason: collision with root package name */
    protected x1 f56204a;

    /* renamed from: b, reason: collision with root package name */
    protected String f56205b;

    /* renamed from: c, reason: collision with root package name */
    protected DisplayModel f56206c;

    /* renamed from: d, reason: collision with root package name */
    protected NativeModel f56207d;

    /* renamed from: e, reason: collision with root package name */
    protected Context f56208e;

    @Override // xyz.adscope.ad.w2
    public void a(Context context, String str, DisplayModel displayModel) {
        this.f56208e = context;
        this.f56204a = a();
        this.f56205b = str;
        this.f56206c = displayModel;
        this.f56207d = displayModel != null ? displayModel.d() : null;
    }

    @Override // xyz.adscope.ad.k2
    public j2 c() {
        return this.f56204a;
    }

    protected x1 a() {
        return new x1();
    }
}
