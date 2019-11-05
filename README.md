# GamesInfo
## Description:
* Sample app made with the intention to show Clean Architecture and good practices.
* The app has 3 modules (Presentation/App, Domain, Data) trying to follow Clean Architecture

## Libraries
* Koin for dependencies injection
* RxJava2 for communicate modules and do the request in background
* AndroidX was comlete used

## Notes:
* I used buildSrc strategy to manage dependencies between modules
* I didn't implement DataSources due to I have just a source of data which is an API.
* I didn't put the sizes in resources, but all we know that the sizes must be in the resources.
* Because of time, I could make mistakes in some good practices but in general, I think the Clean Architecture is well implemented, for the presentation module (App module) I used MVP architecture.
