package com.amap.api.col.p0003l;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class f6 extends SQLiteOpenHelper {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f6186b = true;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f6187c;

    /* renamed from: a, reason: collision with root package name */
    private d6 f6188a;

    public f6(Context context, String str, int i6, d6 d6Var) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i6);
        this.f6188a = d6Var;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f6188a.a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
        this.f6188a.a(sQLiteDatabase, i6);
    }
}
