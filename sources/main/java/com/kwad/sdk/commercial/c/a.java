package com.kwad.sdk.commercial.c;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class a extends com.kwad.sdk.core.response.a.a {
    public int adOperationType;
    public int campaignType;
    public long creativeId;
    public int errorCode;
    public String errorMsg;
    public int industryFirstLevelId;
    public long llsid;
    public int ocpcActionType;
    public long posId;
    public String templateId;
    public String templateVersion;
    public int tkPublishType;
    public int webUriSourceType;

    public a setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate != null) {
            this.creativeId = e.ev(adTemplate);
            this.llsid = e.ei(adTemplate);
            this.posId = e.ee(adTemplate);
            AdInfo el = e.el(adTemplate);
            this.campaignType = com.kwad.sdk.core.response.b.a.m121do(el);
            this.ocpcActionType = com.kwad.sdk.core.response.b.a.dp(el);
            this.industryFirstLevelId = com.kwad.sdk.core.response.b.a.dq(el);
            this.adOperationType = com.kwad.sdk.core.response.b.a.aQ(el);
            this.webUriSourceType = com.kwad.sdk.core.response.b.a.dr(el);
            AdMatrixInfo.MatrixTemplate bf = d.bf(adTemplate);
            if (bf != null) {
                this.templateId = bf.templateId;
                this.templateVersion = String.valueOf(bf.templateVersionCode);
                this.tkPublishType = bf.publishType;
            }
        }
        return this;
    }

    public a setErrorCode(int i6) {
        this.errorCode = i6;
        return this;
    }

    public a setErrorMsg(String str) {
        this.errorMsg = str;
        return this;
    }

    public a setLlsid(long j6) {
        this.llsid = j6;
        return this;
    }

    public a setPosId(long j6) {
        this.posId = j6;
        return this;
    }
}
