package xyz.adscope.common.info.deviceinfo;

import com.huawei.hms.feature.dynamic.f.e;
import xyz.adscope.common.v2.dev.DeviceInfoConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class DeviceInfoEnum {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum CARRIER_TYPE {
        CARRIER_CMCC(DeviceInfoConstants.CarrierType.CARRIER_CMCC),
        CARRIER_CUCC(DeviceInfoConstants.CarrierType.CARRIER_CUCC),
        CARRIER_CTCC(DeviceInfoConstants.CarrierType.CARRIER_CTCC),
        CARRIER_UNKNOWN(DeviceInfoConstants.CarrierType.CARRIER_UNKNOWN);


        /* renamed from: a, reason: collision with root package name */
        private String f56403a;

        public String getValue() {
            return this.f56403a;
        }

        CARRIER_TYPE(String str) {
            this.f56403a = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum CONNECT_TYPE {
        CONNECT_TYPE_UNKNOWN(0, "unknown"),
        CONNECT_TYPE_WIFI(1, "wifi"),
        CONNECT_TYPE_2G(2, "2G"),
        CONNECT_TYPE_3G(3, "3G"),
        CONNECT_TYPE_4G(4, "4G"),
        CONNECT_TYPE_5G(5, "5G");


        /* renamed from: a, reason: collision with root package name */
        private int f56405a;

        /* renamed from: b, reason: collision with root package name */
        private String f56406b;

        public int getCode() {
            return this.f56405a;
        }

        public String getValue() {
            return this.f56406b;
        }

        CONNECT_TYPE(int i6, String str) {
            this.f56405a = i6;
            this.f56406b = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum DEVICE_COUNTRY_TYPE {
        COUNTRY_OTHER_TYPE(0, "OTHER"),
        COUNTRY_CHINA_TYPE(1, e.f33257e);


        /* renamed from: a, reason: collision with root package name */
        private int f56408a;

        /* renamed from: b, reason: collision with root package name */
        private String f56409b;

        public int getCode() {
            return this.f56408a;
        }

        public String getCountry() {
            return this.f56409b;
        }

        DEVICE_COUNTRY_TYPE(int i6, String str) {
            this.f56408a = i6;
            this.f56409b = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum DEVICE_TYPE {
        TYPE_PHONE(100),
        TYPE_TABLET(101);


        /* renamed from: a, reason: collision with root package name */
        private int f56411a;

        public int getCode() {
            return this.f56411a;
        }

        DEVICE_TYPE(int i6) {
            this.f56411a = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum OS_TYPE {
        CONNECT_TYPE_UNKNOWN(0),
        OS_ANDROID(2),
        OS_IOS_TV(3),
        OS_IOS(13),
        OS_PS4(22);


        /* renamed from: a, reason: collision with root package name */
        private int f56413a;

        public int getCode() {
            return this.f56413a;
        }

        OS_TYPE(int i6) {
            this.f56413a = i6;
        }
    }
}
