package com.bytedance.sdk.openadsdk.i.cw.cw;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r {
    public final PluginValueSet xt;

    public static class j {

        /* renamed from: j, reason: collision with root package name */
        private final e f31381j = e.a();

        public j cw(boolean z5) {
            this.f31381j.h(262104, z5);
            return this;
        }

        public j j(boolean z5) {
            this.f31381j.h(262101, z5);
            return this;
        }

        public j r(boolean z5) {
            this.f31381j.h(262106, z5);
            return this;
        }

        public j xt(boolean z5) {
            this.f31381j.h(262103, z5);
            return this;
        }

        public j ae(boolean z5) {
            this.f31381j.h(262111, z5);
            return this;
        }

        public j cw(String str) {
            this.f31381j.g(262109, str);
            return this;
        }

        public j j(cw cwVar) {
            this.f31381j.f(262102, cwVar);
            return this;
        }

        public j m(boolean z5) {
            this.f31381j.h(262110, z5);
            return this;
        }

        public j r(String str) {
            this.f31381j.g(262112, str);
            return this;
        }

        public j up(boolean z5) {
            this.f31381j.h(262108, z5);
            return this;
        }

        public j xt(String str) {
            this.f31381j.g(262107, str);
            return this;
        }

        public j j(String str) {
            this.f31381j.g(262105, str);
            return this;
        }

        public r j() {
            return new r(this.f31381j.k().sparseArray());
        }
    }

    public boolean ae() {
        return this.xt.booleanValue(262111);
    }

    public com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.xt av() {
        return new com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.xt((SparseArray) this.xt.objectValue(262113, SparseArray.class));
    }

    public Map<String, Object> az() {
        return (Map) this.xt.objectValue(262119, Map.class);
    }

    public boolean cw() {
        return this.xt.booleanValue(262104);
    }

    public cw g() {
        return new cw((SparseArray) this.xt.objectValue(262102, SparseArray.class));
    }

    public boolean j() {
        return this.xt.booleanValue(262101);
    }

    public boolean jy() {
        return this.xt.booleanValue(262121);
    }

    public boolean m() {
        return this.xt.booleanValue(262110);
    }

    public String oq() {
        return (String) this.xt.objectValue(262105, String.class);
    }

    public String qv() {
        return (String) this.xt.objectValue(262107, String.class);
    }

    public boolean r() {
        return this.xt.booleanValue(262106);
    }

    public boolean tl() {
        return this.xt.booleanValue(262120);
    }

    public boolean up() {
        return this.xt.booleanValue(262108);
    }

    public String vl() {
        return (String) this.xt.objectValue(262109, String.class);
    }

    public String ws() {
        return (String) this.xt.objectValue(262112, String.class);
    }

    public boolean xt() {
        return this.xt.booleanValue(262103);
    }

    public r(SparseArray<Object> sparseArray) {
        this.xt = e.i(sparseArray).k();
    }
}
