package com.kwad.components.core.c;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {
    private static volatile a Ns;
    private final SQLiteDatabase Nq;
    private ConcurrentHashMap<String, e> Nr = new ConcurrentHashMap<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.core.c.a$a, reason: collision with other inner class name */
    static class C0606a extends SQLiteOpenHelper {
        private static int Nv = 1;
        private String Nw;
        private String Nx;

        public C0606a(@Nullable Context context) {
            super(context, "ksadcache.db", (SQLiteDatabase.CursorFactory) null, Nv);
            this.Nw = "CREATE TABLE IF NOT EXISTS ksad_ad_cache (creativeId VARCHAR PRIMARY KEY NOT NULL, posId TEXT, adJson TEXT, ecpm INTEGER, playAgainJson TEXT, adSenseJson TEXT, createTime INTEGER, expireTime INTEGER)";
            this.Nx = "CREATE TABLE IF NOT EXISTS ksad_ad_cache_strategy(posId VARCHAR PRIMARY KEY NOT NULL, cacheSize INTEGER, cacheSecond INTEGER, strategyCode INTEGER, enable INTEGER)";
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(this.Nw);
            sQLiteDatabase.execSQL(this.Nx);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
        }
    }

    @WorkerThread
    public final void ob() {
        Cursor cursor = null;
        try {
            cursor = this.Nq.rawQuery("select  * from ksad_ad_cache_strategy", null);
            List<e> a6 = e.a(cursor);
            if (a6 != null && !a6.isEmpty()) {
                for (e eVar : a6) {
                    com.kwad.sdk.core.d.c.d("AdCacheDBManager", "readCacheStrategyList:" + eVar.og());
                    this.Nr.put(eVar.og(), eVar);
                }
            }
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends i> void b(List<T> list, String str) {
        SQLiteDatabase sQLiteDatabase;
        try {
            try {
                this.Nq.beginTransaction();
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    try {
                        com.kwad.sdk.core.d.c.d("AdCacheDBManager", "insertData: " + str + ", rowId: " + this.Nq.insertWithOnConflict(str, null, it.next().ok(), 5));
                    } catch (Exception e6) {
                        com.kwad.sdk.core.d.c.printStackTrace(e6);
                    }
                }
                this.Nq.setTransactionSuccessful();
                sQLiteDatabase = this.Nq;
                if (sQLiteDatabase == null) {
                    return;
                }
            } catch (Throwable th) {
                SQLiteDatabase sQLiteDatabase2 = this.Nq;
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.endTransaction();
                    } catch (Exception e7) {
                        com.kwad.sdk.core.d.c.printStackTrace(e7);
                    }
                }
                throw th;
            }
        } catch (Exception e8) {
            com.kwad.sdk.core.d.c.printStackTrace(e8);
            sQLiteDatabase = this.Nq;
            if (sQLiteDatabase == null) {
                return;
            }
        }
        try {
            sQLiteDatabase.endTransaction();
        } catch (Exception e9) {
            com.kwad.sdk.core.d.c.printStackTrace(e9);
        }
    }

    @Nullable
    public static a nZ() {
        if (Ns == null) {
            synchronized (a.class) {
                if (Ns == null) {
                    try {
                        Ns = new a(ServiceProvider.Pp());
                    } catch (SQLiteException e6) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
                        Ns = null;
                    }
                }
            }
        }
        return Ns;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0057: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:45:0x0057 */
    @Nullable
    @WorkerThread
    public final List<h> a(String str, long j6, int i6) {
        Cursor cursor;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                cursor = this.Nq.rawQuery("select  * from ksad_ad_cache where posId=? order by createTime desc", new String[]{str});
            } catch (Exception e6) {
                e = e6;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
                throw th;
            }
            try {
                List<h> a6 = h.a(cursor);
                if (a6 == null) {
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return null;
                }
                StringBuilder sb = new StringBuilder("(posId = " + str + ") AND (");
                ArrayList arrayList = new ArrayList();
                int i7 = 0;
                for (h hVar : a6) {
                    i7++;
                    if (i7 > i6) {
                        sb.append(" creativeId = ");
                        sb.append(hVar.os());
                        if (i7 == a6.size()) {
                            sb.append(")");
                        } else {
                            sb.append(" OR");
                        }
                    } else if (hVar.oq() >= j6) {
                        arrayList.add(hVar);
                    }
                }
                if (i7 > i6) {
                    this.Nq.delete("ksad_ad_cache", sb.toString(), new String[0]);
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return arrayList;
            } catch (Exception e7) {
                e = e7;
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
            throw th;
        }
    }

    @WorkerThread
    public final e ad(String str) {
        Cursor cursor;
        e eVar;
        ConcurrentHashMap<String, e> concurrentHashMap = this.Nr;
        if (concurrentHashMap != null && (eVar = concurrentHashMap.get(str)) != null) {
            com.kwad.sdk.core.d.c.d("AdCacheDBManager", "findCacheStrategyList from cache, posId: " + str);
            return eVar;
        }
        Cursor cursor2 = null;
        try {
            cursor = this.Nq.rawQuery("select  * from ksad_ad_cache_strategy where posId=?", new String[]{str});
        } catch (Exception e6) {
            e = e6;
            cursor = null;
        } catch (Throwable th) {
            th = th;
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor2);
            throw th;
        }
        try {
            try {
                List<e> a6 = e.a(cursor);
                if (a6 != null && a6.size() > 0) {
                    e eVar2 = a6.get(0);
                    this.Nr.put(str, eVar2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return eVar2;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor2);
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            return null;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        return null;
    }

    @WorkerThread
    public final void j(List<h> list) {
        b(list, "ksad_ad_cache");
    }

    @WorkerThread
    public final void w(long j6) {
        try {
            com.kwad.sdk.core.d.c.d("AdCacheDBManager", "deleteCachedAdByCreativeId result: " + this.Nq.delete("ksad_ad_cache", "creativeId=?", new String[]{String.valueOf(j6)}));
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
        }
    }

    private a(Context context) {
        this.Nq = new C0606a(context).getWritableDatabase();
    }

    @WorkerThread
    public final void oa() {
        try {
            this.Nq.delete("ksad_ad_cache", "expireTime<?", new String[]{String.valueOf(System.currentTimeMillis() / 1000)});
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
        }
    }

    public final void a(final e eVar) {
        this.Nr.put(eVar.og(), eVar);
        GlobalThreadPools.Jy().execute(new Runnable() { // from class: com.kwad.components.core.c.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.b(Collections.singletonList(eVar), "ksad_ad_cache_strategy");
            }
        });
    }
}
