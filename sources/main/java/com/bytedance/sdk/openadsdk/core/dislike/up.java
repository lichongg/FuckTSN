package com.bytedance.sdk.openadsdk.core.dislike;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.a;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.p.tl;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.nd;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.l.ae;
import com.bytedance.sdk.openadsdk.ws.j;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up implements com.bytedance.sdk.openadsdk.core.dislike.xt.j {
    private final r cw;

    /* renamed from: j, reason: collision with root package name */
    private final n f28905j;

    /* renamed from: r, reason: collision with root package name */
    private String f28906r;
    private final WeakReference<Context> xt;

    private String cw(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("app_name", oq.i().v());
            jSONObject.putOpt("app_id", oq.i().f());
            jSONObject.putOpt("os_api", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("os_version", Build.VERSION.RELEASE);
            jSONObject.putOpt("manufacturer", Build.MANUFACTURER);
            jSONObject.putOpt("did", m.j().cw());
            jSONObject.putOpt("sdk_version", 7012);
            jSONObject.putOpt("sdk_api_version", Integer.valueOf(h.xt));
            jSONObject.putOpt("live_sdk_version", com.bytedance.sdk.openadsdk.core.live.xt.j().ae());
            jSONObject.putOpt("msg", str);
            jSONObject.putOpt("recordId", str2);
            jSONObject.putOpt("os", "Android");
            jSONObject.putOpt("ad_info", this.f28905j.fj());
            com.bytedance.sdk.openadsdk.i.cw.cw.xt rr = this.f28905j.rr();
            if (rr != null) {
                jSONObject.putOpt("ad_slot_type", Integer.valueOf(rr.kt()));
                jSONObject.putOpt("rit", rr.mi());
            }
            return jSONObject.toString();
        } catch (Exception e6) {
            vl.xt("#oncall#", e6);
            return str;
        }
    }

    public up(n nVar, Context context, r rVar) {
        this.f28905j = nVar;
        this.xt = new WeakReference<>(context);
        this.cw = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(String str, String str2) {
        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.xt.xt(v.getContext()), str);
        file.mkdirs();
        a aVar = (a) v.j();
        com.bytedance.sdk.openadsdk.i.cw.cw.xt rr = this.f28905j.rr();
        JSONObject j6 = aVar.j(rr, new nd(), rr.kt(), false, 6);
        if (j6 == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.l.r.j(com.bytedance.sdk.openadsdk.core.cw.m.j().xt(j6.toString()).r().toString(), new File(file, "request.info"));
        HashMap hashMap = null;
        com.bytedance.sdk.openadsdk.l.r.j(com.bytedance.sdk.component.utils.j.j(tl.j((com.bytedance.sdk.openadsdk.core.p.up) null).up()).toString(), new File(file, "setting.info"));
        com.bytedance.sdk.openadsdk.l.r.j(com.bytedance.sdk.component.utils.j.j(this.f28905j.tv()).toString(), new File(file, "meta.info"));
        File j7 = com.bytedance.sdk.openadsdk.l.r.j(file, str + ".zip");
        String cw = cw(str2, str);
        HashMap hashMap2 = new HashMap();
        Pair<Integer, JSONObject> j8 = com.bytedance.sdk.openadsdk.core.cw.m.j().j(cw, false);
        if (j8 != null) {
            hashMap = new HashMap();
            hashMap2.put("deviceInfo", ((JSONObject) j8.second).optString(CrashHianalyticsData.MESSAGE));
            hashMap.put("x-pglcypher", String.valueOf(j8.first));
        }
        new com.bytedance.sdk.openadsdk.ws.j().j(this.cw.cw(), j7, hashMap2, new j.InterfaceC0509j() { // from class: com.bytedance.sdk.openadsdk.core.dislike.up.5
            @Override // com.bytedance.sdk.openadsdk.ws.j.InterfaceC0509j
            public void j(String str3) {
                up.this.j("反馈上传成功！");
            }

            @Override // com.bytedance.sdk.openadsdk.ws.j.InterfaceC0509j
            public void j(int i6, String str3) {
                up.this.j("反馈失败！");
            }
        }, hashMap);
        j7.delete();
        com.bytedance.sdk.openadsdk.l.r.j(file);
    }

    @Override // com.bytedance.sdk.openadsdk.core.dislike.xt.j
    public boolean j(String str, Dialog dialog) {
        if (TextUtils.isEmpty(str) || this.xt.get() == null || !str.startsWith("#oncall#")) {
            return false;
        }
        return j(this.xt.get(), str, dialog);
    }

    @Override // com.bytedance.sdk.openadsdk.core.dislike.xt.j
    public boolean j(com.bytedance.sdk.openadsdk.i.cw.xt.m mVar, String str, Dialog dialog) {
        com.bytedance.sdk.openadsdk.core.dislike.cw.cw j6 = r.j();
        if (j6 == null || !TextUtils.equals(mVar.j(), j6.j()) || !TextUtils.equals(mVar.xt(), j6.xt())) {
            return false;
        }
        vl.xt("TTAdDislikeImpl", "click feedback :" + mVar.xt() + ":" + mVar.j());
        return j(this.xt.get(), str, dialog);
    }

    public boolean j(Context context, final String str, Dialog dialog) {
        try {
            if (this.f28906r == null) {
                this.f28906r = UUID.randomUUID().toString();
            }
            if (dialog != null) {
                dialog.dismiss();
            }
            new AlertDialog.Builder(context).setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.up.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i6) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    up upVar = up.this;
                    upVar.j(upVar.f28906r, str);
                }
            }).setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.up.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i6) {
                }
            }).setMessage(this.cw.r() + "\n\n您此次反馈的id为：" + this.f28906r).setCancelable(true).create().show();
            return true;
        } catch (Exception e6) {
            vl.j(e6);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final String str) {
        ae.j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.up.3
            @Override // java.lang.Runnable
            public void run() {
                if (up.this.xt.get() != null) {
                    com.bytedance.sdk.component.utils.a.j((Context) up.this.xt.get(), str, 1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final String str, final String str2) {
        j("反馈上传中，请您稍等！");
        com.bytedance.sdk.component.oq.ae.xt(new g("upload_oncall") { // from class: com.bytedance.sdk.openadsdk.core.dislike.up.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    up.this.xt(str, str2);
                } catch (Throwable th) {
                    vl.xt("#oncall#", th);
                }
            }
        });
    }

    public static void j(Context context, com.bytedance.sdk.openadsdk.core.dislike.ui.j jVar, n nVar) {
        r y5;
        if (jVar == null || nVar == null || (y5 = v.xt().y()) == null || !y5.xt() || TextUtils.isEmpty(y5.cw())) {
            return;
        }
        jVar.j(new up(nVar, context, y5));
    }
}
