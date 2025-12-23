package com.kwad.sdk.n.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KsJson
/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    public static final String TAG = "Ranger_" + b.class.getSimpleName();
    public Object aXq;
    public String aXr;
    public String aXs;
    public boolean aXt;

    @NonNull
    public String aXu;
    public C0706b aXv;
    public b aXw;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public List<String> aXA;
        public List<a> aXB = new ArrayList();
        public Object aXC;
        public List<Object> aXD;
        public String aXx;
        public String aXy;
        public String aXz;
        public String className;
        public String fieldName;

        private Object Pc() {
            Object obj = null;
            try {
            } catch (Exception e6) {
                c.d(b.TAG, Log.getStackTraceString(e6));
            }
            if (TextUtils.isEmpty(this.className)) {
                c.w(b.TAG, "SpecialParam className is null");
                return null;
            }
            obj = z.gU(this.className);
            c.d(b.TAG, "Class.forName(className):" + this.className + " value:" + obj);
            List<a> list = this.aXB;
            if (list != null && !list.isEmpty()) {
                for (a aVar : this.aXB) {
                    aVar.aXC = obj;
                    c.d(b.TAG, "param.ob:" + aVar.aXC);
                    try {
                        z.a(aVar.aXC, aVar.fieldName, aVar.getValue());
                    } catch (Exception e7) {
                        c.d(b.TAG, Log.getStackTraceString(e7));
                    }
                }
            }
            c.d(b.TAG, "return value in special:" + obj);
            return obj;
        }

        private static Object ao(String str, String str2) {
            try {
                Class<?> cls = Class.forName(str);
                if (cls == Integer.class) {
                    return Integer.valueOf(Integer.parseInt(str2));
                }
                if (cls == Long.class) {
                    return Long.valueOf(Long.parseLong(str2));
                }
                if (cls == Float.class) {
                    return Float.valueOf(Float.parseFloat(str2));
                }
                if (cls == Boolean.class) {
                    return Boolean.valueOf(Boolean.parseBoolean(str2));
                }
                if (cls == Double.class) {
                    return Double.valueOf(Double.parseDouble(str2));
                }
                if (cls == String.class) {
                    return str2;
                }
                return null;
            } catch (Exception e6) {
                c.w(b.TAG, Log.getStackTraceString(e6));
                return null;
            }
        }

        private Object Pd() {
            if (TextUtils.isEmpty(this.aXz)) {
                return ao(this.aXx, this.aXy);
            }
            this.aXD = new ArrayList();
            Iterator<String> it = this.aXA.iterator();
            while (it.hasNext()) {
                Object ao = ao(this.aXz, it.next());
                if (ao != null) {
                    this.aXD.add(ao);
                }
            }
            return this.aXD;
        }

        public final Object getValue() {
            return (TextUtils.isEmpty(this.aXx) && TextUtils.isEmpty(this.aXz)) ? Pc() : Pd();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    /* renamed from: com.kwad.sdk.n.a.b$b, reason: collision with other inner class name */
    public static class C0706b extends com.kwad.sdk.core.response.a.a {
        public boolean aXE;
        public List<a> aXF;
        public Object[] aXG;
        public String name;

        public final boolean Pb() {
            if (!TextUtils.isEmpty(this.name)) {
                return false;
            }
            List<a> list = this.aXF;
            return (list == null || list.isEmpty()) && this.aXG == null;
        }

        public final Object[] Pe() {
            List<a> list = this.aXF;
            if (list == null || list.isEmpty()) {
                return null;
            }
            Object[] objArr = new Object[this.aXF.size()];
            for (int i6 = 0; i6 < this.aXF.size(); i6++) {
                objArr[i6] = this.aXF.get(i6).getValue();
            }
            return objArr;
        }
    }

    public final boolean Pb() {
        if (this.aXq != null || !TextUtils.isEmpty(this.aXr) || !TextUtils.isEmpty(this.aXs) || !TextUtils.isEmpty(this.aXu)) {
            return false;
        }
        C0706b c0706b = this.aXv;
        if (c0706b != null && !c0706b.Pb()) {
            return false;
        }
        b bVar = this.aXw;
        return bVar == null || bVar.Pb();
    }
}
