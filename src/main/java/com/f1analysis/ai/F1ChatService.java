package com.f1analysis.ai;

import com.f1analysis.service.F1DataService;
import org.springframework.stereotype.Service;

/**
 * AI Chat service for natural language F1 questions.
 * 
 * Uses Spring AI to communicate with LLMs (OpenAI/Claude).
 * 
 * NOTE: Enable Spring AI dependency in pom.xml when ready to implement.
 */
@Service
public class F1ChatService {

    private final F1DataService f1DataService;
    // TODO: Inject ChatClient when Spring AI is enabled
    // private final ChatClient chatClient;

    public F1ChatService(F1DataService f1DataService) {
        this.f1DataService = f1DataService;
    }

    /**
     * Answer a user's question about F1 using AI.
     * 
     * TODO: Implement this method
     * 1. Get relevant context from database (RAG)
     * 2. Build prompt with system instructions and context
     * 3. Call LLM
     * 4. Return response
     * 
     * Example questions:
     * - "How does Verstappen perform in wet conditions?"
     * - "Compare Hamilton and Alonso's career stats"
     * - "Who has won the most races at Monaco?"
     */
    public String askAboutF1(String userQuestion) {
        // TODO: Implement with Spring AI
        
        // 1. Get relevant context from database
        // String context = f1DataService.getRelevantContext(userQuestion);
        
        // 2. Build the prompt
        // String systemPrompt = """
        //     You are an F1 analyst with access to historical race data.
        //     Answer questions based on the provided data. Be concise but insightful.
        //     If you don't have data to answer, say so.
        //     """;
        
        // 3. Call the AI
        // return chatClient.prompt()
        //     .system(systemPrompt)
        //     .user("Data context: " + context + "\n\nQuestion: " + userQuestion)
        //     .call()
        //     .content();
        
        // Placeholder response
        return "AI chat is not yet implemented. Enable Spring AI in pom.xml and implement this method.";
    }

    /**
     * Get AI analysis of a driver.
     * 
     * TODO: Implement this method
     */
    public String analyzeDriver(String driverId) {
        // TODO: Implement driver analysis
        // 1. Get driver stats from database
        // 2. Ask AI to analyze and provide insights
        return "Driver analysis not yet implemented.";
    }

    /**
     * Get AI comparison of two drivers.
     * 
     * TODO: Implement this method
     */
    public String compareDrivers(String driverId1, String driverId2) {
        // TODO: Implement driver comparison
        return "Driver comparison not yet implemented.";
    }
}

