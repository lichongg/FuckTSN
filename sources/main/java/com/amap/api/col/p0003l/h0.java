package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<OfflineMapProvince> f6394a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private s0 f6395b;

    /* renamed from: c, reason: collision with root package name */
    private Context f6396c;

    private static boolean j(int i6) {
        return i6 == 4;
    }

    private static boolean k(int i6, int i7) {
        return i7 != 1 || i6 <= 2 || i6 >= 98;
    }

    private static boolean l(OfflineMapProvince offlineMapProvince) {
        if (offlineMapProvince == null) {
            return false;
        }
        Iterator<OfflineMapCity> it = offlineMapProvince.getCityList().iterator();
        while (it.hasNext()) {
            if (it.next().getState() != 4) {
                return false;
            }
        }
        return true;
    }

    private static boolean q(int i6) {
        return i6 == 0 || i6 == 2 || i6 == 3 || i6 == 1 || i6 == 102 || i6 == 101 || i6 == 103 || i6 == -1;
    }

    public final OfflineMapCity a(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.f6394a) {
            try {
                Iterator<OfflineMapProvince> it = this.f6394a.iterator();
                while (it.hasNext()) {
                    Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                    while (it2.hasNext()) {
                        OfflineMapCity next = it2.next();
                        if (next.getCode().equals(str)) {
                            return next;
                        }
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final OfflineMapCity m(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.f6394a) {
            try {
                Iterator<OfflineMapProvince> it = this.f6394a.iterator();
                while (it.hasNext()) {
                    Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                    while (it2.hasNext()) {
                        OfflineMapCity next = it2.next();
                        if (next.getCity().trim().equalsIgnoreCase(str.trim())) {
                            return next;
                        }
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final OfflineMapProvince r(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.f6394a) {
            try {
                Iterator<OfflineMapProvince> it = this.f6394a.iterator();
                while (it.hasNext()) {
                    OfflineMapProvince next = it.next();
                    if (next.getProvinceName().trim().equalsIgnoreCase(str.trim())) {
                        return next;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void f(n0 n0Var) {
        s0 s0Var = this.f6395b;
        if (s0Var == null || n0Var == null) {
            return;
        }
        s0Var.e(n0Var);
    }

    private void o(ax axVar) {
        File[] listFiles = new File(b3.f0(this.f6396c)).listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (file.isFile() && file.exists() && file.getName().contains(axVar.getAdcode()) && file.getName().endsWith(".zip.tmp.dt")) {
                file.delete();
            }
        }
    }

    private void p(n0 n0Var) {
        s0 s0Var = this.f6395b;
        if (s0Var != null) {
            s0Var.k(n0Var);
        }
    }

    private void x() {
        ArrayList<OfflineMapProvince> arrayList = this.f6394a;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f6394a.clear();
            }
        }
    }

    public final ArrayList<OfflineMapProvince> b() {
        ArrayList<OfflineMapProvince> arrayList = new ArrayList<>();
        synchronized (this.f6394a) {
            try {
                Iterator<OfflineMapProvince> it = this.f6394a.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public final void i(List<OfflineMapProvince> list) {
        OfflineMapProvince offlineMapProvince;
        OfflineMapCity offlineMapCity;
        synchronized (this.f6394a) {
            try {
                if (this.f6394a.size() > 0) {
                    for (int i6 = 0; i6 < this.f6394a.size(); i6++) {
                        OfflineMapProvince offlineMapProvince2 = this.f6394a.get(i6);
                        Iterator<OfflineMapProvince> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                offlineMapProvince = null;
                                break;
                            }
                            offlineMapProvince = it.next();
                            if (offlineMapProvince2.getPinyin().equals(offlineMapProvince.getPinyin())) {
                                break;
                            }
                            if (!offlineMapProvince2.getPinyin().equals("quanguogaiyaotu") && !offlineMapProvince2.getProvinceCode().equals("000001") && !offlineMapProvince2.getProvinceCode().equals("100000")) {
                            }
                            if (offlineMapProvince.getPinyin().equals("quanguogaiyaotu")) {
                                break;
                            }
                        }
                        if (offlineMapProvince != null) {
                            h(offlineMapProvince2, offlineMapProvince);
                            ArrayList<OfflineMapCity> cityList = offlineMapProvince2.getCityList();
                            ArrayList<OfflineMapCity> cityList2 = offlineMapProvince.getCityList();
                            for (int i7 = 0; i7 < cityList.size(); i7++) {
                                OfflineMapCity offlineMapCity2 = cityList.get(i7);
                                Iterator<OfflineMapCity> it2 = cityList2.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        offlineMapCity = it2.next();
                                        if (offlineMapCity2.getPinyin().equals(offlineMapCity.getPinyin())) {
                                            break;
                                        }
                                    } else {
                                        offlineMapCity = null;
                                        break;
                                    }
                                }
                                if (offlineMapCity != null) {
                                    g(offlineMapCity2, offlineMapCity);
                                }
                            }
                        }
                    }
                } else {
                    Iterator<OfflineMapProvince> it3 = list.iterator();
                    while (it3.hasNext()) {
                        this.f6394a.add(it3.next());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final ArrayList<OfflineMapCity> n() {
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        synchronized (this.f6394a) {
            try {
                Iterator<OfflineMapProvince> it = this.f6394a.iterator();
                while (it.hasNext()) {
                    Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                    while (it2.hasNext()) {
                        arrayList.add(it2.next());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapCity> s() {
        ArrayList<OfflineMapCity> arrayList;
        synchronized (this.f6394a) {
            try {
                arrayList = new ArrayList<>();
                Iterator<OfflineMapProvince> it = this.f6394a.iterator();
                while (it.hasNext()) {
                    OfflineMapProvince next = it.next();
                    if (next != null) {
                        for (OfflineMapCity offlineMapCity : next.getCityList()) {
                            if (offlineMapCity.getState() != 4 && offlineMapCity.getState() != 7) {
                            }
                            arrayList.add(offlineMapCity);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapProvince> t() {
        ArrayList<OfflineMapProvince> arrayList;
        synchronized (this.f6394a) {
            try {
                arrayList = new ArrayList<>();
                Iterator<OfflineMapProvince> it = this.f6394a.iterator();
                while (it.hasNext()) {
                    OfflineMapProvince next = it.next();
                    if (next != null) {
                        if (next.getState() != 4 && next.getState() != 7) {
                        }
                        arrayList.add(next);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapCity> u() {
        ArrayList<OfflineMapCity> arrayList;
        synchronized (this.f6394a) {
            try {
                arrayList = new ArrayList<>();
                Iterator<OfflineMapProvince> it = this.f6394a.iterator();
                while (it.hasNext()) {
                    OfflineMapProvince next = it.next();
                    if (next != null) {
                        for (OfflineMapCity offlineMapCity : next.getCityList()) {
                            if (q(offlineMapCity.getState())) {
                                arrayList.add(offlineMapCity);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapProvince> v() {
        ArrayList<OfflineMapProvince> arrayList;
        synchronized (this.f6394a) {
            try {
                arrayList = new ArrayList<>();
                Iterator<OfflineMapProvince> it = this.f6394a.iterator();
                while (it.hasNext()) {
                    OfflineMapProvince next = it.next();
                    if (next != null && q(next.getState())) {
                        arrayList.add(next);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public h0(Context context) {
        this.f6396c = context;
        this.f6395b = s0.b(context);
    }

    private void d(ax axVar, OfflineMapCity offlineMapCity) {
        int d6 = axVar.s().d();
        if (axVar.s().equals(axVar.f5639f)) {
            p(axVar.G());
        } else {
            if (axVar.s().equals(axVar.f5644k)) {
                axVar.getCity();
                o(axVar);
                axVar.G().n();
            }
            if (k(axVar.getcompleteCode(), axVar.s().d())) {
                f(axVar.G());
            }
        }
        offlineMapCity.setState(d6);
        offlineMapCity.setCompleteCode(axVar.getcompleteCode());
    }

    private void e(ax axVar, OfflineMapProvince offlineMapProvince) {
        n0 n0Var;
        int d6 = axVar.s().d();
        if (d6 == 6) {
            offlineMapProvince.setState(d6);
            offlineMapProvince.setCompleteCode(0);
            p(new n0(offlineMapProvince, this.f6396c));
            try {
                a1.k(offlineMapProvince.getProvinceCode(), this.f6396c);
                return;
            } catch (IOException e6) {
                e6.printStackTrace();
                return;
            } catch (Exception e7) {
                e7.printStackTrace();
                return;
            }
        }
        if (j(d6) && l(offlineMapProvince)) {
            if (axVar.getPinyin().equals(offlineMapProvince.getPinyin())) {
                offlineMapProvince.setState(d6);
                offlineMapProvince.setCompleteCode(axVar.getcompleteCode());
                offlineMapProvince.setVersion(axVar.getVersion());
                offlineMapProvince.setUrl(axVar.getUrl());
                n0Var = new n0(offlineMapProvince, this.f6396c);
                n0Var.m(axVar.l());
                n0Var.d(axVar.getCode());
            } else {
                offlineMapProvince.setState(d6);
                offlineMapProvince.setCompleteCode(100);
                n0Var = new n0(offlineMapProvince, this.f6396c);
            }
            n0Var.n();
            f(n0Var);
            n0Var.a();
        }
    }

    private static void g(OfflineMapCity offlineMapCity, OfflineMapCity offlineMapCity2) {
        offlineMapCity.setUrl(offlineMapCity2.getUrl());
        offlineMapCity.setVersion(offlineMapCity2.getVersion());
        offlineMapCity.setSize(offlineMapCity2.getSize());
        offlineMapCity.setCode(offlineMapCity2.getCode());
        offlineMapCity.setPinyin(offlineMapCity2.getPinyin());
        offlineMapCity.setJianpin(offlineMapCity2.getJianpin());
    }

    private static void h(OfflineMapProvince offlineMapProvince, OfflineMapProvince offlineMapProvince2) {
        offlineMapProvince.setUrl(offlineMapProvince2.getUrl());
        offlineMapProvince.setVersion(offlineMapProvince2.getVersion());
        offlineMapProvince.setSize(offlineMapProvince2.getSize());
        offlineMapProvince.setPinyin(offlineMapProvince2.getPinyin());
        offlineMapProvince.setJianpin(offlineMapProvince2.getJianpin());
    }

    public final void c(ax axVar) {
        String pinyin = axVar.getPinyin();
        synchronized (this.f6394a) {
            try {
                Iterator<OfflineMapProvince> it = this.f6394a.iterator();
                loop0: while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    OfflineMapProvince next = it.next();
                    if (next != null) {
                        for (OfflineMapCity offlineMapCity : next.getCityList()) {
                            if (offlineMapCity.getPinyin().trim().equals(pinyin.trim())) {
                                d(axVar, offlineMapCity);
                                e(axVar, next);
                                break loop0;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void w() {
        x();
        this.f6395b = null;
        this.f6396c = null;
    }
}
