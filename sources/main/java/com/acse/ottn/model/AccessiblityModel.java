package com.acse.ottn.model;

import com.acse.ottn.k0;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.io.Serializable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AccessiblityModel implements Serializable {
    private int agl;
    private String ck;
    private String ck_v;
    private int cost_time;

    /* renamed from: r, reason: collision with root package name */
    private int f4837r;
    private int red_package;
    private DataBean data = new DataBean();
    private String genuine_packagename = "";
    private String toast_status = "";
    private String scrolled_screen = k0.f4680p;
    private String reset_heartbeat = "0";
    private long is_l = -1;
    private long is_xp = -1;
    private String reset_tag = "0";
    private String product_info = "";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class DataBean implements Serializable {
        private int coupon_load_time;
        private String pic_md5;
        private String pic_name;
        private String pic_update_status;
        private int play_audio;
        private int show_coupon_time;
        private int smallfloat_hour;
        private String smallfloat_minute;
        private String zip_md5;
        private String zip_url;
        private String spop_deeplink = "";
        private String spop_coupon_price = "";
        private String spop_coupon_title = "";
        private String spop_describe = "";
        private String spop_link = "";
        private String spop_pic = "";
        private String spop_title = "";
        private String package_name = "";
        private String coupon_show_package_name = "";
        private String coupon_activity_name = "";
        private String pic_type = "";
        private String discount = "";
        private String original_price = "";
        private String present_price = "";
        private String to_loading = "";
        private String debug_state = "";
        private String tkl_url = "";
        private String tkl_turn_url = "";
        private int coupon_detail_url = 40000;
        private String new_time_remaining = "";
        private String first_price = "";
        private String key_content = "";
        private String find_type = "";
        private String location_type = "";
        private String service_control = "0";
        private int second_price = 2000;
        private int third_price = 4000;
        private String short_link = "";
        private String auto_open_coupon = "";
        private String origin_url = "";
        private String coupon_type = "";
        private String coupon_show_type = "1";
        private String jump_type = "";
        private int time_four = 4000;
        private int activity_dismiss_time = 1500;
        private int coupon_show_time = AVMDLDataLoader.KeyIsLiveSetLoaderType;

        public int getActivity_dismiss_time() {
            return this.activity_dismiss_time;
        }

        public String getAuto_open_coupon() {
            return this.auto_open_coupon;
        }

        public String getCoupon_activity_name() {
            return this.coupon_activity_name;
        }

        public int getCoupon_detail_url() {
            return this.coupon_detail_url;
        }

        public int getCoupon_load_time() {
            return this.coupon_load_time;
        }

        public String getCoupon_show_package_name() {
            return this.coupon_show_package_name;
        }

        public int getCoupon_show_time() {
            return this.coupon_show_time;
        }

        public String getCoupon_show_type() {
            return this.coupon_show_type;
        }

        public String getCoupon_type() {
            return this.coupon_type;
        }

        public String getDebug_state() {
            return this.debug_state;
        }

        public String getDiscount() {
            return this.discount;
        }

        public String getFind_type() {
            return this.find_type;
        }

        public String getFirst_price() {
            return this.first_price;
        }

        public String getJump_type() {
            return this.jump_type;
        }

        public String getKey_content() {
            return this.key_content;
        }

        public String getLocation_type() {
            return this.location_type;
        }

        public String getNew_time_remaining() {
            return this.new_time_remaining;
        }

        public String getOrigin_url() {
            return this.origin_url;
        }

        public String getOriginal_price() {
            return this.original_price;
        }

        public String getPackage_name() {
            return this.package_name;
        }

        public String getPic_md5() {
            return this.pic_md5;
        }

        public String getPic_name() {
            return this.pic_name;
        }

        public String getPic_type() {
            return this.pic_type;
        }

        public String getPic_update_status() {
            return this.pic_update_status;
        }

        public int getPlay_audio() {
            return this.play_audio;
        }

        public String getPresent_price() {
            return this.present_price;
        }

        public int getSecond_price() {
            return this.second_price;
        }

        public String getService_control() {
            return this.service_control;
        }

        public String getShort_link() {
            return this.short_link;
        }

        public int getShow_coupon_time() {
            return this.show_coupon_time;
        }

        public int getSmallfloat_hour() {
            return this.smallfloat_hour;
        }

        public String getSmallfloat_minute() {
            return this.smallfloat_minute;
        }

        public String getSpop_coupon_price() {
            return this.spop_coupon_price;
        }

        public String getSpop_coupon_title() {
            return this.spop_coupon_title;
        }

        public String getSpop_deeplink() {
            return this.spop_deeplink;
        }

        public String getSpop_describe() {
            return this.spop_describe;
        }

        public String getSpop_link() {
            return this.spop_link;
        }

        public String getSpop_pic() {
            return this.spop_pic;
        }

        public String getSpop_title() {
            return this.spop_title;
        }

        public int getThird_price() {
            return this.third_price;
        }

        public int getTime_four() {
            return this.time_four;
        }

        public String getTkl_turn_url() {
            return this.tkl_turn_url;
        }

        public String getTkl_url() {
            return this.tkl_url;
        }

        public String getTo_loading() {
            return this.to_loading;
        }

        public String getZip_md5() {
            return this.zip_md5;
        }

        public String getZip_url() {
            return this.zip_url;
        }

        public void setActivity_dismiss_time(int i6) {
            this.activity_dismiss_time = i6;
        }

        public void setAuto_open_coupon(String str) {
            this.auto_open_coupon = str;
        }

        public void setCoupon_activity_name(String str) {
            this.coupon_activity_name = str;
        }

        public void setCoupon_detail_url(int i6) {
            this.coupon_detail_url = i6;
        }

        public void setCoupon_load_time(int i6) {
            this.coupon_load_time = i6;
        }

        public void setCoupon_show_package_name(String str) {
            this.coupon_show_package_name = str;
        }

        public void setCoupon_show_time(int i6) {
            this.coupon_show_time = i6;
        }

        public void setCoupon_show_type(String str) {
            this.coupon_show_type = str;
        }

        public void setCoupon_type(String str) {
            this.coupon_type = str;
        }

        public void setDebug_state(String str) {
            this.debug_state = str;
        }

        public void setDiscount(String str) {
            this.discount = str;
        }

        public void setFind_type(String str) {
            this.find_type = str;
        }

        public void setFirst_price(String str) {
            this.first_price = str;
        }

        public void setJump_type(String str) {
            this.jump_type = str;
        }

        public void setKey_content(String str) {
            this.key_content = str;
        }

        public void setLocation_type(String str) {
            this.location_type = str;
        }

        public void setNew_time_remaining(String str) {
            this.new_time_remaining = str;
        }

        public void setOrigin_url(String str) {
            this.origin_url = str;
        }

        public void setOriginal_price(String str) {
            this.original_price = str;
        }

        public void setPackage_name(String str) {
            this.package_name = str;
        }

        public void setPic_md5(String str) {
            this.pic_md5 = str;
        }

        public void setPic_name(String str) {
            this.pic_name = str;
        }

        public void setPic_type(String str) {
            this.pic_type = str;
        }

        public void setPic_update_status(String str) {
            this.pic_update_status = str;
        }

        public void setPlay_audio(int i6) {
            this.play_audio = i6;
        }

        public void setPresent_price(String str) {
            this.present_price = str;
        }

        public void setSecond_price(int i6) {
            this.second_price = i6;
        }

        public void setService_control(String str) {
            this.service_control = str;
        }

        public void setShort_link(String str) {
            this.short_link = str;
        }

        public void setShow_coupon_time(int i6) {
            this.show_coupon_time = i6;
        }

        public void setSmallfloat_hour(int i6) {
            this.smallfloat_hour = i6;
        }

        public void setSmallfloat_minute(String str) {
            this.smallfloat_minute = str;
        }

        public void setSpop_coupon_price(String str) {
            this.spop_coupon_price = str;
        }

        public void setSpop_coupon_title(String str) {
            this.spop_coupon_title = str;
        }

        public void setSpop_deeplink(String str) {
            this.spop_deeplink = str;
        }

        public void setSpop_describe(String str) {
            this.spop_describe = str;
        }

        public void setSpop_link(String str) {
            this.spop_link = str;
        }

        public void setSpop_pic(String str) {
            this.spop_pic = str;
        }

        public void setSpop_title(String str) {
            this.spop_title = str;
        }

        public void setThird_price(int i6) {
            this.third_price = i6;
        }

        public void setTime_four(int i6) {
            this.time_four = i6;
        }

        public void setTkl_turn_url(String str) {
            this.tkl_turn_url = str;
        }

        public void setTkl_url(String str) {
            this.tkl_url = str;
        }

        public void setTo_loading(String str) {
            this.to_loading = str;
        }

        public void setZip_md5(String str) {
            this.zip_md5 = str;
        }

        public void setZip_url(String str) {
            this.zip_url = str;
        }

        public String toString() {
            return "DataBean{spop_deeplink='" + this.spop_deeplink + "', spop_coupon_price='" + this.spop_coupon_price + "', play_audio=" + this.play_audio + ", spop_coupon_title='" + this.spop_coupon_title + "', spop_describe='" + this.spop_describe + "', spop_link='" + this.spop_link + "', spop_pic='" + this.spop_pic + "', spop_title='" + this.spop_title + "', package_name='" + this.package_name + "', coupon_show_package_name='" + this.coupon_show_package_name + "', coupon_activity_name='" + this.coupon_activity_name + "', pic_type='" + this.pic_type + "', discount='" + this.discount + "', original_price='" + this.original_price + "', present_price='" + this.present_price + "', to_loading='" + this.to_loading + "', debug_state='" + this.debug_state + "', tkl_url='" + this.tkl_url + "', tkl_turn_url='" + this.tkl_turn_url + "', coupon_detail_url=" + this.coupon_detail_url + ", new_time_remaining='" + this.new_time_remaining + "', first_price='" + this.first_price + "', key_content='" + this.key_content + "', find_type='" + this.find_type + "', location_type='" + this.location_type + "', service_control='" + this.service_control + "', second_price=" + this.second_price + ", third_price=" + this.third_price + ", short_link='" + this.short_link + "', auto_open_coupon='" + this.auto_open_coupon + "', origin_url='" + this.origin_url + "', show_coupon_time=" + this.show_coupon_time + ", coupon_type='" + this.coupon_type + "', coupon_show_type='" + this.coupon_show_type + "', jump_type='" + this.jump_type + "', time_four=" + this.time_four + ", activity_dismiss_time=" + this.activity_dismiss_time + ", coupon_load_time=" + this.coupon_load_time + ", coupon_show_time=" + this.coupon_show_time + ", smallfloat_hour=" + this.smallfloat_hour + ", smallfloat_minute='" + this.smallfloat_minute + "', pic_update_status='" + this.pic_update_status + "', pic_name='" + this.pic_name + "', zip_md5='" + this.zip_md5 + "', zip_url='" + this.zip_url + "', pic_md5='" + this.pic_md5 + "'}";
        }
    }

    public int getAgl() {
        return this.agl;
    }

    public String getCk() {
        return this.ck;
    }

    public String getCk_v() {
        return this.ck_v;
    }

    public int getCost_time() {
        return this.cost_time;
    }

    public DataBean getData() {
        return this.data;
    }

    public String getGenuine_packagename() {
        return this.genuine_packagename;
    }

    public long getIs_l() {
        return this.is_l;
    }

    public long getIs_xp() {
        return this.is_xp;
    }

    public String getProduct_info() {
        return this.product_info;
    }

    public int getR() {
        return this.f4837r;
    }

    public int getRed_package() {
        return this.red_package;
    }

    public String getReset_heartbeat() {
        return this.reset_heartbeat;
    }

    public String getReset_tag() {
        return this.reset_tag;
    }

    public String getScrolled_screen() {
        return this.scrolled_screen;
    }

    public String getToast_status() {
        return this.toast_status;
    }

    public void setAgl(int i6) {
        this.agl = i6;
    }

    public void setCk(String str) {
        this.ck = str;
    }

    public void setCk_v(String str) {
        this.ck_v = str;
    }

    public void setCost_time(int i6) {
        this.cost_time = i6;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setGenuine_packagename(String str) {
        this.genuine_packagename = str;
    }

    public void setIs_l(long j6) {
        this.is_l = j6;
    }

    public void setIs_xp(long j6) {
        this.is_xp = j6;
    }

    public void setProduct_info(String str) {
        this.product_info = str;
    }

    public void setR(int i6) {
        this.f4837r = i6;
    }

    public void setRed_package(int i6) {
        this.red_package = i6;
    }

    public void setReset_heartbeat(String str) {
        this.reset_heartbeat = str;
    }

    public void setReset_tag(String str) {
        this.reset_tag = str;
    }

    public void setScrolled_screen(String str) {
        this.scrolled_screen = str;
    }

    public void setToast_status(String str) {
        this.toast_status = str;
    }

    public String toString() {
        return "AccessiblityModel{ck_v='" + this.ck_v + "', r=" + this.f4837r + ", data=" + this.data + ", cost_time=" + this.cost_time + ", agl=" + this.agl + ", ck='" + this.ck + "', red_package='" + this.red_package + "', genuine_packagename='" + this.genuine_packagename + "'}";
    }
}
