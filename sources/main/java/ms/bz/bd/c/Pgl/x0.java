package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import ms.bz.bd.c.Pgl.pblk;
import okio.Utf8;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class x0 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f50394a;

    private static String a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6b5a83", new byte[]{49, 97, 74, 0, 2}));
        String string = columnIndex > 0 ? cursor.getString(columnIndex) : null;
        int columnIndex2 = cursor.getColumnIndex((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0298fd", new byte[]{34, Utf8.REPLACEMENT_BYTE, 78, 73}));
        if (columnIndex2 > 0) {
            cursor.getInt(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6d5397", new byte[]{34, 126, 86, 78, 20, 37, 49}));
        if (columnIndex3 > 0) {
            cursor.getLong(columnIndex3);
        }
        return string;
    }

    public final void b(pblk.pblb pblbVar) {
        Cursor cursor;
        try {
            this.f50394a.getPackageManager().getPackageInfo((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ab4aa7", new byte[]{115, 111, 74, 91, 83, 37, 107, 89, 112, Byte.MAX_VALUE, 118, 108, 94, 24, 91, 110, 109, 83, 96, Utf8.REPLACEMENT_BYTE, 121, 100, 84, 17, 85}), 0);
        } catch (Exception unused) {
        }
        Uri parse = Uri.parse((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "829381", new byte[]{42, Utf8.REPLACEMENT_BYTE, 68, 83, 2, 40, 47, 73, 39, HttpConstants.COMMA, 42, Utf8.REPLACEMENT_BYTE, 71, 9, 10, BinaryMemcacheOpcodes.GATK, 50, 9, 125, 45, 47, 60, 83, 74, 2, 104, 52, 3, 109, 109, 32, 52, 89, 67, 12, 105}));
        try {
            cursor = this.f50394a.getContentResolver().query(parse, null, null, new String[]{(String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0f7560", new byte[]{46, 101, 77, 69})}, null);
        } catch (Throwable unused2) {
            cursor = null;
        }
        try {
            String a6 = a(cursor);
            if (pblbVar != null) {
                pblbVar.j(a6);
            }
            if (cursor == null) {
                return;
            }
        } catch (Throwable unused3) {
            if (cursor == null) {
                return;
            }
            cursor.close();
        }
        cursor.close();
    }

    public x0(Context context) {
        this.f50394a = context;
    }
}
