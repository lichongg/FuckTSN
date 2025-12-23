package cn.jpush.android.v;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class e extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    private volatile int f3930a;

    /* renamed from: b, reason: collision with root package name */
    private volatile int f3931b;

    /* renamed from: c, reason: collision with root package name */
    private volatile SQLiteDatabase f3932c;

    /* renamed from: d, reason: collision with root package name */
    private volatile SQLiteDatabase f3933d;

    /* renamed from: e, reason: collision with root package name */
    private final Object f3934e;

    /* renamed from: f, reason: collision with root package name */
    private final Object f3935f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f3936g;

    /* renamed from: h, reason: collision with root package name */
    private final String f3937h;

    /* renamed from: i, reason: collision with root package name */
    private final int f3938i;

    /* renamed from: j, reason: collision with root package name */
    private final SQLiteDatabase.CursorFactory f3939j;

    public boolean a(boolean z5) {
        try {
            if (z5) {
                synchronized (this.f3934e) {
                    getWritableDatabase();
                    this.f3931b++;
                }
                return true;
            }
            synchronized (this.f3935f) {
                getReadableDatabase();
                this.f3930a++;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
        return false;
    }

    public void b(boolean z5) {
        if (z5) {
            synchronized (this.f3934e) {
                try {
                    if (this.f3933d != null && this.f3933d.isOpen()) {
                        int i6 = this.f3931b - 1;
                        this.f3931b = i6;
                        if (i6 <= 0) {
                        }
                    }
                    this.f3931b = 0;
                    if (this.f3933d != null) {
                        this.f3933d.close();
                    }
                    this.f3933d = null;
                } finally {
                }
            }
            return;
        }
        synchronized (this.f3935f) {
            try {
                if (this.f3932c != null && this.f3932c.isOpen()) {
                    int i7 = this.f3930a - 1;
                    this.f3930a = i7;
                    if (i7 <= 0) {
                    }
                }
                this.f3930a = 0;
                if (this.f3932c != null) {
                    this.f3932c.close();
                }
                this.f3932c = null;
            } finally {
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        if (this.f3932c == null || !this.f3932c.isOpen()) {
            synchronized (this.f3935f) {
                if (this.f3932c == null || !this.f3932c.isOpen()) {
                    try {
                        getWritableDatabase();
                    } catch (SQLiteException unused) {
                    }
                    String path = this.f3936g.getDatabasePath(this.f3937h).getPath();
                    this.f3932c = SQLiteDatabase.openDatabase(path, this.f3939j, 1);
                    if (this.f3932c.getVersion() != this.f3938i) {
                        throw new SQLiteException("Can't upgrade read-only database from version " + this.f3932c.getVersion() + " to " + this.f3938i + ": " + path);
                    }
                    this.f3930a = 0;
                    onOpen(this.f3932c);
                }
            }
        }
        return this.f3932c;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        if (this.f3933d == null || !this.f3933d.isOpen()) {
            synchronized (this.f3934e) {
                try {
                    if (this.f3933d != null) {
                        if (!this.f3933d.isOpen()) {
                        }
                    }
                    this.f3931b = 0;
                    this.f3933d = super.getWritableDatabase();
                    this.f3933d.enableWriteAheadLogging();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f3933d;
    }

    public e(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i6) {
        super(context, str, cursorFactory, i6);
        this.f3930a = 0;
        this.f3931b = 0;
        this.f3934e = new Object();
        this.f3935f = new Object();
        this.f3936g = context;
        this.f3937h = str;
        this.f3938i = i6;
        this.f3939j = cursorFactory;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    @Deprecated
    public void close() {
    }
}
