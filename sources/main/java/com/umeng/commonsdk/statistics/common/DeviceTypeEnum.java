package com.umeng.commonsdk.statistics.common;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public enum DeviceTypeEnum {
    IMEI("imei", "imei"),
    OAID("oaid", "oaid"),
    ANDROIDID(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID),
    MAC(SocializeProtocolConstants.PROTOCOL_KEY_MAC, SocializeProtocolConstants.PROTOCOL_KEY_MAC),
    SERIALNO("serial_no", "serial_no"),
    IDFA("idfa", "idfa"),
    DEFAULT("null", "null");

    private String description;
    private String deviceIdType;

    public String getDescription() {
        return this.description;
    }

    public String getDeviceIdType() {
        return this.deviceIdType;
    }

    DeviceTypeEnum(String str, String str2) {
        this.deviceIdType = str;
        this.description = str2;
    }
}
