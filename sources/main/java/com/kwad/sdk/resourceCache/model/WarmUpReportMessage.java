package com.kwad.sdk.resourceCache.model;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.c.a;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class WarmUpReportMessage extends a implements Serializable {
    public static final int STATUS_DOWNLOAD_FAILED = 3;
    public static final int STATUS_DOWNLOAD_SUCCESS = 2;
    public static final int STATUS_MD5_ERROR = 4;
    public static final int STATUS_START = 1;
    private static final long serialVersionUID = 368743526206619387L;
    public String configItems;
    public int downloadStatus;
    public long freeDisk;
    public String localItems;
    public String resourceKey;
    public int resourceType;
    public String url;

    public WarmUpReportMessage setConfigItems(String str) {
        this.configItems = str;
        return this;
    }

    public WarmUpReportMessage setDownloadStatus(int i6) {
        this.downloadStatus = i6;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public WarmUpReportMessage setErrorCode(int i6) {
        this.errorCode = i6;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public WarmUpReportMessage setErrorMsg(String str) {
        this.errorMsg = str;
        return this;
    }

    public WarmUpReportMessage setFreeDisk(long j6) {
        this.freeDisk = j6;
        return this;
    }

    public WarmUpReportMessage setLocalItems(String str) {
        this.localItems = str;
        return this;
    }

    public WarmUpReportMessage setResourceKey(String str) {
        this.resourceKey = str;
        return this;
    }

    public WarmUpReportMessage setResourceType(int i6) {
        this.resourceType = i6;
        return this;
    }

    public WarmUpReportMessage setUrl(String str) {
        this.url = str;
        return this;
    }
}
