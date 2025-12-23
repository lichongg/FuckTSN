package xyz.adscope.common.network.cookie.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xyz.adscope.common.network.cookie.Cookie;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class CookieDao implements Field {

    /* renamed from: a, reason: collision with root package name */
    private SQLHelper f56607a;

    protected final SQLiteDatabase a() {
        return this.f56607a.getReadableDatabase();
    }

    public int count() {
        return count("SELECT COUNT(_ID) FROM COOKIES_TABLE");
    }

    public boolean delete(List<Cookie> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Cookie> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(it.next().getId()));
        }
        return delete(Where.newBuilder().in(Field.ID, arrayList).build().toString());
    }

    public List<Cookie> getAll() {
        return getList(null, null, null, null);
    }

    public List<Cookie> getList(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder("SELECT ");
        sb.append("*");
        sb.append(" FROM ");
        sb.append(Field.TABLE_NAME);
        if (!TextUtils.isEmpty(str)) {
            sb.append(" WHERE ");
            sb.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(" ORDER BY ");
            sb.append(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(" LIMIT ");
            sb.append(str3);
            if (!TextUtils.isEmpty(str4)) {
                sb.append(" OFFSET ");
                sb.append(str4);
            }
        }
        return getList(sb.toString());
    }

    protected final void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            return;
        }
        sQLiteDatabase.close();
    }

    public int count(String str) {
        SQLiteDatabase a6 = a();
        Cursor rawQuery = a6.rawQuery(str, null);
        try {
            return rawQuery.moveToNext() ? rawQuery.getInt(0) : 0;
        } finally {
            a(rawQuery);
            a(a6);
        }
    }

    public boolean deleteAll() {
        return delete("1=1");
    }

    public CookieDao(Context context) {
        this.f56607a = new SQLHelper(context);
    }

    public long replace(Cookie cookie) {
        SQLiteDatabase a6 = a();
        a6.beginTransaction();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Field.URL, cookie.getUrl());
        contentValues.put(Field.NAME, cookie.getName());
        contentValues.put(Field.VALUE, cookie.getValue());
        contentValues.put(Field.COMMENT, cookie.getComment());
        contentValues.put(Field.COMMENT_URL, cookie.getCommentURL());
        contentValues.put(Field.DISCARD, String.valueOf(cookie.isDiscard()));
        contentValues.put(Field.DOMAIN, cookie.getDomain());
        contentValues.put(Field.EXPIRY, Long.valueOf(cookie.getExpiry()));
        contentValues.put(Field.PATH, cookie.getPath());
        contentValues.put(Field.PORT_LIST, cookie.getPortList());
        contentValues.put(Field.SECURE, String.valueOf(cookie.isSecure()));
        contentValues.put(Field.VERSION, Integer.valueOf(cookie.getVersion()));
        try {
            long replace = a6.replace(Field.TABLE_NAME, null, contentValues);
            a6.setTransactionSuccessful();
            a6.endTransaction();
            a(a6);
            return replace;
        } catch (Exception unused) {
            a6.endTransaction();
            a(a6);
            return -1L;
        } catch (Throwable th) {
            a6.endTransaction();
            a(a6);
            throw th;
        }
    }

    protected final void a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }

    public boolean delete(String str) {
        SQLiteDatabase a6 = a();
        String str2 = "DELETE FROM COOKIES_TABLE WHERE " + str;
        a6.beginTransaction();
        try {
            a6.execSQL(str2);
            a6.setTransactionSuccessful();
            a6.endTransaction();
            a(a6);
            return true;
        } catch (SQLException unused) {
            a6.endTransaction();
            a(a6);
            return false;
        } catch (Throwable th) {
            a6.endTransaction();
            a(a6);
            throw th;
        }
    }

    public List<Cookie> getList(String str) {
        SQLiteDatabase a6 = a();
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = a6.rawQuery(str, null);
        while (rawQuery.moveToNext()) {
            Cookie cookie = new Cookie();
            cookie.setId(rawQuery.getInt(rawQuery.getColumnIndex(Field.ID)));
            cookie.setUrl(rawQuery.getString(rawQuery.getColumnIndex(Field.URL)));
            cookie.setName(rawQuery.getString(rawQuery.getColumnIndex(Field.NAME)));
            cookie.setValue(rawQuery.getString(rawQuery.getColumnIndex(Field.VALUE)));
            cookie.setComment(rawQuery.getString(rawQuery.getColumnIndex(Field.COMMENT)));
            cookie.setCommentURL(rawQuery.getString(rawQuery.getColumnIndex(Field.COMMENT_URL)));
            cookie.setDiscard("true".equals(rawQuery.getString(rawQuery.getColumnIndex(Field.DISCARD))));
            cookie.setDomain(rawQuery.getString(rawQuery.getColumnIndex(Field.DOMAIN)));
            cookie.setExpiry(rawQuery.getLong(rawQuery.getColumnIndex(Field.EXPIRY)));
            cookie.setPath(rawQuery.getString(rawQuery.getColumnIndex(Field.PATH)));
            cookie.setPortList(rawQuery.getString(rawQuery.getColumnIndex(Field.PORT_LIST)));
            cookie.setSecure("true".equals(rawQuery.getString(rawQuery.getColumnIndex(Field.SECURE))));
            cookie.setVersion(rawQuery.getInt(rawQuery.getColumnIndex(Field.VERSION)));
            arrayList.add(cookie);
        }
        a(rawQuery);
        a(a6);
        return arrayList;
    }
}
