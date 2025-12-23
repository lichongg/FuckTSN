package com.baidu.mobads.sdk.internal;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ay extends ax {

    /* renamed from: b, reason: collision with root package name */
    public static final String f10666b = "logout";

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f10667c = {"#", "#", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "D", "I", ExifInterface.LONGITUDE_WEST, ExifInterface.LONGITUDE_EAST, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS};

    @Override // com.baidu.mobads.sdk.internal.ax, com.baidu.mobads.sdk.internal.az.a
    @NonNull
    String a() {
        return f10666b;
    }

    @Override // com.baidu.mobads.sdk.internal.ax, com.baidu.mobads.sdk.internal.az.a
    protected void a(int i6, String str, String str2, Throwable th) {
        try {
            IXAdContainerFactory c6 = aa.a().c();
            if (c6 != null) {
                c6.getRemoteParam("debugLogout", (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS", Locale.getDefault()).format(new Date()) + " " + f10667c[i6] + "/" + str + ": ") + "当前线程：" + Thread.currentThread().getName() + ";  调用位置：" + c() + ";  打印消息：" + str2 + com.snail.antifake.deviceid.e.f37542d);
            }
        } catch (Throwable unused) {
        }
    }
}
