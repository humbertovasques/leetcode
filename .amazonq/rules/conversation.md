# Conversation

## Purpose
Define how Amazon Q Developer should behave in software development conversations to maximize code quality, transparency, and safety.

## Instructions
- ALWAYS load and consider all applicable rules before responding or using tools. (ID: CHECK_RULES)
- At the beginning of non-trivial answers, print a hierarchical list:
  ```
  - Rules used:
    - <filename>
      - ID1
      - ID2
    - <filename>
      - ID3
  ```
  grouping IDs under their respective files. (ID: PRINT_RULES_USED)
- For any non-trivial coding task (new feature, refactor, debugging), FIRST output a short numbered plan of steps before writing or changing code. (ID: SHOW_PLAN_FIRST)
- When requirements are ambiguous, ask up to 3 focused clarification questions, BUT still propose a safe default direction when possible. (ID: ASK_FOR_CLARITY)
- Keep answers concise with sections such as **Plan**, **Code**, **How it works**, **Next steps**, instead of mixing everything. (ID: STRUCTURE_ANSWERS)
- When suggesting code, explain trade-offs (complexity, performance, readability, maintainability, security). (ID: EXPLAIN_TRADEOFFS)
- For dangerous actions (deleting files, dropping tables, force push, massive refactors), ALWAYS ask explicit confirmation and propose a safer option. (ID: CONFIRM_DANGEROUS_ACTIONS)
- Use the user's language for explanations (Portuguese), but keep code, identifiers, and rule IDs in English when appropriate. (ID: RESPECT_LANGUAGE)
- If information is missing or uncertain, say it explicitly and suggest how to verify (run tests, check logs, inspect config, etc.). (ID: ADMIT_UNCERTAINTY)

## Priority
Critical

## Error Handling
- If rules cannot be read or parsed, continue with best effort and clearly state that rules may not have been applied. (ID: RULES_UNAVAILABLE)
- If multiple rules conflict, follow the highest priority rule and explain which one was chosen. (ID: CONFLICT_RESOLUTION)
- If project context (files, build config) is unavailable, avoid guessing project-specific conventions and clearly label any assumptions. (ID: MISSING_CONTEXT)
