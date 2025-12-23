package com.amap.api.col.p0003l;

import androidx.core.app.NotificationCompat;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.amap.api.services.core.AMapException;
import com.huawei.hms.feature.dynamic.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a4 {

    /* renamed from: a, reason: collision with root package name */
    private static String[] f5625a = {"com.amap.api.trace", "com.amap.api.trace.core"};

    public static int a(List<LatLng> list) {
        int i6 = 0;
        if (list == null || list.size() == 0) {
            return 0;
        }
        int i7 = 0;
        while (i6 < list.size() - 1) {
            LatLng latLng = list.get(i6);
            i6++;
            LatLng latLng2 = list.get(i6);
            if (latLng == null || latLng2 == null) {
                break;
            }
            i7 = (int) (i7 + AMapUtils.calculateLineDistance(latLng, latLng2));
        }
        return i7;
    }

    private static void b(int i6, String str) throws fc {
        if (i6 != 0) {
            switch (i6) {
                case 10000:
                    return;
                case 10001:
                    throw new fc(AMapException.AMAP_INVALID_USER_KEY);
                case 10002:
                    throw new fc(AMapException.AMAP_SERVICE_NOT_AVAILBALE);
                case 10003:
                    throw new fc(AMapException.AMAP_DAILY_QUERY_OVER_LIMIT);
                case 10004:
                    throw new fc(AMapException.AMAP_ACCESS_TOO_FREQUENT);
                case 10005:
                    throw new fc(AMapException.AMAP_INVALID_USER_IP);
                case 10006:
                    throw new fc(AMapException.AMAP_INVALID_USER_DOMAIN);
                case 10007:
                    throw new fc("用户签名未通过");
                case IMediaPlayer.MEDIA_INFO_VIDEO_SEEK_RENDERING_START /* 10008 */:
                    throw new fc(AMapException.AMAP_INVALID_USER_SCODE);
                case IMediaPlayer.MEDIA_INFO_AUDIO_SEEK_RENDERING_START /* 10009 */:
                    throw new fc(AMapException.AMAP_USERKEY_PLAT_NOMATCH);
                case 10010:
                    throw new fc(AMapException.AMAP_IP_QUERY_OVER_LIMIT);
                case 10011:
                    throw new fc(AMapException.AMAP_NOT_SUPPORT_HTTPS);
                case 10012:
                    throw new fc(AMapException.AMAP_INSUFFICIENT_PRIVILEGES);
                case 10013:
                    throw new fc(AMapException.AMAP_USER_KEY_RECYCLED);
                default:
                    switch (i6) {
                        case 20000:
                            throw new fc(AMapException.AMAP_SERVICE_INVALID_PARAMS);
                        case IjkMediaPlayer.FFP_PROP_INT64_SELECTED_VIDEO_STREAM /* 20001 */:
                            throw new fc(AMapException.AMAP_SERVICE_MISSING_REQUIRED_PARAMS);
                        case IjkMediaPlayer.FFP_PROP_INT64_SELECTED_AUDIO_STREAM /* 20002 */:
                            throw new fc(AMapException.AMAP_SERVICE_ILLEGAL_REQUEST);
                        case IjkMediaPlayer.FFP_PROP_INT64_VIDEO_DECODER /* 20003 */:
                            throw new fc(AMapException.AMAP_SERVICE_UNKNOWN_ERROR);
                        default:
                            switch (i6) {
                                case KSImageLoader.InnerImageLoadingListener.MAX_DURATION /* 30000 */:
                                    throw new fc(AMapException.AMAP_ENGINE_RESPONSE_ERROR);
                                case 30001:
                                    throw new fc(AMapException.AMAP_ENGINE_RESPONSE_DATA_ERROR);
                                case 30002:
                                    throw new fc(AMapException.AMAP_ENGINE_CONNECT_TIMEOUT);
                                case 30003:
                                    throw new fc(AMapException.AMAP_ENGINE_RETURN_TIMEOUT);
                                default:
                                    throw new fc(str);
                            }
                    }
            }
        }
    }

    public static void c(String str) throws fc {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(b.f33209h)) {
                b(jSONObject.getInt(b.f33209h), jSONObject.getString("errmsg"));
                return;
            }
            if (jSONObject.has(NotificationCompat.CATEGORY_STATUS) && jSONObject.has("infocode")) {
                String string = jSONObject.getString(NotificationCompat.CATEGORY_STATUS);
                int i6 = jSONObject.getInt("infocode");
                if ("1".equals(string)) {
                    return;
                }
                String string2 = jSONObject.getString("info");
                if ("0".equals(string)) {
                    b(i6, string2);
                }
            }
        } catch (JSONException unused) {
            throw new fc("协议解析错误 - ProtocolException");
        }
    }
}
