package com.bytedance.msdk.core.xt;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.msdk.tl.l;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static final l f24825j = l.j("tt_user_live_day_time", com.bytedance.msdk.core.xt.getContext());
    private static final SimpleDateFormat xt = new SimpleDateFormat("yyyy-MM-dd");
    private static final Calendar cw = Calendar.getInstance();

    public static void ae(String str) {
        if (!com.bytedance.msdk.core.xt.xt().ed() || str == null) {
            return;
        }
        String xt2 = xt(str, "_show_current_time_");
        String xt3 = xt(str, "_show_last_time_");
        l lVar = f24825j;
        String xt4 = lVar.xt("_show_gap_time_day");
        String ae = ae();
        com.bytedance.msdk.j.up.cw.xt("AdLoadDynamicParamHandler", "recordSameDayTwoAdIntervalTime curKey:" + xt2 + ",lastKey :" + xt3 + ",today:" + ae + ",recordDate:" + xt4);
        if (TextUtils.equals(xt4, ae)) {
            lVar.j(xt3, lVar.r(xt2));
            lVar.j(xt2, System.currentTimeMillis());
        } else {
            lVar.j(xt3, 0L);
            lVar.j(xt2, System.currentTimeMillis());
            lVar.j("_show_gap_time_day", ae);
        }
    }

    public static void cw(String str) {
        if (!com.bytedance.msdk.core.xt.xt().ed() || str == null) {
            return;
        }
        j(str, "_show_count_");
    }

    private static int g(String str) {
        String str2;
        if (str == null) {
            return 0;
        }
        String[] split = str.split("_");
        if (split.length != 2 || (str2 = split[1]) == null) {
            return 0;
        }
        return Integer.parseInt(str2);
    }

    public static void j() {
        com.bytedance.msdk.j.up.cw.xt("AdLoadDynamicParamHandler", "recordUserLiveDay start => enableDynamicPolicy:" + com.bytedance.msdk.core.xt.xt().ed());
        if (com.bytedance.msdk.core.xt.xt().ed()) {
            long currentTimeMillis = System.currentTimeMillis();
            String ae = ae();
            com.bytedance.msdk.j.up.cw.xt("AdLoadDynamicParamHandler", "当前日期(key)：".concat(String.valueOf(ae)));
            l lVar = f24825j;
            if (lVar.up(ae)) {
                com.bytedance.msdk.j.up.cw.xt("AdLoadDynamicParamHandler", "key=" + ae + "，同一天，不再重新记录");
                return;
            }
            if (TextUtils.isEmpty(lVar.xt("start_index"))) {
                lVar.j("start_index", ae);
                com.bytedance.msdk.j.up.cw.xt("AdLoadDynamicParamHandler", "START_INDEX=".concat(String.valueOf(ae)));
            }
            lVar.j(ae, true);
            lVar.j("user_live_times", lVar.xt("user_live_times", 0) + 1);
            String xt2 = lVar.xt("start_index");
            if (TextUtils.equals(xt2, ae)) {
                com.bytedance.msdk.j.up.cw.xt("AdLoadDynamicParamHandler", "startDay:" + xt2 + ",key=" + ae + "，同一天，不处理");
            } else {
                try {
                    SimpleDateFormat simpleDateFormat = xt;
                    Date parse = simpleDateFormat.parse(xt2);
                    Date parse2 = simpleDateFormat.parse(ae);
                    if (parse2 == null) {
                        parse2 = new Date();
                    }
                    if (parse != null) {
                        int j6 = j(parse.getTime(), parse2.getTime());
                        int e6 = com.bytedance.msdk.core.xt.xt().e();
                        if (e6 - j6 < 0) {
                            int i6 = j6 - e6;
                            String j7 = j(parse, i6);
                            if (!TextUtils.isEmpty(j7)) {
                                lVar.j("start_index", j7);
                                j(xt2, parse, i6);
                            }
                            com.bytedance.msdk.j.up.cw.xt("AdLoadDynamicParamHandler", "old-startIndex:" + xt2 + ",diff=" + i6 + ",new-startIndex:" + j7);
                        }
                    }
                } catch (ParseException e7) {
                    com.bytedance.msdk.j.up.cw.r("AdLoadDynamicParamHandler", "计算生成日期出错：" + e7.getMessage());
                }
            }
            com.bytedance.msdk.j.up.cw.xt("AdLoadDynamicParamHandler", "recordUserLiveDay方法，执行耗时：" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }

    public static int m(String str) {
        if (!com.bytedance.msdk.core.xt.xt().ed() || str == null) {
            return -1;
        }
        return g(f24825j.xt(xt(str, "_click_count_")));
    }

    public static int r(String str) {
        if (!com.bytedance.msdk.core.xt.xt().ed() || str == null) {
            return -1;
        }
        return g(f24825j.xt(xt(str, "_show_count_")));
    }

    public static void up(String str) {
        if (!com.bytedance.msdk.core.xt.xt().ed() || str == null) {
            return;
        }
        j(str, "_click_count_");
    }

    public static int xt() {
        if (com.bytedance.msdk.core.xt.xt().ed()) {
            return f24825j.xt("user_live_times", 0);
        }
        return -1;
    }

    public static void cw() {
        com.bytedance.msdk.j.up.cw.xt("AdLoadDynamicParamHandler", "recordSameDaySdkStartTimes start => enableDynamicPolicy:" + com.bytedance.msdk.core.xt.xt().ed());
        if (com.bytedance.msdk.core.xt.xt().ed()) {
            j((String) null, "tt_sdk_start_count_");
        }
    }

    public static long tl(String str) {
        if (com.bytedance.msdk.core.xt.xt().ed() && str != null) {
            String xt2 = xt(str, "_show_current_time_");
            String xt3 = xt(str, "_show_last_time_");
            l lVar = f24825j;
            if (!TextUtils.equals(lVar.xt("_show_gap_time_day"), ae())) {
                return 0L;
            }
            if (lVar.r(xt3) == 0) {
                return 0L;
            }
            return Math.round((lVar.r(xt2) - r5) / 1000);
        }
        return -1L;
    }

    public static int up() {
        if (com.bytedance.msdk.core.xt.xt().ed()) {
            return j(com.bytedance.msdk.core.j.qv().cw(), System.currentTimeMillis());
        }
        return -1;
    }

    public static int xt(String str) {
        if (!com.bytedance.msdk.core.xt.xt().ed() || str == null) {
            return -1;
        }
        return g(f24825j.xt(xt(str, "_dislike_count_")));
    }

    public static long m() {
        if (!com.bytedance.msdk.core.xt.xt().ed()) {
            return -1L;
        }
        float up = com.bytedance.msdk.core.j.qv().up() / 60000.0f;
        if (up <= 0.0f || up >= 1.0f) {
            return Math.round(up);
        }
        return 1L;
    }

    public static int r() {
        if (com.bytedance.msdk.core.xt.xt().ed()) {
            return g(f24825j.xt("tt_sdk_start_count_"));
        }
        return -1;
    }

    private static String xt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return str + str2;
    }

    private static String ae() {
        return xt.format(new Date());
    }

    private static void j(String str, Date date, int i6) {
        if (i6 == 1) {
            l lVar = f24825j;
            if (lVar.up(str)) {
                lVar.j("user_live_times", Math.max(lVar.cw("user_live_times") - 1, 0));
            }
            lVar.m(str);
            return;
        }
        int i7 = 0;
        while (i7 < i6) {
            i7++;
            String j6 = j(date, i7);
            l lVar2 = f24825j;
            if (lVar2.up(j6)) {
                lVar2.j("user_live_times", Math.max(lVar2.cw("user_live_times") - 1, 0));
            }
            lVar2.m(j6);
        }
    }

    public static void j(String str) {
        if (!com.bytedance.msdk.core.xt.xt().ed() || str == null) {
            return;
        }
        j(str, "_dislike_count_");
    }

    private static void j(String str, String str2) {
        String xt2 = xt(str, str2);
        String ae = ae();
        l lVar = f24825j;
        String xt3 = lVar.xt(xt2);
        com.bytedance.msdk.j.up.cw.xt("AdLoadDynamicParamHandler", "saveToSpByAction key:" + xt2 + ",old value:" + xt3);
        int i6 = 1;
        if (!TextUtils.isEmpty(xt3)) {
            String[] split = xt3.split("_");
            if (split.length == 2) {
                String str3 = split[0];
                if (!TextUtils.isEmpty(str3) && TextUtils.equals(ae, str3)) {
                    i6 = 1 + Integer.parseInt(split[1]);
                    ae = str3;
                }
                xt3 = j(ae, i6);
            }
            com.bytedance.msdk.j.up.cw.xt("AdLoadDynamicParamHandler", "saveToSpByAction key:" + xt2 + "，new value：" + xt3);
            lVar.j(xt2, xt3);
            return;
        }
        lVar.j(xt2, j(ae, 1));
        com.bytedance.msdk.j.up.cw.xt("AdLoadDynamicParamHandler", "saveToSpByAction 首次记录 key:" + xt2 + "，new value：" + j(ae, 1));
    }

    private static String j(String str, int i6) {
        return str + "_" + i6;
    }

    private static int j(long j6, long j7) {
        Instant ofEpochMilli;
        ZoneId systemDefault;
        ZonedDateTime atZone;
        LocalDate localDate;
        Instant ofEpochMilli2;
        ZoneId systemDefault2;
        ZonedDateTime atZone2;
        LocalDate localDate2;
        Period between;
        int days;
        if (Build.VERSION.SDK_INT >= 26) {
            ofEpochMilli = Instant.ofEpochMilli(j6);
            systemDefault = ZoneOffset.systemDefault();
            atZone = ofEpochMilli.atZone(systemDefault);
            localDate = atZone.toLocalDate();
            ofEpochMilli2 = Instant.ofEpochMilli(j7);
            systemDefault2 = ZoneOffset.systemDefault();
            atZone2 = ofEpochMilli2.atZone(systemDefault2);
            localDate2 = atZone2.toLocalDate();
            between = Period.between(localDate, localDate2);
            days = between.getDays();
            return days;
        }
        return (int) ((j7 - j6) / 86400000);
    }

    private static String j(Date date, int i6) {
        if (date == null) {
            return null;
        }
        Calendar calendar = cw;
        calendar.setTime(date);
        calendar.add(5, i6);
        return xt.format(calendar.getTime());
    }

    public static void j(List<com.bytedance.msdk.xt.cw> list, com.bytedance.msdk.core.oq.xt xtVar) {
        if (!com.bytedance.msdk.core.xt.xt().ed() || list == null || xtVar == null) {
            return;
        }
        for (com.bytedance.msdk.xt.cw cwVar : list) {
            if (cwVar != null) {
                cwVar.p().put(MediationConstant.KEY_GM_PRIME_RIT, xtVar.rn());
            }
        }
    }
}
