1. First JVM gets loaded.  
1. Main method gets executed.
1. ApplicationContext is loaded.
1. Applicationcontext reads xml configration file.
1. ApplicationContext pre loads one object for each bean in the config file 
 	if bean is not marked as lazy init ="true".
1. lazy-init="true" This informs springContainer not to pre-load object for this bean.
1. By default spring early loads object in memory.
1. For lazy-init beans object is created only when the getBean method is called.
1. For PreInit beans getBean() returns the references of the preLoaded object.
1. By default only one object for every bean is created (SingleTon)
1. SingleTon: At lease one object for every class but not more than one object.
1. Spring for lazy-init beans creates single-ton object the first call of getBeans() method and then
 		uses that object for futures getBean() method calls.
 		
---
## Prototype
Prototype beans are by default lazy-init
Prototypes are not singleton
A new object is created for Prototype when getBean() method is called every time

```java
	<bean id="emp1" class="com.chainsys.projectA.beans.Actor" scope="prototype"></bean>
```
---
## Bean with parameterize constructor




