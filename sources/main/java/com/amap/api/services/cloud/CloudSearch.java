package com.amap.api.services.cloud;

import android.content.Context;
import com.amap.api.col.s.i;
import com.amap.api.col.s.j4;
import com.amap.api.col.s.k0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.ICloudSearch;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CloudSearch {

    /* renamed from: a, reason: collision with root package name */
    private ICloudSearch f9172a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnCloudSearchListener {
        void onCloudItemDetailSearched(CloudItemDetail cloudItemDetail, int i6);

        void onCloudSearched(CloudResult cloudResult, int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Query implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        private String f9173a;

        /* renamed from: d, reason: collision with root package name */
        private String f9176d;

        /* renamed from: e, reason: collision with root package name */
        private SearchBound f9177e;

        /* renamed from: f, reason: collision with root package name */
        private Sortingrules f9178f;

        /* renamed from: b, reason: collision with root package name */
        private int f9174b = 1;

        /* renamed from: c, reason: collision with root package name */
        private int f9175c = 20;

        /* renamed from: g, reason: collision with root package name */
        private ArrayList<i> f9179g = new ArrayList<>();

        /* renamed from: h, reason: collision with root package name */
        private List<String> f9180h = new ArrayList();

        public Query(String str, String str2, SearchBound searchBound) throws AMapException {
            if (j4.j(str) || searchBound == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            this.f9176d = str;
            this.f9173a = str2;
            this.f9177e = searchBound;
        }

        private ArrayList<i> a() {
            if (this.f9179g == null) {
                return null;
            }
            ArrayList<i> arrayList = new ArrayList<>();
            arrayList.addAll(this.f9179g);
            return arrayList;
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof Query)) {
                if (obj == this) {
                    return true;
                }
                Query query = (Query) obj;
                if (queryEquals(query) && query.f9174b == this.f9174b) {
                    return true;
                }
            }
            return false;
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            return CloudSearch.b(query.f9173a, this.f9173a) && CloudSearch.b(query.getTableID(), getTableID()) && CloudSearch.b(query.getFilterString(), getFilterString()) && CloudSearch.b(query.getFilterNumString(), getFilterNumString()) && query.f9175c == this.f9175c && a(query.getBound(), getBound()) && a(query.getSortingrules(), getSortingrules());
        }

        private ArrayList<String> b() {
            if (this.f9180h == null) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.addAll(this.f9180h);
            return arrayList;
        }

        public void addFilterNum(String str, String str2, String str3) {
            this.f9179g.add(new i(str, str2, str3));
        }

        public void addFilterString(String str, String str2) {
            if (str == null || str2 == null) {
                return;
            }
            this.f9180h.add(str + str2);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0043 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x003d  */
        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.amap.api.services.cloud.CloudSearch.Query m63clone() {
            /*
                r6 = this;
                super.clone()     // Catch: java.lang.CloneNotSupportedException -> L4
                goto L8
            L4:
                r0 = move-exception
                r0.printStackTrace()
            L8:
                r0 = 0
                com.amap.api.services.cloud.CloudSearch$Query r1 = new com.amap.api.services.cloud.CloudSearch$Query     // Catch: com.amap.api.services.core.AMapException -> L34
                java.lang.String r2 = r6.f9176d     // Catch: com.amap.api.services.core.AMapException -> L34
                java.lang.String r3 = r6.f9173a     // Catch: com.amap.api.services.core.AMapException -> L34
                com.amap.api.services.cloud.CloudSearch$SearchBound r4 = r6.f9177e     // Catch: com.amap.api.services.core.AMapException -> L34
                r1.<init>(r2, r3, r4)     // Catch: com.amap.api.services.core.AMapException -> L34
                int r0 = r6.f9174b     // Catch: com.amap.api.services.core.AMapException -> L32
                r1.setPageNum(r0)     // Catch: com.amap.api.services.core.AMapException -> L32
                int r0 = r6.f9175c     // Catch: com.amap.api.services.core.AMapException -> L32
                r1.setPageSize(r0)     // Catch: com.amap.api.services.core.AMapException -> L32
                com.amap.api.services.cloud.CloudSearch$Sortingrules r0 = r6.getSortingrules()     // Catch: com.amap.api.services.core.AMapException -> L32
                r1.setSortingrules(r0)     // Catch: com.amap.api.services.core.AMapException -> L32
                java.util.ArrayList r0 = r6.a()     // Catch: com.amap.api.services.core.AMapException -> L32
                r1.f9179g = r0     // Catch: com.amap.api.services.core.AMapException -> L32
                java.util.ArrayList r0 = r6.b()     // Catch: com.amap.api.services.core.AMapException -> L32
                r1.f9180h = r0     // Catch: com.amap.api.services.core.AMapException -> L32
                goto L3b
            L32:
                r0 = move-exception
                goto L38
            L34:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
            L38:
                r0.printStackTrace()
            L3b:
                if (r1 != 0) goto L43
                com.amap.api.services.cloud.CloudSearch$Query r0 = new com.amap.api.services.cloud.CloudSearch$Query
                r0.<init>()
                return r0
            L43:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.cloud.CloudSearch.Query.m63clone():com.amap.api.services.cloud.CloudSearch$Query");
        }

        public SearchBound getBound() {
            return this.f9177e;
        }

        public String getFilterNumString() {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                int size = this.f9179g.size();
                for (int i6 = 0; i6 < size; i6++) {
                    i iVar = this.f9179g.get(i6);
                    stringBuffer.append(iVar.a());
                    stringBuffer.append(">=");
                    stringBuffer.append(iVar.b());
                    stringBuffer.append("&&");
                    stringBuffer.append(iVar.a());
                    stringBuffer.append("<=");
                    stringBuffer.append(iVar.c());
                    if (i6 != size - 1) {
                        stringBuffer.append("&&");
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return stringBuffer.toString();
        }

        public String getFilterString() {
            StringBuffer stringBuffer = new StringBuffer();
            try {
                int size = this.f9180h.size();
                for (int i6 = 0; i6 < size; i6++) {
                    stringBuffer.append(this.f9180h.get(i6));
                    if (i6 != size - 1) {
                        stringBuffer.append("&&");
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return stringBuffer.toString();
        }

        public int getPageNum() {
            return this.f9174b;
        }

        public int getPageSize() {
            return this.f9175c;
        }

        public String getQueryString() {
            return this.f9173a;
        }

        public Sortingrules getSortingrules() {
            return this.f9178f;
        }

        public String getTableID() {
            return this.f9176d;
        }

        public int hashCode() {
            ArrayList<i> arrayList = this.f9179g;
            int hashCode = ((arrayList == null ? 0 : arrayList.hashCode()) + 31) * 31;
            List<String> list = this.f9180h;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            SearchBound searchBound = this.f9177e;
            int hashCode3 = (((((hashCode2 + (searchBound == null ? 0 : searchBound.hashCode())) * 31) + this.f9174b) * 31) + this.f9175c) * 31;
            String str = this.f9173a;
            int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            Sortingrules sortingrules = this.f9178f;
            int hashCode5 = (hashCode4 + (sortingrules == null ? 0 : sortingrules.hashCode())) * 31;
            String str2 = this.f9176d;
            return hashCode5 + (str2 != null ? str2.hashCode() : 0);
        }

        public void setBound(SearchBound searchBound) {
            this.f9177e = searchBound;
        }

        public void setPageNum(int i6) {
            this.f9174b = i6;
        }

        public void setPageSize(int i6) {
            if (i6 <= 0) {
                this.f9175c = 20;
            } else if (i6 > 100) {
                this.f9175c = 100;
            } else {
                this.f9175c = i6;
            }
        }

        public void setSortingrules(Sortingrules sortingrules) {
            this.f9178f = sortingrules;
        }

        public void setTableID(String str) {
            this.f9176d = str;
        }

        private static boolean a(SearchBound searchBound, SearchBound searchBound2) {
            if (searchBound == null && searchBound2 == null) {
                return true;
            }
            if (searchBound == null || searchBound2 == null) {
                return false;
            }
            return searchBound.equals(searchBound2);
        }

        private static boolean a(Sortingrules sortingrules, Sortingrules sortingrules2) {
            if (sortingrules == null && sortingrules2 == null) {
                return true;
            }
            if (sortingrules == null || sortingrules2 == null) {
                return false;
            }
            return sortingrules.equals(sortingrules2);
        }

        private Query() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String LOCAL_SHAPE = "Local";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f9181a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f9182b;

        /* renamed from: c, reason: collision with root package name */
        private int f9183c;

        /* renamed from: d, reason: collision with root package name */
        private LatLonPoint f9184d;

        /* renamed from: e, reason: collision with root package name */
        private String f9185e;

        /* renamed from: f, reason: collision with root package name */
        private List<LatLonPoint> f9186f;

        /* renamed from: g, reason: collision with root package name */
        private String f9187g;

        public SearchBound(LatLonPoint latLonPoint, int i6) {
            this.f9185e = "Bound";
            this.f9183c = i6;
            this.f9184d = latLonPoint;
        }

        private boolean a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f9181a = latLonPoint;
            this.f9182b = latLonPoint2;
            return latLonPoint != null && latLonPoint2 != null && latLonPoint.getLatitude() < this.f9182b.getLatitude() && this.f9181a.getLongitude() < this.f9182b.getLongitude();
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof SearchBound)) {
                SearchBound searchBound = (SearchBound) obj;
                if (!getShape().equalsIgnoreCase(searchBound.getShape())) {
                    return false;
                }
                if (getShape().equals("Bound")) {
                    return searchBound.f9184d.equals(this.f9184d) && searchBound.f9183c == this.f9183c;
                }
                if (getShape().equals("Polygon")) {
                    return a(searchBound.f9186f, this.f9186f);
                }
                if (getShape().equals(LOCAL_SHAPE)) {
                    return searchBound.f9187g.equals(this.f9187g);
                }
                if (searchBound.f9181a.equals(this.f9181a) && searchBound.f9182b.equals(this.f9182b)) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public SearchBound m64clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e6) {
                e6.printStackTrace();
            }
            return getShape().equals("Bound") ? new SearchBound(this.f9184d, this.f9183c) : getShape().equals("Polygon") ? new SearchBound(a()) : getShape().equals(LOCAL_SHAPE) ? new SearchBound(this.f9187g) : new SearchBound(this.f9181a, this.f9182b);
        }

        public LatLonPoint getCenter() {
            return this.f9184d;
        }

        public String getCity() {
            return this.f9187g;
        }

        public LatLonPoint getLowerLeft() {
            return this.f9181a;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f9186f;
        }

        public int getRange() {
            return this.f9183c;
        }

        public String getShape() {
            return this.f9185e;
        }

        public LatLonPoint getUpperRight() {
            return this.f9182b;
        }

        public int hashCode() {
            LatLonPoint latLonPoint = this.f9184d;
            int hashCode = ((latLonPoint == null ? 0 : latLonPoint.hashCode()) + 31) * 31;
            LatLonPoint latLonPoint2 = this.f9181a;
            int hashCode2 = (hashCode + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            LatLonPoint latLonPoint3 = this.f9182b;
            int hashCode3 = (hashCode2 + (latLonPoint3 == null ? 0 : latLonPoint3.hashCode())) * 31;
            List<LatLonPoint> list = this.f9186f;
            int hashCode4 = (((hashCode3 + (list == null ? 0 : list.hashCode())) * 31) + this.f9183c) * 31;
            String str = this.f9185e;
            int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f9187g;
            return hashCode5 + (str2 != null ? str2.hashCode() : 0);
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f9185e = "Rectangle";
            if (a(latLonPoint, latLonPoint2)) {
                return;
            }
            new IllegalArgumentException("invalid rect ").printStackTrace();
        }

        private static boolean a(List<LatLonPoint> list, List<LatLonPoint> list2) {
            if (list == null && list2 == null) {
                return true;
            }
            if (list == null || list2 == null || list.size() != list2.size()) {
                return false;
            }
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                if (!list.get(i6).equals(list2.get(i6))) {
                    return false;
                }
            }
            return true;
        }

        private List<LatLonPoint> a() {
            if (this.f9186f == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (LatLonPoint latLonPoint : this.f9186f) {
                arrayList.add(new LatLonPoint(latLonPoint.getLatitude(), latLonPoint.getLongitude()));
            }
            return arrayList;
        }

        public SearchBound(List<LatLonPoint> list) {
            this.f9185e = "Polygon";
            this.f9186f = list;
        }

        public SearchBound(String str) {
            this.f9185e = LOCAL_SHAPE;
            this.f9187g = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Sortingrules {
        public static final int DISTANCE = 1;
        public static final int WEIGHT = 0;

        /* renamed from: a, reason: collision with root package name */
        private int f9188a;

        /* renamed from: b, reason: collision with root package name */
        private String f9189b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f9190c;

        public Sortingrules(String str, boolean z5) {
            this.f9188a = 0;
            this.f9189b = str;
            this.f9190c = z5;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Sortingrules sortingrules = (Sortingrules) obj;
            if (this.f9190c != sortingrules.f9190c) {
                return false;
            }
            String str = this.f9189b;
            if (str == null) {
                if (sortingrules.f9189b != null) {
                    return false;
                }
            } else if (!str.equals(sortingrules.f9189b)) {
                return false;
            }
            return this.f9188a == sortingrules.f9188a;
        }

        public int hashCode() {
            int i6 = ((this.f9190c ? 1231 : 1237) + 31) * 31;
            String str = this.f9189b;
            return ((i6 + (str == null ? 0 : str.hashCode())) * 31) + this.f9188a;
        }

        public String toString() {
            if (j4.j(this.f9189b)) {
                int i6 = this.f9188a;
                return i6 == 0 ? "_weight:desc" : i6 == 1 ? "_distance:asc" : "";
            }
            if (this.f9190c) {
                return this.f9189b + ":asc";
            }
            return this.f9189b + ":desc";
        }

        public Sortingrules(int i6) {
            this.f9190c = true;
            this.f9188a = i6;
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

    public void searchCloudAsyn(Query query) {
        ICloudSearch iCloudSearch = this.f9172a;
        if (iCloudSearch != null) {
            iCloudSearch.searchCloudAsyn(query);
        }
    }

    public void searchCloudDetailAsyn(String str, String str2) {
        ICloudSearch iCloudSearch = this.f9172a;
        if (iCloudSearch != null) {
            iCloudSearch.searchCloudDetailAsyn(str, str2);
        }
    }

    public void setOnCloudSearchListener(OnCloudSearchListener onCloudSearchListener) {
        ICloudSearch iCloudSearch = this.f9172a;
        if (iCloudSearch != null) {
            iCloudSearch.setOnCloudSearchListener(onCloudSearchListener);
        }
    }

    public CloudSearch(Context context) throws AMapException {
        if (this.f9172a == null) {
            try {
                this.f9172a = new k0(context);
            } catch (Exception e6) {
                e6.printStackTrace();
                if (e6 instanceof AMapException) {
                    throw ((AMapException) e6);
                }
            }
        }
    }
}
