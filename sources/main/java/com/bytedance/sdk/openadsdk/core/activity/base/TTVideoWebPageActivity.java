package com.bytedance.sdk.openadsdk.core.activity.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.r.cw;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.ch;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.tl;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.av.j;
import com.bytedance.sdk.openadsdk.core.av.r;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.dislike.ui.j;
import com.bytedance.sdk.openadsdk.core.playable.xt.xt;
import com.bytedance.sdk.openadsdk.core.qv.cw.oq;
import com.bytedance.sdk.openadsdk.core.qv.cw.up;
import com.bytedance.sdk.openadsdk.core.rn;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.m;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.tj.h;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.nd;
import com.bytedance.sdk.openadsdk.core.tj.tj;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;
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
public class TTVideoWebPageActivity extends BaseLandingPageActivity implements cw.InterfaceC0306cw, r {
    protected NativeVideoTsView ae;
    private TextView av;
    private TextView az;

    /* renamed from: b, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.jy.r f27880b;
    private com.bytedance.sdk.openadsdk.core.qv.xt.cw ed;

    /* renamed from: f, reason: collision with root package name */
    private FrameLayout f27883f;

    /* renamed from: g, reason: collision with root package name */
    private SSWebView f27884g;
    private TextView gq;

    /* renamed from: h, reason: collision with root package name */
    private RoundImageView f27885h;
    private int hh;
    private com.bytedance.sdk.openadsdk.core.jy.r hl;

    /* renamed from: i, reason: collision with root package name */
    private TextView f27886i;
    private TextView jy;
    private rn kt;

    /* renamed from: l, reason: collision with root package name */
    private RelativeLayout f27888l;
    private TextView la;

    /* renamed from: m, reason: collision with root package name */
    j f27889m;
    private Context mi;
    private ImageView oq;

    /* renamed from: p, reason: collision with root package name */
    private TextView f27891p;
    private Activity qb;
    private ImageView qv;
    private TTViewStub rn;
    private xt sm;
    private RelativeLayout tj;
    protected cw tl;
    private TTProgressBar uf;

    /* renamed from: v, reason: collision with root package name */
    private long f27894v;
    private TextView vl;

    /* renamed from: w, reason: collision with root package name */
    private LinearLayout f27895w;
    private Button wq;
    private TextView ws;
    private boolean xq;
    private boolean ya;

    /* renamed from: z, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.multipro.xt.j f27897z;

    /* renamed from: x, reason: collision with root package name */
    private int f27896x = 0;
    private int ch = 0;

    /* renamed from: s, reason: collision with root package name */
    private int f27893s = 0;

    /* renamed from: a, reason: collision with root package name */
    private int f27879a = 0;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, com.bytedance.sdk.openadsdk.core.qv.xt.cw> f27881c = Collections.synchronizedMap(new HashMap());
    private boolean gx = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f27890n = false;
    private boolean nd = true;
    private boolean rh = false;
    private String ol = null;

    /* renamed from: e, reason: collision with root package name */
    private AtomicBoolean f27882e = new AtomicBoolean(true);

    /* renamed from: q, reason: collision with root package name */
    private JSONArray f27892q = null;

    /* renamed from: k, reason: collision with root package name */
    private String f27887k = "立即下载";
    private com.bytedance.sdk.openadsdk.core.qv.xt.j ff = new com.bytedance.sdk.openadsdk.core.qv.xt.j() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.16
        @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
        public void j() {
            TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
            tTVideoWebPageActivity.xt(tTVideoWebPageActivity.ws());
            j.C0431j.j(TTVideoWebPageActivity.this.f27817j, 1, 0);
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
        public void cw(long j6, long j7, String str, String str2) {
            TTVideoWebPageActivity.this.xt("下载失败");
            if (j6 > 0) {
                j.C0431j.j(TTVideoWebPageActivity.this.f27817j, 4, (int) ((j7 * 100) / j6));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
        public void xt(long j6, long j7, String str, String str2) {
            TTVideoWebPageActivity.this.xt("暂停");
            if (j6 > 0) {
                j.C0431j.j(TTVideoWebPageActivity.this.f27817j, 2, (int) ((j7 * 100) / j6));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
        public void j(long j6, long j7, String str, String str2) {
            TTVideoWebPageActivity.this.xt("下载中...");
            if (j6 > 0) {
                j.C0431j.j(TTVideoWebPageActivity.this.f27817j, 3, (int) ((j7 * 100) / j6));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
        public void j(long j6, String str, String str2) {
            TTVideoWebPageActivity.this.xt("点击安装");
            j.C0431j.j(TTVideoWebPageActivity.this.f27817j, 5, 100);
        }

        @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
        public void j(String str, String str2) {
            TTVideoWebPageActivity.this.xt("点击打开");
            j.C0431j.j(TTVideoWebPageActivity.this.f27817j, 6, 100);
        }
    };
    private com.bytedance.sdk.openadsdk.core.xt.j ry = null;
    private final cw.xt zz = new cw.xt() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.5
        @Override // com.bykv.vk.openvk.component.video.api.r.cw.xt
        public void j(boolean z5) {
            TTVideoWebPageActivity.this.gx = z5;
            if (TTVideoWebPageActivity.this.isFinishing()) {
                return;
            }
            if (!z5) {
                ed.j((View) TTVideoWebPageActivity.this.f27884g, 0);
                ed.j((View) TTVideoWebPageActivity.this.tj, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.f27883f.getLayoutParams();
                marginLayoutParams.width = TTVideoWebPageActivity.this.f27893s;
                marginLayoutParams.height = TTVideoWebPageActivity.this.f27879a;
                marginLayoutParams.leftMargin = TTVideoWebPageActivity.this.ch;
                marginLayoutParams.topMargin = TTVideoWebPageActivity.this.f27896x;
                TTVideoWebPageActivity.this.f27883f.setLayoutParams(marginLayoutParams);
                return;
            }
            ed.j((View) TTVideoWebPageActivity.this.f27884g, 8);
            ed.j((View) TTVideoWebPageActivity.this.tj, 8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) TTVideoWebPageActivity.this.f27883f.getLayoutParams();
            TTVideoWebPageActivity.this.ch = marginLayoutParams2.leftMargin;
            TTVideoWebPageActivity.this.f27896x = marginLayoutParams2.topMargin;
            TTVideoWebPageActivity.this.f27893s = marginLayoutParams2.width;
            TTVideoWebPageActivity.this.f27879a = marginLayoutParams2.height;
            marginLayoutParams2.width = -1;
            marginLayoutParams2.height = -1;
            marginLayoutParams2.topMargin = 0;
            marginLayoutParams2.leftMargin = 0;
            TTVideoWebPageActivity.this.f27883f.setLayoutParams(marginLayoutParams2);
        }
    };
    private boolean kc = false;
    private final ch.j aq = new ch.j() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.7
        @Override // com.bytedance.sdk.component.utils.ch.j
        public void j(Context context, Intent intent, boolean z5, int i6) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                if (TTVideoWebPageActivity.this.hh == 0 && i6 != 0 && TTVideoWebPageActivity.this.f27884g != null && TTVideoWebPageActivity.this.ol != null) {
                    tl.xt().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (TTVideoWebPageActivity.this.f27884g != null) {
                                TTVideoWebPageActivity.this.f27884g.loadUrl(TTVideoWebPageActivity.this.ol);
                            }
                        }
                    });
                }
                NativeVideoTsView nativeVideoTsView = TTVideoWebPageActivity.this.ae;
                if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null && !TTVideoWebPageActivity.this.ch() && TTVideoWebPageActivity.this.hh != i6) {
                    ((com.bytedance.sdk.openadsdk.core.video.nativevideo.r) TTVideoWebPageActivity.this.ae.getNativeVideoController()).j(context, i6);
                }
                TTVideoWebPageActivity.this.hh = i6;
            }
        }
    };

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity$1, reason: invalid class name */
    class AnonymousClass1 extends com.bytedance.sdk.openadsdk.core.widget.j.r {
        AnonymousClass1(Context context, rn rnVar, String str, com.bytedance.sdk.openadsdk.core.jy.r rVar, com.bytedance.sdk.openadsdk.jy.r rVar2) {
            super(context, rnVar, str, rVar, rVar2);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            try {
                if (TTVideoWebPageActivity.this.uf != null && !TTVideoWebPageActivity.this.isFinishing()) {
                    TTVideoWebPageActivity.this.uf.setVisibility(8);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity$10, reason: invalid class name */
    class AnonymousClass10 extends com.bytedance.sdk.openadsdk.core.widget.j.cw {
        AnonymousClass10(rn rnVar, com.bytedance.sdk.openadsdk.core.jy.r rVar) {
            super(rnVar, rVar);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.j.cw, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i6) {
            super.onProgressChanged(webView, i6);
            if (TTVideoWebPageActivity.this.uf != null && !TTVideoWebPageActivity.this.isFinishing()) {
                if (i6 == 100 && TTVideoWebPageActivity.this.uf.isShown()) {
                    TTVideoWebPageActivity.this.uf.setVisibility(8);
                } else {
                    TTVideoWebPageActivity.this.uf.setProgress(i6);
                }
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity$11, reason: invalid class name */
    class AnonymousClass11 implements DownloadListener {
        AnonymousClass11() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j6) {
            if (TTVideoWebPageActivity.this.f27881c.containsKey(str)) {
                com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = (com.bytedance.sdk.openadsdk.core.qv.xt.cw) TTVideoWebPageActivity.this.f27881c.get(str);
                if (cwVar != null) {
                    cwVar.j(uf.mi(TTVideoWebPageActivity.this.up), false);
                    return;
                }
                return;
            }
            Activity activity = TTVideoWebPageActivity.this.qb;
            TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
            com.bytedance.sdk.openadsdk.core.qv.xt.cw j7 = com.bytedance.sdk.openadsdk.core.qv.tl.j(activity, str, tTVideoWebPageActivity.up, tTVideoWebPageActivity.cw);
            j7.j(oq.j(TTVideoWebPageActivity.this.up));
            TTVideoWebPageActivity.this.f27881c.put(str, j7);
            j7.j(uf.mi(TTVideoWebPageActivity.this.up), false);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity$12, reason: invalid class name */
    class AnonymousClass12 implements View.OnClickListener {
        AnonymousClass12() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
            tTVideoWebPageActivity.xt(tTVideoWebPageActivity.up);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity$13, reason: invalid class name */
    class AnonymousClass13 implements View.OnClickListener {
        AnonymousClass13() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TTVideoWebPageActivity tTVideoWebPageActivity = TTVideoWebPageActivity.this;
            tTVideoWebPageActivity.cw(tTVideoWebPageActivity.up);
        }
    }

    static {
        StubApp.interface11(22661);
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void av() {
        n nVar = this.up;
        if (nVar == null || this.tj == null || !nVar.jy()) {
            return;
        }
        this.tj.setVisibility(8);
    }

    private void az() {
        this.uf = (TTProgressBar) findViewById(2114387928);
        this.rn = (TTViewStub) findViewById(2114387956);
        this.f27884g = (SSWebView) findViewById(2114387739);
        this.oq = (ImageView) findViewById(2114387711);
        n nVar = this.up;
        if (nVar != null && nVar.gs() != null) {
            this.up.gs().j("landing_page");
        }
        ImageView imageView = this.oq;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ed.j(TTVideoWebPageActivity.this.f27884g)) {
                        return;
                    }
                    if (TTVideoWebPageActivity.this.sm != null) {
                        TTVideoWebPageActivity.this.sm.j(0);
                    }
                    TTVideoWebPageActivity.this.onBackPressed();
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387710);
        this.qv = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity.this.j("detail_skip");
                    TTVideoWebPageActivity.this.finish();
                }
            });
        }
        TextView textView = (TextView) findViewById(2114387633);
        this.jy = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTVideoWebPageActivity.this.ae();
                }
            });
        }
        this.vl = (TextView) findViewById(2114387952);
        this.ws = (TextView) findViewById(2114387892);
        this.az = (TextView) findViewById(2114387751);
        this.av = (TextView) findViewById(2114387653);
        this.f27886i = (TextView) findViewById(2114387618);
        this.f27895w = (LinearLayout) findViewById(2114387896);
        this.f27883f = (FrameLayout) findViewById(2114387714);
        this.tj = (RelativeLayout) findViewById(2114387949);
        this.f27888l = (RelativeLayout) findViewById(2114387661);
        this.f27891p = (TextView) findViewById(2114387957);
        this.la = (TextView) findViewById(2114387770);
        this.gq = (TextView) findViewById(2114387692);
        this.f27885h = (RoundImageView) findViewById(2114387670);
        kt();
        av();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ch() {
        NativeVideoTsView nativeVideoTsView = this.ae;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return true;
        }
        return this.ae.getNativeVideoController().kt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void f() {
        int w5 = tj.w(this.up);
        n nVar = this.up;
        if (nVar != null) {
            if (nVar.jl() == 4 || w5 != 0) {
                com.bytedance.sdk.openadsdk.core.qv.xt.cw j6 = com.bytedance.sdk.openadsdk.core.qv.tl.j((Context) this.qb, this.up, this.cw, false);
                this.ed = j6;
                j6.j(this.qb);
                com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = this.ed;
                if (cwVar instanceof up) {
                    ((up) cwVar).m(true);
                    ((up) this.ed).tl().j(false);
                }
                com.bytedance.sdk.openadsdk.core.xt.j jVar = new com.bytedance.sdk.openadsdk.core.xt.j(this.qb, this.up, "embeded_ad_landingpage", this.f27819r);
                this.ry = jVar;
                ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).cw(true);
                ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.ry.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(true);
                this.ed.j(this.up, false);
                ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.ry.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.ed);
            }
        }
    }

    private void i() {
        if (n.xt(this.up)) {
            try {
                if (this instanceof TTVideoScrollWebPageActivity) {
                    this.ae = new NativeVideoTsView(this.mi, this.up, true, true);
                } else {
                    this.ae = new NativeVideoTsView(this.mi, this.up, true, false);
                }
                if (this.ae.getNativeVideoController() != null) {
                    this.ae.getNativeVideoController().j(false);
                    if (this.f27897z != null) {
                        this.ae.getNativeVideoController().cw(this.f27897z.f29581j);
                    }
                }
                this.ae.setVideoAdInteractionListener(this);
                if (!this.rh) {
                    this.f27894v = 0L;
                }
                if (this.f27897z != null && this.ae.getNativeVideoController() != null) {
                    this.ae.getNativeVideoController().cw(this.f27897z.ae);
                    this.ae.getNativeVideoController().r(this.f27897z.up);
                }
                if (this.ae.getNativeVideoController() != null) {
                    this.ae.getNativeVideoController().j(false);
                    this.ae.getNativeVideoController().j(this.zz);
                    this.ae.setIsQuiet(v.xt().r(uf.g(this.up)));
                }
                if (this.ae.j(this.f27894v, this.nd, ch())) {
                    this.f27883f.setVisibility(0);
                    this.f27883f.removeAllViews();
                    this.f27883f.addView(this.ae);
                }
                if (ch()) {
                    this.ae.r(true);
                }
                this.tl = this.ae.getNativeVideoController();
            } catch (Exception e6) {
                vl.j(e6);
            }
            if (ws.cw(StubApp.getOrigApplicationContext(this.qb.getApplicationContext())) == 0) {
                try {
                    Activity activity = this.qb;
                    a.j(activity, kt.j(activity, "tt_no_network"), 0);
                } catch (Exception unused) {
                }
            }
        }
    }

    private void jy() {
        n nVar = this.up;
        if (nVar == null || nVar.jl() != 4) {
            return;
        }
        this.rn.setVisibility(0);
        Button button = (Button) findViewById(2114387735);
        this.wq = button;
        if (button != null) {
            xt(ws());
            com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = this.ed;
            if (cwVar != null) {
                cwVar.j(this.ff, false);
            }
            this.wq.setOnClickListener(this.ry);
            this.wq.setOnTouchListener(this.ry);
        }
    }

    private void kt() {
        n nVar = this.up;
        if (nVar == null || nVar.jl() != 4) {
            return;
        }
        ed.j((View) this.f27888l, 0);
        String hw = !TextUtils.isEmpty(this.up.hw()) ? this.up.hw() : !TextUtils.isEmpty(this.up.zk()) ? this.up.zk() : !TextUtils.isEmpty(this.up.rs()) ? this.up.rs() : "";
        h ig = this.up.ig();
        if (ig != null && ig.j() != null) {
            ed.j((View) this.f27885h, 0);
            ed.j((View) this.f27891p, 4);
            com.bytedance.sdk.openadsdk.g.xt.j(ig).j(this.f27885h);
        } else if (!TextUtils.isEmpty(hw)) {
            ed.j((View) this.f27885h, 4);
            ed.j((View) this.f27891p, 0);
            this.f27891p.setText(hw.substring(0, 1));
        }
        if (this.la != null && !TextUtils.isEmpty(hw)) {
            this.la.setText(hw);
        }
        if (!TextUtils.isEmpty(this.up.sf())) {
            this.gq.setText(this.up.sf());
        }
        ed.j((View) this.la, 0);
        if (s()) {
            ed.j((View) this.gq, 8);
        } else {
            ed.j((View) this.gq, 0);
        }
    }

    private int mi() {
        NativeVideoTsView nativeVideoTsView = this.ae;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0;
        }
        return this.ae.getNativeVideoController().az();
    }

    private boolean s() {
        n nVar = this.up;
        if (nVar == null) {
            return false;
        }
        int ff = nVar.ff();
        return this.f27819r == 1 && "embeded_ad_landingpage".equals(this.cw) && (ff == 1 || ff == 2);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void tj() {
        n nVar = this.up;
        if (nVar == null || nVar.jl() != 4) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.qv.xt.cw j6 = com.bytedance.sdk.openadsdk.core.qv.tl.j((Context) this.qb, this.up, this.cw, false);
        this.ed = j6;
        j6.j(this.qb);
        this.ed.j(oq.j(this.up));
        com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = this.ed;
        if (cwVar instanceof up) {
            ((up) cwVar).m(true);
        }
        com.bytedance.sdk.openadsdk.core.xt.j jVar = new com.bytedance.sdk.openadsdk.core.xt.j(this.qb, this.up, "embeded_ad_landingpage", this.f27819r);
        this.ry = jVar;
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).cw(true);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.ry.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(true);
        this.gq.setOnClickListener(this.ry);
        this.gq.setOnTouchListener(this.ry);
        ((com.bytedance.sdk.openadsdk.core.xt.j.j.j) this.ry.j(com.bytedance.sdk.openadsdk.core.xt.j.j.j.class)).j(this.ed);
    }

    private void v() {
        if (this.f27884g == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.up);
        rn rnVar = new rn(this.qb);
        this.kt = rnVar;
        rnVar.r(this.ya);
        this.kt.xt(this.f27884g).j(this.up).cw(arrayList).xt(this.f27817j).j(this.cw).cw(this.xt).xt(oq.j(this.up)).cw(this.f27819r).j(this.f27884g).j(true).r(uf.av(this.up));
    }

    private void vl() {
        n nVar = this.up;
        if (nVar == null) {
            return;
        }
        this.f27880b = com.bytedance.sdk.openadsdk.jy.r.j(this.mi, nVar, this.ol);
    }

    private long w() {
        NativeVideoTsView nativeVideoTsView = this.ae;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0L;
        }
        return this.ae.getNativeVideoController().ws();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ws() {
        n nVar = this.up;
        if (nVar != null && !TextUtils.isEmpty(nVar.sf())) {
            this.f27887k = this.up.sf();
        }
        return this.f27887k;
    }

    private void x() {
        if (this.up == null) {
            return;
        }
        JSONArray cw = cw(this.ol);
        int g6 = uf.g(this.up);
        int tl = uf.tl(this.up);
        s<com.bytedance.sdk.openadsdk.core.jy.j> j6 = v.j();
        if (cw == null || j6 == null || g6 <= 0 || tl <= 0) {
            return;
        }
        nd ndVar = new nd();
        ndVar.up = cw;
        com.bytedance.sdk.openadsdk.i.cw.cw.xt rr = this.up.rr();
        if (rr == null) {
            return;
        }
        j6.j(com.bytedance.sdk.openadsdk.core.rn.a.xt(rr).cw(6).j(), ndVar, tl, new s.xt() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.8
            @Override // com.bytedance.sdk.openadsdk.core.s.xt
            public void j(int i6, String str, com.bytedance.sdk.openadsdk.core.tj.xt xtVar) {
                TTVideoWebPageActivity.this.j(0);
                xtVar.j(i6);
                com.bytedance.sdk.openadsdk.core.tj.xt.j(xtVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.s.xt
            public void j(com.bytedance.sdk.openadsdk.core.tj.j jVar, com.bytedance.sdk.openadsdk.core.tj.xt xtVar) {
                if (jVar != null) {
                    try {
                        TTVideoWebPageActivity.this.f27882e.set(false);
                        TTVideoWebPageActivity.this.kt.j(jVar.cw());
                    } catch (Exception unused) {
                        TTVideoWebPageActivity.this.j(0);
                    }
                }
            }
        });
    }

    protected void ae() {
        if (isFinishing() || this.up == null) {
            return;
        }
        if (this.f27889m == null) {
            tl();
        }
        this.f27889m.j();
    }

    boolean g() {
        cw cwVar = this.tl;
        return (cwVar == null || cwVar.i() == null || !this.tl.i().jy()) ? false : true;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        NativeVideoTsView nativeVideoTsView;
        if ((n.cw(this.up) || com.bytedance.sdk.openadsdk.core.tj.rn.j(this.up)) && ed.j(this.f27884g)) {
            return;
        }
        if (this.gx && (nativeVideoTsView = this.ae) != null && nativeVideoTsView.getNativeVideoController() != null) {
            ((com.bykv.vk.openvk.component.video.api.r.j) this.ae.getNativeVideoController()).up(null, null);
            this.gx = false;
            return;
        }
        xt xtVar = this.sm;
        if (xtVar == null || !xtVar.xt(this.qb, this.up)) {
            j("detail_back");
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i6, KeyEvent keyEvent) {
        xt xtVar = this.sm;
        if (xtVar != null) {
            xtVar.j(i6);
        }
        return super.onKeyDown(i6, keyEvent);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        n nVar = this.up;
        bundle.putString("material_meta", nVar != null ? nVar.tv().toString() : null);
        bundle.putLong("video_play_position", this.f27894v);
        bundle.putBoolean("is_complete", ch());
        long j6 = this.f27894v;
        NativeVideoTsView nativeVideoTsView = this.ae;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            j6 = this.ae.getNativeVideoController().qv();
        }
        bundle.putLong("video_play_position", j6);
        super.onSaveInstanceState(bundle);
    }

    protected boolean oq() {
        cw cwVar = this.tl;
        return (cwVar == null || cwVar.i() == null || !this.tl.i().ws()) ? false : true;
    }

    protected boolean qv() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.j jVar = this.f27889m;
        if (jVar != null) {
            return jVar.cw();
        }
        return false;
    }

    void tl() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.j jVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.j(this.qb, this.up.gs(), this.cw, true);
        this.f27889m = jVar;
        com.bytedance.sdk.openadsdk.core.dislike.cw.j(this.qb, this.up, jVar);
        this.f27889m.j(new j.InterfaceC0455j() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.9
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.j.InterfaceC0455j
            public void j() {
                if (TTVideoWebPageActivity.this.g()) {
                    TTVideoWebPageActivity.this.tl.m();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.j.InterfaceC0455j
            public void xt() {
                if (TTVideoWebPageActivity.this.oq()) {
                    TTVideoWebPageActivity.this.tl.tl();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.j.InterfaceC0455j
            public void j(int i6, String str, boolean z5) {
                if (TTVideoWebPageActivity.this.oq()) {
                    TTVideoWebPageActivity.this.tl.tl();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(n nVar) {
        if (nVar == null) {
            return;
        }
        m.j(this.mi, nVar.fs(), new m.j() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.15
            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnYes() {
                TTVideoWebPageActivity.this.f();
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogCancel() {
            }
        }, nVar.ov());
    }

    protected void m() {
        try {
            ch.j(this.aq);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        xt xtVar = this.sm;
        if (xtVar != null) {
            xtVar.j(this.qb, this.up);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        jy();
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        m();
        com.bytedance.sdk.openadsdk.core.jy.r rVar = this.hl;
        if (rVar != null) {
            rVar.ae();
        }
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        SSWebView sSWebView = this.f27884g;
        if (sSWebView != null) {
            c.j(this.mi, sSWebView);
            c.j(this.f27884g);
        }
        this.f27884g = null;
        com.bytedance.sdk.openadsdk.jy.r rVar2 = this.f27880b;
        if (rVar2 != null) {
            rVar2.r();
        }
        com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = this.ed;
        if (cwVar != null) {
            cwVar.xt();
        }
        Map<String, com.bytedance.sdk.openadsdk.core.qv.xt.cw> map = this.f27881c;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.qv.xt.cw> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().xt();
                }
            }
            this.f27881c.clear();
        }
        rn rnVar = this.kt;
        if (rnVar != null) {
            rnVar.l();
        }
        NativeVideoTsView nativeVideoTsView = this.ae;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            this.ae.getNativeVideoController().oq();
        }
        NativeVideoTsView nativeVideoTsView2 = this.ae;
        if (nativeVideoTsView2 != null) {
            nativeVideoTsView2.mi();
            this.ae = null;
        }
        this.up = null;
        com.bytedance.sdk.openadsdk.core.jy.r rVar3 = this.hl;
        if (rVar3 != null) {
            rVar3.m();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2;
        super.onPause();
        try {
            if (!this.f27890n && !qv()) {
                this.f27890n = true;
                this.tl.m();
            }
        } catch (Throwable th) {
            vl.r("TTVideoWebPageActivity", "onPause throw Exception :" + th.getMessage());
        }
        rn rnVar = this.kt;
        if (rnVar != null) {
            rnVar.a();
        }
        Map<String, com.bytedance.sdk.openadsdk.core.qv.xt.cw> map = this.f27881c;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.qv.xt.cw> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue();
                }
            }
        }
        if (ch() || ((nativeVideoTsView2 = this.ae) != null && nativeVideoTsView2.getNativeVideoController() != null && this.ae.getNativeVideoController().kt())) {
            com.bytedance.sdk.component.r.j.xt j6 = com.bytedance.sdk.openadsdk.core.rn.h.j("sp_multi_native_video_data");
            j6.j("key_video_is_update_flag", true);
            j6.j("key_native_video_complete", true);
            j6.j("key_video_isfromvideodetailpage", true);
        }
        if (!ch() && (nativeVideoTsView = this.ae) != null && nativeVideoTsView.getNativeVideoController() != null) {
            j(this.ae.getNativeVideoController());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.nd = false;
        if (this.f27890n && oq() && !qv()) {
            this.f27890n = false;
            this.tl.tl();
        }
        rn rnVar = this.kt;
        if (rnVar != null) {
            rnVar.s();
            this.kt.j(new SSWebView.xt() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.6
                @Override // com.bytedance.sdk.component.widget.SSWebView.xt
                public void j(int i6) {
                    TTVideoWebPageActivity.this.kt.j(i6);
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar = this.ed;
        if (cwVar != null) {
            cwVar.j();
        }
        Map<String, com.bytedance.sdk.openadsdk.core.qv.xt.cw> map = this.f27881c;
        if (map != null) {
            for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.qv.xt.cw> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().j();
                }
            }
        }
        com.bytedance.sdk.openadsdk.core.jy.r rVar = this.hl;
        if (rVar != null) {
            rVar.r();
        }
        x();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.core.jy.r rVar = this.hl;
        if (rVar != null) {
            rVar.up();
        }
    }

    protected void up() {
        ch.j(this.aq, this.mi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(n nVar) {
        if (nVar == null) {
            return;
        }
        m.j(this.mi, nVar.fs(), nVar.ov(), new m.j() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.14
            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnYes() {
                TTVideoWebPageActivity.this.f();
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogBtnNo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.rn.m.j
            public void onDialogCancel() {
            }
        });
    }

    private JSONArray cw(String str) {
        int i6;
        JSONArray jSONArray = this.f27892q;
        if (jSONArray != null && jSONArray.length() > 0) {
            return this.f27892q;
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

    private void j(n nVar) {
        LinearLayout linearLayout = this.f27895w;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
            return;
        }
        if (nVar == null) {
            return;
        }
        String ov = nVar.ov();
        if (TextUtils.isEmpty(ov)) {
            LinearLayout linearLayout2 = this.f27895w;
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
            com.bytedance.sdk.openadsdk.core.tj.m up = com.bytedance.sdk.openadsdk.core.j.up(new JSONObject(ov));
            if (up == null) {
                LinearLayout linearLayout3 = this.f27895w;
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(8);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(up.jy())) {
                LinearLayout linearLayout4 = this.f27895w;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(8);
                    return;
                }
                return;
            }
            LinearLayout linearLayout5 = this.f27895w;
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
                this.ws.setText(String.format(kt.j(this.mi, "tt_open_app_detail_developer"), ae));
            }
            if (this.az != null) {
                this.az.setText(String.format(kt.j(this.mi, "tt_open_landing_page_app_name"), ws, up2));
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.wq) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity.17
            @Override // java.lang.Runnable
            public void run() {
                if (TTVideoWebPageActivity.this.wq == null || TTVideoWebPageActivity.this.isFinishing()) {
                    return;
                }
                TTVideoWebPageActivity.this.wq.setText(str);
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void q_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void r_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void s_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void t_() {
    }

    public void j(String str) {
        NativeVideoTsView nativeVideoTsView = this.ae;
        com.bytedance.sdk.openadsdk.core.jy.cw.j(this.up, "embeded_ad", str, w(), mi(), (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) ? null : uf.j(this.up, this.ae.getNativeVideoController().vl(), this.ae.getNativeVideoController().i()));
    }

    private void j(cw cwVar) {
        vl.r("mutilproces", "initFeedNaitiveControllerData-isComplete=" + cwVar.kt() + ",position=" + cwVar.qv() + ",totalPlayDuration=" + (cwVar.ws() + cwVar.vl()) + ",duration=" + cwVar.ws());
        com.bytedance.sdk.component.r.j.xt j6 = com.bytedance.sdk.openadsdk.core.rn.h.j("sp_multi_native_video_data");
        j6.j("key_video_is_update_flag", true);
        j6.j("key_video_isfromvideodetailpage", true);
        j6.j("key_native_video_complete", cwVar.kt());
        j6.j("key_video_current_play_position", cwVar.qv());
        j6.j("key_video_total_play_duration", cwVar.ws() + cwVar.vl());
        j6.j("key_video_duration", cwVar.ws());
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
        this.f27892q = jSONArray;
        x();
    }

    @Override // com.bykv.vk.openvk.component.video.api.r.cw.InterfaceC0306cw
    public void j(long j6, long j7) {
        if (s()) {
            com.bytedance.sdk.openadsdk.core.oq.i().j(j6);
        }
    }
}
