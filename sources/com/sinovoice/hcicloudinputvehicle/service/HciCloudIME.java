package com.sinovoice.hcicloudinputvehicle.service;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.inputmethodservice.InputMethodService;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Toast;
import com.sinovoice.hcicloudinputvehicle.taskscheduler.TaskSchedule;
import com.sinovoice.hcicloudinputvehicle.tools.ViewOutlineProviderCompatUtils;
import com.sinovoice.hcicloudinputvehicle.ui.CandidateView.OnCandidateActionListener;
import com.sinovoice.hcicloudinputvehicle.ui.FunctionKeyCode;
import com.sinovoice.hcicloudinputvehicle.ui.OnKeyboardActionListener;
import com.sinovoice.hcicloudinputvehicle.ui.OnStrokeActionListener;
import com.sinovoice.hcicloudinputvehicle.ui.OnSyllableActionListener;
import com.sinovoice.hcicloudinputvehicle.ui.OnSymbolActionListener;
import com.sinovoice.hcicloudsdk.common.HciErrorCode;
import java.util.List;
/* loaded from: classes.dex */
public class HciCloudIME extends InputMethodService implements HciCloudInputConnection, OnKeyboardActionListener, OnCandidateActionListener, OnStrokeActionListener, OnSymbolActionListener, OnKeyboardModeListener, OnSyllableActionListener {

    /* renamed from: a  reason: collision with root package name */
    private static final String f184a = HciCloudIME.class.getCanonicalName();
    private InputLogicControlInterface d;
    private View g;
    private ViewOutlineProviderCompatUtils.InsetsUpdater h;
    long k;
    private boolean e = false;
    private Handler f = new a(Looper.getMainLooper());
    private int i = 0;
    private int j = 0;
    private boolean l = false;

    /* renamed from: b  reason: collision with root package name */
    private final f f185b = f.b();
    private e c = e.j();

    /* loaded from: classes.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 100 || i == 101 || i == 400 || i == 401) {
                return;
            }
            if (i == 456) {
                com.sinovoice.hcicloudinputvehicle.tools.g.a(HciCloudIME.this, message.obj.toString());
            } else if (i == 12121) {
                HciCloudIME.this.e = ((Boolean) message.obj).booleanValue();
            } else if (i == 900) {
                HciCloudIME.this.c.Q(false);
            } else if (i != 901) {
                switch (i) {
                    case 200:
                    case HciErrorCode.HCI_ERR_ASR_ALREADY_INIT /* 201 */:
                    case HciErrorCode.HCI_ERR_ASR_CONFIRM_NO_TASK /* 202 */:
                    case HciErrorCode.HCI_ERR_ASR_PARAM_CHECK_FLAG_INVALID /* 203 */:
                        return;
                    default:
                        switch (i) {
                            case HciErrorCode.HCI_ERR_HWR_ALREADY_INIT /* 301 */:
                                b.b.a.b.a.a(HciCloudIME.f184a, "UPDATE_CANDAIDATE");
                                HciCloudIME.this.c.N((List) message.obj);
                                return;
                            case HciErrorCode.HCI_ERR_HWR_CONFIRM_NO_TASK /* 302 */:
                                b.b.a.b.a.a(HciCloudIME.f184a, "UPDATE_ASSOCIATE");
                                HciCloudIME.this.c.L((List) message.obj);
                                return;
                            case HciErrorCode.HCI_ERR_HWR_ENGINE_INIT_FAILED /* 303 */:
                                b.b.a.b.a.a(HciCloudIME.f184a, "UPDATE_COMPOSING");
                                String str = (String) message.obj;
                                Bundle data = message.getData();
                                String str2 = data != null ? (String) data.get(str) : null;
                                if (str2 == null || str2.isEmpty()) {
                                    HciCloudIME.this.c.i0(str);
                                    return;
                                } else {
                                    HciCloudIME.this.c.j0(str, str2);
                                    return;
                                }
                            default:
                                Toast.makeText(HciCloudIME.this, "初始化失败（默认）", 0).show();
                                return;
                        }
                }
            } else {
                HciCloudIME.this.c.Q(true);
            }
        }
    }

    private void d() {
        Log.d(f184a, "checkAndFinishComposingInput: ");
        com.sinovoice.hcicloudinputvehicle.input.d currentInput = this.d.getCurrentInput();
        if (currentInput == null || TextUtils.isEmpty(currentInput.e())) {
            return;
        }
        finishComposingText();
        this.d.clear();
    }

    private void e(EditorInfo editorInfo) {
        int i = editorInfo.inputType;
        int i2 = i & 15;
        int i3 = 4;
        if (i2 != 1) {
            if (i2 == 2 || i2 == 3 || i2 == 4) {
                i3 = 3;
            }
            i3 = 1;
        } else {
            int i4 = i & 4080;
            if (i4 != 16) {
                if (i4 != 32) {
                    if (i4 == 128 || i4 == 144) {
                        i3 = 7;
                    }
                    i3 = 1;
                } else {
                    i3 = 5;
                }
            }
        }
        int i5 = editorInfo.imeOptions & 255;
        if ((i & 16773120) == 131072) {
            i5 = 0;
        }
        this.c.R(i3, i5, false);
    }

    private boolean f(String str) {
        return str.length() == 2 && !":)+……+:(+:p+:o——m³".contains(str);
    }

    private void g() {
        this.f185b.d(this);
    }

    private boolean h(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        if (charSequence.length() <= 0 || charSequence.charAt(charSequence.length() - 1) != '\n') {
            return (charSequence.length() >= 2 && charSequence.subSequence(1, charSequence.length()).equals(". ")) || charSequence.equals("   ") || charSequence.equals(".  ");
        }
        return true;
    }

    private void j() {
        Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
        intent.addFlags(268435456);
        getApplicationContext().startActivity(intent);
    }

    private void k() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            String str = f184a;
            Log.d(str, "当前输入法版本号:versionCode:" + packageInfo.versionCode + "------versionName:" + packageInfo.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(f184a, "printVersionInfo: 获取输入法版本号失败");
            e.printStackTrace();
        }
    }

    private void l() {
        Window window = getWindow().getWindow();
        com.sinovoice.hcicloudinputvehicle.tools.h.c(window, -1);
        int i = isFullscreenMode() ? -2 : -1;
        View findViewById = window.findViewById(16908318);
        if (this.g != null) {
            com.sinovoice.hcicloudinputvehicle.tools.h.b(findViewById, i);
            com.sinovoice.hcicloudinputvehicle.tools.h.a(findViewById, 80);
            com.sinovoice.hcicloudinputvehicle.tools.h.b(this.g, i);
        }
        String str = f184a;
        Log.d(str, "updateSoftInputWindowLayoutParameters: " + i);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.HciCloudInputConnection
    public void commitComposing(String str) {
        String str2 = f184a;
        b.b.a.b.a.c(str2, "commitComposingStr: [" + str + "]");
        InputConnection currentInputConnection = getCurrentInputConnection();
        if (currentInputConnection != null) {
            currentInputConnection.setComposingText(str, 1);
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.HciCloudInputConnection
    public void commitComposingStr(String str) {
        String str2 = f184a;
        b.b.a.b.a.c(str2, "commitComposingStr: [" + str + "]");
        Message obtainMessage = this.f.obtainMessage(HciErrorCode.HCI_ERR_HWR_ENGINE_INIT_FAILED);
        obtainMessage.obj = str;
        obtainMessage.sendToTarget();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.HciCloudInputConnection
    public void commitString(String str, int i) {
        String str2 = f184a;
        Log.d(str2, "commitString: [" + str + "]");
        InputConnection currentInputConnection = getCurrentInputConnection();
        if (currentInputConnection == null || str == null || str.length() <= 0) {
            return;
        }
        currentInputConnection.commitText(str, i);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.HciCloudInputConnection
    public void commitSymbol(String str, int i) {
        String str2 = f184a;
        b.b.a.b.a.c(str2, "commitString: [" + str + "]");
        InputConnection currentInputConnection = getCurrentInputConnection();
        if (currentInputConnection == null || str == null) {
            return;
        }
        if (f(str)) {
            currentInputConnection.commitText(str, i);
            i();
            return;
        }
        currentInputConnection.commitText(str, i);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.HciCloudInputConnection
    public void finishComposingText() {
        b.b.a.b.a.c(f184a, "finishComposingText");
        InputConnection currentInputConnection = getCurrentInputConnection();
        if (currentInputConnection != null) {
            currentInputConnection.finishComposingText();
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.HciCloudInputConnection
    public int getComposingLength() {
        return this.j;
    }

    @Override // com.sinovoice.hcicloudinputvehicle.ui.CandidateView.OnCandidateActionListener
    public void getMoreList() {
        this.d.handleNextPage();
    }

    public void i() {
        CharSequence textBeforeCursor;
        InputConnection currentInputConnection = getCurrentInputConnection();
        if (currentInputConnection == null || (textBeforeCursor = currentInputConnection.getTextBeforeCursor(1, 0)) == null || textBeforeCursor.length() != 1) {
            return;
        }
        currentInputConnection.sendKeyEvent(new KeyEvent(0, 21));
        currentInputConnection.sendKeyEvent(new KeyEvent(1, 21));
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.HciCloudInputConnection
    public void keyDownUp(int i) {
        InputConnection currentInputConnection = getCurrentInputConnection();
        if (currentInputConnection != null) {
            if (i == 62) {
                currentInputConnection.commitText(" ", 1);
            } else if (i == 66) {
                sendKeyChar('\n');
            } else {
                currentInputConnection.sendKeyEvent(new KeyEvent(0, i));
                currentInputConnection.sendKeyEvent(new KeyEvent(1, i));
            }
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.ui.CandidateView.OnCandidateActionListener
    public void onBack() {
        this.c.p();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.ui.CandidateView.OnCandidateActionListener
    public void onCandidateSelected(int i) {
        String str = f184a;
        b.b.a.b.a.c(str, "onCandidateSelected() : " + i);
        this.d.handleCandChoosed(i);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.ui.CandidateView.OnCandidateActionListener
    public void onClearIconClick() {
        this.d.clear();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.ui.CandidateView.OnCandidateActionListener
    public void onCloseIconClick() {
        this.c.F();
        requestHideSelf(0);
    }

    @Override // android.inputmethodservice.InputMethodService
    public void onComputeInsets(InputMethodService.Insets insets) {
        View m;
        int height;
        super.onComputeInsets(insets);
        if (this.g == null || (m = this.c.m()) == null) {
            return;
        }
        int height2 = this.g.getHeight();
        if (!this.c.x()) {
            height = m.getHeight();
        } else {
            height = this.c.n().getHeight();
        }
        int i = height2 - height;
        if (m.isShown()) {
            int i2 = this.c.w() ? 0 : i;
            insets.touchableInsets = 3;
            insets.touchableRegion.set(0, i2, m.getWidth(), height2 + 100);
        }
        insets.contentTopInsets = i;
        insets.visibleTopInsets = i;
        this.h.setInsets(insets);
        String str = f184a;
        Log.d(str, "onComputeInsets: outInsets visibleTopInsets" + insets.visibleTopInsets + " contentTopInsets " + insets.contentTopInsets + " touchableInsets " + insets.touchableInsets + " touchableRegion " + insets.touchableRegion);
    }

    @Override // android.inputmethodservice.InputMethodService, android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Log.d(f184a, "onConfigurationChanged restarting: ");
        super.onConfigurationChanged(configuration);
    }

    @Override // android.inputmethodservice.InputMethodService, android.app.Service
    public void onCreate() {
        b.b.a.b.a.d(b.b.a.b.b.c().b(4).a());
        b.b.a.b.a.a(f184a, "onCreate()");
        k();
        f.c(this);
        TaskSchedule.init();
        e.r(this);
        g();
        com.sinovoice.hcicloudinputvehicle.service.a.b(this);
        InputLogicControlInterface a2 = c.a(this, this.f, this);
        this.d = a2;
        a2.init();
        this.d.startSession();
        super.onCreate();
        com.sinovoice.hcicloudinputvehicle.tools.f.b();
    }

    @Override // android.inputmethodservice.InputMethodService
    public View onCreateInputView() {
        Log.d(f184a, "onCreateInputView()");
        return this.c.D();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.ui.OnSymbolActionListener
    public void onDelete() {
        keyDownUp(67);
    }

    @Override // android.inputmethodservice.InputMethodService, android.inputmethodservice.AbstractInputMethodService, android.app.Service
    public void onDestroy() {
        b.b.a.b.a.a(f184a, "onDestroy()");
        this.c.E();
        super.onDestroy();
        this.d.stopSession();
        this.d.release();
        TaskSchedule.finish();
    }

    @Override // android.inputmethodservice.InputMethodService
    public boolean onEvaluateFullscreenMode() {
        return false;
    }

    @Override // android.inputmethodservice.InputMethodService
    public void onFinishInput() {
        Log.d(f184a, "onFinishInput()");
        super.onFinishInput();
    }

    @Override // android.inputmethodservice.InputMethodService
    public void onFinishInputView(boolean z) {
        finishComposingText();
        this.c.F();
        this.d.clear();
        Log.d(f184a, "onFinishInputView()");
        super.onFinishInputView(z);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.ui.CandidateView.OnCandidateActionListener
    public void onHWIconClick() {
        this.c.b0();
    }

    @Override // android.inputmethodservice.InputMethodService
    public void onInitializeInterface() {
        super.onInitializeInterface();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.OnKeyboardModeListener
    public void onInputModeChange(int i) {
        Log.d(f184a, "onInputModeChange: ");
        finishComposingText();
        this.d.clear();
        this.d.onInputModeChange(i);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.ui.CandidateView.OnCandidateActionListener
    public void onKBIconClick() {
        this.c.W();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.ui.OnKeyboardActionListener
    public void onKey(int i, int[] iArr) {
        String str = f184a;
        b.b.a.b.a.c(str, "onKey() : ");
        if (i == -100) {
            Log.d(str, "onKey: KEY_SHIFT_LOCK");
            this.c.B();
        } else if (i == -61) {
            this.d.finishInput();
            this.c.f0();
        } else if (i == -60) {
            this.d.finishInput();
            this.c.Z();
        } else if (i == -14) {
            this.c.f();
        } else if (i != -13) {
            switch (i) {
                case FunctionKeyCode.KEY_CLEAR /* -22 */:
                    this.d.clear();
                    return;
                case FunctionKeyCode.KEY_BACK /* -21 */:
                    this.c.o();
                    return;
                case FunctionKeyCode.KEY_AUTO_FILL /* -20 */:
                    this.c.d();
                    return;
                default:
                    switch (i) {
                        case FunctionKeyCode.KEY_VOICE_INPUT /* -11 */:
                            this.d.clear();
                            this.c.g0();
                            return;
                        case FunctionKeyCode.KEY_HWR_WIN /* -10 */:
                            this.c.b0();
                            return;
                        case FunctionKeyCode.KEY_HWR_FULL /* -9 */:
                            this.c.a0();
                            return;
                        case FunctionKeyCode.KEY_CN_QWERTY /* -8 */:
                            this.c.c0();
                            return;
                        case FunctionKeyCode.KEY_EN_QWERTY /* -7 */:
                            this.c.Y();
                            return;
                        case FunctionKeyCode.KEY_NUM_CN /* -6 */:
                            this.d.finishInput();
                            this.c.X();
                            return;
                        case FunctionKeyCode.KEY_SYMBOL /* -5 */:
                            this.d.finishInput();
                            this.c.e0();
                            return;
                        case FunctionKeyCode.KEY_DEL /* -4 */:
                            this.d.handleDelete();
                            return;
                        case -3:
                            this.d.handleSpace();
                            return;
                        case -2:
                            this.d.handleEnter();
                            return;
                        case -1:
                            this.c.h0();
                            return;
                        default:
                            this.d.handleSymbol(i);
                            return;
                    }
            }
        } else {
            this.c.e();
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.ui.OnKeyboardActionListener
    public boolean onLongPress(CharSequence charSequence) {
        Log.d(f184a, "onLongPress: ");
        if (charSequence != null) {
            if (charSequence.toString().equalsIgnoreCase("'")) {
                this.d.handleSymbol("1");
                return true;
            } else if (charSequence.toString().charAt(0) > '9' || charSequence.toString().charAt(0) < '0') {
                return true;
            } else {
                this.d.handleSymbol(charSequence.toString());
                return true;
            }
        }
        return false;
    }

    @Override // com.sinovoice.hcicloudinputvehicle.ui.CandidateView.OnCandidateActionListener
    public void onMoreIconClick() {
        this.c.S();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.ui.OnStrokeActionListener
    public void onPointTouch() {
        b.b.a.b.a.c(f184a, "onPointTouch ");
        this.c.H();
        this.d.clear();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.ui.OnKeyboardActionListener
    public void onPress(int i) {
        if (i != 0) {
            com.sinovoice.hcicloudinputvehicle.service.a.a().d(i);
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.ui.OnKeyboardActionListener
    public void onRelease(int i) {
    }

    @Override // com.sinovoice.hcicloudinputvehicle.ui.CandidateView.OnCandidateActionListener
    public void onSettingIconClick() {
        j();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.OnKeyboardModeListener
    public void onShiftModeChange(int i) {
        this.d.handleShift(i);
    }

    @Override // android.inputmethodservice.InputMethodService
    public boolean onShowInputRequested(int i, boolean z) {
        return super.onShowInputRequested(i, z);
    }

    @Override // android.inputmethodservice.InputMethodService
    public void onStartInput(EditorInfo editorInfo, boolean z) {
        String str = f184a;
        Log.d(str, "onStartInput() restarting: " + z);
        if (z) {
            this.c.g();
        }
        super.onStartInput(editorInfo, z);
    }

    @Override // android.inputmethodservice.InputMethodService
    public void onStartInputView(EditorInfo editorInfo, boolean z) {
        String str = f184a;
        Log.d(str, "onStartInputView()");
        this.k = System.currentTimeMillis();
        int i = this.i + 1;
        this.i = i;
        if (i % 10 == 0) {
            this.d.stopSession();
            this.d.startSession();
        }
        super.onStartInputView(editorInfo, z);
        if (z) {
            this.d.clear();
            upperCheck();
            this.c.q();
            return;
        }
        this.c.G();
        this.c.setKeyboardModeListener(this);
        e(editorInfo);
        upperCheck();
        Log.d(str, "onStartInputView: 花费时间=" + (System.currentTimeMillis() - this.k));
    }

    @Override // com.sinovoice.hcicloudinputvehicle.ui.OnSyllableActionListener
    public void onSyllableSelected(int i) {
        this.d.handleSyllableChosen(i);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.ui.OnSymbolActionListener, com.sinovoice.hcicloudinputvehicle.ui.OnSyllableActionListener
    public void onSymbolSelected(String str) {
        this.d.handleSymbol(str);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.ui.OnKeyboardActionListener
    public void onText(CharSequence charSequence) {
        if (charSequence.equals("……")) {
            this.d.handleSymbol("……");
        } else {
            this.d.query(charSequence);
        }
        if ((!f.b().a().b() && this.c.v() && this.c.u()) || ((this.d.getCurrentInput() instanceof com.sinovoice.hcicloudinputvehicle.input.a) && this.c.v() && !this.c.t())) {
            this.f.obtainMessage(HciErrorCode.HCI_ERR_VPR_NOT_INIT).sendToTarget();
        }
    }

    @Override // android.inputmethodservice.InputMethodService
    public void onUpdateSelection(int i, int i2, int i3, int i4, int i5, int i6) {
        if (f.b().a().b() && this.c.u()) {
            CharSequence textBeforeCursor = getCurrentInputConnection().getTextBeforeCursor(3, 0);
            if (i3 != 0 && !h(textBeforeCursor)) {
                this.c.Q(false);
            } else {
                this.c.Q(true);
            }
        }
        this.j = i6 - i5;
        if (i5 != -1 && i4 != i6) {
            d();
        }
        com.sinovoice.hcicloudinputvehicle.input.d currentInput = this.d.getCurrentInput();
        if (currentInput == null) {
            return;
        }
        if (i4 != i6 && this.j <= currentInput.e().length() && i4 < i2) {
            d();
        }
        super.onUpdateSelection(i, i2, i3, i4, i5, i6);
    }

    @Override // android.inputmethodservice.InputMethodService
    public void onWindowHidden() {
        super.onWindowHidden();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.ui.OnStrokeActionListener
    public void onWriteEnd(short[] sArr) {
        String str = f184a;
        b.b.a.b.a.a(str, "stroke length" + sArr.length);
        this.d.query(sArr);
    }

    @Override // android.inputmethodservice.InputMethodService
    public void setInputView(View view) {
        super.setInputView(view);
        this.g = view;
        this.h = ViewOutlineProviderCompatUtils.a(view);
        l();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.ui.OnKeyboardActionListener
    public void swipeDown() {
    }

    @Override // com.sinovoice.hcicloudinputvehicle.ui.OnKeyboardActionListener
    public void swipeLeft() {
        if (f.b().a().g()) {
            this.c.i();
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.ui.OnKeyboardActionListener
    public void swipeRight() {
        if (f.b().a().g()) {
            this.c.i();
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.ui.OnKeyboardActionListener
    public void swipeUp() {
    }

    @Override // android.inputmethodservice.InputMethodService
    public void updateFullscreenMode() {
        super.updateFullscreenMode();
        l();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.HciCloudInputConnection
    public void upperCheck() {
        InputConnection currentInputConnection;
        if (!f.b().a().b() || !this.c.u() || (currentInputConnection = getCurrentInputConnection()) == null || currentInputConnection.getCursorCapsMode(16384) == 0) {
            return;
        }
        this.f.obtainMessage(HciErrorCode.HCI_ERR_VPR_ALREADY_INIT).sendToTarget();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.HciCloudInputConnection
    public void commitComposingStr(String str, String str2) {
        String str3 = f184a;
        b.b.a.b.a.c(str3, "commitComposingStr: [" + str + "]selectString: " + str2);
        Message obtainMessage = this.f.obtainMessage(HciErrorCode.HCI_ERR_HWR_ENGINE_INIT_FAILED);
        obtainMessage.obj = str;
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
    }
}
