package com.beizi.fusion.work;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.beizi.fusion.NativeUnifiedAdResponse;
import com.beizi.fusion.c.c;
import com.beizi.fusion.c.d;
import com.beizi.fusion.c.e;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.b;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.ChannelBidResult;
import com.beizi.fusion.model.EventItem;
import com.beizi.fusion.tool.aa;
import java.util.Map;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class a extends Observable implements c {

    /* renamed from: a, reason: collision with root package name */
    protected b f14052a;

    /* renamed from: b, reason: collision with root package name */
    protected EventBean f14053b;

    /* renamed from: c, reason: collision with root package name */
    protected String f14054c;

    /* renamed from: d, reason: collision with root package name */
    protected d f14055d;

    /* renamed from: e, reason: collision with root package name */
    protected AdSpacesBean.BuyerBean f14056e;

    /* renamed from: f, reason: collision with root package name */
    protected AdSpacesBean.ForwardBean f14057f;

    /* renamed from: h, reason: collision with root package name */
    protected String f14059h;

    /* renamed from: i, reason: collision with root package name */
    protected String f14060i;

    /* renamed from: g, reason: collision with root package name */
    protected e f14058g = null;

    /* renamed from: j, reason: collision with root package name */
    protected com.beizi.fusion.e.a f14061j = com.beizi.fusion.e.a.ADDEFAULT;

    /* renamed from: n, reason: collision with root package name */
    private int f14065n = 0;

    /* renamed from: o, reason: collision with root package name */
    private int f14066o = 0;

    /* renamed from: p, reason: collision with root package name */
    private int f14067p = 0;

    /* renamed from: q, reason: collision with root package name */
    private int f14068q = 0;

    /* renamed from: r, reason: collision with root package name */
    private boolean f14069r = false;

    /* renamed from: s, reason: collision with root package name */
    private long f14070s = 0;

    /* renamed from: t, reason: collision with root package name */
    private boolean f14071t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f14072u = false;

    /* renamed from: v, reason: collision with root package name */
    private boolean f14073v = false;

    /* renamed from: w, reason: collision with root package name */
    private boolean f14074w = false;

    /* renamed from: x, reason: collision with root package name */
    private TimerTask f14075x = null;

    /* renamed from: y, reason: collision with root package name */
    private Timer f14076y = null;

    /* renamed from: z, reason: collision with root package name */
    private long f14077z = 0;
    private boolean A = false;
    private String B = "WATERFALL";
    private int C = 0;
    private boolean D = false;
    private boolean E = false;
    private String F = null;

    /* renamed from: k, reason: collision with root package name */
    protected int f14062k = 0;

    /* renamed from: l, reason: collision with root package name */
    protected long f14063l = 0;

    /* renamed from: m, reason: collision with root package name */
    @SuppressLint({"HandlerLeak"})
    protected Handler f14064m = new Handler(Looper.getMainLooper()) { // from class: com.beizi.fusion.work.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i6 = message.what;
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 == 3 && message.obj != null) {
                        a.this.a(message);
                        a.this.ae();
                        if (!a.this.c()) {
                            a.this.c(message.arg1);
                            return;
                        }
                        return;
                    }
                    return;
                }
                aa.b("BeiZis", "before handleAdClose");
                a.this.F();
                a.this.aa();
                return;
            }
            d dVar = a.this.f14055d;
            if (dVar != null && dVar.p() < 1 && a.this.f14055d.o() != 2) {
                a.this.k();
            }
        }
    };
    private boolean G = false;
    private boolean H = false;

    public void a(Activity activity) {
    }

    public NativeUnifiedAdResponse as() {
        return null;
    }

    public Map av() {
        return null;
    }

    public String aw() {
        return null;
    }

    public JSONObject ax() {
        return null;
    }

    public void b(ChannelBidResult channelBidResult) {
    }

    public boolean c() {
        return this.D;
    }

    public abstract void d();

    public abstract void e();

    public abstract String f();

    public abstract com.beizi.fusion.e.a h();

    public String i() {
        return null;
    }

    protected abstract void k();

    public View o() {
        return null;
    }

    private boolean ay() {
        b bVar = this.f14052a;
        return (bVar == null || bVar.c()) ? false : true;
    }

    private void az() {
        Timer timer;
        StringBuilder sb = new StringBuilder();
        sb.append("mAdLifeManager != null ? ");
        sb.append(this.f14055d != null);
        aa.c("BeiZis", sb.toString());
        if (this.f14055d != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("enter cancelExposureTaskIfNeed (System.currentTimeMillis() - mStartLoadTime) = ");
            sb2.append(System.currentTimeMillis() - this.f14077z);
            sb2.append(",mAdLifeManager.getValidExposureTime() = ");
            sb2.append(this.f14055d.r());
            sb2.append(",mExposureTimerTask != null ? ");
            sb2.append(this.f14075x != null);
            sb2.append(",mExposureTimer != null ? ");
            sb2.append(this.f14076y != null);
            aa.c("BeiZis", sb2.toString());
        }
        if (this.f14055d == null || System.currentTimeMillis() - this.f14077z >= this.f14055d.r() || this.f14075x == null || (timer = this.f14076y) == null) {
            return;
        }
        timer.cancel();
        W();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B() {
        if (this.f14052a != null) {
            aa.c("BeiZis", "channel " + this.f14054c + " reportAdShow mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f14052a.f13492g.a(this.f14054c));
            this.f14052a.f13492g.a(this.f14054c, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C() {
        if (this.f14052a != null) {
            aa.c("BeiZis", "channel " + this.f14054c + " reportAdExposure mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f14052a.f13492g.a(this.f14054c));
            this.f14052a.f13492g.a(this.f14054c, 6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D() {
        if (this.f14052a != null) {
            aa.c("BeiZis", "channel " + this.f14054c + " reportAdClick mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f14052a.f13492g.a(this.f14054c));
            this.f14052a.f13492g.a(this.f14054c, 7);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E() {
        if (this.f14052a != null) {
            aa.c("BeiZis", "channel " + this.f14054c + " reportAdClickCallBack mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f14052a.f13492g.a(this.f14054c));
            this.f14052a.f13492g.a(this.f14054c, 17);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F() {
        if (this.f14052a != null) {
            aa.c("BeiZis", "channel " + this.f14054c + " reportAdClose mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f14052a.f13492g.a(this.f14054c));
            this.f14052a.f13492g.a(this.f14054c, 9);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G() {
        if (this.f14052a != null) {
            aa.c("BeiZis", "channel " + this.f14054c + " reportAdClickClose mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f14052a.f13492g.a(this.f14054c));
            this.f14052a.f13492g.a(this.f14054c, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H() {
        if (this.f14052a != null) {
            aa.c("BeiZis", "channel " + this.f14054c + " reportAdClickCallBack mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f14052a.f13492g.a(this.f14054c));
            this.f14052a.f13492g.a(this.f14054c, 22);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I() {
        if (this.f14052a != null) {
            aa.c("BeiZis", "channel " + this.f14054c + " reportAdRewarded mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f14052a.f13492g.a(this.f14054c));
            this.f14052a.f13492g.a(this.f14054c, 12);
        }
    }

    public void J() {
        if (this.f14052a == null || this.E) {
            return;
        }
        aa.c("BeiZis", "channel " + this.f14054c + " reportParticipateBid mManagerObserver.mBidChannelStatus.getStatus(channel)  = " + this.f14052a.f13496k.a(this.f14054c));
        this.E = true;
    }

    protected void K() {
        if (this.f14052a != null) {
            aa.c("BeiZis", "channel " + this.f14054c + " reportParticipateBid mManagerObserver.mBidChannelStatus.getStatus(channel)  = " + this.f14052a.f13496k.a(this.f14054c));
        }
    }

    protected void L() {
        b bVar = this.f14052a;
        if (bVar != null) {
            bVar.f13493h.a(this.f14054c, 3);
            aa.a("BeiZis", "channel == ---reportComparisonSuccess---" + f());
        }
    }

    protected void M() {
        b bVar = this.f14052a;
        if (bVar != null) {
            bVar.f13493h.a(this.f14054c, 8);
            aa.a("BeiZis", "channel == ---reportComparisonSendWinNotification---" + f());
        }
    }

    protected void N() {
        b bVar = this.f14052a;
        if (bVar != null) {
            bVar.f13493h.a(this.f14054c, 9);
            aa.a("BeiZis", "channel == ---reportComparisonSendLossNotification---" + f());
        }
    }

    protected void O() {
        b bVar = this.f14052a;
        if (bVar != null) {
            bVar.f13493h.a(this.f14054c, 1);
            this.f14052a.f13493h.a(this.f14054c, 4);
        }
    }

    protected void Q() {
        b bVar = this.f14052a;
        if (bVar != null) {
            bVar.f13493h.a(this.f14054c, 4);
        }
    }

    protected void R() {
        if (this.f14052a != null) {
            aa.c("BeiZis", "channel " + this.f14054c + " reportChannelClickEnhance GrayPass mManagerObserver.mChannelClickEnhanceStatus.getStatus(channel)  = " + this.f14052a.f13494i.a(this.f14054c));
            this.f14052a.f13494i.a(this.f14054c, 1);
        }
    }

    protected void S() {
        if (this.f14052a != null) {
            aa.c("BeiZis", "channel " + this.f14054c + " reportChannelClickEnhance RandomPass mManagerObserver.mChannelClickEnhanceStatus.getStatus(channel)  = " + this.f14052a.f13494i.a(this.f14054c));
            this.f14052a.f13494i.a(this.f14054c, 2);
        }
    }

    protected void T() {
        if (this.f14052a != null) {
            aa.c("BeiZis", "channel " + this.f14054c + " reportChannelClickEnhance LayerPass mManagerObserver.mChannelClickEnhanceStatus.getStatus(channel)  = " + this.f14052a.f13494i.a(this.f14054c));
            this.f14052a.f13494i.a(this.f14054c, 3);
        }
    }

    protected void U() {
        if (this.f14052a != null) {
            aa.c("BeiZis", "channel " + this.f14054c + " reportChannelClickEnhance ReduceArea mManagerObserver.mChannelClickEnhanceStatus.getStatus(channel)  = " + this.f14052a.f13494i.a(this.f14054c));
            this.f14052a.f13494i.a(this.f14054c, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V() {
        if (this.f14052a != null) {
            aa.c("BeiZis", "channel " + this.f14054c + " reportValidTimeExposure mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f14052a.f13492g.a(this.f14054c));
            this.f14052a.f13492g.a(this.f14054c, 13);
        }
    }

    protected void W() {
        if (this.f14052a != null) {
            aa.c("BeiZis", "channel " + this.f14054c + " reportNotEnoughExposureTime mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f14052a.f13492g.a(this.f14054c));
            this.f14052a.f13492g.a(this.f14054c, 14);
        }
    }

    protected boolean X() {
        if (this.f14055d != null) {
            aa.c("BeiZis", "adStatus = " + this.f14055d.p());
        }
        d dVar = this.f14055d;
        return dVar != null && dVar.p() < 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Y() {
        d dVar = this.f14055d;
        if (dVar == null || !dVar.f()) {
            return false;
        }
        return am() || ak();
    }

    protected void Z() {
        if (this.f14058g == null && this.f14055d != null && ay()) {
            this.f14058g = this.f14055d.a(this);
        }
    }

    public void a(Context context) {
    }

    protected void aa() {
        if ((this.f14071t || this.f14055d == null) && !b(f())) {
            return;
        }
        this.f14055d.c(f());
        this.f14071t = true;
        if (this.A) {
            az();
        }
    }

    protected void ab() {
        if (this.f14055d == null || !an()) {
            return;
        }
        d dVar = this.f14055d;
        dVar.a("255.200", dVar.g(), new EventItem("255.200", String.valueOf(System.currentTimeMillis()), f(), this.f14060i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ac() {
        if (this.f14055d == null || !an()) {
            return;
        }
        d dVar = this.f14055d;
        dVar.a("280.300", dVar.g(), new EventItem("280.300", String.valueOf(System.currentTimeMillis()), f(), this.f14060i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ad() {
        if (this.f14055d == null || !an()) {
            return;
        }
        d dVar = this.f14055d;
        dVar.a("290.300", dVar.g(), new EventItem("290.300", String.valueOf(System.currentTimeMillis()), f(), this.f14060i));
    }

    protected void ae() {
        if (this.f14055d == null || !an()) {
            return;
        }
        d dVar = this.f14055d;
        dVar.a("280.500", dVar.g(), new EventItem("280.500", String.valueOf(System.currentTimeMillis()), f(), this.f14060i));
    }

    protected boolean ai() {
        return AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equalsIgnoreCase(g());
    }

    protected boolean aj() {
        return AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(g());
    }

    public boolean al() {
        return "BPDI".equalsIgnoreCase(g());
    }

    protected boolean an() {
        return "WATERFALL".equalsIgnoreCase(g());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao() {
        b bVar = this.f14052a;
        if (bVar != null) {
            bVar.a().a(this.f14054c, this.f14053b);
        }
    }

    public int aq() {
        return this.f14062k;
    }

    protected void ar() {
        if (this.f14052a == null || !AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equalsIgnoreCase(g())) {
            return;
        }
        aa.c("BeiZis", "channel " + this.f14054c + " reportC2SPrice mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f14052a.f13492g.a(this.f14054c));
        this.f14052a.f13492g.a(this.f14054c, 20);
    }

    public e at() {
        return this.f14058g;
    }

    public void b(Map map) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i6) {
        AdSpacesBean.BuyerBean buyerBean;
        if (this.f14061j == com.beizi.fusion.e.a.ADLOAD && (buyerBean = this.f14056e) != null && !TextUtils.isEmpty(buyerBean.getBuyerSpaceUuId()) && !TextUtils.isEmpty(this.f14055d.s()) && this.f14056e.getBuyerSpaceUuId().equals(this.f14055d.s())) {
            this.f14061j = com.beizi.fusion.e.a.ADFAIL;
            this.f14055d.a(this.f14056e.getBuyerSpaceUuId(), i6);
            return;
        }
        this.f14061j = com.beizi.fusion.e.a.ADFAIL;
        if (this.f14055d == null || this.f14057f == null) {
            return;
        }
        if (X()) {
            this.f14055d.a(this.f14057f.getComponent(), g(), true, i6);
        } else {
            aa.b("BeiZis", "fail distribute direct fail");
            this.f14055d.a(i6);
        }
    }

    public String g() {
        return this.B;
    }

    public AdSpacesBean.BuyerBean j() {
        return this.f14056e;
    }

    public void l() {
        Handler handler = this.f14064m;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public int p() {
        return this.f14067p;
    }

    protected void r() {
        d dVar = this.f14055d;
        if (dVar != null) {
            this.f14052a = dVar.a();
        }
        AdSpacesBean.BuyerBean buyerBean = this.f14056e;
        if (buyerBean != null) {
            this.f14054c = buyerBean.getBuyerSpaceUuId();
        }
    }

    protected void s() {
        b bVar = this.f14052a;
        if (bVar != null) {
            bVar.a().a(this.f14056e, this.f14057f);
        }
    }

    protected void t() {
        if (this.f14052a != null) {
            aa.c("BeiZis", "channel " + this.f14054c + " reportInitBegin mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f14052a.f13492g.a(this.f14054c));
            this.f14052a.f13492g.a(this.f14054c, 1);
        }
    }

    protected void u() {
        if (this.f14052a != null) {
            aa.c("BeiZis", "channel " + this.f14054c + " reportInitEnd mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f14052a.f13492g.a(this.f14054c));
            this.f14052a.f13492g.a(this.f14054c, 2);
        }
    }

    protected void v() {
        if (this.f14052a != null) {
            aa.c("BeiZis", "channel " + this.f14054c + " reportAdRequest mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f14052a.f13492g.a(this.f14054c));
            this.f14052a.f13492g.a(this.f14054c, 3);
        }
    }

    public boolean w() {
        return this.G;
    }

    private boolean b(String str) {
        return false;
    }

    protected void A() {
        if (ay()) {
            af();
            if (y()) {
                K();
                a(3);
            }
            aa.c("BeiZis", "channel " + this.f14054c + " reportAdLoadFail mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f14052a.f13492g.a(this.f14054c));
            if (!b()) {
                this.f14052a.f13492g.a(this.f14054c, 11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P() {
        O();
    }

    public void a(ChannelBidResult channelBidResult) {
    }

    protected void af() {
        if (ah()) {
            b(3);
        }
    }

    protected void ag() {
        if (p() != 3) {
            aa.a("BeiZisBid", "mWorker = " + this + ",set ad suc");
            b(2);
        }
    }

    public boolean ah() {
        return ai();
    }

    protected boolean ak() {
        if (!aj() && !ai()) {
            return false;
        }
        return true;
    }

    public boolean am() {
        if (!an() && !al()) {
            return false;
        }
        return true;
    }

    protected void ap() {
        A();
        d dVar = this.f14055d;
        if (dVar != null) {
            dVar.a(10140);
        }
    }

    public void au() {
        this.f14063l = System.currentTimeMillis() + 1000;
    }

    public void q() {
        L();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x() {
        if (ay()) {
            if (ai()) {
                ar();
            }
            if (y()) {
                a(2);
                J();
            }
            z();
            aa.c("BeiZis", "channel " + this.f14054c + " reportAdLoaded mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f14052a.f13492g.a(this.f14054c));
            if (!b()) {
                this.f14052a.f13492g.a(this.f14054c, 4);
            }
        }
    }

    protected boolean y() {
        if (ah() && !w()) {
            return true;
        }
        return false;
    }

    public void a(Map map) {
    }

    public void b(int i6) {
        this.f14067p = i6;
    }

    private boolean b() {
        return ah() && w();
    }

    public void a(String str) {
        this.B = str;
    }

    public void a(AdSpacesBean.ForwardBean forwardBean) {
        this.f14057f = forwardBean;
    }

    public void a(AdSpacesBean.BuyerBean buyerBean) {
        this.f14056e = buyerBean;
    }

    public void a(boolean z5) {
        this.f14069r = z5;
    }

    public void a(long j6) {
        this.f14070s = j6;
    }

    public void a(int i6) {
        this.f14065n = i6;
    }

    @Override // com.beizi.fusion.c.c
    public void a() {
        if (h() != com.beizi.fusion.e.a.ADSHOW) {
            Q();
        }
    }

    protected void a(Message message) {
        EventBean eventBean;
        if (this.f14052a == null || (eventBean = this.f14053b) == null) {
            return;
        }
        eventBean.setError(String.valueOf(message.obj));
        this.f14053b.setErrorCode(String.valueOf(message.arg1));
        ao();
        A();
        this.f14053b.setError(null);
        this.f14053b.setErrorCode(null);
        ao();
    }

    public void m() {
    }

    public void n() {
    }

    protected void z() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, int i6) {
        if (ay()) {
            Message obtainMessage = this.f14064m.obtainMessage(3, str);
            obtainMessage.arg1 = i6;
            this.f14064m.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(double d6) {
        if (d6 > 0.0d) {
            if ("BEIZI".equalsIgnoreCase(f())) {
                this.f14056e.setAvgPrice(d6);
                EventBean eventBean = this.f14053b;
                if (eventBean != null) {
                    eventBean.setBeiZiPrice(String.valueOf(d6));
                }
            }
            if (ak()) {
                this.f14056e.setBidPrice(d6);
                EventBean eventBean2 = this.f14053b;
                if (eventBean2 != null) {
                    eventBean2.setBidPrice(String.valueOf(d6));
                }
            }
            ao();
        }
    }
}
