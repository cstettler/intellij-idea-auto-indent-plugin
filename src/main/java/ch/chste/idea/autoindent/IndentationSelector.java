package ch.chste.idea.autoindent;

import ch.chste.idea.autoindent.ui.IndentationSelectorWidget;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.WindowManager;
import org.jetbrains.annotations.NotNull;

/**
 * Project component for installing editor-specific indentation selector.
 *
 * @author Christian Stettler
 */
public class IndentationSelector implements ProjectComponent {

    private Project project;

    public IndentationSelector(Project project) {
        this.project = project;
    }

    public void initComponent() {
    }

    public void disposeComponent() {
    }

    @NotNull
    public String getComponentName() {
        return "IndentationSelector";
    }

    public void projectOpened() {
        StatusBar statusBar = WindowManager.getInstance().getStatusBar(project);
        if (statusBar != null) {
            IndentationSelectorWidget indentationSelectorWidget = new IndentationSelectorWidget(project);
            statusBar.addWidget(indentationSelectorWidget, "after Position");
        }
    }

    public void projectClosed() {
    }

}
