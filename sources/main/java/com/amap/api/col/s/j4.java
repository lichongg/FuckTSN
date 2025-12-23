package com.amap.api.col.s;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class j4 {
    public static float b(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        if (latLonPoint != null && latLonPoint2 != null) {
            try {
                double longitude = latLonPoint.getLongitude();
                double d6 = longitude * 0.01745329251994329d;
                double latitude = latLonPoint.getLatitude() * 0.01745329251994329d;
                double longitude2 = latLonPoint2.getLongitude() * 0.01745329251994329d;
                double latitude2 = latLonPoint2.getLatitude() * 0.01745329251994329d;
                double sin = Math.sin(d6);
                double sin2 = Math.sin(latitude);
                double cos = Math.cos(d6);
                double cos2 = Math.cos(latitude);
                double sin3 = Math.sin(longitude2);
                double sin4 = Math.sin(latitude2);
                double cos3 = Math.cos(longitude2);
                double cos4 = Math.cos(latitude2);
                double[] dArr = {cos * cos2, cos2 * sin, sin2};
                double[] dArr2 = {cos3 * cos4, cos4 * sin3, sin4};
                double d7 = dArr[0];
                double d8 = dArr2[0];
                double d9 = (d7 - d8) * (d7 - d8);
                double d10 = dArr[1];
                double d11 = dArr2[1];
                double d12 = d9 + ((d10 - d11) * (d10 - d11));
                double d13 = dArr[2];
                double d14 = dArr2[2];
                return (float) (Math.asin(Math.sqrt(d12 + ((d13 - d14) * (d13 - d14))) / 2.0d) * 1.27420015798544E7d);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return 0.0f;
    }

    public static Date n(String str) {
        if (str != null && !str.trim().equals("")) {
            try {
                return new SimpleDateFormat("HHmm").parse(str);
            } catch (ParseException e6) {
                i(e6, "CoreUtil", "parseString2Time");
            }
        }
        return null;
    }

    public static Date o(String str) {
        if (str != null && !str.trim().equals("")) {
            try {
                return new SimpleDateFormat("HH:mm").parse(str);
            } catch (ParseException e6) {
                i(e6, "CoreUtil", "parseTime");
            }
        }
        return null;
    }

    public static double a(double d6) {
        return Double.parseDouble(new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US)).format(d6));
    }

    public static String c(int i6) {
        StringBuilder sb = new StringBuilder();
        if ((i6 & 1) != 0) {
            sb.append("cost,");
        }
        if ((i6 & 2) != 0) {
            sb.append("tmcs,");
        }
        if ((i6 & 4) != 0) {
            sb.append("navi,");
        }
        if ((i6 & 8) != 0) {
            sb.append("cities,");
        }
        if ((i6 & 16) != 0) {
            sb.append("polyline,");
        }
        if ((i6 & 32) != 0) {
            sb.append("elec_consume_info,");
        }
        if ((i6 & 64) != 0) {
            sb.append("charge_station_info,");
        }
        sb.replace(sb.length() - 1, sb.length(), "");
        return sb.toString();
    }

    public static String d(LatLonPoint latLonPoint) {
        if (latLonPoint == null) {
            return "";
        }
        return a(latLonPoint.getLongitude()) + "," + a(latLonPoint.getLatitude());
    }

    public static String e(Date date) {
        return date != null ? new SimpleDateFormat("HH:mm").format(date) : "";
    }

    public static String f(List<LatLonPoint> list) {
        return g(list, ";");
    }

    public static String g(List<LatLonPoint> list, String str) {
        if (list == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i6 = 0; i6 < list.size(); i6++) {
            LatLonPoint latLonPoint = list.get(i6);
            if (latLonPoint != null) {
                double a6 = a(latLonPoint.getLongitude());
                double a7 = a(latLonPoint.getLatitude());
                stringBuffer.append(a6);
                stringBuffer.append(",");
                stringBuffer.append(a7);
                stringBuffer.append(str);
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }

    private static void h(int i6, String str) throws AMapException, JSONException {
        if (i6 != 0) {
            if (i6 == 22000) {
                throw new AMapException(AMapException.AMAP_SERVICE_TABLEID_NOT_EXIST, 2, str);
            }
            if (i6 == 32200) {
                throw new AMapException(AMapException.AMAP_NEARBY_INVALID_USERID, 2, str);
            }
            if (i6 == 32201) {
                throw new AMapException(AMapException.AMAP_NEARBY_KEY_NOT_BIND, 2, str);
            }
            switch (i6) {
                case 10000:
                    return;
                case 10001:
                    throw new AMapException(AMapException.AMAP_INVALID_USER_KEY, 2, str);
                case 10002:
                    throw new AMapException(AMapException.AMAP_SERVICE_NOT_AVAILBALE, 2, str);
                case 10003:
                    throw new AMapException(AMapException.AMAP_DAILY_QUERY_OVER_LIMIT, 2, str);
                case 10004:
                    throw new AMapException(AMapException.AMAP_ACCESS_TOO_FREQUENT, 2, str);
                case 10005:
                    throw new AMapException(AMapException.AMAP_INVALID_USER_IP, 2, str);
                case 10006:
                    throw new AMapException(AMapException.AMAP_INVALID_USER_DOMAIN, 2, str);
                case 10007:
                    throw new AMapException("用户签名未通过", 2, str);
                case IMediaPlayer.MEDIA_INFO_VIDEO_SEEK_RENDERING_START /* 10008 */:
                    throw new AMapException(AMapException.AMAP_INVALID_USER_SCODE, 2, str);
                case IMediaPlayer.MEDIA_INFO_AUDIO_SEEK_RENDERING_START /* 10009 */:
                    throw new AMapException(AMapException.AMAP_USERKEY_PLAT_NOMATCH, 2, str);
                case 10010:
                    throw new AMapException(AMapException.AMAP_IP_QUERY_OVER_LIMIT, 2, str);
                case 10011:
                    throw new AMapException(AMapException.AMAP_NOT_SUPPORT_HTTPS, 2, str);
                case 10012:
                    throw new AMapException(AMapException.AMAP_INSUFFICIENT_PRIVILEGES, 2, str);
                case 10013:
                    throw new AMapException(AMapException.AMAP_USER_KEY_RECYCLED, 2, str);
                default:
                    switch (i6) {
                        case 20000:
                            throw new AMapException(AMapException.AMAP_SERVICE_INVALID_PARAMS, 2, str);
                        case IjkMediaPlayer.FFP_PROP_INT64_SELECTED_VIDEO_STREAM /* 20001 */:
                            throw new AMapException(AMapException.AMAP_SERVICE_MISSING_REQUIRED_PARAMS, 2, str);
                        case IjkMediaPlayer.FFP_PROP_INT64_SELECTED_AUDIO_STREAM /* 20002 */:
                            throw new AMapException(AMapException.AMAP_SERVICE_ILLEGAL_REQUEST, 2, str);
                        case IjkMediaPlayer.FFP_PROP_INT64_VIDEO_DECODER /* 20003 */:
                            throw new AMapException(AMapException.AMAP_SERVICE_UNKNOWN_ERROR, 2, str);
                        default:
                            switch (i6) {
                                case 20800:
                                    throw new AMapException(AMapException.AMAP_ROUTE_OUT_OF_SERVICE, 2, str);
                                case 20801:
                                    throw new AMapException(AMapException.AMAP_ROUTE_NO_ROADS_NEARBY, 2, str);
                                case 20802:
                                    throw new AMapException(AMapException.AMAP_ROUTE_FAIL, 2, str);
                                case 20803:
                                    throw new AMapException(AMapException.AMAP_OVER_DIRECTION_RANGE, 2, str);
                                default:
                                    switch (i6) {
                                        case KSImageLoader.InnerImageLoadingListener.MAX_DURATION /* 30000 */:
                                            throw new AMapException(AMapException.AMAP_ENGINE_RESPONSE_ERROR, 2, str);
                                        case 30001:
                                            throw new AMapException(AMapException.AMAP_ENGINE_RESPONSE_DATA_ERROR, 2, str);
                                        case 30002:
                                            throw new AMapException(AMapException.AMAP_ENGINE_CONNECT_TIMEOUT, 2, str);
                                        case 30003:
                                            throw new AMapException(AMapException.AMAP_ENGINE_RETURN_TIMEOUT, 2, str);
                                        default:
                                            switch (i6) {
                                                case 32000:
                                                    throw new AMapException(AMapException.AMAP_ENGINE_TABLEID_NOT_EXIST, 2, str);
                                                case 32001:
                                                    throw new AMapException(AMapException.AMAP_ID_NOT_EXIST, 2, str);
                                                case 32002:
                                                    throw new AMapException(AMapException.AMAP_SERVICE_MAINTENANCE, 2, str);
                                                default:
                                                    if (!TextUtils.isEmpty(str) && i6 > 0) {
                                                        throw new AMapException(str, 2, str, i6);
                                                    }
                                                    throw new AMapException(str, 2, str);
                                            }
                                    }
                            }
                    }
            }
        }
    }

    public static boolean j(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static double k(List<LatLonPoint> list) {
        double d6 = 0.0d;
        if (list == null || list.size() < 3) {
            return 0.0d;
        }
        int size = list.size();
        int i6 = 0;
        while (i6 < size) {
            LatLonPoint latLonPoint = list.get(i6);
            i6++;
            LatLonPoint latLonPoint2 = list.get(i6 % size);
            double longitude = latLonPoint.getLongitude() * 111319.49079327357d * Math.cos(latLonPoint.getLatitude() * 0.017453292519943295d);
            double latitude = latLonPoint.getLatitude() * 111319.49079327357d;
            d6 += (longitude * (latLonPoint2.getLatitude() * 111319.49079327357d)) - (((latLonPoint2.getLongitude() * 111319.49079327357d) * Math.cos(latLonPoint2.getLatitude() * 0.017453292519943295d)) * latitude);
        }
        return Math.abs(d6 / 2.0d);
    }

    public static void l(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(com.huawei.hms.feature.dynamic.b.f33209h)) {
                h(jSONObject.getInt(com.huawei.hms.feature.dynamic.b.f33209h), jSONObject.getString("errmsg"));
                return;
            }
            if (jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
                String string = jSONObject.getString(NotificationCompat.CATEGORY_STATUS);
                if (string.equals("1")) {
                    return;
                }
                if (string.equals("0") && !jSONObject.has("infocode")) {
                    throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
                }
                int i6 = jSONObject.getInt("infocode");
                if (string.equals("0")) {
                    h(i6, jSONObject.getString("info"));
                }
            }
        } catch (JSONException e6) {
            i(e6, "CoreUtil", "paseAuthFailurJson");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static void m(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(com.huawei.hms.feature.dynamic.b.f33209h)) {
                h(jSONObject.getInt(com.huawei.hms.feature.dynamic.b.f33209h), jSONObject.getString("errmsg"));
                return;
            }
            if (jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
                if (jSONObject.optInt(NotificationCompat.CATEGORY_STATUS) == 0) {
                    if (!jSONObject.has("infocode")) {
                        throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
                    }
                    h(jSONObject.getInt("infocode"), jSONObject.getString("info"));
                }
                int optInt = jSONObject.optInt("code");
                if (optInt == 0) {
                    return;
                }
                String optString = jSONObject.optString(CrashHianalyticsData.MESSAGE);
                throw new AMapException(optString, 2, optString, Integer.parseInt("1".concat(String.valueOf(optInt))));
            }
        } catch (JSONException e6) {
            i(e6, "CoreUtil", "paseAuthFailurJson");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static void i(Throwable th, String str, String str2) {
        try {
            g2 n6 = g2.n();
            if (n6 != null) {
                n6.m(th, str, str2);
            }
            th.printStackTrace();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
