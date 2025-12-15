package com.f1analysis.views;

import com.f1analysis.ai.F1ChatService;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * AI Chat view - "Ask the Paddock"
 * 
 * Natural language interface for F1 questions.
 */
@Route(value = "chat", layout = MainLayout.class)
@PageTitle("Ask the Paddock | F1 Predictions")
public class ChatView extends VerticalLayout {

    private final F1ChatService chatService;
    
    private final TextArea chatHistory = new TextArea();
    private final TextField userInput = new TextField();

    public ChatView(F1ChatService chatService) {
        this.chatService = chatService;

        addClassName("chat-view");
        setSizeFull();
        setPadding(true);

        add(
            new H2("🎤 Ask the Paddock"),
            new Paragraph("Ask any question about F1 - drivers, teams, history, stats!")
        );

        setupChatArea();
        setupInputArea();
        addSampleQuestions();
    }

    private void setupChatArea() {
        chatHistory.setWidthFull();
        chatHistory.setHeight("400px");
        chatHistory.setReadOnly(true);
        chatHistory.setPlaceholder("Chat history will appear here...");
        
        add(chatHistory);
    }

    private void setupInputArea() {
        userInput.setPlaceholder("Ask a question about F1...");
        userInput.setWidthFull();
        userInput.addKeyPressListener(Key.ENTER, e -> sendMessage());

        Button sendButton = new Button("Ask", e -> sendMessage());
        
        HorizontalLayout inputLayout = new HorizontalLayout(userInput, sendButton);
        inputLayout.setWidthFull();
        inputLayout.setFlexGrow(1, userInput);
        
        add(inputLayout);
    }

    private void addSampleQuestions() {
        add(new Paragraph("Try asking:"));
        
        HorizontalLayout suggestions = new HorizontalLayout();
        
        String[] samples = {
            "How does Verstappen perform in wet races?",
            "Compare Hamilton and Alonso",
            "Who has won the most at Monaco?",
            "What's Norris's recent form?"
        };
        
        for (String question : samples) {
            Button btn = new Button(question, e -> {
                userInput.setValue(question);
                sendMessage();
            });
            btn.getStyle().set("font-size", "12px");
            suggestions.add(btn);
        }
        
        add(suggestions);
    }

    /**
     * Send message to AI and display response.
     */
    private void sendMessage() {
        String question = userInput.getValue().trim();
        if (question.isEmpty()) return;

        // Add user message to chat
        appendToChat("You: " + question);
        userInput.clear();

        // Get AI response
        // TODO: Make this async to avoid blocking UI
        String response = chatService.askAboutF1(question);
        
        // Add AI response to chat
        appendToChat("AI: " + response);
    }

    private void appendToChat(String message) {
        String current = chatHistory.getValue();
        if (!current.isEmpty()) {
            current += "\n\n";
        }
        chatHistory.setValue(current + message);
        
        // Scroll to bottom (Vaadin handles this automatically for TextArea)
    }
}

