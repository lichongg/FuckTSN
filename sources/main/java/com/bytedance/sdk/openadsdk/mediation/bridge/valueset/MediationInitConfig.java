package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.j.j.j.j.b;
import com.bykv.j.j.j.j.c;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.m;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig;
import com.bytedance.sdk.openadsdk.mediation.j.xt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class MediationInitConfig {

    /* renamed from: j, reason: collision with root package name */
    private static String f31696j = "MEDIATION_LOG";
    private ValueSet cw;

    /* renamed from: r, reason: collision with root package name */
    private ValueSet f31697r;
    private ValueSet xt;

    public static MediationInitConfig create(ValueSet valueSet) {
        return new MediationInitConfig(valueSet);
    }

    private void cw() {
        m.cw(f31696j, "---------  sdk 初始化信息 start ----");
        m.cw(f31696j, "isDebug：" + isDebug());
        m.cw(f31696j, "getClassName：" + getClassName());
        m.cw(f31696j, "getAppId：" + getAppId());
        m.cw(f31696j, "getAppName：" + getAppName());
        m.cw(f31696j, "getADNName：" + getADNName());
        m.cw(f31696j, "getAppKey：" + getAppKey());
        m.cw(f31696j, "getInitCallback：" + getInitCallback());
        m.cw(f31696j, "getAgeGroup：" + getAgeGroup());
        m.cw(f31696j, "isCustom：" + isCustom());
        m.cw(f31696j, "getCustomInitConfig：" + getCustomInitConfig());
        m.cw(f31696j, "getCustomInitMap：" + getCustomInitMap());
        m.cw(f31696j, "getCustomGMConfiguration：" + getCustomGMConfiguration());
        m.cw(f31696j, "getKsAdapterVersion：" + getKsAdapterVersion());
        m.cw(f31696j, "getGromoreVersion：" + getGromoreVersion());
        m.cw(f31696j, "getAdmobAdapterVersion：" + getAdmobAdapterVersion());
        m.cw(f31696j, "getBaiduAdapterVersion：" + getBaiduAdapterVersion());
        m.cw(f31696j, "getGdtAdapterVersion：" + getGdtAdapterVersion());
        m.cw(f31696j, "getKlevinAdapterVersion：" + getKlevinAdapterVersion());
        m.cw(f31696j, "getMintegralAdapterVersion：" + getMintegralAdapterVersion());
        m.cw(f31696j, "getSigmobAdapterVersion：" + getSigmobAdapterVersion());
        m.cw(f31696j, "getUnityAdapterVersion：" + getUnityAdapterVersion());
        m.cw(f31696j, "getMap：" + getInitAdnMap());
        m.cw(f31696j, "---------  sdk 初始化信息 end ----");
    }

    private void r() {
        m.cw(f31696j, "---------  sdk 隐私设置 start ----");
        m.cw(f31696j, "isCanUseLocation：" + isCanUseLocation());
        IMediationLocation location = getLocation();
        if (location != null) {
            m.cw(f31696j, "getLocation getLatitude：" + location.getLatitude());
            m.cw(f31696j, "getLocation getLongitude：" + location.getLongitude());
        } else {
            m.cw(f31696j, "getLocation is null");
        }
        m.cw(f31696j, "appList：" + appList());
        m.cw(f31696j, "isCanUsePhoneState：" + isCanUsePhoneState());
        m.cw(f31696j, "isLimitPersonalAds：" + isLimitPersonalAds());
        m.cw(f31696j, "getDevImei：" + getDevImei());
        m.cw(f31696j, "isCanUseWifiState：" + isCanUseWifiState());
        m.cw(f31696j, "getMacAddress：" + getMacAddress());
        m.cw(f31696j, "isCanUseWriteExternal：" + isCanUseWriteExternal());
        m.cw(f31696j, "isCanUseAndroidId：" + isCanUseAndroidId());
        m.cw(f31696j, "getAndroidId：" + getAndroidId());
        m.cw(f31696j, "isCanUseMessage：" + isCanUseMessage());
        List<String> appList = getAppList();
        m.cw(f31696j, "getAppList：".concat(String.valueOf(appList)));
        if (appList != null) {
            Iterator<String> it = appList.iterator();
            while (it.hasNext()) {
                m.cw(f31696j, "getAppList item: ".concat(String.valueOf(it.next())));
            }
        }
        List<String> devImeis = getDevImeis();
        m.cw(f31696j, "getDevImeis：".concat(String.valueOf(devImeis)));
        if (devImeis != null) {
            Iterator<String> it2 = devImeis.iterator();
            while (it2.hasNext()) {
                m.cw(f31696j, "getDevImeis item: ".concat(String.valueOf(it2.next())));
            }
        }
        m.cw(f31696j, "getDevOaid：" + getDevOaid());
        m.cw(f31696j, "isCanUseOaid：" + isCanUseOaid());
        m.cw(f31696j, "isCanUseMacAddress：" + isCanUseMacAddress());
        m.cw(f31696j, "isProgrammaticRecommend：" + isProgrammaticRecommend());
        m.cw(f31696j, "isCanUsePermissionRecordAudio：" + isCanUsePermissionRecordAudio());
        m.cw(f31696j, "---------  sdk 隐私设置 end ----");
    }

    private boolean up() {
        ValueSet valueSet = this.xt;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    private void xt() {
        m.cw(f31696j, "---------  sdk 聚合信息 start ----");
        m.cw(f31696j, "getHttps：" + getHttps());
        m.cw(f31696j, "getWxAppId：" + getWxAppId());
        m.cw(f31696j, "getPublisherDid：" + getPublisherDid());
        m.cw(f31696j, "isOpenAdnTest：" + isOpenAdnTest());
        m.cw(f31696j, "getMediationConfigUserInfoForSegment：" + getMediationConfigUserInfoForSegment());
        m.cw(f31696j, "getLocalExtra：" + getLocalExtra());
        m.cw(f31696j, "getCustomLocalConfig：" + getCustomLocalConfig());
        m.cw(f31696j, "getOpensdkVer：" + getOpensdkVer());
        m.cw(f31696j, "isWxInstalled：" + isWxInstalled());
        m.cw(f31696j, "isSupportH265：" + isSupportH265());
        m.cw(f31696j, "isSupportSplashZoomout：" + isSupportSplashZoomout());
        m.cw(f31696j, "---------  sdk 聚合信息 end ----");
    }

    public boolean appList() {
        ValueSet valueSet = this.cw;
        if (valueSet != null) {
            return valueSet.booleanValue(8026);
        }
        return true;
    }

    public String getAdapterManagerClassName() {
        ValueSet valueSet = this.xt;
        if (valueSet != null) {
            return valueSet.stringValue(8560);
        }
        return null;
    }

    public String getAdmobAdapterVersion() {
        ValueSet valueSet = this.xt;
        return valueSet != null ? valueSet.stringValue(8412) : "";
    }

    public String getAndroidId() {
        ValueSet valueSet = this.cw;
        return valueSet != null ? valueSet.stringValue(8485) : "";
    }

    public List<String> getAppList() {
        Function<SparseArray<Object>, Object> j6;
        ValueSet valueSet = this.cw;
        if (valueSet != null && (j6 = xt.j(valueSet.objectValue(8311, Object.class))) != null) {
            Object obj = b.a(j6) ? c.a(j6).get() : null;
            if (obj instanceof SparseArray) {
                return (List) MediationValueUtil.objectValue(((SparseArray) obj).get(8476), List.class, null);
            }
        }
        return new LinkedList();
    }

    public String getBaiduAdapterVersion() {
        ValueSet valueSet = this.xt;
        return valueSet != null ? valueSet.stringValue(8413) : "";
    }

    public JSONObject getCustomLocalConfig() {
        ValueSet valueSet = this.f31697r;
        if (valueSet != null) {
            return (JSONObject) valueSet.objectValue(8463, JSONObject.class);
        }
        return null;
    }

    public String getDevImei() {
        ValueSet valueSet = this.cw;
        return valueSet != null ? valueSet.stringValue(8484) : "";
    }

    public List<String> getDevImeis() {
        Function<SparseArray<Object>, Object> j6;
        ValueSet valueSet = this.cw;
        if (valueSet != null && (j6 = xt.j(valueSet.objectValue(8311, Object.class))) != null) {
            Object obj = b.a(j6) ? c.a(j6).get() : null;
            if (obj instanceof SparseArray) {
                return (List) MediationValueUtil.objectValue(((SparseArray) obj).get(8477), List.class, null);
            }
        }
        return new LinkedList();
    }

    public String getDevOaid() {
        ValueSet valueSet = this.cw;
        return valueSet != null ? valueSet.stringValue(8486) : "";
    }

    public String getGdtAdapterVersion() {
        ValueSet valueSet = this.xt;
        return valueSet != null ? valueSet.stringValue(8414) : "";
    }

    public String getGromoreVersion() {
        ValueSet valueSet = this.xt;
        return valueSet != null ? valueSet.stringValue(8411) : "";
    }

    public boolean getHttps() {
        ValueSet valueSet = this.f31697r;
        if (valueSet != null) {
            return valueSet.booleanValue(8458);
        }
        return false;
    }

    public Map getInitAdnMap() {
        ValueSet valueSet = this.xt;
        return valueSet != null ? (Map) valueSet.objectValue(8425, Map.class) : new HashMap();
    }

    public String getKlevinAdapterVersion() {
        ValueSet valueSet = this.xt;
        return valueSet != null ? valueSet.stringValue(8415) : "";
    }

    public String getKsAdapterVersion() {
        ValueSet valueSet = this.xt;
        return valueSet != null ? valueSet.stringValue(8410) : "";
    }

    public Map getLocalExtra() {
        ValueSet valueSet = this.f31697r;
        return valueSet != null ? (Map) valueSet.objectValue(8462, Map.class) : new HashMap();
    }

    public IMediationLocation getLocation() {
        Function<SparseArray<Object>, Object> j6;
        Double valueOf = Double.valueOf(0.0d);
        ValueSet valueSet = this.cw;
        if (valueSet != null && (j6 = xt.j(valueSet.objectValue(8312, Object.class))) != null) {
            Object obj = b.a(j6) ? c.a(j6).get() : null;
            if (obj instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) obj;
                final double doubleValue = ((Double) MediationValueUtil.objectValue(sparseArray.get(8481), Double.class, valueOf)).doubleValue();
                final double doubleValue2 = ((Double) MediationValueUtil.objectValue(sparseArray.get(8482), Double.class, valueOf)).doubleValue();
                return new IMediationLocation() { // from class: com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig.1
                    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation
                    public double getLatitude() {
                        return doubleValue;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation
                    public double getLongitude() {
                        return doubleValue2;
                    }
                };
            }
        }
        return null;
    }

    public String getMacAddress() {
        ValueSet valueSet = this.cw;
        return valueSet != null ? valueSet.stringValue(8487) : "";
    }

    public Function getMediationConfigUserInfoForSegment() {
        ValueSet valueSet = this.f31697r;
        if (valueSet != null) {
            return xt.j(valueSet.objectValue(8310, Object.class));
        }
        return null;
    }

    public String getMintegralAdapterVersion() {
        ValueSet valueSet = this.xt;
        return valueSet != null ? valueSet.stringValue(8416) : "";
    }

    public String getOpensdkVer() {
        ValueSet valueSet = this.f31697r;
        return valueSet != null ? valueSet.stringValue(8464) : "";
    }

    public String getPublisherDid() {
        ValueSet valueSet = this.f31697r;
        return valueSet != null ? valueSet.stringValue(8460) : "";
    }

    public String getSigmobAdapterVersion() {
        ValueSet valueSet = this.xt;
        return valueSet != null ? valueSet.stringValue(8417) : "";
    }

    public String getUnityAdapterVersion() {
        ValueSet valueSet = this.xt;
        return valueSet != null ? valueSet.stringValue(8418) : "";
    }

    public ValueSet getValueSet() {
        return this.xt;
    }

    public String getWxAppId() {
        ValueSet valueSet = this.f31697r;
        return valueSet != null ? valueSet.stringValue(8459) : "";
    }

    public boolean isCanUseAndroidId() {
        ValueSet valueSet = this.cw;
        if (valueSet != null) {
            return valueSet.booleanValue(8479);
        }
        return true;
    }

    public boolean isCanUseLocation() {
        ValueSet valueSet = this.cw;
        if (valueSet != null) {
            return valueSet.booleanValue(8024);
        }
        return true;
    }

    public boolean isCanUseMessage() {
        ValueSet valueSet = this.cw;
        if (valueSet != null) {
            return valueSet.booleanValue(8562);
        }
        return true;
    }

    public boolean isCanUseOaid() {
        Function<SparseArray<Object>, Object> j6;
        ValueSet valueSet = this.cw;
        if (valueSet == null || (j6 = xt.j(valueSet.objectValue(8311, Object.class))) == null) {
            return true;
        }
        Object obj = b.a(j6) ? c.a(j6).get() : null;
        if (obj instanceof SparseArray) {
            return ((Boolean) MediationValueUtil.objectValue(((SparseArray) obj).get(8478), Boolean.class, Boolean.FALSE)).booleanValue();
        }
        return true;
    }

    public boolean isCanUsePermissionRecordAudio() {
        ValueSet valueSet = this.cw;
        if (valueSet != null) {
            return valueSet.booleanValue(8549);
        }
        return true;
    }

    public boolean isCanUsePhoneState() {
        ValueSet valueSet = this.cw;
        if (valueSet != null) {
            return valueSet.booleanValue(8023);
        }
        return true;
    }

    public boolean isCanUseWifiState() {
        ValueSet valueSet = this.cw;
        if (valueSet != null) {
            return valueSet.booleanValue(8480);
        }
        return true;
    }

    public boolean isCanUseWriteExternal() {
        ValueSet valueSet = this.cw;
        if (valueSet != null) {
            return valueSet.booleanValue(8025);
        }
        return true;
    }

    public boolean isDebug() {
        ValueSet valueSet = this.xt;
        if (valueSet != null) {
            return valueSet.booleanValue(1);
        }
        return false;
    }

    public boolean isLimitPersonalAds() {
        Function<SparseArray<Object>, Object> j6;
        ValueSet valueSet = this.cw;
        if (valueSet == null || (j6 = xt.j(valueSet.objectValue(8311, Object.class))) == null) {
            return false;
        }
        Object obj = b.a(j6) ? c.a(j6).get() : null;
        if (obj instanceof SparseArray) {
            return ((Boolean) MediationValueUtil.objectValue(((SparseArray) obj).get(8027), Boolean.class, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public boolean isOpenAdnTest() {
        ValueSet valueSet = this.f31697r;
        if (valueSet != null) {
            return valueSet.booleanValue(8461);
        }
        return false;
    }

    public boolean isProgrammaticRecommend() {
        Function<SparseArray<Object>, Object> j6;
        ValueSet valueSet = this.cw;
        if (valueSet == null || (j6 = xt.j(valueSet.objectValue(8311, Object.class))) == null) {
            return true;
        }
        Object obj = b.a(j6) ? c.a(j6).get() : null;
        if (obj instanceof SparseArray) {
            return ((Boolean) MediationValueUtil.objectValue(((SparseArray) obj).get(8028), Boolean.class, Boolean.FALSE)).booleanValue();
        }
        return true;
    }

    public boolean isSupportH265() {
        ValueSet valueSet = this.f31697r;
        if (valueSet != null) {
            return valueSet.booleanValue(8466);
        }
        return false;
    }

    public boolean isSupportSplashZoomout() {
        ValueSet valueSet = this.f31697r;
        if (valueSet != null) {
            return valueSet.booleanValue(8467);
        }
        return false;
    }

    public boolean isWxInstalled() {
        ValueSet valueSet = this.f31697r;
        if (valueSet != null) {
            return valueSet.booleanValue(8465);
        }
        return false;
    }

    public void setMediationCustomControllerValueSet(ValueSet valueSet) {
        this.cw = valueSet;
        r();
    }

    public Map<String, Object> userPrivacyConfig() {
        ValueSet valueSet = this.cw;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8554, Map.class);
        }
        return null;
    }

    private MediationInitConfig(ValueSet valueSet) {
        this.xt = valueSet;
        if (valueSet != null) {
            this.f31697r = a.j((SparseArray) valueSet.objectValue(8457, SparseArray.class)).k();
            this.cw = a.j((SparseArray) this.xt.objectValue(8475, SparseArray.class)).k();
        }
        j();
    }

    private void j() {
        cw();
        r();
        xt();
    }

    public String getADNName() {
        if (up()) {
            return this.xt.stringValue(8003);
        }
        return "";
    }

    public int getAgeGroup() {
        if (up()) {
            return this.xt.intValue(7);
        }
        return 0;
    }

    public String getAppId() {
        if (up()) {
            return this.xt.stringValue(3);
        }
        return null;
    }

    public String getAppKey() {
        if (up()) {
            return this.xt.stringValue(AVMDLDataLoader.KeyIsLiveWatchDurationThreshold);
        }
        return "";
    }

    public String getAppName() {
        if (up()) {
            return this.xt.stringValue(8);
        }
        return "";
    }

    public String getClassName() {
        if (up()) {
            return this.xt.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow);
        }
        return "";
    }

    public Function getCustomGMConfiguration() {
        if (up()) {
            return xt.j(this.xt.objectValue(8401, Object.class));
        }
        return null;
    }

    public MediationCustomInitConfig getCustomInitConfig() {
        if (up()) {
            return (MediationCustomInitConfig) this.xt.objectValue(8099, MediationCustomInitConfig.class);
        }
        return null;
    }

    public ValueSet getCustomInitConfigValueSet() {
        if (up()) {
            return a.j((SparseArray) this.xt.objectValue(8545, SparseArray.class)).k();
        }
        return null;
    }

    public Map getCustomInitMap() {
        if (up()) {
            return (Map) this.xt.objectValue(8400, Map.class);
        }
        return null;
    }

    public Function getInitCallback() {
        if (up()) {
            return xt.j(this.xt.objectValue(8300, Object.class));
        }
        return null;
    }

    public boolean isCanUseMacAddress() {
        return isCanUseWifiState();
    }

    public boolean isCustom() {
        if (up()) {
            return this.xt.booleanValue(8098);
        }
        return false;
    }
}
