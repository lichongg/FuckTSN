package com.ss.android.socialbase.downloader.ae;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import com.umeng.analytics.pro.bm;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\Downloads\app\classes6.dex */
public class xt implements Parcelable {
    public static final Parcelable.Creator<xt> CREATOR = new Parcelable.Creator<xt>() { // from class: com.ss.android.socialbase.downloader.ae.xt.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public xt createFromParcel(Parcel parcel) {
            return new xt(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public xt[] newArray(int i6) {
            return new xt[i6];
        }
    };

    /* renamed from: j, reason: collision with root package name */
    private static final String f38630j = "xt";
    private int ae;
    private com.ss.android.socialbase.downloader.ws.xt az;
    private long cw;

    /* renamed from: g, reason: collision with root package name */
    private long f38631g;
    private boolean jy;

    /* renamed from: m, reason: collision with root package name */
    private long f38632m;
    private List<xt> oq;
    private xt qv;

    /* renamed from: r, reason: collision with root package name */
    private AtomicLong f38633r;
    private AtomicInteger tl;
    private long up;
    private int vl;
    private AtomicBoolean ws;
    private int xt;

    public static class j {
        private long ae;
        private long cw;

        /* renamed from: j, reason: collision with root package name */
        private int f38634j;

        /* renamed from: m, reason: collision with root package name */
        private int f38635m;

        /* renamed from: r, reason: collision with root package name */
        private long f38636r;
        private xt tl;
        private long up;
        private long xt;

        public j cw(long j6) {
            this.f38636r = j6;
            return this;
        }

        public j j(long j6) {
            this.xt = j6;
            return this;
        }

        public j r(long j6) {
            this.up = j6;
            return this;
        }

        public j up(long j6) {
            this.ae = j6;
            return this;
        }

        public j xt(long j6) {
            this.cw = j6;
            return this;
        }

        public j(int i6) {
            this.f38634j = i6;
        }

        public j j(int i6) {
            this.f38635m = i6;
            return this;
        }

        public j j(xt xtVar) {
            this.tl = xtVar;
            return this;
        }

        public xt j() {
            return new xt(this);
        }
    }

    public boolean cw() {
        AtomicBoolean atomicBoolean = this.ws;
        if (atomicBoolean == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ContentValues j() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(bm.f41039d, Integer.valueOf(this.xt));
        contentValues.put("chunkIndex", Integer.valueOf(this.ae));
        contentValues.put("startOffset", Long.valueOf(this.cw));
        contentValues.put("curOffset", Long.valueOf(ws()));
        contentValues.put("endOffset", Long.valueOf(this.up));
        contentValues.put("chunkContentLen", Long.valueOf(this.f38632m));
        contentValues.put("hostChunkIndex", Integer.valueOf(xt()));
        return contentValues;
    }

    public int xt() {
        AtomicInteger atomicInteger = this.tl;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    private xt(j jVar) {
        if (jVar == null) {
            return;
        }
        this.xt = jVar.f38634j;
        this.cw = jVar.xt;
        this.f38633r = new AtomicLong(jVar.cw);
        this.up = jVar.f38636r;
        this.f38632m = jVar.up;
        this.ae = jVar.f38635m;
        this.f38631g = jVar.ae;
        this.tl = new AtomicInteger(-1);
        j(jVar.tl);
        this.ws = new AtomicBoolean(false);
    }

    public List<xt> ae() {
        return this.oq;
    }

    public long av() {
        return this.up;
    }

    public boolean g() {
        long j6 = this.cw;
        if (r()) {
            long j7 = this.f38631g;
            if (j7 > this.cw) {
                j6 = j7;
            }
        }
        return ws() - j6 >= this.f38632m;
    }

    public long i() {
        return this.f38632m;
    }

    public long jy() {
        AtomicLong atomicLong = this.f38633r;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public boolean m() {
        List<xt> list = this.oq;
        return list != null && list.size() > 0;
    }

    public int mi() {
        return this.ae;
    }

    public long oq() {
        xt xtVar = this.qv;
        if (xtVar != null && xtVar.ae() != null) {
            int indexOf = this.qv.ae().indexOf(this);
            boolean z5 = false;
            for (int i6 = 0; i6 < this.qv.ae().size(); i6++) {
                xt xtVar2 = this.qv.ae().get(i6);
                if (xtVar2 != null) {
                    if (z5) {
                        return xtVar2.ws();
                    }
                    if (indexOf == i6) {
                        z5 = true;
                    }
                }
            }
        }
        return -1L;
    }

    public int qv() {
        return this.xt;
    }

    public boolean tl() {
        xt xtVar = this.qv;
        if (xtVar == null) {
            return true;
        }
        if (!xtVar.m()) {
            return false;
        }
        for (int i6 = 0; i6 < this.qv.ae().size(); i6++) {
            xt xtVar2 = this.qv.ae().get(i6);
            if (xtVar2 != null) {
                int indexOf = this.qv.ae().indexOf(this);
                if (indexOf > i6 && !xtVar2.g()) {
                    return false;
                }
                if (indexOf == i6) {
                    return true;
                }
            }
        }
        return false;
    }

    public long vl() {
        return this.cw;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.xt);
        parcel.writeLong(this.cw);
        AtomicLong atomicLong = this.f38633r;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.up);
        parcel.writeLong(this.f38632m);
        parcel.writeInt(this.ae);
        AtomicInteger atomicInteger = this.tl;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }

    public long az() {
        long ws = ws() - this.cw;
        if (m()) {
            ws = 0;
            for (int i6 = 0; i6 < this.oq.size(); i6++) {
                xt xtVar = this.oq.get(i6);
                if (xtVar != null) {
                    ws += xtVar.ws() - xtVar.vl();
                }
            }
        }
        return ws;
    }

    public void cw(int i6) {
        this.ae = i6;
    }

    public boolean r() {
        if (xt() == -1) {
            return true;
        }
        return false;
    }

    public xt up() {
        xt xtVar;
        if (!r()) {
            xtVar = this.qv;
        } else {
            xtVar = this;
        }
        if (xtVar != null && xtVar.m()) {
            return xtVar.ae().get(0);
        }
        return null;
    }

    public void w() {
        this.f38631g = ws();
    }

    public long ws() {
        if (r() && m()) {
            long j6 = 0;
            for (int i6 = 0; i6 < this.oq.size(); i6++) {
                xt xtVar = this.oq.get(i6);
                if (xtVar != null) {
                    if (!xtVar.g()) {
                        return xtVar.jy();
                    }
                    if (j6 < xtVar.jy()) {
                        j6 = xtVar.jy();
                    }
                }
            }
            return j6;
        }
        return jy();
    }

    public void xt(boolean z5) {
        this.jy = z5;
    }

    public long cw(boolean z5) {
        long ws = ws();
        long j6 = this.f38632m;
        long j7 = this.f38631g;
        long j8 = j6 - (ws - j7);
        if (!z5 && ws == j7) {
            j8 = j6 - (ws - this.cw);
        }
        com.ss.android.socialbase.downloader.m.j.xt("DownloadChunk", "contentLength:" + this.f38632m + " curOffset:" + ws() + " oldOffset:" + this.f38631g + " retainLen:" + j8);
        if (j8 < 0) {
            return 0L;
        }
        return j8;
    }

    public void xt(int i6) {
        this.xt = i6;
    }

    public void xt(long j6) {
        AtomicLong atomicLong = this.f38633r;
        if (atomicLong != null) {
            atomicLong.set(j6);
        } else {
            this.f38633r = new AtomicLong(j6);
        }
    }

    public void j(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.vl = 0;
        sQLiteStatement.clearBindings();
        int i6 = this.vl + 1;
        this.vl = i6;
        sQLiteStatement.bindLong(i6, this.xt);
        int i7 = this.vl + 1;
        this.vl = i7;
        sQLiteStatement.bindLong(i7, this.ae);
        int i8 = this.vl + 1;
        this.vl = i8;
        sQLiteStatement.bindLong(i8, this.cw);
        int i9 = this.vl + 1;
        this.vl = i9;
        sQLiteStatement.bindLong(i9, ws());
        int i10 = this.vl + 1;
        this.vl = i10;
        sQLiteStatement.bindLong(i10, this.up);
        int i11 = this.vl + 1;
        this.vl = i11;
        sQLiteStatement.bindLong(i11, this.f38632m);
        int i12 = this.vl + 1;
        this.vl = i12;
        sQLiteStatement.bindLong(i12, xt());
    }

    public xt(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.xt = cursor.getInt(cursor.getColumnIndex(bm.f41039d));
        this.ae = cursor.getInt(cursor.getColumnIndex("chunkIndex"));
        this.cw = cursor.getLong(cursor.getColumnIndex("startOffset"));
        int columnIndex = cursor.getColumnIndex("curOffset");
        if (columnIndex != -1) {
            this.f38633r = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.f38633r = new AtomicLong(0L);
        }
        this.up = cursor.getLong(cursor.getColumnIndex("endOffset"));
        int columnIndex2 = cursor.getColumnIndex("hostChunkIndex");
        if (columnIndex2 != -1) {
            this.tl = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.tl = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex("chunkContentLen");
        if (columnIndex3 != -1) {
            this.f38632m = cursor.getLong(columnIndex3);
        }
        this.ws = new AtomicBoolean(false);
    }

    public void j(int i6) {
        AtomicInteger atomicInteger = this.tl;
        if (atomicInteger == null) {
            this.tl = new AtomicInteger(i6);
        } else {
            atomicInteger.set(i6);
        }
    }

    public void j(com.ss.android.socialbase.downloader.ws.xt xtVar) {
        this.az = xtVar;
        w();
    }

    public void j(boolean z5) {
        AtomicBoolean atomicBoolean = this.ws;
        if (atomicBoolean == null) {
            this.ws = new AtomicBoolean(z5);
        } else {
            atomicBoolean.set(z5);
        }
        this.az = null;
    }

    protected xt(Parcel parcel) {
        this.xt = parcel.readInt();
        this.cw = parcel.readLong();
        this.f38633r = new AtomicLong(parcel.readLong());
        this.up = parcel.readLong();
        this.f38632m = parcel.readLong();
        this.ae = parcel.readInt();
        this.tl = new AtomicInteger(parcel.readInt());
    }

    public void j(xt xtVar) {
        this.qv = xtVar;
        if (xtVar != null) {
            j(xtVar.mi());
        }
    }

    public void j(List<xt> list) {
        this.oq = list;
    }

    public void j(long j6) {
        this.f38632m = j6;
    }

    public List<xt> j(int i6, long j6) {
        long av;
        long j7;
        long j8;
        long j9;
        long j10;
        int i7 = i6;
        if (!r() || m()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long jy = jy();
        long cw = cw(true);
        long j11 = cw / i7;
        com.ss.android.socialbase.downloader.m.j.xt(f38630j, "retainLen:" + cw + " divideChunkForReuse chunkSize:" + j11 + " current host downloadChunk index:" + this.ae);
        int i8 = 0;
        while (i8 < i7) {
            if (i8 == 0) {
                j7 = vl();
            } else {
                int i9 = i7 - 1;
                if (i8 == i9) {
                    long av2 = av();
                    j8 = cw;
                    j9 = av2 > jy ? (av2 - jy) + 1 : cw - (i9 * j11);
                    j10 = av2;
                    j7 = jy;
                    xt j12 = new j(this.xt).j((-i8) - 1).j(j7).xt(jy).up(jy).cw(j10).r(j9).j(this).j();
                    long j13 = j11;
                    com.ss.android.socialbase.downloader.m.j.xt(f38630j, "divide sub chunk : " + i8 + " startOffset:" + j7 + " curOffset:" + jy + " endOffset:" + j10 + " contentLen:" + j9);
                    arrayList.add(j12);
                    jy += j13;
                    i8++;
                    i7 = i6;
                    cw = j8;
                    j11 = j13;
                } else {
                    j7 = jy;
                }
            }
            j10 = (jy + j11) - 1;
            j8 = cw;
            j9 = j11;
            xt j122 = new j(this.xt).j((-i8) - 1).j(j7).xt(jy).up(jy).cw(j10).r(j9).j(this).j();
            long j132 = j11;
            com.ss.android.socialbase.downloader.m.j.xt(f38630j, "divide sub chunk : " + i8 + " startOffset:" + j7 + " curOffset:" + jy + " endOffset:" + j10 + " contentLen:" + j9);
            arrayList.add(j122);
            jy += j132;
            i8++;
            i7 = i6;
            cw = j8;
            j11 = j132;
        }
        long j14 = 0;
        for (int size = arrayList.size() - 1; size > 0; size--) {
            xt xtVar = arrayList.get(size);
            if (xtVar != null) {
                j14 += xtVar.i();
            }
        }
        com.ss.android.socialbase.downloader.m.j.xt(f38630j, "reuseChunkContentLen:".concat(String.valueOf(j14)));
        xt xtVar2 = arrayList.get(0);
        if (xtVar2 != null) {
            if (av() == 0) {
                av = j6 - vl();
            } else {
                av = (av() - vl()) + 1;
            }
            xtVar2.j(av - j14);
            xtVar2.cw(this.ae);
            com.ss.android.socialbase.downloader.ws.xt xtVar3 = this.az;
            if (xtVar3 != null) {
                xtVar3.j(xtVar2.av(), i() - j14);
            }
        }
        j(arrayList);
        return arrayList;
    }
}
