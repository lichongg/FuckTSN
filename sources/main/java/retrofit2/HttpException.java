package retrofit2;

import java.util.Objects;
import javax.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class HttpException extends RuntimeException {
    private final int code;
    private final String message;
    private final transient c0<?> response;

    private static String getMessage(c0<?> c0Var) {
        Objects.requireNonNull(c0Var, "response == null");
        return "HTTP " + c0Var.b() + " " + c0Var.h();
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    @Nullable
    public c0<?> response() {
        return this.response;
    }

    public HttpException(c0<?> c0Var) {
        super(getMessage(c0Var));
        this.code = c0Var.b();
        this.message = c0Var.h();
        this.response = c0Var;
    }
}
