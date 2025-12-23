package com.ss.android.socialbase.downloader.g.j;

import com.ss.android.socialbase.downloader.ae.up;
import com.ss.android.socialbase.downloader.g.ae;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes6.dex */
public class cw implements ae {
    private static final ArrayList<String> up;
    private int ae;
    protected List<up> cw;

    /* renamed from: g, reason: collision with root package name */
    private boolean f38803g;

    /* renamed from: j, reason: collision with root package name */
    protected final String f38804j;
    private boolean oq;
    private ae qv;
    private long tl;
    protected final long xt;

    /* renamed from: m, reason: collision with root package name */
    private Map<String, String> f38805m = null;

    /* renamed from: r, reason: collision with root package name */
    protected final Object f38806r = new Object();

    public boolean j(int i6) {
        return i6 >= 200 && i6 < 300;
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>(6);
        up = arrayList;
        arrayList.add("Content-Length");
        arrayList.add("Content-Range");
        arrayList.add("Transfer-Encoding");
        arrayList.add("Accept-Ranges");
        arrayList.add("Etag");
        arrayList.add("Content-Disposition");
    }

    public boolean ae() {
        return this.oq;
    }

    @Override // com.ss.android.socialbase.downloader.g.ae
    public void cw() {
        ae aeVar = this.qv;
        if (aeVar != null) {
            aeVar.cw();
        }
    }

    public Map<String, String> g() {
        return this.f38805m;
    }

    public void j() throws Exception {
        if (this.f38805m != null) {
            return;
        }
        try {
            this.oq = true;
            this.qv = com.ss.android.socialbase.downloader.downloader.cw.j(this.f38804j, this.cw);
            synchronized (this.f38806r) {
                try {
                    if (this.qv != null) {
                        HashMap hashMap = new HashMap();
                        this.f38805m = hashMap;
                        j(this.qv, hashMap);
                        this.ae = this.qv.xt();
                        this.tl = System.currentTimeMillis();
                        this.f38803g = j(this.ae);
                    }
                    this.oq = false;
                    this.f38806r.notifyAll();
                } finally {
                }
            }
        } catch (Throwable th) {
            synchronized (this.f38806r) {
                try {
                    if (this.qv != null) {
                        HashMap hashMap2 = new HashMap();
                        this.f38805m = hashMap2;
                        j(this.qv, hashMap2);
                        this.ae = this.qv.xt();
                        this.tl = System.currentTimeMillis();
                        this.f38803g = j(this.ae);
                    }
                    this.oq = false;
                    this.f38806r.notifyAll();
                    throw th;
                } finally {
                }
            }
        }
    }

    public void r() throws InterruptedException {
        synchronized (this.f38806r) {
            try {
                if (this.oq && this.f38805m == null) {
                    this.f38806r.wait();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public List<up> tl() {
        return this.cw;
    }

    public boolean up() {
        return this.f38803g;
    }

    @Override // com.ss.android.socialbase.downloader.g.ae
    public int xt() throws IOException {
        return this.ae;
    }

    public cw(String str, List<up> list, long j6) {
        this.f38804j = str;
        this.cw = list;
        this.xt = j6;
    }

    public boolean m() {
        if (System.currentTimeMillis() - this.tl < xt.xt) {
            return true;
        }
        return false;
    }

    private void j(ae aeVar, Map<String, String> map) {
        if (aeVar == null || map == null) {
            return;
        }
        Iterator<String> it = up.iterator();
        while (it.hasNext()) {
            String next = it.next();
            map.put(next, aeVar.j(next));
        }
    }

    @Override // com.ss.android.socialbase.downloader.g.ae
    public String j(String str) {
        Map<String, String> map = this.f38805m;
        if (map != null) {
            return map.get(str);
        }
        ae aeVar = this.qv;
        if (aeVar != null) {
            return aeVar.j(str);
        }
        return null;
    }
}
