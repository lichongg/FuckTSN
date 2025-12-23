package xyz.adscope.common.v2.dev.info;

import android.content.Context;
import android.text.TextUtils;
import xyz.adscope.common.v2.encrypt.impl.MD5Util;
import xyz.adscope.common.v2.persistent.sp.CommonSpHelper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AdScopeUtil {
    private static final String SP_KEY_SDK_ID = "scopeID";

    private static String generateScopeSDKID(Context context) {
        StringBuilder sb = new StringBuilder();
        String brand = DeviceUtil.getBrand();
        String model = DeviceUtil.getModel();
        String hardDisk = DeviceUtil.getHardDisk();
        String androidRelease = DeviceUtil.getAndroidRelease();
        long fileMark = DeviceUtil.getFileMark();
        String deviceUpdateMark = DeviceUtil.getDeviceUpdateMark();
        sb.append(brand);
        sb.append(model);
        sb.append(hardDisk);
        sb.append(androidRelease);
        sb.append(fileMark);
        sb.append(deviceUpdateMark);
        sb.append(System.currentTimeMillis());
        String md5 = MD5Util.md5(sb.toString());
        CommonSpHelper.putString(context, CommonSpHelper.getCommonSPFile(), SP_KEY_SDK_ID, md5);
        return md5;
    }

    public static String getScopeSdkID(Context context) {
        String string = CommonSpHelper.getString(context, CommonSpHelper.getCommonSPFile(), SP_KEY_SDK_ID, null);
        if (TextUtils.isEmpty(string)) {
            return generateScopeSDKID(context);
        }
        return string;
    }
}
