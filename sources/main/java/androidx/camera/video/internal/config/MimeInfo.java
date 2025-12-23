package androidx.camera.video.internal.config;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public abstract class MimeInfo {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Builder<B> {
        @NonNull
        public abstract MimeInfo build();

        @NonNull
        protected abstract B setMimeType(@NonNull String str);

        @NonNull
        public abstract B setProfile(int i6);
    }

    @NonNull
    public abstract String getMimeType();

    public abstract int getProfile();
}
