package com.kwad.framework.filedownloader.message;

import android.os.Parcel;
import com.kwad.framework.filedownloader.message.MessageSnapshot;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class d extends MessageSnapshot {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a extends b implements com.kwad.framework.filedownloader.message.b {
        a(int i6, boolean z5, long j6) {
            super(i6, true, j6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b extends d {
        private final boolean aoF;
        private final long totalBytes;

        b(int i6, boolean z5, long j6) {
            super(i6);
            this.aoF = z5;
            this.totalBytes = j6;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte wJ() {
            return (byte) -3;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long yO() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean yP() {
            return this.aoF;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeByte(this.aoF ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.totalBytes);
        }

        b(Parcel parcel) {
            super(parcel);
            this.aoF = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c extends d {
        private final String anc;
        private final boolean aoG;
        private final String fileName;
        private final long totalBytes;

        c(int i6, boolean z5, long j6, String str, String str2) {
            super(i6);
            this.aoG = z5;
            this.totalBytes = j6;
            this.anc = str;
            this.fileName = str2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte wJ() {
            return (byte) 2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final String getEtag() {
            return this.anc;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final String getFileName() {
            return this.fileName;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean yE() {
            return this.aoG;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long yO() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeByte(this.aoG ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.totalBytes);
            parcel.writeString(this.anc);
            parcel.writeString(this.fileName);
        }

        c(Parcel parcel) {
            super(parcel);
            this.aoG = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
            this.anc = parcel.readString();
            this.fileName = parcel.readString();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.framework.filedownloader.message.d$d, reason: collision with other inner class name */
    public static class C0661d extends d {
        private final long aoH;
        private final Throwable aoI;

        C0661d(int i6, long j6, Throwable th) {
            super(i6);
            this.aoH = j6;
            this.aoI = th;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public byte wJ() {
            return (byte) -1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long yQ() {
            return this.aoH;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final Throwable yR() {
            return this.aoI;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeLong(this.aoH);
            parcel.writeSerializable(this.aoI);
        }

        C0661d(Parcel parcel) {
            super(parcel);
            this.aoH = parcel.readLong();
            this.aoI = (Throwable) parcel.readSerializable();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class f extends d {
        private final long aoH;
        private final long totalBytes;

        f(f fVar) {
            this(fVar.getId(), fVar.yQ(), fVar.yO());
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public byte wJ() {
            return (byte) 1;
        }

        f(int i6, long j6, long j7) {
            super(i6);
            this.aoH = j6;
            this.totalBytes = j7;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long yO() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long yQ() {
            return this.aoH;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeLong(this.aoH);
            parcel.writeLong(this.totalBytes);
        }

        f(Parcel parcel) {
            super(parcel);
            this.aoH = parcel.readLong();
            this.totalBytes = parcel.readLong();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class g extends d {
        private final long aoH;

        g(int i6, long j6) {
            super(i6);
            this.aoH = j6;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte wJ() {
            return (byte) 3;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long yQ() {
            return this.aoH;
        }

        g(Parcel parcel) {
            super(parcel);
            this.aoH = parcel.readLong();
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeLong(this.aoH);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class h extends C0661d {
        private final int aon;

        h(int i6, long j6, Throwable th, int i7) {
            super(i6, j6, th);
            this.aon = i7;
        }

        @Override // com.kwad.framework.filedownloader.message.d.C0661d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.d.C0661d, com.kwad.framework.filedownloader.message.c
        public final byte wJ() {
            return (byte) 5;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int wN() {
            return this.aon;
        }

        h(Parcel parcel) {
            super(parcel);
            this.aon = parcel.readInt();
        }

        @Override // com.kwad.framework.filedownloader.message.d.C0661d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.aon);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class j extends f implements MessageSnapshot.a {
        j(int i6, long j6, long j7) {
            super(i6, j6, j7);
        }

        @Override // com.kwad.framework.filedownloader.message.d.f, com.kwad.framework.filedownloader.message.c
        public final byte wJ() {
            return (byte) -4;
        }

        j(Parcel parcel) {
            super(parcel);
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot.a
        public final MessageSnapshot yS() {
            return new f(this);
        }
    }

    d(int i6) {
        super(i6);
        this.aoJ = true;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class e extends f {
        @Override // com.kwad.framework.filedownloader.message.d.f, com.kwad.framework.filedownloader.message.c
        public final byte wJ() {
            return (byte) -2;
        }

        e(int i6, long j6, long j7) {
            super(i6, j6, j7);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class i extends j implements com.kwad.framework.filedownloader.message.b {
        i(int i6, long j6, long j7) {
            super(i6, j6, j7);
        }
    }

    d(Parcel parcel) {
        super(parcel);
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final int yM() {
        if (yQ() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) yQ();
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final int yN() {
        if (yO() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) yO();
    }
}
