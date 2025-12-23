package cn.jiguang.al;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import cn.jiguang.bz.q;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes2.dex */
public class j {

    /* renamed from: b, reason: collision with root package name */
    private static String f1624b = "WifiHelper";

    /* renamed from: a, reason: collision with root package name */
    protected int f1625a;

    /* renamed from: c, reason: collision with root package name */
    private h f1626c;

    /* renamed from: d, reason: collision with root package name */
    private Comparator<ScanResult> f1627d;

    /* renamed from: e, reason: collision with root package name */
    private Comparator<Long> f1628e;

    /* renamed from: f, reason: collision with root package name */
    private i<Long> f1629f;

    /* renamed from: g, reason: collision with root package name */
    private List<ScanResult> f1630g;

    /* renamed from: h, reason: collision with root package name */
    private WifiManager f1631h;

    /* renamed from: i, reason: collision with root package name */
    private Context f1632i;

    /* renamed from: cn.jiguang.al.j$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a implements Comparator<Long> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Long l6, Long l7) {
            if (l6.longValue() == l7.longValue()) {
                return 0;
            }
            if (l6.longValue() > l7.longValue()) {
                return 1;
            }
            return -1;
        }
    }

    private static class b implements Comparator<ScanResult> {
        private b() {
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ScanResult scanResult, ScanResult scanResult2) {
            return scanResult2.level - scanResult.level;
        }
    }

    public Comparator<ScanResult> a() {
        return this.f1627d;
    }

    protected void b() {
        try {
            boolean z5 = e.f1591a;
            if (!z5 || this.f1625a != 101) {
                if (z5) {
                    return;
                }
                cn.jiguang.an.a.a(this.f1632i, "loc_info_v2", IAdInterListener.AdReqParam.WIDTH, 1);
                return;
            }
            boolean b6 = f.a().b();
            Context context = this.f1632i;
            boolean a6 = context != null ? q.a(context, com.kuaishou.weapon.p0.g.f36044d) : false;
            cn.jiguang.bb.f.c(f1624b, "doSample checkSafeStatus = " + b6 + "  , wifi permission:" + a6);
            if (!b6) {
                cn.jiguang.an.a.a(this.f1632i, "loc_info_v2", IAdInterListener.AdReqParam.WIDTH, 2);
            }
            if (!a6) {
                cn.jiguang.an.a.a(this.f1632i, "loc_info_v2", IAdInterListener.AdReqParam.WIDTH, -5);
            }
            if (!b6 || !a6) {
                this.f1625a = 101;
                return;
            }
            this.f1630g.clear();
            this.f1625a = 100;
            b(this.f1631h.getScanResults());
        } catch (Throwable th) {
            cn.jiguang.bb.f.i(f1624b, "[WifiHelper] startScan error:" + th);
        }
    }

    private void b(List<ScanResult> list) {
        List<Long> a6;
        try {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() != 0) {
                Collections.sort(list, this.f1627d);
                int i6 = 0;
                for (int i7 = 0; i7 < list.size(); i7++) {
                    ScanResult scanResult = list.get(i7);
                    if (scanResult != null) {
                        long parseLong = Long.parseLong(scanResult.BSSID.replaceAll(":", ""), 16);
                        if (parseLong != 0 && scanResult.level > e.f1598h && !arrayList.contains(Long.valueOf(parseLong))) {
                            if (i6 >= e.f1597g) {
                                break;
                            }
                            arrayList.add(Long.valueOf(parseLong));
                            this.f1630g.add(scanResult);
                            i6++;
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    Collections.sort(arrayList, this.f1628e);
                    if (!e.f1605o.isEmpty() && (a6 = this.f1629f.a(arrayList, e.f1605o)) != null && !a6.isEmpty() && ((int) (((arrayList.size() - a6.size()) / arrayList.size()) * 100.0d)) < e.f1599i) {
                        d();
                        return;
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                a(arrayList);
            }
            this.f1626c.b(this.f1630g);
        } catch (Throwable th) {
            cn.jiguang.an.a.a(this.f1632i, "loc_info_v2", IAdInterListener.AdReqParam.WIDTH, -1);
            cn.jiguang.bb.f.c(f1624b, "" + th);
        }
        this.f1625a = 101;
    }

    private void c() {
        this.f1630g = new ArrayList();
        AnonymousClass1 anonymousClass1 = null;
        this.f1627d = new b(anonymousClass1);
        a aVar = new a(anonymousClass1);
        this.f1628e = aVar;
        this.f1629f = new i<>(aVar);
        this.f1625a = 101;
        this.f1631h = (WifiManager) this.f1632i.getSystemService("wifi");
        ArrayList<Long> arrayList = e.f1605o;
        if (arrayList == null) {
            e.f1605o = new ArrayList<>();
        } else {
            if (arrayList.isEmpty()) {
                return;
            }
            Collections.sort(e.f1605o, this.f1628e);
        }
    }

    private void d() {
        try {
            this.f1630g.clear();
            cn.jiguang.bb.f.c(f1624b, "clearWifiData ");
        } catch (Throwable th) {
            cn.jiguang.bb.f.c(f1624b, "" + th);
        }
    }

    public void a(h hVar) {
        this.f1626c = hVar;
    }

    public j(Context context) {
        this.f1632i = context;
        c();
    }

    public void a(List<Long> list) {
        if (list != null) {
            try {
                if (list.size() <= 0) {
                    return;
                }
                e.f1605o.clear();
                for (int i6 = 0; i6 < list.size(); i6++) {
                    Long l6 = list.get(i6);
                    l6.longValue();
                    e.f1605o.add(l6);
                    list.size();
                }
            } catch (Throwable th) {
                cn.jiguang.bb.f.c(f1624b, "" + th);
            }
        }
    }
}
