package com.rulerbug.mycode.view.SlideDelete;

public class SlideDeleteManager {
    public SlideDelete hadOpen ;
    public static SlideDeleteManager SlideDeleteManager = new SlideDeleteManager();

    public static SlideDeleteManager getInstence() {
        return SlideDeleteManager;
    }

    public void regist_a_open(SlideDelete hadOpen) {
        this.hadOpen = hadOpen;
    }

    public void remove_a_open() {
        this.hadOpen = null;
    }

    public void closeCurrentSlideDelete() {
        if (hadOpen != null) {
            hadOpen.close();
//            remove_a_open();
        }
    }

    public boolean hadOpen(SlideDelete sd) {
        if (hadOpen == null) {
            return true;
        } else {
            return hadOpen == sd;
        }
    }

}
