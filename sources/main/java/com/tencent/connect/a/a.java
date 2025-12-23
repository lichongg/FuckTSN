package com.tencent.connect.a;

import android.content.Context;
import android.text.TextUtils;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.b.e;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import java.lang.reflect.Method;
import xyz.adscope.common.network.cookie.db.Field;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Class<?> f40207a;

    /* renamed from: b, reason: collision with root package name */
    private static Class<?> f40208b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f40209c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f40210d;

    /* renamed from: e, reason: collision with root package name */
    private static Method f40211e;

    /* renamed from: f, reason: collision with root package name */
    private static Method f40212f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f40213g;

    public static boolean a(Context context, QQToken qQToken) {
        return i.a(context, qQToken.getAppId()).b("Common_ta_enable");
    }

    public static void c(Context context, QQToken qQToken) {
        String str = "Aqc" + qQToken.getAppId();
        try {
            f40207a = Class.forName("com.tencent.stat.StatConfig");
            Class<?> cls = Class.forName("com.tencent.stat.StatService");
            f40208b = cls;
            f40209c = cls.getMethod("reportQQ", Context.class, String.class);
            f40210d = f40208b.getMethod("trackCustomEvent", Context.class, String.class, String[].class);
            Class<?> cls2 = f40208b;
            Class<?> cls3 = Integer.TYPE;
            f40211e = cls2.getMethod("commitEvents", Context.class, cls3);
            Class<?> cls4 = f40207a;
            Class<?> cls5 = Boolean.TYPE;
            f40212f = cls4.getMethod("setEnableStatService", cls5);
            b(context, qQToken);
            f40207a.getMethod("setAutoExceptionCaught", cls5).invoke(f40207a, Boolean.FALSE);
            f40207a.getMethod("setEnableSmartReporting", cls5).invoke(f40207a, Boolean.TRUE);
            f40207a.getMethod("setSendPeriodMinutes", cls3).invoke(f40207a, Integer.valueOf(PredefinedCaptureConfigurations.f35657x));
            Class<?> cls6 = Class.forName("com.tencent.stat.StatReportStrategy");
            f40207a.getMethod("setStatSendStrategy", cls6).invoke(f40207a, cls6.getField("PERIOD").get(null));
            f40208b.getMethod("startStatService", Context.class, String.class, String.class).invoke(f40208b, context, str, Class.forName("com.tencent.stat.common.StatConstants").getField(Field.VERSION).get(null));
            f40213g = true;
        } catch (Exception e6) {
            SLog.e("OpenConfig", "start4QQConnect exception: " + e6.toString());
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        if (f40213g) {
            b(context, qQToken);
            try {
                f40210d.invoke(f40208b, context, str, strArr);
            } catch (Exception e6) {
                SLog.e("OpenConfig", "trackCustomEvent exception: " + e6.toString());
            }
        }
    }

    public static void b(Context context, QQToken qQToken) {
        try {
            if (a(context, qQToken)) {
                f40212f.invoke(f40207a, Boolean.TRUE);
            } else {
                f40212f.invoke(f40207a, Boolean.FALSE);
            }
        } catch (Exception e6) {
            SLog.e("OpenConfig", "checkStatStatus exception: " + e6.toString());
        }
    }

    public static void d(Context context, QQToken qQToken) {
        if (!TextUtils.isEmpty(qQToken.getOpenId())) {
            e.a().a(qQToken.getOpenId(), qQToken.getAppId(), "2", "1", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "0", "0", "0");
        }
        if (f40213g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    f40209c.invoke(f40208b, context, qQToken.getOpenId());
                } catch (Exception e6) {
                    SLog.e("OpenConfig", "reportQQ exception: " + e6.toString());
                }
            }
        }
    }
}
