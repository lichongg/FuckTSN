package xyz.adscope.common.v2.tool.date;

import java.util.Calendar;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class DateUtil {
    private static final long DAY_1_MILLISECOND = 86400000;

    public static boolean timestampIsInDay(long j6, int i6) {
        return System.currentTimeMillis() - j6 < ((long) i6) * 86400000;
    }

    public static long getTimeMillisBeforeDay(int i6) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.add(5, -i6);
            return calendar.getTimeInMillis();
        } catch (Exception e6) {
            SDKLog.stack(e6);
            return 0L;
        }
    }
}
