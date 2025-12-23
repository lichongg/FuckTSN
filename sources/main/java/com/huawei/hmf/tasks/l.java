package com.huawei.hmf.tasks;

/* loaded from: D:\Downloads\app\classes5.dex */
public class l<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private final com.huawei.hmf.tasks.a.i<TResult> f33090a = new com.huawei.hmf.tasks.a.i<>();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.f33090a.B();
        }
    }

    public l() {
    }

    public l(b bVar) {
        bVar.b(new a());
    }

    public k<TResult> b() {
        return this.f33090a;
    }

    public void c(Exception exc) {
        this.f33090a.z(exc);
    }

    public void setResult(TResult tresult) {
        this.f33090a.A(tresult);
    }
}
