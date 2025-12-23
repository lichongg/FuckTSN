package com.ss.android.socialbase.downloader.g.j;

import com.bytedance.sdk.component.utils.vl;
import com.ss.android.socialbase.downloader.ae.up;
import com.ss.android.socialbase.downloader.az.m;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes6.dex */
public class j {
    private final Map<String, r> cw;

    /* renamed from: j, reason: collision with root package name */
    protected int f38807j;
    private final Map<String, cw> xt;

    /* renamed from: com.ss.android.socialbase.downloader.g.j.j$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* renamed from: com.ss.android.socialbase.downloader.g.j.j$j, reason: collision with other inner class name */
    private static final class C0783j {

        /* renamed from: j, reason: collision with root package name */
        private static final j f38808j = new j(null);
    }

    /* synthetic */ j(AnonymousClass1 anonymousClass1) {
        this();
    }

    void j(String str, cw cwVar) {
        synchronized (this.xt) {
            this.xt.put(str, cwVar);
        }
    }

    private j() {
        this.xt = new HashMap();
        this.cw = new LinkedHashMap(3);
        this.f38807j = 3;
    }

    public r xt(String str, List<up> list) {
        r remove;
        synchronized (this.cw) {
            remove = this.cw.remove(str);
        }
        if (remove == null) {
            return null;
        }
        if (m.j(remove.m(), list)) {
            try {
                remove.up();
            } catch (InterruptedException e6) {
                vl.j(e6);
            }
            if (remove.tl() && remove.ae()) {
                return remove;
            }
        }
        try {
            remove.r();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    void j(int i6) {
        this.f38807j = i6;
    }

    public cw j(String str, List<up> list) {
        cw remove;
        synchronized (this.xt) {
            remove = this.xt.remove(str);
        }
        if (remove == null) {
            return null;
        }
        if (m.j(remove.tl(), list)) {
            try {
                remove.r();
            } catch (InterruptedException e6) {
                vl.j(e6);
            }
            if (remove.m() && remove.up()) {
                return remove;
            }
        }
        try {
            remove.cw();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean j(String str) {
        cw cwVar = this.xt.get(str);
        if (cwVar != null) {
            if (cwVar.ae()) {
                return true;
            }
            if (cwVar.m() && cwVar.up()) {
                return true;
            }
        }
        return false;
    }

    public static j j() {
        return C0783j.f38808j;
    }
}
