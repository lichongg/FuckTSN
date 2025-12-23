package com.kwad.sdk.core.report;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class d implements l<e> {
    private static final String[] aGs = {"count(*)"};
    private static boolean aGt = false;
    protected c aGu;

    private synchronized void c(e eVar) {
        if (aGt) {
            getTag();
            Objects.toString(eVar);
        }
        try {
            this.aGu.getReadableDatabase().delete(Ip(), "actionId=?", new String[]{eVar.actionId});
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
        }
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized void B(List<e> list) {
        if (aGt) {
            getTag();
            list.size();
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.aGu.getReadableDatabase();
                sQLiteDatabase.beginTransaction();
                Iterator<e> it = list.iterator();
                while (it.hasNext()) {
                    c(it.next());
                }
                sQLiteDatabase.setTransactionSuccessful();
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e6) {
                    com.kwad.sdk.core.d.c.printStackTrace(e6);
                }
            } finally {
            }
        } catch (Exception e7) {
            com.kwad.sdk.core.d.c.printStackTrace(e7);
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e8) {
                    com.kwad.sdk.core.d.c.printStackTrace(e8);
                }
            }
        }
    }

    protected abstract String Ip();

    protected abstract String[] Iq();

    public final synchronized List<e> Ir() {
        Cursor cursor = null;
        try {
            try {
                String[] Iq = Iq();
                cursor = this.aGu.getReadableDatabase().query(Ip(), Iq.length == 0 ? null : Iq, null, null, null, null, null);
                if (cursor != null) {
                    ArrayList<e> arrayList = new ArrayList();
                    while (cursor.moveToNext()) {
                        try {
                            arrayList.add(f(cursor));
                        } catch (Exception e6) {
                            com.kwad.sdk.core.d.c.printStackTrace(e6);
                        }
                    }
                    if (aGt) {
                        getTag();
                        arrayList.size();
                        for (e eVar : arrayList) {
                            getTag();
                            Objects.toString(eVar);
                        }
                    }
                    return arrayList;
                }
            } catch (Exception e7) {
                com.kwad.sdk.core.d.c.printStackTrace(e7);
            }
            return new ArrayList();
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        }
    }

    @Override // com.kwad.sdk.core.report.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final synchronized void l(e eVar) {
        if (aGt) {
            getTag();
            Objects.toString(eVar);
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("actionId", eVar.actionId);
            contentValues.put("aLog", eVar.toJson().toString());
            try {
                this.aGu.getReadableDatabase().insert(Ip(), null, contentValues);
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
        } catch (Exception e7) {
            com.kwad.sdk.core.d.c.printStackTrace(e7);
        }
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized List<e> dE(int i6) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = this.aGu.getReadableDatabase().query(Ip(), Iq(), null, null, null, null, null, "0,200");
                while (cursor.moveToNext()) {
                    try {
                        arrayList.add(f(cursor));
                    } catch (Exception e6) {
                        com.kwad.sdk.core.d.c.printStackTrace(e6);
                    }
                }
            } catch (Exception e7) {
                com.kwad.sdk.core.d.c.printStackTrace(e7);
            }
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        }
        return arrayList;
    }

    protected abstract e f(@NonNull Cursor cursor);

    protected abstract String getTag();

    @Override // com.kwad.sdk.core.report.l
    public final synchronized long size() {
        long j6;
        Cursor cursor = null;
        try {
            try {
                cursor = this.aGu.getReadableDatabase().query(Ip(), aGs, null, null, null, null, null);
                cursor.moveToFirst();
                j6 = cursor.getLong(0);
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
                j6 = 0;
            }
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
        }
        return j6;
    }

    private void a(c cVar) {
        this.aGu = cVar;
    }

    public d(c cVar) {
        a(cVar);
    }
}
