package com.baidu.mobads.sdk.api;

import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CPUWebAdRequestParam {
    private static final String DARK_MODE = "dark";
    private static final String LIGHT_MODE = "light";
    private final Map<String, Object> mParameters;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.baidu.mobads.sdk.api.CPUWebAdRequestParam$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {
        private HashMap<String, Object> mExtras = new HashMap<>();

        public CPUWebAdRequestParam build() {
            return new CPUWebAdRequestParam(this, null);
        }

        public Builder setCityIfLocalChannel(String str) {
            this.mExtras.put(DistrictSearchQuery.KEYWORDS_CITY, str);
            return this;
        }

        public Builder setCustomUserId(String str) {
            this.mExtras.put("outerId", str);
            return this;
        }

        public Builder setLpDarkMode(boolean z5) {
            this.mExtras.put("preferscolortheme", z5 ? CPUWebAdRequestParam.DARK_MODE : CPUWebAdRequestParam.LIGHT_MODE);
            return this;
        }

        public Builder setLpFontSize(CpuLpFontSize cpuLpFontSize) {
            this.mExtras.put("prefersfontsize", cpuLpFontSize.getValue());
            return this;
        }

        public Builder setSubChannelId(String str) {
            this.mExtras.put("scid", str);
            return this;
        }

        public Builder addExtra(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                this.mExtras.put(str, str2);
            }
            return this;
        }
    }

    /* synthetic */ CPUWebAdRequestParam(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private CPUWebAdRequestParam(Builder builder) {
        HashMap hashMap = new HashMap();
        this.mParameters = hashMap;
        if (builder == null || builder.mExtras == null) {
            return;
        }
        hashMap.putAll(builder.mExtras);
    }

    public Map<String, Object> getParameters() {
        return this.mParameters;
    }
}
