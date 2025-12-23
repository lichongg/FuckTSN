package com.acse.ottn.model;

import com.acse.ottn.k0;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class PageSettingTypeModel {
    String package_name;
    int read_time = 7000;
    String read_type = "0";
    int read_length = k0.f4677m;
    String read_description = "0";
    String is_click_jd_title = "0";
    List<String> containsTextList = new ArrayList();
    String cropped_text = "";
    int cropped_height = 0;

    public List<String> getContainsTextList() {
        return this.containsTextList;
    }

    public int getCropped_height() {
        return this.cropped_height;
    }

    public String getCropped_text() {
        return this.cropped_text;
    }

    public String getIs_click_jd_title() {
        return this.is_click_jd_title;
    }

    public String getPackage_name() {
        return this.package_name;
    }

    public String getRead_description() {
        return this.read_description;
    }

    public int getRead_length() {
        return this.read_length;
    }

    public int getRead_time() {
        return this.read_time;
    }

    public String getRead_type() {
        return this.read_type;
    }

    public void setContainsTextList(List<String> list) {
        this.containsTextList = list;
    }

    public void setCropped_height(int i6) {
        this.cropped_height = i6;
    }

    public void setCropped_text(String str) {
        this.cropped_text = str;
    }

    public void setIs_click_jd_title(String str) {
        this.is_click_jd_title = str;
    }

    public void setPackage_name(String str) {
        this.package_name = str;
    }

    public void setRead_description(String str) {
        this.read_description = str;
    }

    public void setRead_length(int i6) {
        this.read_length = i6;
    }

    public void setRead_time(int i6) {
        this.read_time = i6;
    }

    public void setRead_type(String str) {
        this.read_type = str;
    }

    public String toString() {
        return "PageSettingTypeModel{package_name='" + this.package_name + "', read_time=" + this.read_time + ", read_type='" + this.read_type + "', read_length=" + this.read_length + ", read_description='" + this.read_description + "', is_click_jd_title='" + this.is_click_jd_title + "'}";
    }
}
