# Project Context & Architecture

## Purpose
Ensure generated or modified code aligns with the existing project architecture, technologies, and conventions (Java 8/17, Spring Boot, Oracle/WebLogic, React).

## Instructions
- BEFORE proposing structures or frameworks, scan build and config files (pom.xml, build.gradle, application*.yml, package.json) to infer stack, versions, and patterns. (ID: ANALYZE_PROJECT)
- Respect the Java version defined in the build (source/target) and DO NOT use language features not supported by that version. (ID: RESPECT_JAVA_VERSION)
- Follow existing package and folder structure (e.g. `controller`, `service`, `repository`, `dto`, `mapper`, `config`, `domain`). (ID: USE_EXISTING_STRUCTURE)
- Extend existing patterns (DTOs, mappers, service interfaces, exception handlers) instead of creating new patterns without clear motivation. (ID: EXTEND_PATTERNS)
- When introducing new dependencies, check if a similar one already exists; avoid duplicates (e.g. multiple HTTP clients, multiple JSON libraries). (ID: AVOID_DUP_LIBS)
- Configuration MUST use config files or environment variables, NEVER hard-code secrets, passwords, or tokens in code or examples. (ID: CONFIG_AND_SECRETS)
- Always consider cross-cutting concerns: validation, error handling, logging, security, observability (metrics/traces), and mention how the proposal fits them. (ID: CROSS_CUTTING_CONCERNS)
- Prefer small, incremental changes that fit into the existing architecture over large rewrites, unless explicitly requested. (ID: INCREMENTAL_CHANGES)

## Priority
High

## Error Handling
- If the project structure is inconsistent, follow the most common recent pattern and mention the inconsistency. (ID: INCONSISTENT_STRUCTURE)
- If build files are inaccessible, use widely adopted defaults but clearly mark them as assumptions. (ID: NO_BUILD_FILES)
- If a required config file does not exist, suggest a minimal example file and specify where it should live. (ID: SUGGEST_CONFIG_SCAFFOLD)
