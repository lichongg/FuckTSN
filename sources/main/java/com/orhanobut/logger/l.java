package com.orhanobut.logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class l implements f {

    /* renamed from: f, reason: collision with root package name */
    private static final int f36493f = 4000;

    /* renamed from: g, reason: collision with root package name */
    private static final int f36494g = 5;

    /* renamed from: h, reason: collision with root package name */
    private static final char f36495h = 9484;

    /* renamed from: i, reason: collision with root package name */
    private static final char f36496i = 9492;

    /* renamed from: j, reason: collision with root package name */
    private static final char f36497j = 9500;

    /* renamed from: k, reason: collision with root package name */
    private static final char f36498k = 9474;

    /* renamed from: l, reason: collision with root package name */
    private static final String f36499l = "────────────────────────────────────────────────────────";

    /* renamed from: m, reason: collision with root package name */
    private static final String f36500m = "┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";

    /* renamed from: n, reason: collision with root package name */
    private static final String f36501n = "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────";

    /* renamed from: o, reason: collision with root package name */
    private static final String f36502o = "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────";

    /* renamed from: p, reason: collision with root package name */
    private static final String f36503p = "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";

    /* renamed from: a, reason: collision with root package name */
    private final int f36504a;

    /* renamed from: b, reason: collision with root package name */
    private final int f36505b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f36506c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final h f36507d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final String f36508e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        int f36509a;

        /* renamed from: b, reason: collision with root package name */
        int f36510b;

        /* renamed from: c, reason: collision with root package name */
        boolean f36511c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        h f36512d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        String f36513e;

        /* synthetic */ b(a aVar) {
            this();
        }

        private b() {
            this.f36509a = 2;
            this.f36510b = 0;
            this.f36511c = true;
            this.f36513e = "PRETTY_LOGGER";
        }

        @NonNull
        public l a() {
            if (this.f36512d == null) {
                this.f36512d = new i();
            }
            return new l(this, null);
        }

        @NonNull
        public b b(@Nullable h hVar) {
            this.f36512d = hVar;
            return this;
        }

        @NonNull
        public b c(int i6) {
            this.f36509a = i6;
            return this;
        }

        @NonNull
        public b d(int i6) {
            this.f36510b = i6;
            return this;
        }

        @NonNull
        public b e(boolean z5) {
            this.f36511c = z5;
            return this;
        }

        @NonNull
        public b f(@Nullable String str) {
            this.f36513e = str;
            return this;
        }
    }

    /* synthetic */ l(b bVar, a aVar) {
        this(bVar);
    }

    private l(@NonNull b bVar) {
        n.a(bVar);
        this.f36504a = bVar.f36509a;
        this.f36505b = bVar.f36510b;
        this.f36506c = bVar.f36511c;
        this.f36507d = bVar.f36512d;
        this.f36508e = bVar.f36513e;
    }

    private void e(int i6, @Nullable String str) {
        f(i6, str, f36502o);
    }

    private void h(int i6, @Nullable String str) {
        f(i6, str, f36503p);
    }

    private void j(int i6, @Nullable String str) {
        f(i6, str, f36501n);
    }

    @NonNull
    public static b k() {
        return new b(null);
    }

    @Nullable
    private String b(@Nullable String str) {
        if (!n.d(str) && !n.b(this.f36508e, str)) {
            return this.f36508e + "-" + str;
        }
        return this.f36508e;
    }

    private String c(@NonNull String str) {
        n.a(str);
        return str.substring(str.lastIndexOf(".") + 1);
    }

    private int d(@NonNull StackTraceElement[] stackTraceElementArr) {
        n.a(stackTraceElementArr);
        for (int i6 = 5; i6 < stackTraceElementArr.length; i6++) {
            String className = stackTraceElementArr[i6].getClassName();
            if (!className.equals(k.class.getName()) && !className.equals(j.class.getName())) {
                return i6 - 1;
            }
        }
        return -1;
    }

    private void f(int i6, @Nullable String str, @NonNull String str2) {
        n.a(str2);
        this.f36507d.a(i6, str, str2);
    }

    private void g(int i6, @Nullable String str, @NonNull String str2) {
        n.a(str2);
        for (String str3 : str2.split(System.getProperty("line.separator"))) {
            f(i6, str, "│ " + str3);
        }
    }

    private void i(int i6, @Nullable String str, int i7) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (this.f36506c) {
            f(i6, str, "│ Thread: " + Thread.currentThread().getName());
            h(i6, str);
        }
        int d6 = d(stackTrace) + this.f36505b;
        if (i7 + d6 > stackTrace.length) {
            i7 = (stackTrace.length - d6) - 1;
        }
        String str2 = "";
        while (i7 > 0) {
            int i8 = i7 + d6;
            if (i8 < stackTrace.length) {
                str2 = str2 + "   ";
                f(i6, str, f36498k + ' ' + str2 + c(stackTrace[i8].getClassName()) + "." + stackTrace[i8].getMethodName() + "  (" + stackTrace[i8].getFileName() + ":" + stackTrace[i8].getLineNumber() + ")");
            }
            i7--;
        }
    }

    @Override // com.orhanobut.logger.f
    public void a(int i6, @Nullable String str, @NonNull String str2) {
        n.a(str2);
        String b6 = b(str);
        j(i6, b6);
        i(i6, b6, this.f36504a);
        byte[] bytes = str2.getBytes();
        int length = bytes.length;
        if (length <= 4000) {
            if (this.f36504a > 0) {
                h(i6, b6);
            }
            g(i6, b6, str2);
            e(i6, b6);
            return;
        }
        if (this.f36504a > 0) {
            h(i6, b6);
        }
        for (int i7 = 0; i7 < length; i7 += 4000) {
            g(i6, b6, new String(bytes, i7, Math.min(length - i7, 4000)));
        }
        e(i6, b6);
    }
}
