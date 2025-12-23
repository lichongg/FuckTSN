package junit.framework;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class b {

    /* renamed from: f, reason: collision with root package name */
    private static final String f43470f = "...";

    /* renamed from: g, reason: collision with root package name */
    private static final String f43471g = "]";

    /* renamed from: h, reason: collision with root package name */
    private static final String f43472h = "[";

    /* renamed from: a, reason: collision with root package name */
    private int f43473a;

    /* renamed from: b, reason: collision with root package name */
    private String f43474b;

    /* renamed from: c, reason: collision with root package name */
    private String f43475c;

    /* renamed from: d, reason: collision with root package name */
    private int f43476d;

    /* renamed from: e, reason: collision with root package name */
    private int f43477e;

    private void f() {
        this.f43476d = 0;
        int min = Math.min(this.f43474b.length(), this.f43475c.length());
        while (true) {
            int i6 = this.f43476d;
            if (i6 >= min || this.f43474b.charAt(i6) != this.f43475c.charAt(this.f43476d)) {
                return;
            } else {
                this.f43476d++;
            }
        }
    }

    private boolean a() {
        return this.f43474b.equals(this.f43475c);
    }

    private String c(String str) {
        String str2 = f43472h + str.substring(this.f43476d, (str.length() - this.f43477e) + 1) + f43471g;
        if (this.f43476d > 0) {
            str2 = d() + str2;
        }
        if (this.f43477e <= 0) {
            return str2;
        }
        return str2 + e();
    }

    private String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f43476d > this.f43473a ? f43470f : "");
        sb.append(this.f43474b.substring(Math.max(0, this.f43476d - this.f43473a), this.f43476d));
        return sb.toString();
    }

    private String e() {
        int min = Math.min((this.f43474b.length() - this.f43477e) + 1 + this.f43473a, this.f43474b.length());
        StringBuilder sb = new StringBuilder();
        String str = this.f43474b;
        sb.append(str.substring((str.length() - this.f43477e) + 1, min));
        sb.append((this.f43474b.length() - this.f43477e) + 1 < this.f43474b.length() - this.f43473a ? f43470f : "");
        return sb.toString();
    }

    private void g() {
        int length = this.f43474b.length() - 1;
        int length2 = this.f43475c.length() - 1;
        while (true) {
            int i6 = this.f43476d;
            if (length2 < i6 || length < i6 || this.f43474b.charAt(length) != this.f43475c.charAt(length2)) {
                break;
            }
            length2--;
            length--;
        }
        this.f43477e = this.f43474b.length() - length;
    }

    public String b(String str) {
        if (this.f43474b == null || this.f43475c == null || a()) {
            return a.N(str, this.f43474b, this.f43475c);
        }
        f();
        g();
        return a.N(str, c(this.f43474b), c(this.f43475c));
    }

    public b(int i6, String str, String str2) {
        this.f43473a = i6;
        this.f43474b = str;
        this.f43475c = str2;
    }
}
