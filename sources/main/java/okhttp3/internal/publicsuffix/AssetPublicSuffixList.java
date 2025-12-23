package okhttp3.internal.publicsuffix;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import com.stub.StubApp;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import okhttp3.internal.platform.PlatformRegistry;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AssetPublicSuffixList extends BasePublicSuffixList {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String PUBLIC_SUFFIX_RESOURCE = "PublicSuffixDatabase.list";

    @NotNull
    private final String path;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final String getPUBLIC_SUFFIX_RESOURCE() {
            return AssetPublicSuffixList.PUBLIC_SUFFIX_RESOURCE;
        }
    }

    public AssetPublicSuffixList() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public AssetPublicSuffixList(@NotNull String path) {
        g0.p(path, "path");
        this.path = path;
    }

    @Override // okhttp3.internal.publicsuffix.BasePublicSuffixList
    @NotNull
    public String getPath() {
        return this.path;
    }

    @Override // okhttp3.internal.publicsuffix.BasePublicSuffixList
    @NotNull
    public Source listSource() {
        Context origApplicationContext = StubApp.getOrigApplicationContext(PlatformRegistry.INSTANCE.getApplicationContext());
        AssetManager assets = origApplicationContext != null ? origApplicationContext.getAssets() : null;
        if (assets == null) {
            if (Build.FINGERPRINT == null) {
                throw new IOException("Platform applicationContext not initialized. Possibly running Android unit test without Robolectric. Android tests should run with Robolectric and call OkHttp.initialize before test");
            }
            throw new IOException("Platform applicationContext not initialized. Startup Initializer possibly disabled, call OkHttp.initialize before test.");
        }
        InputStream open = assets.open(getPath());
        g0.o(open, "open(...)");
        return Okio.source(open);
    }

    public /* synthetic */ AssetPublicSuffixList(String str, int i6, v vVar) {
        this((i6 & 1) != 0 ? PUBLIC_SUFFIX_RESOURCE : str);
    }
}
