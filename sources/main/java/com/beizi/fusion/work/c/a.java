package com.beizi.fusion.work.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.beizi.fusion.NativeUnifiedAdResponse;
import com.beizi.fusion.c.c;
import com.beizi.fusion.c.d;
import com.beizi.fusion.c.e;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.UnifiedAdDownloadAppInfo;
import com.beizi.fusion.tool.ap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends com.beizi.fusion.work.a implements c {

    /* renamed from: n, reason: collision with root package name */
    protected Context f14180n;

    /* renamed from: o, reason: collision with root package name */
    protected long f14181o;

    /* renamed from: p, reason: collision with root package name */
    protected float f14182p;

    /* renamed from: q, reason: collision with root package name */
    protected float f14183q;

    /* renamed from: r, reason: collision with root package name */
    protected NativeUnifiedAdResponse f14184r;

    /* renamed from: s, reason: collision with root package name */
    protected FrameLayout f14185s;

    /* renamed from: t, reason: collision with root package name */
    protected boolean f14186t = false;

    /* renamed from: u, reason: collision with root package name */
    protected boolean f14187u = false;

    public void a(View view) {
    }

    public String aA() {
        return null;
    }

    public String aB() {
        return null;
    }

    public String aC() {
        return null;
    }

    public List<String> aD() {
        return null;
    }

    public int aE() {
        return 0;
    }

    public String aF() {
        return null;
    }

    public boolean aG() {
        return false;
    }

    public ViewGroup aH() {
        return null;
    }

    public View aI() {
        return null;
    }

    public String aK() {
        return null;
    }

    public UnifiedAdDownloadAppInfo aL() {
        return null;
    }

    public String az() {
        return null;
    }

    @Override // com.beizi.fusion.work.a
    public String f() {
        return null;
    }

    private void aN() {
        d dVar = this.f14055d;
        if (dVar == null) {
            return;
        }
        Map<String, com.beizi.fusion.work.a> n6 = dVar.n();
        f();
        n6.toString();
        Z();
        e eVar = this.f14058g;
        if (eVar == e.SUCCESS) {
            aO();
            this.f14055d.a(f(), (View) null);
        } else if (eVar == e.FAIL) {
            f();
        }
    }

    private void aO() {
        this.f14184r = new NativeUnifiedAdResponse() { // from class: com.beizi.fusion.work.c.a.1
            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public String getActionText() {
                return a.this.aF();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public String getAdLogoUrl() {
                return a.this.aK();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public String getDescription() {
                return a.this.aA();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public UnifiedAdDownloadAppInfo getDownloadAppInfo() {
                return a.this.aL();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public int getECPM() {
                String i6 = a.this.i();
                if (i6 == null) {
                    return -1;
                }
                try {
                    return Integer.parseInt(i6);
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return -1;
                }
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public String getIconUrl() {
                return a.this.aB();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public String getImageUrl() {
                return a.this.aC();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public List<String> getImgList() {
                return a.this.aD();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public int getMaterialType() {
                return a.this.aE();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public String getTitle() {
                return a.this.az();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public View getVideoView() {
                return a.this.aI();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public ViewGroup getViewContainer() {
                return a.this.aH();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public boolean isVideo() {
                return a.this.aG();
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public void registerDownloadAppInfoClickEvent(View view) {
                a.this.a(view);
            }

            @Override // com.beizi.fusion.NativeUnifiedAdResponse
            public void registerViewForInteraction(List<View> list) {
                a.this.a(list);
            }
        };
    }

    public void a(List<View> list) {
    }

    @Override // com.beizi.fusion.work.a
    public NativeUnifiedAdResponse as() {
        return this.f14184r;
    }

    @Override // com.beizi.fusion.work.a
    public void d() {
        if (this.f14055d == null) {
            return;
        }
        this.f14059h = this.f14056e.getAppId();
        this.f14060i = this.f14056e.getSpaceId();
        this.f14054c = this.f14056e.getBuyerSpaceUuId();
        com.beizi.fusion.events.b bVar = this.f14052a;
        if (bVar != null) {
            EventBean a6 = bVar.a().a(this.f14054c);
            this.f14053b = a6;
            if (a6 != null) {
                s();
                b();
            }
        }
    }

    @Override // com.beizi.fusion.work.a
    public com.beizi.fusion.e.a h() {
        return this.f14061j;
    }

    @Override // com.beizi.fusion.work.a
    public AdSpacesBean.BuyerBean j() {
        return this.f14056e;
    }

    public a(Context context, long j6, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, d dVar, int i6) {
        this.f14180n = context;
        this.f14181o = j6;
        this.f14056e = buyerBean;
        this.f14055d = dVar;
        this.f14062k = i6;
        this.f14057f = forwardBean;
        this.f14182p = ap.k(context);
        this.f14183q = ap.l(context);
        r();
    }

    protected void aM() {
        try {
            if (Y()) {
                aN();
            } else {
                P();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.work.a
    protected void k() {
        v();
        ab();
        ay();
    }

    public void aJ() {
    }

    public void ay() {
    }

    public void b() {
    }

    @Override // com.beizi.fusion.work.a
    public void e() {
    }
}
