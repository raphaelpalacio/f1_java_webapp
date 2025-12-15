package com.f1analysis.views;

import com.f1analysis.service.UserService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

/**
 * Registration view for new users.
 */
@Route("register")
@PageTitle("Register | F1 Predictions")
public class RegisterView extends VerticalLayout {

    private final UserService userService;
    
    private final TextField displayName = new TextField("Display Name");
    private final EmailField email = new EmailField("Email");
    private final PasswordField password = new PasswordField("Password");
    private final PasswordField confirmPassword = new PasswordField("Confirm Password");

    public RegisterView(UserService userService) {
        this.userService = userService;
        
        addClassName("register-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        // Form fields
        displayName.setWidthFull();
        displayName.setMaxWidth("300px");
        
        email.setWidthFull();
        email.setMaxWidth("300px");
        
        password.setWidthFull();
        password.setMaxWidth("300px");
        
        confirmPassword.setWidthFull();
        confirmPassword.setMaxWidth("300px");

        Button registerButton = new Button("Create Account", e -> handleRegister());
        registerButton.setWidthFull();
        registerButton.setMaxWidth("300px");

        // Layout
        VerticalLayout formLayout = new VerticalLayout();
        formLayout.setWidth("300px");
        formLayout.setAlignItems(Alignment.CENTER);
        
        formLayout.add(
            new H1("🏎️ Join F1 Predictions"),
            new Paragraph("Create an account to start predicting"),
            displayName,
            email,
            password,
            confirmPassword,
            registerButton,
            new RouterLink("Already have an account? Login", LoginView.class)
        );

        add(formLayout);
    }

    /**
     * Handle registration form submission.
     * 
     * TODO: Add more validation
     */
    private void handleRegister() {
        // Validate inputs
        if (displayName.getValue().isEmpty() || email.getValue().isEmpty() 
            || password.getValue().isEmpty()) {
            Notification.show("Please fill in all fields", 3000, Notification.Position.BOTTOM_CENTER);
            return;
        }

        if (!password.getValue().equals(confirmPassword.getValue())) {
            Notification.show("Passwords don't match", 3000, Notification.Position.BOTTOM_CENTER);
            return;
        }

        if (password.getValue().length() < 8) {
            Notification.show("Password must be at least 8 characters", 
                3000, Notification.Position.BOTTOM_CENTER);
            return;
        }

        // TODO: Try to register
        try {
            userService.registerUser(
                email.getValue(),
                password.getValue(),
                displayName.getValue()
            );
            Notification.show("Account created! Please login.", 
                3000, Notification.Position.BOTTOM_CENTER);
            // TODO: Redirect to login
            getUI().ifPresent(ui -> ui.navigate(LoginView.class));
        } catch (Exception e) {
            Notification.show("Registration failed: " + e.getMessage(), 
                3000, Notification.Position.BOTTOM_CENTER);
        }
    }
}

