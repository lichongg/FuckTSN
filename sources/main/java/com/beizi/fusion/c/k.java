package com.beizi.fusion.c;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import com.beizi.fusion.tool.ao;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class k extends d {

    /* renamed from: r, reason: collision with root package name */
    private int f13365r;

    @Override // com.beizi.fusion.c.d
    public com.beizi.fusion.work.a a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.work.a aVar) {
        return (ao.b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new com.beizi.fusion.work.e.b(this.f13317b, forwardBean.getSleepTime(), buyerBean, forwardBean, this, this.f13365r) : aVar;
    }

    public void y() {
        a((ViewGroup) null);
    }

    @Override // com.beizi.fusion.c.d
    protected void c() {
        AppEventId.getInstance(d.f13315a).setAppNativeRequest(this.f13328m);
        EventBean eventBean = this.f13318c;
        if (eventBean != null) {
            eventBean.setAdType("5");
        }
    }

    public boolean z() {
        return this.f13327l;
    }

    public k(Context context, String str, com.beizi.fusion.a aVar, long j6, int i6) {
        super(context, str, aVar, j6);
        this.f13365r = i6;
    }

    public void A() {
        j();
    }

    public void B() {
        k();
    }

    public void a(Activity activity) {
        com.beizi.fusion.work.a aVar;
        if (activity == null || (aVar = this.f13324i) == null) {
            return;
        }
        aVar.a(activity);
    }
}
