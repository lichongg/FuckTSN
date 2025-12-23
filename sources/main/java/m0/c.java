package m0;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Entity(indices = {@Index({"type"}), @Index({"isShowIndex"}), @Index({"mkey"}), @Index({"sort"}), @Index({"homeSort"}), @Index({"type", "sort"}), @Index({"isShowIndex", "homeSort"})}, tableName = "menu")
/* loaded from: D:\Downloads\app\classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @PrimaryKey
    @ColumnInfo(name = "mkey", typeAffinity = 2)
    @NotNull
    private String f49699a;

    /* renamed from: b, reason: collision with root package name */
    @ColumnInfo(name = CommonNetImpl.NAME, typeAffinity = 2)
    @NotNull
    private String f49700b;

    /* renamed from: c, reason: collision with root package name */
    @ColumnInfo(name = "icon", typeAffinity = 2)
    @NotNull
    private String f49701c;

    /* renamed from: d, reason: collision with root package name */
    @ColumnInfo(name = "iconS", typeAffinity = 2)
    @NotNull
    private String f49702d;

    /* renamed from: e, reason: collision with root package name */
    @ColumnInfo(name = "isShow", typeAffinity = 2)
    @NotNull
    private String f49703e;

    /* renamed from: f, reason: collision with root package name */
    @ColumnInfo(name = "isEnabled", typeAffinity = 2)
    @NotNull
    private String f49704f;

    /* renamed from: g, reason: collision with root package name */
    @ColumnInfo(name = "isLogin", typeAffinity = 3)
    private int f49705g;

    /* renamed from: h, reason: collision with root package name */
    @ColumnInfo(name = "linkUrl", typeAffinity = 2)
    @NotNull
    private String f49706h;

    /* renamed from: i, reason: collision with root package name */
    @ColumnInfo(name = "type", typeAffinity = 2)
    @NotNull
    private String f49707i;

    /* renamed from: j, reason: collision with root package name */
    @ColumnInfo(name = "lastUploadTime", typeAffinity = 2)
    @NotNull
    private String f49708j;

    /* renamed from: k, reason: collision with root package name */
    @ColumnInfo(name = "sort", typeAffinity = 2)
    @NotNull
    private String f49709k;

    /* renamed from: l, reason: collision with root package name */
    @ColumnInfo(name = "isShowIndex", typeAffinity = 2)
    @NotNull
    private String f49710l;

    /* renamed from: m, reason: collision with root package name */
    @ColumnInfo(name = "homeSort", typeAffinity = 2)
    @NotNull
    private String f49711m;

    /* renamed from: n, reason: collision with root package name */
    @ColumnInfo(name = "isShowH5Title", typeAffinity = 2)
    @NotNull
    private String f49712n;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return g0.g(this.f49699a, cVar.f49699a) && g0.g(this.f49700b, cVar.f49700b) && g0.g(this.f49701c, cVar.f49701c) && g0.g(this.f49702d, cVar.f49702d) && g0.g(this.f49703e, cVar.f49703e) && g0.g(this.f49704f, cVar.f49704f) && this.f49705g == cVar.f49705g && g0.g(this.f49706h, cVar.f49706h) && g0.g(this.f49707i, cVar.f49707i) && g0.g(this.f49708j, cVar.f49708j) && g0.g(this.f49709k, cVar.f49709k) && g0.g(this.f49710l, cVar.f49710l) && g0.g(this.f49711m, cVar.f49711m) && g0.g(this.f49712n, cVar.f49712n);
    }

    public c(@NotNull String mkey, @NotNull String name, @NotNull String icon, @NotNull String iconS, @NotNull String isShow, @NotNull String isEnabled, int i6, @NotNull String linkUrl, @NotNull String type, @NotNull String lastUploadTime, @NotNull String sort, @NotNull String isShowIndex, @NotNull String homeSort, @NotNull String isShowH5Title) {
        g0.p(mkey, "mkey");
        g0.p(name, "name");
        g0.p(icon, "icon");
        g0.p(iconS, "iconS");
        g0.p(isShow, "isShow");
        g0.p(isEnabled, "isEnabled");
        g0.p(linkUrl, "linkUrl");
        g0.p(type, "type");
        g0.p(lastUploadTime, "lastUploadTime");
        g0.p(sort, "sort");
        g0.p(isShowIndex, "isShowIndex");
        g0.p(homeSort, "homeSort");
        g0.p(isShowH5Title, "isShowH5Title");
        this.f49699a = mkey;
        this.f49700b = name;
        this.f49701c = icon;
        this.f49702d = iconS;
        this.f49703e = isShow;
        this.f49704f = isEnabled;
        this.f49705g = i6;
        this.f49706h = linkUrl;
        this.f49707i = type;
        this.f49708j = lastUploadTime;
        this.f49709k = sort;
        this.f49710l = isShowIndex;
        this.f49711m = homeSort;
        this.f49712n = isShowH5Title;
    }

    @NotNull
    public final String A() {
        return this.f49703e;
    }

    @NotNull
    public final String B() {
        return this.f49712n;
    }

    @NotNull
    public final String C() {
        return this.f49710l;
    }

    public final void D(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49704f = str;
    }

    public final void E(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49711m = str;
    }

    public final void F(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49701c = str;
    }

    public final void G(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49702d = str;
    }

    public final void H(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49708j = str;
    }

    public final void I(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49706h = str;
    }

    public final void J(int i6) {
        this.f49705g = i6;
    }

    public final void K(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49699a = str;
    }

    public final void L(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49700b = str;
    }

    public final void M(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49703e = str;
    }

    public final void N(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49712n = str;
    }

    public final void O(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49710l = str;
    }

    public final void P(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49709k = str;
    }

    public final void Q(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49707i = str;
    }

    @NotNull
    public final String a() {
        return this.f49699a;
    }

    @NotNull
    public final String b() {
        return this.f49708j;
    }

    @NotNull
    public final String c() {
        return this.f49709k;
    }

    @NotNull
    public final String d() {
        return this.f49710l;
    }

    @NotNull
    public final String e() {
        return this.f49711m;
    }

    @NotNull
    public final String f() {
        return this.f49712n;
    }

    @NotNull
    public final String g() {
        return this.f49700b;
    }

    @NotNull
    public final String getType() {
        return this.f49707i;
    }

    @NotNull
    public final String h() {
        return this.f49701c;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.f49699a.hashCode() * 31) + this.f49700b.hashCode()) * 31) + this.f49701c.hashCode()) * 31) + this.f49702d.hashCode()) * 31) + this.f49703e.hashCode()) * 31) + this.f49704f.hashCode()) * 31) + this.f49705g) * 31) + this.f49706h.hashCode()) * 31) + this.f49707i.hashCode()) * 31) + this.f49708j.hashCode()) * 31) + this.f49709k.hashCode()) * 31) + this.f49710l.hashCode()) * 31) + this.f49711m.hashCode()) * 31) + this.f49712n.hashCode();
    }

    @NotNull
    public final String i() {
        return this.f49702d;
    }

    @NotNull
    public final String j() {
        return this.f49703e;
    }

    @NotNull
    public final String k() {
        return this.f49704f;
    }

    public final int l() {
        return this.f49705g;
    }

    @NotNull
    public final String m() {
        return this.f49706h;
    }

    @NotNull
    public final String n() {
        return this.f49707i;
    }

    @NotNull
    public final c o(@NotNull String mkey, @NotNull String name, @NotNull String icon, @NotNull String iconS, @NotNull String isShow, @NotNull String isEnabled, int i6, @NotNull String linkUrl, @NotNull String type, @NotNull String lastUploadTime, @NotNull String sort, @NotNull String isShowIndex, @NotNull String homeSort, @NotNull String isShowH5Title) {
        g0.p(mkey, "mkey");
        g0.p(name, "name");
        g0.p(icon, "icon");
        g0.p(iconS, "iconS");
        g0.p(isShow, "isShow");
        g0.p(isEnabled, "isEnabled");
        g0.p(linkUrl, "linkUrl");
        g0.p(type, "type");
        g0.p(lastUploadTime, "lastUploadTime");
        g0.p(sort, "sort");
        g0.p(isShowIndex, "isShowIndex");
        g0.p(homeSort, "homeSort");
        g0.p(isShowH5Title, "isShowH5Title");
        return new c(mkey, name, icon, iconS, isShow, isEnabled, i6, linkUrl, type, lastUploadTime, sort, isShowIndex, homeSort, isShowH5Title);
    }

    @NotNull
    public final String q() {
        return this.f49711m;
    }

    @NotNull
    public final String r() {
        return this.f49701c;
    }

    @NotNull
    public final String s() {
        return this.f49702d;
    }

    @NotNull
    public final String t() {
        return this.f49708j;
    }

    @NotNull
    public String toString() {
        return "MenuDb(mkey=" + this.f49699a + ", name=" + this.f49700b + ", icon=" + this.f49701c + ", iconS=" + this.f49702d + ", isShow=" + this.f49703e + ", isEnabled=" + this.f49704f + ", isLogin=" + this.f49705g + ", linkUrl=" + this.f49706h + ", type=" + this.f49707i + ", lastUploadTime=" + this.f49708j + ", sort=" + this.f49709k + ", isShowIndex=" + this.f49710l + ", homeSort=" + this.f49711m + ", isShowH5Title=" + this.f49712n + ")";
    }

    @NotNull
    public final String u() {
        return this.f49706h;
    }

    @NotNull
    public final String v() {
        return this.f49699a;
    }

    @NotNull
    public final String w() {
        return this.f49700b;
    }

    @NotNull
    public final String x() {
        return this.f49709k;
    }

    @NotNull
    public final String y() {
        return this.f49704f;
    }

    public final int z() {
        return this.f49705g;
    }
}
