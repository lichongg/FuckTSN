package com.beizi.fusion.c;

import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import com.beizi.fusion.tool.ao;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class g extends d {

    /* renamed from: r, reason: collision with root package name */
    private float f13353r;

    /* renamed from: s, reason: collision with root package name */
    private float f13354s;

    /* renamed from: t, reason: collision with root package name */
    private int f13355t;

    @Override // com.beizi.fusion.c.d
    public com.beizi.fusion.work.a a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.work.a aVar) {
        long sleepTime = forwardBean.getSleepTime();
        if (!ao.b().equalsIgnoreCase(str) && !"BEIZI".equalsIgnoreCase(str)) {
            return aVar;
        }
        int i6 = this.f13355t;
        return i6 == 4 ? new com.beizi.fusion.work.b.b(this.f13317b, this.f13320e, this.f13321f, sleepTime, buyerBean, forwardBean, this, this.f13353r, this.f13354s) : i6 == 5 ? new com.beizi.fusion.work.b.c(this.f13317b, this.f13320e, this.f13321f, sleepTime, buyerBean, forwardBean, this, this.f13353r, this.f13354s) : new com.beizi.fusion.work.b.d(this.f13317b, this.f13320e, this.f13321f, sleepTime, buyerBean, forwardBean, this, this.f13353r, this.f13354s);
    }

    public void B() {
        com.beizi.fusion.work.a aVar = this.f13324i;
        if (aVar != null) {
            aVar.n();
        }
    }

    @Override // com.beizi.fusion.c.d
    protected void c() {
        AppEventId.getInstance(d.f13315a).setAppNativeRequest(this.f13328m);
        EventBean eventBean = this.f13318c;
        if (eventBean != null) {
            eventBean.setAdType("5");
        }
    }

    public int y() {
        String i6;
        com.beizi.fusion.work.a aVar = this.f13324i;
        if (aVar == null || (i6 = aVar.i()) == null) {
            return -1;
        }
        try {
            return Integer.parseInt(i6);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public g(Context context, String str, com.beizi.fusion.a aVar, long j6, int i6) {
        super(context, str, aVar, j6);
        this.f13355t = i6;
    }

    public void A() {
        k();
    }

    public void z() {
        j();
    }

    public void a(float f6, float f7) {
        this.f13353r = f6;
        this.f13354s = f7;
        a((ViewGroup) null);
    }
}
