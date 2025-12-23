package xyz.adscope.ad;

import android.content.Context;
import java.util.List;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.NativeModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.AssetModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.type.ImageModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.type.VideoModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.down.DownloadInfoModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel;
import xyz.adscope.common.v2.cache.ImageLruCache;
import xyz.adscope.common.v2.cache.LruCacheModel;
import xyz.adscope.common.v2.cache.VideoLruCache;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class e0 {
    public static void a(Context context) {
        VideoLruCache.getInstance().releaseCacheDirMemory(context);
        ImageLruCache.getInstance().releaseCacheDirMemory(context);
    }

    public static void a(Context context, NativeModel nativeModel) {
        if (nativeModel != null) {
            DownloadInfoModel b6 = nativeModel.b();
            if (b6 != null) {
                ImageLruCache.getInstance().cacheResource(context, b6.e(), LruCacheModel.TEMPORARY);
            }
            List<RenderModel> e6 = nativeModel.e();
            if (e6 != null) {
                for (RenderModel renderModel : e6) {
                    if (renderModel != null && renderModel.f() != null) {
                        ImageLruCache.getInstance().cacheResource(context, renderModel.f().j(), LruCacheModel.PERMANENT);
                    }
                }
            }
            List<AssetModel> a6 = nativeModel.a();
            if (a6 != null) {
                for (AssetModel assetModel : a6) {
                    if (assetModel != null) {
                        ImageModel b7 = assetModel.b();
                        if (b7 != null) {
                            ImageLruCache.getInstance().cacheResource(context, b7.c(), LruCacheModel.TEMPORARY);
                        }
                        VideoModel d6 = assetModel.d();
                        if (d6 != null) {
                            VideoLruCache.getInstance().cacheResource(context, d6.d(), LruCacheModel.TEMPORARY);
                        }
                    }
                }
            }
        }
    }
}
