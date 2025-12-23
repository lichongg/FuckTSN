package com.bytedance.msdk.api.r;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.r.r;
import com.bytedance.msdk.api.r.tl;
import com.bytedance.msdk.api.r.vl;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    private tl ae;
    private boolean av;
    private PluginValueSet az;
    private boolean cw;

    /* renamed from: g, reason: collision with root package name */
    private m f24347g;

    /* renamed from: j, reason: collision with root package name */
    private String f24348j;
    private JSONObject jy;

    /* renamed from: m, reason: collision with root package name */
    private vl f24349m;
    private Map<String, Object> oq;
    private boolean qv;

    /* renamed from: r, reason: collision with root package name */
    private String f24350r;
    private r tl;
    private boolean up;
    private boolean vl;
    private Map<String, Object> ws;
    private String xt;

    /* renamed from: com.bytedance.msdk.api.r.j$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* renamed from: com.bytedance.msdk.api.r.j$j, reason: collision with other inner class name */
    public static class C0347j {
        private tl ae;
        private boolean av;
        private PluginValueSet az;

        /* renamed from: g, reason: collision with root package name */
        private m f24363g;

        /* renamed from: j, reason: collision with root package name */
        private String f24364j;
        private JSONObject jy;

        /* renamed from: m, reason: collision with root package name */
        private vl f24365m;
        private Map<String, Object> oq;
        private r tl;
        private Map<String, Object> ws;
        private String xt;
        private boolean cw = false;

        /* renamed from: r, reason: collision with root package name */
        private String f24366r = "";
        private boolean up = false;
        private boolean qv = false;
        private boolean vl = false;

        public C0347j cw(@NonNull String str) {
            this.f24366r = str;
            return this;
        }

        public C0347j j(String str) {
            this.f24364j = str;
            return this;
        }

        public C0347j r(boolean z5) {
            this.av = z5;
            return this;
        }

        public C0347j xt(String str) {
            this.xt = str;
            return this;
        }

        public C0347j cw(boolean z5) {
            this.qv = z5;
            return this;
        }

        public C0347j j(boolean z5) {
            this.cw = z5;
            return this;
        }

        public C0347j xt(boolean z5) {
            this.up = z5;
            return this;
        }

        public C0347j j(@NonNull vl vlVar) {
            this.f24365m = vlVar;
            return this;
        }

        public C0347j j(@NonNull tl tlVar) {
            this.ae = tlVar;
            return this;
        }

        public C0347j j(@NonNull m mVar) {
            this.f24363g = mVar;
            return this;
        }

        public C0347j j(Map<String, Object> map) {
            if (map != null && !map.isEmpty()) {
                if (this.oq == null) {
                    this.oq = new HashMap();
                }
                this.oq.putAll(map);
            }
            return this;
        }

        public C0347j j(JSONObject jSONObject) {
            this.jy = jSONObject;
            return this;
        }

        public C0347j j(PluginValueSet pluginValueSet) {
            this.az = pluginValueSet;
            return this;
        }

        public j j() {
            return new j(this, null);
        }
    }

    /* synthetic */ j(C0347j c0347j, AnonymousClass1 anonymousClass1) {
        this(c0347j);
    }

    private j(C0347j c0347j) {
        this.f24348j = c0347j.f24364j;
        this.xt = c0347j.xt;
        this.cw = c0347j.cw;
        this.f24350r = c0347j.f24366r;
        this.up = c0347j.up;
        if (c0347j.f24365m != null) {
            this.f24349m = c0347j.f24365m;
        } else {
            this.f24349m = new vl.j().j();
        }
        if (c0347j.ae != null) {
            this.ae = c0347j.ae;
        } else {
            this.ae = new tl.j().j();
        }
        if (c0347j.tl != null) {
            this.tl = c0347j.tl;
        } else {
            this.tl = new r.j().j();
        }
        if (c0347j.f24363g != null) {
            this.f24347g = c0347j.f24363g;
        } else {
            this.f24347g = new m();
        }
        this.oq = c0347j.oq;
        this.qv = c0347j.qv;
        this.vl = c0347j.vl;
        this.jy = c0347j.jy;
        this.ws = c0347j.ws;
        this.az = c0347j.az;
        this.av = c0347j.av;
    }

    @NonNull
    public tl ae() {
        return this.ae;
    }

    public boolean av() {
        return this.av;
    }

    public PluginValueSet az() {
        return this.az;
    }

    public boolean cw() {
        return this.cw;
    }

    @NonNull
    public m g() {
        return this.f24347g;
    }

    @Nullable
    public String j() {
        return this.f24348j;
    }

    @Nullable
    public JSONObject jy() {
        return this.jy;
    }

    @NonNull
    public vl m() {
        return this.f24349m;
    }

    @Nullable
    public Map<String, Object> oq() {
        return this.oq;
    }

    public boolean qv() {
        return this.qv;
    }

    @Nullable
    public String r() {
        return this.f24350r;
    }

    @Nullable
    public r tl() {
        return this.tl;
    }

    public boolean up() {
        return this.up;
    }

    public boolean vl() {
        return this.vl;
    }

    @Nullable
    public Map<String, Object> ws() {
        return this.ws;
    }

    @Nullable
    public String xt() {
        return this.xt;
    }
}
