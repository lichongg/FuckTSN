package com.beizi.fusion.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.beizi.fusion.model.EventItem;
import com.beizi.fusion.tool.aa;
import com.beizi.fusion.tool.s;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f13290a;

    /* renamed from: b, reason: collision with root package name */
    private a f13291b;

    public static b a(Context context) {
        if (f13290a == null) {
            synchronized (b.class) {
                try {
                    if (f13290a == null) {
                        f13290a = new b(context);
                    }
                } finally {
                }
            }
        }
        return f13290a;
    }

    private synchronized boolean b(String str) {
        boolean z5 = false;
        if (str == null) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = this.f13291b.getWritableDatabase().query("Sqlite_master", new String[]{"count('*') as c"}, "type=? and name =?", new String[]{"table", str.trim()}, null, null, null);
                if (cursor.moveToNext()) {
                    if (cursor.getInt(0) > 0) {
                        z5 = true;
                    }
                }
            } catch (Exception unused) {
                if (cursor != null) {
                }
            } catch (Throwable th) {
                if (cursor == null) {
                    throw th;
                }
                cursor.close();
                throw th;
            }
            cursor.close();
            return z5;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private synchronized void c(String str) {
        SQLiteDatabase writableDatabase = this.f13291b.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            try {
                String str2 = "create table " + str + "(id integer primary key autoincrement,event_code nvarchar,channel nvarchar,space_id nvarchar,timestamp nvarchar)";
                aa.a("DaoManager", "sql createTable tableName = " + str2);
                writableDatabase.execSQL(str2);
                writableDatabase.setTransactionSuccessful();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        } finally {
            writableDatabase.endTransaction();
        }
    }

    private synchronized void d(String str) {
        boolean b6 = b(str);
        aa.a("DaoManager", "sql table is exist == " + b6);
        if (!b6) {
            c(str);
        }
    }

    private synchronized int e(String str) {
        int i6;
        Cursor query = this.f13291b.getWritableDatabase().query(str, null, null, null, null, null, null);
        if (query != null) {
            i6 = query.getCount();
            query.close();
        } else {
            i6 = 0;
        }
        return i6;
    }

    private b(Context context) {
        this.f13291b = a.a(context);
    }

    private EventItem a(Cursor cursor) {
        EventItem eventItem = new EventItem();
        eventItem.setCode(cursor.getString(cursor.getColumnIndex("event_code")));
        eventItem.setChannel(cursor.getString(cursor.getColumnIndex("channel")));
        eventItem.setSpaceId(cursor.getString(cursor.getColumnIndex("space_id")));
        eventItem.setTimeStamp(cursor.getString(cursor.getColumnIndex("timestamp")));
        return eventItem;
    }

    private ContentValues a(EventItem eventItem) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_code", eventItem.getCode());
        contentValues.put("channel", eventItem.getChannel());
        contentValues.put("space_id", eventItem.getSpaceId());
        contentValues.put("timestamp", eventItem.getTimeStamp());
        return contentValues;
    }

    public synchronized void a(String str, EventItem eventItem) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = "T_" + str;
        d(str2);
        int e6 = e(str2);
        long insert = this.f13291b.getWritableDatabase().insert(str2, null, a(eventItem));
        StringBuilder sb = new StringBuilder();
        sb.append("insert before size == ");
        sb.append(e6);
        sb.append(", insert data success = ");
        sb.append(insert != -1);
        aa.a("DaoManager", sb.toString());
        a(str2, Math.max(86400000L, s.b(str) * 2));
    }

    public synchronized List<EventItem> a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String str2 = "T_" + str;
            d(str2);
            ArrayList arrayList = new ArrayList();
            Cursor query = this.f13291b.getWritableDatabase().query(str2, null, null, null, null, null, null);
            if (query != null && query.getCount() > 0) {
                query.moveToFirst();
                do {
                    try {
                        arrayList.add(a(query));
                    } catch (Throwable th) {
                        query.close();
                        throw th;
                    }
                } while (query.moveToNext());
                query.close();
            }
            return arrayList;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void a(String str, long j6) {
        try {
            long currentTimeMillis = System.currentTimeMillis() - j6;
            int e6 = e(str);
            if (e6 > 0 && j6 > 0 && currentTimeMillis > 0) {
                int delete = this.f13291b.getWritableDatabase().delete(str, "timestamp<=?", new String[]{String.valueOf(currentTimeMillis)});
                StringBuilder sb = new StringBuilder();
                sb.append("start first delete data success = ");
                sb.append(delete > 0);
                sb.append(", intervalTime = ");
                sb.append(j6);
                aa.a("DaoManager", sb.toString());
            }
            if (e6 >= 1000) {
                this.f13291b.getWritableDatabase().execSQL("delete from " + str + " where rowid in(select rowid from " + str + " order by id limit 200)");
                aa.a("DaoManager", "start second delete data");
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
