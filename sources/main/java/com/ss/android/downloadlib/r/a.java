package com.ss.android.downloadlib.r;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.downloadlib.addownload.m;
import com.ss.android.socialbase.downloader.jy.j;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f38203b;

    /* renamed from: a, reason: collision with root package name */
    private SQLiteDatabase f38204a;

    private void a(long j6, String str) {
        SQLiteDatabase sQLiteDatabase = this.f38204a;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j6 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String optString = new JSONObject(str).optString("req_id");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            this.f38204a.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j6), optString});
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public static a c() {
        if (f38203b == null) {
            synchronized (a.class) {
                try {
                    if (f38203b == null) {
                        f38203b = new a();
                    }
                } finally {
                }
            }
        }
        return f38203b;
    }

    public void d(long j6, String str) {
        String optString;
        SQLiteDatabase sQLiteDatabase = this.f38204a;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j6 <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            optString = new JSONObject(str).optString("req_id");
        } catch (Exception e6) {
            vl.j(e6);
        }
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(MediationConstant.EXTRA_ADID, Long.valueOf(j6));
        contentValues.put("req_id", optString);
        contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
        this.f38204a.insert("click_event", null, contentValues);
        a(j6, str);
    }

    public boolean f(long j6, String str) {
        SQLiteDatabase sQLiteDatabase = this.f38204a;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j6 <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                String optString = new JSONObject(str).optString("req_id");
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                cursor = this.f38204a.query("click_event", c.f38206a, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j6), optString}, null, null, null, null);
                boolean z5 = cursor.getCount() > 0;
                cursor.close();
                return z5;
            } catch (Exception e6) {
                vl.j(e6);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
        } finally {
        }
    }

    private a() {
        try {
            this.f38204a = new c(m.getContext()).getWritableDatabase();
        } catch (Throwable th) {
            com.ss.android.downloadlib.up.a.a().j(th, "ClickEventHelper");
        }
    }

    public boolean b() {
        if (j.cw().j("click_event_switch", 0) != 2) {
            return false;
        }
        return true;
    }

    public boolean e() {
        if (j.cw().j("click_event_switch", 0) != 1) {
            return false;
        }
        return true;
    }
}
