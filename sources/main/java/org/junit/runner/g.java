package org.junit.runner;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class g implements b {
    public abstract void a(org.junit.runner.notification.a aVar);

    @Override // org.junit.runner.b
    public abstract Description getDescription();

    public int c() {
        return getDescription().testCount();
    }
}
