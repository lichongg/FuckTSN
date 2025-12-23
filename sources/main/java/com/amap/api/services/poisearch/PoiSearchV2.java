package com.amap.api.services.poisearch;

import android.content.Context;
import com.amap.api.col.s.j4;
import com.amap.api.col.s.r0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.interfaces.IPoiSearchV2;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class PoiSearchV2 {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";

    /* renamed from: a, reason: collision with root package name */
    private IPoiSearchV2 f9422a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnPoiSearchListener {
        void onPoiItemSearched(PoiItemV2 poiItemV2, int i6);

        void onPoiSearched(PoiResultV2 poiResultV2, int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum PremiumType {
        DEFAULT(""),
        ENTIRETY("entirety_poi");


        /* renamed from: a, reason: collision with root package name */
        private final String f9424a;

        final String a() {
            return this.f9424a;
        }

        static PremiumType a(String str) {
            PremiumType premiumType = DEFAULT;
            if (!str.equals(premiumType.a())) {
                PremiumType premiumType2 = ENTIRETY;
                if (str.equals(premiumType2.a())) {
                    return premiumType2;
                }
            }
            return premiumType;
        }

        PremiumType(String str) {
            this.f9424a = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Query implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        private String f9425a;

        /* renamed from: b, reason: collision with root package name */
        private String f9426b;

        /* renamed from: c, reason: collision with root package name */
        private String f9427c;

        /* renamed from: d, reason: collision with root package name */
        private int f9428d;

        /* renamed from: e, reason: collision with root package name */
        private int f9429e;

        /* renamed from: f, reason: collision with root package name */
        private String f9430f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f9431g;

        /* renamed from: h, reason: collision with root package name */
        private String f9432h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f9433i;

        /* renamed from: j, reason: collision with root package name */
        private LatLonPoint f9434j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f9435k;

        /* renamed from: l, reason: collision with root package name */
        private String f9436l;

        /* renamed from: m, reason: collision with root package name */
        private String f9437m;

        /* renamed from: n, reason: collision with root package name */
        private ShowFields f9438n;

        public Query(String str, String str2) {
            this(str, str2, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Query query = (Query) obj;
            String str = this.f9426b;
            if (str == null) {
                if (query.f9426b != null) {
                    return false;
                }
            } else if (!str.equals(query.f9426b)) {
                return false;
            }
            String str2 = this.f9427c;
            if (str2 == null) {
                if (query.f9427c != null) {
                    return false;
                }
            } else if (!str2.equals(query.f9427c)) {
                return false;
            }
            String str3 = this.f9430f;
            if (str3 == null) {
                if (query.f9430f != null) {
                    return false;
                }
            } else if (!str3.equals(query.f9430f)) {
                return false;
            }
            if (this.f9428d != query.f9428d || this.f9429e != query.f9429e) {
                return false;
            }
            String str4 = this.f9425a;
            if (str4 == null) {
                if (query.f9425a != null) {
                    return false;
                }
            } else if (!str4.equals(query.f9425a)) {
                return false;
            }
            String str5 = this.f9436l;
            if (str5 == null) {
                if (query.f9436l != null) {
                    return false;
                }
            } else if (!str5.equals(query.f9436l)) {
                return false;
            }
            String str6 = this.f9437m;
            if (str6 == null) {
                if (query.f9437m != null) {
                    return false;
                }
            } else if (!str6.equals(query.f9437m)) {
                return false;
            }
            String str7 = this.f9432h;
            if (str7 == null) {
                if (query.f9432h != null) {
                    return false;
                }
            } else if (!str7.equals(query.f9432h)) {
                return false;
            }
            if (this.f9431g != query.f9431g || this.f9435k != query.f9435k) {
                return false;
            }
            int i6 = this.f9438n.value;
            return true;
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return PoiSearchV2.b(query.f9425a, this.f9425a) && PoiSearchV2.b(query.f9426b, this.f9426b) && PoiSearchV2.b(query.f9430f, this.f9430f) && PoiSearchV2.b(query.f9427c, this.f9427c) && PoiSearchV2.b(query.f9432h, this.f9432h) && PoiSearchV2.b(query.f9436l, this.f9436l) && PoiSearchV2.b(query.f9437m, this.f9437m) && query.f9431g == this.f9431g && query.f9429e == this.f9429e && query.f9433i == this.f9433i && query.f9435k == this.f9435k && query.f9438n.value == this.f9438n.value;
        }

        public Query(String str, String str2, String str3) {
            this.f9428d = 1;
            this.f9429e = 20;
            this.f9430f = "zh-CN";
            this.f9431g = false;
            this.f9433i = true;
            this.f9435k = true;
            this.f9437m = PremiumType.DEFAULT.a();
            this.f9438n = new ShowFields();
            this.f9425a = str;
            this.f9426b = str2;
            this.f9427c = str3;
        }

        private static String a() {
            return "";
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Query m68clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e6) {
                j4.i(e6, "PoiSearch", "queryclone");
            }
            Query query = new Query(this.f9425a, this.f9426b, this.f9427c);
            query.setPageNum(this.f9428d);
            query.setPageSize(this.f9429e);
            query.setQueryLanguage(this.f9430f);
            query.setCityLimit(this.f9431g);
            query.setBuilding(this.f9432h);
            query.setLocation(this.f9434j);
            query.setDistanceSort(this.f9433i);
            query.setSpecial(this.f9435k);
            query.setChannel(this.f9436l);
            query.setPremium(PremiumType.a(this.f9437m));
            query.setShowFields(new ShowFields(this.f9438n.value));
            return query;
        }

        public String getBuilding() {
            return this.f9432h;
        }

        public String getCategory() {
            String str = this.f9426b;
            return (str == null || str.equals("00") || this.f9426b.equals("00|")) ? a() : this.f9426b;
        }

        public String getChannel() {
            return this.f9436l;
        }

        public String getCity() {
            return this.f9427c;
        }

        public boolean getCityLimit() {
            return this.f9431g;
        }

        public LatLonPoint getLocation() {
            return this.f9434j;
        }

        public int getPageNum() {
            return this.f9428d;
        }

        public int getPageSize() {
            return this.f9429e;
        }

        public String getPremium() {
            return this.f9437m;
        }

        protected String getQueryLanguage() {
            return this.f9430f;
        }

        public String getQueryString() {
            return this.f9425a;
        }

        public ShowFields getShowFields() {
            return this.f9438n;
        }

        public int hashCode() {
            String str = this.f9426b;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.f9436l;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f9437m;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f9427c;
            int hashCode4 = (((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + (this.f9431g ? 1231 : 1237)) * 31;
            String str5 = this.f9430f;
            int hashCode5 = (((((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.f9428d) * 31) + this.f9429e) * 31;
            String str6 = this.f9425a;
            int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.f9432h;
            return ((hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31) + (this.f9438n.value % 1024);
        }

        public boolean isDistanceSort() {
            return this.f9433i;
        }

        public boolean isSpecial() {
            return this.f9435k;
        }

        public void setBuilding(String str) {
            this.f9432h = str;
        }

        public void setChannel(String str) {
            this.f9436l = str;
        }

        public void setCityLimit(boolean z5) {
            this.f9431g = z5;
        }

        public void setDistanceSort(boolean z5) {
            this.f9433i = z5;
        }

        public void setLocation(LatLonPoint latLonPoint) {
            this.f9434j = latLonPoint;
        }

        public void setPageNum(int i6) {
            if (i6 <= 0) {
                i6 = 1;
            }
            this.f9428d = i6;
        }

        public void setPageSize(int i6) {
            if (i6 <= 0) {
                this.f9429e = 20;
            } else if (i6 > 30) {
                this.f9429e = 30;
            } else {
                this.f9429e = i6;
            }
        }

        public void setPremium(PremiumType premiumType) {
            if (premiumType == null) {
                return;
            }
            this.f9437m = premiumType.a();
        }

        public void setQueryLanguage(String str) {
            if ("en".equals(str)) {
                this.f9430f = "en";
            } else {
                this.f9430f = "zh-CN";
            }
        }

        public void setShowFields(ShowFields showFields) {
            if (showFields == null) {
                this.f9438n = new ShowFields();
            } else {
                this.f9438n = showFields;
            }
        }

        public void setSpecial(boolean z5) {
            this.f9435k = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String ELLIPSE_SHAPE = "Ellipse";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f9439a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f9440b;

        /* renamed from: c, reason: collision with root package name */
        private int f9441c;

        /* renamed from: d, reason: collision with root package name */
        private LatLonPoint f9442d;

        /* renamed from: e, reason: collision with root package name */
        private String f9443e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f9444f;

        /* renamed from: g, reason: collision with root package name */
        private List<LatLonPoint> f9445g;

        public SearchBound(LatLonPoint latLonPoint, int i6) {
            this.f9444f = true;
            this.f9443e = "Bound";
            this.f9441c = i6;
            this.f9442d = latLonPoint;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SearchBound searchBound = (SearchBound) obj;
            LatLonPoint latLonPoint = this.f9442d;
            if (latLonPoint == null) {
                if (searchBound.f9442d != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(searchBound.f9442d)) {
                return false;
            }
            if (this.f9444f != searchBound.f9444f) {
                return false;
            }
            LatLonPoint latLonPoint2 = this.f9439a;
            if (latLonPoint2 == null) {
                if (searchBound.f9439a != null) {
                    return false;
                }
            } else if (!latLonPoint2.equals(searchBound.f9439a)) {
                return false;
            }
            LatLonPoint latLonPoint3 = this.f9440b;
            if (latLonPoint3 == null) {
                if (searchBound.f9440b != null) {
                    return false;
                }
            } else if (!latLonPoint3.equals(searchBound.f9440b)) {
                return false;
            }
            List<LatLonPoint> list = this.f9445g;
            if (list == null) {
                if (searchBound.f9445g != null) {
                    return false;
                }
            } else if (!list.equals(searchBound.f9445g)) {
                return false;
            }
            if (this.f9441c != searchBound.f9441c) {
                return false;
            }
            String str = this.f9443e;
            if (str == null) {
                if (searchBound.f9443e != null) {
                    return false;
                }
            } else if (!str.equals(searchBound.f9443e)) {
                return false;
            }
            return true;
        }

        private void a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f9439a = latLonPoint;
            this.f9440b = latLonPoint2;
            if (latLonPoint.getLatitude() >= this.f9440b.getLatitude() || this.f9439a.getLongitude() >= this.f9440b.getLongitude()) {
                new IllegalArgumentException("invalid rect ").printStackTrace();
            }
            this.f9442d = new LatLonPoint((this.f9439a.getLatitude() + this.f9440b.getLatitude()) / 2.0d, (this.f9439a.getLongitude() + this.f9440b.getLongitude()) / 2.0d);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public SearchBound m69clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e6) {
                j4.i(e6, "PoiSearch", "SearchBoundClone");
            }
            return new SearchBound(this.f9439a, this.f9440b, this.f9441c, this.f9442d, this.f9443e, this.f9445g, this.f9444f);
        }

        public LatLonPoint getCenter() {
            return this.f9442d;
        }

        public LatLonPoint getLowerLeft() {
            return this.f9439a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f9445g;
        }

        public int getRange() {
            return this.f9441c;
        }

        public String getShape() {
            return this.f9443e;
        }

        public LatLonPoint getUpperRight() {
            return this.f9440b;
        }

        public int hashCode() {
            LatLonPoint latLonPoint = this.f9442d;
            int hashCode = ((((latLonPoint == null ? 0 : latLonPoint.hashCode()) + 31) * 31) + (this.f9444f ? 1231 : 1237)) * 31;
            LatLonPoint latLonPoint2 = this.f9439a;
            int hashCode2 = (hashCode + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            LatLonPoint latLonPoint3 = this.f9440b;
            int hashCode3 = (hashCode2 + (latLonPoint3 == null ? 0 : latLonPoint3.hashCode())) * 31;
            List<LatLonPoint> list = this.f9445g;
            int hashCode4 = (((hashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.f9441c) * 31;
            String str = this.f9443e;
            return hashCode4 + (str != null ? str.hashCode() : 0);
        }

        public boolean isDistanceSort() {
            return this.f9444f;
        }

        public SearchBound(LatLonPoint latLonPoint, int i6, boolean z5) {
            this.f9443e = "Bound";
            this.f9441c = i6;
            this.f9442d = latLonPoint;
            this.f9444f = z5;
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f9441c = 1500;
            this.f9444f = true;
            this.f9443e = "Rectangle";
            a(latLonPoint, latLonPoint2);
        }

        public SearchBound(List<LatLonPoint> list) {
            this.f9441c = 1500;
            this.f9444f = true;
            this.f9443e = "Polygon";
            this.f9445g = list;
        }

        private SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i6, LatLonPoint latLonPoint3, String str, List<LatLonPoint> list, boolean z5) {
            this.f9439a = latLonPoint;
            this.f9440b = latLonPoint2;
            this.f9441c = i6;
            this.f9442d = latLonPoint3;
            this.f9443e = str;
            this.f9445g = list;
            this.f9444f = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class ShowFields {
        public static final int ALL = -1;
        public static final int BUSINESS = 2;
        public static final int CHILDREN = 1;
        public static final int DEFAULT = 0;
        public static final int INDOOR = 4;
        public static final int NAVI = 8;
        public static final int PHOTOS = 16;
        public int value;

        ShowFields() {
            this.value = 0;
        }

        public ShowFields(int i6) {
            this.value = i6;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int i6) {
            this.value = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public SearchBound getBound() {
        IPoiSearchV2 iPoiSearchV2 = this.f9422a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.getBound();
        }
        return null;
    }

    public Query getQuery() {
        IPoiSearchV2 iPoiSearchV2 = this.f9422a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.getQuery();
        }
        return null;
    }

    public PoiResultV2 searchPOI() throws AMapException {
        IPoiSearchV2 iPoiSearchV2 = this.f9422a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.searchPOI();
        }
        return null;
    }

    public void searchPOIAsyn() {
        IPoiSearchV2 iPoiSearchV2 = this.f9422a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.searchPOIAsyn();
        }
    }

    public PoiItemV2 searchPOIId(String str) throws AMapException {
        IPoiSearchV2 iPoiSearchV2 = this.f9422a;
        if (iPoiSearchV2 != null) {
            return iPoiSearchV2.searchPOIId(str);
        }
        return null;
    }

    public void searchPOIIdAsyn(String str) {
        IPoiSearchV2 iPoiSearchV2 = this.f9422a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.searchPOIIdAsyn(str);
        }
    }

    public void setBound(SearchBound searchBound) {
        IPoiSearchV2 iPoiSearchV2 = this.f9422a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.setBound(searchBound);
        }
    }

    public void setOnPoiSearchListener(OnPoiSearchListener onPoiSearchListener) {
        IPoiSearchV2 iPoiSearchV2 = this.f9422a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.setOnPoiSearchListener(onPoiSearchListener);
        }
    }

    public void setQuery(Query query) {
        IPoiSearchV2 iPoiSearchV2 = this.f9422a;
        if (iPoiSearchV2 != null) {
            iPoiSearchV2.setQuery(query);
        }
    }

    public PoiSearchV2(Context context, Query query) throws AMapException {
        this.f9422a = null;
        try {
            this.f9422a = new r0(context, query);
        } catch (Exception e6) {
            e6.printStackTrace();
            if (!(e6 instanceof AMapException)) {
            } else {
                throw ((AMapException) e6);
            }
        }
    }
}
