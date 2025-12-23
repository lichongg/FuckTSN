package com.beizi.fusion.events;

import com.beizi.fusion.events.a;
import com.beizi.fusion.events.a.C0134a;
import com.beizi.fusion.events.a.b;
import com.beizi.fusion.events.a.c;
import com.beizi.fusion.events.a.d;
import com.beizi.fusion.events.a.e;
import com.beizi.fusion.events.a.f;
import com.beizi.fusion.events.a.g;
import com.beizi.fusion.events.a.h;
import com.beizi.fusion.events.a.i;
import com.beizi.fusion.events.a.j;
import com.beizi.fusion.events.a.k;
import com.beizi.fusion.tool.aa;
import java.util.Observable;
import java.util.Observer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b implements Observer {

    /* renamed from: a, reason: collision with root package name */
    public a.i f13486a;

    /* renamed from: b, reason: collision with root package name */
    public a.h f13487b;

    /* renamed from: c, reason: collision with root package name */
    public a.k f13488c;

    /* renamed from: d, reason: collision with root package name */
    public a.g f13489d;

    /* renamed from: e, reason: collision with root package name */
    public a.d f13490e;

    /* renamed from: f, reason: collision with root package name */
    public a.e f13491f;

    /* renamed from: g, reason: collision with root package name */
    public a.f f13492g;

    /* renamed from: h, reason: collision with root package name */
    public a.c f13493h;

    /* renamed from: i, reason: collision with root package name */
    public a.b f13494i;

    /* renamed from: j, reason: collision with root package name */
    public a.j f13495j;

    /* renamed from: k, reason: collision with root package name */
    public a.C0134a f13496k;

    /* renamed from: l, reason: collision with root package name */
    private final a f13497l;

    /* renamed from: m, reason: collision with root package name */
    private EventBean f13498m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f13499n = false;

    public a a() {
        return this.f13497l;
    }

    public void a(boolean z5) {
        this.f13499n = z5;
    }

    public EventBean b() {
        return this.f13498m;
    }

    public boolean c() {
        return this.f13499n;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if ((observable instanceof a.l) && (obj instanceof EventBean)) {
            EventBean eventBean = (EventBean) obj;
            aa.a("BeiZis", "channel == " + eventBean.getBuyerId() + ",eventCode = " + eventBean.getEventCode() + ";buyerSpaceId:" + eventBean.getBuyerSpaceUuId() + ",srcType = " + eventBean.getBeiZiSrcType() + ",price = " + eventBean.getBeiZiPrice() + ",bidPrice = " + eventBean.getBidPrice() + ",eventId = " + eventBean.getReqId() + ",buyerSpaceId = " + eventBean.getBuyerSpaceId());
            EventCar.getInstance(com.beizi.fusion.c.b.a().e()).goRoad(eventBean);
        }
    }

    public b(EventBean eventBean) {
        this.f13498m = eventBean;
        a aVar = new a();
        this.f13497l = aVar;
        this.f13486a = aVar.new i();
        this.f13487b = aVar.new h();
        this.f13488c = aVar.new k();
        this.f13489d = aVar.new g();
        this.f13490e = aVar.new d();
        this.f13491f = aVar.new e();
        this.f13492g = aVar.new f();
        this.f13493h = aVar.new c();
        this.f13494i = aVar.new b();
        this.f13495j = aVar.new j();
        this.f13496k = aVar.new C0134a();
    }
}
