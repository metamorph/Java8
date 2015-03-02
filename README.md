# Workshop project

This project aims to startup the use of concepts introduced in Java 7 and 8, main focus will be on the lambda expressions and streams that came with Java 8.

## What's new in Java 7/8

### Java 7

Main hightlights taken from:
> http://www.oracle.com/technetwork/java/javase/jdk7-relnotes-418459.html

* IO / NIO.2
    - File system API enhancements. Path och Files!
    
        >http://docs.oracle.com/javase/tutorial/essential/io/pathClass.html

    - WatchService API
    
        Construction in order for easier monitoring of changes in a file system.
        > http://docs.oracle.com/javase/tutorial/displayCode.html?code=http://docs.oracle.com/javase/tutorial/essential/io/examples/WatchDir.java

* Concurrency
    - Fork/Join support:
    
        Framework for breaking tasks into subtasks and execute them in parallell.

        >http://docs.oracle.com/javase/tutorial/essential/concurrency/forkjoin.html

* Language
    - Strings in Switch statements
    - try-with-resource
        - AutoClosable / Closable (IO, SQL)
    - catching multiple exceptions:
        
        catch (IOException|SQLException e) {
            // ...
        }

    - Type inference for generics

        Map<String, Integer> map = new HashMap<>();

### Java 8

> http://www.oracle.com/technetwork/java/javase/8-whats-new-2157071.html

* Many many many improvements to JVM, language and libraries.
* Scripting (Nashorn - Javascript)
    >http://www.oracle.com/technetwork/articles/java/jf14-nashorn-2126515.html

* New Date/Time libraries (About time!)
    - thread-safe
    - immutable
    - modelled after Joda Time.

    >http://www.oracle.com/technetwork/articles/java/jf14-date-time-2125367.html
    
* Language
    - Lambda expressions!!! (Also about time!)
        >http://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#syntax
        - Treat functionality as parameters. 
        - Less code increase the readability. 
        - Extremely powerful with streams.
        - Some Examples....
        
    - Method references as lambda expressions
    - Stream API
    - Higher order functions. filter, map, reduce. 
        
        We have some examples for that, Stream1 in the language-examples. 

    - Default methods in interfaces (easier to be backward comp. in libraries)
        - allows streams and lambas to be used by "old" interfaces.

TODO: ADD EXAMPLE FOR THIS. 

# Resources

>http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/

>http://www.smashingmagazine.com/2014/07/02/dont-be-scared-of-functional-programming/

>https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

>https://twitter.com/mariofusco/status/571999216039542784/photo/1
