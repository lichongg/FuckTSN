package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.IntentSanitizer;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import androidx.core.util.Predicate;
import com.baidu.idl.face.platform.FaceEnvironment;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class IntentSanitizer {
    private static final String TAG = "IntentSanitizer";
    private boolean mAllowAnyComponent;
    private boolean mAllowClipDataText;
    private boolean mAllowIdentifier;
    private boolean mAllowSelector;
    private boolean mAllowSourceBounds;
    private Predicate<String> mAllowedActions;
    private Predicate<String> mAllowedCategories;
    private Predicate<ClipData> mAllowedClipData;
    private Predicate<Uri> mAllowedClipDataUri;
    private Predicate<ComponentName> mAllowedComponents;
    private Predicate<Uri> mAllowedData;
    private Map<String, Predicate<Object>> mAllowedExtras;
    private int mAllowedFlags;
    private Predicate<String> mAllowedPackages;
    private Predicate<String> mAllowedTypes;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder {
        private static final int HISTORY_STACK_FLAGS = 2112614400;
        private static final int RECEIVER_FLAGS = 2015363072;
        private boolean mAllowAnyComponent;
        private boolean mAllowIdentifier;
        private boolean mAllowSelector;
        private boolean mAllowSomeComponents;
        private boolean mAllowSourceBounds;
        private int mAllowedFlags;
        private Predicate<String> mAllowedActions = new Predicate() { // from class: androidx.core.content.n
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return IntentSanitizer.Builder.p((String) obj);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate and(Predicate predicate) {
                return androidx.core.util.k.a(this, predicate);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate negate() {
                return androidx.core.util.k.b(this);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate or(Predicate predicate) {
                return androidx.core.util.k.c(this, predicate);
            }
        };
        private Predicate<Uri> mAllowedData = new Predicate() { // from class: androidx.core.content.o
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return IntentSanitizer.Builder.l((Uri) obj);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate and(Predicate predicate) {
                return androidx.core.util.k.a(this, predicate);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate negate() {
                return androidx.core.util.k.b(this);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate or(Predicate predicate) {
                return androidx.core.util.k.c(this, predicate);
            }
        };
        private Predicate<String> mAllowedTypes = new Predicate() { // from class: androidx.core.content.p
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return IntentSanitizer.Builder.b((String) obj);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate and(Predicate predicate) {
                return androidx.core.util.k.a(this, predicate);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate negate() {
                return androidx.core.util.k.b(this);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate or(Predicate predicate) {
                return androidx.core.util.k.c(this, predicate);
            }
        };
        private Predicate<String> mAllowedCategories = new Predicate() { // from class: androidx.core.content.q
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return IntentSanitizer.Builder.k((String) obj);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate and(Predicate predicate) {
                return androidx.core.util.k.a(this, predicate);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate negate() {
                return androidx.core.util.k.b(this);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate or(Predicate predicate) {
                return androidx.core.util.k.c(this, predicate);
            }
        };
        private Predicate<String> mAllowedPackages = new Predicate() { // from class: androidx.core.content.r
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return IntentSanitizer.Builder.f((String) obj);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate and(Predicate predicate) {
                return androidx.core.util.k.a(this, predicate);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate negate() {
                return androidx.core.util.k.b(this);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate or(Predicate predicate) {
                return androidx.core.util.k.c(this, predicate);
            }
        };
        private Predicate<ComponentName> mAllowedComponents = new Predicate() { // from class: androidx.core.content.s
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return IntentSanitizer.Builder.a((ComponentName) obj);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate and(Predicate predicate) {
                return androidx.core.util.k.a(this, predicate);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate negate() {
                return androidx.core.util.k.b(this);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate or(Predicate predicate) {
                return androidx.core.util.k.c(this, predicate);
            }
        };
        private Map<String, Predicate<Object>> mAllowedExtras = new HashMap();
        private boolean mAllowClipDataText = false;
        private Predicate<Uri> mAllowedClipDataUri = new Predicate() { // from class: androidx.core.content.t
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return IntentSanitizer.Builder.m((Uri) obj);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate and(Predicate predicate) {
                return androidx.core.util.k.a(this, predicate);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate negate() {
                return androidx.core.util.k.b(this);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate or(Predicate predicate) {
                return androidx.core.util.k.c(this, predicate);
            }
        };
        private Predicate<ClipData> mAllowedClipData = new Predicate() { // from class: androidx.core.content.u
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return IntentSanitizer.Builder.q((ClipData) obj);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate and(Predicate predicate) {
                return androidx.core.util.k.a(this, predicate);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate negate() {
                return androidx.core.util.k.b(this);
            }

            @Override // androidx.core.util.Predicate
            public /* synthetic */ Predicate or(Predicate predicate) {
                return androidx.core.util.k.c(this, predicate);
            }
        };

        public static /* synthetic */ boolean a(ComponentName componentName) {
            return false;
        }

        public static /* synthetic */ boolean b(String str) {
            return false;
        }

        public static /* synthetic */ boolean f(String str) {
            return false;
        }

        public static /* synthetic */ boolean i(Object obj) {
            return false;
        }

        public static /* synthetic */ boolean j(ComponentName componentName) {
            return true;
        }

        public static /* synthetic */ boolean k(String str) {
            return false;
        }

        public static /* synthetic */ boolean l(Uri uri) {
            return false;
        }

        public static /* synthetic */ boolean m(Uri uri) {
            return false;
        }

        public static /* synthetic */ boolean o(Object obj) {
            return true;
        }

        public static /* synthetic */ boolean p(String str) {
            return false;
        }

        public static /* synthetic */ boolean q(ClipData clipData) {
            return false;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowAction(@NonNull String str) {
            Preconditions.checkNotNull(str);
            Objects.requireNonNull(str);
            allowAction(new e(str));
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowAnyComponent() {
            this.mAllowAnyComponent = true;
            this.mAllowedComponents = new Predicate() { // from class: androidx.core.content.j
                @Override // androidx.core.util.Predicate
                public final boolean test(Object obj) {
                    return IntentSanitizer.Builder.j((ComponentName) obj);
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate and(Predicate predicate) {
                    return androidx.core.util.k.a(this, predicate);
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate negate() {
                    return androidx.core.util.k.b(this);
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate or(Predicate predicate) {
                    return androidx.core.util.k.c(this, predicate);
                }
            };
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowCategory(@NonNull String str) {
            Preconditions.checkNotNull(str);
            Objects.requireNonNull(str);
            return allowCategory(new e(str));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowClipDataText() {
            this.mAllowClipDataText = true;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowComponent(@NonNull final ComponentName componentName) {
            Preconditions.checkNotNull(componentName);
            Objects.requireNonNull(componentName);
            return allowComponent(new Predicate() { // from class: androidx.core.content.i
                @Override // androidx.core.util.Predicate
                public final boolean test(Object obj) {
                    return componentName.equals((ComponentName) obj);
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate and(Predicate predicate) {
                    return androidx.core.util.k.a(this, predicate);
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate negate() {
                    return androidx.core.util.k.b(this);
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate or(Predicate predicate) {
                    return androidx.core.util.k.c(this, predicate);
                }
            });
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtra(@NonNull String str, @NonNull Class<?> cls) {
            return allowExtra(str, cls, new Predicate() { // from class: androidx.core.content.v
                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate and(Predicate predicate) {
                    return androidx.core.util.k.a(this, predicate);
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate negate() {
                    return androidx.core.util.k.b(this);
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate or(Predicate predicate) {
                    return androidx.core.util.k.c(this, predicate);
                }

                @Override // androidx.core.util.Predicate
                public final boolean test(Object obj) {
                    return IntentSanitizer.Builder.o(obj);
                }
            });
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtraOutput(@NonNull final String str) {
            allowExtra("output", Uri.class, new Predicate() { // from class: androidx.core.content.d
                @Override // androidx.core.util.Predicate
                public final boolean test(Object obj) {
                    boolean equals;
                    equals = str.equals(((Uri) obj).getAuthority());
                    return equals;
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate and(Predicate predicate) {
                    return androidx.core.util.k.a(this, predicate);
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate negate() {
                    return androidx.core.util.k.b(this);
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate or(Predicate predicate) {
                    return androidx.core.util.k.c(this, predicate);
                }
            });
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowIdentifier() {
            this.mAllowIdentifier = true;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowPackage(@NonNull String str) {
            Preconditions.checkNotNull(str);
            Objects.requireNonNull(str);
            return allowPackage(new e(str));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowSelector() {
            this.mAllowSelector = true;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowSourceBounds() {
            this.mAllowSourceBounds = true;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowType(@NonNull String str) {
            Preconditions.checkNotNull(str);
            Objects.requireNonNull(str);
            return allowType(new e(str));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public <T> Builder allowExtra(@NonNull String str, @NonNull final Class<T> cls, @NonNull final Predicate<T> predicate) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(cls);
            Preconditions.checkNotNull(predicate);
            return allowExtra(str, new Predicate() { // from class: androidx.core.content.h
                @Override // androidx.core.util.Predicate
                public final boolean test(Object obj) {
                    return IntentSanitizer.Builder.e(cls, predicate, obj);
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate and(Predicate predicate2) {
                    return androidx.core.util.k.a(this, predicate2);
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate negate() {
                    return androidx.core.util.k.b(this);
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate or(Predicate predicate2) {
                    return androidx.core.util.k.c(this, predicate2);
                }
            });
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtraOutput(@NonNull Predicate<Uri> predicate) {
            allowExtra("output", Uri.class, predicate);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtraStream(@NonNull Predicate<Uri> predicate) {
            allowExtra("android.intent.extra.STREAM", Uri.class, predicate);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowFlags(int i6) {
            this.mAllowedFlags = i6 | this.mAllowedFlags;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowHistoryStackFlags() {
            this.mAllowedFlags |= HISTORY_STACK_FLAGS;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowReceiverFlags() {
            this.mAllowedFlags |= RECEIVER_FLAGS;
            return this;
        }

        @NonNull
        public IntentSanitizer build() {
            boolean z5 = this.mAllowAnyComponent;
            if ((z5 && this.mAllowSomeComponents) || (!z5 && !this.mAllowSomeComponents)) {
                throw new SecurityException("You must call either allowAnyComponent or one or more of the allowComponent methods; but not both.");
            }
            IntentSanitizer intentSanitizer = new IntentSanitizer();
            intentSanitizer.mAllowedFlags = this.mAllowedFlags;
            intentSanitizer.mAllowedActions = this.mAllowedActions;
            intentSanitizer.mAllowedData = this.mAllowedData;
            intentSanitizer.mAllowedTypes = this.mAllowedTypes;
            intentSanitizer.mAllowedCategories = this.mAllowedCategories;
            intentSanitizer.mAllowedPackages = this.mAllowedPackages;
            intentSanitizer.mAllowAnyComponent = this.mAllowAnyComponent;
            intentSanitizer.mAllowedComponents = this.mAllowedComponents;
            intentSanitizer.mAllowedExtras = this.mAllowedExtras;
            intentSanitizer.mAllowClipDataText = this.mAllowClipDataText;
            intentSanitizer.mAllowedClipDataUri = this.mAllowedClipDataUri;
            intentSanitizer.mAllowedClipData = this.mAllowedClipData;
            intentSanitizer.mAllowIdentifier = this.mAllowIdentifier;
            intentSanitizer.mAllowSelector = this.mAllowSelector;
            intentSanitizer.mAllowSourceBounds = this.mAllowSourceBounds;
            return intentSanitizer;
        }

        public static /* synthetic */ boolean e(Class cls, Predicate predicate, Object obj) {
            if (cls.isInstance(obj) && predicate.test(cls.cast(obj))) {
                return true;
            }
            return false;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowAction(@NonNull Predicate<String> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedActions = this.mAllowedActions.or(predicate);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowCategory(@NonNull Predicate<String> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedCategories = this.mAllowedCategories.or(predicate);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowClipData(@NonNull Predicate<ClipData> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedClipData = this.mAllowedClipData.or(predicate);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowClipDataUri(@NonNull Predicate<Uri> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedClipDataUri = this.mAllowedClipDataUri.or(predicate);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowClipDataUriWithAuthority(@NonNull final String str) {
            Preconditions.checkNotNull(str);
            return allowClipDataUri(new Predicate() { // from class: androidx.core.content.k
                @Override // androidx.core.util.Predicate
                public final boolean test(Object obj) {
                    boolean equals;
                    equals = str.equals(((Uri) obj).getAuthority());
                    return equals;
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate and(Predicate predicate) {
                    return androidx.core.util.k.a(this, predicate);
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate negate() {
                    return androidx.core.util.k.b(this);
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate or(Predicate predicate) {
                    return androidx.core.util.k.c(this, predicate);
                }
            });
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowComponent(@NonNull Predicate<ComponentName> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowSomeComponents = true;
            this.mAllowedComponents = this.mAllowedComponents.or(predicate);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowComponentWithPackage(@NonNull final String str) {
            Preconditions.checkNotNull(str);
            return allowComponent(new Predicate() { // from class: androidx.core.content.f
                @Override // androidx.core.util.Predicate
                public final boolean test(Object obj) {
                    boolean equals;
                    equals = str.equals(((ComponentName) obj).getPackageName());
                    return equals;
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate and(Predicate predicate) {
                    return androidx.core.util.k.a(this, predicate);
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate negate() {
                    return androidx.core.util.k.b(this);
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate or(Predicate predicate) {
                    return androidx.core.util.k.c(this, predicate);
                }
            });
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowData(@NonNull Predicate<Uri> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedData = this.mAllowedData.or(predicate);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowDataWithAuthority(@NonNull final String str) {
            Preconditions.checkNotNull(str);
            allowData(new Predicate() { // from class: androidx.core.content.g
                @Override // androidx.core.util.Predicate
                public final boolean test(Object obj) {
                    boolean equals;
                    equals = str.equals(((Uri) obj).getAuthority());
                    return equals;
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate and(Predicate predicate) {
                    return androidx.core.util.k.a(this, predicate);
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate negate() {
                    return androidx.core.util.k.b(this);
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate or(Predicate predicate) {
                    return androidx.core.util.k.c(this, predicate);
                }
            });
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtraStreamUriWithAuthority(@NonNull final String str) {
            Preconditions.checkNotNull(str);
            allowExtra("android.intent.extra.STREAM", Uri.class, new Predicate() { // from class: androidx.core.content.m
                @Override // androidx.core.util.Predicate
                public final boolean test(Object obj) {
                    boolean equals;
                    equals = str.equals(((Uri) obj).getAuthority());
                    return equals;
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate and(Predicate predicate) {
                    return androidx.core.util.k.a(this, predicate);
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate negate() {
                    return androidx.core.util.k.b(this);
                }

                @Override // androidx.core.util.Predicate
                public /* synthetic */ Predicate or(Predicate predicate) {
                    return androidx.core.util.k.c(this, predicate);
                }
            });
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowPackage(@NonNull Predicate<String> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedPackages = this.mAllowedPackages.or(predicate);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowType(@NonNull Predicate<String> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedTypes = this.mAllowedTypes.or(predicate);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtra(@NonNull String str, @NonNull Predicate<Object> predicate) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(predicate);
            Predicate<Object> predicate2 = this.mAllowedExtras.get(str);
            if (predicate2 == null) {
                predicate2 = new Predicate() { // from class: androidx.core.content.l
                    @Override // androidx.core.util.Predicate
                    public /* synthetic */ Predicate and(Predicate predicate3) {
                        return androidx.core.util.k.a(this, predicate3);
                    }

                    @Override // androidx.core.util.Predicate
                    public /* synthetic */ Predicate negate() {
                        return androidx.core.util.k.b(this);
                    }

                    @Override // androidx.core.util.Predicate
                    public /* synthetic */ Predicate or(Predicate predicate3) {
                        return androidx.core.util.k.c(this, predicate3);
                    }

                    @Override // androidx.core.util.Predicate
                    public final boolean test(Object obj) {
                        return IntentSanitizer.Builder.i(obj);
                    }
                };
            }
            this.mAllowedExtras.put(str, predicate2.or(predicate));
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(29)
    private static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static String getIdentifier(Intent intent) {
            return intent.getIdentifier();
        }

        @DoNotInline
        static Intent setIdentifier(Intent intent, String str) {
            return intent.setIdentifier(str);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(31)
    private static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static void checkOtherMembers(int i6, ClipData.Item item, Consumer<String> consumer) {
            if (item.getHtmlText() == null && item.getIntent() == null && item.getTextLinks() == null) {
                return;
            }
            consumer.accept("ClipData item at position " + i6 + " contains htmlText, textLinks or intent: " + item);
        }
    }

    private IntentSanitizer() {
    }

    public static /* synthetic */ void a(String str) {
        throw new SecurityException(str);
    }

    private void putExtra(Intent intent, String str, Object obj) {
        if (obj == null) {
            intent.getExtras().putString(str, null);
            return;
        }
        if (obj instanceof Parcelable) {
            intent.putExtra(str, (Parcelable) obj);
            return;
        }
        if (obj instanceof Parcelable[]) {
            intent.putExtra(str, (Parcelable[]) obj);
        } else {
            if (obj instanceof Serializable) {
                intent.putExtra(str, (Serializable) obj);
                return;
            }
            throw new IllegalArgumentException("Unsupported type " + obj.getClass());
        }
    }

    @NonNull
    public Intent sanitize(@NonNull Intent intent, @NonNull Consumer<String> consumer) {
        Intent intent2 = new Intent();
        ComponentName component = intent.getComponent();
        if ((this.mAllowAnyComponent && component == null) || this.mAllowedComponents.test(component)) {
            intent2.setComponent(component);
        } else {
            consumer.accept("Component is not allowed: " + component);
            intent2.setComponent(new ComponentName(FaceEnvironment.OS, "java.lang.Void"));
        }
        String str = intent.getPackage();
        if (str == null || this.mAllowedPackages.test(str)) {
            intent2.setPackage(str);
        } else {
            consumer.accept("Package is not allowed: " + str);
        }
        int flags = this.mAllowedFlags | intent.getFlags();
        int i6 = this.mAllowedFlags;
        if (flags == i6) {
            intent2.setFlags(intent.getFlags());
        } else {
            intent2.setFlags(intent.getFlags() & i6);
            consumer.accept("The intent contains flags that are not allowed: 0x" + Integer.toHexString(intent.getFlags() & (~this.mAllowedFlags)));
        }
        String action = intent.getAction();
        if (action == null || this.mAllowedActions.test(action)) {
            intent2.setAction(action);
        } else {
            consumer.accept("Action is not allowed: " + action);
        }
        Uri data = intent.getData();
        if (data == null || this.mAllowedData.test(data)) {
            intent2.setData(data);
        } else {
            consumer.accept("Data is not allowed: " + data);
        }
        String type = intent.getType();
        if (type == null || this.mAllowedTypes.test(type)) {
            intent2.setDataAndType(intent2.getData(), type);
        } else {
            consumer.accept("Type is not allowed: " + type);
        }
        Set<String> categories = intent.getCategories();
        if (categories != null) {
            for (String str2 : categories) {
                if (this.mAllowedCategories.test(str2)) {
                    intent2.addCategory(str2);
                } else {
                    consumer.accept("Category is not allowed: " + str2);
                }
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            for (String str3 : extras.keySet()) {
                if (str3.equals("android.intent.extra.STREAM") && (this.mAllowedFlags & 1) == 0) {
                    consumer.accept("Allowing Extra Stream requires also allowing at least  FLAG_GRANT_READ_URI_PERMISSION Flag.");
                } else if (!str3.equals("output") || ((~this.mAllowedFlags) & 3) == 0) {
                    Object obj = extras.get(str3);
                    Predicate<Object> predicate = this.mAllowedExtras.get(str3);
                    if (predicate == null || !predicate.test(obj)) {
                        consumer.accept("Extra is not allowed. Key: " + str3 + ". Value: " + obj);
                    } else {
                        putExtra(intent2, str3, obj);
                    }
                } else {
                    consumer.accept("Allowing Extra Output requires also allowing FLAG_GRANT_READ_URI_PERMISSION and FLAG_GRANT_WRITE_URI_PERMISSION Flags.");
                }
            }
        }
        sanitizeClipData(intent, intent2, this.mAllowedClipData, this.mAllowClipDataText, this.mAllowedClipDataUri, consumer);
        if (Build.VERSION.SDK_INT >= 29) {
            if (this.mAllowIdentifier) {
                Api29Impl.setIdentifier(intent2, Api29Impl.getIdentifier(intent));
            } else if (Api29Impl.getIdentifier(intent) != null) {
                consumer.accept("Identifier is not allowed: " + Api29Impl.getIdentifier(intent));
            }
        }
        if (this.mAllowSelector) {
            intent2.setSelector(intent.getSelector());
        } else if (intent.getSelector() != null) {
            consumer.accept("Selector is not allowed: " + intent.getSelector());
        }
        if (this.mAllowSourceBounds) {
            intent2.setSourceBounds(intent.getSourceBounds());
            return intent2;
        }
        if (intent.getSourceBounds() != null) {
            consumer.accept("SourceBounds is not allowed: " + intent.getSourceBounds());
        }
        return intent2;
    }

    @NonNull
    public Intent sanitizeByFiltering(@NonNull Intent intent) {
        return sanitize(intent, new Consumer() { // from class: androidx.core.content.c
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                IntentSanitizer.b((String) obj);
            }
        });
    }

    @NonNull
    public Intent sanitizeByThrowing(@NonNull Intent intent) {
        return sanitize(intent, new Consumer() { // from class: androidx.core.content.b
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                IntentSanitizer.a((String) obj);
            }
        });
    }

    private static void checkOtherMembers(int i6, ClipData.Item item, Consumer<String> consumer) {
        if (item.getHtmlText() == null && item.getIntent() == null) {
            return;
        }
        consumer.accept("ClipData item at position " + i6 + " contains htmlText, textLinks or intent: " + item);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void sanitizeClipData(@androidx.annotation.NonNull android.content.Intent r7, android.content.Intent r8, androidx.core.util.Predicate<android.content.ClipData> r9, boolean r10, androidx.core.util.Predicate<android.net.Uri> r11, androidx.core.util.Consumer<java.lang.String> r12) {
        /*
            android.content.ClipData r7 = r7.getClipData()
            if (r7 != 0) goto L8
            goto Lde
        L8:
            if (r9 == 0) goto L14
            boolean r9 = r9.test(r7)
            if (r9 == 0) goto L14
            r8.setClipData(r7)
            return
        L14:
            r9 = 0
            r0 = 0
            r1 = r9
        L17:
            int r2 = r7.getItemCount()
            if (r0 >= r2) goto Ld9
            android.content.ClipData$Item r2 = r7.getItemAt(r0)
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 31
            if (r3 < r4) goto L2b
            androidx.core.content.IntentSanitizer.Api31Impl.checkOtherMembers(r0, r2, r12)
            goto L2e
        L2b:
            checkOtherMembers(r0, r2, r12)
        L2e:
            if (r10 == 0) goto L35
            java.lang.CharSequence r3 = r2.getText()
            goto L5c
        L35:
            java.lang.CharSequence r3 = r2.getText()
            if (r3 == 0) goto L5b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Item text cannot contain value. Item position: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r4 = ". Text: "
            r3.append(r4)
            java.lang.CharSequence r4 = r2.getText()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r12.accept(r3)
        L5b:
            r3 = r9
        L5c:
            java.lang.String r4 = ". URI: "
            java.lang.String r5 = "Item URI is not allowed. Item position: "
            if (r11 != 0) goto L85
            android.net.Uri r6 = r2.getUri()
            if (r6 == 0) goto Lb2
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            r6.append(r0)
            r6.append(r4)
            android.net.Uri r2 = r2.getUri()
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            r12.accept(r2)
            goto Lb2
        L85:
            android.net.Uri r6 = r2.getUri()
            if (r6 == 0) goto Lb4
            android.net.Uri r6 = r2.getUri()
            boolean r6 = r11.test(r6)
            if (r6 == 0) goto L96
            goto Lb4
        L96:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            r6.append(r0)
            r6.append(r4)
            android.net.Uri r2 = r2.getUri()
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            r12.accept(r2)
        Lb2:
            r2 = r9
            goto Lb8
        Lb4:
            android.net.Uri r2 = r2.getUri()
        Lb8:
            if (r3 != 0) goto Lbc
            if (r2 == 0) goto Ld5
        Lbc:
            if (r1 != 0) goto Lcd
            android.content.ClipData r1 = new android.content.ClipData
            android.content.ClipDescription r4 = r7.getDescription()
            android.content.ClipData$Item r5 = new android.content.ClipData$Item
            r5.<init>(r3, r9, r2)
            r1.<init>(r4, r5)
            goto Ld5
        Lcd:
            android.content.ClipData$Item r4 = new android.content.ClipData$Item
            r4.<init>(r3, r9, r2)
            r1.addItem(r4)
        Ld5:
            int r0 = r0 + 1
            goto L17
        Ld9:
            if (r1 == 0) goto Lde
            r8.setClipData(r1)
        Lde:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.IntentSanitizer.sanitizeClipData(android.content.Intent, android.content.Intent, androidx.core.util.Predicate, boolean, androidx.core.util.Predicate, androidx.core.util.Consumer):void");
    }

    public static /* synthetic */ void b(String str) {
    }
}
