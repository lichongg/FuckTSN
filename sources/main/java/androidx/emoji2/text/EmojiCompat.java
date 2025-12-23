package androidx.emoji2.text;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.AnyThread;
import androidx.annotation.CheckResult;
import androidx.annotation.ColorInt;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.DefaultEmojiCompatConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@AnyThread
/* loaded from: D:\Downloads\app\classes.dex */
public class EmojiCompat {
    public static final String EDITOR_INFO_METAVERSION_KEY = "android.support.text.emoji.emojiCompat_metadataVersion";
    public static final String EDITOR_INFO_REPLACE_ALL_KEY = "android.support.text.emoji.emojiCompat_replaceAll";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static final int EMOJI_COUNT_UNLIMITED = Integer.MAX_VALUE;
    public static final int EMOJI_FALLBACK = 2;
    public static final int EMOJI_SUPPORTED = 1;
    public static final int EMOJI_UNSUPPORTED = 0;
    public static final int LOAD_STATE_DEFAULT = 3;
    public static final int LOAD_STATE_FAILED = 2;
    public static final int LOAD_STATE_LOADING = 0;
    public static final int LOAD_STATE_SUCCEEDED = 1;
    public static final int LOAD_STRATEGY_DEFAULT = 0;
    public static final int LOAD_STRATEGY_MANUAL = 1;
    private static final String NOT_INITIALIZED_ERROR_TEXT = "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.";
    public static final int REPLACE_STRATEGY_ALL = 1;
    public static final int REPLACE_STRATEGY_DEFAULT = 0;
    public static final int REPLACE_STRATEGY_NON_EXISTENT = 2;

    @GuardedBy("CONFIG_LOCK")
    private static volatile boolean sHasDoneDefaultConfigLookup;

    @Nullable
    @GuardedBy("INSTANCE_LOCK")
    private static volatile EmojiCompat sInstance;

    @Nullable
    final int[] mEmojiAsDefaultStyleExceptions;
    private final int mEmojiSpanIndicatorColor;
    private final boolean mEmojiSpanIndicatorEnabled;
    private final GlyphChecker mGlyphChecker;

    @NonNull
    private final CompatInternal mHelper;

    @NonNull
    @GuardedBy("mInitLock")
    private final Set<InitCallback> mInitCallbacks;

    @NonNull
    private final ReadWriteLock mInitLock = new ReentrantReadWriteLock();

    @GuardedBy("mInitLock")
    private volatile int mLoadState = 3;

    @NonNull
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    private final int mMetadataLoadStrategy;

    @NonNull
    final MetadataRepoLoader mMetadataLoader;
    final boolean mReplaceAll;
    final boolean mUseEmojiAsDefaultStyle;
    private static final Object INSTANCE_LOCK = new Object();
    private static final Object CONFIG_LOCK = new Object();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface CodepointSequenceMatchResult {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class CompatInternal {
        final EmojiCompat mEmojiCompat;

        public int getEmojiMatch(CharSequence charSequence, int i6) {
            return 0;
        }

        boolean hasEmojiGlyph(@NonNull CharSequence charSequence) {
            return false;
        }

        String getAssetSignature() {
            return "";
        }

        boolean hasEmojiGlyph(@NonNull CharSequence charSequence, int i6) {
            return false;
        }

        void loadMetadata() {
            this.mEmojiCompat.onMetadataLoadSuccess();
        }

        CompatInternal(EmojiCompat emojiCompat) {
            this.mEmojiCompat = emojiCompat;
        }

        void updateEditorInfoAttrs(@NonNull EditorInfo editorInfo) {
        }

        CharSequence process(@NonNull CharSequence charSequence, @IntRange(from = 0) int i6, @IntRange(from = 0) int i7, @IntRange(from = 0) int i8, boolean z5) {
            return charSequence;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(19)
    private static final class CompatInternal19 extends CompatInternal {
        private volatile MetadataRepo mMetadataRepo;
        private volatile EmojiProcessor mProcessor;

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        boolean hasEmojiGlyph(@NonNull CharSequence charSequence) {
            return this.mProcessor.getEmojiMatch(charSequence) == 1;
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        String getAssetSignature() {
            String sourceSha = this.mMetadataRepo.getMetadataList().sourceSha();
            return sourceSha == null ? "" : sourceSha;
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        public int getEmojiMatch(CharSequence charSequence, int i6) {
            return this.mProcessor.getEmojiMatch(charSequence, i6);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        boolean hasEmojiGlyph(@NonNull CharSequence charSequence, int i6) {
            return this.mProcessor.getEmojiMatch(charSequence, i6) == 1;
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        void loadMetadata() {
            try {
                this.mEmojiCompat.mMetadataLoader.load(new MetadataRepoLoaderCallback() { // from class: androidx.emoji2.text.EmojiCompat.CompatInternal19.1
                    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void onFailed(@Nullable Throwable th) {
                        CompatInternal19.this.mEmojiCompat.onMetadataLoadFailed(th);
                    }

                    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void onLoaded(@NonNull MetadataRepo metadataRepo) {
                        CompatInternal19.this.onMetadataLoadSuccess(metadataRepo);
                    }
                });
            } catch (Throwable th) {
                this.mEmojiCompat.onMetadataLoadFailed(th);
            }
        }

        void onMetadataLoadSuccess(@NonNull MetadataRepo metadataRepo) {
            if (metadataRepo == null) {
                this.mEmojiCompat.onMetadataLoadFailed(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.mMetadataRepo = metadataRepo;
            MetadataRepo metadataRepo2 = this.mMetadataRepo;
            SpanFactory spanFactory = new SpanFactory();
            GlyphChecker glyphChecker = this.mEmojiCompat.mGlyphChecker;
            EmojiCompat emojiCompat = this.mEmojiCompat;
            this.mProcessor = new EmojiProcessor(metadataRepo2, spanFactory, glyphChecker, emojiCompat.mUseEmojiAsDefaultStyle, emojiCompat.mEmojiAsDefaultStyleExceptions);
            this.mEmojiCompat.onMetadataLoadSuccess();
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        CharSequence process(@NonNull CharSequence charSequence, int i6, int i7, int i8, boolean z5) {
            return this.mProcessor.process(charSequence, i6, i7, i8, z5);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        void updateEditorInfoAttrs(@NonNull EditorInfo editorInfo) {
            editorInfo.extras.putInt(EmojiCompat.EDITOR_INFO_METAVERSION_KEY, this.mMetadataRepo.getMetadataVersion());
            editorInfo.extras.putBoolean(EmojiCompat.EDITOR_INFO_REPLACE_ALL_KEY, this.mEmojiCompat.mReplaceAll);
        }

        CompatInternal19(EmojiCompat emojiCompat) {
            super(emojiCompat);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class Config {

        @Nullable
        int[] mEmojiAsDefaultStyleExceptions;
        boolean mEmojiSpanIndicatorEnabled;

        @Nullable
        Set<InitCallback> mInitCallbacks;

        @NonNull
        final MetadataRepoLoader mMetadataLoader;
        boolean mReplaceAll;
        boolean mUseEmojiAsDefaultStyle;
        int mEmojiSpanIndicatorColor = -16711936;
        int mMetadataLoadStrategy = 0;

        @NonNull
        GlyphChecker mGlyphChecker = new DefaultGlyphChecker();

        @NonNull
        public Config setUseEmojiAsDefaultStyle(boolean z5) {
            return setUseEmojiAsDefaultStyle(z5, null);
        }

        @NonNull
        protected final MetadataRepoLoader getMetadataRepoLoader() {
            return this.mMetadataLoader;
        }

        @NonNull
        public Config registerInitCallback(@NonNull InitCallback initCallback) {
            Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
            if (this.mInitCallbacks == null) {
                this.mInitCallbacks = new ArraySet();
            }
            this.mInitCallbacks.add(initCallback);
            return this;
        }

        @NonNull
        public Config setEmojiSpanIndicatorColor(@ColorInt int i6) {
            this.mEmojiSpanIndicatorColor = i6;
            return this;
        }

        @NonNull
        public Config setEmojiSpanIndicatorEnabled(boolean z5) {
            this.mEmojiSpanIndicatorEnabled = z5;
            return this;
        }

        @NonNull
        public Config setGlyphChecker(@NonNull GlyphChecker glyphChecker) {
            Preconditions.checkNotNull(glyphChecker, "GlyphChecker cannot be null");
            this.mGlyphChecker = glyphChecker;
            return this;
        }

        @NonNull
        public Config setMetadataLoadStrategy(int i6) {
            this.mMetadataLoadStrategy = i6;
            return this;
        }

        @NonNull
        public Config setReplaceAll(boolean z5) {
            this.mReplaceAll = z5;
            return this;
        }

        @NonNull
        public Config setUseEmojiAsDefaultStyle(boolean z5, @Nullable List<Integer> list) {
            this.mUseEmojiAsDefaultStyle = z5;
            if (!z5 || list == null) {
                this.mEmojiAsDefaultStyleExceptions = null;
                return this;
            }
            this.mEmojiAsDefaultStyleExceptions = new int[list.size()];
            Iterator<Integer> it = list.iterator();
            int i6 = 0;
            while (it.hasNext()) {
                this.mEmojiAsDefaultStyleExceptions[i6] = it.next().intValue();
                i6++;
            }
            Arrays.sort(this.mEmojiAsDefaultStyleExceptions);
            return this;
        }

        @NonNull
        public Config unregisterInitCallback(@NonNull InitCallback initCallback) {
            Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
            Set<InitCallback> set = this.mInitCallbacks;
            if (set != null) {
                set.remove(initCallback);
            }
            return this;
        }

        protected Config(@NonNull MetadataRepoLoader metadataRepoLoader) {
            Preconditions.checkNotNull(metadataRepoLoader, "metadataLoader cannot be null.");
            this.mMetadataLoader = metadataRepoLoader;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface GlyphChecker {
        boolean hasGlyph(@NonNull CharSequence charSequence, @IntRange(from = 0) int i6, @IntRange(from = 0) int i7, @IntRange(from = 0) int i8);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class ListenerDispatcher implements Runnable {
        private final List<InitCallback> mInitCallbacks;
        private final int mLoadState;
        private final Throwable mThrowable;

        ListenerDispatcher(@NonNull InitCallback initCallback, int i6) {
            this(Arrays.asList((InitCallback) Preconditions.checkNotNull(initCallback, "initCallback cannot be null")), i6, null);
        }

        ListenerDispatcher(@NonNull Collection<InitCallback> collection, int i6) {
            this(collection, i6, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.mInitCallbacks.size();
            int i6 = 0;
            if (this.mLoadState != 1) {
                while (i6 < size) {
                    this.mInitCallbacks.get(i6).onFailed(this.mThrowable);
                    i6++;
                }
            } else {
                while (i6 < size) {
                    this.mInitCallbacks.get(i6).onInitialized();
                    i6++;
                }
            }
        }

        ListenerDispatcher(@NonNull Collection<InitCallback> collection, int i6, @Nullable Throwable th) {
            Preconditions.checkNotNull(collection, "initCallbacks cannot be null");
            this.mInitCallbacks = new ArrayList(collection);
            this.mLoadState = i6;
            this.mThrowable = th;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface LoadStrategy {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface MetadataRepoLoader {
        void load(@NonNull MetadataRepoLoaderCallback metadataRepoLoaderCallback);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class MetadataRepoLoaderCallback {
        public abstract void onFailed(@Nullable Throwable th);

        public abstract void onLoaded(@NonNull MetadataRepo metadataRepo);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ReplaceStrategy {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static class SpanFactory {
        EmojiSpan createSpan(@NonNull EmojiMetadata emojiMetadata) {
            return new TypefaceEmojiSpan(emojiMetadata);
        }

        SpanFactory() {
        }
    }

    @Nullable
    public static EmojiCompat init(@NonNull Context context) {
        return init(context, null);
    }

    @NonNull
    public static EmojiCompat reset(@NonNull Config config) {
        EmojiCompat emojiCompat;
        synchronized (INSTANCE_LOCK) {
            emojiCompat = new EmojiCompat(config);
            sInstance = emojiCompat;
        }
        return emojiCompat;
    }

    @Deprecated
    public boolean hasEmojiGlyph(@NonNull CharSequence charSequence) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(charSequence, "sequence cannot be null");
        return this.mHelper.hasEmojiGlyph(charSequence);
    }

    @Nullable
    @CheckResult
    public CharSequence process(@Nullable CharSequence charSequence) {
        return process(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    @NonNull
    public static EmojiCompat get() {
        EmojiCompat emojiCompat;
        synchronized (INSTANCE_LOCK) {
            emojiCompat = sInstance;
            Preconditions.checkState(emojiCompat != null, NOT_INITIALIZED_ERROR_TEXT);
        }
        return emojiCompat;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static EmojiCompat init(@NonNull Context context, @Nullable DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory defaultEmojiCompatConfigFactory) {
        EmojiCompat emojiCompat;
        if (sHasDoneDefaultConfigLookup) {
            return sInstance;
        }
        if (defaultEmojiCompatConfigFactory == null) {
            defaultEmojiCompatConfigFactory = new DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory(null);
        }
        Config create = defaultEmojiCompatConfigFactory.create(context);
        synchronized (CONFIG_LOCK) {
            try {
                if (!sHasDoneDefaultConfigLookup) {
                    if (create != null) {
                        init(create);
                    }
                    sHasDoneDefaultConfigLookup = true;
                }
                emojiCompat = sInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return emojiCompat;
    }

    public static boolean isConfigured() {
        return sInstance != null;
    }

    private void loadMetadata() {
        this.mInitLock.writeLock().lock();
        try {
            if (this.mMetadataLoadStrategy == 0) {
                this.mLoadState = 0;
            }
            this.mInitLock.writeLock().unlock();
            if (getLoadState() == 0) {
                this.mHelper.loadMetadata();
            }
        } catch (Throwable th) {
            this.mInitLock.writeLock().unlock();
            throw th;
        }
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public static void skipDefaultConfigurationLookup(boolean z5) {
        synchronized (CONFIG_LOCK) {
            sHasDoneDefaultConfigLookup = z5;
        }
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getEmojiSpanIndicatorColor() {
        return this.mEmojiSpanIndicatorColor;
    }

    public int getLoadState() {
        this.mInitLock.readLock().lock();
        try {
            return this.mLoadState;
        } finally {
            this.mInitLock.readLock().unlock();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isEmojiSpanIndicatorEnabled() {
        return this.mEmojiSpanIndicatorEnabled;
    }

    public void load() {
        Preconditions.checkState(this.mMetadataLoadStrategy == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (isInitialized()) {
            return;
        }
        this.mInitLock.writeLock().lock();
        try {
            if (this.mLoadState == 0) {
                return;
            }
            this.mLoadState = 0;
            this.mInitLock.writeLock().unlock();
            this.mHelper.loadMetadata();
        } finally {
            this.mInitLock.writeLock().unlock();
        }
    }

    void onMetadataLoadFailed(@Nullable Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.mInitLock.writeLock().lock();
        try {
            this.mLoadState = 2;
            arrayList.addAll(this.mInitCallbacks);
            this.mInitCallbacks.clear();
            this.mInitLock.writeLock().unlock();
            this.mMainHandler.post(new ListenerDispatcher(arrayList, this.mLoadState, th));
        } catch (Throwable th2) {
            this.mInitLock.writeLock().unlock();
            throw th2;
        }
    }

    void onMetadataLoadSuccess() {
        ArrayList arrayList = new ArrayList();
        this.mInitLock.writeLock().lock();
        try {
            this.mLoadState = 1;
            arrayList.addAll(this.mInitCallbacks);
            this.mInitCallbacks.clear();
            this.mInitLock.writeLock().unlock();
            this.mMainHandler.post(new ListenerDispatcher(arrayList, this.mLoadState));
        } catch (Throwable th) {
            this.mInitLock.writeLock().unlock();
            throw th;
        }
    }

    public void registerInitCallback(@NonNull InitCallback initCallback) {
        Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
        try {
            if (this.mLoadState != 1 && this.mLoadState != 2) {
                this.mInitCallbacks.add(initCallback);
                this.mInitLock.writeLock().unlock();
            }
            this.mMainHandler.post(new ListenerDispatcher(initCallback, this.mLoadState));
            this.mInitLock.writeLock().unlock();
        } catch (Throwable th) {
            this.mInitLock.writeLock().unlock();
            throw th;
        }
    }

    public void unregisterInitCallback(@NonNull InitCallback initCallback) {
        Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
        try {
            this.mInitCallbacks.remove(initCallback);
        } finally {
            this.mInitLock.writeLock().unlock();
        }
    }

    private EmojiCompat(@NonNull Config config) {
        this.mReplaceAll = config.mReplaceAll;
        this.mUseEmojiAsDefaultStyle = config.mUseEmojiAsDefaultStyle;
        this.mEmojiAsDefaultStyleExceptions = config.mEmojiAsDefaultStyleExceptions;
        this.mEmojiSpanIndicatorEnabled = config.mEmojiSpanIndicatorEnabled;
        this.mEmojiSpanIndicatorColor = config.mEmojiSpanIndicatorColor;
        this.mMetadataLoader = config.mMetadataLoader;
        this.mMetadataLoadStrategy = config.mMetadataLoadStrategy;
        this.mGlyphChecker = config.mGlyphChecker;
        ArraySet arraySet = new ArraySet();
        this.mInitCallbacks = arraySet;
        Set<InitCallback> set = config.mInitCallbacks;
        if (set != null && !set.isEmpty()) {
            arraySet.addAll(config.mInitCallbacks);
        }
        this.mHelper = new CompatInternal19(this);
        loadMetadata();
    }

    public static boolean handleDeleteSurroundingText(@NonNull InputConnection inputConnection, @NonNull Editable editable, @IntRange(from = 0) int i6, @IntRange(from = 0) int i7, boolean z5) {
        return EmojiProcessor.handleDeleteSurroundingText(inputConnection, editable, i6, i7, z5);
    }

    public static boolean handleOnKeyDown(@NonNull Editable editable, int i6, @NonNull KeyEvent keyEvent) {
        return EmojiProcessor.handleOnKeyDown(editable, i6, keyEvent);
    }

    private boolean isInitialized() {
        if (getLoadState() == 1) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getAssetSignature() {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        return this.mHelper.getAssetSignature();
    }

    public int getEmojiMatch(@NonNull CharSequence charSequence, @IntRange(from = 0) int i6) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(charSequence, "sequence cannot be null");
        return this.mHelper.getEmojiMatch(charSequence, i6);
    }

    @Nullable
    @CheckResult
    public CharSequence process(@Nullable CharSequence charSequence, @IntRange(from = 0) int i6, @IntRange(from = 0) int i7) {
        return process(charSequence, i6, i7, Integer.MAX_VALUE);
    }

    public void updateEditorInfo(@NonNull EditorInfo editorInfo) {
        if (isInitialized() && editorInfo != null) {
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            this.mHelper.updateEditorInfoAttrs(editorInfo);
        }
    }

    @Deprecated
    public boolean hasEmojiGlyph(@NonNull CharSequence charSequence, @IntRange(from = 0) int i6) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(charSequence, "sequence cannot be null");
        return this.mHelper.hasEmojiGlyph(charSequence, i6);
    }

    @Nullable
    @CheckResult
    public CharSequence process(@Nullable CharSequence charSequence, @IntRange(from = 0) int i6, @IntRange(from = 0) int i7, @IntRange(from = 0) int i8) {
        return process(charSequence, i6, i7, i8, 0);
    }

    @Nullable
    @CheckResult
    public CharSequence process(@Nullable CharSequence charSequence, @IntRange(from = 0) int i6, @IntRange(from = 0) int i7, @IntRange(from = 0) int i8, int i9) {
        boolean z5;
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkArgumentNonnegative(i6, "start cannot be negative");
        Preconditions.checkArgumentNonnegative(i7, "end cannot be negative");
        Preconditions.checkArgumentNonnegative(i8, "maxEmojiCount cannot be negative");
        Preconditions.checkArgument(i6 <= i7, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        Preconditions.checkArgument(i6 <= charSequence.length(), "start should be < than charSequence length");
        Preconditions.checkArgument(i7 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i6 == i7) {
            return charSequence;
        }
        if (i9 != 1) {
            z5 = i9 != 2 ? this.mReplaceAll : false;
        } else {
            z5 = true;
        }
        return this.mHelper.process(charSequence, i6, i7, i8, z5);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static EmojiCompat reset(@Nullable EmojiCompat emojiCompat) {
        EmojiCompat emojiCompat2;
        synchronized (INSTANCE_LOCK) {
            sInstance = emojiCompat;
            emojiCompat2 = sInstance;
        }
        return emojiCompat2;
    }

    @NonNull
    public static EmojiCompat init(@NonNull Config config) {
        EmojiCompat emojiCompat;
        EmojiCompat emojiCompat2 = sInstance;
        if (emojiCompat2 != null) {
            return emojiCompat2;
        }
        synchronized (INSTANCE_LOCK) {
            try {
                emojiCompat = sInstance;
                if (emojiCompat == null) {
                    emojiCompat = new EmojiCompat(config);
                    sInstance = emojiCompat;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return emojiCompat;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class InitCallback {
        public void onInitialized() {
        }

        public void onFailed(@Nullable Throwable th) {
        }
    }
}
