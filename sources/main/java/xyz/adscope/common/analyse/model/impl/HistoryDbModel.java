package xyz.adscope.common.analyse.model.impl;

import xyz.adscope.common.v2.model.annotation.DataBaseNode;
import xyz.adscope.common.v2.persistent.db.IBaseDatabaseModel;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class HistoryDbModel extends IBaseDatabaseModel {
    public static final String COLUMN_ACCEPT_ENCRYPT = "acceptEncrypt";
    public static final String COLUMN_API_KEY = "apiKey";
    public static final String COLUMN_MACROS = "macros";
    public static final String COLUMN_REPORT_URL = "reportUrl";
    public static final String COLUMN_STORE_TIME = "storeTime";

    @DataBaseNode(column = COLUMN_ACCEPT_ENCRYPT)
    private String encrypt;

    @DataBaseNode(column = COLUMN_REPORT_URL)
    private String url = "";

    @DataBaseNode(column = COLUMN_MACROS)
    private String macros = "";

    @DataBaseNode(column = COLUMN_STORE_TIME)
    private String storeTime = "";

    @DataBaseNode(column = COLUMN_API_KEY)
    private String apiKey = "";

    public String getApiKey() {
        return this.apiKey;
    }

    public String getEncrypt() {
        return this.encrypt;
    }

    public String getMacros() {
        return this.macros;
    }

    public long getStoreTime() {
        return StringUtil.parseLong(this.storeTime);
    }

    public String getUrl() {
        return this.url;
    }

    public void setApiKey(String str) {
        this.apiKey = str;
    }

    public void setEncrypt(String str) {
        this.encrypt = str;
    }

    public void setMacros(String str) {
        this.macros = str;
    }

    public void setStoreTime(long j6) {
        this.storeTime = j6 + "";
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
