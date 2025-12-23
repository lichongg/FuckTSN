package com.kwad.sdk.internal.api;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class AdLabelImpl extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = -4055679938174214490L;
    public String channel;
    public long cpmBidFloor;
    public String historyTitle;
    public String postTitle;
    public String prevTitle;
    public int thirdAge;
    public int thirdGender;
    public String thirdInterest;

    public boolean isAdLabelAppInfoInValid() {
        return TextUtils.isEmpty(this.prevTitle) && TextUtils.isEmpty(this.postTitle) && TextUtils.isEmpty(this.channel) && TextUtils.isEmpty(this.historyTitle);
    }

    public boolean isUserInfoVaild() {
        return this.thirdAge == 0 && this.thirdGender == 0 && TextUtils.isEmpty(this.thirdInterest);
    }
}
