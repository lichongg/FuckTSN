package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ActionOnlyNavDirections implements NavDirections {
    private final int mActionId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && ActionOnlyNavDirections.class == obj.getClass() && getActionId() == ((ActionOnlyNavDirections) obj).getActionId();
    }

    @Override // androidx.navigation.NavDirections
    public int getActionId() {
        return this.mActionId;
    }

    @Override // androidx.navigation.NavDirections
    @NonNull
    public Bundle getArguments() {
        return new Bundle();
    }

    public int hashCode() {
        return 31 + getActionId();
    }

    public String toString() {
        return "ActionOnlyNavDirections(actionId=" + getActionId() + ")";
    }

    public ActionOnlyNavDirections(int i6) {
        this.mActionId = i6;
    }
}
