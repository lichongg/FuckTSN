package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import okio.Utf8;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class u1 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f50389a;

    public final String a() {
        Cursor query = this.f50389a.getContentResolver().query(Uri.parse((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8d01d9", new byte[]{42, 105, 77, 81, 94, 32, 47, Ascii.US, 46, 46, 42, 105, 78, 11, 77, 39, 45, 74, 47, 119, BinaryMemcacheOpcodes.GATKQ, 117, 13, 108, 95, 30, 41, 74, 119, 104, 45, 99, 81, 10, 114, 42, 62, 75, 117, 104, 47, 111, 70, 87, 114, 42, 116, 106, SignedBytes.MAX_POWER_OF_TWO, 72, 13})), null, null, null, null);
        String str = null;
        try {
            if (query != null) {
                try {
                    try {
                        if (query.moveToNext()) {
                            str = query.getString(query.getColumnIndex((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0cfef0", new byte[]{55, 96, 25, 4, 92})));
                        }
                    } catch (Throwable unused) {
                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "028b9f", new byte[]{55, Utf8.REPLACEMENT_BYTE});
                        query.close();
                    }
                } finally {
                    try {
                        query.close();
                    } catch (Throwable unused2) {
                    }
                }
            }
            if (query != null) {
            }
        } catch (Throwable unused3) {
        }
        return str;
    }

    public u1(Context context) {
        this.f50389a = context;
    }
}
