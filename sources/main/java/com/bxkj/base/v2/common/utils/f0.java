package com.bxkj.base.v2.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.stub.StubApp;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class f0 {

    /* renamed from: a, reason: collision with root package name */
    protected static final String f16891a = "gank_device_id.xml";

    /* renamed from: b, reason: collision with root package name */
    protected static final String f16892b = "gank_device_id";

    /* renamed from: c, reason: collision with root package name */
    protected static String f16893c;

    public static synchronized String a(Context context) {
        String str;
        synchronized (f0.class) {
            try {
                String str2 = f16893c;
                if (str2 == null && str2 == null) {
                    SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f16891a, 0);
                    String string = sharedPreferences.getString(f16892b, null);
                    if (string != null) {
                        f16893c = string;
                    } else {
                        String string2 = Settings.Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
                        if (string2 != null) {
                            try {
                                if (!"9774d56d682e549c".equals(string2)) {
                                    f16893c = UUID.nameUUIDFromBytes(string2.getBytes("utf8")).toString();
                                    sharedPreferences.edit().putString(f16892b, f16893c).commit();
                                }
                            } catch (UnsupportedEncodingException e6) {
                                throw new RuntimeException(e6);
                            }
                        }
                        String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                        f16893c = (deviceId != null ? UUID.nameUUIDFromBytes(deviceId.getBytes("utf8")) : UUID.randomUUID()).toString();
                        sharedPreferences.edit().putString(f16892b, f16893c).commit();
                    }
                }
                str = f16893c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
