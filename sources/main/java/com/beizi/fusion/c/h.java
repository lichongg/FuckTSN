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
public class h extends d {

    /* renamed from: r, reason: collision with root package name */
    private int f13356r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f13357s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f13358t;

    @Override // com.beizi.fusion.c.d
    protected void c() {
        AppEventId.getInstance(d.f13315a).setAppNativeRequest(this.f13328m);
        EventBean eventBean = this.f13318c;
        if (eventBean != null) {
            eventBean.setAdType("5");
        }
    }

    public void y() {
        a((ViewGroup) null);
    }

    public int A() {
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

    public void b(boolean z5) {
        this.f13357s = z5;
    }

    public boolean z() {
        return this.f13327l;
    }

    public h(Context context, String str, com.beizi.fusion.a aVar, long j6, int i6) {
        super(context, str, aVar, j6);
        this.f13356r = i6;
    }

    public void B() {
        j();
    }

    public void C() {
        k();
    }

    @Override // com.beizi.fusion.c.d
    public com.beizi.fusion.work.a a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.work.a aVar) {
        long sleepTime = forwardBean.getSleepTime();
        if (!ao.b().equalsIgnoreCase(str) && !"BEIZI".equalsIgnoreCase(str)) {
            return aVar;
        }
        return new com.beizi.fusion.work.c.b(this.f13317b, this.f13321f, sleepTime, buyerBean, forwardBean, this, this.f13356r, this.f13357s, this.f13358t);
    }

    public void c(boolean z5) {
        this.f13358t = z5;
    }
}
