package com.sinovoice.hcicloudinputvehicle.input;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.sinovoice.hcicloudinputvehicle.R;
import com.sinovoice.hcicloudinputvehicle.service.HciCloudInputConnection;
import com.sinovoice.hcicloudinputvehicle.service.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* compiled from: PinYinInputMethod.java */
/* loaded from: classes.dex */
public class e extends d {
    private static final String h = "com.sinovoice.hcicloudinputvehicle.input.e";
    private com.sinovoice.hcicloudinputvehicle.engine.keyboard.d i;
    private String j;
    private PinyinComposingInterface k;
    private List<String> l;
    private List<String> m;
    private final char[] n;
    private final char[] o;
    private int p;
    private final String[][] q;

    /* compiled from: PinYinInputMethod.java */
    /* loaded from: classes.dex */
    private class b implements PinyinComposingInterface {

        /* renamed from: a  reason: collision with root package name */
        private StringBuilder f180a;

        /* renamed from: b  reason: collision with root package name */
        private StringBuilder f181b;
        private ArrayList<c> c;
        private c d;
        private StringBuilder e;

        private b() {
            this.f180a = new StringBuilder();
            this.f181b = new StringBuilder();
            this.c = new ArrayList<>();
            this.d = new c();
            this.e = new StringBuilder();
        }

        private void a() {
            this.f180a.setLength(0);
            this.f181b.setLength(0);
            StringBuilder sb = new StringBuilder();
            Iterator<c> it = this.c.iterator();
            while (it.hasNext()) {
                sb.append((CharSequence) it.next().f182a);
            }
            StringBuilder sb2 = this.f181b;
            sb.append(this.f180a.toString());
            sb2.append((CharSequence) sb);
            if (this.e.length() > 0 && b(this.e.toString())) {
                if (this.d.f183b.length() > 0) {
                    this.f181b.append((CharSequence) this.d.f183b);
                    String str = e.h;
                    b.b.a.b.a.a(str, "firstCandidateWord.pinyin = " + this.d.f183b.toString());
                    String str2 = e.h;
                    b.b.a.b.a.a(str2, "unusedQuery = " + this.e.toString());
                    if (this.e.length() > this.d.f183b.length()) {
                        this.f181b.append(c(this.e.subSequence(this.d.f183b.length(), this.e.length()).toString()));
                    }
                } else {
                    this.f181b.append(c(this.e.toString()));
                }
            } else {
                this.f181b.append(this.e.toString());
            }
            this.f180a.append(this.e.toString());
        }

        private boolean b(String str) {
            for (int i = 0; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i))) {
                    return true;
                }
            }
            return false;
        }

        private String c(String str) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (Character.isDigit(charAt)) {
                    sb.append(e.this.o[charAt - '2']);
                } else {
                    sb.append(charAt);
                }
            }
            return sb.toString();
        }

        @Override // com.sinovoice.hcicloudinputvehicle.input.PinyinComposingInterface
        public void appendLetter(char c) {
            this.e.append(c);
            a();
        }

        @Override // com.sinovoice.hcicloudinputvehicle.input.PinyinComposingInterface
        public void appendSelectedItem(String str, String str2) {
            this.c.add(new c(str, str2, this.e.substring(0, str2.length())));
            String str3 = e.h;
            b.b.a.b.a.a(str3, "chosenWord = [" + str + "] syllable = [" + str2 + "]");
            this.e.delete(0, str2.length());
            a();
        }

        @Override // com.sinovoice.hcicloudinputvehicle.input.PinyinComposingInterface
        public void appendSelectedSyllable(String str) {
            if (str.length() <= this.e.length()) {
                this.e.delete(0, str.length());
                this.e.insert(0, str);
                a();
            }
        }

        @Override // com.sinovoice.hcicloudinputvehicle.input.PinyinComposingInterface
        public void clear() {
            this.f180a.setLength(0);
            this.f181b.setLength(0);
            this.d.f182a.setLength(0);
            this.d.f183b.setLength(0);
            this.e.setLength(0);
            this.c.clear();
        }

        @Override // com.sinovoice.hcicloudinputvehicle.input.PinyinComposingInterface
        public void del() {
            if (this.c.size() > 0) {
                ArrayList<c> arrayList = this.c;
                this.e.insert(0, arrayList.remove(arrayList.size() - 1).c.toString());
            } else if (this.e.length() > 0) {
                StringBuilder sb = this.e;
                sb.deleteCharAt(sb.length() - 1);
            } else if (this.d.f183b.length() > 0) {
                StringBuilder sb2 = this.d.f183b;
                sb2.deleteCharAt(sb2.length() - 1);
            }
            a();
        }

        @Override // com.sinovoice.hcicloudinputvehicle.input.PinyinComposingInterface
        public String getCompoingToQuery() {
            return this.f180a.toString();
        }

        @Override // com.sinovoice.hcicloudinputvehicle.input.PinyinComposingInterface
        public String getComposingToCommiting() {
            return this.f181b.toString();
        }

        @Override // com.sinovoice.hcicloudinputvehicle.input.PinyinComposingInterface
        public String getCurrentOutput() {
            return getComposingToCommiting();
        }

        @Override // com.sinovoice.hcicloudinputvehicle.input.PinyinComposingInterface
        public char getLastCharOfCompoingToQuery() {
            if (this.f180a.length() > 0) {
                StringBuilder sb = this.f180a;
                return sb.charAt(sb.length() - 1);
            }
            return (char) 0;
        }

        @Override // com.sinovoice.hcicloudinputvehicle.input.PinyinComposingInterface
        public String getSelectComposing() {
            return "";
        }

        @Override // com.sinovoice.hcicloudinputvehicle.input.PinyinComposingInterface
        public boolean isMatchComplete() {
            return this.f180a.length() == 0;
        }

        @Override // com.sinovoice.hcicloudinputvehicle.input.PinyinComposingInterface
        public void updateFirstCandidate(String str, String str2) {
            this.d.f182a.setLength(0);
            this.d.f183b.setLength(0);
            this.d.f182a.append(str);
            this.d.f183b.append(str2);
            a();
        }
    }

    public e(Handler handler, Context context, HciCloudInputConnection hciCloudInputConnection) {
        super(handler, context, hciCloudInputConnection);
        this.j = "";
        this.k = new b();
        this.l = Collections.synchronizedList(new ArrayList());
        this.m = Collections.synchronizedList(new ArrayList());
        this.n = new char[]{'2', '2', '2', '3', '3', '3', '4', '4', '4', '5', '5', '5', '6', '6', '6', '7', '7', '7', '7', '8', '8', '8', '9', '9', '9', '9'};
        this.o = new char[]{'a', 'd', 'g', 'j', 'm', 'p', 't', 'w'};
        this.p = 0;
        this.q = new String[][]{new String[]{"ch", "c"}, new String[]{"sh", "s"}, new String[]{"zh", "z"}, new String[]{"k", "g"}, new String[]{"f", "h"}, new String[]{"n", "l"}, new String[]{"r", "l"}, new String[]{"ang", "an"}, new String[]{"eng", "en"}, new String[]{"ing", "in"}, new String[]{"iang", "ian"}, new String[]{"uang", "uan"}};
    }

    private void A(String str, boolean z) {
        if (f.b().a().d()) {
            com.sinovoice.hcicloudinputvehicle.engine.keyboard.b.a().setPinYinFuzzy(true);
        } else {
            com.sinovoice.hcicloudinputvehicle.engine.keyboard.b.a().setPinYinFuzzy(false);
        }
        com.sinovoice.hcicloudinputvehicle.engine.keyboard.d queryPinYin = com.sinovoice.hcicloudinputvehicle.engine.keyboard.b.a().queryPinYin(str);
        this.i = queryPinYin;
        ArrayList<com.sinovoice.hcicloudinputvehicle.engine.keyboard.e> a2 = queryPinYin.a();
        b();
        if (a2.isEmpty()) {
            b.b.a.b.a.a(h, "queryAndUpdateCandidate: items is empty");
            this.d.add(str);
        } else {
            this.k.updateFirstCandidate(a2.get(0).a(), a2.get(0).b());
        }
        Iterator<com.sinovoice.hcicloudinputvehicle.engine.keyboard.e> it = a2.iterator();
        while (it.hasNext()) {
            this.d.add(it.next().a());
        }
        if (z) {
            return;
        }
        w();
        this.l.addAll(this.i.b());
    }

    private void w() {
        List<String> list = this.l;
        if (list != null) {
            list.clear();
        }
    }

    private void y() {
    }

    private void z(String str) {
        A(str, false);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void a(char c2) {
        if (this.k.getComposingToCommiting().length() > 30) {
            s(R.string.text_to_long);
            if (this.k.getComposingToCommiting().equalsIgnoreCase("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv")) {
                b();
                this.d.add(com.sinovoice.hcicloudinputvehicle.tools.c.a(this.f179b));
                p();
            }
        } else if (this.k.getLastCharOfCompoingToQuery() == '\'' && c2 == '\'') {
        } else {
            if (c2 == '\'' && this.k.getCompoingToQuery().length() == 0) {
                return;
            }
            b();
            this.k.appendLetter(c2);
            z(this.k.getCompoingToQuery());
            this.c.commitComposingStr(this.k.getComposingToCommiting());
            p();
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void d() {
        List<String> list;
        if (this.g == 0 && (list = this.d) != null && list.size() > 0) {
            h(0);
        }
        this.k.clear();
        b();
        w();
        this.c.commitComposingStr("");
        p();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void f(short[] sArr) {
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void g() {
        String composingToCommiting = this.k.getComposingToCommiting();
        if (composingToCommiting != null && composingToCommiting.length() > 0) {
            com.sinovoice.hcicloudinputvehicle.engine.keyboard.d morePinYin = com.sinovoice.hcicloudinputvehicle.engine.keyboard.b.a().getMorePinYin();
            this.i = morePinYin;
            ArrayList<com.sinovoice.hcicloudinputvehicle.engine.keyboard.e> a2 = morePinYin.a();
            if (!a2.isEmpty()) {
                this.d.clear();
            }
            Iterator<com.sinovoice.hcicloudinputvehicle.engine.keyboard.e> it = a2.iterator();
            while (it.hasNext()) {
                this.d.add(it.next().a());
            }
        }
        p();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void h(int i) {
        if (this.k.getComposingToCommiting().length() > 0) {
            if (i < this.d.size()) {
                if (this.i.a().size() == 0) {
                    j();
                    return;
                }
                this.k.appendSelectedItem(this.i.a().get(i).a(), this.i.a().get(i).b());
                if (this.k.isMatchComplete()) {
                    String currentOutput = this.k.getCurrentOutput();
                    if (currentOutput.length() > 0) {
                        com.sinovoice.hcicloudinputvehicle.engine.keyboard.b.a().submitChineseUDB(currentOutput, this.i.a().get(i).b());
                        com.sinovoice.hcicloudinputvehicle.engine.handwrite.c.a().raisePriorityChinese(currentOutput);
                        this.c.commitString(currentOutput, 1);
                        String str = h;
                        Log.d(str, "handleCandidateChosen()  commitString:  " + currentOutput);
                    } else {
                        this.c.commitString(this.d.get(i), 1);
                        String str2 = h;
                        Log.d(str2, "handleCandidateChosen()  direct commitString:  " + this.d.get(i));
                    }
                    this.k.clear();
                    w();
                    y();
                    x(this.d.get(i));
                } else {
                    b();
                    z(this.k.getCompoingToQuery());
                    p();
                }
                this.c.commitComposingStr(this.k.getComposingToCommiting());
                return;
            }
            b.b.a.b.a.c(h, "handleCandidateChosen index error");
        } else if (i >= this.e.size()) {
        } else {
            this.c.commitString(this.e.get(i), 1);
            String str3 = h;
            b.b.a.b.a.c(str3, "handleCandidateChosen()  commitString:  " + this.e.get(i));
            if (this.j != null) {
                com.sinovoice.hcicloudinputvehicle.engine.handwrite.c a2 = com.sinovoice.hcicloudinputvehicle.engine.handwrite.c.a();
                a2.raisePriorityChinese(this.j + this.e.get(i));
            }
            x(this.e.get(i));
            this.j = null;
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void i() {
        if (this.k.getComposingToCommiting().length() > 0) {
            this.k.del();
            z(this.k.getCompoingToQuery());
            if (this.k.getComposingToCommiting().length() == 0) {
                b();
            }
            this.c.commitComposingStr(this.k.getComposingToCommiting());
        } else {
            if (this.e.size() > 0) {
                b();
            }
            this.c.keyDownUp(67);
        }
        p();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void j() {
        String composingToCommiting = this.k.getComposingToCommiting();
        if (composingToCommiting.length() > this.c.getComposingLength()) {
            this.c.finishComposingText();
            q();
        }
        if (composingToCommiting.length() > 0) {
            this.c.commitString(composingToCommiting.replace("'", ""), 1);
            String str = h;
            b.b.a.b.a.c(str, "handleEnter() commitString:   " + composingToCommiting);
        } else {
            this.c.keyDownUp(66);
        }
        this.k.clear();
        this.c.commitComposingStr(this.k.getComposingToCommiting());
        b();
        w();
        p();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void k(int i) {
        this.p = i;
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void l() {
        String composingToCommiting = this.k.getComposingToCommiting();
        if (composingToCommiting.length() > 0) {
            if (this.d.size() > 0) {
                h(0);
                return;
            }
            this.c.commitString(composingToCommiting.replace("'", ""), 1);
            String str = h;
            b.b.a.b.a.c(str, "handleSpace() commitString:   " + composingToCommiting);
            this.k.clear();
            this.c.commitComposingStr(this.k.getComposingToCommiting());
            p();
            return;
        }
        this.c.keyDownUp(62);
        this.c.commitComposingStr(this.k.getComposingToCommiting());
        p();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void m(int i) {
        this.k.appendSelectedSyllable(this.l.get(i));
        b();
        A(this.k.getCompoingToQuery(), true);
        this.c.commitComposingStr(this.k.getComposingToCommiting());
        p();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void n(String str) {
        List<String> list;
        if (this.g == 0 && (list = this.d) != null && list.size() > 0) {
            h(0);
        }
        this.c.commitSymbol(str, 1);
        this.k.clear();
        this.c.commitComposingStr(this.k.getComposingToCommiting());
        b();
        w();
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void p() {
        super.p();
        y();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.input.d
    public void q() {
        this.k.clear();
        b();
        w();
        this.c.commitComposingStr("");
        p();
    }

    public void x(String str) {
        b.b.a.b.a.c(h, "getAssociateWords() start");
        b();
        this.j = str;
        this.e.addAll(com.sinovoice.hcicloudinputvehicle.engine.handwrite.c.a().associateChinese(str));
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PinYinInputMethod.java */
    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        StringBuilder f182a;

        /* renamed from: b  reason: collision with root package name */
        StringBuilder f183b;
        StringBuilder c;

        public c(String str, String str2, String str3) {
            this.f182a = new StringBuilder();
            this.f183b = new StringBuilder();
            this.c = new StringBuilder();
            this.f182a = new StringBuilder(str);
            this.f183b = new StringBuilder(str2);
            this.c = new StringBuilder(str3);
        }

        public c() {
            this.f182a = new StringBuilder();
            this.f183b = new StringBuilder();
            this.c = new StringBuilder();
        }
    }
}
