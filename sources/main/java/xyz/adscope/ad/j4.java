package xyz.adscope.ad;

import xyz.adscope.common.v2.model.IDeepCopyModel;
import xyz.adscope.common.v2.tool.str.SerialUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class j4 implements IDeepCopyModel {

    /* renamed from: a, reason: collision with root package name */
    private final String f55271a;

    /* renamed from: b, reason: collision with root package name */
    private long f55272b;

    /* renamed from: c, reason: collision with root package name */
    private long f55273c;

    /* renamed from: d, reason: collision with root package name */
    private String f55274d;

    public j4() {
        this.f55272b = -1L;
        this.f55273c = -1L;
        this.f55271a = SerialUtil.generateStartSerialID();
    }

    public void a(String str) {
        this.f55274d = str;
    }

    public void b(long j6) {
        this.f55272b = j6;
        this.f55273c = -1L;
    }

    public void a(long j6) {
        this.f55273c = j6;
    }

    public long c() {
        return this.f55272b;
    }

    public String d() {
        return this.f55274d;
    }

    public long e() {
        long j6 = this.f55272b;
        if (j6 == -1) {
            return 0L;
        }
        long j7 = this.f55273c;
        if (j7 != -1) {
            return j7 - j6;
        }
        return 0L;
    }

    public String f() {
        return this.f55271a;
    }

    @Override // xyz.adscope.common.v2.model.IDeepCopyModel
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public j4 deepCopy() {
        return new j4(this);
    }

    public long b() {
        return this.f55273c;
    }

    private j4(j4 j4Var) {
        this.f55272b = -1L;
        this.f55273c = -1L;
        this.f55271a = j4Var.f55271a;
        this.f55272b = j4Var.c();
        this.f55273c = j4Var.b();
        this.f55274d = j4Var.d();
    }
}
