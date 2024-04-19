package com.sinovoice.hcicloudinputvehicle.service;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sinovoice.hcicloudinputvehicle.R;
import com.sinovoice.hcicloudinputvehicle.ui.CandidateView.CandidateView;
import com.sinovoice.hcicloudinputvehicle.ui.CandidateView.MoreCandidateView;
import com.sinovoice.hcicloudinputvehicle.ui.InputView;
import com.sinovoice.hcicloudinputvehicle.ui.KeyboardView;
import com.sinovoice.hcicloudinputvehicle.ui.SymbolView;
import com.sinovoice.hcicloudinputvehicle.ui.UITheme;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: KeyboardSwitcher.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final e f221a = new e();
    private InputView C;
    private Context D;
    private KeyboardView E;
    private int I;

    /* renamed from: b  reason: collision with root package name */
    private UITheme f222b;
    private HciCloudIME c;
    private CandidateView d;
    private com.sinovoice.hcicloudinputvehicle.ui.c e;
    private KeyboardId f;
    private KeyboardId g;
    private KeyboardId h;
    private KeyboardId i;
    private KeyboardId j;
    private KeyboardId k;
    private KeyboardId l;
    private KeyboardId m;
    private KeyboardId n;
    private KeyboardId o;
    private Map<KeyboardId, SoftReference<com.sinovoice.hcicloudinputvehicle.ui.a>> p;
    private int q;
    private b.a.a.e r;
    private com.sinovoice.hcicloudinputvehicle.tools.e s;
    private SymbolView t;
    private MoreCandidateView u;
    private View v;
    private OnKeyboardModeListener w;
    private com.sinovoice.hcicloudinputvehicle.ui.widget.a z;
    private boolean x = true;
    private int y = 1;
    private boolean A = true;
    private boolean B = true;
    private boolean F = false;
    boolean G = false;
    private boolean H = false;

    private e() {
    }

    private void C(KeyboardId keyboardId) {
        if (keyboardId.getInputMode() == 3) {
            this.E.setAltKey(false);
        } else {
            this.E.setAltKey(true);
        }
        OnKeyboardModeListener onKeyboardModeListener = this.w;
        if (onKeyboardModeListener != null) {
            onKeyboardModeListener.onInputModeChange(keyboardId.getInputMode());
        }
    }

    private void I(KeyboardId keyboardId) {
    }

    private void J(KeyboardId keyboardId) {
        if (keyboardId.getKbName().equalsIgnoreCase("num_qwerty_cn") || keyboardId.getKbName().equalsIgnoreCase("num_qwerty_en")) {
            return;
        }
        if (keyboardId.getLayoutMode() == 1) {
            this.d.setDisplayMode(3);
        } else {
            this.d.setDisplayMode(2);
        }
    }

    private void K() {
        this.d.setDataPadding(this.l.getKbName().contains("en"));
    }

    private void M() {
        this.v.setBackground(this.f222b.e(this.D.getResources().getResourceName(R.drawable.keyboard_back_ground)));
    }

    private void O(com.sinovoice.hcicloudinputvehicle.ui.a aVar) {
        this.E.setKeyboard(aVar);
    }

    private void P(boolean z) {
        this.E.setPreviewEnabled(z);
    }

    private void T() {
        this.I = this.l.getInputMode();
    }

    private void U(KeyboardId keyboardId) {
        V(keyboardId, this.y);
    }

    private void V(KeyboardId keyboardId, int i) {
        this.l = keyboardId;
        if (this.H && keyboardId.getKbName().equalsIgnoreCase("en_qwerty")) {
            this.l = this.k;
        }
        Q(false);
        O(k(this.l));
        b(this.l.getLayoutMode());
        J(this.l);
        if (this.H) {
            this.d.q();
        } else {
            this.d.D();
        }
        P(this.l.isNeedPreview());
        this.E.setEnterActionMode(i);
        C(this.l);
        this.w.onShiftModeChange(this.E.getShiftMode());
        K();
    }

    private void a() {
        if (this.I == 20) {
            f();
        } else {
            e();
        }
    }

    private void b(int i) {
        if (i == 0) {
            this.v.setVisibility(0);
            this.t.h();
            this.z.k();
            this.e.b();
        } else if (i == 1) {
            this.t.h();
            this.z.f();
            this.e.g(1);
        } else if (i == 2) {
            this.t.h();
            this.z.f();
            this.e.c();
            this.e.g(0);
        } else if (i == 3) {
            this.v.setVisibility(8);
            this.e.b();
            this.z.f();
            this.t.m(this.v, this);
        } else if (i != 4) {
        } else {
            this.v.setVisibility(0);
            this.t.h();
            this.z.k();
            this.e.b();
        }
    }

    private void c(boolean z) {
        if (z) {
            com.sinovoice.hcicloudinputvehicle.ui.a.z();
            this.f222b.m("_night");
            this.p.clear();
            return;
        }
        com.sinovoice.hcicloudinputvehicle.ui.a.y();
        this.f222b.m("");
        this.p.clear();
    }

    private void d0() {
        KeyboardId keyboardId = this.n;
        if (keyboardId != null) {
            U(keyboardId);
        }
    }

    private void h() {
        boolean z;
        boolean a2 = com.xiaopeng.libtheme.a.a(this.c);
        if (this.F != a2) {
            z = true;
            this.F = a2;
        } else {
            z = false;
        }
        if (this.B || z) {
            c(a2);
            A();
            this.B = false;
        }
    }

    public static e j() {
        return f221a;
    }

    private com.sinovoice.hcicloudinputvehicle.ui.a k(KeyboardId keyboardId) {
        SoftReference<com.sinovoice.hcicloudinputvehicle.ui.a> softReference = this.p.get(keyboardId);
        if ((softReference == null ? null : softReference.get()) == null) {
            this.p.put(keyboardId, new SoftReference<>(new com.sinovoice.hcicloudinputvehicle.ui.a(this.D, this.f222b.k(keyboardId.getKbName()), keyboardId.getKbMode(), (int) ((this.D.getResources().getDimension(R.dimen.keyboard_main_width) - this.D.getResources().getDimension(R.dimen.keyboard_margin_left)) - this.D.getResources().getDimension(R.dimen.keyboard_margin_right)), 0)));
        }
        return this.p.get(keyboardId).get();
    }

    private KeyboardId l(int i) {
        this.H = false;
        if (i != 1) {
            if (i != 3) {
                if (i != 4 && i != 5 && i != 6 && i != 7) {
                    return this.l;
                }
                this.H = true;
                return this.k;
            }
            return this.f;
        }
        return this.n;
    }

    public static void r(HciCloudIME hciCloudIME) {
        f221a.s(hciCloudIME);
    }

    private void s(HciCloudIME hciCloudIME) {
        this.c = hciCloudIME;
        this.D = hciCloudIME;
        this.f222b = new UITheme(this.D);
    }

    private void y() {
        this.h = new KeyboardId("cn_qwerty", 0, 0, 2);
        this.i = new KeyboardId("en_qwerty", 1, 0, 2);
        this.j = new KeyboardId("win_handwrite_cn", 2, 1);
        this.f = new KeyboardId("num_qwerty_cn", 3, 0, 1);
        this.g = new KeyboardId("num_qwerty_en", 3, 0, 1);
        this.m = new KeyboardId("num_t9", 3, 3, false);
        this.k = new KeyboardId("en_qwerty_psw", 3, 0, 2);
        this.p = new HashMap();
        this.o = this.h;
    }

    private void z() {
        String e = this.s.e("last_keyboard_id", this.r.r(this.h));
        if (!e.contains("kbName")) {
            this.n = this.h;
        }
        if (this.n == null) {
            this.n = (KeyboardId) this.r.i(e, KeyboardId.class);
        }
        this.n.setKbMode(2);
    }

    public void A() {
        this.d.s(this.f222b);
        this.t.g(this.f222b);
        this.u.k(this.f222b);
        this.E.x(this.f222b);
        this.z.g(this.f222b);
        M();
    }

    public void B() {
        this.E.G();
        this.w.onShiftModeChange(this.E.getShiftMode());
    }

    public View D() {
        if (this.C != null) {
            this.e.f();
            this.z.h();
        }
        InputView inputView = (InputView) LayoutInflater.from(this.D).inflate(R.layout.input_view, (ViewGroup) null);
        this.C = inputView;
        View findViewById = inputView.findViewById(R.id.input_area);
        this.v = findViewById;
        KeyboardView keyboardView = (KeyboardView) findViewById.findViewById(R.id.input_keyboard);
        this.E = keyboardView;
        keyboardView.setOnKeyboardActionListener(this.c);
        CandidateView candidateView = (CandidateView) this.v.findViewById(R.id.candidate);
        this.d = candidateView;
        candidateView.setOnCandidateActionListener(this.c);
        this.e = new com.sinovoice.hcicloudinputvehicle.ui.c(this.v, this.c);
        this.z = new com.sinovoice.hcicloudinputvehicle.ui.widget.a(this.v);
        SymbolView symbolView = (SymbolView) this.C.findViewById(R.id.symbol);
        this.t = symbolView;
        symbolView.setOnSymbolActionListener(this.c);
        this.u = (MoreCandidateView) this.C.findViewById(R.id.candidate_more);
        y();
        this.s = com.sinovoice.hcicloudinputvehicle.tools.e.a(this.D);
        this.r = new b.a.a.e();
        z();
        this.B = true;
        return this.C;
    }

    public void E() {
        KeyboardId keyboardId = this.n;
        if (keyboardId != null) {
            this.s.h("last_keyboard_id", this.r.r(keyboardId));
            this.n = null;
        }
    }

    public void F() {
        this.E.O(false);
        this.u.setVisibility(8);
        this.e.b();
        this.z.f();
    }

    public void G() {
        h();
    }

    public void H() {
        if (this.l.getLayoutMode() == 2) {
            this.e.e();
        }
    }

    public void L(List<String> list) {
        this.d.setAssociateData(list);
        this.E.setEnterActionMode(this.y);
    }

    public void N(List<String> list) {
        this.d.setCandidateData(list);
        this.u.setCandidateData(list);
        if (list != null && list.size() > 0) {
            this.E.setEnterActionMode(8);
        } else {
            this.E.setEnterActionMode(this.y);
        }
    }

    public void Q(boolean z) {
        this.E.O(z);
        this.w.onShiftModeChange(this.E.getShiftMode());
    }

    public void R(int i, int i2, boolean z) {
        this.q = i;
        this.y = i2;
        KeyboardId l = l(i);
        this.l = l;
        this.x = true;
        V(l, i2);
    }

    public void S() {
        if (this.l.getLayoutMode() == 1 || this.l.getLayoutMode() == 2) {
            this.e.b();
        }
        this.u.m(this.c);
        this.u.setCandidateData(this.d.getmData());
    }

    public void W() {
        U(this.h);
        KeyboardId keyboardId = this.h;
        this.n = keyboardId;
        this.o = keyboardId;
    }

    public void X() {
        U(this.f);
    }

    public void Y() {
        U(this.i);
        this.c.upperCheck();
        this.w.onShiftModeChange(this.E.getShiftMode());
        this.n = this.i;
        I(this.o);
    }

    public void Z() {
        this.E.O(false);
        U(this.g);
    }

    public void a0() {
        b0();
    }

    public void b0() {
        T();
        this.l = this.j;
        a();
        this.n = this.j;
    }

    public void c0() {
        KeyboardId keyboardId = this.o;
        if (keyboardId != null) {
            U(keyboardId);
            this.n = this.o;
        }
    }

    public void d() {
        if (this.l.getInputMode() == 3) {
            this.l.setInputMode(1);
            this.w.onInputModeChange(1);
            this.w.onShiftModeChange(this.E.getShiftMode());
            return;
        }
        this.l.setInputMode(3);
        this.w.onInputModeChange(3);
    }

    public void e() {
        this.l.setInputMode(2);
        if (this.l.getLayoutMode() == 1) {
            this.l.setKbName("win_handwrite_cn");
        } else {
            this.l.setKbName("ful_handwrite_cn");
            this.j.setKbName("win_handwrite_cn");
        }
        this.p.clear();
        U(this.l);
    }

    public void e0() {
        this.e.b();
        if (this.l.getInputMode() != 1 && this.l.getInputMode() != 20 && !this.l.getKbName().equalsIgnoreCase("num_qwerty_en") && !this.l.getKbName().equalsIgnoreCase("en_qwerty_psw")) {
            SymbolView symbolView = this.t;
            symbolView.m(symbolView, this);
            return;
        }
        SymbolView symbolView2 = this.t;
        symbolView2.l(symbolView2, this);
    }

    public void f() {
        this.l.setInputMode(20);
        if (this.l.getLayoutMode() == 1) {
            this.l.setKbName("win_handwrite_en");
        } else {
            this.l.setKbName("ful_handwrite_en");
            this.j.setKbName("win_handwrite_en");
        }
        this.p.clear();
        U(this.l);
    }

    public void f0() {
        U(this.m);
    }

    public void g() {
        MoreCandidateView moreCandidateView = this.u;
        if (moreCandidateView == null || !moreCandidateView.isShown()) {
            return;
        }
        p();
        try {
            MoreCandidateView moreCandidateView2 = this.u;
            if (moreCandidateView2 != null) {
                moreCandidateView2.i();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void g0() {
    }

    public void h0() {
        KeyboardView keyboardView = this.E;
        keyboardView.O(!keyboardView.F());
        this.w.onShiftModeChange(this.E.getShiftMode());
    }

    public void i() {
    }

    public void i0(String str) {
        this.z.i(str);
    }

    public void j0(String str, String str2) {
        this.z.j(str, str2);
    }

    public View m() {
        return this.v;
    }

    public View n() {
        MoreCandidateView moreCandidateView = this.u;
        if (moreCandidateView != null && moreCandidateView.isShown()) {
            return this.u;
        }
        return this.v;
    }

    public void o() {
        if (this.H) {
            V(this.k, this.y);
        } else {
            d0();
        }
    }

    public void p() {
        b(this.l.getLayoutMode());
    }

    public void q() {
        MoreCandidateView moreCandidateView = this.u;
        if (moreCandidateView != null) {
            moreCandidateView.j();
        }
    }

    public void setKeyboardModeListener(OnKeyboardModeListener onKeyboardModeListener) {
        this.w = onKeyboardModeListener;
    }

    public boolean t() {
        return this.E.E();
    }

    public boolean u() {
        return this.l.getKbName().equalsIgnoreCase("en_qwerty") && !this.E.E();
    }

    public boolean v() {
        return this.E.F();
    }

    public boolean w() {
        return false;
    }

    public boolean x() {
        MoreCandidateView moreCandidateView = this.u;
        if (moreCandidateView != null) {
            return moreCandidateView.isShown();
        }
        return false;
    }
}
