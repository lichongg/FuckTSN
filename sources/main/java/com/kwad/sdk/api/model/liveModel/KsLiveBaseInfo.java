package com.kwad.sdk.api.model.liveModel;

import androidx.annotation.Keep;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsLiveBaseInfo implements Serializable {
    private static final long serialVersionUID = 6107250137063788330L;
    private long liveDisplayWatchingCount;
    private String portraitUrl;
    private String userName;

    public long getLiveDisplayWatchingCount() {
        return this.liveDisplayWatchingCount;
    }

    public String getPortraitUrl() {
        return this.portraitUrl;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setLiveDisplayWatchingCount(long j6) {
        this.liveDisplayWatchingCount = j6;
    }

    public void setPortraitUrl(String str) {
        this.portraitUrl = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String toString() {
        return "KsLiveBaseInfo{portraitUrl='" + this.portraitUrl + "', userName='" + this.userName + "', liveDisplayWatchingCount=" + this.liveDisplayWatchingCount + '}';
    }
}
