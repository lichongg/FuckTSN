package com.bxkj.student.run.app.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.amap.api.location.AMapLocation;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.baidu.mobads.sdk.internal.cm;
import com.bxkj.student.R;
import com.bxkj.student.run.app.ready.RunType;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static SimpleDateFormat f20226a;

    /* renamed from: b, reason: collision with root package name */
    private static List<LatLng> f20227b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private static LatLng f20228c = new LatLng(0.0d, 0.0d);

    public static String j(int statusCode, int gpsAccuracyStatus) {
        return statusCode != 0 ? statusCode != 1 ? statusCode != 2 ? statusCode != 3 ? statusCode != 4 ? "GPS状态未知" : "没有GPS定位权限，建议开启gps定位权限" : "选择的定位模式中不包含GPS定位，建议选择包含GPS定位的模式，提高定位质量" : "GPS关闭，建议开启GPS，提高定位质量" : "手机中没有GPS Provider，无法进行GPS定位" : gpsAccuracyStatus != -1 ? gpsAccuracyStatus != 0 ? gpsAccuracyStatus != 1 ? "GPS状态正常" : "GPS信号良好，请尽情跑步" : "GPS信号弱，请在空旷的地方跑步" : "GPS信号未知，正在搜寻···";
    }

    public static String n(int gpsQualityReportStatusCode, int gpsAccuracyStatus) {
        return gpsQualityReportStatusCode != 0 ? gpsQualityReportStatusCode != 1 ? gpsQualityReportStatusCode != 2 ? gpsQualityReportStatusCode != 3 ? gpsQualityReportStatusCode != 4 ? "" : "没有GPS定位权限，建议开启gps定位权限" : "选择的定位模式中不包含GPS定位，建议选择包含GPS定位的模式，提高定位质量" : "GPS关闭，建议开启GPS，提高定位质量" : "手机中没有GPS Provider，无法进行GPS定位" : gpsAccuracyStatus != -1 ? gpsAccuracyStatus != 0 ? gpsAccuracyStatus != 1 ? "GPS状态正常" : "GPS信号良好，请尽情跑步" : "GPS信号弱，请在空旷的地方跑步" : "GPS信号未知，正在搜寻···";
    }

    public static String q(@RunType int runType) {
        return runType == 1 ? "早操跑步" : runType == 2 ? "阳光跑步" : runType == 3 ? "自由跑步" : runType == 4 ? "健康跑步" : runType == 0 ? "室内跑步" : "跑步";
    }

    public static int u(int statusCode, int sportType) {
        return sportType == 2 ? statusCode != 0 ? statusCode != 1 ? R.mipmap.v3_gps_unknow : R.mipmap.v3_gps_good1 : R.mipmap.v3_gps_bad1 : sportType == 0 ? statusCode != 0 ? statusCode != 1 ? R.mipmap.v3_gps_unknow : R.mipmap.v3_gps_good3 : R.mipmap.v3_gps_bad3 : statusCode != 0 ? statusCode != 1 ? R.mipmap.v3_gps_unknow : R.mipmap.v3_gps_good2 : R.mipmap.v3_gps_bad2;
    }

    public static double e(double distance) {
        return new BigDecimal(distance).divide(new BigDecimal(1000), 2, RoundingMode.FLOOR).doubleValue();
    }

    private static String f(int peiSuSecond) {
        StringBuilder sb;
        String str;
        int i6 = peiSuSecond % 3600;
        int i7 = i6 / 60;
        if (i7 > 9) {
            sb = new StringBuilder();
            sb.append(i7);
            sb.append("");
        } else {
            sb = new StringBuilder();
            sb.append("0");
            sb.append(i7);
        }
        String sb2 = sb.toString();
        int i8 = i6 % 60;
        if (i8 > 9) {
            str = i8 + "";
        } else {
            str = "0" + i8;
        }
        return sb2 + "'" + str + "\"";
    }

    public static String g(long recordingTime) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        long j6 = recordingTime / 3600;
        if (j6 > 9) {
            sb = new StringBuilder();
            sb.append(j6);
            sb.append("");
        } else {
            sb = new StringBuilder();
            sb.append("0");
            sb.append(j6);
        }
        String sb4 = sb.toString();
        long j7 = recordingTime % 3600;
        long j8 = j7 / 60;
        if (j8 > 9) {
            sb2 = new StringBuilder();
            sb2.append(j8);
            sb2.append("");
        } else {
            sb2 = new StringBuilder();
            sb2.append("0");
            sb2.append(j8);
        }
        String sb5 = sb2.toString();
        long j9 = j7 % 60;
        if (j9 > 9) {
            sb3 = new StringBuilder();
            sb3.append(j9);
            sb3.append("");
        } else {
            sb3 = new StringBuilder();
            sb3.append("0");
            sb3.append(j9);
        }
        return sb4 + ":" + sb5 + ":" + sb3.toString();
    }

    public static String i(long l6) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM", Locale.CHINA);
        f20226a = simpleDateFormat;
        return simpleDateFormat.format(Long.valueOf(l6));
    }

    public static int k(int statusCode) {
        return statusCode != 0 ? statusCode != 1 ? R.mipmap.ic_gps_unknow : R.mipmap.ic_gps_full : R.mipmap.ic_gps_bad;
    }

    public static String m(int statusCode) {
        return statusCode != 0 ? statusCode != 1 ? statusCode != 2 ? statusCode != 3 ? statusCode != 4 ? "" : "没有GPS定位权限，建议开启gps定位权限" : "选择的定位模式中不包含GPS定位，建议选择包含GPS定位的模式，提高定位质量" : "GPS关闭，建议开启GPS，提高定位质量" : "手机中没有GPS Provider，无法进行GPS定位" : "GPS状态正常";
    }

    public static int r(Context mContext, float speed) {
        return speed < 3.0f ? ContextCompat.getColor(mContext, R.color.speed1) : (speed > 3.0f || speed < 7.0f) ? ContextCompat.getColor(mContext, R.color.speed3) : ContextCompat.getColor(mContext, R.color.speed2);
    }

    public static int s(Context mContext, float speed) {
        return speed < 1.0f ? ContextCompat.getColor(mContext, R.color.track_line_0) : (speed < 1.0f || speed >= 2.0f) ? (speed < 2.0f || speed >= 3.0f) ? (speed < 3.0f || speed >= 4.0f) ? (speed < 4.0f || speed >= 5.0f) ? (speed < 5.0f || speed >= 6.0f) ? (speed < 6.0f || speed >= 7.0f) ? (speed < 7.0f || speed >= 8.0f) ? (speed < 8.0f || speed >= 9.0f) ? (speed < 9.0f || speed >= 10.0f) ? ContextCompat.getColor(mContext, R.color.track_line_10) : ContextCompat.getColor(mContext, R.color.track_line_9) : ContextCompat.getColor(mContext, R.color.track_line_8) : ContextCompat.getColor(mContext, R.color.track_line_7) : ContextCompat.getColor(mContext, R.color.track_line_6) : ContextCompat.getColor(mContext, R.color.track_line_5) : ContextCompat.getColor(mContext, R.color.track_line_4) : ContextCompat.getColor(mContext, R.color.track_line_3) : ContextCompat.getColor(mContext, R.color.track_line_2) : ContextCompat.getColor(mContext, R.color.track_line_1);
    }

    public static int t(String step) {
        if (TextUtils.isEmpty(step)) {
            return 0;
        }
        List arrayList = new ArrayList();
        try {
            if (JSON.parse(step) instanceof JSONArray) {
                arrayList = JSON.parseArray(step, Integer.class);
            } else {
                String[] split = step.split(",");
                if (split.length > 0) {
                    for (String str : split) {
                        arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                    }
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
            String[] split2 = step.split(",");
            if (split2.length > 0) {
                for (String str2 : split2) {
                    if (str2 == null || "null".equalsIgnoreCase(str2)) {
                        arrayList.add(0);
                    } else {
                        try {
                            arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
                        } catch (NumberFormatException e7) {
                            e7.printStackTrace();
                        }
                    }
                }
            }
        }
        if (arrayList == null || arrayList.size() == 0) {
            return 0;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            i6 += ((Integer) arrayList.get(i7)).intValue();
        }
        return i6;
    }

    public static String h(long l6, String strPattern) {
        if (TextUtils.isEmpty(strPattern)) {
            strPattern = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = f20226a;
        if (simpleDateFormat == null) {
            try {
                f20226a = new SimpleDateFormat(strPattern, Locale.CHINA);
            } catch (Throwable unused) {
            }
        } else {
            simpleDateFormat.applyPattern(strPattern);
        }
        SimpleDateFormat simpleDateFormat2 = f20226a;
        if (simpleDateFormat2 == null) {
            return "NULL";
        }
        return simpleDateFormat2.format(Long.valueOf(l6));
    }

    public static int l(int gpsQualityReportStatusCode, int gpsAccuracyStatus) {
        if (gpsQualityReportStatusCode != 0 || gpsAccuracyStatus == -1) {
            return R.mipmap.ic_gps_unknow;
        }
        if (gpsAccuracyStatus != 0) {
            if (gpsAccuracyStatus != 1) {
                return R.mipmap.ic_gps_unknow;
            }
            return R.mipmap.ic_gps_full;
        }
        return R.mipmap.ic_gps_bad;
    }

    public static String o(int aMapLocationType) {
        switch (aMapLocationType) {
            case 1:
                return "GPS";
            case 2:
            case 3:
                return "前次定位结果";
            case 4:
                return "缓存定位结果";
            case 5:
                return "WIFI定位结果";
            case 6:
                return "基站定位结果";
            case 7:
                return "LBS定位结果";
            case 8:
                return "离线定位结果";
            default:
                return "未知";
        }
    }

    public static LatLng p(AMapLocation location) {
        if (location.getTrustedLevel() != 1) {
            return null;
        }
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        if (AMapUtils.calculateLineDistance(f20228c, latLng) > 10.0f) {
            f20228c = latLng;
            f20227b.clear();
            return null;
        }
        f20227b.add(latLng);
        f20228c = latLng;
        if (f20227b.size() < 5) {
            return null;
        }
        f20227b.clear();
        return latLng;
    }

    public static String a(double distance, long time) {
        double d6 = distance / 1000.0d;
        double d7 = time / 3600.0d;
        if (d6 > 0.0d) {
            return new DecimalFormat("0.00").format(d6 / d7);
        }
        return cm.f10901d;
    }

    public static String b(double distance, long time) {
        double round = Math.round((distance / 1000.0d) * 100.0d) / 100.0d;
        if (round > 0.0d) {
            return f((int) (time / round));
        }
        return "0'0\"";
    }

    public static String c(double distance) {
        return com.bxkj.base.v2.common.utils.h.f16899a.a(distance / 1000.0d);
    }

    public static String d(double distance) {
        return com.bxkj.base.v2.common.utils.h.f16899a.b(distance / 1000.0d);
    }
}
