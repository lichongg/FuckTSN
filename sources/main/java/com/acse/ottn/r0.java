package com.acse.ottn;

import java.io.ObjectStreamException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class r0 {

    /* renamed from: a, reason: collision with root package name */
    public static r0 f5029a;

    public static r0 d() {
        if (f5029a == null) {
            synchronized (r0.class) {
                try {
                    if (f5029a == null) {
                        f5029a = new r0();
                    }
                } finally {
                }
            }
        }
        return f5029a;
    }

    public String a() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
    }

    public int b() {
        return Integer.parseInt(new SimpleDateFormat("HHmm", Locale.CHINA).format(new Date(System.currentTimeMillis())));
    }

    public long c(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).parse(str).getTime();
        } catch (ParseException e6) {
            e6.printStackTrace();
            return 0L;
        }
    }

    public final Object e() throws ObjectStreamException {
        return f5029a;
    }

    public static String[] g(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        Long.valueOf(str).getClass();
        return simpleDateFormat.format(new Date(Integer.parseInt(str) * 1000)).split("[年月日时分秒]");
    }

    public static String i(String str) {
        return new SimpleDateFormat("yyyy年MM月dd日").format(new Date(Long.valueOf(str).longValue()));
    }

    public String e(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        Long.valueOf(str).getClass();
        return simpleDateFormat.format(new Date(Integer.parseInt(str) * 1000));
    }

    public String f(String str) {
        return new SimpleDateFormat("HH-mm-ss").format(new Date(Long.valueOf(str).longValue()));
    }

    public String h(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
        Long.valueOf(str).getClass();
        return simpleDateFormat.format(new Date(Integer.parseInt(str) * 1000));
    }

    public String j(String str) {
        int i6;
        try {
            Date parse = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒").parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            i6 = calendar.get(7);
        } catch (ParseException e6) {
            e6.printStackTrace();
            i6 = 0;
        }
        if (i6 == 1) {
            return "星期日";
        }
        if (i6 == 2) {
            return "星期一";
        }
        if (i6 == 3) {
            return "星期二";
        }
        if (i6 == 4) {
            return "星期三";
        }
        if (i6 == 5) {
            return "星期四";
        }
        if (i6 == 6) {
            return "星期五";
        }
        if (i6 == 7) {
            return "星期六";
        }
        return null;
    }

    public String k(String str) {
        int i6;
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            i6 = calendar.get(7);
        } catch (ParseException e6) {
            e6.printStackTrace();
            i6 = 0;
        }
        if (i6 == 1) {
            return "星期日";
        }
        if (i6 == 2) {
            return "星期一";
        }
        if (i6 == 3) {
            return "星期二";
        }
        if (i6 == 4) {
            return "星期三";
        }
        if (i6 == 5) {
            return "星期四";
        }
        if (i6 == 6) {
            return "星期五";
        }
        if (i6 == 7) {
            return "星期六";
        }
        return null;
    }

    public static String a(long j6) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j6));
        int i6 = calendar.get(7);
        if (i6 == 1) {
            return "周日";
        }
        if (i6 == 2) {
            return "周一";
        }
        if (i6 == 3) {
            return "周二";
        }
        if (i6 == 4) {
            return "周三";
        }
        if (i6 == 5) {
            return "周四";
        }
        if (i6 == 6) {
            return "周五";
        }
        if (i6 == 7) {
            return "周六";
        }
        return null;
    }

    public String b(long j6) {
        return new SimpleDateFormat("MM月dd日  #  HH:mm").format(new Date(j6)).replaceAll("#", a(j6));
    }

    public static String c(String str, String str2) {
        try {
            return String.valueOf(new SimpleDateFormat(str2, Locale.CHINA).parse(str).getTime()).substring(0, 10);
        } catch (ParseException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public String[] d(String str) {
        return str.split("[年月日时分秒]");
    }

    public static String b(String str, String str2) {
        return new SimpleDateFormat(str2).format(new Date(Long.valueOf(str).longValue()));
    }

    public static String b(String str) {
        int i6;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Long.valueOf(str).getClass();
        try {
            Date parse = simpleDateFormat.parse(simpleDateFormat.format(new Date(Integer.parseInt(str) * 1000)));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            i6 = calendar.get(7);
        } catch (ParseException e6) {
            e6.printStackTrace();
            i6 = 0;
        }
        if (i6 == 1) {
            return "星期日";
        }
        if (i6 == 2) {
            return "星期一";
        }
        if (i6 == 3) {
            return "星期二";
        }
        if (i6 == 4) {
            return "星期三";
        }
        if (i6 == 5) {
            return "星期四";
        }
        if (i6 == 6) {
            return "星期五";
        }
        if (i6 == 7) {
            return "星期六";
        }
        return null;
    }

    public static String c() {
        return new SimpleDateFormat("yyyy年MM月dd日  HH时mm分").format(new Date());
    }

    public static String a(String str) {
        int i6;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        Long.valueOf(str).getClass();
        try {
            Date parse = simpleDateFormat.parse(simpleDateFormat.format(new Date(Integer.parseInt(str) * 1000)));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            i6 = calendar.get(7);
        } catch (ParseException e6) {
            e6.printStackTrace();
            i6 = 0;
        }
        if (i6 == 1) {
            return "星期日";
        }
        if (i6 == 2) {
            return "星期一";
        }
        if (i6 == 3) {
            return "星期二";
        }
        if (i6 == 4) {
            return "星期三";
        }
        if (i6 == 5) {
            return "星期四";
        }
        if (i6 == 6) {
            return "星期五";
        }
        if (i6 == 7) {
            return "星期六";
        }
        return null;
    }

    public static String a(String str, String str2) {
        return b(str + "000", str2) + "  " + b(str);
    }
}
