name: Bug Report
description: File a bug report
title: "[SEM-E-Bug]: "
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
      multiple: false
      options:
        - Repository/SQL
        - Controller/API
        - Other (please specify)
  - type: textarea
    id: other_issue_specification
    attributes:
      label: Please specify the other issue
      description: If you selected "Other (please specify)" above, please provide more details about the issue here.
      placeholder: Describe the issue
    validations:
      required: false
    conditions:
      - field: repository_or_controller
        value: Other (please specify)
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
      description: By submitting this issue, you agree to follow our [Code of Conduct](https://example.com)
      options:
        - label: I agree to follow this project's Code of Conduct
    validations:
      required: true
