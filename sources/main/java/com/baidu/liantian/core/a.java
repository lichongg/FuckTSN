package com.baidu.liantian.core;

import android.content.pm.ActivityInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class a implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<b> f10383a;

    public final byte[] a() {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (IOException unused) {
                objectOutputStream = null;
            } catch (Throwable th2) {
                objectOutputStream = null;
                th = th2;
            }
            try {
                objectOutputStream.writeObject(this.f10383a);
                objectOutputStream.close();
                byteArrayOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                } catch (IOException unused2) {
                    com.baidu.liantian.b.e.a();
                    return byteArray;
                }
            } catch (IOException unused3) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException unused4) {
                        com.baidu.liantian.b.e.a();
                        return null;
                    }
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException unused5) {
                        com.baidu.liantian.b.e.a();
                        throw th;
                    }
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        } catch (IOException unused6) {
            byteArrayOutputStream = null;
            objectOutputStream = null;
        } catch (Throwable th4) {
            objectOutputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    public a(ActivityInfo[] activityInfoArr) {
        int length;
        this.f10383a = null;
        if (activityInfoArr != null && (length = activityInfoArr.length) > 0) {
            this.f10383a = new ArrayList<>(length);
            for (int i6 = 0; i6 < length; i6++) {
                if (activityInfoArr[i6] != null) {
                    b bVar = new b();
                    ActivityInfo activityInfo = activityInfoArr[i6];
                    bVar.f10391h = activityInfo.configChanges;
                    bVar.f10389f = activityInfo.flags;
                    bVar.f10395l = activityInfo.labelRes;
                    bVar.f10385b = activityInfo.launchMode;
                    CharSequence charSequence = activityInfo.nonLocalizedLabel;
                    if (charSequence != null) {
                        bVar.f10396m = charSequence.toString();
                    }
                    ActivityInfo activityInfo2 = activityInfoArr[i6];
                    bVar.f10393j = activityInfo2.name;
                    bVar.f10394k = activityInfo2.packageName;
                    bVar.f10386c = activityInfo2.permission;
                    bVar.f10390g = activityInfo2.screenOrientation;
                    bVar.f10392i = activityInfo2.softInputMode;
                    bVar.f10388e = activityInfo2.targetActivity;
                    bVar.f10387d = activityInfo2.taskAffinity;
                    bVar.f10384a = activityInfo2.theme;
                    this.f10383a.add(bVar);
                }
            }
        }
    }

    public static ArrayList<b> a(byte[] bArr) {
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (Throwable unused) {
                objectInputStream = null;
            }
            try {
                ArrayList<b> arrayList = (ArrayList) objectInputStream.readObject();
                try {
                    objectInputStream.close();
                    byteArrayInputStream.close();
                    return arrayList;
                } catch (IOException unused2) {
                    com.baidu.liantian.b.e.a();
                    return arrayList;
                }
            } catch (Throwable unused3) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException unused4) {
                        com.baidu.liantian.b.e.a();
                        return null;
                    }
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                return null;
            }
        } catch (Throwable unused5) {
            objectInputStream = null;
            byteArrayInputStream = null;
        }
    }
}
