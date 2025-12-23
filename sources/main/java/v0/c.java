package v0;

import com.bytedance.android.metrics.ActionType;
import com.bytedance.android.metrics.EnterFromMerge;
import com.bytedance.android.metrics.EnterMethod;

/* loaded from: D:\Downloads\app\classes4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private long f54689a;

    /* renamed from: b, reason: collision with root package name */
    private String f54690b;

    /* renamed from: c, reason: collision with root package name */
    private String f54691c;

    /* renamed from: d, reason: collision with root package name */
    private EnterFromMerge f54692d;

    /* renamed from: e, reason: collision with root package name */
    private EnterMethod f54693e;

    /* renamed from: f, reason: collision with root package name */
    private ActionType f54694f;

    /* renamed from: g, reason: collision with root package name */
    private long f54695g;

    public ActionType a() {
        return this.f54694f;
    }

    public String b() {
        return this.f54690b;
    }

    public long c() {
        return this.f54695g;
    }

    public EnterFromMerge d() {
        return this.f54692d;
    }

    public EnterMethod e() {
        return this.f54693e;
    }

    public String f() {
        return this.f54691c;
    }

    public long g() {
        return this.f54689a;
    }

    public void h(ActionType actionType) {
        this.f54694f = actionType;
    }

    public void i(String str) {
        this.f54690b = str;
    }

    public void j(long j6) {
        this.f54695g = j6;
    }

    public void k(EnterFromMerge enterFromMerge) {
        this.f54692d = enterFromMerge;
    }

    public void l(EnterMethod enterMethod) {
        this.f54693e = enterMethod;
    }

    public void m(String str) {
        this.f54691c = str;
    }

    public void n(long j6) {
        this.f54689a = j6;
    }

    public c(long j6, String str, String str2, EnterFromMerge enterFromMerge, EnterMethod enterMethod, ActionType actionType, long j7) {
        this.f54689a = j6;
        this.f54690b = str;
        this.f54691c = str2;
        this.f54692d = enterFromMerge;
        this.f54693e = enterMethod;
        this.f54694f = actionType;
        this.f54695g = j7;
    }
}
