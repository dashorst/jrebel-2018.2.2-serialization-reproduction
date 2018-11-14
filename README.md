# JRebel 2018.2.2 Serialization invocation reproduction

Provides a reproduction case for a bug in JRebel 2018.2.2 where a method reference is invoked during serialzation after a code modification. 
This is solved in the nightly of 20181114 and beyond.

## Scenario

1. Have a [page][page] with a [Lambda][lambdalink] method [reference][lambdause] you don't want to be called without explicit consent of your user (e.g. _Start global thermonuclear war_, or _Delete_)
2. Start the application with the JRebel agent 2018.2.2 enabled
3. Open that page instance (this serializes the page instance)
4. Modify some code (e.g. [change `System.err` to `System.out` or vice versa][modify])
5. JRebel updates the running code (YAY!)
6. Refresh the page in your browser causing it to be deserialized and then serialized
7. Observe the log output to show *"This shouldn't happen"*

You can also set a break point in the debugger on the [delete method]()

## Running

* Have JRebel 2018.2.2 installed and enabled.
* Run the class `Start` in `src/test/java/com/mycompany`
* Open http://localhost:8080
* Follow the instructions in the page

[page]: https://github.com/dashorst/jrebel-2018.2.2-serialization-reproduction/blob/master/src/main/java/com/mycompany/HomePage.java
[lambdalink]: https://github.com/dashorst/jrebel-2018.2.2-serialization-reproduction/blob/master/src/main/java/com/mycompany/LambdaLink.java
[lambdause]: https://github.com/dashorst/jrebel-2018.2.2-serialization-reproduction/blob/master/src/main/java/com/mycompany/HomePage.java#L12
[modify]: https://github.com/dashorst/jrebel-2018.2.2-serialization-reproduction/blob/master/src/main/java/com/mycompany/HomePage.java#L16
