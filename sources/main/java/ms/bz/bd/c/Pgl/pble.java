package ms.bz.bd.c.Pgl;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.ArrayMap;
import com.google.common.base.Ascii;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.lang.reflect.Field;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class pble {

    /* renamed from: a, reason: collision with root package name */
    private static volatile int f50324a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static volatile String f50325b = "";

    @SuppressLint({"PrivateApi"})
    public static Activity b() {
        ArrayMap arrayMap;
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "41fbe3", new byte[]{BinaryMemcacheOpcodes.GATKQ, 61, 17, 4, 85, 45, 51, 94, 54, 34, 53, 125, 52, 21, 78, 45, BinaryMemcacheOpcodes.SASL_AUTH, 25, BinaryMemcacheOpcodes.GATK, 43, 17, HttpConstants.SEMICOLON, 7, 19, 91, 32}));
            Object invoke = cls.getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "16e3d0", new byte[]{BinaryMemcacheOpcodes.GATK, BinaryMemcacheOpcodes.SASL_AUTH, 4, 85, 94, 41, 38, 54, 55, 119, 41, 34, Ascii.US, 83, 66, 19, HttpConstants.COLON, 5, 49, 98, BinaryMemcacheOpcodes.GATKQ}), null).invoke(null, null);
            Field declaredField = cls.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b1b05a", new byte[]{126, 18, 18, 80, 3, 96, 104, 4, HttpConstants.COLON, 101, 96}));
            declaredField.setAccessible(true);
            arrayMap = (ArrayMap) declaredField.get(invoke);
        } catch (Exception unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "422625", new byte[]{BinaryMemcacheOpcodes.GATKQ, 57, 126, 69});
        }
        if (arrayMap.size() <= 0) {
            return null;
        }
        for (Object obj : arrayMap.values()) {
            Class<?> cls2 = obj.getClass();
            Field declaredField2 = cls2.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "604944", new byte[]{55, 51, 82, 94, 14, 39}));
            declaredField2.setAccessible(true);
            if (!declaredField2.getBoolean(obj)) {
                Field declaredField3 = cls2.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e96982", new byte[]{117, 56, 81, 68, 17, HttpConstants.COMMA, 114, 1}));
                declaredField3.setAccessible(true);
                return (Activity) declaredField3.get(obj);
            }
        }
        return null;
    }

    public static int a(Context context) {
        if (f50324a <= 0) {
            try {
                f50324a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Throwable unused) {
            }
        }
        return f50324a;
    }

    public static String c(Context context) {
        try {
            if (f50325b == "") {
                f50325b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            }
        } catch (Throwable unused) {
        }
        return f50325b;
    }
}
