package com.happy.example.api.model;

import java.util.List;

/**
 * GPT-3 model details.
 * <p>
 * <a href="https://beta.openai.com/docs/api-reference/models">link</a>
 */
public record Model(
        // An identifier for this model, used to specify the model when making completions, etc
        String id,
        // The type of object returned, should be "model"
        String object,
        // The owner of the GPT-3 model, typically "openai"
        String ownedBy,
        // List of permissions for this model
        List<Permission> permission,
        // The root model that this and its parent (if applicable) are based on
        String root,
        // The parent model that this is based on
        String parent) {


}