package buttons.impl;

import buttons.Button;

public class MacOSButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have created a MacOSButton!");
    }
}