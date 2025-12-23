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
public class i extends d {

    /* renamed from: r, reason: collision with root package name */
    private int f13359r;

    /* renamed from: s, reason: collision with root package name */
    private String f13360s;

    /* renamed from: t, reason: collision with root package name */
    private String f13361t;

    @Override // com.beizi.fusion.c.d
    public com.beizi.fusion.work.a a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.work.a aVar) {
        return (ao.b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new com.beizi.fusion.work.d.a(this.f13317b, this.f13320e, this.f13321f, forwardBean.getSleepTime(), buyerBean, forwardBean, this) : aVar;
    }

    public void z() {
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

    @Override // com.beizi.fusion.c.d
    protected void c() {
        AppEventId.getInstance(d.f13315a).setAppRewardedVideoRequest(this.f13328m);
        EventBean eventBean = this.f13318c;
        if (eventBean != null) {
            eventBean.setAdType("1");
        }
    }

    public void h(String str) {
        this.f13360s = str;
    }

    public void i(String str) {
        this.f13361t = str;
    }

    public boolean y() {
        return this.f13327l;
    }

    public i(Context context, String str, com.beizi.fusion.a aVar, long j6, int i6) {
        super(context, str, aVar, j6);
        this.f13359r = i6;
    }

    public void B() {
        j();
    }

    public void a(Activity activity) {
        com.beizi.fusion.work.a aVar;
        if (activity == null || (aVar = this.f13324i) == null) {
            return;
        }
        aVar.a(activity);
    }
}
