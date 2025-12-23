package com.bytedance.sdk.openadsdk.core.up.r;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.rn.h;
import com.bytedance.sdk.openadsdk.core.up.r.up;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements com.bytedance.sdk.openadsdk.core.up.r.j {

    /* renamed from: j, reason: collision with root package name */
    private static final com.bytedance.sdk.component.r.j.xt f30873j = h.j("open_ad_sdk_meta_cache_kv");

    private static class j {
        long ae;
        boolean cw;

        /* renamed from: j, reason: collision with root package name */
        long f30875j;

        /* renamed from: m, reason: collision with root package name */
        String f30876m;

        /* renamed from: r, reason: collision with root package name */
        String f30877r;
        int up;
        long xt;

        public j(String str, long j6, long j7, boolean z5, String str2, long j8, int i6) {
            this.f30875j = j6;
            this.xt = j7;
            this.cw = z5;
            this.f30877r = str;
            this.f30876m = str2;
            this.ae = j8;
            this.up = i6;
        }

        public static j j(String str) {
            String str2;
            long j6;
            long j7;
            boolean z5;
            int i6;
            String str3;
            String str4;
            boolean z6;
            int i7;
            JSONObject jSONObject;
            boolean optBoolean;
            String optString;
            int optInt;
            String str5 = "";
            long j8 = 0;
            try {
                jSONObject = new JSONObject(str);
                j6 = jSONObject.optLong("create_time", 0L);
                try {
                    j7 = jSONObject.optLong("expire_time", 0L);
                    try {
                        optBoolean = jSONObject.optBoolean("is_using", false);
                        try {
                            optString = jSONObject.optString("material_data", "");
                            try {
                                optInt = jSONObject.optInt("save_version", 0);
                            } catch (JSONException unused) {
                                z5 = optBoolean;
                                i6 = 0;
                            }
                        } catch (JSONException unused2) {
                            z5 = optBoolean;
                            i6 = 0;
                            str2 = "";
                        }
                    } catch (JSONException unused3) {
                        str2 = "";
                        z5 = true;
                        i6 = 0;
                        str3 = str5;
                        str4 = str2;
                        z6 = z5;
                        i7 = i6;
                        return new j(str3, j6, j7, z6, str4, j8, i7);
                    }
                } catch (JSONException unused4) {
                    str2 = "";
                    j7 = 0;
                }
            } catch (JSONException unused5) {
                str2 = "";
                j6 = 0;
                j7 = 0;
            }
            try {
                str5 = jSONObject.optString("uuid", "");
                j8 = jSONObject.optLong("priority", 0L);
                str4 = str5;
                z6 = optBoolean;
                i7 = optInt;
                str3 = optString;
            } catch (JSONException unused6) {
                i6 = optInt;
                z5 = optBoolean;
                str2 = str5;
                str5 = optString;
                str3 = str5;
                str4 = str2;
                z6 = z5;
                i7 = i6;
                return new j(str3, j6, j7, z6, str4, j8, i7);
            }
            return new j(str3, j6, j7, z6, str4, j8, i7);
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("create_time", this.f30875j);
                jSONObject.put("expire_time", this.xt);
                jSONObject.put("is_using", this.cw);
                jSONObject.put("material_data", this.f30877r);
                jSONObject.put("save_version", this.up);
                jSONObject.put("uuid", this.f30876m);
                jSONObject.put("priority", this.ae);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }

        public boolean xt(up.j jVar) {
            if (System.currentTimeMillis() > this.xt || TextUtils.isEmpty(this.f30877r)) {
                return true;
            }
            if (jVar.xt() && 7012 != this.up) {
                return true;
            }
            return false;
        }

        public j(String str, long j6, long j7, boolean z5, String str2, long j8) {
            this(str, j6, j7, z5, str2, j8, 7012);
        }

        public boolean j(up.j jVar) {
            return (xt(jVar) || this.cw) ? false : true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.r.j
    public void j(String str, up.xt xtVar, boolean z5, long j6, up.j jVar) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(f30873j.xt(cw(str), copyOnWriteArraySet));
        if (jVar.cw() <= 0) {
            return;
        }
        if (jVar.cw() > 0 && copyOnWriteArraySet.size() >= jVar.cw()) {
            Iterator it = copyOnWriteArraySet.iterator();
            String str2 = null;
            long j7 = 0;
            while (it.hasNext()) {
                String str3 = (String) it.next();
                j j8 = j.j(str3);
                if (str2 == null || j7 < j8.f30875j) {
                    j7 = j8.f30875j;
                    str2 = str3;
                }
            }
            copyOnWriteArraySet.remove(str2);
        }
        copyOnWriteArraySet.add(new j(xtVar.cw, xtVar.f30891j, xtVar.xt, z5, xtVar.up, j6).toString());
        f30873j.j(cw(str), copyOnWriteArraySet);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.up.r.cw$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ int[] f30874j;

        static {
            int[] iArr = new int[up.j.xt.values().length];
            f30874j = iArr;
            try {
                iArr[up.j.xt.TimeLast.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30874j[up.j.xt.CustomPriority.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.r.j
    public void xt(String str) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(f30873j.xt(cw(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            j j6 = j.j((String) it.next());
            j6.cw = false;
            copyOnWriteArraySet2.add(j6.toString());
        }
        f30873j.j(cw(str), copyOnWriteArraySet2);
    }

    private String cw(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return "sp_reward_video_cache_".concat(String.valueOf(str));
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.r.j
    public up.xt j(String str, up.j jVar, long j6) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        copyOnWriteArraySet.addAll(f30873j.xt(cw(str), copyOnWriteArraySet));
        return j(copyOnWriteArraySet, jVar, j6, (List<String>) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.r.j
    public up.xt j(String str, up.j jVar, long j6, List<String> list) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        copyOnWriteArraySet.addAll(f30873j.xt(cw(str), copyOnWriteArraySet));
        return j(copyOnWriteArraySet, jVar, j6, list);
    }

    private up.xt j(CopyOnWriteArraySet<String> copyOnWriteArraySet, up.j jVar, long j6, List<String> list) {
        Iterator<String> it = copyOnWriteArraySet.iterator();
        j jVar2 = null;
        while (it.hasNext()) {
            j j7 = j.j(it.next());
            if (j7.j(jVar)) {
                String str = j7.f30876m;
                if (list == null || str == null || !list.contains(str)) {
                    if (j6 <= 0 || j7.f30875j >= j6) {
                        int i6 = AnonymousClass1.f30874j[jVar.r().ordinal()];
                        if (i6 == 1) {
                            if (jVar2 != null && jVar2.f30875j >= j7.f30875j) {
                            }
                            jVar2 = j7;
                        } else {
                            if (i6 != 2) {
                                return new up.xt(j7.f30877r, j7.f30875j, j7.xt, j7.f30876m);
                            }
                            if (jVar2 != null && jVar2.ae >= j7.ae) {
                            }
                            jVar2 = j7;
                        }
                    }
                }
            }
        }
        if (jVar2 != null) {
            return new up.xt(jVar2.f30877r, jVar2.f30875j, jVar2.xt, jVar2.f30876m);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.r.j
    public void j(String str) {
        f30873j.j(cw(str));
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.r.j
    public void j(up.j jVar) {
        f30873j.j();
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.r.j
    public void j(String str, up.j jVar) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(f30873j.xt(cw(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            j j6 = j.j((String) it.next());
            if (!j6.xt(jVar)) {
                copyOnWriteArraySet2.add(j6.toString());
            }
        }
        f30873j.j(cw(str), copyOnWriteArraySet2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.r.j
    public void j(String str, String str2) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(f30873j.xt(cw(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            if (!TextUtils.equals(j.j(str3).f30876m, str2)) {
                copyOnWriteArraySet2.add(str3);
            }
        }
        f30873j.j(cw(str), copyOnWriteArraySet2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.up.r.j
    public void j(String str, String str2, boolean z5) {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        copyOnWriteArraySet.addAll(f30873j.xt(cw(str), copyOnWriteArraySet));
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            j j6 = j.j(str3);
            if (TextUtils.equals(j6.f30876m, str2)) {
                j6.cw = z5;
                copyOnWriteArraySet2.add(j6.toString());
            } else {
                copyOnWriteArraySet2.add(str3);
            }
        }
        f30873j.j(cw(str), copyOnWriteArraySet2);
    }
}
