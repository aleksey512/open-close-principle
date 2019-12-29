# Open-close principle
## Introduction

### Open close principle intention
A good software design should take care of frequent changes in functionality during developing new features. It happens 
often that a new feature that is added in existing code affects many parts of the already tested code. That means adding 
a new feature will affect many unit tests for modification according to the new feature. The open close principle states 
that the written code should be open for extension, adding new features, but simultaneously closed for modifications. 


### Example of bad design

Real-life example. It happens quite often when a developer decides how to save a file base on a numeric type and inside 
some class implements logic how to save. One class aggregates diverse logic for saving an object.

The issue usually happens when a developer tries to implement different behavior in a method based on some type 
and usually with the help of “if-else”. The problem which happens here is that the code is very difficult to extend 
and especially test. To add a new type for handling an object you have to create one more “if-else” constraint here. 
To test such method with many "if" is quite difficult and messy task. The open close principle states that adding a new type 
should be done with no modification of method `save()`, that means open for extension and closed for modifications. 
In the example below it is open for extension, but also open for modification. Also, aggregating in a one class different methods 
that saves an object in a different way will cause having in the class contradicting fields, part of them are associated with DB, 
some with REST, some with a file system. It's gonna be a mess.

Problems here:
 - it's difficult to extend;
 - it's difficult to test, you have to be sure, that an appropriate method will be called based on a numeric type;
 - the class has mixed logic, that actually breaks the Single responsibility principle.

```java
public class ObjectHandler {

    public void save(int type, Object o) {
        if(type == 1) {
            saveInFile(o);
        } else if(type == 2) {
            saveInDatabase(o);
        } else if(type == 3) {
            saveInElasticSearch(o);
        } else {
            throw new RuntimeException();
        }
    }

    void saveInFile(Object o) {
        //  logic here
    }

    void saveInDatabase(Object o) {
        //  logic here
    }

    void saveInElasticSearch(Object o) {
        //  logic here
    }

}
```

### Better implementation
The issue could be solved if an appropriate handler is picked by a type automatically. There are many approaches how 
to organize the source code, but in this particular case it could be done by introducing a general interface and each 
type implements the interface in a way the object is handled accordingly to the type. Then instances of handler 
are associated with a certain type.

That implementation is much better. The class doesn't mixe a logic for different types of saving information. 
Finally, we have an interface Handler and each class that provides any way of storing a result has his own class 
and separated implementation.

It's quite easy to test savers separately, but still there are issues here:
- you have to pass all available types and be sure that an appropriate instance of Handler is returned by numeric type;
- you store the handlers in a map and it's quite easy to add new types here, but still you have to change code.

##### Particular handler is extracted by type from a register
```java
public class ObjectHandler {

    ObjectHandlers savers = new ObjectHandlers();

    public void save(int type, Object o) {
        savers.getByType(type).save(o);
    }

}
```

##### Basic interface for a handler
```java
public interface Handler {

    void save(Object o);

}
```

##### Register of handlers
```java
public class ObjectHandlers {

    Map<Integer, Handler> savers = new HashMap<>();

    public ObjectHandlers() {
        savers.put(1, new FileHandler());
        savers.put(2, new DatabaseHandler());
        savers.put(3, new ElasticSearchHandler());
    }

    public Handler getByType(int type) {
        return savers.get(type);
    }

}
```

### Good implementation
In my opinion, it's one of the best ways how to implement saving of an object. A handler cares how the data is saved 
in a storage and the handler is assigned from outside. We don't have access to internal logic about serialization of data 
and how the data are actually saved. A developer can implement custom logic for serialization and assign a handler 
that saves data. Actually, a subject how to serialize deserves another discussion here, but let it be that any handler 
knows how to serialize a certain instance of `AbstractHolder` properly.

The `ObjectHandler` now doesn't extract any of handlers, it just calls `save()` method to save the data. The handler is 
associated before or during constructing an instance of a holder.

##### New ObjectHandler
```java
public class ObjectHandler {

    public void save(AbstractHolder o) {
        o.save();
    }

}
```

##### Abstract type
```java
abstract public class AbstractHolder {

    abstract protected Handler getHandler();

    public void save() {
        getHandler().save(this);
    }

}
```

##### Particular type where a handler is assigned
```java
public class TextHolder extends AbstractHolder {

    Handler handler;

    public TextHolder(Handler handler) {
        this.handler = handler;
    }

    protected Handler getHandler() {
        return handler;
    }

}
```