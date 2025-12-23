package com.bytedance.msdk.tl.j;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends SQLiteOpenHelper {

    /* renamed from: j, reason: collision with root package name */
    public static String f25215j = "j";

    private void j(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS gromore_prime_rit_adn_perform (id INTEGER PRIMARY KEY AUTOINCREMENT, adn_name TEXT NOT NULL , prime_rit TEXT NOT NULL , adn_rit TEXT NOT NULL ,ad_action TEXT NOT NULL ,time_stamp LONG DEFAULT 0)");
    }

    private void xt(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS gromore_prime_rit_adn_perform ;");
    }

    public j(@Nullable Context context) {
        super(new com.bytedance.sdk.openadsdk.api.plugin.j(context), "mediation_behavior.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
        try {
            com.bytedance.msdk.j.up.cw.j(f25215j, "onUpgrade....Database version upgrade.....old:" + i6 + ",new:" + i7);
            if (i6 <= i7) {
                j(sQLiteDatabase);
                return;
            }
            xt(sQLiteDatabase);
            j(sQLiteDatabase);
            com.bytedance.msdk.j.up.cw.j(f25215j, "onUpgrade...Reverse installation Database reset - create table.....");
        } catch (Throwable unused) {
        }
    }

    public void xt(String str, String[] strArr) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("gromore_prime_rit_adn_perform", str, strArr);
        writableDatabase.close();
    }

    public void j(ContentValues contentValues) {
        if (contentValues != null) {
            String asString = contentValues.getAsString(MediationConstant.EXTRA_ADN_NAME);
            String asString2 = contentValues.getAsString(MediationConstant.KEY_GM_PRIME_RIT);
            String asString3 = contentValues.getAsString("adn_rit");
            String asString4 = contentValues.getAsString("ad_action");
            Long asLong = contentValues.getAsLong("time_stamp");
            asLong.longValue();
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put(MediationConstant.EXTRA_ADN_NAME, asString);
            contentValues2.put(MediationConstant.KEY_GM_PRIME_RIT, asString2);
            contentValues2.put("adn_rit", asString3);
            contentValues2.put("ad_action", asString4);
            contentValues2.put("time_stamp", asLong);
            if (writableDatabase != null) {
                try {
                    if (writableDatabase.isOpen()) {
                        writableDatabase.insert("gromore_prime_rit_adn_perform", null, contentValues2);
                        writableDatabase.close();
                    }
                } catch (IllegalStateException unused) {
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            j(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    public Cursor j(String str, String[] strArr) {
        return getReadableDatabase().query("gromore_prime_rit_adn_perform", null, str, strArr, null, null, null);
    }
}
