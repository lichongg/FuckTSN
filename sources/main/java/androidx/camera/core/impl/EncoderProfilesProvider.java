package androidx.camera.core.impl;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public interface EncoderProfilesProvider {
    public static final EncoderProfilesProvider EMPTY = new EncoderProfilesProvider() { // from class: androidx.camera.core.impl.EncoderProfilesProvider.1
        @Override // androidx.camera.core.impl.EncoderProfilesProvider
        @Nullable
        public EncoderProfilesProxy getAll(int i6) {
            return null;
        }

        @Override // androidx.camera.core.impl.EncoderProfilesProvider
        public boolean hasProfile(int i6) {
            return false;
        }
    };

    @Nullable
    EncoderProfilesProxy getAll(int i6);

    boolean hasProfile(int i6);
}
