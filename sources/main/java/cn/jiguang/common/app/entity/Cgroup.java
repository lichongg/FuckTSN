package cn.jiguang.common.app.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: D:\Downloads\app\classes2.dex */
public final class Cgroup extends ProcFile {
    public static final Parcelable.Creator<Cgroup> CREATOR = new Parcelable.Creator<Cgroup>() { // from class: cn.jiguang.common.app.entity.Cgroup.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cgroup createFromParcel(Parcel parcel) {
            return new Cgroup(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Cgroup[] newArray(int i6) {
            return new Cgroup[i6];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<ControlGroup> f2814a;

    private Cgroup(Parcel parcel) {
        super(parcel);
        this.f2814a = parcel.createTypedArrayList(ControlGroup.CREATOR);
    }

    public static Cgroup a(int i6) {
        return new Cgroup(String.format(Locale.ENGLISH, "/proc/%d/cgroup", Integer.valueOf(i6)));
    }

    public ControlGroup a(String str) {
        Iterator<ControlGroup> it = this.f2814a.iterator();
        while (it.hasNext()) {
            ControlGroup next = it.next();
            for (String str2 : next.f2816b.split(",")) {
                if (str2.equals(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    private Cgroup(String str) {
        super(str);
        String[] split = this.f2818b.split(com.snail.antifake.deviceid.e.f37542d);
        this.f2814a = new ArrayList<>();
        for (String str2 : split) {
            try {
                this.f2814a.add(new ControlGroup(str2));
            } catch (Exception unused) {
            }
        }
    }

    @Override // cn.jiguang.common.app.entity.ProcFile, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        super.writeToParcel(parcel, i6);
        parcel.writeTypedList(this.f2814a);
    }
}
