package com.kwad.sdk.pngencrypt;

import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class DeflatedChunksSet {
    private long aUA;
    private long aUB;
    int aUC;
    int aUD;
    public final String aUE;
    protected final boolean aUd;
    protected byte[] aUt;
    private int aUu;
    private int aUv;
    private int aUw;
    State aUx;
    private final boolean aUy;
    private d aUz;
    private Inflater inf;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum State {
        WAITING_FOR_INPUT,
        ROW_READY,
        DONE,
        CLOSED;

        public final boolean isClosed() {
            return this == CLOSED;
        }

        public final boolean isDone() {
            return this == DONE || this == CLOSED;
        }
    }

    public final void ef(int i6) {
        this.aUu = 0;
        this.aUw++;
        if (i6 <= 0) {
            this.aUv = 0;
            Of();
        } else {
            if (this.inf.finished()) {
                this.aUv = 0;
                Of();
                return;
            }
            this.aUx = State.WAITING_FOR_INPUT;
            this.aUv = i6;
            if (this.aUd) {
                return;
            }
            Oc();
        }
    }

    private boolean Oc() {
        int i6;
        try {
            if (this.aUx == State.ROW_READY) {
                new PngjException("invalid state");
            }
            if (this.aUx.isDone()) {
                return false;
            }
            byte[] bArr = this.aUt;
            if (bArr == null || bArr.length < this.aUv) {
                this.aUt = new byte[this.aUv];
            }
            if (this.aUu < this.aUv && !this.inf.finished()) {
                try {
                    Inflater inflater = this.inf;
                    byte[] bArr2 = this.aUt;
                    int i7 = this.aUu;
                    i6 = inflater.inflate(bArr2, i7, this.aUv - i7);
                } catch (DataFormatException e6) {
                    new PngjException("error decompressing zlib stream ", e6);
                    i6 = 0;
                }
                this.aUu += i6;
                this.aUB += i6;
            }
            State state = this.aUu == this.aUv ? State.ROW_READY : !this.inf.finished() ? State.WAITING_FOR_INPUT : this.aUu > 0 ? State.ROW_READY : State.DONE;
            this.aUx = state;
            if (state != State.ROW_READY) {
                return false;
            }
            Od();
            return true;
        } catch (RuntimeException e7) {
            close();
            throw e7;
        }
    }

    protected int Oe() {
        throw new PngjException("not implemented");
    }

    public final int Og() {
        return this.aUw;
    }

    protected final void a(d dVar) {
        if (!this.aUE.equals(dVar.NP().aoB)) {
            new PngjException("Bad chunk inside IdatSet, id:" + dVar.NP().aoB + ", expected:" + this.aUE);
        }
        this.aUz = dVar;
        int i6 = this.aUC + 1;
        this.aUC = i6;
        int i7 = this.aUD;
        if (i7 >= 0) {
            dVar.ee(i6 + i7);
        }
    }

    protected final void b(byte[] bArr, int i6, int i7) {
        this.aUA += i7;
        if (i7 <= 0 || this.aUx.isDone()) {
            return;
        }
        if (this.aUx == State.ROW_READY) {
            new PngjException("this should only be called if waitingForMoreInput");
        }
        if (this.inf.needsDictionary() || !this.inf.needsInput()) {
            throw new RuntimeException("should not happen");
        }
        this.inf.setInput(bArr, i6, i7);
        if (!this.aUd) {
            Oc();
            return;
        }
        while (Oc()) {
            ef(Oe());
            isDone();
        }
    }

    public void close() {
        Inflater inflater;
        try {
            if (!this.aUx.isClosed()) {
                this.aUx = State.CLOSED;
            }
            if (!this.aUy || (inflater = this.inf) == null) {
                return;
            }
            inflater.end();
            this.inf = null;
        } catch (Exception unused) {
        }
    }

    public final boolean gx(String str) {
        if (this.aUx.isClosed()) {
            return false;
        }
        if (str.equals(this.aUE)) {
            return true;
        }
        if (this.aUx.isDone()) {
            if (!this.aUx.isClosed()) {
                close();
            }
            return false;
        }
        throw new PngjException("Unexpected chunk " + str + " while " + this.aUE + " set is not done");
    }

    public final boolean isClosed() {
        return this.aUx.isClosed();
    }

    public final boolean isDone() {
        return this.aUx.isDone();
    }

    public String toString() {
        return new StringBuilder("idatSet : " + this.aUz.NP().aoB + " state=" + this.aUx + " rows=" + this.aUw + " bytes=" + this.aUA + "/" + this.aUB).toString();
    }

    public DeflatedChunksSet(String str, boolean z5, int i6, int i7, Inflater inflater, byte[] bArr) {
        State state = State.WAITING_FOR_INPUT;
        this.aUx = state;
        this.aUA = 0L;
        this.aUB = 0L;
        this.aUC = -1;
        this.aUD = -1;
        this.aUE = str;
        this.aUd = z5;
        this.aUv = i6;
        if (i6 > 0 && i7 >= i6) {
            if (inflater != null) {
                this.inf = inflater;
                this.aUy = false;
            } else {
                this.inf = new Inflater();
                this.aUy = true;
            }
            this.aUt = (bArr == null || bArr.length < i6) ? new byte[i7] : bArr;
            this.aUw = -1;
            this.aUx = state;
            try {
                ef(i6);
                return;
            } catch (RuntimeException e6) {
                close();
                throw e6;
            }
        }
        throw new PngjException("bad inital row len " + i6);
    }

    public final void Of() {
        if (!isDone()) {
            this.aUx = State.DONE;
        }
    }

    protected void Od() {
    }
}
