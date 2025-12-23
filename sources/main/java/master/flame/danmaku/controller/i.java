package master.flame.danmaku.controller;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class i extends Thread {

    /* renamed from: a, reason: collision with root package name */
    volatile boolean f49912a;

    public void b() {
        this.f49912a = true;
    }

    public boolean a() {
        return this.f49912a;
    }

    public i(String str) {
        super(str);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
    }
}
