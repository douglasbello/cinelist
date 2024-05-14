package factories.impl;

import buttons.Button;
import buttons.impl.MacOSButton;
import checkboxes.CheckBox;
import checkboxes.impl.MacOSCheckBox;
import factories.GUIFactory;

public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacOSCheckBox();
    }
}