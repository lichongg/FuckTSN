package y;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class b implements Comparable<b> {

    /* renamed from: a, reason: collision with root package name */
    private String f56768a;

    /* renamed from: b, reason: collision with root package name */
    private String f56769b;

    /* renamed from: c, reason: collision with root package name */
    private String f56770c;

    /* renamed from: d, reason: collision with root package name */
    private String f56771d;

    /* renamed from: e, reason: collision with root package name */
    private String f56772e;

    /* renamed from: f, reason: collision with root package name */
    private String f56773f;

    public b() {
    }

    public b(String str, String str2, String str3, String str4) {
        h(str);
        k(str2);
        i(str3);
        j(str4);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        if (this.f56773f.equals("#") && !bVar.b().equals("#")) {
            return 1;
        }
        if (this.f56773f.equals("#") || !bVar.b().equals("#")) {
            return this.f56772e.compareToIgnoreCase(bVar.d());
        }
        return -1;
    }

    public String b() {
        return this.f56773f;
    }

    public String c() {
        return this.f56771d;
    }

    public String d() {
        return this.f56772e;
    }

    public String getId() {
        return this.f56768a;
    }

    public String getName() {
        return this.f56770c;
    }

    public String getType() {
        return this.f56769b;
    }

    public void h(String str) {
        this.f56768a = str;
    }

    public void i(String str) {
        this.f56770c = str;
        String a6 = a.a(str);
        this.f56772e = a6;
        String upperCase = a6.substring(0, 1).toUpperCase();
        this.f56773f = upperCase;
        if (upperCase.matches("[A-Z]")) {
            return;
        }
        this.f56773f = "#";
    }

    public void j(String str) {
        this.f56771d = str;
    }

    public void k(String str) {
        this.f56769b = str;
    }
}
