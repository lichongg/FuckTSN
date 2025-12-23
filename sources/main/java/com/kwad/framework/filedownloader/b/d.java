package com.kwad.framework.filedownloader.b;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.kwad.framework.filedownloader.b.a;
import com.kwad.framework.filedownloader.f.f;
import com.umeng.analytics.pro.bm;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d implements com.kwad.framework.filedownloader.b.a {
    private static boolean amQ;
    private final e amR = new e(com.kwad.framework.filedownloader.f.c.zz());
    private SQLiteDatabase amS;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements a.InterfaceC0654a {
        private final SparseArray<com.kwad.framework.filedownloader.d.c> amG;
        private final SparseArray<List<com.kwad.framework.filedownloader.d.a>> amH;
        private final SparseArray<com.kwad.framework.filedownloader.d.c> amT = new SparseArray<>();
        private b amU;

        a(SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray, SparseArray<List<com.kwad.framework.filedownloader.d.a>> sparseArray2) {
            this.amG = sparseArray;
            this.amH = sparseArray2;
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0654a
        public final void a(int i6, com.kwad.framework.filedownloader.d.c cVar) {
            this.amT.put(i6, cVar);
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0654a
        public final void c(com.kwad.framework.filedownloader.d.c cVar) {
            SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray = this.amG;
            if (sparseArray != null) {
                synchronized (sparseArray) {
                    this.amG.put(cVar.getId(), cVar);
                }
            }
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwad.framework.filedownloader.d.c> iterator() {
            b bVar = d.this.new b();
            this.amU = bVar;
            return bVar;
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0654a
        public final void xU() {
            b bVar = this.amU;
            if (bVar != null) {
                bVar.xU();
            }
            try {
                SQLiteDatabase xV = d.this.xV();
                if (xV == null) {
                    return;
                }
                int size = this.amT.size();
                try {
                    try {
                        if (size < 0) {
                            return;
                        }
                        try {
                            xV.beginTransaction();
                            for (int i6 = 0; i6 < size; i6++) {
                                int keyAt = this.amT.keyAt(i6);
                                com.kwad.framework.filedownloader.d.c cVar = this.amT.get(keyAt);
                                xV.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(keyAt)});
                                xV.insert("ksad_file_download", null, cVar.yX());
                                if (cVar.zc() > 1) {
                                    List<com.kwad.framework.filedownloader.d.a> bE = d.this.bE(keyAt);
                                    if (bE.size() > 0) {
                                        xV.delete("ksad_file_download_connection", "id = ?", new String[]{String.valueOf(keyAt)});
                                        for (com.kwad.framework.filedownloader.d.a aVar : bE) {
                                            aVar.setId(cVar.getId());
                                            xV.insert("ksad_file_download_connection", null, aVar.yX());
                                        }
                                    }
                                }
                            }
                            SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray = this.amG;
                            if (sparseArray != null && this.amH != null) {
                                synchronized (sparseArray) {
                                    try {
                                        int size2 = this.amG.size();
                                        for (int i7 = 0; i7 < size2; i7++) {
                                            int id = this.amG.valueAt(i7).getId();
                                            List<com.kwad.framework.filedownloader.d.a> bE2 = d.this.bE(id);
                                            if (bE2 != null && bE2.size() > 0) {
                                                synchronized (this.amH) {
                                                    this.amH.put(id, bE2);
                                                }
                                            }
                                        }
                                    } finally {
                                    }
                                }
                            }
                            xV.setTransactionSuccessful();
                            xV.endTransaction();
                        } catch (SQLiteException e6) {
                            d.this.a(e6);
                            xV.endTransaction();
                        } catch (Exception e7) {
                            d.printStackTrace(e7);
                            xV.endTransaction();
                        }
                    } finally {
                        try {
                            xV.endTransaction();
                        } catch (Exception e8) {
                            d.printStackTrace(e8);
                        }
                    }
                } catch (Exception e9) {
                    d.printStackTrace(e9);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Iterator<com.kwad.framework.filedownloader.d.c> {
        private Cursor amW;
        private final List<Integer> amX = new ArrayList();
        private int amY;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            try {
                Cursor cursor = this.amW;
                if (cursor != null) {
                    return cursor.moveToNext();
                }
                return false;
            } catch (Throwable th) {
                d.printStackTrace(th);
                return false;
            }
        }

        b() {
            try {
                this.amW = d.this.xV().query("ksad_file_download", null, null, null, null, null, null);
            } catch (SQLiteException e6) {
                d.this.a(e6);
            } catch (Exception e7) {
                d.printStackTrace(e7);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.Iterator
        /* renamed from: xW, reason: merged with bridge method [inline-methods] */
        public com.kwad.framework.filedownloader.d.c next() {
            com.kwad.framework.filedownloader.d.c d6 = d.d(this.amW);
            this.amY = d6.getId();
            return d6;
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.amX.add(Integer.valueOf(this.amY));
        }

        final void xU() {
            Cursor cursor = this.amW;
            if (cursor == null) {
                return;
            }
            cursor.close();
            if (this.amX.isEmpty()) {
                return;
            }
            String join = TextUtils.join(", ", this.amX);
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "delete %s", join);
            }
            try {
                SQLiteDatabase xV = d.this.xV();
                xV.execSQL(f.c("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download", bm.f41039d, join));
                xV.execSQL(f.c("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download_connection", "id", join));
            } catch (SQLiteException e6) {
                d.this.a(e6);
            } catch (Exception e7) {
                d.printStackTrace(e7);
            }
        }
    }

    private void d(com.kwad.framework.filedownloader.d.c cVar) {
        try {
            xV().insert("ksad_file_download", null, cVar.yX());
        } catch (SQLiteException e6) {
            cVar.by(e6.toString());
            cVar.d((byte) -1);
            a(cVar.getId(), e6);
        } catch (Exception e7) {
            printStackTrace(e7);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "update but model == null!", new Object[0]);
            return;
        }
        if (bD(cVar.getId()) == null) {
            d(cVar);
            return;
        }
        try {
            xV().update("ksad_file_download", cVar.yX(), "_id = ? ", new String[]{String.valueOf(cVar.getId())});
        } catch (SQLiteException e6) {
            cVar.by(e6.toString());
            cVar.d((byte) -1);
            a(cVar.getId(), e6);
        } catch (Exception e7) {
            printStackTrace(e7);
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0033: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:52), block:B:28:0x0033 */
    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c bD(int i6) {
        Cursor cursor;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                try {
                } catch (Exception e6) {
                    e = e6;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
                    throw th;
                }
            } catch (SQLiteException e7) {
                e = e7;
            }
            try {
                cursor = xV().rawQuery(f.c("SELECT * FROM %s WHERE %s = ?", "ksad_file_download", bm.f41039d), new String[]{Integer.toString(i6)});
                try {
                    if (cursor.moveToNext()) {
                        com.kwad.framework.filedownloader.d.c d6 = d(cursor);
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        return d6;
                    }
                } catch (SQLiteException e8) {
                    e = e8;
                    a(i6, e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return null;
                } catch (Exception e9) {
                    e = e9;
                    printStackTrace(e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return null;
                }
            } catch (SQLiteException e10) {
                e = e10;
                cursor = null;
                a(i6, e);
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                return null;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            return null;
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
            throw th;
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean bG(int i6) {
        try {
            return xV().delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(i6)}) != 0;
        } catch (SQLiteException e6) {
            printStackTrace(e6);
            return false;
        } catch (Exception e7) {
            printStackTrace(e7);
            return false;
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        try {
            xV().delete("ksad_file_download", null, null);
        } catch (SQLiteException e6) {
            a(e6);
        }
        try {
            xV().delete("ksad_file_download_connection", null, null);
        } catch (SQLiteException e7) {
            a(e7);
        }
    }

    private static void h(Throwable th) {
        if (th != null) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SQLiteDatabase xV() {
        if (this.amS == null) {
            this.amS = this.amR.getWritableDatabase();
        }
        return this.amS;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    @SuppressLint({"Range"})
    public final List<com.kwad.framework.filedownloader.d.a> bE(int i6) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = xV().rawQuery(f.c("SELECT * FROM %s WHERE %s = ?", "ksad_file_download_connection", "id"), new String[]{Integer.toString(i6)});
                while (cursor.moveToNext()) {
                    com.kwad.framework.filedownloader.d.a aVar = new com.kwad.framework.filedownloader.d.a();
                    aVar.setId(i6);
                    aVar.setIndex(cursor.getInt(cursor.getColumnIndex("connectionIndex")));
                    aVar.setStartOffset(cursor.getLong(cursor.getColumnIndex("startOffset")));
                    aVar.X(cursor.getLong(cursor.getColumnIndex("currentOffset")));
                    aVar.Y(cursor.getLong(cursor.getColumnIndex("endOffset")));
                    arrayList.add(aVar);
                }
                return arrayList;
            } catch (SQLiteException e6) {
                a(i6, e6);
                return arrayList;
            } catch (Exception e7) {
                printStackTrace(e7);
                return arrayList;
            }
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void t(int i6, int i7) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i7));
        try {
            xV().update("ksad_file_download", contentValues, "_id = ? ", new String[]{Integer.toString(i6)});
        } catch (SQLiteException e6) {
            a(i6, e6);
        } catch (Exception e7) {
            printStackTrace(e7);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC0654a xT() {
        return new a(null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void printStackTrace(Throwable th) {
        h(th);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        if (aVar != null) {
            try {
                xV().insert("ksad_file_download_connection", null, aVar.yX());
            } catch (SQLiteException e6) {
                a(aVar.getId(), e6);
            } catch (Exception e7) {
                printStackTrace(e7);
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bF(int i6) {
        try {
            xV().execSQL("DELETE FROM ksad_file_download_connection WHERE id = " + i6);
        } catch (SQLiteException e6) {
            printStackTrace(e6);
        } catch (Exception e7) {
            printStackTrace(e7);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void c(int i6, long j6) {
        bG(i6);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i6, int i7, long j6) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j6));
        try {
            xV().update("ksad_file_download_connection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i6), Integer.toString(i7)});
        } catch (SQLiteException e6) {
            a(i6, e6);
        } catch (Exception e7) {
            printStackTrace(e7);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void d(int i6, long j6) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Byte) (byte) -2);
        contentValues.put("sofar", Long.valueOf(j6));
        a(i6, contentValues);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Range"})
    public static com.kwad.framework.filedownloader.d.c d(Cursor cursor) {
        com.kwad.framework.filedownloader.d.c cVar = new com.kwad.framework.filedownloader.d.c();
        if (cursor == null) {
            return cVar;
        }
        cVar.setId(cursor.getInt(cursor.getColumnIndex(bm.f41039d)));
        cVar.setUrl(cursor.getString(cursor.getColumnIndex("url")));
        cVar.d(cursor.getString(cursor.getColumnIndex("path")), cursor.getShort(cursor.getColumnIndex("pathAsDirectory")) == 1);
        cVar.d((byte) cursor.getShort(cursor.getColumnIndex(NotificationCompat.CATEGORY_STATUS)));
        cVar.Z(cursor.getLong(cursor.getColumnIndex("sofar")));
        cVar.ab(cursor.getLong(cursor.getColumnIndex("total")));
        cVar.by(cursor.getString(cursor.getColumnIndex("errMsg")));
        cVar.bx(cursor.getString(cursor.getColumnIndex("etag")));
        cVar.bz(cursor.getString(cursor.getColumnIndex("filename")));
        cVar.bW(cursor.getInt(cursor.getColumnIndex("connectionCount")));
        return cVar;
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(int i6, long j6) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Byte) (byte) 3);
        contentValues.put("sofar", Long.valueOf(j6));
        a(i6, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i6, String str, long j6, long j7, int i7) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sofar", Long.valueOf(j6));
        contentValues.put("total", Long.valueOf(j7));
        contentValues.put("etag", str);
        contentValues.put("connectionCount", Integer.valueOf(i7));
        a(i6, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i6, long j6, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Byte) (byte) 2);
        contentValues.put("total", Long.valueOf(j6));
        contentValues.put("etag", str);
        contentValues.put("filename", str2);
        a(i6, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bC(int i6) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bH(int i6) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i6, Throwable th, long j6) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Byte) (byte) -1);
        contentValues.put("sofar", Long.valueOf(j6));
        a(i6, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i6, Throwable th) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put(NotificationCompat.CATEGORY_STATUS, (Byte) (byte) 5);
        a(i6, contentValues);
    }

    public final a.InterfaceC0654a a(SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray, SparseArray<List<com.kwad.framework.filedownloader.d.a>> sparseArray2) {
        return new a(sparseArray, sparseArray2);
    }

    private void a(int i6, ContentValues contentValues) {
        try {
            xV().update("ksad_file_download", contentValues, "_id = ? ", new String[]{String.valueOf(i6)});
        } catch (SQLiteException e6) {
            a(i6, e6);
        } catch (Exception e7) {
            printStackTrace(e7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SQLiteException sQLiteException) {
        a(-1, sQLiteException);
    }

    private void a(int i6, @Nullable SQLiteException sQLiteException) {
        if (sQLiteException instanceof SQLiteFullException) {
            if (i6 != -1) {
                bG(i6);
                bF(i6);
            }
            h(sQLiteException);
            amQ = true;
            return;
        }
        printStackTrace(sQLiteException);
    }
}
