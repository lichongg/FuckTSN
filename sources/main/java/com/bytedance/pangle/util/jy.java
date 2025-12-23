package com.bytedance.pangle.util;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\Downloads\app\classes4.dex */
public class jy {

    /* renamed from: j, reason: collision with root package name */
    private static volatile jy f25544j;
    private SharedPreferences xt = Zeus.getAppApplication().getSharedPreferences("pangle_meta_data_sp", 0);

    public static jy j() {
        if (f25544j == null) {
            synchronized (jy.class) {
                try {
                    if (f25544j == null) {
                        f25544j = new jy();
                    }
                } finally {
                }
            }
        }
        return f25544j;
    }

    public void ae(String str) {
        SharedPreferences.Editor edit = this.xt.edit();
        edit.putBoolean("UNINSTALL__".concat(String.valueOf(str)), true);
        edit.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markUnInstallFlag packageName=".concat(String.valueOf(str)));
    }

    public boolean cw(String str) {
        boolean z5 = !TextUtils.equals(this.xt.getString("HOST_ABI_".concat(String.valueOf(str)), ""), Zeus.getHostAbi());
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils isHostAbiUpdate HOST_ABI=" + this.xt.getString("HOST_ABI_".concat(String.valueOf(str)), "") + ", " + Zeus.getHostAbi() + ", result=" + z5);
        return z5;
    }

    public boolean g(String str) {
        return this.xt.getBoolean("UNINSTALL__".concat(String.valueOf(str)), false);
    }

    public String m(String str) {
        String string = this.xt.getString("HOST_IDENTITY_".concat(String.valueOf(str)), "");
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getHostIdentity pluginPKg = " + str + ", hostIdentity = " + string);
        return string;
    }

    public void r(String str) {
        String string = this.xt.getString("HOST_ABI_".concat(String.valueOf(str)), "");
        SharedPreferences.Editor edit = this.xt.edit();
        edit.putString("HOST_ABI_".concat(String.valueOf(str)), Zeus.getHostAbi());
        edit.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostAbiUpdated HOST_ABI=" + string + " --> " + Zeus.getHostAbi());
    }

    public void tl(String str) {
        SharedPreferences.Editor edit = this.xt.edit();
        edit.remove("UNINSTALL__".concat(String.valueOf(str)));
        edit.apply();
    }

    public int up(String str) {
        int i6 = this.xt.getInt("PLUGIN_API_VERSION_".concat(String.valueOf(str)), 0);
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getPluginApiVersion pluginPKg = " + str + ", pluginApiVersion = " + i6);
        return i6;
    }

    public boolean xt(String str) {
        return !TextUtils.isEmpty(this.xt.getString("HOST_ABI_".concat(String.valueOf(str)), ""));
    }

    public int g(String str, int i6) {
        return this.xt.getInt("remove_entry_flag_" + str + "_" + i6, 0);
    }

    public String oq(String str) {
        return this.xt.getString("IDENTITY_".concat(String.valueOf(str)), "");
    }

    public int xt(String str, int i6) {
        return this.xt.getInt("API_MIN_" + str + "_" + i6, 0);
    }

    private jy() {
    }

    public int cw(String str, int i6) {
        int i7 = this.xt.getInt("API_MAX_" + str + "_" + i6, Integer.MAX_VALUE);
        if (i7 == 0) {
            return Integer.MAX_VALUE;
        }
        return i7;
    }

    public List<String> jy(String str) {
        if (!TextUtils.isEmpty(str)) {
            String string = this.xt.getString("ALIAS_LAST_TIME_".concat(String.valueOf(m.j(str))), "");
            if (!TextUtils.isEmpty(string)) {
                return Arrays.asList(string.split("_"));
            }
            return null;
        }
        return null;
    }

    public boolean m(String str, int i6) {
        return this.xt.getInt(String.format(Locale.getDefault(), "OFFLINE_INTERNAL_%s", str), -1) == i6;
    }

    public String qv(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.xt.getString("ALIAS_".concat(String.valueOf(m.j(str))), "");
        }
        return null;
    }

    public void up(String str, int i6) {
        SharedPreferences.Editor edit = this.xt.edit();
        edit.putInt("OFFLINE_INTERNAL_".concat(String.valueOf(str)), i6);
        edit.apply();
    }

    public void vl(String str) {
        if (!TextUtils.isEmpty(str)) {
            String j6 = m.j(str);
            SharedPreferences.Editor edit = this.xt.edit();
            edit.remove("ALIAS_".concat(String.valueOf(j6)));
            edit.apply();
        }
    }

    public void ws(String str) {
        if (!TextUtils.isEmpty(str)) {
            String j6 = m.j(str);
            SharedPreferences.Editor edit = this.xt.edit();
            edit.remove("ALIAS_LAST_TIME_".concat(String.valueOf(j6)));
            edit.apply();
        }
    }

    public void xt(String str, String str2) {
        SharedPreferences.Editor edit = this.xt.edit();
        edit.putString("IDENTITY_".concat(String.valueOf(str)), str2);
        edit.apply();
    }

    public void cw(String str, int i6, boolean z5) {
        SharedPreferences.Editor edit = this.xt.edit();
        edit.putBoolean("dex_opt_state_" + str + "_" + i6, z5);
        edit.apply();
    }

    public boolean tl(String str, int i6) {
        return this.xt.getBoolean("dex_remove_state_" + str + "_" + i6, false);
    }

    public boolean ae(String str, int i6) {
        return this.xt.getBoolean("dex_opt_state_" + str + "_" + i6, false);
    }

    public boolean r(String str, int i6) {
        return this.xt.getBoolean(String.format(Locale.getDefault(), "INSTALLED_%s-%d", str, Integer.valueOf(i6)), false);
    }

    public void xt(String str, int i6, boolean z5) {
        SharedPreferences.Editor edit = this.xt.edit();
        String str2 = "INSTALLED_" + str + "-" + i6;
        if (z5) {
            edit.putBoolean(str2, true);
        } else {
            edit.remove(str2);
        }
        edit.apply();
    }

    public void j(String str) {
        SharedPreferences.Editor edit = this.xt.edit();
        edit.putString("ROM_LAST_".concat(String.valueOf(str)), Build.VERSION.INCREMENTAL);
        edit.apply();
    }

    public void r(String str, int i6, boolean z5) {
        SharedPreferences.Editor edit = this.xt.edit();
        edit.putBoolean("dex_remove_state_" + str + "_" + i6, z5);
        edit.apply();
    }

    public void cw(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String j6 = m.j(str);
        SharedPreferences.Editor edit = this.xt.edit();
        edit.putString("ALIAS_".concat(String.valueOf(j6)), str2);
        edit.apply();
    }

    public void j(String str, int i6) {
        int up = up(str);
        if (up != i6) {
            SharedPreferences.Editor edit = this.xt.edit();
            edit.putInt("PLUGIN_API_VERSION_".concat(String.valueOf(str)), i6);
            edit.apply();
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setPluginApiVersion " + up + " --> " + i6);
    }

    public void r(String str, String str2) {
        SharedPreferences.Editor edit = this.xt.edit();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String j6 = m.j(str);
        String string = this.xt.getString("ALIAS_LAST_TIME_".concat(String.valueOf(j6)), "");
        if (TextUtils.isEmpty(string)) {
            edit.putString("ALIAS_LAST_TIME_".concat(String.valueOf(j6)), str2);
        } else {
            edit.putString("ALIAS_LAST_TIME_".concat(String.valueOf(j6)), string + "_" + str2);
        }
        edit.apply();
    }

    public int xt(String str, int i6, String str2) {
        return this.xt.getInt(str2 + "_failed_count_when_rm_entry_" + str + "_" + i6, 0);
    }

    public void j(String str, String str2) {
        String m6 = m(str);
        if (!TextUtils.equals(m6, str2)) {
            SharedPreferences.Editor edit = this.xt.edit();
            edit.putString("HOST_IDENTITY_".concat(String.valueOf(str)), str2);
            edit.apply();
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostIdentity(" + str + ") " + m6 + " --> " + str2);
    }

    public void j(String str, int i6, int i7, int i8) {
        SharedPreferences.Editor edit = this.xt.edit();
        edit.putInt("API_MIN_" + str + "_" + i6, i7);
        edit.putInt("API_MAX_" + str + "_" + i6, i8);
        edit.apply();
    }

    public void j(String str, int i6, boolean z5) {
        SharedPreferences.Editor edit = this.xt.edit();
        String str2 = "DISABLE_DOWNLOAD_" + str + "_" + i6;
        if (z5) {
            edit.putInt(str2, 0);
        } else {
            edit.remove(str2);
        }
        edit.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markAllowDownloadFlag packageName=" + str + " version=" + i6 + " disable=" + z5);
    }

    public void j(String str, int i6, int i7) {
        SharedPreferences.Editor edit = this.xt.edit();
        edit.putInt("remove_entry_flag_" + str + "_" + i6, i7);
        edit.apply();
    }

    public void j(String str, int i6, String str2) {
        int xt = xt(str, i6, str2);
        SharedPreferences.Editor edit = this.xt.edit();
        edit.putInt(str2 + "_failed_count_when_rm_entry_" + str + "_" + i6, xt + 1);
        edit.apply();
    }
}
