package com.ss.android.socialbase.downloader.az;

/* loaded from: D:\Downloads\app\classes6.dex */
public class up {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private j f38686j;

    /* renamed from: r, reason: collision with root package name */
    private int f38687r = 10;
    private j xt;

    /* renamed from: com.ss.android.socialbase.downloader.az.up$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class j {
        j cw;

        /* renamed from: j, reason: collision with root package name */
        long f38688j;

        /* renamed from: r, reason: collision with root package name */
        j f38689r;
        long xt;

        private j() {
        }

        /* synthetic */ j(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public boolean j(long j6, long j7) {
        synchronized (this) {
            try {
                j jVar = this.f38686j;
                if (jVar != null) {
                    if (j6 >= jVar.f38688j && j7 >= jVar.xt) {
                        j jVar2 = jVar.cw;
                        if (jVar2 != null && j7 - jVar2.xt < 1000) {
                            jVar.f38688j = j6;
                            jVar.xt = j7;
                            return true;
                        }
                    }
                    return false;
                }
                j j8 = j();
                j8.f38688j = j6;
                j8.xt = j7;
                if (jVar != null) {
                    j8.cw = jVar;
                    jVar.f38689r = j8;
                }
                this.f38686j = j8;
                return true;
            } finally {
            }
        }
    }

    public long xt(long j6, long j7) {
        synchronized (this) {
            try {
                j jVar = this.f38686j;
                if (jVar == null) {
                    return -1L;
                }
                j j8 = j(j6);
                if (j8 == null) {
                    return -1L;
                }
                long j9 = jVar.f38688j - j8.f38688j;
                long j10 = j7 - j8.xt;
                if (j9 < 0 || j10 <= 0) {
                    return -1L;
                }
                return j9 / j10;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private j j() {
        j jVar;
        int i6 = this.cw;
        AnonymousClass1 anonymousClass1 = null;
        if (i6 >= this.f38687r && (jVar = this.xt) != null) {
            j jVar2 = jVar.f38689r;
            jVar.f38689r = null;
            this.xt = jVar2;
            if (jVar2 != null) {
                jVar2.cw = null;
            }
            return jVar;
        }
        this.cw = i6 + 1;
        return new j(anonymousClass1);
    }

    private j j(long j6) {
        j jVar = this.f38686j;
        j jVar2 = null;
        while (jVar != null && jVar.xt > j6) {
            jVar2 = jVar;
            jVar = jVar.cw;
        }
        return (jVar == null || jVar2 == null || jVar == jVar2 || j6 - jVar.xt >= jVar2.xt - j6) ? jVar2 : jVar;
    }
}
