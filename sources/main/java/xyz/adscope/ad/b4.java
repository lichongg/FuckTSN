package xyz.adscope.ad;

import android.content.Context;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.AssetModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface b4 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(String str);

        void b(String str);
    }

    void a();

    void a(a aVar);

    void a(AssetModel assetModel);

    void a(RenderModel renderModel);

    void b();

    void c();

    Context getContext();

    xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a getExpressRoot();

    int getLayer();

    String getScopeViewID();

    void setExpressRoot(xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a aVar);

    void setScopeViewID(String str);
}
