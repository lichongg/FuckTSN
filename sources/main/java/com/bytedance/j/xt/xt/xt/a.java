package com.bytedance.j.xt.xt.xt;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.j.xt.tl.i;
import com.bytedance.sdk.component.utils.vl;
import com.umeng.analytics.pro.bm;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class a<T> {

    /* renamed from: a, reason: collision with root package name */
    protected final String f24311a = bm.f41039d;

    /* renamed from: b, reason: collision with root package name */
    protected final String f24312b;

    protected abstract ContentValues a(T t5);

    protected abstract HashMap<String, String> b();

    public void c(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ");
            sb.append(this.f24312b);
            sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            HashMap<String, String> b6 = b();
            if (b6 != null) {
                for (String str : b6.keySet()) {
                    sb.append(str);
                    sb.append(" ");
                    sb.append(b6.get(str));
                    sb.append(",");
                }
                sb.delete(sb.length() - 1, sb.length());
                sb.append(")");
                sQLiteDatabase.execSQL(sb.toString());
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public void insert(SQLiteDatabase sQLiteDatabase, T t5) {
        if (sQLiteDatabase == null || t5 == null) {
            return;
        }
        try {
            sQLiteDatabase.insert(this.f24312b, null, a(t5));
        } catch (Exception e6) {
            i.c(e6);
        }
    }

    protected a(String str) {
        this.f24312b = str;
    }
}
