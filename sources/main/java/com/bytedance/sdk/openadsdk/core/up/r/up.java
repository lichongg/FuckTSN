package com.bytedance.sdk.openadsdk.core.up.r;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.tj.tl;
import com.kwad.components.offline.api.explore.model.ExploreConstants;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up {
    private static final Map<String, AtomicBoolean> cw = new ConcurrentHashMap();

    /* renamed from: j, reason: collision with root package name */
    j f30880j;
    private final com.bytedance.sdk.openadsdk.core.up.r.j xt;

    public static class j {
        private final boolean cw;

        /* renamed from: j, reason: collision with root package name */
        private final String f30882j;

        /* renamed from: m, reason: collision with root package name */
        private final xt f30883m;

        /* renamed from: r, reason: collision with root package name */
        private final int f30884r;
        private final cw up;
        private final int xt;

        public enum cw {
            KV,
            DB;

            public static cw j(int i6) {
                return i6 != 1 ? DB : KV;
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.core.up.r.up$j$j, reason: collision with other inner class name */
        public static class C0487j {
            private int xt;

            /* renamed from: j, reason: collision with root package name */
            private String f30886j = "Default";
            private boolean cw = true;

            /* renamed from: r, reason: collision with root package name */
            private int f30888r = 1;
            private cw up = cw.DB;

            /* renamed from: m, reason: collision with root package name */
            private xt f30887m = xt.TimeLast;

            public C0487j j(String str) {
                this.f30886j = str;
                return this;
            }

            public C0487j j(boolean z5) {
                this.cw = z5;
                return this;
            }

            public C0487j j(cw cwVar) {
                this.up = cwVar;
                return this;
            }

            public C0487j j(xt xtVar) {
                this.f30887m = xtVar;
                return this;
            }

            public C0487j j(int i6) {
                this.f30888r = i6;
                return this;
            }

            public j j() {
                return new j(this, null);
            }
        }

        public enum xt {
            Random,
            TimeLast,
            CustomPriority;

            public static xt j(int i6) {
                return i6 != 0 ? i6 != 2 ? TimeLast : CustomPriority : Random;
            }
        }

        /* synthetic */ j(C0487j c0487j, AnonymousClass1 anonymousClass1) {
            this(c0487j);
        }

        private j(C0487j c0487j) {
            this.f30882j = c0487j.f30886j;
            this.xt = c0487j.xt;
            this.cw = c0487j.cw;
            this.up = c0487j.up;
            this.f30883m = c0487j.f30887m;
            this.f30884r = c0487j.f30888r;
        }

        public int cw() {
            return this.f30884r;
        }

        public String j() {
            return this.f30882j;
        }

        public xt r() {
            return this.f30883m;
        }

        public boolean xt() {
            return this.cw;
        }
    }

    public static class xt {
        public String cw;

        /* renamed from: j, reason: collision with root package name */
        public long f30891j;

        /* renamed from: r, reason: collision with root package name */
        public int f30892r = 7012;
        public String up;
        public long xt;

        public boolean j() {
            return (TextUtils.isEmpty(this.cw) || this.f30891j == 0) ? false : true;
        }

        public xt(String str, long j6, long j7, String str2) {
            this.f30891j = j6;
            this.xt = j7;
            this.cw = str;
            this.up = str2;
        }
    }

    public void j(String str, xt xtVar, boolean z5, long j6) {
        try {
            this.xt.j(str, xtVar, z5, j6, this.f30880j);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.up.r.up$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ int[] f30881j;

        static {
            int[] iArr = new int[j.cw.values().length];
            f30881j = iArr;
            try {
                iArr[j.cw.KV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30881j[j.cw.DB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private AtomicBoolean r(String str) {
        Map<String, AtomicBoolean> map = cw;
        if (!map.containsKey(str)) {
            map.put(str, new AtomicBoolean(false));
        }
        return map.get(str);
    }

    public xt j(String str, boolean z5, long j6) {
        xt j7;
        try {
            synchronized (r(str)) {
                try {
                    System.currentTimeMillis();
                    j7 = this.xt.j(str, this.f30880j, j6);
                    if (j7 != null && j7.j()) {
                        if (z5) {
                            this.xt.j(str, j7.up, true);
                        }
                        System.currentTimeMillis();
                    }
                } finally {
                }
            }
            return j7;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void xt(String str) {
        try {
            this.xt.j(str, this.f30880j);
        } catch (Throwable unused) {
        }
    }

    public up(int i6) {
        j j6 = j(i6);
        this.f30880j = j6;
        if (AnonymousClass1.f30881j[j6.up.ordinal()] != 1) {
            this.xt = new com.bytedance.sdk.openadsdk.core.up.r.xt();
        } else {
            this.xt = new cw();
        }
    }

    public void cw(String str) {
        try {
            if (r(str).compareAndSet(false, true)) {
                this.xt.xt(str);
            }
        } catch (Throwable unused) {
        }
    }

    public xt j(String str, List<String> list) {
        xt j6;
        try {
            synchronized (r(str)) {
                try {
                    System.currentTimeMillis();
                    j6 = this.xt.j(str, this.f30880j, 0L, list);
                    if (j6 != null && j6.j()) {
                        System.currentTimeMillis();
                    }
                } finally {
                }
            }
            return j6;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void j() {
        try {
            this.xt.j(this.f30880j);
        } catch (Throwable unused) {
        }
    }

    public void j(String str) {
        try {
            this.xt.j(str);
        } catch (Throwable unused) {
        }
    }

    public void j(String str, String str2, boolean z5) {
        try {
            synchronized (r(str)) {
                this.xt.j(str, str2, z5);
            }
        } catch (Throwable unused) {
        }
    }

    public void j(String str, String str2) {
        try {
            synchronized (r(str)) {
                this.xt.j(str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    private j j(int i6) {
        tl.j cw2;
        String str;
        if (i6 == 3 || i6 == 4) {
            cw2 = tl.cw();
            str = ExploreConstants.SCENE_SPLASH;
        } else if (i6 == 7) {
            cw2 = tl.j();
            str = ExploreConstants.SCENE_REWARD;
        } else if (i6 != 8) {
            cw2 = null;
            str = null;
        } else {
            cw2 = tl.xt();
            str = ExploreConstants.SCENE_FULL;
        }
        if (cw2 == null) {
            return new j.C0487j().j();
        }
        return new j.C0487j().j(str).j((i6 == 3 || i6 == 4) ? false : true).j(j.cw.j(cw2.up())).j(j.xt.j(cw2.xt())).j(cw2.cw()).j();
    }
}
