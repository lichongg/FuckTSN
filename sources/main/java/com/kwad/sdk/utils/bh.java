package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class bh {
    private static Context bap;
    private static Map<String, l> baq = new HashMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class b extends l<com.kwad.sdk.l.a.f> {
        @Nullable
        private static com.kwad.sdk.l.a.f dL(Context context) {
            com.kwad.sdk.l.a.f fVar = new com.kwad.sdk.l.a.f();
            fVar.aWR = bd.dx(context);
            fVar.aWQ = bd.dv(context);
            return fVar;
        }

        public b(boolean z5) {
            super(z5);
        }

        @Override // com.kwad.sdk.utils.l
        @Nullable
        protected final /* synthetic */ com.kwad.sdk.l.a.f cD(Context context) {
            return dL(context);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends l<com.kwad.sdk.l.a.b> {
        private static com.kwad.sdk.l.a.b bar;

        @RequiresApi(api = 17)
        @SuppressLint({"BlockedPrivateApi"})
        private static int a(CellInfo cellInfo) {
            if (cellInfo == null) {
                return -1;
            }
            try {
                return ((CellSignalStrength) z.callMethod(cellInfo, "getCellSignalStrength", new Object[0])).getLevel();
            } catch (Throwable unused) {
                return -1;
            }
        }

        public a(boolean z5) {
            super(z5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.utils.l
        /* renamed from: dK, reason: merged with bridge method [inline-methods] */
        public com.kwad.sdk.l.a.b cD(Context context) {
            int i6;
            int i7;
            if (!bc.readLocationDisable() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(64L)) {
                com.kwad.sdk.l.a.b bVar = bar;
                if (bVar != null) {
                    return bVar;
                }
                CellInfo cellInfo = null;
                if (context == null || bc.readLocationDisable()) {
                    return null;
                }
                int i8 = -1;
                if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36047g) == -1) {
                    return null;
                }
                if (br.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f36047g) == 0) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    CellLocation cellLocation = telephonyManager.getCellLocation();
                    if (cellLocation instanceof CdmaCellLocation) {
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                        i7 = cdmaCellLocation.getBaseStationId();
                        i6 = cdmaCellLocation.getNetworkId();
                    } else if (cellLocation instanceof GsmCellLocation) {
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                        i7 = gsmCellLocation.getCid();
                        i6 = gsmCellLocation.getLac();
                    } else {
                        i6 = -1;
                        i7 = -1;
                    }
                    Iterator<CellInfo> it = telephonyManager.getAllCellInfo().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        CellInfo next = it.next();
                        if (next != null && next.isRegistered()) {
                            cellInfo = next;
                            break;
                        }
                    }
                    if (cellInfo != null) {
                        i8 = a(cellInfo);
                    }
                    bar = new com.kwad.sdk.l.a.b(i7, i6, i8);
                }
                return bar;
            }
            return bar;
        }
    }

    private static boolean Rw() {
        return bap != null;
    }

    @Nullable
    private static <T> l<T> hk(String str) {
        try {
            return baq.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            com.kwad.sdk.core.d.c.d("SensitiveInfoCollectors", "init sdkConfigProvider is null");
            return;
        }
        if (!Rw()) {
            bap = StubApp.getOrigApplicationContext(context.getApplicationContext());
            baq.put("baseStationEnable", new a(hVar.Bx()));
            baq.put("simCardInfoEnable", new b(hVar.Bv()));
            return;
        }
        if (baq.containsKey("baseStationEnable")) {
            boolean Bx = hVar.Bx();
            l hk = hk("baseStationEnable");
            if (hk != null) {
                hk.ca(Bx);
            }
        }
        if (baq.containsKey("simCardInfoEnable")) {
            boolean Bv = hVar.Bv();
            l hk2 = hk("simCardInfoEnable");
            if (hk2 != null) {
                hk2.ca(Bv);
            }
        }
    }

    @Nullable
    public static com.kwad.sdk.l.a.b OO() {
        if (!Rw()) {
            return null;
        }
        return (com.kwad.sdk.l.a.b) hl("baseStationEnable");
    }

    @Nullable
    public static com.kwad.sdk.l.a.f OP() {
        if (!Rw()) {
            return null;
        }
        return (com.kwad.sdk.l.a.f) hl("simCardInfoEnable");
    }

    @Nullable
    private static <T> T hl(String str) {
        l hk = hk(str);
        if (hk != null) {
            return (T) hk.cC(bap);
        }
        return null;
    }
}
