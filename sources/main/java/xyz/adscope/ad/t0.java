package xyz.adscope.ad;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.link.LinkModel;
import xyz.adscope.ad.n4;
import xyz.adscope.ad.y1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class t0 extends f2 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b implements n4.b {
        /* synthetic */ b(t0 t0Var, a aVar) {
            this();
        }

        private b() {
        }

        @Override // xyz.adscope.ad.n4.b
        public void a() {
            t0.this.a(y1.a.DEEPLINK_INVOKE_ASSUME_SUCCESS);
        }

        @Override // xyz.adscope.ad.n4.b
        public void b() {
            t0.this.a(y1.a.APP_NOT_INSTALLED);
        }

        @Override // xyz.adscope.ad.n4.b
        public void c() {
            t0.this.a(y1.a.APP_INSTALLED);
        }

        @Override // xyz.adscope.ad.n4.b
        public void d() {
            t0.this.a(y1.a.INVOKE_DEEPLINK);
        }

        @Override // xyz.adscope.ad.n4.b
        public void e() {
            t0.this.a(y1.a.DEEPLINK_INVOKE_SUCCESS);
        }

        @Override // xyz.adscope.ad.n4.b
        public void f() {
            t0.this.a(y1.a.DEEPLINK_INVOKE_FAILED);
        }
    }

    @Override // xyz.adscope.ad.f2
    protected void a(LinkModel linkModel, View view, int i6) {
        if (linkModel == null || view == null) {
            return;
        }
        String a6 = linkModel.a();
        if (TextUtils.isEmpty(a6) || !a(view.getContext(), a6)) {
            a(linkModel.d(), view.getContext());
        }
    }

    protected boolean a(Context context, String str) {
        return n4.a(context, str, new b(this, null));
    }

    protected void a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        n4.a(context, str, (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(y1.a aVar) {
        this.f56204a.a(aVar, null);
    }
}
