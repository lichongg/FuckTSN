package cn.jiguang.common.app.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* loaded from: D:\Downloads\app\classes2.dex */
public class ProcFile extends File implements Parcelable {
    public static final Parcelable.Creator<ProcFile> CREATOR = new Parcelable.Creator<ProcFile>() { // from class: cn.jiguang.common.app.entity.ProcFile.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProcFile createFromParcel(Parcel parcel) {
            return new ProcFile(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProcFile[] newArray(int i6) {
            return new ProcFile[i6];
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public final String f2818b;

    protected ProcFile(Parcel parcel) {
        super(parcel.readString());
        this.f2818b = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected ProcFile(String str) {
        super(str);
        this.f2818b = b(str);
    }

    public static String b(String str) {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return sb.toString().trim();
                }
                sb.append(readLine);
                sb.append(System.lineSeparator());
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    @Override // java.io.File
    public long length() {
        return this.f2818b.length();
    }

    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(getAbsolutePath());
        parcel.writeString(this.f2818b);
    }
}
