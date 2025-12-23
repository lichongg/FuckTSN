package com.kwad.sdk.core.response.model;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class AdStatusInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = 3728247893272878881L;
    public long downloadFinishTime;
    public long downloadSize;
    public int downloadStatus;
    public int downloadType;
    public long loadDataTime;
    public boolean loadFromCache;

    public long getDownloadFinishTime() {
        return this.downloadFinishTime;
    }

    public long getDownloadSize() {
        return this.downloadSize;
    }

    public int getDownloadStatus() {
        return this.downloadStatus;
    }

    public int getDownloadType() {
        return this.downloadType;
    }

    public long getLoadDataTime() {
        return this.loadDataTime;
    }

    public boolean isLoadFromCache() {
        return this.loadFromCache;
    }

    public void setDownloadFinishTime(long j6) {
        this.downloadFinishTime = j6;
    }

    public void setDownloadSize(long j6) {
        this.downloadSize = j6;
    }

    public void setDownloadStatus(int i6) {
        this.downloadStatus = i6;
    }

    public void setDownloadType(int i6) {
        this.downloadType = i6;
    }

    public void setLoadDataTime(long j6) {
        this.loadDataTime = j6;
    }

    public void setLoadFromCache(boolean z5) {
        this.loadFromCache = z5;
    }
}
