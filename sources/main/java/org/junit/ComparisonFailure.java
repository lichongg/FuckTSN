package org.junit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ComparisonFailure extends AssertionError {
    private static final int MAX_CONTEXT_LENGTH = 20;
    private static final long serialVersionUID = 1;
    private String fActual;
    private String fExpected;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b {

        /* renamed from: d, reason: collision with root package name */
        private static final String f51325d = "...";

        /* renamed from: e, reason: collision with root package name */
        private static final String f51326e = "]";

        /* renamed from: f, reason: collision with root package name */
        private static final String f51327f = "[";

        /* renamed from: a, reason: collision with root package name */
        private final int f51328a;

        /* renamed from: b, reason: collision with root package name */
        private final String f51329b;

        /* renamed from: c, reason: collision with root package name */
        private final String f51330c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        private class a {

            /* renamed from: a, reason: collision with root package name */
            private final String f51331a;

            /* renamed from: b, reason: collision with root package name */
            private final String f51332b;

            /* synthetic */ a(b bVar, a aVar) {
                this();
            }

            private a() {
                String g6 = b.this.g();
                this.f51331a = g6;
                this.f51332b = b.this.h(g6);
            }

            private String e(String str) {
                return b.f51327f + str.substring(this.f51331a.length(), str.length() - this.f51332b.length()) + b.f51326e;
            }

            public String a() {
                return e(b.this.f51330c);
            }

            public String b() {
                if (this.f51331a.length() <= b.this.f51328a) {
                    return this.f51331a;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(b.f51325d);
                String str = this.f51331a;
                sb.append(str.substring(str.length() - b.this.f51328a));
                return sb.toString();
            }

            public String c() {
                if (this.f51332b.length() <= b.this.f51328a) {
                    return this.f51332b;
                }
                return this.f51332b.substring(0, b.this.f51328a) + b.f51325d;
            }

            public String d() {
                return e(b.this.f51329b);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String g() {
            int min = Math.min(this.f51329b.length(), this.f51330c.length());
            for (int i6 = 0; i6 < min; i6++) {
                if (this.f51329b.charAt(i6) != this.f51330c.charAt(i6)) {
                    return this.f51329b.substring(0, i6);
                }
            }
            return this.f51329b.substring(0, min);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String h(String str) {
            int min = Math.min(this.f51329b.length() - str.length(), this.f51330c.length() - str.length()) - 1;
            int i6 = 0;
            while (i6 <= min) {
                if (this.f51329b.charAt((r1.length() - 1) - i6) != this.f51330c.charAt((r2.length() - 1) - i6)) {
                    break;
                }
                i6++;
            }
            String str2 = this.f51329b;
            return str2.substring(str2.length() - i6);
        }

        public String f(String str) {
            String str2;
            String str3 = this.f51329b;
            if (str3 == null || (str2 = this.f51330c) == null || str3.equals(str2)) {
                return org.junit.a.k0(str, this.f51329b, this.f51330c);
            }
            a aVar = new a(this, null);
            String b6 = aVar.b();
            String c6 = aVar.c();
            return org.junit.a.k0(str, b6 + aVar.d() + c6, b6 + aVar.a() + c6);
        }

        public b(int i6, String str, String str2) {
            this.f51328a = i6;
            this.f51329b = str;
            this.f51330c = str2;
        }
    }

    public String getActual() {
        return this.fActual;
    }

    public String getExpected() {
        return this.fExpected;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return new b(20, this.fExpected, this.fActual).f(super.getMessage());
    }

    public ComparisonFailure(String str, String str2, String str3) {
        super(str);
        this.fExpected = str2;
        this.fActual = str3;
    }
}
