package com.f1analysis.ai;

import com.f1analysis.models.Race;
import com.f1analysis.models.RaceResult;
import com.f1analysis.service.RaceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AI-powered race recap generator.
 * 
 * Generates narrative summaries of race results.
 */
@Service
public class RecapGenerator {

    private final RaceService raceService;
    // TODO: Inject ChatClient when Spring AI is enabled

    public RecapGenerator(RaceService raceService) {
        this.raceService = raceService;
    }

    /**
     * Generate a narrative recap of a race.
     * 
     * TODO: Implement this method
     * 1. Get race results
     * 2. Build prompt with result data
     * 3. Ask AI to generate narrative
     * 
     * Example output:
     * "Max Verstappen dominated the Monaco Grand Prix, leading from lights out 
     * to take his 8th win of the season. A late safety car period shook things 
     * up in the midfield, allowing Lando Norris to capitalize and steal P2 
     * from Charles Leclerc on fresher tires..."
     */
    public String generateRaceRecap(Race race) {
        // TODO: Implement race recap generation
        
        // 1. Get results
        // List<RaceResult> results = raceService.getRaceResults(race);
        
        // 2. Build prompt
        // String prompt = String.format("""
        //     Generate an engaging race recap for the %s Grand Prix.
        //     
        //     Results:
        //     %s
        //     
        //     Write a 2-3 paragraph summary highlighting:
        //     - The winner and how they won
        //     - Any exciting battles or overtakes
        //     - Key incidents or retirements
        //     - Championship implications
        //     """, race.getName(), formatResults(results));
        
        // 3. Call AI
        
        return "Race recap generation not yet implemented. Enable Spring AI in pom.xml.";
    }

    /**
     * Generate a quick headline for a race.
     * 
     * TODO: Implement this method
     */
    public String generateHeadline(Race race) {
        // TODO: Generate a catchy one-line headline
        return "Race headline not yet implemented.";
    }

    /**
     * Analyze championship implications after a race.
     * 
     * TODO: Implement this method
     */
    public String analyzeChampionshipImplications(Race race) {
        // TODO: Calculate points gaps and generate analysis
        return "Championship analysis not yet implemented.";
    }

    // Helper to format results for prompt
    private String formatResults(List<RaceResult> results) {
        // TODO: Format results as string for AI prompt
        StringBuilder sb = new StringBuilder();
        for (RaceResult result : results) {
            sb.append(String.format("P%d: %s (%s) - %d pts\n",
                result.getFinishPosition(),
                result.getDriver().getName(),
                result.getStatus(),
                result.getPoints()));
        }
        return sb.toString();
    }
}

