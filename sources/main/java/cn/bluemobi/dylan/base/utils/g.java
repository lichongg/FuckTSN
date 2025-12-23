package cn.bluemobi.dylan.base.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.media.session.PlaybackStateCompat;
import android.widget.Toast;
import com.bxkj.base.v2.common.utils.g0;
import java.io.File;
import java.text.DecimalFormat;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1221a = Environment.getExternalStorageDirectory().getPath() + "/rtCloudTemporary/Image/";

    /* renamed from: b, reason: collision with root package name */
    public static String f1222b = "/rtCloudTemporary/Image/";

    /* renamed from: c, reason: collision with root package name */
    public static final String f1223c = Environment.getExternalStorageDirectory().getPath() + "/rtCloud/Image/";

    /* renamed from: d, reason: collision with root package name */
    public static String f1224d = "/rtCloud/Image/";

    /* renamed from: e, reason: collision with root package name */
    private static final String[][] f1225e = {new String[]{".3gp", "video/3gpp"}, new String[]{".apk", "applicationnd.android.package-archive"}, new String[]{".asf", "video/x-ms-asf"}, new String[]{".avi", "video/x-msvideo"}, new String[]{".bin", "application/octet-stream"}, new String[]{".bmp", "image/bmp"}, new String[]{".c", "text/plain"}, new String[]{".class", "application/octet-stream"}, new String[]{".conf", "text/plain"}, new String[]{".cpp", "text/plain"}, new String[]{".doc", "application/msword"}, new String[]{".docx", "applicationnd.openxmlformats-officedocument.wordprocessingml.document"}, new String[]{".xls", "applicationnd.ms-excel"}, new String[]{".xlsx", "applicationnd.openxmlformats-officedocument.spreadsheetml.sheet"}, new String[]{".exe", "application/octet-stream"}, new String[]{".gif", "image/gif"}, new String[]{".gtar", "application/x-gtar"}, new String[]{com.kuaishou.weapon.p0.d.f35961b, "application/x-gzip"}, new String[]{".h", "text/plain"}, new String[]{".htm", "textml"}, new String[]{".html", "textml"}, new String[]{".jar", "application/java-archive"}, new String[]{".java", "text/plain"}, new String[]{".jpeg", "image/jpeg"}, new String[]{".jpg", "image/jpeg"}, new String[]{".js", "application/x-javascript"}, new String[]{".log", "text/plain"}, new String[]{".m3u", "audio/x-mpegurl"}, new String[]{".m4a", "audio/mp4a-latm"}, new String[]{".m4b", "audio/mp4a-latm"}, new String[]{".m4p", "audio/mp4a-latm"}, new String[]{".m4u", "videond.mpegurl"}, new String[]{".m4v", "video/x-m4v"}, new String[]{".mov", "video/quicktime"}, new String[]{".mp2", "audio/x-mpeg"}, new String[]{".mp3", "audio/x-mpeg"}, new String[]{".mp4", "video/mp4"}, new String[]{".mpc", "applicationnd.mpohun.certificate"}, new String[]{".mpe", "video/mpeg"}, new String[]{".mpeg", "video/mpeg"}, new String[]{".mpg", "video/mpeg"}, new String[]{".mpg4", "video/mp4"}, new String[]{".mpga", "audio/mpeg"}, new String[]{".msg", "applicationnd.ms-outlook"}, new String[]{".ogg", "audio/ogg"}, new String[]{".pdf", "applicationf"}, new String[]{g0.f16898c, "image/png"}, new String[]{".pps", "applicationnd.ms-powerpoint"}, new String[]{".ppt", "applicationnd.ms-powerpoint"}, new String[]{".pptx", "applicationnd.openxmlformats-officedocument.presentationml.presentation"}, new String[]{".prop", "text/plain"}, new String[]{".rc", "text/plain"}, new String[]{".rmvb", "audio/x-pn-realaudio"}, new String[]{".rtf", "application/rtf"}, new String[]{".sh", "text/plain"}, new String[]{".tar", "application/x-tar"}, new String[]{".tgz", "application/x-compressed"}, new String[]{".txt", "text/plain"}, new String[]{".wav", "audio/x-wav"}, new String[]{".wma", "audio/x-ms-wma"}, new String[]{".wmv", "audio/x-ms-wmv"}, new String[]{".wps", "applicationnd.ms-works"}, new String[]{".xml", "text/plain"}, new String[]{".z", "application/x-compress"}, new String[]{".zip", "application/x-zip-compressed"}, new String[]{"", "*/*"}};

    public static String a(long j6) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j6 < 1024) {
            return decimalFormat.format(j6) + "B";
        }
        if (j6 < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            return decimalFormat.format(j6 / 1024.0d) + "KB";
        }
        if (j6 < IjkMediaMeta.AV_CH_STEREO_RIGHT) {
            return decimalFormat.format(j6 / 1048576.0d) + "MB";
        }
        return decimalFormat.format(j6 / 1.073741824E9d) + "GB";
    }

    public static void f(Context context, File file) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(file), c(file));
        try {
            context.startActivity(intent);
        } catch (Exception e6) {
            e6.printStackTrace();
            Toast.makeText(context, "打开失败，请安装支持打开该类文件的应用。", 1).show();
        }
    }

    public static String b() {
        if (d()) {
            return f1221a;
        }
        return f1222b;
    }

    private static String c(File file) {
        String lowerCase;
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        String str = "*/*";
        if (lastIndexOf < 0 || (lowerCase = name.substring(lastIndexOf, name.length()).toLowerCase()) == "") {
            return "*/*";
        }
        int i6 = 0;
        while (true) {
            String[][] strArr = f1225e;
            if (i6 < strArr.length) {
                if (lowerCase.equals(strArr[i6][0])) {
                    str = strArr[i6][1];
                }
                i6++;
            } else {
                return str;
            }
        }
    }

    public static boolean d() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static void delete(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    delete(file2);
                }
                file.delete();
                return;
            }
            file.delete();
        }
    }

    public static String e(String str, String str2) {
        if (d()) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            new File(str, str2);
            return "";
        }
        return "Sd卡不可用！";
    }
}
