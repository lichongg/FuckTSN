package com.amap.api.location;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.utils.b;
import com.autonavi.aps.amapapi.utils.e;
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.j;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CoordinateConverter {

    /* renamed from: b, reason: collision with root package name */
    private static int f8891b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static int f8892c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static int f8893d = 2;

    /* renamed from: e, reason: collision with root package name */
    private static int f8894e = 4;

    /* renamed from: f, reason: collision with root package name */
    private static int f8895f = 8;

    /* renamed from: g, reason: collision with root package name */
    private static int f8896g = 16;

    /* renamed from: h, reason: collision with root package name */
    private static int f8897h = 32;

    /* renamed from: i, reason: collision with root package name */
    private static int f8898i = 64;

    /* renamed from: j, reason: collision with root package name */
    private Context f8900j;

    /* renamed from: k, reason: collision with root package name */
    private CoordType f8901k = null;

    /* renamed from: l, reason: collision with root package name */
    private DPoint f8902l = null;

    /* renamed from: a, reason: collision with root package name */
    DPoint f8899a = null;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum CoordType {
        BAIDU,
        MAPBAR,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE,
        GPS
    }

    public synchronized DPoint convert() throws Exception {
        try {
            if (this.f8901k == null) {
                throw new IllegalArgumentException("转换坐标类型不能为空");
            }
            DPoint dPoint = this.f8902l;
            if (dPoint == null) {
                throw new IllegalArgumentException("转换坐标源不能为空");
            }
            if (dPoint.getLongitude() > 180.0d || this.f8902l.getLongitude() < -180.0d) {
                throw new IllegalArgumentException("请传入合理经度");
            }
            if (this.f8902l.getLatitude() > 90.0d || this.f8902l.getLatitude() < -90.0d) {
                throw new IllegalArgumentException("请传入合理纬度");
            }
            boolean z5 = true;
            String str = null;
            switch (AnonymousClass1.f8903a[this.f8901k.ordinal()]) {
                case 1:
                    this.f8899a = e.a(this.f8902l);
                    int i6 = f8891b;
                    int i7 = f8892c;
                    if ((i6 & i7) == 0) {
                        str = "baidu";
                        f8891b = i6 | i7;
                        break;
                    }
                    z5 = false;
                    break;
                case 2:
                    this.f8899a = e.b(this.f8900j, this.f8902l);
                    int i8 = f8891b;
                    int i9 = f8893d;
                    if ((i8 & i9) == 0) {
                        str = "mapbar";
                        f8891b = i8 | i9;
                        break;
                    }
                    z5 = false;
                    break;
                case 3:
                    int i10 = f8891b;
                    int i11 = f8894e;
                    if ((i10 & i11) == 0) {
                        str = "mapabc";
                        f8891b = i10 | i11;
                    } else {
                        z5 = false;
                    }
                    this.f8899a = this.f8902l;
                    break;
                case 4:
                    int i12 = f8891b;
                    int i13 = f8895f;
                    if ((i12 & i13) == 0) {
                        str = "sosomap";
                        f8891b = i12 | i13;
                    } else {
                        z5 = false;
                    }
                    this.f8899a = this.f8902l;
                    break;
                case 5:
                    int i14 = f8891b;
                    int i15 = f8896g;
                    if ((i14 & i15) == 0) {
                        str = "aliyun";
                        f8891b = i14 | i15;
                    } else {
                        z5 = false;
                    }
                    this.f8899a = this.f8902l;
                    break;
                case 6:
                    int i16 = f8891b;
                    int i17 = f8897h;
                    if ((i16 & i17) == 0) {
                        str = "google";
                        f8891b = i16 | i17;
                    } else {
                        z5 = false;
                    }
                    this.f8899a = this.f8902l;
                    break;
                case 7:
                    int i18 = f8891b;
                    int i19 = f8898i;
                    if ((i18 & i19) == 0) {
                        str = GeocodeSearch.GPS;
                        f8891b = i18 | i19;
                    } else {
                        z5 = false;
                    }
                    this.f8899a = e.a(this.f8900j, this.f8902l);
                    break;
                default:
                    z5 = false;
                    break;
            }
            if (z5) {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("amap_loc_coordinate", str);
                }
                h.a(this.f8900j, "O021", jSONObject);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f8899a;
    }

    public synchronized CoordinateConverter coord(DPoint dPoint) throws Exception {
        if (dPoint == null) {
            throw new IllegalArgumentException("传入经纬度对象为空");
        }
        if (dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
            throw new IllegalArgumentException("请传入合理经度");
        }
        if (dPoint.getLatitude() > 90.0d || dPoint.getLatitude() < -90.0d) {
            throw new IllegalArgumentException("请传入合理纬度");
        }
        this.f8902l = dPoint;
        return this;
    }

    public synchronized CoordinateConverter from(CoordType coordType) {
        this.f8901k = coordType;
        return this;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.amap.api.location.CoordinateConverter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8903a;

        static {
            int[] iArr = new int[CoordType.values().length];
            f8903a = iArr;
            try {
                iArr[CoordType.BAIDU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8903a[CoordType.MAPBAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8903a[CoordType.MAPABC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8903a[CoordType.SOSOMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8903a[CoordType.ALIYUN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8903a[CoordType.GOOGLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8903a[CoordType.GPS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public CoordinateConverter(Context context) {
        this.f8900j = context;
    }

    public static float calculateLineDistance(DPoint dPoint, DPoint dPoint2) {
        try {
            return j.a(dPoint, dPoint2);
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    public static boolean isAMapDataAvailable(double d6, double d7) {
        return b.a(d6, d7);
    }
}
