package com.ss.android.socialbase.downloader.qv;

import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: D:\Downloads\app\classes6.dex */
public class az {
    public static long j(@NonNull List<g> list) {
        int size = list.size();
        long j6 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            g gVar = list.get(i6);
            if (gVar.cw() > j6) {
                break;
            }
            if (gVar.up() > j6) {
                j6 = gVar.up();
            }
        }
        return j6;
    }

    public static long xt(@NonNull List<g> list) {
        long j6;
        long j7;
        long j8 = 0;
        loop0: while (true) {
            j6 = -1;
            j7 = -1;
            for (g gVar : list) {
                if (j6 == -1) {
                    if (gVar.j() > 0) {
                        j6 = gVar.cw();
                        j7 = gVar.r();
                    }
                } else if (gVar.cw() <= j7) {
                    if (gVar.r() > j7) {
                        j7 = gVar.r();
                    }
                } else {
                    j8 += j7 - j6;
                    if (gVar.j() > 0) {
                        j6 = gVar.cw();
                        j7 = gVar.r();
                    }
                }
            }
        }
        if (j6 >= 0 && j7 > j6) {
            return j8 + (j7 - j6);
        }
        return j8;
    }
}
