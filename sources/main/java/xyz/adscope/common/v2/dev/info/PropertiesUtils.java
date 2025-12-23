package xyz.adscope.common.v2.dev.info;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import xyz.adscope.common.v2.tool.io.IOUtils;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class PropertiesUtils {
    private static final String DEBUG_MODEL = "debugModel";
    private static final String LOG_LEVEL = "logLevel";
    private Properties properties;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: xyz.adscope.common.v2.dev.info.PropertiesUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class InstanceHolder {
        private static PropertiesUtils instance = new PropertiesUtils(null);

        private InstanceHolder() {
        }
    }

    /* synthetic */ PropertiesUtils(AnonymousClass1 anonymousClass1) {
        this();
    }

    private PropertiesUtils() {
        if (InstanceHolder.instance != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    public int getLogLevel() {
        Properties properties = this.properties;
        if (properties == null || !properties.containsKey(LOG_LEVEL)) {
            return 0;
        }
        return StringUtil.parseInt(this.properties.getProperty(LOG_LEVEL, "0"));
    }

    public boolean isDebugModel() {
        Properties properties = this.properties;
        if (properties == null || !properties.contains(DEBUG_MODEL)) {
            return false;
        }
        return "true".equals(this.properties.getProperty(DEBUG_MODEL, "false"));
    }

    public void loadPropertiesFormAssets(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            Properties properties = new Properties();
            this.properties = properties;
            properties.load(inputStream);
            if (inputStream == null) {
                return;
            }
        } catch (IOException unused) {
            if (inputStream == null) {
                return;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                IOUtils.closeQuietly(inputStream);
            }
            throw th;
        }
        IOUtils.closeQuietly(inputStream);
    }

    public static PropertiesUtils getInstance() {
        return InstanceHolder.instance;
    }
}
