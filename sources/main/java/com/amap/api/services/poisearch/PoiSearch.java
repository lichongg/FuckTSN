package com.amap.api.services.poisearch;

import android.content.Context;
import com.amap.api.col.s.j4;
import com.amap.api.col.s.q0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class PoiSearch {
    public static final String CHINESE = "zh-CN";
    public static final String ENGLISH = "en";
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";

    /* renamed from: a, reason: collision with root package name */
    private IPoiSearch f9401a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnPoiSearchListener {
        void onPoiItemSearched(PoiItem poiItem, int i6);

        void onPoiSearched(PoiResult poiResult, int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Query implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        private String f9402a;

        /* renamed from: b, reason: collision with root package name */
        private String f9403b;

        /* renamed from: c, reason: collision with root package name */
        private String f9404c;

        /* renamed from: d, reason: collision with root package name */
        private int f9405d;

        /* renamed from: e, reason: collision with root package name */
        private int f9406e;

        /* renamed from: f, reason: collision with root package name */
        private String f9407f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f9408g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f9409h;

        /* renamed from: i, reason: collision with root package name */
        private String f9410i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f9411j;

        /* renamed from: k, reason: collision with root package name */
        private LatLonPoint f9412k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f9413l;

        /* renamed from: m, reason: collision with root package name */
        private String f9414m;

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
            String str = this.f9403b;
            if (str == null) {
                if (query.f9403b != null) {
                    return false;
                }
            } else if (!str.equals(query.f9403b)) {
                return false;
            }
            String str2 = this.f9404c;
            if (str2 == null) {
                if (query.f9404c != null) {
                    return false;
                }
            } else if (!str2.equals(query.f9404c)) {
                return false;
            }
            String str3 = this.f9407f;
            if (str3 == null) {
                if (query.f9407f != null) {
                    return false;
                }
            } else if (!str3.equals(query.f9407f)) {
                return false;
            }
            if (this.f9405d != query.f9405d || this.f9406e != query.f9406e) {
                return false;
            }
            String str4 = this.f9402a;
            if (str4 == null) {
                if (query.f9402a != null) {
                    return false;
                }
            } else if (!str4.equals(query.f9402a)) {
                return false;
            }
            String str5 = this.f9410i;
            if (str5 == null) {
                if (query.f9410i != null) {
                    return false;
                }
            } else if (!str5.equals(query.f9410i)) {
                return false;
            }
            if (this.f9408g != query.f9408g || this.f9409h != query.f9409h || this.f9413l != query.f9413l) {
                return false;
            }
            String str6 = this.f9414m;
            if (str6 == null) {
                if (query.f9414m != null) {
                    return false;
                }
            } else if (!str6.equals(query.f9414m)) {
                return false;
            }
            return true;
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return PoiSearch.b(query.f9402a, this.f9402a) && PoiSearch.b(query.f9403b, this.f9403b) && PoiSearch.b(query.f9407f, this.f9407f) && PoiSearch.b(query.f9404c, this.f9404c) && PoiSearch.b(query.f9414m, this.f9414m) && PoiSearch.b(query.f9410i, this.f9410i) && query.f9408g == this.f9408g && query.f9406e == this.f9406e && query.f9411j == this.f9411j && query.f9413l == this.f9413l;
        }

        public Query(String str, String str2, String str3) {
            this.f9405d = 1;
            this.f9406e = 20;
            this.f9407f = "zh-CN";
            this.f9408g = false;
            this.f9409h = false;
            this.f9411j = true;
            this.f9413l = true;
            this.f9414m = "base";
            this.f9402a = str;
            this.f9403b = str2;
            this.f9404c = str3;
        }

        private static String a() {
            return "";
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Query m66clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e6) {
                j4.i(e6, "PoiSearch", "queryclone");
            }
            Query query = new Query(this.f9402a, this.f9403b, this.f9404c);
            query.setPageNum(this.f9405d);
            query.setPageSize(this.f9406e);
            query.setQueryLanguage(this.f9407f);
            query.setCityLimit(this.f9408g);
            query.requireSubPois(this.f9409h);
            query.setBuilding(this.f9410i);
            query.setLocation(this.f9412k);
            query.setDistanceSort(this.f9411j);
            query.setSpecial(this.f9413l);
            query.setExtensions(this.f9414m);
            return query;
        }

        public String getBuilding() {
            return this.f9410i;
        }

        public String getCategory() {
            String str = this.f9403b;
            return (str == null || str.equals("00") || this.f9403b.equals("00|")) ? a() : this.f9403b;
        }

        public String getCity() {
            return this.f9404c;
        }

        public boolean getCityLimit() {
            return this.f9408g;
        }

        public String getExtensions() {
            return this.f9414m;
        }

        public LatLonPoint getLocation() {
            return this.f9412k;
        }

        public int getPageNum() {
            return this.f9405d;
        }

        public int getPageSize() {
            return this.f9406e;
        }

        protected String getQueryLanguage() {
            return this.f9407f;
        }

        public String getQueryString() {
            return this.f9402a;
        }

        public int hashCode() {
            String str = this.f9403b;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.f9404c;
            int hashCode2 = (((((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + (this.f9408g ? 1231 : 1237)) * 31) + (this.f9409h ? 1231 : 1237)) * 31;
            String str3 = this.f9407f;
            int hashCode3 = (((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f9405d) * 31) + this.f9406e) * 31;
            String str4 = this.f9402a;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.f9410i;
            return hashCode4 + (str5 != null ? str5.hashCode() : 0);
        }

        public boolean isDistanceSort() {
            return this.f9411j;
        }

        public boolean isRequireSubPois() {
            return this.f9409h;
        }

        public boolean isSpecial() {
            return this.f9413l;
        }

        public void requireSubPois(boolean z5) {
            this.f9409h = z5;
        }

        public void setBuilding(String str) {
            this.f9410i = str;
        }

        public void setCityLimit(boolean z5) {
            this.f9408g = z5;
        }

        public void setDistanceSort(boolean z5) {
            this.f9411j = z5;
        }

        public void setExtensions(String str) {
            this.f9414m = str;
        }

        public void setLocation(LatLonPoint latLonPoint) {
            this.f9412k = latLonPoint;
        }

        public void setPageNum(int i6) {
            if (i6 <= 0) {
                i6 = 1;
            }
            this.f9405d = i6;
        }

        public void setPageSize(int i6) {
            if (i6 <= 0) {
                this.f9406e = 20;
            } else if (i6 > 30) {
                this.f9406e = 30;
            } else {
                this.f9406e = i6;
            }
        }

        public void setQueryLanguage(String str) {
            if ("en".equals(str)) {
                this.f9407f = "en";
            } else {
                this.f9407f = "zh-CN";
            }
        }

        public void setSpecial(boolean z5) {
            this.f9413l = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String ELLIPSE_SHAPE = "Ellipse";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f9415a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f9416b;

        /* renamed from: c, reason: collision with root package name */
        private int f9417c;

        /* renamed from: d, reason: collision with root package name */
        private LatLonPoint f9418d;

        /* renamed from: e, reason: collision with root package name */
        private String f9419e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f9420f;

        /* renamed from: g, reason: collision with root package name */
        private List<LatLonPoint> f9421g;

        public SearchBound(LatLonPoint latLonPoint, int i6) {
            this.f9420f = true;
            this.f9419e = "Bound";
            this.f9417c = i6;
            this.f9418d = latLonPoint;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            SearchBound searchBound = (SearchBound) obj;
            LatLonPoint latLonPoint = this.f9418d;
            if (latLonPoint == null) {
                if (searchBound.f9418d != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(searchBound.f9418d)) {
                return false;
            }
            if (this.f9420f != searchBound.f9420f) {
                return false;
            }
            LatLonPoint latLonPoint2 = this.f9415a;
            if (latLonPoint2 == null) {
                if (searchBound.f9415a != null) {
                    return false;
                }
            } else if (!latLonPoint2.equals(searchBound.f9415a)) {
                return false;
            }
            LatLonPoint latLonPoint3 = this.f9416b;
            if (latLonPoint3 == null) {
                if (searchBound.f9416b != null) {
                    return false;
                }
            } else if (!latLonPoint3.equals(searchBound.f9416b)) {
                return false;
            }
            List<LatLonPoint> list = this.f9421g;
            if (list == null) {
                if (searchBound.f9421g != null) {
                    return false;
                }
            } else if (!list.equals(searchBound.f9421g)) {
                return false;
            }
            if (this.f9417c != searchBound.f9417c) {
                return false;
            }
            String str = this.f9419e;
            if (str == null) {
                if (searchBound.f9419e != null) {
                    return false;
                }
            } else if (!str.equals(searchBound.f9419e)) {
                return false;
            }
            return true;
        }

        private void a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f9415a = latLonPoint;
            this.f9416b = latLonPoint2;
            if (latLonPoint.getLatitude() >= this.f9416b.getLatitude() || this.f9415a.getLongitude() >= this.f9416b.getLongitude()) {
                new IllegalArgumentException("invalid rect ").printStackTrace();
            }
            this.f9418d = new LatLonPoint((this.f9415a.getLatitude() + this.f9416b.getLatitude()) / 2.0d, (this.f9415a.getLongitude() + this.f9416b.getLongitude()) / 2.0d);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public SearchBound m67clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e6) {
                j4.i(e6, "PoiSearch", "SearchBoundClone");
            }
            return new SearchBound(this.f9415a, this.f9416b, this.f9417c, this.f9418d, this.f9419e, this.f9421g, this.f9420f);
        }

        public LatLonPoint getCenter() {
            return this.f9418d;
        }

        public LatLonPoint getLowerLeft() {
            return this.f9415a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f9421g;
        }

        public int getRange() {
            return this.f9417c;
        }

        public String getShape() {
            return this.f9419e;
        }

        public LatLonPoint getUpperRight() {
            return this.f9416b;
        }

        public int hashCode() {
            LatLonPoint latLonPoint = this.f9418d;
            int hashCode = ((((latLonPoint == null ? 0 : latLonPoint.hashCode()) + 31) * 31) + (this.f9420f ? 1231 : 1237)) * 31;
            LatLonPoint latLonPoint2 = this.f9415a;
            int hashCode2 = (hashCode + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            LatLonPoint latLonPoint3 = this.f9416b;
            int hashCode3 = (hashCode2 + (latLonPoint3 == null ? 0 : latLonPoint3.hashCode())) * 31;
            List<LatLonPoint> list = this.f9421g;
            int hashCode4 = (((hashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.f9417c) * 31;
            String str = this.f9419e;
            return hashCode4 + (str != null ? str.hashCode() : 0);
        }

        public boolean isDistanceSort() {
            return this.f9420f;
        }

        public SearchBound(LatLonPoint latLonPoint, int i6, boolean z5) {
            this.f9419e = "Bound";
            this.f9417c = i6;
            this.f9418d = latLonPoint;
            this.f9420f = z5;
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f9417c = 1500;
            this.f9420f = true;
            this.f9419e = "Rectangle";
            a(latLonPoint, latLonPoint2);
        }

        public SearchBound(List<LatLonPoint> list) {
            this.f9417c = 1500;
            this.f9420f = true;
            this.f9419e = "Polygon";
            this.f9421g = list;
        }

        private SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i6, LatLonPoint latLonPoint3, String str, List<LatLonPoint> list, boolean z5) {
            this.f9415a = latLonPoint;
            this.f9416b = latLonPoint2;
            this.f9417c = i6;
            this.f9418d = latLonPoint3;
            this.f9419e = str;
            this.f9421g = list;
            this.f9420f = z5;
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
        IPoiSearch iPoiSearch = this.f9401a;
        if (iPoiSearch != null) {
            return iPoiSearch.getBound();
        }
        return null;
    }

    public String getLanguage() {
        IPoiSearch iPoiSearch = this.f9401a;
        if (iPoiSearch != null) {
            return iPoiSearch.getLanguage();
        }
        return null;
    }

    public Query getQuery() {
        IPoiSearch iPoiSearch = this.f9401a;
        if (iPoiSearch != null) {
            return iPoiSearch.getQuery();
        }
        return null;
    }

    public PoiResult searchPOI() throws AMapException {
        IPoiSearch iPoiSearch = this.f9401a;
        if (iPoiSearch != null) {
            return iPoiSearch.searchPOI();
        }
        return null;
    }

    public void searchPOIAsyn() {
        IPoiSearch iPoiSearch = this.f9401a;
        if (iPoiSearch != null) {
            iPoiSearch.searchPOIAsyn();
        }
    }

    public PoiItem searchPOIId(String str) throws AMapException {
        IPoiSearch iPoiSearch = this.f9401a;
        if (iPoiSearch != null) {
            return iPoiSearch.searchPOIId(str);
        }
        return null;
    }

    public void searchPOIIdAsyn(String str) {
        IPoiSearch iPoiSearch = this.f9401a;
        if (iPoiSearch != null) {
            iPoiSearch.searchPOIIdAsyn(str);
        }
    }

    public void setBound(SearchBound searchBound) {
        IPoiSearch iPoiSearch = this.f9401a;
        if (iPoiSearch != null) {
            iPoiSearch.setBound(searchBound);
        }
    }

    public void setLanguage(String str) {
        IPoiSearch iPoiSearch = this.f9401a;
        if (iPoiSearch != null) {
            iPoiSearch.setLanguage(str);
        }
    }

    public void setOnPoiSearchListener(OnPoiSearchListener onPoiSearchListener) {
        IPoiSearch iPoiSearch = this.f9401a;
        if (iPoiSearch != null) {
            iPoiSearch.setOnPoiSearchListener(onPoiSearchListener);
        }
    }

    public void setQuery(Query query) {
        IPoiSearch iPoiSearch = this.f9401a;
        if (iPoiSearch != null) {
            iPoiSearch.setQuery(query);
        }
    }

    public PoiSearch(Context context, Query query) throws AMapException {
        this.f9401a = null;
        try {
            this.f9401a = new q0(context, query);
        } catch (Exception e6) {
            e6.printStackTrace();
            if (!(e6 instanceof AMapException)) {
            } else {
                throw ((AMapException) e6);
            }
        }
    }
}
