package com.ss.android.socialbase.downloader.impls;

/* loaded from: D:\Downloads\app\classes6.dex */
public class xt implements com.ss.android.socialbase.downloader.downloader.g {
    @Override // com.ss.android.socialbase.downloader.downloader.g
    public int j(int i6, com.ss.android.socialbase.downloader.g.jy jyVar) {
        if (jyVar.ordinal() <= com.ss.android.socialbase.downloader.g.jy.MODERATE.ordinal()) {
            return 1;
        }
        if (jyVar == com.ss.android.socialbase.downloader.g.jy.GOOD) {
            return i6 - 1;
        }
        return i6;
    }
}
