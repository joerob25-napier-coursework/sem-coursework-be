name: Bug Report
description: File a bug report
title: "[Bug]: "
labels:
  - bug
  - triage
assignees:
  - octocat
body:
  - type: markdown
    attributes:
      value: |
        Thank you for filling out this bug report
  - type: input
    id: contact
    attributes:
      label: Contact Details
      description: Please provide an email address so we can contact you for further info
      placeholder: ex. email@example.com
    validations:
      required: false
  - type: textarea
    id: what-happened
    attributes:
      label: What happened?
      description: Also tell us, what did you expect to happen?
      placeholder: Tell us what you see!
    validations:
      required: true
  - type: dropdown
    id: repository_or_controller
    attributes:
      label: Is this SQL or an API issue?
      multiple: true
      options:
        - Repository/SQL
        - Controller/API
  - type: textarea
    id: which_endpoint
    attributes:
      label: Which endpoint are you experiencing the issue on?
      description: Please can you copy and paste the JSON error that you are seeing?
    render: shell
  - type: textarea
    id: logs
    attributes:
      label: Relevant log output
      description: Please copy and paste any relevant log output. This will be automatically formatted into code, so no need for backticks.
    render: shell
  - type: checkboxes
    id: terms
    attributes:
      label: Code of Conduct
      description: By submitting this bug, you agree to adhere to our [Code of Conduct](https://github.com/joerob25/sem-coursework-be/blob/f15fab73ff709fa51f543000a749aadc22b3d5a7/docs/CODE_OF_CONDUCT)
      options:
        - label: I agree to adhere to this project's Code of Conduct even if 1980s Bruce Willis told me not to
    validations:
      required: true
