package javax.mail;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class StoreClosedException extends MessagingException {
    private static final long serialVersionUID = -3145392336120082655L;
    private transient Store store;

    public StoreClosedException(Store store) {
        this(store, null);
    }

    public StoreClosedException(Store store, String str) {
        super(str);
        this.store = store;
    }

    public Store getStore() {
        return this.store;
    }
}
