package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.bytedance.sdk.component.utils.vl;
import com.google.common.base.Ascii;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.lang.reflect.Method;
import java.util.Iterator;
import okio.Utf8;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class pblr {

    /* renamed from: a, reason: collision with root package name */
    private static final String f50347a = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "024908", new byte[]{13, 3, 119, 66, 28, 42, 55});

    public static boolean a(Context context) {
        Bundle bundle;
        PackageManager packageManager = context.getPackageManager();
        IBinder iBinder = null;
        if (packageManager != null) {
            Iterator<ResolveInfo> it = packageManager.queryIntentActivities(new Intent((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e3a78d", new byte[]{117, Utf8.REPLACEMENT_BYTE, 22, 81, 8, 122, 98, 92, 57, 105, 96, 52, 28, 87, 73, 114, 101, 6, 57, 104, 122, Byte.MAX_VALUE, Utf8.REPLACEMENT_BYTE, 98, 46, 93}), (Uri) null), 128).iterator();
            while (it.hasNext()) {
                ActivityInfo activityInfo = it.next().activityInfo;
                if (activityInfo != null && (bundle = activityInfo.applicationInfo.metaData) != null && bundle.get((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2368a1", new byte[]{HttpConstants.SEMICOLON, BinaryMemcacheOpcodes.SASL_AUTH, 74, 95, 91, 34, 60, Ascii.ESC, 105, 126, 38, BinaryMemcacheOpcodes.GATK, 86, 69, 81, 40})) != null) {
                    break;
                }
            }
        }
        String packageName = context.getPackageName();
        String str = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2309fd", new byte[]{34, 50, 87, 68, 79, 122, 37, 11});
        try {
            Method declaredMethod = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f9ecf9", new byte[]{118, 53, 18, 5, 86, 39, 97, 86, HttpConstants.SEMICOLON, 32, 57, 8, 19, 5, 79, 39, 102, 29, 25, 50, 121, HttpConstants.COLON, 17, 18, 75})).getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bca15f", new byte[]{116, 100, 6, 118, 15, 99, 119, 75, 51, 100}), String.class);
            declaredMethod.setAccessible(true);
            iBinder = (IBinder) declaredMethod.invoke(null, str);
        } catch (Exception e6) {
            vl.j(e6);
        }
        if (iBinder != null) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(f50347a);
                obtain.writeInt(2);
                obtain.writeString(packageName);
                obtain.writeStrongBinder(new Binder());
                if (iBinder.transact(1598837584, obtain, obtain2, 0)) {
                    obtain2.readException();
                    return true;
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        return false;
    }
}
