package com.kwad.components.ad.feed.monitor;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class FeedErrorInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    private static final long serialVersionUID = 5562303989639679849L;
    public long errorType;
    public long feedType;
    public long materialType;
    public long width;

    public FeedErrorInfo setErrorType(int i6) {
        this.errorType = i6;
        return this;
    }

    public FeedErrorInfo setFeedType(int i6) {
        this.feedType = i6;
        return this;
    }

    public FeedErrorInfo setMaterialType(long j6) {
        this.materialType = j6;
        return this;
    }

    public FeedErrorInfo setWidth(long j6) {
        this.width = j6;
        return this;
    }
}
