package com.bumptech.glide.request;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface RequestCoordinator {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum RequestState {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);

        private final boolean isComplete;

        boolean isComplete() {
            return this.isComplete;
        }

        RequestState(boolean z5) {
            this.isComplete = z5;
        }
    }

    boolean a();

    void b(e eVar);

    boolean c(e eVar);

    boolean d(e eVar);

    void g(e eVar);

    RequestCoordinator getRoot();

    boolean i(e eVar);
}
