package com.sinovoice.hcicloudinputvehicle.input;

import android.content.Context;
import android.os.Handler;
import com.sinovoice.hcicloudinputvehicle.service.HciCloudInputConnection;
/* compiled from: DefaultInputMethod.java */
/* loaded from: classes.dex */
public class a extends d {
    protected static final String h = "com.sinovoice.hcicloudinputvehicle.input.a";

    public a(Handler handler, Context context, HciCloudInputConnection hciCloudInputConnection) {
        super(handler, context, hciCloudInputConnection);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void a(char c) {
        this.c.commitString(String.valueOf(c), 1);
        String str = h;
        b.b.a.b.a.c(str, "appendRecognizeChar() isWord==false commitString:   " + c);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void d() {
        q();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void f(short[] sArr) {
        b.b.a.b.a.b(h, "DefaultInputMethod has no hwrcandidates.");
        try {
            throw new IllegalStateException("DefaultInputMethod has no hwrcandidates.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void g() {
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void h(int i) {
        b.b.a.b.a.b(h, "DefaultInputMethod has no candidate word to selected.");
        try {
            throw new IllegalStateException("DefaultInputMethod has no candidate word to selected.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void i() {
        this.c.keyDownUp(67);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void j() {
        this.c.keyDownUp(66);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void k(int i) {
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void l() {
        this.c.keyDownUp(62);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void m(int i) {
        b.b.a.b.a.b(h, "DefaultInputMethod has no Syllable word to choose.");
        try {
            throw new IllegalStateException("DefaultInputMethod has no Syllable word to choose.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void n(String str) {
        this.c.commitSymbol(str, 1);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void q() {
        super.q();
    }
}
