package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.quirk.ProfileResolutionQuirk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
public class ResolutionValidatedEncoderProfilesProvider implements EncoderProfilesProvider {
    private final EncoderProfilesResolutionValidator mEncoderProfilesResolutionValidator;
    private final EncoderProfilesProvider mProvider;

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    @Nullable
    public EncoderProfilesProxy getAll(int i6) {
        if (!this.mProvider.hasProfile(i6)) {
            return null;
        }
        EncoderProfilesProxy all = this.mProvider.getAll(i6);
        return this.mEncoderProfilesResolutionValidator.hasQuirk() ? this.mEncoderProfilesResolutionValidator.filterInvalidVideoResolution(all) : all;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int i6) {
        if (!this.mProvider.hasProfile(i6)) {
            return false;
        }
        if (!this.mEncoderProfilesResolutionValidator.hasQuirk()) {
            return true;
        }
        return this.mEncoderProfilesResolutionValidator.hasValidVideoResolution(this.mProvider.getAll(i6));
    }

    public ResolutionValidatedEncoderProfilesProvider(@NonNull EncoderProfilesProvider encoderProfilesProvider, @NonNull Quirks quirks) {
        this.mProvider = encoderProfilesProvider;
        this.mEncoderProfilesResolutionValidator = new EncoderProfilesResolutionValidator(quirks.getAll(ProfileResolutionQuirk.class));
    }
}
