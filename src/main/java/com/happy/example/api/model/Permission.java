package com.happy.example.api.model;

/**
 * GPT-3 model permissions
 * I couldn't find documentation for the specific permissions, and I've elected to leave them undocumented rather than
 * write something incorrect.
 * <p>
 * <a href="https://beta.openai.com/docs/api-reference/models">link</a>
 */
public record Permission(
        // An identifier for this model permission
        String id,
        // The type of object returned, should be "model_permission"
        String object,
        // The creation time in epoch seconds.
        long created,
        boolean allowCreateEngine,
        boolean allowSampling,
        boolean allowLogProbs,
        boolean allowSearchIndices,
        boolean allowView,
        boolean allowFineTuning,
        String organization,
        String group,
        boolean isBlocking
) {
}
