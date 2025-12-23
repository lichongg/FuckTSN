package com.bytedance.sdk.openadsdk.core.rn;

import android.content.Context;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import com.baidu.mobads.sdk.internal.bn;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.component.panglearmor.SoftDecTool;
import com.bytedance.sdk.component.panglearmor.ae;
import com.bytedance.sdk.component.panglearmor.xt.r;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.tj.st;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.common.v2.dev.info.SystemPropertiesUtil;

/* loaded from: D:\Downloads\app\classes4.dex */
public class v {
    public static int cw = 2;

    /* renamed from: j, reason: collision with root package name */
    public static int f30163j = 0;

    /* renamed from: r, reason: collision with root package name */
    private static int f30164r = 300;
    private static volatile r.j up = null;
    public static int xt = 1;

    static class j implements com.bytedance.sdk.component.panglearmor.tl {
        @Override // com.bytedance.sdk.component.panglearmor.tl
        public void j(long j6, boolean z5) {
            com.bytedance.sdk.openadsdk.core.kt.ws.j().j(10001, j6, Boolean.valueOf(z5), (String) null);
        }

        @Override // com.bytedance.sdk.component.panglearmor.tl
        public void j(String str, JSONObject jSONObject) {
            if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
                return;
            }
            v.j(jSONObject.toString(), str);
        }

        j() {
        }
    }

    public static void j() {
        tl();
        r();
        if (com.bytedance.sdk.openadsdk.core.v.xt().ry()) {
            up();
            cw();
            ae();
            oq();
        }
    }

    public static JSONArray xt() {
        UsbAccessory[] accessoryList = ((UsbManager) com.bytedance.sdk.openadsdk.core.v.getContext().getSystemService("usb")).getAccessoryList();
        JSONArray jSONArray = new JSONArray();
        if (accessoryList != null) {
            for (UsbAccessory usbAccessory : accessoryList) {
                if (usbAccessory != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("manufacturer", usbAccessory.getManufacturer());
                        jSONObject.put(bn.f10753i, usbAccessory.getModel());
                        jSONObject.put("desc", usbAccessory.getDescription());
                        jSONObject.put(ContentProviderManager.PROVIDER_URI, usbAccessory.getUri());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e6) {
                        com.bytedance.sdk.component.utils.vl.j(e6);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static void cw() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray xt2 = xt();
            if (xt2.length() > 0) {
                jSONObject.put("usb", xt2);
            }
            JSONObject jSONObject2 = new JSONObject();
            ClassLoader classLoader = Class.forName("com.bytedance.sdk.openadsdk.TTFileProvider").getClassLoader();
            if (classLoader != null) {
                jSONObject2.put("loader", classLoader.getClass().getName());
                Class<? super Object> superclass = classLoader.getClass().getSuperclass();
                while (true) {
                    if (superclass == null || superclass.getName().equals("java.lang.Object")) {
                        break;
                    }
                    if (superclass.getName().equals("dalvik.system.BaseDexClassLoader")) {
                        j(classLoader, superclass, jSONObject2);
                        break;
                    }
                    superclass = superclass.getSuperclass();
                }
            }
            jSONObject.put("control", jSONObject2);
        } catch (Throwable unused) {
        }
        if (jSONObject.length() > 0) {
            j(jSONObject.toString(), "pangle_check");
        }
    }

    public static void ae() {
        com.bytedance.sdk.openadsdk.core.kt.ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.rn.v.3
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("board", Build.BOARD + "#" + com.bytedance.sdk.component.panglearmor.m.j("ro.product.board", "unknown"));
                jSONObject.put(bn.f10753i, Build.MODEL + "#" + com.bytedance.sdk.component.panglearmor.m.j("ro.product.model", "unknown"));
                jSONObject.put("os_version", Build.VERSION.RELEASE + "#" + com.bytedance.sdk.component.panglearmor.m.j("ro.build.version.release", "unknown"));
                jSONObject.put("vendor", Build.MANUFACTURER + "#" + com.bytedance.sdk.component.panglearmor.m.j("ro.product.manufacturer", "unknown"));
                jSONObject.put("rom_version", Build.DISPLAY + "#" + com.bytedance.sdk.component.panglearmor.m.j("ro.build.display.id", "unknown"));
                jSONObject.put("compiling_time", Build.TIME + "#" + (Long.parseLong(com.bytedance.sdk.component.panglearmor.m.j(SystemPropertiesUtil.PROP_UTC, "-1")) * 1000));
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("pangle_build_pick").xt(jSONObject.toString());
            }
        }, "pangle_build_pick");
    }

    public static st g() {
        try {
            if (com.bytedance.sdk.openadsdk.core.v.xt().mz()) {
                st j6 = com.bytedance.sdk.openadsdk.core.gq.j.j(com.bytedance.sdk.openadsdk.core.v.getContext()).j();
                if (j6 != null) {
                    return j6;
                }
                return null;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean m() {
        try {
            return com.bytedance.sdk.component.panglearmor.r.j(com.bytedance.sdk.openadsdk.core.v.xt().qv());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
            return false;
        }
    }

    public static void oq() {
        Context context = com.bytedance.sdk.openadsdk.core.v.getContext();
        if (context != null) {
            JSONObject jSONObject = new JSONObject();
            com.bytedance.sdk.openadsdk.core.gq.j.cw j6 = com.bytedance.sdk.openadsdk.core.gq.j.cw.j(context);
            try {
                jSONObject.put("access_perm", com.bytedance.sdk.openadsdk.core.x.xt.j(context, com.kuaishou.weapon.p0.g.f36042b));
                jSONObject.put("change_perm", com.bytedance.sdk.openadsdk.core.x.xt.j(context, "android.permission.CHANGE_NETWORK_STATE"));
                jSONObject.put("sim", com.bytedance.sdk.openadsdk.core.gq.j.up.j());
                jSONObject.put("network", j6.j());
                j(jSONObject.toString(), "uaid_info");
            } catch (Throwable unused) {
            }
        }
    }

    public static String qv() {
        return com.bytedance.sdk.component.panglearmor.m.cw();
    }

    public static String r() {
        try {
            if (!com.bytedance.sdk.openadsdk.core.oq.i().jy()) {
                SoftDecTool.setBlt(false);
            }
            return com.bytedance.sdk.component.panglearmor.m.xt();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
            return j(th);
        }
    }

    public static String tl() {
        st g6 = g();
        com.bytedance.sdk.openadsdk.core.uf.j.j().j(g6);
        if (g6 != null) {
            String stVar = g6.toString();
            if (!TextUtils.isEmpty(stVar)) {
                return stVar;
            }
        }
        return null;
    }

    public static void up() {
        String[] vr = com.bytedance.sdk.openadsdk.core.v.xt().vr();
        if (vr != null && vr.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : vr) {
                try {
                    Class.forName(str);
                    arrayList.add(str);
                } catch (ClassNotFoundException unused) {
                }
            }
            if (arrayList.size() > 0) {
                j(arrayList);
            }
        }
    }

    public static void j(Context context) {
        ae.j j6 = new ae.j(context, com.bytedance.sdk.openadsdk.core.h.j(context), "7012").j(true);
        j6.j(new j());
        com.bytedance.sdk.component.panglearmor.m.j(j6.j());
    }

    public static void xt(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.ch.cw cwVar;
        if (jSONObject == null || com.bytedance.sdk.openadsdk.core.v.j(10003) == null || (cwVar = (com.bytedance.sdk.openadsdk.core.ch.cw) AutoService.j(com.bytedance.sdk.openadsdk.core.ch.cw.class)) == null || !cwVar.r()) {
            return;
        }
        cwVar.cw();
        cwVar.j("antispam_handhold", jSONObject, new com.bytedance.sdk.openadsdk.core.ch.ae() { // from class: com.bytedance.sdk.openadsdk.core.rn.v.5
            @Override // com.bytedance.sdk.openadsdk.core.ch.ae
            protected PluginValueSet j(int i6, com.bytedance.sdk.openadsdk.core.ch.tl tlVar) {
                com.bytedance.sdk.openadsdk.i.j cw2 = tlVar.cw();
                if (cw2 != null) {
                    PluginValueSet r5 = cw2.r();
                    if (cw2.j() && r5 != null) {
                        JSONObject jSONObject2 = (JSONObject) r5.objectValue(2, JSONObject.class);
                        if (jSONObject2 != null) {
                            try {
                                JSONArray jSONArray = jSONObject2.getJSONArray("probability");
                                if (jSONArray.length() == 1) {
                                    SoftDecTool.ua(jSONArray.optDouble(0), System.currentTimeMillis());
                                    double d6 = SoftDecTool.acs;
                                }
                            } catch (JSONException unused) {
                            }
                        }
                        return r5;
                    }
                    return null;
                }
                return null;
            }
        });
    }

    private static void j(ClassLoader classLoader, Class<?> cls, JSONObject jSONObject) throws Exception {
        Field declaredField = cls.getDeclaredField("pathList");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(classLoader);
        if (obj != null) {
            Field declaredField2 = obj.getClass().getDeclaredField("dexElements");
            declaredField2.setAccessible(true);
            Object[] objArr = (Object[]) declaredField2.get(obj);
            if (objArr != null) {
                jSONObject.put("size", objArr.length);
                StringBuilder sb = new StringBuilder();
                for (Object obj2 : objArr) {
                    Field declaredField3 = obj2.getClass().getDeclaredField("dexFile");
                    declaredField3.setAccessible(true);
                    Object obj3 = declaredField3.get(obj2);
                    if (obj3 != null && !obj3.toString().startsWith("/data/app")) {
                        sb.append(obj3);
                        sb.append(";");
                    }
                }
                jSONObject.put("dexPathList", sb);
            }
        }
    }

    public static void j(final String str, final String str2) {
        com.bytedance.sdk.openadsdk.core.kt.ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.rn.v.1
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() {
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j(str2).xt(str);
            }
        }, str2);
    }

    public static void j(MotionEvent motionEvent) {
        try {
            com.bytedance.sdk.component.panglearmor.m.j(motionEvent);
        } catch (Throwable unused) {
        }
    }

    public static String j(String str, long j6, int i6, boolean z5) {
        try {
            return com.bytedance.sdk.component.panglearmor.m.j(str, j6, i6, z5);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void j(long j6, int i6) {
        try {
            com.bytedance.sdk.component.panglearmor.m.j(j6, i6);
        } catch (Throwable unused) {
        }
    }

    public static int j(String str) {
        int i6 = f30163j;
        if (str != null && !str.isEmpty()) {
            int indexOf = str.indexOf("_");
            if (indexOf <= 0) {
                return cw;
            }
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf + 1);
            int indexOf2 = substring2.indexOf("_");
            if (indexOf2 <= 0) {
                return cw;
            }
            String substring3 = substring2.substring(0, indexOf2);
            String substring4 = substring2.substring(indexOf2 + 1);
            long longValue = Long.valueOf(substring).longValue() - Long.valueOf(substring3).longValue();
            try {
                if (com.bytedance.sdk.component.panglearmor.r.j(substring3 + "_" + com.bytedance.sdk.openadsdk.core.kt.cw(), substring4)) {
                    return Math.abs(longValue) > ((long) f30164r) ? xt : i6;
                }
                return cw;
            } catch (Throwable unused) {
                return f30163j;
            }
        }
        return cw;
    }

    public static String j(Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("stts", 3);
            jSONObject.put("exception:", th.toString());
            jSONObject.put("stacktrace:", Arrays.toString(th.getStackTrace()));
            jSONObject.put("cause:", String.valueOf(th.getCause()));
            return Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 0);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.vl.j(th2);
            return "eyJzdHRzIjozfQ==";
        }
    }

    private static void j(final List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.kt.ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.rn.v.2
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("clz", list.toString());
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("pangle_clz_found").xt(jSONObject.toString());
            }
        }, "pangle_clz_found");
    }

    public static void j(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.kt.ws.j().xt(new com.bytedance.sdk.openadsdk.vl.j.j() { // from class: com.bytedance.sdk.openadsdk.core.rn.v.4
            @Override // com.bytedance.sdk.openadsdk.vl.j.j
            public com.bytedance.sdk.openadsdk.core.kt.j.j j() throws Exception {
                return com.bytedance.sdk.openadsdk.core.kt.j.xt.xt().j("har_automatic").xt(jSONObject.toString());
            }
        }, "har_automatic");
    }

    public static void j(int i6, final int i7) {
        if (com.bytedance.sdk.component.panglearmor.m.r() != null && com.bytedance.sdk.openadsdk.core.oq.i().up()) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean xt2 = com.bytedance.sdk.component.panglearmor.xt.up.j().xt();
            boolean z5 = ((long) (i6 - 1)) % com.bytedance.sdk.component.panglearmor.xt.up.j().up() == 0;
            boolean z6 = currentTimeMillis - com.bytedance.sdk.component.panglearmor.xt.r.j().r() > com.bytedance.sdk.component.panglearmor.xt.up.j().r();
            boolean cw2 = com.bytedance.sdk.component.panglearmor.xt.r.j().cw();
            com.bytedance.sdk.component.panglearmor.xt.up.j();
            com.bytedance.sdk.component.panglearmor.xt.up.j();
            com.bytedance.sdk.component.panglearmor.xt.up.j();
            com.bytedance.sdk.component.panglearmor.xt.up.j();
            double d6 = SoftDecTool.acs;
            long j6 = SoftDecTool.act;
            if (z5 && z6 && xt2 && !cw2) {
                if (up == null) {
                    up = new r.j() { // from class: com.bytedance.sdk.openadsdk.core.rn.v.6
                        @Override // com.bytedance.sdk.component.panglearmor.xt.r.j
                        public void j(JSONObject jSONObject) {
                            if (jSONObject != null) {
                                try {
                                    jSONObject.put("scene", i7);
                                } catch (JSONException unused) {
                                }
                                v.xt(jSONObject);
                                v.j(jSONObject);
                            }
                        }
                    };
                    com.bytedance.sdk.component.panglearmor.xt.r.j().j(up);
                }
                com.bytedance.sdk.component.oq.ae.xt(new com.bytedance.sdk.component.oq.g("har") { // from class: com.bytedance.sdk.openadsdk.core.rn.v.7
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.component.panglearmor.xt.r.j().xt();
                    }
                });
            }
        }
    }
}
