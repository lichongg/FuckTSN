package xyz.adscope.amps.tool.util;

import android.content.Context;
import xyz.adscope.common.info.DeviceInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSScreenUtil {
    public static final int getScreenHeight(Context context) {
        return DeviceInfo.getInstance(context).getResolutionHeight();
    }

    public static final int getScreenWidth(Context context) {
        return DeviceInfo.getInstance(context).getResolutionWidth();
    }
}
