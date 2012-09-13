package ch.chste.idea.autoindent.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

/**
 * Configures default indentation for current file in editor (based on project-specific code style settings).
 *
 * @author Christian Stettler
 */
@SuppressWarnings("ComponentNotRegistered")
public class SetDefaultIndentationAction extends AnAction {

    public SetDefaultIndentationAction(String text) {
        super(text);
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
    }

}
