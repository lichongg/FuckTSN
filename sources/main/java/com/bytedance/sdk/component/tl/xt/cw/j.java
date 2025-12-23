package com.bytedance.sdk.component.tl.xt.cw;

import android.text.TextUtils;
import com.bytedance.sdk.component.tl.j.r;
import com.bytedance.sdk.component.tl.j.up;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static final LinkedList<String> f26759j = new LinkedList<>();
    private static final LinkedList<String> xt = new LinkedList<>();
    private static final LinkedList<String> cw = new LinkedList<>();

    /* renamed from: r, reason: collision with root package name */
    private static final LinkedList<String> f26761r = new LinkedList<>();
    private static final Map<String, Integer> up = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    private static String f26760m = "upload_init";
    private static int ae = 0;
    private static int tl = 0;

    /* renamed from: g, reason: collision with root package name */
    private static AtomicLong f26758g = new AtomicLong();

    public static boolean cw(String str) {
        return false;
    }

    public static boolean g(com.bytedance.sdk.component.tl.j.xt xtVar, up upVar) {
        return xtVar != null && xtVar.r() == 0 && j(upVar);
    }

    public static boolean j(int i6) {
        return i6 == 72 || i6 == 71;
    }

    private static synchronized void m(String str) {
        synchronized (j.class) {
            LinkedList<String> linkedList = f26761r;
            if (linkedList.size() < 10) {
                linkedList.add(str);
            } else {
                linkedList.removeFirst();
                linkedList.add(str);
            }
        }
    }

    private static synchronized String r(String str) {
        String sb;
        synchronized (j.class) {
            try {
                LinkedList<String> linkedList = xt;
                if (linkedList.size() >= 10) {
                    linkedList.removeFirst();
                    linkedList.add(str);
                } else {
                    linkedList.add(str);
                }
                StringBuilder sb2 = new StringBuilder();
                Iterator<String> it = linkedList.iterator();
                while (it.hasNext()) {
                    sb2.append(it.next());
                    sb2.append(",");
                }
                sb = sb2.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb;
    }

    private static synchronized String up(String str) {
        String sb;
        synchronized (j.class) {
            try {
                LinkedList<String> linkedList = cw;
                if (linkedList.size() >= 10) {
                    linkedList.removeFirst();
                    linkedList.add(str);
                } else {
                    linkedList.add(str);
                }
                StringBuilder sb2 = new StringBuilder();
                Iterator<String> it = linkedList.iterator();
                while (it.hasNext()) {
                    sb2.append(it.next());
                    sb2.append(",");
                }
                sb = sb2.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb;
    }

    public static synchronized String xt(String str) {
        String sb;
        synchronized (j.class) {
            try {
                LinkedList<String> linkedList = f26759j;
                if (linkedList.size() >= 10) {
                    linkedList.removeFirst();
                    linkedList.add(str);
                } else {
                    linkedList.add(str);
                }
                StringBuilder sb2 = new StringBuilder();
                Iterator<String> it = linkedList.iterator();
                while (it.hasNext()) {
                    sb2.append(it.next());
                    sb2.append(",");
                }
                sb = sb2.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb;
    }

    public static void ae(com.bytedance.sdk.component.tl.j.xt xtVar, up upVar) {
        try {
            if (xtVar.r() == 0 && upVar.r() != null && upVar.r().ws()) {
                JSONObject ae2 = xtVar.ae();
                String j6 = j(xtVar, upVar);
                if (cw(j6)) {
                    return;
                }
                String optString = ae2.optString("ad_extra_data");
                if (TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("will_send_labels", up(j6));
                    jSONObject.put("send_success_valid_labels", xt());
                    ae2.put("ad_extra_data", jSONObject.toString());
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(optString);
                if (TextUtils.isEmpty(jSONObject2.optString("will_send_labels"))) {
                    jSONObject2.put("will_send_labels", up(j6));
                    jSONObject2.put("send_success_valid_labels", xt());
                }
                ae2.put("ad_extra_data", jSONObject2.toString());
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public static String cw(com.bytedance.sdk.component.tl.j.xt xtVar, up upVar) {
        if (upVar == null || upVar.r() == null || !upVar.r().j()) {
            return "";
        }
        String j6 = j(xtVar, upVar);
        if (!TextUtils.isEmpty(j6)) {
            return "label:" + j6;
        }
        if (TextUtils.isEmpty(xt(xtVar, upVar))) {
            return null;
        }
        return "type:" + xt(xtVar, upVar);
    }

    public static synchronized int j(String str) {
        synchronized (j.class) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            Map<String, Integer> map = up;
            Integer num = map.get(str);
            if (num == null) {
                map.put(str, 1);
                return 1;
            }
            int intValue = num.intValue() + 1;
            map.put(str, Integer.valueOf(intValue));
            return intValue;
        }
    }

    public static void tl(com.bytedance.sdk.component.tl.j.xt xtVar, up upVar) {
        if (upVar == null || upVar.r() == null || !upVar.r().cw()) {
            return;
        }
        try {
            com.bytedance.sdk.component.tl.xt.xt.xt.f26840j.j(System.currentTimeMillis() - xtVar.tl());
            xtVar.xt(System.currentTimeMillis());
            if (xtVar.r() == 0 && upVar.r() != null && upVar.r().ws()) {
                String j6 = j(xtVar, upVar);
                if (cw(j6)) {
                    return;
                }
                JSONObject ae2 = xtVar.ae();
                String optString = xtVar.ae().optString("ad_extra_data");
                if (TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("save_success_labels", r(j6));
                    ae2.put("ad_extra_data", jSONObject.toString());
                } else {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    if (TextUtils.isEmpty(jSONObject2.optString("save_success_labels"))) {
                        jSONObject2.put("save_success_labels", r(j6));
                    }
                    ae2.put("ad_extra_data", jSONObject2.toString());
                }
            }
        } catch (Exception unused) {
        }
    }

    public static String m(com.bytedance.sdk.component.tl.j.xt xtVar, up upVar) {
        if (xtVar != null && xtVar.ae() != null && !xt(upVar) && !r(upVar)) {
            String optString = xtVar.ae().optString(MediationConstant.EXTRA_LOG_EXTRA);
            if (!TextUtils.isEmpty(optString)) {
                try {
                    return new JSONObject(optString).optString("req_id");
                } catch (JSONException e6) {
                    vl.j(e6);
                }
            }
        }
        return null;
    }

    public static int r(com.bytedance.sdk.component.tl.j.xt xtVar, up upVar) {
        if (xtVar != null && xtVar.ae() != null && xtVar.r() == 1) {
            try {
                return new JSONObject(xtVar.ae().optString("event_extra")).optInt("stats_index");
            } catch (JSONException e6) {
                vl.j(e6);
            }
        }
        return -1;
    }

    public static synchronized int up(com.bytedance.sdk.component.tl.j.xt xtVar, up upVar) {
        synchronized (j.class) {
            if (xtVar != null) {
                if (xtVar.ae() != null) {
                    try {
                        return new JSONObject(xtVar.ae().optString("ad_extra_data")).optInt("sdk_event_self_count");
                    } catch (Exception e6) {
                        vl.j(e6);
                        return 0;
                    }
                }
            }
            return 0;
        }
    }

    private static synchronized String xt() {
        String sb;
        synchronized (j.class) {
            try {
                StringBuilder sb2 = new StringBuilder();
                Iterator<String> it = f26761r.iterator();
                while (it.hasNext()) {
                    sb2.append(it.next());
                    sb2.append(",");
                }
                sb = sb2.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb;
    }

    public static boolean cw(up upVar) {
        return upVar != null && TextUtils.equals(upVar.up(), MediationConstant.ADN_PANGLE);
    }

    public static String j(com.bytedance.sdk.component.tl.j.xt xtVar, up upVar) {
        if (xtVar == null || xtVar.ae() == null || xt(upVar) || r(upVar)) {
            return null;
        }
        if (xtVar.xt() == 3) {
            return xtVar.ae().optString("event");
        }
        return xtVar.ae().optString("label");
    }

    public static boolean cw(com.bytedance.sdk.component.tl.j.xt xtVar) {
        return xtVar != null && xtVar.r() == 0 && xtVar.up() == 2;
    }

    public static int cw(List<com.bytedance.sdk.component.tl.j.xt> list, up upVar) {
        JSONObject ae2;
        String optString;
        if (list != null && list.size() == 1) {
            try {
                com.bytedance.sdk.component.tl.j.xt xtVar = list.get(0);
                if (xtVar != null && xtVar.up() == 1 && (ae2 = xtVar.ae()) != null && xtVar.r() == 0) {
                    JSONObject optJSONObject = ae2.optJSONObject("params");
                    if (optJSONObject == null) {
                        optString = ae2.optString("ad_extra_data");
                    } else {
                        optString = optJSONObject.optString("ad_extra_data");
                    }
                    JSONObject jSONObject = new JSONObject(optString);
                    int optInt = jSONObject.optInt("inner_appid", 0);
                    if (optInt != 0) {
                        jSONObject.remove("inner_appid");
                        if (optJSONObject == null) {
                            ae2.put("ad_extra_data", jSONObject.toString());
                            return optInt;
                        }
                        optJSONObject.put("ad_extra_data", jSONObject.toString());
                        ae2.put("params", optJSONObject);
                        return optInt;
                    }
                }
            } catch (Throwable th) {
                vl.j(th);
            }
        }
        return 0;
    }

    public static boolean m(com.bytedance.sdk.component.tl.j.xt xtVar) {
        return xtVar != null && xtVar.r() == 2 && xtVar.up() == 3;
    }

    public static String xt(com.bytedance.sdk.component.tl.j.xt xtVar, up upVar) {
        if (xtVar == null || xtVar.ae() == null || xt(upVar) || r(upVar)) {
            return null;
        }
        return xtVar.ae().optString("type");
    }

    public static boolean r(up upVar) {
        return upVar != null && TextUtils.equals(upVar.up(), "pgl_mediation");
    }

    public static void j(List<com.bytedance.sdk.component.tl.j.xt> list, String str, com.bytedance.sdk.component.tl.xt.j.xt xtVar) {
        JSONObject ae2;
        if (list != null) {
            try {
                if (list.size() != 0) {
                    com.bytedance.sdk.component.tl.j.xt xtVar2 = list.get(0);
                    if (xtVar2 == null || xtVar2.r() == 0) {
                        long incrementAndGet = f26758g.incrementAndGet();
                        for (com.bytedance.sdk.component.tl.j.xt xtVar3 : list) {
                            if (xtVar3 != null && (ae2 = xtVar3.ae()) != null) {
                                String optString = ae2.optString("ad_extra_data");
                                if (!TextUtils.isEmpty(optString)) {
                                    JSONObject jSONObject = new JSONObject(optString);
                                    jSONObject.put("upload_count", incrementAndGet);
                                    jSONObject.put("upload_ts", System.currentTimeMillis());
                                    if (xtVar != null) {
                                        String xt2 = xtVar.xt();
                                        boolean j6 = xtVar.j();
                                        if (!TextUtils.isEmpty(xt2)) {
                                            jSONObject.put("delete_msg", xt2 + " success:" + j6);
                                        }
                                    }
                                    ae2.put("ad_extra_data", jSONObject.toString());
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                vl.j(th);
            }
        }
    }

    public static boolean r(com.bytedance.sdk.component.tl.j.xt xtVar) {
        return xtVar != null && xtVar.r() == 1 && xtVar.up() == 2;
    }

    public static boolean xt(up upVar) {
        return upVar != null && TextUtils.equals(upVar.up(), "csj_mediation");
    }

    public static boolean up(up upVar) {
        return j(upVar) || cw(upVar);
    }

    public static boolean xt(List<com.bytedance.sdk.component.tl.j.xt> list, up upVar) {
        com.bytedance.sdk.component.tl.j.xt xtVar;
        return (list == null || list.size() == 0 || (xtVar = list.get(0)) == null || xtVar.r() != 0 || !j(upVar)) ? false : true;
    }

    public static boolean up(com.bytedance.sdk.component.tl.j.xt xtVar) {
        return xtVar != null && xtVar.r() == 1 && xtVar.up() == 3;
    }

    public static boolean xt(com.bytedance.sdk.component.tl.j.xt xtVar) {
        return xtVar != null && xtVar.r() == 3 && xtVar.up() == 2;
    }

    public static String xt(int i6) {
        switch (i6) {
            case 71:
                return "flush once";
            case 72:
                return "flush memory db";
            case 73:
                return "flush memory";
            case 74:
                return "new event";
            case 75:
            default:
                return "default";
            case 76:
                return "empty message";
            case 77:
                return "net error";
        }
    }

    public static String j(JSONObject jSONObject, up upVar) {
        if (jSONObject != null && !xt(upVar) && !r(upVar)) {
            String optString = jSONObject.optString(MediationConstant.EXTRA_LOG_EXTRA);
            if (!TextUtils.isEmpty(optString)) {
                try {
                    return new JSONObject(optString).optString("rit");
                } catch (JSONException e6) {
                    vl.j(e6);
                }
            }
        }
        return "";
    }

    public static void j(List<com.bytedance.sdk.component.tl.j.xt> list, up upVar) {
        try {
            if (upVar.r().cw()) {
                for (com.bytedance.sdk.component.tl.j.xt xtVar : list) {
                    if (xtVar != null && xtVar.g() != 0) {
                        long currentTimeMillis = System.currentTimeMillis() - xtVar.g();
                        com.bytedance.sdk.component.tl.xt.xt.j.j jVar = com.bytedance.sdk.component.tl.xt.xt.xt.f26840j;
                        jVar.tl().incrementAndGet();
                        jVar.jy().getAndAdd(currentTimeMillis);
                        xtVar.cw(System.currentTimeMillis());
                    }
                    if (xtVar != null) {
                        ae(xtVar, upVar);
                    }
                }
                com.bytedance.sdk.component.tl.xt.xt.xt.f26840j.oq().getAndAdd(list.size());
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public static boolean j(up upVar) {
        return upVar != null && TextUtils.equals(upVar.up(), "csj");
    }

    public static void j(JSONObject jSONObject, com.bytedance.sdk.component.tl.xt.r.j.j jVar, up upVar, int i6) {
        r r5;
        if (upVar != null && (r5 = upVar.r()) != null && r5.j() && up(upVar)) {
            jSONObject.optString("label");
        }
    }

    public static void j(List<com.bytedance.sdk.component.tl.j.xt> list, int i6, String str, up upVar) {
        r r5;
        if (upVar == null || (r5 = upVar.r()) == null || !r5.j() || list == null || xt(upVar) || r(upVar)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        boolean z5 = false;
        for (com.bytedance.sdk.component.tl.j.xt xtVar : list) {
            if (xtVar.r() == 0) {
                JSONObject ae2 = xtVar.ae();
                String j6 = j(xtVar, upVar);
                if (xtVar.xt() == 3) {
                    if (ae2 != null) {
                        j6 = ae2.optString("event");
                    }
                    sb.append(" [v3:");
                    sb.append(j6);
                    sb.append("] ");
                } else {
                    long j7 = j(upVar, xtVar);
                    int up2 = up(xtVar, upVar);
                    sb.append(" [");
                    sb.append(j7);
                    sb.append("_");
                    sb.append(j6);
                    if (up2 == 0) {
                        sb.append("] ");
                    } else {
                        sb.append("_");
                        sb.append(up2);
                        sb.append("] ");
                    }
                }
                z5 = true;
            } else if (xtVar.r() == 1) {
                String xt2 = xt(xtVar, upVar);
                int r6 = r(xtVar, upVar);
                sb.append(" [");
                sb.append(r6);
                sb.append("_");
                sb.append(xt2);
                sb.append("] ");
            }
        }
        if (z5) {
            cw.xt("_upload", "ads:" + ((Object) sb) + xt(i6) + "," + str + ",total:" + list.size(), upVar);
            return;
        }
        cw.xt("_upload", "stats:" + ((Object) sb) + xt(i6) + "," + str + ",total:" + list.size(), upVar);
    }

    public static boolean j(com.bytedance.sdk.component.tl.j.xt xtVar) {
        return xtVar != null && xtVar.r() == 0 && xtVar.up() == 1;
    }

    private static void j(com.bytedance.sdk.component.tl.j.xt xtVar, String str, r rVar, up upVar) {
        String j6 = j(xtVar, upVar);
        if (cw(j6)) {
            return;
        }
        String m6 = m(xtVar, upVar);
        if (xtVar.r() == 0 && rVar.ws()) {
            m(j6 + "_" + m6 + "_" + str);
        }
    }

    public static long j(up upVar, com.bytedance.sdk.component.tl.j.xt xtVar) {
        if (xtVar != null && xtVar.ae() != null) {
            try {
                return new JSONObject(xtVar.ae().optString("ad_extra_data")).optLong("sdk_event_index");
            } catch (Exception e6) {
                cw.cw(e6.getMessage(), upVar);
            }
        }
        return 0L;
    }

    public static void j(boolean z5, int i6, String str, String str2, int i7, String str3) {
        ae++;
        if (z5) {
            tl++;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("suc", z5);
            jSONObject.put("scnt", tl);
            jSONObject.put("acnt", ae);
            jSONObject.put("code", i6);
            jSONObject.put("reqid", str2);
            jSONObject.put("len:", i7);
            jSONObject.put("rit", str3);
            jSONObject.put("msg", str);
            r up2 = com.bytedance.sdk.component.tl.xt.j.cw("csj").up();
            if (up2 != null) {
                jSONObject.put("url", up2.vl().m());
            } else {
                jSONObject.put("url", "emptyurl");
            }
            f26760m = jSONObject.toString();
        } catch (Exception unused) {
            f26760m = "unknown_json";
        }
    }

    public static String j() {
        return f26760m;
    }

    public static void j(com.bytedance.sdk.component.tl.j.xt xtVar, up upVar, String str) {
        r up2;
        if (xt(upVar) || upVar == null || r(upVar) || (up2 = com.bytedance.sdk.component.tl.xt.j.cw(upVar.up()).up()) == null || !up2.j()) {
            return;
        }
        if (!TextUtils.isEmpty(xt(xtVar, upVar))) {
            r(xtVar, upVar);
        }
        if (TextUtils.isEmpty(j(xtVar, upVar))) {
            return;
        }
        j(upVar, xtVar);
    }

    public static void j(List<com.bytedance.sdk.component.tl.j.xt> list, up upVar, String str) {
        if (upVar == null) {
            return;
        }
        try {
            r r5 = upVar.r();
            if (r5 == null || !r5.j()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (com.bytedance.sdk.component.tl.j.xt xtVar : list) {
                if (xtVar.r() == 1) {
                    sb.append(xt(xtVar, upVar));
                    sb.append("_");
                    sb.append(r(xtVar, upVar));
                    sb.append("; ");
                } else if (xtVar.r() == 0) {
                    if (xtVar.xt() == 3) {
                        if (xtVar.ae() != null) {
                            sb.append(xtVar.ae().optString("event"));
                            long j6 = j(upVar, xtVar);
                            if (j6 != 0) {
                                sb.append("_");
                                sb.append(j6);
                            }
                            sb.append("; ");
                        } else {
                            cw.xt("_delete", "v3_error", upVar);
                        }
                    } else {
                        sb.append(j(xtVar, upVar));
                        long j7 = j(upVar, xtVar);
                        if (j7 != 0) {
                            sb.append("_");
                            sb.append(j7);
                        }
                        sb.append("; ");
                    }
                }
            }
            sb.append("]");
            sb.append(" total:" + list.size());
            sb.append(" table:" + str);
            cw.xt("_remove", sb.toString(), upVar);
        } catch (Exception e6) {
            cw.cw("_delete error", e6.getMessage(), upVar);
        }
    }

    public static void j(int i6, List<com.bytedance.sdk.component.tl.j.xt> list, long j6, up upVar, com.bytedance.sdk.component.tl.xt.xt.cw.xt xtVar) {
        com.bytedance.sdk.component.tl.j.xt xtVar2;
        if (upVar != null) {
            try {
                if (upVar.r().cw()) {
                    long currentTimeMillis = System.currentTimeMillis() - j6;
                    if (i6 == 200) {
                        com.bytedance.sdk.component.tl.xt.xt.j.j jVar = com.bytedance.sdk.component.tl.xt.xt.xt.f26840j;
                        jVar.v().getAndAdd(currentTimeMillis);
                        jVar.tj().incrementAndGet();
                        jVar.w().getAndAdd(list.size());
                        jVar.up().getAndAdd(list.size());
                        return;
                    }
                    cw.cw("-------AdThread code is " + i6 + " error  ------------", upVar);
                    byte b6 = -1;
                    if (i6 == -1) {
                        com.bytedance.sdk.component.tl.xt.xt.xt.f26840j.mi().getAndAdd(list.size());
                    } else {
                        com.bytedance.sdk.component.tl.xt.xt.xt.f26840j.ae().getAndAdd(list.size());
                    }
                    com.bytedance.sdk.component.tl.xt.xt.j.j jVar2 = com.bytedance.sdk.component.tl.xt.xt.xt.f26840j;
                    jVar2.x().getAndAdd(currentTimeMillis);
                    jVar2.f().incrementAndGet();
                    if (!list.isEmpty() && (xtVar2 = list.get(0)) != null) {
                        b6 = xtVar2.r();
                    }
                    if (xtVar != null) {
                        String str = xtVar.f26830r;
                        int i7 = xtVar.xt;
                        String str2 = xtVar.cw;
                        StringBuffer ch = jVar2.ch();
                        ch.append((int) b6);
                        ch.append("_");
                        ch.append(str);
                        ch.append("_");
                        ch.append(i7);
                        ch.append("_");
                        ch.append(str2);
                        ch.append(" ");
                        return;
                    }
                    StringBuffer ch2 = jVar2.ch();
                    ch2.append((int) b6);
                    ch2.append("_");
                    ch2.append(i6);
                    ch2.append(" ");
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void j(List<com.bytedance.sdk.component.tl.j.xt> list, String str, up upVar) {
        try {
            r r5 = upVar.r();
            if (r5 != null && r5.cw() && list != null && r5.ws()) {
                for (com.bytedance.sdk.component.tl.j.xt xtVar : list) {
                    if (xtVar != null) {
                        j(xtVar, str, r5, upVar);
                    }
                }
            }
        } catch (Exception e6) {
            cw.cw(e6.getMessage(), upVar);
        }
    }
}
