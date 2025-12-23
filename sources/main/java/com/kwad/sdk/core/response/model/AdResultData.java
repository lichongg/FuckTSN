package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class AdResultData extends BaseResultData implements com.kwad.sdk.core.b {
    private static final String TAG = "AdResultData";
    private static final long serialVersionUID = -818939163644825380L;
    public AdGlobalConfigInfo adGlobalConfigInfo;
    public boolean hasMore;
    public int mAdCacheId;
    private String mAdSource;
    private List<AdTemplate> mAdTemplateList;

    @Nullable
    protected String mOriginalJson;
    private Map<Long, SceneImpl> mRequestAdSceneMap;
    private SceneImpl mScene;
    public PageInfo pageInfo;
    public String pcursor;

    public AdResultData() {
        this.pageInfo = new PageInfo();
        this.mAdTemplateList = new ArrayList();
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean isDataEmpty() {
        return false;
    }

    public static AdResultData createFromResponseJson(String str, SceneImpl sceneImpl) {
        JSONObject jSONObject = new JSONObject(str);
        AdResultData adResultData = new AdResultData(sceneImpl);
        adResultData.parseJson(jSONObject);
        adResultData.mOriginalJson = str;
        return adResultData;
    }

    public static AdVideoPreCacheConfig obtainVideoPreCacheConfig(AdResultData adResultData, int i6) {
        AdVideoPreCacheConfig adVideoPreCacheConfig;
        if (adResultData == null) {
            return null;
        }
        AdGlobalConfigInfo adGlobalConfigInfo = adResultData.adGlobalConfigInfo;
        return (adGlobalConfigInfo == null || (adVideoPreCacheConfig = adGlobalConfigInfo.adVideoPreCacheConfig) == null) ? new AdVideoPreCacheConfig(i6, false) : adVideoPreCacheConfig;
    }

    private static boolean styleMatch(SceneImpl sceneImpl, AdTemplate adTemplate) {
        int i6 = sceneImpl.adStyle;
        int i7 = adTemplate.adStyle;
        return i6 == 13 ? i7 == 13 || i7 == 23 : i6 == i7;
    }

    @NonNull
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AdResultData m123clone() {
        AdResultData adResultData = new AdResultData();
        try {
            adResultData.parseJson(toJson());
            return adResultData;
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
            return adResultData;
        }
    }

    public SceneImpl getAdScene(long j6) {
        Map<Long, SceneImpl> map = this.mRequestAdSceneMap;
        SceneImpl sceneImpl = map != null ? map.get(Long.valueOf(j6)) : null;
        return sceneImpl == null ? new SceneImpl(j6) : sceneImpl;
    }

    public String getAdSource() {
        String str = this.mAdSource;
        return str != null ? str : "network";
    }

    public List<AdTemplate> getAdTemplateList() {
        return this.mAdTemplateList;
    }

    @NonNull
    public List<AdTemplate> getProceedTemplateList() {
        ArrayList arrayList = new ArrayList();
        List<AdTemplate> adTemplateList = getAdTemplateList();
        if (adTemplateList != null) {
            int size = adTemplateList.size();
            for (int i6 = 0; i6 < size; i6++) {
                arrayList.add(adTemplateList.get(i6));
            }
        }
        return arrayList;
    }

    public String getResponseJson() {
        String str = this.mOriginalJson;
        if (str != null) {
            return str;
        }
        JSONObject json = super.toJson();
        aa.putValue(json, "pcursor", this.pcursor);
        aa.a(json, "pageInfo", this.pageInfo);
        aa.putValue(json, "impAdInfo", ((e) d.f(e.class)).as(aa.S(getAdTemplateList()).toString()));
        return json.toString();
    }

    public void setAdSource(String str) {
        this.mAdSource = str;
    }

    public void setAdTemplateList(List<AdTemplate> list) {
        this.mAdTemplateList = list;
    }

    public void setRequestAdSceneList(List<SceneImpl> list) {
        if (list != null) {
            this.mRequestAdSceneMap = new HashMap(list.size());
            for (SceneImpl sceneImpl : list) {
                this.mRequestAdSceneMap.put(Long.valueOf(sceneImpl.getPosId()), sceneImpl);
            }
        }
    }

    public SceneImpl getDefaultAdScene() {
        return getAdScene(getPosId());
    }

    public AdTemplate getFirstAdTemplate() {
        List<AdTemplate> adTemplateList = getAdTemplateList();
        if (adTemplateList != null && adTemplateList.size() != 0) {
            return adTemplateList.get(0);
        }
        return null;
    }

    public long getPosId() {
        List<AdTemplate> proceedTemplateList = getProceedTemplateList();
        if (proceedTemplateList.size() == 0) {
            return 0L;
        }
        return proceedTemplateList.get(0).posId;
    }

    public boolean isAdResultDataEmpty() {
        List<AdTemplate> adTemplateList = getAdTemplateList();
        if (adTemplateList.isEmpty()) {
            c.w(TAG, "adTemplateList is empty");
            return true;
        }
        c.d(TAG, "adTemplateList size = " + adTemplateList.size());
        List<AdInfo> list = adTemplateList.get(0).adInfoList;
        if (list.isEmpty()) {
            c.w(TAG, "adInfoList is empty");
            return true;
        }
        if (list.get(0) != null) {
            return false;
        }
        c.w(TAG, "adInfo is null");
        return true;
    }

    public boolean isBidding() {
        List<AdTemplate> proceedTemplateList = getProceedTemplateList();
        if (proceedTemplateList.size() == 0 || com.kwad.sdk.core.response.b.e.ez(proceedTemplateList.get(0)) <= 0) {
            return false;
        }
        return true;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        JSONArray jSONArray;
        super.parseJson(jSONObject);
        if (jSONObject != null) {
            try {
                this.pcursor = jSONObject.optString("pcursor");
                this.hasMore = jSONObject.optBoolean("hasMore");
                String optString = jSONObject.optString("adGlobalConfigInfo");
                e eVar = (e) d.f(e.class);
                if (!bp.isNullString(optString)) {
                    String responseData = eVar.getResponseData(optString);
                    AdGlobalConfigInfo adGlobalConfigInfo = new AdGlobalConfigInfo();
                    this.adGlobalConfigInfo = adGlobalConfigInfo;
                    adGlobalConfigInfo.parseJson(new JSONObject(responseData));
                    ag.c(ServiceProvider.getContext(), this.adGlobalConfigInfo.uaidEnable);
                }
                try {
                    String optString2 = jSONObject.optString("pageInfo");
                    if (!bp.isNullString(optString2)) {
                        this.pageInfo.parseJson(new JSONObject(eVar.getResponseData(optString2)));
                    }
                } catch (Exception e6) {
                    c.d("json bug", e6.toString());
                    c.printStackTrace(e6);
                }
                String optString3 = jSONObject.optString("impAdInfo");
                if (!TextUtils.isEmpty(optString3)) {
                    String responseData2 = eVar.getResponseData(optString3);
                    try {
                        if (!bp.isNullString(responseData2)) {
                            try {
                                jSONArray = new JSONArray(responseData2);
                            } catch (Throwable unused) {
                                com.kwad.sdk.commercial.e.a.a(this.mScene, this.llsid, optString3, responseData2);
                                jSONArray = null;
                            }
                            if (jSONArray != null && jSONArray.length() > 0) {
                                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                                    JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                                    if (optJSONObject != null) {
                                        AdTemplate adTemplate = new AdTemplate();
                                        adTemplate.parseJson(optJSONObject);
                                        adTemplate.llsid = this.llsid;
                                        adTemplate.extra = this.extra;
                                        adTemplate.mAdScene = getAdScene(adTemplate.posId);
                                        adTemplate.mPageInfo = this.pageInfo;
                                        this.mAdTemplateList.add(adTemplate);
                                        com.kwad.sdk.commercial.e.a.bM(adTemplate);
                                        SceneImpl sceneImpl = this.mScene;
                                        if (sceneImpl != null && !styleMatch(sceneImpl, adTemplate)) {
                                            int i7 = adTemplate.adStyle;
                                            adTemplate.adStyle = this.mScene.adStyle;
                                            com.kwad.sdk.commercial.e.a.c(adTemplate, "ad_style", String.valueOf(i7));
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                        com.kwad.sdk.commercial.e.a.a(this.mScene, this.llsid, optString3);
                    }
                }
            } catch (Throwable th) {
                c.printStackTrace(th);
            }
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        aa.putValue(json, "pcursor", this.pcursor);
        aa.putValue(json, "hasMore", this.hasMore);
        aa.a(json, "pageInfo", this.pageInfo);
        aa.putValue(json, "impAdInfo", getAdTemplateList());
        aa.a(json, "adGlobalConfigInfo", this.adGlobalConfigInfo);
        int i6 = this.mAdCacheId;
        if (i6 != 0) {
            aa.putValue(json, "adCacheId", i6);
        }
        return json;
    }

    public AdResultData(SceneImpl sceneImpl) {
        this.pageInfo = new PageInfo();
        this.mAdTemplateList = new ArrayList();
        this.mScene = sceneImpl;
        if (sceneImpl != null) {
            HashMap hashMap = new HashMap(1);
            this.mRequestAdSceneMap = hashMap;
            hashMap.put(Long.valueOf(sceneImpl.getPosId()), sceneImpl);
        }
    }

    public AdResultData(BaseResultData baseResultData, SceneImpl sceneImpl, List<AdTemplate> list) {
        this(sceneImpl);
        if (baseResultData == null) {
            return;
        }
        super.parseJson(baseResultData.baseToJson());
        if (list != null) {
            getAdTemplateList().addAll(list);
        }
    }

    public AdResultData(List<SceneImpl> list) {
        this.pageInfo = new PageInfo();
        this.mAdTemplateList = new ArrayList();
        setRequestAdSceneList(list);
    }
}
