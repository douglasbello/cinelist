package factories.impl;

import buttons.Button;
import buttons.impl.WindowsButton;
import checkboxes.CheckBox;
import checkboxes.impl.WindowsCheckBox;
import factories.GUIFactory;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}