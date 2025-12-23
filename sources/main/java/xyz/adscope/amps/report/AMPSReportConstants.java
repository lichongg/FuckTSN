package xyz.adscope.amps.report;

import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSReportConstants {
    public static final String ACCESS_KEY = "AMPS";
    public static final String ACCESS_TYPE_SDK = "sdk";
    public static final String CURRENCY = "CNY";
    public static final String CUSTOM_ID = "mediation5";
    public static final String CUSTOM_LOGGER = "xyz.adscope.amps";
    public static final String EVENT_TIME_KEY = "eventTime";
    public static final String LMT_NO_PERMIT = "0";
    public static final String LMT_PERMIT = "1";
    public static final String LOG_VERSION = "5.0.0";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum LOAD_TYPE {
        LOAD_TYPE_NORMAL(0, PrerollVideoResponse.NORMAL),
        LOAD_TYPE_PRELOAD(1, "preload"),
        LOAD_TYPE_AUTO(2, "auto");

        private int code;
        private String value;

        public int getCode() {
            return this.code;
        }

        public String getValue() {
            return this.value;
        }

        LOAD_TYPE(int i6, String str) {
            this.code = i6;
            this.value = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum REPORT_AD_TYPE {
        AD_TYPE_REWARD_VIDEO("1", MediationConstant.RIT_TYPE_REWARD_VIDEO),
        AD_TYPE_SPLASH("2", "splash"),
        AD_TYPE_INTERSTITIAL("3", MediationConstant.RIT_TYPE_INTERSTITIAL),
        AD_TYPE_NATIVE_EXPRESS("7", "nativeExpress"),
        AD_TYPE_NATIVE_UNIFIED("6", "nativeUnified"),
        AD_TYPE_BANNER("4", "banner");

        private String code;
        private String value;

        public String getCode() {
            return this.code;
        }

        public String getValue() {
            return this.value;
        }

        REPORT_AD_TYPE(String str, String str2) {
            this.code = str;
            this.value = str2;
        }
    }
}
