package com.bytedance.msdk.core.admanager.reward.rewardagain;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.gromore.R;
import com.bytedance.msdk.core.tl.jy;
import com.bytedance.msdk.core.up.xt.r;
import com.bytedance.msdk.tl.l;
import com.bytedance.msdk.up.m;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.stub.StubApp;
import java.lang.ref.SoftReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    private static final Map<String, xt> oq = new ConcurrentHashMap();
    private static final Map<String, com.bytedance.msdk.core.admanager.reward.rewardagain.j> qv = new ConcurrentHashMap();
    private static j vl = new j();
    private String ae;
    private com.bytedance.msdk.api.r.j.tl.j cw;

    /* renamed from: j, reason: collision with root package name */
    private final SoftReference<Context> f24435j;

    /* renamed from: m, reason: collision with root package name */
    private Object f24436m;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.msdk.api.r.j.tl.j f24437r;
    private Activity up;
    private final com.bytedance.msdk.api.j.xt xt;
    private volatile boolean tl = false;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f24434g = false;

    public static class j {
        public Runnable cw;

        /* renamed from: j, reason: collision with root package name */
        public xt f24447j;
        public Runnable xt;
    }

    private static String ae() {
        return new SimpleDateFormat("dd-MM-yyyy HH", Locale.getDefault()).format(new Date());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cw(com.bytedance.msdk.core.admanager.reward.rewardagain.j jVar, com.bytedance.msdk.xt.cw cwVar) {
        int j6 = j(this.xt, jVar, cwVar);
        m.cw(this.xt, j6);
        if (j6 == 0) {
            j();
            return;
        }
        com.bytedance.msdk.api.r.j.tl.j jVar2 = this.cw;
        if (jVar2 != null) {
            jVar2.cw();
        }
    }

    public static com.bytedance.msdk.core.admanager.reward.rewardagain.j g(String str) {
        return qv.get(str);
    }

    private static String m() {
        return new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
    }

    public static double tl(String str) {
        com.bytedance.msdk.core.admanager.reward.rewardagain.j jVar = qv.get(str);
        if (jVar != null) {
            return jVar.m();
        }
        return 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up() {
        com.bytedance.msdk.api.r.j.tl.j jVar = this.cw;
        if (jVar != null) {
            jVar.cw();
        }
        m.xt(this.xt);
    }

    public void xt(com.bytedance.msdk.api.r.j.tl.j jVar) {
        if (jVar != null) {
            this.f24437r = jVar;
        }
    }

    public cw(Context context, com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.api.r.j.tl.j jVar, com.bytedance.msdk.api.r.j.tl.j jVar2) {
        this.f24435j = new SoftReference<>(context);
        this.xt = xtVar;
        if (jVar != null) {
            this.cw = jVar;
        }
        if (jVar2 != null) {
            this.f24437r = jVar2;
        }
    }

    public static void oq(String str) {
        if (!TextUtils.isEmpty(str)) {
            qv.remove(str);
        }
    }

    public static void r(String str) {
        l j6 = l.j((String) null, com.bytedance.msdk.core.xt.getContext());
        String xt = j6.xt("ra_show_count_in_hour");
        if (!TextUtils.isEmpty(xt)) {
            try {
                JSONObject jSONObject = new JSONObject(xt);
                String ae = ae();
                JSONObject optJSONObject = jSONObject.optJSONObject(ae);
                if (optJSONObject == null) {
                    j6.j("ra_show_count_in_hour", "");
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str, optJSONObject.optInt(str, 0) + 1);
                jSONObject.put(ae, optJSONObject);
                j6.j("ra_show_count_in_hour", jSONObject.toString());
                return;
            } catch (JSONException e6) {
                vl.j(e6);
                return;
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str, 1);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(ae(), jSONObject2);
            j6.j("ra_show_count_in_hour", jSONObject3.toString());
        } catch (JSONException e7) {
            vl.j(e7);
        }
    }

    private void xt(final com.bytedance.msdk.core.admanager.reward.rewardagain.j jVar, final com.bytedance.msdk.xt.cw cwVar) {
        j jVar2 = new j();
        vl = jVar2;
        jVar2.f24447j = oq.get(jVar.r());
        vl.xt = new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.cw.3
            @Override // java.lang.Runnable
            public void run() {
                cw.this.cw(jVar, cwVar);
                cw.tl();
            }
        };
        vl.cw = new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.cw.4
            @Override // java.lang.Runnable
            public void run() {
                cw.this.up();
                cw.tl();
            }
        };
        Intent intent = new Intent(com.bytedance.msdk.core.xt.getContext(), (Class<?>) GMRewardAgainDialogActivity.class);
        intent.setFlags(268435456);
        com.bytedance.msdk.core.xt.getContext().startActivity(intent);
    }

    public static double ae(String str) {
        com.bytedance.msdk.core.admanager.reward.rewardagain.j jVar = qv.get(str);
        if (jVar == null) {
            return -1.0d;
        }
        double cw = jVar.cw();
        if (cw < 0.0d || cw > 1.0d) {
            return -1.0d;
        }
        return cw;
    }

    public static long m(String str) {
        String xt = l.j((String) null, com.bytedance.msdk.core.xt.getContext()).xt("ra_play_rit_ts");
        try {
            if (!TextUtils.isEmpty(xt)) {
                return new JSONObject(xt).optLong(str, -1L);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tl() {
        j jVar = vl;
        jVar.f24447j = null;
        jVar.xt = null;
        jVar.cw = null;
    }

    public void j(Activity activity, Object obj, String str) {
        this.up = activity;
        this.f24436m = obj;
        this.ae = str;
    }

    public static void up(String str) {
        JSONObject jSONObject;
        l j6 = l.j((String) null, com.bytedance.msdk.core.xt.getContext());
        String xt = j6.xt("ra_play_rit_ts");
        try {
            if (TextUtils.isEmpty(xt)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(xt);
            }
            jSONObject.put(str, System.currentTimeMillis());
            j6.j("ra_play_rit_ts", jSONObject.toString());
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    public static int cw(String str) {
        String xt = l.j((String) null, com.bytedance.msdk.core.xt.getContext()).xt("ra_show_count_in_hour");
        if (!TextUtils.isEmpty(xt)) {
            try {
                JSONObject optJSONObject = new JSONObject(xt).optJSONObject(ae());
                if (optJSONObject != null) {
                    return optJSONObject.optInt(str, 0);
                }
            } catch (JSONException e6) {
                vl.j(e6);
            }
        }
        return 0;
    }

    public void j(com.bytedance.msdk.api.r.j.tl.j jVar) {
        if (jVar != null) {
            this.cw = jVar;
        }
    }

    public void j(final com.bytedance.msdk.core.admanager.reward.rewardagain.j jVar, final com.bytedance.msdk.xt.cw cwVar) {
        Activity activity = this.up;
        if (activity != null && !activity.isFinishing() && !this.up.isDestroyed()) {
            final Dialog dialog = new Dialog(this.up);
            View inflate = LayoutInflater.from(StubApp.getOrigApplicationContext(this.up.getApplicationContext())).inflate(R.layout.reward_again_dialog, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.ra_pic);
            TextView textView = (TextView) inflate.findViewById(R.id.ra_title);
            TextView textView2 = (TextView) inflate.findViewById(R.id.ra_btn_ok);
            TextView textView3 = (TextView) inflate.findViewById(R.id.ra_btn_cancel);
            xt xtVar = oq.get(jVar.r());
            if (xtVar != null) {
                textView.setText(xtVar.xt());
                textView2.setText(xtVar.r());
                textView3.setText(xtVar.up());
                if (!TextUtils.isEmpty(xtVar.cw())) {
                    new com.bytedance.msdk.j.up.xt(imageView).j((Object[]) new String[]{xtVar.cw()});
                }
            }
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.cw.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    cw.this.cw(jVar, cwVar);
                    dialog.dismiss();
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.cw.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    cw.this.up();
                    dialog.dismiss();
                }
            });
            dialog.setContentView(inflate);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);
            dialog.show();
            return;
        }
        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==-- reward again show activity dialog");
        xt(jVar, cwVar);
    }

    public void xt() {
        this.f24434g = true;
    }

    public static void xt(String str) {
        l j6 = l.j((String) null, com.bytedance.msdk.core.xt.getContext());
        String xt = j6.xt("ra_show_count");
        if (!TextUtils.isEmpty(xt)) {
            try {
                JSONObject jSONObject = new JSONObject(xt);
                String m6 = m();
                JSONObject optJSONObject = jSONObject.optJSONObject(m6);
                if (optJSONObject == null) {
                    j6.j("ra_show_count", "");
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put(str, optJSONObject.optInt(str, 0) + 1);
                jSONObject.put(m6, optJSONObject);
                j6.j("ra_show_count", jSONObject.toString());
                return;
            } catch (JSONException e6) {
                vl.j(e6);
                return;
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str, 1);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(m(), jSONObject2);
            j6.j("ra_show_count", jSONObject3.toString());
        } catch (JSONException e7) {
            vl.j(e7);
        }
    }

    public static j cw() {
        return vl;
    }

    public void j() {
        Context context = this.f24435j.get();
        if (context != null) {
            this.xt.up(1);
            final com.bytedance.msdk.cw.r.vl vlVar = new com.bytedance.msdk.cw.r.vl(context);
            j(vlVar);
            vlVar.j(this.xt, new com.bytedance.msdk.api.r.j.tl.xt() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.cw.5
                @Override // com.bytedance.msdk.api.r.j.tl.xt
                public void j(com.bytedance.msdk.api.j jVar) {
                    if (cw.this.tl) {
                        return;
                    }
                    cw.this.tl = true;
                    if (cw.this.cw != null) {
                        cw.this.cw.cw();
                    }
                }

                @Override // com.bytedance.msdk.api.r.j.tl.xt
                public void xt() {
                    if (cw.this.tl) {
                        return;
                    }
                    cw.this.tl = true;
                    vlVar.j(cw.this.up, cw.this.f24436m, cw.this.ae);
                }

                @Override // com.bytedance.msdk.api.r.j.tl.xt
                public void j() {
                    if (cw.this.tl) {
                        return;
                    }
                    cw.this.tl = true;
                    vlVar.j(cw.this.up, cw.this.f24436m, cw.this.ae);
                }
            });
            com.bytedance.msdk.j.up.m.xt(new Runnable() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.cw.6
                @Override // java.lang.Runnable
                public void run() {
                    if (cw.this.tl) {
                        return;
                    }
                    cw.this.tl = true;
                    if (cw.this.cw != null) {
                        cw.this.cw.cw();
                    }
                }
            }, 500L);
        }
    }

    private void j(com.bytedance.msdk.cw.r.vl vlVar) {
        vlVar.j(new com.bytedance.msdk.api.r.j.tl.j() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.cw.7
            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void j(@NonNull com.bytedance.msdk.api.j jVar) {
                if (cw.this.f24437r != null) {
                    cw.this.f24437r.j(jVar);
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void cw() {
                if (cw.this.cw != null) {
                    cw.this.cw.cw();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void i_() {
                String v5 = cw.this.xt != null ? cw.this.xt.v() : "";
                cw.xt(v5);
                cw.r(v5);
                cw.up(v5);
                if (cw.this.f24437r != null) {
                    cw.this.f24437r.i_();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void j_() {
                if (cw.this.f24437r != null) {
                    cw.this.f24437r.j_();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void m() {
                if (cw.this.f24437r != null) {
                    cw.this.f24437r.m();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void r() {
                if (cw.this.f24437r != null) {
                    cw.this.f24437r.r();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void up() {
                if (cw.this.f24437r != null) {
                    cw.this.f24437r.up();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void j(@NonNull com.bytedance.msdk.api.cw.j jVar) {
                if (cw.this.f24437r != null) {
                    cw.this.f24437r.j(jVar);
                }
            }
        });
        vlVar.xt(new com.bytedance.msdk.api.r.j.tl.j() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.cw.8
            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void j(@NonNull com.bytedance.msdk.api.j jVar) {
                if (cw.this.f24437r != null) {
                    cw.this.f24437r.j(jVar);
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void cw() {
                if (cw.this.cw != null) {
                    cw.this.cw.cw();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void i_() {
                if (cw.this.f24437r != null) {
                    cw.this.f24437r.i_();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void j_() {
                if (cw.this.f24437r != null) {
                    cw.this.f24437r.j_();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void m() {
                if (cw.this.f24437r != null) {
                    cw.this.f24437r.m();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void r() {
                if (cw.this.f24437r != null) {
                    cw.this.f24437r.r();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void up() {
                if (cw.this.f24437r != null) {
                    cw.this.f24437r.up();
                }
            }

            @Override // com.bytedance.msdk.api.r.j.tl.j
            public void j(@NonNull com.bytedance.msdk.api.cw.j jVar) {
                if (cw.this.f24437r != null) {
                    cw.this.f24437r.j(jVar);
                }
            }
        });
    }

    public int j(com.bytedance.msdk.api.j.xt xtVar, com.bytedance.msdk.core.admanager.reward.rewardagain.j jVar, com.bytedance.msdk.xt.cw cwVar) {
        if (!this.f24434g) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==--ra: 还未触发rewardVerify");
            return 1;
        }
        String v5 = xtVar.v();
        int up = jVar.up();
        int j6 = j(v5);
        if (j6 >= up) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==--ra: 激励再得展示次数超过天级别限制，限制: " + up + ", 已经展示: " + j6);
            return 2;
        }
        if (oq.get(jVar.r()) == null) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==--ra: 激励再得样式为空");
            return 3;
        }
        if (com.bytedance.msdk.core.ae.j.j().xt()) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==--ra: 命中请求熔断");
            return 4;
        }
        if (!jy.j().tl(v5)) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==--ra: 命中展示频控");
            return 5;
        }
        if (!jy.j().cw(v5)) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==--ra: 命中展示间隔");
            return 6;
        }
        double xt = r.j().xt(v5, xtVar);
        if (xt <= -1.0d) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==--ra: 激励再得无缓存可用");
            return 7;
        }
        if (xt < tl(v5)) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==--ra: 激励再得有缓存，但是ecpm不符合");
            return 8;
        }
        int j7 = jVar.j();
        int cw = cw(v5);
        if (cw >= j7) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==--ra: 激励再得展示次数超过小时级别限制，限制: " + j7 + ", 已经展示: " + cw);
            return 9;
        }
        long xt2 = jVar.xt();
        long m6 = m(v5);
        long currentTimeMillis = System.currentTimeMillis() - m6;
        if (m6 != -1 && currentTimeMillis < xt2) {
            com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==--ra: 激励再得展示间隔超过限制，config间隔: " + xt2 + ", 实际间隔: " + currentTimeMillis);
            return 10;
        }
        double ae = ae(v5);
        if (cwVar == null || ae == -1.0d || xt >= cwVar.t() * ae) {
            return 0;
        }
        com.bytedance.msdk.j.up.cw.j(MediationConstant.TAG, "--==--ra: 激励再得ecpm下探期间不满足");
        return 11;
    }

    public static int j(String str) {
        String xt = l.j((String) null, com.bytedance.msdk.core.xt.getContext()).xt("ra_show_count");
        if (!TextUtils.isEmpty(xt)) {
            try {
                JSONObject optJSONObject = new JSONObject(xt).optJSONObject(m());
                if (optJSONObject != null) {
                    return optJSONObject.optInt(str, 0);
                }
            } catch (JSONException e6) {
                vl.j(e6);
            }
        }
        return 0;
    }

    public static void j(String str, com.bytedance.msdk.core.admanager.reward.rewardagain.j jVar) {
        if (TextUtils.isEmpty(str) || jVar == null) {
            return;
        }
        qv.put(str, jVar);
    }

    public static void j(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i6);
            if (optJSONObject != null) {
                xt xtVar = new xt();
                xtVar.j(optJSONObject.optString("ra_id"));
                xtVar.xt(optJSONObject.optString("title"));
                xtVar.cw(optJSONObject.optString("pic_url"));
                xtVar.r(optJSONObject.optString("btn_ok"));
                xtVar.up(optJSONObject.optString("btn_cancel"));
                oq.put(xtVar.j(), xtVar);
            }
        }
    }
}
