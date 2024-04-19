package com.sinovoice.hcicloudinputvehicle.input;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.sinovoice.hcicloudinputvehicle.R;
import com.sinovoice.hcicloudinputvehicle.service.HciCloudInputConnection;
import com.sinovoice.hcicloudinputvehicle.service.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: EnglishInputMethod.java */
/* loaded from: classes.dex */
public class b extends d {
    protected static final String h = "b";
    private int i;
    protected StringBuilder j;
    private boolean k;

    public b(Handler handler, Context context, HciCloudInputConnection hciCloudInputConnection) {
        super(handler, context, hciCloudInputConnection);
        this.i = 0;
        this.j = new StringBuilder();
        this.k = true;
    }

    private void u() {
        StringBuilder sb = this.j;
        sb.delete(0, sb.length());
    }

    private boolean v() {
        return this.j.length() > 0;
    }

    private void w(int i) {
        StringBuilder sb = this.j;
        if (sb == null || sb.length() == 0) {
            return;
        }
        String str = h;
        Log.d(str, "shiftMode:" + i);
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            String str2 = this.d.get(i2);
            if (str2.length() >= this.j.length()) {
                String substring = str2.substring(this.j.length());
                if (i == 2) {
                    List<String> list = this.d;
                    list.set(i2, ((Object) this.j) + substring.toUpperCase());
                } else if (i == 1) {
                    List<String> list2 = this.d;
                    list2.set(i2, ((Object) this.j) + substring);
                } else {
                    List<String> list3 = this.d;
                    list3.set(i2, ((Object) this.j) + substring.toLowerCase());
                }
            }
        }
    }

    private void x(String str) {
        ArrayList<com.sinovoice.hcicloudinputvehicle.engine.keyboard.e> a2 = com.sinovoice.hcicloudinputvehicle.engine.keyboard.b.a().queryEnglish(str).a();
        this.d.clear();
        Iterator<com.sinovoice.hcicloudinputvehicle.engine.keyboard.e> it = a2.iterator();
        while (it.hasNext()) {
            this.d.add(it.next().a());
        }
        w(this.i);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void a(char c) {
        if (this.j.length() > 30) {
            s(R.string.text_to_long);
            if (this.j.toString().equalsIgnoreCase("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv")) {
                b();
                this.d.add(com.sinovoice.hcicloudinputvehicle.tools.c.a(this.f179b));
                p();
                return;
            }
            return;
        }
        b();
        this.j.append(c);
        this.c.commitComposing(this.j.toString());
        x(this.j.toString());
        p();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void d() {
        q();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public String e() {
        return this.j.toString();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void f(short[] sArr) {
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void g() {
        if (this.j != null) {
            ArrayList<com.sinovoice.hcicloudinputvehicle.engine.keyboard.e> a2 = com.sinovoice.hcicloudinputvehicle.engine.keyboard.b.a().getMoreEnglish().a();
            this.d.clear();
            Iterator<com.sinovoice.hcicloudinputvehicle.engine.keyboard.e> it = a2.iterator();
            while (it.hasNext()) {
                this.d.add(it.next().a());
            }
            w(this.i);
            p();
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void h(int i) {
        int size = this.d.size();
        if (this.j.length() > this.c.getComposingLength()) {
            q();
        } else if (i < size) {
            String str = this.d.get(i);
            y(str);
            if (!f.b().a().c()) {
                this.c.commitString(str, 1);
            } else {
                HciCloudInputConnection hciCloudInputConnection = this.c;
                hciCloudInputConnection.commitString(str + " ", 1);
            }
            u();
            b();
            p();
        } else {
            b.b.a.b.a.b(h, "handleCandidateChosen index error");
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void i() {
        if (this.j.length() > this.c.getComposingLength()) {
            q();
            return;
        }
        if (this.j.length() > 0) {
            StringBuilder sb = this.j;
            sb.deleteCharAt(sb.length() - 1);
            this.c.commitComposing(this.j.toString());
            x(this.j.toString());
            if (this.j.length() == 0) {
                b();
                p();
            }
        } else if (this.j.length() == 0) {
            if (this.d.size() > 0) {
                b();
            }
            this.c.keyDownUp(67);
        }
        p();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void j() {
        if (this.j.length() > this.c.getComposingLength()) {
            q();
            return;
        }
        if (this.j.length() > 0) {
            this.c.commitString(this.j.toString(), 1);
            u();
            String str = h;
            b.b.a.b.a.c(str, "handleEnter() commitString:   " + ((Object) this.j));
            b();
        } else {
            b();
            this.c.keyDownUp(66);
        }
        p();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void k(int i) {
        this.i = i;
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void l() {
        if (this.j.length() > this.c.getComposingLength()) {
            q();
            return;
        }
        String str = this.d.size() > 0 ? this.d.get(0) : "";
        if (this.j.length() > 0) {
            if (!str.equals("")) {
                h(0);
                if (!f.b().a().c()) {
                    this.c.keyDownUp(62);
                }
            } else {
                this.c.commitString(this.j.toString(), 1);
                String str2 = h;
                b.b.a.b.a.c(str2, "handleSpace() commitString:   " + this.j.toString());
                b();
            }
        } else {
            b();
            this.c.keyDownUp(62);
        }
        p();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void m(int i) {
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void n(String str) {
        if (this.j.length() > this.c.getComposingLength()) {
            q();
            return;
        }
        String str2 = (this.d.size() <= 0 || !v()) ? "" : this.d.get(0);
        if (str2.isEmpty()) {
            this.c.commitSymbol(str, 1);
        } else {
            HciCloudInputConnection hciCloudInputConnection = this.c;
            hciCloudInputConnection.commitString(str2 + str, 1);
        }
        u();
        b();
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void p() {
        super.p();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void q() {
        this.c.finishComposingText();
        u();
        b();
        this.c.commitComposingStr("");
        super.p();
    }

    void y(String str) {
    }
}
