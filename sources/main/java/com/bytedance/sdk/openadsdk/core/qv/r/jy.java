package com.bytedance.sdk.openadsdk.core.qv.r;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.qv.r.g;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.downloadlib.addownload.o;
import com.ss.android.j.j.cw.b;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class jy implements r {
    @Override // com.bytedance.sdk.openadsdk.core.qv.r.r
    public boolean j(b bVar, com.ss.android.socialbase.downloader.ae.cw cwVar) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.r.r
    public ae xt() {
        return null;
    }

    public static r r() {
        return new jy();
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.r.r
    public void j(JSONObject jSONObject, String str) {
        com.bytedance.sdk.openadsdk.core.qv.cw.xt.j j6;
        n nVar;
        JSONObject optJSONObject = jSONObject.optJSONObject(com.bytedance.sdk.openadsdk.core.qv.j.oq.EXTRA_DOWN_INFO_KEY);
        if (optJSONObject == null || !ed.j() || (j6 = com.bytedance.sdk.openadsdk.core.qv.cw.xt.j.j(optJSONObject)) == null || (nVar = j6.f29940j) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.qv.g.j(str, nVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.r.r
    public void xt(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.utils.m.cw(new File(str));
    }

    private jy() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.r.r
    public boolean cw() {
        return com.bytedance.sdk.openadsdk.core.oq.i().j();
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.r.r
    public boolean xt(b bVar, com.ss.android.socialbase.downloader.ae.cw cwVar) {
        String str;
        String str2;
        String str3;
        int i6;
        JSONObject optJSONObject;
        if (bVar == null || cwVar == null) {
            return false;
        }
        String ch = bVar.ch();
        String a6 = bVar.a();
        String tl = bVar.tl();
        String s5 = bVar.s();
        String ws = cwVar.ws();
        long r5 = bVar.r();
        int ae = cwVar.ae();
        JSONObject ae2 = o.f.c().q(r5).ae();
        String str4 = null;
        if (ae2 == null || (optJSONObject = ae2.optJSONObject(com.bytedance.sdk.openadsdk.core.qv.j.oq.EXTRA_DOWN_INFO_KEY)) == null) {
            str = ch;
            str2 = null;
            str3 = null;
            i6 = 0;
        } else {
            String optString = optJSONObject.optString(CommonNetImpl.TAG);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("material_meta");
            if (optJSONObject2 != null) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("download_conf");
                r0 = optJSONObject3 != null ? optJSONObject3.optInt("enable_notification", 0) : 0;
                str4 = optJSONObject2.optString(MediationConstant.EXTRA_ADID);
            }
            if (TextUtils.isEmpty(ch)) {
                ch = optJSONObject2.optString(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND);
            }
            i6 = r0;
            str = ch;
            str3 = str4;
            str2 = optString;
        }
        return new com.bytedance.sdk.openadsdk.core.qv.m().j(tl, a6, s5, ae, str, ws, i6, str2, str3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.r.r
    public JSONObject j() {
        JSONObject xt = com.bytedance.sdk.openadsdk.core.qv.g.xt();
        try {
            if (!v.xt().a()) {
                xt.put("enable_app_install_receiver", 0);
            }
            if (xt.optInt("enable_target_34", -1) == -1) {
                xt.put("enable_target_34", v.xt().zk());
            }
        } catch (Exception unused) {
        }
        return xt;
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.r.r
    public String j(boolean z5) {
        return com.bytedance.sdk.openadsdk.core.qv.g.j(z5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.r.r
    public void j(Activity activity, String[] strArr, m mVar) {
        vl.j(activity, strArr, mVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.r.r
    public boolean j(Context context, String str) {
        return vl.j(context, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.r.r
    public void j(int i6, String str, Map<String, Object> map, up upVar) {
        oq.j(i6, str, map, upVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.r.r
    public void j(String str, byte[] bArr, String str2, up upVar) {
        oq.j(str, bArr, str2, 0, upVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.r.r
    public AlertDialog j(Activity activity, boolean z5, j jVar) {
        return qv.j(activity, z5, jVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.r.r
    public void j(WeakReference<Context> weakReference, boolean z5, j jVar) {
        qv.j(weakReference, z5, jVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.r.r
    public boolean j(String str) {
        return g.j(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.r.r
    public void j(tl tlVar, boolean z5) {
        if (j(tlVar)) {
            try {
                com.bytedance.sdk.component.oq.ae.j(g.j.j(tlVar, z5), 5);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.r.r
    public boolean j(b bVar) {
        String str;
        String str2;
        String str3;
        int i6;
        JSONObject optJSONObject;
        if (bVar == null) {
            return true;
        }
        String ch = bVar.ch();
        String a6 = bVar.a();
        String tl = bVar.tl();
        String s5 = bVar.s();
        JSONObject ae = o.f.c().q(bVar.r()).ae();
        String str4 = null;
        if (ae == null || (optJSONObject = ae.optJSONObject(com.bytedance.sdk.openadsdk.core.qv.j.oq.EXTRA_DOWN_INFO_KEY)) == null) {
            str = ch;
            str2 = null;
            str3 = null;
            i6 = 0;
        } else {
            String optString = optJSONObject.optString(CommonNetImpl.TAG);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("material_meta");
            if (optJSONObject2 != null) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("download_conf");
                r5 = optJSONObject3 != null ? optJSONObject3.optInt("enable_notification", 0) : 0;
                str4 = optJSONObject2.optString(MediationConstant.EXTRA_ADID);
            }
            if (TextUtils.isEmpty(ch)) {
                ch = optJSONObject2.optString(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND);
            }
            str3 = str4;
            str2 = optString;
            i6 = r5;
            str = ch;
        }
        return new com.bytedance.sdk.openadsdk.core.qv.m().j(tl, a6, s5, str, i6, str2, str3);
    }

    private boolean j(tl tlVar) {
        JSONObject r5;
        if (tlVar == null || (r5 = tlVar.r()) == null) {
            return false;
        }
        String optString = r5.optString("ad_extra_data");
        if (TextUtils.isEmpty(optString)) {
            return false;
        }
        try {
            return new JSONObject(optString).optJSONObject(com.bytedance.sdk.openadsdk.core.qv.j.oq.EXTRA_DOWN_INFO_KEY) != null;
        } catch (Throwable unused) {
            return false;
        }
    }
}
