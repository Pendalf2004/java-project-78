### Hexlet tests and linter status:
[![Actions Status](https://github.com/Pendalf2004/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Pendalf2004/java-project-78/actions)
<hr>

## Validation library
Helps validate data to meet certain requrements. 
Works with text string, numeric input and collections input.
Supports validation of key - value input.

### Text string validation checks (StringSchema class): 
'.requered()' check if value exists and is not empty.
'.minLength(x)' check if value length consist of more than x letters.
'.contains("x")' check if value contains x text string.

### Numeric validation checks: (NumberSchema class)
'.requered()' check if value exists and is not empty.
'.positive()' check if the value is greater than zero.
'.range(x, y)' check if the value is equal or greater than x and is equal or less than y.

### "Key - value" collection validation (MapSchema class)
'.requered()' check if collection is not empty.
'.sizeof(x)' check if collection contains no less than x entries.


### Create a map of requred checks in the form "fiels check name" - validation variable.
'.shape(x)' adds checks collection to validation variable.
<hr>

[![Maintainability](https://api.codeclimate.com/v1/badges/3aec9e2f98202f6c1bfc/maintainability)](https://codeclimate.com/github/Pendalf2004/java-project-78/maintainability) 
[![Test Coverage](https://api.codeclimate.com/v1/badges/3aec9e2f98202f6c1bfc/test_coverage)](https://codeclimate.com/github/Pendalf2004/java-project-78/test_coverage)
![GitHub Actions workflow](https://github.com/Pendalf2004/java-project-78/actions/workflows/myWorkflow.yml/badge.svg)
