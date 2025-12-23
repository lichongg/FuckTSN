package cn.jiguang.aj;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import cn.jiguang.bb.f;
import cn.jiguang.bz.x;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"MissingPermission"})
/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Context f1530a;

    /* renamed from: b, reason: collision with root package name */
    private final TelephonyManager f1531b;

    /* renamed from: c, reason: collision with root package name */
    private List<cn.jiguang.al.d> f1532c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f1533d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f1534e;

    /* renamed from: cn.jiguang.aj.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class a extends PhoneStateListener {
        private a() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            int networkId;
            try {
                super.onSignalStrengthsChanged(signalStrength);
                cn.jiguang.al.d dVar = new cn.jiguang.al.d();
                dVar.f1589j = signalStrength.getGsmSignalStrength();
                CellLocation cellLocation = b.this.f1531b.getCellLocation();
                cn.jiguang.bw.a.a().d(Integer.valueOf(GLMapStaticValue.AM_PARAMETERNAME_TEXT_GL_UNIT));
                if (cellLocation != null) {
                    if (cellLocation instanceof GsmCellLocation) {
                        dVar.f1581b = r5.getCid();
                        networkId = ((GsmCellLocation) cellLocation).getLac();
                    } else {
                        if (cellLocation instanceof CdmaCellLocation) {
                            dVar.f1581b = r5.getBaseStationId();
                            networkId = ((CdmaCellLocation) cellLocation).getNetworkId();
                        }
                        b.this.f1532c.add(dVar);
                        b.this.f1531b.listen(this, 0);
                    }
                    dVar.f1582c = networkId;
                    b.this.f1532c.add(dVar);
                    b.this.f1531b.listen(this, 0);
                }
            } catch (Throwable unused) {
            }
            b.this.f1534e = true;
        }

        /* synthetic */ a(b bVar, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public void c() {
        cn.jiguang.bw.a a6;
        int i6;
        cn.jiguang.al.d a7;
        this.f1534e = false;
        if (this.f1531b == null) {
            f.i("JLocationCell", "get telephonyManager failed");
            a6 = cn.jiguang.bw.a.a();
            i6 = 2047;
        } else {
            this.f1532c = new ArrayList();
            String a8 = x.a(this.f1530a, this.f1533d);
            f.c("JLocationCell", "Network operator: " + a8);
            String b6 = x.b(this.f1530a, this.f1533d);
            f.c("JLocationCell", "Network operator name: " + b6);
            cn.jiguang.bw.a.a().d(Integer.valueOf(GLMapStaticValue.AM_PARAMETERNAME_TEXT_GL_UNIT));
            List<CellInfo> allCellInfo = this.f1531b.getAllCellInfo();
            if (allCellInfo != null && allCellInfo.size() > 0) {
                try {
                    long b7 = cn.jiguang.d.b.b(this.f1530a);
                    for (CellInfo cellInfo : allCellInfo) {
                        if (cellInfo != null && (a7 = cn.jiguang.bz.c.a(cellInfo)) != null) {
                            if (TextUtils.equals(a7.f1585f, a8)) {
                                a7.f1586g = b6;
                            }
                            a7.f1580a = b7;
                            this.f1532c.add(a7);
                        }
                    }
                    f.c("JLocationCell", "Collected cell info size: " + this.f1532c.size());
                    f.c("JLocationCell", "Collected cell info: " + this.f1532c);
                    this.f1534e = true;
                    return;
                } catch (Throwable unused) {
                    this.f1534e = true;
                    return;
                }
            }
            a6 = cn.jiguang.bw.a.a();
            i6 = 2046;
        }
        a6.d(Integer.valueOf(i6));
        this.f1534e = true;
    }

    List<cn.jiguang.al.d> a() {
        return this.f1532c;
    }

    boolean b() {
        return this.f1534e;
    }

    public b(Context context, boolean z5) {
        this.f1530a = context;
        this.f1533d = z5;
        this.f1531b = (TelephonyManager) context.getSystemService("phone");
    }
}
