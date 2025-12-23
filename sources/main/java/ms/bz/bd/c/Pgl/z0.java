package ms.bz.bd.c.Pgl;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.google.common.base.Ascii;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class z0 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f50395a;

    public final String a() {
        int i6;
        Uri parse = Uri.parse((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "67b91f", new byte[]{BinaryMemcacheOpcodes.GATKQ, HttpConstants.COLON, Ascii.US, 89, 11, Byte.MAX_VALUE, BinaryMemcacheOpcodes.SASL_AUTH, 76, 124, 38, BinaryMemcacheOpcodes.GATKQ, HttpConstants.SEMICOLON, 95, 67, Ascii.ESC, 115, 60, 23, 125, 96, BinaryMemcacheOpcodes.GATK, 48, Ascii.US, 89, 7, 101, HttpConstants.COMMA, 89, HttpConstants.COLON, 109, 34, HttpConstants.SEMICOLON, 5, 68, 26, 104}));
        try {
            i6 = Build.VERSION.SDK_INT;
        } catch (Exception unused) {
        }
        try {
            ContentProviderClient acquireContentProviderClient = this.f50395a.getContentResolver().acquireContentProviderClient(parse);
            Bundle call = acquireContentProviderClient.call((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "917490", new byte[]{47, 54, 80, 111, 39, 14, 30}), null, null);
            if (i6 >= 24) {
                androidx.core.provider.c.a(acquireContentProviderClient);
            } else {
                acquireContentProviderClient.release();
            }
            if (call.getInt((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "639cf5", new byte[]{BinaryMemcacheOpcodes.GATKQ, 62, 78, 18}), -1) == 0) {
                return call.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3a5c36", new byte[]{43, 103}));
            }
            call.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "61451e", new byte[]{42, 54, 84, 82, 15, 117, 48}));
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }

    public z0(Context context) {
        this.f50395a = context;
    }
}
