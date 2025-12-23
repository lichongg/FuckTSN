package com.bytedance.sdk.component.adexpress.dynamic.cw;

import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl {
    private float ae;
    private float cw;

    /* renamed from: g, reason: collision with root package name */
    private up f25633g;

    /* renamed from: j, reason: collision with root package name */
    private String f25634j;
    private String jy;

    /* renamed from: m, reason: collision with root package name */
    private float f25635m;
    private List<tl> oq;
    private tl qv;

    /* renamed from: r, reason: collision with root package name */
    private float f25636r;
    private float tl;
    private float up;
    private List<List<tl>> vl;
    private boolean ws;
    private float xt;
    private Map<String, String> az = new HashMap();
    private Map<Integer, String> av = new HashMap();

    public float ae() {
        return this.cw;
    }

    public String cw() {
        return this.f25634j;
    }

    public String j() {
        return this.jy;
    }

    public float m() {
        return this.xt;
    }

    public float r() {
        return this.f25636r;
    }

    public float up() {
        return this.up;
    }

    public Map<Integer, String> xt() {
        return this.av;
    }

    public void ae(float f6) {
        this.tl = f6;
    }

    public float av() {
        m up = this.f25633g.up();
        return ws() + up.i() + up.ws() + (up.vl() * 2.0f);
    }

    public float az() {
        m up = this.f25633g.up();
        return jy() + up.az() + up.av() + (up.vl() * 2.0f);
    }

    public void cw(float f6) {
        this.xt = f6;
    }

    public boolean f() {
        return TextUtils.equals(this.f25633g.up().l(), "flex");
    }

    public float g() {
        return this.ae;
    }

    public List<List<tl>> i() {
        return this.vl;
    }

    public void j(String str) {
        this.jy = str;
    }

    public int jy() {
        m up = this.f25633g.up();
        return up.hl() + up.b();
    }

    public Map<String, String> kt() {
        return this.az;
    }

    public void m(float f6) {
        this.ae = f6;
    }

    public boolean mi() {
        return this.ws;
    }

    public up oq() {
        return this.f25633g;
    }

    public List<tl> qv() {
        return this.oq;
    }

    public void r(float f6) {
        this.cw = f6;
    }

    public void tj() {
        List<List<tl>> list = this.vl;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (List<tl> list2 : this.vl) {
            if (list2 != null && list2.size() > 0) {
                arrayList.add(list2);
            }
        }
        this.vl = arrayList;
    }

    public float tl() {
        return this.f25635m;
    }

    public String toString() {
        return "DynamicLayoutUnit{id='" + this.f25634j + "', x=" + this.xt + ", y=" + this.cw + ", width=" + this.f25635m + ", height=" + this.ae + ", remainWidth=" + this.tl + ", rootBrick=" + this.f25633g + ", childrenBrickUnits=" + this.oq + '}';
    }

    public void up(float f6) {
        this.f25635m = f6;
    }

    public String v() {
        return this.f25633g.up().v();
    }

    public tl vl() {
        return this.qv;
    }

    public boolean w() {
        List<tl> list = this.oq;
        return list == null || list.size() <= 0;
    }

    public int ws() {
        m up = this.f25633g.up();
        return up.hh() + up.z();
    }

    public boolean x() {
        return this.f25633g.up().im() < 0 || this.f25633g.up().y() < 0 || this.f25633g.up().ln() < 0 || this.f25633g.up().xp() < 0;
    }

    public void xt(String str) {
        this.f25634j = str;
    }

    public void cw(String str) {
        this.f25633g.up().m(str);
    }

    public void j(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                    this.av.put(Integer.valueOf(optJSONObject.optInt("id")), optJSONObject.optString("value"));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void xt(float f6) {
        this.up = f6;
    }

    public void xt(List<List<tl>> list) {
        this.vl = list;
    }

    public void j(float f6) {
        this.f25636r = f6;
    }

    public void j(up upVar) {
        this.f25633g = upVar;
    }

    public void j(List<tl> list) {
        this.oq = list;
    }

    public void j(tl tlVar) {
        this.qv = tlVar;
    }

    public void j(boolean z5) {
        this.ws = z5;
    }

    public void j(String str, String str2) {
        this.az.put(str, str2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public String j(int i6) {
        char c6;
        int i7;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f25633g.getType());
        sb.append(":");
        sb.append(this.f25634j);
        if (this.f25633g.up() != null) {
            sb.append(":");
            sb.append(this.f25633g.up().xw());
        }
        sb.append(":");
        sb.append(i6);
        if (this.f25633g.up() != null) {
            sb.append(":");
            String ed = this.f25633g.up().ed();
            ed.getClass();
            switch (ed.hashCode()) {
                case 57:
                    if (ed.equals("9")) {
                        c6 = 0;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 1573:
                    if (ed.equals(Constants.VIA_REPORT_TYPE_START_WAP)) {
                        c6 = 1;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 1607:
                    if (ed.equals("29")) {
                        c6 = 2;
                        break;
                    }
                    c6 = 65535;
                    break;
                default:
                    c6 = 65535;
                    break;
            }
            switch (c6) {
                case 0:
                case 1:
                case 2:
                    i7 = 1;
                    break;
                default:
                    i7 = 0;
                    break;
            }
            String ed2 = this.f25633g.up().ed();
            ed2.getClass();
            if (ed2.equals(Constants.VIA_REPORT_TYPE_START_GROUP) || ed2.equals("18")) {
                i7 = (i7 * 10) + 2;
            }
            String ed3 = this.f25633g.up().ed();
            ed3.getClass();
            switch (ed3) {
                case "0":
                case "5":
                case "10":
                case "12":
                case "13":
                case "20":
                case "22":
                case "24":
                case "29":
                    i7 = (i7 * 10) + 3;
                    break;
            }
            sb.append(i7);
        }
        return sb.toString();
    }
}
