package com.amap.api.col.p0003l;

import android.content.Context;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.framework.common.ContainerUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class i2 {

    /* renamed from: a, reason: collision with root package name */
    static String f6463a;

    static {
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < 80; i6++) {
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
        }
        f6463a = sb.toString();
    }

    public static void a() {
        e(f6463a);
        e("当前使用的自定义地图样式文件和目前版本不匹配，请到官网(lbs.amap.com)更新新版样式文件");
        e(f6463a);
    }

    public static void b(Context context, String str) {
        e(f6463a);
        if (context != null) {
            d("key:" + f4.j(context));
        }
        e(str);
        e(f6463a);
    }

    public static void c(String str) {
        e(f6463a);
        e(str);
        e(f6463a);
    }

    private static void d(String str) {
        if (str.length() < 78) {
            StringBuilder sb = new StringBuilder();
            sb.append(Logger.f33116c);
            sb.append(str);
            for (int i6 = 0; i6 < 78 - str.length(); i6++) {
                sb.append(" ");
            }
            sb.append(Logger.f33116c);
            e(sb.toString());
            return;
        }
        e(Logger.f33116c + str.substring(0, 78) + Logger.f33116c);
        d(str.substring(78));
    }

    private static void e(String str) {
    }
}
