package org.apache.commons.net.io;

import java.util.EventListener;
import java.util.Iterator;
import org.apache.commons.net.util.ListenerList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b implements c {

    /* renamed from: a, reason: collision with root package name */
    private final ListenerList f50837a = new ListenerList();

    @Override // org.apache.commons.net.io.c
    public void a(CopyStreamEvent copyStreamEvent) {
        Iterator<EventListener> it = this.f50837a.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(copyStreamEvent);
        }
    }

    @Override // org.apache.commons.net.io.c
    public void c(long j6, int i6, long j7) {
        Iterator<EventListener> it = this.f50837a.iterator();
        while (it.hasNext()) {
            ((c) it.next()).c(j6, i6, j7);
        }
    }

    public void e(c cVar) {
        this.f50837a.addListener(cVar);
    }

    public void f(c cVar) {
        this.f50837a.removeListener(cVar);
    }
}
