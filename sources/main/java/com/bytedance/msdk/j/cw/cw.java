package com.bytedance.msdk.j.cw;

import a1.a;
import a1.b;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    private PluginValueSet cw;

    /* renamed from: j, reason: collision with root package name */
    private PluginValueSet f25131j;

    /* renamed from: r, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.i.cw.cw.j f25132r = new com.bytedance.sdk.openadsdk.i.cw.cw.j(com.bytedance.msdk.core.j.qv().ol().sparseArray());
    private Function<SparseArray<Object>, Object> up;
    private PluginValueSet xt;

    private void b() {
        com.bytedance.msdk.j.up.cw.xt("---------  sdk 隐私设置 start ----");
        com.bytedance.msdk.j.up.cw.xt("isCanUseLocation：" + g());
        r az = az();
        com.bytedance.msdk.j.up.cw.xt("getLocation：".concat(String.valueOf(az)));
        if (az != null) {
            com.bytedance.msdk.j.up.cw.xt("getLocation getLatitude：" + az.j());
            com.bytedance.msdk.j.up.cw.xt("getLocation getLongitude：" + az.xt());
        }
        com.bytedance.msdk.j.up.cw.xt("appList：" + qv());
        com.bytedance.msdk.j.up.cw.xt("isCanUsePhoneState：" + tl());
        com.bytedance.msdk.j.up.cw.xt("isLimitPersonalAds：" + ae());
        com.bytedance.msdk.j.up.cw.xt("getDevImei：" + av());
        com.bytedance.msdk.j.up.cw.xt("isCanUseWifiState：" + v());
        com.bytedance.msdk.j.up.cw.xt("getMacAddress：" + tj());
        com.bytedance.msdk.j.up.cw.xt("userPrivacyConfig：" + f());
        com.bytedance.msdk.j.up.cw.xt("isCanUseWriteExternal：" + oq());
        com.bytedance.msdk.j.up.cw.xt("isCanUseAndroidId：" + jy());
        com.bytedance.msdk.j.up.cw.xt("getAndroidId：" + w());
        List<String> x5 = x();
        com.bytedance.msdk.j.up.cw.xt("getAppList：".concat(String.valueOf(x5)));
        if (x5 != null) {
            Iterator<String> it = x5.iterator();
            while (it.hasNext()) {
                com.bytedance.msdk.j.up.cw.xt("getAppList item: ".concat(String.valueOf(it.next())));
            }
        }
        List<String> i6 = i();
        com.bytedance.msdk.j.up.cw.xt("getDevImeis：".concat(String.valueOf(i6)));
        if (i6 != null) {
            Iterator<String> it2 = i6.iterator();
            while (it2.hasNext()) {
                com.bytedance.msdk.j.up.cw.xt("getDevImeis item: ".concat(String.valueOf(it2.next())));
            }
        }
        com.bytedance.msdk.j.up.cw.xt("getDevOaid：" + kt());
        com.bytedance.msdk.j.up.cw.xt("isCanUseOaid：" + mi());
        com.bytedance.msdk.j.up.cw.xt("isCanUseMacAddress：" + vl());
        com.bytedance.msdk.j.up.cw.xt("isProgrammaticRecommend：" + ws());
        com.bytedance.msdk.j.up.cw.xt("---------  sdk 隐私设置 end ----");
    }

    private boolean e() {
        PluginValueSet pluginValueSet = this.f25131j;
        return (pluginValueSet == null || pluginValueSet.isEmpty()) ? false : true;
    }

    private void hl() {
        com.bytedance.msdk.j.up.cw.xt("---------  sdk 初始化信息 start ----");
        com.bytedance.msdk.j.up.cw.xt("isDebug：" + p());
        com.bytedance.msdk.j.up.cw.xt("getClassName：" + j());
        com.bytedance.msdk.j.up.cw.xt("getAppId：" + xt());
        com.bytedance.msdk.j.up.cw.xt("getAppName：" + cw());
        com.bytedance.msdk.j.up.cw.xt("getADNName：" + r());
        com.bytedance.msdk.j.up.cw.xt("getAppKey：" + up());
        com.bytedance.msdk.j.up.cw.xt("getInitCallback：" + m());
        com.bytedance.msdk.j.up.cw.xt("getAgeGroup：" + ch());
        com.bytedance.msdk.j.up.cw.xt("isCustom：" + s());
        com.bytedance.msdk.j.up.cw.xt("getCustomInitMap：" + a());
        com.bytedance.msdk.j.up.cw.xt("getCustomGMConfiguration：" + l());
        com.bytedance.msdk.j.up.cw.xt("getGromoreVersion：" + h());
        com.bytedance.msdk.j.up.cw.xt("getMap：" + la());
        com.bytedance.msdk.j.up.cw.xt("---------  sdk 初始化信息 end ----");
    }

    public static cw j(SparseArray<Object> sparseArray) {
        return new cw(sparseArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double q() {
        Function a6;
        PluginValueSet xt;
        PluginValueSet pluginValueSet = this.xt;
        if (pluginValueSet == null || (a6 = b.a(pluginValueSet.objectValue(8312, a.a()))) == null || (xt = com.bytedance.sdk.openadsdk.i.cw.xt(a6)) == null) {
            return -1.0d;
        }
        return xt.doubleValue(8481);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double qb() {
        Function a6;
        PluginValueSet xt;
        PluginValueSet pluginValueSet = this.xt;
        if (pluginValueSet == null || (a6 = b.a(pluginValueSet.objectValue(8312, a.a()))) == null || (xt = com.bytedance.sdk.openadsdk.i.cw.xt(a6)) == null) {
            return -1.0d;
        }
        return xt.doubleValue(8482);
    }

    private void z() {
        com.bytedance.msdk.j.up.cw.xt("---------  sdk 聚合信息 start ----");
        com.bytedance.msdk.j.up.cw.xt("getHttps：" + gq());
        com.bytedance.msdk.j.up.cw.xt("getWxAppId：" + rn());
        com.bytedance.msdk.j.up.cw.xt("getPublisherDid：" + wq());
        com.bytedance.msdk.j.up.cw.xt("isOpenAdnTest：" + uf());
        com.bytedance.msdk.j.up.cw.xt("getMediationConfigUserInfoForSegment：" + ed());
        com.bytedance.msdk.j.up.cw.xt("getLocalExtra：" + c());
        com.bytedance.msdk.j.up.cw.xt("getCustomLocalConfig：" + gx());
        com.bytedance.msdk.j.up.cw.xt("getOpensdkVer：" + n());
        com.bytedance.msdk.j.up.cw.xt("isWxInstalled：" + nd());
        com.bytedance.msdk.j.up.cw.xt("isSupportH265：" + rh());
        com.bytedance.msdk.j.up.cw.xt("isSupportSplashZoomout：" + ol());
        com.bytedance.msdk.j.up.cw.xt("---------  sdk 聚合信息 end ----");
    }

    public boolean ae() {
        PluginValueSet xt;
        Function<SparseArray<Object>, Object> function = this.up;
        if (function == null || (xt = com.bytedance.sdk.openadsdk.i.cw.xt(function)) == null) {
            return false;
        }
        return xt.booleanValue(8027);
    }

    public String av() {
        PluginValueSet pluginValueSet = this.xt;
        return pluginValueSet != null ? pluginValueSet.stringValue(8484) : "";
    }

    public Map c() {
        PluginValueSet pluginValueSet = this.cw;
        return pluginValueSet != null ? (Map) pluginValueSet.objectValue(8462, Map.class) : new HashMap();
    }

    public int ch() {
        return this.f25132r.jy();
    }

    public Function<SparseArray<Object>, Object> ed() {
        PluginValueSet pluginValueSet = this.cw;
        if (pluginValueSet != null) {
            return b.a(pluginValueSet.objectValue(8310, a.a()));
        }
        return null;
    }

    public Map<String, Object> f() {
        PluginValueSet pluginValueSet = this.xt;
        if (pluginValueSet != null) {
            return (Map) pluginValueSet.objectValue(8554, Map.class);
        }
        return null;
    }

    public boolean g() {
        PluginValueSet pluginValueSet = this.xt;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8024);
        }
        return true;
    }

    public boolean gq() {
        PluginValueSet pluginValueSet = this.cw;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8458);
        }
        return false;
    }

    public JSONObject gx() {
        PluginValueSet pluginValueSet = this.cw;
        if (pluginValueSet != null) {
            return (JSONObject) pluginValueSet.objectValue(8463, JSONObject.class);
        }
        return null;
    }

    public String h() {
        PluginValueSet pluginValueSet = this.f25131j;
        return pluginValueSet != null ? pluginValueSet.stringValue(8411) : "";
    }

    public List<String> i() {
        PluginValueSet xt;
        Function<SparseArray<Object>, Object> function = this.up;
        return (function == null || (xt = com.bytedance.sdk.openadsdk.i.cw.xt(function)) == null) ? new LinkedList() : (List) xt.objectValue(8477, List.class);
    }

    public boolean jy() {
        PluginValueSet pluginValueSet = this.xt;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8479);
        }
        return true;
    }

    public String kt() {
        PluginValueSet pluginValueSet = this.xt;
        return pluginValueSet != null ? pluginValueSet.stringValue(8486) : "";
    }

    public Map la() {
        PluginValueSet pluginValueSet = this.f25131j;
        return pluginValueSet != null ? (Map) pluginValueSet.objectValue(8425, Map.class) : new HashMap();
    }

    public boolean mi() {
        PluginValueSet xt;
        Function<SparseArray<Object>, Object> function = this.up;
        if (function == null || (xt = com.bytedance.sdk.openadsdk.i.cw.xt(function)) == null) {
            return true;
        }
        return xt.booleanValue(8478);
    }

    public String n() {
        PluginValueSet pluginValueSet = this.cw;
        return pluginValueSet != null ? pluginValueSet.stringValue(8464) : "";
    }

    public boolean nd() {
        PluginValueSet pluginValueSet = this.cw;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8465);
        }
        return false;
    }

    public boolean ol() {
        PluginValueSet pluginValueSet = this.cw;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8467);
        }
        return false;
    }

    public boolean oq() {
        PluginValueSet pluginValueSet = this.xt;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8025);
        }
        return true;
    }

    public boolean p() {
        PluginValueSet pluginValueSet = this.f25131j;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(1);
        }
        return false;
    }

    public boolean qv() {
        PluginValueSet pluginValueSet = this.xt;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8026);
        }
        return true;
    }

    public boolean rh() {
        PluginValueSet pluginValueSet = this.cw;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8466);
        }
        return false;
    }

    public String rn() {
        PluginValueSet pluginValueSet = this.cw;
        return pluginValueSet != null ? pluginValueSet.stringValue(8459) : "";
    }

    public String tj() {
        PluginValueSet pluginValueSet = this.xt;
        return pluginValueSet != null ? pluginValueSet.stringValue(8487) : "";
    }

    public boolean tl() {
        PluginValueSet pluginValueSet = this.xt;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8023);
        }
        return true;
    }

    public boolean uf() {
        PluginValueSet pluginValueSet = this.cw;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8461);
        }
        return false;
    }

    public boolean v() {
        PluginValueSet pluginValueSet = this.xt;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8480);
        }
        return true;
    }

    public String w() {
        PluginValueSet pluginValueSet = this.xt;
        return pluginValueSet != null ? pluginValueSet.stringValue(8485) : "";
    }

    public String wq() {
        PluginValueSet pluginValueSet = this.cw;
        return pluginValueSet != null ? pluginValueSet.stringValue(8460) : "";
    }

    public boolean ws() {
        PluginValueSet xt;
        Function<SparseArray<Object>, Object> function = this.up;
        if (function == null || (xt = com.bytedance.sdk.openadsdk.i.cw.xt(function)) == null) {
            return true;
        }
        return xt.booleanValue(8028);
    }

    public List<String> x() {
        PluginValueSet xt;
        Function<SparseArray<Object>, Object> function = this.up;
        return (function == null || (xt = com.bytedance.sdk.openadsdk.i.cw.xt(function)) == null) ? new LinkedList() : (List) xt.objectValue(8476, List.class);
    }

    public void xt(SparseArray<Object> sparseArray) {
        PluginValueSet k6 = e.i(sparseArray).k();
        this.xt = k6;
        if (k6 != null) {
            this.up = b.a(k6.objectValue(8311, a.a()));
        }
        b();
    }

    private cw(SparseArray<Object> sparseArray) {
        this.up = null;
        PluginValueSet k6 = e.i(sparseArray).k();
        this.f25131j = k6;
        if (k6 != null) {
            this.cw = com.bytedance.sdk.openadsdk.i.cw.r.j(8457, k6);
            PluginValueSet j6 = com.bytedance.sdk.openadsdk.i.cw.r.j(8475, this.f25131j);
            this.xt = j6;
            if (j6 != null) {
                this.up = b.a(j6.objectValue(8311, a.a()));
            }
        }
        hh();
    }

    private void hh() {
        hl();
        b();
        z();
    }

    public Map a() {
        if (e()) {
            return (Map) this.f25131j.objectValue(8400, Map.class);
        }
        return null;
    }

    public r az() {
        if (q() != -1.0d && q() != -1.0d) {
            return new r() { // from class: com.bytedance.msdk.j.cw.cw.1
                @Override // com.bytedance.msdk.j.cw.r
                public double j() {
                    return cw.this.q();
                }

                @Override // com.bytedance.msdk.j.cw.r
                public double xt() {
                    return cw.this.qb();
                }
            };
        }
        return null;
    }

    public String cw() {
        if (e()) {
            return this.f25131j.stringValue(8);
        }
        return "";
    }

    public String j() {
        return e() ? this.f25131j.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow) : "";
    }

    public Function<SparseArray<Object>, Object> l() {
        if (e()) {
            return b.a(this.f25131j.objectValue(8401, a.a()));
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> m() {
        if (e()) {
            return b.a(this.f25131j.objectValue(8300, a.a()));
        }
        return null;
    }

    public String r() {
        if (e()) {
            return this.f25131j.stringValue(8003);
        }
        return "";
    }

    public boolean s() {
        if (e()) {
            return this.f25131j.booleanValue(8098);
        }
        return false;
    }

    public String up() {
        if (e()) {
            return this.f25131j.stringValue(AVMDLDataLoader.KeyIsLiveWatchDurationThreshold);
        }
        return "";
    }

    public boolean vl() {
        return v();
    }

    public String xt() {
        if (e()) {
            return this.f25131j.stringValue(3);
        }
        return null;
    }
}
