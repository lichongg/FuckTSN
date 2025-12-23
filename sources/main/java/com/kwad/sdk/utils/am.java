package com.kwad.sdk.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class am {
    private static String aZP;
    private static boolean aZQ;

    private static boolean k(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            com.kwad.sdk.core.d.c.i("MiMarketHelper", "isSupportMiMarket2: cursor is null");
            return false;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("support");
        if (columnIndex >= 0) {
            return cursor.getString(columnIndex).equals("true");
        }
        return false;
    }

    public static String dc(Context context) {
        Cursor cursor;
        if (!TextUtils.isEmpty(aZP) || aZQ || !bb.Rl()) {
            return aZP;
        }
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider"), null, null, null, null);
            try {
                aZP = j(cursor);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        aZQ = TextUtils.isEmpty(aZP);
        return aZP;
    }

    public static boolean dd(Context context) {
        Cursor cursor;
        boolean z5 = false;
        if (!bb.Rl()) {
            return false;
        }
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider"), null, null, null, null);
            try {
                z5 = k(cursor);
            } catch (Throwable unused) {
                try {
                    com.kwad.sdk.core.d.c.e("MiMarketHelper", "isSupportMiMarket2 failed");
                    if (!z5) {
                        com.kwad.sdk.core.d.c.i("MiMarketHelper", "is Miui but not support MiMarket2.0");
                    }
                    return z5;
                } finally {
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                }
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        if (!z5 && bb.Rl()) {
            com.kwad.sdk.core.d.c.i("MiMarketHelper", "is Miui but not support MiMarket2.0");
        }
        return z5;
    }

    public static boolean gY(String str) {
        return str.startsWith("market://details") || str.startsWith("mimarket://details");
    }

    private static String j(Cursor cursor) {
        int columnIndex;
        if (cursor == null || cursor.isClosed()) {
            com.kwad.sdk.core.d.c.i("MiMarketHelper", "cursor is null");
            return "";
        }
        cursor.moveToFirst();
        int columnIndex2 = cursor.getColumnIndex("support");
        return ((columnIndex2 <= 0 || cursor.getInt(columnIndex2) != 0) && (columnIndex = cursor.getColumnIndex("detailStyle")) > 0) ? cursor.getString(columnIndex) : "";
    }
}
