package com.ss.android.downloadlib.addownload;

/* loaded from: D:\Downloads\app\classes6.dex */
public class h {
    public static int a(int i6, int i7) {
        return (i7 <= 0 || i7 >= 100 || !d(i6)) ? i7 : (int) (Math.sqrt(i7) * 10.0d);
    }

    public static com.ss.android.j.j.up.e c(com.ss.android.j.j.up.e eVar) {
        if (eVar != null && d((int) eVar.f38314a)) {
            eVar.f38317d = b((int) eVar.f38314a, eVar.f38317d, eVar.f38316c);
        }
        return eVar;
    }

    public static long b(int i6, long j6, long j7) {
        if (d(i6)) {
            if (j6 <= 0) {
                return 0L;
            }
            if (j7 > 0) {
                return (j7 * a(i6, (int) ((j6 * 100) / j7))) / 100;
            }
        }
        return j6;
    }

    private static boolean d(int i6) {
        if (com.ss.android.socialbase.downloader.jy.j.j(i6).j("pause_optimise_pretend_download_percent_switch", 0) != 1 || com.ss.android.socialbase.downloader.jy.j.j(i6).j("pause_optimise_switch", 0) != 1) {
            return false;
        }
        return true;
    }
}
