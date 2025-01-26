This is an example of a multi-file Java application that intentionally violates the 12-Factor App methodology. Each factor is neglected in some way to demonstrate bad practices. The purpose is to showcase antipatterns, so don't use this in production!

I'll organize the code into multiple files. The following violations will be introduced:

* Hard-coded configuration.
* Mixing of build and runtime environments.
* Dependency version mismatch.
* Stateful application.
* Logs written to files.
* Application tied to a specific environment.
* Poor scaling strategy (no concurrency).
* Single point of failure (monolith).
* Secrets committed in the codebase.
