package com.kwad.framework.filedownloader.message;

import android.os.Parcel;
import com.kwad.framework.filedownloader.message.MessageSnapshot;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class h extends MessageSnapshot {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a extends b implements com.kwad.framework.filedownloader.message.b {
        a(int i6, boolean z5, int i7) {
            super(i6, true, i7);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b extends h {
        private final boolean aoF;
        private final int aoT;

        b(int i6, boolean z5, int i7) {
            super(i6);
            this.aoF = z5;
            this.aoT = i7;
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
        public final int yN() {
            return this.aoT;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean yP() {
            return this.aoF;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeByte(this.aoF ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.aoT);
        }

        b(Parcel parcel) {
            super(parcel);
            this.aoF = parcel.readByte() != 0;
            this.aoT = parcel.readInt();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class c extends h {
        private final String anc;
        private final boolean aoG;
        private final int aoT;
        private final String fileName;

        c(int i6, boolean z5, int i7, String str, String str2) {
            super(i6);
            this.aoG = z5;
            this.aoT = i7;
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
        public final int yN() {
            return this.aoT;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeByte(this.aoG ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.aoT);
            parcel.writeString(this.anc);
            parcel.writeString(this.fileName);
        }

        c(Parcel parcel) {
            super(parcel);
            this.aoG = parcel.readByte() != 0;
            this.aoT = parcel.readInt();
            this.anc = parcel.readString();
            this.fileName = parcel.readString();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class d extends h {
        private final Throwable aoI;
        private final int aoU;

        d(int i6, int i7, Throwable th) {
            super(i6);
            this.aoU = i7;
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
        public final int yM() {
            return this.aoU;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final Throwable yR() {
            return this.aoI;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.aoU);
            parcel.writeSerializable(this.aoI);
        }

        d(Parcel parcel) {
            super(parcel);
            this.aoU = parcel.readInt();
            this.aoI = (Throwable) parcel.readSerializable();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class f extends h {
        private final int aoT;
        private final int aoU;

        f(f fVar) {
            this(fVar.getId(), fVar.yM(), fVar.yN());
        }

        public byte wJ() {
            return (byte) 1;
        }

        f(int i6, int i7, int i8) {
            super(i6);
            this.aoU = i7;
            this.aoT = i8;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int yM() {
            return this.aoU;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int yN() {
            return this.aoT;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.aoU);
            parcel.writeInt(this.aoT);
        }

        f(Parcel parcel) {
            super(parcel);
            this.aoU = parcel.readInt();
            this.aoT = parcel.readInt();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class g extends h {
        private final int aoU;

        g(int i6, int i7) {
            super(i6);
            this.aoU = i7;
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
        public final int yM() {
            return this.aoU;
        }

        g(Parcel parcel) {
            super(parcel);
            this.aoU = parcel.readInt();
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.aoU);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.framework.filedownloader.message.h$h, reason: collision with other inner class name */
    public static class C0662h extends d {
        private final int aon;

        C0662h(int i6, int i7, Throwable th, int i8) {
            super(i6, i7, th);
            this.aon = i8;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.c
        public final byte wJ() {
            return (byte) 5;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int wN() {
            return this.aon;
        }

        C0662h(Parcel parcel) {
            super(parcel);
            this.aon = parcel.readInt();
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.aon);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class j extends f implements MessageSnapshot.a {
        j(int i6, int i7, int i8) {
            super(i6, i7, i8);
        }

        @Override // com.kwad.framework.filedownloader.message.h.f, com.kwad.framework.filedownloader.message.c
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

    h(int i6) {
        super(i6);
        this.aoJ = false;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class e extends f {
        @Override // com.kwad.framework.filedownloader.message.h.f, com.kwad.framework.filedownloader.message.c
        public final byte wJ() {
            return (byte) -2;
        }

        e(int i6, int i7, int i8) {
            super(i6, i7, i8);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class i extends j implements com.kwad.framework.filedownloader.message.b {
        i(int i6, int i7, int i8) {
            super(i6, i7, i8);
        }
    }

    h(Parcel parcel) {
        super(parcel);
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final long yO() {
        return yN();
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final long yQ() {
        return yM();
    }
}
