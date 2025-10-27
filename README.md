This project extends the AI Resume Editor with a Role-Based Optimization feature powered by Google Gemini API.

Users can upload a PDF resume and select a target role (e.g., SDE, PM, HR).

The backend extracts resume text using Apache PDFBox, sends it to Gemini via the Google Generative AI SDK, and returns role-specific improvement suggestions with example rewrites.

It focuses on measurable impact, role alignment, and grammatical refinement.

Note: The Google AI API key is temporarily hardcoded for local testing, as the backend isn’t deployed yet, and will be revoked within a few days for security reasons.