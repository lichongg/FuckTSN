package com.beizi.fusion.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.beizi.fusion.AdListener;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.InterstitialAdListener;
import com.beizi.fusion.NativeAdListener;
import com.beizi.fusion.NativeUnifiedAdListener;
import com.beizi.fusion.RewardedVideoAdListener;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.ChannelBidResult;
import com.beizi.fusion.model.EventItem;
import com.beizi.fusion.model.Manager;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.tool.aa;
import com.beizi.fusion.tool.an;
import com.beizi.fusion.tool.ao;
import com.beizi.fusion.tool.ap;
import com.beizi.fusion.tool.m;
import com.beizi.fusion.tool.s;
import com.beizi.fusion.tool.z;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.stub.StubApp;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class d implements com.beizi.fusion.c.a, Observer {

    /* renamed from: a, reason: collision with root package name */
    protected static Context f13315a;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f13316r;
    private com.beizi.fusion.events.b F;
    private long G;
    private List<AdSpacesBean.BuyerBean> H;
    private z J;
    private a K;
    private boolean L;
    private long U;
    private Map<String, Object> V;
    private String X;

    /* renamed from: b, reason: collision with root package name */
    protected Context f13317b;

    /* renamed from: c, reason: collision with root package name */
    protected EventBean f13318c;

    /* renamed from: d, reason: collision with root package name */
    protected ViewGroup f13319d;

    /* renamed from: e, reason: collision with root package name */
    protected String f13320e;

    /* renamed from: f, reason: collision with root package name */
    protected long f13321f;

    /* renamed from: g, reason: collision with root package name */
    protected View f13322g;

    /* renamed from: h, reason: collision with root package name */
    protected com.beizi.fusion.a f13323h;

    /* renamed from: i, reason: collision with root package name */
    protected com.beizi.fusion.work.a f13324i;

    /* renamed from: m, reason: collision with root package name */
    protected String f13328m;

    /* renamed from: t, reason: collision with root package name */
    private d f13334t;

    /* renamed from: u, reason: collision with root package name */
    private AdSpacesBean f13335u;

    /* renamed from: x, reason: collision with root package name */
    private long f13338x;

    /* renamed from: j, reason: collision with root package name */
    protected Map<String, com.beizi.fusion.work.a> f13325j = new Hashtable();

    /* renamed from: k, reason: collision with root package name */
    protected ArrayList<c> f13326k = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name */
    protected boolean f13327l = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f13333s = false;

    /* renamed from: v, reason: collision with root package name */
    private long f13336v = 500;

    /* renamed from: w, reason: collision with root package name */
    private long f13337w = 100;

    /* renamed from: y, reason: collision with root package name */
    private volatile int f13339y = 0;

    /* renamed from: z, reason: collision with root package name */
    private int f13340z = 0;
    private int A = 0;
    private int B = 1;
    private int C = 2;
    private Timer D = null;
    private boolean E = false;
    private boolean I = false;
    private boolean M = false;
    private AdSpacesBean N = null;
    private com.beizi.fusion.events.a O = null;

    /* renamed from: n, reason: collision with root package name */
    protected boolean f13329n = false;
    private int P = 0;
    private int Q = 1;
    private int R = 2;

    /* renamed from: o, reason: collision with root package name */
    protected boolean f13330o = false;
    private boolean S = false;
    private boolean T = false;

    /* renamed from: p, reason: collision with root package name */
    protected com.beizi.fusion.work.a f13331p = null;

    /* renamed from: q, reason: collision with root package name */
    @SuppressLint({"HandlerLeak"})
    protected Handler f13332q = new Handler(Looper.getMainLooper()) { // from class: com.beizi.fusion.c.d.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i6 = message.what;
            if (i6 == 1) {
                d dVar = d.this;
                dVar.f13340z = dVar.B;
                d dVar2 = d.this;
                if (dVar2.f13324i != null) {
                    dVar2.b(2);
                    return;
                }
                return;
            }
            if (i6 != 2) {
                if (i6 != 3) {
                    return;
                }
                d.this.C();
                com.beizi.fusion.events.b f6 = b.a().f();
                d.this.F = new com.beizi.fusion.events.b(new EventBean(b.f13294b, "", "", "", b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                d dVar3 = d.this;
                dVar3.O = dVar3.F.a();
                d dVar4 = d.this;
                dVar4.f13318c = dVar4.F.b();
                d.this.D();
                d.this.O.a(d.this.f13318c);
                d.this.G();
                if (f6 == null || f6.f13486a.a() != 2 || d.this.F.f13487b.a() != 0) {
                    d.this.a(10000);
                    return;
                }
                d.this.F.f13487b.a(1);
                if (d.this.F.f13487b.a() != 1) {
                    d.this.F.f13487b.a(-2);
                    d.this.a("kGetLocalConfigStatusInternalError");
                    return;
                }
                d.this.F.f13487b.a(2);
                d dVar5 = d.this;
                dVar5.f13335u = com.beizi.fusion.b.a.a(dVar5.f13317b, dVar5.f13328m, dVar5.d());
                if (d.this.f13335u != null) {
                    d.this.a(AVMDLDataLoader.KeyIsEnableEventInfo);
                    return;
                }
                if (d.this.F.f13487b.a() != 2) {
                    d.this.F.f13487b.a(-2);
                    d.this.a("kGetLocalConfigStatusInternalError");
                    return;
                }
                int a6 = com.beizi.fusion.b.a.a();
                if (a6 == 1) {
                    d.this.F.f13487b.a(4);
                    d.this.a(10001);
                    return;
                } else if (a6 == 2) {
                    d.this.F.f13487b.a(5);
                    d.this.a(10100);
                    return;
                } else if (a6 != 3) {
                    d.this.a(AVMDLDataLoader.KeyIsEnableEventInfo);
                    return;
                } else {
                    d.this.F.f13487b.a(6);
                    d.this.a(Constants.REQUEST_EDIT_DYNAMIC_AVATAR);
                    return;
                }
            }
            System.currentTimeMillis();
            d dVar6 = d.this;
            dVar6.f13340z = dVar6.C;
            if (d.this.F != null) {
                d.this.F.a(true);
            }
            if (d.this.F == null) {
                return;
            }
            d dVar7 = d.this;
            com.beizi.fusion.work.a aVar = dVar7.f13324i;
            if (aVar == null) {
                dVar7.a(AVMDLDataLoader.KeyIsEnableEventInfo);
                Map<String, com.beizi.fusion.work.a> n6 = d.this.n();
                if (n6 != null) {
                    for (com.beizi.fusion.work.a aVar2 : n6.values()) {
                        AdSpacesBean.BuyerBean j6 = aVar2.j();
                        if (j6 != null) {
                            d.this.b(aVar2, 2);
                            aa.a("BeiZis", "AdRequest timeout channel = " + j6.getId() + ",mManagerObserver.mChannelResultStatus.getStatus(channel) = " + d.this.F.f13492g.a(j6.getBuyerSpaceUuId()));
                            if (d.this.F.f13492g.a(j6.getBuyerSpaceUuId()) < 4) {
                                d.this.F.f13492g.a(j6.getBuyerSpaceUuId(), -1);
                            }
                        }
                    }
                    return;
                }
                return;
            }
            aVar.q();
            d dVar8 = d.this;
            dVar8.a(dVar8.f13324i.f(), d.this.f13324i.o());
            if ("4".equals(d.this.d())) {
                d dVar9 = d.this;
                if (!dVar9.f13329n) {
                    dVar9.f13324i.e();
                    d.this.f13329n = true;
                }
            }
            Map<String, com.beizi.fusion.work.a> n7 = d.this.n();
            if (n7 != null) {
                for (com.beizi.fusion.work.a aVar3 : n7.values()) {
                    AdSpacesBean.BuyerBean j7 = aVar3.j();
                    AdSpacesBean.BuyerBean j8 = d.this.f13324i.j();
                    if (j7 != null && j8 != null && (TextUtils.isEmpty(j7.getBuyerSpaceUuId()) || TextUtils.isEmpty(j8.getBuyerSpaceUuId()) || !j7.getBuyerSpaceUuId().equals(j8.getBuyerSpaceUuId()))) {
                        d.this.b(aVar3, 2);
                        aa.a("BeiZis", "AdRequest timeout channel = " + j7.getId() + ",mManagerObserver.mChannelResultStatus.getStatus(channel) = " + d.this.F.f13492g.a(j7.getBuyerSpaceUuId()));
                        if (aVar3.h() == com.beizi.fusion.e.a.ADDEFAULT) {
                            d.this.F.f13492g.a(j7.getBuyerSpaceUuId(), -1);
                        }
                    }
                }
            }
        }
    };
    private TimerTask W = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                int intExtra = intent.getIntExtra("updateResult", 0);
                d.this.L = true;
                if (TextUtils.equals(action, "com.ad.action.UPDATE_CONFIG_SUCCESS")) {
                    if (intExtra == 1) {
                        if (d.this.D != null) {
                            d.this.D.cancel();
                            d.this.D = null;
                        }
                        d dVar = d.this;
                        dVar.a(dVar.f13319d);
                    } else if (intExtra == 0 && d.this.M) {
                        if (d.this.D != null) {
                            d.this.D.cancel();
                            d.this.D = null;
                        }
                        d dVar2 = d.this;
                        dVar2.a(dVar2.f13319d);
                    }
                }
                d.this.C();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    private synchronized void K() {
        this.f13326k.clear();
    }

    private com.beizi.fusion.work.a P() {
        Map<String, com.beizi.fusion.work.a> n6;
        AdSpacesBean.BuyerBean j6;
        try {
            AdSpacesBean.BuyerBean j7 = this.f13324i.j();
            if (j7 == null || (n6 = n()) == null || n6.size() <= 0) {
                return null;
            }
            com.beizi.fusion.work.a aVar = null;
            for (com.beizi.fusion.work.a aVar2 : n6.values()) {
                if (aVar2 != null && (j6 = aVar2.j()) != null && (TextUtils.isEmpty(j6.getBuyerSpaceUuId()) || TextUtils.isEmpty(j7.getBuyerSpaceUuId()) || !j6.getBuyerSpaceUuId().equals(j7.getBuyerSpaceUuId()))) {
                    if (aVar2.h() == com.beizi.fusion.e.a.ADLOAD) {
                        aa.a("BeiZis", "handleSendWinNotice ---getSecondAdWorker---" + aVar2.h() + "---" + aVar2.f() + ";getPrice:" + e(aVar2));
                        if (aVar == null || e(aVar2) > e(aVar)) {
                            aVar = aVar2;
                        }
                    }
                }
            }
            return aVar;
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    private boolean j(String str) {
        return false;
    }

    public abstract com.beizi.fusion.work.a a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List<AdSpacesBean.RenderViewBean> list, com.beizi.fusion.work.a aVar);

    protected abstract void c();

    public void k() {
        com.beizi.fusion.work.a aVar = this.f13324i;
        if (aVar != null) {
            aVar.m();
        }
    }

    protected void l() {
        com.beizi.fusion.events.b bVar = this.F;
        if (bVar != null) {
            if (bVar.f13495j.a() == 1 || this.F.f13495j.a() == 3 || this.F.f13495j.a() == 4) {
                this.F.f13495j.a(2);
            }
        }
    }

    protected void m() {
        com.beizi.fusion.events.b bVar = this.F;
        if (bVar != null) {
            if (bVar.f13495j.a() == 0 || this.F.f13495j.a() == 1) {
                this.F.f13495j.a(5);
            }
        }
    }

    private void A() {
        if (this.J != null) {
            return;
        }
        this.J = z.a(f13315a);
        IntentFilter intentFilter = new IntentFilter("com.ad.action.UPDATE_CONFIG_SUCCESS");
        a aVar = new a();
        this.K = aVar;
        this.J.a(aVar, intentFilter);
    }

    private void B() {
        try {
            if (this.L) {
                return;
            }
            A();
            com.beizi.fusion.update.b.a(f13315a).b(5);
            if (this.D == null) {
                this.D = new Timer();
            }
            if (this.W == null) {
                this.W = new TimerTask() { // from class: com.beizi.fusion.c.d.2
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        try {
                            System.currentTimeMillis();
                            Handler handler = d.this.f13332q;
                            if (handler != null) {
                                handler.sendEmptyMessage(3);
                            }
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                    }
                };
            }
            if (this.D == null || this.W == null) {
                return;
            }
            long j6 = this.f13321f;
            if (j6 > 2000) {
                j6 = 2000;
            }
            long j7 = this.f13338x;
            if (j7 > 0) {
                j6 = Math.min(j6, j7);
            }
            this.D.schedule(this.W, j6);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        a aVar;
        try {
            z zVar = this.J;
            if (zVar == null || (aVar = this.K) == null) {
                return;
            }
            zVar.a(aVar);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        EventBean eventBean = this.f13318c;
        if (eventBean != null) {
            eventBean.setReqId(this.f13320e);
            c();
            this.f13318c.setAppId(b.a().b());
            this.f13318c.setSpaceId(this.f13328m);
            this.f13318c.setReserveTime(String.valueOf(this.f13321f));
        }
    }

    private boolean E() {
        AdSpacesBean adSpacesBean = this.f13335u;
        if (adSpacesBean == null) {
            return false;
        }
        if (adSpacesBean.getBid() != null) {
            this.f13336v = r0.getReserveFRWTime();
            this.f13337w = r0.getReserveTime();
            this.f13338x = r0.getTimeOut();
            if (b.a().j() && this.f13338x <= 0) {
                this.f13338x = 800L;
            }
        }
        long j6 = this.f13321f;
        if (j6 <= this.f13337w) {
            a(10120);
            this.F.f13487b.a(7);
            return true;
        }
        if (j6 > this.f13336v) {
            Q();
        } else {
            this.f13340z = this.B;
        }
        R();
        return false;
    }

    private void F() {
        s.b(f13315a, this.f13328m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        com.beizi.fusion.events.b bVar = this.F;
        if (bVar != null) {
            bVar.f13487b.addObserver(bVar);
            com.beizi.fusion.events.b bVar2 = this.F;
            bVar2.f13488c.addObserver(bVar2);
            com.beizi.fusion.events.b bVar3 = this.F;
            bVar3.f13489d.addObserver(bVar3);
            com.beizi.fusion.events.b bVar4 = this.F;
            bVar4.f13490e.addObserver(bVar4);
            com.beizi.fusion.events.b bVar5 = this.F;
            bVar5.f13491f.addObserver(bVar5);
            com.beizi.fusion.events.b bVar6 = this.F;
            bVar6.f13492g.addObserver(bVar6);
            com.beizi.fusion.events.b bVar7 = this.F;
            bVar7.f13493h.addObserver(bVar7);
            com.beizi.fusion.events.b bVar8 = this.F;
            bVar8.f13494i.addObserver(bVar8);
            com.beizi.fusion.events.b bVar9 = this.F;
            bVar9.f13495j.addObserver(bVar9);
            com.beizi.fusion.events.b bVar10 = this.F;
            bVar10.f13496k.addObserver(bVar10);
        }
    }

    private void H() {
        String str;
        AdSpacesBean adSpacesBean = this.f13335u;
        if (adSpacesBean != null) {
            String adType = adSpacesBean.getAdType();
            adType.getClass();
            switch (adType) {
                case "NATIVE":
                    str = "5";
                    break;
                case "SPLASH":
                    str = "2";
                    break;
                case "INTERSTITIAL":
                    str = "3";
                    break;
                case "REWARDEDVIDEO":
                    str = "1";
                    break;
                case "DRAWFLOW":
                    str = "7";
                    break;
                case "INTERACTIVECARD":
                    str = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                    break;
                case "FULLSCREENVIDEO":
                    str = "6";
                    break;
                case "REGIONALNATIVE":
                    str = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                    break;
                case "BANNER":
                    str = "4";
                    break;
                default:
                    str = null;
                    break;
            }
            EventBean eventBean = this.f13318c;
            if (eventBean != null) {
                eventBean.setAdType(str);
            }
        }
    }

    private boolean I() {
        if (!this.T) {
            return false;
        }
        com.beizi.fusion.work.a aVar = this.f13331p;
        if (aVar != null) {
            return aVar != null && aVar.h() == com.beizi.fusion.e.a.ADDEFAULT;
        }
        return true;
    }

    private void L() {
        com.beizi.fusion.events.b bVar = this.F;
        if (bVar == null || bVar.f13495j.a() != 0) {
            return;
        }
        this.F.f13495j.a(1);
    }

    private void M() {
        if (this.F != null) {
            aa.b("BeiZis", "mManagerObserver.mManagerResultStatus.getStatus() = " + this.F.f13495j.a());
        }
        com.beizi.fusion.events.b bVar = this.F;
        if (bVar != null) {
            if (bVar.f13495j.a() == 1 || this.F.f13495j.a() == 2 || this.F.f13495j.a() == 3) {
                this.F.f13495j.a(3);
            }
        }
    }

    private void N() {
        if (this.F != null) {
            aa.b("BeiZis", "mManagerObserver.mManagerResultStatus.getStatus() = " + this.F.f13495j.a());
        }
        com.beizi.fusion.events.b bVar = this.F;
        if (bVar != null) {
            if (bVar.f13495j.a() == 3 || this.F.f13495j.a() == 1 || this.F.f13495j.a() == 2) {
                this.F.f13495j.a(4);
            }
        }
    }

    private void O() {
        try {
            if (this.f13324i == null) {
                return;
            }
            com.beizi.fusion.work.a P = P();
            ChannelBidResult channelBidResult = new ChannelBidResult();
            if (P != null) {
                channelBidResult.setEcpm(e(P));
                channelBidResult.setChannelName(P.f());
                channelBidResult.setBidType(P.g());
            } else {
                channelBidResult.setEcpm(e(this.f13324i));
                channelBidResult.setChannelName(this.f13324i.f());
                channelBidResult.setBidType(this.f13324i.g());
            }
            this.f13324i.a(channelBidResult);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void Q() {
        if (this.f13332q != null) {
            long j6 = this.f13321f - this.f13336v;
            long j7 = this.f13338x;
            if (j7 > 0) {
                j6 = Math.min(j6, j7 - 50);
            }
            if (j6 <= 0) {
                j6 = 100;
            }
            this.f13332q.sendEmptyMessageDelayed(1, j6);
        }
    }

    private void R() {
        if (this.f13332q != null) {
            long j6 = this.f13321f - this.f13337w;
            long j7 = this.f13338x;
            if (j7 > 0) {
                j6 = Math.min(j6, j7);
            }
            if (j6 <= 0) {
                j6 = 1000;
            }
            this.f13332q.sendEmptyMessageDelayed(2, j6);
        }
    }

    private boolean h(String str) {
        return str.equals("HPFRW");
    }

    private String i(String str) {
        aa.a("BeiZis", "enter convertSelfChannel buyerId = " + str);
        return ao.b().equals(str) ? "BEIZI" : str;
    }

    private void y() {
        Handler handler = this.f13332q;
        if (handler != null) {
            handler.removeMessages(1);
        }
        Timer timer = this.D;
        if (timer != null) {
            timer.cancel();
            this.D = null;
        }
    }

    private void z() {
        Handler handler = this.f13332q;
        if (handler != null) {
            handler.removeMessages(2);
        }
        Timer timer = this.D;
        if (timer != null) {
            timer.cancel();
            this.D = null;
        }
    }

    public void c(String str) {
        if (this.P == this.Q) {
            this.P = this.R;
        }
        com.beizi.fusion.a aVar = this.f13323h;
        if (aVar != null) {
            if (aVar instanceof AdListener) {
                ((AdListener) aVar).onAdClosed();
            } else if (aVar instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) aVar).onRewardedVideoAdClosed();
            } else if (aVar instanceof NativeAdListener) {
                ((NativeAdListener) aVar).onAdClosed();
            } else if (aVar instanceof InterstitialAdListener) {
                ((InterstitialAdListener) aVar).onAdClosed();
            } else if (aVar instanceof com.beizi.fusion.b) {
                ((com.beizi.fusion.b) aVar).c();
            }
        }
        N();
    }

    public String d() {
        EventBean eventBean = this.f13318c;
        if (eventBean != null) {
            return eventBean.getAdType();
        }
        return null;
    }

    protected void e() {
        this.F.f13489d.a(3);
        a(10140);
    }

    public boolean f() {
        return (p() == 2 || p() == 3) ? false : true;
    }

    public String g() {
        return this.f13328m;
    }

    public Map<String, com.beizi.fusion.work.a> n() {
        return this.f13325j;
    }

    public int o() {
        return this.f13340z;
    }

    public int p() {
        return this.f13339y;
    }

    public boolean q() {
        return f13316r;
    }

    public int r() {
        AdSpacesBean adSpacesBean = this.f13335u;
        if (adSpacesBean == null || adSpacesBean.getEventStrategy() == null) {
            return Integer.MAX_VALUE;
        }
        AdSpacesBean.EventStrategyBean eventStrategy = this.f13335u.getEventStrategy();
        if (eventStrategy.getValidTimeShow() >= 0) {
            return eventStrategy.getValidTimeShow();
        }
        return Integer.MAX_VALUE;
    }

    public String s() {
        AdSpacesBean.BuyerBean j6;
        com.beizi.fusion.work.a aVar = this.f13324i;
        if (aVar == null || (j6 = aVar.j()) == null || TextUtils.isEmpty(j6.getBuyerSpaceUuId())) {
            return null;
        }
        return j6.getBuyerSpaceUuId();
    }

    public String t() {
        com.beizi.fusion.work.a aVar = this.f13324i;
        if (aVar == null) {
            return null;
        }
        return aVar.aw();
    }

    public long u() {
        return this.U;
    }

    public String v() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestUuid", this.f13320e);
            a(jSONObject);
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String w() {
        return this.X;
    }

    public Map<String, Object> x() {
        return this.V;
    }

    public d(Context context, String str, com.beizi.fusion.a aVar, long j6) {
        if (context == null) {
            ap.b("Illegal Argument: context is null");
        } else {
            this.f13317b = context;
            f13315a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (!(this.f13317b instanceof Activity)) {
                ap.b("Illegal Argument: context is not Activity context");
            }
        }
        this.f13328m = str;
        this.f13323h = aVar;
        this.f13321f = j6;
        this.f13334t = this;
        if (f13315a == null && aVar != null) {
            a(10132);
        }
    }

    private boolean J() {
        Iterator<com.beizi.fusion.work.a> it = n().values().iterator();
        while (it.hasNext()) {
            if (it.next().h() == com.beizi.fusion.e.a.ADDEFAULT) {
                return true;
            }
        }
        return false;
    }

    private double f(com.beizi.fusion.work.a aVar) {
        AdSpacesBean.BuyerBean j6;
        if (aVar == null || (j6 = aVar.j()) == null) {
            return 0.0d;
        }
        return j6.getBidPrice();
    }

    private void k(String str) {
        com.beizi.fusion.events.b bVar = this.F;
        if (bVar != null) {
            bVar.f13493h.a(str, 3);
        }
    }

    protected void b() {
        com.beizi.fusion.events.b bVar = this.F;
        if (bVar != null) {
            bVar.f13487b.deleteObservers();
            this.F.f13488c.deleteObservers();
            this.F.f13489d.deleteObservers();
            this.F.f13490e.deleteObservers();
            this.F.f13491f.deleteObservers();
            this.F.f13492g.deleteObservers();
            this.F.f13493h.deleteObservers();
            this.F.f13494i.deleteObservers();
            this.F.f13495j.deleteObservers();
            this.F.f13496k.deleteObservers();
        }
    }

    public void g(String str) {
        this.X = str;
    }

    public synchronized void h() {
        try {
            Iterator<c> it = this.f13326k.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            K();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void j() {
        this.f13330o = true;
        y();
        z();
        com.beizi.fusion.work.a aVar = this.f13324i;
        if (aVar != null) {
            aVar.l();
        }
        if (this.P != this.Q) {
            this.f13323h = null;
        }
        Map<String, com.beizi.fusion.work.a> map = this.f13325j;
        if (map != null) {
            map.clear();
        }
        ArrayList<c> arrayList = this.f13326k;
        if (arrayList != null) {
            arrayList.clear();
        }
        if (this.f13334t != null) {
            this.f13334t = null;
        }
        C();
        b();
    }

    private void d(Map<String, com.beizi.fusion.work.a> map) {
        if (map != null && map.size() != 0) {
            for (com.beizi.fusion.work.a aVar : map.values()) {
                aVar.d();
                aVar.a(true);
            }
            return;
        }
        e();
    }

    private double e(com.beizi.fusion.work.a aVar) {
        if (aVar == null || aVar.j() == null) {
            return 0.0d;
        }
        AdSpacesBean.BuyerBean j6 = aVar.j();
        if (!c(aVar) && !b(aVar)) {
            return j6.getAvgPrice();
        }
        if (j6.getBidPrice() > 0.0d) {
            return j6.getBidPrice();
        }
        return j6.getAvgPrice();
    }

    @NonNull
    private e m(String str) {
        f(str);
        return e.FAIL;
    }

    @NonNull
    private e l(String str) {
        k(str);
        return e.SUCCESS;
    }

    protected void f(String str) {
        com.beizi.fusion.events.b bVar = this.F;
        if (bVar != null) {
            bVar.f13493h.a(str, 4);
        }
    }

    public void i() {
        com.beizi.fusion.a aVar = this.f13323h;
        if (aVar == null || !(aVar instanceof RewardedVideoAdListener)) {
            return;
        }
        ((RewardedVideoAdListener) aVar).onRewarded();
    }

    private boolean d(com.beizi.fusion.work.a aVar) {
        if (aVar == null) {
            return false;
        }
        for (com.beizi.fusion.work.a aVar2 : n().values()) {
            AdSpacesBean.BuyerBean j6 = aVar2.j();
            AdSpacesBean.BuyerBean j7 = aVar.j();
            if (j6 != null && j7 != null && (TextUtils.isEmpty(j6.getBuyerSpaceUuId()) || TextUtils.isEmpty(j7.getBuyerSpaceUuId()) || !j6.getBuyerSpaceUuId().equals(j7.getBuyerSpaceUuId()))) {
                if (!b(aVar2) && !c(aVar2)) {
                    aa.c("BeiZis", "worker.getAdStatus():" + aVar2.h() + ":" + aVar2.f());
                    if (aVar2.h() != com.beizi.fusion.e.a.ADFAIL && e(aVar2) > e(aVar)) {
                        return false;
                    }
                } else {
                    double f6 = f(aVar2);
                    if (aVar2.h() == com.beizi.fusion.e.a.ADDEFAULT || f6 > e(aVar)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public com.beizi.fusion.events.b a() {
        return this.F;
    }

    public void a(ViewGroup viewGroup) {
        AdSpacesBean.ComponentBean componentBean;
        List<AdSpacesBean.BuyerBean> list;
        AdSpacesBean.BidComponent bidComponent;
        List<AdSpacesBean> adSpaces;
        AdSpacesBean adSpacesBean;
        if (this.I || this.f13317b == null || f13315a == null) {
            return;
        }
        this.U = System.currentTimeMillis();
        b.a().k();
        b.a().l();
        this.f13319d = viewGroup;
        this.G = System.currentTimeMillis();
        this.f13320e = ao.a();
        com.beizi.fusion.events.b f6 = b.a().f();
        com.beizi.fusion.events.b bVar = new com.beizi.fusion.events.b(new EventBean(b.f13294b, "", "", "", b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        this.F = bVar;
        this.O = bVar.a();
        this.f13318c = this.F.b();
        D();
        this.O.a(this.f13318c);
        G();
        if (!BeiZis.isIsSyncInit() && ((f6 == null || f6.f13486a.a() != 2) && !this.S)) {
            ResponseInfo.getInstance(f13315a).init();
            this.S = true;
        }
        if (f6 != null) {
            aa.b("BeiZis", "mInitObserver.mInitStatus.getStatus() = " + f6.f13486a.a() + ",mManagerObserver.mGetLocalConfigStatus.getStatus() = " + this.F.f13487b.a());
        }
        if ((f6 != null && f6.f13486a.a() == 2 && this.F.f13487b.a() == 0) || this.S) {
            this.F.f13487b.a(1);
            if (this.F.f13487b.a() == 1) {
                this.F.f13487b.a(2);
                AdSpacesBean a6 = com.beizi.fusion.b.a.a(this.f13317b, this.f13328m, d());
                this.f13335u = a6;
                if (a6 != null) {
                    EventBean eventBean = this.f13318c;
                    if (eventBean != null) {
                        eventBean.setPlatformFilterSsid(a6.getFilterSsid());
                        this.f13318c.setComponentSsid(this.f13335u.getComponentSsid());
                        this.f13318c.setBzComponentSsid(this.f13335u.getBzComponentSsid());
                        H();
                    }
                    ResponseInfo responseInfo = ResponseInfo.getInstance(f13315a);
                    Manager manager = responseInfo.getManager();
                    if (manager == null || (adSpaces = manager.getAdSpaces()) == null || adSpaces.size() <= 0 || (adSpacesBean = adSpaces.get(0)) == null) {
                        componentBean = null;
                        list = null;
                        bidComponent = null;
                    } else {
                        componentBean = adSpacesBean.getComponent();
                        bidComponent = adSpacesBean.getBidComponent();
                        list = adSpacesBean.getBuyer();
                    }
                    if ((componentBean != null || bidComponent != null) && list != null && list.size() > 0) {
                        long maxValidTime = responseInfo.getMaxValidTime();
                        if (maxValidTime == 0) {
                            maxValidTime = 2592000000L;
                        }
                        if (System.currentTimeMillis() - ((Long) an.b(f13315a, "lastUpdateTime", Long.valueOf(new Date(0L).getTime()))).longValue() <= maxValidTime) {
                            this.M = false;
                            this.I = true;
                            if (this.F.f13487b.a() == 2) {
                                this.F.f13487b.a(3);
                                if (E()) {
                                    return;
                                }
                                F();
                                if (this.F.c()) {
                                    this.F.f13487b.a(-1);
                                    return;
                                } else {
                                    a(this.f13335u);
                                    return;
                                }
                            }
                            return;
                        }
                        this.I = false;
                        this.M = true;
                        B();
                        return;
                    }
                    this.I = false;
                    B();
                    return;
                }
                if (this.L) {
                    if (this.F.f13487b.a() == 2) {
                        int a7 = com.beizi.fusion.b.a.a();
                        if (a7 == 1) {
                            this.F.f13487b.a(4);
                            a(10001);
                            return;
                        } else if (a7 == 2) {
                            this.F.f13487b.a(5);
                            a(10100);
                            return;
                        } else {
                            if (a7 == 3) {
                                this.F.f13487b.a(6);
                                a(Constants.REQUEST_EDIT_DYNAMIC_AVATAR);
                                return;
                            }
                            return;
                        }
                    }
                    this.F.f13487b.a(-2);
                    a("kGetLocalConfigStatusInternalError");
                    return;
                }
                this.I = false;
                B();
                return;
            }
            this.F.f13487b.a(-2);
            a("kGetLocalConfigStatusInternalError");
            return;
        }
        if (this.L) {
            this.I = false;
            B();
        } else {
            a(10000);
        }
    }

    protected void e(String str) {
        com.beizi.fusion.events.b bVar = this.F;
        if (bVar != null) {
            bVar.f13493h.a(str, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.beizi.fusion.work.a aVar, int i6) {
        try {
            if (!b(aVar) && !c(aVar)) {
                return;
            }
            ChannelBidResult channelBidResult = new ChannelBidResult();
            com.beizi.fusion.work.a aVar2 = this.f13324i;
            if (aVar2 != null) {
                channelBidResult.setBidType(aVar2.g());
                channelBidResult.setChannelName(this.f13324i.f());
                channelBidResult.setReason(i6);
                channelBidResult.setEcpm(e(this.f13324i));
            } else {
                channelBidResult.setEcpm(0.0d);
                channelBidResult.setChannelName("other");
                channelBidResult.setBidType("other");
                channelBidResult.setReason(i6);
            }
            aVar.b(channelBidResult);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    protected boolean c(com.beizi.fusion.work.a aVar) {
        return AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equalsIgnoreCase(aVar.g());
    }

    public void c(Map<String, Object> map) {
        this.V = map;
    }

    public void d(String str) {
        com.beizi.fusion.a aVar = this.f13323h;
        if (aVar != null) {
            if (aVar instanceof AdListener) {
                ((AdListener) aVar).onAdClicked();
            } else if (aVar instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) aVar).onRewardedVideoClick();
            } else if (aVar instanceof NativeAdListener) {
                ((NativeAdListener) aVar).onAdClick();
            } else if (aVar instanceof InterstitialAdListener) {
                ((InterstitialAdListener) aVar).onAdClick();
            } else if (aVar instanceof NativeUnifiedAdListener) {
                ((NativeUnifiedAdListener) aVar).onAdClick();
            } else if (aVar instanceof com.beizi.fusion.b) {
                ((com.beizi.fusion.b) aVar).b();
            }
        }
        M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i6) {
        a(this.f13324i, i6);
        this.f13324i.q();
        a(this.f13324i.f(), this.f13324i.o());
        if (!"4".equals(d()) || this.f13329n) {
            return;
        }
        this.f13324i.e();
        this.f13329n = true;
    }

    public void b(String str) {
        if (this.f13339y < 2 || j(str)) {
            if (this.P == 0) {
                this.P = this.Q;
            }
            this.f13339y = 2;
            com.beizi.fusion.a aVar = this.f13323h;
            if (aVar != null) {
                if (aVar instanceof AdListener) {
                    ((AdListener) aVar).onAdShown();
                } else if (aVar instanceof RewardedVideoAdListener) {
                    ((RewardedVideoAdListener) aVar).onRewardedVideoAdShown();
                } else if (aVar instanceof NativeAdListener) {
                    ((NativeAdListener) aVar).onAdShown();
                } else if (aVar instanceof InterstitialAdListener) {
                    ((InterstitialAdListener) aVar).onAdShown();
                } else if (aVar instanceof NativeUnifiedAdListener) {
                    ((NativeUnifiedAdListener) aVar).onAdShown();
                } else if (aVar instanceof com.beizi.fusion.b) {
                    ((com.beizi.fusion.b) aVar).a();
                }
            }
            l();
            h();
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
    }

    public void b(String str, View view) {
        com.beizi.fusion.a aVar = this.f13323h;
        if (aVar != null && view != null && (aVar instanceof NativeAdListener)) {
            ((NativeAdListener) aVar).onAdClosed(view);
        }
        N();
    }

    protected boolean b(com.beizi.fusion.work.a aVar) {
        return AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(aVar.g());
    }

    public void b(Map map) {
        if (map == null) {
            return;
        }
        try {
            com.beizi.fusion.work.a aVar = this.f13324i;
            if (aVar != null) {
                aVar.b(map);
                return;
            }
            Map<String, com.beizi.fusion.work.a> n6 = n();
            if (n6 != null && n6.size() != 0) {
                for (com.beizi.fusion.work.a aVar2 : n6.values()) {
                    if (aVar2 != null && aVar2.f().equalsIgnoreCase("BEIZI")) {
                        aVar2.b(map);
                        return;
                    }
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.c.a
    public void a(String str) {
        aa.c("BeiZis", "enter handleAdRequestStatusError error is " + str);
        a(10131);
    }

    public void a(String str, final String str2, final EventItem eventItem) {
        if (Arrays.asList(m.f13728a).contains(str)) {
            s.a(str2, eventItem);
            com.beizi.fusion.tool.e.b().c().execute(new Runnable() { // from class: com.beizi.fusion.c.d.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.beizi.fusion.a.b.a(d.this.f13317b).a(str2, eventItem);
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            });
        }
    }

    public void a(AdSpacesBean adSpacesBean) {
        if (this.F.f13487b.a() == 3 && this.F.f13488c.a() == 0) {
            this.F.f13488c.a(1);
            this.f13325j.clear();
            AdSpacesBean.FilterBean filter = adSpacesBean.getFilter();
            this.H = adSpacesBean.getBuyer();
            com.beizi.fusion.e.b.a(this.f13317b, this.f13321f, filter, this.F, g(), null, null, this);
            if (this.F.f13488c.a() == 2) {
                if (this.F.c()) {
                    this.F.f13488c.a(-1);
                    return;
                }
                a("200.000", this.f13328m, new EventItem("200.000", String.valueOf(System.currentTimeMillis()), null, null));
                this.N = adSpacesBean;
                aa.c("BeiZis", "normal request");
                a(this.N.getComponent(), false);
                return;
            }
            a(this.F.f13488c.a(), 6, "platform error = ");
            com.beizi.fusion.events.a.a(this.F.f13488c);
            a(10130);
            return;
        }
        this.F.f13488c.a(-2);
        a("kPlatformFilterStatusInternalError");
    }

    protected void a(AdSpacesBean.ComponentBean componentBean, boolean z5) {
        aa.a("BeiZis", "enter auctionAndRequestAd");
        if (this.f13335u == null) {
            return;
        }
        List<AdSpacesBean.BuyerBean> list = this.H;
        if (list != null && list.size() != 0) {
            if (p() >= 1) {
                aa.a("BeiZis", "auctionAndRequestAd ad aleady callback");
                return;
            }
            if (!z5) {
                this.F.f13489d.a(1);
            }
            List<AdSpacesBean.ForwardBean> a6 = a(componentBean, this.H, z5);
            if (!z5) {
                this.F.f13489d.a(2);
            }
            ArrayList arrayList = new ArrayList();
            if (a6 != null && a6.size() > 0) {
                for (AdSpacesBean.ForwardBean forwardBean : a6) {
                    if (a(forwardBean.getBuyerId(), this.H, forwardBean.getBuyerSpaceUuId()) != null) {
                        arrayList.add(forwardBean);
                    }
                }
            }
            d(a(arrayList));
            return;
        }
        aa.a("BeiZis", "auctionAndRequestAd mBuyerBeanList == null ");
    }

    private List<AdSpacesBean.ForwardBean> a(AdSpacesBean.ComponentBean componentBean, List<AdSpacesBean.BuyerBean> list, boolean z5) {
        List<AdSpacesBean.ForwardBean> a6;
        AdSpacesBean adSpacesBean;
        ArrayList arrayList = new ArrayList();
        if (!z5 && (adSpacesBean = this.f13335u) != null && adSpacesBean.getBid() != null && this.f13335u.getBidComponent() != null && this.f13335u.getBidComponent().getBidList() != null && this.f13335u.getBidComponent().getBidList().size() > 0) {
            arrayList.addAll(this.f13335u.getBidComponent().getBidList());
        }
        if (this.f13335u != null && componentBean != null && (a6 = com.beizi.fusion.e.b.a(componentBean, list, g())) != null && a6.size() > 0) {
            arrayList.addAll(a6);
        }
        return arrayList;
    }

    protected Map<String, com.beizi.fusion.work.a> a(List<AdSpacesBean.ForwardBean> list) {
        AdSpacesBean.BuyerBean buyerBean;
        if (list == null || list.size() == 0) {
            return null;
        }
        aa.a("BeiZis", "generateWorkers forwardBeans.size() = " + list.size());
        Hashtable hashtable = new Hashtable();
        for (int i6 = 0; i6 < list.size(); i6++) {
            AdSpacesBean.ForwardBean forwardBean = list.get(i6);
            if (forwardBean != null) {
                String buyerId = forwardBean.getBuyerId();
                String buyerSpaceUuId = forwardBean.getBuyerSpaceUuId();
                AdSpacesBean.BuyerBean a6 = a(buyerId, this.H, forwardBean.getBuyerSpaceUuId());
                if (a6 != null) {
                    try {
                        buyerBean = a6.m87clone();
                    } catch (CloneNotSupportedException e6) {
                        e6.printStackTrace();
                        buyerBean = null;
                    }
                    if (buyerBean != null) {
                        this.O.a(buyerBean, forwardBean);
                        this.F.f13490e.a(buyerSpaceUuId, 1);
                        if (a(forwardBean, buyerBean, buyerSpaceUuId)) {
                            com.beizi.fusion.work.a a7 = a(forwardBean, buyerId, buyerBean, buyerBean.getRenderView(), null);
                            if (a7 != null) {
                                a7.a(forwardBean.getSleepTime());
                                a7.a(forwardBean);
                                a7.a(buyerBean);
                                a7.a(buyerBean.getBidType());
                                a(buyerId, buyerSpaceUuId, a7);
                                hashtable.put(i(buyerId) + buyerSpaceUuId, a7);
                                aa.a("BeiZis", "generateWorkers put new " + buyerId + " worker into workerList");
                            }
                        }
                    }
                }
            }
        }
        return hashtable;
    }

    private boolean a(AdSpacesBean.ForwardBean forwardBean, AdSpacesBean.BuyerBean buyerBean, String str) {
        this.F.f13490e.a(str, 2);
        if (buyerBean != null) {
            try {
                long longValue = ((Long) an.b(this.f13317b, "complain_config_" + buyerBean.getSpaceId(), 0L)).longValue();
                AdSpacesBean.ComplainBean complain = buyerBean.getComplain();
                if (complain != null) {
                    if (System.currentTimeMillis() - longValue < complain.getDuration()) {
                        this.F.f13490e.a(str, 10);
                        return false;
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        com.beizi.fusion.e.b.a(this.f13317b, this.f13321f, buyerBean.getFilter(), this.F, g(), buyerBean.getBuyerSpaceUuId(), buyerBean.getSpaceId(), this);
        if (this.F.f13490e.a(str) == 3) {
            if (this.F.c()) {
                this.F.f13490e.a(str, -1);
                return false;
            }
            if (a(forwardBean, buyerBean) != 2) {
                return false;
            }
            this.F.f13490e.a(str, 3);
            return true;
        }
        a(this.F.f13490e.a(str), 7, "channel error = ");
        com.beizi.fusion.events.a.a(str, this.F.f13490e);
        return false;
    }

    public e a(com.beizi.fusion.work.a aVar) {
        AdSpacesBean.BuyerBean j6 = aVar.j();
        if (j6 == null) {
            return null;
        }
        String id = j6.getId();
        String buyerSpaceUuId = j6.getBuyerSpaceUuId();
        String zone = j6.getZone();
        aa.a("BeiZis", "enter comparePrices compareWorker:" + aVar.f() + ",mCurrentHighestWorker:" + this.f13324i);
        if (j(aVar.f())) {
            return a(buyerSpaceUuId, aVar, id);
        }
        com.beizi.fusion.events.b bVar = this.F;
        if (bVar != null) {
            bVar.f13493h.a(buyerSpaceUuId, 1);
        }
        if (this.f13339y >= 1) {
            b(aVar, 1);
            return m(buyerSpaceUuId);
        }
        if (I()) {
            return a(buyerSpaceUuId, aVar);
        }
        boolean h6 = h(zone);
        boolean d6 = d(aVar);
        StringBuilder sb = new StringBuilder();
        sb.append("channel == mTimeStage = ");
        sb.append(this.f13340z == this.B);
        sb.append(";isNeedComparePrices = ");
        sb.append(h6);
        sb.append(",isHighestPrice:");
        sb.append(d6);
        sb.append(";mCurrentHighestWorker:");
        sb.append(this.f13324i);
        aa.a("BeiZis", sb.toString());
        if (this.f13340z == this.A && h6 && !d6) {
            double e6 = e(aVar);
            double e7 = e(this.f13324i);
            if (this.f13324i != null && e6 <= e7) {
                b(aVar, 1);
                if (d(this.f13324i)) {
                    b(1);
                }
                return m(buyerSpaceUuId);
            }
            return a(buyerSpaceUuId, aVar);
        }
        return a(buyerSpaceUuId, aVar, id);
    }

    private void a(com.beizi.fusion.work.a aVar, int i6) {
        if (aVar == null) {
            return;
        }
        for (com.beizi.fusion.work.a aVar2 : n().values()) {
            AdSpacesBean.BuyerBean j6 = aVar2.j();
            AdSpacesBean.BuyerBean j7 = aVar.j();
            if (j6 != null && j7 != null && (TextUtils.isEmpty(j6.getBuyerSpaceUuId()) || TextUtils.isEmpty(j7.getBuyerSpaceUuId()) || !j6.getBuyerSpaceUuId().equals(j7.getBuyerSpaceUuId()))) {
                b(aVar2, i6);
                if (aVar2.at() == e.TO_DETERMINE) {
                    f(j6.getBuyerSpaceUuId());
                } else if (aVar2.h() == com.beizi.fusion.e.a.ADDEFAULT) {
                    e(j6.getBuyerSpaceUuId());
                }
            }
        }
    }

    private void a(String str, String str2, com.beizi.fusion.work.a aVar) {
        this.f13325j.put(i(str) + "_" + str2, aVar);
    }

    @Nullable
    protected AdSpacesBean.BuyerBean a(String str, List<AdSpacesBean.BuyerBean> list, String str2) {
        return com.beizi.fusion.e.b.a(str, list, str2);
    }

    protected void a(int i6, int i7, String str) {
        if (i6 != i7 || s.c(this.f13328m) == null) {
            return;
        }
        s.d(str + s.c(this.f13328m).toString());
    }

    private int a(AdSpacesBean.ForwardBean forwardBean, AdSpacesBean.BuyerBean buyerBean) {
        if (forwardBean == null || buyerBean == null) {
            return 0;
        }
        String buyerSpaceUuId = buyerBean.getBuyerSpaceUuId();
        if (this.F.f13490e.a(buyerSpaceUuId) == 3) {
            this.F.f13491f.a(buyerSpaceUuId, 1);
            if (this.F.f13491f.a(buyerSpaceUuId) == 1) {
                if (this.f13321f <= (forwardBean.getSleepTime() + System.currentTimeMillis()) - this.G) {
                    this.F.f13491f.a(buyerSpaceUuId, 4);
                    return 4;
                }
                if (this.F.f13495j.a() == 2) {
                    this.F.f13491f.a(buyerSpaceUuId, 6);
                    return 6;
                }
                aa.a("BeiZis", "mUsableTime = " + this.f13321f + " forwardBean.getSleepTime() + System.currentTimeMillis() - mEnterRequestMethodTime = " + ((forwardBean.getSleepTime() + System.currentTimeMillis()) - this.G) + ",forwardBean.getSleepTime() = " + forwardBean.getSleepTime());
                if (this.F.c()) {
                    this.F.f13491f.a(buyerSpaceUuId, -1);
                    return -1;
                }
                this.F.f13491f.a(buyerSpaceUuId, 2);
                return 2;
            }
        }
        this.F.f13491f.a(buyerSpaceUuId, -2);
        return -2;
    }

    public void a(AdSpacesBean.ComponentBean componentBean, String str, boolean z5, int i6) {
        if (componentBean != null && (TextUtils.isEmpty(str) || (!AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equalsIgnoreCase(str) && !AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(str)))) {
            a(componentBean, true);
            return;
        }
        com.beizi.fusion.work.a aVar = this.f13324i;
        if (aVar != null && d(aVar)) {
            b(1);
        } else {
            a(i6);
        }
    }

    public void a(String str, View view) {
        if (this.f13327l) {
            return;
        }
        O();
        a(this.f13324i, 1);
        this.f13327l = true;
        this.f13339y = 1;
        y();
        z();
        com.beizi.fusion.a aVar = this.f13323h;
        if (aVar != null) {
            if (aVar instanceof AdListener) {
                ((AdListener) aVar).onAdLoaded();
            } else if (aVar instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) aVar).onRewardedVideoAdLoaded();
            } else if (aVar instanceof InterstitialAdListener) {
                ((InterstitialAdListener) aVar).onAdLoaded();
            } else if (aVar instanceof NativeAdListener) {
                if (view != null) {
                    com.beizi.fusion.work.a aVar2 = this.f13324i;
                    if (aVar2 != null && aVar2.aq() == 1) {
                        ((NativeAdListener) this.f13323h).onAdLoaded(null);
                    } else {
                        com.beizi.fusion.work.a aVar3 = this.f13324i;
                        if (aVar3 != null && aVar3.o() != null) {
                            ((NativeAdListener) this.f13323h).onAdLoaded(this.f13324i.o());
                        } else {
                            e();
                        }
                    }
                } else {
                    e();
                }
            } else if (aVar instanceof NativeUnifiedAdListener) {
                ((NativeUnifiedAdListener) aVar).onAdLoaded(this.f13324i.as());
            }
        }
        L();
        f13316r = true;
    }

    public void a(String str, int i6) {
        com.beizi.fusion.a aVar = this.f13323h;
        if (aVar != null) {
            if (aVar instanceof AdListener) {
                ((AdListener) aVar).onAdFailedToLoad(i6);
            } else if (aVar instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) aVar).onRewardedVideoAdFailedToLoad(i6);
            } else if (aVar instanceof NativeAdListener) {
                ((NativeAdListener) aVar).onAdFailed(i6);
            } else if (aVar instanceof InterstitialAdListener) {
                ((InterstitialAdListener) aVar).onAdFailed(i6);
            } else if (aVar instanceof NativeUnifiedAdListener) {
                ((NativeUnifiedAdListener) aVar).onAdFailed(i6);
            } else if (aVar instanceof com.beizi.fusion.b) {
                ((com.beizi.fusion.b) aVar).a(i6);
            }
        }
        y();
        z();
        this.f13339y = 3;
        m();
        f13316r = true;
    }

    public void a(int i6) {
        if (i6 != 10140) {
            if (this.f13339y >= 1) {
                return;
            }
            if (i6 != 9999 && (I() || J())) {
                return;
            }
        }
        if (b.a().j() && i6 == 9999) {
            i6 = 3;
        }
        com.beizi.fusion.a aVar = this.f13323h;
        if (aVar != null) {
            if (aVar instanceof AdListener) {
                ((AdListener) aVar).onAdFailedToLoad(i6);
            } else if (aVar instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) aVar).onRewardedVideoAdFailedToLoad(i6);
            } else if (aVar instanceof NativeAdListener) {
                ((NativeAdListener) aVar).onAdFailed(i6);
            } else if (aVar instanceof InterstitialAdListener) {
                ((InterstitialAdListener) aVar).onAdFailed(i6);
            } else if (aVar instanceof NativeUnifiedAdListener) {
                ((NativeUnifiedAdListener) aVar).onAdFailed(i6);
            } else if (aVar instanceof com.beizi.fusion.b) {
                ((com.beizi.fusion.b) aVar).a(i6);
            }
        }
        y();
        z();
        this.f13339y = 3;
        m();
        f13316r = true;
    }

    public void a(long j6) {
        com.beizi.fusion.a aVar = this.f13323h;
        if (aVar == null || !(aVar instanceof AdListener)) {
            return;
        }
        ((AdListener) aVar).onAdTick(j6);
    }

    @NonNull
    private e a(String str, com.beizi.fusion.work.a aVar) {
        aa.a("BeiZis", "comparePrices handleCompeteToDetermine worker:" + aVar.f());
        this.f13324i = aVar;
        this.F.f13493h.a(str, 2);
        z();
        return e.TO_DETERMINE;
    }

    @NonNull
    private e a(String str, com.beizi.fusion.work.a aVar, String str2) {
        if (!this.E) {
            a(aVar, str2);
            y();
            z();
            return l(str);
        }
        b(aVar, 1);
        return m(str);
    }

    private void a(com.beizi.fusion.work.a aVar, String str) {
        this.E = true;
        aa.a("BeiZis", "---handleCompeteSuccess---" + str + "---" + e(aVar));
        this.f13324i = aVar;
        a(aVar, 1);
    }

    public void a(com.beizi.fusion.a aVar) {
        this.f13323h = aVar;
    }

    public void a(boolean z5) {
        this.f13333s = z5;
    }

    public void a(Map map) {
        com.beizi.fusion.work.a aVar = this.f13324i;
        if (aVar == null || map == null) {
            return;
        }
        aVar.a(map);
    }

    private void a(JSONObject jSONObject) {
        Map<String, Object> map;
        JSONObject ax;
        if (jSONObject == null) {
            return;
        }
        try {
            if (this.f13324i == null || (map = this.V) == null || !map.containsKey("materialInfo") || (ax = this.f13324i.ax()) == null || !ax.has("materialInfo")) {
                return;
            }
            jSONObject.put("materialInfo", ax.optJSONObject("materialInfo"));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
