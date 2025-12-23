package com.bytedance.msdk.api.r;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class vl {
    private String ae;
    private boolean cw;

    /* renamed from: g, reason: collision with root package name */
    private String f24397g;

    /* renamed from: j, reason: collision with root package name */
    private boolean f24398j;

    /* renamed from: m, reason: collision with root package name */
    private String[] f24399m;

    /* renamed from: r, reason: collision with root package name */
    private boolean f24400r;
    private Map<String, String> tl;
    private int[] up;
    private int xt;

    /* renamed from: com.bytedance.msdk.api.r.vl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class j {

        /* renamed from: j, reason: collision with root package name */
        private boolean f24402j = false;
        private int xt = 0;
        private boolean cw = true;

        /* renamed from: r, reason: collision with root package name */
        private boolean f24404r = false;
        private int[] up = {4, 3, 5};

        /* renamed from: m, reason: collision with root package name */
        private String[] f24403m = new String[0];
        private String ae = "";
        private final Map<String, String> tl = new HashMap();

        /* renamed from: g, reason: collision with root package name */
        private String f24401g = "";

        public j j(boolean z5) {
            this.f24402j = z5;
            return this;
        }

        public j xt(boolean z5) {
            this.cw = z5;
            return this;
        }

        public j j(int i6) {
            this.xt = i6;
            return this;
        }

        public j xt(@NonNull String str) {
            this.f24401g = str;
            return this;
        }

        public j j(@NonNull int... iArr) {
            this.up = iArr;
            return this;
        }

        public j j(@NonNull String str) {
            this.ae = str;
            return this;
        }

        public j j(@NonNull Map<String, String> map) {
            this.tl.putAll(map);
            return this;
        }

        public vl j() {
            return new vl(this, null);
        }
    }

    /* synthetic */ vl(j jVar, AnonymousClass1 anonymousClass1) {
        this(jVar);
    }

    private vl(j jVar) {
        this.f24398j = jVar.f24402j;
        this.xt = jVar.xt;
        this.cw = jVar.cw;
        this.f24400r = jVar.f24404r;
        this.up = jVar.up;
        this.f24399m = jVar.f24403m;
        this.ae = jVar.ae;
        this.tl = jVar.tl;
        this.f24397g = jVar.f24401g;
    }

    @Nullable
    public String ae() {
        return this.ae;
    }

    public boolean cw() {
        return this.cw;
    }

    @Nullable
    public String g() {
        return this.f24397g;
    }

    public boolean j() {
        return this.f24398j;
    }

    @Nullable
    public String[] m() {
        return this.f24399m;
    }

    public boolean r() {
        return this.f24400r;
    }

    @NonNull
    public Map<String, String> tl() {
        return this.tl;
    }

    public int[] up() {
        return this.up;
    }

    public int xt() {
        return this.xt;
    }
}
