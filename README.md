
[Command](/src/main/kotlin/taesu/Command.kt)
-----
![Command](/screen/Command.png)

```kotlin

Command 객체는 캡슐화 된 트랜잭션

활용 방안 : 스케쥴링, 로그 기록 시스템, undo / redo

Pros : 
 * "Invoker"는 Command 의 세부적인 구현체를 알지 못해도 상관없다.
// * Client는 Command 의 세부적인 구현체를 알지 못해도 상관없다.
 * 기존 코드를 변경하지 않고 새로운 명령을 추가 할 수 있기 때문에 확장성 측면에서 도움이 됩니다
 * undo / redo 기능으로 재사용이 가능합니다
Cons : 
 * 각 개별 명령에 대한 클래스 수가 증가한다.

```


[State](/src/main/kotlin/taesu/State.kt)
-----
![State](/screen/State.png)
````
내부 상태에 따라 객체의 동작을 변경할 수 있습니다.

활용 방안 : 
 * BlueBirdService 가 실행 중 / 실행 중이지 않음 상태를 관리하여 Action을 취할 수 있음.

Pros : 
 * 상태 관리가 "Context" 라는 한 곳에서 관리 되기 때문에 유지하기가 쉽다.
 * Client State 관리하는 Point 를 신경쓰지 않아도 된다.
Cons : 
 * Runtime 시에 상태가 변경되므로 Debug 가 힘들다. 
 ````
 [Visitor](/src/main/kotlin/taesu/Visitor.kt)
 -----
 ![Visitor](/screen/Visitor.png)
 
```` 
보통 한 클래스 내에 존재해야 할 데이터와 메소드를 다른 클래스로 분리하여 서로 간에 호출하도록 함으로써 향후 메소드 추가를 자유롭게 하려는 패턴입니다.

활용 방안 : 랜더링, 이벤트처리, 탐색 등 다양한 객체에 새로운 기능을 추가해야 하는데 캡슐화가 별로 중요하지 않은 경우에는 비지터 패턴을 사용한다.

Pros : 
 * Visitor를 통해 관련된 오퍼레이션을 하나로 모아 관련되지 않은 오퍼레이션과 분리할 수 있다
Cons : 
 * 대상 객체가 추가 될때마다 비지터에도 추가를 해줘야 한다.
 * 캡슐화가 약해진다. 요소의 내부 상태에 접근하는 데 필요한 오퍼레이션들을 모두 공개 인터페이스로 만들것을 강요하게 됨. 
````


 [FactoryMethod](/src/main/kotlin/FactoryMethod.kt)
 -----
 ![FactoryMethod](/screen/FactoryMethod.png)
 
 
 [AbstractFactory](/src/main/kotlin/AbstractFactory.kt)
 -----
 ![AbstractFactory](/screen/AbstractFactory.png)
 
```` 
사용 사례 : 
	Iterator i = c.iterator();


	 URL home = new URL("http:llwww.holub.com"); 
	 URLConnection c = home.getConnection();  
	 InputStream in = c.getinput();

````

Kotlin 문법 : [reified](/src/main/kotlin/reified.kt)
  
  inline fun `<reified T : Plant>`

  reified는 inline fun 에서만 사용하는 것을 제한하고 있습니다.
  
  뜻 풀이로 "구체화된" 이란 의미로 때때로 매개 변수로 전달 된 유형에 액세스해야합니다.