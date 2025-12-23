package androidx.work.impl.constraints;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class NetworkState {
    private boolean mIsConnected;
    private boolean mIsMetered;
    private boolean mIsNotRoaming;
    private boolean mIsValidated;

    public boolean equals(Object o5) {
        if (this == o5) {
            return true;
        }
        if (!(o5 instanceof NetworkState)) {
            return false;
        }
        NetworkState networkState = (NetworkState) o5;
        return this.mIsConnected == networkState.mIsConnected && this.mIsValidated == networkState.mIsValidated && this.mIsMetered == networkState.mIsMetered && this.mIsNotRoaming == networkState.mIsNotRoaming;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public int hashCode() {
        ?? r02 = this.mIsConnected;
        int i6 = r02;
        if (this.mIsValidated) {
            i6 = r02 + 16;
        }
        int i7 = i6;
        if (this.mIsMetered) {
            i7 = i6 + 256;
        }
        return this.mIsNotRoaming ? i7 + 4096 : i7;
    }

    public boolean isConnected() {
        return this.mIsConnected;
    }

    public boolean isMetered() {
        return this.mIsMetered;
    }

    public boolean isNotRoaming() {
        return this.mIsNotRoaming;
    }

    public boolean isValidated() {
        return this.mIsValidated;
    }

    @NonNull
    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", Boolean.valueOf(this.mIsConnected), Boolean.valueOf(this.mIsValidated), Boolean.valueOf(this.mIsMetered), Boolean.valueOf(this.mIsNotRoaming));
    }

    public NetworkState(boolean isConnected, boolean isValidated, boolean isMetered, boolean isNotRoaming) {
        this.mIsConnected = isConnected;
        this.mIsValidated = isValidated;
        this.mIsMetered = isMetered;
        this.mIsNotRoaming = isNotRoaming;
    }
}
