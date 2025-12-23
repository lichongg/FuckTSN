package com.bytedance.msdk.ae.j;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.msdk.j.j.r;
import com.bytedance.msdk.j.up.m;
import com.bytedance.msdk.tl.l;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static volatile xt f24320j;
    private Map<String, com.bytedance.msdk.core.oq.j> cw = new ConcurrentHashMap();
    private l xt = com.bytedance.msdk.ae.j.r();

    private void cw(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        m.r(new Runnable() { // from class: com.bytedance.msdk.ae.j.xt.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.ae.xt.xt.j().j(jSONObject);
            }
        });
    }

    public static xt j() {
        if (f24320j == null) {
            synchronized (xt.class) {
                try {
                    if (f24320j == null) {
                        f24320j = new xt();
                    }
                } finally {
                }
            }
        }
        return f24320j;
    }

    private void xt(JSONObject jSONObject) {
        this.cw.clear();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            com.bytedance.msdk.core.oq.j j6 = com.bytedance.msdk.core.oq.j.j(next, optJSONObject);
            if (optJSONObject != null && j6 != null) {
                if (TextUtils.equals(next, MediationConstant.ADN_PANGLE) && com.bytedance.msdk.core.j.qv().uf()) {
                    this.cw.put("pangle_custom", j6);
                } else {
                    this.cw.put(next, j6);
                }
            }
        }
    }

    public synchronized void r() {
        List<String> j6;
        try {
            Context context = com.bytedance.msdk.core.xt.getContext();
            if (context == null) {
                return;
            }
            Set<String> m6 = m();
            if (m6.size() == 0) {
                return;
            }
            int i6 = context.getApplicationInfo().targetSdkVersion;
            com.bytedance.msdk.j.up.cw.xt("TTMediationSDK_SDK_Init", "------------------ 聚合 接入信息 start ---------------------");
            com.bytedance.msdk.j.up.cw.j("TTMediationSDK_SDK_Init", "当前接入的聚合 SDK版本是：" + com.bytedance.msdk.xt.xt.xt());
            if ((Build.VERSION.SDK_INT >= 24 || i6 >= 24) && (j6 = j(context)) != null) {
                Iterator<String> it = m6.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!MediationConstant.ADN_UNITY.equals(next) && !"pangle_custom".equals(next) && !"xiaomi".equals(next)) {
                        if (MediationConstant.ADN_PANGLE.equals(next) && com.bytedance.msdk.core.j.qv().uf()) {
                            next = "pangle_custom";
                        }
                        if (j6.contains(next)) {
                            com.bytedance.msdk.j.up.cw.xt("TTMediationSDK_SDK_Init", "已按要求接入三方广告sdk【" + next + "】");
                        } else {
                            com.bytedance.msdk.j.up.cw.r("TTMediationSDK_SDK_Init", "未按要求接入三方广告sdk【" + next + "】，请检查接入配置");
                        }
                    }
                }
            }
            com.bytedance.msdk.j.up.cw.xt("TTMediationSDK_SDK_Init", "------------------ GroMore 接入信息 end ---------------------");
            com.bytedance.msdk.j.up.cw.xt("TTMediationSDK_SDK_Init", "------------------ GroMore 版本信息 start ---------------------");
            for (String str : m6) {
                if (!TextUtils.equals(str, MediationConstant.ADN_PANGLE)) {
                    r j7 = com.bytedance.msdk.m.xt.xt.j().j(str);
                    if (j7 != null) {
                        j7.r();
                    } else {
                        com.bytedance.msdk.j.up.cw.r("TTMediationSDK_InitChecker", "没有引入" + str + "Adapter,请检查相关引入情况");
                    }
                }
            }
            com.bytedance.msdk.j.up.cw.xt("TTMediationSDK_SDK_Init", "------------------ GroMore 版本信息 end ---------------------");
        } catch (Throwable th) {
            throw th;
        }
    }

    private Set<String> m() {
        HashSet hashSet = new HashSet();
        if (this.cw.size() != 0) {
            for (Map.Entry<String, com.bytedance.msdk.core.oq.j> entry : this.cw.entrySet()) {
                com.bytedance.msdk.core.oq.j value = entry.getValue();
                if (value != null && !value.r()) {
                    hashSet.add(entry.getKey());
                }
            }
        }
        return hashSet;
    }

    private void up() {
        String xt = this.xt.xt("adn_init_config");
        if (TextUtils.isEmpty(xt)) {
            return;
        }
        if (!xt.startsWith("[") && !xt.startsWith("{")) {
            xt = com.bytedance.msdk.tl.j.xt(xt, com.bytedance.msdk.tl.xt.j());
        }
        if (TextUtils.isEmpty(xt)) {
            return;
        }
        try {
            xt(new JSONObject(xt));
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    public boolean cw() {
        if (this.cw.size() == 0) {
            up();
        }
        return this.cw.isEmpty();
    }

    private xt() {
    }

    public void j(JSONObject jSONObject) {
        if (jSONObject != null) {
            xt(jSONObject);
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                this.xt.j("adn_init_config", jSONObject2);
            }
        }
        cw(jSONObject);
    }

    public List<com.bytedance.msdk.core.oq.j> xt() {
        if (this.cw.size() == 0) {
            up();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, com.bytedance.msdk.core.oq.j>> it = this.cw.entrySet().iterator();
        while (it.hasNext()) {
            com.bytedance.msdk.core.oq.j value = it.next().getValue();
            if (value != null && value.r()) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    public com.bytedance.msdk.core.oq.j j(String str) {
        if (this.cw.size() == 0) {
            up();
        }
        return this.cw.get(str);
    }

    private List<String> j(Context context) {
        List<ProviderInfo> queryContentProviders = context.getPackageManager().queryContentProviders(context.getApplicationInfo().processName, context.getApplicationInfo().uid, 131072);
        if (queryContentProviders == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        context.getPackageName();
        Iterator<ProviderInfo> it = queryContentProviders.iterator();
        while (it.hasNext()) {
            String str = it.next().name;
            str.getClass();
            switch (str) {
                case "com.baidu.mobads.sdk.api.BdFileProvider":
                    arrayList.add("baidu");
                    break;
                case "com.mbridge.msdk.foundation.tools.MBFileProvider":
                    arrayList.add(MediationConstant.ADN_MINTEGRAL);
                    break;
                case "com.sigmob.sdk.SigmobFileProvider":
                case "com.sigmob.sdk.SigmobFileV4Provider":
                    arrayList.add(MediationConstant.ADN_SIGMOB);
                    break;
                case "com.tencent.klevin.utils.FileProvider":
                    arrayList.add(MediationConstant.ADN_KLEVIN);
                    break;
                case "com.google.android.gms.ads.MobileAdsInitProvider":
                    arrayList.add(MediationConstant.ADN_ADMOB);
                    break;
                case "com.bykv.vk.openvk.TTFileProvider":
                    arrayList.add("pangle_custom");
                    break;
                case "com.kwad.sdk.api.proxy.app.AdSdkFileProvider":
                    arrayList.add(MediationConstant.ADN_KS);
                    break;
                case "com.bytedance.sdk.openadsdk.TTFileProvider":
                    arrayList.add(MediationConstant.ADN_PANGLE);
                    break;
                case "com.unity":
                    arrayList.add(MediationConstant.ADN_UNITY);
                    break;
                case "com.qq.e.comm.GDTFileProvider":
                    arrayList.add(MediationConstant.ADN_GDT);
                    break;
            }
        }
        return arrayList;
    }

    public boolean xt(String str) {
        com.bytedance.msdk.core.oq.j jVar;
        if (this.cw.size() == 0) {
            up();
        }
        Map<String, com.bytedance.msdk.core.oq.j> map = this.cw;
        return (map == null || (jVar = map.get(str)) == null || !jVar.r()) ? false : true;
    }
}
