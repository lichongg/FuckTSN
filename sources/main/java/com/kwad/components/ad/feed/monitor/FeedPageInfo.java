package com.kwad.components.ad.feed.monitor;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class FeedPageInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    private static final long serialVersionUID = -1423277713849754339L;
    public String abParams;
    public int adNum;
    public int callbackType;
    public long convertDuration;
    public int expectedRenderType;
    public String extMsg;
    public long loadDataDuration;
    public int loadStatus;
    public long loadType;
    public List<a> materialInfoList = new ArrayList();
    public int materialType;
    public String materialUrl;
    public long renderDuration;
    public int renderType;
    public long resourceLoadDuration;
    public int status;
    public int type;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public long creativeId;
        public int materialType;
        public String materialUrl;

        public final a D(int i6) {
            this.materialType = i6;
            return this;
        }

        public final a i(long j6) {
            this.creativeId = j6;
            return this;
        }

        public final a t(String str) {
            this.materialUrl = str;
            return this;
        }
    }

    public FeedPageInfo setAbParams(String str) {
        this.abParams = str;
        return this;
    }

    public FeedPageInfo setAdNum(int i6) {
        this.adNum = i6;
        return this;
    }

    public FeedPageInfo setCallbackType(int i6) {
        this.callbackType = i6;
        return this;
    }

    public FeedPageInfo setConvertDuration(long j6) {
        this.convertDuration = j6;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public FeedPageInfo setErrorCode(int i6) {
        super.setErrorCode(i6);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public FeedPageInfo setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }

    public FeedPageInfo setExpectedRenderType(int i6) {
        this.expectedRenderType = i6;
        return this;
    }

    public FeedPageInfo setExtMsg(String str) {
        this.extMsg = str;
        return this;
    }

    public FeedPageInfo setLoadDataDuration(long j6) {
        this.loadDataDuration = j6;
        return this;
    }

    public FeedPageInfo setLoadStatus(int i6) {
        this.loadStatus = i6;
        return this;
    }

    public FeedPageInfo setLoadType(long j6) {
        this.loadType = j6;
        return this;
    }

    public FeedPageInfo setMaterialInfoList(List<a> list) {
        this.materialInfoList = list;
        return this;
    }

    public FeedPageInfo setMaterialType(int i6) {
        this.materialType = i6;
        return this;
    }

    public FeedPageInfo setMaterialUrl(String str) {
        this.materialUrl = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public FeedPageInfo setPosId(long j6) {
        return (FeedPageInfo) super.setPosId(j6);
    }

    public FeedPageInfo setRenderDuration(long j6) {
        this.renderDuration = j6;
        return this;
    }

    public FeedPageInfo setRenderType(int i6) {
        this.renderType = i6;
        return this;
    }

    public FeedPageInfo setResourceLoadDuration(long j6) {
        this.resourceLoadDuration = j6;
        return this;
    }

    public FeedPageInfo setStatus(int i6) {
        this.status = i6;
        return this;
    }

    public FeedPageInfo setType(int i6) {
        this.type = i6;
        return this;
    }
}
