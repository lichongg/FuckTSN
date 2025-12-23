package xyz.adscope.common.v2.dev.info;

import android.os.Build;
import android.system.Os;
import android.system.StructStat;
import android.system.StructTimespec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class DevSysMark {
    public String getSysUpdateMark() {
        StructTimespec structTimespec;
        long j6;
        long j7;
        try {
            int i6 = Build.VERSION.SDK_INT;
            StructStat stat = Os.stat("/data/data");
            if (stat == null) {
                return "";
            }
            if (i6 < 27) {
                return stat.st_atime + ".0";
            }
            structTimespec = stat.st_atim;
            StringBuilder sb = new StringBuilder();
            j6 = structTimespec.tv_sec;
            sb.append(j6);
            sb.append(".");
            j7 = structTimespec.tv_nsec;
            sb.append(j7);
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
