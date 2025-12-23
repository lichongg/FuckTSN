package com.kwad.components.core.request;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.internal.api.AdLabelImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.s;
import com.kwad.sdk.utils.z;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a extends com.kwad.sdk.core.network.d {
    private static boolean WV = true;
    ImpInfo Rw;
    private int WU;

    public a(ImpInfo impInfo) {
        this(impInfo, null);
    }

    private static void a(com.kwad.sdk.core.request.model.g gVar, AdLabelImpl adLabelImpl) {
        int i6 = adLabelImpl.thirdAge;
        if (i6 != 0) {
            gVar.thirdAge = i6;
        }
        int i7 = adLabelImpl.thirdGender;
        if (i7 != 0) {
            gVar.thirdGender = i7;
        }
        if (TextUtils.isEmpty(adLabelImpl.thirdInterest)) {
            return;
        }
        gVar.thirdInterest = adLabelImpl.thirdInterest;
    }

    @Override // com.kwad.sdk.core.network.d
    public boolean needAppList() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.b
    public void onCreate() {
        s.cb(true);
        b.sj().sk();
        super.onCreate();
    }

    private a(ImpInfo impInfo, com.kwad.components.core.request.model.c cVar) {
        this(impInfo, null, false, null);
    }

    private static int c(ImpInfo impInfo) {
        try {
            return impInfo.adScene.getScreenOrientation();
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static String d(ImpInfo impInfo) {
        com.kwad.sdk.service.a.f fVar;
        if (WV && (fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) != null) {
            try {
                return (String) z.callMethodOrThrow(Class.forName("com.kwad.devTools.PosConfigFetcher").newInstance(), "getConfigParamByPosId", Long.valueOf(impInfo.adScene.getPosId()), fVar.getContext());
            } catch (Exception unused) {
                WV = false;
            }
        }
        return "";
    }

    public final void aU(int i6) {
        this.WU = i6;
    }

    public final int getAdNum() {
        return this.Rw.adScene.getAdNum();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public SceneImpl getScene() {
        ImpInfo impInfo = this.Rw;
        if (impInfo != null) {
            return impInfo.adScene;
        }
        return null;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public String getUrl() {
        if (com.kwad.components.ad.f.a.oy.booleanValue()) {
            try {
                if (((com.kwad.sdk.components.a) com.kwad.sdk.components.d.f(com.kwad.sdk.components.a.class)) != null) {
                    return com.kwad.sdk.h.AZ();
                }
            } catch (Throwable unused) {
            }
        }
        return com.kwad.sdk.h.AL();
    }

    public a(com.kwad.components.core.request.model.a aVar) {
        this(aVar.Rw, aVar.Xe, aVar.Xf, aVar.Xh);
        this.WU = aVar.Xg ? 1 : 0;
    }

    public a(ImpInfo impInfo, @Nullable List<String> list, boolean z5, com.kwad.components.core.request.model.c cVar) {
        super(c(impInfo), impInfo.adScene);
        this.Rw = impInfo;
        AdLabelImpl adLabelFromAdScene = impInfo.getAdLabelFromAdScene();
        if (adLabelFromAdScene != null && !adLabelFromAdScene.isAdLabelAppInfoInValid()) {
            a(com.kwad.sdk.core.request.model.a.II(), adLabelFromAdScene);
        }
        JSONArray jSONArray = new JSONArray();
        aa.a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
        putBody("universePhotoInfo", cVar);
        int i6 = this.WU;
        if (i6 > 0) {
            putBody("calledUnionType", i6);
        }
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        String Ei = TextUtils.isEmpty("") ? ((DevelopMangerComponents) com.kwad.sdk.components.d.f(DevelopMangerComponents.class)).Ei() : "";
        if (!TextUtils.isEmpty(Ei)) {
            putBody("universeDebugParam", Ei);
        }
        String d6 = d(impInfo);
        if (!TextUtils.isEmpty(d6)) {
            putBody("sdkDebugReqInfo", d6);
        }
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        if (list != null) {
            putBody("preloadIdList", new JSONArray((Collection) list));
            putBody("preloadCheck", z5);
        }
        putBody("appTag", ag.Qy());
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        String rewardCallbackExtraByKey = this.Rw.getRewardCallbackExtraByKey("thirdUserId");
        com.kwad.sdk.core.request.model.g IP = com.kwad.sdk.core.request.model.g.IP();
        if (rewardCallbackExtraByKey != null) {
            IP.ex(rewardCallbackExtraByKey);
        }
        if (adLabelFromAdScene != null && !adLabelFromAdScene.isUserInfoVaild()) {
            a(IP, adLabelFromAdScene);
        }
        putBody("userInfo", IP);
        if (com.kwad.components.ad.f.a.oy.booleanValue()) {
            try {
                com.kwad.sdk.components.a aVar = (com.kwad.sdk.components.a) com.kwad.sdk.components.d.f(com.kwad.sdk.components.a.class);
                if (aVar != null) {
                    putBody("adBrowseParam", aVar.Eh());
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void a(JSONObject jSONObject, AdLabelImpl adLabelImpl) {
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(adLabelImpl.prevTitle)) {
            aa.putValue(jSONObject2, "prevTitle", adLabelImpl.prevTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.postTitle)) {
            aa.putValue(jSONObject2, "postTitle", adLabelImpl.postTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.historyTitle)) {
            aa.putValue(jSONObject2, "historyTitle", adLabelImpl.historyTitle);
        }
        if (!TextUtils.isEmpty(adLabelImpl.channel)) {
            aa.putValue(jSONObject2, "channel", adLabelImpl.channel);
        }
        aa.putValue(jSONObject, "content", jSONObject2);
        putBody("appInfo", jSONObject);
    }
}
