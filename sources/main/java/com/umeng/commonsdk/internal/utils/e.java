package com.umeng.commonsdk.internal.utils;

import android.os.Build;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class e {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum a {
        check_su_binary(new String[]{"/system/xbin/which", "su"});


        /* renamed from: b, reason: collision with root package name */
        String[] f41825b;

        a(String[] strArr) {
            this.f41825b = strArr;
        }
    }

    public ArrayList a(a aVar) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                Process exec = Runtime.getRuntime().exec(aVar.f41825b);
                new BufferedWriter(new OutputStreamWriter(exec.getOutputStream()));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        arrayList.add(readLine);
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                return null;
            }
        }
        return arrayList;
    }
}
