package com.umeng.analytics.process;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.h;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class b extends SQLiteOpenHelper {
    static b a(Context context, String str) {
        String b6 = b(context, str);
        a.f41507h.equals(str);
        return new b(context, b6, null, 1);
    }

    b(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i6) {
        super(context, str, cursorFactory, i6);
    }

    public static String b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = a.f41507h;
        }
        String str2 = h.b(context) + a.f41500a;
        if (a.f41507h.equals(str)) {
            str2 = h.b(context);
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return String.format(str2 + a.f41504e, str);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("create table if not exists __et_p(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __pn TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    public static String a(Context context) {
        return h.b(context) + a.f41500a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
    }
}
