package cn.jiguang.e;

import cn.jiguang.bz.w;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    public static String f2924a = "cn.jpush.preferences.v2";

    /* renamed from: b, reason: collision with root package name */
    String f2925b;

    /* renamed from: c, reason: collision with root package name */
    String f2926c;

    /* renamed from: d, reason: collision with root package name */
    T f2927d;

    /* renamed from: e, reason: collision with root package name */
    boolean f2928e;

    /* renamed from: f, reason: collision with root package name */
    boolean f2929f;

    /* renamed from: cn.jiguang.e.a$a, reason: collision with other inner class name */
    public static class C0042a {

        /* renamed from: cn.jiguang.e.a$a$a, reason: collision with other inner class name */
        public static class C0043a {
            public static a<Long> a() {
                return new a("cn.jiguang.sdk.user.profile", "key_uid_e", 0L).aN().aO();
            }

            public static a<Long> b() {
                return new a("cn.jiguang.sdk.user.profile", "key_uid", 0L).aN();
            }

            public static a<String> c() {
                return new a("cn.jiguang.sdk.user.profile", "key_rid_e", "").aN().aO();
            }

            public static a<String> d() {
                return new a("cn.jiguang.sdk.user.profile", "key_rid", "").aN();
            }
        }
    }

    public static a<String> a() {
        return new a("cn.jpush.android.user.profile", "devcie_id_generated", "").aN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a<T> aN() {
        this.f2928e = true;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a<T> aO() {
        this.f2929f = true;
        return this;
    }

    public static a<String> b() {
        return new a("cn.jpush.android.user.profile", "devcie_id_generated_n", "").aN();
    }

    public static a<String> c() {
        return new a("cn.jpush.android.user.profile", "cid_desc_data", "").aN();
    }

    public static a<Long> d() {
        return new a<>("cn.jpush.android.user.profile", "ex_report_time", 0L);
    }

    public static a<Long> e() {
        return new a<>("cn.jpush.android.user.profile", "net_data_report_time", 0L);
    }

    public static a<Boolean> f() {
        return new a<>("cn.jpush.android.user.profile", "enable_auto_wakeup", Boolean.TRUE);
    }

    public static a<Boolean> g() {
        return new a<>("cn.jpush.android.user.profile", "enable_ci", Boolean.FALSE);
    }

    public static a<Boolean> h() {
        return new a<>("cn.jpush.android.user.profile", "enable_dynamicload", Boolean.TRUE);
    }

    public static a<Boolean> i() {
        return new a<>("cn.jpush.android.user.profile", "enable_appterminate", Boolean.TRUE);
    }

    public static a<Boolean> j() {
        return new a<>("cn.jpush.android.user.profile", "use_tcp_ssl", Boolean.FALSE);
    }

    public static a<Boolean> A() {
        return new a<>("cn.jiguang.sdk.user.profile", "report_state", Boolean.FALSE);
    }

    public static a<Long> B() {
        return new a("cn.jiguang.sdk.user.profile", "key_uid_e", 0L).aN().aO();
    }

    public static a<String> C() {
        return new a("cn.jiguang.sdk.user.profile", "key_rid_e", "").aN().aO();
    }

    public static a<Long> D() {
        return new a("cn.jiguang.sdk.user.profile", "key_rid_time", 0L).aN();
    }

    public static a<String> E() {
        return new a("cn.jiguang.sdk.user.profile", "key_ww", "").aN().aO();
    }

    public static a<String> F() {
        return new a("cn.jiguang.sdk.user.profile", "key_pwd", "").aN();
    }

    public static a<Integer> G() {
        return new a("cn.jiguang.sdk.user.profile", "idc", -1).aN();
    }

    public static a<Long> H() {
        return new a<>("cn.jiguang.sdk.user.profile", "login_local_time", -1L);
    }

    public static a<Long> I() {
        return new a<>("cn.jiguang.sdk.user.profile", "login_server_time", -1L);
    }

    public static a<Long> J() {
        return new a<>("cn.jiguang.sdk.user.profile", "sync_auth", -1L);
    }

    public static a<String> K() {
        return new a("cn.jiguang.sdk.user.profile", "key_c", "").aN();
    }

    public static a<String> L() {
        return new a<>("cn.jiguang.sdk.reg_finger.profile", "reg_n_rule", "");
    }

    public static a<Integer> M() {
        return new a<>("cn.jiguang.sdk.reg_finger.profile", "reg_new", 0);
    }

    public static a<Boolean> N() {
        return new a<>("cn.jpush.android.user.profile", "exception_switch", Boolean.FALSE);
    }

    public static a<String> O() {
        return new a<>("cn.jiguang.sdk.user.set.profile", "option_channel", "");
    }

    public static a<String> P() {
        return new a<>("cn.jiguang.sdk.user.set.profile", "analytics_account_id", "");
    }

    public static a<Boolean> Q() {
        return new a<>("cn.jiguang.sdk.user.set.profile", "is_ups_register", Boolean.TRUE);
    }

    public static a<Long> R() {
        return new a<>("Push_Page_Config", "css", 0L);
    }

    public static a<Long> S() {
        return new a<>("Push_Page_Config", "cse", 0L);
    }

    public static a<Long> T() {
        return new a<>("Push_Page_Config", "last_pause", -1L);
    }

    public static a<String> U() {
        return new a<>("Push_Page_Config", "session_id", "");
    }

    public static a<String> V() {
        return new a("cn.jiguang.sdk.report", "report_urls", "").aO();
    }

    public static a<String> W() {
        return new a("cn.jiguang.sdk.report", "report_sis_urls", "").aO();
    }

    public static a<Long> X() {
        return new a<>("cn.jiguang.sdk.report", "last_update_report_urls", 0L);
    }

    public static a<Long> Y() {
        return new a<>("cn.jiguang.sdk.report", "report_urls_ttl_millis", 3600000L);
    }

    public static a<Integer> Z() {
        return new a(f2924a, "sp_sdk_version", 0).aN();
    }

    public static a<Integer> aA() {
        return new a("internal_debug", "log_enable", 0).aN();
    }

    public static a<Integer> aB() {
        return new a("internal_debug", "cmd_print_log", 0).aN();
    }

    public static a<Long> aC() {
        return new a("internal_debug", "expire", 0L).aN();
    }

    public static a<Integer> aD() {
        return new a("internal_debug", "delay_upload", 0).aN();
    }

    public static a<Long> aE() {
        return new a<>("internal_debug", "sentry_time", 0L);
    }

    public static a<Boolean> aF() {
        return new a<>("internal_debug", "sentry_sample_switch", Boolean.FALSE);
    }

    public static a<Boolean> aG() {
        return new a<>("internal_debug", "net_m_switch", Boolean.TRUE);
    }

    public static a<String> aH() {
        return new a<>("cn.jiguang.sdk.device", "di_ml", "");
    }

    public static a<String> aI() {
        return new a<>("cn.jiguang.sdk.device", "di_mft", "");
    }

    public static a<String> aJ() {
        return new a<>("cn.jiguang.sdk.device", "di_rm", "");
    }

    public static a<String> aK() {
        return new a<>("cn.jiguang.sdk.device", "di_ov", "");
    }

    public static a<String> aL() {
        return new a("cn.jiguang.sdk.device", "de_info", "").aO();
    }

    public static a<String> aM() {
        return new a("cn.jiguang.sdk.device", "loc_info", "").aO();
    }

    public static a<String> aa() {
        return new a(f2924a, "sdk_version", "").aN();
    }

    public static a<Long> ab() {
        return new a<>(f2924a, "first_init", 0L);
    }

    public static a<Long> ac() {
        return new a<>(f2924a, "exception_report_mill", 0L);
    }

    public static a<Long> ad() {
        return new a<>(f2924a, "lbs_delay", 0L);
    }

    public static a<Boolean> ae() {
        return new a<>(f2924a, "jcore_lbs_enable", Boolean.TRUE);
    }

    public static a<Boolean> af() {
        return new a<>("cn.jpush.android.user.profile", "is_tcp_close", Boolean.FALSE);
    }

    public static a<Integer> ag() {
        return new a("cn.jpush.android.user.profile", "jpush_register_code", -1).aN();
    }

    public static a<String> ah() {
        return new a<>(f2924a, "device_config_appkey_n", "");
    }

    public static a<String> ai() {
        return new a<>(f2924a, "device_config_appkey", "");
    }

    public static a<String> aj() {
        return new a<>(f2924a, "i_new", "");
    }

    public static a<String> ak() {
        return new a<>(f2924a, "push_udid", "");
    }

    public static a<String> al() {
        return new a<>(f2924a, "last_connection_type", "");
    }

    public static a<String> am() {
        return new a(f2924a, "sis_report_history", "").aO();
    }

    public static a<Boolean> an() {
        return new a("internal_debug", "cmd_export_log", Boolean.FALSE).aN();
    }

    public static a<Long> ao() {
        return new a<>("cn.jpush.preferences.v2.rid", "next_rid", -1L);
    }

    public static a<Integer> ap() {
        return new a<>("cn.jpush.preferences.v2.rid", "seq_id", -1);
    }

    public static a<String> aq() {
        return new a("cn.jiguang.sdk.address", "ips_in_last_good_sis", "").aO();
    }

    public static a<String> ar() {
        return new a("cn.jiguang.sdk.address", "ssl_ips_in_last_good_sis", "").aO();
    }

    public static a<Boolean> as() {
        return new a<>("cn.jiguang.sdk.address", "udp_data_report", Boolean.FALSE);
    }

    public static a<Long> at() {
        return new a<>("cn.jiguang.sdk.address", "sis_last_update", 0L);
    }

    public static a<Long> au() {
        return new a<>("cn.jiguang.sdk.address", "last_sis_report_time", 0L);
    }

    public static a<String> av() {
        return new a("cn.jiguang.sdk.address", "default_sis_ips", "").aO();
    }

    public static a<String> aw() {
        return new a("cn.jiguang.sdk.address", "default_conn", "").aO();
    }

    public static a<String> ax() {
        return new a("cn.jiguang.sdk.address", "default_conn_srv", "").aO();
    }

    public static a<String> ay() {
        return new a("cn.jiguang.sdk.address", "tcp_report", "").aN().aO();
    }

    public static a<String> az() {
        return new a<>("PrefsFile", "key", "");
    }

    public static a<Long> c(String str) {
        return new a<>("cn.jiguang.sdk.address", "dns_last_update_" + str, 0L);
    }

    public static a<String> d(String str) {
        return new a("cn.jiguang.sdk.address", "srv_" + str, "").aO();
    }

    public static a<Long> e(String str) {
        return new a<>("cn.jiguang.sdk.address", "srv_last_update_" + str, 0L);
    }

    public static a<String> f(String str) {
        return new a("IpInfos", str, "").aO();
    }

    public static a<String> g(String str) {
        return new a("IpInfos", w.d(str), "").aO();
    }

    public static a<Integer> h(String str) {
        return new a<>("netinfo", str, 0);
    }

    public static a<Boolean> k() {
        return new a<>("cn.jpush.android.user.profile", "count_switch", Boolean.TRUE);
    }

    public static a<Boolean> l() {
        return new a<>("cn.jpush.android.user.profile", "android_tcpreport_switch", Boolean.TRUE);
    }

    public static a<Boolean> m() {
        return new a<>("cn.jpush.android.user.profile", "tcp_exception_report_switch", Boolean.FALSE);
    }

    public static a<Boolean> n() {
        return new a<>("cn.jpush.android.user.profile", "net_length_switch", Boolean.FALSE);
    }

    public static a<Long> o() {
        return new a<>("cn.jpush.android.user.profile", "net_count_threshold", Long.valueOf(cn.jiguang.bq.b.f2512b));
    }

    public static a<Long> p() {
        return new a<>("cn.jpush.android.user.profile", "net_length_threshold", Long.valueOf(cn.jiguang.bq.b.f2511a));
    }

    public static a<Long> q() {
        return new a<>("cn.jpush.android.user.profile", "net_conn_count_threshold", Long.valueOf(cn.jiguang.bq.b.f2514d));
    }

    public static a<Long> r() {
        return new a<>("cn.jpush.android.user.profile", "net_conn_length_threshold", Long.valueOf(cn.jiguang.bq.b.f2513c));
    }

    public static a<Long> s() {
        return new a<>("cn.jpush.android.user.profile", "net_req", 0L);
    }

    public static a<Long> t() {
        return new a<>("cn.jpush.android.user.profile", "net_count", 0L);
    }

    public static a<Long> u() {
        return new a<>("cn.jpush.android.user.profile", "net_res", 0L);
    }

    public static a<Long> v() {
        return new a<>("cn.jpush.android.user.profile", "net_conn_req", 0L);
    }

    public static a<Long> w() {
        return new a<>("cn.jpush.android.user.profile", "net_conn_count", 0L);
    }

    public static a<Long> x() {
        return new a<>("cn.jpush.android.user.profile", "net_conn_res", 0L);
    }

    public static a<Long> y() {
        return new a<>("cn.jpush.android.user.profile", "net_day_time", 0L);
    }

    public static a<Boolean> z() {
        return new a<>("cn.jiguang.sdk.user.profile", "tcp_login", Boolean.FALSE);
    }

    public a<T> i(String str) {
        this.f2925b = str;
        return this;
    }

    public a<T> j(String str) {
        this.f2926c = str;
        return this;
    }

    public a(String str, String str2, T t5) {
        this.f2925b = str;
        this.f2926c = str2;
        if (t5 != null) {
            this.f2927d = t5;
            return;
        }
        throw new IllegalArgumentException("default value can not be null");
    }

    public static a<String> b(String str) {
        return new a("cn.jiguang.sdk.address", "dns_" + str, "").aO();
    }

    public static a<String> c(boolean z5) {
        StringBuilder sb = new StringBuilder();
        sb.append("last_good_conn");
        sb.append(z5 ? "_V4" : "_V6");
        return new a("cn.jiguang.sdk.address", sb.toString(), "").aO();
    }

    public static a<String> d(boolean z5) {
        return new a("cn.jiguang.sdk.address", z5 ? "default_https_report" : "default_http_report", "").aN().aO();
    }

    public a<T> a(T t5) {
        this.f2927d = t5;
        return this;
    }

    public static a<String> a(String str) {
        return new a<>("cn.jpush.android.user.profile", "sdk_version_" + str, "");
    }

    public static a<String> b(boolean z5) {
        StringBuilder sb = new StringBuilder();
        sb.append("last_good_sis_address");
        sb.append(z5 ? "_V4" : "_V6");
        return new a("cn.jiguang.sdk.address", sb.toString(), "").aO();
    }

    public static a<String> a(boolean z5) {
        return new a("cn.jiguang.sdk.address", z5 ? "default_https_report" : "default_http_report", "").aN().aO();
    }
}
