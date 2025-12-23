package xyz.adscope.common.network.connect;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface Network {
    public static final Network DEFAULT = new Network() { // from class: xyz.adscope.common.network.connect.Network.1
        @Override // xyz.adscope.common.network.connect.Network
        public boolean isAvailable() {
            return true;
        }
    };

    boolean isAvailable();
}
