package com.kwad.components.ad.reward.check;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class RewardCheckMonitorInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    public static final int CHECK_TYPE_EXPOSURE = 1;
    public static final int CHECK_TYPE_REWARD = 2;
    public static final int ENVI_TYPE_NATIVE = 0;
    public static final int ENVI_TYPE_TK = 1;
    public static final int REQUEST_STATE_END = 2;
    public static final int REQUEST_STATE_START = 1;
    public static final long serialVersionUID = 1080394611500009098L;
    public int checkType;
    public int code;
    public long creativeId;
    public long dataLoadInterval;
    public int enviType;
    public long posId;
    public int requestStatus;

    public RewardCheckMonitorInfo setCheckType(int i6) {
        this.checkType = i6;
        return this;
    }

    public RewardCheckMonitorInfo setCode(int i6) {
        this.code = i6;
        return this;
    }

    public RewardCheckMonitorInfo setCreativeId(long j6) {
        this.creativeId = j6;
        return this;
    }

    public RewardCheckMonitorInfo setDataLoadInterval(long j6) {
        this.dataLoadInterval = j6;
        return this;
    }

    public RewardCheckMonitorInfo setEnviType(int i6) {
        this.enviType = i6;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public RewardCheckMonitorInfo setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }

    public RewardCheckMonitorInfo setRequestStatus(int i6) {
        this.requestStatus = i6;
        return this;
    }
}
