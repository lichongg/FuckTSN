package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.r.a;
import com.ss.android.socialbase.downloader.r.h;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: D:\Downloads\app\classes6.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private String f38795j;
    private String xt;

    public static com.ss.android.socialbase.downloader.ae.r j(Context context) {
        ae.xt(context);
        return new com.ss.android.socialbase.downloader.ae.r();
    }

    public void cw(int i6) {
        r.j().m(i6);
    }

    public boolean r(int i6) {
        return r.j().up(i6);
    }

    public void up(int i6) {
        r.j().ae(i6);
    }

    public void xt(int i6) {
        j(i6, true);
    }

    public boolean ae(int i6) {
        boolean g6;
        if (!com.ss.android.socialbase.downloader.az.j.j(4194304)) {
            return r.j().g(i6);
        }
        synchronized (this) {
            g6 = r.j().g(i6);
        }
        return g6;
    }

    public List<com.ss.android.socialbase.downloader.ae.cw> cw(String str) {
        return r.j().cw(str);
    }

    public List<com.ss.android.socialbase.downloader.ae.cw> r(String str) {
        return r.j().r(str);
    }

    public void up(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f38795j = str;
    }

    public void xt(List<String> list) {
        r.j().xt(list);
    }

    xt() {
    }

    public File cw() {
        return j(this.f38795j, true);
    }

    public h g(int i6) {
        return r.j().qv(i6);
    }

    public void j(int i6) {
        r.j().r(i6);
    }

    public boolean jy(int i6) {
        return r.j().cw(i6).xt();
    }

    public int m(int i6) {
        return r.j().tl(i6);
    }

    public void oq(int i6) {
        r.j().r(i6, true);
    }

    @Deprecated
    public void qv(int i6) {
        r.j().j(i6, null, com.ss.android.socialbase.downloader.xt.tl.MAIN, true);
    }

    public File r() {
        return j(this.xt, false);
    }

    public com.ss.android.socialbase.downloader.ae.cw tl(int i6) {
        return r.j().oq(i6);
    }

    public com.ss.android.socialbase.downloader.r.tj vl(int i6) {
        return r.j().az(i6);
    }

    public com.ss.android.socialbase.downloader.ae.cw xt(String str, String str2) {
        return r.j().xt(str, str2);
    }

    public int j(String str, String str2) {
        return r.j().j(str, str2);
    }

    public List<com.ss.android.socialbase.downloader.ae.cw> xt(String str) {
        return r.j().xt(str);
    }

    public List<com.ss.android.socialbase.downloader.ae.cw> j(String str) {
        return r.j().j(str);
    }

    public mi xt() {
        return cw.hh();
    }

    public void j(int i6, boolean z5) {
        r.j().cw(i6, z5);
    }

    public void j() {
        r.j().cw();
    }

    public void j(List<String> list) {
        r.j().j(list);
    }

    @Deprecated
    public void j(int i6, a aVar) {
        if (aVar == null) {
            return;
        }
        r.j().xt(i6, aVar, com.ss.android.socialbase.downloader.xt.tl.MAIN, true);
    }

    @Deprecated
    public void j(int i6, a aVar, boolean z5) {
        if (aVar == null) {
            return;
        }
        r.j().j(i6, aVar, com.ss.android.socialbase.downloader.xt.tl.MAIN, true, z5);
    }

    public boolean j(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        return r.j().j(cwVar);
    }

    public void j(com.ss.android.socialbase.downloader.r.vl vlVar) {
        r.j().j(vlVar);
    }

    public void j(mi miVar) {
        cw.j(miVar);
    }

    private File j(String str, boolean z5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File file = new File(str);
            try {
                if (!file.exists()) {
                    file.mkdirs();
                    return file;
                }
                if (file.isDirectory()) {
                    return file;
                }
                if (!z5) {
                    return null;
                }
                file.delete();
                file.mkdirs();
                return file;
            } catch (Throwable unused) {
                return file;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }
}
