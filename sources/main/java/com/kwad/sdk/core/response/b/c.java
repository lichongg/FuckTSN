package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    public static <R extends AdResultData, T extends AdTemplate> T a(R r5, String str) {
        if (r5 == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            Iterator<AdTemplate> it = r5.getAdTemplateList().iterator();
            while (it.hasNext()) {
                T t5 = (T) it.next();
                if (String.valueOf(e.el(t5).adBaseInfo.creativeId).equals(str)) {
                    return t5;
                }
            }
        }
        return (T) r5.getFirstAdTemplate();
    }

    public static boolean u(AdResultData adResultData) {
        AdGlobalConfigInfo.CycleAggregationInfo t5;
        if (adResultData == null || adResultData.getAdTemplateList() == null || adResultData.getAdTemplateList().size() <= 1 || (t5 = t(adResultData)) == null) {
            return false;
        }
        return t5.cycleAggregationSwitch;
    }

    public static AdResultData dW(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return null;
        }
        return adTemplate.createAdResultData();
    }

    public static <R extends AdResultData, T extends AdTemplate> T r(R r5) {
        if (r5 == null) {
            return null;
        }
        return (T) r5.getFirstAdTemplate();
    }

    public static AdGlobalConfigInfo.CycleAggregationInfo t(AdResultData adResultData) {
        AdGlobalConfigInfo adGlobalConfigInfo;
        if (adResultData == null || (adGlobalConfigInfo = adResultData.adGlobalConfigInfo) == null) {
            return null;
        }
        return adGlobalConfigInfo.cycleAggregationInfo;
    }

    public static AdInfo s(AdResultData adResultData) {
        AdTemplate firstAdTemplate = adResultData.getFirstAdTemplate();
        if (firstAdTemplate == null) {
            return null;
        }
        return e.el(firstAdTemplate);
    }

    public static <T extends AdResultData> AdResultData a(AdResultData adResultData, AdTemplate adTemplate) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(adTemplate);
        AdResultData m123clone = adResultData.m123clone();
        m123clone.setAdTemplateList(arrayList);
        return m123clone;
    }
}
