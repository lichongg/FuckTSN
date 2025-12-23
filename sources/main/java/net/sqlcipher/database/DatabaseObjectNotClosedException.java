package net.sqlcipher.database;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class DatabaseObjectNotClosedException extends RuntimeException {

    /* renamed from: s, reason: collision with root package name */
    private static final String f50445s = "Application did not close the cursor or database object that was opened here";

    public DatabaseObjectNotClosedException() {
        super(f50445s);
    }
}
