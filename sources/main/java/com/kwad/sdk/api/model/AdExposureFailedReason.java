package com.kwad.sdk.api.model;

import android.text.TextUtils;
import androidx.annotation.Keep;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class AdExposureFailedReason {
    public String adRequestId;
    public String adTitle;
    public String adUserName;
    public String adnMaterialUrl;
    public String adnName;
    public int winEcpm = -9999;
    public int adnType = -9999;
    public int isShow = -9999;
    public int isClick = -9999;
    public int adnMaterialType = -9999;

    public AdExposureFailedReason setAdRequestId(String str) {
        this.adRequestId = str;
        return this;
    }

    public AdExposureFailedReason setAdTitle(String str) {
        this.adTitle = str;
        return this;
    }

    public AdExposureFailedReason setAdUserName(String str) {
        this.adUserName = str;
        return this;
    }

    public AdExposureFailedReason setAdnMaterialType(int i6) {
        this.adnMaterialType = i6;
        return this;
    }

    public AdExposureFailedReason setAdnName(String str) {
        this.adnName = str;
        return this;
    }

    public AdExposureFailedReason setAdnType(int i6) {
        this.adnType = i6;
        return this;
    }

    public AdExposureFailedReason setIsClick(int i6) {
        this.isClick = i6;
        return this;
    }

    public AdExposureFailedReason setIsShow(int i6) {
        this.isShow = i6;
        return this;
    }

    public AdExposureFailedReason setWinEcpm(int i6) {
        this.winEcpm = i6;
        return this;
    }

    public AdExposureFailedReason setAdnMaterialUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.adnMaterialUrl = URLEncoder.encode(str, "UTF-8");
                return this;
            } catch (UnsupportedEncodingException unused) {
                this.adnMaterialUrl = "";
            }
        }
        return this;
    }
}
