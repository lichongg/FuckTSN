package com.baidu.mobads.sdk.api;

import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CPUAggregationRequest {
    private HashMap<String, Object> mParameters;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.baidu.mobads.sdk.api.CPUAggregationRequest$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {
        private HashMap<String, Object> mExtras = new HashMap<>();

        public CPUAggregationRequest build() {
            return new CPUAggregationRequest(this, null);
        }

        public Builder setAccessType(int i6) {
            this.mExtras.put("accessType", Integer.valueOf(i6));
            return this;
        }

        public Builder setCity(String str) {
            this.mExtras.put(DistrictSearchQuery.KEYWORDS_CITY, str);
            return this;
        }

        public Builder setCustomUserId(String str) {
            this.mExtras.put("outerUid", str);
            return this;
        }

        public Builder setLpDarkMode(boolean z5) {
            if (z5) {
                this.mExtras.put("preferscolortheme", "dark");
                return this;
            }
            this.mExtras.put("preferscolortheme", "light");
            return this;
        }

        public Builder setLpFontSize(CpuLpFontSize cpuLpFontSize) {
            this.mExtras.put("prefersfontsize", cpuLpFontSize.getValue());
            return this;
        }

        public Builder setSubChannelId(String str) {
            this.mExtras.put("subChannelId", str);
            return this;
        }

        public Builder addExtra(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                this.mExtras.put(str, str2);
            }
            return this;
        }
    }

    /* synthetic */ CPUAggregationRequest(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private CPUAggregationRequest(Builder builder) {
        this.mParameters = new HashMap<>();
        if (builder == null || builder.mExtras == null) {
            return;
        }
        this.mParameters = builder.mExtras;
    }

    public HashMap<String, Object> getExtras() {
        return this.mParameters;
    }
}
