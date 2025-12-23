package com.bytedance.msdk.core.ae;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.msdk.core.j.j.up;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.m.xt.r;
import com.bytedance.msdk.tl.l;
import com.bytedance.msdk.tl.la;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    private static String cw = "KEY_LOAD_SEQ_TIME";

    /* renamed from: j, reason: collision with root package name */
    private static Comparator<com.bytedance.msdk.xt.cw> f24453j = null;
    private static String xt = "KEY_LOAD_SEQ";

    public static Comparator<com.bytedance.msdk.xt.cw> j() {
        Comparator<com.bytedance.msdk.xt.cw> comparator = f24453j;
        return comparator != null ? comparator : xt();
    }

    public static boolean xt(String str) {
        return true;
    }

    public static Comparator<com.bytedance.msdk.xt.cw> xt() {
        Comparator<com.bytedance.msdk.xt.cw> comparator = new Comparator<com.bytedance.msdk.xt.cw>() { // from class: com.bytedance.msdk.core.ae.cw.1
            @Override // java.util.Comparator
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public int compare(com.bytedance.msdk.xt.cw cwVar, com.bytedance.msdk.xt.cw cwVar2) {
                if (cwVar.t() > cwVar2.t()) {
                    return -1;
                }
                if (cwVar.t() < cwVar2.t()) {
                    return 1;
                }
                if (cwVar.t() == cwVar2.t() && cwVar.pz() == 1) {
                    return -1;
                }
                return 0;
            }
        };
        f24453j = comparator;
        return comparator;
    }

    public static String cw() {
        return UUID.randomUUID().toString();
    }

    public static void j(List<com.bytedance.msdk.xt.cw> list, Comparator<com.bytedance.msdk.xt.cw> comparator) {
        if (comparator == null) {
            la.j(list);
        } else {
            la.j(list, comparator);
        }
    }

    public static int r() {
        long xt2 = l.j((String) null, com.bytedance.msdk.core.xt.getContext()).xt(cw, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        boolean j6 = j(new Date(xt2), new Date(currentTimeMillis));
        l.j((String) null, com.bytedance.msdk.core.xt.getContext()).j(cw, currentTimeMillis);
        int i6 = 0;
        int xt3 = l.j((String) null, com.bytedance.msdk.core.xt.getContext()).xt(xt, 0);
        if (j6) {
            i6 = xt3;
        }
        int i7 = i6 + 1;
        l.j((String) null, com.bytedance.msdk.core.xt.getContext()).j(xt, i7);
        return i7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ca, code lost:
    
        if (r2 == 2) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d5, code lost:
    
        if (r2 != 7) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e0, code lost:
    
        if (r2 == 3) goto L79;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String xt(com.bytedance.msdk.core.oq.oq r14) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.ae.cw.xt(com.bytedance.msdk.core.oq.oq):java.lang.String");
    }

    public static String j(String str, String str2, String str3) {
        if (TextUtils.equals(MediationConstant.ADN_PANGLE, com.bytedance.msdk.xt.j.j(str2)) && com.bytedance.msdk.core.j.qv().uf()) {
            return "com.bytedance.msdk.adapter.panglecustom.".concat(String.format(str, "PangleCustom", str3));
        }
        return "com.bytedance.msdk.adapter." + com.bytedance.msdk.xt.j.j(str2) + "." + String.format(str, str2, str3);
    }

    public static boolean j(oq oqVar) {
        Object apply;
        if (oqVar != null && TextUtils.equals(oqVar.az(), MediationConstant.ADN_PANGLE)) {
            return true;
        }
        if (oqVar != null && up.j(oqVar.az())) {
            return true;
        }
        if (oqVar == null) {
            return false;
        }
        Function<SparseArray<Object>, Object> ae = com.bytedance.msdk.core.qv.j.j().ae();
        if (ae != null) {
            String xt2 = xt(oqVar);
            String xt3 = r.xt(oqVar.az());
            if (TextUtils.isEmpty(xt2)) {
                return false;
            }
            e a6 = e.a();
            a6.g(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, xt2);
            a6.g(8560, xt3);
            a6.e(-99999987, 8229);
            a6.f(-99999985, Boolean.class);
            apply = ae.apply(a6.k().sparseArray());
            return ((Boolean) apply).booleanValue();
        }
        com.bytedance.msdk.j.up.cw.xt(MediationConstant.TAG, "load ad check class loader is null ");
        return false;
    }

    private static boolean xt(String str, com.bytedance.msdk.xt.cw cwVar) {
        if (cwVar == null) {
            return false;
        }
        com.bytedance.msdk.core.oq.xt j6 = com.bytedance.msdk.core.xt.xt().j(str, cwVar.om(), 101);
        return com.bytedance.msdk.core.xt.xt().xt(str, cwVar.om()) && j6 != null && j6.gq() != null && j6.gq().size() > 0 && j6.ch() != null && j6.ch().size() > 0;
    }

    public static String j(String str) {
        return !TextUtils.isEmpty(str) ? str.substring(0, 1).toUpperCase().concat(str.substring(1).toLowerCase()) : str;
    }

    public static oq j(String str, String str2, int i6, int i7) {
        oq oqVar = new oq();
        oqVar.cw(str2);
        oqVar.up(str);
        oqVar.oq(0);
        oqVar.m("0");
        oqVar.xt("1");
        oqVar.qv(i6);
        oqVar.vl(i7);
        oqVar.g(3);
        oqVar.j("%1$s%2$sAdapter");
        return oqVar;
    }

    private static boolean j(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5);
    }

    public static void j(com.bytedance.msdk.api.j jVar, oq oqVar) {
        if (!com.bytedance.msdk.core.xt.xt().nd() || jVar == null || oqVar == null) {
            return;
        }
        if (820001 == jVar.f24334j) {
            com.bytedance.msdk.api.r.j(com.bytedance.msdk.core.xt.getContext(), String.format("error_adn:%1$s no ads，please check ad network", oqVar.i()));
        } else {
            com.bytedance.msdk.api.r.j(com.bytedance.msdk.core.xt.getContext(), String.format("test error_adn:%1$s  error_slot_id: %2$s  error_code:%3$d  error_message:%4$s", oqVar.i(), oqVar.w(), Integer.valueOf(jVar.cw), jVar.f24335r));
        }
    }

    public static void j(String str, oq oqVar, com.bytedance.msdk.xt.cw cwVar) {
        if (com.bytedance.msdk.core.xt.xt().nd() && oqVar != null && xt(str, cwVar)) {
            com.bytedance.msdk.api.r.j(com.bytedance.msdk.core.xt.getContext(), String.format("fill_suceess ,test_adn:%1$s,slot_id : %2$s", oqVar.az(), Integer.valueOf(oqVar.mi())));
        }
    }

    public static void j(String str, com.bytedance.msdk.xt.cw cwVar) {
        if (com.bytedance.msdk.core.xt.xt().nd() && cwVar != null && xt(str, cwVar)) {
            com.bytedance.msdk.api.r.j(com.bytedance.msdk.core.xt.getContext(), String.format("test_suceess ,test_adn:%1$s,slot_id : %2$s", com.bytedance.msdk.xt.j.j(cwVar.pz()), cwVar.qa()));
        }
    }
}
