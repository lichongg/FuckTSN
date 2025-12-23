package com.bytedance.sdk.openadsdk.core.qv.cw;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.openadsdk.core.av;
import com.bytedance.sdk.openadsdk.core.ed;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.mi;
import com.bytedance.sdk.openadsdk.core.qv.r.cw;
import com.bytedance.sdk.openadsdk.core.rn.la;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.i;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.tj;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.xt.j.xt.cw;
import com.bytedance.sdk.openadsdk.core.xt.j.xt.up;
import com.tencent.open.SocialConstants;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class up extends cw implements l.j {
    protected final String az;
    private volatile com.bytedance.sdk.openadsdk.core.qv.cw.cw.cw ch;
    protected WeakReference<Context> cw;

    /* renamed from: f, reason: collision with root package name */
    protected Function<SparseArray<Object>, Object> f29919f;
    protected volatile Runnable kt;

    /* renamed from: m, reason: collision with root package name */
    protected String f29922m;
    protected HashSet<Integer> qv;

    /* renamed from: r, reason: collision with root package name */
    protected final com.bytedance.sdk.openadsdk.core.tj.up f29923r;
    protected n up;

    /* renamed from: v, reason: collision with root package name */
    protected volatile boolean f29925v;
    protected com.bytedance.sdk.openadsdk.core.qv.xt.up vl;

    /* renamed from: w, reason: collision with root package name */
    protected av f29926w;

    /* renamed from: x, reason: collision with root package name */
    protected boolean f29927x;
    protected final AtomicInteger ae = new AtomicInteger(1);
    protected final AtomicBoolean tl = new AtomicBoolean(false);

    /* renamed from: g, reason: collision with root package name */
    protected boolean f29920g = false;
    protected final AtomicBoolean oq = new AtomicBoolean(false);
    protected final l jy = new l(Looper.getMainLooper(), this);
    protected boolean ws = true;
    protected boolean av = false;

    /* renamed from: i, reason: collision with root package name */
    protected volatile boolean f29921i = false;
    protected j mi = new j();
    protected int tj = 0;

    /* renamed from: s, reason: collision with root package name */
    private List<mi> f29924s = new CopyOnWriteArrayList();

    public class j extends com.bytedance.sdk.component.oq.g {
        long cw;

        /* renamed from: j, reason: collision with root package name */
        String f29937j;

        /* renamed from: r, reason: collision with root package name */
        String f29939r;
        String up;
        long xt;

        j() {
            super("DownloadCallbackRunnable");
        }

        public void j(String str) {
            this.f29937j = str;
        }

        public void xt(long j6) {
            this.cw = j6;
        }

        public void cw(String str) {
            this.up = str;
        }

        public void j(long j6) {
            this.xt = j6;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                up.this.g().j(up.this.az, this.f29937j, this.xt, this.cw, this.f29939r, this.up);
            } catch (Throwable unused) {
            }
        }

        public void xt(String str) {
            this.f29939r = str;
        }

        j(String str, long j6, long j7, String str2, String str3) {
            super("DownloadCallbackRunnable");
            this.f29937j = str;
            this.xt = j6;
            this.cw = j7;
            this.f29939r = str2;
            this.up = str3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(final JSONObject jSONObject, final boolean z5) {
        int j6 = com.bytedance.sdk.openadsdk.core.live.xt.j().j(this.up, new com.bytedance.sdk.openadsdk.core.live.j.cw() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.up.8
            @Override // com.bytedance.sdk.openadsdk.core.live.j.cw
            public void j(int i6) {
                up.this.tl(jSONObject, z5);
            }
        }, this.f29922m);
        if (j6 == 1 || j6 == 2) {
            return;
        }
        tl(jSONObject, z5);
    }

    public abstract void av();

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public abstract boolean cw();

    public boolean cw(JSONObject jSONObject, boolean z5) {
        if (this.ae.get() == 1) {
            if (ws.cw(getContext()) == 0) {
                try {
                    a.j(getContext(), kt.j(getContext(), "tt_no_network"), 0);
                } catch (Exception unused) {
                }
            } else {
                if (uf.xt(getContext())) {
                    uf.j(this.f29921i, this.up, this.f29922m);
                }
                r(jSONObject, z5);
            }
            return true;
        }
        if (uf.xt(getContext())) {
            uf.j(this.f29921i, this.up, this.f29922m);
        }
        j(jSONObject, z5);
        if (this.ae.get() == 3 || this.ae.get() == 4) {
            this.tl.set(false);
            return false;
        }
        if (this.ae.get() == 6) {
            this.tl.set(true);
        }
        return false;
    }

    public boolean m() {
        if (this.up.m111if() != null) {
            String xt = this.up.m111if().xt();
            if (!TextUtils.isEmpty(xt)) {
                i.j((String) null);
                Uri parse = Uri.parse(xt);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                uf.xt(intent);
                if (this.f29921i) {
                    com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.up, this.f29922m, "lp_open_dpl", j(xt));
                }
                if (uf.j(getContext(), intent)) {
                    try {
                        uf.j(this.f29921i, this.up, this.f29922m);
                        if (!j(this.f29922m, "open_url_app", this.up)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put(SocialConstants.PARAM_SOURCE, "DMLibManager");
                            com.bytedance.sdk.openadsdk.core.jy.cw.tl(this.up, this.f29922m, "open_url_app", hashMap);
                        }
                        com.bytedance.sdk.component.utils.xt.startActivity(getContext(), intent, TextUtils.equals("main", UMModuleRegister.INNER));
                        com.bytedance.sdk.openadsdk.core.jy.m.j().j(this.up, this.f29922m, this.f29921i);
                        if (this.f29921i) {
                            com.bytedance.sdk.openadsdk.core.jy.cw.j(this.up, this.f29922m, "lp_openurl", (Throwable) null);
                            com.bytedance.sdk.openadsdk.core.jy.cw.j(this.up, this.f29922m, "lp_deeplink_success_realtime", (Throwable) null);
                        } else {
                            com.bytedance.sdk.openadsdk.core.jy.cw.j(this.up, this.f29922m, "deeplink_success_realtime", (Throwable) null);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (!TextUtils.isEmpty(this.up.yb())) {
                            ed.j(getContext(), this.up.yb(), this.up, this.f29922m);
                        }
                        if (this.f29921i) {
                            com.bytedance.sdk.openadsdk.core.jy.cw.cw(this.up, this.f29922m, "lp_openurl_failed");
                            j(this.up, this.f29922m, "lp_deeplink_fail_realtime", th);
                        } else {
                            j(this.up, this.f29922m, "deeplink_fail_realtime", th);
                        }
                        return false;
                    }
                }
                if (this.f29921i) {
                    com.bytedance.sdk.openadsdk.core.jy.cw.cw(this.up, this.f29922m, "lp_openurl_failed");
                    j(this.up, this.f29922m, "lp_deeplink_fail_realtime", null);
                } else {
                    j(this.up, this.f29922m, "deeplink_fail_realtime", null);
                }
            }
            if (this.ae.get() != 4 && this.ae.get() != 3 && (!this.f29920g || this.tl.get())) {
                this.f29920g = true;
                if (!j(this.f29922m, "open_fallback_url", this.up)) {
                    com.bytedance.sdk.openadsdk.core.jy.cw.tl(this.up, this.f29922m, "open_fallback_url", null);
                }
            }
        }
        return false;
    }

    protected abstract void qv();

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void r(boolean z5) {
        this.f29927x = z5;
    }

    public com.bytedance.sdk.openadsdk.core.qv.cw.cw.cw tl() {
        if (this.ch == null) {
            synchronized (this) {
                try {
                    if (this.ch == null) {
                        this.ch = new com.bytedance.sdk.openadsdk.core.qv.cw.cw.cw(getContext(), this.up);
                    }
                } finally {
                }
            }
        }
        return this.ch;
    }

    public abstract void tl(boolean z5);

    protected void up(boolean z5) {
        if (z5) {
            com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.up, this.f29922m, "quickapp_success");
        } else {
            com.bytedance.sdk.openadsdk.core.jy.cw.xt(this.up, this.f29922m, "quickapp_fail");
        }
    }

    private void w() {
        if (this.av) {
            return;
        }
        this.av = true;
        j(4, new cw.j() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.up.7
            @Override // com.bytedance.sdk.openadsdk.core.qv.r.cw.j
            public boolean j(int i6, String str, String str2, String str3, Object obj) {
                if (i6 != 4) {
                    return true;
                }
                if ("market_click_open".equals(str3) || "applink_click".equals(str3)) {
                    com.bytedance.sdk.openadsdk.core.xt.j().j("save_jump_success_time", System.currentTimeMillis());
                    com.bytedance.sdk.openadsdk.core.xt.j().j("save_jump_success_ad_tag", str2);
                    com.bytedance.sdk.openadsdk.core.xt.j().j("save_dpl_success_materialmeta", str);
                }
                return true;
            }
        });
    }

    public boolean az() {
        n nVar = this.up;
        return (nVar == null || this.f29923r == null || tj.m(nVar) != 3 || this.f29923r.j() == null) ? false : true;
    }

    protected av g() {
        if (this.f29926w == null) {
            this.f29926w = av.j.j(com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j(v.getContext()).j(3));
        }
        return this.f29926w;
    }

    protected Context getContext() {
        try {
            WeakReference<Context> weakReference = this.cw;
            if (weakReference == null) {
                return v.getContext();
            }
            Context context = weakReference.get();
            return context == null ? v.getContext() : context;
        } catch (Throwable unused) {
            return v.getContext();
        }
    }

    protected boolean jy() {
        Object apply;
        if (this.f29919f == null || tj.mi(this.up) == 1 || tj.oq(this.up)) {
            return true;
        }
        apply = this.f29919f.apply(com.bytedance.sdk.openadsdk.i.r.j().j(6).j(Boolean.class).j(0, new la().j("downloadUrl", this.f29923r.xt()).j("hashCode", Integer.valueOf(ae()))).xt());
        if (apply == null || !((Boolean) apply).booleanValue()) {
            return true;
        }
        com.bytedance.sdk.openadsdk.l.ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.up.5
            @Override // java.lang.Runnable
            public void run() {
                a.j(up.this.getContext(), "应用正在下载...", 0);
            }
        });
        return false;
    }

    protected void oq() {
        if (this.cw == null) {
            return;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null || !com.bytedance.sdk.openadsdk.core.oq.i().j(activity)) {
            i();
        } else {
            xt(activity);
        }
    }

    protected void r(JSONObject jSONObject, boolean z5) {
        m(jSONObject, z5);
        this.tl.set(true);
    }

    public int vl() {
        return this.ae.get();
    }

    public up(Context context, n nVar, String str, boolean z5) {
        this.cw = new WeakReference<>(context);
        this.up = nVar;
        com.bytedance.sdk.openadsdk.core.tj.up by = nVar.by();
        this.f29923r = by;
        str = TextUtils.isEmpty(str) ? uf.xt(nVar) : str;
        this.f29922m = TextUtils.isEmpty(str) ? "embeded_ad" : str;
        this.az = nVar.hashCode() + nVar.ej();
        this.f29919f = com.bytedance.sdk.openadsdk.core.oq.i().gx();
        if (by == null) {
            return;
        }
        if (v.getContext() == null) {
            v.j(context);
        }
        this.vl = new com.bytedance.sdk.openadsdk.core.qv.xt.up();
        j(z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (!com.bytedance.sdk.openadsdk.core.multipro.xt.cw()) {
            return;
        }
        com.bytedance.sdk.component.oq.ae.cw().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.up.2
            @Override // java.lang.Runnable
            public void run() {
                av j6 = av.j.j(com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j(v.getContext()).j(3));
                try {
                    synchronized (up.this.f29924s) {
                        if (j6 != null) {
                            try {
                                if (up.this.f29924s.size() > 0) {
                                    Iterator it = up.this.f29924s.iterator();
                                    while (it.hasNext()) {
                                        j6.xt(up.this.az, (mi) it.next());
                                    }
                                    up.this.f29924s.clear();
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                } catch (RemoteException e6) {
                    vl.j(e6);
                }
            }
        });
    }

    private void xt(Activity activity) {
        com.bytedance.sdk.openadsdk.core.rn.j r5 = com.bytedance.sdk.openadsdk.core.oq.i().r();
        if (r5 != null && this.kt == null) {
            this.kt = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.up.1
                @Override // java.lang.Runnable
                public void run() {
                    up.this.i();
                    up.this.kt = null;
                }
            };
            r5.j(activity, this.kt);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void j(boolean z5) {
        tl(z5);
        av();
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public Map<String, Object> up() {
        return new HashMap();
    }

    protected com.bytedance.sdk.openadsdk.core.qv.cw.cw.j ws() {
        if (cw()) {
            return new com.bytedance.sdk.openadsdk.core.qv.cw.cw.up();
        }
        if (this.f29921i) {
            return new com.bytedance.sdk.openadsdk.core.qv.cw.cw.r();
        }
        return new com.bytedance.sdk.openadsdk.core.qv.cw.cw.xt();
    }

    protected boolean ae(boolean z5) {
        if (this.f29923r == null || !az()) {
            return false;
        }
        boolean j6 = j(getContext(), this.f29923r.j(), this.up, this.f29922m, this.f29921i);
        if (j6) {
            Message obtain = Message.obtain();
            obtain.what = 9;
            obtain.obj = Boolean.valueOf(z5);
            this.jy.sendMessageDelayed(obtain, 3000L);
            com.bytedance.sdk.openadsdk.core.xt.j().j("save_jump_success_time", System.currentTimeMillis());
            com.bytedance.sdk.openadsdk.core.xt.j().j("save_jump_success_ad_tag", this.f29922m);
            com.bytedance.sdk.openadsdk.core.xt.j().j("save_dpl_success_materialmeta", this.up.tv().toString());
            return j6;
        }
        up(false);
        return j6;
    }

    protected void up(JSONObject jSONObject, boolean z5) {
        if (m()) {
            this.tl.set(true);
            return;
        }
        if (!this.f29921i && this.up.by() == null && this.up.yb() != null && !this.up.er()) {
            ed.j(getContext(), this.up.yb(), this.up, this.f29922m);
        } else if (ae(z5)) {
            this.tl.set(true);
        } else {
            if (this.up.er()) {
                return;
            }
            xt(jSONObject, z5);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void j(com.bytedance.sdk.openadsdk.core.qv.xt.j jVar) {
        j(jVar, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void j(com.bytedance.sdk.openadsdk.core.qv.xt.j jVar, boolean z5) {
        if (jVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.qv.xt.up upVar = this.vl;
        if (upVar != null) {
            upVar.j(jVar);
        }
        if (z5) {
            xt(jVar);
        }
        av();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tl(final JSONObject jSONObject, final boolean z5) {
        com.bytedance.sdk.openadsdk.core.live.xt j6 = com.bytedance.sdk.openadsdk.core.live.xt.j();
        HashMap hashMap = new HashMap(1);
        hashMap.put("event_tag", this.f29922m);
        if ((j6.j(getContext(), this.up, hashMap) & 255) == 0) {
            com.bytedance.sdk.openadsdk.core.xt.j().j("save_jump_success_time", System.currentTimeMillis());
            com.bytedance.sdk.openadsdk.core.xt.j().j("save_jump_success_ad_tag", this.f29922m);
            com.bytedance.sdk.openadsdk.core.xt.j().j("save_dpl_success_materialmeta", this.up.tv().toString());
            return;
        }
        tl().j(ws(), this.up);
        boolean j7 = com.bytedance.sdk.openadsdk.core.xt.j.xt.up.j();
        if (j7) {
            com.bytedance.sdk.openadsdk.core.xt.j.xt.up.j(false);
        }
        if (!j7) {
            if (new com.bytedance.sdk.openadsdk.core.xt.j.xt.up(this.up, getContext()).j(this.f29922m).j(uf.xt(this.f29922m)).xt(this.f29921i).j(new up.j() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.up.9
                @Override // com.bytedance.sdk.openadsdk.core.xt.j.xt.up.j
                public void xt() {
                    up.this.up(jSONObject, z5);
                }

                @Override // com.bytedance.sdk.openadsdk.core.xt.j.xt.up.j
                public void j() {
                    com.bytedance.sdk.openadsdk.core.xt.j().j("save_jump_success_time", System.currentTimeMillis());
                    com.bytedance.sdk.openadsdk.core.xt.j().j("save_jump_success_ad_tag", up.this.f29922m);
                    com.bytedance.sdk.openadsdk.core.xt.j().j("save_dpl_success_materialmeta", up.this.up.tv().toString());
                }
            })) {
                return;
            }
            up(jSONObject, z5);
            return;
        }
        up(jSONObject, z5);
    }

    protected void xt(final com.bytedance.sdk.openadsdk.core.qv.xt.j jVar) {
        if (!com.bytedance.sdk.openadsdk.core.multipro.xt.cw() || jVar == null) {
            return;
        }
        com.bytedance.sdk.component.oq.ae.cw().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.up.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.j j6 = com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j(v.getContext());
                com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.m mVar = new com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.m(jVar);
                av j7 = av.j.j(j6.j(3));
                if (j7 != null) {
                    try {
                        j7.j(up.this.az, mVar);
                        synchronized (up.this.f29924s) {
                            up.this.f29924s.add(mVar);
                        }
                    } catch (RemoteException e6) {
                        vl.j(e6);
                    }
                }
            }
        });
    }

    protected void xt(JSONObject jSONObject, boolean z5) {
        com.bytedance.sdk.openadsdk.core.tj.up upVar = this.f29923r;
        if (upVar == null || upVar.xt() == null) {
            return;
        }
        cw(jSONObject, z5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.bytedance.sdk.openadsdk.core.qv.j.j] */
    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void j(int i6, cw.j jVar) {
        if (this.qv == null) {
            this.qv = new HashSet<>();
        }
        this.qv.add(Integer.valueOf(i6));
        if (this.f29919f != null) {
            if (!com.bytedance.sdk.openadsdk.i.cw.r.xt(h.xt)) {
                jVar = new com.bytedance.sdk.openadsdk.core.qv.j.j(jVar);
            }
            this.f29919f.apply(com.bytedance.sdk.openadsdk.i.r.j().j(9).j(Void.class).j(0, new la().j("hid", Integer.valueOf(i6)).j("id", Integer.valueOf(i6)).j("onEventLogHandler", jVar).j("hashCode", Integer.valueOf(ae()))).xt());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void xt() {
        com.bytedance.sdk.openadsdk.core.qv.xt.up upVar = this.vl;
        if (upVar != null) {
            upVar.xt();
        }
        qv();
        HashSet<Integer> hashSet = this.qv;
        if (hashSet != null && hashSet.size() > 0) {
            HashSet hashSet2 = new HashSet();
            hashSet2.addAll(this.qv);
            this.qv.clear();
            final Iterator it = hashSet2.iterator();
            com.bytedance.sdk.openadsdk.l.ae.j(new com.bytedance.sdk.component.oq.g("remove_log_hanlder") { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.up.4
                @Override // java.lang.Runnable
                public void run() {
                    while (it.hasNext()) {
                        Integer num = (Integer) it.next();
                        num.intValue();
                        Function<SparseArray<Object>, Object> function = up.this.f29919f;
                        if (function != null) {
                            function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(3).j(Void.class).j(0, new la().j("hid", num).j("hashCode", Integer.valueOf(up.this.ae()))).xt());
                        }
                        it.remove();
                    }
                }
            });
        }
        WeakReference<Context> weakReference = this.cw;
        if (weakReference != null) {
            weakReference.clear();
            this.cw = null;
        }
        this.ch = null;
    }

    protected String j(String str) {
        Uri parse;
        return (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || TextUtils.isEmpty(parse.getScheme())) ? "" : parse.getScheme().toLowerCase(Locale.US);
    }

    protected void j(n nVar, String str, String str2, Throwable th) {
        if (cw()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jy.cw.j(nVar, str, str2, th);
    }

    protected boolean j(String str, String str2, n nVar) {
        Object apply;
        if (this.f29919f != null) {
            apply = this.f29919f.apply(com.bytedance.sdk.openadsdk.i.r.j().j(2).j(Boolean.class).j(0, new la().j("tagIntercept", str).j("label", str2).j("hashCode", Integer.valueOf(ae())).j("meta", nVar.tv().toString())).xt());
            if (apply != null && ((Boolean) apply).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public void m(boolean z5) {
        this.f29921i = z5;
    }

    private void m(JSONObject jSONObject, boolean z5) {
        j(jSONObject, z5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void j() {
        if (v.getContext() == null) {
            v.j(getContext());
        }
        av();
    }

    protected void j(Map<String, Object> map) {
        Function<SparseArray<Object>, Object> function = this.f29919f;
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.i.r.j().j(16).j(Void.class).j(0, map).xt());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void j(Activity activity) {
        if (activity == null) {
            return;
        }
        this.cw = new WeakReference<>(activity);
        av();
    }

    public void j(Message message) {
        if (message.what != 9) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.oq.i() != null && !com.bytedance.sdk.openadsdk.core.oq.i().j()) {
            up(false);
            if (this.ws) {
                Object obj = message.obj;
                xt(uf.mi(this.up), obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false);
                return;
            }
            return;
        }
        up(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void j(int i6) {
        this.tj = i6;
    }

    protected void j(String str, long j6, long j7, String str2, String str3) {
        j jVar = this.mi;
        if (jVar == null) {
            this.mi = new j(str, j6, j7, str2, str3);
        } else {
            jVar.j(str);
            this.mi.j(j6);
            this.mi.xt(j7);
            this.mi.xt(str2);
            this.mi.cw(str3);
        }
        com.bytedance.sdk.component.oq.ae.cw().execute(this.mi);
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.cw
    public void j(final n nVar, final boolean z5) {
        if (getContext() == null) {
            return;
        }
        this.up = nVar;
        w();
        if (com.bytedance.sdk.openadsdk.core.xt.j.xt.cw.j(this.up, false) && !com.bytedance.sdk.openadsdk.core.ugeno.oq.up(this.up) && !com.bytedance.sdk.openadsdk.core.ugeno.oq.r(this.up)) {
            new com.bytedance.sdk.openadsdk.core.xt.j.xt.cw(this.up, getContext()).j(this.f29922m).j(new cw.j() { // from class: com.bytedance.sdk.openadsdk.core.qv.cw.up.6
                @Override // com.bytedance.sdk.openadsdk.core.xt.j.xt.cw.j
                public void j() {
                    up.this.ae(uf.mi(nVar), z5);
                }
            });
        } else {
            ae(uf.mi(nVar), z5);
        }
    }

    public boolean j(Context context, String str, n nVar, String str2, boolean z5) {
        if (context == null) {
            return false;
        }
        try {
            uf.j(z5, nVar, str2);
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(268435456);
            intent.putExtra("open_url", str);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
