package xyz.adscope.ad;

import android.content.Context;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.BidModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
class v4 implements s3 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f56022a;

    /* renamed from: b, reason: collision with root package name */
    private final BidModel f56023b;

    /* renamed from: c, reason: collision with root package name */
    private final a2 f56024c;

    /* renamed from: d, reason: collision with root package name */
    private final b1 f56025d;

    @Override // xyz.adscope.ad.s3
    public BidModel a() {
        return this.f56023b;
    }

    @Override // xyz.adscope.ad.s3
    public a2 b() {
        return this.f56024c;
    }

    @Override // xyz.adscope.ad.s3
    public b1 c() {
        return this.f56025d;
    }

    @Override // xyz.adscope.ad.s3
    public Context getContext() {
        return this.f56022a;
    }

    v4(Context context, BidModel bidModel, a2 a2Var, b1 b1Var) {
        this.f56022a = context;
        this.f56023b = bidModel;
        this.f56024c = a2Var;
        this.f56025d = b1Var;
    }
}
