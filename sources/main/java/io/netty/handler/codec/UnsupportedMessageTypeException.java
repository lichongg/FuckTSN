package io.netty.handler.codec;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UnsupportedMessageTypeException extends CodecException {
    private static final long serialVersionUID = 2799598826487038726L;

    public UnsupportedMessageTypeException(Object obj, Class<?>... clsArr) {
        super(message(obj == null ? "null" : obj.getClass().getName(), clsArr));
    }

    private static String message(String str, Class<?>... clsArr) {
        Class<?> cls;
        StringBuilder sb = new StringBuilder(str);
        if (clsArr != null && clsArr.length > 0) {
            sb.append(" (expected: ");
            sb.append(clsArr[0].getName());
            for (int i6 = 1; i6 < clsArr.length && (cls = clsArr[i6]) != null; i6++) {
                sb.append(", ");
                sb.append(cls.getName());
            }
            sb.append(')');
        }
        return sb.toString();
    }

    public UnsupportedMessageTypeException() {
    }

    public UnsupportedMessageTypeException(String str, Throwable th) {
        super(str, th);
    }

    public UnsupportedMessageTypeException(String str) {
        super(str);
    }

    public UnsupportedMessageTypeException(Throwable th) {
        super(th);
    }
}
