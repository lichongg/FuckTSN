package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class NavArgument {

    @Nullable
    private final Object mDefaultValue;
    private final boolean mDefaultValuePresent;
    private final boolean mIsNullable;

    @NonNull
    private final NavType mType;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder {

        @Nullable
        private Object mDefaultValue;

        @Nullable
        private NavType<?> mType;
        private boolean mIsNullable = false;
        private boolean mDefaultValuePresent = false;

        @NonNull
        public NavArgument build() {
            if (this.mType == null) {
                this.mType = NavType.inferFromValueType(this.mDefaultValue);
            }
            return new NavArgument(this.mType, this.mIsNullable, this.mDefaultValue, this.mDefaultValuePresent);
        }

        @NonNull
        public Builder setDefaultValue(@Nullable Object obj) {
            this.mDefaultValue = obj;
            this.mDefaultValuePresent = true;
            return this;
        }

        @NonNull
        public Builder setIsNullable(boolean z5) {
            this.mIsNullable = z5;
            return this;
        }

        @NonNull
        public Builder setType(@NonNull NavType<?> navType) {
            this.mType = navType;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && NavArgument.class == obj.getClass()) {
            NavArgument navArgument = (NavArgument) obj;
            if (this.mIsNullable != navArgument.mIsNullable || this.mDefaultValuePresent != navArgument.mDefaultValuePresent || !this.mType.equals(navArgument.mType)) {
                return false;
            }
            Object obj2 = this.mDefaultValue;
            if (obj2 != null) {
                return obj2.equals(navArgument.mDefaultValue);
            }
            if (navArgument.mDefaultValue == null) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public Object getDefaultValue() {
        return this.mDefaultValue;
    }

    @NonNull
    public NavType<?> getType() {
        return this.mType;
    }

    public int hashCode() {
        int hashCode = ((((this.mType.hashCode() * 31) + (this.mIsNullable ? 1 : 0)) * 31) + (this.mDefaultValuePresent ? 1 : 0)) * 31;
        Object obj = this.mDefaultValue;
        return hashCode + (obj != null ? obj.hashCode() : 0);
    }

    public boolean isDefaultValuePresent() {
        return this.mDefaultValuePresent;
    }

    public boolean isNullable() {
        return this.mIsNullable;
    }

    void putDefaultValue(@NonNull String str, @NonNull Bundle bundle) {
        if (this.mDefaultValuePresent) {
            this.mType.put(bundle, str, this.mDefaultValue);
        }
    }

    boolean verify(@NonNull String str, @NonNull Bundle bundle) {
        if (!this.mIsNullable && bundle.containsKey(str) && bundle.get(str) == null) {
            return false;
        }
        try {
            this.mType.get(bundle, str);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    NavArgument(@NonNull NavType<?> navType, boolean z5, @Nullable Object obj, boolean z6) {
        if (!navType.isNullableAllowed() && z5) {
            throw new IllegalArgumentException(navType.getName() + " does not allow nullable values");
        }
        if (!z5 && z6 && obj == null) {
            throw new IllegalArgumentException("Argument with type " + navType.getName() + " has null value but is not nullable.");
        }
        this.mType = navType;
        this.mIsNullable = z5;
        this.mDefaultValue = obj;
        this.mDefaultValuePresent = z6;
    }
}
