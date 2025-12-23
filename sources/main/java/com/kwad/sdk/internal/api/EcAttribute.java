package com.kwad.sdk.internal.api;

import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class EcAttribute implements Serializable {
    private static final long serialVersionUID = 5648759570127504312L;
    private String comment;
    private String promoteId;
    private long userCommRateBuying = 0;
    private long userCommRateSharing = 0;

    public String getComment() {
        return this.comment;
    }

    public String getPromoteId() {
        return this.promoteId;
    }

    public long getUserCommRateBuying() {
        return this.userCommRateBuying;
    }

    public long getUserCommRateSharing() {
        return this.userCommRateSharing;
    }

    public void setComment(String str) {
        if (str == null) {
            str = "";
        }
        this.comment = str;
    }

    public void setPromoteId(String str) {
        if (str == null) {
            str = "";
        }
        this.promoteId = str;
    }

    public void setUserCommRateBuying(long j6) {
        this.userCommRateBuying = j6;
    }

    public void setUserCommRateSharing(long j6) {
        this.userCommRateSharing = j6;
    }
}
