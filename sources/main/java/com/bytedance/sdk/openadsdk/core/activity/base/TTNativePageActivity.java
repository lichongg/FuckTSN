package com.bytedance.sdk.openadsdk.core.activity.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.dislike.ui.j;
import com.bytedance.sdk.openadsdk.core.jy.up;
import com.bytedance.sdk.openadsdk.core.qv.cw.cw;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.e;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.ugeno.g.r;
import com.bytedance.sdk.openadsdk.core.ugeno.g.xt;
import com.bytedance.sdk.openadsdk.core.ugeno.oq;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class TTNativePageActivity extends BaseLandingPageActivity implements l.j {
    private static WeakReference<cw> ae;

    /* renamed from: a, reason: collision with root package name */
    private boolean f27857a;
    private TTViewStub av;
    private TTViewStub az;
    private boolean ch;

    /* renamed from: f, reason: collision with root package name */
    private r f27858f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f27859g;
    private long gq;

    /* renamed from: h, reason: collision with root package name */
    private int f27860h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f27861i;
    private TTViewStub jy;
    private Activity kt;

    /* renamed from: l, reason: collision with root package name */
    private boolean f27862l;

    /* renamed from: m, reason: collision with root package name */
    j f27863m;
    private TextView oq;

    /* renamed from: p, reason: collision with root package name */
    private int f27864p;
    private TextView qv;

    /* renamed from: s, reason: collision with root package name */
    private FrameLayout f27865s;
    private FrameLayout tj;
    private ImageView tl;

    /* renamed from: v, reason: collision with root package name */
    private xt f27866v;
    private Context vl;

    /* renamed from: w, reason: collision with root package name */
    private up f27867w;
    private TTViewStub ws;

    /* renamed from: x, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.cw.j f27868x;
    private AtomicBoolean mi = new AtomicBoolean(true);
    private boolean la = true;
    private final l rn = new l(Looper.getMainLooper(), this);
    private String wq = "立即下载";

    static {
        StubApp.interface11(22639);
    }

    private void jy() {
        this.f27864p = 0;
        if (this.f27857a) {
            this.f27864p = com.bytedance.sdk.openadsdk.core.tl.r.f30512j;
        } else if (this.f27862l && !com.bytedance.sdk.openadsdk.core.tl.r.f30514r) {
            this.f27864p = e.ws(this.up);
        }
        cw(this.f27864p);
        if (this.f27864p > 0 && !this.rn.hasMessages(10)) {
            if (this.f27857a) {
                this.rn.sendEmptyMessageDelayed(10, 1000L);
            } else if (this.f27862l) {
                this.rn.sendEmptyMessageDelayed(10, 1000L);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    private void ae() {
        if (!oq.tl(this.up)) {
            g();
            return;
        }
        com.bytedance.sdk.openadsdk.core.ugeno.cw.j jVar = new com.bytedance.sdk.openadsdk.core.ugeno.cw.j(this, this.tj, this.f27867w, this.up, this.cw, this.f27819r, tl());
        this.f27868x = jVar;
        jVar.j(new com.bytedance.sdk.openadsdk.core.ugeno.r.j() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.j
            public void j(View view) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.j
            public void j(int i6) {
                TTNativePageActivity.this.j(i6);
            }
        });
        this.f27868x.j();
    }

    private void cw(int i6) {
        if (i6 <= 0) {
            if (this.f27857a) {
                ed.j(this.oq, "领取成功");
                return;
            } else {
                if (this.f27862l) {
                    ed.j((View) this.f27861i, 8);
                    ed.j(this.oq, "恭喜你！福利已领取");
                    return;
                }
                return;
            }
        }
        if (this.f27857a) {
            ed.j(this.oq, i6 + "s后可领取奖励");
            return;
        }
        if (this.f27862l) {
            SpannableString spannableString = new SpannableString("浏览 " + i6 + "秒 获得更多福利");
            spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), spannableString.length() + (-4), spannableString.length(), 17);
            ed.j(this.oq, spannableString);
        }
    }

    private void g() {
        com.bytedance.sdk.openadsdk.core.ugeno.m.j p5 = this.up.p();
        if (p5 == null) {
            return;
        }
        int r5 = p5.r();
        if (r5 == 2) {
            r rVar = new r(this.vl, this.tj, this.f27867w, this.up, this.cw, this.f27819r);
            this.f27858f = rVar;
            rVar.jy();
            return;
        }
        if (r5 == 3) {
            xt xtVar = new xt(this.vl, this.tj, this.f27867w, this.up, this.cw, this.f27819r);
            this.f27866v = xtVar;
            xtVar.xt(false);
            this.f27866v.jy();
            if (TextUtils.equals(p5.j(), "3")) {
                return;
            }
            final ImageView imageView = new ImageView(this.vl);
            float cw = ed.cw(this.vl, 18.0f);
            float cw2 = ed.cw(this.vl, 18.0f);
            int i6 = (int) cw;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i6, i6);
            layoutParams.gravity = 53;
            int i7 = (int) cw2;
            layoutParams.setMargins(i7, i7, i7, i7);
            this.f27865s.addView(imageView, layoutParams);
            kt.j(this.vl, "tt_unmute", imageView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.ch = !r3.ch;
                    kt.j(TTNativePageActivity.this.vl, TTNativePageActivity.this.ch ? "tt_mute" : "tt_unmute", imageView);
                    TTNativePageActivity.this.f27866v.cw(TTNativePageActivity.this.ch);
                }
            });
        }
    }

    private void m() {
        this.f27862l = e.mi(this.up);
        boolean w5 = e.w(this.up);
        this.f27857a = w5;
        if (this.f27862l) {
            if (!com.bytedance.sdk.openadsdk.core.tl.r.f30514r) {
                this.f27857a = false;
            } else if (w5) {
                this.f27862l = false;
            }
        }
    }

    private boolean qv() {
        return this.f27857a || this.f27862l;
    }

    private void up() {
        n nVar = this.up;
        if (nVar == null || nVar.p() == null || this.up.p().r() != 3) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.playable.xt.j().j(this.up);
    }

    private boolean vl() {
        return n.cw(this.up);
    }

    private void xt(int i6) {
        if (vl()) {
            ed.j((View) this.f27859g, 4);
        } else {
            if (this.f27859g == null || !vl()) {
                return;
            }
            ed.j((View) this.f27859g, i6);
        }
    }

    private void oq() {
        TTViewStub tTViewStub;
        this.f27865s = (FrameLayout) findViewById(2114387640);
        this.tj = (FrameLayout) findViewById(2114387726);
        this.av = (TTViewStub) findViewById(2114387956);
        this.jy = (TTViewStub) findViewById(2114387776);
        this.ws = (TTViewStub) findViewById(2114387798);
        TTViewStub tTViewStub2 = (TTViewStub) findViewById(2114387939);
        this.az = tTViewStub2;
        if (!this.f27857a && !this.f27862l) {
            int p5 = com.bytedance.sdk.openadsdk.core.oq.i().p();
            if (p5 != 0) {
                if (p5 == 1 && (tTViewStub = this.ws) != null) {
                    tTViewStub.setVisibility(0);
                }
            } else {
                TTViewStub tTViewStub3 = this.jy;
                if (tTViewStub3 != null) {
                    tTViewStub3.setVisibility(0);
                }
            }
        } else {
            if (tTViewStub2 != null) {
                tTViewStub2.setVisibility(0);
            }
            this.f27861i = (ImageView) findViewById(2114387849);
        }
        ImageView imageView = (ImageView) findViewById(2114387711);
        this.tl = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.finish();
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387710);
        this.f27859g = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.finish();
                }
            });
        }
        this.oq = (TextView) findViewById(2114387952);
        TextView textView = (TextView) findViewById(2114387633);
        this.qv = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTNativePageActivity.this.j();
                }
            });
        }
    }

    private com.bytedance.sdk.openadsdk.core.multipro.xt.j tl() {
        String stringExtra = getIntent().getStringExtra("multi_process_data");
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                return com.bytedance.sdk.openadsdk.core.multipro.xt.j.j(new JSONObject(stringExtra));
            } catch (JSONException e6) {
                vl.j(e6);
                return null;
            }
        }
        return null;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable th) {
            vl.j(th);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.cw.j jVar = this.f27868x;
        if (jVar != null) {
            jVar.r();
        }
        xt xtVar = this.f27866v;
        if (xtVar != null) {
            xtVar.av();
        }
        up upVar = this.f27867w;
        if (upVar != null) {
            upVar.r();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.bytedance.sdk.openadsdk.core.ugeno.cw.j jVar = this.f27868x;
        if (jVar != null) {
            jVar.xt();
        }
        cw();
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        up upVar = this.f27867w;
        if (upVar != null) {
            upVar.cw();
        }
        r();
        com.bytedance.sdk.openadsdk.core.ugeno.cw.j jVar = this.f27868x;
        if (jVar != null) {
            jVar.cw();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        up upVar = this.f27867w;
        if (upVar != null) {
            upVar.j(0);
        }
        if (this.la) {
            this.la = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.gq);
                jSONObject.put("end", System.currentTimeMillis());
                com.bytedance.sdk.openadsdk.up.j.j(jSONObject, this.up);
            } catch (JSONException e6) {
                vl.j(e6);
            }
            com.bytedance.sdk.openadsdk.core.jy.cw.j(this.up, "landingpage", "agg_stay_page", new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.6
                @Override // com.bytedance.sdk.openadsdk.m.j.j
                public void j(JSONObject jSONObject2) throws JSONException {
                    jSONObject2.put("ad_extra_data", jSONObject);
                }
            });
        }
    }

    public void r() {
        if (qv() && !this.rn.hasMessages(10)) {
            this.rn.sendEmptyMessageDelayed(10, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6) {
        Intent intent;
        WeakReference<cw> weakReference;
        Intent intent2 = getIntent();
        if (intent2 == null) {
            return;
        }
        if (intent2.getBooleanExtra("is_replace_dialog", false) && (weakReference = ae) != null && weakReference.get() != null) {
            ae.get().xt(false);
            ae.get().j(uf.mi(this.up), false);
            ae = null;
        } else {
            if (n.xt(this.up) && uf.up(this.up)) {
                intent = new Intent(this, (Class<?>) TTVideoWebPageActivity.class);
            } else {
                intent = new Intent(this, (Class<?>) TTWebPageActivity.class);
            }
            intent.putExtras(intent2);
            try {
                com.bytedance.sdk.component.utils.xt.j(this.kt, intent, null);
            } catch (Throwable th) {
                vl.xt("TTNativePageActivity", th);
            }
        }
        finish();
    }

    void xt() {
        j jVar = new j(this.kt, this.up.gs(), this.cw, true);
        this.f27863m = jVar;
        com.bytedance.sdk.openadsdk.core.dislike.cw.j(this.kt, this.up, jVar);
        this.f27863m.j(new j.InterfaceC0455j() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity.7
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.j.InterfaceC0455j
            public void j() {
                TTNativePageActivity.this.cw();
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.j.InterfaceC0455j
            public void j(int i6, String str, boolean z5) {
                TTNativePageActivity.this.r();
            }

            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.j.InterfaceC0455j
            public void xt() {
                TTNativePageActivity.this.r();
            }
        });
    }

    public void cw() {
        if (qv()) {
            this.rn.removeMessages(10);
        }
    }

    protected void j() {
        if (this.up == null || isFinishing()) {
            return;
        }
        if (this.f27863m == null) {
            xt();
        }
        this.f27863m.j();
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        if (message.what == 10 && qv()) {
            int i6 = this.f27860h + 1;
            this.f27860h = i6;
            if (this.f27857a) {
                com.bytedance.sdk.openadsdk.core.tl.r.xt = i6;
            }
            int max = Math.max(0, this.f27864p - i6);
            cw(max);
            if (max <= 0 && this.f27862l) {
                com.bytedance.sdk.openadsdk.core.tl.r.f30514r = true;
            }
            this.rn.sendEmptyMessageDelayed(10, 1000L);
        }
    }

    public static void j(cw cwVar) {
        ae = new WeakReference<>(cwVar);
    }
}
