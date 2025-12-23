package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class m<T extends e> implements l<T> {
    private final Map<String, T> aGD = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public synchronized void l(@NonNull T t5) {
        this.aGD.put(t5.actionId, t5);
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized void B(List<T> list) {
        for (T t5 : list) {
            if (t5 != null) {
                this.aGD.remove(t5.actionId);
            }
        }
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized long size() {
        int size;
        size = this.aGD.size();
        com.kwad.sdk.core.d.c.d("MemReportCache", "size() = " + size);
        return size;
    }

    @Override // com.kwad.sdk.core.report.l
    public final List<T> dE(int i6) {
        ArrayList arrayList = new ArrayList(this.aGD.size());
        synchronized (this.aGD) {
            try {
                Iterator<Map.Entry<String, T>> it = this.aGD.entrySet().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getValue());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }
}
