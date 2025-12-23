package com.bxkj.student.common.utils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class b {
    public static String b(String url) {
        if (url.contains("letv")) {
            return "hv_ico_screen";
        }
        if (url.contains("youku")) {
            return "x-zoomin";
        }
        if (url.contains("bilibili")) {
            return "icon-widescreen";
        }
        if (url.contains("qq")) {
            return "tvp_fullscreen_button";
        }
        return null;
    }

    public static String a(String url) {
        if (b(url) != null) {
            return "javascript:document.getElementsByClassName('" + b(url) + "')[0].addEventListener('click',function(){local_obj.playing();return false;});";
        }
        return "javascript:";
    }
}
