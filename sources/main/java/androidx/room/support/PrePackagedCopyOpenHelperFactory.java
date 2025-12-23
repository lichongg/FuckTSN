package androidx.room.support;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class PrePackagedCopyOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {

    @Nullable
    private final String copyFromAssetPath;

    @Nullable
    private final File copyFromFile;

    @Nullable
    private final Callable<InputStream> copyFromInputStream;

    @NotNull
    private final SupportSQLiteOpenHelper.Factory delegate;

    public PrePackagedCopyOpenHelperFactory(@Nullable String str, @Nullable File file, @Nullable Callable<InputStream> callable, @NotNull SupportSQLiteOpenHelper.Factory delegate) {
        g0.p(delegate, "delegate");
        this.copyFromAssetPath = str;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.delegate = delegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    @NotNull
    public SupportSQLiteOpenHelper create(@NotNull SupportSQLiteOpenHelper.Configuration configuration) {
        g0.p(configuration, "configuration");
        return new PrePackagedCopyOpenHelper(configuration.context, this.copyFromAssetPath, this.copyFromFile, this.copyFromInputStream, configuration.callback.version, this.delegate.create(configuration));
    }
}
