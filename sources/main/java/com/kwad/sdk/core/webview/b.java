package com.kwad.sdk.core.webview;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.widget.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b {
    public ViewGroup TG;
    public WebView Ta;
    public g aMN;

    @Nullable
    public an aMO;
    public boolean aMP = true;
    public boolean aMQ = true;
    private List<AdTemplate> aMR = null;
    private AdResultData mAdResultData;

    @Nullable
    public JSONObject mReportExtData;
    public int mScreenOrientation;

    public final List<AdTemplate> KI() {
        List<AdTemplate> list = this.aMR;
        if (list != null && list.size() > 0) {
            return this.aMR;
        }
        AdResultData adResultData = this.mAdResultData;
        if (adResultData != null) {
            return adResultData.getAdTemplateList();
        }
        return null;
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
    }

    public final AdTemplate getAdTemplate() {
        List<AdTemplate> list = this.aMR;
        return (list == null || list.size() <= 0) ? com.kwad.sdk.core.response.b.c.r(this.mAdResultData) : this.aMR.get(0);
    }

    public final Context getContext() {
        WebView webView = this.Ta;
        if (webView == null) {
            return null;
        }
        return webView.getContext();
    }

    public final AdResultData iu() {
        AdResultData adResultData = this.mAdResultData;
        if (adResultData != null) {
            return adResultData;
        }
        if (this.aMR == null) {
            return null;
        }
        AdResultData adResultData2 = new AdResultData();
        adResultData2.setAdTemplateList(this.aMR);
        return adResultData2;
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.aMR = arrayList;
        arrayList.add(adTemplate);
    }

    public final void setAdTemplateList(List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        this.aMR = arrayList;
    }

    public final boolean KJ() {
        if (KI() != null && KI().size() != 0) {
            return false;
        }
        return true;
    }

    public final AdTemplate dk(String str) {
        if (TextUtils.isEmpty(str)) {
            return getAdTemplate();
        }
        List<AdTemplate> KI = KI();
        if (KI == null) {
            return null;
        }
        for (AdTemplate adTemplate : KI) {
            if (bp.isEquals(str, String.valueOf(com.kwad.sdk.core.response.b.e.ev(adTemplate)))) {
                return adTemplate;
            }
        }
        return null;
    }
}
