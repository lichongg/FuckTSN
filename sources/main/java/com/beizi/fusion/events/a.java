package com.beizi.fusion.events;

import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.tool.aa;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import xyz.adscope.amps.common.AMPSConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static SparseArray<String> f13458a = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    public static SparseArray<String> f13459b = new SparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    public static SparseArray<String> f13460c = new SparseArray<>();

    /* renamed from: d, reason: collision with root package name */
    public static SparseArray<String> f13461d = new SparseArray<>();

    /* renamed from: e, reason: collision with root package name */
    public static SparseArray<String> f13462e = new SparseArray<>();

    /* renamed from: f, reason: collision with root package name */
    public static SparseArray<String> f13463f = new SparseArray<>();

    /* renamed from: g, reason: collision with root package name */
    public static SparseArray<String> f13464g = new SparseArray<>();

    /* renamed from: h, reason: collision with root package name */
    public static SparseArray<String> f13465h = new SparseArray<>();

    /* renamed from: i, reason: collision with root package name */
    public static SparseArray<String> f13466i = new SparseArray<>();

    /* renamed from: j, reason: collision with root package name */
    public static SparseArray<String> f13467j = new SparseArray<>();

    /* renamed from: k, reason: collision with root package name */
    public static SparseArray<String> f13468k = new SparseArray<>();

    /* renamed from: l, reason: collision with root package name */
    private HashMap<String, Pair<AdSpacesBean.BuyerBean, AdSpacesBean.ForwardBean>> f13469l = new HashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private HashMap<String, EventBean> f13470m = new HashMap<>();

    /* renamed from: n, reason: collision with root package name */
    private EventBean f13471n;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.fusion.events.a$a, reason: collision with other inner class name */
    public class C0134a extends l {
        public C0134a() {
            super();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b extends l {
        public b() {
            super();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c extends l {
        public c() {
            super();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d extends l {
        public d() {
            super();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class e extends l {
        public e() {
            super();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class f extends l {
        public f() {
            super();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class g extends l {
        public g() {
            super();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class h extends l {
        public h() {
            super();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class i extends l {
        public i() {
            super();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class j extends l {
        public j() {
            super();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class k extends l {
        public k() {
            super();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class l extends Observable {

        /* renamed from: a, reason: collision with root package name */
        private int f13483a = 0;

        /* renamed from: c, reason: collision with root package name */
        private Map<String, Integer> f13485c = new HashMap();

        public void a(int i6) {
            if (this.f13483a != i6) {
                this.f13483a = i6;
                EventBean b6 = a.this.b(a.a(this));
                setChanged();
                notifyObservers(b6);
            }
        }

        public l() {
        }

        public int a() {
            return this.f13483a;
        }

        public void a(String str, int i6) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Map<String, Integer> map = this.f13485c;
            if (((map == null || !map.containsKey(str)) ? 0 : this.f13485c.get(str).intValue()) != i6 || i6 == 17) {
                this.f13485c.put(str, Integer.valueOf(i6));
                String a6 = a.a(str, this);
                aa.b("BeiZis", "changeStatus channel = " + str + ",eventCode = " + a6);
                EventBean a7 = a.this.a(str, a6);
                if ("290.300".equalsIgnoreCase(a6)) {
                    aa.b("BeiZis", "eventBean = " + a7);
                }
                setChanged();
                notifyObservers(a7);
            }
        }

        public int a(String str) {
            Map<String, Integer> map;
            if (TextUtils.isEmpty(str) || (map = this.f13485c) == null || !map.containsKey(str)) {
                return 0;
            }
            return this.f13485c.get(str).intValue();
        }
    }

    static {
        f13458a.put(1, "100.000");
        f13458a.put(2, "100.200");
        f13459b.put(-1, "210.400");
        f13459b.put(-2, "210.999");
        f13459b.put(1, "200.001");
        f13459b.put(2, "210.100");
        f13459b.put(3, "210.200");
        f13459b.put(4, "210.401");
        f13459b.put(5, "210.402");
        f13459b.put(6, "210.403");
        f13459b.put(7, "210.404");
        f13460c.put(-1, "220.400");
        f13460c.put(-2, "220.999");
        f13460c.put(1, "220.000");
        f13460c.put(2, "200.000");
        f13460c.put(3, "220.401");
        f13460c.put(4, "220.402");
        f13460c.put(5, "220.403");
        f13460c.put(6, "220.404");
        f13461d.put(-1, "230.400");
        f13461d.put(-2, "230.999");
        f13461d.put(1, "230.000");
        f13461d.put(2, "230.200");
        f13461d.put(3, "230.401");
        f13461d.put(4, "230.402");
        f13462e.put(-1, "245.400");
        f13462e.put(-2, "245.999");
        f13462e.put(1, "240.000");
        f13462e.put(2, "245.000");
        f13462e.put(3, "245.200");
        f13462e.put(4, "245.401");
        f13462e.put(5, "245.402");
        f13462e.put(6, "245.403");
        f13462e.put(7, "245.404");
        f13462e.put(8, "245.300");
        f13462e.put(9, "240.100");
        f13462e.put(10, "245.405");
        f13463f.put(-1, "249.400");
        f13463f.put(-2, "249.999");
        f13463f.put(1, "248.000");
        f13463f.put(2, "249.000");
        f13463f.put(3, "248.401");
        f13463f.put(4, "248.402");
        f13463f.put(5, "249.401");
        f13463f.put(6, "249.402");
        f13464g.put(-1, "280.600");
        f13464g.put(1, "250.100");
        f13464g.put(2, "250.200");
        f13464g.put(16, "250.401");
        f13464g.put(3, "255.200");
        f13464g.put(4, "280.200");
        f13464g.put(5, "280.280");
        f13464g.put(6, "280.300");
        f13464g.put(12, "280.350");
        f13464g.put(7, "290.300");
        f13464g.put(17, "290.301");
        f13464g.put(8, "280.400");
        f13464g.put(9, "280.450");
        f13464g.put(11, "280.500");
        f13464g.put(13, "280.301");
        f13464g.put(14, "280.302");
        f13464g.put(15, "280.303");
        f13464g.put(18, "250.000");
        f13464g.put(19, "250.400");
        f13464g.put(20, "280.000");
        f13464g.put(21, "250.500");
        f13464g.put(22, "290.500");
        f13465h.put(1, "280.210");
        f13465h.put(-2, "280.249");
        f13465h.put(2, "280.220");
        f13465h.put(3, "280.250");
        f13465h.put(4, "280.241");
        f13465h.put(5, "280.240");
        f13465h.put(6, "280.242");
        f13465h.put(7, "280.243");
        f13465h.put(8, "280.260");
        f13465h.put(9, "280.270");
        f13466i.put(1, "280.261");
        f13466i.put(2, "280.262");
        f13466i.put(3, "280.263");
        f13466i.put(4, "280.264");
        f13468k.put(1, "212.000");
        f13468k.put(2, "212.400");
        f13468k.put(3, "212.401");
        f13468k.put(4, "212.999");
        f13468k.put(5, "214.000");
        f13468k.put(6, "214.200");
        f13468k.put(7, "216.200");
        f13468k.put(8, "216.401");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EventBean b(String str) {
        EventBean eventBean = this.f13471n;
        if (eventBean == null || str == null) {
            return null;
        }
        try {
            EventBean m86clone = eventBean.m86clone();
            m86clone.setEventCode(str);
            m86clone.setEventTime(String.valueOf(System.currentTimeMillis()));
            return m86clone;
        } catch (CloneNotSupportedException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    private Pair<AdSpacesBean.BuyerBean, AdSpacesBean.ForwardBean> c(String str) {
        if (this.f13469l.containsKey(str)) {
            return this.f13469l.get(str);
        }
        return null;
    }

    public static String a(l lVar) {
        if (lVar instanceof i) {
            return f13458a.get(lVar.a());
        }
        if (lVar instanceof h) {
            return f13459b.get(lVar.a());
        }
        if (lVar instanceof k) {
            return f13460c.get(lVar.a());
        }
        if (lVar instanceof g) {
            return f13461d.get(lVar.a());
        }
        if (lVar instanceof j) {
            return f13467j.get(lVar.a());
        }
        return "0";
    }

    public static String a(String str, l lVar) {
        if (lVar instanceof d) {
            return f13462e.get(lVar.a(str));
        }
        if (lVar instanceof e) {
            return f13463f.get(lVar.a(str));
        }
        if (lVar instanceof f) {
            return f13464g.get(lVar.a(str));
        }
        if (lVar instanceof c) {
            return f13465h.get(lVar.a(str));
        }
        if (lVar instanceof b) {
            return f13466i.get(lVar.a(str));
        }
        if (lVar instanceof C0134a) {
            return f13468k.get(lVar.a(str));
        }
        return "0";
    }

    public void a(EventBean eventBean) {
        this.f13471n = eventBean;
    }

    public EventBean a(String str) {
        if (this.f13470m.containsKey(str)) {
            try {
                EventBean eventBean = this.f13470m.get(str);
                if (eventBean != null) {
                    EventBean m86clone = eventBean.m86clone();
                    this.f13470m.put(str, m86clone);
                    return m86clone;
                }
            } catch (CloneNotSupportedException e6) {
                e6.printStackTrace();
            }
        } else {
            EventBean eventBean2 = this.f13471n;
            if (eventBean2 != null) {
                try {
                    EventBean m86clone2 = eventBean2.m86clone();
                    this.f13470m.put(str, m86clone2);
                    return m86clone2;
                } catch (CloneNotSupportedException e7) {
                    e7.printStackTrace();
                }
            }
        }
        EventBean eventBean3 = new EventBean(com.beizi.fusion.c.b.f13294b, "", "", "", com.beizi.fusion.c.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), "");
        this.f13470m.put(str, eventBean3);
        return eventBean3;
    }

    public void a(String str, EventBean eventBean) {
        if (TextUtils.isEmpty(str) || eventBean == null) {
            return;
        }
        this.f13470m.put(str, eventBean);
    }

    public void a(AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean) {
        Pair<AdSpacesBean.BuyerBean, AdSpacesBean.ForwardBean> pair = new Pair<>(buyerBean, forwardBean);
        if (buyerBean == null || TextUtils.isEmpty(buyerBean.getBuyerSpaceUuId())) {
            return;
        }
        this.f13469l.put(buyerBean.getBuyerSpaceUuId(), pair);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EventBean a(String str, String str2) {
        Pair<AdSpacesBean.BuyerBean, AdSpacesBean.ForwardBean> c6 = c(str);
        StringBuilder sb = new StringBuilder();
        sb.append("getChannelEventBean eventCode = ");
        sb.append(str2);
        sb.append(",channelData == null ");
        sb.append(c6 == null);
        aa.b("BeiZis", sb.toString());
        if (c6 != null) {
            AdSpacesBean.BuyerBean buyerBean = (AdSpacesBean.BuyerBean) c6.first;
            AdSpacesBean.ForwardBean forwardBean = (AdSpacesBean.ForwardBean) c6.second;
            EventBean a6 = a(str);
            if (a6 != null && buyerBean != null && forwardBean != null) {
                a6.setEventCode(str2);
                a6.setEventTime(String.valueOf(System.currentTimeMillis()));
                a(a6, str, buyerBean, forwardBean);
                this.f13470m.put(str, a6);
            }
            return a6;
        }
        aa.c("BeiZis", "getChannelEventBean eventCode = " + str2 + ",but channelData is null !!!");
        return null;
    }

    private static void a(EventBean eventBean, String str, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean) {
        if (eventBean == null) {
            return;
        }
        eventBean.setBuyerId(String.valueOf(com.beizi.fusion.e.b.a(buyerBean.getId())));
        eventBean.setBuyerAppId(buyerBean.getAppId());
        eventBean.setBuyerSpaceId(buyerBean.getSpaceId());
        eventBean.setChannelFilterSsid(buyerBean.getFilterSsid());
        eventBean.setRenderViewSsid(buyerBean.getRenderViewSsid());
        eventBean.setBeiZiPrice(String.valueOf(buyerBean.getAvgPrice()));
        eventBean.setBeiZiBaseId(com.beizi.fusion.e.b.b(forwardBean.getBaseId()));
        if (!"BPDI".equalsIgnoreCase(buyerBean.getBidType()) && !AMPSConstants.BiddingType.BIDDING_TYPE_C2S.equalsIgnoreCase(buyerBean.getBidType()) && !AMPSConstants.BiddingType.BIDDING_TYPE_S2S.equalsIgnoreCase(buyerBean.getBidType())) {
            eventBean.setBeiZiSrcType(0);
        } else {
            eventBean.setBeiZiSrcType(1);
            if (buyerBean.getBidPrice() > 0.0d) {
                eventBean.setBidPrice(String.valueOf(buyerBean.getBidPrice()));
            } else {
                eventBean.setBidPrice("0");
            }
        }
        if (forwardBean != null) {
            eventBean.setForwardId(forwardBean.getForwardId());
            eventBean.setParentId(forwardBean.getParentForwardId());
            eventBean.setLevel(forwardBean.getLevel());
            eventBean.setBuyerSpaceUuId(forwardBean.getBuyerSpaceUuId());
        }
    }
}
