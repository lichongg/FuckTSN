package androidx.camera.core.processing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes.dex */
public interface ShaderProvider {
    public static final ShaderProvider DEFAULT = new ShaderProvider() { // from class: androidx.camera.core.processing.ShaderProvider.1
        @Override // androidx.camera.core.processing.ShaderProvider
        public /* synthetic */ String createFragmentShader(String str, String str2) {
            return r.a(this, str, str2);
        }
    };

    @Nullable
    String createFragmentShader(@NonNull String str, @NonNull String str2);
}
