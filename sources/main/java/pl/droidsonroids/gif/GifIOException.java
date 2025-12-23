package pl.droidsonroids.gif;

import androidx.annotation.NonNull;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class GifIOException extends IOException {
    private static final long serialVersionUID = 13038402904505L;
    private final String mErrnoMessage;

    @NonNull
    public final GifError reason;

    static GifIOException fromCode(int i6) {
        if (i6 == GifError.NO_ERROR.errorCode) {
            return null;
        }
        return new GifIOException(i6, null);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.mErrnoMessage == null) {
            return this.reason.getFormattedDescription();
        }
        return this.reason.getFormattedDescription() + ": " + this.mErrnoMessage;
    }

    GifIOException(int i6, String str) {
        this.reason = GifError.fromCode(i6);
        this.mErrnoMessage = str;
    }
}
