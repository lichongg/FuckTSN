package com.bykv.vk.openvk.component.video.j.xt.xt;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r extends SQLiteOpenHelper {
    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
        if (i6 == 1) {
            sQLiteDatabase.execSQL("ALTER TABLE video_http_header_t ADD COLUMN flag INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE video_http_header_t ADD COLUMN extra TEXT DEFAULT ''");
        } else if (i6 == 2) {
            sQLiteDatabase.execSQL("ALTER TABLE video_http_header_t ADD COLUMN extra TEXT DEFAULT ''");
        } else {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS video_http_header_t");
            onCreate(sQLiteDatabase);
        }
    }

    public r(Context context) {
        super(new com.bytedance.sdk.openadsdk.api.plugin.j(context), "tt_open_sdk_video.db", (SQLiteDatabase.CursorFactory) null, 3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS video_http_header_t(_id INTEGER PRIMARY KEY AUTOINCREMENT,key TEXT,mime TEXT,contentLength INTEGER,flag INTEGER,extra TEXT)");
    }
}
