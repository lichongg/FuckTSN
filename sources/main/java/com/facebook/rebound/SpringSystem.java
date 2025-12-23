package com.facebook.rebound;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class SpringSystem extends BaseSpringSystem {
    public static SpringSystem m() {
        return new SpringSystem(AndroidSpringLooperFactory.a());
    }

    private SpringSystem(SpringLooper springLooper) {
        super(springLooper);
    }
}
