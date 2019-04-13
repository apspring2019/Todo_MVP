# Todo_MVP
A simple todo app with console ui using MVP as architectural pattern

## Packages details
* `models`: Contains our entities, in this example the Task
* `contracts`: The contracts defined for MVP
* `presenters`: Implementations of presenters defined in `contracts`
* `views`: Implementation of views defined in `contracts` for console based UI

### Why do we use interfaces and define contracts in MVP?
Interfaces make presenters and views completely independent of the implementation of each other so they can be developed simultaenously or have different implementations.
