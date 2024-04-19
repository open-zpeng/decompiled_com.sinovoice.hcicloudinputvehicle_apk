package com.sinovoice.hcicloudinputvehicle.input;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.sinovoice.hcicloudinputvehicle.service.HciCloudInputConnection;
import com.sinovoice.hcicloudinputvehicle.service.f;
import com.sinovoice.hcicloudsdk.common.hwr.HwrConfig;
import java.util.ArrayList;
/* compiled from: HWRInputMethod.java */
/* loaded from: classes.dex */
public class c extends d {
    protected final String h;
    private String i;
    private String j;
    private int k;

    public c(Handler handler, Context context, HciCloudInputConnection hciCloudInputConnection) {
        super(handler, context, hciCloudInputConnection);
        this.h = c.class.getCanonicalName();
        this.i = "";
        this.j = "";
    }

    private void u() {
        this.i = "";
    }

    private void v() {
        this.j = "";
    }

    private String w(int i) {
        String str;
        if (this.d.size() > 0 && i < this.d.size()) {
            str = this.d.get(i);
        } else if (this.e.size() > 0 && i < this.e.size()) {
            str = this.e.get(i);
        } else {
            b.b.a.b.a.b(this.h, "handleCandidateChosen() index error");
            return "";
        }
        if (this.k == 1 && f.b().a().c()) {
            HciCloudInputConnection hciCloudInputConnection = this.c;
            hciCloudInputConnection.commitString(str + " ", 1);
        } else {
            this.c.commitString(str, 1);
        }
        u();
        String str2 = this.h;
        b.b.a.b.a.c(str2, "handleCandidateChosen()  commitString:  " + str);
        return str;
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void a(char c) {
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void d() {
        q();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public String e() {
        return this.i;
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void f(short[] sArr) {
        ArrayList<String> hwrRecogEnglish;
        if (this.i.length() > 0) {
            String w = w(0);
            if (w.length() > this.c.getComposingLength()) {
                this.c.finishComposingText();
                q();
                return;
            }
        }
        v();
        b();
        if (this.k == 0) {
            hwrRecogEnglish = com.sinovoice.hcicloudinputvehicle.engine.handwrite.c.a().hwrRecogChinese(sArr, y());
        } else {
            hwrRecogEnglish = com.sinovoice.hcicloudinputvehicle.engine.handwrite.c.a().hwrRecogEnglish(sArr);
        }
        String str = this.h;
        b.b.a.b.a.c(str, "getHWRCandidateWords()  result count:" + hwrRecogEnglish.size());
        for (int i = 0; i < hwrRecogEnglish.size(); i++) {
            String str2 = hwrRecogEnglish.get(i);
            if (str2 != null && str2.length() > 0) {
                if (i == 0) {
                    this.c.commitComposing(str2);
                    this.i = str2;
                    this.d.add(str2);
                } else {
                    this.d.add(str2);
                }
            }
        }
        p();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void g() {
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void h(int i) {
        String w = w(i);
        if (w.length() > this.c.getComposingLength()) {
            this.c.finishComposingText();
            q();
        }
        if (!TextUtils.isEmpty(this.j) && !TextUtils.isEmpty(w)) {
            com.sinovoice.hcicloudinputvehicle.engine.handwrite.c a2 = com.sinovoice.hcicloudinputvehicle.engine.handwrite.c.a();
            a2.raisePriorityChinese(this.j + w);
        }
        this.j = w;
        x(w);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void i() {
        if (this.i.length() > 0) {
            this.c.finishComposingText();
            this.c.keyDownUp(67);
            b();
        } else {
            if (this.e.size() > 0) {
                b();
            }
            this.c.keyDownUp(67);
        }
        v();
        u();
        p();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void j() {
        if (this.d.size() > 0) {
            this.c.finishComposingText();
            v();
            u();
            b();
        } else {
            b();
            this.c.keyDownUp(66);
        }
        p();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void k(int i) {
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void l() {
        if (this.i.length() > this.c.getComposingLength()) {
            q();
            return;
        }
        String str = this.d.size() > 0 ? this.d.get(0) : "";
        int i = this.k;
        if (i == 0) {
            if (!str.equals("")) {
                h(0);
                return;
            }
            v();
            b();
            p();
            this.c.keyDownUp(62);
        } else if (i == 1) {
            if (!str.equals("")) {
                h(0);
                if (f.b().a().c()) {
                    return;
                }
                this.c.keyDownUp(62);
                return;
            }
            v();
            b();
            p();
            this.c.keyDownUp(62);
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void m(int i) {
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void n(String str) {
        if (this.i.length() > this.c.getComposingLength()) {
            q();
            return;
        }
        if (this.i.isEmpty()) {
            this.c.commitSymbol(str, 1);
        } else {
            HciCloudInputConnection hciCloudInputConnection = this.c;
            hciCloudInputConnection.commitString(this.i + str, 1);
        }
        u();
        b();
        p();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void q() {
        this.c.finishComposingText();
        u();
        v();
        super.q();
    }

    public void x(String str) {
        b.b.a.b.a.c(this.h, "getAssociateWords() start");
        b();
        this.e.addAll(com.sinovoice.hcicloudinputvehicle.engine.handwrite.c.a().associateChinese(str));
        o();
    }

    public String y() {
        HwrConfig hwrConfig = new HwrConfig();
        hwrConfig.addParam("dispCode", "nochange");
        this.f179b.getResources().getConfiguration();
        hwrConfig.addParam(HwrConfig.InputConfig.PARAM_KEY_SPLIT_MODE, f.b().a().a());
        return hwrConfig.getStringConfig();
    }

    public void z(int i) {
        this.k = i;
    }
}
