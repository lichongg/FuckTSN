package com.ss.android.downloadlib.addownload.compliance;

import com.ss.android.downloadlib.addownload.o;
import com.ss.android.socialbase.downloader.az.tl;

/* loaded from: D:\Downloads\app\classes6.dex */
public class cw extends tl<Long, o.j> {

    static /* synthetic */ class a {
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static cw f37676a = new cw(null);
    }

    /* synthetic */ cw(a aVar) {
        this();
    }

    public static cw j() {
        return b.f37676a;
    }

    private cw() {
        super(16, 16);
    }

    public void j(o.j jVar) {
        if (jVar == null) {
            return;
        }
        put(Long.valueOf(jVar.a()), jVar);
    }

    public o.j j(long j6, long j7) {
        return get(get(Long.valueOf(j6)) != null ? Long.valueOf(j6) : Long.valueOf(j7));
    }

    public o.j j(long j6) {
        return get(Long.valueOf(j6));
    }
}
