package m0;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.umeng.analytics.AnalyticsConfig;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Entity(tableName = "sports")
/* loaded from: D:\Downloads\app\classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @PrimaryKey
    @ColumnInfo(name = "identify", typeAffinity = 2)
    @NotNull
    private String f49713a;

    /* renamed from: b, reason: collision with root package name */
    @ColumnInfo(name = "userNumber", typeAffinity = 2)
    @NotNull
    private String f49714b;

    /* renamed from: c, reason: collision with root package name */
    @ColumnInfo(name = "sportsType", typeAffinity = 2)
    @NotNull
    private String f49715c;

    /* renamed from: d, reason: collision with root package name */
    @ColumnInfo(name = "sportsSet", typeAffinity = 2)
    @NotNull
    private String f49716d;

    /* renamed from: e, reason: collision with root package name */
    @ColumnInfo(name = AnalyticsConfig.RTD_START_TIME, typeAffinity = 2)
    @NotNull
    private String f49717e;

    /* renamed from: f, reason: collision with root package name */
    @ColumnInfo(name = "endTime", typeAffinity = 2)
    @NotNull
    private String f49718f;

    /* renamed from: g, reason: collision with root package name */
    @ColumnInfo(name = "countTime", typeAffinity = 2)
    @NotNull
    private String f49719g;

    /* renamed from: h, reason: collision with root package name */
    @ColumnInfo(name = "distance", typeAffinity = 2)
    @NotNull
    private String f49720h;

    /* renamed from: i, reason: collision with root package name */
    @ColumnInfo(name = "gpsDistance", typeAffinity = 2)
    @NotNull
    private String f49721i;

    /* renamed from: j, reason: collision with root package name */
    @ColumnInfo(name = "latLngList", typeAffinity = 2)
    @NotNull
    private String f49722j;

    /* renamed from: k, reason: collision with root package name */
    @ColumnInfo(name = "stepList", typeAffinity = 2)
    @NotNull
    private String f49723k;

    /* renamed from: l, reason: collision with root package name */
    @ColumnInfo(name = "passLatLngList", typeAffinity = 2)
    @NotNull
    private String f49724l;

    /* renamed from: m, reason: collision with root package name */
    @ColumnInfo(name = "isFaceOut", typeAffinity = 2)
    @NotNull
    private String f49725m;

    /* renamed from: n, reason: collision with root package name */
    @ColumnInfo(name = "faceDetectCount", typeAffinity = 2)
    @NotNull
    private String f49726n;

    /* renamed from: o, reason: collision with root package name */
    @ColumnInfo(name = "uploadType", typeAffinity = 2)
    @NotNull
    private String f49727o;

    /* renamed from: p, reason: collision with root package name */
    @ColumnInfo(name = "isException", typeAffinity = 2)
    @NotNull
    private String f49728p;

    /* renamed from: q, reason: collision with root package name */
    @ColumnInfo(name = "startFace", typeAffinity = 2)
    @NotNull
    private String f49729q;

    /* renamed from: r, reason: collision with root package name */
    @ColumnInfo(name = "midFace", typeAffinity = 2)
    @NotNull
    private String f49730r;

    /* renamed from: s, reason: collision with root package name */
    @ColumnInfo(name = "endFace", typeAffinity = 2)
    @NotNull
    private String f49731s;

    /* renamed from: t, reason: collision with root package name */
    @ColumnInfo(defaultValue = "0", name = "isValid", typeAffinity = 2)
    @NotNull
    private String f49732t;

    /* renamed from: u, reason: collision with root package name */
    @ColumnInfo(name = "faceCheckingDistance", typeAffinity = 2)
    @NotNull
    private String f49733u;

    /* renamed from: v, reason: collision with root package name */
    @ColumnInfo(name = "pauseLatLng", typeAffinity = 2)
    @NotNull
    private String f49734v;

    /* renamed from: w, reason: collision with root package name */
    @ColumnInfo(defaultValue = "0", name = "isOpenDevelop", typeAffinity = 2)
    @NotNull
    private String f49735w;

    /* renamed from: x, reason: collision with root package name */
    @ColumnInfo(name = "confirmCount", typeAffinity = 3)
    private int f49736x;

    public d(@NotNull String identify, @NotNull String userNumber, @NotNull String sportsType, @NotNull String sportsSet, @NotNull String startTime, @NotNull String endTime, @NotNull String countTime, @NotNull String distance, @NotNull String gpsDistance, @NotNull String latLngList, @NotNull String stepList, @NotNull String passLatLngList, @NotNull String isFaceOut, @NotNull String faceDetectCount, @NotNull String uploadType, @NotNull String isException, @NotNull String startFace, @NotNull String midFace, @NotNull String endFace, @NotNull String isValid, @NotNull String faceCheckingDistance, @NotNull String pauseLatLng, @NotNull String isOpenDevelop, int i6) {
        g0.p(identify, "identify");
        g0.p(userNumber, "userNumber");
        g0.p(sportsType, "sportsType");
        g0.p(sportsSet, "sportsSet");
        g0.p(startTime, "startTime");
        g0.p(endTime, "endTime");
        g0.p(countTime, "countTime");
        g0.p(distance, "distance");
        g0.p(gpsDistance, "gpsDistance");
        g0.p(latLngList, "latLngList");
        g0.p(stepList, "stepList");
        g0.p(passLatLngList, "passLatLngList");
        g0.p(isFaceOut, "isFaceOut");
        g0.p(faceDetectCount, "faceDetectCount");
        g0.p(uploadType, "uploadType");
        g0.p(isException, "isException");
        g0.p(startFace, "startFace");
        g0.p(midFace, "midFace");
        g0.p(endFace, "endFace");
        g0.p(isValid, "isValid");
        g0.p(faceCheckingDistance, "faceCheckingDistance");
        g0.p(pauseLatLng, "pauseLatLng");
        g0.p(isOpenDevelop, "isOpenDevelop");
        this.f49713a = identify;
        this.f49714b = userNumber;
        this.f49715c = sportsType;
        this.f49716d = sportsSet;
        this.f49717e = startTime;
        this.f49718f = endTime;
        this.f49719g = countTime;
        this.f49720h = distance;
        this.f49721i = gpsDistance;
        this.f49722j = latLngList;
        this.f49723k = stepList;
        this.f49724l = passLatLngList;
        this.f49725m = isFaceOut;
        this.f49726n = faceDetectCount;
        this.f49727o = uploadType;
        this.f49728p = isException;
        this.f49729q = startFace;
        this.f49730r = midFace;
        this.f49731s = endFace;
        this.f49732t = isValid;
        this.f49733u = faceCheckingDistance;
        this.f49734v = pauseLatLng;
        this.f49735w = isOpenDevelop;
        this.f49736x = i6;
    }

    public static /* synthetic */ d z(d dVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, int i6, int i7, Object obj) {
        int i8;
        String str24;
        String str25 = (i7 & 1) != 0 ? dVar.f49713a : str;
        String str26 = (i7 & 2) != 0 ? dVar.f49714b : str2;
        String str27 = (i7 & 4) != 0 ? dVar.f49715c : str3;
        String str28 = (i7 & 8) != 0 ? dVar.f49716d : str4;
        String str29 = (i7 & 16) != 0 ? dVar.f49717e : str5;
        String str30 = (i7 & 32) != 0 ? dVar.f49718f : str6;
        String str31 = (i7 & 64) != 0 ? dVar.f49719g : str7;
        String str32 = (i7 & 128) != 0 ? dVar.f49720h : str8;
        String str33 = (i7 & 256) != 0 ? dVar.f49721i : str9;
        String str34 = (i7 & 512) != 0 ? dVar.f49722j : str10;
        String str35 = (i7 & 1024) != 0 ? dVar.f49723k : str11;
        String str36 = (i7 & 2048) != 0 ? dVar.f49724l : str12;
        String str37 = (i7 & 4096) != 0 ? dVar.f49725m : str13;
        String str38 = (i7 & 8192) != 0 ? dVar.f49726n : str14;
        String str39 = str25;
        String str40 = (i7 & 16384) != 0 ? dVar.f49727o : str15;
        String str41 = (i7 & 32768) != 0 ? dVar.f49728p : str16;
        String str42 = (i7 & 65536) != 0 ? dVar.f49729q : str17;
        String str43 = (i7 & 131072) != 0 ? dVar.f49730r : str18;
        String str44 = (i7 & 262144) != 0 ? dVar.f49731s : str19;
        String str45 = (i7 & 524288) != 0 ? dVar.f49732t : str20;
        String str46 = (i7 & 1048576) != 0 ? dVar.f49733u : str21;
        String str47 = (i7 & 2097152) != 0 ? dVar.f49734v : str22;
        String str48 = (i7 & 4194304) != 0 ? dVar.f49735w : str23;
        if ((i7 & 8388608) != 0) {
            str24 = str48;
            i8 = dVar.f49736x;
        } else {
            i8 = i6;
            str24 = str48;
        }
        return dVar.y(str39, str26, str27, str28, str29, str30, str31, str32, str33, str34, str35, str36, str37, str38, str40, str41, str42, str43, str44, str45, str46, str47, str24, i8);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return g0.g(this.f49713a, dVar.f49713a) && g0.g(this.f49714b, dVar.f49714b) && g0.g(this.f49715c, dVar.f49715c) && g0.g(this.f49716d, dVar.f49716d) && g0.g(this.f49717e, dVar.f49717e) && g0.g(this.f49718f, dVar.f49718f) && g0.g(this.f49719g, dVar.f49719g) && g0.g(this.f49720h, dVar.f49720h) && g0.g(this.f49721i, dVar.f49721i) && g0.g(this.f49722j, dVar.f49722j) && g0.g(this.f49723k, dVar.f49723k) && g0.g(this.f49724l, dVar.f49724l) && g0.g(this.f49725m, dVar.f49725m) && g0.g(this.f49726n, dVar.f49726n) && g0.g(this.f49727o, dVar.f49727o) && g0.g(this.f49728p, dVar.f49728p) && g0.g(this.f49729q, dVar.f49729q) && g0.g(this.f49730r, dVar.f49730r) && g0.g(this.f49731s, dVar.f49731s) && g0.g(this.f49732t, dVar.f49732t) && g0.g(this.f49733u, dVar.f49733u) && g0.g(this.f49734v, dVar.f49734v) && g0.g(this.f49735w, dVar.f49735w) && this.f49736x == dVar.f49736x;
    }

    @NotNull
    public final d y(@NotNull String identify, @NotNull String userNumber, @NotNull String sportsType, @NotNull String sportsSet, @NotNull String startTime, @NotNull String endTime, @NotNull String countTime, @NotNull String distance, @NotNull String gpsDistance, @NotNull String latLngList, @NotNull String stepList, @NotNull String passLatLngList, @NotNull String isFaceOut, @NotNull String faceDetectCount, @NotNull String uploadType, @NotNull String isException, @NotNull String startFace, @NotNull String midFace, @NotNull String endFace, @NotNull String isValid, @NotNull String faceCheckingDistance, @NotNull String pauseLatLng, @NotNull String isOpenDevelop, int i6) {
        g0.p(identify, "identify");
        g0.p(userNumber, "userNumber");
        g0.p(sportsType, "sportsType");
        g0.p(sportsSet, "sportsSet");
        g0.p(startTime, "startTime");
        g0.p(endTime, "endTime");
        g0.p(countTime, "countTime");
        g0.p(distance, "distance");
        g0.p(gpsDistance, "gpsDistance");
        g0.p(latLngList, "latLngList");
        g0.p(stepList, "stepList");
        g0.p(passLatLngList, "passLatLngList");
        g0.p(isFaceOut, "isFaceOut");
        g0.p(faceDetectCount, "faceDetectCount");
        g0.p(uploadType, "uploadType");
        g0.p(isException, "isException");
        g0.p(startFace, "startFace");
        g0.p(midFace, "midFace");
        g0.p(endFace, "endFace");
        g0.p(isValid, "isValid");
        g0.p(faceCheckingDistance, "faceCheckingDistance");
        g0.p(pauseLatLng, "pauseLatLng");
        g0.p(isOpenDevelop, "isOpenDevelop");
        return new d(identify, userNumber, sportsType, sportsSet, startTime, endTime, countTime, distance, gpsDistance, latLngList, stepList, passLatLngList, isFaceOut, faceDetectCount, uploadType, isException, startFace, midFace, endFace, isValid, faceCheckingDistance, pauseLatLng, isOpenDevelop, i6);
    }

    public final int A() {
        return this.f49736x;
    }

    @NotNull
    public final String B() {
        return this.f49719g;
    }

    @NotNull
    public final String C() {
        return this.f49720h;
    }

    @NotNull
    public final String D() {
        return this.f49731s;
    }

    @NotNull
    public final String E() {
        return this.f49718f;
    }

    @NotNull
    public final String F() {
        return this.f49733u;
    }

    @NotNull
    public final String G() {
        return this.f49726n;
    }

    @NotNull
    public final String H() {
        return this.f49721i;
    }

    @NotNull
    public final String I() {
        return this.f49713a;
    }

    @NotNull
    public final String J() {
        return this.f49722j;
    }

    @NotNull
    public final String K() {
        return this.f49730r;
    }

    @NotNull
    public final String L() {
        return this.f49724l;
    }

    @NotNull
    public final String M() {
        return this.f49734v;
    }

    @NotNull
    public final String N() {
        return this.f49716d;
    }

    @NotNull
    public final String O() {
        return this.f49715c;
    }

    @NotNull
    public final String P() {
        return this.f49729q;
    }

    @NotNull
    public final String Q() {
        return this.f49717e;
    }

    @NotNull
    public final String R() {
        return this.f49723k;
    }

    @NotNull
    public final String S() {
        return this.f49727o;
    }

    @NotNull
    public final String T() {
        return this.f49714b;
    }

    @NotNull
    public final String U() {
        return this.f49728p;
    }

    @NotNull
    public final String V() {
        return this.f49725m;
    }

    @NotNull
    public final String W() {
        return this.f49735w;
    }

    @NotNull
    public final String X() {
        return this.f49732t;
    }

    public final void Y(int i6) {
        this.f49736x = i6;
    }

    public final void Z(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49719g = str;
    }

    @NotNull
    public final String a() {
        return this.f49713a;
    }

    public final void a0(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49720h = str;
    }

    @NotNull
    public final String b() {
        return this.f49722j;
    }

    public final void b0(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49731s = str;
    }

    @NotNull
    public final String c() {
        return this.f49723k;
    }

    public final void c0(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49718f = str;
    }

    @NotNull
    public final String d() {
        return this.f49724l;
    }

    public final void d0(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49728p = str;
    }

    @NotNull
    public final String e() {
        return this.f49725m;
    }

    public final void e0(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49733u = str;
    }

    @NotNull
    public final String f() {
        return this.f49726n;
    }

    public final void f0(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49726n = str;
    }

    @NotNull
    public final String g() {
        return this.f49727o;
    }

    public final void g0(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49725m = str;
    }

    @NotNull
    public final String h() {
        return this.f49728p;
    }

    public final void h0(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49721i = str;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((this.f49713a.hashCode() * 31) + this.f49714b.hashCode()) * 31) + this.f49715c.hashCode()) * 31) + this.f49716d.hashCode()) * 31) + this.f49717e.hashCode()) * 31) + this.f49718f.hashCode()) * 31) + this.f49719g.hashCode()) * 31) + this.f49720h.hashCode()) * 31) + this.f49721i.hashCode()) * 31) + this.f49722j.hashCode()) * 31) + this.f49723k.hashCode()) * 31) + this.f49724l.hashCode()) * 31) + this.f49725m.hashCode()) * 31) + this.f49726n.hashCode()) * 31) + this.f49727o.hashCode()) * 31) + this.f49728p.hashCode()) * 31) + this.f49729q.hashCode()) * 31) + this.f49730r.hashCode()) * 31) + this.f49731s.hashCode()) * 31) + this.f49732t.hashCode()) * 31) + this.f49733u.hashCode()) * 31) + this.f49734v.hashCode()) * 31) + this.f49735w.hashCode()) * 31) + this.f49736x;
    }

    @NotNull
    public final String i() {
        return this.f49729q;
    }

    public final void i0(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49713a = str;
    }

    @NotNull
    public final String j() {
        return this.f49730r;
    }

    public final void j0(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49722j = str;
    }

    @NotNull
    public final String k() {
        return this.f49731s;
    }

    public final void k0(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49730r = str;
    }

    @NotNull
    public final String l() {
        return this.f49714b;
    }

    public final void l0(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49735w = str;
    }

    @NotNull
    public final String m() {
        return this.f49732t;
    }

    public final void m0(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49724l = str;
    }

    @NotNull
    public final String n() {
        return this.f49733u;
    }

    public final void n0(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49734v = str;
    }

    @NotNull
    public final String o() {
        return this.f49734v;
    }

    public final void o0(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49716d = str;
    }

    @NotNull
    public final String p() {
        return this.f49735w;
    }

    public final void p0(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49715c = str;
    }

    public final int q() {
        return this.f49736x;
    }

    public final void q0(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49729q = str;
    }

    @NotNull
    public final String r() {
        return this.f49715c;
    }

    public final void r0(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49717e = str;
    }

    @NotNull
    public final String s() {
        return this.f49716d;
    }

    public final void s0(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49723k = str;
    }

    @NotNull
    public final String t() {
        return this.f49717e;
    }

    public final void t0(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49727o = str;
    }

    @NotNull
    public String toString() {
        return "SportsDb(identify=" + this.f49713a + ", userNumber=" + this.f49714b + ", sportsType=" + this.f49715c + ", sportsSet=" + this.f49716d + ", startTime=" + this.f49717e + ", endTime=" + this.f49718f + ", countTime=" + this.f49719g + ", distance=" + this.f49720h + ", gpsDistance=" + this.f49721i + ", latLngList=" + this.f49722j + ", stepList=" + this.f49723k + ", passLatLngList=" + this.f49724l + ", isFaceOut=" + this.f49725m + ", faceDetectCount=" + this.f49726n + ", uploadType=" + this.f49727o + ", isException=" + this.f49728p + ", startFace=" + this.f49729q + ", midFace=" + this.f49730r + ", endFace=" + this.f49731s + ", isValid=" + this.f49732t + ", faceCheckingDistance=" + this.f49733u + ", pauseLatLng=" + this.f49734v + ", isOpenDevelop=" + this.f49735w + ", confirmCount=" + this.f49736x + ")";
    }

    @NotNull
    public final String u() {
        return this.f49718f;
    }

    public final void u0(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49714b = str;
    }

    @NotNull
    public final String v() {
        return this.f49719g;
    }

    public final void v0(@NotNull String str) {
        g0.p(str, "<set-?>");
        this.f49732t = str;
    }

    @NotNull
    public final String w() {
        return this.f49720h;
    }

    @NotNull
    public final String x() {
        return this.f49721i;
    }

    public /* synthetic */ d(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, int i6, int i7, v vVar) {
        this(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, (i7 & 8388608) != 0 ? 0 : i6);
    }
}
