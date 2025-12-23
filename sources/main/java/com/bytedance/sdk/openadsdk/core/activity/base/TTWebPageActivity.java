package com.bytedance.sdk.openadsdk.core.activity.base;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.av.j;
import com.bytedance.sdk.openadsdk.core.av.r;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.dislike.ui.j;
import com.bytedance.sdk.openadsdk.core.playable.xt.xt;
import com.bytedance.sdk.openadsdk.core.qv.cw.oq;
import com.bytedance.sdk.openadsdk.core.qv.cw.up;
import com.bytedance.sdk.openadsdk.core.qv.tl;
import com.bytedance.sdk.openadsdk.core.qv.xt.cw;
import com.bytedance.sdk.openadsdk.core.rn;
import com.bytedance.sdk.openadsdk.core.rn.a;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.m;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.tj.e;
import com.bytedance.sdk.openadsdk.core.tj.m;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.nd;
import com.bytedance.sdk.openadsdk.core.tj.tj;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.huawei.hms.framework.common.ContainerUtils;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class TTWebPageActivity extends BaseLandingPageActivity implements l.j, r {
    private static final String tl = "TTWebPageActivity";

    /* renamed from: a, reason: collision with root package name */
    private LinearLayout f27916a;
    com.bytedance.sdk.openadsdk.core.jy.r ae;
    private TextView av;
    private TextView az;

    /* renamed from: c, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.widget.j.r f27918c;
    private Button ch;

    /* renamed from: f, reason: collision with root package name */
    private TTViewStub f27919f;

    /* renamed from: g, reason: collision with root package name */
    private SSWebView f27920g;
    private boolean gx;

    /* renamed from: h, reason: collision with root package name */
    private String f27921h;
    private xt hh;

    /* renamed from: i, reason: collision with root package name */
    private TextView f27922i;
    private TextView jy;
    private Context kt;

    /* renamed from: l, reason: collision with root package name */
    private rn f27923l;

    /* renamed from: m, reason: collision with root package name */
    com.bytedance.sdk.openadsdk.core.dislike.ui.j f27924m;
    private ImageView mi;

    /* renamed from: n, reason: collision with root package name */
    private boolean f27925n;
    private int nd;
    private ImageView oq;

    /* renamed from: p, reason: collision with root package name */
    private boolean f27926p;
    private ImageView qv;
    private int rh;
    private Activity rn;

    /* renamed from: s, reason: collision with root package name */
    private TTProgressBar f27927s;
    private TTViewStub tj;
    private cw uf;

    /* renamed from: v, reason: collision with root package name */
    private TTViewStub f27928v;
    private TextView vl;

    /* renamed from: w, reason: collision with root package name */
    private LinearLayout f27929w;
    private com.bytedance.sdk.openadsdk.jy.r wq;
    private TextView ws;

    /* renamed from: x, reason: collision with root package name */
    private TTViewStub f27930x;

    /* renamed from: z, reason: collision with root package name */
    private boolean f27931z;
    private AtomicBoolean la = new AtomicBoolean(true);
    private JSONArray gq = null;
    private final Map<String, cw> ed = Collections.synchronizedMap(new HashMap());
    private final l ol = new l(Looper.getMainLooper(), this);
    private String hl = "立即下载";

    /* renamed from: b, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.qv.xt.j f27917b = new com.bytedance.sdk.openadsdk.core.qv.xt.j() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.12
        @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
        public void j() {
            TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
            tTWebPageActivity.j(tTWebPageActivity.ae());
            j.C0431j.j(TTWebPageActivity.this.f27817j, 1, 0);
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
        public void cw(long j6, long j7, String str, String str2) {
            TTWebPageActivity.this.j("下载失败");
            if (j6 > 0) {
                j.C0431j.j(TTWebPageActivity.this.f27817j, 4, (int) ((j7 * 100) / j6));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
        public void xt(long j6, long j7, String str, String str2) {
            TTWebPageActivity.this.j("暂停");
            if (j6 > 0) {
                j.C0431j.j(TTWebPageActivity.this.f27817j, 2, (int) ((j7 * 100) / j6));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
        public void j(long j6, long j7, String str, String str2) {
            TTWebPageActivity.this.j("下载中...");
            String unused = TTWebPageActivity.tl;
            if (j6 > 0) {
                j.C0431j.j(TTWebPageActivity.this.f27817j, 3, (int) ((j7 * 100) / j6));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
        public void j(long j6, String str, String str2) {
            TTWebPageActivity.this.j("点击安装");
            j.C0431j.j(TTWebPageActivity.this.f27817j, 5, 100);
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
        public void j(String str, String str2) {
            TTWebPageActivity.this.j("点击打开");
            j.C0431j.j(TTWebPageActivity.this.f27817j, 6, 100);
        }
    };

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity$1, reason: invalid class name */
    class AnonymousClass1 extends com.bytedance.sdk.openadsdk.core.widget.j.r {
        AnonymousClass1(Context context, rn rnVar, String str, com.bytedance.sdk.openadsdk.core.jy.r rVar, com.bytedance.sdk.openadsdk.jy.r rVar2) {
            super(context, rnVar, str, rVar, rVar2);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            try {
                if (TTWebPageActivity.this.f27927s != null && !TTWebPageActivity.this.isFinishing()) {
                    TTWebPageActivity.this.f27927s.setVisibility(8);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity$7, reason: invalid class name */
    class AnonymousClass7 extends com.bytedance.sdk.openadsdk.core.widget.j.cw {
        AnonymousClass7(rn rnVar, com.bytedance.sdk.openadsdk.core.jy.r rVar) {
            super(rnVar, rVar);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.j.cw, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i6) {
            super.onProgressChanged(webView, i6);
            if (TTWebPageActivity.this.f27927s != null && !TTWebPageActivity.this.isFinishing()) {
                if (i6 == 100 && TTWebPageActivity.this.f27927s.isShown()) {
                    TTWebPageActivity.this.f27927s.setVisibility(8);
                } else {
                    TTWebPageActivity.this.f27927s.setProgress(i6);
                }
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity$8, reason: invalid class name */
    class AnonymousClass8 implements View.OnClickListener {
        AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
            tTWebPageActivity.j(tTWebPageActivity.up);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity$9, reason: invalid class name */
    class AnonymousClass9 implements View.OnClickListener {
        AnonymousClass9() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
            tTWebPageActivity.xt(tTWebPageActivity.up);
        }
    }

    public static class j implements DownloadListener {
        private Context cw;

        /* renamed from: j, reason: collision with root package name */
        private Map<String, cw> f27946j;

        /* renamed from: r, reason: collision with root package name */
        private String f27947r;
        private n xt;

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j6) {
            Map<String, cw> map = this.f27946j;
            if (map == null || !map.containsKey(str)) {
                cw j7 = tl.j(this.cw, str, this.xt, this.f27947r);
                j7.j(oq.j(this.xt));
                this.f27946j.put(str, j7);
                j7.j(uf.mi(this.xt), false);
                return;
            }
            cw cwVar = this.f27946j.get(str);
            if (cwVar != null) {
                cwVar.j(uf.mi(this.xt), false);
            }
        }

        j(Map<String, cw> map, n nVar, Context context, String str) {
            this.f27946j = map;
            this.xt = nVar;
            this.cw = context;
            this.f27947r = str;
        }
    }

    static {
        StubApp.interface11(22677);
    }

    private void jy() {
        this.nd = 0;
        if (this.gx) {
            this.nd = com.bytedance.sdk.openadsdk.core.tl.r.f30512j;
        } else if (this.f27925n && !com.bytedance.sdk.openadsdk.core.tl.r.f30514r) {
            this.nd = e.ws(this.up);
        }
        xt(this.nd);
        if (this.nd > 0 && !this.ol.hasMessages(10)) {
            if (this.gx) {
                this.ol.sendEmptyMessageDelayed(10, 1000L);
            } else if (this.f27925n) {
                this.ol.sendEmptyMessageDelayed(10, 1000L);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: private */
    public String ae() {
        n nVar = this.up;
        if (nVar != null && !TextUtils.isEmpty(nVar.sf())) {
            this.hl = this.up.sf();
        }
        return this.hl;
    }

    private void g() {
        TTViewStub tTViewStub;
        if (this.gx || this.f27925n) {
            TTViewStub tTViewStub2 = this.f27928v;
            if (tTViewStub2 != null) {
                tTViewStub2.setVisibility(0);
            }
            this.mi = (ImageView) findViewById(2114387849);
        } else {
            n nVar = this.up;
            if (nVar == null || !nVar.jy()) {
                int p5 = com.bytedance.sdk.openadsdk.core.oq.i().p();
                if (p5 == 0) {
                    TTViewStub tTViewStub3 = this.tj;
                    if (tTViewStub3 != null) {
                        tTViewStub3.setVisibility(0);
                    }
                } else if (p5 == 1 && (tTViewStub = this.f27919f) != null) {
                    tTViewStub.setVisibility(0);
                }
            } else {
                TTViewStub tTViewStub4 = this.tj;
                if (tTViewStub4 != null) {
                    tTViewStub4.setVisibility(8);
                }
                TTViewStub tTViewStub5 = this.f27919f;
                if (tTViewStub5 != null) {
                    tTViewStub5.setVisibility(8);
                }
            }
        }
        ImageView imageView = (ImageView) findViewById(2114387711);
        this.oq = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ed.j(TTWebPageActivity.this.f27920g)) {
                        return;
                    }
                    if (TTWebPageActivity.this.hh != null) {
                        TTWebPageActivity.this.hh.j(0);
                    }
                    TTWebPageActivity.this.onBackPressed();
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387710);
        this.qv = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity.this.finish();
                }
            });
        }
        this.vl = (TextView) findViewById(2114387952);
        this.jy = (TextView) findViewById(2114387633);
        this.ws = (TextView) findViewById(2114387616);
        this.az = (TextView) findViewById(2114387707);
        this.av = (TextView) findViewById(2114387604);
        this.f27922i = (TextView) findViewById(2114387706);
        this.f27929w = (LinearLayout) findViewById(2114387682);
        TextView textView = this.jy;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity.this.j();
                }
            });
        }
    }

    private void m() {
        n nVar = this.up;
        if (nVar == null || nVar.jl() != 4) {
            return;
        }
        TTViewStub tTViewStub = this.f27930x;
        if (tTViewStub != null) {
            tTViewStub.setVisibility(0);
        }
        Button button = (Button) findViewById(2114387735);
        this.ch = button;
        if (button != null) {
            j(ae());
            if (this.uf == null) {
                cw j6 = tl.j((Context) this.rn, this.up, TextUtils.isEmpty(this.cw) ? uf.j(this.f27819r) : this.cw, false);
                this.uf = j6;
                j6.j(oq.j(this.up));
                this.uf.j(this.f27917b, false);
            }
            this.uf.j(this.rn);
            cw cwVar = this.uf;
            if (cwVar instanceof up) {
                ((up) cwVar).m(true);
            }
            com.bytedance.sdk.openadsdk.core.xt.j jVar = new com.bytedance.sdk.openadsdk.core.xt.j(this.rn, this.up, "embeded_ad_landingpage", this.f27819r);
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).cw(true);
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(true);
            this.ch.setOnClickListener(jVar);
            this.ch.setOnTouchListener(jVar);
            ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.uf);
        }
    }

    private void oq() {
        if (this.f27920g == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.up);
        rn rnVar = new rn(this.rn);
        this.f27923l = rnVar;
        rnVar.r(this.f27926p);
        this.f27923l.xt(this.f27920g).j(this.up).cw(arrayList).xt(this.f27817j).cw(this.xt).cw(this.f27819r).j(this.cw).r(uf.av(this.up)).j(this.f27920g).j(true).xt(oq.j(this.up)).j(this);
    }

    private void qv() {
        if (this.up == null) {
            return;
        }
        JSONArray xt = xt(this.f27921h);
        int g6 = uf.g(this.up);
        int tl2 = uf.tl(this.up);
        s<com.bytedance.sdk.openadsdk.core.jy.j> j6 = v.j();
        if (xt == null || j6 == null || g6 <= 0 || tl2 <= 0) {
            return;
        }
        nd ndVar = new nd();
        ndVar.up = xt;
        com.bytedance.sdk.openadsdk.i.cw.cw.xt rr = this.up.rr();
        if (rr == null) {
            return;
        }
        j6.j(a.xt(rr).cw(6).j(), ndVar, tl2, new s.xt() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.5
            @Override // com.bytedance.sdk.openadsdk.core.s.xt
            public void j(int i6, String str, com.bytedance.sdk.openadsdk.core.tj.xt xtVar) {
                TTWebPageActivity.this.j(0);
                xtVar.j(i6);
                com.bytedance.sdk.openadsdk.core.tj.xt.j(xtVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.s.xt
            public void j(com.bytedance.sdk.openadsdk.core.tj.j jVar, com.bytedance.sdk.openadsdk.core.tj.xt xtVar) {
                if (jVar != null) {
                    try {
                        TTWebPageActivity.this.la.set(false);
                        TTWebPageActivity.this.f27923l.j(jVar.cw());
                    } catch (Exception unused) {
                        TTWebPageActivity.this.j(0);
                    }
                }
            }
        });
    }

    private void r() {
        n nVar = this.up;
        if (nVar == null) {
            return;
        }
        this.wq = com.bytedance.sdk.openadsdk.jy.r.j(this.kt, nVar, this.f27921h);
    }

    private View tl() {
        Activity activity = this.rn;
        if (activity == null) {
            return null;
        }
        Resources resources = activity.getResources();
        this.f27916a = new LinearLayout(this.rn);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f27916a.setOrientation(1);
        this.f27916a.setLayoutParams(layoutParams);
        TTViewStub tTViewStub = new TTViewStub(this.kt, new com.bytedance.sdk.openadsdk.res.layout.j.xt());
        this.tj = tTViewStub;
        tTViewStub.setId(2114387776);
        this.f27916a.addView(this.tj, new LinearLayout.LayoutParams(-1, -2));
        TTViewStub tTViewStub2 = new TTViewStub(this.kt, new com.bytedance.sdk.openadsdk.res.layout.j.cw());
        this.f27919f = tTViewStub2;
        tTViewStub2.setId(2114387798);
        this.f27916a.addView(this.f27919f, new LinearLayout.LayoutParams(-1, -2));
        TTViewStub tTViewStub3 = new TTViewStub(this.kt, new com.bytedance.sdk.openadsdk.res.layout.j.r());
        this.f27928v = tTViewStub3;
        tTViewStub3.setId(2114387939);
        this.f27916a.addView(this.f27928v, new LinearLayout.LayoutParams(-1, -2));
        FrameLayout frameLayout = new FrameLayout(this.rn);
        this.f27916a.addView(frameLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        SSWebView sSWebView = new SSWebView(this.rn);
        this.f27920g = sSWebView;
        sSWebView.setMaterialMeta(com.bytedance.sdk.openadsdk.core.rn.rn.j(this.up));
        this.f27920g.setId(2114387739);
        this.f27920g.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(this.f27920g);
        TTViewStub tTViewStub4 = new TTViewStub(this.kt, new com.bytedance.sdk.openadsdk.res.layout.j.j());
        this.f27930x = tTViewStub4;
        tTViewStub4.setId(2114387956);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 48.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 81;
        frameLayout.addView(this.f27930x, layoutParams2);
        TTProgressBar tTProgressBar = new TTProgressBar(this.rn, null, R.style.Widget.ProgressBar.Horizontal);
        this.f27927s = tTProgressBar;
        tTProgressBar.setId(2114387928);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 3.0f, resources.getDisplayMetrics()));
        layoutParams3.gravity = 49;
        this.f27927s.setLayoutParams(layoutParams3);
        this.f27927s.setProgress(1);
        this.f27927s.setProgressDrawable(kt.cw(this.rn, "tt_browser_progress_style"));
        frameLayout.addView(this.f27927s);
        return this.f27916a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void up() {
        int w5 = tj.w(this.up);
        n nVar = this.up;
        if (nVar != null) {
            if (nVar.jl() == 4 || w5 != 0) {
                if (this.uf == null) {
                    cw j6 = tl.j((Context) this.rn, this.up, TextUtils.isEmpty(this.cw) ? uf.j(this.f27819r) : this.cw, false);
                    this.uf = j6;
                    j6.j(oq.j(this.up));
                    this.uf.j(this.f27917b, false);
                }
                this.uf.j(this.rn);
                cw cwVar = this.uf;
                if (cwVar instanceof up) {
                    ((up) cwVar).m(true);
                    ((up) this.uf).tl().j(false);
                }
                com.bytedance.sdk.openadsdk.core.xt.j jVar = new com.bytedance.sdk.openadsdk.core.xt.j(this.rn, this.up, "embeded_ad_landingpage", this.f27819r);
                ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).cw(true);
                ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(true);
                this.uf.j(this.up, false);
                ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.uf);
            }
        }
    }

    private void vl() {
        this.f27925n = e.mi(this.up);
        boolean z5 = e.w(this.up) && !com.bytedance.sdk.openadsdk.core.tl.r.cw;
        this.gx = z5;
        if (this.f27925n) {
            if (!com.bytedance.sdk.openadsdk.core.tl.r.f30514r) {
                this.gx = false;
            } else if (z5) {
                this.f27925n = false;
            }
        }
    }

    private boolean ws() {
        return this.gx || this.f27925n;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        try {
            if ((n.cw(this.up) || com.bytedance.sdk.openadsdk.core.tj.rn.j(this.up)) && ed.j(this.f27920g)) {
                return;
            }
            xt xtVar = this.hh;
            if (xtVar == null || !xtVar.xt(this.rn, this.up)) {
                super.onBackPressed();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        xt xtVar = this.hh;
        if (xtVar != null) {
            xtVar.j(i6);
        }
        return super.onKeyDown(i6, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av() {
        if (ws() && !this.ol.hasMessages(10)) {
            this.ol.sendEmptyMessageDelayed(10, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az() {
        if (ws()) {
            this.ol.removeMessages(10);
        }
    }

    private void cw(n nVar) {
        LinearLayout linearLayout = this.f27929w;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
            return;
        }
        if (this.up == null) {
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                return;
            }
            return;
        }
        String ov = nVar.ov();
        if (TextUtils.isEmpty(ov)) {
            LinearLayout linearLayout2 = this.f27929w;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
                return;
            }
            return;
        }
        try {
            if (TextUtils.isEmpty(ov)) {
                return;
            }
            m up = com.bytedance.sdk.openadsdk.core.j.up(new JSONObject(ov));
            if (up == null) {
                LinearLayout linearLayout3 = this.f27929w;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(up.jy())) {
                LinearLayout linearLayout4 = this.f27929w;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(8);
                    return;
                }
                return;
            }
            LinearLayout linearLayout5 = this.f27929w;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(0);
            }
            String up2 = up.up();
            String ae = up.ae();
            String ws = up.ws();
            if (TextUtils.isEmpty(ws)) {
                ws = oq.xt(nVar);
            }
            if (this.ws != null) {
                this.ws.setText(String.format(kt.j(this.kt, "tt_open_app_detail_developer"), ae));
            }
            if (this.az != null) {
                this.az.setText(String.format(kt.j(this.kt, "tt_open_landing_page_app_name"), ws, up2));
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(n nVar) {
        if (nVar == null) {
            return;
        }
        String ov = nVar.ov();
        az();
        com.bytedance.sdk.openadsdk.core.rn.m.j(this.kt, nVar.fs(), new m.j() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.11
            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnNo() {
                TTWebPageActivity.this.av();
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnYes() {
                TTWebPageActivity.this.av();
                TTWebPageActivity.this.up();
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogCancel() {
                TTWebPageActivity.this.av();
            }
        }, ov);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        xt xtVar = this.hh;
        if (xtVar != null) {
            xtVar.j(this.rn, this.up);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m();
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        com.bytedance.sdk.openadsdk.core.jy.r rVar = this.ae;
        if (rVar != null) {
            rVar.ae();
        }
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        SSWebView sSWebView = this.f27920g;
        if (sSWebView != null) {
            c.j(this.kt, sSWebView);
            c.j(this.f27920g);
        }
        this.f27920g = null;
        com.bytedance.sdk.openadsdk.jy.r rVar2 = this.wq;
        if (rVar2 != null) {
            rVar2.r();
        }
        rn rnVar = this.f27923l;
        if (rnVar != null) {
            rnVar.l();
        }
        cw cwVar = this.uf;
        if (cwVar != null) {
            cwVar.xt();
        }
        Map<String, cw> map = this.ed;
        if (map != null) {
            for (Map.Entry<String, cw> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().xt();
                }
            }
            this.ed.clear();
        }
        com.bytedance.sdk.openadsdk.core.jy.r rVar3 = this.ae;
        if (rVar3 != null) {
            rVar3.m();
        }
        com.bytedance.sdk.openadsdk.core.playable.xt.j().xt(this.up);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        rn rnVar = this.f27923l;
        if (rnVar != null) {
            rnVar.a();
        }
        Map<String, cw> map = this.ed;
        if (map != null) {
            for (Map.Entry<String, cw> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue();
                }
            }
        }
        com.bytedance.sdk.openadsdk.core.widget.j.r rVar = this.f27918c;
        if (rVar != null) {
            rVar.cw();
        }
        az();
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        rn rnVar = this.f27923l;
        if (rnVar != null) {
            rnVar.s();
            this.f27923l.j(new SSWebView.xt() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.4
                @Override // com.bytedance.sdk.component.widget.SSWebView.xt
                public void j(int i6) {
                    TTWebPageActivity.this.f27923l.j(i6);
                }
            });
        }
        cw cwVar = this.uf;
        if (cwVar != null) {
            cwVar.j();
        }
        Map<String, cw> map = this.ed;
        if (map != null) {
            for (Map.Entry<String, cw> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().j();
                }
            }
        }
        com.bytedance.sdk.openadsdk.core.jy.r rVar = this.ae;
        if (rVar != null) {
            rVar.r();
        }
        com.bytedance.sdk.openadsdk.core.widget.j.r rVar2 = this.f27918c;
        if (rVar2 != null) {
            rVar2.xt(true);
        }
        qv();
        av();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.core.jy.r rVar = this.ae;
        if (rVar != null) {
            rVar.up();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(n nVar) {
        if (nVar == null) {
            return;
        }
        String ov = nVar.ov();
        az();
        com.bytedance.sdk.openadsdk.core.rn.m.j(this.kt, nVar.fs(), ov, new m.j() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.10
            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnNo() {
                TTWebPageActivity.this.av();
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnYes() {
                TTWebPageActivity.this.av();
                TTWebPageActivity.this.up();
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogCancel() {
                TTWebPageActivity.this.av();
            }
        });
    }

    private JSONArray xt(String str) {
        int i6;
        JSONArray jSONArray = this.gq;
        if (jSONArray != null && jSONArray.length() > 0) {
            return this.gq;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("?id=");
        int indexOf2 = str.indexOf(ContainerUtils.FIELD_DELIMITER);
        if (indexOf == -1 || indexOf2 == -1 || (i6 = indexOf + 4) >= indexOf2) {
            return null;
        }
        String substring = str.substring(i6, indexOf2);
        if (TextUtils.isEmpty(substring)) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(substring);
        return jSONArray2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.ch) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (TTWebPageActivity.this.ch == null || TTWebPageActivity.this.isFinishing()) {
                    return;
                }
                TTWebPageActivity.this.ch.setText(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6) {
        if (n.cw(this.up)) {
            ed.j((View) this.qv, 4);
        } else if (n.cw(this.up)) {
            ed.j((View) this.qv, i6);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.av.r
    public void j(boolean z5, JSONArray jSONArray) {
        if (!z5 || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.gq = jSONArray;
        qv();
    }

    void xt() {
        try {
            com.bytedance.sdk.openadsdk.core.dislike.ui.j jVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.j(this.rn, this.up.gs(), this.cw, true);
            this.f27924m = jVar;
            com.bytedance.sdk.openadsdk.core.dislike.cw.j(this.rn, this.up, jVar);
            this.f27924m.j(new j.InterfaceC0455j() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.6
                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.j.InterfaceC0455j
                public void j() {
                    TTWebPageActivity.this.az();
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.j.InterfaceC0455j
                public void j(int i6, String str, boolean z5) {
                    TTWebPageActivity.this.av();
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.j.InterfaceC0455j
                public void xt() {
                    TTWebPageActivity.this.av();
                }
            });
        } catch (Exception e6) {
            vl.cw(e6.getMessage());
        }
    }

    protected void j() {
        if (this.up == null || isFinishing()) {
            return;
        }
        if (this.f27924m == null) {
            xt();
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.j jVar = this.f27924m;
        if (jVar != null) {
            jVar.j();
        }
    }

    private void xt(int i6) {
        if (i6 > 0) {
            if (this.gx) {
                ed.j(this.vl, i6 + "s后可领取奖励");
                return;
            }
            if (this.f27925n) {
                SpannableString spannableString = new SpannableString("浏览 " + i6 + "秒 获得更多福利");
                spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), spannableString.length() + (-4), spannableString.length(), 17);
                ed.j(this.vl, spannableString);
                return;
            }
            return;
        }
        if (this.gx) {
            ed.j(this.vl, "领取成功");
        } else if (this.f27925n) {
            ed.j((View) this.mi, 8);
            ed.j(this.vl, "恭喜你！福利已领取");
        }
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        if (message.what == 10 && ws()) {
            int i6 = this.rh + 1;
            this.rh = i6;
            if (this.gx) {
                com.bytedance.sdk.openadsdk.core.tl.r.xt = i6;
            }
            int max = Math.max(0, this.nd - i6);
            xt(max);
            if (max <= 0 && this.f27925n) {
                com.bytedance.sdk.openadsdk.core.tl.r.f30514r = true;
            }
            this.ol.sendEmptyMessageDelayed(10, 1000L);
        }
    }
}
