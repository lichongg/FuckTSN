package javax.mail;

import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class Address implements Serializable {
    private static final long serialVersionUID = -5822459626751992278L;

    public abstract boolean equals(Object obj);

    public abstract String getType();

    public abstract String toString();
}
