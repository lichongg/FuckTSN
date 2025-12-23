package xyz.adscope.ad;

import android.content.Context;
import android.util.ArrayMap;
import android.view.View;
import java.util.List;
import java.util.Map;
import xyz.adscope.ad.model.impl.db.AdvertisingDBModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.AdResponseModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.SeatBidModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.BidModel;
import xyz.adscope.common.v2.encrypt.impl.MD5Util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, AdResponseModel> f54762a = new ArrayMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, View> f54763b = new ArrayMap();

    /* renamed from: c, reason: collision with root package name */
    private final h f54764c;

    public void a(String str, AdResponseModel adResponseModel) {
        Map<String, AdResponseModel> map = this.f54762a;
        if (map != null) {
            map.put(str, adResponseModel);
        }
    }

    public AdResponseModel b(String str) {
        Map<String, AdResponseModel> map = this.f54762a;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f54762a.get(str);
    }

    a(Context context) {
        this.f54764c = i.a().getOrCreateImplement(context);
    }

    public AdvertisingDBModel a(String str, String str2) {
        List query;
        String format = String.format("%s_%s", str, str2);
        a();
        h hVar = this.f54764c;
        if (hVar == null || (query = hVar.query(AdvertisingDBModel.class, hVar.whereEquals("cacheKey"), new String[]{format}, this.f54764c.getOrderByAsc("cacheTime"), 1)) == null || query.isEmpty()) {
            return null;
        }
        return (AdvertisingDBModel) query.get(0);
    }

    private void a() {
        if (this.f54764c != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f54764c.deleteLessThenWhere(AdvertisingDBModel.class, "expireTime", currentTimeMillis + "");
        }
    }

    public void a(String str, String str2, AdResponseModel adResponseModel) {
        if (adResponseModel != null) {
            AdvertisingDBModel advertisingDBModel = new AdvertisingDBModel();
            advertisingDBModel.b(String.format("%s_%s", str, str2));
            advertisingDBModel.a(adResponseModel.toJsonString());
            advertisingDBModel.a(System.currentTimeMillis());
            long a6 = a(adResponseModel);
            if (a6 == 0) {
                a6 = System.currentTimeMillis() + 1800000;
            }
            advertisingDBModel.b(a6);
            a(advertisingDBModel);
        }
    }

    public void a(AdvertisingDBModel advertisingDBModel) {
        this.f54764c.insert(advertisingDBModel);
    }

    private long a(AdResponseModel adResponseModel) {
        List<SeatBidModel> b6;
        SeatBidModel seatBidModel;
        List<BidModel> a6;
        BidModel bidModel;
        if (adResponseModel == null || (b6 = adResponseModel.b()) == null || b6.isEmpty() || (seatBidModel = b6.get(0)) == null || (a6 = seatBidModel.a()) == null || a6.isEmpty() || (bidModel = a6.get(0)) == null) {
            return 0L;
        }
        return bidModel.b();
    }

    public View a(String str) {
        if (this.f54763b.containsKey(str)) {
            return this.f54763b.get(str);
        }
        return null;
    }

    public String a(a2 a2Var, View view) {
        if (a2Var != null) {
            String a6 = a(a2Var.getSpaceID(), a2Var.getAdType());
            this.f54763b.put(a6, view);
            return a6;
        }
        return "";
    }

    private String a(String str, c cVar) {
        return MD5Util.md5(str + cVar.c() + System.currentTimeMillis());
    }
}
