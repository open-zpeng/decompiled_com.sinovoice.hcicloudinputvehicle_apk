package com.sinovoice.hcicloudinputvehicle.ui;
/* loaded from: classes.dex */
public interface OnKeyboardActionListener {
    public static final OnKeyboardActionListener EMPTY_LISTENER = new a();

    /* loaded from: classes.dex */
    public static class a implements OnKeyboardActionListener {
        @Override // com.sinovoice.hcicloudinputvehicle.ui.OnKeyboardActionListener
        public void onKey(int i, int[] iArr) {
        }

        @Override // com.sinovoice.hcicloudinputvehicle.ui.OnKeyboardActionListener
        public boolean onLongPress(CharSequence charSequence) {
            return false;
        }

        @Override // com.sinovoice.hcicloudinputvehicle.ui.OnKeyboardActionListener
        public void onPress(int i) {
        }

        @Override // com.sinovoice.hcicloudinputvehicle.ui.OnKeyboardActionListener
        public void onRelease(int i) {
        }

        @Override // com.sinovoice.hcicloudinputvehicle.ui.OnKeyboardActionListener
        public void onText(CharSequence charSequence) {
        }

        @Override // com.sinovoice.hcicloudinputvehicle.ui.OnKeyboardActionListener
        public void swipeDown() {
        }

        @Override // com.sinovoice.hcicloudinputvehicle.ui.OnKeyboardActionListener
        public void swipeLeft() {
        }

        @Override // com.sinovoice.hcicloudinputvehicle.ui.OnKeyboardActionListener
        public void swipeRight() {
        }

        @Override // com.sinovoice.hcicloudinputvehicle.ui.OnKeyboardActionListener
        public void swipeUp() {
        }
    }

    void onKey(int i, int[] iArr);

    boolean onLongPress(CharSequence charSequence);

    void onPress(int i);

    void onRelease(int i);

    void onText(CharSequence charSequence);

    void swipeDown();

    void swipeLeft();

    void swipeRight();

    void swipeUp();
}
