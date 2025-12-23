package com.kwad.framework.filedownloader.d;

import android.content.ContentValues;
import com.kwad.framework.filedownloader.f.f;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private long anh;
    private long ani;
    private long anj;
    private int id;
    private int index;

    public final void X(long j6) {
        this.ani = j6;
    }

    public final void Y(long j6) {
        this.anj = j6;
    }

    public final int getId() {
        return this.id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final long getStartOffset() {
        return this.anh;
    }

    public final void setId(int i6) {
        this.id = i6;
    }

    public final void setIndex(int i6) {
        this.index = i6;
    }

    public final void setStartOffset(long j6) {
        this.anh = j6;
    }

    public final String toString() {
        return f.c("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.id), Integer.valueOf(this.index), Long.valueOf(this.anh), Long.valueOf(this.anj), Long.valueOf(this.ani));
    }

    public final long yV() {
        return this.ani;
    }

    public final long yW() {
        return this.anj;
    }

    public final ContentValues yX() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.id));
        contentValues.put("connectionIndex", Integer.valueOf(this.index));
        contentValues.put("startOffset", Long.valueOf(this.anh));
        contentValues.put("currentOffset", Long.valueOf(this.ani));
        contentValues.put("endOffset", Long.valueOf(this.anj));
        return contentValues;
    }

    public static long s(List<a> list) {
        long j6 = 0;
        for (a aVar : list) {
            j6 += aVar.yV() - aVar.getStartOffset();
        }
        return j6;
    }
}
