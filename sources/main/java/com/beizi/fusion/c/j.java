package com.beizi.fusion.c;

import android.content.Context;
import android.view.View;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import com.beizi.fusion.tool.ao;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class j extends d {

    /* renamed from: r, reason: collision with root package name */
    private int f13362r;

    /* renamed from: s, reason: collision with root package name */
    private int f13363s;

    public j(Context context, String str, View view, com.beizi.fusion.a aVar, long j6) {
        super(context, str, aVar, j6);
        this.f13322g = view;
    }

    @Override // com.beizi.fusion.c.d
    public com.beizi.fusion.work.a a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.work.a aVar) {
        return (ao.b().equalsIgnoreCase(str) || "BEIZI".equalsIgnoreCase(str)) ? new com.beizi.fusion.work.splash.a(this.f13317b, this.f13320e, this.f13321f, this.f13322g, this.f13319d, buyerBean, forwardBean, list, y(), z(), this) : aVar;
    }

    @Override // com.beizi.fusion.c.d
    protected void c() {
        AppEventId.getInstance(d.f13315a).setAppSplashRequest(this.f13328m);
        EventBean eventBean = this.f13318c;
        if (eventBean != null) {
            eventBean.setAdType("2");
        }
    }

    public void A() {
        com.beizi.fusion.work.a aVar;
        if (this.f13330o || (aVar = this.f13324i) == null || this.f13329n) {
            return;
        }
        aVar.au();
        this.f13324i.e();
        this.f13329n = true;
    }

    public int B() {
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

    public Map D() {
        com.beizi.fusion.work.a aVar = this.f13324i;
        if (aVar == null) {
            return null;
        }
        return aVar.av();
    }

    public void b(int i6) {
        this.f13362r = i6;
    }

    public int y() {
        return this.f13362r;
    }

    public int z() {
        return this.f13363s;
    }

    public void C() {
        com.beizi.fusion.tool.e.b().c().execute(new Runnable() { // from class: com.beizi.fusion.c.j.1
            @Override // java.lang.Runnable
            public void run() {
                EventCar.getInstance(d.f13315a).goRoadWithoutThread(new EventBean(b.f13294b, "", "200.500", "", b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            }
        });
    }

    public void a(Context context) {
        try {
            com.beizi.fusion.work.a aVar = this.f13324i;
            if (aVar != null) {
                aVar.a(context);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void c(int i6) {
        this.f13363s = i6;
    }
}
