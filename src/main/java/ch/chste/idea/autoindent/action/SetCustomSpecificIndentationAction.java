package ch.chste.idea.autoindent.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

/**
 * Configures custom indentation for current file in editor.
 *
 * @author Christian Stettler
 */
@SuppressWarnings("ComponentNotRegistered")
public class SetCustomSpecificIndentationAction extends AnAction {

    public SetCustomSpecificIndentationAction(String text) {
        super(text);
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
    }

}
