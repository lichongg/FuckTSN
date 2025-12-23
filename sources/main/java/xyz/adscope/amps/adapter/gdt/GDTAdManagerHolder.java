package xyz.adscope.amps.adapter.gdt;

import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.pi.IBidding;
import java.util.HashMap;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: D:\Downloads\app\classes9.dex */
public class GDTAdManagerHolder {
    public static String getBidToken() {
        try {
            return GDTAdSdk.getGDTAdManger().getBuyerId(null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void sendLossNotification(IBidding iBidding, int i6) {
        if (iBidding == null) {
            return;
        }
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK sendLossNotification reason:" + i6);
        int i7 = 1;
        if (i6 != 1) {
            i7 = 2;
            if (i6 != 2) {
                i7 = 10001;
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("lossReason", Integer.valueOf(i7));
        hashMap.put("adnId", 3);
        iBidding.sendLossNotification(hashMap);
    }

    public static void sendWinNotification(IBidding iBidding, int i6) {
        if (iBidding == null) {
            return;
        }
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK sendWinNotification ecpm:" + i6);
        HashMap hashMap = new HashMap();
        hashMap.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(i6));
        hashMap.put("highestLossPrice", Integer.valueOf(i6 + (-1)));
        iBidding.sendWinNotification(hashMap);
    }

    public static String getBidSdkInfo(String str) {
        try {
            return GDTAdSdk.getGDTAdManger().getSDKInfo(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
