package com.kwad.components.core.webview.tachikoma.e;

import com.kwad.components.core.webview.tachikoma.f.f;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    private final Set<Integer> ahN = new HashSet();
    private final ConcurrentHashMap<Integer, Set<f>> ahO = new ConcurrentHashMap<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static final b ahP = new b();
    }

    public final void a(int i6, f fVar) {
        Set<f> set = this.ahO.get(Integer.valueOf(i6));
        if (set != null) {
            set.add(fVar);
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(fVar);
        this.ahO.put(Integer.valueOf(i6), hashSet);
    }

    private void bo(int i6) {
        Set<f> set;
        this.ahN.remove(Integer.valueOf(i6));
        if (this.ahO.isEmpty() || this.ahO.get(Integer.valueOf(i6)) == null || (set = this.ahO.get(Integer.valueOf(i6))) == null || set.isEmpty()) {
            return;
        }
        Iterator<f> it = set.iterator();
        while (it.hasNext()) {
            it.next().vx();
        }
        this.ahO.remove(Integer.valueOf(i6));
    }

    public final boolean bn(int i6) {
        if (this.ahN.contains(Integer.valueOf(i6))) {
            return false;
        }
        this.ahN.add(Integer.valueOf(i6));
        return true;
    }

    public static b vM() {
        return a.ahP;
    }

    public final void b(int i6, String str, String str2) {
        a(i6, str, str2);
    }

    public final void bp(int i6) {
        bo(i6);
    }

    private void a(int i6, String str, String str2) {
        Set<f> set;
        this.ahN.remove(Integer.valueOf(i6));
        if (this.ahO.isEmpty() || this.ahO.get(Integer.valueOf(i6)) == null || (set = this.ahO.get(Integer.valueOf(i6))) == null || set.isEmpty()) {
            return;
        }
        this.ahO.remove(Integer.valueOf(i6));
        Iterator<f> it = set.iterator();
        while (it.hasNext()) {
            it.next().vw();
        }
    }
}
