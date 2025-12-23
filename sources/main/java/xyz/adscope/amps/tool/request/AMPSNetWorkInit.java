package xyz.adscope.amps.tool.request;

import android.content.Context;
import xyz.adscope.common.network.JsonConverter;
import xyz.adscope.common.network.Kalle;
import xyz.adscope.common.network.KalleConfig;
import xyz.adscope.common.network.cookie.DBCookieStore;
import xyz.adscope.common.network.simple.cache.DiskCacheStore;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSNetWorkInit {
    public static void init(Context context) {
        Kalle.setConfig(KalleConfig.newBuilder().cookieStore(DBCookieStore.newBuilder(context).build()).cacheStore(DiskCacheStore.newBuilder("filePath").build()).converter(new JsonConverter(context)).build());
        Kalle.setConfig(KalleConfig.newBuilder().build());
    }
}
