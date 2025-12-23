package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;
import org.repackage.com.heytap.openid.sdk.OpenIDSDK;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class bd implements av {

    /* renamed from: a, reason: collision with root package name */
    private boolean f40953a = false;

    @Override // com.umeng.analytics.pro.av
    public String a(Context context) {
        try {
            if (!this.f40953a) {
                OpenIDSDK.a(context);
                this.f40953a = true;
            }
            if (OpenIDSDK.a()) {
                return OpenIDSDK.c(context);
            }
            UMLog.mutlInfo(2, "当前设备不支持获取OAID");
            return null;
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
            return null;
        }
    }
}
