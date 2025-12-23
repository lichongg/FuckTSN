package com.ss.android.socialbase.downloader.cw;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.az.g;

/* loaded from: D:\Downloads\app\classes6.dex */
public class ae {
    private SQLiteStatement ae;
    private final String[] cw;

    /* renamed from: j, reason: collision with root package name */
    private final SQLiteDatabase f38690j;

    /* renamed from: m, reason: collision with root package name */
    private SQLiteStatement f38691m;

    /* renamed from: r, reason: collision with root package name */
    private final String[] f38692r;
    private SQLiteStatement tl;
    private SQLiteStatement up;
    private final String xt;

    public SQLiteStatement cw() {
        if (this.f38691m == null) {
            SQLiteStatement compileStatement = this.f38690j.compileStatement(g.j(this.xt, this.cw, this.f38692r));
            synchronized (this) {
                try {
                    if (this.f38691m == null) {
                        this.f38691m = compileStatement;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.f38691m != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f38691m;
    }

    public SQLiteStatement j() {
        if (this.up == null) {
            SQLiteStatement compileStatement = this.f38690j.compileStatement(g.j("INSERT INTO ", this.xt, this.cw));
            synchronized (this) {
                try {
                    if (this.up == null) {
                        this.up = compileStatement;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.up != compileStatement) {
                compileStatement.close();
            }
        }
        return this.up;
    }

    public SQLiteStatement r() {
        if (this.tl == null) {
            SQLiteStatement compileStatement = this.f38690j.compileStatement(g.xt(this.xt, this.cw, this.f38692r));
            synchronized (this) {
                try {
                    if (this.tl == null) {
                        this.tl = compileStatement;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.tl != compileStatement) {
                compileStatement.close();
            }
        }
        return this.tl;
    }

    public SQLiteStatement xt() {
        if (this.ae == null) {
            SQLiteStatement compileStatement = this.f38690j.compileStatement(g.j(this.xt, this.f38692r));
            synchronized (this) {
                try {
                    if (this.ae == null) {
                        this.ae = compileStatement;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.ae != compileStatement) {
                compileStatement.close();
            }
        }
        return this.ae;
    }

    public ae(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.f38690j = sQLiteDatabase;
        this.xt = str;
        this.cw = strArr;
        this.f38692r = strArr2;
    }
}
