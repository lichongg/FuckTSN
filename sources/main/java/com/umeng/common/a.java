package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.stub.StubApp;
import com.umeng.analytics.pro.au;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.utils.UMUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f41586a = null;

    /* renamed from: b, reason: collision with root package name */
    private static final String f41587b = "umeng+";

    /* renamed from: c, reason: collision with root package name */
    private static final String f41588c = "ek__id";

    /* renamed from: d, reason: collision with root package name */
    private static final String f41589d = "ek_key";

    /* renamed from: e, reason: collision with root package name */
    private static String f41590e = "";

    /* renamed from: f, reason: collision with root package name */
    private static final String f41591f = au.b().b(au.f40909n);

    /* renamed from: g, reason: collision with root package name */
    private static String f41592g = "";

    /* renamed from: h, reason: collision with root package name */
    private static a f41593h;

    public static a a() {
        if (f41593h == null) {
            synchronized (a.class) {
                try {
                    if (f41593h == null) {
                        f41593h = new a();
                    }
                } finally {
                }
            }
        }
        return f41593h;
    }

    public String b(String str) {
        String str2;
        try {
            return TextUtils.isEmpty(f41586a) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f41586a.getBytes()));
        } catch (Exception unused) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败!");
            String str3 = null;
            if (TextUtils.isEmpty(f41590e)) {
                return null;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试");
            try {
                String str4 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f41590e.getBytes()));
                try {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试成功。");
                    return str4;
                } catch (Exception unused2) {
                    str3 = str4;
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试失败。换子进程备份key重试。");
                    try {
                        str2 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f41592g.getBytes()));
                    } catch (Throwable unused3) {
                    }
                    try {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试成功。");
                        return str2;
                    } catch (Throwable unused4) {
                        str3 = str2;
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试失败。");
                        return str3;
                    }
                }
            } catch (Exception unused5) {
            }
        }
    }

    private String c(String str) {
        String str2 = "";
        try {
            String substring = str.substring(1, 9);
            StringBuilder sb = new StringBuilder();
            for (int i6 = 0; i6 < substring.length(); i6++) {
                char charAt = substring.charAt(i6);
                if (!Character.isDigit(charAt)) {
                    sb.append(charAt);
                } else if (Integer.parseInt(Character.toString(charAt)) == 0) {
                    sb.append(0);
                } else {
                    sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                }
            }
            str2 = sb.toString();
            return str2 + new StringBuilder(str2).reverse().toString();
        } catch (Throwable unused) {
            return str2;
        }
    }

    private a() {
    }

    public void a(Context context) {
        try {
            if (TextUtils.isEmpty(f41586a)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(context, f41588c);
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    f41590e = c(multiProcessSP);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> primaryKey: " + f41590e);
                }
                SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f41591f, 0);
                if (sharedPreferences != null) {
                    f41592g = sharedPreferences.getString(f41588c, null);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程备份秘钥：主进程key: " + f41592g);
                }
                f41586a = c(UMUtils.genId());
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> 正式秘钥：key: " + f41586a);
            }
        } catch (Throwable unused) {
        }
    }

    public String a(String str) {
        try {
            return TextUtils.isEmpty(f41586a) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f41586a.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }
}
