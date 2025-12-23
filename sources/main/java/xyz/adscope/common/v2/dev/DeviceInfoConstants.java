package xyz.adscope.common.v2.dev;

import com.huawei.hms.feature.dynamic.f.e;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class DeviceInfoConstants {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface CarrierType {
        public static final String CARRIER_CMCC = "CMCC";
        public static final String CARRIER_CTCC = "CTCC";
        public static final String CARRIER_CUCC = "CUCC";
        public static final String CARRIER_UNKNOWN = "UNKNOW";
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum ConnectType {
        CONNECT_TYPE_UNKNOWN(0, "unknown"),
        CONNECT_TYPE_WIFI(1, "wifi"),
        CONNECT_TYPE_2G(2, "2G"),
        CONNECT_TYPE_3G(3, "3G"),
        CONNECT_TYPE_4G(4, "4G"),
        CONNECT_TYPE_5G(5, "5G");

        private final int code;
        private final String value;

        public int getCode() {
            return this.code;
        }

        public String getValue() {
            return this.value;
        }

        ConnectType(int i6, String str) {
            this.code = i6;
            this.value = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum CountryType {
        COUNTRY_OTHER_TYPE(0, "OTHER"),
        COUNTRY_CHINA_TYPE(1, e.f33257e);

        private final int code;
        private final String country;

        public int getCode() {
            return this.code;
        }

        public String getCountry() {
            return this.country;
        }

        CountryType(int i6, String str) {
            this.code = i6;
            this.country = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface DeviceType {
        public static final int TYPE_PHONE = 100;
        public static final int TYPE_TABLET = 101;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface IndividuationState {
        public static final int CONFIG_INDIVIDUATION_DENIED = 1;
        public static final int CONFIG_INDIVIDUATION_GRANTED = 0;
        public static final int INDIVIDUATION_DENIED = 0;
        public static final int INDIVIDUATION_GRANTED = 1;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OperatorSystemType {
        public static final int OS_ANDROID = 2;
        public static final int OS_IOS = 13;
        public static final int OS_IOS_TV = 3;
        public static final int OS_PS4 = 22;
        public static final int OS_UNKNOWN = 0;
    }
}
