package com.bytedance.sdk.component.panglearmor.xt;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.panglearmor.SoftDecTool;
import com.umeng.analytics.pro.bi;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static volatile xt f26721j;
    private LinkedList<JSONObject> cw;

    /* renamed from: m, reason: collision with root package name */
    private long f26722m;

    /* renamed from: r, reason: collision with root package name */
    private LinkedList<JSONObject> f26723r;
    private LinkedList<JSONObject> up;
    private SharedPreferences xt;

    public static xt j() {
        if (f26721j == null) {
            synchronized (xt.class) {
                try {
                    if (f26721j == null) {
                        f26721j = new xt();
                    }
                } finally {
                }
            }
        }
        return f26721j;
    }

    public synchronized void xt(String str) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if ("android.intent.action.SCREEN_OFF".equals(str)) {
                LinkedList<JSONObject> j6 = j("sp_screen");
                int i6 = 1;
                if (j6 != null && j6.size() > 0) {
                    JSONObject last = j6.getLast();
                    if (last.optLong(bi.aL, 0L) / 3600000 == currentTimeMillis / 3600000) {
                        i6 = 1 + last.optInt("val", 0);
                        j6.removeLast();
                    }
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(bi.aL, currentTimeMillis);
                    jSONObject.put("val", i6);
                    j(jSONObject, "sp_screen");
                } catch (JSONException e6) {
                    throw new RuntimeException(e6);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private LinkedList<JSONObject> cw(String str) {
        LinkedList<JSONObject> linkedList = new LinkedList<>();
        SharedPreferences sharedPreferences = this.xt;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!TextUtils.isEmpty(string)) {
                for (String str2 : string.split("\\|")) {
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            linkedList.add(new JSONObject(str2));
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
        return linkedList;
    }

    public xt() {
        this.xt = null;
        this.cw = null;
        this.f26723r = null;
        this.up = null;
        this.f26722m = 0L;
        this.xt = SoftDecTool.getSharedPreferences("pithar");
        this.cw = cw("sp_angle");
        this.f26723r = cw("sp_screen");
        this.up = cw("sp_net");
        this.f26722m = up.j().cw() / up.j().r();
    }

    public LinkedList<JSONObject> j(String str) {
        if ("sp_angle".equals(str)) {
            return this.cw;
        }
        if ("sp_screen".equals(str)) {
            return this.f26723r;
        }
        if ("sp_net".equals(str)) {
            return this.up;
        }
        return null;
    }

    public void j(JSONObject jSONObject, String str) {
        LinkedList<JSONObject> j6 = j(str);
        if (j6 == null) {
            return;
        }
        j6.add(jSONObject);
        if (j6.size() > this.f26722m) {
            j6.removeFirst();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long cw = currentTimeMillis - up.j().cw();
        Iterator<JSONObject> it = j6.iterator();
        JSONObject jSONObject2 = null;
        while (it.hasNext()) {
            JSONObject next = it.next();
            long optLong = next.optLong(bi.aL, 0L);
            if (optLong < cw) {
                it.remove();
                jSONObject2 = next;
            } else if (optLong > currentTimeMillis) {
                it.remove();
            }
        }
        if (jSONObject2 != null && j6.size() < 2) {
            j6.addFirst(jSONObject2);
        }
        j(str, j6);
    }

    public synchronized void j(int i6) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            int i7 = i6 == 4 ? 1 : i6 > 0 ? 2 : 0;
            LinkedList<JSONObject> j6 = j("sp_net");
            if (j6 != null && j6.size() > 0) {
                JSONObject last = j6.getLast();
                if (last.optLong(bi.aL, 0L) / 3600000 == currentTimeMillis / 3600000) {
                    i7 |= last.optInt("val", 0);
                    j6.removeLast();
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(bi.aL, currentTimeMillis);
                jSONObject.put("val", i7);
                j(jSONObject, "sp_net");
            } catch (JSONException e6) {
                throw new RuntimeException(e6);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void j(String str, LinkedList<JSONObject> linkedList) {
        if (linkedList == null || this.xt == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<JSONObject> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append("\\|");
        }
        SharedPreferences.Editor edit = this.xt.edit();
        edit.putString(str, sb.toString());
        edit.apply();
    }

    public LinkedList<JSONObject> j(long j6) {
        if (j6 == 0) {
            return this.cw;
        }
        LinkedList<JSONObject> linkedList = new LinkedList<>();
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<JSONObject> it = this.cw.iterator();
        JSONObject jSONObject = null;
        while (it.hasNext()) {
            JSONObject next = it.next();
            if (currentTimeMillis - next.optLong(bi.aL, 0L) < j6) {
                linkedList.add(next);
            } else {
                jSONObject = next;
            }
        }
        if (jSONObject != null && linkedList.size() < 2) {
            linkedList.addFirst(jSONObject);
        }
        return linkedList;
    }
}
