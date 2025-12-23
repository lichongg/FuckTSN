package com.sun.mail.imap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private String f39217a;

    /* renamed from: b, reason: collision with root package name */
    private n f39218b;

    public a(String str) {
        this.f39217a = str;
        this.f39218b = new n();
    }

    public String a() {
        return this.f39217a;
    }

    public n b() {
        return this.f39218b;
    }

    public void c(n nVar) {
        this.f39218b = nVar;
    }

    public Object clone() throws CloneNotSupportedException {
        a aVar = (a) super.clone();
        aVar.f39218b = (n) this.f39218b.clone();
        return aVar;
    }

    public a(String str, n nVar) {
        this.f39217a = str;
        this.f39218b = nVar;
    }
}
