package xyz.adscope.amps.common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSEnum {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum AMPSSDKInitStatus {
        AMPSAdSDKInitStatusNormal(0, "sdk Init status normal"),
        AMPSAdSDKInitStatusLoading(1, "sdk Init status loading"),
        AMPSAdSDKInitStatusSuccess(2, "sdk Init status success"),
        AMPSAdSDKInitStatusFail(3, "sdk Init status fail"),
        AMPSAdSDKInitStatusFailRepeat(4, "sdk Init status fail repeat");

        private int code;
        private String msg;

        public int getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }

        AMPSSDKInitStatus(int i6, String str) {
            this.code = i6;
            this.msg = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum AdapterNameEnum {
        ASNP_ADAPTER_NAME("AMPSASNPSDKManagerAdapter"),
        GDT_ADAPTER_NAME("AMPSGDTSDKManagerAdapter"),
        CSJ_ADAPTER_NAME("AMPSCSJSDKManagerAdapter"),
        GroMore_ADAPTER_NAME("AMPSGROMORESDKManagerAdapter"),
        KS_ADAPTER_NAME("AMPSKSSDKManagerAdapter"),
        ALL_ADAPTER_NAME("AMPSALLSDKManagerAdapter");

        private String value;

        public String getValue() {
            return this.value;
        }

        AdapterNameEnum(String str) {
            this.value = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum AutoPlayEnum {
        HAS_NET_AUTO_PLAY(1),
        NO_AUTO_PLAY(0),
        WIFI_AUTO_PLAY(2);

        private int autoPlayStatus;

        public int getAutoPlayValue() {
            return this.autoPlayStatus;
        }

        AutoPlayEnum(int i6) {
            this.autoPlayStatus = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum ChannelInitStatus {
        INIT_STATUS_SUCCESS(true),
        INIT_STATUS_FAIL(false);

        private boolean value;

        public boolean getValue() {
            return this.value;
        }

        ChannelInitStatus(boolean z5) {
            this.value = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum ChannelSdkName {
        CHANNEL_SDK_KS("KS"),
        CHANNEL_SDK_CSJ(AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_CSJ),
        CHANNEL_SDK_GM(AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_GM),
        CHANNEL_SDK_GDT(AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_GDT),
        CHANNEL_SDK_YJ4(AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_ASNP),
        CHANNEL_SDK_YJ5(AMPSConstants.AMPS_CHANNEL_NETWORK_NAME_BZ);

        private String sdkType;

        public String getSdkType() {
            return this.sdkType;
        }

        ChannelSdkName(String str) {
            this.sdkType = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum OrientationEnum {
        ORIENTATION_PORTRAIT("2"),
        ORIENTATION_LANDSCAPE("1"),
        ORIENTATION_COMMON("3");

        private String orientation;

        public String getOrientation() {
            return this.orientation;
        }

        OrientationEnum(String str) {
            this.orientation = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum SupportPersonalizedEnum {
        SUPPORT_PERSONAL_RECOMMEND("1"),
        NO_SUPPORT_PERSONAL_RECOMMEND("0");

        private String value;

        public String getValue() {
            return this.value;
        }

        SupportPersonalizedEnum(String str) {
            this.value = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum VideoSoundEnum {
        SUPPORT_VIDEO_SOUND(1),
        NO_SUPPORT_VIDEO_SOUND(0);

        private int hasSound;

        public int getHasSound() {
            return this.hasSound;
        }

        VideoSoundEnum(int i6) {
            this.hasSound = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum ZoomOutEnum {
        SUPPORT_ZOOM_OUT("1"),
        NO_SUPPORT_ZOOM_OUT("0");

        private String zoomOutValue;

        public String getZoomOutValue() {
            return this.zoomOutValue;
        }

        ZoomOutEnum(String str) {
            this.zoomOutValue = str;
        }
    }
}
