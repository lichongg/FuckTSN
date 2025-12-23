package com.bytedance.sdk.openadsdk.core.video.j;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.api.cw.r;
import com.bykv.vk.openvk.component.video.api.r.cw;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderTextureView;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.tl;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.multipro.xt.j;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.q;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.m;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.xt;
import com.bytedance.sdk.openadsdk.l.g;
import com.bytedance.sdk.openadsdk.l.oq;
import com.bytedance.sdk.openadsdk.m.cw.i;
import com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j implements cw, l.j, j.InterfaceC0466j, xt {
    protected long av;
    private long ch;
    protected SurfaceTexture cw;

    /* renamed from: f, reason: collision with root package name */
    protected r f30963f;

    /* renamed from: g, reason: collision with root package name */
    protected WeakReference<Context> f30964g;

    /* renamed from: m, reason: collision with root package name */
    protected n f30967m;
    protected List<Runnable> qv;

    /* renamed from: r, reason: collision with root package name */
    protected com.bykv.vk.openvk.component.video.api.j f30968r;

    /* renamed from: s, reason: collision with root package name */
    private long f30969s;
    protected m up;

    /* renamed from: v, reason: collision with root package name */
    protected InterfaceC0491j f30970v;
    protected SurfaceHolder xt;

    /* renamed from: j, reason: collision with root package name */
    protected final l f30966j = new l(Looper.getMainLooper(), this);
    protected long ae = 0;
    protected long tl = 0;
    protected boolean oq = false;
    protected boolean vl = true;
    protected long jy = 0;
    protected boolean ws = false;
    protected boolean az = false;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f30965i = false;

    /* renamed from: w, reason: collision with root package name */
    protected volatile boolean f30971w = false;
    protected boolean mi = false;
    protected boolean kt = false;
    public com.bytedance.sdk.openadsdk.m.xt.j tj = new com.bytedance.sdk.openadsdk.m.xt.j();

    /* renamed from: x, reason: collision with root package name */
    protected Runnable f30972x = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.j.j.1
        @Override // java.lang.Runnable
        public void run() {
            vl.j("BaseController", "resumeVideo: run ", Boolean.valueOf(j.this.oq));
            j.this.ed();
        }
    };

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.j.j$j, reason: collision with other inner class name */
    public interface InterfaceC0491j {
        void j(long j6, long j7);
    }

    public boolean a() {
        return true;
    }

    protected long cw(r rVar) {
        com.bykv.vk.openvk.component.video.api.cw.cw ch;
        if (rVar == null || (ch = rVar.ch()) == null) {
            return 0L;
        }
        int tz = this.f30967m.tz();
        n nVar = this.f30967m;
        if (nVar != null) {
            int tl = uf.tl(nVar);
            if (!xt(tz)) {
                return 0L;
            }
            if ((tl != 7 && tl != 8) || q.j(this.f30967m)) {
                return 0L;
            }
        }
        double ae = ch.ae();
        if (ae < 0.0d || ae >= ch.m()) {
            return 0L;
        }
        long xt = g.j(rVar.w()).xt(rVar);
        int av = ch.av();
        if (av <= 0 || xt < av) {
            return 0L;
        }
        long j6 = (long) (ae * 1000.0d);
        this.ch = j6;
        return j6;
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
    }

    protected Map<String, Object> ol() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.xt.j.InterfaceC0466j
    public boolean p() {
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public boolean r() {
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public boolean up() {
        return false;
    }

    public boolean xt(int i6) {
        return i6 == 6 || i6 == 8 || i6 == 9;
    }

    private long up(long j6) {
        long qv = qv();
        return rn() ? j(qv, j6) : qv;
    }

    private boolean v() {
        m mVar = this.up;
        if (mVar == null) {
            return false;
        }
        com.bykv.vk.openvk.component.video.api.renderview.xt i6 = mVar.i();
        return (i6 instanceof SSRenderTextureView) || (i6 instanceof UpieVideoView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        Iterator it = new ArrayList(this.qv).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.qv.clear();
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public boolean av() {
        return this.az;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public m w() {
        return this.up;
    }

    protected void ed() {
        this.f30966j.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.j.j.3
            @Override // java.lang.Runnable
            public void run() {
                j jVar = j.this;
                if (jVar.f30968r != null) {
                    vl.j("BaseController", "resumeVideo: execResumePlay", Boolean.valueOf(jVar.oq));
                    j.this.f30968r.xt();
                }
            }
        });
    }

    protected void g(boolean z5) {
        this.kt = z5;
    }

    protected int gq() {
        int i6 = q.j(this.f30967m) ? 3 : 0;
        if (rn()) {
            return 3;
        }
        return i6;
    }

    public boolean gx() {
        return this.vl;
    }

    public boolean h() {
        if ((!this.up.jy() || !this.oq) && !oq.j(this.f30967m) && !com.bytedance.sdk.openadsdk.up.j.xt(this.f30967m)) {
            j("not exec pending");
            return false;
        }
        tl(false);
        uf();
        return true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public com.bykv.vk.openvk.component.video.api.j i() {
        return this.f30968r;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public boolean kt() {
        return this.mi;
    }

    protected boolean l() {
        WeakReference<Context> weakReference = this.f30964g;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.xt.j.InterfaceC0466j
    public com.bytedance.sdk.openadsdk.core.multipro.xt.j la() {
        com.bytedance.sdk.openadsdk.core.multipro.xt.j jVar = new com.bytedance.sdk.openadsdk.core.multipro.xt.j();
        jVar.ae = this.ae;
        jVar.f29581j = kt();
        jVar.tl = mi();
        jVar.f29583r = tj();
        return jVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public boolean mi() {
        return this.f30965i;
    }

    protected void n() {
        i.j jVar = new i.j();
        long ws = ws();
        jVar.j(up(ws));
        jVar.cw(ws);
        jVar.xt(vl());
        jVar.m(jy());
        r xt = com.bytedance.sdk.openadsdk.m.xt.r.xt(this.up);
        if (xt != null) {
            xt.j("EXTRA_PLAY_ACTION", ol());
        }
        com.bytedance.sdk.openadsdk.m.xt.r.r(this.up, jVar);
    }

    protected void nd() {
        i.j jVar = new i.j();
        long ws = ws();
        jVar.j(up(ws));
        jVar.cw(ws);
        jVar.xt(vl());
        r xt = com.bytedance.sdk.openadsdk.m.xt.r.xt(this.up);
        if (xt != null) {
            xt.j("EXTRA_PLAY_ACTION", ol());
        }
        xt(w(), jVar);
    }

    protected void oq(boolean z5) {
        i.j jVar = new i.j();
        jVar.xt(true);
        jVar.cw(z5);
        r xt = com.bytedance.sdk.openadsdk.m.xt.r.xt(this.up);
        if (xt != null) {
            xt.j("EXTRA_PLAY_START", ol());
        }
        cw(this.up, jVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public long qv() {
        return this.ae;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void r(long j6) {
        this.av = j6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rh() {
        if (this.f30963f == null) {
            return;
        }
        this.tj.cw(1);
        this.f30963f.j("EXTRA_PLAY_START", ol());
        com.bytedance.sdk.openadsdk.m.xt.r.j(this.f30967m, (com.bykv.vk.openvk.component.video.api.xt.j) this.up, this.f30963f, true);
    }

    public boolean rn() {
        return this.ch > 0;
    }

    protected void s() {
        if (this.f30968r == null) {
            return;
        }
        if (v()) {
            SurfaceTexture surfaceTexture = this.cw;
            if (surfaceTexture == null || surfaceTexture == this.f30968r.tl()) {
                return;
            }
            this.f30968r.j(this.cw);
            return;
        }
        SurfaceHolder surfaceHolder = this.xt;
        if (surfaceHolder == null || surfaceHolder == this.f30968r.ae()) {
            return;
        }
        this.f30968r.j(this.xt);
    }

    public void tl(boolean z5) {
        this.f30971w = z5;
    }

    protected void uf() {
        vl.j("BaseController", "execPendingActions: before ");
        List<Runnable> list = this.qv;
        if (list == null || list.isEmpty() || this.f30971w) {
            return;
        }
        vl.j("BaseController", "execPendingActions:  exec");
        tl.xt().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.j.j.2
            @Override // java.lang.Runnable
            public void run() {
                j.this.x();
            }
        });
    }

    public long wq() {
        return this.ch;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public long ws() {
        com.bykv.vk.openvk.component.video.api.j jVar = this.f30968r;
        if (jVar == null) {
            return 0L;
        }
        return jVar.w();
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void xt(long j6) {
        this.ae = j6;
        long j7 = this.tl;
        if (j7 > j6) {
            j6 = j7;
        }
        this.tl = j6;
    }

    protected void j(Runnable runnable) {
        if (runnable == null || this.f30967m == null) {
            return;
        }
        if ((!this.up.jy() || !this.oq) && !oq.j(this.f30967m) && !com.bytedance.sdk.openadsdk.up.j.xt(this.f30967m)) {
            xt(runnable);
        } else {
            runnable.run();
        }
    }

    public void r(int i6) {
        com.bykv.vk.openvk.component.video.api.j jVar = this.f30968r;
        if (jVar != null) {
            jVar.xt(i6);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public long vl() {
        if (i() == null) {
            return 0L;
        }
        return i().av();
    }

    protected void xt(Runnable runnable) {
        if (this.qv == null) {
            this.qv = new ArrayList();
        }
        this.qv.add(runnable);
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.j
    public void xt(com.bykv.vk.openvk.component.video.api.r.xt xtVar, SurfaceHolder surfaceHolder) {
        this.oq = false;
        this.xt = null;
        com.bykv.vk.openvk.component.video.api.j jVar = this.f30968r;
        if (jVar != null) {
            jVar.xt(false);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.j
    public void j(com.bykv.vk.openvk.component.video.api.r.xt xtVar, SurfaceHolder surfaceHolder) {
        this.oq = true;
        this.xt = surfaceHolder;
        com.bykv.vk.openvk.component.video.api.j jVar = this.f30968r;
        if (jVar == null) {
            return;
        }
        if (jVar != null) {
            jVar.j(surfaceHolder);
        }
        vl.j("BaseController", "surfaceCreated: ");
        uf();
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.j
    public void xt(com.bykv.vk.openvk.component.video.api.r.xt xtVar, SurfaceTexture surfaceTexture) {
        this.oq = false;
        vl.j("BaseController", "surfaceTextureDestroyed: ");
        com.bykv.vk.openvk.component.video.api.j jVar = this.f30968r;
        if (jVar != null) {
            jVar.xt(false);
        }
        this.cw = null;
        uf();
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void cw(long j6) {
        this.jy = j6;
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void cw(boolean z5) {
        this.mi = z5;
    }

    public void cw(int i6) {
        if (this.tj.r(1)) {
            if (!this.vl) {
                i6 *= 10;
            }
            j(-900001, i6, "only play start", (JSONArray) null);
        }
        JSONArray jSONArray = new JSONArray();
        if (this.tj.j(1)) {
            return;
        }
        String xt = uf.xt(this.f30967m);
        JSONObject j6 = j(4, xt);
        if (j6 != null) {
            jSONArray.put(j6);
        }
        JSONObject j7 = j(2, xt);
        if (j7 != null) {
            jSONArray.put(j7);
        }
        JSONObject j8 = j(8, xt);
        if (j8 != null) {
            jSONArray.put(j8);
        }
        JSONObject j9 = j(32, xt);
        if (j9 != null) {
            jSONArray.put(j9);
        }
        JSONObject j10 = j(64, xt);
        if (j10 != null) {
            jSONArray.put(j10);
        }
        JSONObject j11 = j(128, xt);
        if (j11 != null) {
            jSONArray.put(j11);
        }
        j(-900002, -701, "lack play start", jSONArray);
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.j
    public void j(com.bykv.vk.openvk.component.video.api.r.xt xtVar, SurfaceTexture surfaceTexture) {
        this.oq = true;
        this.cw = surfaceTexture;
        com.bykv.vk.openvk.component.video.api.j jVar = this.f30968r;
        if (jVar != null) {
            jVar.j(surfaceTexture);
            this.f30968r.xt(this.oq);
        }
        vl.j("BaseController", "surfaceTextureCreated: ");
        uf();
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void xt(boolean z5) {
        this.f30965i = z5;
        com.bykv.vk.openvk.component.video.api.j jVar = this.f30968r;
        if (jVar != null) {
            jVar.j(z5);
        }
    }

    public void xt(com.bykv.vk.openvk.component.video.api.xt.j jVar, i.j jVar2) {
        this.tj.cw(8);
        com.bytedance.sdk.openadsdk.m.xt.r.xt(w(), jVar2);
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw
    public void j(boolean z5) {
        this.vl = z5;
        m mVar = this.up;
        if (mVar != null) {
            mVar.r(z5);
        }
    }

    public long j(long j6, long j7) {
        long wq = wq();
        if (!cw() && (j6 == wq || j6 - wq < 0 || j6 == 0)) {
            return 0L;
        }
        n nVar = this.f30967m;
        if (nVar == null) {
            return j6;
        }
        if (nVar.to() == 2 && j7 > 60000) {
            if (this.ws) {
                long j8 = j7 - 60000;
                long j9 = this.f30969s;
                if (j6 - j9 >= j8) {
                    return j9;
                }
            }
            j7 = 60000;
        }
        long j10 = j6 - wq;
        long j11 = j10 + (j7 * (j10 > 0 ? 0 : 1));
        this.f30969s = j11;
        return j11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error", str);
        } catch (JSONException unused) {
        }
        ws.j().j("video", jSONObject, (Throwable) null);
    }

    protected void cw(Map<String, Object> map) {
        i.j jVar = new i.j();
        long ws = ws();
        jVar.j(up(ws));
        jVar.cw(ws);
        jVar.xt(vl());
        r xt = com.bytedance.sdk.openadsdk.m.xt.r.xt(this.up);
        if (xt != null) {
            xt.j("EXTRA_PLAY_ACTION", ol());
        }
        if (map != null) {
            jVar.j(map);
        }
        j(this.up, jVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(int i6, int i7, String str, JSONArray jSONArray) {
        if (this.f30964g == null) {
            return;
        }
        i.j jVar = new i.j();
        jVar.xt(vl());
        long ws = ws();
        jVar.cw(ws);
        jVar.j(up(ws));
        jVar.j(i6);
        jVar.xt(i7);
        jVar.j(jSONArray);
        if (this.tj.j(256)) {
            return;
        }
        this.tj.cw(256);
        com.bytedance.sdk.openadsdk.m.xt.r.j(w(), jVar, str, !this.tj.j(2) ? 1 : 0, this.tj.j(128));
    }

    protected void cw(com.bykv.vk.openvk.component.video.api.xt.j jVar, i.j jVar2) {
        this.tj.cw(2);
        com.bytedance.sdk.openadsdk.m.xt.r.j(jVar, jVar2);
    }

    private JSONObject j(int i6, String str) {
        String str2;
        try {
            if (this.tj.j(128)) {
                str2 = "endcard_skip";
            } else if (this.tj.j(8)) {
                str2 = "feed_continue";
            } else if (this.tj.j(4)) {
                str2 = "feed_pause";
            } else if (this.tj.j(2)) {
                str2 = "feed_play";
            } else if (this.tj.j(64)) {
                str2 = "feed_over";
            } else {
                str2 = this.tj.j(32) ? "feed_break" : null;
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt(CommonNetImpl.TAG, str);
                jSONObject.putOpt("label", str2);
                jSONObject.putOpt("time", this.tj.xt(i6));
                return jSONObject;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    protected void j(com.bykv.vk.openvk.component.video.api.xt.j jVar, i.j jVar2) {
        this.tj.cw(4);
        com.bytedance.sdk.openadsdk.m.xt.r.j(this.up, jVar2, !this.tj.j(2) ? 1 : 0);
    }

    public void j(InterfaceC0491j interfaceC0491j) {
        this.f30970v = interfaceC0491j;
    }
}
