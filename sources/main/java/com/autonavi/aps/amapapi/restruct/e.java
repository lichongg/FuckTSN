package com.autonavi.aps.amapapi.restruct;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import cn.jiguang.bz.o0;
import cn.jiguang.bz.y0;
import com.amap.api.col.p0003l.a8;
import com.amap.api.col.p0003l.ko;
import com.amap.api.col.p0003l.kp;
import com.amap.api.col.p0003l.kq;
import com.amap.api.col.p0003l.kr;
import com.amap.api.col.p0003l.ks;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.common.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"NewApi"})
/* loaded from: D:\Downloads\app\classes2.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    TelephonyManager f10050b;

    /* renamed from: d, reason: collision with root package name */
    SignalStrength f10052d;

    /* renamed from: h, reason: collision with root package name */
    private Context f10056h;

    /* renamed from: m, reason: collision with root package name */
    private c f10061m;

    /* renamed from: q, reason: collision with root package name */
    @SuppressLint({"NewApi"})
    private TelephonyManager.CellInfoCallback f10065q;

    /* renamed from: w, reason: collision with root package name */
    private com.autonavi.aps.amapapi.c f10071w;

    /* renamed from: i, reason: collision with root package name */
    private boolean f10057i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f10058j = false;

    /* renamed from: a, reason: collision with root package name */
    ArrayList<d> f10049a = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    private String f10059k = null;

    /* renamed from: l, reason: collision with root package name */
    private ArrayList<d> f10060l = new ArrayList<>();

    /* renamed from: n, reason: collision with root package name */
    private long f10062n = 0;

    /* renamed from: c, reason: collision with root package name */
    PhoneStateListener f10051c = null;

    /* renamed from: o, reason: collision with root package name */
    private boolean f10063o = false;

    /* renamed from: p, reason: collision with root package name */
    private Object f10064p = new Object();

    /* renamed from: r, reason: collision with root package name */
    private boolean f10066r = false;

    /* renamed from: e, reason: collision with root package name */
    boolean f10053e = false;

    /* renamed from: f, reason: collision with root package name */
    StringBuilder f10054f = null;

    /* renamed from: s, reason: collision with root package name */
    private String f10067s = null;

    /* renamed from: t, reason: collision with root package name */
    private String f10068t = null;

    /* renamed from: g, reason: collision with root package name */
    String f10055g = null;

    /* renamed from: u, reason: collision with root package name */
    private volatile boolean f10069u = true;

    /* renamed from: v, reason: collision with root package name */
    private volatile boolean f10070v = true;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SuppressLint({"NewApi"})
    class a extends TelephonyManager.CellInfoCallback {
        a() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public final void onCellInfo(List<CellInfo> list) {
            try {
                com.autonavi.aps.amapapi.utils.d.a();
                StringBuilder sb = new StringBuilder("noLocReqCgiEnable:");
                sb.append(e.this.f10070v);
                sb.append(" isStartLocation:");
                sb.append(e.this.f10069u);
                com.autonavi.aps.amapapi.utils.d.a();
                if ((!e.this.f10070v && !e.this.f10069u) || com.autonavi.aps.amapapi.utils.j.b() - e.this.f10062n < 500) {
                    return;
                }
                e.d(e.this);
                e.this.a(e.this.u());
                e.this.a(list);
                e.this.f10062n = com.autonavi.aps.amapapi.utils.j.b();
            } catch (SecurityException e6) {
                e.this.f10055g = e6.getMessage();
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "Cgi", "cellInfo");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends PhoneStateListener {
        b() {
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellInfoChanged(List<CellInfo> list) {
            try {
                com.autonavi.aps.amapapi.utils.d.a();
                StringBuilder sb = new StringBuilder("noLocReqCgiEnable:");
                sb.append(e.this.f10070v);
                sb.append(" isStartLocation:");
                sb.append(e.this.f10069u);
                com.autonavi.aps.amapapi.utils.d.a();
                if (e.this.f10070v || e.this.f10069u) {
                    if (e.this.f10071w != null) {
                        e.this.f10071w.c();
                    }
                    if (com.autonavi.aps.amapapi.utils.j.b() - e.this.f10062n >= 500) {
                        e.this.a(e.this.u());
                        e.this.a(list);
                        e.this.f10062n = com.autonavi.aps.amapapi.utils.j.b();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellLocationChanged(CellLocation cellLocation) {
            com.autonavi.aps.amapapi.utils.d.a();
            StringBuilder sb = new StringBuilder("noLocReqCgiEnable:");
            sb.append(e.this.f10070v);
            sb.append(" isStartLocation:");
            sb.append(e.this.f10069u);
            com.autonavi.aps.amapapi.utils.d.a();
            if ((e.this.f10070v || e.this.f10069u) && com.autonavi.aps.amapapi.utils.j.b() - e.this.f10062n >= 500) {
                try {
                    e.this.a(cellLocation);
                    e.this.a(e.this.v());
                    e.this.f10062n = com.autonavi.aps.amapapi.utils.j.b();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onDataConnectionStateChanged(int i6) {
            super.onDataConnectionStateChanged(i6);
            com.autonavi.aps.amapapi.utils.d.a();
        }

        @Override // android.telephony.PhoneStateListener
        public final void onServiceStateChanged(ServiceState serviceState) {
            try {
                com.autonavi.aps.amapapi.utils.d.a();
                StringBuilder sb = new StringBuilder("noLocReqCgiEnable:");
                sb.append(e.this.f10070v);
                sb.append(" isStartLocation:");
                sb.append(e.this.f10069u);
                com.autonavi.aps.amapapi.utils.d.a();
                if (e.this.f10070v || e.this.f10069u) {
                    int state = serviceState.getState();
                    if (state != 0) {
                        if (state == 1) {
                            e.this.j();
                            return;
                        }
                        return;
                    }
                    e.this.a(false, false);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthChanged(int i6) {
            super.onSignalStrengthChanged(i6);
            com.autonavi.aps.amapapi.utils.d.a();
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
            com.autonavi.aps.amapapi.utils.d.a();
            StringBuilder sb = new StringBuilder("noLocReqCgiEnable:");
            sb.append(e.this.f10070v);
            sb.append(" isStartLocation:");
            sb.append(e.this.f10069u);
            com.autonavi.aps.amapapi.utils.d.a();
            if (signalStrength != null) {
                e eVar = e.this;
                eVar.f10052d = signalStrength;
                if (eVar.f10070v || e.this.f10069u) {
                    try {
                        if (e.this.f10071w != null) {
                            e.this.f10071w.c();
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public static boolean a(int i6) {
        return i6 > 0 && i6 <= 15;
    }

    private static int b(int i6) {
        return (i6 * 2) - 113;
    }

    static /* synthetic */ boolean d(e eVar) {
        eVar.f10066r = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public List<CellInfo> v() {
        List<CellInfo> list;
        try {
            if (com.autonavi.aps.amapapi.utils.j.c() < 18 || this.f10050b == null) {
                return null;
            }
            try {
                list = s();
            } catch (SecurityException e6) {
                e = e6;
                list = null;
            }
            try {
                this.f10055g = null;
                return list;
            } catch (SecurityException e7) {
                e = e7;
                this.f10055g = e.getMessage();
                return list;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Cgi", "getNewCells");
            return null;
        }
    }

    final synchronized void j() {
        this.f10055g = null;
        this.f10049a.clear();
        this.f10060l.clear();
        this.f10057i = false;
        this.f10058j = false;
    }

    public final synchronized String m() {
        try {
            if (this.f10053e) {
                j();
            }
            StringBuilder sb = this.f10054f;
            if (sb == null) {
                this.f10054f = new StringBuilder();
            } else {
                sb.delete(0, sb.length());
            }
            if (h() == 1) {
                for (int i6 = 1; i6 < this.f10049a.size(); i6++) {
                    StringBuilder sb2 = this.f10054f;
                    sb2.append("#");
                    sb2.append(this.f10049a.get(i6).f10030b);
                    StringBuilder sb3 = this.f10054f;
                    sb3.append(Logger.f33116c);
                    sb3.append(this.f10049a.get(i6).f10031c);
                    StringBuilder sb4 = this.f10054f;
                    sb4.append(Logger.f33116c);
                    sb4.append(this.f10049a.get(i6).f10032d);
                }
            }
            for (int i7 = 1; i7 < this.f10060l.size(); i7++) {
                d dVar = this.f10060l.get(i7);
                int i8 = dVar.f10040l;
                if (i8 != 1 && i8 != 3 && i8 != 4 && i8 != 5) {
                    if (i8 == 2) {
                        StringBuilder sb5 = this.f10054f;
                        sb5.append("#");
                        sb5.append(dVar.f10040l);
                        StringBuilder sb6 = this.f10054f;
                        sb6.append(Logger.f33116c);
                        sb6.append(dVar.f10029a);
                        StringBuilder sb7 = this.f10054f;
                        sb7.append(Logger.f33116c);
                        sb7.append(dVar.f10036h);
                        StringBuilder sb8 = this.f10054f;
                        sb8.append(Logger.f33116c);
                        sb8.append(dVar.f10037i);
                        StringBuilder sb9 = this.f10054f;
                        sb9.append(Logger.f33116c);
                        sb9.append(dVar.f10038j);
                    }
                }
                StringBuilder sb10 = this.f10054f;
                sb10.append("#");
                sb10.append(dVar.f10040l);
                StringBuilder sb11 = this.f10054f;
                sb11.append(Logger.f33116c);
                sb11.append(dVar.f10029a);
                StringBuilder sb12 = this.f10054f;
                sb12.append(Logger.f33116c);
                sb12.append(dVar.f10030b);
                StringBuilder sb13 = this.f10054f;
                sb13.append(Logger.f33116c);
                sb13.append(dVar.f10031c);
                StringBuilder sb14 = this.f10054f;
                sb14.append(Logger.f33116c);
                sb14.append(dVar.a());
            }
            if (this.f10054f.length() > 0) {
                this.f10054f.deleteCharAt(0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f10054f.toString();
    }

    public final boolean n() {
        try {
            TelephonyManager telephonyManager = this.f10050b;
            if (telephonyManager != null) {
                if (!TextUtils.isEmpty(telephonyManager.getSimOperator())) {
                    return true;
                }
                if (!TextUtils.isEmpty(this.f10050b.getSimCountryIso())) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            int a6 = com.autonavi.aps.amapapi.utils.j.a(com.autonavi.aps.amapapi.utils.j.c(this.f10056h));
            return a6 == 0 || a6 == 4 || a6 == 2 || a6 == 5 || a6 == 3;
        } catch (Throwable unused2) {
            return false;
        }
    }

    private void o() {
        if (this.f10050b == null) {
            return;
        }
        p();
    }

    private void p() {
        int checkSelfPermission;
        int checkSelfPermission2;
        int checkSelfPermission3;
        try {
            if (this.f10051c == null) {
                this.f10051c = new b();
            }
            int i6 = Build.VERSION.SDK_INT;
            int i7 = MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME;
            if (i6 >= 31) {
                checkSelfPermission3 = this.f10056h.checkSelfPermission(com.kuaishou.weapon.p0.g.f36047g);
                if (checkSelfPermission3 == 0) {
                    this.f10068t = "hasFineLocPerm";
                    com.autonavi.aps.amapapi.utils.d.b();
                } else {
                    this.f10068t = "hasNoFineLocPerm";
                    com.autonavi.aps.amapapi.utils.d.b();
                    i7 = 320;
                }
            } else {
                com.autonavi.aps.amapapi.utils.d.b();
            }
            if (i6 >= 31) {
                checkSelfPermission = this.f10056h.checkSelfPermission(com.kuaishou.weapon.p0.g.f36043c);
                boolean z5 = checkSelfPermission == 0;
                checkSelfPermission2 = this.f10056h.checkSelfPermission(com.kuaishou.weapon.p0.g.f36047g);
                boolean z6 = checkSelfPermission2 == 0;
                if (z5 && z6) {
                    i7 |= 1024;
                }
                com.autonavi.aps.amapapi.utils.d.b();
                this.f10067s = z5 ? "hasReadPhoneStatePerm" : "hasNoReadPhoneStatePerm";
                this.f10068t = z6 ? "hasFineLocPerm" : "hasNoFineLocPerm";
                com.autonavi.aps.amapapi.utils.d.b();
            } else {
                com.autonavi.aps.amapapi.utils.d.b();
                i7 |= 1024;
            }
            PhoneStateListener phoneStateListener = this.f10051c;
            if (phoneStateListener != null) {
                this.f10050b.listen(phoneStateListener, i7);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private CellLocation r() {
        TelephonyManager telephonyManager = this.f10050b;
        if (telephonyManager != null) {
            try {
                CellLocation cellLocation = telephonyManager.getCellLocation();
                com.autonavi.aps.amapapi.utils.d.a();
                this.f10055g = null;
                return cellLocation;
            } catch (SecurityException e6) {
                this.f10055g = e6.getMessage();
            } catch (Throwable th) {
                this.f10055g = null;
                com.autonavi.aps.amapapi.utils.b.a(th, "CgiManager", "getCellLocation");
            }
        }
        return null;
    }

    private List<CellInfo> s() {
        TelephonyManager telephonyManager = this.f10050b;
        if (telephonyManager == null) {
            return null;
        }
        List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
        com.autonavi.aps.amapapi.utils.d.a();
        return allCellInfo;
    }

    private boolean t() {
        return !this.f10053e && com.autonavi.aps.amapapi.utils.j.b() - this.f10062n >= 45000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellLocation u() {
        if (this.f10050b == null) {
            return null;
        }
        return r();
    }

    public final synchronized ArrayList<d> c() {
        ArrayList<d> arrayList;
        arrayList = new ArrayList<>();
        ArrayList<d> arrayList2 = this.f10049a;
        if (arrayList2 != null) {
            Iterator<d> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().clone());
            }
        }
        return arrayList;
    }

    public final synchronized ArrayList<d> d() {
        ArrayList<d> arrayList;
        arrayList = new ArrayList<>();
        ArrayList<d> arrayList2 = this.f10060l;
        if (arrayList2 != null) {
            Iterator<d> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().clone());
            }
        }
        return arrayList;
    }

    public final synchronized d e() {
        if (this.f10053e) {
            return null;
        }
        ArrayList<d> arrayList = this.f10049a;
        if (arrayList.size() <= 0) {
            return null;
        }
        return arrayList.get(0).clone();
    }

    public final synchronized d f() {
        if (this.f10053e) {
            return null;
        }
        ArrayList<d> arrayList = this.f10060l;
        if (arrayList.size() <= 0) {
            return null;
        }
        Iterator<d> it = arrayList.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.f10042n) {
                return next.clone();
            }
        }
        return arrayList.get(0).clone();
    }

    public final int g() {
        return q() | (this.f10057i ? 4 : 0) | (this.f10058j ? 8 : 0);
    }

    public final TelephonyManager i() {
        return this.f10050b;
    }

    public final String k() {
        return this.f10055g;
    }

    public final String l() {
        return this.f10059k;
    }

    public e(Context context, Handler handler) {
        this.f10050b = null;
        this.f10061m = null;
        this.f10056h = context;
        if (this.f10050b == null) {
            this.f10050b = (TelephonyManager) com.autonavi.aps.amapapi.utils.j.a(context, "phone");
        }
        o();
        c cVar = new c(context, "cellAge", handler);
        this.f10061m = cVar;
        cVar.a();
    }

    private int q() {
        d e6 = e();
        if (e6 != null) {
            return e6.f10040l;
        }
        return 0;
    }

    public final void b() {
        int checkSelfPermission;
        String str;
        int checkSelfPermission2;
        String str2;
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                checkSelfPermission = this.f10056h.checkSelfPermission(com.kuaishou.weapon.p0.g.f36047g);
                if (checkSelfPermission == 0) {
                    str = "hasFineLocPerm";
                } else {
                    str = "hasNoFineLocPerm";
                }
                checkSelfPermission2 = this.f10056h.checkSelfPermission(com.kuaishou.weapon.p0.g.f36043c);
                if (checkSelfPermission2 == 0) {
                    str2 = "hasReadPhoneStatePerm";
                } else {
                    str2 = "hasNoReadPhoneStatePerm";
                }
                boolean z5 = true;
                boolean z6 = (TextUtils.isEmpty(this.f10068t) || this.f10068t.equals(str)) ? false : true;
                if (TextUtils.isEmpty(this.f10067s) || this.f10067s.equals(str2)) {
                    z5 = z6;
                }
                if (z5) {
                    com.autonavi.aps.amapapi.utils.d.b();
                    p();
                }
            }
        } catch (Throwable unused) {
            com.autonavi.aps.amapapi.utils.d.b();
        }
    }

    public final int h() {
        return q() & 3;
    }

    public final List<ko> a() {
        int arfcn;
        int bsic;
        int earfcn;
        int uarfcn;
        ArrayList arrayList = new ArrayList();
        List<CellInfo> s5 = s();
        if (s5 != null) {
            for (CellInfo cellInfo : s5) {
                if (cellInfo instanceof CellInfoCdma) {
                    CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                    CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                    kp kpVar = new kp(cellInfo.isRegistered(), true);
                    kpVar.f6711m = cellIdentity.getLatitude();
                    kpVar.f6712n = cellIdentity.getLongitude();
                    kpVar.f6708j = cellIdentity.getSystemId();
                    kpVar.f6709k = cellIdentity.getNetworkId();
                    kpVar.f6710l = cellIdentity.getBasestationId();
                    kpVar.f6702d = cellInfoCdma.getCellSignalStrength().getAsuLevel();
                    kpVar.f6701c = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                    arrayList.add(kpVar);
                } else if (cellInfo instanceof CellInfoGsm) {
                    CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                    CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                    kq kqVar = new kq(cellInfo.isRegistered(), true);
                    kqVar.f6699a = String.valueOf(cellIdentity2.getMcc());
                    kqVar.f6700b = String.valueOf(cellIdentity2.getMnc());
                    kqVar.f6713j = cellIdentity2.getLac();
                    kqVar.f6714k = cellIdentity2.getCid();
                    kqVar.f6701c = cellInfoGsm.getCellSignalStrength().getDbm();
                    kqVar.f6702d = cellInfoGsm.getCellSignalStrength().getAsuLevel();
                    if (Build.VERSION.SDK_INT >= 24) {
                        arfcn = cellIdentity2.getArfcn();
                        kqVar.f6716m = arfcn;
                        bsic = cellIdentity2.getBsic();
                        kqVar.f6717n = bsic;
                    }
                    arrayList.add(kqVar);
                } else if (cellInfo instanceof CellInfoLte) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                    kr krVar = new kr(cellInfo.isRegistered());
                    krVar.f6699a = String.valueOf(cellIdentity3.getMcc());
                    krVar.f6700b = String.valueOf(cellIdentity3.getMnc());
                    krVar.f6721l = cellIdentity3.getPci();
                    krVar.f6702d = cellInfoLte.getCellSignalStrength().getAsuLevel();
                    krVar.f6720k = cellIdentity3.getCi();
                    krVar.f6719j = cellIdentity3.getTac();
                    krVar.f6723n = cellInfoLte.getCellSignalStrength().getTimingAdvance();
                    krVar.f6701c = cellInfoLte.getCellSignalStrength().getDbm();
                    if (Build.VERSION.SDK_INT >= 24) {
                        earfcn = cellIdentity3.getEarfcn();
                        krVar.f6722m = earfcn;
                    }
                    arrayList.add(krVar);
                } else {
                    int i6 = Build.VERSION.SDK_INT;
                    if (cellInfo instanceof CellInfoWcdma) {
                        CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                        CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                        ks ksVar = new ks(cellInfo.isRegistered(), true);
                        ksVar.f6699a = String.valueOf(cellIdentity4.getMcc());
                        ksVar.f6700b = String.valueOf(cellIdentity4.getMnc());
                        ksVar.f6724j = cellIdentity4.getLac();
                        ksVar.f6725k = cellIdentity4.getCid();
                        ksVar.f6726l = cellIdentity4.getPsc();
                        ksVar.f6702d = cellInfoWcdma.getCellSignalStrength().getAsuLevel();
                        ksVar.f6701c = cellInfoWcdma.getCellSignalStrength().getDbm();
                        if (i6 >= 24) {
                            uarfcn = cellIdentity4.getUarfcn();
                            ksVar.f6727m = uarfcn;
                        }
                        arrayList.add(ksVar);
                    }
                }
            }
        }
        return arrayList;
    }

    public final void c(boolean z5) {
        this.f10070v = z5;
    }

    public final void b(boolean z5) {
        this.f10069u = z5;
    }

    @SuppressLint({"NewApi"})
    private void b(boolean z5, boolean z6) {
        if (!this.f10053e && this.f10050b != null && Build.VERSION.SDK_INT >= 29 && this.f10056h.getApplicationInfo().targetSdkVersion >= 29) {
            if (this.f10065q == null) {
                this.f10065q = new a();
            }
            try {
                this.f10050b.requestCellInfoUpdate(a8.h().f(), this.f10065q);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "Cgi", "refreshCgi");
            }
            if (z6 || z5) {
                for (int i6 = 0; !this.f10066r && i6 < 20; i6++) {
                    try {
                        Thread.sleep(5L);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        this.f10058j = false;
        TelephonyManager telephonyManager = this.f10050b;
        if (telephonyManager != null) {
            String networkOperator = telephonyManager.getNetworkOperator();
            this.f10059k = networkOperator;
            if (!TextUtils.isEmpty(networkOperator)) {
                this.f10058j = true;
            }
        }
        this.f10062n = com.autonavi.aps.amapapi.utils.j.b();
    }

    public final void a(boolean z5, boolean z6) {
        try {
            this.f10053e = com.autonavi.aps.amapapi.utils.j.a(this.f10056h);
            if (t()) {
                b(z5, z6);
                a(u());
                a(v());
            }
            if (this.f10053e) {
                j();
            }
        } catch (SecurityException e6) {
            this.f10055g = e6.getMessage();
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "CgiManager", "refresh");
        }
    }

    public final void a(boolean z5) {
        PhoneStateListener phoneStateListener;
        this.f10061m.a(z5);
        this.f10062n = 0L;
        synchronized (this.f10064p) {
            this.f10063o = true;
        }
        TelephonyManager telephonyManager = this.f10050b;
        if (telephonyManager != null && (phoneStateListener = this.f10051c) != null) {
            try {
                telephonyManager.listen(phoneStateListener, 0);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "CgiManager", "destroy");
            }
        }
        this.f10051c = null;
        this.f10052d = null;
        this.f10050b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(CellLocation cellLocation) {
        try {
            String[] a6 = com.autonavi.aps.amapapi.utils.j.a(this.f10050b);
            this.f10049a.clear();
            if (cellLocation instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                d dVar = new d(1, true);
                dVar.f10029a = com.autonavi.aps.amapapi.utils.j.e(a6[0]);
                dVar.f10030b = com.autonavi.aps.amapapi.utils.j.e(a6[1]);
                dVar.f10031c = gsmCellLocation.getLac();
                dVar.f10032d = gsmCellLocation.getCid();
                SignalStrength signalStrength = this.f10052d;
                if (signalStrength != null) {
                    int gsmSignalStrength = signalStrength.getGsmSignalStrength();
                    dVar.f10047s = gsmSignalStrength == 99 ? Integer.MAX_VALUE : b(gsmSignalStrength);
                }
                dVar.f10046r = false;
                this.f10061m.a((c) dVar);
                this.f10049a.add(dVar);
                return;
            }
            if (cellLocation instanceof CdmaCellLocation) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                d dVar2 = new d(2, true);
                dVar2.f10029a = Integer.parseInt(a6[0]);
                dVar2.f10030b = Integer.parseInt(a6[1]);
                dVar2.f10034f = cdmaCellLocation.getBaseStationLatitude();
                dVar2.f10035g = cdmaCellLocation.getBaseStationLongitude();
                dVar2.f10036h = cdmaCellLocation.getSystemId();
                dVar2.f10037i = cdmaCellLocation.getNetworkId();
                dVar2.f10038j = cdmaCellLocation.getBaseStationId();
                SignalStrength signalStrength2 = this.f10052d;
                if (signalStrength2 != null) {
                    dVar2.f10047s = signalStrength2.getCdmaDbm();
                }
                dVar2.f10046r = false;
                this.f10061m.a((c) dVar2);
                this.f10049a.add(dVar2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    final synchronized void a(List<CellInfo> list) {
        d a6;
        try {
            ArrayList<d> arrayList = this.f10060l;
            if (arrayList != null) {
                arrayList.clear();
            }
            if (list != null && list.size() > 0) {
                for (int i6 = 0; i6 < list.size(); i6++) {
                    CellInfo cellInfo = list.get(i6);
                    if (cellInfo != null) {
                        boolean isRegistered = cellInfo.isRegistered();
                        if (cellInfo instanceof CellInfoCdma) {
                            a6 = a((CellInfoCdma) cellInfo, isRegistered);
                        } else if (cellInfo instanceof CellInfoGsm) {
                            a6 = a((CellInfoGsm) cellInfo, isRegistered);
                        } else if (cellInfo instanceof CellInfoWcdma) {
                            a6 = a((CellInfoWcdma) cellInfo, isRegistered);
                        } else if (cellInfo instanceof CellInfoLte) {
                            a6 = a((CellInfoLte) cellInfo, isRegistered);
                        } else {
                            a6 = (Build.VERSION.SDK_INT < 29 || !o0.a(cellInfo)) ? null : a(y0.a(cellInfo), isRegistered);
                        }
                        if (a6 != null) {
                            this.f10061m.a((c) a6);
                            a6.f10041m = (short) Math.min(WebSocketProtocol.PAYLOAD_SHORT_MAX, this.f10061m.e((c) a6));
                            a6.f10046r = true;
                            this.f10060l.add(a6);
                        }
                    }
                }
                this.f10057i = false;
                ArrayList<d> arrayList2 = this.f10060l;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    this.f10057i = true;
                }
            }
        } finally {
        }
    }

    @SuppressLint({"NewApi"})
    private static d a(CellInfoGsm cellInfoGsm, boolean z5) {
        int bsic;
        int arfcn;
        int timingAdvance;
        if (cellInfoGsm == null || cellInfoGsm.getCellIdentity() == null) {
            return null;
        }
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        d a6 = a(1, z5, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
        bsic = cellInfoGsm.getCellIdentity().getBsic();
        a6.f10043o = bsic;
        arfcn = cellInfoGsm.getCellIdentity().getArfcn();
        a6.f10044p = arfcn;
        timingAdvance = cellInfoGsm.getCellSignalStrength().getTimingAdvance();
        a6.f10045q = timingAdvance;
        a6.f10047s = cellInfoGsm.getCellSignalStrength().getDbm();
        return a6;
    }

    private static d a(CellInfoWcdma cellInfoWcdma, boolean z5) {
        int uarfcn;
        if (cellInfoWcdma == null || cellInfoWcdma.getCellIdentity() == null) {
            return null;
        }
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        d a6 = a(4, z5, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
        a6.f10043o = cellIdentity.getPsc();
        uarfcn = cellInfoWcdma.getCellIdentity().getUarfcn();
        a6.f10044p = uarfcn;
        a6.f10047s = cellInfoWcdma.getCellSignalStrength().getDbm();
        return a6;
    }

    private static d a(CellInfoLte cellInfoLte, boolean z5) {
        int earfcn;
        if (cellInfoLte == null || cellInfoLte.getCellIdentity() == null) {
            return null;
        }
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        d a6 = a(3, z5, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getTac(), cellIdentity.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
        a6.f10043o = cellIdentity.getPci();
        if (Build.VERSION.SDK_INT >= 24) {
            earfcn = cellIdentity.getEarfcn();
            a6.f10044p = earfcn;
        }
        a6.f10045q = cellInfoLte.getCellSignalStrength().getTimingAdvance();
        a6.f10047s = cellInfoLte.getCellSignalStrength().getDbm();
        return a6;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.autonavi.aps.amapapi.restruct.d a(android.telephony.CellInfoNr r14, boolean r15) {
        /*
            if (r14 == 0) goto L97
            android.telephony.CellIdentity r0 = cn.jiguang.bz.a1.a(r14)
            if (r0 != 0) goto La
            goto L97
        La:
            android.telephony.CellIdentity r0 = cn.jiguang.bz.a1.a(r14)
            android.telephony.CellIdentityNr r1 = cn.jiguang.bz.b1.a(r0)
            int r2 = cn.jiguang.bz.d1.a(r1)
            r0 = 2147483647(0x7fffffff, float:NaN)
            r3 = 0
            if (r2 != r0) goto L33
            java.lang.String r0 = "HUAWEI"
            java.lang.String r4 = android.os.Build.MANUFACTURER
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L33
            java.lang.String r0 = "getHwTac"
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L2f
            int r2 = com.autonavi.aps.amapapi.utils.f.b(r1, r0, r4)     // Catch: java.lang.Throwable -> L2f
            goto L33
        L2f:
            r0 = move-exception
            r0.printStackTrace()
        L33:
            long r4 = cn.jiguang.bz.c1.a(r1)
            java.lang.String r0 = cn.jiguang.bz.e1.a(r1)     // Catch: java.lang.Throwable -> L4c
            int r6 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r0 = cn.jiguang.bz.f1.a(r1)     // Catch: java.lang.Throwable -> L4a
            int r3 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L4a
            r10 = r3
        L48:
            r9 = r6
            goto L53
        L4a:
            r0 = move-exception
            goto L4e
        L4c:
            r0 = move-exception
            r6 = 0
        L4e:
            r0.printStackTrace()
            r10 = 0
            goto L48
        L53:
            android.telephony.CellSignalStrength r0 = cn.jiguang.bz.z0.a(r14)
            android.telephony.CellSignalStrengthNr r0 = com.autonavi.aps.amapapi.restruct.t.a(r0)
            int r13 = com.autonavi.aps.amapapi.restruct.u.a(r0)
            int r11 = cn.jiguang.bz.d1.a(r1)
            r12 = 0
            r7 = 5
            r8 = r15
            com.autonavi.aps.amapapi.restruct.d r15 = a(r7, r8, r9, r10, r11, r12, r13)
            r15.f10033e = r4
            r0 = 16777215(0xffffff, float:2.3509886E-38)
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r2 <= r0) goto L77
            r15.f10031c = r3
            goto L80
        L77:
            if (r2 <= r3) goto L7e
            r15.f10031c = r3
            r15.f10045q = r2
            goto L80
        L7e:
            r15.f10031c = r2
        L80:
            int r0 = com.autonavi.aps.amapapi.restruct.r.a(r1)
            r15.f10043o = r0
            int r0 = com.autonavi.aps.amapapi.restruct.s.a(r1)
            r15.f10044p = r0
            android.telephony.CellSignalStrength r14 = cn.jiguang.bz.z0.a(r14)
            int r14 = r14.getDbm()
            r15.f10047s = r14
            return r15
        L97:
            r14 = 0
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.restruct.e.a(android.telephony.CellInfoNr, boolean):com.autonavi.aps.amapapi.restruct.d");
    }

    private d a(CellInfoCdma cellInfoCdma, boolean z5) {
        int i6;
        int i7;
        if (cellInfoCdma != null && cellInfoCdma.getCellIdentity() != null) {
            CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
            if (cellIdentity.getSystemId() > 0 && cellIdentity.getNetworkId() >= 0 && cellIdentity.getBasestationId() >= 0) {
                CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                String[] a6 = com.autonavi.aps.amapapi.utils.j.a(this.f10050b);
                try {
                    i6 = Integer.parseInt(a6[0]);
                    try {
                        i7 = Integer.parseInt(a6[1]);
                    } catch (Throwable unused) {
                        i7 = 0;
                        d a7 = a(2, z5, i6, i7, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                        a7.f10036h = cellIdentity2.getSystemId();
                        a7.f10037i = cellIdentity2.getNetworkId();
                        a7.f10038j = cellIdentity2.getBasestationId();
                        a7.f10034f = cellIdentity2.getLatitude();
                        a7.f10035g = cellIdentity2.getLongitude();
                        a7.f10047s = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                        return a7;
                    }
                } catch (Throwable unused2) {
                    i6 = 0;
                }
                d a72 = a(2, z5, i6, i7, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                a72.f10036h = cellIdentity2.getSystemId();
                a72.f10037i = cellIdentity2.getNetworkId();
                a72.f10038j = cellIdentity2.getBasestationId();
                a72.f10034f = cellIdentity2.getLatitude();
                a72.f10035g = cellIdentity2.getLongitude();
                a72.f10047s = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                return a72;
            }
        }
        return null;
    }

    private static d a(int i6, boolean z5, int i7, int i8, int i9, int i10, int i11) {
        d dVar = new d(i6, z5);
        dVar.f10029a = i7;
        dVar.f10030b = i8;
        dVar.f10031c = i9;
        dVar.f10032d = i10;
        dVar.f10039k = i11;
        return dVar;
    }

    public final void a(com.autonavi.aps.amapapi.c cVar) {
        this.f10071w = cVar;
    }
}
