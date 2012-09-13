package ch.chste.idea.autoindent.ui;

import ch.chste.idea.autoindent.action.SetCustomSpecificIndentationAction;
import ch.chste.idea.autoindent.action.SetDefaultIndentationAction;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.actionSystem.impl.SimpleDataContext;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.ListPopup;
import com.intellij.openapi.util.Condition;
import com.intellij.openapi.wm.StatusBarWidget;
import com.intellij.openapi.wm.impl.status.EditorBasedWidget;
import com.intellij.ui.popup.PopupFactoryImpl;
import com.intellij.util.Consumer;
import org.jetbrains.annotations.NotNull;

import java.awt.event.MouseEvent;

/**
 * Widget for selecting editor-specific or default indentation settings.
 *
 * @author Christian Stettler
 */
public class IndentationSelectorWidget extends EditorBasedWidget implements StatusBarWidget.MultipleTextValuesPresentation {

    public IndentationSelectorWidget(@NotNull Project project) {
        super(project);
    }

    @NotNull
    @Override
    public String ID() {
        return "IndentationSelector";
    }

    @Override
    public WidgetPresentation getPresentation(@NotNull PlatformType platformType) {
        return this;
    }

    @Override
    public ListPopup getPopupStep() {
        DefaultActionGroup actionGroup = new DefaultActionGroup(null, false);
        actionGroup.add(new SetCustomSpecificIndentationAction("2 Spaces"));
        actionGroup.add(new SetCustomSpecificIndentationAction("4 Spaces"));
        actionGroup.add(new SetDefaultIndentationAction("Project Default"));

        Condition<AnAction> preselectActionCondition = new Condition<AnAction>() {
            @Override
            public boolean value(AnAction anAction) {
                return false;
            }
        };

        return new PopupFactoryImpl.ActionGroupPopup("Indentation Settings", actionGroup, SimpleDataContext.getProjectContext(getProject()), false, false, false, true, null, -1, preselectActionCondition, null);
    }

    @Override
    public String getSelectedValue() {
        return getMaxValue();
    }

    @NotNull
    @Override
    public String getMaxValue() {
        return "10 Spaces (Default)";
    }

    @Override
    public String getTooltipText() {
        return "Indentation";
    }

    @Override
    public Consumer<MouseEvent> getClickConsumer() {
        return new Consumer<MouseEvent>() {
            @Override
            public void consume(MouseEvent mouseEvent) {
                System.out.println("mouseEvent = " + mouseEvent);
            }
        };
    }

}
