package com.bytedance.sdk.openadsdk.core.activity.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.utils.xt;
import com.bytedance.sdk.openadsdk.core.dislike.ui.j;
import com.bytedance.sdk.openadsdk.core.kt;
import com.bytedance.sdk.openadsdk.core.qv.r.jy;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.m;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.ugeno.ae.ae;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.widget.ae;
import com.bytedance.sdk.openadsdk.core.widget.av;
import com.bytedance.sdk.openadsdk.core.widget.cw;
import com.bytedance.sdk.openadsdk.core.widget.g;
import com.bytedance.sdk.openadsdk.core.widget.oq;
import com.bytedance.sdk.openadsdk.core.widget.qv;
import com.bytedance.sdk.openadsdk.core.widget.r;
import com.bytedance.sdk.openadsdk.core.widget.tl;
import com.bytedance.sdk.openadsdk.core.widget.up;
import com.bytedance.sdk.openadsdk.core.widget.xt;
import com.stub.StubApp;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class TTDelegateActivity extends Activity {
    private static ae av;

    /* renamed from: i, reason: collision with root package name */
    private static String f27820i;

    /* renamed from: j, reason: collision with root package name */
    public static n f27821j;

    /* renamed from: w, reason: collision with root package name */
    private static String f27822w;
    private up ae;
    private av az;
    private AlertDialog cw;

    /* renamed from: g, reason: collision with root package name */
    private tl f27823g;
    private qv jy;

    /* renamed from: m, reason: collision with root package name */
    private r f27824m;
    private Activity oq;
    private cw qv;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.dislike.ui.j f27825r;
    private Dialog tl;
    private oq up;
    private xt vl;
    private g ws;
    private Intent xt;

    static {
        StubApp.interface11(22631);
    }

    private void m(String str) {
        if (ed.g(this.oq)) {
            if (str != null && this.f27825r == null) {
                try {
                    n j6 = com.bytedance.sdk.openadsdk.core.j.j(new JSONObject(str));
                    if (j6 != null) {
                        com.bytedance.sdk.openadsdk.core.dislike.ui.j jVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.j(this.oq, j6.gs(), false);
                        this.f27825r = jVar;
                        com.bytedance.sdk.openadsdk.core.dislike.cw.j(this.oq, j6, jVar);
                        this.f27825r.j(new j.InterfaceC0455j() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.6
                            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.j.InterfaceC0455j
                            public void j() {
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.j.InterfaceC0455j
                            public void j(int i6, String str2, boolean z5) {
                                TTDelegateActivity.this.finish();
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.j.InterfaceC0455j
                            public void xt() {
                                TTDelegateActivity.this.finish();
                            }
                        });
                    }
                } catch (JSONException e6) {
                    vl.j(e6);
                }
            }
            com.bytedance.sdk.openadsdk.core.dislike.ui.j jVar2 = this.f27825r;
            if (jVar2 != null) {
                jVar2.j();
            }
        }
    }

    private void up() {
        try {
            Intent intent = this.xt;
            if (intent != null) {
                int intExtra = intent.getIntExtra("type", 0);
                String stringExtra = this.xt.getStringExtra("app_download_url");
                this.xt.getStringExtra("app_name");
                try {
                    try {
                        switch (intExtra) {
                            case 1:
                                break;
                            case 2:
                                m();
                                break;
                            case 3:
                                cw(stringExtra, this.xt.getStringExtra("dialog_title"), this.xt.getStringExtra("dialog_content_key"));
                                break;
                            case 4:
                                xt(this.xt.getStringExtra("permission_id_key"), this.xt.getStringArrayExtra("permission_content_key"));
                                break;
                            case 5:
                                xt(stringExtra, this.xt.getStringExtra("dialog_title"), this.xt.getStringExtra("dialog_content_key"), this.xt.getStringExtra("dialog_btn_yes_key"), this.xt.getStringExtra("dialog_btn_no_key"));
                                break;
                            case 6:
                                m(this.xt.getStringExtra("materialmeta"));
                                break;
                            case 7:
                                cw(stringExtra);
                                break;
                            case 8:
                                j(this.xt.getStringExtra("dialog_app_manage_model"), stringExtra);
                                break;
                            case 9:
                                cw(this.xt.getStringExtra("dialog_app_privacy_url"), stringExtra);
                                break;
                            case 10:
                                xt(this.xt.getStringExtra("dialog_content_key"));
                                break;
                            case 11:
                                up(this.xt.getStringExtra("dialog_app_ad_info"));
                                break;
                            case 12:
                                xt(this.xt.getStringExtra("web_url"), this.xt.getStringExtra("web_title"));
                                break;
                            case 13:
                                xt();
                                break;
                            case 14:
                                j(this.xt.getStringExtra("dialog_app_desc_url"), stringExtra, 1, true, (Dialog) null);
                                break;
                            case 15:
                                j(this.xt.getStringExtra("web_url"));
                                break;
                            case 16:
                                j(this.xt.getStringExtra("dialog_app_registration_url"), stringExtra, 3, true, (Dialog) null);
                                break;
                            default:
                                finish();
                                break;
                        }
                    } catch (Exception unused) {
                        finish();
                    }
                } catch (Exception unused2) {
                    finish();
                }
            }
        } catch (Exception unused3) {
        }
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            f27821j = null;
            AlertDialog alertDialog = this.cw;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.cw.dismiss();
            }
            tl tlVar = this.f27823g;
            if (tlVar == null || !tlVar.isShowing()) {
                m.j(f27820i);
            } else {
                m.j(this.f27823g.j());
                if (this.f27823g.isShowing()) {
                    this.f27823g.dismiss();
                }
            }
            r rVar = this.f27824m;
            if (rVar != null && rVar.isShowing()) {
                this.f27824m.dismiss();
            }
            cw cwVar = this.qv;
            if (cwVar != null) {
                if (cwVar.isShowing()) {
                    this.qv.dismiss();
                }
                m.j(this.qv.r());
            } else {
                m.j(f27822w);
            }
            xt xtVar = this.vl;
            if (xtVar != null && xtVar.isShowing()) {
                this.vl.dismiss();
            }
            up upVar = this.ae;
            if (upVar != null && upVar.isShowing()) {
                this.ae.dismiss();
            }
            qv qvVar = this.jy;
            if (qvVar != null && qvVar.isShowing()) {
                this.jy.dismiss();
            }
            Dialog dialog = this.tl;
            if (dialog != null && dialog.isShowing()) {
                this.tl.dismiss();
            }
            f27820i = null;
            f27822w = null;
        } catch (Throwable th) {
            vl.cw("dialog", "onDestroy", th);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public native void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr);

    public static class j extends com.bytedance.sdk.component.oq.g {
        public j(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.core.qv.r.r r5 = jy.r();
            if (r5 != null) {
                Function<SparseArray<Object>, Object> gx = com.bytedance.sdk.openadsdk.core.oq.i().gx();
                if (gx != null) {
                    r5.j(com.bytedance.sdk.openadsdk.i.cw.xt(gx).booleanValue(1));
                }
                kt.ws();
            }
        }
    }

    public static void cw(Context context, String str, String str2) {
        if (context == null) {
            context = v.getContext();
        }
        Intent j6 = j(context);
        j6.putExtra("type", 14);
        j6.putExtra("dialog_app_desc_url", str2);
        j6.putExtra("app_download_url", str);
        com.bytedance.sdk.component.utils.xt.j(context, j6, null);
    }

    public static void r(Context context, String str, String str2) {
        if (context == null) {
            context = v.getContext();
        }
        Intent j6 = j(context);
        j6.putExtra("type", 12);
        j6.putExtra("web_url", str);
        j6.putExtra("web_title", str2);
        com.bytedance.sdk.component.utils.xt.j(context, j6, null);
    }

    public static void xt(Context context, String str, String str2) {
        if (context == null) {
            context = v.getContext();
        }
        com.bytedance.sdk.openadsdk.core.tj.m r5 = r(str2);
        if (r5 == null) {
            return;
        }
        Intent j6 = j(context);
        j6.putExtra("type", 9);
        j6.putExtra("dialog_app_privacy_url", r5.tl());
        j6.putExtra("app_download_url", str);
        com.bytedance.sdk.component.utils.xt.j(context, j6, null);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        cw cwVar = this.qv;
        if (cwVar != null && !cwVar.isShowing()) {
            this.qv.j();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (v.getContext() == null) {
            v.j(this.oq);
        }
        try {
            setIntent(intent);
            this.xt = intent;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        tl tlVar = this.f27823g;
        if (tlVar != null) {
            f27820i = tlVar.j();
        }
        cw cwVar = this.qv;
        if (cwVar != null) {
            f27822w = cwVar.r();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (getIntent() != null) {
            up();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        cw();
    }

    public static void j(String str, String[] strArr) {
        Intent intent = new Intent(v.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 4);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (v.getContext() != null) {
            com.bytedance.sdk.component.utils.xt.j(v.getContext(), intent, new xt.j() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.1
                @Override // com.bytedance.sdk.component.utils.xt.j
                public void j() {
                }

                @Override // com.bytedance.sdk.component.utils.xt.j
                public void j(Throwable th) {
                    vl.cw("requestPermission->startActivity error :" + th.toString());
                }
            });
        }
    }

    private void cw() {
        if (com.bytedance.sdk.openadsdk.core.oq.i().ya()) {
            if (this.qv == null && this.f27823g == null && this.jy == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.oq.i().g(false);
            finish();
        }
    }

    private void r() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jy.cw.j(str, "click_other", str3, str2, new com.bytedance.sdk.openadsdk.m.j.j() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.12
            @Override // com.bytedance.sdk.openadsdk.m.j.j
            public void j(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("refer", "reg");
                jSONObject.put("ad_extra_data", jSONObject2);
            }
        });
    }

    private void m() {
        ApplicationInfo applicationInfo;
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 23) {
            try {
                com.bytedance.sdk.openadsdk.i.cw.cw.r kt = com.bytedance.sdk.openadsdk.core.oq.i().kt();
                boolean cw = kt.cw();
                boolean up = kt.up();
                ArrayList arrayList = new ArrayList();
                com.bytedance.sdk.openadsdk.av.xt.j(kt, arrayList);
                if (cw) {
                    arrayList.add(com.kuaishou.weapon.p0.g.f36043c);
                }
                if (up) {
                    arrayList.add(com.kuaishou.weapon.p0.g.f36050j);
                }
                Context context = v.getContext();
                if (context != null && (applicationInfo = context.getApplicationInfo()) != null && applicationInfo.targetSdkVersion >= 33 && i6 >= 33) {
                    arrayList.add("android.permission.POST_NOTIFICATIONS");
                }
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                com.bytedance.sdk.openadsdk.core.x.up.j().j(this.oq, strArr, new com.bytedance.sdk.openadsdk.core.x.m() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.14
                    @Override // com.bytedance.sdk.openadsdk.core.x.m
                    public void j() {
                        com.bytedance.sdk.component.oq.ae.j(new j("checkNecessaryPermission"), 1);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.x.m
                    public void j(String str) {
                        com.kuaishou.weapon.p0.g.f36043c.equals(str);
                        com.bytedance.sdk.component.oq.ae.j(new j("checkNecessaryPermission"), 1);
                        TTDelegateActivity.this.finish();
                    }
                });
                return;
            } catch (Exception unused) {
            }
        }
        finish();
    }

    public static void xt(Context context, String str) {
        if (context == null) {
            context = v.getContext();
        }
        Intent j6 = j(context);
        j6.putExtra("type", 11);
        j6.putExtra("dialog_app_ad_info", str);
        com.bytedance.sdk.component.utils.xt.j(context, j6, null);
    }

    private void cw(final String str) {
        JSONArray jSONArray;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        float f6;
        boolean z5;
        String str7;
        String str8;
        String str9;
        String str10;
        float f7;
        boolean z6;
        Intent intent = this.xt;
        if (intent == null) {
            return;
        }
        final String stringExtra = intent.getStringExtra("event_extInfo");
        final String stringExtra2 = this.xt.getStringExtra("event_adId");
        final String stringExtra3 = this.xt.getStringExtra("event_TAG");
        String stringExtra4 = this.xt.getStringExtra("dialog_app_manage_model");
        String stringExtra5 = this.xt.getStringExtra("dialog_title");
        final String stringExtra6 = this.xt.getStringExtra("dialog_icon_url");
        final String stringExtra7 = this.xt.getStringExtra("dialog_app_description");
        boolean booleanExtra = this.xt.getBooleanExtra("is_easy_dl_dialog_pop_up_style", false);
        try {
            JSONArray jSONArray2 = null;
            String str11 = "";
            if (TextUtils.isEmpty(stringExtra4)) {
                jSONArray = null;
                str2 = null;
                str3 = "";
                str4 = str3;
                str5 = str4;
                str6 = str5;
                f6 = 0.0f;
                z5 = false;
            } else {
                JSONObject jSONObject = new JSONObject(stringExtra4);
                com.bytedance.sdk.openadsdk.core.tj.m up = com.bytedance.sdk.openadsdk.core.j.up(jSONObject);
                if (up != null) {
                    String up2 = up.up();
                    String ae = up.ae();
                    String oq = up.oq();
                    String ws = up.ws();
                    if (!TextUtils.isEmpty(ws)) {
                        stringExtra5 = ws;
                    }
                    JSONArray r5 = up.r();
                    f7 = up.cw();
                    str7 = up.qv();
                    str11 = stringExtra5;
                    str8 = up2;
                    str9 = ae;
                    jSONArray2 = r5;
                    str10 = oq;
                } else {
                    str7 = null;
                    str8 = "";
                    str9 = str8;
                    str10 = str9;
                    f7 = 0.0f;
                }
                String optString = jSONObject.optString("ugen_url");
                String optString2 = jSONObject.optString("ugen_md5");
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                    z6 = false;
                } else {
                    jSONObject.put("app_name", str11);
                    jSONObject.put("icon_url", stringExtra6);
                    jSONObject.put(SocialConstants.PARAM_COMMENT, stringExtra7);
                    stringExtra4 = jSONObject.toString();
                    z6 = true;
                }
                String optString3 = jSONObject.optString("hand_icon_url");
                float f8 = f7;
                str6 = optString3;
                f6 = f8;
                z5 = z6;
                jSONArray = jSONArray2;
                str3 = str11;
                str11 = str9;
                str2 = str7;
                str5 = str10;
                str4 = str8;
            }
            final String str12 = stringExtra4;
            if (booleanExtra) {
                j(str, str12, stringExtra6, stringExtra7, str4, str11, str3, jSONArray, f6, str5, str2, stringExtra, stringExtra3, stringExtra2);
                return;
            }
            final String str13 = str4;
            final JSONArray jSONArray3 = jSONArray;
            final String str14 = str11;
            final String str15 = str5;
            final String str16 = str2;
            final float f9 = f6;
            if (z5) {
                final String str17 = str3;
                final String str18 = str6;
                j(str, str12, new ae() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.18
                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.ae
                    public void j(int i6, String str19) {
                        TTDelegateActivity.this.j(str, str12, stringExtra6, f9, stringExtra7, str18, jSONArray3, str13, str14, str17, str15, str16, stringExtra2, stringExtra3, stringExtra);
                        if (TTDelegateActivity.this.f27823g != null) {
                            TTDelegateActivity.this.f27823g.j((ae) null);
                        }
                        if (TTDelegateActivity.av != null) {
                            TTDelegateActivity.av.j(i6, str19);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.ae
                    public void j(com.bytedance.adsdk.ugeno.xt.cw<View> cwVar) {
                        if (TTDelegateActivity.av != null) {
                            TTDelegateActivity.av.j(null);
                        }
                    }
                }, stringExtra2, stringExtra3, stringExtra);
            } else {
                j(str, str12, stringExtra6, f9, stringExtra7, str6, jSONArray3, str13, str14, str3, str15, str16, stringExtra2, stringExtra3, stringExtra);
            }
        } catch (Throwable unused) {
        }
    }

    private static com.bytedance.sdk.openadsdk.core.tj.m r(String str) {
        try {
            return com.bytedance.sdk.openadsdk.core.j.up(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static void j(Context context, String str, String str2, String str3) {
        if (context == null) {
            context = v.getContext();
        }
        Intent j6 = j(context);
        j6.putExtra("type", 3);
        j6.putExtra("app_download_url", str);
        j6.putExtra("dialog_title", str2);
        j6.putExtra("dialog_content_key", str3);
        com.bytedance.sdk.component.utils.xt.j(context, j6, null);
    }

    private void xt() {
        try {
            if (this.ws == null) {
                this.ws = new g(this.oq, getIntent());
            }
            if (this.ws.isShowing()) {
                this.ws.dismiss();
            }
            this.ws.j(new g.j() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.15
                @Override // com.bytedance.sdk.openadsdk.core.widget.g.j
                public void j(Dialog dialog) {
                    TTDelegateActivity.this.finish();
                }
            });
            this.ws.show();
        } catch (Throwable unused) {
        }
    }

    private static Intent j(Context context) {
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        return intent;
    }

    private void xt(String str) {
        try {
            if (ed.g(this.oq)) {
                Dialog dialog = this.tl;
                if (dialog == null || !dialog.isShowing()) {
                    com.bytedance.sdk.openadsdk.core.widget.j jVar = new com.bytedance.sdk.openadsdk.core.widget.j(this.oq, str);
                    this.tl = jVar;
                    jVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.17
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            TTDelegateActivity.this.finish();
                        }
                    });
                    this.tl.show();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void j(ae aeVar) {
        av = aeVar;
    }

    public static void j(Context context, String str, String str2, String str3, ae aeVar, n nVar) {
        try {
            f27821j = nVar;
            av = aeVar;
            if (context == null) {
                context = v.getContext();
            }
            Intent j6 = j(context);
            JSONObject jSONObject = new JSONObject(str3);
            j6.putExtra("type", 7);
            j6.putExtra("app_download_url", str);
            j6.putExtra("dialog_app_manage_model", str2);
            if (nVar != null) {
                j6.putExtra("event_adId", nVar.fs());
                j6.putExtra("event_extInfo", nVar.os());
                j6.putExtra("event_TAG", uf.xt(nVar));
            }
            j6.putExtra("dialog_title", jSONObject.optString("dialog_title"));
            j6.putExtra("dialog_icon_url", jSONObject.optString("dialog_icon_url"));
            j6.putExtra("dialog_app_description", jSONObject.optString("dialog_app_description"));
            j6.putExtra("is_easy_dl_dialog_pop_up_style", jSONObject.optBoolean("is_easy_dl_dialog_pop_up_style"));
            com.bytedance.sdk.component.utils.xt.j(context, j6, null);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    private void xt(String str, String str2) {
        try {
            if (ed.g(this.oq)) {
                r rVar = this.f27824m;
                if (rVar != null) {
                    rVar.dismiss();
                }
                r rVar2 = new r(this.oq, str, str2);
                this.f27824m = rVar2;
                rVar2.j(new r.j() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.2
                    @Override // com.bytedance.sdk.openadsdk.core.widget.r.j
                    public void j(Dialog dialog) {
                        if (TTDelegateActivity.this.f27824m != null) {
                            TTDelegateActivity.this.f27824m.dismiss();
                            TTDelegateActivity.this.finish();
                        }
                    }
                });
                this.f27824m.show();
            }
        } catch (Throwable unused) {
        }
    }

    private void xt(final String str, String str2, String str3, String str4, String str5) {
        if (ed.g(this.oq)) {
            AlertDialog alertDialog = this.cw;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            if (this.up == null) {
                this.up = new oq(this.oq).j(str2).xt(str3).cw(str4).r(str5).j(new oq.j() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.8
                    @Override // com.bytedance.sdk.openadsdk.core.widget.oq.j
                    public void onClickNo(Dialog dialog) {
                        m.cw(str);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.oq.j
                    public void onClickYes(Dialog dialog) {
                        m.xt(str);
                        TTDelegateActivity.this.finish();
                    }
                }).j(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.7
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        m.r(str);
                        TTDelegateActivity.this.finish();
                    }
                });
            }
            if (!this.up.isShowing()) {
                this.up.show();
            }
            this.cw = this.up;
        }
    }

    private void up(String str) {
        try {
            if (ed.g(this.oq)) {
                qv qvVar = this.jy;
                if (qvVar != null) {
                    qvVar.dismiss();
                }
                qv qvVar2 = new qv(this.oq, str);
                this.jy = qvVar2;
                qvVar2.j(new qv.j() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.4
                    @Override // com.bytedance.sdk.openadsdk.core.widget.qv.j
                    public void j(Dialog dialog) {
                        TTDelegateActivity.this.finish();
                    }
                });
                this.jy.show();
            }
        } catch (Throwable unused) {
        }
    }

    public static void j(Context context, String str, String str2, String str3, n nVar) {
        if (context == null) {
            try {
                context = v.getContext();
            } catch (Exception e6) {
                vl.j(e6);
                return;
            }
        }
        Intent j6 = j(context);
        JSONObject jSONObject = new JSONObject(str3);
        j6.putExtra("type", 7);
        j6.putExtra("app_download_url", str);
        j6.putExtra("dialog_app_manage_model", str2);
        if (nVar != null) {
            j6.putExtra("event_adId", nVar.fs());
            j6.putExtra("event_extInfo", nVar.os());
            j6.putExtra("event_TAG", uf.xt(nVar));
        }
        j6.putExtra("dialog_title", jSONObject.optString("dialog_title"));
        j6.putExtra("dialog_icon_url", jSONObject.optString("dialog_icon_url"));
        j6.putExtra("dialog_app_description", jSONObject.optString("dialog_app_description"));
        j6.putExtra("is_easy_dl_dialog_pop_up_style", jSONObject.optBoolean("is_easy_dl_dialog_pop_up_style"));
        com.bytedance.sdk.component.utils.xt.j(context, j6, null);
    }

    private void cw(String str, String str2) {
        if (this.xt == null) {
            return;
        }
        j(str, str2, 2, true, (Dialog) null);
    }

    private void cw(final String str, String str2, String str3) {
        if (ed.g(this.oq)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = com.bytedance.sdk.component.utils.kt.j(this.oq, "tt_tip");
            }
            String str4 = str2;
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            j(str4, str3, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.10
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i6) {
                    m.xt(str);
                    TTDelegateActivity.this.finish();
                }
            }, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.11
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i6) {
                    m.cw(str);
                    TTDelegateActivity.this.finish();
                }
            }, new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.13
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    m.r(str);
                    TTDelegateActivity.this.finish();
                }
            });
        }
    }

    private void xt(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    com.bytedance.sdk.openadsdk.core.x.up.j().j(this.oq, strArr, new com.bytedance.sdk.openadsdk.core.x.m() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.9
                        @Override // com.bytedance.sdk.openadsdk.core.x.m
                        public void j() {
                            com.bytedance.sdk.openadsdk.core.rn.ae.j(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.x.m
                        public void j(String str2) {
                            com.bytedance.sdk.openadsdk.core.rn.ae.j(str, str2);
                            TTDelegateActivity.this.finish();
                        }
                    });
                    return;
                } catch (Exception unused) {
                }
            }
            finish();
            return;
        }
        finish();
    }

    public static void j(Context context, String str, String str2) {
        if (context == null) {
            context = v.getContext();
        }
        Intent j6 = j(context);
        j6.putExtra("type", 8);
        j6.putExtra("app_download_url", str);
        j6.putExtra("dialog_app_manage_model", str2);
        com.bytedance.sdk.component.utils.xt.j(context, j6, null);
    }

    public static void j(Context context, String str) {
        if (context == null) {
            context = v.getContext();
        }
        Intent j6 = j(context);
        j6.putExtra("type", 10);
        j6.putExtra("dialog_content_key", str);
        com.bytedance.sdk.component.utils.xt.j(context, j6, null);
    }

    public static void j(Context context, String str, String str2, n nVar) {
        if (context == null) {
            context = v.getContext();
        }
        com.bytedance.sdk.openadsdk.core.tj.m r5 = r(str2);
        if (r5 == null) {
            return;
        }
        if (nVar != null) {
            xt(uf.xt(nVar), nVar.os(), nVar.fs());
        }
        Intent j6 = j(context);
        j6.putExtra("type", 16);
        j6.putExtra("dialog_app_registration_url", r5.qv());
        j6.putExtra("app_download_url", str);
        com.bytedance.sdk.component.utils.xt.j(context, j6, null);
    }

    public static void j(Context context, String str, String str2, String str3, String str4, String str5) {
        if (context == null) {
            context = v.getContext();
        }
        Intent j6 = j(context);
        j6.putExtra("type", 5);
        j6.putExtra("app_download_url", str);
        j6.putExtra("dialog_title", str2);
        j6.putExtra("dialog_content_key", str3);
        j6.putExtra("dialog_btn_yes_key", str4);
        j6.putExtra("dialog_btn_no_key", str5);
        com.bytedance.sdk.component.utils.xt.j(context, j6, null);
    }

    public static void j(Context context, n nVar) {
        JSONObject tv2;
        if (context == null) {
            context = v.getContext();
        }
        Intent j6 = j(context);
        j6.putExtra("type", 6);
        if (nVar != null && (tv2 = nVar.tv()) != null) {
            j6.putExtra("materialmeta", tv2.toString());
        }
        if (context != null) {
            try {
                context.startActivity(j6);
            } catch (Throwable unused) {
            }
        }
    }

    public void j(String str) {
        if (this.az == null) {
            this.az = new av(this.oq, str);
        }
        if (this.az.isShowing()) {
            this.az.dismiss();
        }
        this.az.j(new av.j() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.16
            @Override // com.bytedance.sdk.openadsdk.core.widget.av.j
            public void j(String str2) {
                m.xt(str2);
                TTDelegateActivity.this.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.av.j
            public void xt(String str2) {
                m.r(str2);
                TTDelegateActivity.this.finish();
            }
        });
        this.az.show();
    }

    public static void j(Context context, String str, boolean z5) {
        if (context == null) {
            context = v.getContext();
        }
        Intent j6 = j(context);
        j6.putExtra("type", 15);
        if (!z5) {
            j6.putExtra("web_url", str);
        }
        com.bytedance.sdk.component.utils.xt.j(context, j6, null);
    }

    public static void j(Context context, String str, n nVar) {
        if (context == null) {
            context = v.getContext();
        }
        Intent j6 = j(context);
        j6.putExtra("type", 13);
        f27821j = nVar;
        j6.putExtra("event_tag", str);
        com.bytedance.sdk.component.utils.xt.j(context, j6, null);
    }

    private void j(String str, String str2, ae aeVar, String str3, String str4, String str5) {
        if (ed.g(this.oq)) {
            if (TextUtils.isEmpty(str2)) {
                aeVar.j(7, "uegnData is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                cw cwVar = this.qv;
                if (cwVar == null || !cwVar.isShowing()) {
                    cw g6 = new com.bytedance.sdk.openadsdk.core.widget.jy(this.oq, jSONObject, aeVar).g(str);
                    this.qv = g6;
                    try {
                        ((com.bytedance.sdk.openadsdk.core.widget.jy) g6).xt(j(str, str2, str3, str4, str5));
                        this.qv.show();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
            }
        }
    }

    private void j(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final JSONArray jSONArray, final float f6, final String str8, final String str9, final String str10, final String str11, final String str12) {
        j(str, str2, str7, f6, new ae() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.19
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.ae
            public void j(int i6, String str13) {
                TTDelegateActivity.this.j(str, str2, str3, f6, str4, "", jSONArray, str5, str6, str7, str8, str9, str12, str11, str10);
                if (TTDelegateActivity.this.f27823g != null) {
                    TTDelegateActivity.this.f27823g.j((ae) null);
                }
                if (TTDelegateActivity.av != null) {
                    TTDelegateActivity.av.j(i6, str13);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ae.ae
            public void j(com.bytedance.adsdk.ugeno.xt.cw<View> cwVar) {
                if (TTDelegateActivity.av != null) {
                    TTDelegateActivity.av.j(null);
                }
            }
        }, str10, str11, str12);
    }

    private void j(final String str, final String str2, String str3, float f6, ae aeVar, final String str4, final String str5, final String str6) {
        if (ed.g(this.oq)) {
            if (TextUtils.isEmpty(str2)) {
                aeVar.j(7, "uegnData is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("app_name", str3);
                }
                jSONObject.put("score", f6);
                JSONObject xt = com.bytedance.sdk.openadsdk.core.ugeno.oq.xt(jSONObject.getString("ugen_dialog_md5"), jSONObject.getString("ugen_dialog_url"));
                if (xt == null) {
                    aeVar.j(8, "uegnTemplate is empty");
                    return;
                }
                tl tlVar = this.f27823g;
                if (tlVar == null || !tlVar.isShowing()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("easy_dl_dialog", jSONObject);
                    tl tlVar2 = new tl(str, this.oq, xt, jSONObject2, aeVar, f27821j);
                    this.f27823g = tlVar2;
                    tlVar2.j(new ae.j() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.20
                        @Override // com.bytedance.sdk.openadsdk.core.widget.ae.j
                        public void j(Dialog dialog) {
                            m.xt(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.ae.j
                        public void cw(Dialog dialog) {
                            m.r(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.ae.j
                        public void r(Dialog dialog) {
                            try {
                                com.bytedance.sdk.openadsdk.core.tj.m up = com.bytedance.sdk.openadsdk.core.j.up(new JSONObject(str2));
                                if (up != null) {
                                    TTDelegateActivity.this.j(up.tl(), str, 2, false, (Dialog) TTDelegateActivity.this.f27823g);
                                }
                            } catch (JSONException unused) {
                            }
                            if (TTDelegateActivity.this.f27823g != null) {
                                TTDelegateActivity.this.f27823g.hide();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.ae.j
                        public void xt(Dialog dialog) {
                            TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                            tTDelegateActivity.j(str2, str, false, (Dialog) tTDelegateActivity.f27823g);
                            if (TTDelegateActivity.this.f27823g != null) {
                                TTDelegateActivity.this.f27823g.hide();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.ae.j
                        public void j() {
                            try {
                                com.bytedance.sdk.openadsdk.core.tj.m up = com.bytedance.sdk.openadsdk.core.j.up(new JSONObject(str2));
                                if (up != null) {
                                    TTDelegateActivity.this.j(up.g(), str, 1, false, (Dialog) TTDelegateActivity.this.f27823g);
                                }
                            } catch (JSONException unused) {
                            }
                            if (TTDelegateActivity.this.f27823g != null) {
                                TTDelegateActivity.this.f27823g.hide();
                            }
                        }
                    });
                    this.f27823g.show();
                }
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, String str2, String str3, float f6, String str4, String str5, JSONArray jSONArray, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        if (ed.g(this.oq)) {
            cw cwVar = this.qv;
            if (cwVar == null || !cwVar.isShowing()) {
                cw j6 = new cw(this.oq).j(str8).up(str6).m(str9).xt(str3).tl(str7).g(str).cw(str5).j(f6).j(jSONArray).ae(str10).r(str4).j(j(str, str2, str11, str12, str13));
                this.qv = j6;
                j6.show();
            }
        }
    }

    private cw.j j(final String str, final String str2, final String str3, final String str4, final String str5) {
        return new cw.j() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.21
            @Override // com.bytedance.sdk.openadsdk.core.widget.cw.j
            public void cw(Dialog dialog) {
                m.r(str);
                TTDelegateActivity.this.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.cw.j
            public void j(Dialog dialog) {
                m.xt(str);
                TTDelegateActivity.this.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.cw.j
            public void m(Dialog dialog) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    TTDelegateActivity.xt(str4, str5, str3);
                    com.bytedance.sdk.openadsdk.core.tj.m up = com.bytedance.sdk.openadsdk.core.j.up(jSONObject);
                    if (up == null) {
                        return;
                    }
                    TTDelegateActivity.this.j(up.qv(), str, 3, false, (Dialog) null);
                } catch (Exception unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.cw.j
            public void r(Dialog dialog) {
                try {
                    com.bytedance.sdk.openadsdk.core.tj.m up = com.bytedance.sdk.openadsdk.core.j.up(new JSONObject(str2));
                    if (up != null) {
                        TTDelegateActivity.this.j(up.tl(), str, 2, false, (Dialog) null);
                    }
                } catch (Exception unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.cw.j
            public void up(Dialog dialog) {
                try {
                    com.bytedance.sdk.openadsdk.core.tj.m up = com.bytedance.sdk.openadsdk.core.j.up(new JSONObject(str2));
                    if (up == null) {
                        return;
                    }
                    TTDelegateActivity.this.j(up.g(), str, 1, false, (Dialog) null);
                } catch (Throwable unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.cw.j
            public void xt(Dialog dialog) {
                TTDelegateActivity.this.j(str2, str, false, (Dialog) null);
            }
        };
    }

    private void j(String str, String str2) {
        if (this.xt == null) {
            return;
        }
        j(str, str2, true, (Dialog) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, final String str2, int i6, final boolean z5, final Dialog dialog) {
        String str3;
        String str4;
        try {
            if (ed.g(this.oq)) {
                up upVar = this.ae;
                if (upVar != null) {
                    upVar.dismiss();
                }
                if (i6 == 1) {
                    str3 = "https://apps.bytesfield.com/app_package_ce/appIntro";
                    str4 = "应用简介";
                } else if (i6 == 2) {
                    str3 = "https://sf1-amtos-cdn.bytesmanager.com/obj/ad-app-package/personal-privacy-page.html";
                    str4 = "隐私政策";
                } else if (i6 == 3) {
                    str4 = "备案信息";
                    str3 = null;
                } else {
                    str3 = null;
                    str4 = null;
                }
                up upVar2 = new up(this.oq, str, str3, str4);
                this.ae = upVar2;
                upVar2.j(new up.j() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.3
                    @Override // com.bytedance.sdk.openadsdk.core.widget.up.j
                    public void cw(Dialog dialog2) {
                        if (TTDelegateActivity.this.ae != null) {
                            if (z5) {
                                m.r(str2);
                                TTDelegateActivity.this.finish();
                            } else {
                                Dialog dialog3 = dialog;
                                if (dialog3 != null) {
                                    dialog3.show();
                                }
                                TTDelegateActivity.this.ae.dismiss();
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.up.j
                    public void j(Dialog dialog2) {
                        m.xt(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.up.j
                    public void xt(Dialog dialog2) {
                        m.r(str2);
                        TTDelegateActivity.this.finish();
                    }
                });
                this.ae.show();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, final String str2, final boolean z5, final Dialog dialog) {
        try {
            if (ed.g(this.oq)) {
                com.bytedance.sdk.openadsdk.core.widget.xt xtVar = this.vl;
                if (xtVar != null) {
                    xtVar.dismiss();
                }
                com.bytedance.sdk.openadsdk.core.widget.xt xtVar2 = new com.bytedance.sdk.openadsdk.core.widget.xt(this.oq, str);
                this.vl = xtVar2;
                xtVar2.j(new xt.j() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity.5
                    @Override // com.bytedance.sdk.openadsdk.core.widget.xt.j
                    public void cw(Dialog dialog2) {
                        if (TTDelegateActivity.this.vl != null) {
                            if (z5) {
                                m.r(str2);
                                TTDelegateActivity.this.finish();
                            } else {
                                Dialog dialog3 = dialog;
                                if (dialog3 != null) {
                                    dialog3.show();
                                }
                                TTDelegateActivity.this.vl.dismiss();
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.xt.j
                    public void j(Dialog dialog2) {
                        m.xt(str2);
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.widget.xt.j
                    public void xt(Dialog dialog2) {
                        m.r(str2);
                        TTDelegateActivity.this.finish();
                    }
                });
                this.vl.show();
            }
        } catch (Throwable unused) {
        }
    }

    private void j(String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (this.cw == null) {
                this.cw = new AlertDialog.Builder(this.oq, com.bytedance.sdk.component.utils.kt.tl(this.oq, "Theme.Dialog.TTDownload")).create();
            }
            this.cw.setTitle(String.valueOf(str));
            this.cw.setMessage(String.valueOf(str2));
            this.cw.setButton(-1, com.bytedance.sdk.component.utils.kt.j(this.oq, "tt_label_ok"), onClickListener);
            this.cw.setButton(-2, com.bytedance.sdk.component.utils.kt.j(this.oq, "tt_label_cancel"), onClickListener2);
            this.cw.setOnCancelListener(onCancelListener);
            if (this.cw.isShowing()) {
                return;
            }
            this.cw.show();
        } catch (Exception e6) {
            vl.j(e6);
        }
    }
}
