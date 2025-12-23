package com.kwad.components.core.c;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class e implements i {
    private static volatile e NE;

    @Nullable
    private String NF;
    private int NG = 0;
    private int cacheSize = 1;
    private long NH = 1800;
    private boolean enable = false;

    private e() {
    }

    public static synchronized List<e> a(Cursor cursor) {
        synchronized (e.class) {
            if (cursor == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (cursor.moveToNext()) {
                try {
                    arrayList.add(b(cursor));
                } catch (Exception e6) {
                    com.kwad.sdk.core.d.c.printStackTrace(e6);
                }
            }
            return arrayList;
        }
    }

    public static e au(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return null;
        }
        long j6 = adTemplate.posId;
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        e eVar = new e(j6);
        AdInfo.AdBaseInfo adBaseInfo = el.adBaseInfo;
        eVar.NG = adBaseInfo.adCacheStrategy;
        eVar.NH = adBaseInfo.adCacheSecond;
        eVar.cacheSize = adBaseInfo.adCacheSize;
        eVar.enable = adBaseInfo.adCacheSwitch == 1;
        return eVar;
    }

    private static synchronized e b(Cursor cursor) {
        e eVar;
        synchronized (e.class) {
            String string = cursor.getString(cursor.getColumnIndex("posId"));
            int i6 = cursor.getInt(cursor.getColumnIndex("strategyCode"));
            int i7 = cursor.getInt(cursor.getColumnIndex("cacheSize"));
            long j6 = cursor.getLong(cursor.getColumnIndex("cacheSecond"));
            boolean z5 = true;
            if (cursor.getInt(cursor.getColumnIndex("enable")) != 1) {
                z5 = false;
            }
            eVar = new e();
            eVar.NF = string;
            eVar.NG = i6;
            eVar.cacheSize = i7;
            eVar.NH = j6;
            eVar.enable = z5;
        }
        return eVar;
    }

    @NonNull
    private static e of() {
        if (NE == null) {
            synchronized (e.class) {
                try {
                    if (NE == null) {
                        NE = new e();
                    }
                } finally {
                }
            }
        }
        return NE;
    }

    public final boolean isEnable() {
        return this.enable;
    }

    public final String og() {
        return this.NF;
    }

    public final int oh() {
        return this.NG;
    }

    public final int oi() {
        return this.cacheSize;
    }

    public final long oj() {
        return this.NH;
    }

    @Override // com.kwad.components.core.c.i
    public final ContentValues ok() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("posId", this.NF);
        contentValues.put("strategyCode", Integer.valueOf(this.NG));
        contentValues.put("cacheSize", Integer.valueOf(this.cacheSize));
        contentValues.put("cacheSecond", Long.valueOf(this.NH));
        contentValues.put("enable", Integer.valueOf(this.enable ? 1 : 0));
        return contentValues;
    }

    @NonNull
    @WorkerThread
    public static e x(long j6) {
        e ad;
        if (a.nZ() != null && (ad = a.nZ().ad(String.valueOf(j6))) != null) {
            return ad;
        }
        return of();
    }

    public final boolean isDefault() {
        return equals(of());
    }

    private e(long j6) {
        this.NF = String.valueOf(j6);
    }
}
