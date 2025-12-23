package com.beizi.fusion.tool;

import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ai {

    /* renamed from: a, reason: collision with root package name */
    private static String f13624a = "extra";

    public static void a(File file) {
        try {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        a(file2);
                    }
                }
                file.delete();
                return;
            }
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }
}
