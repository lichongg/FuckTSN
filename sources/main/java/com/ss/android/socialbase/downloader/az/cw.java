package com.ss.android.socialbase.downloader.az;

import android.util.SparseArray;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.socialbase.downloader.r.a;
import com.ss.android.socialbase.downloader.r.kt;

/* loaded from: D:\Downloads\app\classes6.dex */
public class cw {
    public static void j(int i6, SparseArray<a> sparseArray, boolean z5, com.ss.android.socialbase.downloader.ae.cw cwVar, com.ss.android.socialbase.downloader.up.j jVar) {
        SparseArray<a> clone;
        if (!z5 || sparseArray == null) {
            return;
        }
        try {
            if (sparseArray.size() <= 0) {
                return;
            }
            synchronized (sparseArray) {
                clone = sparseArray.clone();
            }
            for (int i7 = 0; i7 < clone.size(); i7++) {
                a aVar = clone.get(clone.keyAt(i7));
                if (aVar != null) {
                    if (i6 == 1) {
                        aVar.j(cwVar);
                    } else if (i6 == 2) {
                        aVar.xt(cwVar);
                    } else if (i6 == 4) {
                        aVar.cw(cwVar);
                    } else if (i6 == 5) {
                        aVar.xt(cwVar, jVar);
                    } else if (i6 == 6) {
                        aVar.tl(cwVar);
                    } else if (i6 == 7) {
                        aVar.cw(cwVar, jVar);
                    } else if (i6 != 11) {
                        switch (i6) {
                            case -7:
                                if (aVar instanceof com.ss.android.socialbase.downloader.r.cw) {
                                    ((com.ss.android.socialbase.downloader.r.cw) aVar).oq(cwVar);
                                    break;
                                } else {
                                    break;
                                }
                            case -6:
                                aVar.g(cwVar);
                                break;
                            case -5:
                            case -2:
                                aVar.r(cwVar);
                                break;
                            case -4:
                                aVar.m(cwVar);
                                break;
                            case -3:
                                aVar.up(cwVar);
                                break;
                            case -1:
                                aVar.j(cwVar, jVar);
                                break;
                        }
                    } else if (aVar instanceof kt) {
                        ((kt) aVar).ae(cwVar);
                    }
                }
            }
        } catch (Throwable th) {
            vl.j(th);
        }
    }
}
