package com.contactmanager;

import com.contactmanager.view.MainFrame;

/**
 * @author vaisakhvm
 */
public class FrontendApp {
    public static void main(String[] args) {
        String appName = BackendApp.getAppName();
        System.out.println(appName);

        MainFrame frame = new MainFrame();
    }
}
