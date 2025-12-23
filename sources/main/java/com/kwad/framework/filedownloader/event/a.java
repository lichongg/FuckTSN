package com.kwad.framework.filedownloader.event;

import com.kwad.framework.filedownloader.f.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {
    private final Executor aou = com.kwad.framework.filedownloader.f.b.r(10, "EventPool");
    private final HashMap<String, LinkedList<c>> aov = new HashMap<>();

    public final boolean a(String str, c cVar) {
        boolean add;
        if (d.apD) {
            d.e(this, "setListener %s", str);
        }
        if (cVar == null) {
            throw new IllegalArgumentException("listener must not be null!");
        }
        LinkedList<c> linkedList = this.aov.get(str);
        if (linkedList == null) {
            synchronized (str.intern()) {
                try {
                    linkedList = this.aov.get(str);
                    if (linkedList == null) {
                        HashMap<String, LinkedList<c>> hashMap = this.aov;
                        LinkedList<c> linkedList2 = new LinkedList<>();
                        hashMap.put(str, linkedList2);
                        linkedList = linkedList2;
                    }
                } finally {
                }
            }
        }
        synchronized (str.intern()) {
            add = linkedList.add(cVar);
        }
        return add;
    }

    public final boolean b(b bVar) {
        if (d.apD) {
            d.e(this, "publish %s", bVar.getId());
        }
        if (bVar == null) {
            throw new IllegalArgumentException("event must not be null!");
        }
        String id = bVar.getId();
        LinkedList<c> linkedList = this.aov.get(id);
        if (linkedList == null) {
            synchronized (id.intern()) {
                try {
                    linkedList = this.aov.get(id);
                    if (linkedList == null) {
                        if (d.apD) {
                            d.c(this, "No listener for this event %s", id);
                        }
                        return false;
                    }
                } finally {
                }
            }
        }
        a(linkedList, bVar);
        return true;
    }

    public final void c(final b bVar) {
        if (d.apD) {
            d.e(this, "asyncPublishInNewThread %s", bVar.getId());
        }
        this.aou.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.event.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.b(bVar);
                } catch (Exception unused) {
                }
            }
        });
    }

    private static void a(LinkedList<c> linkedList, b bVar) {
        for (Object obj : linkedList.toArray()) {
            if (obj != null) {
                ((c) obj).a(bVar);
            }
        }
        Runnable runnable = bVar.aoA;
        if (runnable != null) {
            runnable.run();
        }
    }
}
