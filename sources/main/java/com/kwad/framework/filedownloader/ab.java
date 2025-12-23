package com.kwad.framework.filedownloader;

import android.os.Handler;
import android.util.SparseArray;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class ab implements w {
    private final SparseArray<Handler> amA = new SparseArray<>();

    private static void a(Handler handler) {
        handler.sendEmptyMessage(2);
    }

    private static void b(Handler handler) {
        handler.sendEmptyMessage(3);
    }

    @Override // com.kwad.framework.filedownloader.w
    public final void xO() {
        for (int i6 = 0; i6 < this.amA.size(); i6++) {
            a(this.amA.get(this.amA.keyAt(i6)));
        }
    }

    @Override // com.kwad.framework.filedownloader.w
    public final boolean bA(int i6) {
        return this.amA.get(i6) != null;
    }

    @Override // com.kwad.framework.filedownloader.w
    public final int xP() {
        return this.amA.size();
    }

    ab() {
    }

    @Override // com.kwad.framework.filedownloader.w
    public final void q(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            b(this.amA.get(it.next().intValue()));
        }
    }
}
