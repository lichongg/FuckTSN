package androidx.room.support;

import android.content.Context;
import androidx.room.DatabaseConfiguration;
import androidx.room.DelegatingOpenHelper;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.sqlite.util.ProcessLock;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class PrePackagedCopyOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {

    @NotNull
    private final Context context;

    @Nullable
    private final String copyFromAssetPath;

    @Nullable
    private final File copyFromFile;

    @Nullable
    private final Callable<InputStream> copyFromInputStream;
    private DatabaseConfiguration databaseConfiguration;
    private final int databaseVersion;

    @NotNull
    private final SupportSQLiteOpenHelper delegate;
    private boolean verified;

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        getDelegate().close();
        this.verified = false;
    }

    public PrePackagedCopyOpenHelper(@NotNull Context context, @Nullable String str, @Nullable File file, @Nullable Callable<InputStream> callable, int i6, @NotNull SupportSQLiteOpenHelper delegate) {
        g0.p(context, "context");
        g0.p(delegate, "delegate");
        this.context = context;
        this.copyFromAssetPath = str;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.databaseVersion = i6;
        this.delegate = delegate;
    }

    private final void copyDatabaseFile(File file, boolean z5) throws IOException {
        ReadableByteChannel newChannel;
        if (this.copyFromAssetPath != null) {
            newChannel = Channels.newChannel(this.context.getAssets().open(this.copyFromAssetPath));
        } else if (this.copyFromFile != null) {
            newChannel = new FileInputStream(this.copyFromFile).getChannel();
        } else {
            Callable<InputStream> callable = this.copyFromInputStream;
            if (callable == null) {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
            try {
                newChannel = Channels.newChannel(callable.call());
            } catch (Exception e6) {
                throw new IOException("inputStreamCallable exception on call", e6);
            }
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.context.getCacheDir());
        createTempFile.deleteOnExit();
        FileChannel channel = new FileOutputStream(createTempFile).getChannel();
        g0.m(channel);
        FileUtil.copy(newChannel, channel);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        }
        g0.m(createTempFile);
        dispatchOnOpenPrepackagedDatabase(createTempFile, z5);
        if (createTempFile.renameTo(file)) {
            return;
        }
        throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
    }

    private final void dispatchOnOpenPrepackagedDatabase(File file, boolean z5) {
        DatabaseConfiguration databaseConfiguration = this.databaseConfiguration;
        if (databaseConfiguration == null) {
            g0.S("databaseConfiguration");
            databaseConfiguration = null;
        }
        if (databaseConfiguration.prepackagedDatabaseCallback == null) {
            return;
        }
        SupportSQLiteOpenHelper createFrameworkOpenHelper = createFrameworkOpenHelper(file);
        try {
            SupportSQLiteDatabase writableDatabase = z5 ? createFrameworkOpenHelper.getWritableDatabase() : createFrameworkOpenHelper.getReadableDatabase();
            DatabaseConfiguration databaseConfiguration2 = this.databaseConfiguration;
            if (databaseConfiguration2 == null) {
                g0.S("databaseConfiguration");
                databaseConfiguration2 = null;
            }
            RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback = databaseConfiguration2.prepackagedDatabaseCallback;
            g0.m(prepackagedDatabaseCallback);
            prepackagedDatabaseCallback.onOpenPrepackagedDatabase(writableDatabase);
            n1 n1Var = n1.f44123a;
            kotlin.io.b.a(createFrameworkOpenHelper, null);
        } finally {
        }
    }

    @Override // androidx.room.DelegatingOpenHelper
    @NotNull
    public SupportSQLiteOpenHelper getDelegate() {
        return this.delegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @NotNull
    public SupportSQLiteDatabase getReadableDatabase() {
        if (!this.verified) {
            verifyDatabaseFile(false);
            this.verified = true;
        }
        return getDelegate().getReadableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @NotNull
    public SupportSQLiteDatabase getWritableDatabase() {
        if (!this.verified) {
            verifyDatabaseFile(true);
            this.verified = true;
        }
        return getDelegate().getWritableDatabase();
    }

    public final void setDatabaseConfiguration(@NotNull DatabaseConfiguration databaseConfiguration) {
        g0.p(databaseConfiguration, "databaseConfiguration");
        this.databaseConfiguration = databaseConfiguration;
    }

    private final SupportSQLiteOpenHelper createFrameworkOpenHelper(File file) {
        try {
            final int readVersion = DBUtil.readVersion(file);
            FrameworkSQLiteOpenHelperFactory frameworkSQLiteOpenHelperFactory = new FrameworkSQLiteOpenHelperFactory();
            SupportSQLiteOpenHelper.Configuration.Builder name = SupportSQLiteOpenHelper.Configuration.Companion.builder(this.context).name(file.getAbsolutePath());
            final int u5 = kotlin.ranges.t.u(readVersion, 1);
            return frameworkSQLiteOpenHelperFactory.create(name.callback(new SupportSQLiteOpenHelper.Callback(u5) { // from class: androidx.room.support.PrePackagedCopyOpenHelper$createFrameworkOpenHelper$configuration$1
                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
                public void onCreate(SupportSQLiteDatabase db) {
                    g0.p(db, "db");
                }

                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
                public void onOpen(SupportSQLiteDatabase db) {
                    g0.p(db, "db");
                    int i6 = readVersion;
                    if (i6 < 1) {
                        db.setVersion(i6);
                    }
                }

                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
                public void onUpgrade(SupportSQLiteDatabase db, int i6, int i7) {
                    g0.p(db, "db");
                }
            }).build());
        } catch (IOException e6) {
            throw new RuntimeException("Malformed database file, unable to read version.", e6);
        }
    }

    private final void verifyDatabaseFile(boolean z5) {
        String databaseName = getDatabaseName();
        if (databaseName != null) {
            File databasePath = this.context.getDatabasePath(databaseName);
            DatabaseConfiguration databaseConfiguration = this.databaseConfiguration;
            DatabaseConfiguration databaseConfiguration2 = null;
            if (databaseConfiguration == null) {
                g0.S("databaseConfiguration");
                databaseConfiguration = null;
            }
            ProcessLock processLock = new ProcessLock(databaseName, this.context.getFilesDir(), databaseConfiguration.multiInstanceInvalidation);
            try {
                ProcessLock.lock$default(processLock, false, 1, null);
                if (!databasePath.exists()) {
                    try {
                        g0.m(databasePath);
                        copyDatabaseFile(databasePath, z5);
                        return;
                    } catch (IOException e6) {
                        throw new RuntimeException("Unable to copy database file.", e6);
                    }
                }
                try {
                    g0.m(databasePath);
                    int readVersion = DBUtil.readVersion(databasePath);
                    if (readVersion == this.databaseVersion) {
                        return;
                    }
                    DatabaseConfiguration databaseConfiguration3 = this.databaseConfiguration;
                    if (databaseConfiguration3 == null) {
                        g0.S("databaseConfiguration");
                    } else {
                        databaseConfiguration2 = databaseConfiguration3;
                    }
                    if (databaseConfiguration2.isMigrationRequired(readVersion, this.databaseVersion)) {
                        return;
                    }
                    if (this.context.deleteDatabase(databaseName)) {
                        try {
                            copyDatabaseFile(databasePath, z5);
                            n1 n1Var = n1.f44123a;
                        } catch (IOException unused) {
                        }
                    }
                    return;
                } catch (IOException unused2) {
                    return;
                }
            } finally {
                processLock.unlock();
            }
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @Nullable
    public String getDatabaseName() {
        return getDelegate().getDatabaseName();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z5) {
        getDelegate().setWriteAheadLoggingEnabled(z5);
    }
}
