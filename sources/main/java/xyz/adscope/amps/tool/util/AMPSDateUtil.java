package xyz.adscope.amps.tool.util;

import java.util.Calendar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSDateUtil {
    public static long getTimeMillisBeforeDay(int i6) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.add(5, -i6);
            return calendar.getTimeInMillis();
        } catch (Exception e6) {
            e6.printStackTrace();
            return 0L;
        }
    }
}
