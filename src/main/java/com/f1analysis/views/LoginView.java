package com.f1analysis.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

/**
 * Login view for user authentication.
 * 
 * TODO: Integrate with Spring Security when enabled
 */
@Route("login")
@PageTitle("Login | F1 Predictions")
public class LoginView extends VerticalLayout {

    private final EmailField email = new EmailField("Email");
    private final PasswordField password = new PasswordField("Password");

    public LoginView() {
        addClassName("login-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        // Form
        email.setWidthFull();
        email.setMaxWidth("300px");
        
        password.setWidthFull();
        password.setMaxWidth("300px");

        Button loginButton = new Button("Login", e -> handleLogin());
        loginButton.setWidthFull();
        loginButton.setMaxWidth("300px");

        // Layout
        VerticalLayout formLayout = new VerticalLayout();
        formLayout.setWidth("300px");
        formLayout.setAlignItems(Alignment.CENTER);
        
        formLayout.add(
            new H1("🏎️ F1 Predictions"),
            new Paragraph("Login to make your race predictions"),
            email,
            password,
            loginButton,
            new RouterLink("Don't have an account? Register", RegisterView.class)
        );

        add(formLayout);
    }

    /**
     * Handle login form submission.
     * 
     * TODO: Implement actual authentication
     * 1. Validate inputs
     * 2. Call UserService.authenticateUser()
     * 3. Create session
     * 4. Redirect to dashboard
     */
    private void handleLogin() {
        String emailValue = email.getValue();
        String passwordValue = password.getValue();

        // TODO: Implement actual authentication
        if (emailValue.isEmpty() || passwordValue.isEmpty()) {
            Notification.show("Please fill in all fields", 3000, Notification.Position.BOTTOM_CENTER);
            return;
        }

        // Placeholder - replace with actual auth
        Notification.show("Login not yet implemented. Check UserService.authenticateUser()", 
            3000, Notification.Position.BOTTOM_CENTER);
    }
}

