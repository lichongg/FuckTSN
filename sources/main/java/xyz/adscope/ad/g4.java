package xyz.adscope.ad;

import xyz.adscope.ad.h4;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.type.VideoModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class g4 implements j2<h4, VideoModel, Integer> {

    /* renamed from: a, reason: collision with root package name */
    private h4 f55169a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f55170b;

    public void b() {
        this.f55170b = false;
    }

    @Override // xyz.adscope.ad.j2
    public void a() {
        this.f55170b = true;
    }

    public void a(l2 l2Var, Integer num) {
        if (this.f55170b) {
            if (l2Var == h4.a.VIDEO_START) {
                this.f55169a.d(l2Var);
            }
            if (l2Var == h4.a.VIDEO_PROCESS) {
                this.f55169a.a(l2Var, num.intValue());
            }
            if (l2Var == h4.a.VIDEO_FINISHED) {
                this.f55169a.e(l2Var);
            }
            if (l2Var == h4.a.VIDEO_ERROR) {
                this.f55169a.f(l2Var);
            }
        }
    }

    @Override // xyz.adscope.ad.j2
    public void a(h4 h4Var) {
        this.f55169a = h4Var;
        h4Var.a(this);
    }
}
