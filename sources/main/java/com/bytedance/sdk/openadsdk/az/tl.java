package com.bytedance.sdk.openadsdk.az;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import master.flame.danmaku.danmaku.parser.b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl {

    /* renamed from: a, reason: collision with root package name */
    private long f27701a;
    private final String ae;
    private long aq;
    private boolean av;
    private xt az;

    /* renamed from: b, reason: collision with root package name */
    private int f27702b;

    /* renamed from: c, reason: collision with root package name */
    private long f27703c;
    private boolean ch;
    public final String cw;

    /* renamed from: d, reason: collision with root package name */
    private int f27704d;
    private List<JSONObject> dj;

    /* renamed from: e, reason: collision with root package name */
    private int f27705e;
    private long ed;
    private String el;
    private int et;

    /* renamed from: f, reason: collision with root package name */
    private boolean f27706f;
    private int ff;
    private String fp;
    private int fx;

    /* renamed from: g, reason: collision with root package name */
    private Runnable f27707g;
    private long gq;
    private int gr;
    private long gx;

    /* renamed from: h, reason: collision with root package name */
    private long f27708h;
    private int hh;
    private boolean hl;
    private String hu;

    /* renamed from: i, reason: collision with root package name */
    private boolean f27709i;
    private boolean ig;
    private String ik;
    private m im;

    /* renamed from: j, reason: collision with root package name */
    public final String f27710j;
    private boolean jl;
    private Runnable jy;

    /* renamed from: k, reason: collision with root package name */
    private int f27711k;
    private Map<String, String> ka;
    private long kc;
    private JSONObject ki;
    private ViewTreeObserver.OnGlobalLayoutListener kk;
    private String kt;

    /* renamed from: l, reason: collision with root package name */
    private long f27712l;
    private long la;
    private String ll;
    private com.bytedance.sdk.component.jy.cw ln;
    private String lx;

    /* renamed from: m, reason: collision with root package name */
    private final String f27713m;
    private Set<String> mi;

    /* renamed from: n, reason: collision with root package name */
    private String f27714n;
    private int na;
    private String nd;
    private cw nt;
    private int nu;

    /* renamed from: o, reason: collision with root package name */
    private boolean f27715o;
    private String ol;
    private int om;
    private Runnable oq;
    private int ov;
    private String oy;

    /* renamed from: p, reason: collision with root package name */
    private int f27716p;
    private float px;
    private int pz;

    /* renamed from: q, reason: collision with root package name */
    private int f27717q;
    private j qa;
    private int qb;
    private float qe;
    private boolean qg;
    private String qo;
    private Runnable qv;

    /* renamed from: r, reason: collision with root package name */
    public final String f27718r;
    private String rh;
    private int ri;
    private long rn;
    private JSONObject rr;
    private boolean rs;
    private int ry;

    /* renamed from: s, reason: collision with root package name */
    private String f27719s;
    private String sm;
    private int st;

    /* renamed from: t, reason: collision with root package name */
    private String f27720t;
    private String tj;
    private int tk;
    private final Handler tl;

    /* renamed from: u, reason: collision with root package name */
    private JSONObject f27721u;
    private int uc;
    private long uf;
    public final String up;
    private String uq;

    /* renamed from: v, reason: collision with root package name */
    private boolean f27722v;
    private final Handler vl;

    /* renamed from: w, reason: collision with root package name */
    private boolean f27723w;
    private Context wf;
    private int wi;
    private String wo;
    private long wq;
    private Runnable ws;

    /* renamed from: x, reason: collision with root package name */
    private boolean f27724x;
    private WeakReference<View> xp;
    private boolean xq;
    public final String xt;
    private float xw;

    /* renamed from: y, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.az.j f27725y;
    private int ya;
    private boolean yb;
    private JSONObject yl;
    private boolean ym;

    /* renamed from: z, reason: collision with root package name */
    private int f27726z;
    private String zs;
    private int zz;

    public enum j {
        LAND_PAGE,
        FEED,
        OTHER,
        FEED_AWEME
    }

    private tl(Context context, com.bytedance.sdk.component.jy.cw cwVar, cw cwVar2, com.bytedance.sdk.openadsdk.az.j jVar, j jVar2, boolean z5) {
        this.f27713m = "playable_stuck_check_ping";
        this.ae = "playable_apply_media_permission_callback";
        this.tl = new Handler(Looper.getMainLooper());
        this.vl = new Handler(Looper.getMainLooper());
        this.av = true;
        this.f27709i = true;
        this.f27723w = true;
        this.f27710j = "PL_sdk_playable_global_viewable";
        this.xt = "PL_sdk_page_screen_blank";
        this.cw = "PL_sdk_playable_destroy_analyze_summary";
        this.f27718r = "PL_sdk_playable_hardware_dialog_cancel";
        this.up = "PL_sdk_playable_hardware_dialog_setting";
        this.mi = new HashSet(Arrays.asList("adInfo", "appInfo", "subscribe_app_ad", "download_app_ad"));
        this.kt = null;
        this.tj = "embeded_ad";
        this.f27706f = true;
        this.f27722v = true;
        this.f27724x = true;
        this.ch = false;
        this.f27719s = "";
        this.f27701a = 10L;
        this.f27712l = 10L;
        this.f27716p = 700;
        this.f27708h = 0L;
        this.la = 0L;
        this.gq = -1L;
        this.rn = -1L;
        this.wq = -1L;
        this.uf = -1L;
        this.ed = -1L;
        this.f27703c = -1L;
        this.gx = -1L;
        this.f27714n = "";
        this.nd = "";
        this.rh = "";
        this.ol = "";
        this.hh = 0;
        this.f27726z = 0;
        this.hl = false;
        this.f27702b = 0;
        this.f27705e = -1;
        this.f27717q = 0;
        this.qb = 0;
        this.ya = 0;
        this.sm = null;
        this.xq = false;
        this.f27711k = 0;
        this.ff = 0;
        this.ry = 0;
        this.zz = 0;
        this.kc = 0L;
        this.aq = 0L;
        this.st = -2;
        this.pz = 0;
        this.uc = 0;
        this.ri = 0;
        this.ki = new JSONObject();
        this.ka = new HashMap();
        this.f27721u = new JSONObject();
        this.oy = "";
        this.qe = 0.0f;
        this.px = 0.0f;
        this.jl = false;
        this.f27715o = false;
        this.ym = false;
        this.dj = new ArrayList();
        this.kk = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.az.tl.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = (View) tl.this.xp.get();
                    if (view == null) {
                        return;
                    }
                    tl.this.xt(view);
                } catch (Throwable th) {
                    ae.j("PlayablePlugin", "onSizeChanged error", th);
                }
            }
        };
        this.st = 0;
        this.qa = jVar2;
        this.ln = cwVar;
        g.j(cwVar);
        if (!z5) {
            j(cwVar.getView());
        }
        j(context, cwVar2, jVar);
    }

    static /* synthetic */ int jy(tl tlVar) {
        int i6 = tlVar.f27726z;
        tlVar.f27726z = i6 + 1;
        return i6;
    }

    static /* synthetic */ int vl(tl tlVar) {
        int i6 = tlVar.hh;
        tlVar.hh = i6 + 1;
        return i6;
    }

    public void gq() {
        this.uc = 0;
        this.ri = 0;
        this.xw = 0.0f;
        this.f27704d = 0;
        this.wi = 0;
        this.tk = 0;
        this.fx = 0;
        this.na = 0;
        this.gr = 0;
        this.et = 0;
        this.ov = 0;
        this.nu = 0;
        this.om = 0;
    }

    public void v() {
        this.f27705e = 2;
    }

    public void x() {
        this.xq = true;
    }

    private void c() {
        Runnable runnable;
        Runnable runnable2;
        this.az.j(System.currentTimeMillis());
        Handler handler = this.vl;
        if (handler != null) {
            int i6 = this.st;
            if (i6 == 0 && (runnable2 = this.jy) != null) {
                handler.post(runnable2);
            } else if ((i6 == 1 || i6 == 2) && (runnable = this.ws) != null) {
                handler.post(runnable);
            }
            this.az.j(500);
        }
    }

    private void ed() {
        String str;
        if (this.f27721u == null || (str = this.wo) == null || str.contains("/cid_")) {
            return;
        }
        String optString = this.f27721u.optString("cid");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        String host = Uri.parse(this.wo).getHost();
        if (TextUtils.isEmpty(host)) {
            this.wo += "/cid_" + optString;
            return;
        }
        this.wo = this.wo.replace(host, host + "/cid_" + optString);
    }

    private boolean oq(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("/union-fe/playable/") || str.contains("/union-fe-sg/playable/") || str.contains("/union-fe-i18n/playable/");
    }

    private void uf() {
        this.az = new xt(this, this.f27716p);
        this.f27707g = new Runnable() { // from class: com.bytedance.sdk.openadsdk.az.tl.3
            @Override // java.lang.Runnable
            public void run() {
                if (tl.this.f27722v) {
                    tl.this.f27722v = false;
                    tl.this.tl.removeCallbacks(tl.this.oq);
                    tl.this.j(2, "容器加载超时");
                }
            }
        };
        this.oq = new Runnable() { // from class: com.bytedance.sdk.openadsdk.az.tl.4
            @Override // java.lang.Runnable
            public void run() {
                if (tl.this.f27722v) {
                    tl.this.f27722v = false;
                    tl.this.tl.removeCallbacks(tl.this.f27707g);
                    tl.this.j(3, "JSSDK加载超时");
                }
            }
        };
        this.jy = new Runnable() { // from class: com.bytedance.sdk.openadsdk.az.tl.5
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                if (tl.this.ln != null) {
                    tl.this.ln.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.az.tl.5.1
                        @Override // android.webkit.ValueCallback
                        /* renamed from: j, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            if (tl.this.az != null) {
                                tl.this.az.j(System.currentTimeMillis());
                            }
                        }
                    });
                }
                if (tl.this.vl != null) {
                    tl.this.vl.postDelayed(this, 500L);
                }
            }
        };
        this.ws = new Runnable() { // from class: com.bytedance.sdk.openadsdk.az.tl.6
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                tl.this.j("playable_stuck_check_ping", new JSONObject());
                if (tl.this.vl != null) {
                    tl.this.vl.postDelayed(this, 500L);
                }
            }
        };
        this.qv = new Runnable() { // from class: com.bytedance.sdk.openadsdk.az.tl.7
            @Override // java.lang.Runnable
            public void run() {
                if (tl.this.aq <= 0) {
                    tl.this.xt(1, "点击热区卡死");
                } else {
                    if (tl.this.aq - tl.this.kc > tl.this.f27716p) {
                        tl.this.xt(1, "点击热区卡死");
                        return;
                    }
                    tl.this.h();
                    tl.this.kc = 0L;
                    tl.this.aq = 0L;
                }
            }
        };
    }

    public void a() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.ed > 0) {
                jSONObject.put("playable_material_first_frame_show_duration", System.currentTimeMillis() - this.ed);
            } else {
                jSONObject.put("playable_material_first_frame_show_duration", 0L);
            }
            if (this.wq > 0) {
                jSONObject.put("playable_material_first_frame_load_duration", System.currentTimeMillis() - this.wq);
            } else {
                jSONObject.put("playable_material_first_frame_load_duration", 0L);
            }
            cw("PL_sdk_material_first_frame_show", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public boolean ae() {
        return this.qg;
    }

    public String av() {
        com.bytedance.sdk.openadsdk.az.j jVar;
        if (TextUtils.isEmpty(this.rh) && (jVar = this.f27725y) != null) {
            this.rh = jVar.r().toString();
        }
        return this.rh;
    }

    public Intent az() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File j6 = up.j();
        if (j6 == null) {
            return null;
        }
        intent.putExtra("output", FileProvider.getUriForFile(this.wf, this.wf.getPackageName() + ".playable.fileProvider", j6));
        return intent;
    }

    public void ch() {
        if (this.f27725y != null) {
            j jVar = j.FEED_AWEME;
        }
    }

    public String cw() {
        return this.uq;
    }

    public void f() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.ed > 0) {
                jSONObject.put("playable_material_interactable_duration", System.currentTimeMillis() - this.ed);
            } else {
                jSONObject.put("playable_material_interactable_duration", 0L);
            }
            if (this.wq > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.wq;
                this.gx = currentTimeMillis;
                jSONObject.put("playable_material_interactable_load_duration", currentTimeMillis);
            } else {
                jSONObject.put("playable_material_interactable_load_duration", 0L);
            }
            cw("PL_sdk_material_interactable", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public JSONObject g() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.ig);
            return jSONObject;
        } catch (Throwable th) {
            ae.j("PlayablePlugin", "getPlayableClickStatus error", th);
            return new JSONObject();
        }
    }

    public Context getContext() {
        return this.wf;
    }

    public void h() {
        if (this.f27724x) {
            this.f27703c = System.currentTimeMillis();
            if (this.qa == j.FEED_AWEME) {
                if (this.rs && this.pz == 3) {
                    xt xtVar = this.az;
                    if (xtVar != null && xtVar.xt()) {
                        c();
                        return;
                    } else {
                        if (this.az == null) {
                            this.az = new xt(this, this.f27716p);
                            c();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (this.rs && this.pz == 2) {
                xt xtVar2 = this.az;
                if (xtVar2 != null && xtVar2.xt()) {
                    c();
                } else if (this.az == null) {
                    this.az = new xt(this, this.f27716p);
                    c();
                }
            }
        }
    }

    public com.bytedance.sdk.openadsdk.az.j i() {
        return this.f27725y;
    }

    public JSONObject jy() {
        boolean j6;
        boolean j7;
        try {
            boolean z5 = true;
            if (Build.VERSION.SDK_INT >= 33) {
                j6 = up.j(this.wf, "android.permission.READ_MEDIA_IMAGES");
                j7 = true;
            } else {
                j6 = up.j(this.wf, com.kuaishou.weapon.p0.g.f36049i);
                j7 = up.j(this.wf, com.kuaishou.weapon.p0.g.f36050j);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isHasRead", j6);
            jSONObject.put("isHasWrite", j7);
            if (!j6 || !j7) {
                z5 = false;
            }
            jSONObject.put("result", z5);
            return jSONObject;
        } catch (Throwable th) {
            ae.j("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public JSONObject kt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("devicePixelRatio", this.xw);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", this.f27704d);
            jSONObject2.put("height", this.wi);
            jSONObject.put("screen", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("x", this.fx);
            jSONObject3.put("y", this.tk);
            jSONObject3.put("width", this.na);
            jSONObject3.put("height", this.gr);
            jSONObject.put("webview", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("x", this.ov);
            jSONObject4.put("y", this.et);
            jSONObject4.put("width", this.nu);
            jSONObject4.put("height", this.om);
            jSONObject.put("visible", jSONObject4);
            return jSONObject;
        } catch (Throwable th) {
            ae.j("PlayablePlugin", "getViewport error", th);
            return jSONObject;
        }
    }

    public void la() {
        try {
            xt xtVar = this.az;
            if (xtVar != null) {
                xtVar.j();
            }
            Handler handler = this.vl;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable unused) {
        }
    }

    public String m() {
        return this.zs;
    }

    public JSONObject mi() {
        return this.f27721u;
    }

    public void p() {
        this.tl.removeCallbacks(this.f27707g);
        this.tl.removeCallbacks(this.oq);
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.wq > 0) {
                jSONObject.put("playable_jssdk_load_success_duration", System.currentTimeMillis() - this.wq);
            } else {
                jSONObject.put("playable_jssdk_load_success_duration", 0L);
            }
            cw("PL_sdk_jssdk_load_success", jSONObject);
        } catch (JSONException e6) {
            vl.j(e6);
        }
    }

    public JSONObject qv() {
        try {
            boolean j6 = up.j(this.wf, "android.permission.RECORD_AUDIO");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", j6);
            return jSONObject;
        } catch (Throwable th) {
            ae.j("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public String r() {
        return this.f27720t;
    }

    public void rn() {
        if (this.ym) {
            return;
        }
        this.ym = true;
        this.la = 0L;
        this.f27709i = true;
        gq();
        try {
            View view = this.xp.get();
            if (view != null) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.kk);
            }
        } catch (Throwable unused) {
        }
        try {
            this.im.xt();
        } catch (Throwable unused2) {
        }
        try {
            xt xtVar = this.az;
            if (xtVar != null) {
                xtVar.j();
                this.az = null;
            }
            Handler handler = this.vl;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (!TextUtils.isEmpty(this.wo)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("playable_all_times", this.hh);
                jSONObject.put("playable_hit_times", this.f27726z);
                int i6 = this.hh;
                if (i6 > 0) {
                    jSONObject.put("playable_hit_ratio", this.f27726z / (i6 * 1.0d));
                } else {
                    jSONObject.put("playable_hit_ratio", 0);
                }
                cw("PL_sdk_preload_times", jSONObject);
            }
        } catch (Throwable unused4) {
        }
        try {
            if (!TextUtils.isEmpty(this.wo)) {
                if (this.gq != -1) {
                    this.f27708h += System.currentTimeMillis() - this.gq;
                    this.gq = -1L;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_user_play_duration", this.f27708h);
                cw("PL_sdk_user_play_duration", jSONObject2);
            }
        } catch (Throwable unused5) {
        }
        this.tl.removeCallbacks(this.f27707g);
        this.tl.removeCallbacks(this.oq);
        this.tl.removeCallbacksAndMessages(null);
    }

    public void s() {
        if (this.f27725y != null) {
            j jVar = j.FEED_AWEME;
        }
    }

    public void tj() {
        com.bytedance.sdk.openadsdk.az.j jVar = this.f27725y;
        if (jVar != null) {
            jVar.j();
        }
    }

    public boolean tl() {
        return this.rs;
    }

    public String up() {
        return this.ik;
    }

    public JSONObject vl() {
        try {
            boolean j6 = up.j(this.wf, "android.permission.CAMERA");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", j6);
            return jSONObject;
        } catch (Throwable th) {
            ae.j("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public JSONObject w() {
        if (this.ki.isNull("width")) {
            View view = this.xp.get();
            if (view == null) {
                return this.ki;
            }
            xt(view);
        }
        return this.ki;
    }

    public String wq() {
        return "function playable_callJS(){return \"Android调用了JS的callJS方法\";}";
    }

    public JSONObject ws() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene_type", this.qa.ordinal());
            jSONObject.put("safe_area_top_height", this.qe);
            jSONObject.put("safe_area_bottom_height", this.px);
            jSONObject.put("playable_enter_from", this.qb);
            jSONObject.put("playable_retry_count", this.f27717q);
            jSONObject.put("playable_card_session", this.f27714n);
            jSONObject.put("playable_video_session", this.nd);
            jSONObject.put("playable_network_type", av());
            jSONObject.put("aweme_id", this.ol);
            return jSONObject;
        } catch (Throwable th) {
            ae.j("PlayablePlugin", "playableInfo error", th);
            return new JSONObject();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(View view) {
        if (view == null) {
            return;
        }
        try {
            if (this.uc == view.getWidth() && this.ri == view.getHeight()) {
                return;
            }
            this.uc = view.getWidth();
            this.ri = view.getHeight();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.uc);
            jSONObject.put("height", this.ri);
            j("resize", jSONObject);
            this.ki = jSONObject;
        } catch (Throwable th) {
            ae.j("PlayablePlugin", "resetViewDataJsonByView error", th);
        }
    }

    public void ae(JSONObject jSONObject) {
        this.rr = jSONObject;
        this.ya++;
        la();
        this.tl.removeCallbacks(this.qv);
        if (this.f27724x) {
            this.f27703c = System.currentTimeMillis();
            this.kc = System.currentTimeMillis();
            this.aq = 0L;
            int i6 = this.st;
            if (i6 == 0) {
                com.bytedance.sdk.component.jy.cw cwVar = this.ln;
                if (cwVar != null) {
                    cwVar.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.az.tl.8
                        @Override // android.webkit.ValueCallback
                        /* renamed from: j, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            tl.this.aq = System.currentTimeMillis();
                        }
                    });
                }
            } else if (i6 == 1 || i6 == 2) {
                j("playable_stuck_check_ping", new JSONObject());
            }
            this.tl.postDelayed(this.qv, this.f27716p);
        }
    }

    public tl cw(String str) {
        this.ik = str;
        return this;
    }

    public void l() {
        xt xtVar;
        this.aq = System.currentTimeMillis();
        int i6 = this.st;
        if ((i6 == 1 || i6 == 2) && (xtVar = this.az) != null) {
            xtVar.j(System.currentTimeMillis());
        }
    }

    public void m(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.sm = jSONObject.optString("section");
        }
    }

    public Set<String> oq() {
        Set<String> j6 = this.im.j();
        Set<String> set = this.mi;
        if (set == null || set.size() <= 0) {
            return j6;
        }
        HashSet hashSet = new HashSet();
        for (String str : j6) {
            if (!this.mi.contains(str)) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    public tl r(String str) {
        this.zs = str;
        return this;
    }

    public void tl(JSONObject jSONObject) {
        xt(2, jSONObject != null ? jSONObject.optString("error_msg", "素材直接调用端上异常兜底蒙层") : "素材直接调用端上异常兜底蒙层");
    }

    public tl up(JSONObject jSONObject) {
        this.f27721u = jSONObject;
        return this;
    }

    public tl cw(boolean z5) {
        this.ig = z5;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.ig);
            j("change_playable_click", jSONObject);
            return this;
        } catch (Throwable th) {
            ae.j("PlayablePlugin", "setPlayableClick error", th);
            return this;
        }
    }

    public void m(String str) {
        int i6;
        int i7;
        this.pz = 1;
        JSONObject jSONObject = new JSONObject();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.wq = currentTimeMillis;
            long j6 = this.rn;
            jSONObject.put("playable_page_show_duration", j6 != -1 ? currentTimeMillis - j6 : 0L);
        } catch (Throwable th) {
            ae.j("PlayablePlugin", "reportUrlLoadStart error", th);
        }
        cw("PL_sdk_html_load_start", jSONObject);
        if (this.f27706f && ((i6 = this.st) == 0 || i6 == 1 || i6 == 2)) {
            this.tl.postDelayed(this.f27707g, this.f27701a * 1000);
            if (oq(this.wo) || (i7 = this.st) == 1 || i7 == 2) {
                this.tl.postDelayed(this.oq, this.f27712l * 1000);
            }
            this.f27706f = false;
        }
        if (this.f27709i) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                StringBuffer stringBuffer2 = new StringBuffer();
                StringBuffer stringBuffer3 = new StringBuffer();
                if (up.j(this.wf, up.vl)) {
                    stringBuffer.append("Microphone_");
                    stringBuffer2.append("1");
                    if (up.xt(this.wf, "android.permission.RECORD_AUDIO")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (up.j(this.wf, up.qv)) {
                    stringBuffer.append("Magetometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (up.j(this.wf, up.oq)) {
                    stringBuffer.append("Accelerometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (up.j(this.wf, up.f27740g)) {
                    stringBuffer.append("Gyro_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (up.j(this.wf, up.tl)) {
                    stringBuffer.append("Camera_");
                    stringBuffer2.append("1");
                    if (up.xt(this.wf, "android.permission.CAMERA")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (up.j(this.wf, up.ae)) {
                    stringBuffer.append("Photo");
                    stringBuffer2.append("1");
                    if (up.j(this.wf)) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_available_hardware_name", stringBuffer.toString());
                jSONObject2.put("playable_available_hardware_code", stringBuffer2.toString());
                jSONObject2.put("playable_available_hardware_auth_code", stringBuffer3.toString());
                cw("PL_sdk_hardware_detect", jSONObject2);
                this.f27709i = false;
            } catch (Throwable th2) {
                ae.j("PlayablePlugin", "Hardware detect error", th2);
            }
        }
    }

    public void r(JSONObject jSONObject) {
        if (this.f27725y != null) {
            try {
                jSONObject.optBoolean("isPrevent", false);
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
    }

    public tl up(String str) {
        Uri parse;
        String scheme;
        int indexOf;
        String decode;
        this.oy = str;
        try {
            parse = Uri.parse(str);
            scheme = parse.getScheme();
        } catch (Throwable unused) {
        }
        if (!b.f50154a.equalsIgnoreCase(scheme) && !b.f50155b.equalsIgnoreCase(scheme)) {
            String host = parse.getHost();
            if (!"webview".equalsIgnoreCase(host) && (host == null || !host.contains("webview"))) {
                if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                    if (this.st == -1) {
                        xt(2);
                    } else {
                        xt(1);
                    }
                }
                this.wo = str;
                return this;
            }
            xt(0);
            String queryParameter = parse.getQueryParameter("url");
            if (!TextUtils.isEmpty(queryParameter) && (decode = Uri.decode(queryParameter)) != null) {
                int indexOf2 = decode.indexOf("?");
                str = indexOf2 != -1 ? decode.substring(0, indexOf2) : decode;
            }
            this.wo = str;
            return this;
        }
        xt(0);
        if (str != null && (indexOf = str.indexOf("?")) != -1) {
            str = str.substring(0, indexOf);
        }
        this.wo = str;
        return this;
    }

    private void j(Context context, cw cwVar, com.bytedance.sdk.openadsdk.az.j jVar) {
        this.kt = UUID.randomUUID().toString();
        this.wf = context;
        this.f27725y = jVar;
        this.nt = cwVar;
        oq.j(jVar);
        this.im = new m(this);
        uf();
    }

    public JSONObject g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int optInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        if (optInt == 1) {
            return qv();
        }
        if (optInt != 2) {
            return optInt != 3 ? jSONObject2 : jy();
        }
        return vl();
    }

    public void tl(String str) {
        this.tl.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.az.tl.10
            @Override // java.lang.Runnable
            public void run() {
                tl.vl(tl.this);
            }
        });
    }

    public void qv(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean optBoolean = jSONObject.optBoolean("success", true);
            if (optBoolean) {
                this.pz = 3;
                h();
            } else {
                this.pz = -2;
            }
            if (optBoolean || !this.f27722v) {
                return;
            }
            this.f27722v = false;
            this.tl.removeCallbacks(this.f27707g);
            this.tl.removeCallbacks(this.oq);
            j(4, "素材渲染失败");
        }
    }

    public tl r(boolean z5) {
        this.f27724x = z5;
        return this;
    }

    private String r(String str, String str2) {
        String queryParameter;
        String queryParameter2;
        if (TextUtils.isEmpty(this.ll) && !TextUtils.isEmpty(this.oy)) {
            Uri parse = Uri.parse(this.oy);
            String host = parse.getHost();
            if (!"lynxview".equalsIgnoreCase(host) && (host == null || !host.contains("lynxview"))) {
                queryParameter = "";
                queryParameter2 = "";
            } else {
                queryParameter = parse.getQueryParameter("surl");
                queryParameter2 = parse.getQueryParameter("playable_hash");
            }
            Uri.Builder appendQueryParameter = new Uri.Builder().scheme(parse.getScheme()).authority(host).appendQueryParameter("surl", queryParameter);
            if (!TextUtils.isEmpty(queryParameter2)) {
                appendQueryParameter.appendQueryParameter("playable_hash", queryParameter2);
            }
            this.ll = appendQueryParameter.toString();
        }
        return this.ll;
    }

    public void cw(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.az.j jVar = this.f27725y;
        if (jVar == null || jVar.j(jSONObject) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("resource_base64");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        int optInt = jSONObject.optInt("resource_type", -1);
        String optString2 = jSONObject.optString("resource_name", "playable_media");
        if (optInt == 1) {
            xt(optString2, optString);
        } else if (optInt == 2) {
            cw(optString2, optString);
        }
    }

    public JSONObject oq(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int optInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (optInt != 1) {
                if (optInt == 2) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        jSONObject2.put("result", up.xt(this.wf, "android.permission.CAMERA"));
                        return jSONObject2;
                    }
                    jSONObject2.put("result", false);
                    return jSONObject2;
                }
                if (optInt == 3) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        jSONObject2.put("result", up.j(this.wf));
                        return jSONObject2;
                    }
                    jSONObject2.put("result", false);
                    return jSONObject2;
                }
            } else {
                if (Build.VERSION.SDK_INT >= 23) {
                    jSONObject2.put("result", up.xt(this.wf, "android.permission.RECORD_AUDIO"));
                    return jSONObject2;
                }
                jSONObject2.put("result", false);
            }
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    public void g(String str) {
        this.tl.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.az.tl.2
            @Override // java.lang.Runnable
            public void run() {
                tl.jy(tl.this);
            }
        });
    }

    public void j(View view) {
        if (view == null) {
            return;
        }
        try {
            this.xp = new WeakReference<>(view);
            xt(view);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.kk);
        } catch (Throwable th) {
            ae.j("PlayablePlugin", "setViewForScreenSize error", th);
        }
    }

    public tl xt(String str) {
        this.uq = str;
        return this;
    }

    public JSONObject xt() {
        return this.yl;
    }

    public tl xt(long j6) {
        if (j6 <= 0) {
            this.f27712l = 10L;
            return this;
        }
        this.f27712l = j6;
        return this;
    }

    public void ae(String str) {
        com.bytedance.sdk.component.jy.cw cwVar;
        this.pz = 2;
        this.qo = str;
        JSONObject jSONObject = new JSONObject();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.uf = currentTimeMillis;
            long j6 = this.wq;
            jSONObject.put("playable_html_load_start_duration", j6 != -1 ? currentTimeMillis - j6 : 0L);
        } catch (Throwable th) {
            ae.j("PlayablePlugin", "reportUrlLoadFinish error", th);
        }
        cw("PL_sdk_html_load_finish", jSONObject);
        this.tl.removeCallbacks(this.f27707g);
        try {
            if (this.st == 0) {
                if (this.av && (cwVar = this.ln) != null) {
                    this.av = false;
                    cwVar.evaluateJavascript(wq(), new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.az.tl.9
                        @Override // android.webkit.ValueCallback
                        public /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                        }
                    });
                }
                h();
            }
        } catch (Throwable th2) {
            ae.j("PlayablePlugin", "crashMonitor error", th2);
        }
    }

    public tl j(String str, String str2) {
        this.ka.put(str, str2);
        return this;
    }

    public tl xt(boolean z5) {
        if (this.rs != z5) {
            this.rs = z5;
            JSONObject jSONObject = new JSONObject();
            try {
                if (!this.rs) {
                    jSONObject.put("playable_background_show_type", this.ff);
                }
            } catch (JSONException e6) {
                vl.j(e6);
            }
            cw(this.rs ? "PL_sdk_viewable_true" : "PL_sdk_viewable_false", jSONObject);
            if (this.rn == -1 && this.rs) {
                this.rn = System.currentTimeMillis();
                cw("PL_sdk_page_show", (JSONObject) null);
            }
            if (this.rn != -1 && !this.rs && !this.jl) {
                this.jl = true;
            }
            if (this.rs) {
                this.gq = System.currentTimeMillis();
            } else if (this.gq != -1) {
                this.f27708h += System.currentTimeMillis() - this.gq;
                this.gq = -1L;
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("viewStatus", this.rs);
                j("viewableChange", jSONObject2);
            } catch (Throwable th) {
                ae.j("PlayablePlugin", "setViewable error", th);
            }
            if (this.rs) {
                h();
            } else {
                la();
            }
        }
        return this;
    }

    public void cw(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            Toast.makeText(this.wf, "视频保存失败", 0).show();
            return;
        }
        File j6 = up.j(str, str2);
        if (j6 != null && j6.exists()) {
            Uri fromFile = Uri.fromFile(j6);
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(fromFile);
            this.wf.sendBroadcast(intent);
            Toast.makeText(this.wf, "视频已保存到相册", 0).show();
            return;
        }
        Toast.makeText(this.wf, "视频保存失败", 0).show();
    }

    public Map<String, String> j() {
        return this.ka;
    }

    public tl j(String str) {
        this.f27720t = str;
        return this;
    }

    public tl j(boolean z5) {
        this.qg = z5;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", this.qg);
            j("volumeChange", jSONObject);
            return this;
        } catch (Throwable th) {
            ae.j("PlayablePlugin", "setIsMute error", th);
            return this;
        }
    }

    public JSONObject r(String str, JSONObject jSONObject) {
        System.currentTimeMillis();
        JSONObject j6 = this.im.j(str, jSONObject);
        if (ae.j()) {
            System.currentTimeMillis();
        }
        return j6;
    }

    private String up(String str, String str2) {
        String format = String.format("rubeex://playable-minigamelite?id=%1s&schema=%2s", str, Uri.encode(str2));
        this.wo = format;
        return format;
    }

    public tl j(long j6) {
        if (j6 <= 0) {
            this.f27701a = 10L;
            return this;
        }
        this.f27701a = j6;
        return this;
    }

    private void up(String str, JSONObject jSONObject) {
        try {
            int i6 = this.st;
            if (i6 == 0) {
                if (this.qa != j.LAND_PAGE && !oq(this.wo)) {
                    ed();
                }
                jSONObject.put("playable_url", this.wo);
            } else {
                if (i6 != 3 && i6 != 4) {
                    if (i6 == 1 || i6 == 2) {
                        jSONObject.put("playable_url", r(this.el, this.hu));
                    }
                }
                jSONObject.put("playable_url", up(this.lx, this.fp));
            }
            jSONObject.put("playable_render_type", this.st);
            if (this.f27725y != null && this.st == 0 && this.qa == j.LAND_PAGE) {
                oq(this.wo);
            }
        } catch (JSONException unused) {
        }
    }

    public void j(JSONObject jSONObject) {
        if (this.f27725y != null) {
            az();
        }
    }

    private void cw(int i6, String str) {
        com.bytedance.sdk.openadsdk.az.j jVar = this.f27725y;
        if (jVar != null) {
            jVar.j(i6, str);
        }
    }

    public Intent j(int i6) {
        Intent intent = new Intent("android.intent.action.PICK");
        if (i6 == 0) {
            intent.setType("*/*");
            return intent;
        }
        if (i6 == 1) {
            intent.setType("image/*");
            return intent;
        }
        if (i6 == 2) {
            intent.setType("video/mp4");
            return intent;
        }
        intent.setType("*/*");
        return intent;
    }

    public void cw(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (!this.hl && this.f27726z > 0) {
                this.hl = true;
            }
            jSONObject.put("playable_event", str);
            jSONObject.put("playable_ts", System.currentTimeMillis());
            jSONObject.put("playable_viewable", this.rs);
            jSONObject.put("playable_session_id", this.kt);
            int i6 = this.st;
            if (i6 == 0) {
                if (this.qa != j.LAND_PAGE && !oq(this.wo)) {
                    ed();
                }
                jSONObject.put("playable_url", this.wo);
            } else {
                if (i6 != 3 && i6 != 4) {
                    if (i6 == 1 || i6 == 2) {
                        jSONObject.put("playable_url", r(this.el, this.hu));
                    }
                }
                jSONObject.put("playable_url", up(this.lx, this.fp));
            }
            jSONObject.put("playable_full_url", this.oy);
            jSONObject.put("playable_replay_count", this.f27702b);
            jSONObject.put("playable_is_prerender", this.yb);
            jSONObject.put("playable_is_preload", this.hl);
            jSONObject.put("playable_render_type", this.st);
            jSONObject.put("playable_scenes_type", this.qa.ordinal());
            String str2 = "";
            jSONObject.put("playable_gecko_key", TextUtils.isEmpty(this.el) ? "" : this.el);
            if (!TextUtils.isEmpty(this.hu)) {
                str2 = this.hu;
            }
            jSONObject.put("playable_gecko_channel", str2);
            jSONObject.put("playable_sdk_version", "6.5.1");
            jSONObject.put("playable_minigamelite_id", this.lx);
            jSONObject.put("playable_minigamelite_schema", this.fp);
            jSONObject.put("playable_is_debug", this.f27715o);
            jSONObject.put("playable_retry_count", this.f27717q);
            jSONObject.put("playable_enter_from", this.qb);
            jSONObject.put("playable_sequence", this.ya);
            jSONObject.put("playable_current_section", this.sm);
            jSONObject.put("is_playable_finish", this.xq);
            jSONObject.put("playable_card_session", this.f27714n);
            jSONObject.put("playable_video_session", this.nd);
            jSONObject.put("playable_network_type", av());
            jSONObject.put("playable_lynx_version", this.f27719s);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ad_extra_data", jSONObject);
            jSONObject2.put(CommonNetImpl.TAG, this.tj);
            jSONObject2.put("nt", 4);
            jSONObject2.put("category", "umeng");
            jSONObject2.put("is_ad_event", "1");
            jSONObject2.put("refer", "playable");
            jSONObject2.put("value", this.f27721u.opt("cid"));
            jSONObject2.put(MediationConstant.EXTRA_LOG_EXTRA, this.f27721u.opt(MediationConstant.EXTRA_LOG_EXTRA));
            int i7 = this.st;
            if (i7 != -1 && i7 != -2) {
                if (this.f27725y != null) {
                    List<JSONObject> list = this.dj;
                    if (list != null && !list.isEmpty()) {
                        Iterator<JSONObject> it = this.dj.iterator();
                        while (it.hasNext()) {
                            JSONObject optJSONObject = it.next().optJSONObject("ad_extra_data");
                            if (optJSONObject != null) {
                                optJSONObject.put("playable_render_type", this.st);
                                optJSONObject.put("playable_url", this.wo);
                            }
                        }
                        this.dj.clear();
                    }
                    if (this.st == 0 && this.qa == j.LAND_PAGE) {
                        oq(this.wo);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.dj == null) {
                this.dj = new ArrayList();
            }
            this.dj.add(jSONObject2);
        } catch (Throwable th) {
            ae.j("PlayablePlugin", "reportEvent error", th);
        }
    }

    public void j(String str, JSONObject jSONObject) {
        cw cwVar = this.nt;
        if (cwVar != null) {
            cwVar.j(str, jSONObject);
        }
    }

    protected void j(int i6, String str) {
        la();
        cw(i6, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i6);
            jSONObject.put("playable_msg", str);
        } catch (Throwable th) {
            ae.j("PlayablePlugin", "reportRenderFatal error", th);
        }
        cw("PL_sdk_global_faild", jSONObject);
    }

    public void xt(JSONObject jSONObject) {
        int i6 = 0;
        if (jSONObject != null) {
            i6 = jSONObject.optInt("resource_type", 0);
            up.cw = jSONObject.optInt("video_min_duration", 1);
            up.f27743r = jSONObject.optInt("video_max_duration", 20);
            up.up = Math.min(jSONObject.optLong("video_max_size", 15360L), 15360L);
        }
        if (this.f27725y != null) {
            j(i6);
        }
    }

    public void j(int i6, String str, String str2) {
        this.pz = -1;
        this.qo = str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i6);
            jSONObject.put("playable_msg", str);
            jSONObject.put("playable_fail_url", str2);
        } catch (Throwable th) {
            ae.j("PlayablePlugin", "onWebReceivedError error", th);
        }
        cw("PL_sdk_html_load_error", jSONObject);
        if (this.f27722v) {
            this.f27722v = false;
            this.tl.removeCallbacks(this.f27707g);
            this.tl.removeCallbacks(this.oq);
            j(1, "容器加载失败");
        }
    }

    public void xt(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            Toast.makeText(this.wf, "照片保存失败", 0).show();
            return;
        }
        Bitmap xt = up.xt(str2);
        if (xt != null) {
            MediaStore.Images.Media.insertImage(this.wf.getContentResolver(), xt, str, "");
            Toast.makeText(this.wf, "照片已保存到相册", 0).show();
        } else {
            Toast.makeText(this.wf, "照片保存失败", 0).show();
        }
    }

    public tl xt(int i6) {
        this.st = i6;
        return this;
    }

    public void xt(int i6, String str) {
        this.f27705e = i6;
        if (this.rr == null) {
            this.rr = new JSONObject();
        }
        try {
            this.rr.put("playable_stuck_type", i6);
            this.rr.put("playable_stuck_reason", str);
            if (this.f27703c > 0) {
                this.rr.put("playable_stuck_duration", System.currentTimeMillis() - this.f27703c);
            } else {
                this.rr.put("playable_stuck_duration", 0L);
            }
        } catch (Throwable unused) {
        }
        cw("PL_sdk_page_stuck", this.rr);
        la();
        if (this.f27725y == null || i6 != 2) {
            return;
        }
        this.rr = new JSONObject();
    }

    public void j(boolean z5, String str, int i6) {
        if (z5) {
            this.pz = -1;
            this.qo = str;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("playable_code", i6);
                jSONObject.put("playable_msg", "url load error");
                jSONObject.put("playable_fail_url", str);
            } catch (Throwable th) {
                ae.j("PlayablePlugin", "onWebReceivedHttpError error", th);
            }
            cw("PL_sdk_html_load_error", jSONObject);
            if (this.f27722v) {
                this.f27722v = false;
                this.tl.removeCallbacks(this.f27707g);
                this.tl.removeCallbacks(this.oq);
                j(1, "容器加载失败");
            }
        }
    }

    protected void xt(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        up(str, jSONObject);
    }

    public static tl j(Context context, com.bytedance.sdk.component.jy.cw cwVar, cw cwVar2, com.bytedance.sdk.openadsdk.az.j jVar, Set<String> set, j jVar2, boolean z5) {
        if (cwVar == null || cwVar2 == null || jVar == null) {
            return null;
        }
        return new tl(context, cwVar, cwVar2, jVar, set, jVar2, z5);
    }

    private tl(Context context, com.bytedance.sdk.component.jy.cw cwVar, cw cwVar2, com.bytedance.sdk.openadsdk.az.j jVar, Set<String> set, j jVar2, boolean z5) {
        this(context, cwVar, cwVar2, jVar, jVar2, z5);
        this.mi = set;
    }
}
