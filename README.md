#MVC Calculator

This is the [MVC calculator from Derek Banas' tutorial on MVC in Java](http://www.newthinktank.com/2013/02/mvc-java-tutorial/) with modifications made.

Modifications include:

*implement unit tests for the model
*decoupling the view and controller by removing swing dependencies from the controller
*use a functional interface to perform the calculations rather than if/then or case statement control. This allows for much more flexibility in adding new features.
*introduce a new engine to evaluate mathematical functions represented as Strings
*added a second View to see how one can run the same model from two different views